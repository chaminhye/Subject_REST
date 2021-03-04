package com.example.idus.config.common;

public class Paging {
    private int perPageNum;     // 페이지당 보여줄 게시글 수

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int perPageNum) {

        if(perPageNum <= 0 || perPageNum > 10000) {
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }
}