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
    private Phone mPhone;
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.728 -0400", hash_original_method = "8625E021A884D0AE1BFAA6115C272865", hash_generated_method = "69545BB2A82B1C7EC5ACDFE9906D77F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PhoneSubInfo(Phone phone) {
        dsTaint.addTaint(phone.dsTaint);
        mContext = phone.getContext();
        // ---------- Original Method ----------
        //mPhone = phone;
        //mContext = phone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.729 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.729 -0400", hash_original_method = "0C75AFD9B32739C91AE66AE73680B3EC", hash_generated_method = "3E5BC549BFB7E5274A233E5C72B8C754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.729 -0400", hash_original_method = "7FB2911E415BAC248B6F7C00F0AD8580", hash_generated_method = "E8712422FB63E3A6F65F66658A15301A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceId() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String varF02048136524233E8F08EAF44D5957DD_145090896 = (mPhone.getDeviceId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getDeviceId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.730 -0400", hash_original_method = "47A65D652880A955D13092E25ED0BFA3", hash_generated_method = "30AFA05286C9FF95257384B5D57AA8BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDeviceSvn() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String varF1DFF02667B1112189D238F77B41A5ED_1197065231 = (mPhone.getDeviceSvn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getDeviceSvn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.730 -0400", hash_original_method = "31029AA63C15ED3BEB918EA2DF9C53C8", hash_generated_method = "B4AB90809FBDB3651918BDFAD00F7421")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSubscriberId() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String varDDA85C775969DC01364C7ABED720B53A_295815066 = (mPhone.getSubscriberId());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getSubscriberId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.730 -0400", hash_original_method = "F715A558C290BD14ABDE5817D87243CF", hash_generated_method = "86F775D8A329918A1C727305E53F2A38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIccSerialNumber() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String varE10A80C6DDB28BA8A779A0EEDEC13C17_682065191 = (mPhone.getIccSerialNumber());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getIccSerialNumber();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.730 -0400", hash_original_method = "128FE2451356AD093E7C4FB6D31CED7B", hash_generated_method = "3CF36272CB90B144412E119447D7AC3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1Number() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String varCA8FE9BBCF48786C7B3DBAE4A6ECEDD1_945752088 = (mPhone.getLine1Number());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getLine1Number();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.731 -0400", hash_original_method = "3100EE5C09A183E0C52EA30DD2C38FCE", hash_generated_method = "0DF08069722C87F041104F7EE3A6774A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLine1AlphaTag() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String var2AB35E74D861469CB5C8B6D5531D084B_1078210833 = ((String) mPhone.getLine1AlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return (String) mPhone.getLine1AlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.731 -0400", hash_original_method = "486D3990E5DF065E80D4F34954E57792", hash_generated_method = "5F910F62D91A5C14011E7899F2C1C7FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMsisdn() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String var3B78DEB3D3ED1FC9D38E5F64D7FFAC71_1189788975 = (mPhone.getMsisdn());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return mPhone.getMsisdn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.731 -0400", hash_original_method = "D6964CF0DD97089F5666548710C28DF3", hash_generated_method = "2B85CA0D074B57685EAAC4752EBA6514")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String number;
        number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //String number = PhoneNumberUtils.extractNetworkPortion(mPhone.getVoiceMailNumber());
        //Log.d(LOG_TAG, "VM: PhoneSubInfo.getVoiceMailNUmber: ");
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.731 -0400", hash_original_method = "E9A6A2984EA72CED9E5DEFCEFCC9AE08", hash_generated_method = "152B1A89489BA67402C790591A647DE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCompleteVoiceMailNumber() {
        mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                "Requires CALL_PRIVILEGED");
        String number;
        number = mPhone.getVoiceMailNumber();
        Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(CALL_PRIVILEGED,
                //"Requires CALL_PRIVILEGED");
        //String number = mPhone.getVoiceMailNumber();
        //Log.d(LOG_TAG, "VM: PhoneSubInfo.getCompleteVoiceMailNUmber: ");
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.732 -0400", hash_original_method = "D600B0CF58C0E649216D70FCBA15089F", hash_generated_method = "432D1F87E5A78D0755D5B6F4123F5FB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getVoiceMailAlphaTag() {
        mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        String var904B5AD3BFB1537797F345CF4BF0D6D5_950044254 = ((String) mPhone.getVoiceMailAlphaTag());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(READ_PHONE_STATE, "Requires READ_PHONE_STATE");
        //return (String) mPhone.getVoiceMailAlphaTag();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.732 -0400", hash_original_method = "9F475DD57EA6DFA50165E234C6E8C4F9", hash_generated_method = "13B836EE2C4E0374B5455B1AED76E2CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsimImpi() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            String var1388F9C7E6DC63E0BFE64B9DBDD1D25D_1870869901 = (isim.getIsimImpi());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.732 -0400", hash_original_method = "F4E0E1121A78A263259E537EC507AC3C", hash_generated_method = "DDE646E5B44A3242485FFC92F993ED9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIsimDomain() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            String varDFE82EDE52D643DDB2228BBB72CB7B70_947950769 = (isim.getIsimDomain());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.732 -0400", hash_original_method = "88204E3B8EE4ABDC3556103F74BFEFC3", hash_generated_method = "11BAC5851129245B066CF65B05392904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getIsimImpu() {
        mContext.enforceCallingOrSelfPermission(READ_PRIVILEGED_PHONE_STATE,
                "Requires READ_PRIVILEGED_PHONE_STATE");
        IsimRecords isim;
        isim = mPhone.getIsimRecords();
        {
            String[] varAC1FAB815DF9159985E0354B09763198_1340307716 = (isim.getIsimImpu());
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.733 -0400", hash_original_method = "4DB3773BD9844F1658383FB3EDE03C78", hash_generated_method = "EC4EACC6A5ECB8A5A6BE20E8DB9204BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        {
            boolean varA91EEFFC4FA7157AC532A7D7E81F8B19_1917557292 = (mContext.checkCallingOrSelfPermission(android.Manifest.permission.DUMP)
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

    
    static final String LOG_TAG = "PHONE";
    private static final String READ_PHONE_STATE =
        android.Manifest.permission.READ_PHONE_STATE;
    private static final String CALL_PRIVILEGED =
        android.Manifest.permission.CALL_PRIVILEGED;
    private static final String READ_PRIVILEGED_PHONE_STATE =
        android.Manifest.permission.READ_PRIVILEGED_PHONE_STATE;
}

