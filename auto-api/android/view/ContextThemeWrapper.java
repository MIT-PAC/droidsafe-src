package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;

public class ContextThemeWrapper extends ContextWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.634 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.635 -0400", hash_original_field = "1A7BE5C50406CFB30A072C422592257E", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.635 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.635 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.635 -0400", hash_original_method = "2CB22459058FC77C2233290E776C217F", hash_generated_method = "A52E6A8077E95A96382ABDDF2BE523D0")
    public  ContextThemeWrapper() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.636 -0400", hash_original_method = "41565ED1870D25D8F04F2364AB693A1C", hash_generated_method = "BB006EB06E8E607466055A931E2EFE9A")
    public  ContextThemeWrapper(Context base, int themeres) {
        super(base);
        mBase = base;
        mThemeResource = themeres;
        // ---------- Original Method ----------
        //mBase = base;
        //mThemeResource = themeres;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.643 -0400", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "3DABDDC1F65B0CDB24F633535C22EB4F")
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
        // ---------- Original Method ----------
        //super.attachBaseContext(newBase);
        //mBase = newBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.643 -0400", hash_original_method = "E97E7D3D0BCD16FFD8F18C9341C10283", hash_generated_method = "13B2E8C961E9362FDA33D1F57040A307")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        initializeTheme();
        // ---------- Original Method ----------
        //mThemeResource = resid;
        //initializeTheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.644 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "E7E0FC065E85864DC3FE075DEEFEED3D")
    @Override
    public int getThemeResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309374001 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309374001;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.648 -0400", hash_original_method = "21593966DDD7C797D13E86548D9AA1B9", hash_generated_method = "EA71D0E9EEC07AA86A3D721D5BBFCF9F")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_105338493 = null; //Variable for return #1
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1578141040 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_105338493 = mTheme;
        } //End block
        mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                getApplicationInfo().targetSdkVersion);
        initializeTheme();
        varB4EAC82CA7396A68D541C85D26508E83_1578141040 = mTheme;
        Resources.Theme varA7E53CE21691AB073D9660D615818899_444124895; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_444124895 = varB4EAC82CA7396A68D541C85D26508E83_105338493;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_444124895 = varB4EAC82CA7396A68D541C85D26508E83_1578141040;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_444124895.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_444124895;
        // ---------- Original Method ----------
        //if (mTheme != null) {
            //return mTheme;
        //}
        //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                //getApplicationInfo().targetSdkVersion);
        //initializeTheme();
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.649 -0400", hash_original_method = "3DDCB0207132CDAFA0BFC718C36A2A86", hash_generated_method = "420545312172DCEF9A1A149A6FE019D4")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1115940265 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_147422636 = null; //Variable for return #2
        {
            boolean var28A5A9D11D394EF62378796E9CC200BC_695680337 = (LAYOUT_INFLATER_SERVICE.equals(name));
            {
                {
                    mInflater = LayoutInflater.from(mBase).cloneInContext(this);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1115940265 = mInflater;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_147422636 = mBase.getSystemService(name);
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_679244154; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_679244154 = varB4EAC82CA7396A68D541C85D26508E83_1115940265;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_679244154 = varB4EAC82CA7396A68D541C85D26508E83_147422636;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_679244154.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_679244154;
        // ---------- Original Method ----------
        //if (LAYOUT_INFLATER_SERVICE.equals(name)) {
            //if (mInflater == null) {
                //mInflater = LayoutInflater.from(mBase).cloneInContext(this);
            //}
            //return mInflater;
        //}
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.649 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "1142B6CBFFCC6F56BA7C98BDC447AE80")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        theme.applyStyle(resid, true);
        addTaint(theme.getTaint());
        addTaint(resid);
        addTaint(first);
        // ---------- Original Method ----------
        //theme.applyStyle(resid, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.650 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "EE56D5473699821C8E3327C853BB23C6")
    private void initializeTheme() {
        boolean first;
        first = mTheme == null;
        {
            mTheme = getResources().newTheme();
            Resources.Theme theme;
            theme = mBase.getTheme();
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

