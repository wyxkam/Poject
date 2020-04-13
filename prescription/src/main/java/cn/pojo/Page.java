package cn.pojo;

import java.util.List;

public class Page {
	private Integer curPageNo;
	private Integer pageSize;
	private Integer totalCount;
	private Integer totalPageCount;
	private List<PrescriptionTemplate>list;
	private List<Staff> staffList;

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public List<PrescriptionTemplate> getList() {
		return list;
	}

	public void setList(List<PrescriptionTemplate> list) {
		this.list = list;
	}

	public Integer getCurPageNo() {
		return curPageNo;
	}

	public void setCurPageNo(Integer curPageNo) {
		this.curPageNo = curPageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
	}

	public Integer getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		if (totalCount > 0) {
			this.totalPageCount = (totalCount % pageSize == 0) ? totalCount
					/ pageSize : (totalCount / pageSize) + 1;
		} else {
			this.totalCount = 0;
		}
	}
}
