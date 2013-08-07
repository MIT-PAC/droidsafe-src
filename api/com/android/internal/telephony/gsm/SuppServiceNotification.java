package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.telephony.PhoneNumberUtils;



public class SuppServiceNotification {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_field = "2C4033243BCB1298D8FC9ED74DC33162", hash_generated_field = "D837495804683F73D90BFDCC9932C2C7")

    public int notificationType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_field = "C13367945D5D4C91047B3B50234AA7AB", hash_generated_field = "A83EB37C39DFEB590D638EA6E29C0752")

    public int code;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "AE1343475DB0F2C28979E182E3B11BCC")

    public int index;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

    public String number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.879 -0400", hash_original_method = "874E946CBC113089EBEC7DA6D34DA654", hash_generated_method = "874E946CBC113089EBEC7DA6D34DA654")
    public SuppServiceNotification ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_method = "A03F8251EC229F0DECFD7D9A52A7C82D", hash_generated_method = "E2DF6EB38C6250BCA4DC0B8C7547568C")
    public String toString() {
String varFD564195B2D314AB58505BEAE5A1510A_1366204967 =         super.toString() + " mobile"
            + (notificationType == 0 ? " originated " : " terminated ")
            + " code: " + code
            + " index: " + index
            + " \""
            + PhoneNumberUtils.stringFromStringAndTOA(number, type) + "\" ";
        varFD564195B2D314AB58505BEAE5A1510A_1366204967.addTaint(taint);
        return varFD564195B2D314AB58505BEAE5A1510A_1366204967;
        // ---------- Original Method ----------
        //return super.toString() + " mobile"
            //+ (notificationType == 0 ? " originated " : " terminated ")
            //+ " code: " + code
            //+ " index: " + index
            //+ " \""
            //+ PhoneNumberUtils.stringFromStringAndTOA(number, type) + "\" ";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "1533078F1A5EFD91F5C02C5B27B55DF7", hash_generated_field = "F1EB9FE835B3169EA7FA978525F8CCB7")

    static public final int MO_CODE_UNCONDITIONAL_CF_ACTIVE     = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "2939345732DEFFFADC3F3524E30763FA", hash_generated_field = "4408785A22772243D1EE59B708DB0AB3")

    static public final int MO_CODE_SOME_CF_ACTIVE              = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "CF41A211843FC5A009687181ACC7F83A", hash_generated_field = "1ED22293B3A5D719283B5F3D9AC68CB9")

    static public final int MO_CODE_CALL_FORWARDED              = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "4234DECE0C7E0A167293569759C72510", hash_generated_field = "CB64282DDD8A1C5487558151424F4AAF")

    static public final int MO_CODE_CALL_IS_WAITING             = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "21A0174CF60545D0848EF10304FCA8EE", hash_generated_field = "108FCB07CA02845C5616C117817833CF")

    static public final int MO_CODE_CUG_CALL                    = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "4E7C7D0F8AF9C41235D070B8AE5CADCE", hash_generated_field = "0D3FFC61494C54A8000DECD8FFCE8307")

    static public final int MO_CODE_OUTGOING_CALLS_BARRED       = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "771EFE011ED801D230CE82379CDE12E5", hash_generated_field = "D5FFC46EBC5596863CDDB7122A22D55F")

    static public final int MO_CODE_INCOMING_CALLS_BARRED       = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "025C264FD8C2CF041DDEF5DC8F807296", hash_generated_field = "ED599169B14EEB61F20111B038DC1562")

    static public final int MO_CODE_CLIR_SUPPRESSION_REJECTED   = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "A8690775EEB4C6E7B51F78356760F48D", hash_generated_field = "66F0E9129E41BE5D1F568AC94A237B24")

    static public final int MO_CODE_CALL_DEFLECTED              = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "5B8249DA06C0BB97F4CB328E086A5119", hash_generated_field = "6CA71A07413071AD10505CE94E4E783C")

    static public final int MT_CODE_FORWARDED_CALL              = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "8E967804DEA4E294C03A40E54F74C66F", hash_generated_field = "00E2099D68C6E75FC8FB2221615EF10F")

    static public final int MT_CODE_CUG_CALL                    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "9AC8547AF4B92BA738DBFFA6265191F1", hash_generated_field = "479A901AD0FC87D8284980A9589120E5")

    static public final int MT_CODE_CALL_ON_HOLD                = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "4946DB62443075BD0AD24D8EDDF2A81D", hash_generated_field = "7675B6DFA5219B93DF9E7B105F448C38")

    static public final int MT_CODE_CALL_RETRIEVED              = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "3F79B961218B2F8959498D7E456ECEE8", hash_generated_field = "6155C37D34CA206ACC63BD7D6D3871E4")

    static public final int MT_CODE_MULTI_PARTY_CALL            = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "23DC39FC7E6253FB05CEF44A67C16E60", hash_generated_field = "C2DEE0641D616D34B56A9A61661A2AD9")

    static public final int MT_CODE_ON_HOLD_CALL_RELEASED       = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "3BD3300965050896A2974E3D441CB84C", hash_generated_field = "6E8058335394B9183A6E36C4760ECBC1")

    static public final int MT_CODE_FORWARD_CHECK_RECEIVED      = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.880 -0400", hash_original_field = "50662D4346395E6F3DE14FA021267614", hash_generated_field = "0B40A6D65E70FF7EC56162658815AA3C")

    static public final int MT_CODE_CALL_CONNECTING_ECT         = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.881 -0400", hash_original_field = "EFFEC9EAF02C89C5AA8E8EB0C14FA440", hash_generated_field = "16FBD7E8AAA6A70A7997B11D21EB16DC")

    static public final int MT_CODE_CALL_CONNECTED_ECT          = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.881 -0400", hash_original_field = "2E120B8D92319BE1EC049FAF71962472", hash_generated_field = "6EC683C2C3296AA33B0C0EBA6A5F9563")

    static public final int MT_CODE_DEFLECTED_CALL              = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.881 -0400", hash_original_field = "EB9D43040F80B52326B57DF310734F42", hash_generated_field = "0A2518F0F61F49C899A1859B95BD0A43")

    static public final int MT_CODE_ADDITIONAL_CALL_FORWARDED   = 10;
}

