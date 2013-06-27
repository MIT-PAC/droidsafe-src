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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.580 -0400", hash_original_field = "9366EC8886B36238C2F63ECE6C641440", hash_generated_field = "35E1FDA72D4E9A11410B474286E4687E")

    private IccPhoneBookInterfaceManager mIccPhoneBookInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.580 -0400", hash_original_method = "2AD2EA1697680350CF72D11537A6D219", hash_generated_method = "0D5B889F4A889192484E912995303F50")
    public  IccPhoneBookInterfaceManagerProxy(IccPhoneBookInterfaceManager
            iccPhoneBookInterfaceManager) {
        mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        {
            boolean varBBCAD71E9D2D335673136957A9052C19_449396354 = (ServiceManager.getService("simphonebook") == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.581 -0400", hash_original_method = "D73EC83F9CAB72AF50214ABBB6029AE3", hash_generated_method = "7410F9F304037814B37AE40C5E08E3F2")
    public void setmIccPhoneBookInterfaceManager(
            IccPhoneBookInterfaceManager iccPhoneBookInterfaceManager) {
        this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        // ---------- Original Method ----------
        //this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.582 -0400", hash_original_method = "5DDF0C0E89F34CB1A8CBBC902747CC21", hash_generated_method = "0BA37919A35AD89258EDB7723D1C841B")
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber,
            String pin2) throws android.os.RemoteException {
        boolean var7E37E1DB0DB7B43FD9D69755FCDFFC0C_894473732 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2));
        addTaint(efid);
        addTaint(oldTag.getTaint());
        addTaint(oldPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(pin2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645893186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645893186;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                //efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.582 -0400", hash_original_method = "9AD4878D7C5B3598149BA0FF3B75DA5E", hash_generated_method = "3DE91484BAA0352D1127BC40E1601FD5")
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) throws android.os.RemoteException {
        boolean varB86F2A6CF3B8B124957B089253D80C1C_958538408 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                newTag, newPhoneNumber, index, pin2));
        addTaint(efid);
        addTaint(newTag.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(index);
        addTaint(pin2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_3254764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_3254764;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                //newTag, newPhoneNumber, index, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.582 -0400", hash_original_method = "1CAFC4CE677429A2AF90987C4E8DEFFE", hash_generated_method = "1D830C08B64381749D8040C2D784E21B")
    public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException {
        int[] varDC9E3C628D902E4383BDC1B8DEEA8E12_1613278331 = (mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid));
        addTaint(efid);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1220150854 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1220150854;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.583 -0400", hash_original_method = "B2C428BBF650EA5A57A68B0456CE8B82", hash_generated_method = "43408C1C9D21D8519C00D0C2DCE1DB85")
    public List<AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException {
        List<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1339185801 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1339185801 = mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
        addTaint(efid);
        varB4EAC82CA7396A68D541C85D26508E83_1339185801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1339185801;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
    }

    
}

