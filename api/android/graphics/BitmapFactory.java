package android.graphics;

// Droidsafe Imports
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class BitmapFactory {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.744 -0400", hash_original_method = "9FB0451BE5E4A0EC96B2F8C3A0CC38F7", hash_generated_method = "9FB0451BE5E4A0EC96B2F8C3A0CC38F7")
    public BitmapFactory ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static Bitmap decodeFile(String pathName, Options opts) {
        Bitmap bm = null;
        InputStream stream = null;
        try {
            stream = new FileInputStream(pathName);
            bm = decodeStream(stream, null, opts);
        } catch (Exception e) {
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                }
            }
        }
        return bm;
    }

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeFile(String pathName) {
        return decodeFile(pathName, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeResource(Resources res, int id, Options opts) {
        Bitmap bm = null;
        InputStream is = null;
        try {
            final TypedValue value = new TypedValue();
            is = res.openRawResource(id, value);
            bm = decodeResourceStream(res, value, is, null, opts);
        } catch (Exception e) {
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
            }
        }
        if (bm == null && opts != null && opts.inBitmap != null) {
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        }
        return bm;
    }

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeResource(Resources res, int id) {
        return decodeResource(res, id, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeByteArray(byte[] data, int offset, int length) {
        return decodeByteArray(data, offset, length, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeStream(InputStream is, Rect outPadding, Options opts) {
        if (is == null) {
            return null;
        }
        if (!is.markSupported()) {
            is = new BufferedInputStream(is, 16 * 1024);
        }
        is.mark(1024);
        Bitmap  bm;
        if (is instanceof AssetManager.AssetInputStream) {
            bm = nativeDecodeAsset(((AssetManager.AssetInputStream) is).getAssetInt(),
                    outPadding, opts);
        } else {
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeStream(InputStream is) {
        return decodeStream(is, null, null);
    }

    
    @DSModeled(DSC.SAFE)
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
                } catch (Throwable t) {}
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static Bitmap decodeFileDescriptor(FileDescriptor fd) {
        return decodeFileDescriptor(fd, null, null);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefaultConfig(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.RGB_565;
        }
        nativeSetDefaultConfig(config.nativeInt);
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetDefaultConfig(int nativeConfig) {
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeDecodeStream(InputStream is, byte[] storage, Rect padding, Options opts) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeDecodeFileDescriptor(FileDescriptor fd, Rect padding, Options opts) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeDecodeAsset(int asset, Rect padding, Options opts) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static Bitmap nativeDecodeByteArray(byte[] data, int offset, int length, Options opts) {
		return new Bitmap();
	}

    
    @DSModeled(DSC.SAFE)
    private static byte[] nativeScaleNinePatch(byte[] chunk, float scale, Rect pad) {
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_721079546 = { DSUtils.UNKNOWN_BYTE };
		return var2F9C81BC6E497382285CD6B7A7E33DE1_721079546;
	}

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeIsSeekable(FileDescriptor fd) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_440919392 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_440919392;
	}

    
    public static class Options {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.751 -0400", hash_original_field = "17F00150E8B2A9E4FBAD8D43CEDC7965", hash_generated_field = "E14A34C185341AE7F8D4DB91886BE7E5")

        public Bitmap inBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "6258A3C62DA63C37576AABD0D4F67975", hash_generated_field = "C7573D4E32EC16E0C2CD149EBE3AB0B9")

        @SuppressWarnings({"UnusedDeclaration"}) public boolean inMutable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "70130F0A4CF61B0939FABD71E9296B98", hash_generated_field = "1063F6F5AF93C8D68EC45BDD348E5071")

        public boolean inJustDecodeBounds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "63CE80485616583FFF99A9BF00E2DFE8", hash_generated_field = "20BC8D58A8E25C9FB32FDEFC6A90E12A")

        public int inSampleSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "A2119881135B5B4D30F6D308B5B54941", hash_generated_field = "B3F186A0A19CB81CFAB1CFA519948F42")

        public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "79B4E8E023E3363D4A76E84B1E30EEA9", hash_generated_field = "E8FA7CEB38B2930060BA05ADEE3346BB")

        public boolean inDither;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "168C736223E9CA8E075112E9C406FA8B", hash_generated_field = "3610CEE85095008F6597BC9C5FE629D8")

        public int inDensity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "68DD54E04325E60003AED0E381DB42D0", hash_generated_field = "43BDEAA718150EA7C4FAA6F90E278648")

        public int inTargetDensity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "D79D102597FF817C9E5D933CEA990C9B", hash_generated_field = "FA42D7A36E035A3F23389257C5820335")

        public int inScreenDensity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "A2DB623A5F61CE37213712B64F1671AE", hash_generated_field = "A3F3E3CD0B1AC9D4E52712B447050B21")

        public boolean inScaled;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "14C34EB699B7DAC06CEC7FA0AC6090DA", hash_generated_field = "2A4AF0565171D3E469778BF856D92818")

        public boolean inPurgeable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.752 -0400", hash_original_field = "F3A5A50C1671B673F4A4F15A256A35E8", hash_generated_field = "2CBEF9B554D136FB7359A990F5EA7F23")

        public boolean inInputShareable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_field = "252B7794F08FA684F5D0370F9849DD44", hash_generated_field = "0074B39C2082290F2C5AD33FADB0EB13")

        public boolean inPreferQualityOverSpeed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_field = "FDF52608CC3F6F44D6B8DC6CCEEFC3D6", hash_generated_field = "1711C922F444BA74A1E98CA86D96DCCE")

        public int outWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_field = "EC008EE6ECDAF8CD4CAD776F37012600", hash_generated_field = "A872264BA87A83F67078713ABC67D7C1")

        public int outHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_field = "4E4C2369DC65E86D2FBB49DAD06181D1", hash_generated_field = "E4866098B19434EF1531DCD449765740")

        public String outMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_field = "48013C146BD92328BBEB8833B800FE29", hash_generated_field = "594E0FA6AD863865589C962FDBA85D13")

        public byte[] inTempStorage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_field = "67026972FD93F1D5C235393B45074484", hash_generated_field = "847D8059733379B59E06CF32218000D4")

        public boolean mCancel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.753 -0400", hash_original_method = "1E2502131AFAFEE705D62EA28BD1E532", hash_generated_method = "0635C869FB7A2CFDEE0A972AAD74F8C9")
        public  Options() {
            inDither = false;
            inScaled = true;
            // ---------- Original Method ----------
            //inDither = false;
            //inScaled = true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.754 -0400", hash_original_method = "D7A23FF2AF4CBD01F551E962769DA287", hash_generated_method = "0A55D796763E8D9E6E50E72FD3E99166")
        private void requestCancel() {
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.754 -0400", hash_original_method = "1FC603D50B1CC5C62A2F5DE57FF4610A", hash_generated_method = "4C9F07CF8433D9C32575769E3132C089")
        public void requestCancelDecode() {
            mCancel = true;
            requestCancel();
            // ---------- Original Method ----------
            //mCancel = true;
            //requestCancel();
        }

        
    }


    
}

