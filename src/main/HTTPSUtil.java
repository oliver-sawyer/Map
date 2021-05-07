package main;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPSUtil {
    private static final String KEY = "8EJ8bp8k7ASlJ0KvS1eyOYEjkrSClB9t";

    public static Image getStaticMap(String address) throws IOException {
        HttpsURLConnection connection = (HttpsURLConnection) buildConnectionURL(address).openConnection();
        connection.setRequestMethod("GET");

        BufferedImage image = ImageIO.read(connection.getInputStream());
        int status = connection.getResponseCode();
        System.out.println(status);
        return SwingFXUtils.toFXImage(image, null);
    }

    private static URL buildConnectionURL(String address) {
        try {
            URL url =  new URL("https://www.mapquestapi.com/staticmap/v5/map?key=" + KEY + "&center=" + address + "&size=1200,800@2x");
            System.out.println(url.getHost());
            return url;
        } catch(MalformedURLException e) {
            System.err.println("Incorrecte URL");
            return null;
        }
    }
}
