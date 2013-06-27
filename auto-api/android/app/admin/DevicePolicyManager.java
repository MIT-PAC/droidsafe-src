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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.532 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.533 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "E263D54C98D833F4BF6DB51617AA3116")

    private IDevicePolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.549 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "524043B477AF9FF34438AF5C661E38DE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.551 -0400", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "2F627531A2351949ED3D919822EAEA39")
    public boolean isAdminActive(ComponentName who) {
        {
            try 
            {
                boolean varDDC18424843F25DBAC66701537992DCA_368559173 = (mService.isAdminActive(who));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888662706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888662706;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.571 -0400", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "BD87F17E1AC9C303F03B4EE58BDC4175")
    public List<ComponentName> getActiveAdmins() {
        List<ComponentName> varB4EAC82CA7396A68D541C85D26508E83_1533813181 = null; //Variable for return #1
        List<ComponentName> varB4EAC82CA7396A68D541C85D26508E83_440812546 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1533813181 = mService.getActiveAdmins();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_440812546 = null;
        List<ComponentName> varA7E53CE21691AB073D9660D615818899_1548402313; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1548402313 = varB4EAC82CA7396A68D541C85D26508E83_1533813181;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1548402313 = varB4EAC82CA7396A68D541C85D26508E83_440812546;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1548402313.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1548402313;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.581 -0400", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "68378BE88D089A5CF5D75E6A423B749B")
    public boolean packageHasActiveAdmins(String packageName) {
        {
            try 
            {
                boolean var9AD91614F7E6A3EB6B4DC1ED0C825051_1922367333 = (mService.packageHasActiveAdmins(packageName));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176695561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176695561;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.582 -0400", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "6EA59A0440FE573C813306A48A8E217B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.602 -0400", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "5D824F0962D681CD638EA084A31F7580")
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        {
            try 
            {
                boolean var8293FAA2FE4C2CA275B458FF6F9999B9_543440807 = (mService.hasGrantedPolicy(admin, usesPolicy));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(usesPolicy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_916750609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_916750609;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.620 -0400", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "9FDBC76BAE013CE84EAFAEF37BFDE2F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.622 -0400", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "09AFE8E7E66D4F1DF5486B8491ADE00B")
    public int getPasswordQuality(ComponentName admin) {
        {
            try 
            {
                int var50B1D404B3237CB299636EA0B85E73CC_712565328 = (mService.getPasswordQuality(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688059470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688059470;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.623 -0400", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "6DC6D87FB778258FF0F3B22E7DBFF2FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.658 -0400", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "FEE5D7335568200C8841C1D13AFFC55C")
    public int getPasswordMinimumLength(ComponentName admin) {
        {
            try 
            {
                int var3F407E749EA5B2DC2542A0A7919871DB_1848142880 = (mService.getPasswordMinimumLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073932927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2073932927;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.660 -0400", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "6D318F55E14BD3E2DA2ED639019FBFD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.684 -0400", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "96076EED067F6FFA63AE627B3EB735DB")
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        {
            try 
            {
                int var99860992B7CBA8049416DD538EB3AE3F_819317328 = (mService.getPasswordMinimumUpperCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879528601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879528601;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.694 -0400", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "82735EDD2D8A123C967F31FE2D156E9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.696 -0400", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "E6FEC85685394F129C986D365DCDF26B")
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        {
            try 
            {
                int var777E882DCA72E018D863B51B9CC2D33E_1333744190 = (mService.getPasswordMinimumLowerCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191868900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191868900;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.718 -0400", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "1C9BDE4A1D4ECBBA2F1545821B0C21E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.725 -0400", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "45CE382391EB8DE5B82E2CAD1F33611B")
    public int getPasswordMinimumLetters(ComponentName admin) {
        {
            try 
            {
                int var579CFE59F49EAFA16CF346F87A7CF37C_592615808 = (mService.getPasswordMinimumLetters(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643023251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643023251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.756 -0400", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "601979EDE201953B62CA61F225A4DE0D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.768 -0400", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "0472837D65B7655BAC463B24138AA805")
    public int getPasswordMinimumNumeric(ComponentName admin) {
        {
            try 
            {
                int varA96658E08799B3973A9806AB9C11888E_1762936629 = (mService.getPasswordMinimumNumeric(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732761828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732761828;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.770 -0400", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "64C4010E7179237238E1B4DBC3BE193A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.798 -0400", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "C3AE84C0D43489BB270AD16ECE1BD5FB")
    public int getPasswordMinimumSymbols(ComponentName admin) {
        {
            try 
            {
                int varC5459125C02CCD305A9D65BA82E945C4_1559415351 = (mService.getPasswordMinimumSymbols(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202479254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_202479254;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.800 -0400", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "97B1F6F6A29F5A41E50C30F58D1C8D37")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.804 -0400", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "5F0B58D4CAAFC4BCB20573FA195D638D")
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        {
            try 
            {
                int varA4D869D416A4BC57B2A8EF3FBE9140CA_2107394555 = (mService.getPasswordMinimumNonLetter(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814837221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814837221;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.827 -0400", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "D678A9E9382AA5D5CEDED3FACC7F8BFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.829 -0400", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "756F1865BBAAC520E5B68926D710F6E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.854 -0400", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "16C422611EEFCA2B8FE9AA00A332FD56")
    public long getPasswordExpirationTimeout(ComponentName admin) {
        {
            try 
            {
                long var8E0E92ED0AE24F586AFBAEFC4C90C962_2136955940 = (mService.getPasswordExpirationTimeout(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1457621766 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1457621766;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.865 -0400", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "8CB848AA80388C42B4CB57C961D18296")
    public long getPasswordExpiration(ComponentName admin) {
        {
            try 
            {
                long varA425B12B3ADC7B11B7AB412B878E8D27_242144494 = (mService.getPasswordExpiration(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1789175065 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1789175065;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.867 -0400", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "C0E48B9F3B21302A8C1F862D82F441B6")
    public int getPasswordHistoryLength(ComponentName admin) {
        {
            try 
            {
                int var6B58013F3CE3A15346CE8AB072CAF025_194325865 = (mService.getPasswordHistoryLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120157415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120157415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.881 -0400", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "C2D258F16CA44E962646DECCFD686A42")
    public int getPasswordMaximumLength(int quality) {
        addTaint(quality);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658621380 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658621380;
        // ---------- Original Method ----------
        //return 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.883 -0400", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "914D617AACD14B39BB0DC02DB5BE0E8F")
    public boolean isActivePasswordSufficient() {
        {
            try 
            {
                boolean var4C9DBF611B0D22EF5B0E4B1EC5D17B72_764200353 = (mService.isActivePasswordSufficient());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319788315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_319788315;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.902 -0400", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "7FC3F1BF3699281190B656B97ED4DB17")
    public int getCurrentFailedPasswordAttempts() {
        {
            try 
            {
                int varACF84C8123F19D3EC9F60D2D8BF605DA_1853729771 = (mService.getCurrentFailedPasswordAttempts());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5869742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5869742;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.904 -0400", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "2BB86C216254E218A8002EBD091C4455")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.912 -0400", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "1858CEACE90A347ECDB8B628421B642B")
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        {
            try 
            {
                int var79667AF6709342EB68CFAD29539CB206_1883847957 = (mService.getMaximumFailedPasswordsForWipe(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417298570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417298570;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.929 -0400", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "C62320351E7133BC0C4185A5AF94DDB1")
    public boolean resetPassword(String password, int flags) {
        {
            try 
            {
                boolean var60406D42B56A6445438EDD773C9D0828_1405885982 = (mService.resetPassword(password, flags));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(password.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355104242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355104242;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.931 -0400", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "4D2C81E2CACF7573CBDB4D08D15D23CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.938 -0400", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "5A332036A7BAE1FFFD108D18908A1C9A")
    public long getMaximumTimeToLock(ComponentName admin) {
        {
            try 
            {
                long varB8C855E033294E8C52BAAD4F39092DB8_1203998925 = (mService.getMaximumTimeToLock(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1416799456 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1416799456;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.958 -0400", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "AB2EEBEA8902EB56BFA2E2D0BFBEA706")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.960 -0400", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "7B8F651EA306BC200E0748C3408D080E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.357 -0400", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "9B571417F9FD1F8E6CD114EFA09A0CBB")
    public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_435039020 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1845898722 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            try 
            {
                String hostSpec;
                String exclSpec;
                {
                    boolean varAEB17C6E60EDCE7B80F1428467000DDC_1948274425 = (proxySpec.equals(Proxy.NO_PROXY));
                    {
                        hostSpec = null;
                        exclSpec = null;
                    } //End block
                    {
                        {
                            boolean varD0F96407A07133F267A111443D9B66E2_1853113180 = (!proxySpec.type().equals(Proxy.Type.HTTP));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                            } //End block
                        } //End collapsed parenthetic
                        InetSocketAddress sa;
                        sa = (InetSocketAddress)proxySpec.address();
                        String hostName;
                        hostName = sa.getHostName();
                        int port;
                        port = sa.getPort();
                        StringBuilder hostBuilder;
                        hostBuilder = new StringBuilder();
                        hostSpec = hostBuilder.append(hostName)
                        .append(":").append(Integer.toString(port)).toString();
                        {
                            exclSpec = "";
                        } //End block
                        {
                            StringBuilder listBuilder;
                            listBuilder = new StringBuilder();
                            boolean firstDomain;
                            firstDomain = true;
                            {
                                Iterator<String> var9A7ECA37DFC1650714BF7C8F9684918D_1822520306 = (exclusionList).iterator();
                                var9A7ECA37DFC1650714BF7C8F9684918D_1822520306.hasNext();
                                String exclDomain = var9A7ECA37DFC1650714BF7C8F9684918D_1822520306.next();
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
                varB4EAC82CA7396A68D541C85D26508E83_435039020 = mService.setGlobalProxy(admin, hostSpec, exclSpec);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1845898722 = null;
        addTaint(admin.getTaint());
        addTaint(proxySpec.getTaint());
        addTaint(exclusionList.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_1692888486; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1692888486 = varB4EAC82CA7396A68D541C85D26508E83_435039020;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692888486 = varB4EAC82CA7396A68D541C85D26508E83_1845898722;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692888486.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1692888486;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.386 -0400", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "C359297B0A5374DF09532DD99EF6805D")
    public ComponentName getGlobalProxyAdmin() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_718170129 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1228246880 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_718170129 = mService.getGlobalProxyAdmin();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1228246880 = null;
        ComponentName varA7E53CE21691AB073D9660D615818899_507895262; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_507895262 = varB4EAC82CA7396A68D541C85D26508E83_718170129;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_507895262 = varB4EAC82CA7396A68D541C85D26508E83_1228246880;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_507895262.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_507895262;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.388 -0400", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "4C4C86E8641C30A642E7D68A8FB008C8")
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        {
            try 
            {
                int var6405E0D4C3D4E429E287870D4B288E54_442093064 = (mService.setStorageEncryption(admin, encrypt));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(encrypt);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991459864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991459864;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.405 -0400", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "42C82526055C023B56311D0AFD8B4CD4")
    public boolean getStorageEncryption(ComponentName admin) {
        {
            try 
            {
                boolean var5C8A37DD1003FF92AB2322C9A6C4947D_1551747002 = (mService.getStorageEncryption(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301538846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301538846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.411 -0400", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "13396DB760F20C00913A4588FE5324FD")
    public int getStorageEncryptionStatus() {
        {
            try 
            {
                int var81B597DAD09BDD3F2A452B82A5024492_1613227644 = (mService.getStorageEncryptionStatus());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527049914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527049914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.412 -0400", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "DEFFC5AEACF98EAC15E9EBA9735161C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.421 -0400", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "1BE39F3E001D84F693C0A915DCBBB816")
    public boolean getCameraDisabled(ComponentName admin) {
        {
            try 
            {
                boolean var14E94D42F97BE45817ED8F25DE3A71A7_1019052678 = (mService.getCameraDisabled(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891738723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891738723;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.423 -0400", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "48CF28401F690C40DF6D97DBB3F4CD9E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.459 -0400", hash_original_method = "6B96BC98EC991BA4501EAC59D3A81719", hash_generated_method = "3666916F8B27C90EF81A2258AD611063")
    public DeviceAdminInfo getAdminInfo(ComponentName cn) {
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_792047594 = null; //Variable for return #1
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_844366435 = null; //Variable for return #2
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_335882847 = null; //Variable for return #3
        DeviceAdminInfo varB4EAC82CA7396A68D541C85D26508E83_2081964528 = null; //Variable for return #4
        ActivityInfo ai;
        try 
        {
            ai = mContext.getPackageManager().getReceiverInfo(cn,
                    PackageManager.GET_META_DATA);
        } //End block
        catch (PackageManager.NameNotFoundException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_792047594 = null;
        } //End block
        ResolveInfo ri;
        ri = new ResolveInfo();
        ri.activityInfo = ai;
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_844366435 = new DeviceAdminInfo(mContext, ri);
        } //End block
        catch (XmlPullParserException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_335882847 = null;
        } //End block
        catch (IOException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2081964528 = null;
        } //End block
        addTaint(cn.getTaint());
        DeviceAdminInfo varA7E53CE21691AB073D9660D615818899_1920822273; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1920822273 = varB4EAC82CA7396A68D541C85D26508E83_792047594;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1920822273 = varB4EAC82CA7396A68D541C85D26508E83_844366435;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1920822273 = varB4EAC82CA7396A68D541C85D26508E83_335882847;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1920822273 = varB4EAC82CA7396A68D541C85D26508E83_2081964528;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1920822273.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1920822273;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.462 -0400", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "A9A6BC35B461BB3EFA38900AF7574CBE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.472 -0400", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "73890BC4E7EAE3B15312A8DC00E4069A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.492 -0400", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "DA0F8855CD045EED7A79AE05D37D6F31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.493 -0400", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "E63AA8E5F1B277C83F37B55FD191792B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.494 -0400", hash_original_field = "16424C611DCFDEE991143BE6D4D1F988", hash_generated_field = "FF900525E51DBB3F6D9B2A6E08054C76")

    private static String TAG = "DevicePolicyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.494 -0400", hash_original_field = "84DCFB6DE7C700B855F852859ADEE75E", hash_generated_field = "CDF0D3A915C96327043A2D40EDE2C92A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.494 -0400", hash_original_field = "EB2D6AD821D7433857548D0C0758A0C1", hash_generated_field = "5BDD43B8A0E93C7D4FDE8B1FA69FAF93")

    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.495 -0400", hash_original_field = "299F8404600132CA0B341E6D7DCC1C96", hash_generated_field = "8C18FCF3FC885F2E0E13E7C006ED1A43")

    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.495 -0400", hash_original_field = "ACE7A441D6AD0F95AA12C6A04017D0A1", hash_generated_field = "89CEC099D619C862DB69E018F3BFDC73")

    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.495 -0400", hash_original_field = "A2EBD099678C6BE4F705C4577A87BA01", hash_generated_field = "E3AD59906BAAA7B9E356941998879FE7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.512 -0400", hash_original_field = "2F4E22855950CFAE972DB7D8F1928523", hash_generated_field = "420ABA592DCBCC7FDBBD6984C905D379")

    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.512 -0400", hash_original_field = "DEE9F29CDAE6B212147E737B199A69A2", hash_generated_field = "33A112A34C5C25DFBD5A157010E89532")

    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.512 -0400", hash_original_field = "662703F06A406AB873594DDB0CD78C92", hash_generated_field = "7D590DB4720EE2DDFEFB4FFA71549D9C")

    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.513 -0400", hash_original_field = "E8AA9250088CC2672ECA4C8984CE71A2", hash_generated_field = "6079C1AD224868A1FD2E6C91F592E8E5")

    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.513 -0400", hash_original_field = "15F5918F7AE8813144313B741FFB1E22", hash_generated_field = "4CF28041A91E5136B4028DFC45BF43A2")

    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.514 -0400", hash_original_field = "9EBA0E61C11598E64E5DEF9805AB1C87", hash_generated_field = "19D36D84D76399F2965778802906C5F4")

    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.527 -0400", hash_original_field = "DE5AF5B5F19EC717483AFBFE4F1515D0", hash_generated_field = "B6900B6DFFCE3EC3137AFAC8CDF141C8")

    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.528 -0400", hash_original_field = "DB6F58D0A19D67186E0E44A55BE76FC2", hash_generated_field = "A25E572D19EAB5FC775D99C2E5CBD7F9")

    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.528 -0400", hash_original_field = "8B16A56E23ABB90E8E8E8831ED3436AB", hash_generated_field = "6DBBDEA2F83957970766E3EB7A360D87")

    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.528 -0400", hash_original_field = "FDE7057C56CD851E5FD94130A9A8A115", hash_generated_field = "C963AC3E0F57998F2C6F71339C6345A2")

    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.539 -0400", hash_original_field = "FDFB59D4A2C0D29DFC5722412D488218", hash_generated_field = "9BC8B9B07F2BB6E9920B39CA1C7F82FB")

    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.540 -0400", hash_original_field = "A1D502698074B8130C1948EF8E35BC08", hash_generated_field = "5F4944DA22B7A103647F3EE380E7C7E1")

    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.540 -0400", hash_original_field = "88C56DE017A8E3EE82ECA5397D46AE32", hash_generated_field = "4AECE9433F73E3025A1218697C4A55F7")

    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:55.540 -0400", hash_original_field = "47775C2461025F148024416F34E44FEF", hash_generated_field = "D3A52877D04884CC38F2F15EF3C82C3E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
}

