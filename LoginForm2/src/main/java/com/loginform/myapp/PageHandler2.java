package com.loginform.myapp;

import java.util.Objects;

public class PageHandler2 {

  private int navSize = 10; // 내비게이션 크기
  private int totalCnt; // 총 게시물 갯수
  private Integer page; // 현재 페이지
  private Integer pageSize; // 페이지 크기
  private int totalPage; // 총 페이지 갯수
  private int beginPage; // 제일 첫번쨰 페이지
  private int endPage; // 제일 마지막 페이지
  private boolean prevPage; // 이전페이지로 이동할수있는지
  private boolean nextPage; // 다음페이지로 이동할수있는지
  public PageHandler2(){} // 기본 생성자

  public PageHandler2(Integer totalCnt, Integer page) {
      this(totalCnt,page,10);
  }

  public PageHandler2(Integer totalCnt, Integer page, Integer pageSize) {
      this.totalCnt = totalCnt;
      this.page = page;
      this.pageSize = pageSize;

      this.totalPage = (totalCnt / pageSize) + (((totalCnt % pageSize) > 0) ? 1 : 0); // 총 페이지 갯수
      System.out.println("총 페이지 수 : " + this.totalPage);
      this.beginPage = 1;
      this.endPage = totalPage;
  }
  
  void print() {
      System.out.println("page = " + page);
      System.out.println(prevPage ? "[PREV]":"");
      for(int i = beginPage; i<=endPage; i++) {
          System.out.println(i+" ");
      }
      System.out.println(nextPage ? "[NEXT]":"");
  }


  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      PageHandler2 that = (PageHandler2) o;
      return totalCnt == that.totalCnt && page == that.page && pageSize == that.pageSize;
  }

  @Override
  public int hashCode() {
      return Objects.hash(totalCnt, page, pageSize);
  }

  @Override
  public String toString() {
      return "PageHandler{" +
              "navSize=" + navSize +
              ", totalCnt=" + totalCnt +
              ", page ="+page+
              ", pageSize ="+pageSize+
              ", totalPage=" + totalPage +
              ", beginPage=" + beginPage +
              ", endPage=" + endPage +
              ", prevPage=" + prevPage +
              ", nextPage=" + nextPage +
              '}';
  }

  public int getNavSize() {
      return navSize;
  }

  public void setNavSize(int navSize) {
      this.navSize = navSize;
  }

  public int getTotalCnt() {
      return totalCnt;
  }

  public void setTotalCnt(int totalCnt) {
      this.totalCnt = totalCnt;
  }

  public Integer getPage() {
      return page;
  }

  public void setPage(Integer page) {
      this.page = page;
  }

  public Integer getPageSize() {
      return pageSize;
  }

  public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
  }

  public int getTotalPage() {
      return totalPage;
  }

  public void setTotalPage(int totalPage) {
      this.totalPage = totalPage;
  }

  public int getBeginPage() {
      return beginPage;
  }

  public void setBeginPage(int beginPage) {
      this.beginPage = beginPage;
  }

  public int getEndPage() {
      return endPage;
  }

  public void setEndPage(int endPage) {
      this.endPage = endPage;
  }

  public boolean isPrevPage() {
      return prevPage;
  }

  public void setPrevPage(boolean prevPage) {
      this.prevPage = prevPage;
  }

  public boolean isNextPage() {
      return nextPage;
  }

  public void setNextPage(boolean nextPage) {
      this.nextPage = nextPage;
  }
}
