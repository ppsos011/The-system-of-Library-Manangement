<template>
<el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span>添加管理员</span>
      </div>
    </template>
  <el-form :model="form" label-width="120px">
    <el-form-item label="管理员编号">
      <el-input v-model="form.id" />
    </el-form-item>
    <el-form-item label="管理员姓名">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="性别">
      <el-select v-model="form.genda" placeholder="请选择性别">
        <el-option label="男" value="男" />
        <el-option label="女" value="女" />
      </el-select>
    </el-form-item>
    <el-form-item label="职务">
      <el-select v-model="form.level" placeholder="请选择职务">
        <el-option label="图书购入员" value="图书购入员" />
        <el-option label="数量管理员" value="数量管理员" />
        <el-option label="借还管理员" value="借还管理员" />
        <el-option label="清洁员" value="清洁员" />
      </el-select>
    </el-form-item>
    <el-form-item label="管理楼数">
    <el-select v-model="form.depart" class="m-2" placeholder="Select">
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
    <el-form-item>
      <el-button type="primary" @click="onSubmit">添加</el-button>
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
                ability:''
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
                    key6:this.form.ability
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