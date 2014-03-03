package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import droidsafe.helpers.DSUtils;

public class BitmapFactory {

    /**
     * Decode a file path into a bitmap. If the specified file name is null,
     * or cannot be decoded into a bitmap, the function returns null.
     *
     * @param pathName complete path name for the file to be decoded.
     * @param opts null-ok; Options that control downsampling and whether the
     *             image should be completely decoded, or just is size returned.
     * @return The decoded bitmap, or null if the image data could not be
     *         decoded, or, if opts is non-null, if opts requested only the
     *         size be returned (in opts.outWidth and opts.outHeight)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.750 -0500", hash_original_method = "52672E8127CAFECE2449AA57E7257570", hash_generated_method = "238E57666ACD9E7CED5C9BB42FE11C28")
    
public static Bitmap decodeFile(String pathName, Options opts) {
        Bitmap bm = null;
        InputStream stream = null;
        try {
            stream = new FileInputStream(pathName);
            bm = decodeStream(stream, null, opts);
        } catch (Exception e) {
            /*  do nothing.
                If the exception happened on open, bm will be null.
            */
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    // do nothing here
                }
            }
        }
        return bm;
    }

    /**
     * Decode a file path into a bitmap. If the specified file name is null,
     * or cannot be decoded into a bitmap, the function returns null.
     *
     * @param pathName complete path name for the file to be decoded.
     * @return the resulting decoded bitmap, or null if it could not be decoded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.752 -0500", hash_original_method = "7D28734FCE7370D8FDCC234164691F4C", hash_generated_method = "F2CD77CABB152658A32F315E702CC3F9")
    
public static Bitmap decodeFile(String pathName) {
        return decodeFile(pathName, null);
    }

    /**
     * Decode a new Bitmap from an InputStream. This InputStream was obtained from
     * resources, which we pass to be able to scale the bitmap accordingly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.755 -0500", hash_original_method = "DA59C13162065C9078238D65B3CED27B", hash_generated_method = "BDC188C397D3D22DBF33660CA36E5EA8")
    
public static Bitmap decodeResourceStream(Resources res, TypedValue value,
            InputStream is, Rect pad, Options opts) {

        if (opts == null) {
            opts = new Options();
        }

        if (opts.inDensity == 0 && value != null) {
            final int density = value.density;
            if (density == TypedValue.DENSITY_DEFAULT) {
                opts.inDensity = DisplayMetrics.DENSITY_DEFAULT;
            } else if (density != TypedValue.DENSITY_NONE) {
                opts.inDensity = density;
            }
        }
        
        if (opts.inTargetDensity == 0 && res != null) {
            opts.inTargetDensity = res.getDisplayMetrics().densityDpi;
        }
        
        return decodeStream(is, pad, opts);
    }

    /**
     * Synonym for opening the given resource and calling
     * {@link #decodeResourceStream}.
     *
     * @param res   The resources object containing the image data
     * @param id The resource id of the image data
     * @param opts null-ok; Options that control downsampling and whether the
     *             image should be completely decoded, or just is size returned.
     * @return The decoded bitmap, or null if the image data could not be
     *         decoded, or, if opts is non-null, if opts requested only the
     *         size be returned (in opts.outWidth and opts.outHeight)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.757 -0500", hash_original_method = "76C8F8FC59676D6D85C52F32696DF274", hash_generated_method = "04739EFAEB39DB05CF860FAE161E7407")
    
public static Bitmap decodeResource(Resources res, int id, Options opts) {
        Bitmap bm = null;
        InputStream is = null;
        
        try {
            final TypedValue value = new TypedValue();
            is = res.openRawResource(id, value);

            bm = decodeResourceStream(res, value, is, null, opts);
        } catch (Exception e) {
            /*  do nothing.
                If the exception happened on open, bm will be null.
                If it happened on close, bm is still valid.
            */
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                // Ignore
            }
        }

        if (bm == null && opts != null && opts.inBitmap != null) {
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        }

        return bm;
    }

    /**
     * Synonym for {@link #decodeResource(Resources, int, android.graphics.BitmapFactory.Options)}
     * will null Options.
     *
     * @param res The resources object containing the image data
     * @param id The resource id of the image data
     * @return The decoded bitmap, or null if the image could not be decode.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.760 -0500", hash_original_method = "1FD108E128E9B3F5B5DC3826EDC33E9E", hash_generated_method = "4EF628CBC4DD8FE30F8240AEA76D08E5")
    
public static Bitmap decodeResource(Resources res, int id) {
        return decodeResource(res, id, null);
    }

    /**
     * Decode an immutable bitmap from the specified byte array.
     *
     * @param data byte array of compressed image data
     * @param offset offset into imageData for where the decoder should begin
     *               parsing.
     * @param length the number of bytes, beginning at offset, to parse
     * @param opts null-ok; Options that control downsampling and whether the
     *             image should be completely decoded, or just is size returned.
     * @return The decoded bitmap, or null if the image data could not be
     *         decoded, or, if opts is non-null, if opts requested only the
     *         size be returned (in opts.outWidth and opts.outHeight)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.762 -0500", hash_original_method = "8AAF3F50F887FE806E4860779AA74DE9", hash_generated_method = "05D1D900B439E490D08316FB8261B25F")
    
public static Bitmap decodeByteArray(byte[] data, int offset, int length, Options opts) {
        if ((offset | length) < 0 || data.length < offset + length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Bitmap bm = nativeDecodeByteArray(data, offset, length, opts);
        if (bm == null && opts != null && opts.inBitmap != null) {
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        }
        return bm;
    }

    /**
     * Decode an immutable bitmap from the specified byte array.
     *
     * @param data byte array of compressed image data
     * @param offset offset into imageData for where the decoder should begin
     *               parsing.
     * @param length the number of bytes, beginning at offset, to parse
     * @return The decoded bitmap, or null if the image could not be decode.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.764 -0500", hash_original_method = "DFF1A943D13A30E770B3B1EA5D85E01F", hash_generated_method = "792B9E4F49D4AF98885AAB773350BCF4")
    
public static Bitmap decodeByteArray(byte[] data, int offset, int length) {
        return decodeByteArray(data, offset, length, null);
    }

    /**
     * Decode an input stream into a bitmap. If the input stream is null, or
     * cannot be used to decode a bitmap, the function returns null.
     * The stream's position will be where ever it was after the encoded data
     * was read.
     *
     * @param is The input stream that holds the raw data to be decoded into a
     *           bitmap.
     * @param outPadding If not null, return the padding rect for the bitmap if
     *                   it exists, otherwise set padding to [-1,-1,-1,-1]. If
     *                   no bitmap is returned (null) then padding is
     *                   unchanged.
     * @param opts null-ok; Options that control downsampling and whether the
     *             image should be completely decoded, or just is size returned.
     * @return The decoded bitmap, or null if the image data could not be
     *         decoded, or, if opts is non-null, if opts requested only the
     *         size be returned (in opts.outWidth and opts.outHeight)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.768 -0500", hash_original_method = "A48399D0F4A852A63A3C3FE959923362", hash_generated_method = "2A1EC91856AB3B43A7F7823037671A1C")
    
public static Bitmap decodeStream(InputStream is, Rect outPadding, Options opts) {
        // we don't throw in this case, thus allowing the caller to only check
        // the cache, and not force the image to be decoded.
        if (is == null) {
            return null;
        }

        // we need mark/reset to work properly

        if (!is.markSupported()) {
            is = new BufferedInputStream(is, 16 * 1024);
        }

        // so we can call reset() if a given codec gives up after reading up to
        // this many bytes. FIXME: need to find out from the codecs what this
        // value should be.
        is.mark(1024);

        Bitmap  bm;

        if (is instanceof AssetManager.AssetInputStream) {
            bm = nativeDecodeAsset(((AssetManager.AssetInputStream) is).getAssetInt(),
                    outPadding, opts);
        } else {
            // pass some temp storage down to the native code. 1024 is made up,
            // but should be large enough to avoid too many small calls back
            // into is.read(...) This number is not related to the value passed
            // to mark(...) above.
            byte [] tempStorage = null;
            if (opts != null) tempStorage = opts.inTempStorage;
            if (tempStorage == null) tempStorage = new byte[16 * 1024];
            bm = nativeDecodeStream(is, tempStorage, outPadding, opts);
        }
        if (bm == null && opts != null && opts.inBitmap != null) {
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        }

        return finishDecode(bm, outPadding, opts);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.771 -0500", hash_original_method = "3B3A796C44A585AAD8107739957983FB", hash_generated_method = "4318E53CA41CA730D8F21C010F9B12FD")
    
private static Bitmap finishDecode(Bitmap bm, Rect outPadding, Options opts) {
        if (bm == null || opts == null) {
            return bm;
        }
        
        final int density = opts.inDensity;
        if (density == 0) {
            return bm;
        }
        
        bm.setDensity(density);
        final int targetDensity = opts.inTargetDensity;
        if (targetDensity == 0 || density == targetDensity || density == opts.inScreenDensity) {
            return bm;
        }
        
        byte[] np = bm.getNinePatchChunk();
        final boolean isNinePatch = np != null && NinePatch.isNinePatchChunk(np);
        if (opts.inScaled || isNinePatch) {
            float scale = targetDensity / (float)density;
            // TODO: This is very inefficient and should be done in native by Skia
            final Bitmap oldBitmap = bm;
            bm = Bitmap.createScaledBitmap(oldBitmap, (int) (bm.getWidth() * scale + 0.5f),
                    (int) (bm.getHeight() * scale + 0.5f), true);
            oldBitmap.recycle();

            if (isNinePatch) {
                np = nativeScaleNinePatch(np, scale, outPadding);
                bm.setNinePatchChunk(np);
            }
            bm.setDensity(targetDensity);
        }

        return bm;
    }
    
    /**
     * Decode an input stream into a bitmap. If the input stream is null, or
     * cannot be used to decode a bitmap, the function returns null.
     * The stream's position will be where ever it was after the encoded data
     * was read.
     *
     * @param is The input stream that holds the raw data to be decoded into a
     *           bitmap.
     * @return The decoded bitmap, or null if the image data could not be decoded.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.787 -0500", hash_original_method = "B1B6242CCE1D87F8A8E3C9512E1007D6", hash_generated_method = "5E7A8D8150BC51025C552D5F98850988")
    
public static Bitmap decodeStream(InputStream is) {
        return decodeStream(is, null, null);
    }

    /**
     * Decode a bitmap from the file descriptor. If the bitmap cannot be decoded
     * return null. The position within the descriptor will not be changed when
     * this returns, so the descriptor can be used again as-is.
     *
     * @param fd The file descriptor containing the bitmap data to decode
     * @param outPadding If not null, return the padding rect for the bitmap if
     *                   it exists, otherwise set padding to [-1,-1,-1,-1]. If
     *                   no bitmap is returned (null) then padding is
     *                   unchanged.
     * @param opts null-ok; Options that control downsampling and whether the
     *             image should be completely decoded, or just is size returned.
     * @return the decoded bitmap, or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.789 -0500", hash_original_method = "A6990485F5A51C8B42D23EBD17A2489C", hash_generated_method = "2A6442F3D03BF7CBAC6B03C1CC234357")
    
public static Bitmap decodeFileDescriptor(FileDescriptor fd, Rect outPadding, Options opts) {
        if (nativeIsSeekable(fd)) {
            Bitmap bm = nativeDecodeFileDescriptor(fd, outPadding, opts);
            if (bm == null && opts != null && opts.inBitmap != null) {
                throw new IllegalArgumentException("Problem decoding into existing bitmap");
            }
            return finishDecode(bm, outPadding, opts);
        } else {
            FileInputStream fis = new FileInputStream(fd);
            try {
                return decodeStream(fis, outPadding, opts);
            } finally {
                try {
                    fis.close();
                } catch (Throwable t) {/* ignore */}
            }
        }
    }

    /**
     * Decode a bitmap from the file descriptor. If the bitmap cannot be decoded
     * return null. The position within the descriptor will not be changed when
     * this returns, so the descriptor can be used again as is.
     *
     * @param fd The file descriptor containing the bitmap data to decode
     * @return the decoded bitmap, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.792 -0500", hash_original_method = "AD6759EBE965A5DE70F6CCA865F96916", hash_generated_method = "66CCCDB33CFD6B97551E29C13AF35F19")
    
public static Bitmap decodeFileDescriptor(FileDescriptor fd) {
        return decodeFileDescriptor(fd, null, null);
    }

    /**
     * Set the default config used for decoding bitmaps. This config is
     * presented to the codec if the caller did not specify a preferred config
     * in their call to decode...
     *
     * The default value is chosen by the system to best match the device's
     * screen and memory constraints.
     *
     * @param config The preferred config for decoding bitmaps. If null, then
     *               a suitable default is chosen by the system.
     *
     * @hide - only called by the browser at the moment, but should be stable
     *   enough to expose if needed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.794 -0500", hash_original_method = "94074CACAA4A34331C392D3B7A8986BC", hash_generated_method = "ABF67840E4F8FB49D8ADA8E310B2D962")
    
public static void setDefaultConfig(Bitmap.Config config) {
        if (config == null) {
            // pick this for now, as historically it was our default.
            // However, if we have a smarter algorithm, we can change this.
            config = Bitmap.Config.RGB_565;
        }
        nativeSetDefaultConfig(config.nativeInt);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetDefaultConfig(int nativeConfig) {
	}
    
    private static Bitmap nativeDecodeStream(InputStream is, byte[] storage, Rect padding, Options opts) {
		return new Bitmap();
	}
    
    private static Bitmap nativeDecodeFileDescriptor(FileDescriptor fd, Rect padding, Options opts) {
		return new Bitmap();
	}
    
    private static Bitmap nativeDecodeAsset(int asset, Rect padding, Options opts) {
		return new Bitmap();
	}
    
    private static Bitmap nativeDecodeByteArray(byte[] data, int offset, int length, Options opts) {
		return new Bitmap();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static byte[] nativeScaleNinePatch(byte[] chunk, float scale, Rect pad) {
		byte[] bytes = new byte[10];
        bytes[0] = chunk[0];
        bytes.addTaint(scale);
        bytes.addTaint(pad.getTaint());
		return bytes;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeIsSeekable(FileDescriptor fd) {
        return fd.getTaintBoolean();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.744 -0400", hash_original_method = "9FB0451BE5E4A0EC96B2F8C3A0CC38F7", hash_generated_method = "9FB0451BE5E4A0EC96B2F8C3A0CC38F7")
    public BitmapFactory ()
    {
        //Synthesized constructor
    }
    
    public static class Options {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.699 -0500", hash_original_field = "4AAF01BBB4B463EB96C54AF98FCD3449", hash_generated_field = "E14A34C185341AE7F8D4DB91886BE7E5")

        public Bitmap inBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.701 -0500", hash_original_field = "9B6DFB0FE2A479FB869F87C3B4005E1C", hash_generated_field = "137A91BAFB4C94CBEFE1E51F664B95FD")

        @SuppressWarnings({"UnusedDeclaration"}) // used in native code
        public boolean inMutable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.704 -0500", hash_original_field = "D78FB62088F3264A0D415F8B02B25CBE", hash_generated_field = "1063F6F5AF93C8D68EC45BDD348E5071")

        public boolean inJustDecodeBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.706 -0500", hash_original_field = "4D87599F4A09E7ECD4C7BAE5BAA3B931", hash_generated_field = "20BC8D58A8E25C9FB32FDEFC6A90E12A")

        public int inSampleSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.708 -0500", hash_original_field = "F588BEE4A9D7347E86912F1D36DC0DF7", hash_generated_field = "B3F186A0A19CB81CFAB1CFA519948F42")

        public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.710 -0500", hash_original_field = "D9104CC8D631C599B4F31327DE7EF22E", hash_generated_field = "E8FA7CEB38B2930060BA05ADEE3346BB")

        public boolean inDither;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.713 -0500", hash_original_field = "35BA9BF407DF86EC6A0A48AF240CE179", hash_generated_field = "3610CEE85095008F6597BC9C5FE629D8")

        public int inDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.715 -0500", hash_original_field = "4B84F43FD754B53B674DA24E6E2AA1B6", hash_generated_field = "43BDEAA718150EA7C4FAA6F90E278648")

        public int inTargetDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.717 -0500", hash_original_field = "9CBDF303266F1A9B76DB3227F7E73244", hash_generated_field = "FA42D7A36E035A3F23389257C5820335")

        public int inScreenDensity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.719 -0500", hash_original_field = "13C0DB2BB2F87A7D42A82015C43AB12D", hash_generated_field = "A3F3E3CD0B1AC9D4E52712B447050B21")

        public boolean inScaled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.722 -0500", hash_original_field = "2ED1582FEC0275D3B782595E1515CD43", hash_generated_field = "2A4AF0565171D3E469778BF856D92818")

        public boolean inPurgeable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.724 -0500", hash_original_field = "AA0631F0891FE67D95DCFE088232DAD8", hash_generated_field = "2CBEF9B554D136FB7359A990F5EA7F23")

        public boolean inInputShareable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.726 -0500", hash_original_field = "E8989188AA9FB429EEF91B7F5BF834FC", hash_generated_field = "0074B39C2082290F2C5AD33FADB0EB13")

        public boolean inPreferQualityOverSpeed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.729 -0500", hash_original_field = "B688A9D4BB79BE98930626D311FF38CE", hash_generated_field = "1711C922F444BA74A1E98CA86D96DCCE")

        public int outWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.732 -0500", hash_original_field = "9A3E6E0F66078DDBF18BAE5C01E57643", hash_generated_field = "A872264BA87A83F67078713ABC67D7C1")

        public int outHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.734 -0500", hash_original_field = "174B0600EC7774AF31ED1646A4D95E52", hash_generated_field = "E4866098B19434EF1531DCD449765740")

        public String outMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.736 -0500", hash_original_field = "C25AD9CD87C75F63332D4589FE543886", hash_generated_field = "594E0FA6AD863865589C962FDBA85D13")

        public byte[] inTempStorage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.742 -0500", hash_original_field = "9FCF2DAAA02682B3EFC147792ACB86BD", hash_generated_field = "847D8059733379B59E06CF32218000D4")

        public boolean mCancel;
        /**
         * Create a default Options object, which if left unchanged will give
         * the same result from the decoder as if null were passed.
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.697 -0500", hash_original_method = "1E2502131AFAFEE705D62EA28BD1E532", hash_generated_method = "476BB4A6DF32CC0368C94A292A50B98B")
        
public Options() {
            inDither = false;
            inScaled = true;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.740 -0500", hash_original_method = "D7A23FF2AF4CBD01F551E962769DA287", hash_generated_method = "207972AC1E69E3A50625144ADEF8B82A")
        
        private void requestCancel(){
        	//Formerly a native method
        }

        /**
         *  This can be called from another thread while this options object is
         *  inside a decode... call. Calling this will notify the decoder that
         *  it should cancel its operation. This is not guaranteed to cancel
         *  the decode, but if it does, the decoder... operation will return
         *  null, or if inJustDecodeBounds is true, will set outWidth/outHeight
         *  to -1
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.744 -0500", hash_original_method = "1FC603D50B1CC5C62A2F5DE57FF4610A", hash_generated_method = "916058FC98BEB5BEBA4D6C12E44E630C")
        
public void requestCancelDecode() {
            mCancel = true;
            requestCancel();
        }
        
    }
    
}

