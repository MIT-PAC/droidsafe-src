package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.telephony.PhoneNumberUtils;

public class SuppServiceNotification {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.503 -0500", hash_original_field = "AE081512BA6A61C402E7FE5CED6A10CB", hash_generated_field = "F1EB9FE835B3169EA7FA978525F8CCB7")

    static public final int MO_CODE_UNCONDITIONAL_CF_ACTIVE     = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.507 -0500", hash_original_field = "EA7D1255B737BCB0B208CFABCDDBE402", hash_generated_field = "4408785A22772243D1EE59B708DB0AB3")

    static public final int MO_CODE_SOME_CF_ACTIVE              = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.511 -0500", hash_original_field = "D356F1C00AA60931F0EB9E63243C2A5F", hash_generated_field = "1ED22293B3A5D719283B5F3D9AC68CB9")

    static public final int MO_CODE_CALL_FORWARDED              = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.513 -0500", hash_original_field = "694998E5DB5B0E31612BA594B27E43D0", hash_generated_field = "CB64282DDD8A1C5487558151424F4AAF")

    static public final int MO_CODE_CALL_IS_WAITING             = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.516 -0500", hash_original_field = "BF4201870E17A6739370D973F576BF95", hash_generated_field = "108FCB07CA02845C5616C117817833CF")

    static public final int MO_CODE_CUG_CALL                    = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.518 -0500", hash_original_field = "24ACBB265C982A5F9D1A47F10F38B771", hash_generated_field = "0D3FFC61494C54A8000DECD8FFCE8307")

    static public final int MO_CODE_OUTGOING_CALLS_BARRED       = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.521 -0500", hash_original_field = "8037CB44434DA2A61E03EC07EC5A7B68", hash_generated_field = "D5FFC46EBC5596863CDDB7122A22D55F")

    static public final int MO_CODE_INCOMING_CALLS_BARRED       = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.524 -0500", hash_original_field = "A52543F01016EB1134CE092D1383F061", hash_generated_field = "ED599169B14EEB61F20111B038DC1562")

    static public final int MO_CODE_CLIR_SUPPRESSION_REJECTED   = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.526 -0500", hash_original_field = "D24B1B9E0A247C008758B1AA4C73AF3B", hash_generated_field = "66F0E9129E41BE5D1F568AC94A237B24")

    static public final int MO_CODE_CALL_DEFLECTED              = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.529 -0500", hash_original_field = "7B9E300FEDCFAAF5F1EA70CF68BF9852", hash_generated_field = "6CA71A07413071AD10505CE94E4E783C")

    static public final int MT_CODE_FORWARDED_CALL              = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.531 -0500", hash_original_field = "FE15C5D425E62E4FD3A99320BA7E6FBB", hash_generated_field = "00E2099D68C6E75FC8FB2221615EF10F")

    static public final int MT_CODE_CUG_CALL                    = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.534 -0500", hash_original_field = "52B8785B7B3985FA214B68134DE3C83C", hash_generated_field = "479A901AD0FC87D8284980A9589120E5")

    static public final int MT_CODE_CALL_ON_HOLD                = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.536 -0500", hash_original_field = "3AC7584168837BBB150B0B1605CE3395", hash_generated_field = "7675B6DFA5219B93DF9E7B105F448C38")

    static public final int MT_CODE_CALL_RETRIEVED              = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.539 -0500", hash_original_field = "D8D1DE962180A3823A67E3028C92CEA9", hash_generated_field = "6155C37D34CA206ACC63BD7D6D3871E4")

    static public final int MT_CODE_MULTI_PARTY_CALL            = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.541 -0500", hash_original_field = "1680E23F206EBFE0ED762BDA15FA70FB", hash_generated_field = "C2DEE0641D616D34B56A9A61661A2AD9")

    static public final int MT_CODE_ON_HOLD_CALL_RELEASED       = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.544 -0500", hash_original_field = "099449A3FF4EF03B5E9EED3CE15175CF", hash_generated_field = "6E8058335394B9183A6E36C4760ECBC1")

    static public final int MT_CODE_FORWARD_CHECK_RECEIVED      = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.547 -0500", hash_original_field = "D71639EABEF9FD97D32C825B3678EEE6", hash_generated_field = "0B40A6D65E70FF7EC56162658815AA3C")

    static public final int MT_CODE_CALL_CONNECTING_ECT         = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.549 -0500", hash_original_field = "C21B4BF0D0195AB4A37B6742B02B319B", hash_generated_field = "16FBD7E8AAA6A70A7997B11D21EB16DC")

    static public final int MT_CODE_CALL_CONNECTED_ECT          = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.553 -0500", hash_original_field = "D4B4F896AA72CFA6EB0B7FFD913D24CD", hash_generated_field = "6EC683C2C3296AA33B0C0EBA6A5F9563")

    static public final int MT_CODE_DEFLECTED_CALL              = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.555 -0500", hash_original_field = "96C70CB764F2949DEA8FA73B456B0FD2", hash_generated_field = "0A2518F0F61F49C899A1859B95BD0A43")

    static public final int MT_CODE_ADDITIONAL_CALL_FORWARDED   = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.490 -0500", hash_original_field = "8C400C0B29CC4923C60A6CE294D7E981", hash_generated_field = "D837495804683F73D90BFDCC9932C2C7")

    public int notificationType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.493 -0500", hash_original_field = "0AB25991A8A700F155BF903F62C1F5DA", hash_generated_field = "A83EB37C39DFEB590D638EA6E29C0752")

    public int code;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.495 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "AE1343475DB0F2C28979E182E3B11BCC")

    public int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.498 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.500 -0500", hash_original_field = "F0C1D0D479817313A0A5D4AB9BD9FA68", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

    public String number;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_method = "874E946CBC113089EBEC7DA6D34DA654", hash_generated_method = "874E946CBC113089EBEC7DA6D34DA654")
    public SuppServiceNotification ()
    {
        //Synthesized constructor
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:25.557 -0500", hash_original_method = "A03F8251EC229F0DECFD7D9A52A7C82D", hash_generated_method = "1811F7F2DF592112F2E9142BD3B95082")
    
public String toString()
    {
        return super.toString() + " mobile"
            + (notificationType == 0 ? " originated " : " terminated ")
            + " code: " + code
            + " index: " + index
            + " \""
            + PhoneNumberUtils.stringFromStringAndTOA(number, type) + "\" ";
    }
}

