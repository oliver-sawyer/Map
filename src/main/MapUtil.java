package main;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MapUtil {
    private static final String KEY = "8EJ8bp8k7ASlJ0KvS1eyOYEjkrSClB9t";

    public static Image getStaticMap(double lat, double lon) throws IOException {
        HttpsURLConnection connection = establishConnection(buildConnectionURL(lat, lon));
        BufferedImage image = ImageIO.read(connection.getInputStream());
        int status = connection.getResponseCode();
        System.out.println(status);
        return SwingFXUtils.toFXImage(image, null);
    }

    private static URL buildConnectionURL(double lon, double lat) {
        try {
            URL url =  new URL("https://www.mapquestapi.com/staticmap/v5/map?key=" + KEY + "&center=" + lon +","+lat+ "&size=1200,800@2x");
            System.out.println(url.getHost());
            return url;
        } catch(MalformedURLException e) {
            System.err.println("Incorrect URL");
            return null;
        }
    }
    public static Image getStaticMap(double lat, double lon, double zoom) throws IOException {
        HttpsURLConnection connection = establishConnection(buildConnectionURL(lat, lon, zoom));
        BufferedImage image = ImageIO.read(connection.getInputStream());
        int status = connection.getResponseCode();
        System.out.println(status);
        return SwingFXUtils.toFXImage(image, null);
    }

    private static URL buildConnectionURL(double lon, double lat, double zoom) {
        try {
            int intZoom = (int)zoom;
            URL url =  new URL("https://www.mapquestapi.com/staticmap/v5/map?key=" + KEY + "&center=" + lon +","+lat+"&zoom="+intZoom+ "&size=1200,800@2x");
            System.out.println(url.getHost());
            return url;
        } catch(MalformedURLException e) {
            System.err.println("Incorrect URL");
            return null;
        }
    }

    private static HttpsURLConnection establishConnection(URL url) throws IOException {
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

}
