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
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class IccPhoneBookInterfaceManagerProxy extends IIccPhoneBook.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.599 -0400", hash_original_field = "9366EC8886B36238C2F63ECE6C641440", hash_generated_field = "35E1FDA72D4E9A11410B474286E4687E")

    private IccPhoneBookInterfaceManager mIccPhoneBookInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.599 -0400", hash_original_method = "2AD2EA1697680350CF72D11537A6D219", hash_generated_method = "AB108BE31B1E9BD3C3D3C936F0AD79E9")
    public  IccPhoneBookInterfaceManagerProxy(IccPhoneBookInterfaceManager
            iccPhoneBookInterfaceManager) {
        mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
    if(ServiceManager.getService("simphonebook") == null)        
        {
            ServiceManager.addService("simphonebook", this);
        } //End block
        // ---------- Original Method ----------
        //mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        //if(ServiceManager.getService("simphonebook") == null) {
            //ServiceManager.addService("simphonebook", this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.600 -0400", hash_original_method = "D73EC83F9CAB72AF50214ABBB6029AE3", hash_generated_method = "7410F9F304037814B37AE40C5E08E3F2")
    public void setmIccPhoneBookInterfaceManager(
            IccPhoneBookInterfaceManager iccPhoneBookInterfaceManager) {
        this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        // ---------- Original Method ----------
        //this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.601 -0400", hash_original_method = "5DDF0C0E89F34CB1A8CBBC902747CC21", hash_generated_method = "936004A3AC1F2D044D9E51BF3B86EAD0")
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber,
            String pin2) throws android.os.RemoteException {
        addTaint(pin2.getTaint());
        addTaint(newPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(oldPhoneNumber.getTaint());
        addTaint(oldTag.getTaint());
        addTaint(efid);
        boolean varC9D4C0A52E58EC86AA0605336E0967BB_1304900424 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500161660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500161660;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                //efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.601 -0400", hash_original_method = "9AD4878D7C5B3598149BA0FF3B75DA5E", hash_generated_method = "0722964E217C201E09493C0128FCF08E")
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) throws android.os.RemoteException {
        addTaint(pin2.getTaint());
        addTaint(index);
        addTaint(newPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(efid);
        boolean var191C611AAAA872135819F5EEEB8935F8_1487385940 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                newTag, newPhoneNumber, index, pin2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779084890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779084890;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                //newTag, newPhoneNumber, index, pin2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.601 -0400", hash_original_method = "1CAFC4CE677429A2AF90987C4E8DEFFE", hash_generated_method = "9FADA69A9CB8AB893E31324F01A08FCB")
    public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException {
        addTaint(efid);
        int[] varDA05ABA2FA884170302962B204321BA0_1010013114 = (mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid));
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_669194616 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_669194616;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.602 -0400", hash_original_method = "B2C428BBF650EA5A57A68B0456CE8B82", hash_generated_method = "C265E14B2DC79F477BCA36890BF22BAC")
    public List<AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException {
        addTaint(efid);
List<AdnRecord> var24E03C974B6797027BF7ED53C6A4078C_1496456800 =         mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
        var24E03C974B6797027BF7ED53C6A4078C_1496456800.addTaint(taint);
        return var24E03C974B6797027BF7ED53C6A4078C_1496456800;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
    }

    
}

