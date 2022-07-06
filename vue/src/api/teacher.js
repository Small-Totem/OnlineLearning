import request from "../request";

export function getHotTeachers() {
    //todo 具体后端实现改为get_hot而非查询所有
    return request({
        url: 'http://localhost:8080/queryAllTeacher',
        method: 'get'
    })
}
export function getTeachersBySubject(subject) {
    //todo 具体后端实现改为get_hot而非查询所有
    return request({
        url: 'http://localhost:8080/getTeacherBySubject/${subject}',
        method: 'get',
        params:{
            subject
        }
    })
}
