package android.nfc.tech;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.nfc.ErrorCodes;
import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class NdefFormatable extends BasicTagTechnology {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.005 -0400", hash_original_method = "074BAD8FDA859E71D091A9807C3BD3AB", hash_generated_method = "25CA3327852ABB990C5F36B5B2E347B5")
    public  NdefFormatable(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF_FORMATABLE);
        addTaint(tag.getTaint());
        
    }

    
        public static NdefFormatable get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF_FORMATABLE)) return null;
        try {
            return new NdefFormatable(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.006 -0400", hash_original_method = "6CDCACAEC64FFB65AEDACBA4B44913A4", hash_generated_method = "D7399B803076A904EE452AE8C06A80F6")
    public void format(NdefMessage firstMessage) throws IOException, FormatException {
        addTaint(firstMessage.getTaint());
        format(firstMessage, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.006 -0400", hash_original_method = "2D5D7133932920FB3E992CFF7D090021", hash_generated_method = "024B0D5AB9FF910E9A3DFBD7CD3E2EB1")
    public void formatReadOnly(NdefMessage firstMessage) throws IOException, FormatException {
        addTaint(firstMessage.getTaint());
        format(firstMessage, true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.008 -0400", hash_original_method = "E299B2177763F767A596EAE082378EB1", hash_generated_method = "E2B032083BC9DDF1402861922E0E2726")
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
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1692630203 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1692630203.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1692630203;
            case ErrorCodes.ERROR_INVALID_PARAM:
            FormatException var5AE822463340EC06A6F1D312B3631805_1242919393 = new FormatException();
            var5AE822463340EC06A6F1D312B3631805_1242919393.addTaint(taint);
            throw var5AE822463340EC06A6F1D312B3631805_1242919393;
            default:
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_693816505 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_693816505.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_693816505;
}    if(tagService.isNdef(serviceHandle))            
            {
                errorCode = tagService.ndefWrite(serviceHandle, firstMessage);
switch(errorCode){
                case ErrorCodes.SUCCESS:
                break;
                case ErrorCodes.ERROR_IO:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_107514434 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_107514434.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_107514434;
                case ErrorCodes.ERROR_INVALID_PARAM:
                FormatException var5AE822463340EC06A6F1D312B3631805_826184463 = new FormatException();
                var5AE822463340EC06A6F1D312B3631805_826184463.addTaint(taint);
                throw var5AE822463340EC06A6F1D312B3631805_826184463;
                default:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1818783462 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1818783462.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1818783462;
}
            } 
            else
            {
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1739840073 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1739840073.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1739840073;
            } 
    if(makeReadOnly)            
            {
                errorCode = tagService.ndefMakeReadOnly(serviceHandle);
switch(errorCode){
                case ErrorCodes.SUCCESS:
                break;
                case ErrorCodes.ERROR_IO:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_230733027 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_230733027.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_230733027;
                case ErrorCodes.ERROR_INVALID_PARAM:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_566223444 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_566223444.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_566223444;
                default:
                IOException var1508E3FDF27FD56D4E1051DB16DE1816_1955983011 = new IOException();
                var1508E3FDF27FD56D4E1051DB16DE1816_1955983011.addTaint(taint);
                throw var1508E3FDF27FD56D4E1051DB16DE1816_1955983011;
}
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:30.009 -0400", hash_original_field = "839E89798F641D78E99C5732B39CA844", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
}

