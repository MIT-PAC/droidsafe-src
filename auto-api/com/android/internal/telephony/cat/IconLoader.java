package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.IccFileHandler;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

class IconLoader extends Handler {
    private int mState = STATE_SINGLE_ICON;
    private ImageDescriptor mId = null;
    private Bitmap mCurrentIcon = null;
    private int mRecordNumber;
    private IccFileHandler mSimFH = null;
    private Message mEndMsg = null;
    private byte[] mIconData = null;
    private int[] mRecordNumbers = null;
    private int mCurrentRecordIndex = 0;
    private Bitmap[] mIcons = null;
    private HashMap<Integer, Bitmap> mIconsCache = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.908 -0400", hash_original_method = "FC71F40EA342EA47A36AF8D952C946AD", hash_generated_method = "6F619234C09F66FF61C10E1E52D57979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IconLoader(Looper looper , IccFileHandler fh) {
        super(looper);
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(fh.dsTaint);
        mIconsCache = new HashMap<Integer, Bitmap>(50);
        // ---------- Original Method ----------
        //mSimFH = fh;
        //mIconsCache = new HashMap<Integer, Bitmap>(50);
    }

    
        static IconLoader getInstance(Handler caller, IccFileHandler fh) {
        if (sLoader != null) {
            return sLoader;
        }
        if (fh != null) {
            HandlerThread thread = new HandlerThread("Cat Icon Loader");
            thread.start();
            return new IconLoader(thread.getLooper(), fh);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.908 -0400", hash_original_method = "E56E284105F777D8A6CAB7DB3EDAC84F", hash_generated_method = "E57C17B7737325EE25AB0259A33A7EB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void loadIcons(int[] recordNumbers, Message msg) {
        dsTaint.addTaint(recordNumbers[0]);
        dsTaint.addTaint(msg.dsTaint);
        mIcons = new Bitmap[recordNumbers.length];
        mCurrentRecordIndex = 0;
        mState = STATE_MULTI_ICONS;
        startLoadingIcon(recordNumbers[0]);
        // ---------- Original Method ----------
        //if (recordNumbers == null || recordNumbers.length == 0 || msg == null) {
            //return;
        //}
        //mEndMsg = msg;
        //mIcons = new Bitmap[recordNumbers.length];
        //mRecordNumbers = recordNumbers;
        //mCurrentRecordIndex = 0;
        //mState = STATE_MULTI_ICONS;
        //startLoadingIcon(recordNumbers[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.909 -0400", hash_original_method = "328A1F48C7F5C3C618F7E134C6DE5C8B", hash_generated_method = "9707A6FE8A34E418B7C3CA7B111FA5C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void loadIcon(int recordNumber, Message msg) {
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(msg.dsTaint);
        mState = STATE_SINGLE_ICON;
        startLoadingIcon(recordNumber);
        // ---------- Original Method ----------
        //if (msg == null) {
            //return;
        //}
        //mEndMsg = msg;
        //mState = STATE_SINGLE_ICON;
        //startLoadingIcon(recordNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.909 -0400", hash_original_method = "CF2A7740DA96FFBF2B7742A73D5B85D3", hash_generated_method = "DF2CD3EDC660C021599FC8C2325A8FDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void startLoadingIcon(int recordNumber) {
        dsTaint.addTaint(recordNumber);
        mId = null;
        mIconData = null;
        mCurrentIcon = null;
        {
            boolean varDE81173A3DD1F6D6B038C86AB5DCBBC3_1224027670 = (mIconsCache.containsKey(recordNumber));
            {
                mCurrentIcon = mIconsCache.get(recordNumber);
                postIcon();
            } //End block
        } //End collapsed parenthetic
        readId();
        // ---------- Original Method ----------
        //mId = null;
        //mIconData = null;
        //mCurrentIcon = null;
        //mRecordNumber = recordNumber;
        //if (mIconsCache.containsKey(recordNumber)) {
            //mCurrentIcon = mIconsCache.get(recordNumber);
            //postIcon();
            //return;
        //}
        //readId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.909 -0400", hash_original_method = "E1BF715B9C953843C5BFB563C24D3B0D", hash_generated_method = "8F7F0BF4CEAB32ADEFBE5AE4A55C650A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        try 
        {
            //Begin case EVENT_READ_EF_IMG_RECOED_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_READ_EF_IMG_RECOED_DONE 
            //Begin case EVENT_READ_EF_IMG_RECOED_DONE 
            {
                boolean var166F9F3229813452CC65C23DFD03D3DF_1877906683 = (handleImageDescriptor((byte[]) ar.result));
                {
                    readIconData();
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new Exception("Unable to parse image descriptor");
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_READ_EF_IMG_RECOED_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            byte[] rawData;
            rawData = ((byte[]) ar.result);
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            {
                mCurrentIcon = parseToBnW(rawData, rawData.length);
                mIconsCache.put(mRecordNumber, mCurrentIcon);
                postIcon();
            } //End block
            {
                mIconData = rawData;
                readClut();
            } //End block
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_CLUT_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_READ_CLUT_DONE 
            //Begin case EVENT_READ_CLUT_DONE 
            byte [] clut;
            clut = ((byte[]) ar.result);
            //End case EVENT_READ_CLUT_DONE 
            //Begin case EVENT_READ_CLUT_DONE 
            mCurrentIcon = parseToRGB(mIconData, mIconData.length,
                        false, clut);
            //End case EVENT_READ_CLUT_DONE 
            //Begin case EVENT_READ_CLUT_DONE 
            mIconsCache.put(mRecordNumber, mCurrentIcon);
            //End case EVENT_READ_CLUT_DONE 
            //Begin case EVENT_READ_CLUT_DONE 
            postIcon();
            //End case EVENT_READ_CLUT_DONE 
        } //End block
        catch (Exception e)
        {
            CatLog.d(this, "Icon load failed");
            postIcon();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.910 -0400", hash_original_method = "57AAD79E24539ED69C4A9588C1A4DBA1", hash_generated_method = "2D572F74F94EB83641A0E9E2B0B8DF6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean handleImageDescriptor(byte[] rawData) {
        dsTaint.addTaint(rawData[0]);
        mId = ImageDescriptor.parse(rawData, 1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mId = ImageDescriptor.parse(rawData, 1);
        //if (mId == null) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.910 -0400", hash_original_method = "78AA98F6413EBAF06D9D3065D89FA10B", hash_generated_method = "559A1BAEC902DF0B531A9A5E333133CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readClut() {
        int length;
        length = mIconData[3] * CLUT_ENTRY_SIZE;
        Message msg;
        msg = this.obtainMessage(EVENT_READ_CLUT_DONE);
        mSimFH.loadEFImgTransparent(mId.imageId,
                mIconData[CLUT_LOCATION_OFFSET],
                mIconData[CLUT_LOCATION_OFFSET + 1], length, msg);
        // ---------- Original Method ----------
        //int length = mIconData[3] * CLUT_ENTRY_SIZE;
        //Message msg = this.obtainMessage(EVENT_READ_CLUT_DONE);
        //mSimFH.loadEFImgTransparent(mId.imageId,
                //mIconData[CLUT_LOCATION_OFFSET],
                //mIconData[CLUT_LOCATION_OFFSET + 1], length, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.910 -0400", hash_original_method = "9B2E1F9D86B0BE7AA9984F6F6998AD1A", hash_generated_method = "89FBD5E175EEA499B0ADA47DCE6327AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readId() {
        {
            mCurrentIcon = null;
            postIcon();
        } //End block
        Message msg;
        msg = this.obtainMessage(EVENT_READ_EF_IMG_RECOED_DONE);
        mSimFH.loadEFImgLinearFixed(mRecordNumber, msg);
        // ---------- Original Method ----------
        //if (mRecordNumber < 0) {
            //mCurrentIcon = null;
            //postIcon();
            //return;
        //}
        //Message msg = this.obtainMessage(EVENT_READ_EF_IMG_RECOED_DONE);
        //mSimFH.loadEFImgLinearFixed(mRecordNumber, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.910 -0400", hash_original_method = "E5FF0727F4A23FBA52C74807E31F642C", hash_generated_method = "CAAD17297C2BAD97EC97352A8F8278EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readIconData() {
        Message msg;
        msg = this.obtainMessage(EVENT_READ_ICON_DONE);
        mSimFH.loadEFImgTransparent(mId.imageId, 0, 0, mId.length ,msg);
        // ---------- Original Method ----------
        //Message msg = this.obtainMessage(EVENT_READ_ICON_DONE);
        //mSimFH.loadEFImgTransparent(mId.imageId, 0, 0, mId.length ,msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.911 -0400", hash_original_method = "2C2351D604337717A113511ACF501262", hash_generated_method = "3BBCA77ECF8B0A8BF92BF330C4F98D46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postIcon() {
        {
            mEndMsg.obj = mCurrentIcon;
            mEndMsg.sendToTarget();
        } //End block
        {
            mIcons[mCurrentRecordIndex++] = mCurrentIcon;
            {
                startLoadingIcon(mRecordNumbers[mCurrentRecordIndex]);
            } //End block
            {
                mEndMsg.obj = mIcons;
                mEndMsg.sendToTarget();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mState == STATE_SINGLE_ICON) {
            //mEndMsg.obj = mCurrentIcon;
            //mEndMsg.sendToTarget();
        //} else if (mState == STATE_MULTI_ICONS) {
            //mIcons[mCurrentRecordIndex++] = mCurrentIcon;
            //if (mCurrentRecordIndex < mRecordNumbers.length) {
                //startLoadingIcon(mRecordNumbers[mCurrentRecordIndex]);
            //} else {
                //mEndMsg.obj = mIcons;
                //mEndMsg.sendToTarget();
            //}
        //}
    }

    
        public static Bitmap parseToBnW(byte[] data, int length) {
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int numOfPixels = width*height;
        int[] pixels = new int[numOfPixels];
        int pixelIndex = 0;
        int bitIndex = 7;
        byte currentByte = 0x00;
        while (pixelIndex < numOfPixels) {
            if (pixelIndex % 8 == 0) {
                currentByte = data[valueIndex++];
                bitIndex = 7;
            }
            pixels[pixelIndex++] = bitToBnW((currentByte >> bitIndex-- ) & 0x01);
        }
        if (pixelIndex != numOfPixels) {
            CatLog.d("IconLoader", "parseToBnW; size error");
        }
        return Bitmap.createBitmap(pixels, width, height, Bitmap.Config.ARGB_8888);
    }

    
        private static int bitToBnW(int bit) {
        if(bit == 1){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    
        public static Bitmap parseToRGB(byte[] data, int length,
            boolean transparency, byte[] clut) {
        int valueIndex = 0;
        int width = data[valueIndex++] & 0xFF;
        int height = data[valueIndex++] & 0xFF;
        int bitsPerImg = data[valueIndex++] & 0xFF;
        int numOfClutEntries = data[valueIndex++] & 0xFF;
        if (true == transparency) {
            clut[numOfClutEntries - 1] = Color.TRANSPARENT;
        }
        int numOfPixels = width * height;
        int[] pixels = new int[numOfPixels];
        valueIndex = 6;
        int pixelIndex = 0;
        int bitsStartOffset = 8 - bitsPerImg;
        int bitIndex = bitsStartOffset;
        byte currentByte = data[valueIndex++];
        int mask = getMask(bitsPerImg);
        boolean bitsOverlaps = (8 % bitsPerImg == 0);
        while (pixelIndex < numOfPixels) {
            if (bitIndex < 0) {
                currentByte = data[valueIndex++];
                bitIndex = bitsOverlaps ? (bitsStartOffset) : (bitIndex * -1);
            }
            int clutEntry = ((currentByte >> bitIndex) & mask);
            int clutIndex = clutEntry * CLUT_ENTRY_SIZE;
            pixels[pixelIndex++] = Color.rgb(clut[clutIndex],
                    clut[clutIndex + 1], clut[clutIndex + 2]);
            bitIndex -= bitsPerImg;
        }
        return Bitmap.createBitmap(pixels, width, height,
                Bitmap.Config.ARGB_8888);
    }

    
        private static int getMask(int numOfBits) {
        int mask = 0x00;
        switch (numOfBits) {
        case 1:
            mask = 0x01;
            break;
        case 2:
            mask = 0x03;
            break;
        case 3:
            mask = 0x07;
            break;
        case 4:
            mask = 0x0F;
            break;
        case 5:
            mask = 0x1F;
            break;
        case 6:
            mask = 0x3F;
            break;
        case 7:
            mask = 0x7F;
            break;
        case 8:
            mask = 0xFF;
            break;
        }
        return mask;
    }

    
    private static IconLoader sLoader = null;
    private static final int STATE_SINGLE_ICON = 1;
    private static final int STATE_MULTI_ICONS = 2;
    private static final int EVENT_READ_EF_IMG_RECOED_DONE  = 1;
    private static final int EVENT_READ_ICON_DONE           = 2;
    private static final int EVENT_READ_CLUT_DONE           = 3;
    private static final int CLUT_LOCATION_OFFSET = 4;
    private static final int CLUT_ENTRY_SIZE = 3;
}

