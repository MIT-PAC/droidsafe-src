package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.android.internal.telephony.ims.IsimRecords;

public class PhoneSubInfo extends IPhoneSubInfo.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "8625E021A884D0AE1BFAA6115C272865", hash_generated_method = "B9BD004AC9C267676755058C8A68D9F4")
    public  PhoneSubInfo(Phone phone) {
        mPhone = phone;
        mContext = phone.getContext();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "0C75AFD9B32739C91AE66AE73680B3EC", hash_generated_method = "8F16DA9EA1966CE6CA2B1ABF9D723833")
    protected void finalize() {
        try 
        {
            super.finalize();
        } 
        catch (Throwable throwable)
        {
        } 
        Log.d(LOG_TAG, "PhoneSubInfo finalized");
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "7FB2911E415BAC248B6F7C00F0AD8580", hash_generated_method = "79AB8F9C0512A49488DD13A8045E6813")
    public String getDeviceId() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String varFA71673B90CF0A8C48C17D503AAD8DD9_1407743651 =         mPhone.getDeviceId();
        varFA71673B90CF0A8C48C17D503AAD8DD9_1407743651.addTaint(taint);
        return varFA71673B90CF0A8C48C17D503AAD8DD9_1407743651;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "47A65D652880A955D13092E25ED0BFA3", hash_generated_method = "849D029FC118795E507240E62334B95C")
    public String getDeviceSvn() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String var435A9281E17FA260B168A9BA3B7DC04A_1337747816 =         mPhone.getDeviceSvn();
        var435A9281E17FA260B168A9BA3B7DC04A_1337747816.addTaint(taint);
        return var435A9281E17FA260B168A9BA3B7DC04A_1337747816;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "31029AA63C15ED3BEB918EA2DF9C53C8", hash_generated_method = "0ABD3046C648ABA7F32FFBA4928FCCFC")
    public String getSubscriberId() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String var72C25F22D2FBA989AA76F4EC603E0F84_164195638 =         mPhone.getSubscriberId();
        var72C25F22D2FBA989AA76F4EC603E0F84_164195638.addTaint(taint);
        return var72C25F22D2FBA989AA76F4EC603E0F84_164195638;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.349 -0400", hash_original_method = "F715A558C290BD14ABDE5817D87243CF", hash_generated_method = "13640DDE8E60BE21BA3116EDC87A33D2")
    public String getIccSerialNumber() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String var882C1614C4BAC433AE1941907CD6ABCB_241254078 =         mPhone.getIccSerialNumber();
        var882C1614C4BAC433AE1941907CD6ABCB_241254078.addTaint(taint);
        return var882C1614C4BAC433AE1941907CD6ABCB_241254078;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "128FE2451356AD093E7C4FB6D31CED7B", hash_generated_method = "A51D33485F4967BE5AF23E19847EF2A1")
    public String getLine1Number() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String varF99B99AB0238EB21CB7B88C63CBC8EB5_1999545267 =         mPhone.getLine1Number();
        varF99B99AB0238EB21CB7B88C63CBC8EB5_1999545267.addTaint(taint);
        return varF99B99AB0238EB21CB7B88C63CBC8EB5_1999545267;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "3100EE5C09A183E0C52EA30DD2C38FCE", hash_generated_method = "9545F5ACF5B09034722EF8832AFB5E0A")
    public String getLine1AlphaTag() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String var915B399E36AD2DC723DDBF2E1EC534D5_1754237388 =         (String) mPhone.getLine1AlphaTag();
        var915B399E36AD2DC723DDBF2E1EC534D5_1754237388.addTaint(taint);
        return var915B399E36AD2DC723DDBF2E1EC534D5_1754237388;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "486D3990E5DF065E80D4F34954E57792", hash_generated_method = "373E2A3A25AA709DBD04DBE5D9882145")
    public String getMsisdn() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String varD1D6F5168E76CE1592036B4FE9F8DF9C_1317787277 =         mPhone.getMsisdn();
        varD1D6F5168E76CE1592036B4FE9F8DF9C_1317787277.addTaint(taint);
        return varD1D6F5168E76CE1592036B4FE9F8DF9C_1317787277;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "D6964CF0DD97089F5666548710C28DF3", hash_generated_method = "04B6BA8E9524B72FBD3BB0ABC9F81176")
    public String getVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
String var63E80DF571E08DAA47BEFBF0BD0EEBAD_318555510 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_318555510.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_318555510;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "E9A6A2984EA72CED9E5DEFCEFCC9AE08", hash_generated_method = "5818998FCBD71E6512E7CE7F3B1D64EF")
    public String getCompleteVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                "Requires CALL_PRIVILEGED");
        String number = mPhone.getVoiceMailNumber();
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
String var63E80DF571E08DAA47BEFBF0BD0EEBAD_1669743266 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_1669743266.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1669743266;
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "D600B0CF58C0E649216D70FCBA15089F", hash_generated_method = "023FC8387DF6FF0D844A3DF7FA3BD42E")
    public String getVoiceMailAlphaTag() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
String var62E5FB36C0AD7152B2051159B22D2B9A_1718507155 =         (String) mPhone.getVoiceMailAlphaTag();
        var62E5FB36C0AD7152B2051159B22D2B9A_1718507155.addTaint(taint);
        return var62E5FB36C0AD7152B2051159B22D2B9A_1718507155;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.350 -0400", hash_original_method = "9F475DD57EA6DFA50165E234C6E8C4F9", hash_generated_method = "45132F2B5B8BD33F8616CE337D3A2689")
    public String getIsimImpi() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
    if(isim != null)        
        {
String varE77C8481BB3712B45420EDC3130B1A13_1066936725 =             isim.getIsimImpi();
            varE77C8481BB3712B45420EDC3130B1A13_1066936725.addTaint(taint);
            return varE77C8481BB3712B45420EDC3130B1A13_1066936725;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_1260551262 =             null;
            var540C13E9E156B687226421B24F2DF178_1260551262.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1260551262;
        } 
        
        
                
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_method = "F4E0E1121A78A263259E537EC507AC3C", hash_generated_method = "D675EE6CA17A540C825D7477DCE73843")
    public String getIsimDomain() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
    if(isim != null)        
        {
String var49A36196CE44942401AFC488FA3CAA1A_512173005 =             isim.getIsimDomain();
            var49A36196CE44942401AFC488FA3CAA1A_512173005.addTaint(taint);
            return var49A36196CE44942401AFC488FA3CAA1A_512173005;
        } 
        else
        {
String var540C13E9E156B687226421B24F2DF178_1776478155 =             null;
            var540C13E9E156B687226421B24F2DF178_1776478155.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1776478155;
        } 
        
        
                
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_method = "88204E3B8EE4ABDC3556103F74BFEFC3", hash_generated_method = "A666DE7C2732B8F701B77FC4CA4EAB64")
    public String[] getIsimImpu() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
    if(isim != null)        
        {
String[] var85323B51C5BCEDC923817A0AE9C20F2D_79975643 =             isim.getIsimImpu();
            var85323B51C5BCEDC923817A0AE9C20F2D_79975643.addTaint(taint);
            return var85323B51C5BCEDC923817A0AE9C20F2D_79975643;
        } 
        else
        {
String[] var540C13E9E156B687226421B24F2DF178_929115939 =             null;
            var540C13E9E156B687226421B24F2DF178_929115939.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_929115939;
        } 
        
        
                
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_method = "4DB3773BD9844F1658383FB3EDE03C78", hash_generated_method = "F51842C2FF88B51CFBBEFF35BCF8F5C2")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(pw.getTaint());
        addTaint(fd.getTaint());
    if(mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED)        
        {
            pw.println("Permission Denial: can't dump PhoneSubInfo from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            return;
        } 
        pw.println("Phone Subscriber Info:");
        pw.println("  Phone Type = " + mPhone.getPhoneName());
        pw.println("  Device ID = " + mPhone.getDeviceId());
        
        
                
            
                    
                    
            
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "90DFE6F4299DB554E753A7D7707C6EC5")

    static final String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_field = "7B2782AEB1700F4BD8926F60FA19885B", hash_generated_field = "2F0E5184AE9B9B916E62562C47277330")

    private static final String READ_PHONE_STATE = android.Manifest.permission.READ_PHONE_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_field = "7279C1C260136543616047AA0FE48162", hash_generated_field = "DDA7B88DCDDF3EC7FC81030417BB1DD2")

    private static final String CALL_PRIVILEGED = android.Manifest.permission.CALL_PRIVILEGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:22.351 -0400", hash_original_field = "6AF45738A029823BDDEEB9EFB306D02E", hash_generated_field = "F55050C8B8B72CB294B7ED0A3E59A0DA")

    private static final String READ_PRIVILEGED_PHONE_STATE = android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE;
}

