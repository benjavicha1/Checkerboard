/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author benjavichahotrabhavananda
 */
public class FXMLCheckerboardController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8;
    private int numCols = 8;
    
    private Color[] colors = {Color.RED, Color.BLACK, Color.SKYBLUE, Color.DARKBLUE};
    
    private Color lightColor = colors[0];
    private Color darkColor  = colors[1];
    
    private anchor.Checkerboard checkerboard;
    
    @FXML
    private VBox vBox; 

    @FXML
    private void handleMenuItemGrid16X16Action(ActionEvent event) {
        this.numRows = 16;
        this.numCols = 16;
        refresh();
    }
    
    @FXML
    private void handleMenuItemGrid10X10Action(ActionEvent event) {
        this.numRows = 10;
        this.numCols = 10;
        refresh();
    }
    
    @FXML
    private void handleMenuItemGrid8X8Action(ActionEvent event) {
        this.numRows = 8;
        this.numCols = 8;
        refresh();
    }
    
    @FXML
    private void handleMenuItemGrid3X3Action(ActionEvent event) {
        this.numRows = 3;
        this.numCols = 3;
        refresh();
    }
    
    @FXML
    private void handleMenuItemDefaultColorSchemeAction(ActionEvent event) {
        this.lightColor = colors[0];
        this.darkColor  = colors[1];
        refresh();
    }
    
    @FXML
    private void handleMenuItemBlueColorSchemeAction(ActionEvent event) {
        this.lightColor = colors[2];
        this.darkColor  = colors[3];
        refresh();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}   
     
    @Override
    public void start(Stage stage) {
        this.stage = stage;

        checkerboard = new anchor.Checkerboard(this.numRows, this.numCols, stage.getWidth(), stage.getHeight());
        checkerboard.build(stage.getWidth(), stage.getHeight(), 
                this.numRows, this.numCols, this.lightColor, this.darkColor);
        vBox.getChildren().add(checkerboard.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
        
    private void refresh() {
        //Call new Checkerboard
        checkerboard.build(stage.getWidth(), stage.getHeight(), 
                           this.numRows, this.numCols, this.lightColor, this.darkColor);
    }
}
