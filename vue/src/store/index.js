import {createStore} from 'vuex'

export default createStore({
    state: {
        collapse: false,
        userId: null
    },
    mutations: {
        // 侧边栏折叠
        handleCollapse(state, data) {
            state.collapse = data;
        },
        setUserId(state,id){
            state.userId = id;
        },
    },

    actions: {},
    modules: {}
})
