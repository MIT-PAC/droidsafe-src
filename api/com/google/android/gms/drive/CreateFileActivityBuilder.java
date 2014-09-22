package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.internal.hm;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.IOException;
import android.os.ParcelFileDescriptor;
import android.content.IntentSender;

public class CreateFileActivityBuilder
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.100 -0400", hash_original_field = "3E23F07644443EED4FB79858765263F6", hash_generated_field = "A3321F55B8CFC975B738EC077FB9BCE3")

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.104 -0400", hash_original_field = "A4C82118CB2C2166F59DFB475DF688D4", hash_generated_field = "AE66ECAE9434A49612CEB2F788211A70")

    private  h HF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.109 -0400", hash_original_field = "2A5E5FC20AC2EAD580698176C138A3E2", hash_generated_field = "0BE318D3491D28F3E75F0EE0943B9EC1")

    private Contents HG;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.114 -0400", hash_original_method = "7FAC64DC3CE3E3BF26C88396D0692235", hash_generated_method = "9B4E68A983188C71846DC0E91572FB42")
    
public CreateFileActivityBuilder()
    {

        HF = new h(0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.118 -0400", hash_original_method = "3F6E085929D3BA98173A806E53461CA5", hash_generated_method = "2B82D4735DEAFF8208E156ADFC39239D")
    
public CreateFileActivityBuilder setInitialContents(Contents  r1)
    {


        HG = (Contents) hm.f(r1);
        HF.aS(HG.getRequestId());
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.123 -0400", hash_original_method = "753F0487C7294C7A635426B14FEE062A", hash_generated_method = "EC9E049169AFA13AE9CF6D45D8ED138E")
    
public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet  r1)
    {


        HF.a(r1);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.127 -0400", hash_original_method = "7C612ABA8EA0F4CF936BEACB916CC100", hash_generated_method = "ED6300657AD22A1E5BA308A358827BF6")
    
public CreateFileActivityBuilder setActivityStartFolder(DriveId  r1)
    {


        HF.a(r1);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.130 -0400", hash_original_method = "6F4B5CF04F61BB7730D40DCA1303CFC3", hash_generated_method = "ECF837E68D5F62D513DE6F2A2B5E574E")
    
public CreateFileActivityBuilder setActivityTitle(String  r1)
    {


        HF.aM(r1);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.135 -0400", hash_original_method = "977026DC499D9B58C254D9A55C8E22E0", hash_generated_method = "00654CD32CCFF190C869960713D147FF")
    
public IntentSender build(GoogleApiClient  r1)
    {


        hm.b(HG, "Must provide initial contents to CreateFileActivityBuilder.");

        HG.getParcelFileDescriptor().close();

        HG.close();
        return HF.build(r1);
    }
}
