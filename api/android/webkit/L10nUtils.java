package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.HashMap;

public class L10nUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.549 -0400", hash_original_method = "E0BD4E5359B29F1B1ED75AB21E0F35C1", hash_generated_method = "E0BD4E5359B29F1B1ED75AB21E0F35C1")
    public L10nUtils ()
    {
        //Synthesized constructor
    }


        public static void setApplicationContext(Context applicationContext) {
        mApplicationContext = applicationContext.getApplicationContext();
    }

    
        private static String loadString(int id) {
        if (mStrings == null) {
            mStrings = new HashMap<Integer, SoftReference<String> >(mIdsArray.length);
        }
        String localisedString = mApplicationContext.getResources().getString(mIdsArray[id]);
        mStrings.put(id, new SoftReference<String>(localisedString));
        return localisedString;
    }

    
        @DSModeled(DSC.SPEC)
    public static String getLocalisedString(int id) {
        if (mStrings == null) {
            return loadString(id);
        }
        SoftReference<String> ref = mStrings.get(id);
        boolean needToLoad = ref == null || ref.get() == null;
        return needToLoad ? loadString(id) : ref.get();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.550 -0400", hash_original_field = "B4DBCA199BDC3444A5F5A15518240E71", hash_generated_field = "696D9AD877146F078F0534427452F3E8")

    private static int[] mIdsArray = {
        com.android.internal.R.string.autofill_address_name_separator,      
        com.android.internal.R.string.autofill_address_summary_name_format, 
        com.android.internal.R.string.autofill_address_summary_separator,   
        com.android.internal.R.string.autofill_address_summary_format,      
        com.android.internal.R.string.autofill_attention_ignored_re,        
        com.android.internal.R.string.autofill_region_ignored_re,           
        com.android.internal.R.string.autofill_company_re,                  
        com.android.internal.R.string.autofill_address_line_1_re,           
        com.android.internal.R.string.autofill_address_line_1_label_re,     
        com.android.internal.R.string.autofill_address_line_2_re,           
        com.android.internal.R.string.autofill_address_line_3_re,           
        com.android.internal.R.string.autofill_country_re,                  
        com.android.internal.R.string.autofill_zip_code_re,                 
        com.android.internal.R.string.autofill_zip_4_re,                    
        com.android.internal.R.string.autofill_city_re,                     
        com.android.internal.R.string.autofill_state_re,                    
        com.android.internal.R.string.autofill_address_type_same_as_re,     
        com.android.internal.R.string.autofill_address_type_use_my_re,      
        com.android.internal.R.string.autofill_billing_designator_re,       
        com.android.internal.R.string.autofill_shipping_designator_re,      
        com.android.internal.R.string.autofill_email_re,                    
        com.android.internal.R.string.autofill_username_re,                 
        com.android.internal.R.string.autofill_name_re,                     
        com.android.internal.R.string.autofill_name_specific_re,            
        com.android.internal.R.string.autofill_first_name_re,               
        com.android.internal.R.string.autofill_middle_initial_re,           
        com.android.internal.R.string.autofill_middle_name_re,              
        com.android.internal.R.string.autofill_last_name_re,                
        com.android.internal.R.string.autofill_phone_re,                    
        com.android.internal.R.string.autofill_area_code_re,                
        com.android.internal.R.string.autofill_phone_prefix_re,             
        com.android.internal.R.string.autofill_phone_suffix_re,             
        com.android.internal.R.string.autofill_phone_extension_re,          
        com.android.internal.R.string.autofill_name_on_card_re,             
        com.android.internal.R.string.autofill_name_on_card_contextual_re,  
        com.android.internal.R.string.autofill_card_cvc_re,                 
        com.android.internal.R.string.autofill_card_number_re,              
        com.android.internal.R.string.autofill_expiration_month_re,         
        com.android.internal.R.string.autofill_expiration_date_re,          
        com.android.internal.R.string.autofill_card_ignored_re,             
        com.android.internal.R.string.autofill_fax_re,                      
        com.android.internal.R.string.autofill_country_code_re,             
        com.android.internal.R.string.autofill_area_code_notext_re,         
        com.android.internal.R.string.autofill_phone_prefix_separator_re,   
        com.android.internal.R.string.autofill_phone_suffix_separator_re,   
        com.android.internal.R.string.autofill_province,                    
        com.android.internal.R.string.autofill_postal_code,                 
        com.android.internal.R.string.autofill_state,                       
        com.android.internal.R.string.autofill_zip_code,                    
        com.android.internal.R.string.autofill_county,                      
        com.android.internal.R.string.autofill_island,                      
        com.android.internal.R.string.autofill_district,                    
        com.android.internal.R.string.autofill_department,                  
        com.android.internal.R.string.autofill_prefecture,                  
        com.android.internal.R.string.autofill_parish,                      
        com.android.internal.R.string.autofill_area,                        
        com.android.internal.R.string.autofill_emirate                      
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.551 -0400", hash_original_field = "BCB208A03C79579955DC455811823AC0", hash_generated_field = "5F3084FB57196F92DB8F6420AA6F05A0")

    private static Context mApplicationContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.551 -0400", hash_original_field = "DCFA8FC1CFB8B5A5290D25EC1EA3C56B", hash_generated_field = "03A40345C7339DC0F9BFF7212E392A68")

    private static Map<Integer, SoftReference<String> > mStrings;
}

