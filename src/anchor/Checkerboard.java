/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anchor;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author benjavichahotrabhavananda
 */
public class Checkerboard extends Anchor {
    //Fields
    private Color lightColor, darkColor;
    private GridPane gridPane;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        super(numRows, numCols, boardWidth, boardHeight);
        // Set Default color if the user doesn't choose one.
        this.lightColor = Color.RED;
        this.darkColor  = Color.BLACK;
        
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        super(numRows, numCols, boardWidth, boardHeight);
        // Set the colors from the user
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    // Build the board UI and returns an AnchorPane as the root object
    @Override
    public AnchorPane build(double boardWidth, double boardHeight, int numRows, int numCols, Color lightColor, Color darkColor) {
        
        double offset = 55.0;
        boardHeight = boardHeight-offset;
        this.gridPane = new GridPane();
        
        // Build the board UI of AnchorPane
        super.build(boardWidth, boardHeight, numRows, numCols, lightColor, darkColor); 
        
        
        clearGridPane();
        clearAnchorPane();
        
        gridPane.setPrefWidth(boardWidth);
        gridPane.setPrefHeight(boardHeight);
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                
                Color currentColor;
                
                int ifEvenNum = (row + col) % 2;
                if (ifEvenNum == 0)
                    currentColor = lightColor;
                else 
                    currentColor = darkColor;
                
                Rectangle rect = new Rectangle(this.rectWidth, this.rectHeight, currentColor);
                
                gridPane.add(rect, row, col);
            }
        }    
        
        addGridPaneToAnchorPane();
        
        return root;
    }

    public void clearGridPane() { 
        gridPane.getChildren().clear();
    }
    
    public void clearAnchorPane() { 
        super.root.getChildren().clear();
    }
    
    public void addGridPaneToAnchorPane() {
        super.root.getChildren().add(gridPane);
    }
    
    public Color getLightColor() {
        return this.lightColor; 
    }
    
    public Color getDarkColor() {
        return this.darkColor;
    }
    
}
