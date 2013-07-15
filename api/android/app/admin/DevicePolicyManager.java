package android.app.admin;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.558 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.558 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "E263D54C98D833F4BF6DB51617AA3116")

    private IDevicePolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.558 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "C38A3CAA5978B5E74759E44B9191AA99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.559 -0400", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "DBAD7F30BA0C33905849012231D24841")
    public boolean isAdminActive(ComponentName who) {
        addTaint(who.getTaint());
    if(mService != null)        
        {
            try 
            {
                boolean var13D2F88545DC64D095A18A27973B566E_496569726 = (mService.isAdminActive(who));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115464665 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115464665;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1950255477 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225923958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225923958;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.560 -0400", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "D7BA37F0EA8D94FB78F82655874C697A")
    public List<ComponentName> getActiveAdmins() {
    if(mService != null)        
        {
            try 
            {
List<ComponentName> varC13AFE4588D35FE947AC5FB9446B0F65_1380098916 =                 mService.getActiveAdmins();
                varC13AFE4588D35FE947AC5FB9446B0F65_1380098916.addTaint(taint);
                return varC13AFE4588D35FE947AC5FB9446B0F65_1380098916;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
List<ComponentName> var540C13E9E156B687226421B24F2DF178_691211426 =         null;
        var540C13E9E156B687226421B24F2DF178_691211426.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_691211426;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.561 -0400", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "32063AF6EFC86060C8BF74696453824E")
    public boolean packageHasActiveAdmins(String packageName) {
        addTaint(packageName.getTaint());
    if(mService != null)        
        {
            try 
            {
                boolean var775926304587C8D410BEFC33EFA380BE_717100447 = (mService.packageHasActiveAdmins(packageName));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47929973 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_47929973;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_809290207 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910142252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910142252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.561 -0400", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "EA987E4C606C39F9075685012C81FA15")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.562 -0400", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "62A73ACA1AC1480180BACADDB70CB7D8")
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        addTaint(usesPolicy);
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                boolean var2ECE2CA0F342382DD6C45D58F7A1C215_240559053 = (mService.hasGrantedPolicy(admin, usesPolicy));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_306495298 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_306495298;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1655175987 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347218442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347218442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.563 -0400", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "5E7B330AAC4A9A83AE9705A45FF1346B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.565 -0400", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "6F3898585C903948767B731A4496024D")
    public int getPasswordQuality(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var2538A9CC1B611C3F8984C5EEB3E63DCD_1846408821 = (mService.getPasswordQuality(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684905870 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684905870;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int var796529F4FA8C24CE2930D34645BBECF6_1270643472 = (PASSWORD_QUALITY_UNSPECIFIED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844180143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844180143;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.567 -0400", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "8D84AA8B86F189F9E9C392CD8B84232C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.568 -0400", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "5254F99B2113A1D6D02D173D65570274")
    public int getPasswordMinimumLength(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var3A056EFEA71A118B0E7E483B980B2500_796195037 = (mService.getPasswordMinimumLength(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949324675 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949324675;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1109094788 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414344658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414344658;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.569 -0400", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "134CB299CA4A648AC339097987D2B3CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.570 -0400", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "D8AF70CD191537A44A4370F97ACE4DF9")
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var062555FC9D958C9BCC6472CA4D015234_1691166304 = (mService.getPasswordMinimumUpperCase(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531444558 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531444558;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1182782205 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309923575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309923575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.571 -0400", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "EB18CFEFBBAEAA7CDC14EE0F746626AB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.572 -0400", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "932EA8408B45E47A58F92349897C09B5")
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var9434E76896781369D79856E6F615B080_296334455 = (mService.getPasswordMinimumLowerCase(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806584033 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806584033;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1999825906 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629018663 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629018663;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.573 -0400", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "E9970897391681DB7B1E4526E879AB39")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.574 -0400", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "632EAA6FA9290B839C312C6FB10C83ED")
    public int getPasswordMinimumLetters(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var6D18DDC98E75B56D338F7C4BF7236572_1994023841 = (mService.getPasswordMinimumLetters(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_760881675 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_760881675;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1585656562 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219985;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.575 -0400", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "A801D6E67FC543B065BC3581CC7B62DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.576 -0400", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "7E097D67FF1DFB4183660AAF772790BD")
    public int getPasswordMinimumNumeric(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var55D01805A0587E114704553EA76C8ABC_27343752 = (mService.getPasswordMinimumNumeric(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188159054 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188159054;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1812087828 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1212371038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1212371038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.576 -0400", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "AA810CEFEDF7375B1E00D4A7C7CBBB3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.577 -0400", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "A443FBCF250FC8B197BFB816F80D2F70")
    public int getPasswordMinimumSymbols(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var2B879F679016A14A4EE0C872F1897E9F_1232793032 = (mService.getPasswordMinimumSymbols(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368051778 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_368051778;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2117678623 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062395345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062395345;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.578 -0400", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "256FF173243D218109604000FD83FA07")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.578 -0400", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "0CADDABD14B23084455319BE3D080D23")
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int varC8F509EBAD2A2E56255AC11752B25CCD_1813148698 = (mService.getPasswordMinimumNonLetter(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230129531 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230129531;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_507351697 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054015021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1054015021;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.579 -0400", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "DD18DDBC2E6D6E30D58C7323682639AA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.579 -0400", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "EBBBB8CE2B1524272F8E86AF7B7563F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.580 -0400", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "24711921B95C4D899477CA0BF4E6E48B")
    public long getPasswordExpirationTimeout(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                long varEE0C5E40159421A12A790C8A84B060F0_813463301 = (mService.getPasswordExpirationTimeout(admin));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_164396539 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_164396539;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_935396898 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_457803949 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_457803949;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.581 -0400", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "E02DED3CF2A091AFA03749BBFC613E71")
    public long getPasswordExpiration(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                long var9B85005219D405FC2A274E5B92078F81_839009916 = (mService.getPasswordExpiration(admin));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_743224160 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_743224160;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_8450944 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1138304462 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1138304462;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.581 -0400", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "03B1D3035AE82E69690FF53EEEE18372")
    public int getPasswordHistoryLength(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var636026391D9C21F4DBB8C09F8A80CB39_872742005 = (mService.getPasswordHistoryLength(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650289559 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650289559;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_190058286 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113654761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1113654761;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.583 -0400", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "3E44B81121CEA2E54D5289CBA0A47D7C")
    public int getPasswordMaximumLength(int quality) {
        addTaint(quality);
        int varC74D97B01EAE257E44AA9D5BADE97BAF_1390091885 = (16);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220046008 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220046008;
        // ---------- Original Method ----------
        //return 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.584 -0400", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "8B123CE5C85CDAC75E6CECAA69DF3C30")
    public boolean isActivePasswordSufficient() {
    if(mService != null)        
        {
            try 
            {
                boolean var880A109A10260DD9B2A9063FAED29085_2028168524 = (mService.isActivePasswordSufficient());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081978772 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081978772;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_93970691 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873671385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873671385;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.585 -0400", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "70279878120DEAE1CA7AEF65EFA69245")
    public int getCurrentFailedPasswordAttempts() {
    if(mService != null)        
        {
            try 
            {
                int varFC26D26A89900E9D0321371B20C72DA6_1334498652 = (mService.getCurrentFailedPasswordAttempts());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121608286 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121608286;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1055721443 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491366270 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491366270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.586 -0400", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "93E3445BCBFA462EFDE64153E754356E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.587 -0400", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "C3D1CC70C96600D976C93EC34E52F76F")
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int var68BEAD26D832B852098C81D706A8A37E_896813910 = (mService.getMaximumFailedPasswordsForWipe(admin));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064369984 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1064369984;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1999617925 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570704100 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_570704100;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.589 -0400", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "287DA4D4C4FCCD1F43BE6ECA262E862D")
    public boolean resetPassword(String password, int flags) {
        addTaint(flags);
        addTaint(password.getTaint());
    if(mService != null)        
        {
            try 
            {
                boolean var9FA47EF6FA0319A2C7C0CE9F05E9CE92_612089587 = (mService.resetPassword(password, flags));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941497810 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941497810;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_645837188 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860768897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_860768897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.590 -0400", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "8AEFEE146D99A7126A60F8A09D352AAC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.592 -0400", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "80D35F2918B48C0DC5AD2B77A5641F93")
    public long getMaximumTimeToLock(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                long var372088348A58CBCA92034A274668955F_1790994317 = (mService.getMaximumTimeToLock(admin));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1381095285 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1381095285;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_1939505293 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_202213369 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_202213369;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.593 -0400", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "6521C5612DE0EB91F088E2AD81CC2BD4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.596 -0400", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "E8FFDAFBF741C7A0E813DEB76588986B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.600 -0400", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "8CBF61C2E4C5F6561E19EA6485586E7C")
    public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        addTaint(exclusionList.getTaint());
        addTaint(proxySpec.getTaint());
        addTaint(admin.getTaint());
    if(proxySpec == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1101735450 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1101735450.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1101735450;
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
                        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1727884850 = new IllegalArgumentException();
                        var5783EF97022AA508B74A1E3EA38534AF_1727884850.addTaint(taint);
                        throw var5783EF97022AA508B74A1E3EA38534AF_1727884850;
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
ComponentName varB35344B1C50CD546B6E24DF639855582_2122749471 =                 mService.setGlobalProxy(admin, hostSpec, exclSpec);
                varB35344B1C50CD546B6E24DF639855582_2122749471.addTaint(taint);
                return varB35344B1C50CD546B6E24DF639855582_2122749471;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
ComponentName var540C13E9E156B687226421B24F2DF178_196905027 =         null;
        var540C13E9E156B687226421B24F2DF178_196905027.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_196905027;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.602 -0400", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "7B34EF6CC8C24424CAD5677A6EEC05D7")
    public ComponentName getGlobalProxyAdmin() {
    if(mService != null)        
        {
            try 
            {
ComponentName varC3C4898010A44A3696DD18AC06A725C5_1824311659 =                 mService.getGlobalProxyAdmin();
                varC3C4898010A44A3696DD18AC06A725C5_1824311659.addTaint(taint);
                return varC3C4898010A44A3696DD18AC06A725C5_1824311659;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
ComponentName var540C13E9E156B687226421B24F2DF178_1769649592 =         null;
        var540C13E9E156B687226421B24F2DF178_1769649592.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1769649592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.604 -0400", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "61046AE4F5C25C594810DEAB085885BE")
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        addTaint(encrypt);
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                int varD043DC5E40724FF443922CDA04432823_254204587 = (mService.setStorageEncryption(admin, encrypt));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670198260 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670198260;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varD36B3042B1FDF372CA00B243643CA766_1627402722 = (ENCRYPTION_STATUS_UNSUPPORTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307218377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307218377;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.605 -0400", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "AFD1F18553EA1EDF2F58E4367040AA0D")
    public boolean getStorageEncryption(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                boolean var9462F8ACF2B335669D31123B4636C546_1664100814 = (mService.getStorageEncryption(admin));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895877889 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895877889;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_97341573 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060066791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060066791;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.606 -0400", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "A1B3471EB559A75EB42489668F572B0D")
    public int getStorageEncryptionStatus() {
    if(mService != null)        
        {
            try 
            {
                int varFAC54F1D468EF70CD05178AD0D044CFA_184475978 = (mService.getStorageEncryptionStatus());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536068928 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1536068928;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        int varD36B3042B1FDF372CA00B243643CA766_850079080 = (ENCRYPTION_STATUS_UNSUPPORTED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831597137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831597137;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.607 -0400", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "3B0A4AA34A6FA4C1C2CCFA987D272C7B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.608 -0400", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "BFAD4B119A7344FD851D4F159AEC1A7A")
    public boolean getCameraDisabled(ComponentName admin) {
        addTaint(admin.getTaint());
    if(mService != null)        
        {
            try 
            {
                boolean var29D72B98EB670E7158E114256E05744A_1420770972 = (mService.getCameraDisabled(admin));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765237594 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_765237594;
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_635046612 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396918004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396918004;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.609 -0400", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "5C38B93F888237F255E766CCEDF55A67")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.611 -0400", hash_original_method = "6B96BC98EC991BA4501EAC59D3A81719", hash_generated_method = "DA2F7C7B46714979DE20D55C82640A77")
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
DeviceAdminInfo var540C13E9E156B687226421B24F2DF178_1805947518 =             null;
            var540C13E9E156B687226421B24F2DF178_1805947518.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1805947518;
        } //End block
        ResolveInfo ri = new ResolveInfo();
        ri.activityInfo = ai;
        try 
        {
DeviceAdminInfo varAADB1F77EDF8CDC4A4744B325052C979_415113013 =             new DeviceAdminInfo(mContext, ri);
            varAADB1F77EDF8CDC4A4744B325052C979_415113013.addTaint(taint);
            return varAADB1F77EDF8CDC4A4744B325052C979_415113013;
        } //End block
        catch (XmlPullParserException e)
        {
DeviceAdminInfo var540C13E9E156B687226421B24F2DF178_824711955 =             null;
            var540C13E9E156B687226421B24F2DF178_824711955.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_824711955;
        } //End block
        catch (IOException e)
        {
DeviceAdminInfo var540C13E9E156B687226421B24F2DF178_1146148303 =             null;
            var540C13E9E156B687226421B24F2DF178_1146148303.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1146148303;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.613 -0400", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "FD03F2E82F5102DDC85324E85921D4BA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.615 -0400", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "A623AA6862278A180CD6DBE63DA6FB16")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.617 -0400", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "71D102D57880828DEC9322A937A40ABF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.618 -0400", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "5E480C75F0F913422005290F00D7BEA2")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.619 -0400", hash_original_field = "16424C611DCFDEE991143BE6D4D1F988", hash_generated_field = "FF900525E51DBB3F6D9B2A6E08054C76")

    private static String TAG = "DevicePolicyManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.619 -0400", hash_original_field = "84DCFB6DE7C700B855F852859ADEE75E", hash_generated_field = "CDF0D3A915C96327043A2D40EDE2C92A")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.619 -0400", hash_original_field = "EB2D6AD821D7433857548D0C0758A0C1", hash_generated_field = "5BDD43B8A0E93C7D4FDE8B1FA69FAF93")

    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.619 -0400", hash_original_field = "299F8404600132CA0B341E6D7DCC1C96", hash_generated_field = "8C18FCF3FC885F2E0E13E7C006ED1A43")

    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.620 -0400", hash_original_field = "ACE7A441D6AD0F95AA12C6A04017D0A1", hash_generated_field = "89CEC099D619C862DB69E018F3BFDC73")

    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.620 -0400", hash_original_field = "A2EBD099678C6BE4F705C4577A87BA01", hash_generated_field = "E3AD59906BAAA7B9E356941998879FE7")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.620 -0400", hash_original_field = "2F4E22855950CFAE972DB7D8F1928523", hash_generated_field = "420ABA592DCBCC7FDBBD6984C905D379")

    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.620 -0400", hash_original_field = "DEE9F29CDAE6B212147E737B199A69A2", hash_generated_field = "33A112A34C5C25DFBD5A157010E89532")

    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.620 -0400", hash_original_field = "662703F06A406AB873594DDB0CD78C92", hash_generated_field = "7D590DB4720EE2DDFEFB4FFA71549D9C")

    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.621 -0400", hash_original_field = "E8AA9250088CC2672ECA4C8984CE71A2", hash_generated_field = "6079C1AD224868A1FD2E6C91F592E8E5")

    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.621 -0400", hash_original_field = "15F5918F7AE8813144313B741FFB1E22", hash_generated_field = "4CF28041A91E5136B4028DFC45BF43A2")

    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.621 -0400", hash_original_field = "9EBA0E61C11598E64E5DEF9805AB1C87", hash_generated_field = "19D36D84D76399F2965778802906C5F4")

    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.621 -0400", hash_original_field = "DE5AF5B5F19EC717483AFBFE4F1515D0", hash_generated_field = "B6900B6DFFCE3EC3137AFAC8CDF141C8")

    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.621 -0400", hash_original_field = "DB6F58D0A19D67186E0E44A55BE76FC2", hash_generated_field = "A25E572D19EAB5FC775D99C2E5CBD7F9")

    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.621 -0400", hash_original_field = "8B16A56E23ABB90E8E8E8831ED3436AB", hash_generated_field = "6DBBDEA2F83957970766E3EB7A360D87")

    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.622 -0400", hash_original_field = "FDE7057C56CD851E5FD94130A9A8A115", hash_generated_field = "C963AC3E0F57998F2C6F71339C6345A2")

    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.622 -0400", hash_original_field = "FDFB59D4A2C0D29DFC5722412D488218", hash_generated_field = "9BC8B9B07F2BB6E9920B39CA1C7F82FB")

    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.622 -0400", hash_original_field = "A1D502698074B8130C1948EF8E35BC08", hash_generated_field = "5F4944DA22B7A103647F3EE380E7C7E1")

    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.622 -0400", hash_original_field = "88C56DE017A8E3EE82ECA5397D46AE32", hash_generated_field = "4AECE9433F73E3025A1218697C4A55F7")

    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.622 -0400", hash_original_field = "47775C2461025F148024416F34E44FEF", hash_generated_field = "D3A52877D04884CC38F2F15EF3C82C3E")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
}

