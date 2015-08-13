package com.weixin.po;

public class NewsMessage extends BaseMessage{
	private String ArticleCount;
	private String Articles;
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public String getArticles() {
		return Articles;
	}
	public void setArticles(String articles) {
		Articles = articles;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}


}
