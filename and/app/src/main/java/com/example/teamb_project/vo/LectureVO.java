package com.example.teamb_project.vo;

import java.io.Serializable;

public class LectureVO implements Serializable {
    private int lecture_code;
    private int teacher_code;
    private int timetable_code;

    public int getStudent_cnt() {
        return student_cnt;
    }

    public void setStudent_cnt(int student_cnt) {
        this.student_cnt = student_cnt;
    }

    private int student_cnt;
    private String lecture_name, room_code, subject_code,startdate, enddate;

    public String getTimetable_name() {
        return timetable_name;
    }

    public void setTimetable_name(String timetable_name) {
        this.timetable_name = timetable_name;
    }

    //timetable 조인
    private String timetable_name;

    public String getLecture_name() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name = lecture_name;
    }

    public int getLecture_code() {
        return lecture_code;
    }
    public void setLecture_code(int lecture_code) {
        this.lecture_code = lecture_code;
    }
    public int getTeacher_code() {
        return teacher_code;
    }
    public void setTeacher_code(int teacher_code) {
        this.teacher_code = teacher_code;
    }
    public int getTimetable_code() {
        return timetable_code;
    }
    public void setTimetable_code(int timetable_code) {
        this.timetable_code = timetable_code;
    }
    public String getRoom_code() {
        return room_code;
    }
    public void setRoom_code(String room_code) {
        this.room_code = room_code;
    }
    public String getSubject_code() {
        return subject_code;
    }
    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }
    public String getStartdate() {
        return startdate;
    }
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    public String getEnddate() {
        return enddate;
    }
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}
