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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.166 -0400", hash_original_field = "95F855838AA6818DC0F0DA7E3A8E1DD6", hash_generated_field = "977885D72E5C857855A5A55FBD61054C")

    private PhoneSubInfo mPhoneSubInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.173 -0400", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "E8C528A08AB396DCA5ECC22DD7CE3FD7")
    public  PhoneSubInfoProxy(PhoneSubInfo phoneSubInfo) {
        mPhoneSubInfo = phoneSubInfo;
        {
            boolean var2203655666EE46F7BEFC8D224D628972_486247492 = (ServiceManager.getService("iphonesubinfo") == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.173 -0400", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "D262168F541585EBD460EBA7053A0B05")
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        this.mPhoneSubInfo = phoneSubInfo;
        // ---------- Original Method ----------
        //this.mPhoneSubInfo = phoneSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.174 -0400", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "62DD796510848CFD1A08C43D1D8D6B46")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_451172183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_451172183 = mPhoneSubInfo.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_451172183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451172183;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.175 -0400", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "8A70EE270A71EDDF134EEEBA441E2DA3")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_617956777 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_617956777 = mPhoneSubInfo.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_617956777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_617956777;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.198 -0400", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "7F94421E298074959625BF732755C5DD")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_639700067 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_639700067 = mPhoneSubInfo.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_639700067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_639700067;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.198 -0400", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "E9ACE8D2BCD455C57476D86C352652D2")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_829640116 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_829640116 = mPhoneSubInfo.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_829640116.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_829640116;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.199 -0400", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "A17DEC8F285B8F071A905D65B68BE236")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1202899109 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1202899109 = mPhoneSubInfo.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_1202899109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1202899109;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.199 -0400", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "DE9A79340A4DC04F181591A618D2CA3B")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1700264956 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1700264956 = mPhoneSubInfo.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1700264956.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1700264956;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.200 -0400", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "986DBC598E766F93E5E651175B1E58DD")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_657769581 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_657769581 = mPhoneSubInfo.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_657769581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_657769581;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.201 -0400", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "B4956AB09EF1BB2A9E46D6854AE1DEA2")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_212475817 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_212475817 = mPhoneSubInfo.getVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_212475817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_212475817;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.202 -0400", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "C0D532C9CB3FAC208FEF1166887227E4")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_454092773 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_454092773 = mPhoneSubInfo.getCompleteVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_454092773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_454092773;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.202 -0400", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "40B05C56C14A525A2196C1895E3B8A6D")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_153862518 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_153862518 = mPhoneSubInfo.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_153862518.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_153862518;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.202 -0400", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "29749881F87E580BFB298A39DEB38C0C")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_467524761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_467524761 = mPhoneSubInfo.getIsimImpi();
        varB4EAC82CA7396A68D541C85D26508E83_467524761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_467524761;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.203 -0400", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "C4AF18A3DE5809DADD557F329B2BF3CD")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1155807186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1155807186 = mPhoneSubInfo.getIsimDomain();
        varB4EAC82CA7396A68D541C85D26508E83_1155807186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1155807186;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimDomain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.203 -0400", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "3D7074970C1085BBC227B804EB37F699")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_345795738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_345795738 = mPhoneSubInfo.getIsimImpu();
        varB4EAC82CA7396A68D541C85D26508E83_345795738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345795738;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.217 -0400", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "CE03338FAD2DA7598178FADFB4777B53")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        mPhoneSubInfo.dump(fd, pw, args);
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //mPhoneSubInfo.dump(fd, pw, args);
    }

    
}

