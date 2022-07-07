import request from '../request'
export function queryAllUser() {
    return request({
        url: 'http://localhost:8080/queryAllUser',
        method: 'get'
    })
}

export function getUserById(id) {
    return request({
        url: `http://localhost:8080/getUserById/${id}`,
        method: 'get'
    })
}
export function removeUserById(id) {
    return request({
        url:`http://localhost:8080/removeUser/${id}`,
        method:'get'
    })
}
