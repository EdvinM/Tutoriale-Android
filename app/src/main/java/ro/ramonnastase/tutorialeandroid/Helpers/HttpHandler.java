package ro.ramonnastase.tutorialeandroid.Helpers;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    private String reqUrl;
    private Type callType;

    private HashMap<String, String> propertyMap = new HashMap<String, String>();

    private HttpURLConnection conn;

    public HttpHandler(String reqUrl, Type type)
    {
        this.reqUrl     = reqUrl;
        this.callType   = type;
    }

    public void setProperty(String name, String value)
    {
        propertyMap.put(name, value);
    }

    //setPropert("name", "Edvin Mako");

    public String makeServiceCall()
    {
        String response = null;

        try
        {
            URL url = new URL(reqUrl);

            /*
             * Set proper parameters for the request.
             */
            StringBuilder stringBuilder = new StringBuilder();

            for(Map.Entry<String, String> entry : propertyMap.entrySet())
            {
                if(stringBuilder.length() != 0) stringBuilder.append('&');
                stringBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = stringBuilder.toString().getBytes("UTF-8");

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(callType.getType());
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            //conn.setRequestProperty("Authorization", UserAccount.getApiKey());

            //We need this only for POST/PUT requests.
            if(postDataBytes.length != 0)
            {
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
            }

            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = Utils.convertStreamToString(TAG, in);

            Log.d(TAG, "Connection Response Code: " + conn.getResponseCode());
        }
        catch (MalformedURLException e)
        {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        }
        catch (ProtocolException e)
        {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        }
        catch (IOException e)
        {
            Log.e(TAG, "IOException Handler: " + e.getMessage());
        }
        catch (Exception e)
        {
            Log.e(TAG, "Exception: " + e.getMessage());
        }


        return response;
    }

    public enum Type
    {
        POST("POST"),
        GET("GET"),
        PUT("PUT"),
        DELETE("DELETE");

        private String stringValue;
        private Type(String toString)
        {
            stringValue = toString;
        }

        public String getType()
        {
            return stringValue;
        }
    }

}
