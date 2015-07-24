package com.ktf.oem.data;

import java.util.List;

public class MainListBean {
	
	private List<XringInfo> newList;
	private List<XringInfo> bestList;
	private List<XringInfo> weekList;
	public List<XringInfo> getNewList() {
		return newList;
	}
	public void setNewList(List<XringInfo> newList) {
		this.newList = newList;
	}
	public List<XringInfo> getBestList() {
		return bestList;
	}
	public void setBestList(List<XringInfo> bestList) {
		this.bestList = bestList;
	}
	public List<XringInfo> getWeekList() {
		return weekList;
	}
	public void setWeekList(List<XringInfo> weekList) {
		this.weekList = weekList;
	}


}
