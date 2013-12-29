package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;





public class L10nUtils {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.659 -0500", hash_original_method = "F62E536510651D3E5359B74369537C8D", hash_generated_method = "A13D8D4B208EC763D6B9400340BF3C86")
    public static void setApplicationContext(Context applicationContext) {
        mApplicationContext = applicationContext.getApplicationContext();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.660 -0500", hash_original_method = "C45C66BC278CC99395C98B4B1ECDECD3", hash_generated_method = "F1CF98FF5C00D8D12789BA654899D796")
    private static String loadString(int id) {
        if (mStrings == null) {
            mStrings = new HashMap<Integer, SoftReference<String> >(mIdsArray.length);
        }

        String localisedString = mApplicationContext.getResources().getString(mIdsArray[id]);
        mStrings.put(id, new SoftReference<String>(localisedString));
        return localisedString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.661 -0500", hash_original_method = "0B4EB84B53BCA9595476DD3AEDE5C6DC", hash_generated_method = "D7DF9CF57E63246D823FD6115B6B86EC")
    public static String getLocalisedString(int id) {
        if (mStrings == null) {
            // This is the first time we need a localised string.
            // loadString will create the Map.
            return loadString(id);
        }

        SoftReference<String> ref = mStrings.get(id);
        boolean needToLoad = ref == null || ref.get() == null;
        return needToLoad ? loadString(id) : ref.get();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:00.883 -0500", hash_original_field = "91D91901C478914C965A49719F798E69", hash_generated_field = "DF6DD9A455C2ACBF5F3C2C0F13074B3B")

    // external/chromium/android/app/l10n_utils.h
    private static int[] mIdsArray = {
        com.android.internal.R.string.autofill_address_name_separator,      // IDS_AUTOFILL_DIALOG_ADDRESS_NAME_SEPARATOR
        com.android.internal.R.string.autofill_address_summary_name_format, // IDS_AUTOFILL_DIALOG_ADDRESS_SUMMARY_NAME_FORMAT
        com.android.internal.R.string.autofill_address_summary_separator,   // IDS_AUTOFILL_DIALOG_ADDRESS_SUMMARY_SEPARATOR
        com.android.internal.R.string.autofill_address_summary_format,      // IDS_AUTOFILL_DIALOG_ADDRESS_SUMMARY_FORMAT
        com.android.internal.R.string.autofill_attention_ignored_re,        // IDS_AUTOFILL_ATTENTION_IGNORED_RE
        com.android.internal.R.string.autofill_region_ignored_re,           // IDS_AUTOFILL_REGION_IGNORED_RE
        com.android.internal.R.string.autofill_company_re,                  // IDS_AUTOFILL_COMPANY_RE
        com.android.internal.R.string.autofill_address_line_1_re,           // IDS_AUTOFILL_ADDRESS_LINE_1_RE
        com.android.internal.R.string.autofill_address_line_1_label_re,     // IDS_AUTOFILL_ADDRESS_LINE_1_LABEL_RE
        com.android.internal.R.string.autofill_address_line_2_re,           // IDS_AUTOFILL_ADDRESS_LINE_2_RE
        com.android.internal.R.string.autofill_address_line_3_re,           // IDS_AUTOFILL_ADDRESS_LINE_3_RE
        com.android.internal.R.string.autofill_country_re,                  // IDS_AUTOFILL_COUNTRY_RE
        com.android.internal.R.string.autofill_zip_code_re,                 // IDS_AUTOFILL_ZIP_CODE_RE
        com.android.internal.R.string.autofill_zip_4_re,                    // IDS_AUTOFILL_ZIP_4_RE
        com.android.internal.R.string.autofill_city_re,                     // IDS_AUTOFILL_CITY_RE
        com.android.internal.R.string.autofill_state_re,                    // IDS_AUTOFILL_STATE_RE
        com.android.internal.R.string.autofill_address_type_same_as_re,     // IDS_AUTOFILL_SAME_AS_RE
        com.android.internal.R.string.autofill_address_type_use_my_re,      // IDS_AUTOFILL_USE_MY_RE
        com.android.internal.R.string.autofill_billing_designator_re,       // IDS_AUTOFILL_BILLING_DESIGNATOR_RE
        com.android.internal.R.string.autofill_shipping_designator_re,      // IDS_AUTOFILL_SHIPPING_DESIGNATOR_RE
        com.android.internal.R.string.autofill_email_re,                    // IDS_AUTOFILL_EMAIL_RE
        com.android.internal.R.string.autofill_username_re,                 // IDS_AUTOFILL_USERNAME_RE
        com.android.internal.R.string.autofill_name_re,                     // IDS_AUTOFILL_NAME_RE
        com.android.internal.R.string.autofill_name_specific_re,            // IDS_AUTOFILL_NAME_SPECIFIC_RE
        com.android.internal.R.string.autofill_first_name_re,               // IDS_AUTOFILL_FIRST_NAME_RE
        com.android.internal.R.string.autofill_middle_initial_re,           // IDS_AUTOFILL_MIDDLE_INITIAL_RE
        com.android.internal.R.string.autofill_middle_name_re,              // IDS_AUTOFILL_MIDDLE_NAME_RE
        com.android.internal.R.string.autofill_last_name_re,                // IDS_AUTOFILL_LAST_NAME_RE
        com.android.internal.R.string.autofill_phone_re,                    // IDS_AUTOFILL_PHONE_RE
        com.android.internal.R.string.autofill_area_code_re,                // IDS_AUTOFILL_AREA_CODE_RE
        com.android.internal.R.string.autofill_phone_prefix_re,             // IDS_AUTOFILL_PHONE_PREFIX_RE
        com.android.internal.R.string.autofill_phone_suffix_re,             // IDS_AUTOFILL_PHONE_SUFFIX_RE
        com.android.internal.R.string.autofill_phone_extension_re,          // IDS_AUTOFILL_PHONE_EXTENSION_RE
        com.android.internal.R.string.autofill_name_on_card_re,             // IDS_AUTOFILL_NAME_ON_CARD_RE
        com.android.internal.R.string.autofill_name_on_card_contextual_re,  // IDS_AUTOFILL_NAME_ON_CARD_CONTEXTUAL_RE
        com.android.internal.R.string.autofill_card_cvc_re,                 // IDS_AUTOFILL_CARD_CVC_RE
        com.android.internal.R.string.autofill_card_number_re,              // IDS_AUTOFILL_CARD_NUMBER_RE
        com.android.internal.R.string.autofill_expiration_month_re,         // IDS_AUTOFILL_EXPIRATION_MONTH_RE
        com.android.internal.R.string.autofill_expiration_date_re,          // IDS_AUTOFILL_EXPIRATION_DATE_RE
        com.android.internal.R.string.autofill_card_ignored_re,             // IDS_AUTOFILL_CARD_IGNORED_RE
        com.android.internal.R.string.autofill_fax_re,                      // IDS_AUTOFILL_FAX_RE
        com.android.internal.R.string.autofill_country_code_re,             // IDS_AUTOFILL_COUNTRY_CODE_RE
        com.android.internal.R.string.autofill_area_code_notext_re,         // IDS_AUTOFILL_AREA_CODE_NOTEXT_RE
        com.android.internal.R.string.autofill_phone_prefix_separator_re,   // IDS_AUTOFILL_PHONE_PREFIX_SEPARATOR_RE
        com.android.internal.R.string.autofill_phone_suffix_separator_re,   // IDS_AUTOFILL_PHONE_SUFFIX_SEPARATOR_RE
        com.android.internal.R.string.autofill_province,                    // IDS_AUTOFILL_DIALOG_PROVINCE
        com.android.internal.R.string.autofill_postal_code,                 // IDS_AUTOFILL_DIALOG_POSTAL_CODE
        com.android.internal.R.string.autofill_state,                       // IDS_AUTOFILL_DIALOG_STATE
        com.android.internal.R.string.autofill_zip_code,                    // IDS_AUTOFILL_DIALOG_ZIP_CODE
        com.android.internal.R.string.autofill_county,                      // IDS_AUTOFILL_DIALOG_COUNTY
        com.android.internal.R.string.autofill_island,                      // IDS_AUTOFILL_DIALOG_ISLAND
        com.android.internal.R.string.autofill_district,                    // IDS_AUTOFILL_DIALOG_DISTRICT
        com.android.internal.R.string.autofill_department,                  // IDS_AUTOFILL_DIALOG_DEPARTMENT
        com.android.internal.R.string.autofill_prefecture,                  // IDS_AUTOFILL_DIALOG_PREFECTURE
        com.android.internal.R.string.autofill_parish,                      // IDS_AUTOFILL_DIALOG_PARISH
        com.android.internal.R.string.autofill_area,                        // IDS_AUTOFILL_DIALOG_AREA
        com.android.internal.R.string.autofill_emirate                      // IDS_AUTOFILL_DIALOG_EMIRATE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.658 -0500", hash_original_field = "84B225E4BC68B4F650B6DB7632FCB17C", hash_generated_field = "5F3084FB57196F92DB8F6420AA6F05A0")


    private static Context mApplicationContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.658 -0500", hash_original_field = "B3EE038AA4B382F368453F90F212C77B", hash_generated_field = "03A40345C7339DC0F9BFF7212E392A68")

    private static Map<Integer, SoftReference<String> > mStrings;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.295 -0400", hash_original_method = "E0BD4E5359B29F1B1ED75AB21E0F35C1", hash_generated_method = "E0BD4E5359B29F1B1ED75AB21E0F35C1")
    public L10nUtils ()
    {
        //Synthesized constructor
    }
}

