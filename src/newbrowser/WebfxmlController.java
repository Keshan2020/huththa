/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newbrowser;

import java.awt.Button;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Shawon
 */
public class WebfxmlController implements Initializable {
    @FXML
    private TextField txt;
    @FXML
    private Button bt;
    @FXML
    private AnchorPane anc; 
    @FXML
    private WebView webView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        WebEngine we=webView.getEngine();
        we.setJavaScriptEnabled(true);
        
        EventHandler<ActionEvent> enter= new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                we.load(txt.getText().startsWith("http://")?txt.getText():"http://"+txt.getText());
                
            }
        };
        txt.setOnAction(enter);
        bt.setOnAction(enter);
      
        we.locationProperty().addListener(new ChangeListener<String>() {
                @Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    txt.setText(newValue);
                }
            });
       
                
    }    

    @FXML
    private void handle(ActionEvent event) {
        
        //txt.setText("Webview");
    }

    }    
    
