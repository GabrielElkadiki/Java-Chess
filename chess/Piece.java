/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author GabrielElkadiki
 */
public class Piece {
    
    private ChessColour colour;
    private ChessPieces name;
    private char shortName;
    private String imageName;
        
    protected Piece(ChessColour colour, ChessPieces name)
    {
        this.colour = colour;
        this.name = name;
        this.shortName = name.getShortName();
        if (colour == ChessColour.BLACK) this.shortName = Character.toLowerCase(this.shortName);    
        
        imageName = "" + colour + "_" + name + ".png";
        imageName = imageName.toLowerCase();
    }
    public ChessColour getColour() { return this.colour; }
    public ChessPieces getName() { return this.name; }
    public char getShortName() { return this.shortName; }
    public String getImageName() { return this.imageName; }
    
    public String toString() { return colour + " " + name; }
    
    public boolean isLegalMove(ChessBoard board,  Coordinate src, Coordinate dest){
        Piece movingPiece = board.getSquare(src).getPiece();        
        Piece takenPiece = board.getSquare(dest).getPiece();
        if ((takenPiece!=null) && (takenPiece.getColour().equals(this.colour))) return false;
        return true;     
       
        
    }
    
}
