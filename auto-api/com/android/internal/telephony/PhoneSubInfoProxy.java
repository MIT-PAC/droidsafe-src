package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.ServiceManager;

public class PhoneSubInfoProxy extends IPhoneSubInfo.Stub {
    private PhoneSubInfo mPhoneSubInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.737 -0400", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "0AE9406DBBAB78E0D1C9E038B628551C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneSubInfoProxy(PhoneSubInfo phoneSubInfo) {
        dsTaint.addTaint(phoneSubInfo.dsTaint);
        {
            boolean var2203655666EE46F7BEFC8D224D628972_1303431699 = (ServiceManager.getService("iphonesubinfo") == null);
            {
                ServiceManager.addService("iphonesubinfo", this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mPhoneSubInfo = phoneSubInfo;
        //if(ServiceManager.getService("iphonesubinfo") == null) {
            //ServiceManager.addService("iphonesubinfo", this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.737 -0400", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "B6468282351285EE8A1DD06ECCDFD991")
    @DSModeled(DSC.SAFE)
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        dsTaint.addTaint(phoneSubInfo.dsTaint);
        // ---------- Original Method ----------
        //this.mPhoneSubInfo = phoneSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.737 -0400", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "6221CFF2F7DC1DF58C81A4533B289E36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        String varD5FDA813F932237DC42F009465D9207C_803474799 = (mPhoneSubInfo.getDeviceId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.737 -0400", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "B66437D400AFF40A879308A7AEE7578D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceSvn() {
        String var4E23D51C01FC28CB0DFBAC5E982D1D6A_1398330199 = (mPhoneSubInfo.getDeviceSvn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.737 -0400", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "FD5E5221B6E675C8D825C6D87398D906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        String varFD0D821FD9E5B1A85376A6F16261C4A4_26789176 = (mPhoneSubInfo.getSubscriberId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.738 -0400", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "45F40D4F66992C67F7A1D2E0ECC9C4B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIccSerialNumber() {
        String var7BA0189A6F7FFDEF4418E3CEA5DE7261_1939149887 = (mPhoneSubInfo.getIccSerialNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.738 -0400", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "7AAA198F887C23868816D3EB841BE711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        String var1C972B26906F13D52978577EE59F9F2A_476548948 = (mPhoneSubInfo.getLine1Number());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.738 -0400", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "5142234785C1FC5CE5FAEFE9DFDED4AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        String varD75055D8A101705A290956440DA07CF2_914072109 = (mPhoneSubInfo.getLine1AlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.738 -0400", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "FD9B7EFC58B7A8D2815A2115AFEC69E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMsisdn() {
        String var81EB3EC761B7E693FE7EF0BEC00896F7_535837480 = (mPhoneSubInfo.getMsisdn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.738 -0400", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "87A1D71D1E9AB6CDD545F345ADCB0271")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        String var69B1D5D19453AA9939817AEF86CCBA3C_1061420829 = (mPhoneSubInfo.getVoiceMailNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.739 -0400", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "A845F18787450609ED9C4A5CF7DD0780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCompleteVoiceMailNumber() {
        String varB8AF62242E3E7B44B28F9F4D08302935_44989808 = (mPhoneSubInfo.getCompleteVoiceMailNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.739 -0400", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "B3B521A5C8E0D62211F265FB0268DE2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        String var5DC49869BE7750A576EF3CF1A3960E6C_1735130483 = (mPhoneSubInfo.getVoiceMailAlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.739 -0400", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "58F132F02C4A2DC0A6A89E5721E7587D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsimImpi() {
        String var6ABA5AA8636A7E9B6E44C1DCA9DEA7C6_1186688259 = (mPhoneSubInfo.getIsimImpi());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.739 -0400", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "4677BD36833022B6F1072CE9ED3EFAD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsimDomain() {
        String var4C7BFB653A7E6D8C94BD1092C61B79ED_1986315287 = (mPhoneSubInfo.getIsimDomain());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimDomain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.739 -0400", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "72E61B194CEB6FE21448C9E9BBB4AC2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getIsimImpu() {
        String[] var02C179EE7D63535EF4F9720E5D365235_340577712 = (mPhoneSubInfo.getIsimImpu());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.739 -0400", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "40DECA0B68041856B4353E96E0C40A15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        mPhoneSubInfo.dump(fd, pw, args);
        // ---------- Original Method ----------
        //mPhoneSubInfo.dump(fd, pw, args);
    }

    
}

