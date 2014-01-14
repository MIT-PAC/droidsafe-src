package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.telephony.PhoneNumberUtils;
import android.util.Log;

import com.android.internal.telephony.ims.IsimRecords;

public class PhoneSubInfo extends IPhoneSubInfo.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.172 -0500", hash_original_field = "F4446E751DD7D5E85FE650192A5E7AE4", hash_generated_field = "90DFE6F4299DB554E753A7D7707C6EC5")

    static final String LOG_TAG = "PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.179 -0500", hash_original_field = "0ADB37981749F0F2252B432F6575A21F", hash_generated_field = "2F0E5184AE9B9B916E62562C47277330")

    private static final String READ_PHONE_STATE =
        android.Manifest.permission.READ_PHONE_STATE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.182 -0500", hash_original_field = "772994BB4103DC3A3938EC6B41D8D30B", hash_generated_field = "DDA7B88DCDDF3EC7FC81030417BB1DD2")

    private static final String CALL_PRIVILEGED =
        android.Manifest.permission.CALL_PRIVILEGED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.184 -0500", hash_original_field = "34EE13F2771361ED1091977BA975EAB6", hash_generated_field = "F55050C8B8B72CB294B7ED0A3E59A0DA")

    private static final String READ_PRIVILEGED_PHONE_STATE =
        android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.174 -0500", hash_original_field = "3E4A9DF67E5660E9A95DECEFCF15D77A", hash_generated_field = "59DB8B09027983825DB66C99CC153469")

    private Phone mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.176 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.188 -0500", hash_original_method = "8625E021A884D0AE1BFAA6115C272865", hash_generated_method = "D14BC1514453083EB742D91C5FDC7505")
    
public PhoneSubInfo(Phone phone) {
        mPhone = phone;
        mContext = phone.getContext();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.190 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.192 -0500", hash_original_method = "0C75AFD9B32739C91AE66AE73680B3EC", hash_generated_method = "7CD2958A8F39159156440AD90062BDCA")
    
protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            Log.e(LOG_TAG, "Error while finalizing:", throwable);
        }
        Log.d(LOG_TAG, "PhoneSubInfo finalized");
    }

    /**
     * Retrieves the unique device ID, e.g., IMEI for GSM phones and MEID for CDMA phones.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.194 -0500", hash_original_method = "7FB2911E415BAC248B6F7C00F0AD8580", hash_generated_method = "3944B4EB833697DD333BEE15BB48B5BD")
    
public String getDeviceId() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return mPhone.getDeviceId();
    }

    /**
     * Retrieves the software version number for the device, e.g., IMEI/SV
     * for GSM phones.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.196 -0500", hash_original_method = "47A65D652880A955D13092E25ED0BFA3", hash_generated_method = "2D00E8ADDFBF6F25EE30419E8DA5D635")
    
public String getDeviceSvn() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return mPhone.getDeviceSvn();
    }

    /**
     * Retrieves the unique subscriber ID, e.g., IMSI for GSM phones.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.199 -0500", hash_original_method = "31029AA63C15ED3BEB918EA2DF9C53C8", hash_generated_method = "C46560B09E4462F3633D28178B011C9B")
    
public String getSubscriberId() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return mPhone.getSubscriberId();
    }

    /**
     * Retrieves the serial number of the ICC, if applicable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.202 -0500", hash_original_method = "F715A558C290BD14ABDE5817D87243CF", hash_generated_method = "A217EFAEA665691640D486F5F1F5BC3F")
    
public String getIccSerialNumber() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return mPhone.getIccSerialNumber();
    }

    /**
     * Retrieves the phone number string for line 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.204 -0500", hash_original_method = "128FE2451356AD093E7C4FB6D31CED7B", hash_generated_method = "A8A0124513046143F29674ACF0366E8E")
    
public String getLine1Number() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return mPhone.getLine1Number();
    }

    /**
     * Retrieves the alpha identifier for line 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.206 -0500", hash_original_method = "3100EE5C09A183E0C52EA30DD2C38FCE", hash_generated_method = "6EB2846CA87D90839D777E52A4D00589")
    
public String getLine1AlphaTag() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return (String) mPhone.getLine1AlphaTag();
    }

    /**
     * Retrieves the MSISDN string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.209 -0500", hash_original_method = "486D3990E5DF065E80D4F34954E57792", hash_generated_method = "7BFCC5AF5CC06F7C14C9C24B088F9A18")
    
public String getMsisdn() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return mPhone.getMsisdn();
    }

    /**
     * Retrieves the voice mail number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.211 -0500", hash_original_method = "D6964CF0DD97089F5666548710C28DF3", hash_generated_method = "338688FE1AD8A648CE8D6D66CE97A979")
    
public String getVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: "); // + number);
        return number;
    }

    /**
     * Retrieves the complete voice mail number.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.213 -0500", hash_original_method = "E9A6A2984EA72CED9E5DEFCEFCC9AE08", hash_generated_method = "57CD8C581264035B9D6DF0494E40E518")
    
public String getCompleteVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                "Requires CALL_PRIVILEGED");
        String number = mPhone.getVoiceMailNumber();
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: "); // + number);
        return number;
    }

    /**
     * Retrieves the alpha identifier associated with the voice mail number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.216 -0500", hash_original_method = "D600B0CF58C0E649216D70FCBA15089F", hash_generated_method = "331CF1735E15EA1180693FBB3E5A5A35")
    
public String getVoiceMailAlphaTag() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        return (String) mPhone.getVoiceMailAlphaTag();
    }

    /**
     * Returns the IMS private user identity (IMPI) that was loaded from the ISIM.
     * @return the IMPI, or null if not present or not loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.219 -0500", hash_original_method = "9F475DD57EA6DFA50165E234C6E8C4F9", hash_generated_method = "C0737A2CAF643EBEBB8E93980B460BCB")
    
public String getIsimImpi() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
        if (isim != null) {
            return isim.getIsimImpi();
        } else {
            return null;
        }
    }

    /**
     * Returns the IMS home network domain name that was loaded from the ISIM.
     * @return the IMS domain name, or null if not present or not loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.221 -0500", hash_original_method = "F4E0E1121A78A263259E537EC507AC3C", hash_generated_method = "63DDD82099367C54020331F89E79EFCF")
    
public String getIsimDomain() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
        if (isim != null) {
            return isim.getIsimDomain();
        } else {
            return null;
        }
    }

    /**
     * Returns the IMS public user identities (IMPU) that were loaded from the ISIM.
     * @return an array of IMPU strings, with one IMPU per string, or null if
     *      not present or not loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.224 -0500", hash_original_method = "88204E3B8EE4ABDC3556103F74BFEFC3", hash_generated_method = "CB015DE12E85963C3B229512B06B4983")
    
public String[] getIsimImpu() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim = mPhone.getIsimRecords();
        if (isim != null) {
            return isim.getIsimImpu();
        } else {
            return null;
        }
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:12.226 -0500", hash_original_method = "4DB3773BD9844F1658383FB3EDE03C78", hash_generated_method = "610A8ADDF63FC5624B4D86E2D36101A5")
    
protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
                != PackageManager.PERMISSION_GRANTED) {
            pw.println("Permission Denial: can't dump PhoneSubInfo from from pid="
                    + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid());
            return;
        }

        pw.println("Phone Subscriber Info:");
        pw.println("  Phone Type = " + mPhone.getPhoneName());
        pw.println("  Device ID = " + mPhone.getDeviceId());
    }
}

