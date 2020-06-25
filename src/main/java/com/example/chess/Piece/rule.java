package com.example.chess.Piece;

import com.google.gson.internal.$Gson$Types;

public class rule {
    private piece piece;
    private String hang;
    private String grid;
    public com.example.chess.Piece.piece getPiece() {
        return piece;
    }

    public void setPiece(com.example.chess.Piece.piece piece) {
        this.piece = piece;
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

    public rule(com.example.chess.Piece.piece piece, String hang, String grid) {
        this.piece = piece;
        this.hang = hang;
        this.grid = grid;
    }
    public boolean go(){
        if(this.piece.getText().equals("马")){
            if(Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))+Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==3&&Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))>=1&&Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))>=1){
                return true;
            }
            return false;
        }else if(this.piece.getText().equals("车")){
            if((Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))==0||Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==0)&&(Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))>0||Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))>0)){
                return true;
            }
            return false;
        }else if(this.piece.getText().equals("炮")){
            if((Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))==0||Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==0)&&(Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))>0||Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))>0)){
                return true;
            }
            return false;
        }else if(this.piece.getText().equals("象")||this.piece.getHang().equals("相")){
            if(Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))==2&&Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==2){
                return true;
            }
            return false;
        }else if(this.piece.getText().equals("士")){
            if(Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))==1&&Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==1){
                return true;
            }
            return false;
        }else if(this.piece.getText().equals("帅")||this.piece.getHang().equals("将")){
            if((Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))==1||Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==1)&&(Math.abs(Integer.parseInt(this.piece.getHang())+Integer.parseInt(this.hang))+Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==1)){
                return true;
            }
            return false;
        }else if(this.piece.getText().equals("兵")||this.piece.getHang().equals("卒")){
            if((Math.abs(Integer.parseInt(this.piece.getHang())-Integer.parseInt(this.hang))==1||Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==1)&&(Math.abs(Integer.parseInt(this.piece.getHang())+Integer.parseInt(this.hang))+Math.abs(Integer.parseInt(this.piece.getGrid())-Integer.parseInt(this.grid))==1)){
                return true;
            }
            return false;
        }
        return false;
    }
}
