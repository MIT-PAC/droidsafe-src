package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;




import droidsafe.helpers.DSUtils;

public final class Bitmap implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "44187EAF844F975F9CC351362B5828D9")

    public int mNativeBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "D26E89192452D152F1B0620ACC981170")

    public byte[] mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D5ECB585FDF82CD3261AE26CF7CC63CA")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) private BitmapFinalizer mFinalizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "E62BED608586C761CD92607B7C2EF1FD", hash_generated_field = "9C32056DAC69AD0374E74408422BBEB9")

    private boolean mIsMutable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "D3261EC38F92DF331844BA8BBC57CDB0", hash_generated_field = "436C2ED570DD3AA7577644DBEE1CE62A")

    private byte[] mNinePatchChunk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "E5A03441D6069228A477C954385A251B")

    private int mWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "799F7A00E6DAB63292A42CD8E01B88BC")

    private int mHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.787 -0400", hash_original_field = "9F8FEF6E0A2744C399FE0A9EF16A8539", hash_generated_field = "DFE44862C379A23055CB9029F03233AE")

    int mDensity = sDefaultDensity = getDefaultDensity();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.788 -0400", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "21260626989E88F3CDC3EDC0331FA89D")
      Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk,
            int density) {
        if(nativeBitmap == 0)        
        {
            RuntimeException varD4A2FCC10C57632265585A02F75E1B84_555794431 = new RuntimeException("internal error: native bitmap is 0");
            varD4A2FCC10C57632265585A02F75E1B84_555794431.addTaint(taint);
            throw varD4A2FCC10C57632265585A02F75E1B84_555794431;
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

    
    @DSModeled(DSC.BAN)
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
	public int getDensity() {
		return getTaintInt();
        //return mDensity;
    }

    
    @DSModeled(DSC.SAFE)
	public void setDensity(int density) {
		addTaint(density);
        //mDensity = density;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.790 -0400", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "84E478FF6E7328C663D71E05433F8696")
    public void setNinePatchChunk(byte[] chunk) {
        mNinePatchChunk = chunk;
        // ---------- Original Method ----------
        //mNinePatchChunk = chunk;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.790 -0400", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "D495C2A863A61C0A1634FBB0748FA025")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.791 -0400", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "FA5CB4FAA5817C0A3B53968C8B624682")
    public final boolean isRecycled() {
        boolean var1212A62D731F217836716E35FA12386C_2096736229 = (mRecycled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938949979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938949979;
        // ---------- Original Method ----------
        //return mRecycled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.791 -0400", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "914FD405E8CFEF9613824D834CF548FC")
    public int getGenerationId() {
        int varA00831C6DD65E3E88035116FD7438C44_2065890042 = (nativeGenerationId(mNativeBitmap));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689020414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689020414;
        // ---------- Original Method ----------
        //return nativeGenerationId(mNativeBitmap);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.791 -0400", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "074A2EEFAA984114CE0F94EC4EDE71B9")
    private void checkRecycled(String errorMessage) {
        addTaint(errorMessage.getTaint());
        if(mRecycled)        
        {
            IllegalStateException varD9081CDF75B620C4480CABC9EF85BBFC_1815956928 = new IllegalStateException(errorMessage);
            varD9081CDF75B620C4480CABC9EF85BBFC_1815956928.addTaint(taint);
            throw varD9081CDF75B620C4480CABC9EF85BBFC_1815956928;
        } //End block
        // ---------- Original Method ----------
        //if (mRecycled) {
            //throw new IllegalStateException(errorMessage);
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static void checkXYSign(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    
    @DSModeled(DSC.BAN)
    private static void checkWidthHeight(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.792 -0400", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "8DE038C50E21B6E5DE559F6036CB7832")
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
            RuntimeException var684BD95A1BABD1C7D7E5D483114B54AB_1247776239 = new RuntimeException("unsupported Buffer subclass");
            var684BD95A1BABD1C7D7E5D483114B54AB_1247776239.addTaint(taint);
            throw var684BD95A1BABD1C7D7E5D483114B54AB_1247776239;
        } //End block
        long bufferSize = (long)elements << shift;
        long pixelSize = getByteCount();
        if(bufferSize < pixelSize)        
        {
            RuntimeException var65AA43427530ADDFE3F941E2F669D64B_1774953661 = new RuntimeException("Buffer not large enough for pixels");
            var65AA43427530ADDFE3F941E2F669D64B_1774953661.addTaint(taint);
            throw var65AA43427530ADDFE3F941E2F669D64B_1774953661;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.793 -0400", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "DC2C7719721F30BC98BE78D29C3BC905")
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
            RuntimeException var684BD95A1BABD1C7D7E5D483114B54AB_1937152841 = new RuntimeException("unsupported Buffer subclass");
            var684BD95A1BABD1C7D7E5D483114B54AB_1937152841.addTaint(taint);
            throw var684BD95A1BABD1C7D7E5D483114B54AB_1937152841;
        } //End block
        long bufferBytes = (long)elements << shift;
        long bitmapBytes = getByteCount();
        if(bufferBytes < bitmapBytes)        
        {
            RuntimeException var65AA43427530ADDFE3F941E2F669D64B_1935042994 = new RuntimeException("Buffer not large enough for pixels");
            var65AA43427530ADDFE3F941E2F669D64B_1935042994.addTaint(taint);
            throw var65AA43427530ADDFE3F941E2F669D64B_1935042994;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.794 -0400", hash_original_method = "5A36626FB0A5325F859AD016AE482420", hash_generated_method = "2279C6000E444E69DC03419CB555ABDA")
    public Bitmap copy(Config config, boolean isMutable) {
        addTaint(isMutable);
        addTaint(config.getTaint());
        checkRecycled("Can't copy a recycled bitmap");
        //Bitmap b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
        Bitmap b = new Bitmap();
        
        if(b != null)        
        {
            b.mDensity = mDensity;
        } //End block
Bitmap var73F89FAC8F369DF0913D10C37C1E0EA1_36661561 =         b;
        var73F89FAC8F369DF0913D10C37C1E0EA1_36661561.addTaint(taint);
        return var73F89FAC8F369DF0913D10C37C1E0EA1_36661561;
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

    
    @DSModeled(DSC.BAN)
	private static Bitmap createBitmap(int width, int height, Config config, boolean hasAlpha) {
        Bitmap bm = new Bitmap();
        bm.setHeight(height);
        bm.setWidth(width);
        bm.setHasAlpha(hasAlpha);
        /*
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        Bitmap bm = nativeCreate(null, 0, width, width, height, config.nativeInt, true);
        if (config == Config.ARGB_8888 && !hasAlpha) {
            nativeErase(bm.mNativeBitmap, 0xff000000);
            nativeSetHasAlpha(bm.mNativeBitmap, hasAlpha);
        } else {
            // No need to initialize it to zeroes; it is backed by a VM byte array
            // which is by definition preinitialized to all zeroes.
            //
            //nativeErase(bm.mNativeBitmap, 0);
        }
        */
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.796 -0400", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "685985C407F08833059746E544C850A5")
    public byte[] getNinePatchChunk() {
        byte[] varD3261EC38F92DF331844BA8BBC57CDB0_1709459969 = (mNinePatchChunk);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_592671524 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_592671524;
        // ---------- Original Method ----------
        //return mNinePatchChunk;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.797 -0400", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "8781B4B2F5358DFA352642E4FD54EB02")
    public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        addTaint(stream.getTaint());
        addTaint(quality);
        addTaint(format.getTaint());
        checkRecycled("Can't compress a recycled bitmap");
        if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_767220802 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_767220802.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_767220802;
        } //End block
        if(quality < 0 || quality > 100)        
        {
            IllegalArgumentException varBD97A83E5031891AE3E62956E43796D0_1277206634 = new IllegalArgumentException("quality must be 0..100");
            varBD97A83E5031891AE3E62956E43796D0_1277206634.addTaint(taint);
            throw varBD97A83E5031891AE3E62956E43796D0_1277206634;
        } //End block
        boolean var85CC932DCD91F4BF3D2B066E188F9BE4_267747614 = (nativeCompress(mNativeBitmap, format.nativeInt, quality,
                              stream, new byte[WORKING_COMPRESS_STORAGE]));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600557147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600557147;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.797 -0400", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "F81175B90093CCF0E4D0FD9217F484AD")
    public final boolean isMutable() {
        boolean varE62BED608586C761CD92607B7C2EF1FD_268631773 = (mIsMutable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179901395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179901395;
        // ---------- Original Method ----------
        //return mIsMutable;
    }

    
    @DSModeled(DSC.SAFE)
	public int getWidth() {
		//Synthetic method in order to track width taints, which are managed in native code
		return getTaintInt();
	}

    
    @DSModeled(DSC.SAFE)
	public int getHeight() {
		//Synthetic method in order to track height taints, which are managed in native code
		return getTaintInt();
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.798 -0400", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "86CF9C5FDA48C73F20B332EE117BBECE")
    public int getScaledWidth(Canvas canvas) {
        addTaint(canvas.getTaint());
        int var8ACA54DB394A9DA09813E5A9103A7F44_1290417023 = (scaleFromDensity(getWidth(), mDensity, canvas.mDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717186591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717186591;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.799 -0400", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "E2D2FFCCDAFF9BE6EB48E1AF74AD5D91")
    public int getScaledHeight(Canvas canvas) {
        addTaint(canvas.getTaint());
        int var42B308AA8615CF2950DA60C23341BF7B_1630777224 = (scaleFromDensity(getHeight(), mDensity, canvas.mDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234194545 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234194545;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.799 -0400", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "BD84406E6275490C8EDB057995AD104C")
    public int getScaledWidth(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        int var5CF144416F957B6D4EC4EA1109807F1E_1258658652 = (scaleFromDensity(getWidth(), mDensity, metrics.densityDpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067741657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067741657;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, metrics.densityDpi);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.799 -0400", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "E2998A386514C02FE693D3D628899F51")
    public int getScaledHeight(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        int var6D6FF37D0C74BF550DA7C622658CE3D0_1304609009 = (scaleFromDensity(getHeight(), mDensity, metrics.densityDpi));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425521400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425521400;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, metrics.densityDpi);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.800 -0400", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "47D87F55AC47C2240B1F94052A13F1DA")
    public int getScaledWidth(int targetDensity) {
        addTaint(targetDensity);
        int var17FADDAA5AEEE7A48DB864F7D5329658_1676544993 = (scaleFromDensity(getWidth(), mDensity, targetDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854588674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_854588674;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, targetDensity);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.800 -0400", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "16592CACA6286D0D485B730ADCF5C8FF")
    public int getScaledHeight(int targetDensity) {
        addTaint(targetDensity);
        int varBCC1037EC2C3891B7EC633DB99EA42EF_518019123 = (scaleFromDensity(getHeight(), mDensity, targetDensity));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37296540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37296540;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, targetDensity);
    }

    
    @DSModeled(DSC.BAN)
    static public int scaleFromDensity(int size, int sdensity, int tdensity) {
        if (sdensity == DENSITY_NONE || sdensity == tdensity) {
            return size;
        }
        return ((size * tdensity) + (sdensity >> 1)) / sdensity;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.801 -0400", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "50FC7FBF860D2D6E1C1137E5EA0B6805")
    public final int getRowBytes() {
        int varB5360D2236BEDFE453A38C0C68B391D5_241284116 = (nativeRowBytes(mNativeBitmap));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482227997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482227997;
        // ---------- Original Method ----------
        //return nativeRowBytes(mNativeBitmap);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.801 -0400", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "EAF00793C53F3C1F7F1D2776314D4E24")
    public final int getByteCount() {
        int var0819CDDA81535248F4D66ADD730B8D4E_1387634825 = (getRowBytes() * getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591581035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591581035;
        // ---------- Original Method ----------
        //return getRowBytes() * getHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.801 -0400", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "B17F5C71E4B948677E5350E720EE4610")
    public final Config getConfig() {
Config varBA92FAE805FBA986A16BE9B5925B7B62_976057839 =         Config.nativeToConfig(nativeConfig(mNativeBitmap));
        varBA92FAE805FBA986A16BE9B5925B7B62_976057839.addTaint(taint);
        return varBA92FAE805FBA986A16BE9B5925B7B62_976057839;
        // ---------- Original Method ----------
        //return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }

    
    @DSModeled(DSC.SAFE)
	public boolean hasAlpha() {
		//Previous called into native code.  Since we are tracking the taint in, we can track it out
		return getTaintBoolean();
	}

    
    @DSModeled(DSC.SAFE)
	private void setHasAlpha(boolean hasAlpha) {
		//Synthetic method in order to track hasAlpha taints, which are managed in native code
		addTaint(hasAlpha);
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.802 -0400", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "7F2054A3D8D19D95D89230C45ACDA397")
    public void eraseColor(int c) {
        addTaint(c);
        checkRecycled("Can't erase a recycled bitmap");
        if(!isMutable())        
        {
            IllegalStateException var99223427A1AA7E27A86878ED471132CB_1445941235 = new IllegalStateException("cannot erase immutable bitmaps");
            var99223427A1AA7E27A86878ED471132CB_1445941235.addTaint(taint);
            throw var99223427A1AA7E27A86878ED471132CB_1445941235;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.803 -0400", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "6D9CD8271F24D0862B27AAEF75DC4167")
    public int getPixel(int x, int y) {
        addTaint(y);
        addTaint(x);
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(x, y);
        int var2D3A6EFE9FA8EE8F8A63CCCEC8378C77_779692744 = (nativeGetPixel(mNativeBitmap, x, y));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224179137 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224179137;
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixel() on a recycled bitmap");
        //checkPixelAccess(x, y);
        //return nativeGetPixel(mNativeBitmap, x, y);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.803 -0400", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "6DEA1D5682B1FCB90E6C05D3F057DDF1")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.804 -0400", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "B88B455EFD345BABB707C580458C9DD9")
    private void checkPixelAccess(int x, int y) {
        addTaint(y);
        addTaint(x);
        checkXYSign(x, y);
        if(x >= getWidth())        
        {
            IllegalArgumentException var406EF70B7749A8301D674C0A91223939_1666482430 = new IllegalArgumentException("x must be < bitmap.width()");
            var406EF70B7749A8301D674C0A91223939_1666482430.addTaint(taint);
            throw var406EF70B7749A8301D674C0A91223939_1666482430;
        } //End block
        if(y >= getHeight())        
        {
            IllegalArgumentException varF643712FF53DED8DE285A32252A68500_1589327435 = new IllegalArgumentException("y must be < bitmap.height()");
            varF643712FF53DED8DE285A32252A68500_1589327435.addTaint(taint);
            throw varF643712FF53DED8DE285A32252A68500_1589327435;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.805 -0400", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "42CB91704C190538EE332D95AFD945E5")
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
            IllegalArgumentException var3466F3A966382BEF5BF802F7CB74379A_1865661822 = new IllegalArgumentException("width must be >= 0");
            var3466F3A966382BEF5BF802F7CB74379A_1865661822.addTaint(taint);
            throw var3466F3A966382BEF5BF802F7CB74379A_1865661822;
        } //End block
        if(height < 0)        
        {
            IllegalArgumentException var32D5EA37D2C9CC8D7924EB1890514E85_1537280094 = new IllegalArgumentException("height must be >= 0");
            var32D5EA37D2C9CC8D7924EB1890514E85_1537280094.addTaint(taint);
            throw var32D5EA37D2C9CC8D7924EB1890514E85_1537280094;
        } //End block
        if(x + width > getWidth())        
        {
            IllegalArgumentException var5EB20FEA7A0115C73F7BEC3A9F97D8E2_1811522124 = new IllegalArgumentException(
                    "x + width must be <= bitmap.width()");
            var5EB20FEA7A0115C73F7BEC3A9F97D8E2_1811522124.addTaint(taint);
            throw var5EB20FEA7A0115C73F7BEC3A9F97D8E2_1811522124;
        } //End block
        if(y + height > getHeight())        
        {
            IllegalArgumentException var74275FD4162E748074B9E6C684BC87F8_792313831 = new IllegalArgumentException(
                    "y + height must be <= bitmap.height()");
            var74275FD4162E748074B9E6C684BC87F8_792313831.addTaint(taint);
            throw var74275FD4162E748074B9E6C684BC87F8_792313831;
        } //End block
        if(Math.abs(stride) < width)        
        {
            IllegalArgumentException varD1549FCE299AC8F2198C0DF0EF8A3981_1660791158 = new IllegalArgumentException("abs(stride) must be >= width");
            varD1549FCE299AC8F2198C0DF0EF8A3981_1660791158.addTaint(taint);
            throw varD1549FCE299AC8F2198C0DF0EF8A3981_1660791158;
        } //End block
        int lastScanline = offset + (height - 1) * stride;
        int length = pixels.length;
        if(offset < 0 || (offset + width > length)
                || lastScanline < 0
                || (lastScanline + width > length))        
        {
            ArrayIndexOutOfBoundsException var37DB57B1FEB1C9FBA644A093BFA8B678_346051414 = new ArrayIndexOutOfBoundsException();
            var37DB57B1FEB1C9FBA644A093BFA8B678_346051414.addTaint(taint);
            throw var37DB57B1FEB1C9FBA644A093BFA8B678_346051414;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.805 -0400", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "FDF232B528BA9F92FD4925B01CCDCE5E")
    public void setPixel(int x, int y, int color) {
        addTaint(color);
        addTaint(y);
        addTaint(x);
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        if(!isMutable())        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1938129808 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1938129808.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1938129808;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.806 -0400", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "CFEC7336411E0F61EFE4C28AA2E5EF51")
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
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_152390542 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_152390542.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_152390542;
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
    @Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.807 -0400", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "FB5DD9F18B21B3C79C2EB0E33BCA59FA")
    public void writeToParcel(Parcel p, int flags) {
        addTaint(flags);
        addTaint(p.getTaint());
        checkRecycled("Can't parcel a recycled bitmap");
        if(!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p))        
        {
            RuntimeException var4F70AC2128277CCD5293EAD55724162F_311287546 = new RuntimeException("native writeToParcel failed");
            var4F70AC2128277CCD5293EAD55724162F_311287546.addTaint(taint);
            throw var4F70AC2128277CCD5293EAD55724162F_311287546;
        } //End block
        // ---------- Original Method ----------
        //checkRecycled("Can't parcel a recycled bitmap");
        //if (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p)) {
            //throw new RuntimeException("native writeToParcel failed");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.808 -0400", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "CA2DF5D75FDC9C0188C027064C16EE35")
    public Bitmap extractAlpha() {
Bitmap varCB1FEB1592E325F352986A6C8FA8FC91_1016252427 =         extractAlpha(null, null);
        varCB1FEB1592E325F352986A6C8FA8FC91_1016252427.addTaint(taint);
        return varCB1FEB1592E325F352986A6C8FA8FC91_1016252427;
        // ---------- Original Method ----------
        //return extractAlpha(null, null);
    }

    
    @DSModeled(DSC.SAFE)
    public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
        Bitmap bm = new Bitmap();
        bm.taint.addTaint(offsetXY[0]);
        bm.addTaint(paint.getTaint());
        bm.mDensity = mDensity;
        return bm;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.808 -0400", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "16E9C78513AB4391EE126622508DAE88")
    public boolean sameAs(Bitmap other) {
        addTaint(other.getTaint());
        boolean var284AC577042B746753A88A8A8668B1B4_1589993323 = (this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144576705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144576705;
        // ---------- Original Method ----------
        //return this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.809 -0400", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "EDCD1A3F0894A6577A12906075EDF3F2")
    public void prepareToDraw() {
        nativePrepareToDraw(mNativeBitmap);
        // ---------- Original Method ----------
        //nativePrepareToDraw(mNativeBitmap);
    }

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeCreate(int[] colors, int offset,
                                              int stride, int width, int height,
                                            int nativeConfig, boolean mutable) {
    	Bitmap b = new Bitmap();
    	b.addTaint(colors[0]);
    	b.addTaint(offset);
    	b.addTaint(stride);
    	b.addTaint(width);
    	b.addTaint(height);
    	b.addTaint(nativeConfig);
    	b.addTaint(mutable);
    	return b;
    }

    
    /*
    private static Bitmap nativeCopy(int srcBitmap, int nativeConfig,
                                            boolean isMutable) {
                //DSFIXME:  Can't synthesize return for advanced types
    }
    */

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int nativeBitmap) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRecycle(int nativeBitmap) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeCompress(int nativeBitmap, int format,
                                            int quality, OutputStream stream,
                                            byte[] tempStorage) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116630351 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116630351;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeErase(int nativeBitmap, int color) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeWidth(int nativeBitmap) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746939276 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746939276;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeHeight(int nativeBitmap) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907482253 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907482253;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeRowBytes(int nativeBitmap) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115927299 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_115927299;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeConfig(int nativeBitmap) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220830768 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_220830768;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeHasAlpha(int nativeBitmap) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910603484 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_910603484;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetPixel(int nativeBitmap, int x, int y) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133622273 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133622273;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeGetPixels(int nativeBitmap, int[] pixels,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetPixel(int nativeBitmap, int x, int y,
                                              int color) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetPixels(int nativeBitmap, int[] colors,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeCopyPixelsToBuffer(int nativeBitmap,
                                                        Buffer dst) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeCopyPixelsFromBuffer(int nb, Buffer src) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGenerationId(int nativeBitmap) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796645940 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1796645940;
    }

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeCreateFromParcel(Parcel p) {
    	Bitmap b = new Bitmap();
    	b.addTaint(p.getTaint());
    	return b;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeWriteToParcel(int nativeBitmap,
                                                      boolean isMutable,
                                                      int density,
                                                      Parcel p) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146699439 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146699439;
    }

    
    /*
    private static Bitmap nativeExtractAlpha(int nativeBitmap,
                                                    int nativePaint,
                                                    int[] offsetXY) {
                //DSFIXME:  Can't synthesize return for advanced types
    }
    */

    
    @DSModeled(DSC.SAFE)
    private static void nativePrepareToDraw(int nativeBitmap) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetHasAlpha(int nBitmap, boolean hasAlpha) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSameAs(int nb0, int nb1) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_227929198 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_227929198;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.815 -0400", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "E05087C2B2CCBBD706F4C42B20F15F85")
    final int ni() {
        int varF16492AD902BDE58E3AAF1B990115133_1669954112 = (mNativeBitmap);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668471654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668471654;
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
        @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.815 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "94EBE634EB926388C6FE9311F8ADAABA")

        private int mNativeBitmap;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.816 -0400", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "2ABFC00A38D50D88F77B67505EB4A344")
          BitmapFinalizer(int nativeBitmap) {
            mNativeBitmap = nativeBitmap;
            // ---------- Original Method ----------
            //mNativeBitmap = nativeBitmap;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.816 -0400", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "9B5CB58A68FA10E5D74FA1DA487C9FB2")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.816 -0400", hash_original_field = "C71478846957767201391E31D504F7CF", hash_generated_field = "C25FA99E764685711DDB1FEBC88ADFFB")

    public static final int DENSITY_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.816 -0400", hash_original_field = "5B7CE7C3B907236423F83FB7C4C74DB5", hash_generated_field = "1395EEF7EE47C17BCE3B8566023F33E1")

    private static volatile Matrix sScaleMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.816 -0400", hash_original_field = "9F8879FC7AE169BC092D1EE3BC2FBD08", hash_generated_field = "9A5692A5868FC9DC94E238F1418014E4")

    private static volatile int sDefaultDensity = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.816 -0400", hash_original_field = "295B0C9790BF4CF54082ACBBD1BFA817", hash_generated_field = "835CBF2BDF2BE37014A11526CBB54378")

    private final static int WORKING_COMPRESS_STORAGE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.817 -0400", hash_original_field = "BF846A98932B20D726C6F01DDC8F3632", hash_generated_field = "5962E9DA47CF5849E5C813893A51D279")

    public static final Parcelable.Creator<Bitmap> CREATOR
            = new Parcelable.Creator<Bitmap>() {
        
        @DSModeled(DSC.SAFE)
        public Bitmap createFromParcel(Parcel p) {
            Bitmap bm = nativeCreateFromParcel(p);
            if (bm == null) {
                throw new RuntimeException("Failed to unparcel Bitmap");
            }
            return bm;
        }
        @DSModeled(DSC.SAFE)
        public Bitmap[] newArray(int size) {
            return new Bitmap[size];
        }
    };
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	private void setHeight(int height) {
		//Synthetic method in order to track height taints, which are managed in native code
		addTaint(height);
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	private void setWidth(int width) {
		//Synthetic method in order to track width taints, which are managed in native code
		addTaint(width);
	}
    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
	public Bitmap() {
		super();
		//Doesn't exist in the real class but was showing up in specdump
	}
    
}

