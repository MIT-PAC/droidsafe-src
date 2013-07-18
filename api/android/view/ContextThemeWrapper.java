package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;

public class ContextThemeWrapper extends ContextWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.459 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.459 -0400", hash_original_field = "1A7BE5C50406CFB30A072C422592257E", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.459 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.459 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.459 -0400", hash_original_method = "2CB22459058FC77C2233290E776C217F", hash_generated_method = "A52E6A8077E95A96382ABDDF2BE523D0")
    public  ContextThemeWrapper() {
        super(new ContextImpl());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.459 -0400", hash_original_method = "41565ED1870D25D8F04F2364AB693A1C", hash_generated_method = "BB006EB06E8E607466055A931E2EFE9A")
    public  ContextThemeWrapper(Context base, int themeres) {
        super(base);
        mBase = base;
        mThemeResource = themeres;
        // ---------- Original Method ----------
        //mBase = base;
        //mThemeResource = themeres;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.460 -0400", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "3DABDDC1F65B0CDB24F633535C22EB4F")
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
        // ---------- Original Method ----------
        //super.attachBaseContext(newBase);
        //mBase = newBase;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.460 -0400", hash_original_method = "E97E7D3D0BCD16FFD8F18C9341C10283", hash_generated_method = "13B2E8C961E9362FDA33D1F57040A307")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        initializeTheme();
        // ---------- Original Method ----------
        //mThemeResource = resid;
        //initializeTheme();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.461 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "24DB9A9289BBD08519F7621BE9CDFB58")
    @Override
    public int getThemeResId() {
        int var1A7BE5C50406CFB30A072C422592257E_397224431 = (mThemeResource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032855409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1032855409;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.461 -0400", hash_original_method = "21593966DDD7C797D13E86548D9AA1B9", hash_generated_method = "D5FC933F5AAB1B473DBB06788ED3A3A7")
    @Override
    public Resources.Theme getTheme() {
   
        return null;
    }
    
    
        //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                //getApplicationInfo().targetSdkVersion);
        //initializeTheme();
        //return mTheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.462 -0400", hash_original_method = "3DDCB0207132CDAFA0BFC718C36A2A86", hash_generated_method = "A4B7F7241FDE1F674797D6E4EBA0A685")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
        return super.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.462 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "E2663BE27D6C4E8C87CFAFE15029DEFE")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(first);
        addTaint(resid);
        addTaint(theme.getTaint());
        theme.applyStyle(resid, true);
        // ---------- Original Method ----------
        //theme.applyStyle(resid, true);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.462 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "6F51DC32008736AA454500B75DDF7DAC")
    private void initializeTheme() {
        final boolean first = mTheme == null;
        if(first)        
        {
            mTheme = getResources().newTheme();
            Resources.Theme theme = mBase.getTheme();
            if(theme != null)            
            {
                mTheme.setTo(theme);
            } //End block
        } //End block
        onApplyThemeResource(mTheme, mThemeResource, first);
        // ---------- Original Method ----------
        //final boolean first = mTheme == null;
        //if (first) {
            //mTheme = getResources().newTheme();
            //Resources.Theme theme = mBase.getTheme();
            //if (theme != null) {
                //mTheme.setTo(theme);
            //}
        //}
        //onApplyThemeResource(mTheme, mThemeResource, first);
    }

    
}

