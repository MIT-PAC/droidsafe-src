package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class Bitmap implements Parcelable {
    public static final int DENSITY_NONE = 0;
    public /* final */ int mNativeBitmap;
    public byte[] mBuffer;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) 
    private /* final */ BitmapFinalizer mFinalizer;
    private /* final */ boolean mIsMutable;
    private byte[] mNinePatchChunk;
    private int mWidth = -1;
    private int mHeight = -1;
    private boolean mRecycled;
    int mDensity = sDefaultDensity = getDefaultDensity();
    private static volatile Matrix sScaleMatrix;
    private static volatile int sDefaultDensity = -1;
    private final static int WORKING_COMPRESS_STORAGE = 4096;
    
    @DSModeled(DSC.BAN) // Created to support native methods that return Bitmap
    public Bitmap() {
		// TODO Auto-generated constructor stub
	}
    
    public static final Parcelable.Creator<Bitmap> CREATOR = new Parcelable.Creator<Bitmap>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.931 -0400", hash_original_method = "A576610C1F5A8AE8D31C4E9A14C2AA39", hash_generated_method = "18083567215B21F412D30C29339E5AA6")
        @DSModeled(DSC.SAFE)
        public Bitmap createFromParcel(Parcel p) {
            dsTaint.addTaint(p.dsTaint);
            Bitmap bm;
            bm = nativeCreateFromParcel(p);
            if (DroidSafeAndroidRuntime.control)
            {
                throw new RuntimeException("Failed to unparcel Bitmap");
            } //End block
            return (Bitmap)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bitmap bm = nativeCreateFromParcel(p);
            //if (bm == null) {
                //throw new RuntimeException("Failed to unparcel Bitmap");
            //}
            //return bm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.931 -0400", hash_original_method = "9D41A73AB5270B44257816A57AEF6E94", hash_generated_method = "9F6ACA21E555B39E4ED1130778F14C07")
        @DSModeled(DSC.SAFE)
        public Bitmap[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Bitmap[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Bitmap[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.931 -0400", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "D57244C538D69D9DDAF91059B9C479B2")
    @DSModeled(DSC.SAFE)
     Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk,
            int density) {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(isMutable);
        dsTaint.addTaint(density);
        dsTaint.addTaint(nativeBitmap);
        dsTaint.addTaint(ninePatchChunk);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new RuntimeException("internal error: native bitmap is 0");
        } //End block
        mFinalizer = new BitmapFinalizer(nativeBitmap);
        // ---------- Original Method ----------
        //if (nativeBitmap == 0) {
            //throw new RuntimeException("internal error: native bitmap is 0");
        //}
        //mBuffer = buffer;
        //mNativeBitmap = nativeBitmap;
        //mFinalizer = new BitmapFinalizer(nativeBitmap);
        //mIsMutable = isMutable;
        //mNinePatchChunk = ninePatchChunk;
        //if (density >= 0) {
            //mDensity = density;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.932 -0400", hash_original_method = "B71B8E0736B550F2E28E3A81592DC389", hash_generated_method = "BD8D5DF9B38E5690B0479B016893F0D8")
    public static void setDefaultDensity(int density) {
        sDefaultDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.932 -0400", hash_original_method = "E8FCDB013EBE57EEE864D06A44E64265", hash_generated_method = "B3DA9FCCEA9F2AB0232A3F5C8CDBC9F7")
    static int getDefaultDensity() {
        if (sDefaultDensity >= 0) {
            return sDefaultDensity;
        }
        sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
        return sDefaultDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.932 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "51432277FCC7B4EB235DC0C983B8AFA3")
    @DSModeled(DSC.SAFE)
    public int getDensity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.932 -0400", hash_original_method = "9862D9E59C2B168AB35D015A9ED81A18", hash_generated_method = "41E6A786282AFA6C7A9FBB41896172DA")
    @DSModeled(DSC.SAFE)
    public void setDensity(int density) {
        dsTaint.addTaint(density);
        // ---------- Original Method ----------
        //mDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.932 -0400", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "2D85AD11CC50360897EFCA73111D8326")
    @DSModeled(DSC.SAFE)
    public void setNinePatchChunk(byte[] chunk) {
        dsTaint.addTaint(chunk);
        // ---------- Original Method ----------
        //mNinePatchChunk = chunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.932 -0400", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "D7066F9983B68C7BDDB14F66047F29D0")
    @DSModeled(DSC.SAFE)
    public void recycle() {
        {
            mBuffer = null;
            nativeRecycle(mNativeBitmap);
            mNinePatchChunk = null;
            mRecycled = true;
        } //End block
        // ---------- Original Method ----------
        //if (!mRecycled) {
            //mBuffer = null;
            //nativeRecycle(mNativeBitmap);
            //mNinePatchChunk = null;
            //mRecycled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.933 -0400", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "E62065DC626EFCB872C4634F0D8D1F52")
    @DSModeled(DSC.SAFE)
    public final boolean isRecycled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRecycled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.933 -0400", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "0216EF79D3FA3DF09E4AC7CD83115470")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getGenerationId() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int var212795BBF0B899D6098254B7268EC186_786353795 = (nativeGenerationId(mNativeBitmap));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGenerationId(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.933 -0400", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "0DF4D0EDBB68002E7E64A58A52412838")
    @DSModeled(DSC.SAFE)
    private void checkRecycled(String errorMessage) {
        dsTaint.addTaint(errorMessage);
        {
            throw new IllegalStateException(errorMessage);
        } //End block
        // ---------- Original Method ----------
        //if (mRecycled) {
            //throw new IllegalStateException(errorMessage);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.933 -0400", hash_original_method = "D40C73AF8AE1E0F0F229FF274F9DE7E5", hash_generated_method = "14CB1ECB646B90D7A8DFB5948E78C4F9")
    private static void checkXYSign(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.933 -0400", hash_original_method = "99B682048D7DD6F5E24E9EE3CDE8B326", hash_generated_method = "FC25CC9E9401E5DB446A7AA86CBFDC89")
    private static void checkWidthHeight(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.933 -0400", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "FE16C53937993BE72A824B89A040981A")
    @DSModeled(DSC.SAFE)
    public void copyPixelsToBuffer(Buffer dst) {
        dsTaint.addTaint(dst.dsTaint);
        int elements;
        elements = dst.remaining();
        int shift;
        {
            shift = 0;
        } //End block
        {
            shift = 1;
        } //End block
        {
            shift = 2;
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new RuntimeException("unsupported Buffer subclass");
        } //End block
        long bufferSize;
        bufferSize = (long)elements << shift;
        long pixelSize;
        pixelSize = getByteCount();
        if (DroidSafeAndroidRuntime.control)
        {
            throw new RuntimeException("Buffer not large enough for pixels");
        } //End block
        nativeCopyPixelsToBuffer(mNativeBitmap, dst);
        int position;
        position = dst.position();
        position += pixelSize >> shift;
        dst.position(position);
        // ---------- Original Method ----------
        //int elements = dst.remaining();
        //int shift;
        //if (dst instanceof ByteBuffer) {
            //shift = 0;
        //} else if (dst instanceof ShortBuffer) {
            //shift = 1;
        //} else if (dst instanceof IntBuffer) {
            //shift = 2;
        //} else {
            //throw new RuntimeException("unsupported Buffer subclass");
        //}
        //long bufferSize = (long)elements << shift;
        //long pixelSize = getByteCount();
        //if (bufferSize < pixelSize) {
            //throw new RuntimeException("Buffer not large enough for pixels");
        //}
        //nativeCopyPixelsToBuffer(mNativeBitmap, dst);
        //int position = dst.position();
        //position += pixelSize >> shift;
        //dst.position(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.934 -0400", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "FC1B6A214B1DAFCAF494407F29755748")
    @DSModeled(DSC.SAFE)
    public void copyPixelsFromBuffer(Buffer src) {
        dsTaint.addTaint(src.dsTaint);
        checkRecycled("copyPixelsFromBuffer called on recycled bitmap");
        int elements;
        elements = src.remaining();
        int shift;
        {
            shift = 0;
        } //End block
        {
            shift = 1;
        } //End block
        {
            shift = 2;
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new RuntimeException("unsupported Buffer subclass");
        } //End block
        long bufferBytes;
        bufferBytes = (long)elements << shift;
        long bitmapBytes;
        bitmapBytes = getByteCount();
        if (DroidSafeAndroidRuntime.control)
        {
            throw new RuntimeException("Buffer not large enough for pixels");
        } //End block
        nativeCopyPixelsFromBuffer(mNativeBitmap, src);
        // ---------- Original Method ----------
        //checkRecycled("copyPixelsFromBuffer called on recycled bitmap");
        //int elements = src.remaining();
        //int shift;
        //if (src instanceof ByteBuffer) {
            //shift = 0;
        //} else if (src instanceof ShortBuffer) {
            //shift = 1;
        //} else if (src instanceof IntBuffer) {
            //shift = 2;
        //} else {
            //throw new RuntimeException("unsupported Buffer subclass");
        //}
        //long bufferBytes = (long)elements << shift;
        //long bitmapBytes = getByteCount();
        //if (bufferBytes < bitmapBytes) {
            //throw new RuntimeException("Buffer not large enough for pixels");
        //}
        //nativeCopyPixelsFromBuffer(mNativeBitmap, src);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.934 -0400", hash_original_method = "5A36626FB0A5325F859AD016AE482420", hash_generated_method = "C982878374128EB2DAF0D6AAE7A31F20")
    @DSModeled(DSC.SAFE)
    public Bitmap copy(Config config, boolean isMutable) {
        dsTaint.addTaint(isMutable);
        dsTaint.addTaint(config.dsTaint);
        checkRecycled("Can't copy a recycled bitmap");
        Bitmap b;
        b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
        {
            b.mDensity = mDensity;
        } //End block
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkRecycled("Can't copy a recycled bitmap");
        //Bitmap b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
        //if (b != null) {
            //b.mDensity = mDensity;
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.934 -0400", hash_original_method = "9B9D815856FF54261FC90101B85ADFB3", hash_generated_method = "0A69DC0F6E1BDA2B58B3DD24D4CED5C7")
    public static Bitmap createScaledBitmap(Bitmap src, int dstWidth,
            int dstHeight, boolean filter) {
        Matrix m;
        synchronized (Bitmap.class) {
            m = sScaleMatrix;
            sScaleMatrix = null;
        }
        if (m == null) {
            m = new Matrix();
        }
        final int width = src.getWidth();
        final int height = src.getHeight();
        final float sx = dstWidth  / (float)width;
        final float sy = dstHeight / (float)height;
        m.setScale(sx, sy);
        Bitmap b = Bitmap.createBitmap(src, 0, 0, width, height, m, filter);
        synchronized (Bitmap.class) {
            if (sScaleMatrix == null) {
                sScaleMatrix = m;
            }
        }
        return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.934 -0400", hash_original_method = "06B3F44E32866DFBBA409CE7EBE78C90", hash_generated_method = "69140569706508A2D71FA6D606AC28D8")
    public static Bitmap createBitmap(Bitmap src) {
        return createBitmap(src, 0, 0, src.getWidth(), src.getHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.934 -0400", hash_original_method = "FDCB5D0AAFA9E01A4FEEBED763708DF4", hash_generated_method = "0310C45601B1271997169FB3A2B77AE7")
    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height) {
        return createBitmap(source, x, y, width, height, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.934 -0400", hash_original_method = "2890F109635B7BA47A6C3B31AD4C0C33", hash_generated_method = "224327EF7ED50CCD979BC65FDC260FCE")
    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height,
            Matrix m, boolean filter) {
        checkXYSign(x, y);
        checkWidthHeight(width, height);
        if (x + width > source.getWidth()) {
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        }
        if (y + height > source.getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }
        if (!source.isMutable() && x == 0 && y == 0 && width == source.getWidth() &&
                height == source.getHeight() && (m == null || m.isIdentity())) {
            return source;
        }
        int neww = width;
        int newh = height;
        Canvas canvas = new Canvas();
        Bitmap bitmap;
        Paint paint;
        Rect srcR = new Rect(x, y, x + width, y + height);
        RectF dstR = new RectF(0, 0, width, height);
        Config newConfig = Config.ARGB_8888;
        final Config config = source.getConfig();
        if (config != null) {
            switch (config) {
                case RGB_565:
                    newConfig = Config.RGB_565;
                    break;
                case ALPHA_8:
                    newConfig = Config.ALPHA_8;
                    break;
                case ARGB_4444:
                case ARGB_8888:
                default:
                    newConfig = Config.ARGB_8888;
                    break;
            }
        }
        if (m == null || m.isIdentity()) {
            bitmap = createBitmap(neww, newh, newConfig, source.hasAlpha());
            paint = null;   
        } else {
            final boolean transformed = !m.rectStaysRect();
            RectF deviceR = new RectF();
            m.mapRect(deviceR, dstR);
            neww = Math.round(deviceR.width());
            newh = Math.round(deviceR.height());
            bitmap = createBitmap(neww, newh, transformed ? Config.ARGB_8888 : newConfig,
                    transformed || source.hasAlpha());
            canvas.translate(-deviceR.left, -deviceR.top);
            canvas.concat(m);
            paint = new Paint();
            paint.setFilterBitmap(filter);
            if (transformed) {
                paint.setAntiAlias(true);
            }
        }
        bitmap.mDensity = source.mDensity;
        canvas.setBitmap(bitmap);
        canvas.drawBitmap(source, srcR, dstR, paint);
        canvas.setBitmap(null);
        return bitmap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "A69C1A6B363DCF14C299E4864CF77D03", hash_generated_method = "6FF2BF773051FD6D6A1B48DF50C9FDD4")
    public static Bitmap createBitmap(int width, int height, Config config) {
        return createBitmap(width, height, config, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "C32676B0CF17A453879FC2F6E3E2191B", hash_generated_method = "34D011475E80C0F727A31DFA288C1FB9")
    private static Bitmap createBitmap(int width, int height, Config config, boolean hasAlpha) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        Bitmap bm = nativeCreate(null, 0, width, width, height, config.nativeInt, true);
        if (config == Config.ARGB_8888 && !hasAlpha) {
            nativeErase(bm.mNativeBitmap, 0xff000000);
            nativeSetHasAlpha(bm.mNativeBitmap, hasAlpha);
        } else {
        }
        return bm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "3025C3F86E2BC308BDBF4BB36F710549", hash_generated_method = "C5B6A54165DF6B416215E521BC50CE65")
    public static Bitmap createBitmap(int colors[], int offset, int stride,
            int width, int height, Config config) {
        checkWidthHeight(width, height);
        if (Math.abs(stride) < width) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }
        int lastScanline = offset + (height - 1) * stride;
        int length = colors.length;
        if (offset < 0 || (offset + width > length) || lastScanline < 0 ||
                (lastScanline + width > length)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        return nativeCreate(colors, offset, stride, width, height,
                            config.nativeInt, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "0687CE6A4B07D857B75A84209513431A", hash_generated_method = "26A1CBF4DD06B2FCE6D7F82EE8B64B69")
    public static Bitmap createBitmap(int colors[], int width, int height, Config config) {
        return createBitmap(colors, 0, width, width, height, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "C008B31DDCF5AFC2944E56F46F476A85")
    @DSModeled(DSC.SAFE)
    public byte[] getNinePatchChunk() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mNinePatchChunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "AA1DFFA2B4ADAC17944B6F2B45C6104F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(quality);
        dsTaint.addTaint(format.dsTaint);
        checkRecycled("Can't compress a recycled bitmap");
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException();
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("quality must be 0..100");
        } //End block
        boolean varF801D4584D511A06756607336723DBB1_539461545 = (nativeCompress(mNativeBitmap, format.nativeInt, quality,
                              stream, new byte[WORKING_COMPRESS_STORAGE]));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkRecycled("Can't compress a recycled bitmap");
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //if (quality < 0 || quality > 100) {
            //throw new IllegalArgumentException("quality must be 0..100");
        //}
        //return nativeCompress(mNativeBitmap, format.nativeInt, quality,
                              //stream, new byte[WORKING_COMPRESS_STORAGE]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.935 -0400", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "AD05C996EA79F3A97AB3A51CCE0D200C")
    @DSModeled(DSC.SAFE)
    public final boolean isMutable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsMutable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "9273E6434E2E49D8D6A7BEF0351E82F0", hash_generated_method = "D621E129F4FE6BF37983EAB73DF5FA9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getWidth() {
        {
            Object var14BFC634F145725DC48467A508F60C75_530763425 = (mWidth = nativeWidth(mNativeBitmap));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth == -1 ? mWidth = nativeWidth(mNativeBitmap) : mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "C9C832E0F45CC5A7AD0241E8F16710F4", hash_generated_method = "D3B90B5E41E385A82C6887CACE2DCDFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getHeight() {
        {
            Object varA90DB7D8C83D02A678AC88E3CF32E02C_1274555419 = (mHeight = nativeHeight(mNativeBitmap));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeight == -1 ? mHeight = nativeHeight(mNativeBitmap) : mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "993B3AD1528B9C58A61781F8EC2AC686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledWidth(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int varD244B19BB376C166F704354639F6FD2A_1198812937 = (scaleFromDensity(getWidth(), mDensity, canvas.mDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "267203A03820ECC78B485FFFFD4C4DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledHeight(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int var9C7679314AF2CB28ACC9E6D9F7DBE7C8_1195965913 = (scaleFromDensity(getHeight(), mDensity, canvas.mDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "A954EE536BC89663F1022D825F24B628")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledWidth(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        int var22DDB9F91A59073EC3D37288D06D89F5_149580284 = (scaleFromDensity(getWidth(), mDensity, metrics.densityDpi));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "7125702811F1858D1E12F6FD894942BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledHeight(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        int varBC7E5446A696D0B9C3151FDCC509001B_573932324 = (scaleFromDensity(getHeight(), mDensity, metrics.densityDpi));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.936 -0400", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "A396E9FBA3F695B1BCEECB091D5E6439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledWidth(int targetDensity) {
        dsTaint.addTaint(targetDensity);
        int var40BBFFD6794B3ABECF2108DE9A398793_334921694 = (scaleFromDensity(getWidth(), mDensity, targetDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, targetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "9CF0C325D1B5065DB1555FC6D8992A16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledHeight(int targetDensity) {
        dsTaint.addTaint(targetDensity);
        int varEBBA22F03E55C884FB7BC5702A806353_537603614 = (scaleFromDensity(getHeight(), mDensity, targetDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, targetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "2A2576D052362766C414172B545A5E98", hash_generated_method = "C2C77F1F58A3BDBD6550686C8A984042")
    static public int scaleFromDensity(int size, int sdensity, int tdensity) {
        if (sdensity == DENSITY_NONE || sdensity == tdensity) {
            return size;
        }
        return ((size * tdensity) + (sdensity >> 1)) / sdensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "31B2EB1CFACBCB1B342C70C4626AA2D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getRowBytes() {
        int var0267412FC813FD8E20B12B849B0C1F93_159413938 = (nativeRowBytes(mNativeBitmap));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeRowBytes(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "6D0F174BBCB9842A57125F72A72E9FCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getByteCount() {
        int var18558EEEC9B7BD46FC1B51B2AC00445A_2043480111 = (getRowBytes() * getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getRowBytes() * getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "CB7ECB7B329AA6EA5A6916F0AFABCF73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Config getConfig() {
        Config var256D15F1266556B864D532B889452985_997836304 = (Config.nativeToConfig(nativeConfig(mNativeBitmap)));
        return (Config)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "A9E6FFBE96B704702B1F2A7EDD472B86", hash_generated_method = "32B59369A1B4B857577929CDF2E0F7B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasAlpha() {
        boolean var800F787096C2FAD492BB45AE9E7A91D2_1209175987 = (nativeHasAlpha(mNativeBitmap));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeHasAlpha(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "9BF8F5FAA617B68A4287E64028C24BC4", hash_generated_method = "F77271A1A8A174A0939499FC5B82C38E")
    @DSModeled(DSC.SAFE)
    public void setHasAlpha(boolean hasAlpha) {
        dsTaint.addTaint(hasAlpha);
        nativeSetHasAlpha(mNativeBitmap, hasAlpha);
        // ---------- Original Method ----------
        //nativeSetHasAlpha(mNativeBitmap, hasAlpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.937 -0400", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "93C61D2AE8091BC2DA2FE38CF2BCEAD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void eraseColor(int c) {
        dsTaint.addTaint(c);
        checkRecycled("Can't erase a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_487526057 = (!isMutable());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalStateException("cannot erase immutable bitmaps");
            } //End block
        } //End collapsed parenthetic
        nativeErase(mNativeBitmap, c);
        // ---------- Original Method ----------
        //checkRecycled("Can't erase a recycled bitmap");
        //if (!isMutable()) {
            //throw new IllegalStateException("cannot erase immutable bitmaps");
        //}
        //nativeErase(mNativeBitmap, c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.938 -0400", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "5769205DCDD298DD5D9C0A4A7DF9E8F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPixel(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(x, y);
        int var8FD6BA845BC7C15EFB43BAC7ED016EA5_963985130 = (nativeGetPixel(mNativeBitmap, x, y));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixel() on a recycled bitmap");
        //checkPixelAccess(x, y);
        //return nativeGetPixel(mNativeBitmap, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.938 -0400", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "F75FDD4F8DD135E95660CDE00A4671AA")
    @DSModeled(DSC.SAFE)
    public void getPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(pixels);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call getPixels() on a recycled bitmap");
        checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        nativeGetPixels(mNativeBitmap, pixels, offset, stride,
                        x, y, width, height);
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixels() on a recycled bitmap");
        //if (width == 0 || height == 0) {
            //return; 
        //}
        //checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        //nativeGetPixels(mNativeBitmap, pixels, offset, stride,
                        //x, y, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.938 -0400", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "2C4FDE50AD06075DD50865C80EE7CD4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkPixelAccess(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkXYSign(x, y);
        {
            boolean var30490CFCBE0CDDF5A434370B1DCE4F74_1231980976 = (x >= getWidth());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException("x must be < bitmap.width()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var176BE51140078B0967F59852B69E3131_730407417 = (y >= getHeight());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException("y must be < bitmap.height()");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkXYSign(x, y);
        //if (x >= getWidth()) {
            //throw new IllegalArgumentException("x must be < bitmap.width()");
        //}
        //if (y >= getHeight()) {
            //throw new IllegalArgumentException("y must be < bitmap.height()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.938 -0400", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "1C717B97EBDF2FB0BD0D79C5849376C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkPixelsAccess(int x, int y, int width, int height,
                                   int offset, int stride, int pixels[]) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pixels);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkXYSign(x, y);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("width must be >= 0");
        } //End block
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("height must be >= 0");
        } //End block
        {
            boolean varD810B239D6120F6BE5AD1443109E34E9_737957134 = (x + width > getWidth());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException(
                    "x + width must be <= bitmap.width()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var81DF503DAA371D07CDBF07C44BC00011_1951079885 = (y + height > getHeight());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException(
                    "y + height must be <= bitmap.height()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE73A6561371F12118506FC78AF1B9D6D_413014370 = (Math.abs(stride) < width);
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalArgumentException("abs(stride) must be >= width");
            } //End block
        } //End collapsed parenthetic
        int lastScanline;
        lastScanline = offset + (height - 1) * stride;
        int length;
        length = pixels.length;
        {
            throw new ArrayIndexOutOfBoundsException();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.938 -0400", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "0B74E42E80DBBA6B2EEB9857EA9E06C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPixel(int x, int y, int color) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_1136360059 = (!isMutable());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalStateException();
            } //End block
        } //End collapsed parenthetic
        checkPixelAccess(x, y);
        nativeSetPixel(mNativeBitmap, x, y, color);
        // ---------- Original Method ----------
        //checkRecycled("Can't call setPixel() on a recycled bitmap");
        //if (!isMutable()) {
            //throw new IllegalStateException();
        //}
        //checkPixelAccess(x, y);
        //nativeSetPixel(mNativeBitmap, x, y, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.939 -0400", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "39D3671A9C27DD1825D559D541313856")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(pixels);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_355873281 = (!isMutable());
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new IllegalStateException();
            } //End block
        } //End collapsed parenthetic
        checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        nativeSetPixels(mNativeBitmap, pixels, offset, stride,
                        x, y, width, height);
        // ---------- Original Method ----------
        //checkRecycled("Can't call setPixels() on a recycled bitmap");
        //if (!isMutable()) {
            //throw new IllegalStateException();
        //}
        //if (width == 0 || height == 0) {
            //return; 
        //}
        //checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        //nativeSetPixels(mNativeBitmap, pixels, offset, stride,
                        //x, y, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.939 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.939 -0400", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "88FA088EABC25B9A18A18849A369A048")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel p, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(p.dsTaint);
        checkRecycled("Can't parcel a recycled bitmap");
        {
            boolean var5DF242B1AD49EA84F890A63696D1516F_310990640 = (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p));
	        if (DroidSafeAndroidRuntime.control)
            {
                throw new RuntimeException("native writeToParcel failed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkRecycled("Can't parcel a recycled bitmap");
        //if (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p)) {
            //throw new RuntimeException("native writeToParcel failed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.939 -0400", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "106EF9005B92151773A5AEF850AA8474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap extractAlpha() {
        Bitmap varE5990E664B6EA7B07F751ED44580655F_223849913 = (extractAlpha(null, null));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return extractAlpha(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.939 -0400", hash_original_method = "798FC3DD232FCC4B06F4415625A8D213", hash_generated_method = "7E43F86216E295E61DFE92E6F88EB565")
    @DSModeled(DSC.SAFE)
    public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
        dsTaint.addTaint(offsetXY);
        dsTaint.addTaint(paint.dsTaint);
        checkRecycled("Can't extractAlpha on a recycled bitmap");
        int nativePaint;
        nativePaint = paint.mNativePaint;
        nativePaint = 0;
        Bitmap bm;
        bm = nativeExtractAlpha(mNativeBitmap, nativePaint, offsetXY);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new RuntimeException("Failed to extractAlpha on Bitmap");
        } //End block
        bm.mDensity = mDensity;
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkRecycled("Can't extractAlpha on a recycled bitmap");
        //int nativePaint = paint != null ? paint.mNativePaint : 0;
        //Bitmap bm = nativeExtractAlpha(mNativeBitmap, nativePaint, offsetXY);
        //if (bm == null) {
            //throw new RuntimeException("Failed to extractAlpha on Bitmap");
        //}
        //bm.mDensity = mDensity;
        //return bm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.939 -0400", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "AB4A4BC73096D72738FF331526319600")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sameAs(Bitmap other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var573FBB3F9978D0C6C4756653011FAC34_120500839 = (this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "54DE2F2F73CFD7A2AB77A019CF005EEB")
    @DSModeled(DSC.SAFE)
    public void prepareToDraw() {
        nativePrepareToDraw(mNativeBitmap);
        // ---------- Original Method ----------
        //nativePrepareToDraw(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "E55FDC3E006F5C77E42344F79874464A", hash_generated_method = "D1F2B5AD16523432E5B64866C07D7585")
    private static Bitmap nativeCreate(int[] colors, int offset,
                                              int stride, int width, int height,
                                            int nativeConfig, boolean mutable) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "45D4381D1EA2485216945540030C26AB", hash_generated_method = "0DB934118DD62A8C71A2979C480717AB")
    private static Bitmap nativeCopy(int srcBitmap, int nativeConfig,
                                            boolean isMutable) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "E3ED43568C09C79C93191CC5C62576E8", hash_generated_method = "E7DA128ADD85C3F53AA1CE4D807C24CB")
    private static void nativeDestructor(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "EAC2C74B0DDAACA564B4FEDC50474303", hash_generated_method = "B314B89DC61434B5874CBEAD7BAB781F")
    private static void nativeRecycle(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "7622C88430D0083362C5A45EFCD7C50B", hash_generated_method = "638712C04593F1144B9E5E5E02D3E1F7")
    private static boolean nativeCompress(int nativeBitmap, int format,
                                            int quality, OutputStream stream,
                                            byte[] tempStorage) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "D8A777FF80145B93D573CA5FBFBFF540", hash_generated_method = "9607714F26A3600E62D21D08E9D52434")
    private static void nativeErase(int nativeBitmap, int color) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "904945A5B141851798E063E1803A5F04", hash_generated_method = "7D5571C65C276F5B4BB2F63DA60BF5BA")
    private static int nativeWidth(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "97B2ABABD688843FB18A94CF0447DEFD", hash_generated_method = "86690DDED79189EDB69FA6D16D0639C2")
    private static int nativeHeight(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "1C20704BA122DB6BDC5DC60359E85F4F", hash_generated_method = "5FFE99272D7A94FB701D17F94D378E62")
    private static int nativeRowBytes(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "F834D3C6FDF94C2FD5997EC80647C823", hash_generated_method = "B486DF67F3B633BA5237FAC517D09960")
    private static int nativeConfig(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.940 -0400", hash_original_method = "F46C7650077695308A7525A296A3C7D3", hash_generated_method = "8ED49DB63B06521B81762E07D2A705D0")
    private static boolean nativeHasAlpha(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "9E1F2375582A6D02B837E73A5143D79A", hash_generated_method = "29B9240FD6C10A09EAF9540B53B4A979")
    private static int nativeGetPixel(int nativeBitmap, int x, int y) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "4EBA397B05B5A079E2884BC981F23BC3", hash_generated_method = "7102A1C14F9A7321EDE12D813E05ECCD")
    private static void nativeGetPixels(int nativeBitmap, int[] pixels,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "E903262E60E5ED485DFB9CCCDD1DDFDF", hash_generated_method = "969380D8D99253C15CF68BD9CAF14C4A")
    private static void nativeSetPixel(int nativeBitmap, int x, int y,
                                              int color) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "9B26FCEE48C38275291B7C91C0A11454", hash_generated_method = "A8B8E9E7AFA26AD6A30239657BFA026C")
    private static void nativeSetPixels(int nativeBitmap, int[] colors,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "F2E8FEC281E44E430CB30E6CE486A5BB", hash_generated_method = "52E4DFAF7E590CAF6B19890BCCCA3798")
    private static void nativeCopyPixelsToBuffer(int nativeBitmap,
                                                        Buffer dst) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "BB56E9E6DCC632CBF97F66C7AD0A547E", hash_generated_method = "FFA138498DC80F2F0B27B05566753550")
    private static void nativeCopyPixelsFromBuffer(int nb, Buffer src) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "6885BAD84A1A4E36D99C3D1DCC7CCDA2", hash_generated_method = "36109B6199DDEE3F66E954D8DD5C6F26")
    private static int nativeGenerationId(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "BE5F630346E963472055577C84A85AC5", hash_generated_method = "D1698E3393DA9AAFF4E69831D50E755D")
    private static Bitmap nativeCreateFromParcel(Parcel p) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "B6523BE97780BEFBD3636971AB2B89A0", hash_generated_method = "35B135FC01F71CD929458686F13417D1")
    private static boolean nativeWriteToParcel(int nativeBitmap,
                                                      boolean isMutable,
                                                      int density,
                                                      Parcel p) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "BE3BD451DC9581772138C0661617C669", hash_generated_method = "9686A71E7A83AF422AA7E1912905A6DE")
    private static Bitmap nativeExtractAlpha(int nativeBitmap,
                                                    int nativePaint,
                                                    int[] offsetXY) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.941 -0400", hash_original_method = "0710BAA887D760924BA893BBEC19C688", hash_generated_method = "2EF89524AF8727B7C2A431B4B0B1E4F2")
    private static void nativePrepareToDraw(int nativeBitmap) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.942 -0400", hash_original_method = "937AADB8A3EFC644F590336B7B94DB27", hash_generated_method = "5054B7A70F62A8448CE7ABD682E2E065")
    private static void nativeSetHasAlpha(int nBitmap, boolean hasAlpha) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.942 -0400", hash_original_method = "5A9B1A09E3C5251A309F2D65A5E034CD", hash_generated_method = "13C51ADC3CAF263AB61488F4E61C76FD")
    private static boolean nativeSameAs(int nb0, int nb1) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.942 -0400", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "3F8E9628F299FC4D20005C08EE911EA4")
    @DSModeled(DSC.SAFE)
    final int ni() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNativeBitmap;
    }

    
    public enum Config {
        ALPHA_8     (2),
        RGB_565     (4),
        @Deprecated
        ARGB_4444   (5),
        ARGB_8888   (6);
        final int nativeInt;
        @SuppressWarnings({"deprecation"})
        private static Config sConfigs[] = {
            null, null, ALPHA_8, null, RGB_565, ARGB_4444, ARGB_8888
        };
        Config(int ni) {
            this.nativeInt = ni;
        }
        static Config nativeToConfig(int ni) {
            return sConfigs[ni];
        }
    }

    
    public enum CompressFormat {
        JPEG    (0),
        PNG     (1),
        WEBP    (2);
        CompressFormat(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    private static class BitmapFinalizer {
        private /* final */ int mNativeBitmap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.942 -0400", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "19D31848F1BFF1E88B4F60B8B865ADEB")
        @DSModeled(DSC.SAFE)
         BitmapFinalizer(int nativeBitmap) {
            dsTaint.addTaint(nativeBitmap);
            // ---------- Original Method ----------
            //mNativeBitmap = nativeBitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.942 -0400", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "5B264F3B031C3A0B0CA5D8C6D8364E11")
        @DSModeled(DSC.SAFE)
        @Override
        public void finalize() {
            try 
            {
                super.finalize();
            } //End block
            catch (Throwable t)
            { }
            finally 
            {
                nativeDestructor(mNativeBitmap);
            } //End block
            // ---------- Original Method ----------
            //try {
                //super.finalize();
            //} catch (Throwable t) {
            //} finally {
                //nativeDestructor(mNativeBitmap);
            //}
        }

        
    }


    
}


