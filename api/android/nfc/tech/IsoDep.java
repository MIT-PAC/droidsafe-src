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





public final class IsoDep extends BasicTagTechnology {

    /**
     * Get an instance of {@link IsoDep} for the given tag.
     * <p>Does not cause any RF activity and does not block.
     * <p>Returns null if {@link IsoDep} was not enumerated in {@link Tag#getTechList}.
     * This indicates the tag does not support ISO-DEP.
     *
     * @param tag an ISO-DEP compatible tag
     * @return ISO-DEP object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.028 -0500", hash_original_method = "C6CC52618DE66A28A0006BD4E3051663", hash_generated_method = "F4F182B9FEF624CCC2DBFA03BD4E4747")
    public static IsoDep get(Tag tag) {
        if (!tag.hasTech(TagTechnology.ISO_DEP)) return null;
        try {
            return new IsoDep(tag);
        } catch (RemoteException e) {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.024 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.025 -0500", hash_original_field = "21A7C79D1CBD4624F3C2A369D7AAFEB0", hash_generated_field = "0E2E65346F18311034DF7A7BA8ADFB90")

    public static final String EXTRA_HI_LAYER_RESP = "hiresp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.026 -0500", hash_original_field = "E303B98FA2084CA604A101B2172BE952", hash_generated_field = "21C86F60B2A1F20B574EAB41D200309D")

    public static final String EXTRA_HIST_BYTES = "histbytes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.027 -0500", hash_original_field = "024891029CB9A1D2D5A40AF6023BA549", hash_generated_field = "C1B33D9EC979F28624EE472E9265053E")


    private byte[] mHiLayerResponse = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.028 -0500", hash_original_field = "B228B60700B7320A8C1C9D098DEAFA2D", hash_generated_field = "7255E07206283D65FDE42F0CB345FA56")

    private byte[] mHistBytes = null;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.029 -0500", hash_original_method = "FFBD1FB2ECDDD8F0799F6AF75CBD6C12", hash_generated_method = "B4E3DE15822C4591ECF13A8CB1939128")
    public IsoDep(Tag tag)
            throws RemoteException {
        super(tag, TagTechnology.ISO_DEP);
        Bundle extras = tag.getTechExtras(TagTechnology.ISO_DEP);
        if (extras != null) {
            mHiLayerResponse = extras.getByteArray(EXTRA_HI_LAYER_RESP);
            mHistBytes = extras.getByteArray(EXTRA_HIST_BYTES);
        }
    }

    /**
     * Set the timeout of {@link #transceive} in milliseconds.
     * <p>The timeout only applies to ISO-DEP {@link #transceive}, and is
     * reset to a default value when {@link #close} is called.
     * <p>Setting a longer timeout may be useful when performing
     * transactions that require a long processing time on the tag
     * such as key generation.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param timeout timeout value in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.030 -0500", hash_original_method = "C12C31601200CC9185BEA621DAA9D522", hash_generated_method = "D55492101B40F463521FE464EFC6D320")
    public void setTimeout(int timeout) {
        try {
            int err = mTag.getTagService().setTimeout(TagTechnology.ISO_DEP, timeout);
            if (err != ErrorCodes.SUCCESS) {
                throw new IllegalArgumentException("The supplied timeout is not valid");
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        }
    }

    /**
     * Get the current timeout for {@link #transceive} in milliseconds.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @return timeout value in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.031 -0500", hash_original_method = "DE4D3DFA438B7711A20A8976B1AA544A", hash_generated_method = "B06BC3FCD93EBF7540184CD12298E20D")
    public int getTimeout() {
        try {
            return mTag.getTagService().getTimeout(TagTechnology.ISO_DEP);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }

    /**
     * Return the ISO-DEP historical bytes for {@link NfcA} tags.
     * <p>Does not cause any RF activity and does not block.
     * <p>The historical bytes can be used to help identify a tag. They are present
     * only on {@link IsoDep} tags that are based on {@link NfcA} RF technology.
     * If this tag is not {@link NfcA} then null is returned.
     * <p>In ISO 14443-4 terminology, the historical bytes are a subset of the RATS
     * response.
     *
     * @return ISO-DEP historical bytes, or null if this is not a {@link NfcA} tag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.032 -0500", hash_original_method = "4E22C8A1A17AEE88575C62DC6B93AE32", hash_generated_method = "F041335959690BB3F6F3F89EA4FCCE6C")
    public byte[] getHistoricalBytes() {
        return mHistBytes;
    }

    /**
     * Return the higher layer response bytes for {@link NfcB} tags.
     * <p>Does not cause any RF activity and does not block.
     * <p>The higher layer response bytes can be used to help identify a tag.
     * They are present only on {@link IsoDep} tags that are based on {@link NfcB}
     * RF technology. If this tag is not {@link NfcB} then null is returned.
     * <p>In ISO 14443-4 terminology, the higher layer bytes are a subset of the
     * ATTRIB response.
     *
     * @return ISO-DEP historical bytes, or null if this is not a {@link NfcB} tag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.033 -0500", hash_original_method = "7FAA32860355D81337B89B991C6D0641", hash_generated_method = "F25DC6AFB5A5FB58D0A0DF2AA726A425")
    public byte[] getHiLayerResponse() {
        return mHiLayerResponse;
    }

    /**
     * Send raw ISO-DEP data to the tag and receive the response.
     *
     * <p>Applications must only send the INF payload, and not the start of frame and
     * end of frame indicators. Applications do not need to fragment the payload, it
     * will be automatically fragmented and defragmented by {@link #transceive} if
     * it exceeds FSD/FSC limits.
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
     * @param data command bytes to send, must not be null
     * @return response bytes received, will not be null
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or this operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.033 -0500", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CC13A29AED45E04C4807822531800242")
    public byte[] transceive(byte[] data) throws IOException {
        return transceive(data, true);
    }

    /**
     * Return the maximum number of bytes that can be sent with {@link #transceive}.
     * @return the maximum number of bytes that can be sent with {@link #transceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.034 -0500", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "ECC61C711C2C081CEFB91A790D67A4A8")
    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }
}

