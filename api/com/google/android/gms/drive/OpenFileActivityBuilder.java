package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.internal.hm;
import com.google.android.gms.common.api.GoogleApiClient;
import android.os.RemoteException;
import android.content.IntentSender;

public class OpenFileActivityBuilder
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:38.978 -0400", hash_original_field = "3E23F07644443EED4FB79858765263F6", hash_generated_field = "A3321F55B8CFC975B738EC077FB9BCE3")

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:38.987 -0400", hash_original_field = "467ABBEF78ED5B2886D11A7730B5DEC2", hash_generated_field = "827DF17AAC1EE2076940BBE8CAD0910B")

    private String HY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:38.993 -0400", hash_original_field = "E081D0C93FEAE3D3D4329923243F01B9", hash_generated_field = "28F019A6AB5F20196314E461186C8F5A")

    private String[] HZ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:39.001 -0400", hash_original_field = "9234E2ADDC3BB96C9FC04352FB1EECD9", hash_generated_field = "ADAC901D67EC9E74B7A282ECF84CE2E7")

    private DriveId Ia;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:39.010 -0400", hash_original_method = "D951E1847347F043B4C8CD7C7A1A7BE6", hash_generated_method = "D46DCECD5A58B0050801A1719B349AC5")
    
public OpenFileActivityBuilder setActivityTitle(String  r1)
    {


        HY = (String) hm.f(r1);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:39.031 -0400", hash_original_method = "2AB3C64ACBBC1ED211144403D3B10CB8", hash_generated_method = "2FA708C64515F81285F4D0E871E90995")
    
public OpenFileActivityBuilder setMimeType(String[]  r1)
    {

        boolean $z0;
        if (r1 == null)
        {
            $z0 = false;
        }
        else
        {
            $z0 = true;
        }

        hm.b($z0, "mimeTypes may not be null");
        HZ = r1;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:39.040 -0400", hash_original_method = "F952C8DE13D82115BAD9539842F9CBFE", hash_generated_method = "2D66166F92F9E0503F92B37902EBAE3F")
    
public OpenFileActivityBuilder setActivityStartFolder(DriveId  r1)
    {


        Ia = (DriveId) hm.f(r1);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 14:52:39.060 -0400", hash_original_method = "EF980F68C534C16B258579BAA67EFA78", hash_generated_method = "8635667405707F58B1142A995512E1AD")
    
public IntentSender build(GoogleApiClient  r1)
    {

        aa r2;
        IntentSender $r13;
        OpenFileIntentSenderRequest r16;
        RuntimeException r17;
        Throwable r18;
        hm.a(r1.isConnected(), "Client must be connected");

        if (HZ == null)
        {
            HZ = new String[0];
        }

        r2 = ((r) r1.a(Drive.yH)).gp();

        try
        {
            r16 = new OpenFileIntentSenderRequest(HY, HZ, Ia);
            $r13 = r2.a(r16);
        }
        catch (RemoteException $r14)
        {
            r17 = new RuntimeException("Unable to connect Drive Play Service", $r14);
            r18 = (Throwable) r17;
            throw r18;
        }

        return $r13;
    }
}
