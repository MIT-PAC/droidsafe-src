package android.nfc.tech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

public final class MifareUltralight extends BasicTagTechnology {
    private int mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.182 -0400", hash_original_method = "3735B86C07F91E8515EC1CC320AAC040", hash_generated_method = "D6E2200E1B790A1BA2AC12752623C44F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MifareUltralight(Tag tag) throws RemoteException {
        super(tag, TagTechnology.MIFARE_ULTRALIGHT);
        dsTaint.addTaint(tag.dsTaint);
        NfcA a;
        a = NfcA.get(tag);
        mType = TYPE_UNKNOWN;
        {
            boolean var6CC478771079DB48F967904DB58DBB96_435126589 = (a.getSak() == 0x00 && tag.getId()[0] == NXP_MANUFACTURER_ID);
            {
                Bundle extras;
                extras = tag.getTechExtras(TagTechnology.MIFARE_ULTRALIGHT);
                {
                    boolean varEA469A2536A4896C86B6253DEA8C14F6_817388787 = (extras.getBoolean(EXTRA_IS_UL_C));
                    {
                        mType = TYPE_ULTRALIGHT_C;
                    } //End block
                    {
                        mType = TYPE_ULTRALIGHT;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //NfcA a = NfcA.get(tag);
        //mType = TYPE_UNKNOWN;
        //if (a.getSak() == 0x00 && tag.getId()[0] == NXP_MANUFACTURER_ID) {
            //Bundle extras = tag.getTechExtras(TagTechnology.MIFARE_ULTRALIGHT);
            //if (extras.getBoolean(EXTRA_IS_UL_C)) {
                //mType = TYPE_ULTRALIGHT_C;
            //} else {
                //mType = TYPE_ULTRALIGHT;
            //}
        //}
    }

    
        public static MifareUltralight get(Tag tag) {
        if (!tag.hasTech(TagTechnology.MIFARE_ULTRALIGHT)) return null;
        try {
            return new MifareUltralight(tag);
        } catch (RemoteException e) {
            return null;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.182 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "66DFEA4B0062EB4492784966BCFD516E")
    @DSModeled(DSC.SAFE)
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.183 -0400", hash_original_method = "E6849E923D0A9327C443A073C34E8740", hash_generated_method = "B56BECFC6DD9BCA87D0EE304F55C0EF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] readPages(int pageOffset) throws IOException {
        dsTaint.addTaint(pageOffset);
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd;
        byte[] var74A337D194F2176A733474958A472577_748610180 = (transceive(cmd, false));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //validatePageIndex(pageOffset);
        //checkConnected();
        //byte[] cmd = { 0x30, (byte) pageOffset};
        //return transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.185 -0400", hash_original_method = "76B1D0EF2AB1E41E6168EFDF0BF06314", hash_generated_method = "1C76D22E4C12300AB8CF207CE6F0D819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writePage(int pageOffset, byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(pageOffset);
        validatePageIndex(pageOffset);
        checkConnected();
        byte[] cmd;
        cmd = new byte[data.length + 2];
        cmd[0] = (byte) 0xA2;
        cmd[1] = (byte) pageOffset;
        System.arraycopy(data, 0, cmd, 2, data.length);
        transceive(cmd, false);
        // ---------- Original Method ----------
        //validatePageIndex(pageOffset);
        //checkConnected();
        //byte[] cmd = new byte[data.length + 2];
        //cmd[0] = (byte) 0xA2;
        //cmd[1] = (byte) pageOffset;
        //System.arraycopy(data, 0, cmd, 2, data.length);
        //transceive(cmd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.186 -0400", hash_original_method = "E43990821CE38E04B46B3E901EFDFA24", hash_generated_method = "5B05CD8DB4846EA8803574147212A00A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] transceive(byte[] data) throws IOException {
        dsTaint.addTaint(data[0]);
        byte[] var457CAD28AA5A950818B34ED801FB2565_994570709 = (transceive(data, true));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return transceive(data, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.187 -0400", hash_original_method = "CF96EF3BF3FCE4DA3D9E7FBB541AEB70", hash_generated_method = "4609E8C9F019855D79179F46C4AA35E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMaxTransceiveLength() {
        int varAD50EB2A6987338433A93D587AD15277_1757975072 = (getMaxTransceiveLengthInternal());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getMaxTransceiveLengthInternal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.187 -0400", hash_original_method = "D282B40A7C0A3209AA4502B842BB4FB3", hash_generated_method = "C6CB253716AAC92BE411E2EEFFC6D8F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        try 
        {
            int err;
            err = mTag.getTagService().setTimeout(
                    TagTechnology.MIFARE_ULTRALIGHT, timeout);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The supplied timeout is not valid");
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //int err = mTag.getTagService().setTimeout(
                    //TagTechnology.MIFARE_ULTRALIGHT, timeout);
            //if (err != ErrorCodes.SUCCESS) {
                //throw new IllegalArgumentException("The supplied timeout is not valid");
            //}
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.187 -0400", hash_original_method = "849E2A68F4F80A968E68483D2D0B1744", hash_generated_method = "229108F08C952872196406A13AC0A4CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTimeout() {
        try 
        {
            int var0FDD3A6C9CC4EA5F9E59635B4F31C936_1249943616 = (mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mTag.getTagService().getTimeout(TagTechnology.MIFARE_ULTRALIGHT);
        //} catch (RemoteException e) {
            //Log.e(TAG, "NFC service dead", e);
            //return 0;
        //}
    }

    
        private static void validatePageIndex(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= MAX_PAGE_COUNT) {
            throw new IndexOutOfBoundsException("page out of bounds: " + pageIndex);
        }
    }

    
    private static final String TAG = "NFC";
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_ULTRALIGHT = 1;
    public static final int TYPE_ULTRALIGHT_C = 2;
    public static final int PAGE_SIZE = 4;
    private static final int NXP_MANUFACTURER_ID = 0x04;
    private static final int MAX_PAGE_COUNT = 256;
    public static final String EXTRA_IS_UL_C = "isulc";
}

