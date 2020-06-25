package com.example.chess.Server;

import com.example.chess.Piece.piece;

import java.io.Serializable;
import java.util.List;

public class flowObject implements Serializable {
    private static final long serialVersionUID=55438L;
    private String type;
    private List<piece> pieces;
    public flowObject(){

    }
    public flowObject(String type,List<piece> pieces){
        this.type=type;
        this.pieces=pieces;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<piece> pieces) {
        this.pieces = pieces;
    }
}
