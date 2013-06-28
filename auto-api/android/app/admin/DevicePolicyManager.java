package android.app.admin;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public class DevicePolicyManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.922 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.922 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "E263D54C98D833F4BF6DB51617AA3116")

    private IDevicePolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.923 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "524043B477AF9FF34438AF5C661E38DE")
    private  DevicePolicyManager(Context context, Handler handler) {
        mContext = context;
        mService = IDevicePolicyManager.Stub.asInterface(
                ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
        //mContext = context;
        //mService = IDevicePolicyManager.Stub.asInterface(
                //ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
    }

    
    public static DevicePolicyManager create(Context context, Handler handler) {
        DevicePolicyManager me = new DevicePolicyManager(context, handler);
        return me.mService != null ? me : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.924 -0400", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "9A69B2FB077F9F9A3CF95FD043DB407A")
    public boolean isAdminActive(ComponentName who) {
        {
            try 
            {
                boolean varDDC18424843F25DBAC66701537992DCA_1192899159 = (mService.isAdminActive(who));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1864382628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1864382628;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.isAdminActive(who);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.925 -0400", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "339839AC4D577988AE46B2E74EE04A7E")
    public List<ComponentName> getActiveAdmins() {
        List<ComponentName> varB4EAC82CA7396A68D541C85D26508E83_1631496007 = null; //Variable for return #1
        List<ComponentName> varB4EAC82CA7396A68D541C85D26508E83_587331257 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1631496007 = mService.getActiveAdmins();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_587331257 = null;
        List<ComponentName> varA7E53CE21691AB073D9660D615818899_657503427; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_657503427 = varB4EAC82CA7396A68D541C85D26508E83_1631496007;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_657503427 = varB4EAC82CA7396A68D541C85D26508E83_587331257;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_657503427.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_657503427;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getActiveAdmins();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.926 -0400", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "9C8B045A279E4897ED525ADC9B4CD9D0")
    public boolean packageHasActiveAdmins(String packageName) {
        {
            try 
            {
                boolean var9AD91614F7E6A3EB6B4DC1ED0C825051_1906095579 = (mService.packageHasActiveAdmins(packageName));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231041296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231041296;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.packageHasActiveAdmins(packageName);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.926 -0400", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "6EA59A0440FE573C813306A48A8E217B")
    public void removeActiveAdmin(ComponentName who) {
        {
            try 
            {
                mService.removeActiveAdmin(who);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(who.getTaint());
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.removeActiveAdmin(who);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.927 -0400", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "DC2EEFF5BFDC049CBDA42B5EE25B4629")
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        {
            try 
            {
                boolean var8293FAA2FE4C2CA275B458FF6F9999B9_477404518 = (mService.hasGrantedPolicy(admin, usesPolicy));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(usesPolicy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_284438974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_284438974;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.hasGrantedPolicy(admin, usesPolicy);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.928 -0400", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "9FDBC76BAE013CE84EAFAEF37BFDE2F5")
    public void setPasswordQuality(ComponentName admin, int quality) {
        {
            try 
            {
                mService.setPasswordQuality(admin, quality);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(quality);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordQuality(admin, quality);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.929 -0400", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "35CD255AACB5AC701FA51B26E743448B")
    public int getPasswordQuality(ComponentName admin) {
        {
            try 
            {
                int var50B1D404B3237CB299636EA0B85E73CC_273386326 = (mService.getPasswordQuality(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940993498 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940993498;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordQuality(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return PASSWORD_QUALITY_UNSPECIFIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.931 -0400", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "6DC6D87FB778258FF0F3B22E7DBFF2FF")
    public void setPasswordMinimumLength(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumLength(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumLength(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.933 -0400", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "8CF8261A0D1AF050339B463B4E19E531")
    public int getPasswordMinimumLength(ComponentName admin) {
        {
            try 
            {
                int var3F407E749EA5B2DC2542A0A7919871DB_1288787351 = (mService.getPasswordMinimumLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22859507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22859507;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumLength(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.933 -0400", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "6D318F55E14BD3E2DA2ED639019FBFD5")
    public void setPasswordMinimumUpperCase(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumUpperCase(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumUpperCase(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.934 -0400", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "8915646D168ECE6281593440110CE91C")
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        {
            try 
            {
                int var99860992B7CBA8049416DD538EB3AE3F_1930804871 = (mService.getPasswordMinimumUpperCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656354796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_656354796;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumUpperCase(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.935 -0400", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "82735EDD2D8A123C967F31FE2D156E9F")
    public void setPasswordMinimumLowerCase(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumLowerCase(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumLowerCase(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.935 -0400", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "0FC3FB08BA684A67ABCD0C4BD9C9054D")
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        {
            try 
            {
                int var777E882DCA72E018D863B51B9CC2D33E_782862880 = (mService.getPasswordMinimumLowerCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784075992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784075992;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumLowerCase(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.936 -0400", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "1C9BDE4A1D4ECBBA2F1545821B0C21E0")
    public void setPasswordMinimumLetters(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumLetters(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumLetters(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.937 -0400", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "920D0E6676007EFD532F2E7E29A5A993")
    public int getPasswordMinimumLetters(ComponentName admin) {
        {
            try 
            {
                int var579CFE59F49EAFA16CF346F87A7CF37C_701698772 = (mService.getPasswordMinimumLetters(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177962662 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177962662;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumLetters(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.937 -0400", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "601979EDE201953B62CA61F225A4DE0D")
    public void setPasswordMinimumNumeric(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumNumeric(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumNumeric(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.938 -0400", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "5D3E9430492F755D259A0725B5AFE2AA")
    public int getPasswordMinimumNumeric(ComponentName admin) {
        {
            try 
            {
                int varA96658E08799B3973A9806AB9C11888E_1241831771 = (mService.getPasswordMinimumNumeric(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540219893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540219893;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumNumeric(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.939 -0400", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "64C4010E7179237238E1B4DBC3BE193A")
    public void setPasswordMinimumSymbols(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumSymbols(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumSymbols(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.941 -0400", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "948641B6006C4D773C6D2971CEA9AA37")
    public int getPasswordMinimumSymbols(ComponentName admin) {
        {
            try 
            {
                int varC5459125C02CCD305A9D65BA82E945C4_1020858259 = (mService.getPasswordMinimumSymbols(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349880746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_349880746;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumSymbols(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.942 -0400", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "97B1F6F6A29F5A41E50C30F58D1C8D37")
    public void setPasswordMinimumNonLetter(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordMinimumNonLetter(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumNonLetter(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.943 -0400", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "932DA6DFEA4099A907EED93FC0AED1E3")
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        {
            try 
            {
                int varA4D869D416A4BC57B2A8EF3FBE9140CA_89981387 = (mService.getPasswordMinimumNonLetter(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626184660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_626184660;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordMinimumNonLetter(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.944 -0400", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "D678A9E9382AA5D5CEDED3FACC7F8BFD")
    public void setPasswordHistoryLength(ComponentName admin, int length) {
        {
            try 
            {
                mService.setPasswordHistoryLength(admin, length);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordHistoryLength(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.944 -0400", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "756F1865BBAAC520E5B68926D710F6E7")
    public void setPasswordExpirationTimeout(ComponentName admin, long timeout) {
        {
            try 
            {
                mService.setPasswordExpirationTimeout(admin, timeout);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(timeout);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordExpirationTimeout(admin, timeout);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.945 -0400", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "807C4CE0628D1F7B5320ACA31C4FC531")
    public long getPasswordExpirationTimeout(ComponentName admin) {
        {
            try 
            {
                long var8E0E92ED0AE24F586AFBAEFC4C90C962_1218107624 = (mService.getPasswordExpirationTimeout(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_790000492 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_790000492;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordExpirationTimeout(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.946 -0400", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "2F4D5E4227072603A207961B4DC8E20E")
    public long getPasswordExpiration(ComponentName admin) {
        {
            try 
            {
                long varA425B12B3ADC7B11B7AB412B878E8D27_953700056 = (mService.getPasswordExpiration(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_500866459 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_500866459;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordExpiration(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.946 -0400", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "4FEFEE46AA46209B7111C66A9C179F61")
    public int getPasswordHistoryLength(ComponentName admin) {
        {
            try 
            {
                int var6B58013F3CE3A15346CE8AB072CAF025_624971838 = (mService.getPasswordHistoryLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739365271 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739365271;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getPasswordHistoryLength(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.947 -0400", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "4407096FAB260474A393C271A191A6DF")
    public int getPasswordMaximumLength(int quality) {
        addTaint(quality);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752806107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752806107;
        // ---------- Original Method ----------
        //return 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.947 -0400", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "77AC162A93A81AC5C594E755E3F984D3")
    public boolean isActivePasswordSufficient() {
        {
            try 
            {
                boolean var4C9DBF611B0D22EF5B0E4B1EC5D17B72_252773534 = (mService.isActivePasswordSufficient());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122079137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122079137;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.isActivePasswordSufficient();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.948 -0400", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "174947D6F3884B266AED98FCF08209B0")
    public int getCurrentFailedPasswordAttempts() {
        {
            try 
            {
                int varACF84C8123F19D3EC9F60D2D8BF605DA_1314976785 = (mService.getCurrentFailedPasswordAttempts());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835559403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835559403;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getCurrentFailedPasswordAttempts();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.949 -0400", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "2BB86C216254E218A8002EBD091C4455")
    public void setMaximumFailedPasswordsForWipe(ComponentName admin, int num) {
        {
            try 
            {
                mService.setMaximumFailedPasswordsForWipe(admin, num);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(num);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setMaximumFailedPasswordsForWipe(admin, num);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.951 -0400", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "24C8A19B27041899D37B45281EF10587")
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        {
            try 
            {
                int var79667AF6709342EB68CFAD29539CB206_2125333154 = (mService.getMaximumFailedPasswordsForWipe(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2054992812 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2054992812;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getMaximumFailedPasswordsForWipe(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.952 -0400", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "BA1358BB1135C9C2566B25C5DF25B5A3")
    public boolean resetPassword(String password, int flags) {
        {
            try 
            {
                boolean var60406D42B56A6445438EDD773C9D0828_1628409346 = (mService.resetPassword(password, flags));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(password.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_913157542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_913157542;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.resetPassword(password, flags);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.953 -0400", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "4D2C81E2CACF7573CBDB4D08D15D23CF")
    public void setMaximumTimeToLock(ComponentName admin, long timeMs) {
        {
            try 
            {
                mService.setMaximumTimeToLock(admin, timeMs);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(timeMs);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setMaximumTimeToLock(admin, timeMs);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.954 -0400", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "0F74BCB4496EBDE899BDCB4CEDBE89A8")
    public long getMaximumTimeToLock(ComponentName admin) {
        {
            try 
            {
                long varB8C855E033294E8C52BAAD4F39092DB8_1455162057 = (mService.getMaximumTimeToLock(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2053034317 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2053034317;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getMaximumTimeToLock(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.954 -0400", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "AB2EEBEA8902EB56BFA2E2D0BFBEA706")
    public void lockNow() {
        {
            try 
            {
                mService.lockNow();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.lockNow();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.955 -0400", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "7B8F651EA306BC200E0748C3408D080E")
    public void wipeData(int flags) {
        {
            try 
            {
                mService.wipeData(flags);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(flags);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.wipeData(flags);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.002 -0400", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "D9FAA5D275CCB5A0F96FB2A2EFC680E1")
    public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_497111841 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1210698897 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            try 
            {
                String hostSpec;
                String exclSpec;
                {
                    boolean varAEB17C6E60EDCE7B80F1428467000DDC_430465707 = (proxySpec.equals(Proxy.NO_PROXY));
                    {
                        hostSpec = null;
                        exclSpec = null;
                    } //End block
                    {
                        {
                            boolean varD0F96407A07133F267A111443D9B66E2_1248557483 = (!proxySpec.type().equals(Proxy.Type.HTTP));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                            } //End block
                        } //End collapsed parenthetic
                        InetSocketAddress sa = (InetSocketAddress)proxySpec.address();
                        String hostName = sa.getHostName();
                        int port = sa.getPort();
                        StringBuilder hostBuilder = new StringBuilder();
                        hostSpec = hostBuilder.append(hostName)
                        .append(":").append(Integer.toString(port)).toString();
                        {
                            exclSpec = "";
                        } //End block
                        {
                            StringBuilder listBuilder = new StringBuilder();
                            boolean firstDomain = true;
                            {
                                Iterator<String> var9A7ECA37DFC1650714BF7C8F9684918D_1890272929 = (exclusionList).iterator();
                                var9A7ECA37DFC1650714BF7C8F9684918D_1890272929.hasNext();
                                String exclDomain = var9A7ECA37DFC1650714BF7C8F9684918D_1890272929.next();
                                {
                                    {
                                        listBuilder = listBuilder.append(",");
                                    } //End block
                                    {
                                        firstDomain = false;
                                    } //End block
                                    listBuilder = listBuilder.append(exclDomain.trim());
                                } //End block
                            } //End collapsed parenthetic
                            exclSpec = listBuilder.toString();
                        } //End block
                        android.net.Proxy.validate(hostName, Integer.toString(port), exclSpec);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_497111841 = mService.setGlobalProxy(admin, hostSpec, exclSpec);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1210698897 = null;
        addTaint(admin.getTaint());
        addTaint(proxySpec.getTaint());
        addTaint(exclusionList.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_2043645313; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2043645313 = varB4EAC82CA7396A68D541C85D26508E83_497111841;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2043645313 = varB4EAC82CA7396A68D541C85D26508E83_1210698897;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2043645313.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2043645313;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.004 -0400", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "4B7254ACB9DEDD531F16B88C0ABBAF86")
    public ComponentName getGlobalProxyAdmin() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_157212812 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1662821936 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_157212812 = mService.getGlobalProxyAdmin();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1662821936 = null;
        ComponentName varA7E53CE21691AB073D9660D615818899_2004390986; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2004390986 = varB4EAC82CA7396A68D541C85D26508E83_157212812;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2004390986 = varB4EAC82CA7396A68D541C85D26508E83_1662821936;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2004390986.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2004390986;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getGlobalProxyAdmin();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.006 -0400", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "EBA731D29BD105B5985049F5067B0BA4")
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        {
            try 
            {
                int var6405E0D4C3D4E429E287870D4B288E54_599511738 = (mService.setStorageEncryption(admin, encrypt));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(encrypt);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031079979 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031079979;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.setStorageEncryption(admin, encrypt);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return ENCRYPTION_STATUS_UNSUPPORTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.007 -0400", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "AF64B8716073F314F491F042A9E03ED4")
    public boolean getStorageEncryption(ComponentName admin) {
        {
            try 
            {
                boolean var5C8A37DD1003FF92AB2322C9A6C4947D_421352025 = (mService.getStorageEncryption(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832822811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832822811;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getStorageEncryption(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.008 -0400", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "A26ED148EEAB097C44EEEBE914E19810")
    public int getStorageEncryptionStatus() {
        {
            try 
            {
                int var81B597DAD09BDD3F2A452B82A5024492_838721303 = (mService.getStorageEncryptionStatus());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382333088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382333088;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getStorageEncryptionStatus();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return ENCRYPTION_STATUS_UNSUPPORTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.008 -0400", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "DEFFC5AEACF98EAC15E9EBA9735161C3")
    public void setCameraDisabled(ComponentName admin, boolean disabled) {
        {
            try 
            {
                mService.setCameraDisabled(admin, disabled);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(disabled);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setCameraDisabled(admin, disabled);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.009 -0400", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "CE5F44B2A44AF3FF74D8BB2FE5E6158D")
    public boolean getCameraDisabled(ComponentName admin) {
        {
            try 
            {
                boolean var14E94D42F97BE45817ED8F25DE3A71A7_1766882289 = (mService.getCameraDisabled(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972814044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972814044;
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //return mService.getCameraDisabled(admin);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.009 -0400", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "48CF28401F690C40DF6D97DBB3F4CD9E")
    public void setActiveAdmin(ComponentName policyReceiver, boolean refreshing) {
        {
            try 
            {
                mService.setActiveAdmin(policyReceiver, refreshing);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(policyReceiver.getTaint());
        addTaint(refreshing);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setActiveAdmin(policyReceiver, refreshing);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.469 -0400", hash_original_method = "6B96BC98EC991BA4501EAC59D3A81719", hash_generated_method = "72261FC3065DE81EA5EFC9B7D1BA5150")
    public DeviceAdminInfo getAdminInfo(ComponentName cn) {
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_46958880 = null; //Variable for return #1
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_222378204 = null; //Variable for return #2
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_612530210 = null; //Variable for return #3
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_1092067776 = null; //Variable for return #4
        ActivityInfo ai = null;
        try 
        {
            ai = mContext.getPackageManager().getReceiverInfo(cn,
                    PackageManager.GET_META_DATA);
        } //End block
        catch (PackageManager.NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_46958880 = null;
        } //End block
        ResolveInfo ri;
        ri = new ResolveInfo();
        ri.activityInfo = ai;
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_222378204 = new DeviceAdminInfo(mContext, ri);
        } //End block
        catch (XmlPullParserException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_612530210 = null;
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1092067776 = null;
        } //End block
        addTaint(cn.getTaint());
        DeviceAdminInfo varA7E53CE21691AB073D9660D615818899_1799255054; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1799255054 = varB4EAC82CA7396A68D541C85D26508E83_46958880;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1799255054 = varB4EAC82CA7396A68D541C85D26508E83_222378204;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1799255054 = varB4EAC82CA7396A68D541C85D26508E83_612530210;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1799255054 = varB4EAC82CA7396A68D541C85D26508E83_1092067776;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1799255054.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1799255054;
        // ---------- Original Method ----------
        //ActivityInfo ai;
        //try {
            //ai = mContext.getPackageManager().getReceiverInfo(cn,
                    //PackageManager.GET_META_DATA);
        //} catch (PackageManager.NameNotFoundException e) {
            //Log.w(TAG, "Unable to retrieve device policy " + cn, e);
            //return null;
        //}
        //ResolveInfo ri = new ResolveInfo();
        //ri.activityInfo = ai;
        //try {
            //return new DeviceAdminInfo(mContext, ri);
        //} catch (XmlPullParserException e) {
            //Log.w(TAG, "Unable to parse device policy " + cn, e);
            //return null;
        //} catch (IOException e) {
            //Log.w(TAG, "Unable to parse device policy " + cn, e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.010 -0400", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "A9A6BC35B461BB3EFA38900AF7574CBE")
    public void getRemoveWarning(ComponentName admin, RemoteCallback result) {
        {
            try 
            {
                mService.getRemoveWarning(admin, result);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(result.getTaint());
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.getRemoveWarning(admin, result);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.011 -0400", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "73890BC4E7EAE3B15312A8DC00E4069A")
    public void setActivePasswordState(int quality, int length, int letters, int uppercase,
            int lowercase, int numbers, int symbols, int nonletter) {
        {
            try 
            {
                mService.setActivePasswordState(quality, length, letters, uppercase, lowercase,
                        numbers, symbols, nonletter);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(quality);
        addTaint(length);
        addTaint(letters);
        addTaint(uppercase);
        addTaint(lowercase);
        addTaint(numbers);
        addTaint(symbols);
        addTaint(nonletter);
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setActivePasswordState(quality, length, letters, uppercase, lowercase,
                        //numbers, symbols, nonletter);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.012 -0400", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "DA0F8855CD045EED7A79AE05D37D6F31")
    public void reportFailedPasswordAttempt() {
        {
            try 
            {
                mService.reportFailedPasswordAttempt();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.reportFailedPasswordAttempt();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.012 -0400", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "E63AA8E5F1B277C83F37B55FD191792B")
    public void reportSuccessfulPasswordAttempt() {
        {
            try 
            {
                mService.reportSuccessfulPasswordAttempt();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.reportSuccessfulPasswordAttempt();
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.012 -0400", hash_original_field = "16424C611DCFDEE991143BE6D4D1F988", hash_generated_field = "FF900525E51DBB3F6D9B2A6E08054C76")

    private static String TAG = "DevicePolicyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.012 -0400", hash_original_field = "84DCFB6DE7C700B855F852859ADEE75E", hash_generated_field = "CDF0D3A915C96327043A2D40EDE2C92A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.012 -0400", hash_original_field = "EB2D6AD821D7433857548D0C0758A0C1", hash_generated_field = "5BDD43B8A0E93C7D4FDE8B1FA69FAF93")

    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "299F8404600132CA0B341E6D7DCC1C96", hash_generated_field = "8C18FCF3FC885F2E0E13E7C006ED1A43")

    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "ACE7A441D6AD0F95AA12C6A04017D0A1", hash_generated_field = "89CEC099D619C862DB69E018F3BFDC73")

    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "A2EBD099678C6BE4F705C4577A87BA01", hash_generated_field = "E3AD59906BAAA7B9E356941998879FE7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "2F4E22855950CFAE972DB7D8F1928523", hash_generated_field = "420ABA592DCBCC7FDBBD6984C905D379")

    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "DEE9F29CDAE6B212147E737B199A69A2", hash_generated_field = "33A112A34C5C25DFBD5A157010E89532")

    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "662703F06A406AB873594DDB0CD78C92", hash_generated_field = "7D590DB4720EE2DDFEFB4FFA71549D9C")

    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "E8AA9250088CC2672ECA4C8984CE71A2", hash_generated_field = "6079C1AD224868A1FD2E6C91F592E8E5")

    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "15F5918F7AE8813144313B741FFB1E22", hash_generated_field = "4CF28041A91E5136B4028DFC45BF43A2")

    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "9EBA0E61C11598E64E5DEF9805AB1C87", hash_generated_field = "19D36D84D76399F2965778802906C5F4")

    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "DE5AF5B5F19EC717483AFBFE4F1515D0", hash_generated_field = "B6900B6DFFCE3EC3137AFAC8CDF141C8")

    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "DB6F58D0A19D67186E0E44A55BE76FC2", hash_generated_field = "A25E572D19EAB5FC775D99C2E5CBD7F9")

    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "8B16A56E23ABB90E8E8E8831ED3436AB", hash_generated_field = "6DBBDEA2F83957970766E3EB7A360D87")

    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "FDE7057C56CD851E5FD94130A9A8A115", hash_generated_field = "C963AC3E0F57998F2C6F71339C6345A2")

    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "FDFB59D4A2C0D29DFC5722412D488218", hash_generated_field = "9BC8B9B07F2BB6E9920B39CA1C7F82FB")

    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.013 -0400", hash_original_field = "A1D502698074B8130C1948EF8E35BC08", hash_generated_field = "5F4944DA22B7A103647F3EE380E7C7E1")

    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.014 -0400", hash_original_field = "88C56DE017A8E3EE82ECA5397D46AE32", hash_generated_field = "4AECE9433F73E3025A1218697C4A55F7")

    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.014 -0400", hash_original_field = "47775C2461025F148024416F34E44FEF", hash_generated_field = "D3A52877D04884CC38F2F15EF3C82C3E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
}

