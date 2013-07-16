package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class Bitmap implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.772 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "44187EAF844F975F9CC351362B5828D9")

    public int mNativeBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.773 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "D26E89192452D152F1B0620ACC981170")

    public byte[] mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.773 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D5ECB585FDF82CD3261AE26CF7CC63CA")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) private BitmapFinalizer mFinalizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.773 -0400", hash_original_field = "E62BED608586C761CD92607B7C2EF1FD", hash_generated_field = "9C32056DAC69AD0374E74408422BBEB9")

    private boolean mIsMutable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.773 -0400", hash_original_field = "D3261EC38F92DF331844BA8BBC57CDB0", hash_generated_field = "436C2ED570DD3AA7577644DBEE1CE62A")

    private byte[] mNinePatchChunk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.774 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "E5A03441D6069228A477C954385A251B")

    private int mWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.774 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "799F7A00E6DAB63292A42CD8E01B88BC")

    private int mHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.774 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.774 -0400", hash_original_field = "9F8FEF6E0A2744C399FE0A9EF16A8539", hash_generated_field = "DFE44862C379A23055CB9029F03233AE")

    int mDensity = sDefaultDensity = getDefaultDensity();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.776 -0400", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "3932AC41E4A5FE2ED24282D3E2D321CA")
      Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk,
            int density) {
    if(nativeBitmap == 0)        
        {
            RuntimeException varD4A2FCC10C57632265585A02F75E1B84_1830035758 = new RuntimeException("internal error: native bitmap is 0");
            varD4A2FCC10C57632265585A02F75E1B84_1830035758.addTaint(taint);
            throw varD4A2FCC10C57632265585A02F75E1B84_1830035758;
        } //End block
        mBuffer = buffer;
        mNativeBitmap = nativeBitmap;
        mFinalizer = new BitmapFinalizer(nativeBitmap);
        mIsMutable = isMutable;
        mNinePatchChunk = ninePatchChunk;
    if(density >= 0)        
        {
            mDensity = density;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
    public static void setDefaultDensity(int density) {
        sDefaultDensity = density;
    }

    
        @DSModeled(DSC.SAFE)
    static int getDefaultDensity() {
        if (sDefaultDensity >= 0) {
            return sDefaultDensity;
        }
        sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
        return sDefaultDensity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.777 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "7DC710C6C54B6605E820C74543BF7ED7")
    public int getDensity() {
        int var174BB9FF4691CBE6254BA90AE9FA0B63_1377385771 = (mDensity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574368665 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574368665;
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.777 -0400", hash_original_method = "9862D9E59C2B168AB35D015A9ED81A18", hash_generated_method = "58D723A4F769D2A3CBAF9A17D68E73B4")
    public void setDensity(int density) {
        mDensity = density;
        // ---------- Original Method ----------
        //mDensity = density;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.778 -0400", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "84E478FF6E7328C663D71E05433F8696")
    public void setNinePatchChunk(byte[] chunk) {
        mNinePatchChunk = chunk;
        // ---------- Original Method ----------
        //mNinePatchChunk = chunk;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.778 -0400", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "D495C2A863A61C0A1634FBB0748FA025")
    public void recycle() {
    if(!mRecycled)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.779 -0400", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "DBA6E11F1BF4010E5B0231E57CAC2CC4")
    public final boolean isRecycled() {
        boolean var1212A62D731F217836716E35FA12386C_1594548744 = (mRecycled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824674447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824674447;
        // ---------- Original Method ----------
        //return mRecycled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.779 -0400", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "E57437DC25CEB5DC604624EC6913774C")
    public int getGenerationId() {
        int varA00831C6DD65E3E88035116FD7438C44_1401116492 = (nativeGenerationId(mNativeBitmap));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903447839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903447839;
        // ---------- Original Method ----------
        //return nativeGenerationId(mNativeBitmap);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.779 -0400", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "AD62B4BD65644E85DC7C026102898526")
    private void checkRecycled(String errorMessage) {
        addTaint(errorMessage.getTaint());
    if(mRecycled)        
        {
            IllegalStateException varD9081CDF75B620C4480CABC9EF85BBFC_1790561020 = new IllegalStateException(errorMessage);
            varD9081CDF75B620C4480CABC9EF85BBFC_1790561020.addTaint(taint);
            throw varD9081CDF75B620C4480CABC9EF85BBFC_1790561020;
        } //End block
        // ---------- Original Method ----------
        //if (mRecycled) {
            //throw new IllegalStateException(errorMessage);
        //}
    }

    
        @DSModeled(DSC.SAFE)
    private static void checkXYSign(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static void checkWidthHeight(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.781 -0400", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "3D4FF10FDF91E4D8F2F450F7EC92CF90")
    public void copyPixelsToBuffer(Buffer dst) {
        addTaint(dst.getTaint());
        int elements = dst.remaining();
        int shift;
    if(dst instanceof ByteBuffer)        
        {
            shift = 0;
        } //End block
        else
    if(dst instanceof ShortBuffer)        
        {
            shift = 1;
        } //End block
        else
    if(dst instanceof IntBuffer)        
        {
            shift = 2;
        } //End block
        else
        {
            RuntimeException var684BD95A1BABD1C7D7E5D483114B54AB_1562576007 = new RuntimeException("unsupported Buffer subclass");
            var684BD95A1BABD1C7D7E5D483114B54AB_1562576007.addTaint(taint);
            throw var684BD95A1BABD1C7D7E5D483114B54AB_1562576007;
        } //End block
        long bufferSize = (long)elements << shift;
        long pixelSize = getByteCount();
    if(bufferSize < pixelSize)        
        {
            RuntimeException var65AA43427530ADDFE3F941E2F669D64B_104169930 = new RuntimeException("Buffer not large enough for pixels");
            var65AA43427530ADDFE3F941E2F669D64B_104169930.addTaint(taint);
            throw var65AA43427530ADDFE3F941E2F669D64B_104169930;
        } //End block
        nativeCopyPixelsToBuffer(mNativeBitmap, dst);
        int position = dst.position();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.782 -0400", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "C7087BC4A2E5273D09F84B980C611F39")
    public void copyPixelsFromBuffer(Buffer src) {
        addTaint(src.getTaint());
        checkRecycled("copyPixelsFromBuffer called on recycled bitmap");
        int elements = src.remaining();
        int shift;
    if(src instanceof ByteBuffer)        
        {
            shift = 0;
        } //End block
        else
    if(src instanceof ShortBuffer)        
        {
            shift = 1;
        } //End block
        else
    if(src instanceof IntBuffer)        
        {
            shift = 2;
        } //End block
        else
        {
            RuntimeException var684BD95A1BABD1C7D7E5D483114B54AB_244077409 = new RuntimeException("unsupported Buffer subclass");
            var684BD95A1BABD1C7D7E5D483114B54AB_244077409.addTaint(taint);
            throw var684BD95A1BABD1C7D7E5D483114B54AB_244077409;
        } //End block
        long bufferBytes = (long)elements << shift;
        long bitmapBytes = getByteCount();
    if(bufferBytes < bitmapBytes)        
        {
            RuntimeException var65AA43427530ADDFE3F941E2F669D64B_57372979 = new RuntimeException("Buffer not large enough for pixels");
            var65AA43427530ADDFE3F941E2F669D64B_57372979.addTaint(taint);
            throw var65AA43427530ADDFE3F941E2F669D64B_57372979;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.783 -0400", hash_original_method = "5A36626FB0A5325F859AD016AE482420", hash_generated_method = "E8A213E27C875F2B33D7BD9824BC858B")
    public Bitmap copy(Config config, boolean isMutable) {
        addTaint(isMutable);
        addTaint(config.getTaint());
        checkRecycled("Can't copy a recycled bitmap");
        Bitmap b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
    if(b != null)        
        {
            b.mDensity = mDensity;
        } //End block
Bitmap var73F89FAC8F369DF0913D10C37C1E0EA1_1360114621 =         b;
        var73F89FAC8F369DF0913D10C37C1E0EA1_1360114621.addTaint(taint);
        return var73F89FAC8F369DF0913D10C37C1E0EA1_1360114621;
        // ---------- Original Method ----------
        //checkRecycled("Can't copy a recycled bitmap");
        //Bitmap b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
        //if (b != null) {
            //b.mDensity = mDensity;
        //}
        //return b;
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(Bitmap src) {
        return createBitmap(src, 0, 0, src.getWidth(), src.getHeight());
    }

    
        @DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height) {
        return createBitmap(source, x, y, width, height, null, false);
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    public static Bitmap createBitmap(int width, int height, Config config) {
        return createBitmap(width, height, config, true);
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.786 -0400", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "054B69C07BEE00512882173E44BB35BD")
    public byte[] getNinePatchChunk() {
        byte[] varD3261EC38F92DF331844BA8BBC57CDB0_1789694498 = (mNinePatchChunk);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_245833241 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_245833241;
        // ---------- Original Method ----------
        //return mNinePatchChunk;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.787 -0400", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "D01F28F20E4A018EBC5DAA6BEAD3A59B")
    public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        addTaint(stream.getTaint());
        addTaint(quality);
        addTaint(format.getTaint());
        checkRecycled("Can't compress a recycled bitmap");
    if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_751757921 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_751757921.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_751757921;
        } //End block
    if(quality < 0 || quality > 100)        
        {
            IllegalArgumentException varBD97A83E5031891AE3E62956E43796D0_1951598342 = new IllegalArgumentException("quality must be 0..100");
            varBD97A83E5031891AE3E62956E43796D0_1951598342.addTaint(taint);
            throw varBD97A83E5031891AE3E62956E43796D0_1951598342;
        } //End block
        boolean var85CC932DCD91F4BF3D2B066E188F9BE4_1638539223 = (nativeCompress(mNativeBitmap, format.nativeInt, quality,
                              stream, new byte[WORKING_COMPRESS_STORAGE]));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_535189138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_535189138;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.788 -0400", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "3A808F9482F8CA25470396B0389D3658")
    public final boolean isMutable() {
        boolean varE62BED608586C761CD92607B7C2EF1FD_149121419 = (mIsMutable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699792019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699792019;
        // ---------- Original Method ----------
        //return mIsMutable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.788 -0400", hash_original_method = "9273E6434E2E49D8D6A7BEF0351E82F0", hash_generated_method = "9E00522CD0C1B3E1E3254A883499CD5F")
    public final int getWidth() {
        int var3BF51128621ABF9C3888D634FE9E8234_1746306353 = (mWidth == -1 ? mWidth = nativeWidth(mNativeBitmap) : mWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008007149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008007149;
        // ---------- Original Method ----------
        //return mWidth == -1 ? mWidth = nativeWidth(mNativeBitmap) : mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.789 -0400", hash_original_method = "C9C832E0F45CC5A7AD0241E8F16710F4", hash_generated_method = "07DF863F6134049B744CD226A516AF9E")
    public final int getHeight() {
        int var0EF81288FB722485D30D70622DFC52F2_2109643245 = (mHeight == -1 ? mHeight = nativeHeight(mNativeBitmap) : mHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019566324 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019566324;
        // ---------- Original Method ----------
        //return mHeight == -1 ? mHeight = nativeHeight(mNativeBitmap) : mHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.789 -0400", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "804BB6F7450647F5652CF732066EB257")
    public int getScaledWidth(Canvas canvas) {
        addTaint(canvas.getTaint());
        int var8ACA54DB394A9DA09813E5A9103A7F44_1939386296 = (scaleFromDensity(getWidth(), mDensity, canvas.mDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635793792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635793792;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.790 -0400", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "9609B52A595E593F51BE0344272A6C01")
    public int getScaledHeight(Canvas canvas) {
        addTaint(canvas.getTaint());
        int var42B308AA8615CF2950DA60C23341BF7B_1856193566 = (scaleFromDensity(getHeight(), mDensity, canvas.mDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415999443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1415999443;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.790 -0400", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "1D0E4AD1A0979D9DE4A7553D4F622C26")
    public int getScaledWidth(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        int var5CF144416F957B6D4EC4EA1109807F1E_1750662255 = (scaleFromDensity(getWidth(), mDensity, metrics.densityDpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076656604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2076656604;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, metrics.densityDpi);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.790 -0400", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "BDD824558A46978C83A3F8DA03490CEA")
    public int getScaledHeight(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        int var6D6FF37D0C74BF550DA7C622658CE3D0_200974706 = (scaleFromDensity(getHeight(), mDensity, metrics.densityDpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073788113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073788113;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, metrics.densityDpi);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.791 -0400", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "337F5E4583A8FDE5EE6BBEF726E9B95F")
    public int getScaledWidth(int targetDensity) {
        addTaint(targetDensity);
        int var17FADDAA5AEEE7A48DB864F7D5329658_117695535 = (scaleFromDensity(getWidth(), mDensity, targetDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079254589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079254589;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, targetDensity);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.791 -0400", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "7DEBBB3E22AC1B444901CC76508F6300")
    public int getScaledHeight(int targetDensity) {
        addTaint(targetDensity);
        int varBCC1037EC2C3891B7EC633DB99EA42EF_2047148447 = (scaleFromDensity(getHeight(), mDensity, targetDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227579403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227579403;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, targetDensity);
    }

    
        @DSModeled(DSC.SAFE)
    static public int scaleFromDensity(int size, int sdensity, int tdensity) {
        if (sdensity == DENSITY_NONE || sdensity == tdensity) {
            return size;
        }
        return ((size * tdensity) + (sdensity >> 1)) / sdensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.792 -0400", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "F4583DFB5C279DC814BEB3BE2B6A3131")
    public final int getRowBytes() {
        int varB5360D2236BEDFE453A38C0C68B391D5_197740148 = (nativeRowBytes(mNativeBitmap));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800551851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1800551851;
        // ---------- Original Method ----------
        //return nativeRowBytes(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.793 -0400", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "5AF3D2019EFEA32C0DFD7E558A816F5A")
    public final int getByteCount() {
        int var0819CDDA81535248F4D66ADD730B8D4E_607954594 = (getRowBytes() * getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592267003 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592267003;
        // ---------- Original Method ----------
        //return getRowBytes() * getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.793 -0400", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "6D0F2C662B5CB7CC60F008BD6E1F6FEF")
    public final Config getConfig() {
Config varBA92FAE805FBA986A16BE9B5925B7B62_1865049088 =         Config.nativeToConfig(nativeConfig(mNativeBitmap));
        varBA92FAE805FBA986A16BE9B5925B7B62_1865049088.addTaint(taint);
        return varBA92FAE805FBA986A16BE9B5925B7B62_1865049088;
        // ---------- Original Method ----------
        //return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.793 -0400", hash_original_method = "A9E6FFBE96B704702B1F2A7EDD472B86", hash_generated_method = "7D506CE6CD6AE73043B9DA4FFDB0DFA4")
    public final boolean hasAlpha() {
        boolean varDC5C2DACE33E0A3296C291EC9442951A_103743617 = (nativeHasAlpha(mNativeBitmap));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112540445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112540445;
        // ---------- Original Method ----------
        //return nativeHasAlpha(mNativeBitmap);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.794 -0400", hash_original_method = "9BF8F5FAA617B68A4287E64028C24BC4", hash_generated_method = "E4B588AE8E58210FB297A6FBDC0B94DF")
    public void setHasAlpha(boolean hasAlpha) {
        addTaint(hasAlpha);
        nativeSetHasAlpha(mNativeBitmap, hasAlpha);
        // ---------- Original Method ----------
        //nativeSetHasAlpha(mNativeBitmap, hasAlpha);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.794 -0400", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "24B1726EF91DED38E87393BE56E9096E")
    public void eraseColor(int c) {
        addTaint(c);
        checkRecycled("Can't erase a recycled bitmap");
    if(!isMutable())        
        {
            IllegalStateException var99223427A1AA7E27A86878ED471132CB_1261467135 = new IllegalStateException("cannot erase immutable bitmaps");
            var99223427A1AA7E27A86878ED471132CB_1261467135.addTaint(taint);
            throw var99223427A1AA7E27A86878ED471132CB_1261467135;
        } //End block
        nativeErase(mNativeBitmap, c);
        // ---------- Original Method ----------
        //checkRecycled("Can't erase a recycled bitmap");
        //if (!isMutable()) {
            //throw new IllegalStateException("cannot erase immutable bitmaps");
        //}
        //nativeErase(mNativeBitmap, c);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.794 -0400", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "78A4CB62BABFF727C86F9140FEA5B486")
    public int getPixel(int x, int y) {
        addTaint(y);
        addTaint(x);
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(x, y);
        int var2D3A6EFE9FA8EE8F8A63CCCEC8378C77_2093477750 = (nativeGetPixel(mNativeBitmap, x, y));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548814141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548814141;
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixel() on a recycled bitmap");
        //checkPixelAccess(x, y);
        //return nativeGetPixel(mNativeBitmap, x, y);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.795 -0400", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "6DEA1D5682B1FCB90E6C05D3F057DDF1")
    public void getPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(pixels[0]);
        checkRecycled("Can't call getPixels() on a recycled bitmap");
    if(width == 0 || height == 0)        
        {
            return;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.796 -0400", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "FA71C815C4C49073D2E822253F3D3A6F")
    private void checkPixelAccess(int x, int y) {
        addTaint(y);
        addTaint(x);
        checkXYSign(x, y);
    if(x >= getWidth())        
        {
            IllegalArgumentException var406EF70B7749A8301D674C0A91223939_884570729 = new IllegalArgumentException("x must be < bitmap.width()");
            var406EF70B7749A8301D674C0A91223939_884570729.addTaint(taint);
            throw var406EF70B7749A8301D674C0A91223939_884570729;
        } //End block
    if(y >= getHeight())        
        {
            IllegalArgumentException varF643712FF53DED8DE285A32252A68500_72411796 = new IllegalArgumentException("y must be < bitmap.height()");
            varF643712FF53DED8DE285A32252A68500_72411796.addTaint(taint);
            throw varF643712FF53DED8DE285A32252A68500_72411796;
        } //End block
        // ---------- Original Method ----------
        //checkXYSign(x, y);
        //if (x >= getWidth()) {
            //throw new IllegalArgumentException("x must be < bitmap.width()");
        //}
        //if (y >= getHeight()) {
            //throw new IllegalArgumentException("y must be < bitmap.height()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.797 -0400", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "A6FACAF35CA21D3723D31326A2139F95")
    private void checkPixelsAccess(int x, int y, int width, int height,
                                   int offset, int stride, int pixels[]) {
        addTaint(pixels[0]);
        addTaint(stride);
        addTaint(offset);
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        checkXYSign(x, y);
    if(width < 0)        
        {
            IllegalArgumentException var3466F3A966382BEF5BF802F7CB74379A_797224672 = new IllegalArgumentException("width must be >= 0");
            var3466F3A966382BEF5BF802F7CB74379A_797224672.addTaint(taint);
            throw var3466F3A966382BEF5BF802F7CB74379A_797224672;
        } //End block
    if(height < 0)        
        {
            IllegalArgumentException var32D5EA37D2C9CC8D7924EB1890514E85_845470170 = new IllegalArgumentException("height must be >= 0");
            var32D5EA37D2C9CC8D7924EB1890514E85_845470170.addTaint(taint);
            throw var32D5EA37D2C9CC8D7924EB1890514E85_845470170;
        } //End block
    if(x + width > getWidth())        
        {
            IllegalArgumentException var5EB20FEA7A0115C73F7BEC3A9F97D8E2_432651931 = new IllegalArgumentException(
                    "x + width must be <= bitmap.width()");
            var5EB20FEA7A0115C73F7BEC3A9F97D8E2_432651931.addTaint(taint);
            throw var5EB20FEA7A0115C73F7BEC3A9F97D8E2_432651931;
        } //End block
    if(y + height > getHeight())        
        {
            IllegalArgumentException var74275FD4162E748074B9E6C684BC87F8_242378891 = new IllegalArgumentException(
                    "y + height must be <= bitmap.height()");
            var74275FD4162E748074B9E6C684BC87F8_242378891.addTaint(taint);
            throw var74275FD4162E748074B9E6C684BC87F8_242378891;
        } //End block
    if(Math.abs(stride) < width)        
        {
            IllegalArgumentException varD1549FCE299AC8F2198C0DF0EF8A3981_422096340 = new IllegalArgumentException("abs(stride) must be >= width");
            varD1549FCE299AC8F2198C0DF0EF8A3981_422096340.addTaint(taint);
            throw varD1549FCE299AC8F2198C0DF0EF8A3981_422096340;
        } //End block
        int lastScanline = offset + (height - 1) * stride;
        int length = pixels.length;
    if(offset < 0 || (offset + width > length)
                || lastScanline < 0
                || (lastScanline + width > length))        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_789720978 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_789720978.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_789720978;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.798 -0400", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "F2E6A269082B13CE08A769F105942F0C")
    public void setPixel(int x, int y, int color) {
        addTaint(color);
        addTaint(y);
        addTaint(x);
        checkRecycled("Can't call setPixel() on a recycled bitmap");
    if(!isMutable())        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_786089653 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_786089653.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_786089653;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.800 -0400", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "47A90828680043D2EEA8B8C372B830AD")
    public void setPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(y);
        addTaint(x);
        addTaint(stride);
        addTaint(offset);
        addTaint(pixels[0]);
        checkRecycled("Can't call setPixels() on a recycled bitmap");
    if(!isMutable())        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1289652631 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1289652631.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1289652631;
        } //End block
    if(width == 0 || height == 0)        
        {
            return;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.801 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "91147051706F6E953D8F34057C1045E6")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_524150648 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77582069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77582069;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.802 -0400", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "D7517F9692C5055F04AB97D58DEE1DCF")
    public void writeToParcel(Parcel p, int flags) {
        addTaint(flags);
        addTaint(p.getTaint());
        checkRecycled("Can't parcel a recycled bitmap");
    if(!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p))        
        {
            RuntimeException var4F70AC2128277CCD5293EAD55724162F_1271762883 = new RuntimeException("native writeToParcel failed");
            var4F70AC2128277CCD5293EAD55724162F_1271762883.addTaint(taint);
            throw var4F70AC2128277CCD5293EAD55724162F_1271762883;
        } //End block
        // ---------- Original Method ----------
        //checkRecycled("Can't parcel a recycled bitmap");
        //if (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p)) {
            //throw new RuntimeException("native writeToParcel failed");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.803 -0400", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "3B996EC5D207BEC5E121A9A0732BCA03")
    public Bitmap extractAlpha() {
Bitmap varCB1FEB1592E325F352986A6C8FA8FC91_1653240198 =         extractAlpha(null, null);
        varCB1FEB1592E325F352986A6C8FA8FC91_1653240198.addTaint(taint);
        return varCB1FEB1592E325F352986A6C8FA8FC91_1653240198;
        // ---------- Original Method ----------
        //return extractAlpha(null, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.804 -0400", hash_original_method = "798FC3DD232FCC4B06F4415625A8D213", hash_generated_method = "47A6B01DCAC5455ADA25B036C7DE5678")
    public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
        addTaint(offsetXY[0]);
        addTaint(paint.getTaint());
        checkRecycled("Can't extractAlpha on a recycled bitmap");
        int nativePaint = paint != null ? paint.mNativePaint : 0;
        Bitmap bm = nativeExtractAlpha(mNativeBitmap, nativePaint, offsetXY);
    if(bm == null)        
        {
            RuntimeException var67B3BF2BCD6B32B8B5F007307A0B9CE2_1480146061 = new RuntimeException("Failed to extractAlpha on Bitmap");
            var67B3BF2BCD6B32B8B5F007307A0B9CE2_1480146061.addTaint(taint);
            throw var67B3BF2BCD6B32B8B5F007307A0B9CE2_1480146061;
        } //End block
        bm.mDensity = mDensity;
Bitmap varB8E43D5ABE5A56CEFCFBA2D810F6046C_771735090 =         bm;
        varB8E43D5ABE5A56CEFCFBA2D810F6046C_771735090.addTaint(taint);
        return varB8E43D5ABE5A56CEFCFBA2D810F6046C_771735090;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.804 -0400", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "A9E219564FA468510C6105BDF35ADF65")
    public boolean sameAs(Bitmap other) {
        addTaint(other.getTaint());
        boolean var284AC577042B746753A88A8A8668B1B4_172469215 = (this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_154010690 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_154010690;
        // ---------- Original Method ----------
        //return this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.805 -0400", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "EDCD1A3F0894A6577A12906075EDF3F2")
    public void prepareToDraw() {
        nativePrepareToDraw(mNativeBitmap);
        // ---------- Original Method ----------
        //nativePrepareToDraw(mNativeBitmap);
    }

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeCreate(int[] colors, int offset, int stride, int width, int height, int nativeConfig, boolean mutable) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeCopy(int srcBitmap, int nativeConfig, boolean isMutable) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int nativeBitmap) {
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeRecycle(int nativeBitmap) {
	}

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeCompress(int nativeBitmap, int format, int quality, OutputStream stream, byte[] tempStorage) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104407749 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104407749;
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeErase(int nativeBitmap, int color) {
	}

    
    @DSModeled(DSC.SAFE)
    private static int nativeWidth(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883901434 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883901434;
	}

    
    @DSModeled(DSC.SAFE)
    private static int nativeHeight(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185058667 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185058667;
	}

    
    @DSModeled(DSC.SAFE)
    private static int nativeRowBytes(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006498156 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2006498156;
	}

    
    @DSModeled(DSC.SAFE)
    private static int nativeConfig(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639280674 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_639280674;
	}

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeHasAlpha(int nativeBitmap) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606515604 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_606515604;
	}

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetPixel(int nativeBitmap, int x, int y) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039533584 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039533584;
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeGetPixels(int nativeBitmap, int[] pixels, int offset, int stride, int x, int y, int width, int height) {
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetPixel(int nativeBitmap, int x, int y, int color) {
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetPixels(int nativeBitmap, int[] colors, int offset, int stride, int x, int y, int width, int height) {
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeCopyPixelsToBuffer(int nativeBitmap, Buffer dst) {
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeCopyPixelsFromBuffer(int nb, Buffer src) {
	}

    
    @DSModeled(DSC.SAFE)
    private static int nativeGenerationId(int nativeBitmap) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699577780 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699577780;
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeCreateFromParcel(Parcel p) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeWriteToParcel(int nativeBitmap, boolean isMutable, int density, Parcel p) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709717476 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_709717476;
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeExtractAlpha(int nativeBitmap, int nativePaint, int[] offsetXY) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativePrepareToDraw(int nativeBitmap) {
	}

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetHasAlpha(int nBitmap, boolean hasAlpha) {
	}

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSameAs(int nb0, int nb1) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767903221 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_767903221;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.814 -0400", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "B67D0687309A7E389E6B6F6E2C786046")
    final int ni() {
        int varF16492AD902BDE58E3AAF1B990115133_2137059522 = (mNativeBitmap);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283948588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283948588;
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
        @DSModeled(DSC.SAFE)
        static Config nativeToConfig(int ni) {
            return sConfigs[ni];
        }
    }

    
    public enum CompressFormat {
        JPEG    (0),
        PNG     (1),
        WEBP    (2);
        @DSModeled(DSC.SAFE)
        CompressFormat(int nativeInt) {
            this.nativeInt = nativeInt;
        }
        final int nativeInt;
    }

    
    private static class BitmapFinalizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.815 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "94EBE634EB926388C6FE9311F8ADAABA")

        private int mNativeBitmap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.815 -0400", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "2ABFC00A38D50D88F77B67505EB4A344")
          BitmapFinalizer(int nativeBitmap) {
            mNativeBitmap = nativeBitmap;
            // ---------- Original Method ----------
            //mNativeBitmap = nativeBitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.815 -0400", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "9B5CB58A68FA10E5D74FA1DA487C9FB2")
        @Override
        public void finalize() {
            try 
            {
                super.finalize();
            } //End block
            catch (Throwable t)
            {
            } //End block
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.816 -0400", hash_original_field = "C71478846957767201391E31D504F7CF", hash_generated_field = "C25FA99E764685711DDB1FEBC88ADFFB")

    public static final int DENSITY_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.816 -0400", hash_original_field = "5B7CE7C3B907236423F83FB7C4C74DB5", hash_generated_field = "1395EEF7EE47C17BCE3B8566023F33E1")

    private static volatile Matrix sScaleMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.816 -0400", hash_original_field = "9F8879FC7AE169BC092D1EE3BC2FBD08", hash_generated_field = "9A5692A5868FC9DC94E238F1418014E4")

    private static volatile int sDefaultDensity = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.816 -0400", hash_original_field = "295B0C9790BF4CF54082ACBBD1BFA817", hash_generated_field = "835CBF2BDF2BE37014A11526CBB54378")

    private final static int WORKING_COMPRESS_STORAGE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:17.816 -0400", hash_original_field = "BF846A98932B20D726C6F01DDC8F3632", hash_generated_field = "5962E9DA47CF5849E5C813893A51D279")

    public static final Parcelable.Creator<Bitmap> CREATOR
            = new Parcelable.Creator<Bitmap>() {
        
        public Bitmap createFromParcel(Parcel p) {
            Bitmap bm = nativeCreateFromParcel(p);
            if (bm == null) {
                throw new RuntimeException("Failed to unparcel Bitmap");
            }
            return bm;
        }
        public Bitmap[] newArray(int size) {
            return new Bitmap[size];
        }
    };
    // orphaned legacy method
    public Bitmap() {

	}
    
}

