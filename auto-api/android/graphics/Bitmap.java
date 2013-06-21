package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    public int mNativeBitmap;
    public byte[] mBuffer;
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) private BitmapFinalizer mFinalizer;
    private boolean mIsMutable;
    private byte[] mNinePatchChunk;
    private int mWidth = -1;
    private int mHeight = -1;
    private boolean mRecycled;
    int mDensity = sDefaultDensity = getDefaultDensity();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.065 -0400", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "500D11C2104EA6B3C76493159C5AD507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk,
            int density) {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(density);
        dsTaint.addTaint(isMutable);
        dsTaint.addTaint(nativeBitmap);
        dsTaint.addTaint(ninePatchChunk[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("internal error: native bitmap is 0");
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

    
        public static void setDefaultDensity(int density) {
        sDefaultDensity = density;
    }

    
        static int getDefaultDensity() {
        if (sDefaultDensity >= 0) {
            return sDefaultDensity;
        }
        sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
        return sDefaultDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.065 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "F9A8778C3CF83A7A00D23BEF3B0CD3EE")
    @DSModeled(DSC.SAFE)
    public int getDensity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.066 -0400", hash_original_method = "9862D9E59C2B168AB35D015A9ED81A18", hash_generated_method = "CFEB14DBAED3EFE1CBFA8F04F67D5F1C")
    @DSModeled(DSC.SAFE)
    public void setDensity(int density) {
        dsTaint.addTaint(density);
        // ---------- Original Method ----------
        //mDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.066 -0400", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "431627DB66CA686B9E1040F8F87C78D4")
    @DSModeled(DSC.SAFE)
    public void setNinePatchChunk(byte[] chunk) {
        dsTaint.addTaint(chunk[0]);
        // ---------- Original Method ----------
        //mNinePatchChunk = chunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.066 -0400", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "C80B2A72009FC42545A99B19062C110C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.067 -0400", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "673C8278F24B13FFE67BD8D596EE64CE")
    @DSModeled(DSC.SAFE)
    public final boolean isRecycled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRecycled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.067 -0400", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "45739089460558AD8AF8C1D3D65C2F55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getGenerationId() {
        int var212795BBF0B899D6098254B7268EC186_1166942019 = (nativeGenerationId(mNativeBitmap));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGenerationId(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.067 -0400", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "A5EA482D4BB4E2944057FDB11CCBEF97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkRecycled(String errorMessage) {
        dsTaint.addTaint(errorMessage);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(errorMessage);
        } //End block
        // ---------- Original Method ----------
        //if (mRecycled) {
            //throw new IllegalStateException(errorMessage);
        //}
    }

    
        private static void checkXYSign(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    
        private static void checkWidthHeight(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.068 -0400", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "C784F223A04A4F1EE64E40075B8EDA0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("unsupported Buffer subclass");
        } //End block
        long bufferSize;
        bufferSize = (long)elements << shift;
        long pixelSize;
        pixelSize = getByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Buffer not large enough for pixels");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.068 -0400", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "A9C90A76FCE4C4BC6BD5D684249D52C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("unsupported Buffer subclass");
        } //End block
        long bufferBytes;
        bufferBytes = (long)elements << shift;
        long bitmapBytes;
        bitmapBytes = getByteCount();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Buffer not large enough for pixels");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.069 -0400", hash_original_method = "5A36626FB0A5325F859AD016AE482420", hash_generated_method = "3140495151BC97FCB094ED86C0872405")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        public static Bitmap createBitmap(Bitmap src) {
        return createBitmap(src, 0, 0, src.getWidth(), src.getHeight());
    }

    
        public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height) {
        return createBitmap(source, x, y, width, height, null, false);
    }

    
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

    
        public static Bitmap createBitmap(int width, int height, Config config) {
        return createBitmap(width, height, config, true);
    }

    
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

    
        public static Bitmap createBitmap(int colors[], int width, int height, Config config) {
        return createBitmap(colors, 0, width, width, height, config);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.070 -0400", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "CD57EFC61F4FAB861053AF0D24518465")
    @DSModeled(DSC.SAFE)
    public byte[] getNinePatchChunk() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return mNinePatchChunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.071 -0400", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "69C59BC5DEAA491DB6B3BBE62E20E715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        dsTaint.addTaint(stream.dsTaint);
        dsTaint.addTaint(quality);
        dsTaint.addTaint(format.dsTaint);
        checkRecycled("Can't compress a recycled bitmap");
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("quality must be 0..100");
        } //End block
        boolean varF801D4584D511A06756607336723DBB1_958181756 = (nativeCompress(mNativeBitmap, format.nativeInt, quality,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.071 -0400", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "BF4420FEDAAD2070EDC0D1F8F8F135F6")
    @DSModeled(DSC.SAFE)
    public final boolean isMutable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsMutable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.072 -0400", hash_original_method = "9273E6434E2E49D8D6A7BEF0351E82F0", hash_generated_method = "FB6B6B69485064B309516681D234151B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getWidth() {
        {
            Object var14BFC634F145725DC48467A508F60C75_1433035666 = (mWidth = nativeWidth(mNativeBitmap));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mWidth == -1 ? mWidth = nativeWidth(mNativeBitmap) : mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.072 -0400", hash_original_method = "C9C832E0F45CC5A7AD0241E8F16710F4", hash_generated_method = "0279410E0EA9F500DADDCE0622C968D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getHeight() {
        {
            Object varA90DB7D8C83D02A678AC88E3CF32E02C_178462778 = (mHeight = nativeHeight(mNativeBitmap));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeight == -1 ? mHeight = nativeHeight(mNativeBitmap) : mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.073 -0400", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "AC473096221BBAF28217D21C164DF1C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledWidth(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int varD244B19BB376C166F704354639F6FD2A_1061019941 = (scaleFromDensity(getWidth(), mDensity, canvas.mDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.073 -0400", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "17B1AA62180C89701861B3C6E8A6E7B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledHeight(Canvas canvas) {
        dsTaint.addTaint(canvas.dsTaint);
        int var9C7679314AF2CB28ACC9E6D9F7DBE7C8_287472278 = (scaleFromDensity(getHeight(), mDensity, canvas.mDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.073 -0400", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "E847BC0196469505714FE1319617E0FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledWidth(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        int var22DDB9F91A59073EC3D37288D06D89F5_863373112 = (scaleFromDensity(getWidth(), mDensity, metrics.densityDpi));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.074 -0400", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "1B5EF4C291ABFC3C1E493C57C4F78B25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledHeight(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        int varBC7E5446A696D0B9C3151FDCC509001B_689535732 = (scaleFromDensity(getHeight(), mDensity, metrics.densityDpi));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.075 -0400", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "96B004B5781E8A4F70A6FC4C8A1BCC54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledWidth(int targetDensity) {
        dsTaint.addTaint(targetDensity);
        int var40BBFFD6794B3ABECF2108DE9A398793_112902177 = (scaleFromDensity(getWidth(), mDensity, targetDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, targetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.076 -0400", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "00E875954023CFEE28F845BDD0DFC6E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getScaledHeight(int targetDensity) {
        dsTaint.addTaint(targetDensity);
        int varEBBA22F03E55C884FB7BC5702A806353_98800984 = (scaleFromDensity(getHeight(), mDensity, targetDensity));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, targetDensity);
    }

    
        static public int scaleFromDensity(int size, int sdensity, int tdensity) {
        if (sdensity == DENSITY_NONE || sdensity == tdensity) {
            return size;
        }
        return ((size * tdensity) + (sdensity >> 1)) / sdensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.076 -0400", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "10A2B55DC51AD871BBF461DE8A87678B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getRowBytes() {
        int var0267412FC813FD8E20B12B849B0C1F93_1032455841 = (nativeRowBytes(mNativeBitmap));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeRowBytes(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.076 -0400", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "66CEEB53D714F08D08F6B6C7D05FAE12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getByteCount() {
        int var18558EEEC9B7BD46FC1B51B2AC00445A_40249713 = (getRowBytes() * getHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getRowBytes() * getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.076 -0400", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "ADF2F3142C5177B8492B9150E791F7FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Config getConfig() {
        Config var256D15F1266556B864D532B889452985_1033690973 = (Config.nativeToConfig(nativeConfig(mNativeBitmap)));
        return (Config)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.077 -0400", hash_original_method = "A9E6FFBE96B704702B1F2A7EDD472B86", hash_generated_method = "9271CE9352B89152448B09B1D5892E33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasAlpha() {
        boolean var800F787096C2FAD492BB45AE9E7A91D2_620666557 = (nativeHasAlpha(mNativeBitmap));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nativeHasAlpha(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.077 -0400", hash_original_method = "9BF8F5FAA617B68A4287E64028C24BC4", hash_generated_method = "A146C4633A4137BD4B7D696C7DEB48B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHasAlpha(boolean hasAlpha) {
        dsTaint.addTaint(hasAlpha);
        nativeSetHasAlpha(mNativeBitmap, hasAlpha);
        // ---------- Original Method ----------
        //nativeSetHasAlpha(mNativeBitmap, hasAlpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.077 -0400", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "1ECC315382219D195191D266B7FE5DCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void eraseColor(int c) {
        dsTaint.addTaint(c);
        checkRecycled("Can't erase a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_1915328232 = (!isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cannot erase immutable bitmaps");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.077 -0400", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "46708F4E12CF4A5095915D8B3545CBEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPixel(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(x, y);
        int var8FD6BA845BC7C15EFB43BAC7ED016EA5_269270174 = (nativeGetPixel(mNativeBitmap, x, y));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixel() on a recycled bitmap");
        //checkPixelAccess(x, y);
        //return nativeGetPixel(mNativeBitmap, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.078 -0400", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "0636AE0DE145387EB4D8721F9AC01790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pixels[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.078 -0400", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "220B3DF358309AD2847E0300AF4D19EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkPixelAccess(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkXYSign(x, y);
        {
            boolean var30490CFCBE0CDDF5A434370B1DCE4F74_2143451738 = (x >= getWidth());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("x must be < bitmap.width()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var176BE51140078B0967F59852B69E3131_404580914 = (y >= getHeight());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("y must be < bitmap.height()");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.078 -0400", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "EC29431057FEEF924BFEFA191DBE4D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkPixelsAccess(int x, int y, int width, int height,
                                   int offset, int stride, int pixels[]) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(pixels);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkXYSign(x, y);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("width must be >= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("height must be >= 0");
        } //End block
        {
            boolean varD810B239D6120F6BE5AD1443109E34E9_857625178 = (x + width > getWidth());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "x + width must be <= bitmap.width()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var81DF503DAA371D07CDBF07C44BC00011_1101214191 = (y + height > getHeight());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "y + height must be <= bitmap.height()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE73A6561371F12118506FC78AF1B9D6D_15827519 = (Math.abs(stride) < width);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("abs(stride) must be >= width");
            } //End block
        } //End collapsed parenthetic
        int lastScanline;
        lastScanline = offset + (height - 1) * stride;
        int length;
        length = pixels.length;
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.079 -0400", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "0E4BF6F061D00A7F00DF45308863DF4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPixel(int x, int y, int color) {
        dsTaint.addTaint(color);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_1302889136 = (!isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.079 -0400", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "06C2E1D812DCCF4A04ABE011B6BB5361")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(pixels[0]);
        dsTaint.addTaint(stride);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_1935435241 = (!isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.079 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.080 -0400", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "48A0FF0AD43CA69223231C9D7E29216D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel p, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(p.dsTaint);
        checkRecycled("Can't parcel a recycled bitmap");
        {
            boolean var5DF242B1AD49EA84F890A63696D1516F_508178665 = (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("native writeToParcel failed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkRecycled("Can't parcel a recycled bitmap");
        //if (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p)) {
            //throw new RuntimeException("native writeToParcel failed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.080 -0400", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "D092F9E951C0E2F6203B2183038BDD0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap extractAlpha() {
        Bitmap varE5990E664B6EA7B07F751ED44580655F_999170969 = (extractAlpha(null, null));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return extractAlpha(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.080 -0400", hash_original_method = "798FC3DD232FCC4B06F4415625A8D213", hash_generated_method = "97084617464085BF25CFD1F04FA4CE4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
        dsTaint.addTaint(offsetXY[0]);
        dsTaint.addTaint(paint.dsTaint);
        checkRecycled("Can't extractAlpha on a recycled bitmap");
        int nativePaint;
        nativePaint = paint.mNativePaint;
        nativePaint = 0;
        Bitmap bm;
        bm = nativeExtractAlpha(mNativeBitmap, nativePaint, offsetXY);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to extractAlpha on Bitmap");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.081 -0400", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "67EF66A57B9291BC81CD1BA1FFB44B47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sameAs(Bitmap other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var573FBB3F9978D0C6C4756653011FAC34_1073891836 = (this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.081 -0400", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "EDCD1A3F0894A6577A12906075EDF3F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void prepareToDraw() {
        nativePrepareToDraw(mNativeBitmap);
        // ---------- Original Method ----------
        //nativePrepareToDraw(mNativeBitmap);
    }

    
        private static Bitmap nativeCreate(int[] colors, int offset,
                                              int stride, int width, int height,
                                            int nativeConfig, boolean mutable) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static Bitmap nativeCopy(int srcBitmap, int nativeConfig,
                                            boolean isMutable) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static void nativeDestructor(int nativeBitmap) {
    }

    
        private static void nativeRecycle(int nativeBitmap) {
    }

    
        private static boolean nativeCompress(int nativeBitmap, int format,
                                            int quality, OutputStream stream,
                                            byte[] tempStorage) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeErase(int nativeBitmap, int color) {
    }

    
        private static int nativeWidth(int nativeBitmap) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeHeight(int nativeBitmap) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeRowBytes(int nativeBitmap) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeConfig(int nativeBitmap) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean nativeHasAlpha(int nativeBitmap) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static int nativeGetPixel(int nativeBitmap, int x, int y) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeGetPixels(int nativeBitmap, int[] pixels,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
    }

    
        private static void nativeSetPixel(int nativeBitmap, int x, int y,
                                              int color) {
    }

    
        private static void nativeSetPixels(int nativeBitmap, int[] colors,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
    }

    
        private static void nativeCopyPixelsToBuffer(int nativeBitmap,
                                                        Buffer dst) {
    }

    
        private static void nativeCopyPixelsFromBuffer(int nb, Buffer src) {
    }

    
        private static int nativeGenerationId(int nativeBitmap) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static Bitmap nativeCreateFromParcel(Parcel p) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static boolean nativeWriteToParcel(int nativeBitmap,
                                                      boolean isMutable,
                                                      int density,
                                                      Parcel p) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static Bitmap nativeExtractAlpha(int nativeBitmap,
                                                    int nativePaint,
                                                    int[] offsetXY) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static void nativePrepareToDraw(int nativeBitmap) {
    }

    
        private static void nativeSetHasAlpha(int nBitmap, boolean hasAlpha) {
    }

    
        private static boolean nativeSameAs(int nb0, int nb1) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.086 -0400", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "877D44898B368F081F6B0A841502F64E")
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
        private int mNativeBitmap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.086 -0400", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "F41A1078E8D1AEF0FEC5D385B9582F62")
        @DSModeled(DSC.SAFE)
         BitmapFinalizer(int nativeBitmap) {
            dsTaint.addTaint(nativeBitmap);
            // ---------- Original Method ----------
            //mNativeBitmap = nativeBitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.087 -0400", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "F7615B068DA183F6083E4BBEA97826DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    public static final int DENSITY_NONE = 0;
    private static volatile Matrix sScaleMatrix;
    private static volatile int sDefaultDensity = -1;
    private final static int WORKING_COMPRESS_STORAGE = 4096;
    public static final Parcelable.Creator<Bitmap> CREATOR = new Parcelable.Creator<Bitmap>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.089 -0400", hash_original_method = "A576610C1F5A8AE8D31C4E9A14C2AA39", hash_generated_method = "73CFC1D42B0B89C11101958363CC9F75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bitmap createFromParcel(Parcel p) {
            dsTaint.addTaint(p.dsTaint);
            Bitmap bm;
            bm = nativeCreateFromParcel(p);
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to unparcel Bitmap");
            } //End block
            return (Bitmap)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bitmap bm = nativeCreateFromParcel(p);
            //if (bm == null) {
                //throw new RuntimeException("Failed to unparcel Bitmap");
            //}
            //return bm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.089 -0400", hash_original_method = "9D41A73AB5270B44257816A57AEF6E94", hash_generated_method = "180615193BCA3E25E7D7DFD8A0D291A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bitmap[] newArray(int size) {
            dsTaint.addTaint(size);
            Bitmap[] var020823AE6B4FABD43BC5CA310754CD23_1606684459 = (new Bitmap[size]);
            return (Bitmap[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Bitmap[size];
        }

        
}; //Transformed anonymous class
}

