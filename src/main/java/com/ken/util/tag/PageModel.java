package com.ken.util.tag;

/**
 * Created by it on 08/04/2017.
 */
public class PageModel {

    private int recordCount;
    private int currentPageIndex;
    private int pageSize;
    private int totalPageSize;
    private int firstLimitParam;

    public int getFirstLimitParam() {
        return (this.getCurrentPageIndex()-1)*this.getPageSize();
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getCurrentPageIndex() {
        this.currentPageIndex = currentPageIndex<=0?1:currentPageIndex;
        System.out.println("######"+currentPageIndex+"######"+this.getTotalPageSize());
        this.currentPageIndex = currentPageIndex>this.getTotalPageSize()?this.getTotalPageSize():currentPageIndex;
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public int getPageSize() {
        return pageSize == 0 ? 10 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageSize() {
        return (int)Math.ceil((recordCount*1.0)/(pageSize*1.0));
    }
}
