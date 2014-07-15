package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.FormatException;
import android.nfc.INfcTag;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;

public final class Ndef extends BasicTagTechnology {

    /**
     * Get an instance of {@link Ndef} for the given tag.
     *
     * <p>Returns null if {@link Ndef} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag is not NDEF formatted, or that this tag
     * is NDEF formatted but under a vendor specification that this Android
     * device does not implement.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @param tag an MIFARE Classic compatible tag
     * @return MIFARE Classic object
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.593 -0500", hash_original_method = "9C172D84504D1F2289AFEC693534C0B9", hash_generated_method = "024D199E5AEB40D6B24B47FD7F5756CC")
    
public static Ndef get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NDEF)) return null;
        try {
            return new Ndef(tag);
        } catch (RemoteException e) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.528 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.531 -0500", hash_original_field = "4E11FA25F046D778F45AD016478E595A", hash_generated_field = "5DBF9CCE6E13B976C8A1637F644EF8AF")

    public static final int NDEF_MODE_READ_ONLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.533 -0500", hash_original_field = "512DA078CBE1842831F1FAE17096E21E", hash_generated_field = "9AF473C2877E6CEDA9FDC11F4F5C6B13")

    public static final int NDEF_MODE_READ_WRITE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.536 -0500", hash_original_field = "11BF39E9499A8399F4ADEA8BFDF457D3", hash_generated_field = "5D6A58E2CFE31E870DD9ECCB6CB28BCF")

    public static final int NDEF_MODE_UNKNOWN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.538 -0500", hash_original_field = "79DE4A61E296DF44D366C0557578C18B", hash_generated_field = "03D3BAE1BAECD74B0536623170B60435")

    public static final String EXTRA_NDEF_MSG = "ndefmsg";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.541 -0500", hash_original_field = "EA1ECDF7AC468920034456441DCA1794", hash_generated_field = "E9849B00182607135A66EA385BB6EEDF")

    public static final String EXTRA_NDEF_MAXLENGTH = "ndefmaxlength";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.543 -0500", hash_original_field = "B3E14DCB61A328FB403057EFE0DBC5F4", hash_generated_field = "E60DC935E7366BEE7CB8A6BCC1E76C3F")

    public static final String EXTRA_NDEF_CARDSTATE = "ndefcardstate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.546 -0500", hash_original_field = "7B94CF2225CEBC52E26E308E33012228", hash_generated_field = "3A731748AEA21BE10691299B82543FC6")

    public static final String EXTRA_NDEF_TYPE = "ndeftype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.550 -0500", hash_original_field = "574FDA622F18191DA061535A803E1F29", hash_generated_field = "F774A018B9285EC5E477028D8C8B18CA")

    public static final int TYPE_OTHER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.552 -0500", hash_original_field = "B1B6672FD71E4DDA74CB219F1A2D8982", hash_generated_field = "B90833880EBD1E3B8DB2C377F2218D95")

    public static final int TYPE_1 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.554 -0500", hash_original_field = "D4FFAAF0B389E7762997C67687C90A84", hash_generated_field = "C4A935A2405F790089A3222823FA06C8")

    public static final int TYPE_2 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.557 -0500", hash_original_field = "5933B51E6D79BCC2D8FD4F5AE828A6CA", hash_generated_field = "F9DB7252B6E07488AFF6CA7F881E590E")

    public static final int TYPE_3 = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.559 -0500", hash_original_field = "E46C3BCF6BEF8076E8D7226471AD16AA", hash_generated_field = "DC39DE3899327A06A0E797E04D33EFA7")

    public static final int TYPE_4 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.562 -0500", hash_original_field = "0584B245F2A75BFD6097F8571621CF7D", hash_generated_field = "9C9138A0D6504FF2ED079C833E453D03")

    public static final int TYPE_MIFARE_CLASSIC = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.564 -0500", hash_original_field = "512D62FA973ACB64D8678273213F6788", hash_generated_field = "768AA5E4F024C71B498BC3C645A3E062")

    public static final int TYPE_ICODE_SLI = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.567 -0500", hash_original_field = "D21049FAE4D925E76C4E7CEC38F874DD", hash_generated_field = "573D864C4DBFA5B4A14D7BB89E1DF434")

    public static final String UNKNOWN = "android.ndef.unknown";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.569 -0500", hash_original_field = "4A045357583C0FCDA37F8E48AF0F307E", hash_generated_field = "9B9B0F5F8E000574CA0476F14E8B8681")

    public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.572 -0500", hash_original_field = "63B5EE78CED86F68E18C642D526F4C51", hash_generated_field = "186E8B71C431D1BE39AB10B1D3DC67AE")

    public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.574 -0500", hash_original_field = "A960690459F9B1E15129F80A468C82D1", hash_generated_field = "6E8100A3CE039AF9F49634A53A4AD1BE")

    public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.577 -0500", hash_original_field = "3EFEF54AF9C72066DD1D22999EB8D252", hash_generated_field = "3C7054635E2F21BC87F3876F24A2784B")

    public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.579 -0500", hash_original_field = "E340C57926EAE88A91BC2D10E465CA18", hash_generated_field = "E94250C73C997BF5AFE2384A69E09FFD")

    public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.581 -0500", hash_original_field = "B904A867B3CCFFB65AF6A2262A0E34E2", hash_generated_field = "586FB5EAC65F9D040431B061ED147A30")

    public static final String ICODE_SLI = "com.nxp.ndef.icodesli";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.583 -0500", hash_original_field = "B1DE6940067A7C84363ACF537BBCBD90", hash_generated_field = "147ADCC633068E8F332A302E1540AD62")

    private  int mMaxNdefSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.585 -0500", hash_original_field = "F58E8BDA745BE7AC53444E6577F99279", hash_generated_field = "C0E8A71CC004D481AAC21A06997161CB")

    private  int mCardState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.588 -0500", hash_original_field = "4B96A41814E59AD317B5B8F531025DB2", hash_generated_field = "B3FEA61CE75C91D3B77101D5899B2CCA")

    private  NdefMessage mNdefMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.590 -0500", hash_original_field = "841A8953B6521F0C53ED7BCD68948252", hash_generated_field = "5C9298B1E249A04AB9B947E9A8D2BBE2")

    private  int mNdefType;

    /**
     * Internal constructor, to be used by NfcAdapter
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.596 -0500", hash_original_method = "F00E44EC8DF6B41B74270E57D440DE27", hash_generated_method = "DD8992E8E6599E6D041BA3D54DE52B8C")
    
public Ndef(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NDEF);
        Bundle extras = tag.getTechExtras(TagTechnology.NDEF);
        if (extras != null) {
            mMaxNdefSize = extras.getInt(EXTRA_NDEF_MAXLENGTH);
            mCardState = extras.getInt(EXTRA_NDEF_CARDSTATE);
            mNdefMsg = extras.getParcelable(EXTRA_NDEF_MSG);
            mNdefType = extras.getInt(EXTRA_NDEF_TYPE);
        } else {
            throw new NullPointerException("NDEF tech extras are null.");
        }

    }

    /**
     * Get the {@link NdefMessage} that was read from the tag at discovery time.
     *
     * <p>If the NDEF Message is modified by an I/O operation then it
     * will not be updated here, this function only returns what was discovered
     * when the tag entered the field.
     * <p>Does not cause any RF activity and does not block.
     * @return NDEF Message read from the tag at discovery time
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.598 -0500", hash_original_method = "522E1BD05C0F58597909DF2D37B1E51E", hash_generated_method = "F1DF6067C43D5254D241015A7A75412F")
    
public NdefMessage getCachedNdefMessage() {
        return mNdefMsg;
    }

    /**
     * Get the NDEF tag type.
     *
     * <p>Returns one of {@link #NFC_FORUM_TYPE_1}, {@link #NFC_FORUM_TYPE_2},
     * {@link #NFC_FORUM_TYPE_3}, {@link #NFC_FORUM_TYPE_4},
     * {@link #MIFARE_CLASSIC} or another NDEF tag type that has not yet been
     * formalized in this Android API.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return a string representing the NDEF tag type
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.601 -0500", hash_original_method = "A8A4A8CA63E3E206537FB1A4A1A58DE6", hash_generated_method = "18140176E54F0B04A8E6EB5AE9FC9F42")
    
public String getType() {
        switch (mNdefType) {
            case TYPE_1:
                return NFC_FORUM_TYPE_1;
            case TYPE_2:
                return NFC_FORUM_TYPE_2;
            case TYPE_3:
                return NFC_FORUM_TYPE_3;
            case TYPE_4:
                return NFC_FORUM_TYPE_4;
            case TYPE_MIFARE_CLASSIC:
                return MIFARE_CLASSIC;
            case TYPE_ICODE_SLI:
                return ICODE_SLI;
            default:
                return UNKNOWN;
        }
    }

    /**
     * Get the maximum NDEF message size in bytes.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return size in bytes
     */
    //@DSSource({DSSourceKind.NFC})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.603 -0500", hash_original_method = "4EADEE4A8AA14EA957D69BF1EB117D34", hash_generated_method = "8AD1B4AB2226C24E86A76755BED7B340")
    
public int getMaxSize() {
        return mMaxNdefSize;
    }

    /**
     * Determine if the tag is writable.
     *
     * <p>NFC Forum tags can be in read-only or read-write states.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * <p>Requires {@link android.Manifest.permission#NFC} permission.
     *
     * @return true if the tag is writable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.605 -0500", hash_original_method = "9C15355B29C0704385FAC8BA222CAFE7", hash_generated_method = "7D5ABC699679580BC4F850139BF6098F")
    
public boolean isWritable() {
        return (mCardState == NDEF_MODE_READ_WRITE);
    }

    /**
     * Read the current {@link android.nfc.NdefMessage} on this tag.
     *
     * <p>This always reads the current NDEF Message stored on the tag.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * @return the NDEF Message, never null
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     * @throws FormatException if the NDEF Message on the tag is malformed
     */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.608 -0500", hash_original_method = "A26F5401571035886FCD1ABC90F65CF6", hash_generated_method = "3E9B41F787B3B94129FA786342DE001E")
    
public NdefMessage getNdefMessage() throws IOException, FormatException {
        checkConnected();

        try {
            INfcTag tagService = mTag.getTagService();
            int serviceHandle = mTag.getServiceHandle();
            if (tagService.isNdef(serviceHandle)) {
                NdefMessage msg = tagService.ndefRead(serviceHandle);
                if (msg == null) {
                    int errorCode = tagService.getLastError(serviceHandle);
                    switch (errorCode) {
                        case ErrorCodes.ERROR_IO:
                            throw new IOException();
                        case ErrorCodes.ERROR_INVALID_PARAM:
                            throw new FormatException();
                        default:
                            // Should not happen
                            throw new IOException();
                    }
                }
                return msg;
            } else {
                return null;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return null;
        }
    }

    /**
     * Overwrite the {@link NdefMessage} on this tag.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param msg the NDEF Message to write, must not be null
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     * @throws FormatException if the NDEF Message to write is malformed
     */
    @DSComment("NFC technology implementation")
    @DSSpec(DSCat.NFC)
    @DSSink({DSSinkKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.611 -0500", hash_original_method = "A66DE5F0B266681092CD198588C2EDA0", hash_generated_method = "FA8A3743106487F592FE97626C6536EC")
    
public void writeNdefMessage(NdefMessage msg) throws IOException, FormatException {
        checkConnected();

        try {
            INfcTag tagService = mTag.getTagService();
            int serviceHandle = mTag.getServiceHandle();
            if (tagService.isNdef(serviceHandle)) {
                int errorCode = tagService.ndefWrite(serviceHandle, msg);
                switch (errorCode) {
                    case ErrorCodes.SUCCESS:
                        break;
                    case ErrorCodes.ERROR_IO:
                        throw new IOException();
                    case ErrorCodes.ERROR_INVALID_PARAM:
                        throw new FormatException();
                    default:
                        // Should not happen
                        throw new IOException();
                }
            }
            else {
                throw new IOException("Tag is not ndef");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    /**
     * Indicates whether a tag can be made read-only with {@link #makeReadOnly()}.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return true if it is possible to make this tag read-only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.613 -0500", hash_original_method = "7292FD9562AEE851073EE82DFE58EB20", hash_generated_method = "8852E7341685179DDF02B1ECD484D9F2")
    
public boolean canMakeReadOnly() {
        INfcTag tagService = mTag.getTagService();
        try {
            return tagService.canMakeReadOnly(mNdefType);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return false;
        }
    }

    /**
     * Make a tag read-only.
     *
     * <p>This sets the CC field to indicate the tag is read-only,
     * and where possible permanently sets the lock bits to prevent
     * any further modification of the memory.
     * <p>This is a one-way process and cannot be reverted!
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @return true on success, false if it is not possible to make this tag read-only
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.616 -0500", hash_original_method = "4D610B9041279D39FD5203194F60B421", hash_generated_method = "E637A0C23C9B450A1A78530B1DD71A00")
    
public boolean makeReadOnly() throws IOException {
        checkConnected();

        try {
            INfcTag tagService = mTag.getTagService();
            if (tagService.isNdef(mTag.getServiceHandle())) {
                int errorCode = tagService.ndefMakeReadOnly(mTag.getServiceHandle());
                switch (errorCode) {
                    case ErrorCodes.SUCCESS:
                        return true;
                    case ErrorCodes.ERROR_IO:
                        throw new IOException();
                    case ErrorCodes.ERROR_INVALID_PARAM:
                        return false;
                    default:
                        // Should not happen
                        throw new IOException();
                }
           }
           else {
               throw new IOException("Tag is not ndef");
           }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return false;
        }
    }
}

