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
