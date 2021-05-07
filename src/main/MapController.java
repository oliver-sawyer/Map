package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {
    @FXML
    ImageView map;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            map.setImage(HTTPSUtil.getStaticMap("Milwaukee,WI"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
