package com.example.demo1cookieclickerv2;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


public class ImageController {
    ArrayList<Image> coolImages = new ArrayList<>();
    int currentCoolImages;


    public ImageView coinImages;
    public ImageView CoinImagesv2;
    public ImageView CoinImagev3;
    public ImageView CoinImagev4;
    public ImageView CoinImagev5;

    @FXML
    public Accordion myAccordion; //

    @FXML
    public Button addButton; //

    public int paneCount = 0;

    @FXML
    public Button prevButton;

    @FXML
    public Button nextButton;


    Image GreyCoin;
    Image UnbreakableCoin;
    Image YellowCoin;
    Image Sansity;
    Image Lunacy;


    public void initialize() throws Exception {


        FileInputStream input = new FileInputStream("src/main/java/Grey-Coin.png");
        GreyCoin = new Image(input);
        coolImages.add(GreyCoin);

        input = new FileInputStream("src/main/java/Unbreakable.png");
        UnbreakableCoin = new Image(input);
        coolImages.add(UnbreakableCoin);

        input = new FileInputStream("src/main/java/images.jpeg");
        YellowCoin = new Image(input);
        coolImages.add(YellowCoin);

        input = new FileInputStream("src/main/java/sansity.jpeg");
        Sansity = new Image(input);
        coolImages.add(Sansity);

        input = new FileInputStream("src/main/java/Lunacy.jpeg");
        Lunacy = new Image(input);
        coolImages.add(Lunacy);

        currentCoolImages = 0;
        coinImages.setImage(coolImages.get(currentCoolImages));
        currentCoolImages = currentCoolImages + 1;
        CoinImagesv2.setImage(coolImages.get(currentCoolImages));
        currentCoolImages = currentCoolImages + 1;
        CoinImagev3.setImage(coolImages.get(currentCoolImages));
        currentCoolImages = currentCoolImages + 1;
        CoinImagev4.setImage(coolImages.get(currentCoolImages));
        currentCoolImages = currentCoolImages + 1;
        CoinImagev5.setImage(coolImages.get(currentCoolImages));


    }


    @FXML
    public void handleAddButtonAction() {
        AnchorPane content = new AnchorPane();
        content.getChildren().add(new Label("Content for Pane " + paneCount));
        ImageView newIV = new ImageView();

        // need a new Image

        content.getChildren().add(newIV);
        TitledPane newPane = new TitledPane("Title " + paneCount, content);
        myAccordion.getPanes().add(newPane);
        paneCount++; // Increment the counter

        FileChooser fileChooser = new FileChooser();
        // fileChooser.getExtensionFilters().addAll(
        //        new FileChooser.ExtensionFilter("Text Files", ".txt")
        //       ,new FileChooser.ExtensionFilter("HTML Files", ".htm")
        //      ,new FileChooser.ExtensionFilter("PNG Files", ".png")
        //        ,new FileChooser.ExtensionFilter("jpg File", ".jpeg")
        //);
        fileChooser.setTitle("Images that might work");
        //fileChooser.setInitialDirectory(new File("Do"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            System.out.println("Images that might work");
            System.out.println(selectedFile.getPath());
            Image image = new Image(selectedFile.toURI().toString());
            newIV.setImage(image);
        }


        prevButton.setOnAction(e -> {
            TitledPane currentExpandedPane = myAccordion.getExpandedPane();
            if (currentExpandedPane != null) {
                int currentIndex = myAccordion.getPanes().indexOf(currentExpandedPane);
                if (currentIndex > 0) {
                    myAccordion.setExpandedPane(myAccordion.getPanes().get(currentIndex - 1));
                }
            } else if (!myAccordion.getPanes().isEmpty()) {
                myAccordion.setExpandedPane(myAccordion.getPanes().get(myAccordion.getPanes().size() - 1));
            }
        });


    }


    {
        nextButton.setOnAction(e -> {
        TitledPane currentExpandedPane = myAccordion.getExpandedPane();
        if (currentExpandedPane != null) {
            int currentIndex = myAccordion.getPanes().indexOf(currentExpandedPane);
            if (currentIndex < myAccordion.getPanes().size() - 1) {
                myAccordion.setExpandedPane(myAccordion.getPanes().get(currentIndex + 1));
            }
        } else if (!myAccordion.getPanes().isEmpty()) {
            myAccordion.setExpandedPane(myAccordion.getPanes().get(0));
        }
        });

}
        }





