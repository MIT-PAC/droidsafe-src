package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.210 -0400", hash_original_method = "074BAD8FDA859E71D091A9807C3BD3AB", hash_generated_method = "1DCB3AC26AEB3723BC47CFACCCAA86D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefFormatable(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF_FORMATABLE);
        dsTaint.addTaint(tag.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.210 -0400", hash_original_method = "6CDCACAEC64FFB65AEDACBA4B44913A4", hash_generated_method = "4A3AD00669CD2C3F906BD5D8EB63524F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void format(NdefMessage firstMessage) throws IOException, FormatException {
        dsTaint.addTaint(firstMessage.dsTaint);
        format(firstMessage, false);
        // ---------- Original Method ----------
        //format(firstMessage, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.210 -0400", hash_original_method = "2D5D7133932920FB3E992CFF7D090021", hash_generated_method = "CE436F5F4FF0F6ED0047D3A6FF20C1B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void formatReadOnly(NdefMessage firstMessage) throws IOException, FormatException {
        dsTaint.addTaint(firstMessage.dsTaint);
        format(firstMessage, true);
        // ---------- Original Method ----------
        //format(firstMessage, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.211 -0400", hash_original_method = "E299B2177763F767A596EAE082378EB1", hash_generated_method = "0AD134AC66ACE5B522285EF6C2957B35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void format(NdefMessage firstMessage, boolean makeReadOnly) throws IOException,
            FormatException {
        dsTaint.addTaint(makeReadOnly);
        dsTaint.addTaint(firstMessage.dsTaint);
        checkConnected();
        try 
        {
            int serviceHandle;
            serviceHandle = mTag.getServiceHandle();
            INfcTag tagService;
            tagService = mTag.getTagService();
            int errorCode;
            errorCode = tagService.formatNdef(serviceHandle, MifareClassic.KEY_DEFAULT);
            //Begin case ErrorCodes.ERROR_IO 
            if (DroidSafeAndroidRuntime.control) throw new IOException();
            //End case ErrorCodes.ERROR_IO 
            //Begin case ErrorCodes.ERROR_INVALID_PARAM 
            if (DroidSafeAndroidRuntime.control) throw new FormatException();
            //End case ErrorCodes.ERROR_INVALID_PARAM 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IOException();
            //End case default 
            {
                boolean var9E38A8733EA654A0B89FA7D8640BC718_2100530498 = (tagService.isNdef(serviceHandle));
                {
                    errorCode = tagService.ndefWrite(serviceHandle, firstMessage);
                    //Begin case ErrorCodes.ERROR_IO 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case ErrorCodes.ERROR_IO 
                    //Begin case ErrorCodes.ERROR_INVALID_PARAM 
                    if (DroidSafeAndroidRuntime.control) throw new FormatException();
                    //End case ErrorCodes.ERROR_INVALID_PARAM 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case default 
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                } //End block
            } //End collapsed parenthetic
            {
                errorCode = tagService.ndefMakeReadOnly(serviceHandle);
                //Begin case ErrorCodes.ERROR_IO 
                if (DroidSafeAndroidRuntime.control) throw new IOException();
                //End case ErrorCodes.ERROR_IO 
                //Begin case ErrorCodes.ERROR_INVALID_PARAM 
                if (DroidSafeAndroidRuntime.control) throw new IOException();
                //End case ErrorCodes.ERROR_INVALID_PARAM 
                //Begin case default 
                if (DroidSafeAndroidRuntime.control) throw new IOException();
                //End case default 
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String TAG = "NFC";
}

