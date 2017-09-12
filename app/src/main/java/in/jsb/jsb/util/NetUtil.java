package in.jsb.jsb.util;

import android.app.Activity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by pragati.singh on 8/13/2017.
 */

public class NetUtil {
    public static final String NOTIFICATION_MESSAGE = "message";
    public static void handleErrorBody(ResponseBody responseBody, Activity activity) {
        if (null != responseBody) {
            try {
                JSONObject jObjError = new JSONObject(responseBody.string());
                String errorMessage = jObjError.getString(NOTIFICATION_MESSAGE);
                Toast.makeText(activity, errorMessage, Toast.LENGTH_SHORT).show();
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
