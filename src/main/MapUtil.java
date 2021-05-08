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

    public static Image getStaticMap(String address) throws IOException {
        HttpsURLConnection connection = HTTPSUtil.establishConnection(buildConnectionURL(address));
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
            System.err.println("Incorrect URL");
            return null;
        }
    }
    public static Image getStaticMap(String address, double zoom) throws IOException {
        HttpsURLConnection connection = HTTPSUtil.establishConnection(buildConnectionURL(address, zoom));
        BufferedImage image = ImageIO.read(connection.getInputStream());
        int status = connection.getResponseCode();
        System.out.println(status);
        return SwingFXUtils.toFXImage(image, null);
    }

    private static URL buildConnectionURL(String address, double zoom) {
        try {
            int intZoom = (int)zoom;
            URL url =  new URL("https://www.mapquestapi.com/staticmap/v5/map?key=" + KEY + "&center=" + address +"&zoom="+intZoom+ "&size=1200,800@2x");
            System.out.println(url.getHost());
            return url;
        } catch(MalformedURLException e) {
            System.err.println("Incorrect URL");
            return null;
        }
    }
    public static String getMapHtml(double lat, double lng,int zoom,String mapType){
        return "<html>\n" +
                "  <head>\n" +
                "    <script src=\"https://api.mqcdn.com/sdk/mapquest-js/v1.3.2/mapquest.js\"></script>\n" +
                "    <link type=\"text/css\" rel=\"stylesheet\" href=\"https://api.mqcdn.com/sdk/mapquest-js/v1.3.2/mapquest.css\"/>\n" +
                "\n" +
                "    <script type=\"text/javascript\">\n" +
                "      window.onload = function() {\n" +
                "        L.mapquest.key = 'lYrP4vF3Uk5zgTiGGuEzQGwGIVDGuy24';\n" +
                "\n" +
                "        var map = L.mapquest.map('map', {" +
                "          center: ["+lat+", "+lng+"],\n" +
                "          layers: L.mapquest.tileLayer('"+mapType+"'),\n" +
                "          zoom: "+zoom+"\n" +
                "        });\n" +
                "\n" +
                "        map.addControl(L.mapquest.control());\n" +
                "      }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "\n" +
                "  <body style=\"border: 0; margin: 0;\">\n" +
                "    <div id=\"map\" style=\"width: 100%; height: 530px;\"></div>\n" +
                "  </body>\n" +
                "</html>";
    }
}
