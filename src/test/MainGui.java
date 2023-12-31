/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Cyrine
 */
public class MainGui extends Application {

    
    /* public void start(Stage stage) throws Exception {
         Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
                "/views/crudGUI.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Game Nation");
        stage.show();
        
    }*/
    @Override
    public void start(Stage primaryStage) throws IOException {
     /*
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/Affichearticle.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UTILITY);
            primaryStage.show();
            // primaryStage.setTitle("Game Nation");
        } catch (IOException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        } */

             try {
            Parent parent = FXMLLoader.load(getClass().getResource("/views/Commande.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UTILITY);
            primaryStage.show();
            // primaryStage.setTitle("Game Nation");
        } catch (IOException ex) {
            Logger.getLogger(MainGui.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}

