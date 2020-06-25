package com.example.chess.Piece;

public class piece {
    private String text;
    private String hang;
    private String grid;
    private boolean color;
    private boolean number;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public boolean isNumber() {
        return number;
    }

    public void setNumber(boolean number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "piece{" +
                "name='" + text + '\'' +
                ", hang='" + hang + '\'' +
                ", grid='" + grid + '\'' +
                ", ranks=" + color +
                ", choice=" + number +
                '}';
    }
}
