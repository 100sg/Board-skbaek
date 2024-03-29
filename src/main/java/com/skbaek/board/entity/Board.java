package com.skbaek.board.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "board_list")
public class Board {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long no;
	
	@Column
	private String title;
	
	@Column
	private String writer;
	
	@Column
	private String contents;

	@Column(name = "view_cnt")
	private int viewCnt;

	@Column(name = "like_cnt")
	private int likeCnt;

	@CreationTimestamp
	@Column(name = "enroll_time", updatable = false)
	private LocalDateTime enrollTime;

    @UpdateTimestamp
	@Column(name = "update_time", insertable = false)
	private LocalDateTime updateTime;

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public LocalDateTime getEnrollTime() {
		return enrollTime;
	}

	public void setEnrollTime(LocalDateTime enrollTime) {
		this.enrollTime = enrollTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", contents=" + contents + ", viewCnt="
				+ viewCnt + ", likeCnt=" + likeCnt + ", enrollTime=" + enrollTime + ", updateTime=" + updateTime + "]";
	}
	
}
