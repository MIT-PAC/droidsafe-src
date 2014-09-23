package com.google.android.gms.internal;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.provider.Settings$Secure;
import android.os.Build;
import android.os.Looper;
import java.security.MessageDigest;
import java.util.Locale;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import android.os.Handler;

public final class et
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.744 -0400", hash_original_field = "E96225E55504D7EFCCCB5875818A5390", hash_generated_field = "EF77D39E394942998EBC1B53142DB251")

    public static  Handler sv;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.748 -0400", hash_original_method = "8C3657E3F54FA14AC0A13340EE7818EF", hash_generated_method = "4C003589280BB7F5F922807657E64BC9")
    
public static int a(Context  r0, int  i0)
    {


        return et.a(r0.getResources().getDisplayMetrics(), i0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.752 -0400", hash_original_method = "452BFAB0D010E38DAB969F5A0FCD5818", hash_generated_method = "07B64ECBDFC02AADCEACB890CF87788C")
    
public static int a(DisplayMetrics  r0, int  i0)
    {


        return (int) TypedValue.applyDimension(1, (float) i0, r0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.757 -0400", hash_original_method = "475B2CF773F2809B2C5285B57AEC71D3", hash_generated_method = "4D2485C3516432ED4D7860C77A3D2C52")
    
public static void a(ViewGroup  r0, al  r1, String  r2, String  r3)
    {


        eu.D(r3);
        et.a(r0, r1, r2, -65536, -16777216);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.762 -0400", hash_original_method = "2CC7D2083481BB0CA53F9CF9EC199E59", hash_generated_method = "D6285CECF8CB02D585E9F8AFC923077F")
    
public static void a(ViewGroup  r0, al  r1, String  r2)
    {


        et.a(r0, r1, r2, -16777216, -1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.768 -0400", hash_original_method = "7718B469357900AD60DDEDE88E475E51", hash_generated_method = "2089BF13117BF711AAEC28E885FBE1F8")
    
private static void a(ViewGroup  r0, al  r1, String  r2, int  i0, int  i1)
    {

        Context r3;
        TextView r4;
        FrameLayout r5;
        int i2;
        if (r0.getChildCount() == 0)
        {
            r3 = r0.getContext();
            r4 = new TextView(r3);
            r4.setGravity(17);
            r4.setText(r2);
            r4.setTextColor(i0);
            r4.setBackgroundColor(i1);
            r5 = new FrameLayout(r3);
            r5.setBackgroundColor(i0);
            i2 = et.a(r3, 3);
            r5.addView(r4, new FrameLayout$LayoutParams(r1.widthPixels - i2, r1.heightPixels - i2, 17));
            r0.addView(r5, r1.widthPixels, r1.heightPixels);
            return;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.772 -0400", hash_original_method = "7C8DB1ECE7F03A660B421231D66610ED", hash_generated_method = "FD78C1892E9DF5CEDD92D037EDDAAFCE")
    
public static String r(Context  r0)
    {

        String r1, $r3;
        r1 = Settings$Secure.getString(r0.getContentResolver(), "android_id");

        label_0:
        {
            if (r1 != null &&  ! (et.bV()))
            {
                $r3 = r1;
                break label_0;
            }

            $r3 = "emulator";
        } //end label_0:


        return et.y($r3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.775 -0400", hash_original_method = "9C2AA983232870BD0BC624A40CECDEBE", hash_generated_method = "C64FC54759E92B14321E5E96A246A949")
    
public static boolean bV()
    {


        return Build.DEVICE.startsWith("generic");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.779 -0400", hash_original_method = "01CDB31190AE242E248AC7203F863D78", hash_generated_method = "EE85DEF08F661B87E59C50ECBED58CD7")
    
public static boolean bW()
    {

        boolean $z0;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            $z0 = false;
        }
        else
        {
            $z0 = true;
        }

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.784 -0400", hash_original_method = "0056DED3EB3D290D5AFCF5862CC14BD8", hash_generated_method = "755E5C0232EB24790113D12CE0430AB1")
    
public static String y(String  r0)
    {

        MessageDigest r1;
        Locale $r4;
        String $r7;

        while (true)
        {
            r1 = MessageDigest.getInstance("MD5");
            r1.update(r0.getBytes());
            $r4 = Locale.US;
            Object[] $r5 = {new BigInteger(1, r1.digest())};
            $r7 = String.format($r4, "%032X", $r5);

            return $r7;
        }

        return null;
    }

    static
    {


        sv = new Handler(Looper.getMainLooper());
    }
}
