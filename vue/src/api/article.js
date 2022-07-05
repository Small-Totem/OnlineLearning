import request from '../request'

export function getHotArticles() {
  return request({
    url: 'http://localhost:8080/article_test',
    method: 'get'
  })
}

export function getArticleById(id) {
  return request({
    url: `/getArticle/${id}`,
    method: 'get'
  })
}
