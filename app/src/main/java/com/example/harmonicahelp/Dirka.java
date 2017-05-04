package com.example.harmonicahelp;
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
