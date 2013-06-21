package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BitmapFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.114 -0400", hash_original_method = "C40BBBC9DD9975C4D349F8B44ED07DD3", hash_generated_method = "C40BBBC9DD9975C4D349F8B44ED07DD3")
        public BitmapFactory ()
    {
    }


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

    
        public static Bitmap decodeFile(String pathName) {
        return decodeFile(pathName, null);
    }

    
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

    
        public static Bitmap decodeResource(Resources res, int id) {
        return decodeResource(res, id, null);
    }

    
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

    
        public static Bitmap decodeByteArray(byte[] data, int offset, int length) {
        return decodeByteArray(data, offset, length, null);
    }

    
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

    
        public static Bitmap decodeStream(InputStream is) {
        return decodeStream(is, null, null);
    }

    
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

    
        public static Bitmap decodeFileDescriptor(FileDescriptor fd) {
        return decodeFileDescriptor(fd, null, null);
    }

    
        public static void setDefaultConfig(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.RGB_565;
        }
        nativeSetDefaultConfig(config.nativeInt);
    }

    
        private static void nativeSetDefaultConfig(int nativeConfig) {
    }

    
        private static Bitmap nativeDecodeStream(InputStream is, byte[] storage,
            Rect padding, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static Bitmap nativeDecodeFileDescriptor(FileDescriptor fd,
            Rect padding, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static Bitmap nativeDecodeAsset(int asset, Rect padding, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static Bitmap nativeDecodeByteArray(byte[] data, int offset,
            int length, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static byte[] nativeScaleNinePatch(byte[] chunk, float scale, Rect pad) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
        private static boolean nativeIsSeekable(FileDescriptor fd) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static class Options {
        public Bitmap inBitmap;
        @SuppressWarnings({"UnusedDeclaration"}) public boolean inMutable;
        public boolean inJustDecodeBounds;
        public int inSampleSize;
        public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
        public boolean inDither;
        public int inDensity;
        public int inTargetDensity;
        public int inScreenDensity;
        public boolean inScaled;
        public boolean inPurgeable;
        public boolean inInputShareable;
        public boolean inPreferQualityOverSpeed;
        public int outWidth;
        public int outHeight;
        public String outMimeType;
        public byte[] inTempStorage;
        public boolean mCancel;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.118 -0400", hash_original_method = "1E2502131AFAFEE705D62EA28BD1E532", hash_generated_method = "0635C869FB7A2CFDEE0A972AAD74F8C9")
        @DSModeled(DSC.SAFE)
        public Options() {
            inDither = false;
            inScaled = true;
            // ---------- Original Method ----------
            //inDither = false;
            //inScaled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.119 -0400", hash_original_method = "D7A23FF2AF4CBD01F551E962769DA287", hash_generated_method = "0A55D796763E8D9E6E50E72FD3E99166")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void requestCancel() {
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.119 -0400", hash_original_method = "1FC603D50B1CC5C62A2F5DE57FF4610A", hash_generated_method = "4C9F07CF8433D9C32575769E3132C089")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void requestCancelDecode() {
            mCancel = true;
            requestCancel();
            // ---------- Original Method ----------
            //mCancel = true;
            //requestCancel();
        }

        
    }


    
}

