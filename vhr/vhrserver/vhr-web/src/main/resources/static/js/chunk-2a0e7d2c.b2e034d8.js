(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2a0e7d2c"],{"1b13":function(e,t,n){"use strict";n("4925")},2908:function(e,t,n){},"418a":function(e,t,n){"use strict";n.r(t);n("7f7f");var i=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticStyle:{"margin-top":"10px",display:"flex","justify-content":"center"}},[t("el-input",{staticStyle:{width:"400px","margin-right":"10px"},attrs:{placeholder:"通过用户名搜索用户...","prefix-icon":"el-icon-search"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.doSearch.apply(null,arguments)}},model:{value:e.keywords,callback:function(t){e.keywords=t},expression:"keywords"}}),t("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.doSearch}},[e._v("搜索")])],1),t("div",{staticClass:"hr-container"},e._l(e.hrs,(function(n,i){return t("el-card",{key:i,staticClass:"hr-card"},[t("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[t("span",[e._v(e._s(n.name))]),t("el-button",{staticStyle:{float:"right",padding:"3px 0",color:"#e30007"},attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(t){return e.deleteHr(n)}}})],1),t("div",[t("div",{staticClass:"img-container"},[t("img",{staticClass:"userface-img",attrs:{src:n.userface,alt:n.name,title:n.name}})]),t("div",{staticClass:"userinfo-container"},[t("div",[e._v("用户名："+e._s(n.name))]),t("div",[e._v("手机号码："+e._s(n.phone))]),t("div",[e._v("电话号码："+e._s(n.telephone))]),t("div",[e._v("地址："+e._s(n.address))]),t("div",[e._v("用户状态：\n                        "),t("el-switch",{attrs:{"active-text":"启用","active-color":"#13ce66","inactive-color":"#ff4949","inactive-text":"禁用"},on:{change:function(t){return e.enabledChange(n)}},model:{value:n.enabled,callback:function(t){e.$set(n,"enabled",t)},expression:"hr.enabled"}})],1),t("div",[e._v("用户角色：\n                        "),e._l(n.roles,(function(n,i){return t("el-tag",{key:i,staticStyle:{"margin-right":"4px"},attrs:{type:"success"}},[e._v(e._s(n.nameZh)+"\n                        ")])})),t("el-popover",{attrs:{placement:"right",title:"角色列表",width:"200",trigger:"click"},on:{show:function(t){return e.showPop(n)},hide:function(t){return e.hidePop(n)}}},[t("el-select",{attrs:{multiple:"",placeholder:"请选择"},model:{value:e.selectedRoles,callback:function(t){e.selectedRoles=t},expression:"selectedRoles"}},e._l(e.allroles,(function(e,n){return t("el-option",{key:n,attrs:{label:e.nameZh,value:e.id}})})),1),t("el-button",{attrs:{slot:"reference",icon:"el-icon-more",type:"text"},slot:"reference"})],1)],2),t("div",[e._v("备注："+e._s(n.remark))])])])])})),1)])},l=[],a=(n("ac6a"),{name:"SysHr",data:function(){return{keywords:"",hrs:[],selectedRoles:[],allroles:[]}},mounted:function(){this.initHrs()},methods:{deleteHr:function(e){var t=this;this.$confirm("此操作将永久删除【"+e.name+"】, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/system/hr/"+e.id).then((function(e){e&&t.initHrs()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},doSearch:function(){this.initHrs()},hidePop:function(e){var t=this,n=[];Object.assign(n,e.roles);var i=!1;if(n.length!=this.selectedRoles.length)i=!0;else{for(var l=0;l<n.length;l++)for(var a=n[l],s=0;s<this.selectedRoles.length;s++){var o=this.selectedRoles[s];if(a.id==o){n.splice(l,1),l--;break}}0!=n.length&&(i=!0)}if(i){var r="/system/hr/role?hrid="+e.id;this.selectedRoles.forEach((function(e){r+="&rids="+e})),this.putRequest(r).then((function(e){e&&t.initHrs()}))}},showPop:function(e){var t=this;this.initAllRoles();var n=e.roles;this.selectedRoles=[],n.forEach((function(e){t.selectedRoles.push(e.id)}))},enabledChange:function(e){var t=this;delete e.roles,this.putRequest("/system/hr/",e).then((function(e){e&&t.initHrs()}))},initAllRoles:function(){var e=this;this.getRequest("/system/hr/roles").then((function(t){t&&(e.allroles=t)}))},initHrs:function(){var e=this;this.getRequest("/system/hr/?keywords="+this.keywords).then((function(t){t&&(e.hrs=t)}))}}}),s=a,o=(n("1b13"),n("2877")),r=Object(o["a"])(s,i,l,!1,null,null,null);t["default"]=r.exports},4925:function(e,t,n){},"56fd":function(e,t,n){"use strict";n("2908")},"60b8":function(e,t,n){"use strict";n("921f")},"864e":function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e._self._c;return t("div",[e._v("\n    操作日志管理\n")])},l=[],a={name:"SysLog"},s=a,o=n("2877"),r=Object(o["a"])(s,i,l,!1,null,"ff6f3968",null);t["default"]=r.exports},"8d67":function(e,t,n){"use strict";n.r(t);var i=function(){var e=this,t=e._self._c;return t("div",[t("el-tabs",{attrs:{type:"card"},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[t("el-tab-pane",{attrs:{label:"部门管理",name:"depmana"}},[t("DepMana")],1),t("el-tab-pane",{attrs:{label:"职位管理",name:"posmana"}},[t("PosMana")],1),t("el-tab-pane",{attrs:{label:"职称管理",name:"joblevelmana"}},[t("JobLevelMana")],1),t("el-tab-pane",{attrs:{label:"奖惩规则",name:"ecmana"}},[t("EcMana")],1),t("el-tab-pane",{attrs:{label:"权限组",name:"permissmana"}},[t("PermissMana")],1)],1)],1)},l=[],a=(n("7f7f"),function(){var e=this,t=e._self._c;return t("div",{staticStyle:{width:"500px"}},[t("el-input",{attrs:{placeholder:"请输入部门名称进行搜索...","prefix-icon":"el-icon-search"},model:{value:e.filterText,callback:function(t){e.filterText=t},expression:"filterText"}}),t("el-tree",{ref:"tree",attrs:{data:e.deps,props:e.defaultProps,"expand-on-click-node":!1,"filter-node-method":e.filterNode},scopedSlots:e._u([{key:"default",fn:function(n){n.node;var i=n.data;return t("span",{staticClass:"custom-tree-node",staticStyle:{display:"flex","justify-content":"space-between",width:"100%"}},[t("span",[e._v(e._s(i.name))]),t("span",[t("el-button",{staticClass:"depBtn",attrs:{type:"primary",size:"mini"},on:{click:function(){return e.showAddDepView(i)}}},[e._v("\n          添加部门\n        ")]),t("el-button",{staticClass:"depBtn",attrs:{type:"danger",size:"mini"},on:{click:function(){return e.deleteDep(i)}}},[e._v("\n          删除部门\n        ")])],1)])}}])}),t("el-dialog",{attrs:{title:"添加部门",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[t("div",[t("table",[t("tr",[t("td",[t("el-tag",[e._v("上级部门")])],1),t("td",[e._v(e._s(e.pname))])]),t("tr",[t("td",[t("el-tag",[e._v("部门名称")])],1),t("td",[t("el-input",{attrs:{placeholder:"请输入部门名称..."},model:{value:e.dep.name,callback:function(t){e.$set(e.dep,"name",t)},expression:"dep.name"}})],1)])])]),t("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{type:"primary"},on:{click:e.doAddDep}},[e._v("确 定")])],1)])],1)}),s=[],o={name:"DepMana",data:function(){return{dialogVisible:!1,filterText:"",dep:{name:"",parentId:-1},pname:"",deps:[],defaultProps:{children:"children",label:"name"}}},watch:{filterText:function(e){this.$refs.tree.filter(e)}},mounted:function(){this.initDeps()},methods:{initDep:function(){this.dep={name:"",parentId:-1},this.pname=""},addDep2Deps:function(e,t){for(var n=0;n<e.length;n++){var i=e[n];if(i.id==t.parentId)return i.children=i.children.concat(t),void(i.children.length>0&&(i.parent=!0));this.addDep2Deps(i.children,t)}},doAddDep:function(){var e=this;this.postRequest("/system/basic/department/",this.dep).then((function(t){t&&(e.addDep2Deps(e.deps,t.obj),e.dialogVisible=!1,e.initDep())}))},removeDepFromDeps:function(e,t,n){for(var i=0;i<t.length;i++){var l=t[i];if(l.id==n)return t.splice(i,1),void(0==t.length&&(e.parent=!1));this.removeDepFromDeps(l,l.children,n)}},deleteDep:function(e){var t=this;e.parent?this.$message.error("父部门删除失败"):this.$confirm("此操作将永久删除【"+e.name+"】部门, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/system/basic/department/"+e.id).then((function(n){n&&t.removeDepFromDeps(null,t.deps,e.id)}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},showAddDepView:function(e){this.pname=e.name,this.dep.parentId=e.id,this.dialogVisible=!0},initDeps:function(){var e=this;this.getRequest("/system/basic/department/").then((function(t){t&&(e.deps=t)}))},filterNode:function(e,t){return!e||-1!==t.name.indexOf(e)}}},r=o,c=(n("a43e"),n("2877")),d=Object(c["a"])(r,a,s,!1,null,null,null),u=d.exports,p=function(){var e=this,t=e._self._c;return t("div",[t("div",[t("el-input",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticClass:"addPosInput",attrs:{size:"small","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",placeholder:"添加职位...","prefix-icon":"el-icon-plus"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.addPosition.apply(null,arguments)}},model:{value:e.pos.name,callback:function(t){e.$set(e.pos,"name",t)},expression:"pos.name"}}),t("el-button",{attrs:{icon:"el-icon-plus",size:"small",type:"primary"},on:{click:e.addPosition}},[e._v("添加")])],1),t("div",{staticClass:"posManaMain"},[t("el-table",{staticStyle:{width:"70%"},attrs:{data:e.positions,border:"",size:"small",stripe:""},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55"}}),t("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),t("el-table-column",{attrs:{prop:"name",label:"职位名称",width:"180"}}),t("el-table-column",{attrs:{prop:"createDate",width:"150",label:"创建时间"}}),t("el-table-column",{attrs:{label:"是否启用"},scopedSlots:e._u([{key:"default",fn:function(n){return[n.row.enabled?t("el-tag",{attrs:{size:"small",type:"success"}},[e._v("已启用")]):t("el-tag",{attrs:{size:"small",type:"danger"}},[e._v("未启用")])]}}])}),t("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(n){return[t("el-button",{attrs:{size:"mini"},on:{click:function(t){return e.showEditView(n.$index,n.row)}}},[e._v("编辑\n                      ")]),t("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleDelete(n.$index,n.row)}}},[e._v("删除\n                      ")])]}}])})],1),t("el-button",{staticStyle:{"margin-top":"8px"},attrs:{type:"danger",size:"small",disabled:0==e.multipleSelection.length},on:{click:e.deleteMany}},[e._v("批量删除\n          ")])],1),t("el-dialog",{attrs:{title:"修改职位",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[t("div",[t("div",[t("el-tag",[e._v("职位名称")]),t("el-input",{staticClass:"updatePosInput",attrs:{size:"small"},model:{value:e.updatePos.name,callback:function(t){e.$set(e.updatePos,"name",t)},expression:"updatePos.name"}})],1),t("div",[t("el-tag",[e._v("是否启用")]),t("el-switch",{attrs:{"active-text":"启用","inactive-text":"禁用"},model:{value:e.updatePos.enabled,callback:function(t){e.$set(e.updatePos,"enabled",t)},expression:"updatePos.enabled"}})],1)]),t("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.doUpdate}},[e._v("确 定")])],1)])],1)},m=[],f=(n("ac6a"),{name:"PosMana",data:function(){return{pos:{name:""},dialogVisible:!1,loading:!1,updatePos:{name:"",enabled:!1},multipleSelection:[],positions:[]}},methods:{deleteMany:function(){var e=this;this.$confirm("此操作将永久删除【"+this.multipleSelection.length+"】条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.multipleSelection.forEach((function(e){"ids="+e.id+"&"}))})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))},handleSelectionChange:function(e){this.multipleSelection=e},addPosition:function(){var e=this;this.pos.name?this.postRequest("/system/basic/pos/",this.pos).then((function(t){t&&(e.pos.name="")})):this.$message.error("职位名称不可以为空")},showEditView:function(e,t){Object.assign(this.updatePos,t),this.dialogVisible=!0},doUpdate:function(){var e=this;this.putRequest("/system/basic/pos/",this.updatePos).then((function(t){t&&(e.updatePos.name="",e.dialogVisible=!1)}))},handleDelete:function(e,t){var n=this;this.$confirm("此操作将永久删除【"+t.name+"】职位, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).catch((function(){n.$message({type:"info",message:"已取消删除"})}))}}}),h=f,v=(n("56fd"),Object(c["a"])(h,p,m,!1,null,null,null)),b=v.exports,g=function(){var e=this,t=e._self._c;return t("div",[t("div",[t("el-input",{staticStyle:{width:"300px"},attrs:{size:"small","prefix-icon":"el-icon-plus",placeholder:"添加职称..."},model:{value:e.jl.name,callback:function(t){e.$set(e.jl,"name",t)},expression:"jl.name"}}),t("el-select",{staticStyle:{"margin-left":"5px","margin-right":"5px"},attrs:{placeholder:"职称等级",size:"small"},model:{value:e.jl.titleLevel,callback:function(t){e.$set(e.jl,"titleLevel",t)},expression:"jl.titleLevel"}},e._l(e.titleLevels,(function(e){return t("el-option",{key:e,attrs:{label:e,value:e}})})),1),t("el-button",{attrs:{icon:"el-icon-plus",type:"primary",size:"small"},on:{click:e.addJobLevel}},[e._v("添加")])],1),t("div",{staticStyle:{"margin-top":"10px"}},[t("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{width:"80%"},attrs:{data:e.jls,border:"","element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",size:"small"},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55"}}),t("el-table-column",{attrs:{prop:"id",label:"编号",width:"55"}}),t("el-table-column",{attrs:{prop:"name",label:"职称名称",width:"150"}}),t("el-table-column",{attrs:{prop:"titleLevel",label:"职称级别"}}),t("el-table-column",{attrs:{prop:"createDate",label:"创建时间"}}),t("el-table-column",{attrs:{label:"是否启用"},scopedSlots:e._u([{key:"default",fn:function(n){return[n.row.enabled?t("el-tag",{attrs:{type:"success"}},[e._v("已启用")]):t("el-tag",{attrs:{type:"danger"}},[e._v("未启用")])]}}])}),t("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(n){return[t("el-button",{attrs:{size:"small"},on:{click:function(t){return e.showEditView(n.row)}}},[e._v("编辑")]),t("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(t){return e.deleteHandler(n.row)}}},[e._v("删除")])]}}])})],1),t("el-button",{staticStyle:{"margin-top":"10px"},attrs:{type:"danger",size:"small",disabled:0==e.multipleSelection.length},on:{click:e.deleteMany}},[e._v("批量删除\n          ")])],1),t("el-dialog",{attrs:{title:"修改职称",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[t("div",[t("table",[t("tr",[t("td",[t("el-tag",[e._v("职称名")])],1),t("td",[t("el-input",{attrs:{size:"small"},model:{value:e.updateJl.name,callback:function(t){e.$set(e.updateJl,"name",t)},expression:"updateJl.name"}})],1)]),t("tr",[t("td",[t("el-tag",[e._v("职称级别")])],1),t("td",[t("el-select",{staticStyle:{"margin-left":"5px","margin-right":"5px"},attrs:{placeholder:"职称等级",size:"small"},model:{value:e.updateJl.titleLevel,callback:function(t){e.$set(e.updateJl,"titleLevel",t)},expression:"updateJl.titleLevel"}},e._l(e.titleLevels,(function(e){return t("el-option",{key:e,attrs:{label:e,value:e}})})),1)],1)]),t("tr",[t("td",[t("el-tag",[e._v("是否启用")])],1),t("td",[t("el-switch",{attrs:{"active-text":"启用","inactive-text":"禁用"},model:{value:e.updateJl.enabled,callback:function(t){e.$set(e.updateJl,"enabled",t)},expression:"updateJl.enabled"}})],1)])])]),t("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{attrs:{size:"small"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),t("el-button",{attrs:{size:"small",type:"primary"},on:{click:e.doUpdate}},[e._v("确 定")])],1)])],1)},y=[],x={name:"JobLevelMana",data:function(){return{dialogVisible:!1,loading:!1,multipleSelection:[],updateJl:{name:"",titleLevel:"",enabled:!1},jl:{name:"",titleLevel:""},jls:[],titleLevels:["正高级","副高级","中级","初级","员级"]}},mounted:function(){this.initJls()},methods:{deleteMany:function(){var e=this;this.$confirm("此操作将永久删除【"+this.multipleSelection.length+"】条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var t="?";e.multipleSelection.forEach((function(e){t+="ids="+e.id+"&"})),e.deleteRequest("/system/basic/joblevel/"+t).then((function(t){t&&e.initJls()}))})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))},doUpdate:function(){var e=this;this.putRequest("/system/basic/joblevel/",this.updateJl).then((function(t){t&&(e.initJls(),e.dialogVisible=!1)}))},handleSelectionChange:function(e){this.multipleSelection=e},showEditView:function(e){Object.assign(this.updateJl,e),this.dialogVisible=!0},deleteHandler:function(e){var t=this;this.$confirm("此操作将永久【"+e.name+"】职称, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/system/basic/joblevel/"+e.id).then((function(e){e&&t.initJls()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},addJobLevel:function(){var e=this;this.jl.name&&this.jl.titleLevel?this.postRequest("/system/basic/joblevel/",this.jl).then((function(t){t&&e.initJls()})):this.$message.error("添加字段不可以为空!")},initJls:function(){var e=this;this.loading=!0,this.getRequest("/system/basic/joblevel/").then((function(t){e.loading=!1,t&&(e.jls=t,e.jl={name:"",titleLevel:""})}))}}},k=x,_=Object(c["a"])(k,g,y,!1,null,"a807f2ce",null),w=_.exports,R=function(){var e=this,t=e._self._c;return t("div",[e._v("\n    奖惩规则\n")])},S=[],j={name:"EcMana"},$=j,M=Object(c["a"])($,R,S,!1,null,"ea92a492",null),C=M.exports,D=function(){var e=this,t=e._self._c;return t("div",{directives:[{name:"loading",rawName:"v-loading",value:e.globalLoading,expression:"globalLoading"}],attrs:{"element-loading-text":"正在添加...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"}},[t("div",{staticClass:"permissManaTool"},[t("el-input",{attrs:{size:"small",placeholder:"请输入角色英文名"},model:{value:e.role.name,callback:function(t){e.$set(e.role,"name",t)},expression:"role.name"}},[t("template",{slot:"prepend"},[e._v("ROLE_")])],2),t("el-input",{attrs:{size:"small",placeholder:"请输入角色中文名"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.doAddRole.apply(null,arguments)}},model:{value:e.role.nameZh,callback:function(t){e.$set(e.role,"nameZh",t)},expression:"role.nameZh"}}),t("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-plus"},on:{click:e.doAddRole}},[e._v("添加角色")])],1),t("div",{staticClass:"permissManaMain"},[t("el-collapse",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{"element-loading-text":"正在加载...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",accordion:""},on:{change:e.change},model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},e._l(e.roles,(function(n,i){return t("el-collapse-item",{key:i,attrs:{title:n.nameZh,name:n.id}},[t("el-card",{staticClass:"box-card"},[t("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[t("span",[e._v("可访问的资源")]),t("el-button",{staticStyle:{float:"right",padding:"3px 0",color:"#ff0000"},attrs:{icon:"el-icon-delete",type:"text"},on:{click:function(t){return e.deleteRole(n)}}})],1),t("div",[t("el-tree",{key:i,ref:"tree",refInFor:!0,attrs:{"show-checkbox":"","node-key":"id","default-checked-keys":e.selectedMenus,data:e.allmenus,props:e.defaultProps}}),t("div",{staticStyle:{display:"flex","justify-content":"flex-end"}},[t("el-button",{on:{click:e.cancelUpdate}},[e._v("取消修改")]),t("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.doUpdate(n.id,i)}}},[e._v("确认修改")])],1)],1)])],1)})),1)],1)])},P=[],z={name:"PermissMana",data:function(){return{role:{name:"",nameZh:""},allmenus:[],activeName:-1,selectedMenus:[],roles:[],loading:!1,globalLoading:!1,defaultProps:{children:"children",label:"name"}}},mounted:function(){this.initRoles()},methods:{deleteRole:function(e){var t=this;this.$confirm("此操作将永久删除【"+e.nameZh+"】角色, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.deleteRequest("/system/basic/permiss/role/"+e.id).then((function(e){e&&t.initRoles()}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},doAddRole:function(){var e=this;this.role.name&&this.role.nameZh?(this.globalLoading=!0,this.postRequest("/system/basic/permiss/role",this.role).then((function(t){e.globalLoading=!1,t&&(e.role.name="",e.role.nameZh="",e.initRoles())}))):this.$message.error("数据不可以为空")},cancelUpdate:function(){this.activeName=-1},doUpdate:function(e,t){var n=this,i=this.$refs.tree[t],l=i.getCheckedKeys(!0),a="/system/basic/permiss/?rid="+e;l.forEach((function(e){a+="&mids="+e})),this.putRequest(a).then((function(e){e&&(n.activeName=-1)}))},change:function(e){e&&(this.initAllMenus(),this.initSelectedMenus(e))},initSelectedMenus:function(e){var t=this;this.getRequest("/system/basic/permiss/mids/"+e).then((function(e){e&&(t.selectedMenus=e)}))},initAllMenus:function(){var e=this;this.getRequest("/system/basic/permiss/menus").then((function(t){t&&(e.allmenus=t)}))},initRoles:function(){var e=this;this.loading=!0,this.getRequest("/system/basic/permiss/").then((function(t){e.loading=!1,t&&(e.roles=t)}))}}},L=z,J=(n("60b8"),Object(c["a"])(L,D,P,!1,null,null,null)),V=J.exports,q={name:"SysBasic",data:function(){return{activeName:"depmana"}},components:{DepMana:u,PosMana:b,JobLevelMana:w,EcMana:C,PermissMana:V}},T=q,O=Object(c["a"])(T,i,l,!1,null,"a6ce79de",null);t["default"]=O.exports},"921f":function(e,t,n){},a43e:function(e,t,n){"use strict";n("afd9")},afd9:function(e,t,n){}}]);
//# sourceMappingURL=chunk-2a0e7d2c.b2e034d8.js.map