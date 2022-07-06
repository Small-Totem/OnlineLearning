import request from '../request'

export function getAllArticles() {
  return request({
    url: 'http://localhost:8080/queryAllArticle',
    method: 'get'
  })
}

export function getHotArticles() {
  //todo 后端实现改为hot
  return request({
    url: 'http://localhost:8080/queryAllArticle',
    method: 'get'
  })
}

export function getArticleById(id) {
  return request({
    url: `http://localhost:8080/getArticle/${id}`,
    method: 'get'
  })
}

export function getUserData(){
  return request({
    url:'http://localhost:8080/queryAllUser',
    method:"get"
  })
}

export function getTeacherData(){
  return request({
    url:'http://localhost:8080/queryAllTeacher',
    method:"get"
  })
}

export function getCourseData(){
  return request({
    url:'http://localhost:8080/queryAllCourse',
    method:"get"
  })
}

export function getArticleData(){
  return request({
    url:'http://localhost:8080/queryAllArticle',
    method:"get"
  })
}

export function getQuestionData(){
  return request({
    url:'http://localhost:8080/queryAllQuestion',
    method:"get"
  })
}

//作为post带参数的例子 勿动
export function post_param_test(params) {
  return request({
    url: 'http://localhost:8080/addCourseFavorites',
    method: 'post',
    params: {
      userId: params.userId,
      courseId: params.courseId,
    }
  })
}
