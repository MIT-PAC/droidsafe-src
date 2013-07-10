package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.android.internal.telephony.ims.IsimRecords;

public class PhoneSubInfo extends IPhoneSubInfo.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.755 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.755 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.756 -0400", hash_original_method = "8625E021A884D0AE1BFAA6115C272865", hash_generated_method = "B9BD004AC9C267676755058C8A68D9F4")
    public  PhoneSubInfo(Phone phone) {
        mPhone = phone;
        mContext = phone.getContext();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.756 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.757 -0400", hash_original_method = "0C75AFD9B32739C91AE66AE73680B3EC", hash_generated_method = "3E5BC549BFB7E5274A233E5C72B8C754")
    protected void finalize() {
        try 
        {
            super.finalize();
        } 
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "PhoneSubInfo finalized");
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.757 -0400", hash_original_method = "7FB2911E415BAC248B6F7C00F0AD8580", hash_generated_method = "DB54664E6C2999350E56D9C069D500B3")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_936645564 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_936645564 = mPhone.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_936645564.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_936645564;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.758 -0400", hash_original_method = "47A65D652880A955D13092E25ED0BFA3", hash_generated_method = "D82721229AC48C114E93CEB55566FB55")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_725530068 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_725530068 = mPhone.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_725530068.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_725530068;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.759 -0400", hash_original_method = "31029AA63C15ED3BEB918EA2DF9C53C8", hash_generated_method = "AA546827D064D70D91BE011BA50A60C1")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_998646230 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_998646230 = mPhone.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_998646230.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_998646230;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.760 -0400", hash_original_method = "F715A558C290BD14ABDE5817D87243CF", hash_generated_method = "DBB01CC40FDEDD21E1D79906C625DD5F")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1304197465 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1304197465 = mPhone.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_1304197465.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1304197465;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.760 -0400", hash_original_method = "128FE2451356AD093E7C4FB6D31CED7B", hash_generated_method = "42A4AAB9AD652A9BBF1D02DFDEB5AAB2")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_17794450 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_17794450 = mPhone.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_17794450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_17794450;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.761 -0400", hash_original_method = "3100EE5C09A183E0C52EA30DD2C38FCE", hash_generated_method = "1CCAF950A77FEB3073BE05A79975DA2E")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2072610502 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_2072610502 = (String) mPhone.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_2072610502.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2072610502;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.762 -0400", hash_original_method = "486D3990E5DF065E80D4F34954E57792", hash_generated_method = "C8D6DBFCFF31094A725BC72599603755")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1185067644 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1185067644 = mPhone.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_1185067644.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1185067644;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.763 -0400", hash_original_method = "D6964CF0DD97089F5666548710C28DF3", hash_generated_method = "E62F604C371208C300094E061F4CF55C")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_953047803 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        varB4EAC82CA7396A68D541C85D26508E83_953047803 = number;
        varB4EAC82CA7396A68D541C85D26508E83_953047803.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_953047803;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.765 -0400", hash_original_method = "E9A6A2984EA72CED9E5DEFCEFCC9AE08", hash_generated_method = "14191FD25AC399CDBC3C45FDB972CA25")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_635049289 = null; 
        mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                "Requires CALL_PRIVILEGED");
        String number = mPhone.getVoiceMailNumber();
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        varB4EAC82CA7396A68D541C85D26508E83_635049289 = number;
        varB4EAC82CA7396A68D541C85D26508E83_635049289.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_635049289;
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.766 -0400", hash_original_method = "D600B0CF58C0E649216D70FCBA15089F", hash_generated_method = "112FB565357A3C7EACA39DAB82CA3BAE")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_284129498 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_284129498 = (String) mPhone.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_284129498.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_284129498;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.767 -0400", hash_original_method = "9F475DD57EA6DFA50165E234C6E8C4F9", hash_generated_method = "F3CD5F49C92CDDFAFDEAC2EB7BD37538")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_2019398242 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_842773775 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2019398242 = isim.getIsimImpi();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_842773775 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1932367315; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1932367315 = varB4EAC82CA7396A68D541C85D26508E83_2019398242;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1932367315 = varB4EAC82CA7396A68D541C85D26508E83_842773775;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1932367315.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1932367315;
        
        
                
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.769 -0400", hash_original_method = "F4E0E1121A78A263259E537EC507AC3C", hash_generated_method = "BCCCC422301EBA75BFB4BD859DF9D42F")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1483713315 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_126925689 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1483713315 = isim.getIsimDomain();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_126925689 = null;
        } 
        String varA7E53CE21691AB073D9660D615818899_1676484434; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1676484434 = varB4EAC82CA7396A68D541C85D26508E83_1483713315;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1676484434 = varB4EAC82CA7396A68D541C85D26508E83_126925689;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1676484434.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1676484434;
        
        
                
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.770 -0400", hash_original_method = "88204E3B8EE4ABDC3556103F74BFEFC3", hash_generated_method = "7BC47FFF7E37C1FA68814E972CBCD1A5")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1722496660 = null; 
        String[] varB4EAC82CA7396A68D541C85D26508E83_1381009537 = null; 
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1722496660 = isim.getIsimImpu();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1381009537 = null;
        } 
        String[] varA7E53CE21691AB073D9660D615818899_228768468; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_228768468 = varB4EAC82CA7396A68D541C85D26508E83_1722496660;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_228768468 = varB4EAC82CA7396A68D541C85D26508E83_1381009537;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_228768468.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_228768468;
        
        
                
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.772 -0400", hash_original_method = "4DB3773BD9844F1658383FB3EDE03C78", hash_generated_method = "6EC73D89F51FD0892ED435339AABA199")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        {
            boolean varA91EEFFC4FA7157AC532A7D7E81F8B19_286634041 = (mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED);
            {
                pw.println("Permission Denial: can't dump PhoneSubInfo from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            } 
        } 
        pw.println("Phone Subscriber Info:");
        pw.println("  Phone Type = " + mPhone.getPhoneName());
        pw.println("  Device ID = " + mPhone.getDeviceId());
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
        addTaint(args[0].getTaint());
        
        
                
            
                    
                    
            
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.772 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "90DFE6F4299DB554E753A7D7707C6EC5")

    static final String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.772 -0400", hash_original_field = "7B2782AEB1700F4BD8926F60FA19885B", hash_generated_field = "2F0E5184AE9B9B916E62562C47277330")

    private static final String READ_PHONE_STATE = android.Manifest.permission.READ_PHONE_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.772 -0400", hash_original_field = "7279C1C260136543616047AA0FE48162", hash_generated_field = "DDA7B88DCDDF3EC7FC81030417BB1DD2")

    private static final String CALL_PRIVILEGED = android.Manifest.permission.CALL_PRIVILEGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.772 -0400", hash_original_field = "6AF45738A029823BDDEEB9EFB306D02E", hash_generated_field = "F55050C8B8B72CB294B7ED0A3E59A0DA")

    private static final String READ_PRIVILEGED_PHONE_STATE = android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE;
}

