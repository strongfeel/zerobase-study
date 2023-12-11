package com.example.zerobasestudy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;


public class WifiInfo {
    static final String KEY = "756f787775736b7037376943465354";
    static int TOTALCNT;

    public static int TotalCnt() throws ParseException {
        URL url = null;
        HttpURLConnection con= null;
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        int start = 1;
        int end = 1;
        String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                "json/TbPublicWifiInfo/"+ start + "/"+end+"/";

        try {
            url = new URL(baseUrl);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("Content-type", "application/json");

            con.setDoOutput(true);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            while(br.ready()) {
                sb.append(br.readLine());
            }
            con.disconnect();
        }catch(Exception e) {
            e.printStackTrace();
        }

        result = (JSONObject) new JSONParser().parse(sb.toString());

        StringBuilder out = new StringBuilder();

        JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
        int totalGet = Integer.parseInt( data.get("list_total_count").toString());

        return totalGet;
    }

    public static int AddWifi() throws ParseException{
        int start = 0;
        int end = 0;
        int total = 0;

        TOTALCNT = TotalCnt();
        int pageEnd = TOTALCNT / 1000;
        int pageEndRemain = TOTALCNT % 1000;

        for (int k = 0; k <= pageEnd; k++) {
            start = (int) Math.pow(10, 3) * k + 1;

            if(k == pageEnd){
                end = start + pageEndRemain - 1;
            }
            else{
                end = (int) Math.pow(10, 3) * (k+1) ;
            }

            String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                    "json/TbPublicWifiInfo/";

            baseUrl = baseUrl + start + "/" + end + "/";

            URL url = null;
            HttpURLConnection con= null;
            JSONObject result = null;
            StringBuilder sb = new StringBuilder();


            try {
                url = new URL(baseUrl);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-type", "application/json");
                con.setDoOutput(true);


                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                while(br.ready()) {
                    sb.append(br.readLine());
                }
                con.disconnect();
            }catch(Exception e) {
                e.printStackTrace();
            }

            result = (JSONObject) new JSONParser().parse(sb.toString());

            JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
            JSONArray array = (JSONArray) data.get("row");

            WifiDto wifiDto = new WifiDto();

            for(int i = 0; i<array.size(); i++) {
                JSONObject tmp = (JSONObject) array.get(i);
                System.out.println((String) result.get("X_SWIFI_MGR_NO"));// 가져오고자 하는 인자를 작성하면 됨.

                tmp.get("X_SWIFI_MGR_NO").toString();
                tmp.get("X_SWIFI_WRDOFC").toString();
                tmp.get("X_SWIFI_MAIN_NM").toString();
                tmp.get("X_SWIFI_ADRES1").toString();
                tmp.get("X_SWIFI_ADRES2").toString();
                tmp.get("X_SWIFI_INSTL_FLOOR").toString();
                tmp.get("X_SWIFI_INSTL_TY").toString();
                tmp.get("X_SWIFI_INSTL_MBY").toString();
                tmp.get("X_SWIFI_SVC_SE").toString();
                tmp.get("X_SWIFI_CMCWR").toString();
                tmp.get("X_SWIFI_CNSTC_YEAR").toString();
                tmp.get("X_SWIFI_INOUT_DOOR").toString();
                tmp.get("X_SWIFI_REMARS3").toString();
                tmp.get("LAT").toString();
                tmp.get("LNT").toString();
                tmp.get("WORK_DTTM").toString();
                total++;
            }
        }
        return total;
    }
}
