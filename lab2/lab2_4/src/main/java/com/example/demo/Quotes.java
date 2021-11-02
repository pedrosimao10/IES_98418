package com.example.demo;

public class Quotes {

	private long id;
	private String name;
	private String code;
	private String quote;

	public Quotes(long id, String content, String code, String quote) {
		this.id = id;
		this.name = content;
		this.code = code;
		this.quote = quote;
	}

	
	public Quotes(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Quotes(String quote) {
		this.quote = quote;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getQuote() {
		return quote;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
}
