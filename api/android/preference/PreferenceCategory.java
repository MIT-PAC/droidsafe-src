package android.preference;

// Droidsafe Imports
import android.content.Context;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PreferenceCategory extends PreferenceGroup {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.541 -0400", hash_original_method = "1DC034B1500658FC000B09366B7B5F7E", hash_generated_method = "20BA41491D8D5925EEDB0F1805DC236E")
    public  PreferenceCategory(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.541 -0400", hash_original_method = "8161E913420B97F1DB3C693A6B08D371", hash_generated_method = "3004D48D6001715FD5670AE536642CFC")
    public  PreferenceCategory(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.preferenceCategoryStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.541 -0400", hash_original_method = "41E6234004F62208925BDD88189872FC", hash_generated_method = "3039D1EA2009B4CCD567FC0142143AB8")
    public  PreferenceCategory(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.542 -0400", hash_original_method = "C0B8615ABBF994242F8771673126794E", hash_generated_method = "C6291D5495139D5C2FF1E9FFB17BC574")
    @Override
    protected boolean onPrepareAddPreference(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preference.getTaint());
        if(preference instanceof PreferenceCategory)        
        {
            IllegalArgumentException var65D3DF512431A2BB3A2FA11B8EF03724_66695484 = new IllegalArgumentException(
                    "Cannot add a " + TAG + " directly to a " + TAG);
            var65D3DF512431A2BB3A2FA11B8EF03724_66695484.addTaint(taint);
            throw var65D3DF512431A2BB3A2FA11B8EF03724_66695484;
        } //End block
        boolean var960406741B1F57141D90C1CC23592FDF_872605938 = (super.onPrepareAddPreference(preference));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645124099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645124099;
        // ---------- Original Method ----------
        //if (preference instanceof PreferenceCategory) {
            //throw new IllegalArgumentException(
                    //"Cannot add a " + TAG + " directly to a " + TAG);
        //}
        //return super.onPrepareAddPreference(preference);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.542 -0400", hash_original_method = "92A62D678EEB31430D80EB6E828940C3", hash_generated_method = "D43CB99C905D2169F57B85C54533253B")
    @Override
    public boolean isEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_423328079 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151641272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151641272;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.542 -0400", hash_original_field = "FF2B8C54098D71AD39F58C5359121C89", hash_generated_field = "441EBA3E1E175AE51D9A464A63573C42")

    private static final String TAG = "PreferenceCategory";
}

