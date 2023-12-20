<template>
    <div>
        作业展示
      <div>
        <el-button :disabled="importDataDisabled" type="success" icon="el-icon-upload2">
          导出作业表
        </el-button>
        <el-upload
            :show-file-list="false"
            :before-upload="beforeUpload"
            :on-success="onSuccess"
            :on-error="onError"
            :disabled="importDataDisabled"
            style="display: inline-flex;margin-right: 8px;margin-left: 8px"
            action="/employee/basic/import" >
          <el-button :disabled="importDataDisabled" type="success" icon="el-icon-download">
            导入作业表
          </el-button>
        </el-upload>
        <el-button type="primary" icon="el-icon-check" @click="showAddEmpView">
          保存作业表
        </el-button>
        <el-button type="danger" icon="el-icon-delete" @click="showAddEmpView">
          删除作业表
        </el-button>
      </div>
    </div>

</template>

<script>
    export default {
        name: "PraAss"
    }
</script>

<style scoped>

</style>