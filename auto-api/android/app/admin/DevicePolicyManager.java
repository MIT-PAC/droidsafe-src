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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.201 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.201 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "E263D54C98D833F4BF6DB51617AA3116")

    private IDevicePolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.215 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "524043B477AF9FF34438AF5C661E38DE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.249 -0400", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "21F8E04E9A958D8D0F1F33B5E43A23F1")
    public boolean isAdminActive(ComponentName who) {
        {
            try 
            {
                boolean varDDC18424843F25DBAC66701537992DCA_574184797 = (mService.isAdminActive(who));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538768454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538768454;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.252 -0400", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "0993147E68835F107987FF3E3EC506CE")
    public List<ComponentName> getActiveAdmins() {
        List<ComponentName> varB4EAC82CA7396A68D541C85D26508E83_1679981776 = null; //Variable for return #1
        List<ComponentName> varB4EAC82CA7396A68D541C85D26508E83_1768140400 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1679981776 = mService.getActiveAdmins();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1768140400 = null;
        List<ComponentName> varA7E53CE21691AB073D9660D615818899_827086562; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_827086562 = varB4EAC82CA7396A68D541C85D26508E83_1679981776;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_827086562 = varB4EAC82CA7396A68D541C85D26508E83_1768140400;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_827086562.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_827086562;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.255 -0400", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "897FA1A5AD196E0F501251ED7F4E8863")
    public boolean packageHasActiveAdmins(String packageName) {
        {
            try 
            {
                boolean var9AD91614F7E6A3EB6B4DC1ED0C825051_846051985 = (mService.packageHasActiveAdmins(packageName));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(packageName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_487799098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_487799098;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.273 -0400", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "6EA59A0440FE573C813306A48A8E217B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.276 -0400", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "4B8116F1F5319D6D74C01D9386B0D28A")
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        {
            try 
            {
                boolean var8293FAA2FE4C2CA275B458FF6F9999B9_519681395 = (mService.hasGrantedPolicy(admin, usesPolicy));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(usesPolicy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142976251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142976251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.278 -0400", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "9FDBC76BAE013CE84EAFAEF37BFDE2F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.298 -0400", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "9C9253DD6FED95E6ABCA546F06B0DCFD")
    public int getPasswordQuality(ComponentName admin) {
        {
            try 
            {
                int var50B1D404B3237CB299636EA0B85E73CC_40789389 = (mService.getPasswordQuality(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674178849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674178849;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.309 -0400", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "6DC6D87FB778258FF0F3B22E7DBFF2FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.311 -0400", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "8CFDE927EB8DF274304FD9B22887703A")
    public int getPasswordMinimumLength(ComponentName admin) {
        {
            try 
            {
                int var3F407E749EA5B2DC2542A0A7919871DB_1535336011 = (mService.getPasswordMinimumLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643050076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643050076;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.329 -0400", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "6D318F55E14BD3E2DA2ED639019FBFD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.339 -0400", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "F6614E97ED7787A429339199C27FC2A0")
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        {
            try 
            {
                int var99860992B7CBA8049416DD538EB3AE3F_1159063868 = (mService.getPasswordMinimumUpperCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211681306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211681306;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.341 -0400", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "82735EDD2D8A123C967F31FE2D156E9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.346 -0400", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "F778E39514E67548F4A2109CD764021A")
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        {
            try 
            {
                int var777E882DCA72E018D863B51B9CC2D33E_912217881 = (mService.getPasswordMinimumLowerCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538475252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538475252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.348 -0400", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "1C9BDE4A1D4ECBBA2F1545821B0C21E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.379 -0400", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "4D407DDC1247F1BB52CC4BC5F7C4DB47")
    public int getPasswordMinimumLetters(ComponentName admin) {
        {
            try 
            {
                int var579CFE59F49EAFA16CF346F87A7CF37C_1942020206 = (mService.getPasswordMinimumLetters(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298010554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298010554;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.386 -0400", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "601979EDE201953B62CA61F225A4DE0D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.387 -0400", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "3CE7692DC318BF80E7C64C90E40702CF")
    public int getPasswordMinimumNumeric(ComponentName admin) {
        {
            try 
            {
                int varA96658E08799B3973A9806AB9C11888E_807562922 = (mService.getPasswordMinimumNumeric(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383067068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1383067068;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.394 -0400", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "64C4010E7179237238E1B4DBC3BE193A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.417 -0400", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "01D2C8B048867D76874A0ACF5DC1ED9F")
    public int getPasswordMinimumSymbols(ComponentName admin) {
        {
            try 
            {
                int varC5459125C02CCD305A9D65BA82E945C4_351377633 = (mService.getPasswordMinimumSymbols(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443774956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443774956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.438 -0400", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "97B1F6F6A29F5A41E50C30F58D1C8D37")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.441 -0400", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "4BECFAE081F103E755A00FA359FE8988")
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        {
            try 
            {
                int varA4D869D416A4BC57B2A8EF3FBE9140CA_59574721 = (mService.getPasswordMinimumNonLetter(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350996872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350996872;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.455 -0400", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "D678A9E9382AA5D5CEDED3FACC7F8BFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.457 -0400", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "756F1865BBAAC520E5B68926D710F6E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.458 -0400", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "7A4724CF274604D9AE243ED709A7B835")
    public long getPasswordExpirationTimeout(ComponentName admin) {
        {
            try 
            {
                long var8E0E92ED0AE24F586AFBAEFC4C90C962_293084894 = (mService.getPasswordExpirationTimeout(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2089594268 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2089594268;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.479 -0400", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "70B7FEE1BB946993F273D022F57387DC")
    public long getPasswordExpiration(ComponentName admin) {
        {
            try 
            {
                long varA425B12B3ADC7B11B7AB412B878E8D27_1551580874 = (mService.getPasswordExpiration(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1140944801 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1140944801;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.498 -0400", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "79579616575BC5BB19B952C63E2D2CA8")
    public int getPasswordHistoryLength(ComponentName admin) {
        {
            try 
            {
                int var6B58013F3CE3A15346CE8AB072CAF025_1963651843 = (mService.getPasswordHistoryLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539502585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_539502585;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.500 -0400", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "F15A7193DDEF0CA30665BF253289AFE8")
    public int getPasswordMaximumLength(int quality) {
        addTaint(quality);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894465363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894465363;
        // ---------- Original Method ----------
        //return 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.590 -0400", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "6AA7A2300FFDA7A40511F4AFA171F017")
    public boolean isActivePasswordSufficient() {
        {
            try 
            {
                boolean var4C9DBF611B0D22EF5B0E4B1EC5D17B72_831092528 = (mService.isActivePasswordSufficient());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106220544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106220544;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.596 -0400", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "A78F38ECEB7FC9137B25C1E2D54225E0")
    public int getCurrentFailedPasswordAttempts() {
        {
            try 
            {
                int varACF84C8123F19D3EC9F60D2D8BF605DA_1389314451 = (mService.getCurrentFailedPasswordAttempts());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918830631 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_918830631;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.598 -0400", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "2BB86C216254E218A8002EBD091C4455")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.615 -0400", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "857AAA0E12F341FE12E0D97A15AE74C6")
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        {
            try 
            {
                int var79667AF6709342EB68CFAD29539CB206_2003141104 = (mService.getMaximumFailedPasswordsForWipe(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810563026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810563026;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.629 -0400", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "B2273C3AB10A9F71DB915A4D94FBF801")
    public boolean resetPassword(String password, int flags) {
        {
            try 
            {
                boolean var60406D42B56A6445438EDD773C9D0828_1193562761 = (mService.resetPassword(password, flags));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(password.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956473583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956473583;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.631 -0400", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "4D2C81E2CACF7573CBDB4D08D15D23CF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.647 -0400", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "8587BA467A56999CC555A1F24B314C24")
    public long getMaximumTimeToLock(ComponentName admin) {
        {
            try 
            {
                long varB8C855E033294E8C52BAAD4F39092DB8_1014239614 = (mService.getMaximumTimeToLock(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_118205069 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_118205069;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.662 -0400", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "AB2EEBEA8902EB56BFA2E2D0BFBEA706")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.675 -0400", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "7B8F651EA306BC200E0748C3408D080E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.371 -0400", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "50BB5FA3F1CCF85A8BD6C5DADB647AE2")
    public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1870934863 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_2111851590 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            try 
            {
                String hostSpec;
                String exclSpec;
                {
                    boolean varAEB17C6E60EDCE7B80F1428467000DDC_1890576567 = (proxySpec.equals(Proxy.NO_PROXY));
                    {
                        hostSpec = null;
                        exclSpec = null;
                    } //End block
                    {
                        {
                            boolean varD0F96407A07133F267A111443D9B66E2_867425282 = (!proxySpec.type().equals(Proxy.Type.HTTP));
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
                                Iterator<String> var9A7ECA37DFC1650714BF7C8F9684918D_1407403281 = (exclusionList).iterator();
                                var9A7ECA37DFC1650714BF7C8F9684918D_1407403281.hasNext();
                                String exclDomain = var9A7ECA37DFC1650714BF7C8F9684918D_1407403281.next();
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
                varB4EAC82CA7396A68D541C85D26508E83_1870934863 = mService.setGlobalProxy(admin, hostSpec, exclSpec);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2111851590 = null;
        addTaint(admin.getTaint());
        addTaint(proxySpec.getTaint());
        addTaint(exclusionList.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_1815069470; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1815069470 = varB4EAC82CA7396A68D541C85D26508E83_1870934863;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1815069470 = varB4EAC82CA7396A68D541C85D26508E83_2111851590;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1815069470.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1815069470;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.405 -0400", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "D793B40C0F64AEF366C1F396040620BE")
    public ComponentName getGlobalProxyAdmin() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1703599791 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1805093007 = null; //Variable for return #2
        {
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1703599791 = mService.getGlobalProxyAdmin();
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1805093007 = null;
        ComponentName varA7E53CE21691AB073D9660D615818899_1619614477; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1619614477 = varB4EAC82CA7396A68D541C85D26508E83_1703599791;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1619614477 = varB4EAC82CA7396A68D541C85D26508E83_1805093007;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1619614477.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1619614477;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.418 -0400", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "EE667F9CB63FB093608FD3839F992E13")
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        {
            try 
            {
                int var6405E0D4C3D4E429E287870D4B288E54_890010518 = (mService.setStorageEncryption(admin, encrypt));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        addTaint(encrypt);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897864128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897864128;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.433 -0400", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "261A82707AFC54943FEFF8E06D682816")
    public boolean getStorageEncryption(ComponentName admin) {
        {
            try 
            {
                boolean var5C8A37DD1003FF92AB2322C9A6C4947D_524782174 = (mService.getStorageEncryption(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129475762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129475762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.435 -0400", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "30B8CA48991EBE5DC2110F0B5652B430")
    public int getStorageEncryptionStatus() {
        {
            try 
            {
                int var81B597DAD09BDD3F2A452B82A5024492_1056916236 = (mService.getStorageEncryptionStatus());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136422776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136422776;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.440 -0400", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "DEFFC5AEACF98EAC15E9EBA9735161C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.455 -0400", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "634FFDBE57D16F52070BACB942D35A6C")
    public boolean getCameraDisabled(ComponentName admin) {
        {
            try 
            {
                boolean var14E94D42F97BE45817ED8F25DE3A71A7_1521255620 = (mService.getCameraDisabled(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        addTaint(admin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1946803314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1946803314;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.462 -0400", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "48CF28401F690C40DF6D97DBB3F4CD9E")
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
        ActivityInfo ai;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.471 -0400", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "A9A6BC35B461BB3EFA38900AF7574CBE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.496 -0400", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "73890BC4E7EAE3B15312A8DC00E4069A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.511 -0400", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "DA0F8855CD045EED7A79AE05D37D6F31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.513 -0400", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "E63AA8E5F1B277C83F37B55FD191792B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.514 -0400", hash_original_field = "16424C611DCFDEE991143BE6D4D1F988", hash_generated_field = "FF900525E51DBB3F6D9B2A6E08054C76")

    private static String TAG = "DevicePolicyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.514 -0400", hash_original_field = "84DCFB6DE7C700B855F852859ADEE75E", hash_generated_field = "CDF0D3A915C96327043A2D40EDE2C92A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.514 -0400", hash_original_field = "EB2D6AD821D7433857548D0C0758A0C1", hash_generated_field = "5BDD43B8A0E93C7D4FDE8B1FA69FAF93")

    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.515 -0400", hash_original_field = "299F8404600132CA0B341E6D7DCC1C96", hash_generated_field = "8C18FCF3FC885F2E0E13E7C006ED1A43")

    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.515 -0400", hash_original_field = "ACE7A441D6AD0F95AA12C6A04017D0A1", hash_generated_field = "89CEC099D619C862DB69E018F3BFDC73")

    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.518 -0400", hash_original_field = "A2EBD099678C6BE4F705C4577A87BA01", hash_generated_field = "E3AD59906BAAA7B9E356941998879FE7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.529 -0400", hash_original_field = "2F4E22855950CFAE972DB7D8F1928523", hash_generated_field = "420ABA592DCBCC7FDBBD6984C905D379")

    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.529 -0400", hash_original_field = "DEE9F29CDAE6B212147E737B199A69A2", hash_generated_field = "33A112A34C5C25DFBD5A157010E89532")

    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.529 -0400", hash_original_field = "662703F06A406AB873594DDB0CD78C92", hash_generated_field = "7D590DB4720EE2DDFEFB4FFA71549D9C")

    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.530 -0400", hash_original_field = "E8AA9250088CC2672ECA4C8984CE71A2", hash_generated_field = "6079C1AD224868A1FD2E6C91F592E8E5")

    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.530 -0400", hash_original_field = "15F5918F7AE8813144313B741FFB1E22", hash_generated_field = "4CF28041A91E5136B4028DFC45BF43A2")

    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.530 -0400", hash_original_field = "9EBA0E61C11598E64E5DEF9805AB1C87", hash_generated_field = "19D36D84D76399F2965778802906C5F4")

    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.534 -0400", hash_original_field = "DE5AF5B5F19EC717483AFBFE4F1515D0", hash_generated_field = "B6900B6DFFCE3EC3137AFAC8CDF141C8")

    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.535 -0400", hash_original_field = "DB6F58D0A19D67186E0E44A55BE76FC2", hash_generated_field = "A25E572D19EAB5FC775D99C2E5CBD7F9")

    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.549 -0400", hash_original_field = "8B16A56E23ABB90E8E8E8831ED3436AB", hash_generated_field = "6DBBDEA2F83957970766E3EB7A360D87")

    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.549 -0400", hash_original_field = "FDE7057C56CD851E5FD94130A9A8A115", hash_generated_field = "C963AC3E0F57998F2C6F71339C6345A2")

    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.549 -0400", hash_original_field = "FDFB59D4A2C0D29DFC5722412D488218", hash_generated_field = "9BC8B9B07F2BB6E9920B39CA1C7F82FB")

    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.549 -0400", hash_original_field = "A1D502698074B8130C1948EF8E35BC08", hash_generated_field = "5F4944DA22B7A103647F3EE380E7C7E1")

    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.550 -0400", hash_original_field = "88C56DE017A8E3EE82ECA5397D46AE32", hash_generated_field = "4AECE9433F73E3025A1218697C4A55F7")

    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:57.550 -0400", hash_original_field = "47775C2461025F148024416F34E44FEF", hash_generated_field = "D3A52877D04884CC38F2F15EF3C82C3E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
}

