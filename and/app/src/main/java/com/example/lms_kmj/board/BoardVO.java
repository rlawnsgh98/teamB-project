package com.example.lms_kmj.board;

import java.sql.Date;

public class BoardVO {
    private String board_code, title, content
            ,writer,readcnt,category
            ,root,indent,step,lecture_code;
    private Date writedate;

    public String getBoard_code() {
        return board_code;
    }

    public void setBoard_code(String board_code) {
        this.board_code = board_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWritedate() {
        return writedate;
    }

    public void setWritedate(Date writedate) {
        this.writedate = writedate;
    }

    public String getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(String readcnt) {
        this.readcnt = readcnt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getIndent() {
        return indent;
    }

    public void setIndent(String indent) {
        this.indent = indent;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getLecture_code() {
        return lecture_code;
    }

    public void setLecture_code(String lecture_code) {
        this.lecture_code = lecture_code;
    }
}
