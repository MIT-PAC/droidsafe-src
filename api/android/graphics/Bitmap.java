package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * For backwards compatibility, allows the app layer to change the default
     * density when running old apps.
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.722 -0500", hash_original_method = "B71B8E0736B550F2E28E3A81592DC389", hash_generated_method = "BD8D5DF9B38E5690B0479B016893F0D8")
    
public static void setDefaultDensity(int density) {
        sDefaultDensity = density;
    }
    
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.724 -0500", hash_original_method = "E8FCDB013EBE57EEE864D06A44E64265", hash_generated_method = "B3DA9FCCEA9F2AB0232A3F5C8CDBC9F7")
    
static int getDefaultDensity() {
        if (sDefaultDensity >= 0) {
            return sDefaultDensity;
        }
        sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
        return sDefaultDensity;
    }

    /**
     * Common code for checking that x and y are >= 0
     *
     * @param x x coordinate to ensure is >= 0
     * @param y y coordinate to ensure is >= 0
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.745 -0500", hash_original_method = "D40C73AF8AE1E0F0F229FF274F9DE7E5", hash_generated_method = "14CB1ECB646B90D7A8DFB5948E78C4F9")
    
private static void checkXYSign(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    /**
     * Common code for checking that width and height are > 0
     *
     * @param width  width to ensure is > 0
     * @param height height to ensure is > 0
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.748 -0500", hash_original_method = "99B682048D7DD6F5E24E9EE3CDE8B326", hash_generated_method = "FC25CC9E9401E5DB446A7AA86CBFDC89")
    
private static void checkWidthHeight(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    /**
     * Creates a new bitmap, scaled from an existing bitmap.
     *
     * @param src       The source bitmap.
     * @param dstWidth  The new bitmap's desired width.
     * @param dstHeight The new bitmap's desired height.
     * @param filter    true if the source should be filtered.
     * @return the new scaled bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.785 -0500", hash_original_method = "9B9D815856FF54261FC90101B85ADFB3", hash_generated_method = "C9E1186290E6D03B836F1EEEF07AEE04")
    
public static Bitmap createScaledBitmap(Bitmap src, int dstWidth,
            int dstHeight, boolean filter) {
        Matrix m;
        synchronized (Bitmap.class) {
            // small pool of just 1 matrix
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
            // do we need to check for null? why not just assign everytime?
            if (sScaleMatrix == null) {
                sScaleMatrix = m;
            }
        }

        return b;
    }

    /**
     * Returns an immutable bitmap from the source bitmap. The new bitmap may
     * be the same object as source, or a copy may have been made.  It is
     * initialized with the same density as the original bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.787 -0500", hash_original_method = "06B3F44E32866DFBBA409CE7EBE78C90", hash_generated_method = "69140569706508A2D71FA6D606AC28D8")
    
public static Bitmap createBitmap(Bitmap src) {
        return createBitmap(src, 0, 0, src.getWidth(), src.getHeight());
    }

    /**
     * Returns an immutable bitmap from the specified subset of the source
     * bitmap. The new bitmap may be the same object as source, or a copy may
     * have been made.  It is
     * initialized with the same density as the original bitmap.
     *
     * @param source   The bitmap we are subsetting
     * @param x        The x coordinate of the first pixel in source
     * @param y        The y coordinate of the first pixel in source
     * @param width    The number of pixels in each row
     * @param height   The number of rows
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.789 -0500", hash_original_method = "FDCB5D0AAFA9E01A4FEEBED763708DF4", hash_generated_method = "0310C45601B1271997169FB3A2B77AE7")
    
public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height) {
        return createBitmap(source, x, y, width, height, null, false);
    }

    /**
     * Returns an immutable bitmap from subset of the source bitmap,
     * transformed by the optional matrix.  It is
     * initialized with the same density as the original bitmap.
     *
     * @param source   The bitmap we are subsetting
     * @param x        The x coordinate of the first pixel in source
     * @param y        The y coordinate of the first pixel in source
     * @param width    The number of pixels in each row
     * @param height   The number of rows
     * @param m        Optional matrix to be applied to the pixels
     * @param filter   true if the source should be filtered.
     *                   Only applies if the matrix contains more than just
     *                   translation.
     * @return A bitmap that represents the specified subset of source
     * @throws IllegalArgumentException if the x, y, width, height values are
     *         outside of the dimensions of the source bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.792 -0500", hash_original_method = "2890F109635B7BA47A6C3B31AD4C0C33", hash_generated_method = "5E5AAE5AD4DB8799AE28E84D198E7FB9")
    
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

        // check if we can just return our argument unchanged
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
        // GIF files generate null configs, assume ARGB_8888
        if (config != null) {
            switch (config) {
                case RGB_565:
                    newConfig = Config.RGB_565;
                    break;
                case ALPHA_8:
                    newConfig = Config.ALPHA_8;
                    break;
                //noinspection deprecation
                case ARGB_4444:
                case ARGB_8888:
                default:
                    newConfig = Config.ARGB_8888;
                    break;
            }
        }

        if (m == null || m.isIdentity()) {
            bitmap = createBitmap(neww, newh, newConfig, source.hasAlpha());
            paint = null;   // not needed
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
        
        // The new bitmap was created from a known bitmap source so assume that
        // they use the same density
        bitmap.mDensity = source.mDensity;
        
        canvas.setBitmap(bitmap);
        canvas.drawBitmap(source, srcR, dstR, paint);
        canvas.setBitmap(null);
        bitmap.addTaint(source.getTaint());
        return bitmap;
    }

    /**
     * Returns a mutable bitmap with the specified width and height.  Its
     * initial density is as per {@link #getDensity}.
     *
     * @param width    The width of the bitmap
     * @param height   The height of the bitmap
     * @param config   The bitmap config to create.
     * @throws IllegalArgumentException if the width or height are <= 0
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.795 -0500", hash_original_method = "A69C1A6B363DCF14C299E4864CF77D03", hash_generated_method = "6FF2BF773051FD6D6A1B48DF50C9FDD4")
    
public static Bitmap createBitmap(int width, int height, Config config) {
        return createBitmap(width, height, config, true);
    }

    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD) 
    @DSComment("Private Method")
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

    /**
     * Returns a immutable bitmap with the specified width and height, with each
     * pixel value set to the corresponding value in the colors array.  Its
     * initial density is as per {@link #getDensity}.
     *
     * @param colors   Array of {@link Color} used to initialize the pixels.
     * @param offset   Number of values to skip before the first color in the
     *                 array of colors.
     * @param stride   Number of colors in the array between rows (must be >=
     *                 width or <= -width).
     * @param width    The width of the bitmap
     * @param height   The height of the bitmap
     * @param config   The bitmap config to create. If the config does not
     *                 support per-pixel alpha (e.g. RGB_565), then the alpha
     *                 bytes in the colors[] will be ignored (assumed to be FF)
     * @throws IllegalArgumentException if the width or height are <= 0, or if
     *         the color array's length is less than the number of pixels.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.800 -0500", hash_original_method = "3025C3F86E2BC308BDBF4BB36F710549", hash_generated_method = "C5B6A54165DF6B416215E521BC50CE65")
    
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

    /**
     * Returns a immutable bitmap with the specified width and height, with each
     * pixel value set to the corresponding value in the colors array.  Its
     * initial density is as per {@link #getDensity}.
     *
     * @param colors   Array of {@link Color} used to initialize the pixels.
     *                 This array must be at least as large as width * height.
     * @param width    The width of the bitmap
     * @param height   The height of the bitmap
     * @param config   The bitmap config to create. If the config does not
     *                 support per-pixel alpha (e.g. RGB_565), then the alpha
     *                 bytes in the colors[] will be ignored (assumed to be FF)
     * @throws IllegalArgumentException if the width or height are <= 0, or if
     *         the color array's length is less than the number of pixels.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.802 -0500", hash_original_method = "0687CE6A4B07D857B75A84209513431A", hash_generated_method = "26A1CBF4DD06B2FCE6D7F82EE8B64B69")
    
public static Bitmap createBitmap(int colors[], int width, int height, Config config) {
        return createBitmap(colors, 0, width, width, height, config);
    }
    
    /**
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.839 -0500", hash_original_method = "2A2576D052362766C414172B545A5E98", hash_generated_method = "E70553BB69497E15AE7FE118572DC695")
    
static public int scaleFromDensity(int size, int sdensity, int tdensity) {
        if (sdensity == DENSITY_NONE || sdensity == tdensity) {
            return size;
        }
        
        // Scale by tdensity / sdensity, rounding up.
        return ((size * tdensity) + (sdensity >> 1)) / sdensity;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDestructor(int nativeBitmap) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRecycle(int nativeBitmap) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeCompress(int nativeBitmap, int format,
                                            int quality, OutputStream stream,
                                            byte[] tempStorage) {
        stream.addTaint(nativeBitmap + format + quality);
        tempStorage.addTaint(nativeBitmap + format + quality);
        return stream.getTaintBoolean();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeErase(int nativeBitmap, int color) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeWidth(int nativeBitmap) {
        return nativeBitmap;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeHeight(int nativeBitmap) {
        return nativeBitmap;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeRowBytes(int nativeBitmap) {
        return nativeBitmap;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeConfig(int nativeBitmap) {
        return nativeBitmap;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeHasAlpha(int nativeBitmap) {
        return toTaintBoolean(nativeBitmap);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetPixel(int nativeBitmap, int x, int y) {
        return nativeBitmap + x + y;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeGetPixels(int nativeBitmap, int[] pixels,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetPixel(int nativeBitmap, int x, int y,
                                              int color) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetPixels(int nativeBitmap, int[] colors,
                                               int offset, int stride, int x,
                                               int y, int width, int height) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeCopyPixelsToBuffer(int nativeBitmap,
                                                        Buffer dst) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeCopyPixelsFromBuffer(int nb, Buffer src) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGenerationId(int nativeBitmap) {
        return nativeBitmap;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Bitmap nativeCreateFromParcel(Parcel p) {
    	Bitmap b = new Bitmap();
    	b.addTaint(p.getTaint());
    	return b;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeWriteToParcel(int nativeBitmap,
                                                      boolean isMutable,
                                                      int density,
                                                      Parcel p) {
        p.addTaint(nativeBitmap + density);
        p.addTaint(isMutable);
        return p.getTaintBoolean();
    }
    
    /*
    private static Bitmap nativeExtractAlpha(int nativeBitmap,
                                                    int nativePaint,
                                                    int[] offsetXY) {
                //DSFIXME:  Can't synthesize return for advanced types
    }
    */
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativePrepareToDraw(int nativeBitmap) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetHasAlpha(int nBitmap, boolean hasAlpha) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeSameAs(int nb0, int nb1) {
                return toTaintBoolean(nb0 + nb1);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.696 -0500", hash_original_field = "E311D4441C2D20ABF50E7FA2BB4DEE17", hash_generated_field = "C25FA99E764685711DDB1FEBC88ADFFB")

    public static final int DENSITY_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.718 -0500", hash_original_field = "CFCD56283073E32E1C9092301DCE796A", hash_generated_field = "1395EEF7EE47C17BCE3B8566023F33E1")

    private static volatile Matrix sScaleMatrix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.720 -0500", hash_original_field = "08E7DDEBC5FDC03CF80B65E4314BFBE0", hash_generated_field = "9A5692A5868FC9DC94E238F1418014E4")

    private static volatile int sDefaultDensity = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.814 -0500", hash_original_field = "7B29D9E558DDC2DCAE77682B3E8DE6BE", hash_generated_field = "835CBF2BDF2BE37014A11526CBB54378")

    private final static int WORKING_COMPRESS_STORAGE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:31.817 -0400", hash_original_field = "BF846A98932B20D726C6F01DDC8F3632", hash_generated_field = "5962E9DA47CF5849E5C813893A51D279")

    public static final Parcelable.Creator<Bitmap> CREATOR
            = new Parcelable.Creator<Bitmap>() {
        /**
         * Rebuilds a bitmap previously stored with writeToParcel().
         *
         * @param p    Parcel object to read the bitmap from
         * @return a new bitmap created from the data in the parcel
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.869 -0500", hash_original_method = "A576610C1F5A8AE8D31C4E9A14C2AA39", hash_generated_method = "D8C5F10FF7DDB7A0C2AAF5AD8A55B3CB")
        
public Bitmap createFromParcel(Parcel p) {
            Bitmap bm = nativeCreateFromParcel(p);
            if (bm == null) {
                throw new RuntimeException("Failed to unparcel Bitmap");
            }
            return bm;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.873 -0500", hash_original_method = "9D41A73AB5270B44257816A57AEF6E94", hash_generated_method = "3E9300FD879263748D14C8F6F289EA60")
        
public Bitmap[] newArray(int size) {
            return new Bitmap[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.698 -0500", hash_original_field = "D5AB511585FB0D17B787E16D99235382", hash_generated_field = "44187EAF844F975F9CC351362B5828D9")

    public  int mNativeBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.701 -0500", hash_original_field = "2CD4551D9C8A0105C8859C776CE5F7D1", hash_generated_field = "D26E89192452D152F1B0620ACC981170")

    public byte[] mBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.703 -0500", hash_original_field = "985F825340A09E3D006E002226BC17BE", hash_generated_field = "CC1DE3CC2B60AFAC583C7184467064B8")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) // Keep to finalize native resources
    private  BitmapFinalizer mFinalizer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.705 -0500", hash_original_field = "EB33F13BCFFE36BF9E70CC6E979039BC", hash_generated_field = "9C32056DAC69AD0374E74408422BBEB9")

    private  boolean mIsMutable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.707 -0500", hash_original_field = "98BBAF5C54FE60C06B4D57BFEDAFFC26", hash_generated_field = "436C2ED570DD3AA7577644DBEE1CE62A")

    private byte[] mNinePatchChunk;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.709 -0500", hash_original_field = "2BA03B5BE1E097B9BC57B210061D879D", hash_generated_field = "E5A03441D6069228A477C954385A251B")

    private int mWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.711 -0500", hash_original_field = "3D81262840DA37820D58425FC486E30D", hash_generated_field = "799F7A00E6DAB63292A42CD8E01B88BC")

    private int mHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.713 -0500", hash_original_field = "54377D1FA2AD41427FB83B9E454546B7", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.715 -0500", hash_original_field = "DFE44862C379A23055CB9029F03233AE", hash_generated_field = "13C2BF9DA24161DE6F71FD4838E7C5D0")

    /*package*/ int mDensity = sDefaultDensity = getDefaultDensity();
    
    /**
     * @noinspection UnusedDeclaration
     */
    /*  Private constructor that must received an already allocated native
        bitmap int (pointer).

        This can be called from JNI code.
    */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.728 -0500", hash_original_method = "99AF26591A06E5269F88FBD6B3710F13", hash_generated_method = "4487B78C73BD0FA2364AF10891205036")
    
Bitmap(int nativeBitmap, byte[] buffer, boolean isMutable, byte[] ninePatchChunk,
            int density) {
        if (nativeBitmap == 0) {
            throw new RuntimeException("internal error: native bitmap is 0");
        }

        mBuffer = buffer;
        // we delete this in our finalizer
        mNativeBitmap = nativeBitmap;
        mFinalizer = new BitmapFinalizer(nativeBitmap);

        mIsMutable = isMutable;
        mNinePatchChunk = ninePatchChunk;
        if (density >= 0) {
            mDensity = density;
        }
    }
    
    // orphaned legacy method
    
	@DSSafe(DSCat.SAFE_OTHERS)
    public Bitmap() {
		super();
		//Doesn't exist in the real class but was showing up in specdump
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDensity() {
		return getTaintInt();
        //return mDensity;
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void setDensity(int density) {
		addTaint(density);
        //mDensity = density;
    }
    
    /**
     * Sets the nine patch chunk.
     *
     * @param chunk The definition of the nine patch
     *
     * @hide
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.734 -0500", hash_original_method = "30CA035C727F2D2385273CE8F87AAA35", hash_generated_method = "BF4F8C8B096A68BB15084DBA06C1C50A")
    
public void setNinePatchChunk(byte[] chunk) {
        mNinePatchChunk = chunk;
    }

    /**
     * Free the native object associated with this bitmap, and clear the
     * reference to the pixel data. This will not free the pixel data synchronously;
     * it simply allows it to be garbage collected if there are no other references.
     * The bitmap is marked as "dead", meaning it will throw an exception if
     * getPixels() or setPixels() is called, and will draw nothing. This operation
     * cannot be reversed, so it should only be called if you are sure there are no
     * further uses for the bitmap. This is an advanced call, and normally need
     * not be called, since the normal GC process will free up this memory when
     * there are no more references to this bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.736 -0500", hash_original_method = "F143F03043BA4507E1E78FA3303F668C", hash_generated_method = "E01AC0430679ABAA5EC7EB2A86CE700F")
    
public void recycle() {
        if (!mRecycled) {
            mBuffer = null;
            nativeRecycle(mNativeBitmap);
            mNinePatchChunk = null;
            mRecycled = true;
        }
    }

    /**
     * Returns true if this bitmap has been recycled. If so, then it is an error
     * to try to access its pixels, and the bitmap will not draw.
     *
     * @return true if the bitmap has been recycled
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.739 -0500", hash_original_method = "B80D9A696720D276C6AF21D39513741E", hash_generated_method = "3B7D242B0C48B41C862F19CA428991BF")
    
public final boolean isRecycled() {
        return mRecycled;
    }

    /**
     * Returns the generation ID of this bitmap. The generation ID changes
     * whenever the bitmap is modified. This can be used as an efficient way to
     * check if a bitmap has changed.
     * 
     * @return The current generation ID for this bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.741 -0500", hash_original_method = "9DF0E31331C580F9A696941C282E8CDA", hash_generated_method = "85760E95A75AA3C421422E07B28E3124")
    
public int getGenerationId() {
        return nativeGenerationId(mNativeBitmap);
    }
    
    /**
     * This is called by methods that want to throw an exception if the bitmap
     * has already been recycled.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.743 -0500", hash_original_method = "C3E161F555FEE180C4B024634334055B", hash_generated_method = "63136E4B87B672F65F22860C3C9A36F0")
    
private void checkRecycled(String errorMessage) {
        if (mRecycled) {
            throw new IllegalStateException(errorMessage);
        }
    }

    /**
     * Copy the bitmap's pixels into the specified buffer (allocated by the
     * caller). An exception is thrown if the buffer is not large enough to
     * hold all of the pixels (taking into account the number of bytes per
     * pixel) or if the Buffer subclass is not one of the support types
     * (ByteBuffer, ShortBuffer, IntBuffer).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.776 -0500", hash_original_method = "6E96276EBE2927D59F0A224BEB5CF764", hash_generated_method = "AC3C3226CA3E5B6CF253BFCC09D13D8B")
    
public void copyPixelsToBuffer(Buffer dst) {
        int elements = dst.remaining();
        int shift;
        if (dst instanceof ByteBuffer) {
            shift = 0;
        } else if (dst instanceof ShortBuffer) {
            shift = 1;
        } else if (dst instanceof IntBuffer) {
            shift = 2;
        } else {
            throw new RuntimeException("unsupported Buffer subclass");
        }

        long bufferSize = (long)elements << shift;
        long pixelSize = getByteCount();

        if (bufferSize < pixelSize) {
            throw new RuntimeException("Buffer not large enough for pixels");
        }

        nativeCopyPixelsToBuffer(mNativeBitmap, dst);

        // now update the buffer's position
        int position = dst.position();
        position += pixelSize >> shift;
        dst.position(position);
    }

    /**
     * Copy the pixels from the buffer, beginning at the current position,
     * overwriting the bitmap's pixels. The data in the buffer is not changed
     * in any way (unlike setPixels(), which converts from unpremultipled 32bit
     * to whatever the bitmap's native format is.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.780 -0500", hash_original_method = "DF4D046D4E3EE4FA52893B437F7EAF42", hash_generated_method = "6B46B4700A32DA071066C28BB4046251")
    
public void copyPixelsFromBuffer(Buffer src) {
        checkRecycled("copyPixelsFromBuffer called on recycled bitmap");

        int elements = src.remaining();
        int shift;
        if (src instanceof ByteBuffer) {
            shift = 0;
        } else if (src instanceof ShortBuffer) {
            shift = 1;
        } else if (src instanceof IntBuffer) {
            shift = 2;
        } else {
            throw new RuntimeException("unsupported Buffer subclass");
        }

        long bufferBytes = (long)elements << shift;
        long bitmapBytes = getByteCount();

        if (bufferBytes < bitmapBytes) {
            throw new RuntimeException("Buffer not large enough for pixels");
        }

        nativeCopyPixelsFromBuffer(mNativeBitmap, src);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
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
        var73F89FAC8F369DF0913D10C37C1E0EA1_36661561.addTaint(getTaint());
        return var73F89FAC8F369DF0913D10C37C1E0EA1_36661561;
        // ---------- Original Method ----------
        //checkRecycled("Can't copy a recycled bitmap");
        //Bitmap b = nativeCopy(mNativeBitmap, config.nativeInt, isMutable);
        //if (b != null) {
            //b.mDensity = mDensity;
        //}
        //return b;
    }

    /**
     * Returns an optional array of private data, used by the UI system for
     * some bitmaps. Not intended to be called by applications.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.804 -0500", hash_original_method = "FE9BA3F148B3AC85DF389A396D130B66", hash_generated_method = "97032EFFCF25517FA2368B748F52B616")
    
public byte[] getNinePatchChunk() {
        return mNinePatchChunk;
    }

    /**
     * Write a compressed version of the bitmap to the specified outputstream.
     * If this returns true, the bitmap can be reconstructed by passing a
     * corresponding inputstream to BitmapFactory.decodeStream(). Note: not
     * all Formats support all bitmap configs directly, so it is possible that
     * the returned bitmap from BitmapFactory could be in a different bitdepth,
     * and/or may have lost per-pixel alpha (e.g. JPEG only supports opaque
     * pixels).
     *
     * @param format   The format of the compressed image
     * @param quality  Hint to the compressor, 0-100. 0 meaning compress for
     *                 small size, 100 meaning compress for max quality. Some
     *                 formats, like PNG which is lossless, will ignore the
     *                 quality setting
     * @param stream   The outputstream to write the compressed data.
     * @return true if successfully compressed to the specified stream.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.816 -0500", hash_original_method = "222D378B2B8943C109AD4B8264ED828B", hash_generated_method = "1EEF55911D982D9804A2FF9D6A90314B")
    
public boolean compress(CompressFormat format, int quality, OutputStream stream) {
        checkRecycled("Can't compress a recycled bitmap");
        // do explicit check before calling the native method
        if (stream == null) {
            throw new NullPointerException();
        }
        if (quality < 0 || quality > 100) {
            throw new IllegalArgumentException("quality must be 0..100");
        }
        
        stream.addTaint(this.getTaint());
        byte[] array = new byte[WORKING_COMPRESS_STORAGE];
        array[0] = (byte)this.getTaintInt();
        return nativeCompress(mNativeBitmap, format.nativeInt, quality,
                              stream, array);
    }

    /**
     * Returns true if the bitmap is marked as mutable (i.e. can be drawn into)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.818 -0500", hash_original_method = "AC5E4B63287018AAA83AB6875AD71BA5", hash_generated_method = "38CA8B036CBBB3AD7D2A23EA40E8CEEF")
    
public final boolean isMutable() {
        return mIsMutable;
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    public int getWidth() {
		//Synthetic method in order to track width taints, which are managed in native code
		return getTaintInt();
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    public int getHeight() {
		//Synthetic method in order to track height taints, which are managed in native code
		return getTaintInt();
	}

    /**
     * Convenience for calling {@link #getScaledWidth(int)} with the target
     * density of the given {@link Canvas}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.825 -0500", hash_original_method = "7233800DBE61288AC88E6F84763631F6", hash_generated_method = "ACC16BEE4B4E788185BD7EA076BF51AA")
    
public int getScaledWidth(Canvas canvas) {
        return scaleFromDensity(getWidth(), mDensity, canvas.mDensity);
    }

    /**
     * Convenience for calling {@link #getScaledHeight(int)} with the target
     * density of the given {@link Canvas}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.828 -0500", hash_original_method = "25E674A6C63D1170FDA7E606406CA68F", hash_generated_method = "11AC57182B11926AAE99738B571306AD")
    
public int getScaledHeight(Canvas canvas) {
        return scaleFromDensity(getHeight(), mDensity, canvas.mDensity);
    }

    /**
     * Convenience for calling {@link #getScaledWidth(int)} with the target
     * density of the given {@link DisplayMetrics}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.830 -0500", hash_original_method = "1717C0FEBD5DCA9C8E6AC6E449CF9117", hash_generated_method = "6CCE0902C57801B6AB082F09CC1E5582")
    
public int getScaledWidth(DisplayMetrics metrics) {
        return scaleFromDensity(getWidth(), mDensity, metrics.densityDpi);
    }

    /**
     * Convenience for calling {@link #getScaledHeight(int)} with the target
     * density of the given {@link DisplayMetrics}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.832 -0500", hash_original_method = "2419686B3EB221BCF5B58D4D017B048F", hash_generated_method = "6CF8E9503B1268E64CA3310E5FE67B18")
    
public int getScaledHeight(DisplayMetrics metrics) {
        return scaleFromDensity(getHeight(), mDensity, metrics.densityDpi);
    }

    /**
     * Convenience method that returns the width of this bitmap divided
     * by the density scale factor.
     *
     * @param targetDensity The density of the target canvas of the bitmap.
     * @return The scaled width of this bitmap, according to the density scale factor.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.834 -0500", hash_original_method = "8DEB28B38EE84627DD4FE42858F9882C", hash_generated_method = "0E36F2EEED524BD0FBB360B323E5C9D3")
    
public int getScaledWidth(int targetDensity) {
        return scaleFromDensity(getWidth(), mDensity, targetDensity);
    }

    /**
     * Convenience method that returns the height of this bitmap divided
     * by the density scale factor.
     *
     * @param targetDensity The density of the target canvas of the bitmap.
     * @return The scaled height of this bitmap, according to the density scale factor.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.837 -0500", hash_original_method = "936A1164B3B30000BDF78CB4ABE6FDD9", hash_generated_method = "F67900B636697F1C70C9A3A00376CBD4")
    
public int getScaledHeight(int targetDensity) {
        return scaleFromDensity(getHeight(), mDensity, targetDensity);
    }
    
    /**
     * Return the number of bytes between rows in the bitmap's pixels. Note that
     * this refers to the pixels as stored natively by the bitmap. If you call
     * getPixels() or setPixels(), then the pixels are uniformly treated as
     * 32bit values, packed according to the Color class.
     *
     * @return number of bytes between rows of the native bitmap pixels.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.841 -0500", hash_original_method = "12640FDEC394A62871A05E7C4EB570D4", hash_generated_method = "BBFD07EE1F9CFA496DF11A915661C176")
    
public final int getRowBytes() {
        return nativeRowBytes(mNativeBitmap);
    }

    /**
     * Returns the number of bytes used to store this bitmap's pixels.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.843 -0500", hash_original_method = "64813EB6D6A92E85FDB72E109CDAF838", hash_generated_method = "CF9E6B9E7EE252B92066038619B7CDBF")
    
public final int getByteCount() {
        // int result permits bitmaps up to 46,340 x 46,340
        return getRowBytes() * getHeight();
    }

    /**
     * If the bitmap's internal config is in one of the public formats, return
     * that config, otherwise return null.
     */
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.845 -0500", hash_original_method = "2965E803C3174189F0506D62E1B543D4", hash_generated_method = "8C8D5743BC9562CEC4C6371B676EA621")
    
public final Config getConfig() {
        return Config.nativeToConfig(nativeConfig(mNativeBitmap));
    }
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public boolean hasAlpha() {
		//Previous called into native code.  Since we are tracking the taint in, we can track it out
		return getTaintBoolean();
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    private void setHasAlpha(boolean hasAlpha) {
		//Synthetic method in order to track hasAlpha taints, which are managed in native code
		addTaint(hasAlpha);
	}

    /**
     * Fills the bitmap's pixels with the specified {@link Color}.
     *
     * @throws IllegalStateException if the bitmap is not mutable.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.852 -0500", hash_original_method = "6CFCC21E4A33E66B4CBA687A2872E721", hash_generated_method = "681D4694A3FD4097D73564A804777903")
    
public void eraseColor(int c) {
        checkRecycled("Can't erase a recycled bitmap");
        if (!isMutable()) {
            throw new IllegalStateException("cannot erase immutable bitmaps");
        }
        nativeErase(mNativeBitmap, c);
    }

    /**
     * Returns the {@link Color} at the specified location. Throws an exception
     * if x or y are out of bounds (negative or >= to the width or height
     * respectively).
     *
     * @param x    The x coordinate (0...width-1) of the pixel to return
     * @param y    The y coordinate (0...height-1) of the pixel to return
     * @return     The argb {@link Color} at the specified coordinate
     * @throws IllegalArgumentException if x, y exceed the bitmap's bounds
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.854 -0500", hash_original_method = "C5A0202C662F7E6C05A2B74C54AEFFD9", hash_generated_method = "EFFA5266C3DD741088C782B66E1F1119")
    
public int getPixel(int x, int y) {
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(x, y);
        return nativeGetPixel(mNativeBitmap, x, y);
    }

    /**
     * Returns in pixels[] a copy of the data in the bitmap. Each value is
     * a packed int representing a {@link Color}. The stride parameter allows
     * the caller to allow for gaps in the returned pixels array between
     * rows. For normal packed results, just pass width for the stride value.
     *
     * @param pixels   The array to receive the bitmap's colors
     * @param offset   The first index to write into pixels[]
     * @param stride   The number of entries in pixels[] to skip between
     *                 rows (must be >= bitmap's width). Can be negative.
     * @param x        The x coordinate of the first pixel to read from
     *                 the bitmap
     * @param y        The y coordinate of the first pixel to read from
     *                 the bitmap
     * @param width    The number of pixels to read from each row
     * @param height   The number of rows to read
     * @throws IllegalArgumentException if x, y, width, height exceed the
     *         bounds of the bitmap, or if abs(stride) < width.
     * @throws ArrayIndexOutOfBoundsException if the pixels array is too small
     *         to receive the specified number of pixels.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.857 -0500", hash_original_method = "2EE219697E28A03CE1E0A040D289D28E", hash_generated_method = "34D0ECB1DC18EA65D31355C5E9F2E98D")
    
public void getPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        checkRecycled("Can't call getPixels() on a recycled bitmap");
        if (width == 0 || height == 0) {
            return; // nothing to do
        }
        checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        nativeGetPixels(mNativeBitmap, pixels, offset, stride,
                        x, y, width, height);
    }

    /**
     * Shared code to check for illegal arguments passed to getPixel()
     * or setPixel()
     * @param x x coordinate of the pixel
     * @param y y coordinate of the pixel
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.859 -0500", hash_original_method = "F09D942FEC4FE9E75A7F8BD6FD9F7E4F", hash_generated_method = "27D2FD1D6305D649E1E762CC9C8D67B4")
    
private void checkPixelAccess(int x, int y) {
        checkXYSign(x, y);
        if (x >= getWidth()) {
            throw new IllegalArgumentException("x must be < bitmap.width()");
        }
        if (y >= getHeight()) {
            throw new IllegalArgumentException("y must be < bitmap.height()");
        }
    }

    /**
     * Shared code to check for illegal arguments passed to getPixels()
     * or setPixels()
     *
     * @param x left edge of the area of pixels to access
     * @param y top edge of the area of pixels to access
     * @param width width of the area of pixels to access
     * @param height height of the area of pixels to access
     * @param offset offset into pixels[] array
     * @param stride number of elements in pixels[] between each logical row
     * @param pixels array to hold the area of pixels being accessed
    */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.862 -0500", hash_original_method = "2B91B7FBA2B0FAF5EF0FAB9CE5B285D1", hash_generated_method = "0493EC789F1A82BF13E272C6288FC0E7")
    
private void checkPixelsAccess(int x, int y, int width, int height,
                                   int offset, int stride, int pixels[]) {
        checkXYSign(x, y);
        if (width < 0) {
            throw new IllegalArgumentException("width must be >= 0");
        }
        if (height < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        if (x + width > getWidth()) {
            throw new IllegalArgumentException(
                    "x + width must be <= bitmap.width()");
        }
        if (y + height > getHeight()) {
            throw new IllegalArgumentException(
                    "y + height must be <= bitmap.height()");
        }
        if (Math.abs(stride) < width) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }
        int lastScanline = offset + (height - 1) * stride;
        int length = pixels.length;
        if (offset < 0 || (offset + width > length)
                || lastScanline < 0
                || (lastScanline + width > length)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Write the specified {@link Color} into the bitmap (assuming it is
     * mutable) at the x,y coordinate.
     *
     * @param x     The x coordinate of the pixel to replace (0...width-1)
     * @param y     The y coordinate of the pixel to replace (0...height-1)
     * @param color The {@link Color} to write into the bitmap
     * @throws IllegalStateException if the bitmap is not mutable
     * @throws IllegalArgumentException if x, y are outside of the bitmap's
     *         bounds.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.864 -0500", hash_original_method = "85459627EEB2B6C6AD7EB511C3D7B6BB", hash_generated_method = "E77E619233DD0365AE14DA47202B7F88")
    
public void setPixel(int x, int y, int color) {
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        if (!isMutable()) {
            throw new IllegalStateException();
        }
        checkPixelAccess(x, y);
        nativeSetPixel(mNativeBitmap, x, y, color);
    }

    /**
     * Replace pixels in the bitmap with the colors in the array. Each element
     * in the array is a packed int prepresenting a {@link Color}
     *
     * @param pixels   The colors to write to the bitmap
     * @param offset   The index of the first color to read from pixels[]
     * @param stride   The number of colors in pixels[] to skip between rows.
     *                 Normally this value will be the same as the width of
     *                 the bitmap, but it can be larger (or negative).
     * @param x        The x coordinate of the first pixel to write to in
     *                 the bitmap.
     * @param y        The y coordinate of the first pixel to write to in
     *                 the bitmap.
     * @param width    The number of colors to copy from pixels[] per row
     * @param height   The number of rows to write to the bitmap
     * @throws IllegalStateException if the bitmap is not mutable
     * @throws IllegalArgumentException if x, y, width, height are outside of
     *         the bitmap's bounds.
     * @throws ArrayIndexOutOfBoundsException if the pixels array is too small
     *         to receive the specified number of pixels.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.866 -0500", hash_original_method = "ABE133BC8F623C77CA2A0241C4DBE1C8", hash_generated_method = "BBB287CED8F2686E5B8688A7E1E36429")
    
public void setPixels(int[] pixels, int offset, int stride,
                          int x, int y, int width, int height) {
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        if (!isMutable()) {
            throw new IllegalStateException();
        }
        if (width == 0 || height == 0) {
            return; // nothing to do
        }
        checkPixelsAccess(x, y, width, height, offset, stride, pixels);
        nativeSetPixels(mNativeBitmap, pixels, offset, stride,
                        x, y, width, height);
    }

    /**
     * No special parcel contents.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.877 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    
    public enum Config {
        ALPHA_8     (2),
        RGB_565     (4),
        @Deprecated
        ARGB_4444   (5),
        ARGB_8888   (6);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.750 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.753 -0500", hash_original_field = "D1B0E472E1FF5685DB8DC28558255931", hash_generated_field = "C72E7E4509404725E3E746F035EBB075")

        @SuppressWarnings({"deprecation"})
        private static Config sConfigs[] = {
            null, null, ALPHA_8, null, RGB_565, ARGB_4444, ARGB_8888
        };
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.755 -0500", hash_original_method = "E8B44517D98CF2EF62ECAF903B404562", hash_generated_method = "E8B44517D98CF2EF62ECAF903B404562")
            
Config(int ni) {
            this.nativeInt = ni;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.757 -0500", hash_original_method = "5810B524D6EF6A0CE4916256A24D8F07", hash_generated_method = "F21F37582F474388CFB62F8CF21FB304")
            
static Config nativeToConfig(int ni) {
            return sConfigs[ni];
        }
    }
    
    public enum CompressFormat {
        JPEG    (0),
        PNG     (1),
        WEBP    (2);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.808 -0500", hash_original_method = "EE1006137D4907D34973AF007CDF8ABC", hash_generated_method = "EE1006137D4907D34973AF007CDF8ABC")
            
CompressFormat(int nativeInt) {
            this.nativeInt = nativeInt;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.810 -0500", hash_original_field = "6B116C6445FBD920A2653C64D32C9FB3", hash_generated_field = "6B116C6445FBD920A2653C64D32C9FB3")

         int nativeInt;
    }
    
    private static class BitmapFinalizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.891 -0500", hash_original_field = "D5AB511585FB0D17B787E16D99235382", hash_generated_field = "94EBE634EB926388C6FE9311F8ADAABA")

        private  int mNativeBitmap;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.893 -0500", hash_original_method = "0DDF139B38AD50F56D0AF26AB944EC3E", hash_generated_method = "0DDF139B38AD50F56D0AF26AB944EC3E")
        
BitmapFinalizer(int nativeBitmap) {
            mNativeBitmap = nativeBitmap;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.896 -0500", hash_original_method = "750E0A25CDE7A09F3C919B08C5243F0D", hash_generated_method = "B8FD1ACC752A8AF5F2315B76E157CA42")
        
@Override
        public void finalize() {
            try {
                super.finalize();
            } catch (Throwable t) {
                // Ignore
            } finally {
                nativeDestructor(mNativeBitmap);
            }
        }
        
    }

    /**
     * Write the bitmap and its pixels to the parcel. The bitmap can be
     * rebuilt from the parcel by calling CREATOR.createFromParcel().
     * @param p    Parcel object to write the bitmap data into
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.879 -0500", hash_original_method = "D2FB921E1DDA261A52B060B1EF7694C1", hash_generated_method = "150A70ABDE25BDAD5B4F87063516A627")
    
public void writeToParcel(Parcel p, int flags) {
        checkRecycled("Can't parcel a recycled bitmap");
        if (!nativeWriteToParcel(mNativeBitmap, mIsMutable, mDensity, p)) {
            throw new RuntimeException("native writeToParcel failed");
        }
    }

    /**
     * Returns a new bitmap that captures the alpha values of the original.
     * This may be drawn with Canvas.drawBitmap(), where the color(s) will be
     * taken from the paint that is passed to the draw call.
     *
     * @return new bitmap containing the alpha channel of the original bitmap.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.882 -0500", hash_original_method = "75D570937564149AAA647C007E5ED089", hash_generated_method = "EA20EF15157A2F9A31BDEA600DA5B6FF")
    
public Bitmap extractAlpha() {
        return extractAlpha(null, null);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public Bitmap extractAlpha(Paint paint, int[] offsetXY) {
        Bitmap bm = new Bitmap();
        bm.addTaint(offsetXY[0]);
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

    /**
     *  Given another bitmap, return true if it has the same dimensions, config,
     *  and pixel data as this bitmap. If any of those differ, return false.
     *  If other is null, return false.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.886 -0500", hash_original_method = "3EA2D759216A517078419525658BBCD0", hash_generated_method = "5B0C9164781E8B5FE38A18C12C1D13D5")
    
public boolean sameAs(Bitmap other) {
        //return this == other || (other != null && nativeSameAs(mNativeBitmap, other.mNativeBitmap));
        return toTaintBoolean(getTaintInt() + other.getTaintInt() +
                              mNativeBitmap + other.mNativeBitmap);
                              
    }

    /**
     * Rebuilds any caches associated with the bitmap that are used for
     * drawing it. In the case of purgeable bitmaps, this call will attempt to
     * ensure that the pixels have been decoded.
     * If this is called on more than one bitmap in sequence, the priority is
     * given in LRU order (i.e. the last bitmap called will be given highest
     * priority).
     *
     * For bitmaps with no associated caches, this call is effectively a no-op,
     * and therefore is harmless.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.888 -0500", hash_original_method = "ABCB940311631CB7A5E91625A11E0A13", hash_generated_method = "767E8DB27721D7D4F4C0AC08DE5DD726")
    
public void prepareToDraw() {
        nativePrepareToDraw(mNativeBitmap);
    }
    
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:22.991 -0500", hash_original_method = "C9F7301125E447423E7DB3CDD9C42E7E", hash_generated_method = "0EFE49CECCF1DD1E523087C3F2B99BBA")
    
final int ni() {
        return mNativeBitmap;
    }
    // orphaned legacy method
    
	private void setHeight(int height) {
		//Synthetic method in order to track height taints, which are managed in native code
		addTaint(height);
	}
    
    // orphaned legacy method
    
	private void setWidth(int width) {
		//Synthetic method in order to track width taints, which are managed in native code
		addTaint(width);
	}
    
}

