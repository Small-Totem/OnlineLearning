import {createStore} from 'vuex'

export default createStore({
    state: {
        collapse: false,
    },
    mutations: {
        // 侧边栏折叠
        handleCollapse(state, data) {
            state.collapse = data;
        }
    },
    actions: {},
    modules: {}
})
