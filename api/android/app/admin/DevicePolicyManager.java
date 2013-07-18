package android.app.admin;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DevicePolicyManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.707 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.707 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "E263D54C98D833F4BF6DB51617AA3116")

    private IDevicePolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.708 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "C38A3CAA5978B5E74759E44B9191AA99")
    private  DevicePolicyManager(Context context, Handler handler) {
        addTaint(handler.getTaint());
        mContext = context;
        mService = IDevicePolicyManager.Stub.asInterface(
                ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
        // ---------- Original Method ----------
        //mContext = context;
        //mService = IDevicePolicyManager.Stub.asInterface(
                //ServiceManager.getService(Context.DEVICE_POLICY_SERVICE));
    }

    
    public static DevicePolicyManager create(Context context, Handler handler) {
        DevicePolicyManager me = new DevicePolicyManager(context, handler);
        return me.mService != null ? me : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.709 -0400", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "A04D397B65DBA61A10319C9B1CF6C58A")
    public boolean isAdminActive(ComponentName who) {
        addTaint(who.getTaint());
        if(mService != null)        
        {
            try 
            {
                boolean var13D2F88545DC64D095A18A27973B566E_1948567022 = (mService.isAdminActive(who));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098839974 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098839974;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1109748332 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128952689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128952689;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.710 -0400", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "EA75E84C39030EA46F6BEE30DD2C8B15")
    public List<ComponentName> getActiveAdmins() {
        if(mService != null)        
        {
            try 
            {
List<ComponentName> varC13AFE4588D35FE947AC5FB9446B0F65_2097007430 =                 mService.getActiveAdmins();
                varC13AFE4588D35FE947AC5FB9446B0F65_2097007430.addTaint(taint);
                return varC13AFE4588D35FE947AC5FB9446B0F65_2097007430;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
List<ComponentName> var540C13E9E156B687226421B24F2DF178_2073047090 =         null;
        var540C13E9E156B687226421B24F2DF178_2073047090.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2073047090;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.711 -0400", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "5BD024A810F25488DE2AB24B90E6CA70")
    public boolean packageHasActiveAdmins(String packageName) {
        addTaint(packageName.getTaint());
        if(mService != null)        
        {
            try 
            {
                boolean var775926304587C8D410BEFC33EFA380BE_1724048627 = (mService.packageHasActiveAdmins(packageName));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1044682672 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1044682672;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_369222413 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491460108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491460108;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.712 -0400", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "EA987E4C606C39F9075685012C81FA15")
    public void removeActiveAdmin(ComponentName who) {
        addTaint(who.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.removeActiveAdmin(who);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.removeActiveAdmin(who);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.713 -0400", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "DC587195F6CFBFAC085C290BB457806F")
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        addTaint(usesPolicy);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                boolean var2ECE2CA0F342382DD6C45D58F7A1C215_804928418 = (mService.hasGrantedPolicy(admin, usesPolicy));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452977611 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452977611;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1305677274 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699640365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699640365;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.714 -0400", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "5E7B330AAC4A9A83AE9705A45FF1346B")
    public void setPasswordQuality(ComponentName admin, int quality) {
        addTaint(quality);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordQuality(admin, quality);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordQuality(admin, quality);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.714 -0400", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "AE1DA50B7A813674779DD22470726DAB")
    public int getPasswordQuality(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var2538A9CC1B611C3F8984C5EEB3E63DCD_950546372 = (mService.getPasswordQuality(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550582736 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1550582736;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int var796529F4FA8C24CE2930D34645BBECF6_1053615434 = (PASSWORD_QUALITY_UNSPECIFIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752474256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752474256;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.715 -0400", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "8D84AA8B86F189F9E9C392CD8B84232C")
    public void setPasswordMinimumLength(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumLength(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumLength(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.716 -0400", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "4B014F70FEA1B850E3F44EA246457047")
    public int getPasswordMinimumLength(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var3A056EFEA71A118B0E7E483B980B2500_1494472383 = (mService.getPasswordMinimumLength(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069861044 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069861044;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_422335252 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166191140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166191140;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.716 -0400", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "134CB299CA4A648AC339097987D2B3CC")
    public void setPasswordMinimumUpperCase(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumUpperCase(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumUpperCase(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.717 -0400", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "19F1673B164E055849FDA56A92053331")
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var062555FC9D958C9BCC6472CA4D015234_1288944050 = (mService.getPasswordMinimumUpperCase(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744975049 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_744975049;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2105831934 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_785441996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_785441996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.717 -0400", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "EB18CFEFBBAEAA7CDC14EE0F746626AB")
    public void setPasswordMinimumLowerCase(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumLowerCase(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumLowerCase(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.718 -0400", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "29C8BCE0046A9DA49303FF9CFBDCF836")
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var9434E76896781369D79856E6F615B080_1827312416 = (mService.getPasswordMinimumLowerCase(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130173282 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130173282;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2129962351 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217711224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217711224;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.719 -0400", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "E9970897391681DB7B1E4526E879AB39")
    public void setPasswordMinimumLetters(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumLetters(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumLetters(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.720 -0400", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "542ED9042AE927495991185686527617")
    public int getPasswordMinimumLetters(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var6D18DDC98E75B56D338F7C4BF7236572_1429171797 = (mService.getPasswordMinimumLetters(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830404859 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830404859;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1350189483 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093537707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093537707;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.720 -0400", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "A801D6E67FC543B065BC3581CC7B62DA")
    public void setPasswordMinimumNumeric(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumNumeric(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumNumeric(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.721 -0400", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "38CF051E471DC5FE5147DD3EC951471D")
    public int getPasswordMinimumNumeric(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var55D01805A0587E114704553EA76C8ABC_2084753998 = (mService.getPasswordMinimumNumeric(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007180645 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007180645;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1991196386 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542626386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542626386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.721 -0400", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "AA810CEFEDF7375B1E00D4A7C7CBBB3A")
    public void setPasswordMinimumSymbols(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumSymbols(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumSymbols(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.722 -0400", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "83E05F7B2077DDA2304CB3016068548D")
    public int getPasswordMinimumSymbols(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var2B879F679016A14A4EE0C872F1897E9F_1650645312 = (mService.getPasswordMinimumSymbols(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1174934617 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1174934617;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1432123575 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636170421 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1636170421;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.723 -0400", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "256FF173243D218109604000FD83FA07")
    public void setPasswordMinimumNonLetter(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordMinimumNonLetter(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordMinimumNonLetter(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.724 -0400", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "F0FB9B7CD884C3521AE02DDFBE8C7939")
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int varC8F509EBAD2A2E56255AC11752B25CCD_1044985852 = (mService.getPasswordMinimumNonLetter(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694181641 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694181641;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_285122550 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214014388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214014388;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.724 -0400", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "DD18DDBC2E6D6E30D58C7323682639AA")
    public void setPasswordHistoryLength(ComponentName admin, int length) {
        addTaint(length);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordHistoryLength(admin, length);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordHistoryLength(admin, length);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.725 -0400", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "EBBBB8CE2B1524272F8E86AF7B7563F1")
    public void setPasswordExpirationTimeout(ComponentName admin, long timeout) {
        addTaint(timeout);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setPasswordExpirationTimeout(admin, timeout);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setPasswordExpirationTimeout(admin, timeout);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.726 -0400", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "AA99D784423ECA9675F33564B88000B1")
    public long getPasswordExpirationTimeout(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                long varEE0C5E40159421A12A790C8A84B060F0_1210223254 = (mService.getPasswordExpirationTimeout(admin));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_989883129 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_989883129;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_243814703 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1948149971 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1948149971;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.728 -0400", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "7C1D930D979BA1B05D432B3F0BB9CA06")
    public long getPasswordExpiration(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                long var9B85005219D405FC2A274E5B92078F81_1529506548 = (mService.getPasswordExpiration(admin));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_664817477 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_664817477;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_784670212 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_470433280 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_470433280;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.730 -0400", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "4FFD62A8F0F73B6C380BE4049A7C6B6D")
    public int getPasswordHistoryLength(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var636026391D9C21F4DBB8C09F8A80CB39_1442015853 = (mService.getPasswordHistoryLength(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786268206 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_786268206;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_662570715 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172014480 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1172014480;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.732 -0400", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "D53DFF130FD4B73AA655D29169AB924F")
    public int getPasswordMaximumLength(int quality) {
        addTaint(quality);
        int varC74D97B01EAE257E44AA9D5BADE97BAF_838778953 = (16);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_778737876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_778737876;
        // ---------- Original Method ----------
        //return 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.732 -0400", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "ABC56BD17CB2E1E9E715F8E4EAB76B43")
    public boolean isActivePasswordSufficient() {
        if(mService != null)        
        {
            try 
            {
                boolean var880A109A10260DD9B2A9063FAED29085_1240177861 = (mService.isActivePasswordSufficient());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195548983 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195548983;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1596350211 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439648955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439648955;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.734 -0400", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "E3ECAE695158BE43463C993D4EF9F6BC")
    public int getCurrentFailedPasswordAttempts() {
        if(mService != null)        
        {
            try 
            {
                int varFC26D26A89900E9D0321371B20C72DA6_1070472851 = (mService.getCurrentFailedPasswordAttempts());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282554793 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282554793;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_716621395 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81585994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81585994;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.735 -0400", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "93E3445BCBFA462EFDE64153E754356E")
    public void setMaximumFailedPasswordsForWipe(ComponentName admin, int num) {
        addTaint(num);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setMaximumFailedPasswordsForWipe(admin, num);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setMaximumFailedPasswordsForWipe(admin, num);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.738 -0400", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "06D5314395AEF88B0A07DAFFFC46B5CB")
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int var68BEAD26D832B852098C81D706A8A37E_2045968144 = (mService.getMaximumFailedPasswordsForWipe(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213782156 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213782156;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1059734583 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165135345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_165135345;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.739 -0400", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "AC93594F5275F0C149DB961A09796D80")
    public boolean resetPassword(String password, int flags) {
        addTaint(flags);
        addTaint(password.getTaint());
        if(mService != null)        
        {
            try 
            {
                boolean var9FA47EF6FA0319A2C7C0CE9F05E9CE92_641441967 = (mService.resetPassword(password, flags));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454765178 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_454765178;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2093655002 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672175788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672175788;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.742 -0400", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "8AEFEE146D99A7126A60F8A09D352AAC")
    public void setMaximumTimeToLock(ComponentName admin, long timeMs) {
        addTaint(timeMs);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setMaximumTimeToLock(admin, timeMs);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setMaximumTimeToLock(admin, timeMs);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.743 -0400", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "5F2F47E7CF5B2AC693C10CCF3DB189CC")
    public long getMaximumTimeToLock(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                long var372088348A58CBCA92034A274668955F_1778569304 = (mService.getMaximumTimeToLock(admin));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_139815024 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_139815024;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_2070896474 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1785680737 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1785680737;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.744 -0400", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "6521C5612DE0EB91F088E2AD81CC2BD4")
    public void lockNow() {
        if(mService != null)        
        {
            try 
            {
                mService.lockNow();
            } //End block
            catch (RemoteException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.744 -0400", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "E8FFDAFBF741C7A0E813DEB76588986B")
    public void wipeData(int flags) {
        addTaint(flags);
        if(mService != null)        
        {
            try 
            {
                mService.wipeData(flags);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.wipeData(flags);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.748 -0400", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "A8D60B7BE3F86E7A572543A63DE3B817")
    public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        addTaint(exclusionList.getTaint());
        addTaint(proxySpec.getTaint());
        addTaint(admin.getTaint());
        if(proxySpec == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1922151429 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1922151429.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1922151429;
        } //End block
        if(mService != null)        
        {
            try 
            {
                String hostSpec;
                String exclSpec;
                if(proxySpec.equals(Proxy.NO_PROXY))                
                {
                    hostSpec = null;
                    exclSpec = null;
                } //End block
                else
                {
                    if(!proxySpec.type().equals(Proxy.Type.HTTP))                    
                    {
                        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1692527048 = new IllegalArgumentException();
                        var5783EF97022AA508B74A1E3EA38534AF_1692527048.addTaint(taint);
                        throw var5783EF97022AA508B74A1E3EA38534AF_1692527048;
                    } //End block
                    InetSocketAddress sa = (InetSocketAddress)proxySpec.address();
                    String hostName = sa.getHostName();
                    int port = sa.getPort();
                    StringBuilder hostBuilder = new StringBuilder();
                    hostSpec = hostBuilder.append(hostName)
                        .append(":").append(Integer.toString(port)).toString();
                    if(exclusionList == null)                    
                    {
                        exclSpec = "";
                    } //End block
                    else
                    {
                        StringBuilder listBuilder = new StringBuilder();
                        boolean firstDomain = true;
for(String exclDomain : exclusionList)
                        {
                            if(!firstDomain)                            
                            {
                                listBuilder = listBuilder.append(",");
                            } //End block
                            else
                            {
                                firstDomain = false;
                            } //End block
                            listBuilder = listBuilder.append(exclDomain.trim());
                        } //End block
                        exclSpec = listBuilder.toString();
                    } //End block
                    android.net.Proxy.validate(hostName, Integer.toString(port), exclSpec);
                } //End block
ComponentName varB35344B1C50CD546B6E24DF639855582_491590237 =                 mService.setGlobalProxy(admin, hostSpec, exclSpec);
                varB35344B1C50CD546B6E24DF639855582_491590237.addTaint(taint);
                return varB35344B1C50CD546B6E24DF639855582_491590237;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
ComponentName var540C13E9E156B687226421B24F2DF178_1437797311 =         null;
        var540C13E9E156B687226421B24F2DF178_1437797311.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1437797311;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.749 -0400", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "D814BF95586DE8929FD28F8339F62C8F")
    public ComponentName getGlobalProxyAdmin() {
        if(mService != null)        
        {
            try 
            {
ComponentName varC3C4898010A44A3696DD18AC06A725C5_933412827 =                 mService.getGlobalProxyAdmin();
                varC3C4898010A44A3696DD18AC06A725C5_933412827.addTaint(taint);
                return varC3C4898010A44A3696DD18AC06A725C5_933412827;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
ComponentName var540C13E9E156B687226421B24F2DF178_1156806914 =         null;
        var540C13E9E156B687226421B24F2DF178_1156806914.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1156806914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.751 -0400", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "C335644F23AC0267484CA5E2482F4124")
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        addTaint(encrypt);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                int varD043DC5E40724FF443922CDA04432823_1605671487 = (mService.setStorageEncryption(admin, encrypt));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964297323 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1964297323;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varD36B3042B1FDF372CA00B243643CA766_1356511172 = (ENCRYPTION_STATUS_UNSUPPORTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906536212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906536212;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.752 -0400", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "B9B7AA8C7BD8C768DD4E710E63207111")
    public boolean getStorageEncryption(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                boolean var9462F8ACF2B335669D31123B4636C546_1136579710 = (mService.getStorageEncryption(admin));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527653049 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527653049;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_217937194 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_523175794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_523175794;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.754 -0400", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "2C4E688A1825A8D635F66526F005F05A")
    public int getStorageEncryptionStatus() {
        if(mService != null)        
        {
            try 
            {
                int varFAC54F1D468EF70CD05178AD0D044CFA_2049283945 = (mService.getStorageEncryptionStatus());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092782344 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092782344;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varD36B3042B1FDF372CA00B243643CA766_290476963 = (ENCRYPTION_STATUS_UNSUPPORTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937821596 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_937821596;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.756 -0400", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "3B0A4AA34A6FA4C1C2CCFA987D272C7B")
    public void setCameraDisabled(ComponentName admin, boolean disabled) {
        addTaint(disabled);
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setCameraDisabled(admin, disabled);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setCameraDisabled(admin, disabled);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.758 -0400", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "6F1AAD7DDA4AB863D8A1FDF943AB83A3")
    public boolean getCameraDisabled(ComponentName admin) {
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                boolean var29D72B98EB670E7158E114256E05744A_907402975 = (mService.getCameraDisabled(admin));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472434346 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472434346;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1509252474 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_445530964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_445530964;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.759 -0400", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "5C38B93F888237F255E766CCEDF55A67")
    public void setActiveAdmin(ComponentName policyReceiver, boolean refreshing) {
        addTaint(refreshing);
        addTaint(policyReceiver.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.setActiveAdmin(policyReceiver, refreshing);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.setActiveAdmin(policyReceiver, refreshing);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.761 -0400", hash_original_method = "6B96BC98EC991BA4501EAC59D3A81719", hash_generated_method = "49E78D8D761B7D67EDDE443763E13B7F")
    public DeviceAdminInfo getAdminInfo(ComponentName cn) {
        addTaint(cn.getTaint());
        ActivityInfo ai;
        try 
        {
            ai = mContext.getPackageManager().getReceiverInfo(cn,
                    PackageManager.GET_META_DATA);
        } //End block
        catch (PackageManager.NameNotFoundException e)
        {
DeviceAdminInfo var540C13E9E156B687226421B24F2DF178_873213806 =             null;
            var540C13E9E156B687226421B24F2DF178_873213806.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_873213806;
        } //End block
        ResolveInfo ri = new ResolveInfo();
        ri.activityInfo = ai;
        try 
        {
DeviceAdminInfo varAADB1F77EDF8CDC4A4744B325052C979_1005622630 =             new DeviceAdminInfo(mContext, ri);
            varAADB1F77EDF8CDC4A4744B325052C979_1005622630.addTaint(taint);
            return varAADB1F77EDF8CDC4A4744B325052C979_1005622630;
        } //End block
        catch (XmlPullParserException e)
        {
DeviceAdminInfo var540C13E9E156B687226421B24F2DF178_1012423426 =             null;
            var540C13E9E156B687226421B24F2DF178_1012423426.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1012423426;
        } //End block
        catch (IOException e)
        {
DeviceAdminInfo var540C13E9E156B687226421B24F2DF178_2024028732 =             null;
            var540C13E9E156B687226421B24F2DF178_2024028732.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2024028732;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.765 -0400", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "FD03F2E82F5102DDC85324E85921D4BA")
    public void getRemoveWarning(ComponentName admin, RemoteCallback result) {
        addTaint(result.getTaint());
        addTaint(admin.getTaint());
        if(mService != null)        
        {
            try 
            {
                mService.getRemoveWarning(admin, result);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mService != null) {
            //try {
                //mService.getRemoveWarning(admin, result);
            //} catch (RemoteException e) {
                //Log.w(TAG, "Failed talking with device policy service", e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.767 -0400", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "A623AA6862278A180CD6DBE63DA6FB16")
    public void setActivePasswordState(int quality, int length, int letters, int uppercase,
            int lowercase, int numbers, int symbols, int nonletter) {
        addTaint(nonletter);
        addTaint(symbols);
        addTaint(numbers);
        addTaint(lowercase);
        addTaint(uppercase);
        addTaint(letters);
        addTaint(length);
        addTaint(quality);
        if(mService != null)        
        {
            try 
            {
                mService.setActivePasswordState(quality, length, letters, uppercase, lowercase,
                        numbers, symbols, nonletter);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.768 -0400", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "71D102D57880828DEC9322A937A40ABF")
    public void reportFailedPasswordAttempt() {
        if(mService != null)        
        {
            try 
            {
                mService.reportFailedPasswordAttempt();
            } //End block
            catch (RemoteException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.768 -0400", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "5E480C75F0F913422005290F00D7BEA2")
    public void reportSuccessfulPasswordAttempt() {
        if(mService != null)        
        {
            try 
            {
                mService.reportSuccessfulPasswordAttempt();
            } //End block
            catch (RemoteException e)
            {
            } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.769 -0400", hash_original_field = "16424C611DCFDEE991143BE6D4D1F988", hash_generated_field = "FF900525E51DBB3F6D9B2A6E08054C76")

    private static String TAG = "DevicePolicyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.769 -0400", hash_original_field = "84DCFB6DE7C700B855F852859ADEE75E", hash_generated_field = "CDF0D3A915C96327043A2D40EDE2C92A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.769 -0400", hash_original_field = "EB2D6AD821D7433857548D0C0758A0C1", hash_generated_field = "5BDD43B8A0E93C7D4FDE8B1FA69FAF93")

    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.769 -0400", hash_original_field = "299F8404600132CA0B341E6D7DCC1C96", hash_generated_field = "8C18FCF3FC885F2E0E13E7C006ED1A43")

    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.770 -0400", hash_original_field = "ACE7A441D6AD0F95AA12C6A04017D0A1", hash_generated_field = "89CEC099D619C862DB69E018F3BFDC73")

    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.770 -0400", hash_original_field = "A2EBD099678C6BE4F705C4577A87BA01", hash_generated_field = "E3AD59906BAAA7B9E356941998879FE7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.770 -0400", hash_original_field = "2F4E22855950CFAE972DB7D8F1928523", hash_generated_field = "420ABA592DCBCC7FDBBD6984C905D379")

    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.770 -0400", hash_original_field = "DEE9F29CDAE6B212147E737B199A69A2", hash_generated_field = "33A112A34C5C25DFBD5A157010E89532")

    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.771 -0400", hash_original_field = "662703F06A406AB873594DDB0CD78C92", hash_generated_field = "7D590DB4720EE2DDFEFB4FFA71549D9C")

    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.771 -0400", hash_original_field = "E8AA9250088CC2672ECA4C8984CE71A2", hash_generated_field = "6079C1AD224868A1FD2E6C91F592E8E5")

    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.771 -0400", hash_original_field = "15F5918F7AE8813144313B741FFB1E22", hash_generated_field = "4CF28041A91E5136B4028DFC45BF43A2")

    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.771 -0400", hash_original_field = "9EBA0E61C11598E64E5DEF9805AB1C87", hash_generated_field = "19D36D84D76399F2965778802906C5F4")

    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.771 -0400", hash_original_field = "DE5AF5B5F19EC717483AFBFE4F1515D0", hash_generated_field = "B6900B6DFFCE3EC3137AFAC8CDF141C8")

    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.772 -0400", hash_original_field = "DB6F58D0A19D67186E0E44A55BE76FC2", hash_generated_field = "A25E572D19EAB5FC775D99C2E5CBD7F9")

    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.772 -0400", hash_original_field = "8B16A56E23ABB90E8E8E8831ED3436AB", hash_generated_field = "6DBBDEA2F83957970766E3EB7A360D87")

    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.772 -0400", hash_original_field = "FDE7057C56CD851E5FD94130A9A8A115", hash_generated_field = "C963AC3E0F57998F2C6F71339C6345A2")

    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.772 -0400", hash_original_field = "FDFB59D4A2C0D29DFC5722412D488218", hash_generated_field = "9BC8B9B07F2BB6E9920B39CA1C7F82FB")

    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.772 -0400", hash_original_field = "A1D502698074B8130C1948EF8E35BC08", hash_generated_field = "5F4944DA22B7A103647F3EE380E7C7E1")

    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.772 -0400", hash_original_field = "88C56DE017A8E3EE82ECA5397D46AE32", hash_generated_field = "4AECE9433F73E3025A1218697C4A55F7")

    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.773 -0400", hash_original_field = "47775C2461025F148024416F34E44FEF", hash_generated_field = "D3A52877D04884CC38F2F15EF3C82C3E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
}

