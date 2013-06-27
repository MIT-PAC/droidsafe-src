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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.824 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.825 -0400", hash_original_field = "1A7BE5C50406CFB30A072C422592257E", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.825 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.825 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.826 -0400", hash_original_method = "2CB22459058FC77C2233290E776C217F", hash_generated_method = "A52E6A8077E95A96382ABDDF2BE523D0")
    public  ContextThemeWrapper() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.827 -0400", hash_original_method = "41565ED1870D25D8F04F2364AB693A1C", hash_generated_method = "BB006EB06E8E607466055A931E2EFE9A")
    public  ContextThemeWrapper(Context base, int themeres) {
        super(base);
        mBase = base;
        mThemeResource = themeres;
        // ---------- Original Method ----------
        //mBase = base;
        //mThemeResource = themeres;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.834 -0400", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "3DABDDC1F65B0CDB24F633535C22EB4F")
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
        // ---------- Original Method ----------
        //super.attachBaseContext(newBase);
        //mBase = newBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.835 -0400", hash_original_method = "E97E7D3D0BCD16FFD8F18C9341C10283", hash_generated_method = "13B2E8C961E9362FDA33D1F57040A307")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        initializeTheme();
        // ---------- Original Method ----------
        //mThemeResource = resid;
        //initializeTheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.835 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "9612A1A6573D84B4BB0B7FF28DBD82EE")
    @Override
    public int getThemeResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350509356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350509356;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.836 -0400", hash_original_method = "21593966DDD7C797D13E86548D9AA1B9", hash_generated_method = "7C375E482F9EF93E0BD5E44817D94616")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_138073603 = null; //Variable for return #1
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1670205804 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_138073603 = mTheme;
        } //End block
        mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                getApplicationInfo().targetSdkVersion);
        initializeTheme();
        varB4EAC82CA7396A68D541C85D26508E83_1670205804 = mTheme;
        Resources.Theme varA7E53CE21691AB073D9660D615818899_2059241276; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2059241276 = varB4EAC82CA7396A68D541C85D26508E83_138073603;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2059241276 = varB4EAC82CA7396A68D541C85D26508E83_1670205804;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2059241276.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2059241276;
        // ---------- Original Method ----------
        //if (mTheme != null) {
            //return mTheme;
        //}
        //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                //getApplicationInfo().targetSdkVersion);
        //initializeTheme();
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.836 -0400", hash_original_method = "3DDCB0207132CDAFA0BFC718C36A2A86", hash_generated_method = "B850C4B38A2127A57D4F5157C81ACCA4")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_498554060 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_267912999 = null; //Variable for return #2
        {
            boolean var28A5A9D11D394EF62378796E9CC200BC_2140498746 = (LAYOUT_INFLATER_SERVICE.equals(name));
            {
                {
                    mInflater = LayoutInflater.from(mBase).cloneInContext(this);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_498554060 = mInflater;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_267912999 = mBase.getSystemService(name);
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_799189019; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_799189019 = varB4EAC82CA7396A68D541C85D26508E83_498554060;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_799189019 = varB4EAC82CA7396A68D541C85D26508E83_267912999;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_799189019.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_799189019;
        // ---------- Original Method ----------
        //if (LAYOUT_INFLATER_SERVICE.equals(name)) {
            //if (mInflater == null) {
                //mInflater = LayoutInflater.from(mBase).cloneInContext(this);
            //}
            //return mInflater;
        //}
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.850 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "1142B6CBFFCC6F56BA7C98BDC447AE80")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        theme.applyStyle(resid, true);
        addTaint(theme.getTaint());
        addTaint(resid);
        addTaint(first);
        // ---------- Original Method ----------
        //theme.applyStyle(resid, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.851 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "EE56D5473699821C8E3327C853BB23C6")
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

