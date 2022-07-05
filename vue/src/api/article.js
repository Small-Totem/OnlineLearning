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
    url: `/getArticle/${id}`,
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