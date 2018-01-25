package com.xyz.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

public class AuthAPITest {

    public static void main(String[] args) throws JSONException, IOException {
        // TODO Auto-generated method stub
        testAuthAPI();

//		String domain = "http://riclavazeng.cs0309.3g.qq.com";
//		String username = "1FB93QR7ZK17608A";
//		String password = "331050027";
//		String bkey = Integer.toString(new Random().nextInt(60466175), 36);
//		String salt = "BEACON";
//		String btoken = MD5(bkey + salt);
//
//		String content = "product_id=" + username + "&auth_user=" + password;
//		String tokenUrl = domain + "/auth/test_perm.do";
//		if (btoken != null && btoken.length() > 0) {
//			tokenUrl += "?btoken=" + btoken;
//		}
//		System.out.println("-----tokenUrl-----\n" + tokenUrl);
//		String token = post(tokenUrl, content, null, bkey);
//		System.out.println("-----token-----\n" + token);
    }

    private static void testAuthAPI() throws JSONException {
        //开发
//		String domain = "http://localhost:8080";
//		String username = "24ac0e9923553f6080282f552ccbf492";
//		String password = "691d0964ce298310b86ce320601eddfe";
//		String bkey = null;
//		String btoken = "";

        // 内网
//		 String domain = "http://dev.jeffery.beacon.wsd.com";
//		 String username = "24ac0e9923553f6080282f552ccbf493";
//		 String password = "691d0964ce298310b86ce320601eddfg";
//		 String bkey = null;
//		 String btoken = "";

        // 外网
//		String domain = "http://riclavazeng.cs0309.3g.qq.com";
//		String username = "24ac0e9923553f6080282f552ccbf492";
//		String password = "691d0964ce298310b86ce320601eddfe";
//		String bkey = Integer.toString(new Random().nextInt(60466175), 36);
//		String salt = "BEACON";
//		String btoken = MD5(bkey + salt);

        // 外网next
        String domain = "https://next.beacon.qq.com";
        String username = "ecb94ede363f2b8042c649979ae466a5";
        String password = "72f675cd46df3dc4d962b936eca284c8";
        String bkey = Integer.toString(new Random().nextInt(60466175), 36);
        String salt = "BEACON";
        String btoken = MD5(bkey + salt);

        // user_token.do
        String content = "username=" + username + "&password=" + password;
        String tokenUrl = domain + "/auth/user_token.do";
        if (btoken != null && btoken.length() > 0) {
            tokenUrl += "?btoken=" + btoken;
        }
        System.out.println("-----tokenUrl-----\n" + tokenUrl);
        String token = post(tokenUrl, content, null, bkey);
        System.out.println("-----token-----\n" + token);

        // detail_data.do
        JSONObject json = new JSONObject(token);
        String auth = json.getJSONObject("data").getString("user_token");
        String apiUrl = domain
                + "/pages/data/retent_w/detail_data.do?product_id=1FB93QR7ZK17608A&platform=Android&startDate=20171115&endDate=20171128&app_version=total&channel=total";
        if (btoken != null && btoken.length() > 0) {
            apiUrl += "&btoken=" + btoken;
        }
        System.out.println("-----apiUrl-----\n" + apiUrl);
        String data = post(apiUrl, "", auth, bkey);
        System.out.println("-----data-----\n" + data);

        // newapp.do
        content = "app_name=test_1234&app_os=weapp&app_group=130,121&app_introduction=test&creator=290953670&app_origin=wudi";
        String newappUrl = domain + "/pages/interface/newapp.do";
        if (btoken != null && btoken.length() > 0) {
            newappUrl += "?btoken=" + btoken;
        }
        System.out.println("-----newappUrl-----\n" + newappUrl);
        String newappdata = post(newappUrl, content, auth, bkey);
        System.out.println("-----newappdata-----\n" + newappdata);
    }

    public static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * POST请求
     *
     * @param url 		请求的地址
     * @param content 	需要发送的内容
     * @param auth 		授权token
     * @param bkey 		按规则生成
     * @return 			返回的内容，如果非200则返回null
     */
    public static String post(String url, String content, String auth, String bkey) {
        try {
            //打印IP地址
            printIPAddress(new URL(url).getHost());

            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            if (auth != null && auth.length() > 0) {
                connection.setRequestProperty("bea_token", auth);
            }
            if (bkey != null && bkey.length() > 0) {
                connection.setRequestProperty("Cookie", "bkey=" + bkey);
            }

            OutputStream os = connection.getOutputStream();
            os.write(content.getBytes("UTF-8"));
            os.flush();
            os.close();

            int code = connection.getResponseCode();
            System.out.println("-----code-----\n" + code);
//			if (code != 200) {
//				return null;
//			}

            InputStream is = connection.getInputStream();

            StringBuffer response = new StringBuffer(1024);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = null;
            while ((line = bf.readLine()) != null) {
                response.append(line);// .append(System.getProperty("line.separator"));
            }

            is.close();

            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//	public static void printIPAddress(String domains) throws UnknownHostException {
//		InetAddress[] ips = InetAddress.getAllByName(domains);
//		for(InetAddress ip: ips){
//			System.out.println(ip.toString());
//			System.out.println("Address：" + ip.getHostAddress());
//			System.out.println("Name：" + ip.getHostName());
//		}
//	}

    public static void printIPAddress(String domains) throws UnknownHostException {
        InetAddress ip=InetAddress.getByName(domains);
        System.out.println(ip.toString());
        System.out.println("Address："+ip.getHostAddress());
        System.out.println("Name："+ip.getHostName());
    }
}