package com.example.harmonicahelp;
class Note {
    public static Note[] values = {
            new Note("G", "1"), new Note("Ab", "-1'"), new Note("A", "-1"), new Note("Bb", "1*"),
            new Note("B", "2"), new Note("C", "-2''"), new Note("C#", "-2'"), new Note("D", "-2"),
            new Note("Eb", "-3'''"), new Note("E", "-3''"), new Note("F", "-3'"), new Note("F#", "-3"),
            new Note("G", "4"), new Note("Ab", "-4'"), new Note("A", "-4"), new Note("Bb", "4*"),
            new Note("B", "5"), new Note("C", "-5"), new Note("C#", "5*"), new Note("D", "6"),
            new Note("Eb", "-6'"), new Note("E", "-6"), new Note("F", "6*"), new Note("F#", "-7"),
            new Note("G", "7"), new Note("Ab", "-7*"), new Note("A", "-8"), new Note("Bb", "8'"),
            new Note("B", "8"), new Note("C", "-9"), new Note("C#", "9'"), new Note("D", "9"),
            new Note("Eb", "-9*"), new Note("E", "-10"), new Note("F", "10''"), new Note("F#", "10'"),
            new Note("G", "10"), new Note("Ab", "10*"), new Note("A", ""), new Note("Bb", ""),
            new Note("B", ""), new Note("C", ""), new Note("C#", ""), new Note("D", ""), new Note("Eb", ""),
            new Note("E", ""), new Note("F", ""), new Note("F#", ""), new Note("G", "")};

    private String nota;
    private String tab;


    Note(String nota, String tab) {
        this.nota = nota;
        this.tab = tab;
    }

    public String getNota() {
        return nota;
    }

    public String getTab() {
        return tab;
    }
}
