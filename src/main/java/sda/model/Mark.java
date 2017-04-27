package sda.model;

public enum Mark {
    TIC('O'), TOE('X');

    private Character charMark;

    Mark(char charMark) {
        this.charMark = charMark;
    }

    public char getCharMark() {
        return charMark;
    }

    @Override
    public String toString() {
        return charMark.toString();
    }
}
