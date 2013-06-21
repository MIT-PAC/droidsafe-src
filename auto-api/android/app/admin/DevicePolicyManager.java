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
    private Context mContext;
    private IDevicePolicyManager mService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.304 -0400", hash_original_method = "50DCCFAFB01D68C84073DED89668D8AE", hash_generated_method = "E68A7AC649EA88EC89C377A767894674")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DevicePolicyManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.305 -0400", hash_original_method = "DEBAA688BC0765F8640468141F520924", hash_generated_method = "031166251EB57910F9A2CF4A0A6B50B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAdminActive(ComponentName who) {
        dsTaint.addTaint(who.dsTaint);
        {
            try 
            {
                boolean varDDC18424843F25DBAC66701537992DCA_933705860 = (mService.isAdminActive(who));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.305 -0400", hash_original_method = "304202BD61CAAFAF35BBB8D3C8BC6AB8", hash_generated_method = "BD1EF48ED91F122EC74FACC4ECFC9599")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ComponentName> getActiveAdmins() {
        {
            try 
            {
                List<ComponentName> var198B74327AA9CA4DA9239BF8D84410A3_913694297 = (mService.getActiveAdmins());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return (List<ComponentName>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.306 -0400", hash_original_method = "EE57BBE804AE4C87F4CB89ED9793C019", hash_generated_method = "8CCED28837E682772DFAC3EB0565BF69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean packageHasActiveAdmins(String packageName) {
        dsTaint.addTaint(packageName);
        {
            try 
            {
                boolean var9AD91614F7E6A3EB6B4DC1ED0C825051_1913619926 = (mService.packageHasActiveAdmins(packageName));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.306 -0400", hash_original_method = "260DBD46AB1A27EF2CC0A61E058D7901", hash_generated_method = "84C082130AA257F37B2030B22E397539")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeActiveAdmin(ComponentName who) {
        dsTaint.addTaint(who.dsTaint);
        {
            try 
            {
                mService.removeActiveAdmin(who);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.307 -0400", hash_original_method = "23A835CF05C7A5BCBD423FD3E5C1A622", hash_generated_method = "33C13B47E873F34D3FEE4E0F533B574D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasGrantedPolicy(ComponentName admin, int usesPolicy) {
        dsTaint.addTaint(usesPolicy);
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                boolean var8293FAA2FE4C2CA275B458FF6F9999B9_984075378 = (mService.hasGrantedPolicy(admin, usesPolicy));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.307 -0400", hash_original_method = "59F8BF318650672CABE968E5789C79B4", hash_generated_method = "9E662377C89E2FE5DBF3A73EABA6C7A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordQuality(ComponentName admin, int quality) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(quality);
        {
            try 
            {
                mService.setPasswordQuality(admin, quality);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.307 -0400", hash_original_method = "953DAEE8D36D414E1ED2EDA688583D7B", hash_generated_method = "6862B511CB72CBF54A4F5AD6A77A3B5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordQuality(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var50B1D404B3237CB299636EA0B85E73CC_1519907662 = (mService.getPasswordQuality(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.308 -0400", hash_original_method = "F270559FB103FDDF70DB07978E6CE793", hash_generated_method = "2ACAEAFAFAD7EE3AA611F4F5BE861C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumLength(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumLength(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.308 -0400", hash_original_method = "0BF67C005C50195D588980E6F78FE344", hash_generated_method = "347BB7742E5ED394D1170180D99C53B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumLength(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var3F407E749EA5B2DC2542A0A7919871DB_1617495917 = (mService.getPasswordMinimumLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.309 -0400", hash_original_method = "B0A7D811F24F382978794CAD91B66775", hash_generated_method = "6486C954778774DF32902AF2C2D7A843")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumUpperCase(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumUpperCase(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.309 -0400", hash_original_method = "42E8A5AFC85991E9FFA780A53F7AB6A7", hash_generated_method = "D422936E39A369824CD83410BD050755")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumUpperCase(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var99860992B7CBA8049416DD538EB3AE3F_2002960023 = (mService.getPasswordMinimumUpperCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.310 -0400", hash_original_method = "411E57E6ADFDEF4CCE60FF315FF9330B", hash_generated_method = "BB17CD1C87E81A496FDB8F584B495FEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumLowerCase(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumLowerCase(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.310 -0400", hash_original_method = "115CC4F3CDF24178A32FCDB4FA3C0CE3", hash_generated_method = "33592F12CDD1E46B537B33C9CCF7A300")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumLowerCase(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var777E882DCA72E018D863B51B9CC2D33E_1746265403 = (mService.getPasswordMinimumLowerCase(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.311 -0400", hash_original_method = "14047A2F7D126C90FC5B2063BAF2E4A1", hash_generated_method = "786FCA4723F9E62C838732548DD1FFA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumLetters(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumLetters(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.311 -0400", hash_original_method = "B7290C5B6AA0AFA6598FFFCBACAFA85A", hash_generated_method = "942DDF7EE521C7EB3F2E47719E189345")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumLetters(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var579CFE59F49EAFA16CF346F87A7CF37C_2060249263 = (mService.getPasswordMinimumLetters(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.312 -0400", hash_original_method = "33FACE9A88EEFFC907427A4DE2511E88", hash_generated_method = "8C1E0F182F68647A41A96E18A82242A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumNumeric(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumNumeric(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.312 -0400", hash_original_method = "55CECC6BB4262687B1FECD13F88E35AB", hash_generated_method = "82B64B9E477F30389050868E49268468")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumNumeric(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int varA96658E08799B3973A9806AB9C11888E_350124014 = (mService.getPasswordMinimumNumeric(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.313 -0400", hash_original_method = "D86720687DC7C5B971FF240E5ADCEB58", hash_generated_method = "B43B6B4E2628FAF3F4BB77B26D7D1260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumSymbols(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumSymbols(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.314 -0400", hash_original_method = "97C1C4934ACB04DD5927B31B09CB55B5", hash_generated_method = "3888FE5E0B736FC01B01D0016ADAAC39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumSymbols(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int varC5459125C02CCD305A9D65BA82E945C4_884551309 = (mService.getPasswordMinimumSymbols(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.317 -0400", hash_original_method = "8F226B24E69D209379BEE3195F22A7DC", hash_generated_method = "ECAC1ECF47E20B3D04C4FDF40122643F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordMinimumNonLetter(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordMinimumNonLetter(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.319 -0400", hash_original_method = "8ED1E73D193F12CF2F8CF85176FE9B97", hash_generated_method = "F833CA4472CDC8FD39A9EF8A29D17FA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordMinimumNonLetter(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int varA4D869D416A4BC57B2A8EF3FBE9140CA_118711637 = (mService.getPasswordMinimumNonLetter(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.322 -0400", hash_original_method = "56A45FF24A713BC35886C94CD936741A", hash_generated_method = "619F165822FE61C0F7C18187666891F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordHistoryLength(ComponentName admin, int length) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(length);
        {
            try 
            {
                mService.setPasswordHistoryLength(admin, length);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.324 -0400", hash_original_method = "A2F840E60969344CDBBA08F42E12EB97", hash_generated_method = "318EAFF01C4ADCD938A5F16A32E1B3F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPasswordExpirationTimeout(ComponentName admin, long timeout) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(timeout);
        {
            try 
            {
                mService.setPasswordExpirationTimeout(admin, timeout);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.324 -0400", hash_original_method = "31D7885DD1B838E718F93D593801E489", hash_generated_method = "C1D96C5C4CA149446571BE3991817E45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getPasswordExpirationTimeout(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                long var8E0E92ED0AE24F586AFBAEFC4C90C962_2146639384 = (mService.getPasswordExpirationTimeout(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.325 -0400", hash_original_method = "F850BD1F4A684FFED232083DC78EC214", hash_generated_method = "38163052B0241272F125C98045942323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getPasswordExpiration(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                long varA425B12B3ADC7B11B7AB412B878E8D27_738921963 = (mService.getPasswordExpiration(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.325 -0400", hash_original_method = "6A25C50AEC7E714C844A4ACF270DA0EA", hash_generated_method = "1A02197F08A7A2C066038D8C30F04096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPasswordHistoryLength(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var6B58013F3CE3A15346CE8AB072CAF025_1014481344 = (mService.getPasswordHistoryLength(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.326 -0400", hash_original_method = "B720364465717C512AF715245037D814", hash_generated_method = "4DCB66A7FEB5EBCDAE3CFCC620F41E01")
    @DSModeled(DSC.SAFE)
    public int getPasswordMaximumLength(int quality) {
        dsTaint.addTaint(quality);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.326 -0400", hash_original_method = "2B762200302C4E580602F331CF81E49C", hash_generated_method = "9B0635B0B6D022278AD18FF9CB2FDC2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isActivePasswordSufficient() {
        {
            try 
            {
                boolean var4C9DBF611B0D22EF5B0E4B1EC5D17B72_1414022376 = (mService.isActivePasswordSufficient());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.327 -0400", hash_original_method = "EACD63B4064B49538F5A848510A5F41A", hash_generated_method = "19D41807430E6C1EFA2F28DAE3280507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCurrentFailedPasswordAttempts() {
        {
            try 
            {
                int varACF84C8123F19D3EC9F60D2D8BF605DA_1823826398 = (mService.getCurrentFailedPasswordAttempts());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.328 -0400", hash_original_method = "386BE05045BF9977A6E5636AA6860E45", hash_generated_method = "A1E9D5FEAFE7560B0AEB14BD41D24E00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumFailedPasswordsForWipe(ComponentName admin, int num) {
        dsTaint.addTaint(num);
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                mService.setMaximumFailedPasswordsForWipe(admin, num);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.328 -0400", hash_original_method = "2F7102BE4460977EBBF2224AD7A1647D", hash_generated_method = "E38F9FC3019A162A356F1201EEBD027D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaximumFailedPasswordsForWipe(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var79667AF6709342EB68CFAD29539CB206_1910854611 = (mService.getMaximumFailedPasswordsForWipe(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.329 -0400", hash_original_method = "17E6FC8B97A136DE019ACBDDB18AEC37", hash_generated_method = "86D5B781C0D2081CD468B84F55138CC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean resetPassword(String password, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(password);
        {
            try 
            {
                boolean var60406D42B56A6445438EDD773C9D0828_304494254 = (mService.resetPassword(password, flags));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.329 -0400", hash_original_method = "063F6779A334FCBA41EF649C9EC5AECE", hash_generated_method = "9FAB0561DBEDD8DE46232EB269C91E50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumTimeToLock(ComponentName admin, long timeMs) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(timeMs);
        {
            try 
            {
                mService.setMaximumTimeToLock(admin, timeMs);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.340 -0400", hash_original_method = "236548EEF0B27F3ADB5D68074D378910", hash_generated_method = "EC9CAF6C42A8667E9F121B30138C7B1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getMaximumTimeToLock(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                long varB8C855E033294E8C52BAAD4F39092DB8_1033071795 = (mService.getMaximumTimeToLock(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.342 -0400", hash_original_method = "1AD41EB1582F6A4A56913D2EEA649B59", hash_generated_method = "AB2EEBEA8902EB56BFA2E2D0BFBEA706")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.343 -0400", hash_original_method = "6CEDCC268C3E709685447E15BC08FD3A", hash_generated_method = "5E50A013FE855FC4946E2C82979BD6AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void wipeData(int flags) {
        dsTaint.addTaint(flags);
        {
            try 
            {
                mService.wipeData(flags);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.412 -0400", hash_original_method = "53AB2A6BFBDB5E04C8F47C30215E30C2", hash_generated_method = "FA025A57C7CB41551D5B6E56C4B76FB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName setGlobalProxy(ComponentName admin, Proxy proxySpec,
            List<String> exclusionList ) {
        dsTaint.addTaint(exclusionList.dsTaint);
        dsTaint.addTaint(proxySpec.dsTaint);
        dsTaint.addTaint(admin.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            try 
            {
                String hostSpec;
                String exclSpec;
                {
                    boolean varAEB17C6E60EDCE7B80F1428467000DDC_182331678 = (proxySpec.equals(Proxy.NO_PROXY));
                    {
                        hostSpec = null;
                        exclSpec = null;
                    } //End block
                    {
                        {
                            boolean varD0F96407A07133F267A111443D9B66E2_261129982 = (!proxySpec.type().equals(Proxy.Type.HTTP));
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
                                Iterator<String> var9A7ECA37DFC1650714BF7C8F9684918D_1926779020 = (exclusionList).iterator();
                                var9A7ECA37DFC1650714BF7C8F9684918D_1926779020.hasNext();
                                String exclDomain = var9A7ECA37DFC1650714BF7C8F9684918D_1926779020.next();
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
                ComponentName var95F3C6FF61E83564BAFEC27D46479307_30009682 = (mService.setGlobalProxy(admin, hostSpec, exclSpec));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.413 -0400", hash_original_method = "46A87FF58FD44FDC19B7F90436F7E978", hash_generated_method = "8778FCDED5CC12BA45C71E5C26A4A719")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getGlobalProxyAdmin() {
        {
            try 
            {
                ComponentName var54649D5060AA49DC6F3825C8A48F923E_218157298 = (mService.getGlobalProxyAdmin());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return (ComponentName)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.414 -0400", hash_original_method = "17B73A4F954CB746271DADF07BB03245", hash_generated_method = "4D98AE00CD1EEC3A8D0385F80482B289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setStorageEncryption(ComponentName admin, boolean encrypt) {
        dsTaint.addTaint(encrypt);
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                int var6405E0D4C3D4E429E287870D4B288E54_1675804413 = (mService.setStorageEncryption(admin, encrypt));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.414 -0400", hash_original_method = "9A4BD9BB365A613657C962C51C854645", hash_generated_method = "302940EB87CDA3C65CE61B116BE8B2E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getStorageEncryption(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                boolean var5C8A37DD1003FF92AB2322C9A6C4947D_541549147 = (mService.getStorageEncryption(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.415 -0400", hash_original_method = "6CEE42CBFD4B02D7CAAADEA83FCF3486", hash_generated_method = "E345693B23B5695400FD1843933ED7BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStorageEncryptionStatus() {
        {
            try 
            {
                int var81B597DAD09BDD3F2A452B82A5024492_419865705 = (mService.getStorageEncryptionStatus());
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.416 -0400", hash_original_method = "A5F298BC4842F29AB6F496D6FD4E07FD", hash_generated_method = "DEC6F44E523C6C7959FF335A6791B73B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCameraDisabled(ComponentName admin, boolean disabled) {
        dsTaint.addTaint(admin.dsTaint);
        dsTaint.addTaint(disabled);
        {
            try 
            {
                mService.setCameraDisabled(admin, disabled);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.416 -0400", hash_original_method = "8D92C22AE776D4D287A7DAE7D5749852", hash_generated_method = "C1E1B664070C1DF6E8FCE00D99B115BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getCameraDisabled(ComponentName admin) {
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                boolean var14E94D42F97BE45817ED8F25DE3A71A7_1016250669 = (mService.getCameraDisabled(admin));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.434 -0400", hash_original_method = "2E5C17164A00D32AA17FC960DDB2A30B", hash_generated_method = "74EEF639915F5964415B04FCF642F51A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setActiveAdmin(ComponentName policyReceiver, boolean refreshing) {
        dsTaint.addTaint(policyReceiver.dsTaint);
        dsTaint.addTaint(refreshing);
        {
            try 
            {
                mService.setActiveAdmin(policyReceiver, refreshing);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.437 -0400", hash_original_method = "6B96BC98EC991BA4501EAC59D3A81719", hash_generated_method = "9A62559BABAD144086602BDBFD243D80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeviceAdminInfo getAdminInfo(ComponentName cn) {
        dsTaint.addTaint(cn.dsTaint);
        ActivityInfo ai;
        try 
        {
            ai = mContext.getPackageManager().getReceiverInfo(cn,
                    PackageManager.GET_META_DATA);
        } //End block
        catch (PackageManager.NameNotFoundException e)
        { }
        ResolveInfo ri;
        ri = new ResolveInfo();
        ri.activityInfo = ai;
        try 
        {
            DeviceAdminInfo var9E3ACDDC8F47C587C293EB00BAADF2A4_574358581 = (new DeviceAdminInfo(mContext, ri));
        } //End block
        catch (XmlPullParserException e)
        { }
        catch (IOException e)
        { }
        return (DeviceAdminInfo)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.437 -0400", hash_original_method = "B78826B0ABC7DA178D8BC699F76B9B76", hash_generated_method = "01D2217332C008ACB43A5C66F5FB36B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getRemoveWarning(ComponentName admin, RemoteCallback result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(admin.dsTaint);
        {
            try 
            {
                mService.getRemoveWarning(admin, result);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.438 -0400", hash_original_method = "6E15637B027827B7A463543C03AC9E11", hash_generated_method = "9DE5F36D0A78AF9AC95C56625F2607EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setActivePasswordState(int quality, int length, int letters, int uppercase,
            int lowercase, int numbers, int symbols, int nonletter) {
        dsTaint.addTaint(uppercase);
        dsTaint.addTaint(symbols);
        dsTaint.addTaint(numbers);
        dsTaint.addTaint(lowercase);
        dsTaint.addTaint(length);
        dsTaint.addTaint(quality);
        dsTaint.addTaint(nonletter);
        dsTaint.addTaint(letters);
        {
            try 
            {
                mService.setActivePasswordState(quality, length, letters, uppercase, lowercase,
                        numbers, symbols, nonletter);
            } //End block
            catch (RemoteException e)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.438 -0400", hash_original_method = "7A06EB783FBF60A73CE8C82F7F508BC8", hash_generated_method = "DA0F8855CD045EED7A79AE05D37D6F31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.439 -0400", hash_original_method = "715E68F4DA8529CFE0A9E396D6B5FAA4", hash_generated_method = "E63AA8E5F1B277C83F37B55FD191792B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    private static String TAG = "DevicePolicyManager";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_ADD_DEVICE_ADMIN
            = "android.app.action.ADD_DEVICE_ADMIN";
    public static final String ACTION_DEVICE_POLICY_MANAGER_STATE_CHANGED
            = "android.app.action.DEVICE_POLICY_MANAGER_STATE_CHANGED";
    public static final String EXTRA_DEVICE_ADMIN = "android.app.extra.DEVICE_ADMIN";
    public static final String EXTRA_ADD_EXPLANATION = "android.app.extra.ADD_EXPLANATION";
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_SET_NEW_PASSWORD
            = "android.app.action.SET_NEW_PASSWORD";
    public static final int PASSWORD_QUALITY_UNSPECIFIED = 0;
    public static final int PASSWORD_QUALITY_BIOMETRIC_WEAK = 0x8000;
    public static final int PASSWORD_QUALITY_SOMETHING = 0x10000;
    public static final int PASSWORD_QUALITY_NUMERIC = 0x20000;
    public static final int PASSWORD_QUALITY_ALPHABETIC = 0x40000;
    public static final int PASSWORD_QUALITY_ALPHANUMERIC = 0x50000;
    public static final int PASSWORD_QUALITY_COMPLEX = 0x60000;
    public static final int RESET_PASSWORD_REQUIRE_ENTRY = 0x0001;
    public static final int WIPE_EXTERNAL_STORAGE = 0x0001;
    public static final int ENCRYPTION_STATUS_UNSUPPORTED = 0;
    public static final int ENCRYPTION_STATUS_INACTIVE = 1;
    public static final int ENCRYPTION_STATUS_ACTIVATING = 2;
    public static final int ENCRYPTION_STATUS_ACTIVE = 3;
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_START_ENCRYPTION
            = "android.app.action.START_ENCRYPTION";
}

