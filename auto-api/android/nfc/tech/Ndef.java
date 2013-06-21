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
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class Ndef extends BasicTagTechnology {
    private int mMaxNdefSize;
    private int mCardState;
    private NdefMessage mNdefMsg;
    private int mNdefType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.198 -0400", hash_original_method = "F00E44EC8DF6B41B74270E57D440DE27", hash_generated_method = "B3036C3F35D0224589B4B9BF05196F5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Ndef(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF);
        dsTaint.addTaint(tag.dsTaint);
        Bundle extras;
        extras = tag.getTechExtras(TagTechnology.NDEF);
        {
            mMaxNdefSize = extras.getInt(EXTRA_NDEF_MAXLENGTH);
            mCardState = extras.getInt(EXTRA_NDEF_CARDSTATE);
            mNdefMsg = extras.getParcelable(EXTRA_NDEF_MSG);
            mNdefType = extras.getInt(EXTRA_NDEF_TYPE);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("NDEF tech extras are null.");
        } //End block
        // ---------- Original Method ----------
        //Bundle extras = tag.getTechExtras(TagTechnology.NDEF);
        //if (extras != null) {
            //mMaxNdefSize = extras.getInt(EXTRA_NDEF_MAXLENGTH);
            //mCardState = extras.getInt(EXTRA_NDEF_CARDSTATE);
            //mNdefMsg = extras.getParcelable(EXTRA_NDEF_MSG);
            //mNdefType = extras.getInt(EXTRA_NDEF_TYPE);
        //} else {
            //throw new NullPointerException("NDEF tech extras are null.");
        //}
    }

    
        public static Ndef get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF)) return null;
        try {
            return new Ndef(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.200 -0400", hash_original_method = "522E1BD05C0F58597909DF2D37B1E51E", hash_generated_method = "DA4833DD5B3BCDF4278D1494A538AC27")
    @DSModeled(DSC.SAFE)
    public NdefMessage getCachedNdefMessage() {
        return (NdefMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNdefMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.201 -0400", hash_original_method = "A8A4A8CA63E3E206537FB1A4A1A58DE6", hash_generated_method = "058D502440F68498F3BF8BD8FFECB49F")
    @DSModeled(DSC.SAFE)
    public String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch (mNdefType) {
            //case TYPE_1:
                //return NFC_FORUM_TYPE_1;
            //case TYPE_2:
                //return NFC_FORUM_TYPE_2;
            //case TYPE_3:
                //return NFC_FORUM_TYPE_3;
            //case TYPE_4:
                //return NFC_FORUM_TYPE_4;
            //case TYPE_MIFARE_CLASSIC:
                //return MIFARE_CLASSIC;
            //case TYPE_ICODE_SLI:
                //return ICODE_SLI;
            //default:
                //return UNKNOWN;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.202 -0400", hash_original_method = "4EADEE4A8AA14EA957D69BF1EB117D34", hash_generated_method = "616F39052A5BDB56EB1B24CC5DBEF7F0")
    @DSModeled(DSC.SAFE)
    public int getMaxSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMaxNdefSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.202 -0400", hash_original_method = "9C15355B29C0704385FAC8BA222CAFE7", hash_generated_method = "093272A242F185A01A3E831D25D60534")
    @DSModeled(DSC.SAFE)
    public boolean isWritable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mCardState == NDEF_MODE_READ_WRITE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.202 -0400", hash_original_method = "A26F5401571035886FCD1ABC90F65CF6", hash_generated_method = "10F1CC0B27368318F34358BDB04F5140")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NdefMessage getNdefMessage() throws IOException, FormatException {
        checkConnected();
        try 
        {
            INfcTag tagService;
            tagService = mTag.getTagService();
            int serviceHandle;
            serviceHandle = mTag.getServiceHandle();
            {
                boolean var9E38A8733EA654A0B89FA7D8640BC718_796358625 = (tagService.isNdef(serviceHandle));
                {
                    NdefMessage msg;
                    msg = tagService.ndefRead(serviceHandle);
                    {
                        int errorCode;
                        errorCode = tagService.getLastError(serviceHandle);
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
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        return (NdefMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.203 -0400", hash_original_method = "A66DE5F0B266681092CD198588C2EDA0", hash_generated_method = "BED07A2D2B0764FFFA140B61B50D745E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeNdefMessage(NdefMessage msg) throws IOException, FormatException {
        dsTaint.addTaint(msg.dsTaint);
        checkConnected();
        try 
        {
            INfcTag tagService;
            tagService = mTag.getTagService();
            int serviceHandle;
            serviceHandle = mTag.getServiceHandle();
            {
                boolean var9E38A8733EA654A0B89FA7D8640BC718_836822981 = (tagService.isNdef(serviceHandle));
                {
                    int errorCode;
                    errorCode = tagService.ndefWrite(serviceHandle, msg);
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
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Tag is not ndef");
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.203 -0400", hash_original_method = "7292FD9562AEE851073EE82DFE58EB20", hash_generated_method = "4325B46AAAE8E6660D6BD3AE3E7EE468")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean canMakeReadOnly() {
        INfcTag tagService;
        tagService = mTag.getTagService();
        try 
        {
            boolean var23592AA0406DB9179A6CBAB847B3EF44_837491998 = (tagService.canMakeReadOnly(mNdefType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //INfcTag tagService = mTag.getTagService();
        //try {
            //return tagService.canMakeReadOnly(mNdefType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.203 -0400", hash_original_method = "4D610B9041279D39FD5203194F60B421", hash_generated_method = "3D1493205D015310E0E7D7683F507882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean makeReadOnly() throws IOException {
        checkConnected();
        try 
        {
            INfcTag tagService;
            tagService = mTag.getTagService();
            {
                boolean var38FC7228924773AA962BF2A0475BE6CE_1262204717 = (tagService.isNdef(mTag.getServiceHandle()));
                {
                    int errorCode;
                    errorCode = tagService.ndefMakeReadOnly(mTag.getServiceHandle());
                    //Begin case ErrorCodes.ERROR_IO 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case ErrorCodes.ERROR_IO 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IOException();
                    //End case default 
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("Tag is not ndef");
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final String TAG = "NFC";
    public static final int NDEF_MODE_READ_ONLY = 1;
    public static final int NDEF_MODE_READ_WRITE = 2;
    public static final int NDEF_MODE_UNKNOWN = 3;
    public static final String EXTRA_NDEF_MSG = "ndefmsg";
    public static final String EXTRA_NDEF_MAXLENGTH = "ndefmaxlength";
    public static final String EXTRA_NDEF_CARDSTATE = "ndefcardstate";
    public static final String EXTRA_NDEF_TYPE = "ndeftype";
    public static final int TYPE_OTHER = -1;
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_MIFARE_CLASSIC = 101;
    public static final int TYPE_ICODE_SLI = 102;
    public static final String UNKNOWN = "android.ndef.unknown";
    public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
    public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
    public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
    public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
    public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
    public static final String ICODE_SLI = "com.nxp.ndef.icodesli";
}

