package ro.ramonnastase.tutorialeandroid.Helpers;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HelperFunc {
    public static void printHashKey(Context context, TextView textViewKeyHash) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.d("HelperFunc", "Hash Key: " + hashKey);

                textViewKeyHash.setText(hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("HelperFunc", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("HelperFunc", "printHashKey()", e);
        }
    }

}
