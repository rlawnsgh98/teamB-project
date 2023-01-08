package com.example.teamb_project.vo;

import java.sql.Date;

public class BoardVO {
    private int board_code, writer, readcnt, root, indent, step, lecture_code;
    private String title, content, category;
    private Date writedate;

    public void setBoard_code(int board_code) {
        this.board_code = board_code;
    }

    public void setWriter(int writer) {
        this.writer = writer;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setLecture_code(int lecture_code) {
        this.lecture_code = lecture_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWritedate(Date writedate) {
        this.writedate = writedate;
    }

    public int getBoard_code() {
        return board_code;
    }

    public int getWriter() {
        return writer;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public int getRoot() {
        return root;
    }

    public int getIndent() {
        return indent;
    }

    public int getStep() {
        return step;
    }

    public int getLecture_code() {
        return lecture_code;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public Date getWritedate() {
        return writedate;
    }
}
