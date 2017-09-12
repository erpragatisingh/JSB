package in.jsb.jsb.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.util.Locale;


/**
 * @author Pragati Singh
 * 
 */
public final class UtilsPhone {


	public static String getApplicationVersionCode(final Context context) {
		PackageManager packageManager = context.getPackageManager();
		try {
			PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
			return ""+packageInfo.versionCode;
		} catch (PackageManager.NameNotFoundException ex) {} catch(Exception e){}
		return ""+0;
	}


    public static String getDeviceCarrier(final Context context)  {
	TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
	String Carrier = mTelephonyMgr.getSimOperatorName();
	if (Carrier != null && !Carrier.equals(""))
	{
	    return Carrier;
	}
	return "NA";
    }


    public static String getSimCountry(final Context context) {
	TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
	return TelephonyMgr.getSimCountryIso().toUpperCase();
    }



//    public static String getTimeZone() {
//	TimeZone tz = TimeZone.getDefault();
//	String timezone = tz.getDisplayName(false, TimeZone.SHORT);
//	return timezone;
//
//    }

    public static String getDeviceName() {
	String deviceName = null;

	String deviceBuild = Build.MANUFACTURER;

	if (deviceBuild.equalsIgnoreCase("samsung"))
	{
	    BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
	    deviceName = myDevice.getName();
	} else
	{
	    deviceName = Build.MODEL;
	}
	return deviceName;
    }

    public static String getDeviceModel() {

	String model = Build.MODEL;
	// Log.e("model", "" + model);
	return model;
    }


    public static String getCountryDesplayName(final Context mcontext) {

	// String country_Language =
	// mcontext.getResources().getConfiguration().locale.getDisplayLanguage();
	String country_codeBySim = UtilsPhone.getSimCountry(mcontext);
	// String country_codeByLocal=
	// mcontext.getResources().getConfiguration().locale.getCountry();
	Locale loc = new Locale("", country_codeBySim);
	loc.getDisplayCountry();
	// System.out.println("County NAme :"+ loc.getDisplayCountry());
	return loc.getDisplayCountry();
    }

 }
