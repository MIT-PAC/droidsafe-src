package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.IccCardApplication;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.Phone;




public final class SIMFileHandler extends IccFileHandler implements IccConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.433 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.436 -0500", hash_original_field = "3E4A9DF67E5660E9A95DECEFCF15D77A", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;

    //***** Instance Variables

    //***** Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.438 -0500", hash_original_method = "28787217280B11FEE5B9021DD1097C9A", hash_generated_method = "28787217280B11FEE5B9021DD1097C9A")
    
SIMFileHandler(GSMPhone phone) {
        super(phone);
        mPhone = phone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.441 -0500", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "CEA4BD04B364A2D6A5DC0E0491C26D12")
    
public void dispose() {
        super.dispose();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.443 -0500", hash_original_method = "48D1C945A3808FD7B021E909C155155D", hash_generated_method = "D3C172659735198B045DA968A70F9E45")
    
protected void finalize() {
        Log.d(LOG_TAG, "SIMFileHandler finalized");
    }

    //***** Overridden from IccFileHandler

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.445 -0500", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "DCAA486667275FD4C905CA1844E72CB8")
    
@Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.448 -0500", hash_original_method = "10EDEC4C0ACD70E5A3D3B2572E081074", hash_generated_method = "A975ADA1F6A29A037B0FBD288EE9391A")
    
protected String getEFPath(int efid) {
        // TODO(): DF_GSM can be 7F20 or 7F21 to handle backward compatibility.
        // Implement this after discussion with OEMs.
        switch(efid) {
        case EF_SMS:
            return MF_SIM + DF_TELECOM;

        case EF_EXT6:
        case EF_MWIS:
        case EF_MBI:
        case EF_SPN:
        case EF_AD:
        case EF_MBDN:
        case EF_PNN:
        case EF_SPDI:
        case EF_SST:
        case EF_CFIS:
            return MF_SIM + DF_GSM;

        case EF_MAILBOX_CPHS:
        case EF_VOICE_MAIL_INDICATOR_CPHS:
        case EF_CFF_CPHS:
        case EF_SPN_CPHS:
        case EF_SPN_SHORT_CPHS:
        case EF_INFO_CPHS:
        case EF_CSP_CPHS:
            return MF_SIM + DF_GSM;

        case EF_PBR:
            // we only support global phonebook.
            return MF_SIM + DF_TELECOM + DF_PHONEBOOK;
        }
        String path = getCommonIccEFPath(efid);
        if (path == null) {
            // The EFids in USIM phone book entries are decided by the card manufacturer.
            // So if we don't match any of the cases above and if its a USIM return
            // the phone book path.
            IccCard card = phone.getIccCard();
            if (card != null && card.isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM)) {
                return MF_SIM + DF_TELECOM + DF_PHONEBOOK;
            }
            Log.e(LOG_TAG, "Error: EF Path being returned in null");
        }
        return path;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.452 -0500", hash_original_method = "45FB79CED1F6261AE88F32026733A48A", hash_generated_method = "821336B7AA4CA4DD238646288F5D76C2")
    
protected void logd(String msg) {
        Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.454 -0500", hash_original_method = "186F2705ACAE4FAB6B3F0960135671C1", hash_generated_method = "E74A473F03217D8105C116BC7519BFC0")
    
protected void loge(String msg) {
        Log.e(LOG_TAG, "[SIMFileHandler] " + msg);
    }
}

