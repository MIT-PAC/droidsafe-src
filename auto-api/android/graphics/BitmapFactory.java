package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.957 -0400", hash_original_method = "52672E8127CAFECE2449AA57E7257570", hash_generated_method = "CC8DA267BEBF87699792D6FC5A462174")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.957 -0400", hash_original_method = "7D28734FCE7370D8FDCC234164691F4C", hash_generated_method = "F2CD77CABB152658A32F315E702CC3F9")
    public static Bitmap decodeFile(String pathName) {
        return decodeFile(pathName, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.957 -0400", hash_original_method = "DA59C13162065C9078238D65B3CED27B", hash_generated_method = "BDC188C397D3D22DBF33660CA36E5EA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.957 -0400", hash_original_method = "76C8F8FC59676D6D85C52F32696DF274", hash_generated_method = "9A7DE105C45FCBA3DAE27B3EB9E0C764")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.957 -0400", hash_original_method = "1FD108E128E9B3F5B5DC3826EDC33E9E", hash_generated_method = "4EF628CBC4DD8FE30F8240AEA76D08E5")
    public static Bitmap decodeResource(Resources res, int id) {
        return decodeResource(res, id, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.957 -0400", hash_original_method = "8AAF3F50F887FE806E4860779AA74DE9", hash_generated_method = "05D1D900B439E490D08316FB8261B25F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "DFF1A943D13A30E770B3B1EA5D85E01F", hash_generated_method = "792B9E4F49D4AF98885AAB773350BCF4")
    public static Bitmap decodeByteArray(byte[] data, int offset, int length) {
        return decodeByteArray(data, offset, length, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "A48399D0F4A852A63A3C3FE959923362", hash_generated_method = "82B5EDABD3847041E89A3BAFE04E97CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "3B3A796C44A585AAD8107739957983FB", hash_generated_method = "AAC31B93CD54121418D2195993BAC85D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "B1B6242CCE1D87F8A8E3C9512E1007D6", hash_generated_method = "5E7A8D8150BC51025C552D5F98850988")
    public static Bitmap decodeStream(InputStream is) {
        return decodeStream(is, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "A6990485F5A51C8B42D23EBD17A2489C", hash_generated_method = "CA02C073176BDAF744F118617D035937")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "AD6759EBE965A5DE70F6CCA865F96916", hash_generated_method = "66CCCDB33CFD6B97551E29C13AF35F19")
    public static Bitmap decodeFileDescriptor(FileDescriptor fd) {
        return decodeFileDescriptor(fd, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "94074CACAA4A34331C392D3B7A8986BC", hash_generated_method = "7554AA152FEA080C740179DE9F2B9C79")
    public static void setDefaultConfig(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.RGB_565;
        }
        nativeSetDefaultConfig(config.nativeInt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.958 -0400", hash_original_method = "80959A804B6A008DDD8B1C468AF0DA97", hash_generated_method = "FBAEB9ABCB6FE4C576A5AE83B65D3BE6")
    private static void nativeSetDefaultConfig(int nativeConfig) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "92EA38C762B28DCCEF98F05587CB3FCD", hash_generated_method = "FB7968101AC251F1C2D835DD097D9AC5")
    private static Bitmap nativeDecodeStream(InputStream is, byte[] storage,
            Rect padding, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "CE110EAB9438DABA549FE68ED4953373", hash_generated_method = "A55AE19A6EC067FF06ABDC0826A9612C")
    private static Bitmap nativeDecodeFileDescriptor(FileDescriptor fd,
            Rect padding, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "DB394781167C2B599D675A270034AE32", hash_generated_method = "9ACDEFF0753C1BB5F0ACD21DDEF1B3DC")
    private static Bitmap nativeDecodeAsset(int asset, Rect padding, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "6A48A833220AB4E59D8197F45A7F9BE9", hash_generated_method = "7C6CDD61BBB76D717D4464DDE5FEBB85")
    private static Bitmap nativeDecodeByteArray(byte[] data, int offset,
            int length, Options opts) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Bitmap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "A6FE2B76604145B92A6BE6EE1F7C5140", hash_generated_method = "7996BE876BF60728076F982BFC4D0157")
    private static byte[] nativeScaleNinePatch(byte[] chunk, float scale, Rect pad) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new byte[]{DSUtils.UNKNOWN_BYTE};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "D13F1D1D5B69278DEEFEB3B7F79AFBD2", hash_generated_method = "D5334238F99B86B9623C4FC46F15D842")
    private static boolean nativeIsSeekable(FileDescriptor fd) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    public static class Options {
        public Bitmap inBitmap;
        @SuppressWarnings({"UnusedDeclaration"}) 
        public boolean inMutable;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "1E2502131AFAFEE705D62EA28BD1E532", hash_generated_method = "BD5FBFDB5F23833817823320993D97AD")
        @DSModeled(DSC.SAFE)
        public Options() {
            inDither = false;
            inScaled = true;
            // ---------- Original Method ----------
            //inDither = false;
            //inScaled = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "D7A23FF2AF4CBD01F551E962769DA287", hash_generated_method = "E0F235FF799BA5CA8AE1E6CD623914B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void requestCancel() {
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.959 -0400", hash_original_method = "1FC603D50B1CC5C62A2F5DE57FF4610A", hash_generated_method = "1C001951DD5AA1943A3DD86065AE1BCE")
        @DSModeled(DSC.SAFE)
        public void requestCancelDecode() {
            mCancel = true;
            requestCancel();
            // ---------- Original Method ----------
            //mCancel = true;
            //requestCancel();
        }

        
    }


    
}


