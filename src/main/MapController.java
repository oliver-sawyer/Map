package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //System.out.println(mapDoc.getMember("map"));
    }

    @FXML
    public void address() {
        try {
            //map.setImage(MapUtil.getStaticMap(addressField.getText(), zoomSlider.getValue()));
            webMap.getEngine().loadContent(MapUtil.getMapHtml(90,90,(int)zoomSlider.getValue()));
            JSObject mapDoc = (JSObject) webMap.getEngine().getDocument();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
