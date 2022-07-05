import request from '../request'
export function queryAllUser() {
    return request({
        url: 'http://localhost:8080/queryAllUser',
        method: 'get'
    })
}

export function  getUserById(id) {
    return request({
        url: `/getUserById/${id}`,
        method: 'get'
    })
}