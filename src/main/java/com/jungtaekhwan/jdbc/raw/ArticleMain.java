package com.jungtaekhwan.jdbc.raw;

import java.util.List;

import com.jungtaekhwan.jdbc.template.ArticleDaoImplUsingTemplate;



public class ArticleMain {
	// ArticleDao articleDao = new ArticleDaoImplUsingRawJdbc();
	// articleDao의 구현체를 JdbcTemplate을 사용하는 것으로 바꾼다.
	ArticleDao articleDao = new ArticleDaoImplUsingTemplate();

	/**
	 * main 메서드
	 */
	public static void main(String[] args) {
		ArticleMain main = new ArticleMain();
		main.listArticles();
		main.getArticle();
		main.addArticle();
		main.updateArticle();
		main.deleteArticle();
	}

	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	public void addArticle() {
		Article article = new Article();
		article.setTitle("타이틀입니다.");
		article.setContent("컨택트입니다.");
		article.setUserId("2");
		article.setName("정택환");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}

	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("3");
		article.setTitle("타이틀을 업데이트했습니다.");
		article.setContent("컨택트를 업데이트 하였습니다.");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}

	public void deleteArticle() {
		if (articleDao.deleteArticle("5") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}