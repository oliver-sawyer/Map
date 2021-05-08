package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Initializable {
    @FXML
    ImageView map;
    @FXML
    TextField addressField;
    @FXML
    Slider zoomSlider;
    @FXML
    WebView webMap;
    @FXML
    ComboBox mapType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapType.getItems().addAll("satellite","hybrid","map","dark");
        webMap.getEngine().loadContent(MapUtil.getMapHtml(44.3836,-89.8173,(int)zoomSlider.getValue(),"map"));

    }

    @FXML
    public void address() {
        try {

            webMap.getEngine().loadContent(MapUtil.getMapHtml(44.3836,-89.8173,(int)zoomSlider.getValue(),(String) mapType.getValue()));


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
