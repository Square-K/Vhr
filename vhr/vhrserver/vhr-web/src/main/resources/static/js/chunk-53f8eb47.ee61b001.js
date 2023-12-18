(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-53f8eb47"],{"58da":function(e,t,i){"use strict";i.r(t);i("7f7f");var l=function(){var e=this,t=e._self._c;return t("div",[t("div",[t("div",{staticStyle:{display:"flex","justify-content":"space-between"}},[t("div",[t("el-input",{staticStyle:{width:"350px","margin-right":"10px"},attrs:{placeholder:"请输入员工名进行搜索，可以直接回车搜索...","prefix-icon":"el-icon-search",clearable:"",disabled:e.showAdvanceSearchView},on:{clear:e.initEmps},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.initEmps.apply(null,arguments)}},model:{value:e.keyword,callback:function(t){e.keyword=t},expression:"keyword"}}),t("el-button",{attrs:{icon:"el-icon-search",type:"primary",disabled:e.showAdvanceSearchView},on:{click:e.initEmps}},[e._v("\n                        搜索\n                    ")]),t("el-button",{attrs:{type:"primary"},on:{click:function(t){e.showAdvanceSearchView=!e.showAdvanceSearchView}}},[t("i",{class:e.showAdvanceSearchView?"fa fa-angle-double-up":"fa fa-angle-double-down",attrs:{"aria-hidden":"true"}}),e._v("\n                        高级搜索\n                    ")])],1),t("div",[t("el-upload",{staticStyle:{display:"inline-flex","margin-right":"8px"},attrs:{"show-file-list":!1,"before-upload":e.beforeUpload,"on-success":e.onSuccess,"on-error":e.onError,disabled:e.importDataDisabled,action:"/employee/basic/import"}},[t("el-button",{attrs:{disabled:e.importDataDisabled,type:"success",icon:e.importDataBtnIcon}},[e._v("\n                            "+e._s(e.importDataBtnText)+"\n                        ")])],1),t("el-button",{attrs:{type:"success",icon:"el-icon-download"},on:{click:e.exportData}},[e._v("\n                        导出数据\n                    ")]),t("el-button",{attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.showAddEmpView}},[e._v("\n                        添加用户\n                    ")])],1)]),t("transition",{attrs:{name:"slide-fade"}},[t("div",{directives:[{name:"show",rawName:"v-show",value:e.showAdvanceSearchView,expression:"showAdvanceSearchView"}],staticStyle:{border:"1px solid #409eff","border-radius":"5px","box-sizing":"border-box",padding:"5px",margin:"10px 0px"}})])],1),t("div",{staticStyle:{"margin-top":"10px"}},[t("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"100%"},attrs:{data:e.emps,stripe:"",border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"}},[t("el-table-column",{attrs:{type:"selection",width:"55"}}),t("el-table-column",{attrs:{prop:"name",fixed:"",align:"left",label:"姓名",width:"90"}}),t("el-table-column",{attrs:{prop:"gender",label:"性别",align:"left",width:"85"}}),t("el-table-column",{attrs:{prop:"school",label:"学校",align:"left",width:"85"}}),t("el-table-column",{attrs:{prop:"speciality",width:"85",align:"left",label:"专业"}}),t("el-table-column",{attrs:{prop:"education",width:"85",align:"left",label:"学历"}}),t("el-table-column",{attrs:{prop:"graduateDate",width:"120",align:"left",label:"毕业时间"}}),t("el-table-column",{attrs:{prop:"idCard",width:"120",align:"left",label:"身份证号"}}),t("el-table-column",{attrs:{prop:"phone",width:"120",align:"left",label:"手机号码"}}),t("el-table-column",{attrs:{prop:"weChat",width:"120",align:"left",label:"微信号码"}}),t("el-table-column",{attrs:{prop:"Japanese",width:"85",align:"left",label:"日语等级"}}),t("el-table-column",{attrs:{prop:"notes",width:"120",align:"left",label:"备注信息"}}),t("el-table-column",{attrs:{prop:"test_time1",width:"120",align:"left",label:"笔试时间"}}),t("el-table-column",{attrs:{prop:"result1",width:"85",align:"left",label:"笔试结果"}}),t("el-table-column",{attrs:{prop:"test_time2",width:"85",align:"left",label:"面试时间"}}),t("el-table-column",{attrs:{prop:"result2",width:"85",align:"left",label:"面试结果"}}),t("el-table-column",{attrs:{prop:"offer",width:"85",align:"left",label:"接受offer"}}),t("el-table-column",{attrs:{prop:"agreement",width:"85",align:"left",label:"协议签订"}}),t("el-table-column",{attrs:{prop:"beginDate",width:"120",align:"left",label:"开班时间"}})],1),t("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[t("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:e.total},on:{"current-change":e.currentChange,"size-change":e.sizeChange}})],1)],1),t("el-dialog",{attrs:{title:e.title,visible:e.dialogVisible,width:"80%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[t("div",[t("el-form",{ref:"empForm",attrs:{model:e.emp,rules:e.rules}},[t("el-row",[t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"姓名:",prop:"name"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入姓名"},model:{value:e.emp.name,callback:function(t){e.$set(e.emp,"name",t)},expression:"emp.name"}})],1)],1),t("el-col",{attrs:{span:5}},[t("el-form-item",{attrs:{label:"性别:",prop:"gender"}},[t("el-radio-group",{model:{value:e.emp.gender,callback:function(t){e.$set(e.emp,"gender",t)},expression:"emp.gender"}},[t("el-radio",{attrs:{label:"男"}},[e._v("男")]),t("el-radio",{attrs:{label:"女"}},[e._v("女")])],1)],1)],1),t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"学校:",prop:"school"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入学校"},model:{value:e.emp.school,callback:function(t){e.$set(e.emp,"school",t)},expression:"emp.school"}})],1)],1),t("el-col",{attrs:{span:7}},[t("el-form-item",{attrs:{label:"专业:",prop:"speciality"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入专业"},model:{value:e.emp.speciality,callback:function(t){e.$set(e.emp,"speciality",t)},expression:"emp.speciality"}})],1)],1)],1),t("el-row",[t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"学历:",prop:"education"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入专业"},model:{value:e.emp.education,callback:function(t){e.$set(e.emp,"education",t)},expression:"emp.education"}})],1)],1),t("el-col",{attrs:{span:5}},[t("el-form-item",{attrs:{label:"毕业时间:",prop:"graduateDate"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入毕业时间"},model:{value:e.emp.graduateDate,callback:function(t){e.$set(e.emp,"graduateDate",t)},expression:"emp.graduateDate"}})],1)],1),t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"身份证号:",prop:"idCard"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入身份证号"},model:{value:e.emp.idCard,callback:function(t){e.$set(e.emp,"idCard",t)},expression:"emp.idCard"}})],1)],1),t("el-col",{attrs:{span:7}},[t("el-form-item",{attrs:{label:"联系电话:",prop:"phone"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入联系电话"},model:{value:e.emp.phone,callback:function(t){e.$set(e.emp,"phone",t)},expression:"emp.phone"}})],1)],1)],1),t("el-row",[t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"微信号:",prop:"weChat"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入微信号"},model:{value:e.emp.weChat,callback:function(t){e.$set(e.emp,"weChat",t)},expression:"emp.weChat"}})],1)],1),t("el-col",{attrs:{span:5}},[t("el-form-item",{attrs:{label:"日语等级:",prop:"Japanese"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入日语等级"},model:{value:e.emp.Japanese,callback:function(t){e.$set(e.emp,"Japanese",t)},expression:"emp.Japanese"}})],1)],1),t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"备注信息:",prop:"notes"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入备注信息"},model:{value:e.emp.notes,callback:function(t){e.$set(e.emp,"notes",t)},expression:"emp.notes"}})],1)],1),t("el-col",{attrs:{span:7}},[t("el-form-item",{attrs:{label:"笔试时间:",prop:"test_time1"}},[t("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-phone",placeholder:"请输入笔试时间"},model:{value:e.emp.test_time1,callback:function(t){e.$set(e.emp,"test_time1",t)},expression:"emp.test_time1"}})],1)],1)],1),t("el-row",[t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"笔试结果:",prop:"result1"}},[t("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-phone",placeholder:"请输入笔试结果"},model:{value:e.emp.result1,callback:function(t){e.$set(e.emp,"result1",t)},expression:"emp.result1"}})],1)],1),t("el-col",{attrs:{span:5}},[t("el-form-item",{attrs:{label:"面试时间:",prop:"test_time2"}},[t("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-phone",placeholder:"请输入面试时间"},model:{value:e.emp.test_time2,callback:function(t){e.$set(e.emp,"test_time2",t)},expression:"emp.test_time2"}})],1)],1),t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"面试结果:",prop:"result2"}},[t("el-input",{staticStyle:{width:"150px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入面试结果"},model:{value:e.emp.result2,callback:function(t){e.$set(e.emp,"result2",t)},expression:"emp.result2"}})],1)],1),t("el-col",{attrs:{span:7}},[t("el-form-item",{attrs:{label:"接受offer:",prop:"offer"}},[t("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"是否接受offer"},model:{value:e.emp.offer,callback:function(t){e.$set(e.emp,"offer",t)},expression:"emp.offer"}})],1)],1)],1),t("el-row",[t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"协议签订:",prop:"agreement"}},[t("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"是否签订协议"},model:{value:e.emp.agreement,callback:function(t){e.$set(e.emp,"agreement",t)},expression:"emp.agreement"}})],1)],1),t("el-col",{attrs:{span:6}},[t("el-form-item",{attrs:{label:"开班时间:",prop:"beginDate"}},[t("el-input",{staticStyle:{width:"200px"},attrs:{size:"mini","prefix-icon":"el-icon-edit",placeholder:"请输入开班时间"},model:{value:e.emp.beginDate,callback:function(t){e.$set(e.emp,"beginDate",t)},expression:"emp.beginDate"}})],1)],1)],1)],1)],1),t("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{type:"primary"},on:{click:e.doAddEmp}},[e._v("确 定")])],1)])],1)},a=[],n={name:"EmpBasic",data:function(){return{searchValue:{politicId:null,nationId:null,jobLevelId:null,posId:null,engageForm:null,departmentId:null,beginDateScope:null},title:"",importDataBtnText:"导入数据",importDataBtnIcon:"el-icon-upload2",importDataDisabled:!1,showAdvanceSearchView:!1,allDeps:[],emps:[],loading:!1,popVisible:!1,popVisible2:!1,dialogVisible:!1,total:0,page:1,keyword:"",size:10,nations:[],emp:{name:"张三",gender:"男",school:"某某大学",speciality:"日语专业",education:"本科",graduateDate:"20230701",idCard:"123123311231312412",phone:"12312312311",weChat:"123123",Japanese:"N1",notes:"我是备注",test_time1:"20230609",result1:"V",test_time2:"20230612",result2:"V",offer:"V",agreement:"V",beginDate:"20231107"},defaultProps:{children:"children",label:"name"},rules:{name:[{required:!0,message:"请输入用户名",trigger:"blur"}],gender:[{required:!0,message:"请输入性别",trigger:"blur"}],school:[{required:!0,message:"请输入学校",trigger:"blur"}],speciality:[{required:!0,message:"请输入学校",trigger:"blur"}],education:[{required:!0,message:"请输入学历",trigger:"blur"}],graduateDate:[{required:!0,message:"请输入毕业时间",trigger:"blur"}],idCard:[{required:!0,message:"请输入专业",trigger:"blur"},{pattern:/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/,message:"身份证号码格式不正确",trigger:"blur"}],phone:[{required:!0,message:"请输入联系电话",trigger:"blur"}],weChat:[{required:!0,message:"请输入微信号",trigger:"blur"}],Japanese:[{required:!0,message:"请输入日语等级",trigger:"blur"}],notes:[{required:!0,message:"请输入备注",trigger:"blur"}],test_time1:[{required:!0,message:"请输入笔试时间",trigger:"blur"}],result1:[{required:!0,message:"请输入笔试结果",trigger:"blur"}],test_time2:[{required:!0,message:"请输入面试时间",trigger:"blur"}],result2:[{required:!0,message:"请输入面试结果",trigger:"blur"}],offer:[{required:!0,message:"是否接受了offer",trigger:"blur"}],agreement:[{required:!0,message:"是否签订了协议",trigger:"blur"}],beginDate:[{required:!0,message:"请输入开班时间",trigger:"blur"}]}}},mounted:function(){this.initEmps(),this.initData()},methods:{searvhViewHandleNodeClick:function(e){this.inputDepName=e.name,this.searchValue.departmentId=e.id,this.popVisible2=!this.popVisible2},onError:function(e,t,i){this.importDataBtnText="导入数据",this.importDataBtnIcon="el-icon-upload2",this.importDataDisabled=!1},onSuccess:function(e,t,i){this.importDataBtnText="导入数据",this.importDataBtnIcon="el-icon-upload2",this.importDataDisabled=!1,this.initEmps()},beforeUpload:function(){this.importDataBtnText="正在导入",this.importDataBtnIcon="el-icon-loading",this.importDataDisabled=!0},exportData:function(){window.open("/employee/basic/export","_parent")},emptyEmp:function(){this.emp={name:"",gender:"",school:"",speciality:"",education:"",graduateDate:"",idCard:"",phone:"",weChat:"",Japanese:"",notes:"",test_time1:"",result1:"",test_time2:"",result2:"",offer:"",agreement:"",beginDate:""}},showEditEmpView:function(e){this.initPositions(),this.title="编辑员工信息",this.emp=e,this.inputDepName=e.department.name,this.dialogVisible=!0},deleteEmp:function(e){var t=this;this.$confirm("此操作将永久删除【"+e.name+"】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/employee/basic/"+e.id).then((function(e){e&&t.initEmps()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},doAddEmp:function(){var e=this;this.emp.id?this.$refs["empForm"].validate((function(t){t&&e.putRequest("/employee/basic/",e.emp).then((function(t){t&&(e.dialogVisible=!1,e.initEmps())}))})):this.$refs["empForm"].validate((function(t){t&&e.postRequest("/employee/basic/",e.emp).then((function(t){t&&(e.dialogVisible=!1,e.initEmps())}))}))},initData:function(){},sizeChange:function(e){this.size=e,this.initEmps()},currentChange:function(e){this.page=e,this.initEmps()},showAddEmpView:function(){this.emptyEmp(),this.title="添加员工",this.dialogVisible=!0},initEmps:function(){var e=this;this.loading=!0;var t="/employee/basic/?page="+this.page+"&size="+this.size;t+="&name="+this.keyword,this.getRequest(t).then((function(t){e.loading=!1,t&&(e.emps=t.data,e.total=t.total)}))}}},r=n,s=(i("c3cb"),i("2877")),o=Object(s["a"])(r,l,a,!1,null,null,null);t["default"]=o.exports},c3cb:function(e,t,i){"use strict";i("e013")},e013:function(e,t,i){}}]);
//# sourceMappingURL=chunk-53f8eb47.ee61b001.js.map