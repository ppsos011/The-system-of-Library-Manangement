import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
axios.defaults.baseURL="/api"
createApp(App).use(router).use(VueAxios,axios).use(ElementPlus).mount('#app')