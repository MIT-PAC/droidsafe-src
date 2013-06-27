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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.677 -0400", hash_original_field = "95F855838AA6818DC0F0DA7E3A8E1DD6", hash_generated_field = "977885D72E5C857855A5A55FBD61054C")

    private PhoneSubInfo mPhoneSubInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.678 -0400", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "0163DF8068F487B010FE25052F75A98C")
    public  PhoneSubInfoProxy(PhoneSubInfo phoneSubInfo) {
        mPhoneSubInfo = phoneSubInfo;
        {
            boolean var2203655666EE46F7BEFC8D224D628972_2127026749 = (ServiceManager.getService("iphonesubinfo") == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.678 -0400", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "D262168F541585EBD460EBA7053A0B05")
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        this.mPhoneSubInfo = phoneSubInfo;
        // ---------- Original Method ----------
        //this.mPhoneSubInfo = phoneSubInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.679 -0400", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "ECFB6E78562A746F19C308CA73E391D7")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_995188804 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_995188804 = mPhoneSubInfo.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_995188804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_995188804;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.679 -0400", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "4A66527E9895CD51400868926297A866")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1885643905 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1885643905 = mPhoneSubInfo.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1885643905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1885643905;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.688 -0400", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "59E27EF001DEF20CF1CE98CFE43F3622")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_98572459 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_98572459 = mPhoneSubInfo.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_98572459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_98572459;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.689 -0400", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "22FF1641A2F16C5FD0AFE497734EAAAF")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_2115037288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115037288 = mPhoneSubInfo.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_2115037288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115037288;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.691 -0400", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "B1A40C777874F57FD45FC22A8C334F58")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1754495557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1754495557 = mPhoneSubInfo.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_1754495557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1754495557;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.696 -0400", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "5098A29AB670DEBF2F088E27CDBA2FAC")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1162067409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1162067409 = mPhoneSubInfo.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1162067409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1162067409;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.701 -0400", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "9693B37B76D3A92528BFE01E08784F33")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1782400513 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1782400513 = mPhoneSubInfo.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_1782400513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1782400513;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.702 -0400", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "699E23FB56D28525CFE372619C00F572")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_493074348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_493074348 = mPhoneSubInfo.getVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_493074348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493074348;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.702 -0400", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "F0571CC4E20CC402A5E37D8549DF2E84")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1280945616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1280945616 = mPhoneSubInfo.getCompleteVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1280945616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1280945616;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.715 -0400", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "E192039BBF0C4ECD18B0EFE1FE237D4A")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_943349209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_943349209 = mPhoneSubInfo.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_943349209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_943349209;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.715 -0400", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "518BC9E04ADA4B50C6E845E1EE2B4808")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_2096088656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2096088656 = mPhoneSubInfo.getIsimImpi();
        varB4EAC82CA7396A68D541C85D26508E83_2096088656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2096088656;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpi();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.716 -0400", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "23A287E769E5BDA0948EE8CEA8A60588")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1211014678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1211014678 = mPhoneSubInfo.getIsimDomain();
        varB4EAC82CA7396A68D541C85D26508E83_1211014678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1211014678;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimDomain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.716 -0400", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "32A79AF34FE61708B7E32424A4246681")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_643167464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_643167464 = mPhoneSubInfo.getIsimImpu();
        varB4EAC82CA7396A68D541C85D26508E83_643167464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_643167464;
        // ---------- Original Method ----------
        //return mPhoneSubInfo.getIsimImpu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.717 -0400", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "CE03338FAD2DA7598178FADFB4777B53")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        mPhoneSubInfo.dump(fd, pw, args);
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //mPhoneSubInfo.dump(fd, pw, args);
    }

    
}

