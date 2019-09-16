package Riot;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
//TODO download data from Riot in a JSON format instead of just a string
public class Download {
    private URL riot;
    private String apiKey;
    private String fullUrl;

    Download(String request, String apiKey) throws Exception{
        this.fullUrl = request.concat(apiKey);
        this.riot = new URL(fullUrl);
        BufferedReader in = new BufferedReader((new InputStreamReader(riot.openStream())));

        //takes the integer value of a character, typecasts it to a char, adds it to the string
        String targetString = "";
        int value;
        while(((value = in.read()) != -1)){
            targetString += (char) value;
        }
        //splits targetString into tokens for easier viewing
        String[] tokens = targetString.split(",");
        for(int i = 0; i < tokens.length; i++){
            System.out.println(tokens[i]);
            System.out.println("\n");
        }

        in.close();
    }

    public static void main(String[] args) throws Exception {

        Download greysonj = new Download("https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/greysonj?api_key=", "RGAPI-04365ea3-4989-467b-ae4f-1314c6a23913");

    }


}
