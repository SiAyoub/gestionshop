/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import javafx.scene.image.ImageView;

/**
 *
 * @author Cyrine
 */
public class Article {
    private int id_article;
    private String titre_article;
    private String image;
    private String description_article;
    private String prix;
 
    
    public Article(int id_article, String titre_article, String image, String description_article, String prix){
        this.id_article=id_article;
        this.titre_article=titre_article;
        this.image=image;
        this.description_article=description_article;
        this.prix=prix;
 
    }
      public Article(String titre_article){
       
        this.titre_article=titre_article;
       
 
    }
    public Article(String titre_article, String image, String description_article, String prix){
        this.titre_article=titre_article;
        this.image=image;
        this.description_article=description_article;
        this.prix=prix;
      
    } 
    public int getid_article() {
        return id_article;
    }

    public void setid_article(int id_article) {
        this.id_article = id_article;
    }
    public String gettitre_article() {
        return titre_article;
    }

    public void settitre_article(String titre_article) {
        this.titre_article = titre_article;
    }
    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }
    public String getdescription_article() {
        return description_article;
    }

    public void setdescription_article(String description_article) {
        this.description_article = description_article;
    }
    public String getprix() {
        return prix;
    }

    public void setprix(String prix) {
        this.prix = prix;
    }

 
     @Override
    public String toString() {
        return "Article{" + "id_article=" + id_article + ", titre_article=" + titre_article + ", image=" + image + ", description_article=" + description_article + ", prix=" + prix + '}';
    }
}   
