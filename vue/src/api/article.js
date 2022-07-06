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

export function postaddUser(params){
  return request({
    url:'http://localhost:8080/addUser',
    method:"post",
    params:{
      userId: params.userId,
      showName: params.showName,
      picImg: params.picImg,
      sex: params.sex,
      mobile: params.mobile,
      email: params.email,
      createTime:params.createTime,
      password:params.password
    }
  })
}

export function postaddTeacher(params){
  return request({
    url:'http://localhost:8080/addTeacher',
    method:"post",
    params:{
      id: params.id,
      name: params.name,
      education: params.education,
      career: params.career,
      isStar: params.isStar,
      picPath: params.picPath,
      info:params.info,
      createTime:params.createTime,
      subject:params.subject
    }
  })
}

export function postaddCourse(params){
  return request({
    url:'http://localhost:8080/addCourse',
    method:"post",
    params:{
      courseId: params.courseId,
      teacherId: params.teacherId,
      courseName: params.courseName,
      subject: params.subject,
      subjectLink: params.subjectLink,
      title: params.title,
      logo:params.logo,
      addTime:params.addTime,
      pageViewcount:params.pageViewcount
    }
  })
}

export function postaddArticle(params){
  return request({
    url:'http://localhost:8080/addArticle',
    method:"post",
    params:{
      articleId: params.articleId,
      userId: params.userId,
      title: params.title,
      content: params.content,
      summary: params.summary,
      publishTime: params.publishTime,
      link: params.link,
      clickNum:params.clickNum,
      praiseCount:params.praiseCount,
    }
  })
}

export function postaddQuestion(params){
  return request({
    url:'http://localhost:8080/addQuestion',
    method:"post",
    params:{
      id: params.id,
      userId: params.userId,
      title: params.title,
      content: params.content,
      type: params.type,
      status: params.status,
      replyCount: params.replyCount,
      browseCount:params.browseCount,
      praiseCount:params.praiseCount,
      addTime:params.addTime
    }
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
export function removeArticleById(id) {
  return request({
    url:`http://localhost:8080/removeArticle/${id}`,
    method:'get'
  })

}
