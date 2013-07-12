package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Map;
import android.content.Context;
import android.util.AttributeSet;

public class PreferenceCategory extends PreferenceGroup {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.539 -0400", hash_original_method = "1DC034B1500658FC000B09366B7B5F7E", hash_generated_method = "20BA41491D8D5925EEDB0F1805DC236E")
    public  PreferenceCategory(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.539 -0400", hash_original_method = "8161E913420B97F1DB3C693A6B08D371", hash_generated_method = "3004D48D6001715FD5670AE536642CFC")
    public  PreferenceCategory(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceCategoryStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.539 -0400", hash_original_method = "41E6234004F62208925BDD88189872FC", hash_generated_method = "3039D1EA2009B4CCD567FC0142143AB8")
    public  PreferenceCategory(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.539 -0400", hash_original_method = "C0B8615ABBF994242F8771673126794E", hash_generated_method = "9FDB37F22B9F4D3BFFE3B7A806CA63ED")
    @Override
    protected boolean onPrepareAddPreference(Preference preference) {
        
        addTaint(preference.getTaint());
    if(preference instanceof PreferenceCategory)        
        {
            IllegalArgumentException var65D3DF512431A2BB3A2FA11B8EF03724_2122314235 = new IllegalArgumentException(
                    "Cannot add a " + TAG + " directly to a " + TAG);
            var65D3DF512431A2BB3A2FA11B8EF03724_2122314235.addTaint(taint);
            throw var65D3DF512431A2BB3A2FA11B8EF03724_2122314235;
        } 
        boolean var960406741B1F57141D90C1CC23592FDF_1200694482 = (super.onPrepareAddPreference(preference));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872993798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872993798;
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.539 -0400", hash_original_method = "92A62D678EEB31430D80EB6E828940C3", hash_generated_method = "7C63C6578F122CE104B81E20C9C4ED80")
    @Override
    public boolean isEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_1212622388 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1944737937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1944737937;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.539 -0400", hash_original_field = "FF2B8C54098D71AD39F58C5359121C89", hash_generated_field = "441EBA3E1E175AE51D9A464A63573C42")

    private static final String TAG = "PreferenceCategory";
}

