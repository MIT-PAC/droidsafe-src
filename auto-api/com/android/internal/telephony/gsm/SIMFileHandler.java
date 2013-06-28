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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.775 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.776 -0400", hash_original_method = "28787217280B11FEE5B9021DD1097C9A", hash_generated_method = "E0F6B16E89762658DF17EF8C6EF8CDD8")
      SIMFileHandler(GSMPhone phone) {
        super(phone);
        mPhone = phone;
        // ---------- Original Method ----------
        //mPhone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.776 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.777 -0400", hash_original_method = "48D1C945A3808FD7B021E909C155155D", hash_generated_method = "390AF6D8D57B2EBD6C228B7EC0FD43E8")
    protected void finalize() {
        Log.d(LOG_TAG, "SIMFileHandler finalized");
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "SIMFileHandler finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.777 -0400", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "3D6F3DBC2E4A8D25910B641F329886F5")
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //super.handleMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.779 -0400", hash_original_method = "10EDEC4C0ACD70E5A3D3B2572E081074", hash_generated_method = "0B5BF889C7ECDDB412ACAFD622458075")
    protected String getEFPath(int efid) {
        String varB4EAC82CA7396A68D541C85D26508E83_792718722 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_972430412 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1739637963 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_26068486 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_627639161 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1756894489 = null; //Variable for return #6
        //Begin case EF_SMS 
        varB4EAC82CA7396A68D541C85D26508E83_792718722 = MF_SIM + DF_TELECOM;
        //End case EF_SMS 
        //Begin case EF_EXT6 EF_MWIS EF_MBI EF_SPN EF_AD EF_MBDN EF_PNN EF_SPDI EF_SST EF_CFIS 
        varB4EAC82CA7396A68D541C85D26508E83_972430412 = MF_SIM + DF_GSM;
        //End case EF_EXT6 EF_MWIS EF_MBI EF_SPN EF_AD EF_MBDN EF_PNN EF_SPDI EF_SST EF_CFIS 
        //Begin case EF_MAILBOX_CPHS EF_VOICE_MAIL_INDICATOR_CPHS EF_CFF_CPHS EF_SPN_CPHS EF_SPN_SHORT_CPHS EF_INFO_CPHS EF_CSP_CPHS 
        varB4EAC82CA7396A68D541C85D26508E83_1739637963 = MF_SIM + DF_GSM;
        //End case EF_MAILBOX_CPHS EF_VOICE_MAIL_INDICATOR_CPHS EF_CFF_CPHS EF_SPN_CPHS EF_SPN_SHORT_CPHS EF_INFO_CPHS EF_CSP_CPHS 
        //Begin case EF_PBR 
        varB4EAC82CA7396A68D541C85D26508E83_26068486 = MF_SIM + DF_TELECOM + DF_PHONEBOOK;
        //End case EF_PBR 
        String path = getCommonIccEFPath(efid);
        {
            IccCard card = phone.getIccCard();
            {
                boolean var9665AFD4ACE9DC342017EA17A23CC0AF_1036057619 = (card != null && card.isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_627639161 = MF_SIM + DF_TELECOM + DF_PHONEBOOK;
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1756894489 = path;
        addTaint(efid);
        String varA7E53CE21691AB073D9660D615818899_1301948598; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1301948598 = varB4EAC82CA7396A68D541C85D26508E83_792718722;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1301948598 = varB4EAC82CA7396A68D541C85D26508E83_972430412;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1301948598 = varB4EAC82CA7396A68D541C85D26508E83_1739637963;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1301948598 = varB4EAC82CA7396A68D541C85D26508E83_26068486;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1301948598 = varB4EAC82CA7396A68D541C85D26508E83_627639161;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1301948598 = varB4EAC82CA7396A68D541C85D26508E83_1756894489;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1301948598.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1301948598;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.781 -0400", hash_original_method = "45FB79CED1F6261AE88F32026733A48A", hash_generated_method = "B3B0E3D2C2CBAB4EC384489263ADECF6")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.782 -0400", hash_original_method = "186F2705ACAE4FAB6B3F0960135671C1", hash_generated_method = "7C7025F790B2B79900FDADAD81ED13E2")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SIMFileHandler] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.782 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
}

