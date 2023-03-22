<template>
 <div class="common-layout">
    <el-container>
      <el-header><el-icon><user /></el-icon><span>学生宿舍管理系统</span></el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
      >
        <el-sub-menu index="1">
          <template #title>
           <span>学生管理</span>
          </template>
            <el-menu-item index="1-1"><el-icon><caret-right /></el-icon><router-link to="/studentlist">学生信息浏览</router-link></el-menu-item>
            <el-menu-item index="1-2"><el-icon><caret-right /></el-icon><router-link to="/studentadd">学生信息登记</router-link></el-menu-item>
        </el-sub-menu>
         <el-sub-menu index="2">
          <template #title>
           <span>住宿管理</span>
          </template>
            <el-menu-item index="2-1"><el-icon><caret-right /></el-icon>入住管理</el-menu-item>
            <el-menu-item index="2-2"><el-icon><caret-right /></el-icon>宿舍管理</el-menu-item>
            <el-menu-item index="2-3"><el-icon><caret-right /></el-icon>学生退宿</el-menu-item>
            <el-menu-item index="2-4"><el-icon><caret-right /></el-icon>期末注销</el-menu-item>
        </el-sub-menu>
      </el-menu>
        </el-aside>
        <el-main><router-view></router-view></el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
import{User} from '@element-plus/icons-vue'
export default {
  components:{User}
}
</script>
<style lang="scss">
.el-header{
  background-color:cornflowerblue;
  height: 200px;
  padding: 0;
  width:100%;
  display: flex;
  align-items: center
}
.el-aside{
  background-color:cornflowerblue;
  height: 600px;
}

.el-main{
  background-color:white;
}
span{
  margin: 0;
  color: black;
}

</style>
