package com.tigrex.rathalos.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * @author linus
 */
@Slf4j
public class HttpUtils {

    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";

    public static String httpURLConnection(String requestUrl, String requestMethod, String requestParams) {
        log.info("requestUrl:" + requestUrl + ";requestMethod:" + requestMethod + ";requestParams" + requestParams);
        StringBuffer buffer = new StringBuffer();
        HttpsURLConnection httpUrlConn = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpsURLConnection) url.openConnection();
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            TrustManager[] trustManagers = { new RathalosX509TrustManager() };
            sslContext.init(null, trustManagers, new SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            httpUrlConn.setSSLSocketFactory(sslSocketFactory);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //设置网络超时
            httpUrlConn.setConnectTimeout(6000);
            httpUrlConn.setReadTimeout(6000);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);
            if (GET.equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }
            if (!StringUtils.isEmpty(requestParams)) {
                outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(requestParams.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            // 将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
            log.info(buffer.toString());
            return buffer.toString();
        } catch (Exception e) {
            log.error("调用出错：" + e);
            return null;
        } finally {
            try {
                if(inputStreamReader!=null){
                    inputStreamReader.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(outputStream!=null){
                    outputStream.close();
                }
                if(httpUrlConn!=null){
                    httpUrlConn.disconnect();
                }
            } catch (Exception e) {}
        }
    }

//    public static void httpURLConnection() throws IOException {
//        URL url = new URL("http://localhost:9001/user/hello");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
//        xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
//                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
//                "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
//        xml += "<soap:Body>";
//        xml += "<mt xmlns=\"http://localhost:9001/user/hello\">";
//        xml += "<sn>" + 123 + "</sn>";
//        xml += "<pwd>" + 123 + "</pwd>";
//        xml += "<mobile>" + 123 + "</mobile>";
//        xml += "<content>" + 123 + "</content>";
//        xml += "<ext>" + 123 + "</ext>";
//        xml += "<stime>" + 123 + "</stime>";
//        xml += "<rrid></rrid>";
//        xml += "</mt>";
//        xml += "</soap:Body>";
//        xml += "</soap:Envelope>";
//
//        ByteArrayOutputStream bout = new ByteArrayOutputStream();
//        bout.write(xml.getBytes());
//        byte[] b = bout.toByteArray();
//        connection.setRequestProperty("Content-Length", String.valueOf(b.length));
//        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
//        connection.setRequestProperty("SOAPAction", "http://localhost:9001/user/hello");
//        connection.setRequestMethod("POST");
//        connection.setDoInput(true);
//        connection.setDoOutput(true);
//
//        OutputStream out = connection.getOutputStream();
//        out.write(b);
//        out.close();
//
//        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
//        BufferedReader in = new BufferedReader(isr);
//        StringBuilder sb = new StringBuilder();
//        String inputLine;
//        while (null != (inputLine = in.readLine())) {
//            sb.append(inputLine);
//        }
//        System.out.println(sb);
//    }
}
