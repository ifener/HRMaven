package com.ken.util.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by it on 08/04/2017.
 */
public class PagerTag extends SimpleTagSupport {

    public static final String TAG = "{0}";

    private int currentPageIndex;
    private int pageSize;
    private int recordCount;
    private int totalPageSize;
    private String submitUrl;
    private String style="sabrosus";

    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public void setSubmitUrl(String submitUrl) {
        this.submitUrl = submitUrl;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringBuilder builder = new StringBuilder();
        StringBuilder str = new StringBuilder();
        if(recordCount>0){
            totalPageSize = (recordCount-1)/pageSize+1;
            if (this.currentPageIndex==1){
                this.calcPage(str);
                if(currentPageIndex!=this.totalPageSize){
                    String tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.currentPageIndex+1));
                    str.append("<a href=\""+tempUrl+"\">下一页</a>");
                    tempUrl = this.submitUrl.replace(TAG,String.valueOf(totalPageSize));
                    str.append("<a href=\""+tempUrl+"\">尾页</a>");
                }
            } else if(this.currentPageIndex==this.totalPageSize){
                String tempUrl = this.submitUrl.replace(TAG,"1");
                str.append("<a href=\""+tempUrl+"\">首页</a>");

                tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.currentPageIndex-1));
                str.append("<a href=\""+tempUrl+"\">上一页</a>");
                this.calcPage(str);
            } else {
                String tempUrl = this.submitUrl.replace(TAG,"1");
                str.append("<a href=\""+tempUrl+"\">首页</a>");

                tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.currentPageIndex-1));
                str.append("<a href=\""+tempUrl+"\">上一页</a>");
                this.calcPage(str);
                tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.currentPageIndex+1));
                str.append("<a href=\""+tempUrl+"\">下一页</a>");

                tempUrl = this.submitUrl.replace(TAG,String.valueOf(totalPageSize));
                str.append("<a href=\""+tempUrl+"\">尾页</a>");
            }

            builder.append("<p class=\""+style+"\">"+str);
            builder.append("<span>总共"+totalPageSize+"页:"+this.recordCount+"条记录</span>");
            builder.append("</p>");

            this.getJspContext().getOut().print(builder.toString());
        }
    }

    private void calcPage(StringBuilder str){
        if(this.totalPageSize<=11){
            //一次性显示所有的页码
            for(int i=1;i<=totalPageSize;i++){
                if(this.currentPageIndex==i){
                    str.append("<span class=\"current\">"+i+"</span>");
                } else {
                    String tempUrl = this.submitUrl.replace(TAG,String.valueOf(i));
                    str.append("<a href=\""+tempUrl+"\">"+i+"</a>");
                }
            }
        } else {
            //大于11页的情况
            //靠近首页
            if(this.currentPageIndex<=8){
                for(int i=1;i<=10;i++){
                    if(this.currentPageIndex==i){
                        str.append("<span class=\"current\">"+i+"</span>");
                    } else {
                        String tempUrl = this.submitUrl.replace(TAG,String.valueOf(i));
                        str.append("<a href=\""+tempUrl+"\">"+i+"</a>");
                    }
                }
                str.append("...");
                String tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.totalPageSize));
                str.append("<a href=\""+tempUrl+"\">"+this.totalPageSize+"</a>");
            } else if(this.currentPageIndex+8>=this.totalPageSize){
                //靠近尾页
                String tempUrl = this.submitUrl.replace(TAG,"1");
                str.append("<a href=\""+tempUrl+"\">1</a>");
                str.append("...");
                for (int i=this.totalPageSize-10;i<=this.totalPageSize;i++){
                    if(this.currentPageIndex==i){
                        str.append("<span class=\"current\">"+i+"</span>");
                    } else {
                        tempUrl = this.submitUrl.replace(TAG,String.valueOf(i));
                        str.append("<a href=\""+tempUrl+"\">"+i+"</a>");
                    }
                }
            } else {
                //在中间
                String tempUrl = this.submitUrl.replace(TAG,"1");
                str.append("<a href=\""+tempUrl+"\">1</a>");
                str.append("...");

                for(int i= this.currentPageIndex-4,j=this.currentPageIndex+4;i<=j;i++){
                    if(this.currentPageIndex==i){
                        str.append("<span class=\"current\">"+i+"</span>");
                    } else {
                        tempUrl = this.submitUrl.replace(TAG,String.valueOf(i));
                        str.append("<a href=\""+tempUrl+"\">"+i+"</a>");
                    }
                }
                str.append("...");
                tempUrl = this.submitUrl.replace(TAG,String.valueOf(this.totalPageSize));
                str.append("<a href=\""+tempUrl+"\">"+this.totalPageSize+"</a>");
            }
        }
    }
}
