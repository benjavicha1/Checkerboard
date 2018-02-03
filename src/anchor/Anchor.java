/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anchor;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author benjavichahotrabhavananda
 */
public class Anchor {
    protected int numRows;
    protected int numCols;
    
    protected double boardWidth;
    protected double boardHeight;
    
    protected double rectWidth;
    protected double rectHeight;
    
    protected AnchorPane root;
    
    public Anchor(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows     = numRows;
        this.numCols     = numCols;
        
        this.boardWidth  = boardWidth;
        this.boardHeight = boardHeight;

        root = new AnchorPane();
    }
    
    // Build the board UI
    public AnchorPane build(double boardWidth, double boardHeight, int numRows, int numCols, Color lightColor, Color darkColor) {
       
       this.boardWidth = boardWidth;
       this.boardHeight = boardHeight;
       
       rectWidth = Math.ceil(boardWidth / (double)numCols);
       rectHeight = Math.ceil(boardHeight / (double)numRows);
       
       root.setPrefWidth(boardWidth);
       root.setPrefHeight(boardHeight);

       return this.root;
    }
    
    // Return the AnchorPane pane
    public AnchorPane getBoard() {
        if (this.root != null) 
            return this.root;
        return null;
    }
    
    public int getNumRows() {
        return this.numRows;
    }
    
    public int getNumCols() {
        return this.numCols;
    }
    
    public double getWidth() {
        return this.boardWidth;
    }
    
    public double getHeight() {
        return this.boardHeight;
    }
    
    public double getRectWidth() {
        return this.rectWidth;
    }
    
    public double getRectHeight() {
        return this.rectHeight;
    }
}
