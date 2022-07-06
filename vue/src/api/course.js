import request from '../request'

export function getAllCources() {
    return request({
        url: 'http://localhost:8080/queryAllCourse',
        method: 'get'
    })
}

export function getHotCourses() {
    //todo 具体后端实现改为get_hot而非查询所有
    return request({
        url: 'http://localhost:8080/queryAllCourse',
        method: 'get'
    })
}
export function  getCourseById(courseId) {
    return request({
        url:`http://localhost:8080/getCourse/${courseId}`,
        method:'get'
    })

}
