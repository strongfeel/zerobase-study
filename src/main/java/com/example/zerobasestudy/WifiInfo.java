package com.example.zerobasestudy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLNonTransientConnectionException;


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

    public static JSONObject AddWifi() throws ParseException, IOException {
        int start = 0;
        int end = 0;
        int total = 0;

        TOTALCNT = TotalCnt();
        int pageEnd = TOTALCNT / 1000;
        int pageEndRemain = TOTALCNT % 1000;

        JSONObject tmp = null;
        for (int k = 0; k <= pageEnd; k++) {
            start = (int) Math.pow(10, 3) * k + 1;

            if (k == pageEnd) {
                end = start + pageEndRemain - 1;
            } else {
                end = (int) Math.pow(10, 3) * (k + 1);
            }

            String baseUrl = "http://openapi.seoul.go.kr:8088/" + KEY + "/" +
                    "json/TbPublicWifiInfo/";

            baseUrl = baseUrl + start + "/" + end + "/";

            URL url = null;
            HttpURLConnection con = null;
            JSONObject result = null;
            StringBuilder sb = new StringBuilder();


            try {
                url = new URL(baseUrl);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-type", "application/json");
                con.setDoOutput(true);


                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                while (br.ready()) {
                    sb.append(br.readLine());
                }
                con.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }

            result = (JSONObject) new JSONParser().parse(sb.toString());

            JSONObject data = (JSONObject) result.get("TbPublicWifiInfo");
            JSONArray array = (JSONArray) data.get("row");

            for (int i = 0; i < array.size(); i++) {
                tmp = (JSONObject) array.get(i);
                System.out.println((String) result.get("X_SWIFI_MGR_NO"));// 가져오고자 하는 인자를 작성하면 됨.

                String X_SWIFI_MGR_NO = (String) tmp.get("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = (String) tmp.get("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = (String) tmp.get("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = (String) tmp.get("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = (String) tmp.get("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = (String) tmp.get("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = (String) tmp.get("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = (String) tmp.get("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = (String) tmp.get("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = (String) tmp.get("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = (String) tmp.get("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = (String) tmp.get("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = (String) tmp.get("X_SWIFI_REMARS3");
                String LAT = (String) tmp.get("LAT");
                String LNT = (String) tmp.get("LNT");
                String WORK_DTTM = (String) tmp.get("WORK_DTTM");

                WifiDto wifiDto = new WifiDto(X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM);
                WifiDao wifiDao = new WifiDao();
                wifiDao.wifiInsert(wifiDto);

                total++;
            }
        }
        return tmp;
    }
}
