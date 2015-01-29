package com.google.android.gms.internal;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;

public final class eu
{

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.847 -0400", hash_original_method = "0EDCCB167192AFF5C2D02D386B8A761D", hash_generated_method = "57246BD4383C5FB9CC8C28B1F590CCEC")
    
public static void z(String  r0)
    {

        if (eu.p(3))
        {
            Log.d("Ads", r0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.851 -0400", hash_original_method = "3BECEBC69D1D6C2C3AE1479555F2D96C", hash_generated_method = "8665D44AD90FB0860D5CE37F64EFE408")
    
public static void a(String  r0, Throwable  r1)
    {

        if (eu.p(3))
        {
            Log.d("Ads", r0, r1);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.855 -0400", hash_original_method = "2DD96534551D3C990DDBBA54566E82F8", hash_generated_method = "271C98E159A3663AC22F818DC038858B")
    
public static void A(String  r0)
    {

        if (eu.p(6))
        {
            Log.e("Ads", r0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.859 -0400", hash_original_method = "92EEC33891553DCDB8972C8D1DF8E9C0", hash_generated_method = "88C6E0E84F16BA64E88C2083DC205252")
    
public static void b(String  r0, Throwable  r1)
    {

        if (eu.p(6))
        {
            Log.e("Ads", r0, r1);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.863 -0400", hash_original_method = "59F0625C704916D7379CAAA30FE5E8A1", hash_generated_method = "06499C66A05BC8F2662B1B3096EA0070")
    
public static void B(String  r0)
    {

        if (eu.p(4))
        {
            Log.i("Ads", r0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.873 -0400", hash_original_method = "2A687BAA4EA67680C8C3E589F4742593", hash_generated_method = "B1335161DF8DE6E622BDC577C2D28864")
    
public static void C(String  r0)
    {

        if (eu.p(2))
        {
            Log.v("Ads", r0);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.877 -0400", hash_original_method = "B43F2D32A660E0FC9A17E7FD4FE6F5C9", hash_generated_method = "3252C29E0E785293597259D40A131E21")
    
public static void D(String  r0)
    {

        if (eu.p(5))
        {
            Log.w("Ads", r0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.882 -0400", hash_original_method = "8A0381B7C80B90AA8F86907A1DC93C6C", hash_generated_method = "B4D7B1B110FF27B6EA92CE19C430DAA0")
    
public static void c(String  r0, Throwable  r1)
    {

        if (eu.p(5))
        {
            Log.w("Ads", r0, r1);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.886 -0400", hash_original_method = "DADDF28EA3B8E6D2B0910D3AEE91EAB4", hash_generated_method = "F916A5A7CD609748EB12D5F1B2304AAE")
    
public static boolean p(int  i0)
    {

        boolean $z1;
        label_1:
        {
            label_0:
            {
                if (i0 < 5 &&  ! (Log.isLoggable("Ads", i0)))
                {
                    break label_0;
                }

                if (i0 != 2)
                {
                    $z1 = true;
                    break label_1;
                }
            } //end label_0:

            $z1 = false;
        } //end label_1:

        return $z1;
    }
}
