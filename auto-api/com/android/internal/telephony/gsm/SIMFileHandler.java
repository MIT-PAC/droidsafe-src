package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.IccCardApplication;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.Phone;

public final class SIMFileHandler extends IccFileHandler implements IccConstants {
    private Phone mPhone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.148 -0400", hash_original_method = "28787217280B11FEE5B9021DD1097C9A", hash_generated_method = "5A1CF966E079FB562BEDBE7B287F187B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SIMFileHandler(GSMPhone phone) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.149 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.149 -0400", hash_original_method = "48D1C945A3808FD7B021E909C155155D", hash_generated_method = "390AF6D8D57B2EBD6C228B7EC0FD43E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        Log.d(LOG_TAG, "SIMFileHandler finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "SIMFileHandler finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.149 -0400", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "C6E3EA3638A1123EDA1C37F1352177B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        super.handleMessage(msg);
        // ---------- Original Method ----------
        //super.handleMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.149 -0400", hash_original_method = "10EDEC4C0ACD70E5A3D3B2572E081074", hash_generated_method = "2DD5BC0245D0415A2E94D02423173274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String getEFPath(int efid) {
        dsTaint.addTaint(efid);
        String path;
        path = getCommonIccEFPath(efid);
        {
            IccCard card;
            card = phone.getIccCard();
            {
                boolean var9665AFD4ACE9DC342017EA17A23CC0AF_1378360141 = (card != null && card.isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.150 -0400", hash_original_method = "45FB79CED1F6261AE88F32026733A48A", hash_generated_method = "31EDF2110250D9C19928F882CF9D8223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void logd(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:15.150 -0400", hash_original_method = "186F2705ACAE4FAB6B3F0960135671C1", hash_generated_method = "9787A93D90DFA6B45A6AFB03BAF7B783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void loge(String msg) {
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    
    static final String LOG_TAG = "GSM";
}

