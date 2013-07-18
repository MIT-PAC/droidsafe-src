package com.android.internal.telephony.gsm;

// Droidsafe Imports
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.IccCardApplication;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.Phone;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class SIMFileHandler extends IccFileHandler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.430 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.430 -0400", hash_original_method = "28787217280B11FEE5B9021DD1097C9A", hash_generated_method = "E0F6B16E89762658DF17EF8C6EF8CDD8")
      SIMFileHandler(GSMPhone phone) {
        super(phone);
        mPhone = phone;
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.430 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.431 -0400", hash_original_method = "48D1C945A3808FD7B021E909C155155D", hash_generated_method = "390AF6D8D57B2EBD6C228B7EC0FD43E8")
    protected void finalize() {
        Log.d(LOG_TAG, "SIMFileHandler finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "SIMFileHandler finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.431 -0400", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "77C805872CA69F6467EFC5D284BEB40A")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        super.handleMessage(msg);
        // ---------- Original Method ----------
        //super.handleMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.432 -0400", hash_original_method = "10EDEC4C0ACD70E5A3D3B2572E081074", hash_generated_method = "31A2078CA71277330EBA37875FD80A2F")
    protected String getEFPath(int efid) {
        addTaint(efid);
switch(efid){
        case EF_SMS:
String varC105CB41AAF16150249B5DA550B272CE_1284069469 =         MF_SIM + DF_TELECOM;
        varC105CB41AAF16150249B5DA550B272CE_1284069469.addTaint(taint);
        return varC105CB41AAF16150249B5DA550B272CE_1284069469;
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
String varFA2EA53600AD8E391FF729ACE748F1EA_1719015168 =         MF_SIM + DF_GSM;
        varFA2EA53600AD8E391FF729ACE748F1EA_1719015168.addTaint(taint);
        return varFA2EA53600AD8E391FF729ACE748F1EA_1719015168;
        case EF_MAILBOX_CPHS:
        case EF_VOICE_MAIL_INDICATOR_CPHS:
        case EF_CFF_CPHS:
        case EF_SPN_CPHS:
        case EF_SPN_SHORT_CPHS:
        case EF_INFO_CPHS:
        case EF_CSP_CPHS:
String varFA2EA53600AD8E391FF729ACE748F1EA_1109720609 =         MF_SIM + DF_GSM;
        varFA2EA53600AD8E391FF729ACE748F1EA_1109720609.addTaint(taint);
        return varFA2EA53600AD8E391FF729ACE748F1EA_1109720609;
        case EF_PBR:
String var1AB63F8FFC09FEACEF5A3C0A37E2D340_684740340 =         MF_SIM + DF_TELECOM + DF_PHONEBOOK;
        var1AB63F8FFC09FEACEF5A3C0A37E2D340_684740340.addTaint(taint);
        return var1AB63F8FFC09FEACEF5A3C0A37E2D340_684740340;
}        String path = getCommonIccEFPath(efid);
        if(path == null)        
        {
            IccCard card = phone.getIccCard();
            if(card != null && card.isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM))            
            {
String var1AB63F8FFC09FEACEF5A3C0A37E2D340_104273111 =                 MF_SIM + DF_TELECOM + DF_PHONEBOOK;
                var1AB63F8FFC09FEACEF5A3C0A37E2D340_104273111.addTaint(taint);
                return var1AB63F8FFC09FEACEF5A3C0A37E2D340_104273111;
            } //End block
        } //End block
String var535F4D9720F3B0C96D8143873CE0638C_1849585912 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1849585912.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1849585912;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.432 -0400", hash_original_method = "45FB79CED1F6261AE88F32026733A48A", hash_generated_method = "F86FF548D74882274FC42BBA5BDAA6ED")
    protected void logd(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.433 -0400", hash_original_method = "186F2705ACAE4FAB6B3F0960135671C1", hash_generated_method = "7C7025F790B2B79900FDADAD81ED13E2")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.433 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
}

