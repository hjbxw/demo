package com.example.demo.model;

import java.util.Date;

public class CommentSecondLevel {
	private String id;
	private String sayingId;
	private String flcId;
	private String replier;
	private String toCommenter;
	private String replyContent;
	private Date replyTime;
	private CommentFirstLevel flc;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSayingId() {
		return sayingId;
	}

	public void setSayingId(String sayingId) {
		this.sayingId = sayingId;
	}

	public String getFlcId() {
		return flcId;
	}

	public void setFlcId(String flcId) {
		this.flcId = flcId;
	}

	public String getReplier() {
		return replier;
	}

	public void setReplier(String replier) {
		this.replier = replier;
	}

	public String getToCommenter() {
		return toCommenter;
	}

	public void setToCommenter(String toCommenter) {
		this.toCommenter = toCommenter;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public CommentFirstLevel getFlc() {
		return flc;
	}

	public void setFlc(CommentFirstLevel flc) {
		this.flc = flc;
	}

	@Override
	public String toString() {
		return "CommentSecondLevel{" +
				"id='" + id + '\'' +
				", sayingId='" + sayingId + '\'' +
				", flcId='" + flcId + '\'' +
				", replier='" + replier + '\'' +
				", toCommenter='" + toCommenter + '\'' +
				", replyContent='" + replyContent + '\'' +
				", replyTime=" + replyTime +
				", flc=" + flc +
				'}';
	}
}
