package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "990880030B80BFF3BC8D3AE0AC35462D", hash_generated_field = "34FA58117F875C1478775AF3E2E8B77F")

    private int mState = STATE_SINGLE_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "CAF2113C3C2D7C5D808A041F7615F3CD", hash_generated_field = "BBF32FCC0D1BDC907D743204AEBDE31E")

    private ImageDescriptor mId = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "F9053C5A4D5CF365CE2BFAC1ABA72434", hash_generated_field = "C437DBCD739D99106D16871E5C170598")

    private Bitmap mCurrentIcon = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "389D3C466495594C3C81192D48E837ED", hash_generated_field = "915D91392A6FD2996994AAECEF49523C")

    private int mRecordNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "41ACF4E2A2B6659AEE5803BD31F55E0E", hash_generated_field = "466ECA2EC8599DB18BA618AF3BB38E4A")

    private IccFileHandler mSimFH = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "DE64C3B05DBF00C6E37DAFD2C19243BF", hash_generated_field = "B30996872B8060E9F9D87F9AD668CBDD")

    private Message mEndMsg = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "049E0D153A085667CD0A0C021F52B06C", hash_generated_field = "154C16D413ECF747A4DDA2BE115A565B")

    private byte[] mIconData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "08E2F89D3FDD039D2B362CDAA719D53F", hash_generated_field = "992E68CF65D2B9E251C815E9737B213A")

    private int[] mRecordNumbers = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "66DE059789171600749A4FCE27D22427", hash_generated_field = "27D98BF0C1B289316F3B85701A09EBD0")

    private int mCurrentRecordIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "ABA435DA55C8C9C6F5EE674A478FF79A", hash_generated_field = "7BFCC2EA81A743318762373A8002B1FC")

    private Bitmap[] mIcons = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.569 -0400", hash_original_field = "330AF4349101FDC32C6AF684F9B992B1", hash_generated_field = "8961889328AF5E677CB9B441A72BB954")

    private HashMap<Integer, Bitmap> mIconsCache = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.570 -0400", hash_original_method = "FC71F40EA342EA47A36AF8D952C946AD", hash_generated_method = "0F65BF68C15C8D96248718D76E5118C9")
    private  IconLoader(Looper looper , IccFileHandler fh) {
        super(looper);
        mSimFH = fh;
        mIconsCache = new HashMap<Integer, Bitmap>(50);
        addTaint(looper.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.570 -0400", hash_original_method = "E56E284105F777D8A6CAB7DB3EDAC84F", hash_generated_method = "B6ACC3FC0029FE1701705E3A5139F568")
     void loadIcons(int[] recordNumbers, Message msg) {
        mEndMsg = msg;
        mIcons = new Bitmap[recordNumbers.length];
        mRecordNumbers = recordNumbers;
        mCurrentRecordIndex = 0;
        mState = STATE_MULTI_ICONS;
        startLoadingIcon(recordNumbers[0]);
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.571 -0400", hash_original_method = "328A1F48C7F5C3C618F7E134C6DE5C8B", hash_generated_method = "699168182308EFE2FB0864C4782A74DF")
     void loadIcon(int recordNumber, Message msg) {
        mEndMsg = msg;
        mState = STATE_SINGLE_ICON;
        startLoadingIcon(recordNumber);
        addTaint(recordNumber);
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.571 -0400", hash_original_method = "CF2A7740DA96FFBF2B7742A73D5B85D3", hash_generated_method = "98097E7CEA94E78C6737FDF9A2B4538F")
    private void startLoadingIcon(int recordNumber) {
        mId = null;
        mIconData = null;
        mCurrentIcon = null;
        mRecordNumber = recordNumber;
        {
            boolean varDE81173A3DD1F6D6B038C86AB5DCBBC3_1037519460 = (mIconsCache.containsKey(recordNumber));
            {
                mCurrentIcon = mIconsCache.get(recordNumber);
                postIcon();
            } 
        } 
        readId();
        
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.572 -0400", hash_original_method = "E1BF715B9C953843C5BFB563C24D3B0D", hash_generated_method = "8CE620C914EB1090F1087FF33A90E6A7")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        try 
        {
            
            ar = (AsyncResult) msg.obj;
            
            
            {
                boolean var166F9F3229813452CC65C23DFD03D3DF_983871874 = (handleImageDescriptor((byte[]) ar.result));
                {
                    readIconData();
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new Exception("Unable to parse image descriptor");
                } 
            } 
            
            
            ar = (AsyncResult) msg.obj;
            
            
            byte[] rawData = ((byte[]) ar.result);
            
            
            {
                mCurrentIcon = parseToBnW(rawData, rawData.length);
                mIconsCache.put(mRecordNumber, mCurrentIcon);
                postIcon();
            } 
            {
                mIconData = rawData;
                readClut();
            } 
            
            
            ar = (AsyncResult) msg.obj;
            
            
            byte [] clut = ((byte[]) ar.result);
            
            
            mCurrentIcon = parseToRGB(mIconData, mIconData.length,
                        false, clut);
            
            
            mIconsCache.put(mRecordNumber, mCurrentIcon);
            
            
            postIcon();
            
        } 
        catch (Exception e)
        {
            CatLog.d(this, "Icon load failed");
            postIcon();
        } 
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.573 -0400", hash_original_method = "57AAD79E24539ED69C4A9588C1A4DBA1", hash_generated_method = "872F39B7AA4366160BEBEDE02D000339")
    private boolean handleImageDescriptor(byte[] rawData) {
        mId = ImageDescriptor.parse(rawData, 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348010813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_348010813;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.573 -0400", hash_original_method = "78AA98F6413EBAF06D9D3065D89FA10B", hash_generated_method = "B3A123CBAF95CDF1AAC90C96EAD2F3C8")
    private void readClut() {
        int length = mIconData[3] * CLUT_ENTRY_SIZE;
        Message msg = this.obtainMessage(EVENT_READ_CLUT_DONE);
        mSimFH.loadEFImgTransparent(mId.imageId,
                mIconData[CLUT_LOCATION_OFFSET],
                mIconData[CLUT_LOCATION_OFFSET + 1], length, msg);
        
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.574 -0400", hash_original_method = "9B2E1F9D86B0BE7AA9984F6F6998AD1A", hash_generated_method = "AC7CDA5851E7E6263A1C72AF223F9E64")
    private void readId() {
        {
            mCurrentIcon = null;
            postIcon();
        } 
        Message msg = this.obtainMessage(EVENT_READ_EF_IMG_RECOED_DONE);
        mSimFH.loadEFImgLinearFixed(mRecordNumber, msg);
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.574 -0400", hash_original_method = "E5FF0727F4A23FBA52C74807E31F642C", hash_generated_method = "35743DA67D5D7862E0114E3AE4CC1E79")
    private void readIconData() {
        Message msg = this.obtainMessage(EVENT_READ_ICON_DONE);
        mSimFH.loadEFImgTransparent(mId.imageId, 0, 0, mId.length ,msg);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.575 -0400", hash_original_method = "2C2351D604337717A113511ACF501262", hash_generated_method = "3BBCA77ECF8B0A8BF92BF330C4F98D46")
    private void postIcon() {
        {
            mEndMsg.obj = mCurrentIcon;
            mEndMsg.sendToTarget();
        } 
        {
            mIcons[mCurrentRecordIndex++] = mCurrentIcon;
            {
                startLoadingIcon(mRecordNumbers[mCurrentRecordIndex]);
            } 
            {
                mEndMsg.obj = mIcons;
                mEndMsg.sendToTarget();
            } 
        } 
        
        
            
            
        
            
            
                
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static int bitToBnW(int bit) {
        if(bit == 1){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "2383C5F129032F33DA642165345E6FE5", hash_generated_field = "81EC33A739284D15A326AED6A69F224E")

    private static IconLoader sLoader = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "57D20619D1ADC0F3C1464FACFD33041B", hash_generated_field = "D01A6F849D09BA82DD97BA1D8717EC58")

    private static final int STATE_SINGLE_ICON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "2E0B894CF6909D6B66C53C0F327DBB02", hash_generated_field = "33544B92131C82893E35396C5ECA7589")

    private static final int STATE_MULTI_ICONS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "839AA6DBABEFE553CE7C961842CB9FE6", hash_generated_field = "0D80FB9FDA8A6837BB3BE8B7C9E0BA4B")

    private static final int EVENT_READ_EF_IMG_RECOED_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "94A2120BD767086BCE682B84A3650BD9", hash_generated_field = "EFCD2E00E5FDB44DF1B199DC277FDC66")

    private static final int EVENT_READ_ICON_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "FD98309EDAC8A47631964D55E3BB8187", hash_generated_field = "B846C390A0623DCBB7AC15A8B2D5824E")

    private static final int EVENT_READ_CLUT_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "09897846512E90C7E0926A557CDF84D3", hash_generated_field = "3B0A1E53A488A72F02012F8ACD3D744C")

    private static final int CLUT_LOCATION_OFFSET = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.577 -0400", hash_original_field = "73D750EA6EC631EF7B2D42C7D9E50B90", hash_generated_field = "FBE878DE7996E8296B61C24CEDCE7575")

    private static final int CLUT_ENTRY_SIZE = 3;
}

