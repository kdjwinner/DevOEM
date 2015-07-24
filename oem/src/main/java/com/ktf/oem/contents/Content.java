package com.ktf.oem.contents;

import java.util.List;

public class Content {
	private String idx;
	private String lid;
	private String album;
	private String artist;
	private String title;
	private String sondword;
	private String sort;
	private String contentid;
	private String ringcode1;
	private String ringcode2;
	private String ringcode3;	
	private String catecode;
	private List<Content> contentList;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSondword() {
		return sondword;
	}
	public void setSondword(String sondword) {
		this.sondword = sondword;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getRingcode1() {
		return ringcode1;
	}
	public void setRingcode1(String ringcode1) {
		this.ringcode1 = ringcode1;
	}
	public String getRingcode2() {
		return ringcode2;
	}
	public void setRingcode2(String ringcode2) {
		this.ringcode2 = ringcode2;
	}
	public String getRingcode3() {
		return ringcode3;
	}
	public void setRingcode3(String ringcode3) {
		this.ringcode3 = ringcode3;
	}
	public String getCatecode() {
		return catecode;
	}
	public void setCatecode(String catecode) {
		this.catecode = catecode;
	}
	public List<Content> getContentList() {
		return contentList;
	}
	public void setContentList(List<Content> contentList) {
		this.contentList = contentList;
	}

}

