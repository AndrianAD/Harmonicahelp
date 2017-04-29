package com.example.harmonicahelp;

/**
 * Created by Андриан on 26.04.2017.
 */

public class Dirka {
    private String note;
    private String tabs;

    public Dirka(Note note, Note tabs) {
        this.tabs = tabs.getTab();
        this.note = note.getNota();
    }


    public String getNote() {
        return note;
    }

    public String getTabs() {
        return tabs;
    }


}
