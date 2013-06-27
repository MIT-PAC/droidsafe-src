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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.108 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.108 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.109 -0400", hash_original_method = "8625E021A884D0AE1BFAA6115C272865", hash_generated_method = "B9BD004AC9C267676755058C8A68D9F4")
    public  PhoneSubInfo(Phone phone) {
        mPhone = phone;
        mContext = phone.getContext();
        // ---------- Original Method ----------
        //mPhone = phone;
        //mContext = phone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.109 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.110 -0400", hash_original_method = "0C75AFD9B32739C91AE66AE73680B3EC", hash_generated_method = "3E5BC549BFB7E5274A233E5C72B8C754")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.110 -0400", hash_original_method = "7FB2911E415BAC248B6F7C00F0AD8580", hash_generated_method = "F8FFCE3A699BAB89FC221F04233720D2")
    public String getDeviceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1195200841 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1195200841 = mPhone.getDeviceId();
        varB4EAC82CA7396A68D541C85D26508E83_1195200841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1195200841;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.114 -0400", hash_original_method = "47A65D652880A955D13092E25ED0BFA3", hash_generated_method = "E1A28A0AA76042D0FA6FDB78721800A8")
    public String getDeviceSvn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1994726867 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1994726867 = mPhone.getDeviceSvn();
        varB4EAC82CA7396A68D541C85D26508E83_1994726867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994726867;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.118 -0400", hash_original_method = "31029AA63C15ED3BEB918EA2DF9C53C8", hash_generated_method = "76755E0AE73A2972ACEA53789A52E2D1")
    public String getSubscriberId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1734539884 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1734539884 = mPhone.getSubscriberId();
        varB4EAC82CA7396A68D541C85D26508E83_1734539884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734539884;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.118 -0400", hash_original_method = "F715A558C290BD14ABDE5817D87243CF", hash_generated_method = "069361BF399F671E3F5FCBA6847FCEB5")
    public String getIccSerialNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_597960908 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_597960908 = mPhone.getIccSerialNumber();
        varB4EAC82CA7396A68D541C85D26508E83_597960908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_597960908;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.119 -0400", hash_original_method = "128FE2451356AD093E7C4FB6D31CED7B", hash_generated_method = "3382270F981F8F72884E790D51ADA098")
    public String getLine1Number() {
        String varB4EAC82CA7396A68D541C85D26508E83_345113625 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_345113625 = mPhone.getLine1Number();
        varB4EAC82CA7396A68D541C85D26508E83_345113625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345113625;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.132 -0400", hash_original_method = "3100EE5C09A183E0C52EA30DD2C38FCE", hash_generated_method = "8E064053BB1B18228A636977C4E5226A")
    public String getLine1AlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1689780995 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1689780995 = (String) mPhone.getLine1AlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_1689780995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689780995;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return (String) mPhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.133 -0400", hash_original_method = "486D3990E5DF065E80D4F34954E57792", hash_generated_method = "026D424859B03BDDF4C126E687D30227")
    public String getMsisdn() {
        String varB4EAC82CA7396A68D541C85D26508E83_1723661462 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_1723661462 = mPhone.getMsisdn();
        varB4EAC82CA7396A68D541C85D26508E83_1723661462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1723661462;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.133 -0400", hash_original_method = "D6964CF0DD97089F5666548710C28DF3", hash_generated_method = "596C0815C24C61BB3350E7ADF4F83683")
    public String getVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_624246757 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String number;
        number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        varB4EAC82CA7396A68D541C85D26508E83_624246757 = number;
        varB4EAC82CA7396A68D541C85D26508E83_624246757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_624246757;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //String number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        //Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.134 -0400", hash_original_method = "E9A6A2984EA72CED9E5DEFCEFCC9AE08", hash_generated_method = "7A5049435D36E4FC777474F32748B6C3")
    public String getCompleteVoiceMailNumber() {
        String varB4EAC82CA7396A68D541C85D26508E83_343540063 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                "Requires CALL_PRIVILEGED");
        String number;
        number = mPhone.getVoiceMailNumber();
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        varB4EAC82CA7396A68D541C85D26508E83_343540063 = number;
        varB4EAC82CA7396A68D541C85D26508E83_343540063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_343540063;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                //"Requires CALL_PRIVILEGED");
        //String number = mPhone.getVoiceMailNumber();
        //Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.134 -0400", hash_original_method = "D600B0CF58C0E649216D70FCBA15089F", hash_generated_method = "D3B828DFF6E35587FF88167930EDA8AB")
    public String getVoiceMailAlphaTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_391489782 = null; //Variable for return #1
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        varB4EAC82CA7396A68D541C85D26508E83_391489782 = (String) mPhone.getVoiceMailAlphaTag();
        varB4EAC82CA7396A68D541C85D26508E83_391489782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_391489782;
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return (String) mPhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.135 -0400", hash_original_method = "9F475DD57EA6DFA50165E234C6E8C4F9", hash_generated_method = "DCDE862CA91AFAB115B71F788442E874")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_662246910 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_237515918 = null; //Variable for return #2
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_662246910 = isim.getIsimImpi();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_237515918 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_668360991; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_668360991 = varB4EAC82CA7396A68D541C85D26508E83_662246910;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_668360991 = varB4EAC82CA7396A68D541C85D26508E83_237515918;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_668360991.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_668360991;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.135 -0400", hash_original_method = "F4E0E1121A78A263259E537EC507AC3C", hash_generated_method = "1E2BFEFFB4D0BAEBE7B6F884D615A183")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1257248310 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_399033694 = null; //Variable for return #2
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1257248310 = isim.getIsimDomain();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_399033694 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1238300174; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1238300174 = varB4EAC82CA7396A68D541C85D26508E83_1257248310;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1238300174 = varB4EAC82CA7396A68D541C85D26508E83_399033694;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1238300174.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1238300174;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.136 -0400", hash_original_method = "88204E3B8EE4ABDC3556103F74BFEFC3", hash_generated_method = "CFCF1E2EB1B0D6CC38F360F18403D236")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1029377965 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1281049398 = null; //Variable for return #2
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1029377965 = isim.getIsimImpu();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1281049398 = null;
        } //End block
        String[] varA7E53CE21691AB073D9660D615818899_932764827; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_932764827 = varB4EAC82CA7396A68D541C85D26508E83_1029377965;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_932764827 = varB4EAC82CA7396A68D541C85D26508E83_1281049398;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_932764827.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_932764827;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.153 -0400", hash_original_method = "4DB3773BD9844F1658383FB3EDE03C78", hash_generated_method = "4F53BAB54057FEC7300D1D029CBA53C2")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        {
            boolean varA91EEFFC4FA7157AC532A7D7E81F8B19_1319534403 = (mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.154 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "F8B647E30854EAD6B41E2259C3C9C0E5")

    static String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.154 -0400", hash_original_field = "7B2782AEB1700F4BD8926F60FA19885B", hash_generated_field = "EE0EE979C811FED18CC86A2731DE283A")

    private static String READ_PHONE_STATE = android.Manifest.permission.READ_PHONE_STATE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.154 -0400", hash_original_field = "7279C1C260136543616047AA0FE48162", hash_generated_field = "1F22BDD143AA4FC9791A115FB14E2933")

    private static String CALL_PRIVILEGED = android.Manifest.permission.CALL_PRIVILEGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:17.154 -0400", hash_original_field = "6AF45738A029823BDDEEB9EFB306D02E", hash_generated_field = "FEA8848EE0432CB1D6FBDBB78BB3E585")

    private static String READ_PRIVILEGED_PHONE_STATE = android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE;
}

