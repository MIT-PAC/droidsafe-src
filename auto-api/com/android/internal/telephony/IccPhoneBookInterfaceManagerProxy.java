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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.000 -0400", hash_original_field = "9366EC8886B36238C2F63ECE6C641440", hash_generated_field = "35E1FDA72D4E9A11410B474286E4687E")

    private IccPhoneBookInterfaceManager mIccPhoneBookInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.000 -0400", hash_original_method = "2AD2EA1697680350CF72D11537A6D219", hash_generated_method = "E8E4335B95218AE3F21CAC22D09106D2")
    public  IccPhoneBookInterfaceManagerProxy(IccPhoneBookInterfaceManager
            iccPhoneBookInterfaceManager) {
        mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        {
            boolean varBBCAD71E9D2D335673136957A9052C19_526752180 = (ServiceManager.getService("simphonebook") == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.000 -0400", hash_original_method = "D73EC83F9CAB72AF50214ABBB6029AE3", hash_generated_method = "7410F9F304037814B37AE40C5E08E3F2")
    public void setmIccPhoneBookInterfaceManager(
            IccPhoneBookInterfaceManager iccPhoneBookInterfaceManager) {
        this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        // ---------- Original Method ----------
        //this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.001 -0400", hash_original_method = "5DDF0C0E89F34CB1A8CBBC902747CC21", hash_generated_method = "E862F49E7319644F52207CA2B8B7C1FF")
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber,
            String pin2) throws android.os.RemoteException {
        boolean var7E37E1DB0DB7B43FD9D69755FCDFFC0C_1632267411 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2));
        addTaint(efid);
        addTaint(oldTag.getTaint());
        addTaint(oldPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(pin2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_906350195 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_906350195;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                //efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.001 -0400", hash_original_method = "9AD4878D7C5B3598149BA0FF3B75DA5E", hash_generated_method = "B32CAE9D7A041943CB0D12A5C9F7FDD4")
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) throws android.os.RemoteException {
        boolean varB86F2A6CF3B8B124957B089253D80C1C_775693215 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                newTag, newPhoneNumber, index, pin2));
        addTaint(efid);
        addTaint(newTag.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(index);
        addTaint(pin2.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509727539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509727539;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                //newTag, newPhoneNumber, index, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.001 -0400", hash_original_method = "1CAFC4CE677429A2AF90987C4E8DEFFE", hash_generated_method = "53C3D70B91BB521E1FD23194C99F3D3A")
    public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException {
        int[] varDC9E3C628D902E4383BDC1B8DEEA8E12_2054687497 = (mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid));
        addTaint(efid);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1821702176 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1821702176;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.002 -0400", hash_original_method = "B2C428BBF650EA5A57A68B0456CE8B82", hash_generated_method = "6F48D6147A43BE7F0AF4F96904B455C5")
    public List<AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException {
        List<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_778868169 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_778868169 = mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
        addTaint(efid);
        varB4EAC82CA7396A68D541C85D26508E83_778868169.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_778868169;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
    }

    
}

