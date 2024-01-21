<template>
  <div>
    <div>
      <el-button  type="success" @click="exportData" icon="el-icon-upload2">
        导出实训表
      </el-button>

      <el-upload
          :show-file-list="false"
          :before-upload="beforeUpload"
          :on-success="onSuccess"
          :on-error="onError"
          :disabled="importDataDisabled"
          style="display: inline-flex;margin-right: 8px;margin-left: 8px"
          :action="uploadAction">
        <el-button :disabled="importDataDisabled" type="success" :icon="importDataBtnIcon">
          {{importDataBtnText}}
        </el-button>
      </el-upload>
      <el-button type="primary" icon="el-icon-check" @click="saveAllEditedRows">
        保存实训表
      </el-button>
      <el-button type="danger" icon="el-icon-delete" @click="deleteHomeWorks">
        删除实训表
      </el-button>
    </div>
    <!--横向滚动条 -->
    <div class="scrollable-tabs">
      <el-button
          v-for="buttonId in buttonIds"
          :key="buttonId"
          :id="buttonId"
          type="primary"
          style="margin: 5px;width: 120px"
          @click="handleButtonClick(buttonId);updateLastPeriod(buttonId)">
        第{{ buttonId }}期实训成绩表
      </el-button>
    </div>
    <!--表格-->
    <el-table
        class="scrollable-tabs"
        :data="tableData"
        size="mini"
        stripe
        border
        v-loading="loading"
        style="width: 956px"
        @cell-mouse-enter="handleCellEnter"
        @cell-mouse-leave="handleCellLeave"
        @cell-click="handleCellClick"
        @selection-change="handleSelectionChange"
    >
      <el-table-column
          type="selection"
          width="55">
      </el-table-column>
      <el-table-column label="sid" prop="sid" width="110" v-if="false">
        <div class="item" slot-scope="scope">
          <el-input class="item__input" v-model="scope.row.sid" placeholder="请输入内容"></el-input>
          <div class="item__txt">{{scope.row.id}}</div>
        </div>
      </el-table-column>
      <el-table-column
          fixed
          prop="name"
          label="姓名"
          width="110">
        <div slot-scope="scope">
          <div>{{scope.row.name}}</div>
        </div>
      </el-table-column>
      <el-table-column
          v-for="(item,index) in lessonNames"
          :key="index"
          :label="item"
          :prop="item"
          width="110">
        <div class="item" slot-scope="scope">
          <el-input class="item__input" v-model="scope.row.scores[index].score" v-if="scope.row.scores && scope.row.scores[index]" placeholder="请输入内容"></el-input>
          <div class="item__txt" v-if="scope.row.scores && scope.row.scores[index]">
            {{ scope.row.scores[index].score }}
          </div>
        </div>
      </el-table-column>
      <el-table-column
          sortable
          fixed="right"
          prop="sum"
          label="总分"
          width="110">
        <div slot-scope="scope">
          <div v-if="scope.row.sumAndAvg.length > 0">
            {{ scope.row.sumAndAvg[0] }}
          </div>
        </div>
      </el-table-column>
      <el-table-column
          fixed="right"
          label="平均分"
          prop="avg"
          width="110">
        <div slot-scope="scope">
          <div v-if="scope.row.sumAndAvg.length > 0">
            {{ scope.row.sumAndAvg[1] }}
          </div>
        </div>
      </el-table-column>
    </el-table>
  </div>

</template>

<script>
import {getRequest, postRequest} from "@/utils/api";
import { Message } from "element-ui";

export default {
  name: "PraAss",
  data(){
    return {
      buttonIds: [],
      //表格数据
      tableData: [{
        name: '',
        period : 0,
        scores: [{
          id: 0,
          lessonName: '',
          lessonOrder: 0,
          score: 0,
          sid: 0
        }],
        sumAndAvg: [{
          sum: 0,
          avg: 0
        }],
      }],
      loading: false,
      // 需要编辑的属性
      editProp: ['score'],
      // 保存进入编辑的cell
      clickCellMap: {},
      // 存储课程名数据
      lessonNames: ['HTML笔试','HTML机试','SQL笔试','SQL机试','Java基础笔试','Java基础机试','js笔试','js机试','Java高级笔试','Java高级机试','Hibernate笔试','Hibernate机试','Struts笔试','Struts机试','Spring笔试','Spring机试','SSH整合笔试','SSH整合机试','Mybatis笔试','Mybatis机试','SpringMVC笔试','SpringMVC机试','SSM整合笔试','SSM整合机试','Bootstrap笔试','Bootstrap机试'],
      //期数按钮被点击最后一次的期数Period
      lastPeriod: 1,
      //被选中id集合
      selectedIds: [],
      importDataDisabled: false,
      //导入按钮文本
      importDataBtnText: '导入实训表',
      //导入按钮icon样式
      importDataBtnIcon: 'el-icon-download',
      // 保存row信息
      editedRows:[],

    }
  },
  mounted() {
    this.selectMinPeriod();
    this.selectAllPeriod();
    this.scoreByMinPeriod();
  },
  computed: {
    foodLabel () {
      return (val) => {
        return this.options.find(o => o.value === val).label
      }
    },
    uploadAction() {
      return `/score/import`;
    },
  },
  methods: {
    // getSumAndAvg(period) {
    //   let url = `/score/SumAndAvg/${period}`;
    //   this.getRequest(url).then(resp => {
    //     // 处理响应数据
    //     this.tableData.sumAndAvgData = resp;
    //     console.log('Sum and Avg data:', resp);
    //     console.log(this.tableData.sumAndAvgData);
    //   });
    // },
    handleStatusInput(row, event) {
      // 将用户输入映射为 0 或 1
      row.status = event.target.value.toUpperCase() === 'T' ? 1 : 0;
    },
    /**
     * 移入
     * @param row
     * @param column
     * @param cell
     * @param event
     */
    handleCellEnter(row, column, cell, event) {
      const itemTxt = cell.querySelector('.item__txt');
      if (itemTxt) {
        itemTxt.classList.add('item__txt--hover');
      }
    },
    /**
     * 移出
     * @param row
     * @param column
     * @param cell
     * @param event
     */
    handleCellLeave(row, column, cell, event) {
      const itemTxt = cell.querySelector('.item__txt');
      if (itemTxt) {
        itemTxt.classList.remove('item__txt--hover');
      }
    },
    /** 点击cell */
    handleCellClick (row, column, cell, event) {
        // 保存cell
        this.saveCellClick(row, cell)
        cell.querySelector('.item__txt').style.display = 'none'
        cell.querySelector('.item__input').style.display = 'block'
        cell.querySelector('input').focus()
    },
    /** 取消编辑状态 */
    cancelEditable (cell) {
      cell.querySelector('.item__txt').style.display = 'block'
      cell.querySelector('.item__input').style.display = 'none'
    },
    /** 保存进入编辑的cell */
    saveCellClick (row, cell) {
      this.editedRows.push(row)
    },
    /** 保存数据 */
    save (row) {
      const sid = row.sid
      // 取消本行所有cell的编辑状态
      this.clickCellMap[sid].forEach(cell => {
        this.cancelEditable(cell)
      })
      this.clickCellMap[sid] = []
    },
    /** 返回最小期数 */
    selectMinPeriod() {
      this.loading = true;
      let url = '/score/minPeriod';
      this.getRequest(url).then(resp => {
        this.loading = false;
        if (resp) {
          this.lastPeriod = resp; // 先设置 lastPeriod
        }
      });
    },
    /** 查询最小的期数，并返回该期数所有作业 */
    scoreByMinPeriod(){
      this.loading = true;
      let url = '/score/scoreByMinPeriod';
      this.getRequest(url).then(resp => {
        this.loading = false;
        if (resp) {
          this.tableData = resp;
          console.log(this.tableData);
        }
      });
    },
    /** 查询所有的期数 */
    selectAllPeriod(){
      let url = '/score/allPeriod';
      this.getRequest(url).then(resp => {
        if (resp) {
          this.buttonIds = resp;
        }
      });
    },
    /** 点击“第几期实训表”按钮，切换界面*/
    handleButtonClick(buttonId){
      console.log('按钮被点击:', buttonId);
      let url = '/score/'+buttonId;
      this.getRequest(url).then(resp => {
        if (resp) {
          console.log(resp);
          this.tableData = resp;
          //如果学生删除干净，刷新页面
          if(this.tableData.length === 0){
            window.location.reload();
          }
        }
      });
      // this.getSumAndAvg(buttonId);
    },
    /** 期数按钮被点击一次，改变期数*/
    updateLastPeriod(buttonId){
      this.lastPeriod = buttonId;
    },
    /** 保存所有被编辑行的数据 */
    saveAllEditedRows() {
      // 发送保存数据的请求
      this.saveDataToBackend(this.editedRows);
      console.log(this.editedRows);
    },
    /** 发送保存数据的请求到后端 */
    saveDataToBackend(editedRows) {
      const url = '/score/saveEditedRows';
      this.postRequest(url, editedRows)
          .then(response => {
            console.log('Data saved successfully:', response.data);
            // 刷新页面数据
            this.$alert('更新成功！', '', {
              confirmButtonText: '确定',
            });
            this.handleButtonClick(this.lastPeriod);
            //取消编辑框
            for (const sid of Object.keys(this.clickCellMap)) {
              const row = this.tableData.find(item => item.sid === Number(sid));
              if (row) {
                const editedCells = this.clickCellMap[sid];
                // 对每个编辑状态进行处理
                for (const cell of editedCells) {
                  // 处理每个编辑状态
                  this.cancelEditable(cell);
                }
              }
            }
          })
          .catch(error => {
            console.error('Error saving data:', error);
          });
    },
    /** 删除成功提示*/
    deleSuccess() {
      this.$alert('删除成功！', '', {
        confirmButtonText: '确定',
        callback: action => {
          this.$message({
            type: 'info',
            message: `删除成功`
          });
        }
      });
    },
    /** 处理选择变化事件 */
    handleSelectionChange(selection) {
      // 获取被选中行的id数组
      this.selectedIds = selection.map(item => item.sid);
    },
    /** 删除多个实训表 */
    deleteHomeWorks(){
      let url = '/score/deleteScore'
      this.postRequest(url, this.selectedIds)
          .then(response => {
            // 刷新页面数据
            this.handleButtonClick(this.lastPeriod);
            this.deleSuccess()
          })
          .catch(error => {
            console.error('Error deleting homework:', error);
          });
    },
    exportData() {
      window.open('/score/export/'+this.lastPeriod, '_parent');
    },
    beforeUpload() {
      this.importDataBtnText = '正在导入';
      this.importDataBtnIcon = 'el-icon-loading';
      this.importDataDisabled = true;
      this.$alert('更新成功！', '', {
        confirmButtonText: '确定',
      });
      this.handleButtonClick(this.lastPeriod);
    },
    onSuccess(response, file, fileList) {
      this.importDataBtnText = '导入实训表';
      this.importDataBtnIcon = 'el-icon-download';
      this.importDataDisabled = false;
      this.handleButtonClick(this.lastPeriod);
    },
    onError(err, file, fileList) {
      this.importDataBtnText = '导入实训表';
      this.importDataBtnIcon = 'el-icon-download';
      this.importDataDisabled = false;
    },
  }

}
</script>

<style scoped lang='scss'>
.item{
  .item__input {
    display: none;
    width: 100px;
    /* 调整elementUI中样式 */
    .el-input__inner{
      height: 24px!important;
    }
    /* 调整elementUI中样式 */
    .el-input__suffix{
      i{
        font-size: 12px !important;
        line-height: 26px !important;
      }
    }
  }
  .item__txt{
    box-sizing: border-box;
    border: 1px solid transparent;
    width: 100px;
    line-height: 24px;
    padding: 0 8px;
  }
  .item__txt--hover{
    border: 1px solid #dddddd;
    border-radius: 4px;
    cursor: text;
  }
}

.scrollable-tabs {
  width: 956px;
  overflow-x: auto;
  white-space: nowrap;
  margin-top: 10px;
  margin-bottom: 10px ;
  border: 1px solid #ccc;;
}


</style>