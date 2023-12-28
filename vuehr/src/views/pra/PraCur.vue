<template>
  <div>
    <div>
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
      <el-button type="success" @click="exportData" icon="el-icon-upload2">
        导出数据
      </el-button>
      <el-button type="primary" icon="el-icon-check" @click="saveAllEditedRows">
        保存当前修改
      </el-button>
      <el-button type="danger" icon="el-icon-check" @click="deleteCourseByWeekNum">
        删除课程表
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
          @click="handleButtonClick(buttonId);updatelastWeekNum(buttonId)">
        第{{ buttonId }}周课表
      </el-button>
    </div>

    <div style="margin-top: 10px" >
      <el-table :data="courseTable" size="mini"
                stripe
                border
                v-loading="loading"
                style="width: 956px"
                @cell-mouse-enter="handleCellEnter"
                @cell-mouse-leave="handleCellLeave"
                @cell-click="handleCellClick">
        <el-table-column label="时间/课程">
          <template v-slot="scope">
            <div v-if="scope.row.section">
              <div style="margin: 10px 0">{{scope.row.section.num}}</div>
              <div style="margin: 10px 0">{{scope.row.section.time}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周一" >
          <template slot-scope="scope">
            <div  class="item" v-if="scope.row.mon">
              <el-input  class="item__input" v-model="scope.row.mon.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.mon.courseName}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周二" >
          <template v-slot="scope" >
            <div class="item" v-if="scope.row.tue">
              <el-input  class="item__input" v-model="scope.row.tue.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.tue.courseName}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周三" >
          <template v-slot="scope">
            <div class="item" v-if="scope.row.wes">
              <el-input  class="item__input" v-model="scope.row.wes.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.wes.courseName}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周四" >
          <template v-slot="scope" >
            <div class="item" v-if="scope.row.thu">
              <el-input  class="item__input" v-model="scope.row.thu.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.thu.courseName}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周五" >
          <template v-slot="scope" >
            <div class="item" v-if="scope.row.fri">
              <el-input  class="item__input" v-model="scope.row.fri.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.fri.courseName}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周六" >
          <template v-slot="scope" >
            <div class="item" v-if="scope.row.sat">
              <el-input  class="item__input" v-model="scope.row.sat.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.sat.courseName}}</div>
            </div>
          </template>
        </el-table-column>
        <el-table-column label="周日" >
          <template v-slot="scope" >
            <div class="item" v-if="scope.row.sun">
              <el-input  class="item__input" v-model="scope.row.sun.courseName" placeholder="请输入内容"></el-input>
              <div class="item__txt">{{scope.row.sun.courseName}}</div>
            </div>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>

export default {
  name: "PraCur",
  data(){
    return{
      //区分第几周课程的按钮id集合
      buttonIds: [],
      title: '',
      importDataBtnText: '导入课程表',
      importDataBtnIcon: 'el-icon-download',
      importDataDisabled: false,
      //课程对象
      course:[
        {courseId:'',
          weekNum:'',
          courseName:'',
          courseDate:'',
          week:'',
          section:''
        }
      ],
      //课程表数据
      courseTable:[
        {section:{num:'',time:''},
          mon:{course: []},
          tue:{course: []},
          wes:{course: []},
          thu:{course: []},
          fri:{course: []},
          sat:{course: []},
          sun:{course: []}
        }
      ],
      loading: false,
      //期数按钮被点击最后一次的期数epNum
      lastWeekNum: 1,
      // 保存row信息
      clickCellMap: {},
      editedRows:[],
    }
  },
  mounted() {
    //查询所有周数存进集合，然后查询最小周数来查询课程信息
    this.courseByMinWeekNum();
    this.selectAllWeekNums();
    this.selectMinWeekNum();
  },
  computed: {
    /**导出数据 */
     uploadAction() {
       return `/course/import/${this.lastWeekNum}`;
     },
  },
  methods: {
    onError(err, file, fileList) {
      this.importDataBtnText = '导入数据';
      this.importDataBtnIcon = 'el-icon-upload2';
      this.importDataDisabled = false;
    },
    onSuccess(response, file, fileList) {
      this.importDataBtnText = '导入数据';
      this.importDataBtnIcon = 'el-icon-upload2';
      this.importDataDisabled = false;
      this.initEmps();
    },
    beforeUpload() {
      this.importDataBtnText = '正在导入';
      this.importDataBtnIcon = 'el-icon-loading';
      this.importDataDisabled = true;
    },
    /** 导出数据 */
    exportData() {
      window.open('/course/export/'+this.lastWeekNum, '_parent');
    },
    /**
     * 这一部分是编辑数据、保存数据
     */
    /** 鼠标移入cell */
    handleCellEnter(row, column, cell, event) {
      cell.querySelector('.item__txt').classList.add('item__txt--hover')
    },
    /** 鼠标移出cell */
    handleCellLeave(row, column, cell, event) {
      cell.querySelector('.item__txt').classList.remove('item__txt--hover')
    },
    /** 点击cell */
    handleCellClick(row, column, cell, event) {
        this.saveCellClick(row, cell)
        cell.querySelector('.item__txt').style.display = 'none'
        cell.querySelector('.item__input').style.display = 'block'
        cell.querySelector('input').focus()
    },
    /** 取消编辑状态 */
    cancelEditable(cell) {
      cell.querySelector('.item__txt').style.display = 'block'
      cell.querySelector('.item__input').style.display = 'none'
    },
    /** 保存进入编辑的cell */
    saveCellClick(row, cell) {
      this.editedRows.push(row)
    },
    /** 保存所有被编辑行的数据 */
     saveAllEditedRows() {
        this.saveDataToBackend(this.editedRows);
     },
    /** 发送保存数据的请求到后端 */
     saveDataToBackend(editedRows) {
       const url = '/course/saveEditedRows';
       this.postRequest(url, editedRows)
           .then(response => {
             // 刷新页面数据
             this.handleButtonClick(this.lastWeekNum);
             this.$alert('更新成功！', '', {
               confirmButtonText: '确定',
             });
           })
           .catch(error => {
             console.error('Error saving data:', error);
           });
     },
    /**
     * 这一部分是删除部分
     */
    /** 删除方法*/
    deleteCourseByWeekNum(){
      let url = '/course/deleteCourseByWeekNum/'+this.lastWeekNum;
      this.getRequest(url).then(resp =>{
        this.selectAllWeekNums();
        this.courseByMinWeekNum();
        this.deleSuccess()
      })
    },
    /** 删除成功提示*/
    deleSuccess() {
      this.$alert('删除成功！', '', {
        confirmButtonText: '确定',
      });
    },
    /**
     * 这一部分是遍历课表、切换课表
     */
    /** 点击“第几期作业表”按钮，切换界面*/
    handleButtonClick(buttonId) {
      let url = '/course/courseTable/' + buttonId;
      this.getRequest(url).then(resp => {
        if (resp) {
          this.courseTable = resp;
        }
      });
    },
    /** 期数按钮被点击一次，改变期数*/
    updatelastWeekNum(buttonId) {
      this.lastWeekNum = buttonId;
    },
    /** 返回最小期数 */
    selectMinWeekNum() {
      this.loading = true;
      let url = '/course/minWeekNum';
      this.getRequest(url).then(resp => {
        this.loading = false;
        if (resp) {
          //页面加载时lastEpNum默认是最小期数
          this.lastWeekNum = resp;
        }
      });
    },
    /** 查询最小的期数，并返回该期数所有作业 */
    courseByMinWeekNum() {
      this.loading = true;
      let url = '/course/courseByMinWeekNum';
      this.getRequest(url).then(resp => {
        this.loading = false;
        if (resp) {
          this.courseTable = resp;
        }
      });
    },
    /** 查询所有的期数 */
    selectAllWeekNums() {
      let url = '/course/allWeekNums';
      this.getRequest(url).then(resp => {
        if (resp) {
          this.buttonIds = resp;
        }
      });
    },
  }
}
</script>

<style scoped lang="scss">
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