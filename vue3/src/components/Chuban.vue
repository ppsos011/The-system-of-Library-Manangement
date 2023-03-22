<template>
<el-card class="box-card">
    <template #header>
      <div class="card-header">
        <span><el-input
      class="input"
      v-model="input1"
      size="small"
      placeholder="请输入出版社"
    /></span>
        <el-button class="button" type="text" @click="search">查询</el-button>
      </div>
    </template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column fixed prop="id" label="书籍号" width="150" />
    <el-table-column prop="name" label="书名" width="120" />
    <el-table-column prop="genda" label="书籍类别" width="120" />
    <el-table-column prop="level" label="价格" width="120" />
    <el-table-column prop="depart" label="库存" width="120" />
    <el-table-column prop="ability" label="作者" width="120" />
    <el-table-column fixed="right" label="操作员" width="120">
      <template #default>
        <el-button type="text" size="small" @click="handleClick"
          >Detail</el-button
        >
        <el-button type="text" size="small">Edit</el-button>
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
            input1:''
        }
    },
    mounted(){
        const that = this
        this.axios.get('/doctorlist')
            .then(function(response){
                that.tableData = response.data;
            })
    },
    methods:{
      search(){
        const that = this
        this.axios.get('doctorsearch',
                        {params:{searchinfo:this.input1s}})
                  .then(function(response){
                    that.tableData = response.data;
                  })
      }
    }

}
</script>

<style>
.input{
  width: 150px;
}
</style>