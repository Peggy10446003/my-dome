package com.example.alex.viewpagertest1;

/**
 * Created by alex on 2018/5/10.
 */

public class Word {
    int id;
    String title;
    String chinese;
    String context;
    String theme;

    public Word(int id,String title,String chinese ,String context,String theme) {
        this.id = id;
        this.title = title;
        this.chinese = chinese;
        this.context = context;
        this.theme = theme;
    }

    public Word(int id, String title, String chinese, String context) {
        this.id = id;
        this.title = title;
        this.chinese = chinese;
        this.context = context;
    }

    public int getid(){ return id; }
    public String getTitle() {
        return title;
    }


    public String getContext() {
        return context;
    }

    public String getChinese() { return chinese; }
    public String gettheme() { return theme; }
}
