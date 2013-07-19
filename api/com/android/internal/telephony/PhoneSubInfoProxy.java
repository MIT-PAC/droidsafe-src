package com.android.internal.telephony;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.os.ServiceManager;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PhoneSubInfoProxy extends IPhoneSubInfo.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.907 -0400", hash_original_field = "95F855838AA6818DC0F0DA7E3A8E1DD6", hash_generated_field = "977885D72E5C857855A5A55FBD61054C")

    private PhoneSubInfo mPhoneSubInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.907 -0400", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "9BF13A48EE77042B8CBABE6781936843")
    public  PhoneSubInfoProxy(PhoneSubInfo phoneSubInfo) {
        mPhoneSubInfo = phoneSubInfo;
        if(ServiceManager.getService("iphonesubinfo") == null)        
        {
            ServiceManager.addService("iphonesubinfo", this);
        } //End block
        // ---------- Original Method ----------
        //mPhoneSubInfo = phoneSubInfo;
        //if(ServiceManager.getService("iphonesubinfo") == null) {
            //ServiceManager.addService("iphonesubinfo", this);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.907 -0400", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "D262168F541585EBD460EBA7053A0B05")
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        this.mPhoneSubInfo = phoneSubInfo;
        // ---------- Original Method ----------
        //this.mPhoneSubInfo = phoneSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "D7637AD06D9CA48308FEABA37484C761")
    public String getDeviceId() {
String var774D6DF031E7B965971D1CC76B153EA8_835004239 =         mPhoneSubInfo.getDeviceId();
        var774D6DF031E7B965971D1CC76B153EA8_835004239.addTaint(taint);
        return var774D6DF031E7B965971D1CC76B153EA8_835004239;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "A678E84934A361D25AA7D3DFD983AEF5")
    public String getDeviceSvn() {
String var658195DA09987FCDC970237CFC50B17E_357414413 =         mPhoneSubInfo.getDeviceSvn();
        var658195DA09987FCDC970237CFC50B17E_357414413.addTaint(taint);
        return var658195DA09987FCDC970237CFC50B17E_357414413;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "DC9E98E615188BD31290F958F503306C")
    public String getSubscriberId() {
String var15EB06BD6E38A16CE0B50FC4860EBF88_615994690 =         mPhoneSubInfo.getSubscriberId();
        var15EB06BD6E38A16CE0B50FC4860EBF88_615994690.addTaint(taint);
        return var15EB06BD6E38A16CE0B50FC4860EBF88_615994690;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "17AF691418FA7C7EF19EBB188EE03092")
    public String getIccSerialNumber() {
String var9B3DE8D3BA77FF712AFF1319F5781C49_81182611 =         mPhoneSubInfo.getIccSerialNumber();
        var9B3DE8D3BA77FF712AFF1319F5781C49_81182611.addTaint(taint);
        return var9B3DE8D3BA77FF712AFF1319F5781C49_81182611;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "4D0B3C336D5CD7C4993E26CA0A55D8D6")
    public String getLine1Number() {
String var78619270DC9056B01A41B8C7ADA444E2_1283583070 =         mPhoneSubInfo.getLine1Number();
        var78619270DC9056B01A41B8C7ADA444E2_1283583070.addTaint(taint);
        return var78619270DC9056B01A41B8C7ADA444E2_1283583070;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1Number();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "A39E3E8DBDAFEB33086574423D9B071A")
    public String getLine1AlphaTag() {
String varA8750D8FD1CA94253E89C0BCFFC60CB9_326259425 =         mPhoneSubInfo.getLine1AlphaTag();
        varA8750D8FD1CA94253E89C0BCFFC60CB9_326259425.addTaint(taint);
        return varA8750D8FD1CA94253E89C0BCFFC60CB9_326259425;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "22E5FAAA0BDEF6427833453651D9BC1B")
    public String getMsisdn() {
String var24AED85838D389D195B12B51CA6359D7_389531383 =         mPhoneSubInfo.getMsisdn();
        var24AED85838D389D195B12B51CA6359D7_389531383.addTaint(taint);
        return var24AED85838D389D195B12B51CA6359D7_389531383;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "1B822E920444EECEBB53B479A07E6E71")
    public String getVoiceMailNumber() {
String var1289AC061895FC7282FA4480C7C40382_1678560258 =         mPhoneSubInfo.getVoiceMailNumber();
        var1289AC061895FC7282FA4480C7C40382_1678560258.addTaint(taint);
        return var1289AC061895FC7282FA4480C7C40382_1678560258;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "41E45FFC04F0DA2253FD3144CF9A0167")
    public String getCompleteVoiceMailNumber() {
String var8DA80BFB3A6CD92FEEE1AD2D526947DD_835468467 =         mPhoneSubInfo.getCompleteVoiceMailNumber();
        var8DA80BFB3A6CD92FEEE1AD2D526947DD_835468467.addTaint(taint);
        return var8DA80BFB3A6CD92FEEE1AD2D526947DD_835468467;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "55A96233339E2C981BAB91B2CDB9AB18")
    public String getVoiceMailAlphaTag() {
String var6A0254709F47E9FE1BF2249A2A4C13F1_948220442 =         mPhoneSubInfo.getVoiceMailAlphaTag();
        var6A0254709F47E9FE1BF2249A2A4C13F1_948220442.addTaint(taint);
        return var6A0254709F47E9FE1BF2249A2A4C13F1_948220442;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "751D5BBA19776DDE1D85ACBE10EB69B1")
    public String getIsimImpi() {
String varC865A193A4F67CD851C732734DBFA25B_1610848623 =         mPhoneSubInfo.getIsimImpi();
        varC865A193A4F67CD851C732734DBFA25B_1610848623.addTaint(taint);
        return varC865A193A4F67CD851C732734DBFA25B_1610848623;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.908 -0400", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "A63C18AE548CF659B96F2997812EC62D")
    public String getIsimDomain() {
String var541DEE58069D9B2633FB1B116ACC1357_2114420611 =         mPhoneSubInfo.getIsimDomain();
        var541DEE58069D9B2633FB1B116ACC1357_2114420611.addTaint(taint);
        return var541DEE58069D9B2633FB1B116ACC1357_2114420611;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimDomain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.909 -0400", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "0893A499A86E80CA9DDDFFDC3B3D7BD4")
    public String[] getIsimImpu() {
String[] varC760810C18B4A09AFC768FF863D29C8E_844323995 =         mPhoneSubInfo.getIsimImpu();
        varC760810C18B4A09AFC768FF863D29C8E_844323995.addTaint(taint);
        return varC760810C18B4A09AFC768FF863D29C8E_844323995;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.909 -0400", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "863FE854AA8737B8C4A6AA5D40090D74")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(pw.getTaint());
        addTaint(fd.getTaint());
        mPhoneSubInfo.dump(fd, pw, args);
        // ---------- Original Method ----------
        //mPhoneSubInfo.dump(fd, pw, args);
    }

    
}

