package domain;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionTester {
    public Boolean TestConnection(){
        try{
            URL url = new URL("https://en.wikipedia.org/");
            URLConnection Urlconnection = url.openConnection();
            Urlconnection.connect();
            return true;
        }catch (IOException e) {
            return false;
        }
    }
}
