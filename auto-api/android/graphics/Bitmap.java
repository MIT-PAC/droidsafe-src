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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.216 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "44187EAF844F975F9CC351362B5828D9")

    public int mNativeBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.217 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "D26E89192452D152F1B0620ACC981170")

    public byte[] mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.217 -0400", hash_original_field = "2D0BC5276619D20C917420C774FF5089", hash_generated_field = "D5ECB585FDF82CD3261AE26CF7CC63CA")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) private BitmapFinalizer mFinalizer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.217 -0400", hash_original_field = "E62BED608586C761CD92607B7C2EF1FD", hash_generated_field = "9C32056DAC69AD0374E74408422BBEB9")

    private boolean mIsMutable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.232 -0400", hash_original_field = "D3261EC38F92DF331844BA8BBC57CDB0", hash_generated_field = "436C2ED570DD3AA7577644DBEE1CE62A")

    private byte[] mNinePatchChunk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.232 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "E5A03441D6069228A477C954385A251B")

    private int mWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.232 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "799F7A00E6DAB63292A42CD8E01B88BC")

    private int mHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.232 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.232 -0400", hash_original_field = "9F8FEF6E0A2744C399FE0A9EF16A8539", hash_generated_field = "DFE44862C379A23055CB9029F03233AE")

    int mDensity = sDefaultDensity = getDefaultDensity();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.235 -0400", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "94F9D3E4AA3B3BDFD8611768A1633B28")
      Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk,
            int density) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("internal error: native bitmap is 0");
        } //End block
        mBuffer = buffer;
        mNativeBitmap = nativeBitmap;
        mFinalizer = new BitmapFinalizer(nativeBitmap);
        mIsMutable = isMutable;
        mNinePatchChunk = ninePatchChunk;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.252 -0400", hash_original_method = "ED34D3D3464A21C5929C60D84F577074", hash_generated_method = "3A384CD7FF347ED21F897BCA4839A2F5")
    public int getDensity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386593954 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386593954;
        // ---------- Original Method ----------
        //return mDensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.263 -0400", hash_original_method = "9862D9E59C2B168AB35D015A9ED81A18", hash_generated_method = "58D723A4F769D2A3CBAF9A17D68E73B4")
    public void setDensity(int density) {
        mDensity = density;
        // ---------- Original Method ----------
        //mDensity = density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.264 -0400", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "84E478FF6E7328C663D71E05433F8696")
    public void setNinePatchChunk(byte[] chunk) {
        mNinePatchChunk = chunk;
        // ---------- Original Method ----------
        //mNinePatchChunk = chunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.265 -0400", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "C80B2A72009FC42545A99B19062C110C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.266 -0400", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "7EED040F8007C93F30B1449EBAD00B2C")
    public final boolean isRecycled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635307374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635307374;
        // ---------- Original Method ----------
        //return mRecycled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.277 -0400", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "D4FFBB26D9817546BE7A57FC32FFA3BA")
    public int getGenerationId() {
        int var212795BBF0B899D6098254B7268EC186_1744175213 = (nativeGenerationId(mNativeBitmap));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244696501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1244696501;
        // ---------- Original Method ----------
        //return nativeGenerationId(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.277 -0400", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "2AB12235F54ED1E12298F2F9CAA69EE9")
    private void checkRecycled(String errorMessage) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(errorMessage);
        } //End block
        addTaint(errorMessage.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.293 -0400", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "146407FCE4CDDA3664C16DB380F5E497")
    public void copyPixelsToBuffer(Buffer dst) {
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
        addTaint(dst.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.305 -0400", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "2F6C2D07294357690DEE281EC82F91FE")
    public void copyPixelsFromBuffer(Buffer src) {
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
        addTaint(src.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.306 -0400", hash_original_method = "5A36626FB0A5325F859AD016AE482420", hash_generated_method = "87F8186BC12EED87B83787D0C90796E3")
    public Bitmap copy(Config config, boolean isMutable) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1412833540 = null; //Variable for return #1
        checkRecycled("Can't copy a recycled bitmap");
        Bitmap b;
        b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
        {
            b.mDensity = mDensity;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1412833540 = b;
        addTaint(config.getTaint());
        addTaint(isMutable);
        varB4EAC82CA7396A68D541C85D26508E83_1412833540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1412833540;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.331 -0400", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "0C1DF701C9074E141D4F3C4F20D4B840")
    public byte[] getNinePatchChunk() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1799517878 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1799517878;
        // ---------- Original Method ----------
        //return mNinePatchChunk;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.332 -0400", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "35E9075B2BA686217454827AF554F4F6")
    public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        checkRecycled("Can't compress a recycled bitmap");
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("quality must be 0..100");
        } //End block
        boolean varF801D4584D511A06756607336723DBB1_286192282 = (nativeCompress(mNativeBitmap, format.nativeInt, quality,
                              stream, new byte[WORKING_COMPRESS_STORAGE]));
        addTaint(format.getTaint());
        addTaint(quality);
        addTaint(stream.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1753576354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1753576354;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.333 -0400", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "88D8B4EB1E8E78E52EB31A37E27A53A6")
    public final boolean isMutable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224137463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224137463;
        // ---------- Original Method ----------
        //return mIsMutable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.334 -0400", hash_original_method = "9273E6434E2E49D8D6A7BEF0351E82F0", hash_generated_method = "655A050AE575AEBEC761DEA910A268D6")
    public final int getWidth() {
        {
            Object var14BFC634F145725DC48467A508F60C75_1682064721 = (mWidth = nativeWidth(mNativeBitmap));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260419888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260419888;
        // ---------- Original Method ----------
        //return mWidth == -1 ? mWidth = nativeWidth(mNativeBitmap) : mWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.347 -0400", hash_original_method = "C9C832E0F45CC5A7AD0241E8F16710F4", hash_generated_method = "FCCD5092FFEDD765288FD54F98096F35")
    public final int getHeight() {
        {
            Object varA90DB7D8C83D02A678AC88E3CF32E02C_1610092179 = (mHeight = nativeHeight(mNativeBitmap));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895466190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895466190;
        // ---------- Original Method ----------
        //return mHeight == -1 ? mHeight = nativeHeight(mNativeBitmap) : mHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.347 -0400", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "49A098652F822318E98835D06719204B")
    public int getScaledWidth(Canvas canvas) {
        int varD244B19BB376C166F704354639F6FD2A_1297702617 = (scaleFromDensity(getWidth(), mDensity, canvas.mDensity));
        addTaint(canvas.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215537693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215537693;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.351 -0400", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "C427D042D62DB92FB8954194F8CC5EB6")
    public int getScaledHeight(Canvas canvas) {
        int var9C7679314AF2CB28ACC9E6D9F7DBE7C8_132659379 = (scaleFromDensity(getHeight(), mDensity, canvas.mDensity));
        addTaint(canvas.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137561514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137561514;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.363 -0400", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "08372FC8006F0DACB624F7297670C970")
    public int getScaledWidth(DisplayMetrics metrics) {
        int var22DDB9F91A59073EC3D37288D06D89F5_759227373 = (scaleFromDensity(getWidth(), mDensity, metrics.densityDpi));
        addTaint(metrics.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51552522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51552522;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.364 -0400", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "E502A4F3FD2DC516202335D9FFED1B35")
    public int getScaledHeight(DisplayMetrics metrics) {
        int varBC7E5446A696D0B9C3151FDCC509001B_442808745 = (scaleFromDensity(getHeight(), mDensity, metrics.densityDpi));
        addTaint(metrics.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394563417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394563417;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, metrics.densityDpi);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.365 -0400", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "CD3F21A98A9F2B7923C766D56022EBDE")
    public int getScaledWidth(int targetDensity) {
        int var40BBFFD6794B3ABECF2108DE9A398793_1752960963 = (scaleFromDensity(getWidth(), mDensity, targetDensity));
        addTaint(targetDensity);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668047468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668047468;
        // ---------- Original Method ----------
        //return scaleFromDensity(getWidth(), mDensity, targetDensity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.369 -0400", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "4744F0B66A0239E793260EC7A0ABD030")
    public int getScaledHeight(int targetDensity) {
        int varEBBA22F03E55C884FB7BC5702A806353_1618169140 = (scaleFromDensity(getHeight(), mDensity, targetDensity));
        addTaint(targetDensity);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145405757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145405757;
        // ---------- Original Method ----------
        //return scaleFromDensity(getHeight(), mDensity, targetDensity);
    }

    
        static public int scaleFromDensity(int size, int sdensity, int tdensity) {
        if (sdensity == DENSITY_NONE || sdensity == tdensity) {
            return size;
        }
        return ((size * tdensity) + (sdensity >> 1)) / sdensity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.381 -0400", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "AEEE8A8149353100B22DCE664E561CBB")
    public final int getRowBytes() {
        int var0267412FC813FD8E20B12B849B0C1F93_1516551139 = (nativeRowBytes(mNativeBitmap));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966751042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966751042;
        // ---------- Original Method ----------
        //return nativeRowBytes(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.383 -0400", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "7E847512EFE40732E946CFE199850890")
    public final int getByteCount() {
        int var18558EEEC9B7BD46FC1B51B2AC00445A_68599911 = (getRowBytes() * getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189760378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189760378;
        // ---------- Original Method ----------
        //return getRowBytes() * getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.481 -0400", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "419008780241F2B025AF8D86FC5B5F9E")
    public final Config getConfig() {
        Config varB4EAC82CA7396A68D541C85D26508E83_1136915578 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1136915578 = Config.nativeToConfig(nativeConfig(mNativeBitmap));
        varB4EAC82CA7396A68D541C85D26508E83_1136915578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1136915578;
        // ---------- Original Method ----------
        //return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.482 -0400", hash_original_method = "A9E6FFBE96B704702B1F2A7EDD472B86", hash_generated_method = "752528D883E320D47F764150FD62ACDD")
    public final boolean hasAlpha() {
        boolean var800F787096C2FAD492BB45AE9E7A91D2_958485895 = (nativeHasAlpha(mNativeBitmap));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810055308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810055308;
        // ---------- Original Method ----------
        //return nativeHasAlpha(mNativeBitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.483 -0400", hash_original_method = "9BF8F5FAA617B68A4287E64028C24BC4", hash_generated_method = "060ADFF4E1C348B48F39DF28EE5C5091")
    public void setHasAlpha(boolean hasAlpha) {
        nativeSetHasAlpha(mNativeBitmap, hasAlpha);
        addTaint(hasAlpha);
        // ---------- Original Method ----------
        //nativeSetHasAlpha(mNativeBitmap, hasAlpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.489 -0400", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "62012FC4098F2FE07CC99DD8EBC30DF7")
    public void eraseColor(int c) {
        checkRecycled("Can't erase a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_138087843 = (!isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cannot erase immutable bitmaps");
            } //End block
        } //End collapsed parenthetic
        nativeErase(mNativeBitmap, c);
        addTaint(c);
        // ---------- Original Method ----------
        //checkRecycled("Can't erase a recycled bitmap");
        //if (!isMutable()) {
            //throw new IllegalStateException("cannot erase immutable bitmaps");
        //}
        //nativeErase(mNativeBitmap, c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.490 -0400", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "AB252C31227A69E74DE04E987ABE3FC6")
    public int getPixel(int x, int y) {
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(x, y);
        int var8FD6BA845BC7C15EFB43BAC7ED016EA5_506807222 = (nativeGetPixel(mNativeBitmap, x, y));
        addTaint(x);
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287456015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287456015;
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixel() on a recycled bitmap");
        //checkPixelAccess(x, y);
        //return nativeGetPixel(mNativeBitmap, x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.504 -0400", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "DAA2C23B9860580B8248F11EFA967D40")
    public void getPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        checkRecycled("Can't call getPixels() on a recycled bitmap");
        checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        nativeGetPixels(mNativeBitmap, pixels, offset, stride,
                        x, y, width, height);
        addTaint(pixels[0]);
        addTaint(offset);
        addTaint(stride);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //checkRecycled("Can't call getPixels() on a recycled bitmap");
        //if (width == 0 || height == 0) {
            //return; 
        //}
        //checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        //nativeGetPixels(mNativeBitmap, pixels, offset, stride,
                        //x, y, width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.505 -0400", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "322A37123DF337DB50959B256D3C27C5")
    private void checkPixelAccess(int x, int y) {
        checkXYSign(x, y);
        {
            boolean var30490CFCBE0CDDF5A434370B1DCE4F74_1754979517 = (x >= getWidth());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("x must be < bitmap.width()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var176BE51140078B0967F59852B69E3131_113176331 = (y >= getHeight());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("y must be < bitmap.height()");
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //checkXYSign(x, y);
        //if (x >= getWidth()) {
            //throw new IllegalArgumentException("x must be < bitmap.width()");
        //}
        //if (y >= getHeight()) {
            //throw new IllegalArgumentException("y must be < bitmap.height()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.519 -0400", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "EFE02BF31767FD5DCBD3512E5A4B6AAE")
    private void checkPixelsAccess(int x, int y, int width, int height,
                                   int offset, int stride, int pixels[]) {
        checkXYSign(x, y);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("width must be >= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("height must be >= 0");
        } //End block
        {
            boolean varD810B239D6120F6BE5AD1443109E34E9_710839296 = (x + width > getWidth());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "x + width must be <= bitmap.width()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var81DF503DAA371D07CDBF07C44BC00011_1382766051 = (y + height > getHeight());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "y + height must be <= bitmap.height()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE73A6561371F12118506FC78AF1B9D6D_502784841 = (Math.abs(stride) < width);
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
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
        addTaint(offset);
        addTaint(stride);
        addTaint(pixels);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.540 -0400", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "29A96EF4DA3890DF39516427D9077975")
    public void setPixel(int x, int y, int color) {
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_666834090 = (!isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
        } //End collapsed parenthetic
        checkPixelAccess(x, y);
        nativeSetPixel(mNativeBitmap, x, y, color);
        addTaint(x);
        addTaint(y);
        addTaint(color);
        // ---------- Original Method ----------
        //checkRecycled("Can't call setPixel() on a recycled bitmap");
        //if (!isMutable()) {
            //throw new IllegalStateException();
        //}
        //checkPixelAccess(x, y);
        //nativeSetPixel(mNativeBitmap, x, y, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.570 -0400", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "5B80FA3EACC17411B3E8DC74FC889282")
    public void setPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        {
            boolean var2D2A74E00B0F4ADB63FC14E0244B334F_856528664 = (!isMutable());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
        } //End collapsed parenthetic
        checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        nativeSetPixels(mNativeBitmap, pixels, offset, stride,
                        x, y, width, height);
        addTaint(pixels[0]);
        addTaint(offset);
        addTaint(stride);
        addTaint(x);
        addTaint(y);
        addTaint(width);
        addTaint(height);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.570 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3268CEE7B38E7FF8242E45C8B2D4D56C")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646615195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646615195;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.571 -0400", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "BFEC6641D2F6A0B1FA4E64BD790D5EF1")
    public void writeToParcel(Parcel p, int flags) {
        checkRecycled("Can't parcel a recycled bitmap");
        {
            boolean var5DF242B1AD49EA84F890A63696D1516F_122979072 = (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p));
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("native writeToParcel failed");
            } //End block
        } //End collapsed parenthetic
        addTaint(p.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //checkRecycled("Can't parcel a recycled bitmap");
        //if (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p)) {
            //throw new RuntimeException("native writeToParcel failed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.573 -0400", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "4CC3615FFCD09957F114442A407F6A66")
    public Bitmap extractAlpha() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_3166761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_3166761 = extractAlpha(null, null);
        varB4EAC82CA7396A68D541C85D26508E83_3166761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3166761;
        // ---------- Original Method ----------
        //return extractAlpha(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.602 -0400", hash_original_method = "798FC3DD232FCC4B06F4415625A8D213", hash_generated_method = "EB3B383F76284313245727F023756051")
    public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_424088667 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_424088667 = bm;
        addTaint(paint.getTaint());
        addTaint(offsetXY[0]);
        varB4EAC82CA7396A68D541C85D26508E83_424088667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424088667;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.603 -0400", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "BDA0F4D167CDC7555D67998D4D1D6D91")
    public boolean sameAs(Bitmap other) {
        boolean var573FBB3F9978D0C6C4756653011FAC34_1079279290 = (this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap)));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371499247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371499247;
        // ---------- Original Method ----------
        //return this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.633 -0400", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "EDCD1A3F0894A6577A12906075EDF3F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.708 -0400", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "6936CFAE8347F767AB9C5B0D61C18161")
    final int ni() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695900844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695900844;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.708 -0400", hash_original_field = "F16492AD902BDE58E3AAF1B990115133", hash_generated_field = "94EBE634EB926388C6FE9311F8ADAABA")

        private int mNativeBitmap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.709 -0400", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "2ABFC00A38D50D88F77B67505EB4A344")
          BitmapFinalizer(int nativeBitmap) {
            mNativeBitmap = nativeBitmap;
            // ---------- Original Method ----------
            //mNativeBitmap = nativeBitmap;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.724 -0400", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "F7615B068DA183F6083E4BBEA97826DB")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.738 -0400", hash_original_field = "C71478846957767201391E31D504F7CF", hash_generated_field = "C25FA99E764685711DDB1FEBC88ADFFB")

    public static final int DENSITY_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.738 -0400", hash_original_field = "5B7CE7C3B907236423F83FB7C4C74DB5", hash_generated_field = "1395EEF7EE47C17BCE3B8566023F33E1")

    private static volatile Matrix sScaleMatrix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.738 -0400", hash_original_field = "9F8879FC7AE169BC092D1EE3BC2FBD08", hash_generated_field = "9A5692A5868FC9DC94E238F1418014E4")

    private static volatile int sDefaultDensity = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.738 -0400", hash_original_field = "295B0C9790BF4CF54082ACBBD1BFA817", hash_generated_field = "C9F7B201311A3190137BEECBC5C7FABB")

    private static int WORKING_COMPRESS_STORAGE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:11.738 -0400", hash_original_field = "BF846A98932B20D726C6F01DDC8F3632", hash_generated_field = "5962E9DA47CF5849E5C813893A51D279")

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
}

