package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.PackageManager;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IccPhoneBookInterfaceManager extends IIccPhoneBook.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_field = "2997832A50D1A4B04AAED3D387CB11EB", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "DAB8F4E90F4E3EAE5A2A9019275DAB3F")

    protected Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_field = "7E55978E096520E8CDAECF1333070CED", hash_generated_field = "E5B26C030F2ABDD85D0CB8A10D64DB7B")

    protected int recordSize[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_field = "260CA9DD8A4577FC00B7BD5810298076", hash_generated_field = "113121599E8140F8C4C329198A2D7722")

    protected boolean success;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.701 -0400", hash_original_field = "6E52C40BB8FC91FF39EE5C79B4211F67", hash_generated_field = "71F18D31BD5AF48450CA4612AD1865B0")

    protected List<AdnRecord> records;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.706 -0400", hash_original_field = "F240289ECF5C81105F1EF992E6E2ADFE", hash_generated_field = "906683FF84FB26C3E4AB1AE839E9BA02")

    protected Handler mBaseHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.706 -0400", hash_original_method = "F8C0BA183015902A4341C34058945BDE", hash_generated_method = "941FD1090CAF73E06F07DEB3BDEE7189")
        @Override
        public void handleMessage(Message msg) {
            AsyncResult ar;
            //Begin case EVENT_GET_SIZE_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_GET_SIZE_DONE 
            //Begin case EVENT_GET_SIZE_DONE 
            {
                {
                    recordSize = (int[])ar.result;
                    logd("GET_RECORD_SIZE Size " + recordSize[0] +
                                    " total " + recordSize[1] +
                                    " #record " + recordSize[2]);
                } //End block
                notifyPending(ar);
            } //End block
            //End case EVENT_GET_SIZE_DONE 
            //Begin case EVENT_UPDATE_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_UPDATE_DONE 
            {
                success = (ar.exception == null);
                notifyPending(ar);
            } //End block
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_LOAD_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_LOAD_DONE 
            //Begin case EVENT_LOAD_DONE 
            {
                {
                    records = (List<AdnRecord>) ar.result;
                } //End block
                {
                    logd("Cannot load ADN records");
                    {
                        records.clear();
                    } //End block
                } //End block
                notifyPending(ar);
            } //End block
            //End case EVENT_LOAD_DONE 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.706 -0400", hash_original_method = "AEA2E9D2067E99FB1331FC981CC14937", hash_generated_method = "30964B2E056A124E578AD19D36FF206D")
        private void notifyPending(AsyncResult ar) {
            AtomicBoolean status;
            status = (AtomicBoolean) ar.userObj;
            status.set(true);
            mLock.notifyAll();
            addTaint(ar.getTaint());
            // ---------- Original Method ----------
            //if (ar.userObj == null) {
                //return;
            //}
            //AtomicBoolean status = (AtomicBoolean) ar.userObj;
            //status.set(true);
            //mLock.notifyAll();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.707 -0400", hash_original_method = "A61AB5A9E61C78C524F0A299EDDA8B31", hash_generated_method = "F8239CE1F53CC35117D554BE23C34DE0")
    public  IccPhoneBookInterfaceManager(PhoneBase phone) {
        this.phone = phone;
        // ---------- Original Method ----------
        //this.phone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.707 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.707 -0400", hash_original_method = "96914FA697D4DDB9AE25582FAB4A6818", hash_generated_method = "1E7A9ED6D1CCD6DE353231DD77EAE9D8")
    protected void publish() {
        ServiceManager.addService("simphonebook", this);
        // ---------- Original Method ----------
        //ServiceManager.addService("simphonebook", this);
    }

    
    protected abstract void logd(String msg);

    
    protected abstract void loge(String msg);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.719 -0400", hash_original_method = "6BE84EAB1F25CDC10E8188E3A1C3A959", hash_generated_method = "EF54F7A19002CAE0ED356094B892489F")
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber, String pin2) {
        {
            boolean var9B9745B744DE229D86237C6E47057CAE_211408715 = (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
            != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
            } //End block
        } //End collapsed parenthetic
        logd("updateAdnRecordsInEfBySearch: efid=" + efid +
                " ("+ oldTag + "," + oldPhoneNumber + ")"+ "==>" +
                " ("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        efid = updateEfForIccType(efid);
        {
            checkThread();
            success = false;
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord oldAdn;
            oldAdn = new AdnRecord(oldTag, oldPhoneNumber);
            AdnRecord newAdn;
            newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnBySearch(efid, oldAdn, newAdn, pin2, response);
            waitForResult(status);
        } //End block
        addTaint(efid);
        addTaint(oldTag.getTaint());
        addTaint(oldPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(pin2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777122734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777122734;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.721 -0400", hash_original_method = "102FC1C0583C00426ED85686CB9EA64E", hash_generated_method = "9A72F59C731152980BEB5A7A1742EA9A")
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) {
        {
            boolean var7C20BC9080702E0128DD71ABE9A4ADDC_367197281 = (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
            } //End block
        } //End collapsed parenthetic
        logd("updateAdnRecordsInEfByIndex: efid=" + efid +
                " Index=" + index + " ==> " +
                "("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        {
            checkThread();
            success = false;
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord newAdn;
            newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnByIndex(efid, newAdn, index, pin2, response);
            waitForResult(status);
        } //End block
        addTaint(efid);
        addTaint(newTag.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(index);
        addTaint(pin2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305442021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305442021;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract int[] getAdnRecordsSize(int efid);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.722 -0400", hash_original_method = "2EC5B47F5C71460FB1C246E071649E17", hash_generated_method = "A9BA012538661878825F531EB7C0DB55")
    public List<AdnRecord> getAdnRecordsInEf(int efid) {
        List<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1568904422 = null; //Variable for return #1
        {
            boolean var539E4FD5A70571EEC200A34F44B8BBBA_1553843675 = (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    "Requires android.permission.READ_CONTACTS permission");
            } //End block
        } //End collapsed parenthetic
        efid = updateEfForIccType(efid);
        logd("getAdnRecordsInEF: efid=" + efid);
        {
            checkThread();
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_LOAD_DONE, status);
            adnCache.requestLoadAllAdnLike(efid, adnCache.extensionEfForEf(efid), response);
            waitForResult(status);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1568904422 = records;
        addTaint(efid);
        varB4EAC82CA7396A68D541C85D26508E83_1568904422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568904422;
        // ---------- Original Method ----------
        //if (phone.getContext().checkCallingOrSelfPermission(
                //android.Manifest.permission.READ_CONTACTS)
                //!= PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException(
                    //"Requires android.permission.READ_CONTACTS permission");
        //}
        //efid = updateEfForIccType(efid);
        //if (DBG) logd("getAdnRecordsInEF: efid=" + efid);
        //synchronized(mLock) {
            //checkThread();
            //AtomicBoolean status = new AtomicBoolean(false);
            //Message response = mBaseHandler.obtainMessage(EVENT_LOAD_DONE, status);
            //adnCache.requestLoadAllAdnLike(efid, adnCache.extensionEfForEf(efid), response);
            //waitForResult(status);
        //}
        //return records;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.722 -0400", hash_original_method = "323B98E2749A47EA83AB3530A004F85D", hash_generated_method = "A213C671FE66DA935D2227A8A977150F")
    protected void checkThread() {
        {
            {
                boolean var939C0019ED0A3EFF0AFB1602184EBB94_561186687 = (mBaseHandler.getLooper().equals(Looper.myLooper()));
                {
                    loge("query() called on the main UI thread!");
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "You cannot call query on this provder from the main UI thread.");
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (!ALLOW_SIM_OP_IN_UI_THREAD) {
            //if (mBaseHandler.getLooper().equals(Looper.myLooper())) {
                //loge("query() called on the main UI thread!");
                //throw new IllegalStateException(
                        //"You cannot call query on this provder from the main UI thread.");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.734 -0400", hash_original_method = "FD540EF7FFA0769933308F8586A1F0A4", hash_generated_method = "1E4789AD685226D821A0152E9765048F")
    protected void waitForResult(AtomicBoolean status) {
        {
            boolean var54E916846D120E4C0E15EB524D5AB066_593761367 = (!status.get());
            {
                try 
                {
                    mLock.wait();
                } //End block
                catch (InterruptedException e)
                {
                    logd("interrupted while trying to update by search");
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(status.getTaint());
        // ---------- Original Method ----------
        //while (!status.get()) {
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //logd("interrupted while trying to update by search");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.735 -0400", hash_original_method = "6710BA71BBE2AF73325E69DE756B39B5", hash_generated_method = "4A78C7615A2380B42B1CB9909BB964E5")
    private int updateEfForIccType(int efid) {
        {
            {
                boolean var13648D229DF6DF3D9FC1C8923B7156DF_982807522 = (phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM));
            } //End collapsed parenthetic
        } //End block
        addTaint(efid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124987195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124987195;
        // ---------- Original Method ----------
        //if (efid == IccConstants.EF_ADN) {
            //if (phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM)) {
                //return IccConstants.EF_PBR;
            //}
        //}
        //return efid;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.735 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "D751668EF011EB030075908D0A6ACFD9")

    protected static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.735 -0400", hash_original_field = "D649A9D800FCFD8F33135A965A502597", hash_generated_field = "FA1D71E4244EC597340436BF479EB1D2")

    protected static boolean ALLOW_SIM_OP_IN_UI_THREAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.735 -0400", hash_original_field = "70904D17185E41D9EFB2AA2CAD6BE368", hash_generated_field = "526B6F1B800490ABBB8B1A3089D0E50B")

    protected static int EVENT_GET_SIZE_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.735 -0400", hash_original_field = "9B2F039A6EFDFA6B33692A78EEFEE489", hash_generated_field = "A7765961752A627813BD8D2C5D10EFDD")

    protected static int EVENT_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.735 -0400", hash_original_field = "E4F7B0BFE9DAA3D3D6C2A4388043DBB8", hash_generated_field = "584022641802CC9F2BDEEFE5D7435C92")

    protected static int EVENT_UPDATE_DONE = 3;
}

