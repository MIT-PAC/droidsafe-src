package com.google.android.gms.common;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateException;
import java.io.ByteArrayInputStream;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateExpiredException;
import android.content.pm.Signature;
import java.util.Arrays;
import android.util.Base64;
import android.os.Build;
import android.app.PendingIntent;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.Fragment;
import android.app.AlertDialog.Builder;
import android.util.TypedValue;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources.Theme;
import android.support.v4.app.*;
import android.app.*;
import android.support.v4.app.FragmentActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.net.Uri;
import java.io.InputStream;
import java.util.NoSuchElementException;
import android.content.ContentResolver;
import java.util.Scanner;
import android.content.res.Configuration;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public final class GooglePlayServicesUtil
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.292 -0400", hash_original_field = "67E246E59A1085C1E250603E5B47B885", hash_generated_field = "24BAE2F298CC7463ADDE235A9A82F32F")

    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.297 -0400", hash_original_field = "D15228A42773572B4825E0FBAC6C4548", hash_generated_field = "95E862B10195C1A43D7D8645E5A0A568")

    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 5089000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.301 -0400", hash_original_field = "9D754D483C5FF7B9935E4D06FF86B93A", hash_generated_field = "B5263DA25CD5D2636082B35B72EE1F53")

    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.305 -0400", hash_original_field = "EFA9A8D827612987104E8D7E431111D6", hash_generated_field = "EF412D9E59DF481B5C179FF1C8A331F7")

    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.310 -0400", hash_original_field = "85719650E80DD55C767F22B7D39FDFBF", hash_generated_field = "4D3EAF08F0BE5F7BC45F42FB780AB5D7")

    static  byte[][] CV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.315 -0400", hash_original_field = "E26F0D2F70735BB808C98071B7D3B3AD", hash_generated_field = "20A0DC832C5F4508E69B2D19F7425795")

    static  byte[][] CW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.320 -0400", hash_original_field = "C57420675C4C73B8B2641E8A75545147", hash_generated_field = "EF54C569E78D736D58B252A2676EB2C2")

    static  byte[][] CX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.324 -0400", hash_original_field = "5DC344E4F8113CA892A4E3B88C6C9DD1", hash_generated_field = "974C837B34F5DF5851164BA0C2EB83C6")

    static  byte[][] CY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.328 -0400", hash_original_field = "306A972E931E98E7A37366DA395B9813", hash_generated_field = "6F0E9C29858F7A0FCEF60B9ABCDB294F")

    static  byte[][] CZ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.332 -0400", hash_original_field = "D7572D555DEE927747CBCFBF9DB7B3C2", hash_generated_field = "DDF91E73AB331F7F22B94111FF0676E5")

    static  byte[][] Da;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.337 -0400", hash_original_field = "7EBF70A15C79B3BF42FC21AB7A282066", hash_generated_field = "1C72B7A3B184706CD25EE80B8EE62AB0")

    static  byte[][] Db;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.341 -0400", hash_original_field = "520EA63972DD795D9B62B142426EF145", hash_generated_field = "868065C70A4CA31B3096871DC96247EC")

    static  byte[][] Dc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.346 -0400", hash_original_field = "7AE16AF7B04AE92FD6AFE8EAB168EE22", hash_generated_field = "103113C5589A5E205EC5B4DAB3263D08")

    private static  byte[][] Dd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.350 -0400", hash_original_field = "21AB4E11254E32BF9F7A7E94F0DE9C4F", hash_generated_field = "F6A82395FE6448D119FD5FAA44971C4C")

    private static  byte[][] De;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.355 -0400", hash_original_field = "51EA58A8BC3ACD25C4BA980B7E41C310", hash_generated_field = "E462FE7B29968A2D2307FD3D8A614D80")

    public static boolean Df;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.359 -0400", hash_original_field = "C17C133EB39C247A89B942AA81AF81E5", hash_generated_field = "CF0EE9F59418A6868807C2D7EF180449")

    public static boolean Dg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.363 -0400", hash_original_field = "15AE93ACF0DFAD86A511259F345E6F4A", hash_generated_field = "EB0C845A5E32A00D14935C04960EDFB2")

    private static int Dh;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.370 -0400", hash_original_field = "66283C56592722E8D84442FBBD1D03A7", hash_generated_field = "BBEF878CB67B62864034890CD86BED89")

    private static  Object Di;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.374 -0400", hash_original_method = "2AA7F2DD2E1811144C93637C0812208C", hash_generated_method = "139B2C32D4440A296BDFAC11248A8995")
    
public static String getErrorString(int  i0)
    {

        switch (i0)
        {
            case 0:
                return "SUCCESS";

            case 1:
                return "SERVICE_MISSING";

            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";

            case 3:
                return "SERVICE_DISABLED";

            case 4:
                return "SIGN_IN_REQUIRED";

            case 5:
                return "INVALID_ACCOUNT";

            case 6:
                return "RESOLUTION_REQUIRED";

            case 7:
                return "NETWORK_ERROR";

            case 8:
                return "INTERNAL_ERROR";

            case 9:
                return "SERVICE_INVALID";

            case 10:
                return "DEVELOPER_ERROR";

            case 11:
                return "LICENSE_CHECK_FAILED";

            case 12:
                return "DATE_INVALID";

            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.384 -0400", hash_original_method = "75BCA83A4EA2581CE77A849970DEBFE1", hash_generated_method = "A2540595ACCB7ECD2B838793820D2FD0")
    
public static int isGooglePlayServicesAvailable(Context  r0)
    {
    	return r0.getTaintInt();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.466 -0400", hash_original_method = "A045109A6FDD6FF2CC8F4A56EA4CC95B", hash_generated_method = "73A68097DEDC5FE74F062277B023738C")
    
public static Dialog getErrorDialog(int  i0, Activity  r0, int  i1)
    {
        return GooglePlayServicesUtil.getErrorDialog(i0, r0, i1, null);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:47.471 -0400", hash_original_method = "A98D111154C8DBD93DAAFC02FC4D15B1", hash_generated_method = "1AF04B4D46569BFF07E3D7AF0FEF4A93")
    
public static Dialog getErrorDialog(int  i0, Activity  r0, int  i1, DialogInterface.OnCancelListener  r1)
    {
    	Dialog dialog = new Dialog(r0.getApplicationContext());
    	dialog.addTaint(i0 + i1);
    	r1.onCancel(dialog);
    	return dialog;
    }
}
