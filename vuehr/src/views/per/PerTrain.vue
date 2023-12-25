<template>
  <div>
    <div>
      <div style="display: flex;justify-content: space-between">
        <div>
          <el-input placeholder="请输入员工名进行搜索，可以直接回车搜索..." prefix-icon="el-icon-search"
                    clearable
                    @clear="initEmps"
                    style="width: 350px;margin-right: 10px" v-model="keyword"
                    @keydown.enter.native="initEmps" :disabled="showAdvanceSearchView"></el-input>
          <el-button icon="el-icon-search" type="primary" @click="initEmps" :disabled="showAdvanceSearchView">
            搜索
          </el-button>
          <el-button type="primary" @click="showAdvanceSearchView = !showAdvanceSearchView">
            <i :class="showAdvanceSearchView?'fa fa-angle-double-up':'fa fa-angle-double-down'"
               aria-hidden="true"></i>
            高级搜索
          </el-button>
        </div>
        <div>
          <el-upload
              :show-file-list="false"
              :before-upload="beforeUpload"
              :on-success="onSuccess"
              :on-error="onError"
              :disabled="importDataDisabled"
              style="display: inline-flex;margin-right: 8px"
              action="/employee/basic/import">
            <el-button :disabled="importDataDisabled" type="success" :icon="importDataBtnIcon">
              {{importDataBtnText}}
            </el-button>
          </el-upload>
          <el-button type="success" @click="exportData" icon="el-icon-download">
            导出数据
          </el-button>
          <el-button type="primary" icon="el-icon-plus" @click="showAddEmpView">
            添加用户
          </el-button>
        </div>
      </div>
      <transition name="slide-fade">
        <div v-show="showAdvanceSearchView"
             style="border: 1px solid #409eff;border-radius: 5px;box-sizing: border-box;padding: 5px;margin: 10px 0px;">
          <!--                    <el-row>-->
          <!--                        <el-col :span="5">-->
          <!--                            政治面貌:-->
          <!--                            <el-select v-model="searchValue.politicId" placeholder="政治面貌" size="mini"-->
          <!--                                       style="width: 130px;">-->
          <!--                                <el-option-->
          <!--                                        v-for="item in politicsstatus"-->
          <!--                                        :key="item.id"-->
          <!--                                        :label="item.name"-->
          <!--                                        :value="item.id">-->
          <!--                                </el-option>-->
          <!--                            </el-select>-->
          <!--                        </el-col>-->
          <!--                        <el-col :span="4">-->
          <!--                            民族:-->
          <!--                            <el-select v-model="searchValue.nationId" placeholder="民族" size="mini"-->
          <!--                                       style="width: 130px;">-->
          <!--                                <el-option-->
          <!--                                        v-for="item in nations"-->
          <!--                                        :key="item.id"-->
          <!--                                        :label="item.name"-->
          <!--                                        :value="item.id">-->
          <!--                                </el-option>-->
          <!--                            </el-select>-->
          <!--                        </el-col>-->
          <!--                        <el-col :span="4">-->
          <!--                            职位:-->
          <!--                            <el-select v-model="searchValue.posId" placeholder="职位" size="mini" style="width: 130px;">-->
          <!--                                <el-option-->
          <!--                                        v-for="item in positions"-->
          <!--                                        :key="item.id"-->
          <!--                                        :label="item.name"-->
          <!--                                        :value="item.id">-->
          <!--                                </el-option>-->
          <!--                            </el-select>-->
          <!--                        </el-col>-->
          <!--                        <el-col :span="4">-->
          <!--                            职称:-->
          <!--                            <el-select v-model="searchValue.jobLevelId" placeholder="职称" size="mini"-->
          <!--                                       style="width: 130px;">-->
          <!--                                <el-option-->
          <!--                                        v-for="item in joblevels"-->
          <!--                                        :key="item.id"-->
          <!--                                        :label="item.name"-->
          <!--                                        :value="item.id">-->
          <!--                                </el-option>-->
          <!--                            </el-select>-->
          <!--                        </el-col>-->
          <!--                        <el-col :span="7">-->
          <!--                            聘用形式:-->
          <!--                            <el-radio-group v-model="searchValue.engageForm">-->
          <!--                                <el-radio label="劳动合同">劳动合同</el-radio>-->
          <!--                                <el-radio label="劳务合同">劳务合同</el-radio>-->
          <!--                            </el-radio-group>-->
          <!--                        </el-col>-->
          <!--                    </el-row>-->
          <!--                    <el-row style="margin-top: 10px">-->
          <!--                        <el-col :span="5">-->
          <!--                            所属部门:-->
          <!--                            <el-popover-->
          <!--                                    placement="right"-->
          <!--                                    title="请选择部门"-->
          <!--                                    width="200"-->
          <!--                                    trigger="manual"-->
          <!--                                    v-model="popVisible2">-->
          <!--                                <el-tree default-expand-all :data="allDeps" :props="defaultProps"-->
          <!--                                         @node-click="searvhViewHandleNodeClick"></el-tree>-->
          <!--                                <div slot="reference"-->
          <!--                                     style="width: 130px;display: inline-flex;font-size: 13px;border: 1px solid #dedede;height: 26px;border-radius: 5px;cursor: pointer;align-items: center;padding-left: 8px;box-sizing: border-box;margin-left: 3px"-->
          <!--                                     @click="showDepView2">{{inputDepName}}-->
          <!--                                </div>-->
          <!--                            </el-popover>-->
          <!--                        </el-col>-->
          <!--                        <el-col :span="10">-->
          <!--                            入职日期:-->
          <!--                            <el-date-picker-->
          <!--                                    v-model="searchValue.beginDateScope"-->
          <!--                                    type="daterange"-->
          <!--                                    size="mini"-->
          <!--                                    unlink-panels-->
          <!--                                    value-format="yyyy-MM-dd"-->
          <!--                                    range-separator="至"-->
          <!--                                    start-placeholder="开始日期"-->
          <!--                                    end-placeholder="结束日期">-->
          <!--                            </el-date-picker>-->
          <!--                        </el-col>-->
          <!--                        <el-col :span="5" :offset="4">-->
          <!--                            <el-button size="mini">取消</el-button>-->
          <!--                            <el-button size="mini" icon="el-icon-search" type="primary" @click="initEmps('advanced')">搜索</el-button>-->
          <!--                        </el-col>-->
          <!--                    </el-row>-->
        </div>
      </transition>
    </div>
    <div style="margin-top: 10px">
      <el-table
          :data="emps"
          stripe
          border
          v-loading="loading"
          element-loading-text="正在加载..."
          element-loading-spinner="el-icon-loading"
          element-loading-background="rgba(0, 0, 0, 0.8)"
          style="width: 100%">
        <el-table-column
            type="selection"
            width="55">
        </el-table-column>
        <el-table-column
            prop="name"
            fixed
            align="left"
            label="姓名"
            width="90">
        </el-table-column>
        <el-table-column
            prop="gender"
            label="性别"
            align="left"
            width="85">
        </el-table-column>
        <el-table-column
            prop="school"
            label="学校"
            align="left"
            width="85">
        </el-table-column>
        <el-table-column
            prop="speciality"
            width="85"
            align="left"
            label="专业">
        </el-table-column>
        <el-table-column
            prop="education"
            width="85"
            align="left"
            label="学历">
        </el-table-column>
        <el-table-column
            prop="graduateDate"
            width="120"
            align="left"
            label="手机号">
        </el-table-column>
        <el-table-column
            prop="idCard"
            width="120"
            align="left"
            label="微信号">
        </el-table-column>
        <el-table-column
            prop="phone"
            width="120"
            align="left"
            label="日语情况">
        </el-table-column>
        <el-table-column
            prop="weChat"
            width="120"
            align="left"
            label="学习能力">
        </el-table-column>
        <el-table-column
            prop="notes"
            width="120"
            align="left"
            label="学习进度">
        </el-table-column>
        <el-table-column
            prop="test_time1"
            width="120"
            align="left"
            label="是否入场">
        </el-table-column>
      </el-table>
      <div style="display: flex;justify-content: flex-end">
        <el-pagination
            background
            @current-change="currentChange"
            @size-change="sizeChange"
            layout="sizes, prev, pager, next, jumper, ->, total, slot"
            :total="total">
        </el-pagination>
      </div>
    </div>
    <el-dialog
        :title="title"
        :visible.sync="dialogVisible"
        width="80%">
      <div>
        <el-form :model="emp" :rules="rules" ref="empForm">
          <el-row>
            <el-col :span="6">
              <el-form-item label="姓名:" prop="name">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit" v-model="emp.name"
                          placeholder="请输入姓名"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="性别:" prop="gender">
                <el-radio-group v-model="emp.gender">
                  <el-radio label="男">男</el-radio>
                  <el-radio label="女">女</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="学校:" prop="school">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit" v-model="emp.school"
                          placeholder="请输入学校"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="专业:" prop="speciality">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit" v-model="emp.speciality"
                          placeholder="请输入专业"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="学历:" prop="education">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit" v-model="emp.education"
                          placeholder="请输入专业"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="5">
              <el-form-item label="手机号:" prop="graduateDate">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit" v-model="emp.graduateDate"
                          placeholder="请输入手机号"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="微信号:" prop="idCard">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.idCard" placeholder="请输入微信号"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="日语情况:" prop="phone">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.phone" placeholder="请输入日语情况"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="6">
              <el-form-item label="学习能力:" prop="weChat">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.weChat" placeholder="请输入学习能力"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="6">
              <el-form-item label="学习进度:" prop="notes">
                <el-input size="mini" style="width: 150px" prefix-icon="el-icon-edit"
                          v-model="emp.notes" placeholder="请输入学习进度"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="是否入场:" prop="test_time1">
                <el-input size="mini" style="width: 200px" prefix-icon="el-icon-phone"
                          v-model="emp.test_time1" placeholder="请输入是否入场"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="doAddEmp">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "EmpBasic",
  data() {
    return {
      searchValue: {
        politicId: null,
        nationId: null,
        jobLevelId: null,
        posId: null,
        engageForm: null,
        departmentId: null,
        beginDateScope: null
      },
      title: '',
      importDataBtnText: '导入数据',
      importDataBtnIcon: 'el-icon-upload2',
      importDataDisabled: false,
      showAdvanceSearchView: false,
      allDeps: [],
      emps: [],
      loading: false,
      popVisible: false,
      popVisible2: false,
      dialogVisible: false,
      total: 0,
      page: 1,
      keyword: '',
      size: 10,
      nations: [],
      emp: {
        name: "张三",
        gender: "男",
        school: "某某大学",
        speciality: "日语专业",
        education: "本科",
        graduateDate: "20230701",
        idCard: "123123311231312412",
        phone: "12312312311",
        weChat: "123123",
        Japanese: "N1",
        notes: "我是备注",
        test_time1: "20230609",
        result1: "V",
        test_time2: "20230612",
        result2: "V",
        offer: "V",
        agreement: "V",
        beginDate: "20231107"
      },
      defaultProps: {
        children: 'children',
        label: 'name'
      },
      rules: {
        name: [{required: true, message: '请输入用户名', trigger: 'blur'}],
        gender: [{required: true, message: '请输入性别', trigger: 'blur'}],
        school: [{required: true, message: '请输入学校', trigger: 'blur'}],
        speciality: [{required: true, message: '请输入学校', trigger: 'blur'}],
        education: [{required: true, message: '请输入学历', trigger: 'blur'}],
        graduateDate: [{required: true, message: '请输入毕业时间', trigger: 'blur'}],
        idCard: [{required: true, message: '请输入专业', trigger: 'blur'}, {
          pattern: /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/,
          message: '身份证号码格式不正确',
          trigger: 'blur'
        }],
        phone: [{required: true, message: '请输入联系电话', trigger: 'blur'}],
        weChat: [{required: true, message: '请输入微信号', trigger: 'blur'}],
        Japanese: [{required: true, message: '请输入日语等级', trigger: 'blur'}],
        notes: [{required: true, message: '请输入备注', trigger: 'blur'}],
        test_time1: [{required: true, message: '请输入笔试时间', trigger: 'blur'}],
        result1: [{required: true, message: '请输入笔试结果', trigger: 'blur'}],
        test_time2: [{required: true, message: '请输入面试时间', trigger: 'blur'}],
        result2: [{required: true, message: '请输入面试结果', trigger: 'blur'}],
        offer: [{required: true, message: '是否接受了offer', trigger: 'blur'}],
        agreement: [{required: true, message: '是否签订了协议', trigger: 'blur'}],
        beginDate: [{required: true, message: '请输入开班时间', trigger: 'blur'}],
      }
    }
  },
  mounted() {
    this.initEmps();
    this.initData();
  },
  methods: {
    searvhViewHandleNodeClick(data) {
      this.inputDepName = data.name;
      this.searchValue.departmentId = data.id;
      this.popVisible2 = !this.popVisible2
    },
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
    exportData() {
      window.open('/employee/basic/export', '_parent');
    },
    emptyEmp() {
      this.emp = {
        name: "",
        gender: "",
        school: "",
        speciality: "",
        education: "",
        graduateDate: "",
        idCard: "",
        phone: "",
        weChat: "",
        Japanese: "",
        notes: "",
        test_time1: "",
        result1: "",
        test_time2: "",
        result2: "",
        offer: "",
        agreement: "",
        beginDate: ""
      }
    },
    showEditEmpView(data) {
      this.initPositions();
      this.title = '编辑员工信息';
      this.emp = data;
      this.inputDepName = data.department.name;
      this.dialogVisible = true;
    },
    deleteEmp(data) {
      this.$confirm('此操作将永久删除【' + data.name + '】, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.deleteRequest("/employee/basic/" + data.id).then(resp => {
          if (resp) {
            this.initEmps();
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    doAddEmp() {
      if (this.emp.id) {
        this.$refs['empForm'].validate(valid => {
          if (valid) {
            this.putRequest("/employee/basic/", this.emp).then(resp => {
              if (resp) {
                this.dialogVisible = false;
                this.initEmps();
              }
            })
          }
        });
      } else {
        this.$refs['empForm'].validate(valid => {
          if (valid) {
            this.postRequest("/employee/basic/", this.emp).then(resp => {
              if (resp) {
                this.dialogVisible = false;
                this.initEmps();
              }
            })
          }
        });
      }
    },
    // handleNodeClick(data) {
    //     this.inputDepName = data.name;
    //     this.emp.departmentId = data.id;
    //     this.popVisible = !this.popVisible
    // },
    // showDepView() {
    //     this.popVisible = !this.popVisible
    // },
    // showDepView2() {
    //     this.popVisible2 = !this.popVisible2
    // },
    // initPositions() {
    //     this.getRequest('/employee/basic/positions').then(resp => {
    //         if (resp) {
    //             this.positions = resp;
    //         }
    //     })
    // },
    // getMaxWordID() {
    //     this.getRequest("/employee/basic/maxWorkID").then(resp => {
    //         if (resp) {
    //             this.emp.workID = resp.obj;
    //         }
    //     })
    // },
    initData() {
      // if (!window.sessionStorage.getItem("nations")) {
      //     this.getRequest('/employee/basic/nations').then(resp => {
      //         if (resp) {
      //             this.nations = resp;
      //             window.sessionStorage.setItem("nations", JSON.stringify(resp));
      //         }
      //     })
      // } else {
      //     this.nations = JSON.parse(window.sessionStorage.getItem("nations"));
      // }
      // if (!window.sessionStorage.getItem("joblevels")) {
      //     this.getRequest('/employee/basic/joblevels').then(resp => {
      //         if (resp) {
      //             this.joblevels = resp;
      //             window.sessionStorage.setItem("joblevels", JSON.stringify(resp));
      //         }
      //     })
      // } else {
      //     this.joblevels = JSON.parse(window.sessionStorage.getItem("joblevels"));
      // }
      // if (!window.sessionStorage.getItem("politicsstatus")) {
      //     this.getRequest('/employee/basic/politicsstatus').then(resp => {
      //         if (resp) {
      //             this.politicsstatus = resp;
      //             window.sessionStorage.setItem("politicsstatus", JSON.stringify(resp));
      //         }
      //     })
      // } else {
      //     this.politicsstatus = JSON.parse(window.sessionStorage.getItem("politicsstatus"));
      // }
      // if (!window.sessionStorage.getItem("deps")) {
      //     this.getRequest('/employee/basic/deps').then(resp => {
      //         if (resp) {
      //             this.allDeps = resp;
      //             window.sessionStorage.setItem("deps", JSON.stringify(resp));
      //         }
      //     })
      // } else {
      //     this.allDeps = JSON.parse(window.sessionStorage.getItem("deps"));
      // }
    },
    sizeChange(currentSize) {
      this.size = currentSize;
      this.initEmps();
    },
    currentChange(currentPage) {
      this.page = currentPage;
      this.initEmps();
    },
    showAddEmpView() {
      this.emptyEmp();
      this.title = '添加员工';
      this.dialogVisible = true;
    },
    initEmps() {
      this.loading = true;
      let url = '/employee/basic/?page=' + this.page + '&size=' + this.size;
      url += "&name=" + this.keyword;
      this.getRequest(url).then(resp => {
        this.loading = false;
        if (resp) {
          this.emps = resp.data;
          this.total = resp.total;
        }
      });
    }
  }
}
</script>

<style>
/* 可以设置不同的进入和离开动画 */
/* 设置持续时间和动画函数 */
.slide-fade-enter-active {
  transition: all .8s ease;
}

.slide-fade-leave-active {
  transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}

.slide-fade-enter, .slide-fade-leave-to
  /* .slide-fade-leave-active for below version 2.1.8 */
{
  transform: translateX(10px);
  opacity: 0;
}
</style>
