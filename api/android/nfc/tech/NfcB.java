package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;





public final class NfcB extends BasicTagTechnology {

    /**
     * Get an instance of {@link NfcB} for the given tag.
     * <p>Returns null if {@link NfcB} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag does not support NFC-B.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param tag an NFC-B compatible tag
     * @return NFC-B object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.952 -0500", hash_original_method = "EDF07211FEA19828D994E4E19AC16277", hash_generated_method = "C82866596BA0E2DB48501D9FDAE45A26")
    public static NfcB get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_B)) return null;
        try {
            return new NfcB(tag);
        } catch (RemoteException e) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.949 -0500", hash_original_field = "E5FD7730446173C8068D849438A9C114", hash_generated_field = "BE35031294E892C3E6D8B573B512355A")

    public static final String EXTRA_APPDATA = "appdata";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.950 -0500", hash_original_field = "FA4733971EC54FD626CB6DD1C222F2C0", hash_generated_field = "165A7657EEF9F0EE08ECCDD00BB0AAF6")

    public static final String EXTRA_PROTINFO = "protinfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.951 -0500", hash_original_field = "E68F49E54D80A56925B55BBFE4530E9C", hash_generated_field = "D6AB51D7386B9FB075CD62E11E89CC38")


    private byte[] mAppData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.951 -0500", hash_original_field = "BA06040F1B903B8D04380ED6CBE4CC30", hash_generated_field = "FF565EDAE4956E1E70949D0CAC4BD68D")

    private byte[] mProtInfo;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.953 -0500", hash_original_method = "2D2D9B1E167FA423D2EE7B2AB12658F9", hash_generated_method = "4ECA7D762D835F8765526B00D51B8692")
    public NfcB(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_B);
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_B);
        mAppData = extras.getByteArray(EXTRA_APPDATA);
        mProtInfo = extras.getByteArray(EXTRA_PROTINFO);
    }

    /**
     * Return the Application Data bytes from ATQB/SENSB_RES at tag discovery.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return Application Data bytes from ATQB/SENSB_RES bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.954 -0500", hash_original_method = "FD7D4BBD84674EF268698E76F3B3C4A1", hash_generated_method = "9A58C3828F74E653B8D6AAF2BB10122A")
    public byte[] getApplicationData() {
        return mAppData;
    }

    /**
     * Return the Protocol Info bytes from ATQB/SENSB_RES at tag discovery.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return Protocol Info bytes from ATQB/SENSB_RES bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.955 -0500", hash_original_method = "4842BF20AFFD1556EAAF44F971F8DB01", hash_generated_method = "B8ACA353DAC069D6D4A891DF4705C5B6")
    public byte[] getProtocolInfo() {
        return mProtInfo;
    }

    /**
     * Send raw NFC-B commands to the tag and receive the response.
     *
     * <p>Applications must not append the EoD (CRC) to the payload,
     * it will be automatically calculated.
     * <p>Applications must not send commands that manage the polling
     * loop and initialization (SENSB_REQ, SLOT_MARKER etc).
     *
     * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum number of bytes
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.956 -0500", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CC13A29AED45E04C4807822531800242")
    public byte[] transceive(byte[] data) throws IOException {
        return transceive(data, true);
    }

    /**
     * Return the maximum number of bytes that can be sent with {@link #transceive}.
     * @return the maximum number of bytes that can be sent with {@link #transceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:43.956 -0500", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "ECC61C711C2C081CEFB91A790D67A4A8")
    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }
}

