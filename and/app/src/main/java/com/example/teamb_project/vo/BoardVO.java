package com.example.teamb_project.vo;

import java.util.List;

import retrofit2.http.HEAD;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BoardVO {
    private int board_code, writer, readcnt, root, indent, step, lecture_code, no;
    private String title, content, category, member_name;
    private Date writedate;
    private List<BoardFileVO> fileList;

    public int getBoard_code() {
        return board_code;
    }

    public void setBoard_code(int board_code) {
        this.board_code = board_code;
    }

    public int getWriter() {
        return writer;
    }

    public void setWriter(int writer) {
        this.writer = writer;
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

    public int getIndent() {
        return indent;
    }

    public void setIndent(int indent) {
        this.indent = indent;
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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public Date getWritedate() {
        return writedate;
    }

    public void setWritedate(Date writedate) {
        this.writedate = writedate;
    }

    public List<BoardFileVO> getFileList() {
        return fileList;
    }

    public void setFileList(List<BoardFileVO> fileList) {
        this.fileList = fileList;
    }
}
