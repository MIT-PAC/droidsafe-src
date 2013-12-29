package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.RemoteException;





public final class NfcA extends BasicTagTechnology {

    /**
     * Get an instance of {@link NfcA} for the given tag.
     * <p>Returns null if {@link NfcA} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag does not support NFC-A.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param tag an NFC-A compatible tag
     * @return NFC-A object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.090 -0500", hash_original_method = "B4B772E4BD6BD6194B055D8FD2AF64E0", hash_generated_method = "C055DFBE336D3CB6C1C34D38F97BBE7B")
    public static NfcA get(Tag tag) {
        if (!tag.hasTech(TagTechnology.NFC_A)) return null;
        try {
            return new NfcA(tag);
        } catch (RemoteException e) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.086 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.087 -0500", hash_original_field = "740FD8886A3C979DFFB94297916130C7", hash_generated_field = "CDCE0B9F229930126B4A9C3FF1148379")

    public static final String EXTRA_SAK = "sak";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.088 -0500", hash_original_field = "AF463AC1A14921138D392C76E79A8DD6", hash_generated_field = "42E2DBE9FAB155A8309DC6253C59B539")

    public static final String EXTRA_ATQA = "atqa";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.089 -0500", hash_original_field = "0925D0697AA3C3DB845341236C79150E", hash_generated_field = "84C03AB800CA76624FDACC0FE5253451")


    private short mSak;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.089 -0500", hash_original_field = "420539DFF13F5D44245F242194872800", hash_generated_field = "C3ED3C2F9CAB5980376F9374631262D3")

    private byte[] mAtqa;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.091 -0500", hash_original_method = "7F7EA5045624074AA33D4555E4EB43B6", hash_generated_method = "325A5E5BF07BCAFFC1115DDB35E7C5BC")
    public NfcA(Tag tag) throws RemoteException {
        super(tag, TagTechnology.NFC_A);
        Bundle extras = tag.getTechExtras(TagTechnology.NFC_A);
        mSak = extras.getShort(EXTRA_SAK);
        mAtqa = extras.getByteArray(EXTRA_ATQA);
    }

    /**
     * Return the ATQA/SENS_RES bytes from tag discovery.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return ATQA/SENS_RES bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.092 -0500", hash_original_method = "0C48EFD3E17B27EC975A7F66A0C95A20", hash_generated_method = "6AC2779CC2E6FEE5CEA1892E88594E78")
    public byte[] getAtqa() {
        return mAtqa;
    }

    /**
     * Return the SAK/SEL_RES bytes from tag discovery.
     *
     * <p>Does not cause any RF activity and does not block.
     *
     * @return SAK bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.093 -0500", hash_original_method = "82922CBBC94A0186459AA7EC846F5755", hash_generated_method = "D5AB0D6B38F06ED8090E699EB16AFAA7")
    public short getSak() {
        return mSak;
    }

    /**
     * Send raw NFC-A commands to the tag and receive the response.
     *
     * <p>Applications must not append the EoD (CRC) to the payload,
     * it will be automatically calculated.
     * <p>Applications must only send commands that are complete bytes,
     * for example a SENS_REQ is not possible (these are used to
     * manage tag polling and initialization).
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.094 -0500", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CC13A29AED45E04C4807822531800242")
    public byte[] transceive(byte[] data) throws IOException {
        return transceive(data, true);
    }

    /**
     * Return the maximum number of bytes that can be sent with {@link #transceive}.
     * @return the maximum number of bytes that can be sent with {@link #transceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.094 -0500", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "ECC61C711C2C081CEFB91A790D67A4A8")
    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    /**
     * Set the {@link #transceive} timeout in milliseconds.
     *
     * <p>The timeout only applies to {@link #transceive} on this object,
     * and is reset to a default value when {@link #close} is called.
     *
     * <p>Setting a longer timeout may be useful when performing
     * transactions that require a long processing time on the tag
     * such as key generation.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param timeout timeout value in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.096 -0500", hash_original_method = "63D5F2163C0B5751BB93B998E089091B", hash_generated_method = "E77492272970D597221E47D7B03DAC67")
    public void setTimeout(int timeout) {
        try {
            int err = mTag.getTagService().setTimeout(TagTechnology.NFC_A, timeout);
            if (err != ErrorCodes.SUCCESS) {
                throw new IllegalArgumentException("The supplied timeout is not valid");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    /**
     * Get the current {@link #transceive} timeout in milliseconds.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @return timeout value in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.096 -0500", hash_original_method = "BA38E23E1F1B427D7366A44F0802731B", hash_generated_method = "8436CD64C61569FD7D13D897817E46DF")
    public int getTimeout() {
        try {
            return mTag.getTagService().getTimeout(TagTechnology.NFC_A);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }
}

