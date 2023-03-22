<template>
  <div>
    <el-container>
      <el-header>图书管理系统</el-header>
      <el-container>
        <el-aside width="200px">
          <el-row class="tac">
          <el-col :span="20">
      <h5 class="mb-2">
      
      </h5>
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
      >
        <el-sub-menu index="1">
          <template #title>
            <el-icon><location /></el-icon>
            <span>管理员管理</span>
          </template>
          <el-menu-item-group title="">
            <el-menu-item index="1-1"><router-link to="/adddoctor">添加管理员</router-link></el-menu-item>
            <el-menu-item index="1-2"><router-link to="/doctorlist">管理员列表</router-link></el-menu-item>
            <el-sub-menu index="1-3">
            <template #title>图书查询</template>
            <el-menu-item index="1-3-1"><router-link to="/niandai">按年代查询</router-link></el-menu-item>
            <el-menu-item index="1-3-2"><router-link to="/chuban">出版社查询</router-link></el-menu-item>
            <el-menu-item index="1-3-3"><router-link to="/zuozhe">作者查询</router-link></el-menu-item>
            <el-menu-item index="1-3-4"><router-link to="/shuming">书名查询</router-link></el-menu-item>
            <el-menu-item index="1-3-5"><router-link to="/mohu">模糊查询</router-link></el-menu-item>
            <el-menu-item index="1-3-6"><router-link to="/leibie">类别查询</router-link></el-menu-item>
          </el-sub-menu>
          </el-menu-item-group>
          <el-sub-menu index="1-4">
            <template #title>图书信息管理</template>
            <el-menu-item index="1-4-1"><router-link to="/xinxishanchu">信息删除</router-link></el-menu-item>
            <el-menu-item index="1-4-2"><router-link to="/xinxitianjia">信息添加</router-link></el-menu-item>
            <el-menu-item index="1-4-3"><router-link to="/xinxixiugai">信息修改</router-link></el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon><location /></el-icon>
            <span>读者管理</span>
          </template>
          <el-menu-item-group title="">
            <el-menu-item index="2-1"><router-link to="/">增加/删除读者</router-link></el-menu-item>
            <el-menu-item index="2-2"><router-link to="/">修改权限</router-link></el-menu-item>
            <el-menu-item index="2-3"><router-link to="/">个人信息查询/修改</router-link></el-menu-item>
            <el-menu-item index="2-4"><router-link to="/">读者借阅信息查询</router-link></el-menu-item>
            <el-menu-item index="2-5"><router-link to="/">超期/丢失罚款</router-link></el-menu-item>
            <el-menu-item index="2-6"><router-link to="/">办理挂失</router-link></el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <el-icon><location /></el-icon>
            <span>系统管理</span>
          </template>
          <el-menu-item-group title="">
            <el-sub-menu index="3-1">
            <template #title>系统更新</template>
            <el-menu-item index="3-1-1"><router-link to="/">软件更新</router-link></el-menu-item>
            <el-menu-item index="3-1-1"><router-link to="/">硬件更新</router-link></el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="3-2">
            <template #title>系统维护</template>
            <el-menu-item index="3-2-1"><router-link to="/">日志维护</router-link></el-menu-item>
            </el-sub-menu>
          </el-menu-item-group>
        </el-sub-menu>
        <el-menu-item index="4">
          <el-icon><setting /></el-icon>
          <span><router-link to="/">登录/登出</router-link></span>
        </el-menu-item>
      </el-menu>
      
    </el-col>
          </el-row>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.el-header{
  background-color: rgb(231, 228, 225);
  text-align: center;
  line-height :60px;
  
  
}

.el-asider{
  background-color: rgb(106, 103, 103);
  height: 600px;
}
.el-main{
  background-color: white;
  height: 600px;
}
</style>