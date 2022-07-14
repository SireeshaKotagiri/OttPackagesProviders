package com.onnet.ott.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "db_sequence")
@Component
public class DbSequence {

	@Id
	private String id;
	private long seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public DbSequence(String id, long seq, long seq1) {
		super();
		this.id = id;
		this.seq = seq;
	}

	public DbSequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DbSequence [id=" + id + ", seq=" + seq + "]";
	}

}