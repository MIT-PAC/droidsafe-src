package android.nfc.tech;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.os.RemoteException;



public final class NdefFormatable extends BasicTagTechnology {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.698 -0400", hash_original_method = "074BAD8FDA859E71D091A9807C3BD3AB", hash_generated_method = "25CA3327852ABB990C5F36B5B2E347B5")
    public  NdefFormatable(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF_FORMATABLE);
        addTaint(tag.getTaint());
        // ---------- Original Method ----------
    }

    
    public static NdefFormatable get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF_FORMATABLE)) return null;
        try {
            return new NdefFormatable(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.698 -0400", hash_original_method = "6CDCACAEC64FFB65AEDACBA4B44913A4", hash_generated_method = "D7399B803076A904EE452AE8C06A80F6")
    public void format(NdefMessage firstMessage) throws IOException, FormatException {
        addTaint(firstMessage.getTaint());
        format(firstMessage, false);
        // ---------- Original Method ----------
        //format(firstMessage, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.698 -0400", hash_original_method = "2D5D7133932920FB3E992CFF7D090021", hash_generated_method = "024B0D5AB9FF910E9A3DFBD7CD3E2EB1")
    public void formatReadOnly(NdefMessage firstMessage) throws IOException, FormatException {
        addTaint(firstMessage.getTaint());
        format(firstMessage, true);
        // ---------- Original Method ----------
        //format(firstMessage, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.700 -0400", hash_original_method = "E299B2177763F767A596EAE082378EB1", hash_generated_method = "7932BDC750FDE9B3C6DF5FE4ADABE8D7")
     void format(NdefMessage firstMessage, boolean makeReadOnly) throws IOException,
            FormatException {
        addTaint(makeReadOnly);
        addTaint(firstMessage.getTaint());
        checkConnected();
        try 
        {
            int serviceHandle = mTag.getServiceHandle();
            INfcTag tagService = mTag.getTagService();
            int errorCode = tagService.formatNdef(serviceHandle, MifareClassic.KEY_DEFAULT);
switch(errorCode){
            case ErrorCodes.SUCCESS:
            break;
            case ErrorCodes.ERROR_IO:
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_2013333990 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_2013333990.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_2013333990;
            case ErrorCodes.ERROR_INVALID_PARAM:
            FormatException var5AE822463340EC06A6F1D312B3631805_616760938 = new FormatException();
            var5AE822463340EC06A6F1D312B3631805_616760938.addTaint(taint);
            throw var5AE822463340EC06A6F1D312B3631805_616760938;
            default:
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1127506018 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1127506018.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1127506018;
}            if(tagService.isNdef(serviceHandle))            
            {
                errorCode = tagService.ndefWrite(serviceHandle, firstMessage);
switch(errorCode){
                case ErrorCodes.SUCCESS:
                break;
                case ErrorCodes.ERROR_IO:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_458703672 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_458703672.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_458703672;
                case ErrorCodes.ERROR_INVALID_PARAM:
                FormatException var5AE822463340EC06A6F1D312B3631805_944937186 = new FormatException();
                var5AE822463340EC06A6F1D312B3631805_944937186.addTaint(taint);
                throw var5AE822463340EC06A6F1D312B3631805_944937186;
                default:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1351686113 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1351686113.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1351686113;
}
            } //End block
            else
            {
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1751298467 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1751298467.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1751298467;
            } //End block
            if(makeReadOnly)            
            {
                errorCode = tagService.ndefMakeReadOnly(serviceHandle);
switch(errorCode){
                case ErrorCodes.SUCCESS:
                break;
                case ErrorCodes.ERROR_IO:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_2009093582 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_2009093582.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_2009093582;
                case ErrorCodes.ERROR_INVALID_PARAM:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_49775028 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_49775028.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_49775028;
                default:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_581919447 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_581919447.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_581919447;
}
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.701 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
}

