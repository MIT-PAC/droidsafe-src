package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public final class EriInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.935 -0500", hash_original_field = "F371533A774E16C1A5360339412C4F13", hash_generated_field = "6A0C5051C33E7D62E3BAF75434822FCE")


    public static final int ROAMING_INDICATOR_ON    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.936 -0500", hash_original_field = "282FAF324C6410CA4E874561860991FB", hash_generated_field = "B441B006A0E3257CFC8305CBE2F710DB")

    public static final int ROAMING_INDICATOR_OFF   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.937 -0500", hash_original_field = "4563396DF0ABFF60EBF3D5BD622E37BA", hash_generated_field = "EA6ED0A49AE9F77563EC3ECE4C3C2780")

    public static final int ROAMING_INDICATOR_FLASH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.938 -0500", hash_original_field = "88EF6C7E51C8DD21913CDD9E8B902008", hash_generated_field = "FC0E5CFD9FEFA0E41F62137E2DAF8F8F")


    public static final int ROAMING_ICON_MODE_NORMAL    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.939 -0500", hash_original_field = "469F9A74436532AEBA91FFCC64F0C358", hash_generated_field = "BC4536C4233A950573945B34EC6B5CB8")

    public static final int ROAMING_ICON_MODE_FLASH     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.940 -0500", hash_original_field = "6B45D71C85146A160D302F25109C9229", hash_generated_field = "C85059890CBCB114354FFAC076E01974")


    public int mRoamingIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.940 -0500", hash_original_field = "163BC3DB44D266D2E0D599969FE1A091", hash_generated_field = "E2D3138AC87B2928B6D9F7D3E2806194")

    public int mIconIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.941 -0500", hash_original_field = "4FDF93BDA88F02959E0A7BC3ACE5E29B", hash_generated_field = "E2573C2723080B8CA6F6E83E7C9B5FCA")

    public int mIconMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.942 -0500", hash_original_field = "B5669539133B8C51E2A694C3908B5533", hash_generated_field = "6B94FFC7AEAAEC33DBD862020F0D8889")

    public String mEriText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.943 -0500", hash_original_field = "2D45C2865ADA224B1C43C9966460E739", hash_generated_field = "5A1D3B3CD1A43B21BB897437159982AE")

    public int mCallPromptId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.943 -0500", hash_original_field = "5E39647DCF5CA63D51159C8F85ADC430", hash_generated_field = "F11A924874A31CA1797A8BE7FCA7E429")

    public int mAlertId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.944 -0500", hash_original_method = "523A7CAAB1F3203BD5E6C41D254336C4", hash_generated_method = "E84685C2D0CE4AD1890EB9EDF8993FE3")
    public EriInfo (int roamingIndicator, int iconIndex, int iconMode, String eriText,
            int callPromptId, int alertId) {

        this.mRoamingIndicator = roamingIndicator;
        this.mIconIndex = iconIndex;
        this.mIconMode = iconMode;
        this.mEriText = eriText;
        this.mCallPromptId = callPromptId;
        this.mAlertId = alertId;
    }
}

