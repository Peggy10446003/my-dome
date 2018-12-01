package com.example.alex.viewpagertest1;

/**
 * Created by alex on 2018/7/11.
 */

public class Theme {
    private Integer _id;
    private String theme;
    private String catalog;

    public Theme() {
    }


    public Theme(Integer _id, String theme, String catalog) {
        this._id = _id;
        this.theme = theme;
        this.catalog = catalog;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
}
