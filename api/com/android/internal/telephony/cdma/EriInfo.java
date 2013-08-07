package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.annotations.*;



public final class EriInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "2205C1E1EAD21E90ACBCE20887A9493C", hash_generated_field = "C85059890CBCB114354FFAC076E01974")

    public int mRoamingIndicator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "8C3F5B8BA7FA68451D32CCC7129899A4", hash_generated_field = "E2D3138AC87B2928B6D9F7D3E2806194")

    public int mIconIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "9D978B48EFDA9158CF1FC49D48F9F801", hash_generated_field = "E2573C2723080B8CA6F6E83E7C9B5FCA")

    public int mIconMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "A00605290C0DF90D80962ECD0EF5D2B2", hash_generated_field = "6B94FFC7AEAAEC33DBD862020F0D8889")

    public String mEriText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "2FB0AC8DD26FF5F0DD2CA5B243F49CAB", hash_generated_field = "5A1D3B3CD1A43B21BB897437159982AE")

    public int mCallPromptId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "0C1F49AB4CAE69709A2AE399B59A0568", hash_generated_field = "F11A924874A31CA1797A8BE7FCA7E429")

    public int mAlertId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_method = "523A7CAAB1F3203BD5E6C41D254336C4", hash_generated_method = "B084B59664052F9C8BC53AC488F68596")
    public  EriInfo(int roamingIndicator, int iconIndex, int iconMode, String eriText,
            int callPromptId, int alertId) {
        this.mRoamingIndicator = roamingIndicator;
        this.mIconIndex = iconIndex;
        this.mIconMode = iconMode;
        this.mEriText = eriText;
        this.mCallPromptId = callPromptId;
        this.mAlertId = alertId;
        // ---------- Original Method ----------
        //this.mRoamingIndicator = roamingIndicator;
        //this.mIconIndex = iconIndex;
        //this.mIconMode = iconMode;
        //this.mEriText = eriText;
        //this.mCallPromptId = callPromptId;
        //this.mAlertId = alertId;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "BD44D37D6539E3F6329415685D375358", hash_generated_field = "6A0C5051C33E7D62E3BAF75434822FCE")

    public static final int ROAMING_INDICATOR_ON    = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "41F2B5E0A94B488CC0338F283E07FA41", hash_generated_field = "B441B006A0E3257CFC8305CBE2F710DB")

    public static final int ROAMING_INDICATOR_OFF   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "B83470F7529CA5400F8896EFAD434A8E", hash_generated_field = "EA6ED0A49AE9F77563EC3ECE4C3C2780")

    public static final int ROAMING_INDICATOR_FLASH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "09930958C8EE8A08182014EEBB05B17E", hash_generated_field = "FC0E5CFD9FEFA0E41F62137E2DAF8F8F")

    public static final int ROAMING_ICON_MODE_NORMAL    = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.217 -0400", hash_original_field = "6C6FAB72E231752A41C57F0210A030AF", hash_generated_field = "BC4536C4233A950573945B34EC6B5CB8")

    public static final int ROAMING_ICON_MODE_FLASH     = 1;
}

