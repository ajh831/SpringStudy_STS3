package com.loginform.myapp;

import junit.framework.TestCase;
import org.junit.Test;

public class PageHandlerTest extends TestCase {
    @Test
    public void testPageHandler() throws Exception {
        PageHandler ph = new PageHandler(152, 11, 10);
        System.out.println("ph : " + ph);
        System.out.println(ph);
    }
    @Test
    public void testPageHandlerTotalCnt192738() throws Exception {
        PageHandler ph = new PageHandler(192738, 14, 10);
        System.out.println("ph : " + ph);
        System.out.println(ph);
    }
    @Test
    public void testEndPageSize() throws Exception {
        PageHandler ph = new PageHandler(150, 3, 10);
        System.out.println("ph : " + ph);
        System.out.println(ph);
        //ph : PageHandler{startPage=11, endPage=10, totalCnt=0, totalPage=10, page=0, navSize=10, pageSize=0, prevPage=false, nextPage=false}
        // startPage가 endPage보다 커버림 이거 체크해야 됨
    }

}