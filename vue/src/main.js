import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import installElementPlus from './plugins/element'

import './assets/css/icon.css'
const app = createApp(App)

installElementPlus(app)
app
    .use(store)
    .use(router)
    .mount('#app')


store.state.userId=localStorage.getItem("userId")
//console.log("userId="+store.state.userId)
