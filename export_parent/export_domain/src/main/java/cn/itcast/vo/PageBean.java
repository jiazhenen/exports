package cn.itcast.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageBean {
    //    1、当前页码
    private int pageNum;
    //    2、每页显示条数
    private int pageSize;
    //    3、每页的数据
    private List list;
    //    4、总条数
    private Long total;
    //    5、总页数
    private int pages;
    //   6、上一页
    private int prePage;
    //    7、下一页
    private int nextPage;
    //    8、起始页码
//    ${page.navigateFirstPage}" end="${page.navigateLastPage}
    private int navigateFirstPage;
    //    9、结束页码
    private int navigateLastPage;
//    1、页面传入的  pageNum  pageSize
//    2、计算的  pages  prePage  nextPage  startRow  endRow
//    3、查询的   list  total

    public PageBean(Integer pageNum , Integer pageSize, List list , Long total ){

        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
        this.total = total;
//        计算总页数 总条数/每页显示的条数
        if(total%pageSize==0){ //没有余数
            this.pages = (int)(total/pageSize);
        }else{
            this.pages = ((int)(total/pageSize))+1;
        }
        if(pageNum<=1){ //上一页不能小于1
            this.prePage = 1;
        }else{
            this.prePage = pageNum-1;
        }
        if(pageNum>=pages){ //下一页不能超过总页数
            this.nextPage = pages;
        }else{
            this.nextPage = pageNum+1;
        }

//        判断总页数pages是否大于5
//        如果不大于5 startRow=1   endRow=pages
//        startRow  endRow
        if(pages<=5){
            this.navigateFirstPage=1;
            this.navigateLastPage=pages;
        }else{
//            页面上最多显示5个数
//            如果当前页小于等于3
            if(pageNum<=3){
                this.navigateFirstPage=1;
                this.navigateLastPage=5;
            }else if((pages-pageNum)<=2){
                this.navigateFirstPage=pages-4;
                this.navigateLastPage=pages;
            }else {
                this.navigateFirstPage=pageNum-2;
                this.navigateLastPage=pageNum+2;
            }
        }
    }


}
