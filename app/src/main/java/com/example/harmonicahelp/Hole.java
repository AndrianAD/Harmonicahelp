package com.example.harmonicahelp;

public class Hole {
    private String note;
    private String tabs;

    public Hole(Note note, Note tabs) {
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
