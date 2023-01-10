package com.example.teamb_project.vo;

public class LectureBoardVO {

    private String title, content, writer, writedate, category;
    private int board_code, readcnt, root, step, lecture_code;

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

    public String getWritedate() {
        return writedate;
    }

    public void setWritedate(String writedate) {
        this.writedate = writedate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBoard_code() {
        return board_code;
    }

    public void setBoard_code(int board_code) {
        this.board_code = board_code;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getLecture_code() {
        return lecture_code;
    }

    public void setLecture_code(int lecture_code) {
        this.lecture_code = lecture_code;
    }
}
