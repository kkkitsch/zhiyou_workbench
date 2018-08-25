package com.javaweb.costant;

public enum PageEnum {

	PageSize;

	// 每页的默认大小
	public int size;

	PageEnum(int size) {
		this.size = size;
	}

	private PageEnum() {
		this(4);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
