package com.board.web.domain;

import org.springframework.stereotype.Component;

@Component
public class Board {
	String seq, id, title, content, regdate;
	int hit_cnt;

	public int getHit_cnt() {
		return hit_cnt;
	}

	public void setHit_cnt(int hit_cnt) {
		this.hit_cnt = hit_cnt;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
