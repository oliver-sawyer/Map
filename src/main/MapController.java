package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {
    @FXML
    ImageView map;
    @FXML
    TextField addressField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void address() {
        try {
            map.setImage(MapUtil.getStaticMap(addressField.getText()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
