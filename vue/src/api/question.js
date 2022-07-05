import request from '../request'

export function getAllQuestion() {
    return request({
        url: 'http://localhost:8080/queryAllQuestion',
        method: 'get'
    })
}

export function getHotQuestion() {
    //todo 后端实现改为hot
    return request({
        url: 'http://localhost:8080/queryAllQuestion',
        method: 'get'
    })
}
