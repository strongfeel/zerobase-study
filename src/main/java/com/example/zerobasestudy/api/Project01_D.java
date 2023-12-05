package com.example.zerobasestudy.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Project01_D {
    public static void main(String[] args) {

        String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
        String clientId = "dovivev3og";
        String clientSecret = "UeEubRdDzB8SB0GyCrBwMvyjQN1fhZDxmI6gW4h3";
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("주소를 입력해주세요:");
            String address = io.readLine();
            String addr = URLEncoder.encode(address, "UTF-8");
            String reqUrl = apiURL + addr;

            URL url = new URL(reqUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            BufferedReader br;
            int responseCode = con.getResponseCode(); //200
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            }else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String line;
            StringBuffer response = new StringBuffer(); //Json
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            JSONTokener tokener = new JSONTokener(response.toString());
            JSONObject object = new JSONObject(tokener);
            System.out.println(object.toString(2));

            JSONArray arr = object.getJSONArray("addresses");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject temp = (JSONObject) arr.get(i);
                System.out.println("address: " + temp.get("roadAddress"));
                System.out.println("jibunAddress: " + temp.get("jibunAddress"));
                System.out.println("경도: " + temp.get("x"));
                System.out.println("위도: " + temp.get("y"));
            }

        }   catch (Exception e) {
            e.printStackTrace();
        }


    }
}
