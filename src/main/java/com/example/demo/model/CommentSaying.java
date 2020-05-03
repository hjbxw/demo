package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class CommentSaying {
	private String id;
	private String sayingContent;
	private String author;
	private String section_id;
	private String avatar;
	private String likes;
	private String createTime;
	private List<CommentFirstLevel> flcs;

	public CommentSaying() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSayingContent() {
		return sayingContent;
	}

	public void setSayingContent(String sayingContent) {
		this.sayingContent = sayingContent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSection_id() {
		return section_id;
	}

	public void setSection_id(String section_id) {
		this.section_id = section_id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<CommentFirstLevel> getFlcs() {
		return flcs;
	}

	public void setFlcs(List<CommentFirstLevel> flcs) {
		this.flcs = flcs;
	}

	@Override
	public String toString() {
		return "CommentSaying{" +
				"id='" + id + '\'' +
				", sayingContent='" + sayingContent + '\'' +
				", author='" + author + '\'' +
				", section_id='" + section_id + '\'' +
				", avatar='" + avatar + '\'' +
				", likes='" + likes + '\'' +
				", createTime=" + createTime +
				", flcs=" + flcs +
				'}';
	}
}