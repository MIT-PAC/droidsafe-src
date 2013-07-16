package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.ServiceManager;

public class PhoneSubInfoProxy extends IPhoneSubInfo.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.356 -0400", hash_original_field = "95F855838AA6818DC0F0DA7E3A8E1DD6", hash_generated_field = "977885D72E5C857855A5A55FBD61054C")

    private PhoneSubInfo mPhoneSubInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "9BF13A48EE77042B8CBABE6781936843")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "D262168F541585EBD460EBA7053A0B05")
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        this.mPhoneSubInfo = phoneSubInfo;
        // ---------- Original Method ----------
        //this.mPhoneSubInfo = phoneSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "BED4D03E9A2827FDCF0F4E425814F997")
    public String getDeviceId() {
String var774D6DF031E7B965971D1CC76B153EA8_1601711775 =         mPhoneSubInfo.getDeviceId();
        var774D6DF031E7B965971D1CC76B153EA8_1601711775.addTaint(taint);
        return var774D6DF031E7B965971D1CC76B153EA8_1601711775;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "5CB7A99BC3ECC2F1E756EEB45D069EAE")
    public String getDeviceSvn() {
String var658195DA09987FCDC970237CFC50B17E_1081533127 =         mPhoneSubInfo.getDeviceSvn();
        var658195DA09987FCDC970237CFC50B17E_1081533127.addTaint(taint);
        return var658195DA09987FCDC970237CFC50B17E_1081533127;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "FBA002394691B0C8A715C37E490E9AFD")
    public String getSubscriberId() {
String var15EB06BD6E38A16CE0B50FC4860EBF88_449130785 =         mPhoneSubInfo.getSubscriberId();
        var15EB06BD6E38A16CE0B50FC4860EBF88_449130785.addTaint(taint);
        return var15EB06BD6E38A16CE0B50FC4860EBF88_449130785;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "B1D27F16A4DB6E333D2E34E6DEE40A5A")
    public String getIccSerialNumber() {
String var9B3DE8D3BA77FF712AFF1319F5781C49_1350674193 =         mPhoneSubInfo.getIccSerialNumber();
        var9B3DE8D3BA77FF712AFF1319F5781C49_1350674193.addTaint(taint);
        return var9B3DE8D3BA77FF712AFF1319F5781C49_1350674193;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "EEBC9E76BC86B87E6B2C405FE373F837")
    public String getLine1Number() {
String var78619270DC9056B01A41B8C7ADA444E2_638446639 =         mPhoneSubInfo.getLine1Number();
        var78619270DC9056B01A41B8C7ADA444E2_638446639.addTaint(taint);
        return var78619270DC9056B01A41B8C7ADA444E2_638446639;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1Number();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "A8859177414B3593BE5A08ADD4B1C694")
    public String getLine1AlphaTag() {
String varA8750D8FD1CA94253E89C0BCFFC60CB9_27905860 =         mPhoneSubInfo.getLine1AlphaTag();
        varA8750D8FD1CA94253E89C0BCFFC60CB9_27905860.addTaint(taint);
        return varA8750D8FD1CA94253E89C0BCFFC60CB9_27905860;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.357 -0400", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "39F906C87EEF9D903A16EFF65240F5ED")
    public String getMsisdn() {
String var24AED85838D389D195B12B51CA6359D7_1823035080 =         mPhoneSubInfo.getMsisdn();
        var24AED85838D389D195B12B51CA6359D7_1823035080.addTaint(taint);
        return var24AED85838D389D195B12B51CA6359D7_1823035080;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "FCBE5142F350259DC686C09111A8CF8B")
    public String getVoiceMailNumber() {
String var1289AC061895FC7282FA4480C7C40382_1565895766 =         mPhoneSubInfo.getVoiceMailNumber();
        var1289AC061895FC7282FA4480C7C40382_1565895766.addTaint(taint);
        return var1289AC061895FC7282FA4480C7C40382_1565895766;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "0020FB4D2883DEEA07DB9E44DB77BB33")
    public String getCompleteVoiceMailNumber() {
String var8DA80BFB3A6CD92FEEE1AD2D526947DD_1076766276 =         mPhoneSubInfo.getCompleteVoiceMailNumber();
        var8DA80BFB3A6CD92FEEE1AD2D526947DD_1076766276.addTaint(taint);
        return var8DA80BFB3A6CD92FEEE1AD2D526947DD_1076766276;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "7E8807D314CF4D793B70F60AEF7EA7E1")
    public String getVoiceMailAlphaTag() {
String var6A0254709F47E9FE1BF2249A2A4C13F1_2058421023 =         mPhoneSubInfo.getVoiceMailAlphaTag();
        var6A0254709F47E9FE1BF2249A2A4C13F1_2058421023.addTaint(taint);
        return var6A0254709F47E9FE1BF2249A2A4C13F1_2058421023;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "1C312F91680F6E399E031282D8C5F21E")
    public String getIsimImpi() {
String varC865A193A4F67CD851C732734DBFA25B_963880986 =         mPhoneSubInfo.getIsimImpi();
        varC865A193A4F67CD851C732734DBFA25B_963880986.addTaint(taint);
        return varC865A193A4F67CD851C732734DBFA25B_963880986;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "C07F3954527BEAD582E13F91BDEDE8AD")
    public String getIsimDomain() {
String var541DEE58069D9B2633FB1B116ACC1357_288879881 =         mPhoneSubInfo.getIsimDomain();
        var541DEE58069D9B2633FB1B116ACC1357_288879881.addTaint(taint);
        return var541DEE58069D9B2633FB1B116ACC1357_288879881;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimDomain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "E27AA3301CA40C23E0BBAC076F6A9A01")
    public String[] getIsimImpu() {
String[] varC760810C18B4A09AFC768FF863D29C8E_713793185 =         mPhoneSubInfo.getIsimImpu();
        varC760810C18B4A09AFC768FF863D29C8E_713793185.addTaint(taint);
        return varC760810C18B4A09AFC768FF863D29C8E_713793185;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.358 -0400", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "863FE854AA8737B8C4A6AA5D40090D74")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(pw.getTaint());
        addTaint(fd.getTaint());
        mPhoneSubInfo.dump(fd, pw, args);
        // ---------- Original Method ----------
        //mPhoneSubInfo.dump(fd, pw, args);
    }

    
}

