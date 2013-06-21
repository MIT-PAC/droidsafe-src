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
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class IccPhoneBookInterfaceManagerProxy extends IIccPhoneBook.Stub {
    private IccPhoneBookInterfaceManager mIccPhoneBookInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.395 -0400", hash_original_method = "2AD2EA1697680350CF72D11537A6D219", hash_generated_method = "05ED300CF1131AEEE00EA7CDFFA7F1EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccPhoneBookInterfaceManagerProxy(IccPhoneBookInterfaceManager
            iccPhoneBookInterfaceManager) {
        dsTaint.addTaint(iccPhoneBookInterfaceManager.dsTaint);
        {
            boolean varBBCAD71E9D2D335673136957A9052C19_619369922 = (ServiceManager.getService("simphonebook") == null);
            {
                ServiceManager.addService("simphonebook", this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        //if(ServiceManager.getService("simphonebook") == null) {
            //ServiceManager.addService("simphonebook", this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.396 -0400", hash_original_method = "D73EC83F9CAB72AF50214ABBB6029AE3", hash_generated_method = "BD59C29456BAF2367A0E7C432005A508")
    @DSModeled(DSC.SAFE)
    public void setmIccPhoneBookInterfaceManager(
            IccPhoneBookInterfaceManager iccPhoneBookInterfaceManager) {
        dsTaint.addTaint(iccPhoneBookInterfaceManager.dsTaint);
        // ---------- Original Method ----------
        //this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.396 -0400", hash_original_method = "5DDF0C0E89F34CB1A8CBBC902747CC21", hash_generated_method = "9EF449801464D97FB2D27A4881EE3C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber,
            String pin2) throws android.os.RemoteException {
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(newTag);
        dsTaint.addTaint(oldPhoneNumber);
        dsTaint.addTaint(oldTag);
        dsTaint.addTaint(newPhoneNumber);
        dsTaint.addTaint(efid);
        boolean var7E37E1DB0DB7B43FD9D69755FCDFFC0C_1816848548 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                //efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.397 -0400", hash_original_method = "9AD4878D7C5B3598149BA0FF3B75DA5E", hash_generated_method = "72F69EF9E71527626DAFABC32C213B1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) throws android.os.RemoteException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(newTag);
        dsTaint.addTaint(newPhoneNumber);
        dsTaint.addTaint(efid);
        boolean varB86F2A6CF3B8B124957B089253D80C1C_1412263585 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                newTag, newPhoneNumber, index, pin2));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                //newTag, newPhoneNumber, index, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.397 -0400", hash_original_method = "1CAFC4CE677429A2AF90987C4E8DEFFE", hash_generated_method = "90C418AFEB2C32EA4F0BE40F0E585CB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException {
        dsTaint.addTaint(efid);
        int[] varDC9E3C628D902E4383BDC1B8DEEA8E12_1636229592 = (mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid));
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.397 -0400", hash_original_method = "B2C428BBF650EA5A57A68B0456CE8B82", hash_generated_method = "D3579E059C539C9B7EA8F448B181E4B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException {
        dsTaint.addTaint(efid);
        List<AdnRecord> varFE95D75773C910026C651E925A12B39D_1412848746 = (mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid));
        return (List<AdnRecord>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
    }

    
}

