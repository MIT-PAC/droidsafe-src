package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;

public class ContextThemeWrapper extends ContextWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.871 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.871 -0400", hash_original_field = "1A7BE5C50406CFB30A072C422592257E", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.871 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.871 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.871 -0400", hash_original_method = "2CB22459058FC77C2233290E776C217F", hash_generated_method = "A52E6A8077E95A96382ABDDF2BE523D0")
    public  ContextThemeWrapper() {
        super(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.872 -0400", hash_original_method = "41565ED1870D25D8F04F2364AB693A1C", hash_generated_method = "BB006EB06E8E607466055A931E2EFE9A")
    public  ContextThemeWrapper(Context base, int themeres) {
        super(base);
        mBase = base;
        mThemeResource = themeres;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.872 -0400", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "3DABDDC1F65B0CDB24F633535C22EB4F")
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.872 -0400", hash_original_method = "E97E7D3D0BCD16FFD8F18C9341C10283", hash_generated_method = "13B2E8C961E9362FDA33D1F57040A307")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        initializeTheme();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.873 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "6C955D308137962A04F7AD6468897331")
    @Override
    public int getThemeResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057692376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057692376;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.873 -0400", hash_original_method = "21593966DDD7C797D13E86548D9AA1B9", hash_generated_method = "63DF15B2850C1821A7F8C6FDFF6AF27D")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1991870555 = null; 
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_306630786 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1991870555 = mTheme;
        } 
        mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                getApplicationInfo().targetSdkVersion);
        initializeTheme();
        varB4EAC82CA7396A68D541C85D26508E83_306630786 = mTheme;
        Resources.Theme varA7E53CE21691AB073D9660D615818899_1283671401; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1283671401 = varB4EAC82CA7396A68D541C85D26508E83_1991870555;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1283671401 = varB4EAC82CA7396A68D541C85D26508E83_306630786;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1283671401.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1283671401;
        
        
            
        
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.874 -0400", hash_original_method = "3DDCB0207132CDAFA0BFC718C36A2A86", hash_generated_method = "5B2CA5D0D42249B9DF7AB980F5439A17")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_602963228 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1584943584 = null; 
        {
            boolean var28A5A9D11D394EF62378796E9CC200BC_1250996976 = (LAYOUT_INFLATER_SERVICE.equals(name));
            {
                {
                    mInflater = LayoutInflater.from(mBase).cloneInContext(this);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_602963228 = mInflater;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1584943584 = mBase.getSystemService(name);
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2067325039; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2067325039 = varB4EAC82CA7396A68D541C85D26508E83_602963228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2067325039 = varB4EAC82CA7396A68D541C85D26508E83_1584943584;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2067325039.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2067325039;
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.875 -0400", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "1142B6CBFFCC6F56BA7C98BDC447AE80")
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        
        theme.applyStyle(resid, true);
        addTaint(theme.getTaint());
        addTaint(resid);
        addTaint(first);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.876 -0400", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "641C6743CDDFCE1A85D0CEF08B9EB394")
    private void initializeTheme() {
        final boolean first = mTheme == null;
        {
            mTheme = getResources().newTheme();
            Resources.Theme theme = mBase.getTheme();
            {
                mTheme.setTo(theme);
            } 
        } 
        onApplyThemeResource(mTheme, mThemeResource, first);
        
        
        
            
            
            
                
            
        
        
    }

    
}

