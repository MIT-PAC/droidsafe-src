package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

import android.os.ServiceManager;





public class IccPhoneBookInterfaceManagerProxy extends IIccPhoneBook.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.220 -0400", hash_original_field = "9366EC8886B36238C2F63ECE6C641440", hash_generated_field = "35E1FDA72D4E9A11410B474286E4687E")

    private IccPhoneBookInterfaceManager mIccPhoneBookInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.220 -0400", hash_original_method = "2AD2EA1697680350CF72D11537A6D219", hash_generated_method = "AB108BE31B1E9BD3C3D3C936F0AD79E9")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.220 -0400", hash_original_method = "D73EC83F9CAB72AF50214ABBB6029AE3", hash_generated_method = "7410F9F304037814B37AE40C5E08E3F2")
    public void setmIccPhoneBookInterfaceManager(
            IccPhoneBookInterfaceManager iccPhoneBookInterfaceManager) {
        this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
        // ---------- Original Method ----------
        //this.mIccPhoneBookInterfaceManager = iccPhoneBookInterfaceManager;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.221 -0400", hash_original_method = "5DDF0C0E89F34CB1A8CBBC902747CC21", hash_generated_method = "89316C29AF0B1D2F9E62F062D40AED6C")
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
        boolean varC9D4C0A52E58EC86AA0605336E0967BB_56599058 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845285371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845285371;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfBySearch(
                //efid, oldTag, oldPhoneNumber, newTag, newPhoneNumber, pin2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.221 -0400", hash_original_method = "9AD4878D7C5B3598149BA0FF3B75DA5E", hash_generated_method = "EF72975139229B6049D4AC9F6386C9D3")
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) throws android.os.RemoteException {
        addTaint(pin2.getTaint());
        addTaint(index);
        addTaint(newPhoneNumber.getTaint());
        addTaint(newTag.getTaint());
        addTaint(efid);
        boolean var191C611AAAA872135819F5EEEB8935F8_76657936 = (mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                newTag, newPhoneNumber, index, pin2));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_77821821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_77821821;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.updateAdnRecordsInEfByIndex(efid,
                //newTag, newPhoneNumber, index, pin2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.222 -0400", hash_original_method = "1CAFC4CE677429A2AF90987C4E8DEFFE", hash_generated_method = "F794450F32543D728CCBF53A53B5CE1B")
    public int[] getAdnRecordsSize(int efid) throws android.os.RemoteException {
        addTaint(efid);
        int[] varDA05ABA2FA884170302962B204321BA0_1128441038 = (mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid));
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_612181445 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_612181445;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsSize(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.222 -0400", hash_original_method = "B2C428BBF650EA5A57A68B0456CE8B82", hash_generated_method = "271E545530C385EEE89E6095A7AFE4AC")
    public List<AdnRecord> getAdnRecordsInEf(int efid) throws android.os.RemoteException {
        addTaint(efid);
List<AdnRecord> var24E03C974B6797027BF7ED53C6A4078C_1318543470 =         mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
        var24E03C974B6797027BF7ED53C6A4078C_1318543470.addTaint(taint);
        return var24E03C974B6797027BF7ED53C6A4078C_1318543470;
        // ---------- Original Method ----------
        //return mIccPhoneBookInterfaceManager.getAdnRecordsInEf(efid);
    }

    
}

