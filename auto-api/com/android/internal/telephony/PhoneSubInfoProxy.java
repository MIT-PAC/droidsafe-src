package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.ServiceManager;

public class PhoneSubInfoProxy extends IPhoneSubInfo.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.787 -0400", hash_original_field = "95F855838AA6818DC0F0DA7E3A8E1DD6", hash_generated_field = "977885D72E5C857855A5A55FBD61054C")

    private PhoneSubInfo mPhoneSubInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.788 -0400", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "4D71876DCB868FDCC300C77D7A027EFE")
    public  PhoneSubInfoProxy(PhoneSubInfo phoneSubInfo) {
        mPhoneSubInfo = phoneSubInfo;
        {
            boolean var2203655666EE46F7BEFC8D224D628972_313767030 = (ServiceManager.getService("iphonesubinfo") == null);
            {
                ServiceManager.addService("iphonesubinfo", this);
            } 
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.788 -0400", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "D262168F541585EBD460EBA7053A0B05")
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        this.mPhoneSubInfo = phoneSubInfo;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.789 -0400", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "5F54D241ABF2BDC15376B51E37086AA5")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_441746828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_441746828 = mPhoneSubInfo.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_441746828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_441746828;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.789 -0400", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "920EA3C155317ED95F81FCEE34F5C030")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1469281685 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1469281685 = mPhoneSubInfo.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1469281685.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1469281685;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.790 -0400", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "6A5A752AE9083C128CE0AEBBE101AC0F")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1376952316 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1376952316 = mPhoneSubInfo.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_1376952316.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1376952316;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.790 -0400", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "6C743080C026F75215F57546BBF51E0B")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1336197653 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1336197653 = mPhoneSubInfo.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1336197653.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1336197653;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.791 -0400", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "516624189DC1364E4BAD5A4DA9B485F0")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_1664893338 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1664893338 = mPhoneSubInfo.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_1664893338.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1664893338;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.792 -0400", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "94095DF2719CFB0026BE04853B917E74")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_742260720 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_742260720 = mPhoneSubInfo.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_742260720.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_742260720;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.794 -0400", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "C6EDD9613184B9DDDE901E526B81E916")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1995379478 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1995379478 = mPhoneSubInfo.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_1995379478.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1995379478;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.795 -0400", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "BA85F2AEE88B1296874C7A20C9B44B65")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_2140018314 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2140018314 = mPhoneSubInfo.getVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_2140018314.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2140018314;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.796 -0400", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "64D076B7B82FF1B180CD22B0675DD064")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1635755047 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1635755047 = mPhoneSubInfo.getCompleteVoiceMailNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1635755047.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1635755047;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.797 -0400", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "F632EEA0D15197A90516DE238485D62D")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_345573322 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_345573322 = mPhoneSubInfo.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_345573322.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_345573322;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.798 -0400", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "CF547747BD62BE5614A36E68B823AEB2")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_1772586186 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1772586186 = mPhoneSubInfo.getIsimImpi();
        varB4EAC82CA7396A68D541C85D26508E83_1772586186.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1772586186;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.799 -0400", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "3F01F313A436BBDE460E3759FA6CFEE8")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1062458544 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1062458544 = mPhoneSubInfo.getIsimDomain();
        varB4EAC82CA7396A68D541C85D26508E83_1062458544.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1062458544;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.800 -0400", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "D8134E2583125E287B3EFBB0EF19BBBD")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1782001210 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1782001210 = mPhoneSubInfo.getIsimImpu();
        varB4EAC82CA7396A68D541C85D26508E83_1782001210.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1782001210;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.801 -0400", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "CE03338FAD2DA7598178FADFB4777B53")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        mPhoneSubInfo.dump(fd, pw, args);
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
}

