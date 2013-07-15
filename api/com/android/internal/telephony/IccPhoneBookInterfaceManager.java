package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.pm.PackageManager;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IccPhoneBookInterfaceManager extends IIccPhoneBook.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.588 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.588 -0400", hash_original_field = "2997832A50D1A4B04AAED3D387CB11EB", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.588 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "CD9F8D1AABF8833BACD5C9B6B52458C3")

    protected final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.588 -0400", hash_original_field = "7E55978E096520E8CDAECF1333070CED", hash_generated_field = "E5B26C030F2ABDD85D0CB8A10D64DB7B")

    protected int recordSize[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.588 -0400", hash_original_field = "260CA9DD8A4577FC00B7BD5810298076", hash_generated_field = "113121599E8140F8C4C329198A2D7722")

    protected boolean success;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.588 -0400", hash_original_field = "6E52C40BB8FC91FF39EE5C79B4211F67", hash_generated_field = "71F18D31BD5AF48450CA4612AD1865B0")

    protected List<AdnRecord> records;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.989 -0400", hash_original_field = "F240289ECF5C81105F1EF992E6E2ADFE", hash_generated_field = "1DB8578536D5CE25805244FDBD843A4E")

    protected Handler mBaseHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.989 -0400", hash_original_method = "F8C0BA183015902A4341C34058945BDE", hash_generated_method = "941FD1090CAF73E06F07DEB3BDEE7189")
        @Override
        public void handleMessage(Message msg) {
            AsyncResult ar;
            
            ar = (AsyncResult) msg.obj;
            
            
            {
                {
                    recordSize = (int[])ar.result;
                    logd("GET_RECORD_SIZE Size " + recordSize[0] +
                                    " total " + recordSize[1] +
                                    " #record " + recordSize[2]);
                } 
                notifyPending(ar);
            } 
            
            
            ar = (AsyncResult) msg.obj;
            
            
            {
                success = (ar.exception == null);
                notifyPending(ar);
            } 
            
            
            ar = (AsyncResult)msg.obj;
            
            
            {
                {
                    records = (List<AdnRecord>) ar.result;
                } 
                {
                    logd("Cannot load ADN records");
                    {
                        records.clear();
                    } 
                } 
                notifyPending(ar);
            } 
            
            addTaint(msg.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.989 -0400", hash_original_method = "AEA2E9D2067E99FB1331FC981CC14937", hash_generated_method = "A9B77AF35C7BC8F11854E73C8BE49190")
        private void notifyPending(AsyncResult ar) {
            AtomicBoolean status = (AtomicBoolean) ar.userObj;
            status.set(true);
            mLock.notifyAll();
            addTaint(ar.getTaint());
            
            
                
            
            
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.589 -0400", hash_original_method = "A61AB5A9E61C78C524F0A299EDDA8B31", hash_generated_method = "F8239CE1F53CC35117D554BE23C34DE0")
    public  IccPhoneBookInterfaceManager(PhoneBase phone) {
        this.phone = phone;
        // ---------- Original Method ----------
        //this.phone = phone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.589 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.589 -0400", hash_original_method = "96914FA697D4DDB9AE25582FAB4A6818", hash_generated_method = "1E7A9ED6D1CCD6DE353231DD77EAE9D8")
    protected void publish() {
        ServiceManager.addService("simphonebook", this);
        // ---------- Original Method ----------
        //ServiceManager.addService("simphonebook", this);
    }

    
    protected abstract void logd(String msg);

    
    protected abstract void loge(String msg);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.590 -0400", hash_original_method = "6BE84EAB1F25CDC10E8188E3A1C3A959", hash_generated_method = "4D79757B9B75F14E354A2F2BBC093106")
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber, String pin2) {
        addTaint(pin2.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(oldPhoneNumber.getTaint());
        addTaint(oldTag.getTaint());
        addTaint(efid);
    if(phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
            != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException var2F274855F73158EABBE7DB894471DCBD_63812545 = new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
            var2F274855F73158EABBE7DB894471DCBD_63812545.addTaint(taint);
            throw var2F274855F73158EABBE7DB894471DCBD_63812545;
        } //End block
    if(DBG)        
        logd("updateAdnRecordsInEfBySearch: efid=" + efid +
                " ("+ oldTag + "," + oldPhoneNumber + ")"+ "==>" +
                " ("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        efid = updateEfForIccType(efid);
        synchronized
(mLock)        {
            checkThread();
            success = false;
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord oldAdn = new AdnRecord(oldTag, oldPhoneNumber);
            AdnRecord newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnBySearch(efid, oldAdn, newAdn, pin2, response);
            waitForResult(status);
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_1546724994 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1599805915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1599805915;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.591 -0400", hash_original_method = "102FC1C0583C00426ED85686CB9EA64E", hash_generated_method = "D34CBB4037B23E1558FDDC49CE25AB5E")
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) {
        addTaint(pin2.getTaint());
        addTaint(index);
        addTaint(newPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(efid);
    if(phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException var2F274855F73158EABBE7DB894471DCBD_1492090365 = new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
            var2F274855F73158EABBE7DB894471DCBD_1492090365.addTaint(taint);
            throw var2F274855F73158EABBE7DB894471DCBD_1492090365;
        } //End block
    if(DBG)        
        logd("updateAdnRecordsInEfByIndex: efid=" + efid +
                " Index=" + index + " ==> " +
                "("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        synchronized
(mLock)        {
            checkThread();
            success = false;
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnByIndex(efid, newAdn, index, pin2, response);
            waitForResult(status);
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_514485009 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912647433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912647433;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract int[] getAdnRecordsSize(int efid);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.592 -0400", hash_original_method = "2EC5B47F5C71460FB1C246E071649E17", hash_generated_method = "611ED9ADFB4839BAF329BF25E15940D9")
    public List<AdnRecord> getAdnRecordsInEf(int efid) {
        addTaint(efid);
    if(phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException var27FDED624B787859A52BDA309D93217B_2008805073 = new SecurityException(
                    "Requires android.permission.READ_CONTACTS permission");
            var27FDED624B787859A52BDA309D93217B_2008805073.addTaint(taint);
            throw var27FDED624B787859A52BDA309D93217B_2008805073;
        } //End block
        efid = updateEfForIccType(efid);
    if(DBG)        
        logd("getAdnRecordsInEF: efid=" + efid);
        synchronized
(mLock)        {
            checkThread();
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_LOAD_DONE, status);
            adnCache.requestLoadAllAdnLike(efid, adnCache.extensionEfForEf(efid), response);
            waitForResult(status);
        } //End block
List<AdnRecord> varFE65894448998F2F8382F47C41BDE1F8_959461885 =         records;
        varFE65894448998F2F8382F47C41BDE1F8_959461885.addTaint(taint);
        return varFE65894448998F2F8382F47C41BDE1F8_959461885;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.592 -0400", hash_original_method = "323B98E2749A47EA83AB3530A004F85D", hash_generated_method = "F5E39FD5FB99E07DBC08BEA6CEC052F6")
    protected void checkThread() {
    if(!ALLOW_SIM_OP_IN_UI_THREAD)        
        {
    if(mBaseHandler.getLooper().equals(Looper.myLooper()))            
            {
                loge("query() called on the main UI thread!");
                IllegalStateException varAE50B6EACDFF2EBC625ABE87BD6C1EBE_403194215 = new IllegalStateException(
                        "You cannot call query on this provder from the main UI thread.");
                varAE50B6EACDFF2EBC625ABE87BD6C1EBE_403194215.addTaint(taint);
                throw varAE50B6EACDFF2EBC625ABE87BD6C1EBE_403194215;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.593 -0400", hash_original_method = "FD540EF7FFA0769933308F8586A1F0A4", hash_generated_method = "274E2E535773FFF11771E51128916BD7")
    protected void waitForResult(AtomicBoolean status) {
        addTaint(status.getTaint());
        while
(!status.get())        
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
        // ---------- Original Method ----------
        //while (!status.get()) {
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //logd("interrupted while trying to update by search");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.593 -0400", hash_original_method = "6710BA71BBE2AF73325E69DE756B39B5", hash_generated_method = "19271FA0C8DDABFCC7FAA923E1649C4A")
    private int updateEfForIccType(int efid) {
        addTaint(efid);
    if(efid == IccConstants.EF_ADN)        
        {
    if(phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM))            
            {
                int var33F5C4CE294383953D111A51DF9A19CE_483860857 = (IccConstants.EF_PBR);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431875774 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431875774;
            } //End block
        } //End block
        int var1E3235258D1AA505A2572AF2B7877EBF_284421124 = (efid);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546792126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546792126;
        // ---------- Original Method ----------
        //if (efid == IccConstants.EF_ADN) {
            //if (phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM)) {
                //return IccConstants.EF_PBR;
            //}
        //}
        //return efid;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.594 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.594 -0400", hash_original_field = "D649A9D800FCFD8F33135A965A502597", hash_generated_field = "1E8984E99524AF28D68E56356A817DB3")

    protected static final boolean ALLOW_SIM_OP_IN_UI_THREAD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.594 -0400", hash_original_field = "70904D17185E41D9EFB2AA2CAD6BE368", hash_generated_field = "B75ECFF18BE57F85BC7759CCE867BB30")

    protected static final int EVENT_GET_SIZE_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.594 -0400", hash_original_field = "9B2F039A6EFDFA6B33692A78EEFEE489", hash_generated_field = "377496E733F7263CE55C3D4166BA075D")

    protected static final int EVENT_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.594 -0400", hash_original_field = "E4F7B0BFE9DAA3D3D6C2A4388043DBB8", hash_generated_field = "164C2891BBAF1E0C740CD93CF09B115E")

    protected static final int EVENT_UPDATE_DONE = 3;
}

