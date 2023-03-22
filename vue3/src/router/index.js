import { createRouter, createWebHashHistory } from 'vue-router'
import adddoctor from '@/components/AddDoctor'
import doctorlist from '@/components/DoctorList'
import niandai from '@/components/Niandai'
import zuozhe from '@/components/Zuozhe'
import shuming from '@/components/Shuming'
import mohu from '@/components/Mohu'
import leibie from '@/components/Leibie'
import chuban from '@/components/Chuban'
import xinxishanchu from '@/components/Xinxishanchu'
import xinxixiugai from '@/components/Xinxixiugai'
import xinxitianjia from '@/components/Xinxitianjia'
const routes = [
 {
   path:'/adddoctor',
   component:adddoctor
 },
{
  path:'/doctorlist',
  component:doctorlist
},
{
  path:'/niandai',
  component:niandai
},
{
  path:'/zuozhe',
  component:zuozhe
},
{
  path:'/shuming',
  component:shuming
},
{
  path:'/mohu',
  component:mohu
},
{
  path:'/leibie',
  component:leibie
},
{
  path:'/chuban',
  component:chuban
},
{
  path:'/xinxixiugai',
  component:xinxixiugai
},
{
  path:'/xinxitianjia',
  component:xinxitianjia
},
{
  path:'/xinxishanchu',
  component:xinxishanchu
}
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
