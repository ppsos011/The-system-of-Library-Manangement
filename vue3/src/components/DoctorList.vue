<template>
<el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span><el-input
      class="input"
      v-model="input1"
      size="small"
      placeholder="请输入编号或姓名"
    /></span>
        <el-button class="button" type="text" @click="search">搜索</el-button>
      </div>
    </template>
    <el-upload ref="upload" action="" :http-request="uploadFile" :auto-upload="false">
      <template #trigger>
        <el-button type="primary">选择模板文件</el-button>
      </template>
      <el-button type="success" @click="submitUpload">
        保存上传文件/批量添加图书管理员
      </el-button>
    </el-upload>
    <a :href='"http://localhost:8081/downloadPersonModel"'>下载模板</a>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column fixed prop="id" label="管理员编号" width="150" />
    <el-table-column prop="name" label="管理员姓名" width="120" />
    <el-table-column prop="genda" label="性别" width="120" />
    <el-table-column prop="level" label="职务" width="120" />
    <el-table-column prop="depart" label="管理楼数" width="120" />
    <el-table-column prop="ability" label="从事时间" width="120" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #default="scope">
        <el-button type="text" size="small" @click="update(scope.row)">编辑</el-button>
        <el-dialog v-model="dialogFormVisible" title="人员信息更新">
        <el-form :model="form">
          <el-form-item label="编号" :label-width="formLabelWidth">
          <el-input v-model="form.id" disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="genda">
            <el-select v-model="form.genda" placeholder="请选择性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="职务" prop="level">
            <el-select v-model="form.level" placeholder="请选择职务">
              <el-option label="图书购入员" value="图书购入员" />
              <el-option label="数量管理员" value="数量管理员" />
              <el-option label="借还管理员" value="借还管理员" />
              <el-option label="清洁员" value="清洁员" />
            </el-select>
          </el-form-item>
          <el-form-item label="管理楼数">
           <el-select v-model="form.depart" filterable placeholder="Select">
               <el-option label="一楼" value="一楼" />
               <el-option label="二楼" value="二楼" />
               <el-option label="三楼" value="三楼" />
            </el-select>
          </el-form-item>
          <el-form-item label="从事时间">
      <el-select v-model="form.ability" placeholder="请选择">
        <el-option label="小于1年" value="小于1年" />
        <el-option label="1-5年" value="1-5年" />
        <el-option label="5年以上" value="5年以上" />
      </el-select>
    </el-form-item>
        </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="updateOK">确认</el-button>
      </span>
    </template>
  </el-dialog>
        <el-button type="text" size="small" @click="deletebyID(scope.row)">删除</el-button>
      <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="30%"
    :before-close="handleClose"
  >
    <span>确定删除吗？</span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="deleteOK">确定</el-button>
      </span>
    </template>
  </el-dialog>
      </template>
    </el-table-column>
  </el-table>
</el-card>
</template>

<script>
export default {
    data(){
        return{
            tableData:[],
            input1:'',
            form:{
                id:'',
                name:'',
                genda:'',
                level:'',
                depart:'',
                ability:''
            },
            dialogFormVisible:false,
            dialogVisible:false,
            deleteid:''
        }
    },
    mounted(){
        this.searchall()
    },
    methods:{
        uploadFile(param){
          const that = this
          let formData = new FormData()
          formData.append('file', param.file)
          this.axios.post('/addpersons', formData, {
          'Content-Type':'multipart/form-data'
        }).then(function(response){
          console.log(response)
          that.searchall()
        })
        }, 
        submitUpload(){
          this.$refs.upload.submit();
        },   
        deleteOK(){
          const that=this
          this.axios.get("/deletedoctor",{
            params:{key1:this.deleteid}
          }).then(function(response){
            console.log(response)
            that.searchall()
            that.dialogVisible=false
          })
        },
        deletebyID(row){
          this.dialogVisible=true,
          this.deleteid=row.id
        },
        searchall(){
          const that=this
          this.axios.get("/getAllDoctors")
                   .then(function(response){
                    that.tableData=response.data
                   })
        },
        search(){
          const that=this
          this.axios.get("/getDoctors",{
                          params:{key1:this.input1}
          })
                   .then(function(response){
                    that.tableData=response.data
                   })
        },
        update(row){
          this.dialogFormVisible=true
          this.form=row
        },
        updateOK(){
          const that = this
          this.axios.get("/updateDoctor",
                    {params:{
                    key1:this.form.id,
                    key2:this.form.name,
                    key3:this.form.genda,
                    key4:this.form.level,
                    key5:this.form.depart,
                    key6:this.form.ability
                }})
                .then(function(response){
                  console.log(response)
                  that.searchall()
                  that.dialogFormVisible=false
                })
        }









      /*
      searchall(){
        const that = this
        this.axios.get('/doctorlist')
            .then(function(response){
                that.tableData = response.data;
            })
      },
      search(){
        const that = this
        this.axios.get('/doctorsearch',
                        {params:{searchinfo:this.input1}})
                  .then(function(response){
                    that.tableData = response.data;
                  })
      },
      update(row){
        this.dialogFormVisible = true
        this.form.id=row.id
        this.form.name=row.name
        this.form.genda=row.genda
        this.form.level=row.level
        this.form.depart=row.depart
        this.form.ability=row.ability
      },
      updateOK(){
        const that = this
        this.dialogFormVisible=false
        this.axios.get('/updateDoctor',{
          params:{key1:this.form.id,
                  key2:this.form.name,
                  key3:this.form.genda,
                  key4:this.form.level,
                  key5:this.form.depart,
                  key6:this.form.ability}
        }).then(function(response){
          console.log(response)
          that.searchall()
        })

      },
      deletebyID(row){
        console.log(row)
        this.deleteid=row.id
        this.dialogVisible=true
      },
      deleteOK(){
        const that = this
        this.dialogVisible=false
        this.axios.get("/deletedoctor",{
          params:{key1:this.deleteid}
        }).then(function(response){
          console.log(response)
          that.searchall()
        })
      }
      */
    }

}
</script>

<style>
.input{
  width: 150px;
}
</style>