package com.google.android.gms.ads.mediation.customevent;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class CustomEventExtras implements com.google.ads.mediation.NetworkExtras
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.299 -0400", hash_original_field = "35D2015798608054C61A736DED3D8786", hash_generated_field = "F563A70041F72557EAA2106A374D4F30")

    private  HashMap ta;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.305 -0400", hash_original_method = "06F375277BA416D4DC369ABC69BD7E23", hash_generated_method = "CC678EDF18FFC64F0B2DBFF3B2A2BC03")
    
public CustomEventExtras()
    {

        ta = new HashMap();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.309 -0400", hash_original_method = "0C2F4C7F2F3E8903E5F10450488CE430", hash_generated_method = "760AFF234B7CC1AD9AADA367EAEB1856")
    
public Object getExtra(String  r1)
    {


        return ta.get(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:45.314 -0400", hash_original_method = "AEBC55B7FC0DC43BDF67DFB556E28E17", hash_generated_method = "E9765476F0D81F024FE8D4225A61A1E3")
    
public void setExtra(String  r1, Object  r2)
    {


        ta.put(r1, r2);
    }
}
