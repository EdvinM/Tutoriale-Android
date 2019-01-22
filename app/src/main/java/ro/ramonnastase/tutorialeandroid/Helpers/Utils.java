package ro.ramonnastase.tutorialeandroid.Helpers;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static String convertStreamToString(String TAG, InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try
        {
            while ((line = reader.readLine()) != null)
                sb.append(line).append('\n');
        }
        catch (IOException e)
        {
            Log.e(TAG, "convertStreamToString 1: " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                Log.e(TAG, "convertStreamToString 2: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
