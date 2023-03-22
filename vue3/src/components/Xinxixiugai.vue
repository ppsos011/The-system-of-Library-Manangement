<template>
<el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>信息修改</span>
      </div>
    </template>
  <el-form :model="form" label-width="120px">
    <el-form-item label="身份证号：">
      <el-input v-model="form.id" />
    </el-form-item>
    <el-form-item label="姓名">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="性别">
      <el-select v-model="form.genda" placeholder="请选择性别">
        <el-option label="男" value="男" />
        <el-option label="女" value="女" />
      </el-select>
    </el-form-item>
    <el-form-item label="书籍名称">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="书籍类别">
      <el-select v-model="form.level" placeholder="请选择书籍类别">
        <el-option label="科幻" value="科幻" />
        <el-option label="儿童" value="儿童" />
        <el-option label="文学" value="文学" />
        <el-option label="教学" value="教学" />
      </el-select>
    </el-form-item>
    
    <el-form-item>
      <el-button type="primary" @click="onSubmit">购买</el-button>
      <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="30%"
    :before-close="handleClose"
  >
    <span>{{message}}</span>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="dialogVisible = false"
          >Confirm</el-button
        >
      </span>
    </template>
  </el-dialog>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</el-card>

</template>
<script>
export default {
    data(){
        return{
            form:{
                id:'',
                name:'',
                genda:'',
                level:'',
                depart:'',
                ability:'中等'
            },
            dialogVisible:false,
            message:'',
            options:[{value:'',label:''}]
        }
    },
    methods:{
        onSubmit(){
            const that = this
            this.axios.get('/adddoctor',{
                params:{
                    key1:this.form.id,
                    key2:this.form.name,
                    key3:this.form.genda,
                    key4:this.form.level,
                    key5:this.form.depart,
                    
                }
            })
                .then(function(response){
                    if(response.data>0){
                        that.message = "添加成功";
                    }else{
                        that.message = "添加失败"
                    }                   
                    that.dialogVisible=true;
                })
                .catch(function(error){
                    console.log(error)
                });
        } 
    }

}
</script>

<style>

</style>