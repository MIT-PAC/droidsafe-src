package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.os.ServiceManager;





public class PhoneSubInfoProxy extends IPhoneSubInfo.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.727 -0500", hash_original_field = "A26E2776DC4F810939DFB51028079AFA", hash_generated_field = "977885D72E5C857855A5A55FBD61054C")

    private PhoneSubInfo mPhoneSubInfo;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.728 -0500", hash_original_method = "9BD3264052A5435C1685FA905C11EB3C", hash_generated_method = "7A5C29F4142BCB662B7F5EC0A6C218A3")
    public PhoneSubInfoProxy(PhoneSubInfo phoneSubInfo) {
        mPhoneSubInfo = phoneSubInfo;
        if(ServiceManager.getService("iphonesubinfo") == null) {
            ServiceManager.addService("iphonesubinfo", this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.729 -0500", hash_original_method = "2283D2DC026CDBFF3477BE41D42C9914", hash_generated_method = "078872F995C0139672F0767170BB955C")
    public void setmPhoneSubInfo(PhoneSubInfo phoneSubInfo) {
        this.mPhoneSubInfo = phoneSubInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.730 -0500", hash_original_method = "D25D1513A7A9E94213D872FEEFA3459F", hash_generated_method = "9E9544F9FD152A80C9FD2B5D5A83B4FD")
    public String getDeviceId() {
        return mPhoneSubInfo.getDeviceId();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.731 -0500", hash_original_method = "218139047ECFCF8CA6D1F8CDAA4C694C", hash_generated_method = "39FE412244975EF6A34D35DD87B9925A")
    public String getDeviceSvn() {
        return mPhoneSubInfo.getDeviceSvn();
    }

    /**
     * Retrieves the unique subscriber ID, e.g., IMSI for GSM phones.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.732 -0500", hash_original_method = "64517BFCC96C0835EBBF77921AFD12C4", hash_generated_method = "98F82F0677CCE2D9785A670AF0A46B1C")
    public String getSubscriberId() {
        return mPhoneSubInfo.getSubscriberId();
    }

    /**
     * Retrieves the serial number of the ICC, if applicable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.732 -0500", hash_original_method = "E6772554197C74231E47C8BCCAE0DED3", hash_generated_method = "BD59AEFDE2A170B3BAA5045B73B4E4A9")
    public String getIccSerialNumber() {
        return mPhoneSubInfo.getIccSerialNumber();
    }

    /**
     * Retrieves the phone number string for line 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.733 -0500", hash_original_method = "1E3DF53750004468A3FEA812C75DB18E", hash_generated_method = "9A5D4C407777405590C7BA49A3D466F6")
    public String getLine1Number() {
        return mPhoneSubInfo.getLine1Number();
    }

    /**
     * Retrieves the alpha identifier for line 1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.734 -0500", hash_original_method = "64EA0D6EA297012E928C67F727560D62", hash_generated_method = "B2843102405F548A5618B5C418643FA1")
    public String getLine1AlphaTag() {
        return mPhoneSubInfo.getLine1AlphaTag();
    }

    /**
     * Retrieves the MSISDN Number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.736 -0500", hash_original_method = "ECD66F483FDED6B625291F5D42CCD29E", hash_generated_method = "B0C0A415E10FD62F6DBBCD6C1633E9E4")
    public String getMsisdn() {
        return mPhoneSubInfo.getMsisdn();
    }

    /**
     * Retrieves the voice mail number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.736 -0500", hash_original_method = "161F824EA43402C1D442E10B044BD515", hash_generated_method = "C145B8EC6F145F3B5158168D412B2E9A")
    public String getVoiceMailNumber() {
        return mPhoneSubInfo.getVoiceMailNumber();
    }

    /**
     * Retrieves the complete voice mail number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.737 -0500", hash_original_method = "D36FC67BCBBF5218B0475E1086B8F100", hash_generated_method = "D399A77BB1283656E480CAD9D909CDDA")
    public String getCompleteVoiceMailNumber() {
        return mPhoneSubInfo.getCompleteVoiceMailNumber();
    }

    /**
     * Retrieves the alpha identifier associated with the voice mail number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.738 -0500", hash_original_method = "B4E40022523B90FE3B591C5B01B0F447", hash_generated_method = "8861A24099D39FCDFE838C17B6BFBC06")
    public String getVoiceMailAlphaTag() {
        return mPhoneSubInfo.getVoiceMailAlphaTag();
    }

    /**
     * Returns the IMS private user identity (IMPI) that was loaded from the ISIM.
     * @return the IMPI, or null if not present or not loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.739 -0500", hash_original_method = "1B9C156CDE1FE8BC8AD5790ACDC1839F", hash_generated_method = "B149BA5787B1A6E659DC22D2468BC398")
    public String getIsimImpi() {
        return mPhoneSubInfo.getIsimImpi();
    }

    /**
     * Returns the IMS home network domain name that was loaded from the ISIM.
     * @return the IMS domain name, or null if not present or not loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.739 -0500", hash_original_method = "5E6F99581C2642DC2161D87CA1564892", hash_generated_method = "BCCBCF8A6006EEF9ADD195EDF92CED50")
    public String getIsimDomain() {
        return mPhoneSubInfo.getIsimDomain();
    }

    /**
     * Returns the IMS public user identities (IMPU) that were loaded from the ISIM.
     * @return an array of IMPU strings, with one IMPU per string, or null if
     *      not present or not loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.740 -0500", hash_original_method = "AA8729D4828AF8D72F3D75B4D7287C76", hash_generated_method = "B3F5BC6B87BB025C1221F1E49529F91B")
    public String[] getIsimImpu() {
        return mPhoneSubInfo.getIsimImpu();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:31.741 -0500", hash_original_method = "BD901838E03164DC084863FAEEA45A76", hash_generated_method = "DCA7F7C16BDA8A448EE0D5AEC839F0E9")
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        mPhoneSubInfo.dump(fd, pw, args);
    }

    
}

