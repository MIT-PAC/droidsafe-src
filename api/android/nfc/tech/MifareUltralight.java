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





public final class MifareUltralight extends BasicTagTechnology {

    /**
     * Get an instance of {@link MifareUltralight} for the given tag.
     * <p>Returns null if {@link MifareUltralight} was not enumerated in
     * {@link Tag#getTechList} - this indicates the tag is not MIFARE
     * Ultralight compatible, or that this Android
     * device does not implement MIFARE Ultralight.
     * <p>Does not cause any RF activity and does not block.
     *
     * @param tag an MIFARE Ultralight compatible tag
     * @return MIFARE Ultralight object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.256 -0500", hash_original_method = "B741E02638FF439D209E74D661416E0D", hash_generated_method = "95D4598C43B29F141BCF1F77CD261FC9")
    public static MifareUltralight get(Tag tag) {
        if (!tag.hasTech(TagTechnology.MIFARE_ULTRALIGHT)) return null;
        try {
            return new MifareUltralight(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.265 -0500", hash_original_method = "5381F3968E5290EBFA8EA57118E465FB", hash_generated_method = "C9C2E18151F1C0210CB63BA63893EFE9")
    private static void validatePageIndex(int pageIndex) {
        // Do not be too strict on upper bounds checking, since some cards
        // may have more addressable memory than they report.
        // Note that issuing a command to an out-of-bounds block is safe - the
        // tag will wrap the read to an addressable area. This validation is a
        // helper to guard against obvious programming mistakes.
        if (pageIndex < 0 || pageIndex >= MAX_PAGE_COUNT) {
            throw new IndexOutOfBoundsException("page out of bounds: " + pageIndex);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.248 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.249 -0500", hash_original_field = "4E3213304A9AE81B4AE58CC302F1CDF6", hash_generated_field = "384725A35AE2048CC01CB14C667E6F8D")

    public static final int TYPE_UNKNOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.249 -0500", hash_original_field = "C0E356236BA48CC161DA86686F380765", hash_generated_field = "9BE3F76DF00EB59F29F6A17EB828F767")

    public static final int TYPE_ULTRALIGHT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.250 -0500", hash_original_field = "C6883D74B77DA7C4FC59A525D0E70DE0", hash_generated_field = "84E7082E6CDB244EAD32A3F8AC3B8CF8")

    public static final int TYPE_ULTRALIGHT_C = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.251 -0500", hash_original_field = "CE086572C0A0215DC834EF6157816F0E", hash_generated_field = "65A194E1705A84CF4A535345BE21CB60")

    public static final int PAGE_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.252 -0500", hash_original_field = "245FCB02BF0BCBA4E578CD836AA35AFC", hash_generated_field = "06570E4E13E0E5C4F5DAEA0BCB6353F6")


    private static final int NXP_MANUFACTURER_ID = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.253 -0500", hash_original_field = "BA1CE31014F375EFEA7C95068A1C75AD", hash_generated_field = "712A7209011F6BE783946B2F4E26F18C")

    private static final int MAX_PAGE_COUNT = 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.254 -0500", hash_original_field = "497EE385D56A9DD8E270C71B950C7705", hash_generated_field = "4962E30417FE0FA3945478E0C7DB1FD0")

    public static final String EXTRA_IS_UL_C = "isulc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.255 -0500", hash_original_field = "B93BF1EFA6B57CC598632E54B97CD147", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")


    private int mType;

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.257 -0500", hash_original_method = "3735B86C07F91E8515EC1CC320AAC040", hash_generated_method = "BE833DA2AC67E731BFDD92E86842C51D")
    public MifareUltralight(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_ULTRALIGHT);

        // Check if this could actually be a MIFARE
        NfcA a = NfcA.get(tag);

        mType = TYPE_UNKNOWN;

        if (a.getSak() == 0x00 && tag.getId()[0] == NXP_MANUFACTURER_ID) {
            Bundle extras = tag.getTechExtras(TagTechnology.MIFARE_ULTRALIGHT);
            if (extras.getBoolean(EXTRA_IS_UL_C)) {
                mType = TYPE_ULTRALIGHT_C;
            } else {
                mType = TYPE_ULTRALIGHT;
            }
        }
    }

    /**
     * Return the MIFARE Ultralight type of the tag.
     * <p>One of {@link #TYPE_ULTRALIGHT} or {@link #TYPE_ULTRALIGHT_C} or
     * {@link #TYPE_UNKNOWN}.
     * <p>Depending on how the tag has been formatted, it can be impossible
     * to accurately classify between original MIFARE Ultralight and
     * Ultralight C. So treat this method as a hint.
     * <p>Does not cause any RF activity and does not block.
     *
     * @return the type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.257 -0500", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "32498FCDA3AC1E9A676800B51A331335")
    public int getType() {
        return mType;
    }

    /**
     * Read 4 pages (16 bytes).
     *
     * <p>The MIFARE Ultralight protocol always reads 4 pages at a time, to
     * reduce the number of commands required to read an entire tag.
     * <p>If a read spans past the last readable block, then the tag will
     * return pages that have been wrapped back to the first blocks. MIFARE
     * Ultralight tags have readable blocks 0x00 through 0x0F. So a read to
     * block offset 0x0E would return blocks 0x0E, 0x0F, 0x00, 0x01. MIFARE
     * Ultralight C tags have readable blocks 0x00 through 0x2B. So a read to
     * block 0x2A would return blocks 0x2A, 0x2B, 0x00, 0x01.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param pageOffset index of first page to read, starting from 0
     * @return 4 pages (16 bytes)
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.258 -0500", hash_original_method = "E6849E923D0A9327C443A073C34E8740", hash_generated_method = "76E54949ED74B79C16944A57E8832D49")
    public byte[] readPages(int pageOffset) throws IOException {
        validatePageIndex(pageOffset);
        checkConnected();

        byte[] cmd = { 0x30, (byte) pageOffset};
        return transceive(cmd, false);
    }

    /**
     * Write 1 page (4 bytes).
     *
     * <p>The MIFARE Ultralight protocol always writes 1 page at a time, to
     * minimize EEPROM write cycles.
     *
     * <p>This is an I/O operation and will block until complete. It must
     * not be called from the main application thread. A blocked call will be canceled with
     * {@link IOException} if {@link #close} is called from another thread.
     *
     * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
     *
     * @param pageOffset index of page to write, starting from 0
     * @param data 4 bytes to write
     * @throws TagLostException if the tag leaves the field
     * @throws IOException if there is an I/O failure, or the operation is canceled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.259 -0500", hash_original_method = "76B1D0EF2AB1E41E6168EFDF0BF06314", hash_generated_method = "616587A96EAE554F61AB08B5111D4681")
    public void writePage(int pageOffset, byte[] data) throws IOException {
        validatePageIndex(pageOffset);
        checkConnected();

        byte[] cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA2;
        cmd[1] = (byte) pageOffset;
        System.arraycopy(data, 0, cmd, 2, data.length);

        transceive(cmd, false);
    }

    /**
     * Send raw NfcA data to a tag and receive the response.
     *
     * <p>This is equivalent to connecting to this tag via {@link NfcA}
     * and calling {@link NfcA#transceive}. Note that all MIFARE Classic
     * tags are based on {@link NfcA} technology.
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
     * @see NfcA#transceive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.262 -0500", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "CC13A29AED45E04C4807822531800242")
    public byte[] transceive(byte[] data) throws IOException {
        return transceive(data, true);
    }

    /**
     * Return the maximum number of bytes that can be sent with {@link #transceive}.
     * @return the maximum number of bytes that can be sent with {@link #transceive}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.263 -0500", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "ECC61C711C2C081CEFB91A790D67A4A8")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.264 -0500", hash_original_method = "D282B40A7C0A3209AA4502B842BB4FB3", hash_generated_method = "0FC1DEF997C3DBC8A64B326219E90D10")
    public void setTimeout(int timeout) {
        try {
            int err = mTag.getTagService().setTimeout(
                    TagTechnology.MIFARE_ULTRALIGHT, timeout);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:44.264 -0500", hash_original_method = "849E2A68F4F80A968E68483D2D0B1744", hash_generated_method = "4E9626CABB0D93E29B9B4E60B529B09D")
    public int getTimeout() {
        try {
            return mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }
}

