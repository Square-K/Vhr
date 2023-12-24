<template>
    <div>
      <div>
        <el-button  type="success" @click="exportData" icon="el-icon-upload2">
          导出作业表
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
          保存作业表
        </el-button>
        <el-button type="danger" icon="el-icon-delete" @click="deleteHomeWorks">
          删除作业表
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
            @click="handleButtonClick(buttonId);updateLastEpNum(buttonId)">
          第{{ buttonId }}期作业表
        </el-button>
      </div>
<!--表格-->
      <el-table
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
        <el-table-column label="id" prop="id" width="180" v-if="false">
          <div class="item" slot-scope="scope">
            <el-input class="item__input" v-model="scope.row.id" placeholder="请输入内容"></el-input>
            <div class="item__txt">{{scope.row.id}}</div>
          </div>
        </el-table-column>
        <el-table-column
            prop="day"
            label="日期"
            width="180">
          <div class="item" slot-scope="scope">
            <el-input class="item__input" v-model="scope.row.day" placeholder="请输入内容"></el-input>
            <div class="item__txt">{{scope.row.day}}</div>
          </div>
        </el-table-column>
        <el-table-column
            prop="lessonName"
            label="课程名"
            width="180">
          <div class="item" slot-scope="scope">
            <el-input class="item__input" v-model="scope.row.lessonName" placeholder="请输入内容"></el-input>
            <div class="item__txt">{{scope.row.lessonName}}</div>
          </div>
        </el-table-column>
        <el-table-column
            prop="section"
            label="章节"
            width="180">
          <div class="item" slot-scope="scope">
            <el-input class="item__input" v-model="scope.row.section" placeholder="请输入内容"></el-input>
            <div class="item__txt">{{scope.row.section}}</div>
          </div>
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            width="180">
          <div class="item" slot-scope="scope">
            <el-input class="item__input" v-model="scope.row.name" placeholder="请输入内容"></el-input>
            <div class="item__txt">{{scope.row.name}}</div>
          </div>
        </el-table-column>
        <el-table-column
            prop="status"
            label="状态"
            width="180">
          <div class="item" slot-scope="scope">
            <el-input class="item__input" v-model="scope.row.status" placeholder="请输入内容"></el-input>
            <div class="item__txt">{{scope.row.status}}</div>
          </div>
        </el-table-column>
      </el-table>
    </div>

</template>

<script>
    import {postRequest} from "@/utils/api";
    import { Message } from "element-ui";

    export default {
        name: "PraAss",
        data(){
          return {
            buttonIds: [],
            //表格数据
            tableData: [{
              id: 1,
              epNum: 1,
              day: '2023-05-02',
              lessonName: 'html',
              section: 'L1',
              name: '张三',
              status: 1,
              leOrder: 1
            }],
            loading: false,
            // 需要编辑的属性
            editProp: ['day', 'lessonName','section','name','status'],
            // 保存进入编辑的cell
            clickCellMap: {},
            // 存储课程名数据
            //1.html 2.sql 3.java基础 4.js 5.java高级  6. hibernate7.struts 8.spring 9.ssh整合 10.mybatis  11.springmvc  12.ssm整合 13.bootstrap
            lessonNames: ['html','sql','java基础','js','java高级','hibernate','struts','spring','ssh整合','mybatis','springmvc','ssm整合','bootstrap'],
            //期数按钮被点击最后一次的期数epNum
            lastEpNum: 1,
            //被选中id集合
            selectedIds: [],
            importDataDisabled: false,
            //导入按钮文本
            importDataBtnText: '导入作业表',
            //导入按钮icon样式
            importDataBtnIcon: 'el-icon-download'

          }
        },
      mounted() {
        this.selectMinEpNum();
        this.selectAllEpNums();
        this.homeWorksByMinEpNum();
      },
      computed: {
        foodLabel () {
          return (val) => {
            return this.options.find(o => o.value === val).label
          }
        },
        uploadAction() {
          return `/homework/import/${this.lastEpNum}`;
        },
      },
      methods: {
        handleStatusInput(row, event) {
          // 将用户输入映射为 0 或 1
          row.status = event.target.value.toUpperCase() === 'T' ? 1 : 0;
        },
        /** 鼠标移入cell */
        handleCellEnter (row, column, cell, event) {
          const property = column.property
          if (property === 'day' || property === 'lessonName' || property === 'section' || property === 'name' || property === 'status') {
            cell.querySelector('.item__txt').classList.add('item__txt--hover')
          }
        },
        /** 鼠标移出cell */
        handleCellLeave (row, column, cell, event) {
          const property = column.property
          if (this.editProp.includes(property)) {
            cell.querySelector('.item__txt').classList.remove('item__txt--hover')
          }
        },
        /** 点击cell */
        handleCellClick (row, column, cell, event) {
          const property = column.property

          if (this.editProp.includes(property)) {

            // 保存cell
            this.saveCellClick(row, cell)
            cell.querySelector('.item__txt').style.display = 'none'
            cell.querySelector('.item__input').style.display = 'block'
            cell.querySelector('input').focus()

          }
        },
        /** 取消编辑状态 */
        cancelEditable (cell) {
          cell.querySelector('.item__txt').style.display = 'block'
          cell.querySelector('.item__input').style.display = 'none'
        },
        /** 保存进入编辑的cell */
        saveCellClick (row, cell) {
          const id = row.id
          if (this.clickCellMap[id] !== undefined) {
            if (!this.clickCellMap[id].includes(cell)) {
              this.clickCellMap[id].push(cell)
            }
          } else {
            this.clickCellMap[id] = [cell]
          }
        },
        /** 保存数据 */
        save (row) {
          const id = row.id
          // 取消本行所有cell的编辑状态
          this.clickCellMap[id].forEach(cell => {
            this.cancelEditable(cell)
          })
          this.clickCellMap[id] = []
        },
        /** 返回最小期数 */
        selectMinEpNum(){
          this.loading = true;
          let url = '/homework/minEpNum';
          this.getRequest(url).then(resp => {
            this.loading = false;
            if (resp) {
              //页面加载时lastEpNum默认是最小期数
              this.lastEpNum = resp;
            }
          });
        },
        /** 查询最小的期数，并返回该期数所有作业 */
        homeWorksByMinEpNum(){
          this.loading = true;
          let url = '/homework/homeWorksByMinEpNum';
          this.getRequest(url).then(resp => {
            this.loading = false;
            if (resp) {
              this.tableData = resp;
            }
          });
        },
        /** 查询所有的期数 */
        selectAllEpNums(){
          let url = '/homework/allEpNums';
          this.getRequest(url).then(resp => {
            if (resp) {
              this.buttonIds = resp;
            }
          });
        },
        /** 获取lessonNames数据 */
        // fetchLessonNames() {
        //   let url = '/homework/getLessonNames';
        //   this.getRequest(url).then(resp => {
        //     if (resp) {
        //       this.lessonNames = resp;
        //     }
        //   });
        // },
        /** 点击“第几期作业表”按钮，切换界面*/
        handleButtonClick(buttonId){
          let url = '/homework/'+buttonId;
          this.getRequest(url).then(resp => {
            if (resp) {
              this.tableData = resp;
            }
          });
        },
        /** 期数按钮被点击一次，改变期数*/
        updateLastEpNum(buttonId){
            this.lastEpNum=buttonId;
        },
        /** 验证日期格式是否符合yyyy-MM-dd */
        isValidDateFormat(dateString) {
          // 使用正则表达式检查日期格式
          const dateFormatRegex = /^\d{4}-\d{2}-\d{2}$/;
          return dateFormatRegex.test(dateString);
        },
        /** 保存所有被编辑行的数据 */
        saveAllEditedRows() {
          const editedRows = [];

          // 遍历clickCellMap中保存的编辑过的行的cell
          for (const id in this.clickCellMap) {
            if (this.clickCellMap.hasOwnProperty(id)) {
              const row = this.tableData.find(item => item.id === Number(id));

              if (row) {
                // 日期格式验证
                if (this.isValidDateFormat(row.day)) {
                  //进行lessonName验证
                  if (this.lessonNames.includes(row.lessonName)) {
                    if('T' === row.status || 'F' === row.status){
                      editedRows.push(row);
                    }else {
                      //状态不符合T或F情况
                      this.tOrF()
                    }
                  } else {
                    // 处理lessonName不在lessonNames数组中的情况
                    this.leNameAlert()
                  }
                } else {
                  // 处理日期格式不符合要求的情况
                  this.dateAlert()
                }
              }
            }
          }

          // 发送保存数据的请求
          this.saveDataToBackend(editedRows);
        },
        /** 发送保存数据的请求到后端 */
        saveDataToBackend(editedRows) {
          const url = '/homework/saveEditedRows';
          this.postRequest(url, editedRows)
              .then(response => {
                console.log('Data saved successfully:', response.data);
                // 刷新页面数据
                this.handleButtonClick(this.lastEpNum);
                //取消编辑框
                for (const id of Object.keys(this.clickCellMap)) {
                  const row = this.tableData.find(item => item.id === Number(id));

                  if (row) {
                    const editedCells = this.clickCellMap[id];

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
        /** 状态内容错误提示*/
        tOrF() {
          this.$alert('状态内容必须输入T或者F！', '状态', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: `action: ${ action }`
              });
            }
          });
        },
        /** 课程名错误提示*/
        leNameAlert() {
          this.$alert('课程名不符合要求，请重新编写！', '课程名', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: `action: ${ action }`
              });
            }
          });
        },
        /** 日期格式错误提示*/
        dateAlert() {
          this.$alert('日期格式不符合要求，请重新编写！格式例：2023-12-23', '日期', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: `action: ${ action }`
              });
            }
          });
        },
        /** 删除成功提示*/
        deleSuccess() {
          this.$alert('删除成功！', '', {
            confirmButtonText: '确定',
            callback: action => {
              this.$message({
                type: 'info',
                message: `action: ${ action }`
              });
            }
          });
        },
        /** 处理选择变化事件 */
        handleSelectionChange(selection) {
          // 获取被选中行的id数组
          this.selectedIds = selection.map(item => item.id);
        },
        /** 删除多个作业表 */
        deleteHomeWorks(){
          let url = '/homework/deleteHomeWorks'
          this.postRequest(url, this.selectedIds)
              .then(response => {
                // 刷新页面数据
                this.handleButtonClick(this.lastEpNum);
                this.deleSuccess()
              })
              .catch(error => {
                console.error('Error deleting homework:', error);
              });
        },
        exportData() {
          window.open('/homework/export/'+this.lastEpNum, '_parent');
        },
        beforeUpload() {
          this.importDataBtnText = '正在导入';
          this.importDataBtnIcon = 'el-icon-loading';
          this.importDataDisabled = true;
        },
        onSuccess(response, file, fileList) {
          this.importDataBtnText = '导入作业表';
          this.importDataBtnIcon = 'el-icon-download';
          this.importDataDisabled = false;
          this.handleButtonClick(this.lastEpNum);
        },
        onError(err, file, fileList) {
          this.importDataBtnText = '导入作业表';
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