/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package views;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
import service.ServiceArticle;
import models.Article;
import org.controlsfx.control.Notifications;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Cyrine
 */
public class AffichearticleController implements Initializable {

    @FXML
    private TableView<Article> Table;
    @FXML
    private TableColumn<Article, String> titre_colonne;
    @FXML
    private TableColumn<Article, String> image_colonne;
    @FXML
    private TableColumn<Article, String> description_colonne;
    @FXML
    private TableColumn<Article, String> prix_colonne;
    @FXML
    private TextField TFTitre;
    @FXML
    private TextField TFImage;
    @FXML
    private TextField TFDesc;
    @FXML
    private TextField TFPrix;
    @FXML
    private Button btn;
  ObservableList<Article>  list =  FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        ObservableList<Article>  list =  FXCollections.observableArrayList();
          try { 
            Connection cnx = DataSource.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT titre_article, image, description_article, prix FROM article");
            while(rs.next())
            {
                list.add(new Article(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffichearticleController.class.getName()).log(Level.SEVERE, null, ex);
        }

       titre_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().gettitre_article());
        });
    //image_colonne.setCellValueFactory(new PropertyValueFactory<>("image"));
image_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().getimage());
        });
    description_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().getdescription_article());
        });
    prix_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().getprix());
        });
     
  
        // TODO
 Table.setItems(list);
  Table.refresh();
    }    

    @FXML
    private void getSele(MouseEvent event) {
         int index = Table.getSelectionModel().getSelectedIndex();
        if(index<= -1)
        {
            return;
        }
        TFTitre.setText(titre_colonne.getCellData(index).toString());
        TFImage.setText(image_colonne.getCellData(index).toString());
        TFDesc.setText(description_colonne.getCellData(index).toString());
        TFPrix.setText(prix_colonne.getCellData(index).toString());
    }

    @FXML
    private void Ajouterarticle(ActionEvent event) {   
      
       ServiceArticle sp = new ServiceArticle();
       sp.ajouter(new Article(TFTitre.getText(),TFImage.getText(),TFDesc.getText(),TFPrix.getText()));
       Table.refresh();
        Notifications notifications=Notifications.create();
        notifications.text("Ajouté");
        notifications.title("Success Message");
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();

    }

   @FXML
    private void supprimerArticle(ActionEvent event) {
         ServiceArticle sp = new ServiceArticle();
        sp.supprimer(new Article(TFTitre.getText()));
        // JOptionPane.showMessageDialog(null, "Article supprimé !");
        Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem());
          Table.refresh();
             Notifications notifications=Notifications.create();
        notifications.text("supprimé");
        notifications.title("Success Message");
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
    }


    @FXML
    private void modifierArticle(ActionEvent event) {
    
      ServiceArticle sp = new ServiceArticle();
        sp.modifier(new Article(TFTitre.getText(),TFImage.getText(),TFDesc.getText(),TFPrix.getText()));
    Table.refresh();
       Notifications notifications=Notifications.create();
        notifications.text("modifié");
        notifications.title("Success Message");
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
        //JOptionPane.showMessageDialog(null, "Article Modifier !");

    }



    @FXML
    private void upload(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String imageFile = "";
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.getAbsolutePath();
            TFImage.setText(imageFile);
            
        }
    }

    @FXML
    private void refresh(ActionEvent event) {
          // ImageView image1 = new ImageView (new Image(this.getClass().getResourceAsStream("")));  
           ObservableList<Article>  list =  FXCollections.observableArrayList();
          try { 
            Connection cnx = DataSource.getInstance().getCnx();
            ResultSet rs = cnx.createStatement().executeQuery("SELECT titre_article, image, description_article, prix FROM article");
            while(rs.next())
            {
                list.add(new Article(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffichearticleController.class.getName()).log(Level.SEVERE, null, ex);
        }

       titre_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().gettitre_article());
        });

       image_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().getimage());
        }); 
   description_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().getdescription_article());
        });

    prix_colonne.setCellValueFactory(data ->
        {
            return new ReadOnlyStringWrapper(data.getValue().getprix());
        });
         
        // TODO
 Table.setItems(list);
  Table.refresh();
    }

    
}
