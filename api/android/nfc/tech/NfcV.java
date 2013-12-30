package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;





public final class NfcV extends BasicTagTechnology {

    /**
     * Get an instance of {@link NfcV} for the given tag.
     * <p>Returns null if {@link NfcV} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag does not support NFC-V.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param tag an NFC-V compatible tag
     * @return NFC-V object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.407 -0500", hash_original_method = "F21DE175E97C7CA6B5016046F850B598", hash_generated_method = "BA04E11D3E7F4732245DDA59CAEC2390")
    
public static NfcV get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_V)) return null;
        try {
            return new NfcV(tag);
        } catch (RemoteException e) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.397 -0500", hash_original_field = "A99A2829D6F5F929C205B83A458B0A80", hash_generated_field = "95711EE7AD682B156CC0B59B8BB1D20B")

    public static final String EXTRA_RESP_FLAGS = "respflags";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.400 -0500", hash_original_field = "6EFCA95892EE01E4DB47A22052971D83", hash_generated_field = "575D53CDD0D0DA8B99F62F7C149BA7A1")

    public static final String EXTRA_DSFID = "dsfid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.402 -0500", hash_original_field = "2C0FB919660C0D7D01CA14F5FDEF08F9", hash_generated_field = "121CAF4F22F2DB7E3FE6590C2E29C484")


    private byte mRespFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.404 -0500", hash_original_field = "6A0E644AD48A7A11D3A50934FD1C3DD6", hash_generated_field = "22B4F1B6769CD74A976FDA7EB332E5E3")

    private byte mDsfId;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.409 -0500", hash_original_method = "F4045E9985ED2B22A83A671B7ECDE866", hash_generated_method = "BCA4ECC481DE66EB7639D24A2750A8BD")
    
public NfcV(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_V);
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_V);
        mRespFlags = extras.getByte(EXTRA_RESP_FLAGS);
        mDsfId = extras.getByte(EXTRA_DSFID);
    }

    /**
     * Return the Response Flag bytes from tag discovery.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return Response Flag bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.412 -0500", hash_original_method = "19D3A3646C1C2655B316DC5413F4466A", hash_generated_method = "B7AEDAE18B3D311E741259AABC364993")
    
public byte getResponseFlags() {
        return mRespFlags;
    }

    /**
     * Return the DSF ID bytes from tag discovery.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return DSF ID bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.414 -0500", hash_original_method = "9F53E6713A0959247C46979AAE2F100E", hash_generated_method = "CF1C00DE1C7700C1728A76B01F027DE7")
    
public byte getDsfId() {
        return mDsfId;
    }

    /**
     * Send raw NFC-V commands to the tag and receive the response.
     *
     * <p>Applications must not append the CRC to the payload,
     * it will be automatically calculated. The application does
     * provide FLAGS, CMD and PARAMETER bytes.
     *
     * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum amount of bytes
     * that can be sent with {@link #transceive}.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param data bytes to send
     * @return bytes received in response
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or this operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.416 -0500", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CC13A29AED45E04C4807822531800242")
    
public byte[] transceive(byte[] data) throws IOException {
        return transceive(data, true);
    }


    /**
     * Return the maximum number of bytes that can be sent with {@link #transceive}.
     * @return the maximum number of bytes that can be sent with {@link #transceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.418 -0500", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "ECC61C711C2C081CEFB91A790D67A4A8")
    
public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }
}

