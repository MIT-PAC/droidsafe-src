package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.645 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.645 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.646 -0400", hash_original_method = "8625E021A884D0AE1BFAA6115C272865", hash_generated_method = "B9BD004AC9C267676755058C8A68D9F4")
    public  PhoneSubInfo(Phone phone) {
        mPhone = phone;
        mContext = phone.getContext();
        // ---------- Original Method ----------
        //mPhone = phone;
        //mContext = phone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.646 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.647 -0400", hash_original_method = "0C75AFD9B32739C91AE66AE73680B3EC", hash_generated_method = "3E5BC549BFB7E5274A233E5C72B8C754")
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "PhoneSubInfo finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //Log.d(LOG_TAG, "PhoneSubInfo finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.647 -0400", hash_original_method = "7FB2911E415BAC248B6F7C00F0AD8580", hash_generated_method = "225B40DCDE4DA03BAFF189F935DEA7C0")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_934100448 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_934100448 = mPhone.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_934100448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_934100448;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.647 -0400", hash_original_method = "47A65D652880A955D13092E25ED0BFA3", hash_generated_method = "31A2DD72F2F0B66569C2189D5659825C")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1890393587 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1890393587 = mPhone.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1890393587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890393587;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.648 -0400", hash_original_method = "31029AA63C15ED3BEB918EA2DF9C53C8", hash_generated_method = "C67449B65F49814E040F2D822A7258CA")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_497996533 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_497996533 = mPhone.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_497996533.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_497996533;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.648 -0400", hash_original_method = "F715A558C290BD14ABDE5817D87243CF", hash_generated_method = "D4BDD942DAB63AC4DA3360CA69CF8010")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_833603495 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_833603495 = mPhone.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_833603495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_833603495;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.658 -0400", hash_original_method = "128FE2451356AD093E7C4FB6D31CED7B", hash_generated_method = "F0B38177D0E8DB7DD25349D775935365")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_94134266 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_94134266 = mPhone.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_94134266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_94134266;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.658 -0400", hash_original_method = "3100EE5C09A183E0C52EA30DD2C38FCE", hash_generated_method = "8473F8674FF509CC3A6E8B4C762558E3")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2114841635 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_2114841635 = (String) mPhone.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_2114841635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2114841635;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return (String) mPhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.659 -0400", hash_original_method = "486D3990E5DF065E80D4F34954E57792", hash_generated_method = "67952A68C5E38BBDF49456FAF2958E1B")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_260046972 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_260046972 = mPhone.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_260046972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_260046972;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.659 -0400", hash_original_method = "D6964CF0DD97089F5666548710C28DF3", hash_generated_method = "D13BB018E2B37A849C1D5486FF8C0542")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_2104873192 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String number;
        number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        varB4EAC82CA7396A68D541C85D26508E83_2104873192 = number;
        varB4EAC82CA7396A68D541C85D26508E83_2104873192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2104873192;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //String number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        //Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.660 -0400", hash_original_method = "E9A6A2984EA72CED9E5DEFCEFCC9AE08", hash_generated_method = "3B3491173BBB0B892B7A2D242A8DC112")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_1663329512 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                "Requires CALL_PRIVILEGED");
        String number;
        number = mPhone.getVoiceMailNumber();
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        varB4EAC82CA7396A68D541C85D26508E83_1663329512 = number;
        varB4EAC82CA7396A68D541C85D26508E83_1663329512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663329512;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                //"Requires CALL_PRIVILEGED");
        //String number = mPhone.getVoiceMailNumber();
        //Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.660 -0400", hash_original_method = "D600B0CF58C0E649216D70FCBA15089F", hash_generated_method = "1044D1BFBE1D5DA87349A1DD140D7531")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1441652302 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1441652302 = (String) mPhone.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1441652302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441652302;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return (String) mPhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.670 -0400", hash_original_method = "9F475DD57EA6DFA50165E234C6E8C4F9", hash_generated_method = "69A5972A8038B64459713CAA73B0A0AB")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_1903211252 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_780166524 = null; //Variable for return #2
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1903211252 = isim.getIsimImpi();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_780166524 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1023211709; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1023211709 = varB4EAC82CA7396A68D541C85D26508E83_1903211252;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1023211709 = varB4EAC82CA7396A68D541C85D26508E83_780166524;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1023211709.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1023211709;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                //"Requires READ_PRIVILEGED_PHONE_STATE");
        //IsimRecords isim = mPhone.getIsimRecords();
        //if (isim != null) {
            //return isim.getIsimImpi();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.671 -0400", hash_original_method = "F4E0E1121A78A263259E537EC507AC3C", hash_generated_method = "749CB884E14BBAD998354CB8A8A6ED00")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_654936883 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1043816348 = null; //Variable for return #2
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_654936883 = isim.getIsimDomain();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1043816348 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_996479743; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_996479743 = varB4EAC82CA7396A68D541C85D26508E83_654936883;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_996479743 = varB4EAC82CA7396A68D541C85D26508E83_1043816348;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_996479743.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_996479743;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                //"Requires READ_PRIVILEGED_PHONE_STATE");
        //IsimRecords isim = mPhone.getIsimRecords();
        //if (isim != null) {
            //return isim.getIsimDomain();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.674 -0400", hash_original_method = "88204E3B8EE4ABDC3556103F74BFEFC3", hash_generated_method = "4EC3634F7497B7BE247C6E72CDCC2145")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1586264569 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_780918823 = null; //Variable for return #2
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1586264569 = isim.getIsimImpu();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_780918823 = null;
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_757020240; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_757020240 = varB4EAC82CA7396A68D541C85D26508E83_1586264569;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_757020240 = varB4EAC82CA7396A68D541C85D26508E83_780918823;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_757020240.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_757020240;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                //"Requires READ_PRIVILEGED_PHONE_STATE");
        //IsimRecords isim = mPhone.getIsimRecords();
        //if (isim != null) {
            //return isim.getIsimImpu();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.687 -0400", hash_original_method = "4DB3773BD9844F1658383FB3EDE03C78", hash_generated_method = "D8C80D12C9B40F4ADFFF39428C268464")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        {
            boolean varA91EEFFC4FA7157AC532A7D7E81F8B19_1049143654 = (mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED);
            {
                pw.println("Permission Denial: can't dump PhoneSubInfo from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            } //End block
        } //End collapsed parenthetic
        pw.println("Phone Subscriber Info:");
        pw.println("  Phone Type = " + mPhone.getPhoneName());
        pw.println("  Device ID = " + mPhone.getDeviceId());
        addTaint(fd.getTaint());
        addTaint(pw.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //if (mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                //!= PackageManager.PERMISSION_GRANTED) {
            //pw.println("Permission Denial: can't dump PhoneSubInfo from from pid="
                    //+ Binder.getCallingPid()
                    //+ ", uid=" + Binder.getCallingUid());
            //return;
        //}
        //pw.println("Phone Subscriber Info:");
        //pw.println("  Phone Type = " + mPhone.getPhoneName());
        //pw.println("  Device ID = " + mPhone.getDeviceId());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.687 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "F8B647E30854EAD6B41E2259C3C9C0E5")

    static String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.687 -0400", hash_original_field = "7B2782AEB1700F4BD8926F60FA19885B", hash_generated_field = "EE0EE979C811FED18CC86A2731DE283A")

    private static String READ_PHONE_STATE = android.Manifest.permission.READ_PHONE_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.687 -0400", hash_original_field = "7279C1C260136543616047AA0FE48162", hash_generated_field = "1F22BDD143AA4FC9791A115FB14E2933")

    private static String CALL_PRIVILEGED = android.Manifest.permission.CALL_PRIVILEGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.687 -0400", hash_original_field = "6AF45738A029823BDDEEB9EFB306D02E", hash_generated_field = "FEA8848EE0432CB1D6FBDBB78BB3E585")

    private static String READ_PRIVILEGED_PHONE_STATE = android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE;
}

