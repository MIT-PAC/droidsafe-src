package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewRootImpl;

public class WallpaperManager {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.161 -0500", hash_original_method = "C193488ECC93C5DEAFD0BA2DBD2772CE", hash_generated_method = "3443D20D6A8561FDE63D74DBB5E22A62")
    
static void initGlobals(Looper looper) {
        synchronized (sSync) {
            if (sGlobals == null) {
                sGlobals = new Globals(looper);
            }
        }
    }

    /**
     * Retrieve a WallpaperManager associated with the given Context.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.165 -0500", hash_original_method = "97C230F92BF2EA74D74E57D6E151F317", hash_generated_method = "E122D877CAEF7F74721B46251971E070")
    
public static WallpaperManager getInstance(Context context) {
        return (WallpaperManager)context.getSystemService(
                Context.WALLPAPER_SERVICE);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.216 -0500", hash_original_method = "3AB6B8AC89BBBD415EBF8AF5472BAEF1", hash_generated_method = "C5BB8AD7DDD48E7F070B1792C8B07DB0")
    
static Bitmap generateBitmap(Bitmap bm, int width, int height) {
        if (bm == null) {
            return null;
        }

        bm.setDensity(DisplayMetrics.DENSITY_DEVICE);

        if (width <= 0 || height <= 0
                || (bm.getWidth() == width && bm.getHeight() == height)) {
            return bm;
        }

        // This is the final bitmap we want to return.
        try {
            Bitmap newbm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            newbm.setDensity(DisplayMetrics.DENSITY_DEVICE);

            Canvas c = new Canvas(newbm);
            Rect targetRect = new Rect();
            targetRect.right = bm.getWidth();
            targetRect.bottom = bm.getHeight();

            int deltaw = width - targetRect.right;
            int deltah = height - targetRect.bottom;

            if (deltaw > 0 || deltah > 0) {
                // We need to scale up so it covers the entire area.
                float scale;
                if (deltaw > deltah) {
                    scale = width / (float)targetRect.right;
                } else {
                    scale = height / (float)targetRect.bottom;
                }
                targetRect.right = (int)(targetRect.right*scale);
                targetRect.bottom = (int)(targetRect.bottom*scale);
                deltaw = width - targetRect.right;
                deltah = height - targetRect.bottom;
            }

            targetRect.offset(deltaw/2, deltah/2);

            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            c.drawBitmap(bm, null, targetRect, paint);

            bm.recycle();
            c.setBitmap(null);
            return newbm;
        } catch (OutOfMemoryError e) {
            Log.w(TAG, "Can't generate default bitmap", e);
            return bm;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.052 -0500", hash_original_field = "971783314823CED4B1181B3CE36D1F83", hash_generated_field = "48A0CC9AB0B3F0E9E45F7F457712B59F")

    private static String TAG = "WallpaperManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.054 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.061 -0500", hash_original_field = "AEBE9E2CD25B2069660616EC0CDB03F0", hash_generated_field = "DEFFCFE16339DBDBF08B336D28EF6A17")

    public static final String ACTION_LIVE_WALLPAPER_CHOOSER
            = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.063 -0500", hash_original_field = "364BBF91516F810B96D9C1E8EA1FAFAD", hash_generated_field = "BF5D2A76907CE9E554A3FE854675BFD7")

    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.065 -0500", hash_original_field = "53EF42FBDA77E705FA4BF935A39185A1", hash_generated_field = "F96B596B27509EEB5AD3777B9E252E5D")

    public static final String COMMAND_TAP = "android.wallpaper.tap";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.067 -0500", hash_original_field = "5E5F63FD10FD0E026813E6263561F7FD", hash_generated_field = "818BE2DF368F81E0A32AC1FE0FD288C9")

    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.070 -0500", hash_original_field = "D08FA620A4588E34F20A134E4A9D1EBE", hash_generated_field = "70F84F0650C85E3FC996BE9B45E4D2C5")

    public static final String COMMAND_DROP = "android.home.drop";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.156 -0500", hash_original_field = "1F537EBE3F70741DBD8752B11EFDF613", hash_generated_field = "EECB5088E51D82E124490D50E038120E")
    
    private static final Object sSync = new Object[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.158 -0500", hash_original_field = "638429B68A172D5320A3987A26A35185", hash_generated_field = "FAC961618570B702A278896949F1B020")

    private static Globals sGlobals;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.056 -0500", hash_original_field = "2E616F078434B797AEBD3FE9E88C3137", hash_generated_field = "79E763BC7220887CD284E78890CFBD39")

    private float mWallpaperXStep = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.058 -0500", hash_original_field = "0A6106E81E3C9EBA37253187DBC2961A", hash_generated_field = "4E298C71D3B5B2CA896AF40FC8DB3101")

    private float mWallpaperYStep = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.072 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")
    
    private  Context mContext;
    
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.163 -0500", hash_original_method = "AA9944AB0F8A7F99E0205835B0AC132C", hash_generated_method = "AA9944AB0F8A7F99E0205835B0AC132C")
    
WallpaperManager(Context context, Handler handler) {
        mContext = context;
        initGlobals(context.getMainLooper());
    }
    
    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.167 -0500", hash_original_method = "6F9497943DE7A2ADCF716329D67D9BA7", hash_generated_method = "B314011C435ED4886132C5E44A8576FD")
    
public IWallpaperManager getIWallpaperManager() {
        return sGlobals.mService;
    }
    
    /**
     * Retrieve the current system wallpaper; if
     * no wallpaper is set, the system default wallpaper is returned.
     * This is returned as an
     * abstract Drawable that you can install in a View to display whatever
     * wallpaper the user has currently set. 
     *
     * @return Returns a Drawable object that will draw the wallpaper.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.169 -0500", hash_original_method = "983E953189104E5D3E1EF4C33892C5EB", hash_generated_method = "6DE9679FD9FBB6EEEC4F39D6EC1D951A")
    
public Drawable getDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        if (bm != null) {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
            return dr;
        }
        return null;
    }

    /**
     * Retrieve the current system wallpaper; if there is no wallpaper set,
     * a null pointer is returned. This is returned as an
     * abstract Drawable that you can install in a View to display whatever
     * wallpaper the user has currently set.  
     *
     * @return Returns a Drawable object that will draw the wallpaper or a
     * null pointer if these is none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.172 -0500", hash_original_method = "EA4956080FAF0CF8E371329CB76D5A40", hash_generated_method = "4BD624D90F73EF099C6F4BC3376B0CB8")
    
public Drawable peekDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        if (bm != null) {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
            return dr;
        }
        return null;
    }

    /**
     * Like {@link #getDrawable()}, but the returned Drawable has a number
     * of limitations to reduce its overhead as much as possible. It will
     * never scale the wallpaper (only centering it if the requested bounds
     * do match the bitmap bounds, which should not be typical), doesn't
     * allow setting an alpha, color filter, or other attributes, etc.  The
     * bounds of the returned drawable will be initialized to the same bounds
     * as the wallpaper, so normally you will not need to touch it.  The
     * drawable also assumes that it will be used in a context running in
     * the same density as the screen (not in density compatibility mode).
     *
     * @return Returns a Drawable object that will draw the wallpaper.
     */
    @DSComment("Request/Change/Listen Android Manger")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.174 -0500", hash_original_method = "8FF7C2E7F253EDCD7E0E3FAE36FB4E5D", hash_generated_method = "A6D743C421A5C86C17A201B614B9B698")
    
public Drawable getFastDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        if (bm != null) {
            return new FastBitmapDrawable(bm);
        }
        return null;
    }

    /**
     * Like {@link #getFastDrawable()}, but if there is no wallpaper set,
     * a null pointer is returned.
     *
     * @return Returns an optimized Drawable object that will draw the
     * wallpaper or a null pointer if these is none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.176 -0500", hash_original_method = "8A28F31302CE106CFE820B9CBC0915AE", hash_generated_method = "1B034DBE7C2BC82F8D04A47A0A347A32")
    
public Drawable peekFastDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        if (bm != null) {
            return new FastBitmapDrawable(bm);
        }
        return null;
    }

    /**
     * Like {@link #getDrawable()} but returns a Bitmap.
     * 
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.178 -0500", hash_original_method = "214C7E80807DBED0084465B1D80DE965", hash_generated_method = "9CD8850D0BA7D5EE6B1F7F7301A72EF5")
    
public Bitmap getBitmap() {
        return sGlobals.peekWallpaperBitmap(mContext, true);
    }

    /**
     * Remove all internal references to the last loaded wallpaper.  Useful
     * for apps that want to reduce memory usage when they only temporarily
     * need to have the wallpaper.  After calling, the next request for the
     * wallpaper will require reloading it again from disk.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.180 -0500", hash_original_method = "9DD74CD1F13AD5E4F4CF15160B046494", hash_generated_method = "D646522144ACE816F1B9C19EDF69A0F0")
    
public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
    }

    /**
     * If the current wallpaper is a live wallpaper component, return the
     * information about that wallpaper.  Otherwise, if it is a static image,
     * simply return null.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.182 -0500", hash_original_method = "BFBEA651CA003E449BAD7FB6481A127E", hash_generated_method = "F709B650601FE8788463DDA118E96837")
    
public WallpaperInfo getWallpaperInfo() {
        try {
            return sGlobals.mService.getWallpaperInfo();
        } catch (RemoteException e) {
            return null;
        }
    }
    
    /**
     * Change the current system wallpaper to the bitmap in the given resource.
     * The resource is opened as a raw data stream and copied into the
     * wallpaper; it must be a valid PNG or JPEG image.  On success, the intent
     * {@link Intent#ACTION_WALLPAPER_CHANGED} is broadcast.
     *
     * @param resid The bitmap to save.
     *
     * @throws IOException If an error occurs reverting to the default
     * wallpaper.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.185 -0500", hash_original_method = "A9B0C110F9B2DD6C9D3DF08018F94DD2", hash_generated_method = "6B1E8FE27DC47B3466150DB417D923EE")
    
public void setResource(int resid) throws IOException {
        try {
            Resources resources = mContext.getResources();
            /* Set the wallpaper to the default values */
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(
                    "res:" + resources.getResourceName(resid));
            if (fd != null) {
                FileOutputStream fos = null;
                try {
                    fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                    setWallpaper(resources.openRawResource(resid), fos);
                } finally {
                    if (fos != null) {
                        fos.close();
                    }
                }
            }
        } catch (RemoteException e) {
            // Ignore
        }
    }
    
    /**
     * Change the current system wallpaper to a bitmap.  The given bitmap is
     * converted to a PNG and stored as the wallpaper.  On success, the intent
     * {@link Intent#ACTION_WALLPAPER_CHANGED} is broadcast.
     *
     * @param bitmap The bitmap to save.
     *
     * @throws IOException If an error occurs reverting to the default
     * wallpaper.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.188 -0500", hash_original_method = "24319E223B48D297B4260CBD63DF9776", hash_generated_method = "57AEDF5C0763A9F93D7C19FE4354966F")
    
public void setBitmap(Bitmap bitmap) throws IOException {
        try {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            if (fd == null) {
                return;
            }
            FileOutputStream fos = null;
            try {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        } catch (RemoteException e) {
            // Ignore
        }
    }

    /**
     * Change the current system wallpaper to a specific byte stream.  The
     * give InputStream is copied into persistent storage and will now be
     * used as the wallpaper.  Currently it must be either a JPEG or PNG
     * image.  On success, the intent {@link Intent#ACTION_WALLPAPER_CHANGED}
     * is broadcast.
     *
     * @param data A stream containing the raw data to install as a wallpaper.
     *
     * @throws IOException If an error occurs reverting to the default
     * wallpaper.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.190 -0500", hash_original_method = "201E3B54F176FDB2F716DB9554E16862", hash_generated_method = "65E54A0B70FFEC5FD6DA252984147B4E")
    
public void setStream(InputStream data) throws IOException {
        try {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            if (fd == null) {
                return;
            }
            FileOutputStream fos = null;
            try {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                setWallpaper(data, fos);
            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        } catch (RemoteException e) {
            // Ignore
        }
    }
    
    static class FastBitmapDrawable extends Drawable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.075 -0500", hash_original_field = "46C0A7FFF0FFB93D952536F8E8BA5C29", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

        private  Bitmap mBitmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.077 -0500", hash_original_field = "AF6410B200BC05DCA2CF0BE65165448A", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private  int mWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.080 -0500", hash_original_field = "7DDAE255893B528E7BEBEC203BC2D9F3", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private  int mHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.083 -0500", hash_original_field = "C4EF30768FAD5D1C51DAB83607E993FC", hash_generated_field = "DA577E86F21E75B26C2B7DE9380FC9DD")

        private int mDrawLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.085 -0500", hash_original_field = "05DD51586D974331F4291DDC8B7F26DB", hash_generated_field = "BC12CCF55C693145726833EAB6B40601")

        private int mDrawTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.087 -0500", hash_original_field = "0344A2D91EF1BCE652EE63EFC12EEAC9", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

        private  Paint mPaint;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.090 -0500", hash_original_method = "A000E3823EF3583E37A464733E9034D5", hash_generated_method = "ED0EF0E1D8327FA31527D2F99B5C592A")
        
private FastBitmapDrawable(Bitmap bitmap) {
            mBitmap = bitmap;
            mWidth = bitmap.getWidth();
            mHeight = bitmap.getHeight();

            setBounds(0, 0, mWidth, mHeight);

            mPaint = new Paint();
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.092 -0500", hash_original_method = "740DEE0C93073DC91C8FEF81BF30F5D6", hash_generated_method = "824D2CBF38887900E00ACD9A85819CD2")
        
@Override
        public void draw(Canvas canvas) {
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.094 -0500", hash_original_method = "20937ACEFD1116260A9689661466F3F7", hash_generated_method = "6905288CC17C7D82D00D5533E4517C30")
        
@Override
        public int getOpacity() {
            return PixelFormat.OPAQUE;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.097 -0500", hash_original_method = "AD75C11A4E8AD86B9F9EB3DCD5857128", hash_generated_method = "62CD9A0B7E991E8654963885750F8159")
        
@Override
        public void setBounds(int left, int top, int right, int bottom) {
            mDrawLeft = left + (right-left - mWidth) / 2;
            mDrawTop = top + (bottom-top - mHeight) / 2;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.099 -0500", hash_original_method = "51482143A770E9CBA4E27420DA4BB83A", hash_generated_method = "CDB6E320C266D3E3D9C1320C38F789E5")
        
@Override
        public void setAlpha(int alpha) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.102 -0500", hash_original_method = "6EF98891DC00D446E5280E44B83BE80B", hash_generated_method = "A65311E361BA6DB95DA06BF61E62EE59")
        
@Override
        public void setColorFilter(ColorFilter cf) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.104 -0500", hash_original_method = "BBAE54C669BC97BDF73F051E3161B7DC", hash_generated_method = "FB07992368D4A2B40B2DFAA6C014E0E3")
        
@Override
        public void setDither(boolean dither) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.106 -0500", hash_original_method = "072B9683A9FDD22E6BC18017D9B8BE50", hash_generated_method = "DD3B2DE6389CE1500BF931787345BEFA")
        
@Override
        public void setFilterBitmap(boolean filter) {
            throw new UnsupportedOperationException("Not supported with this drawable");
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.108 -0500", hash_original_method = "7C6E7C05DAF2C7C11CBD631A19BA11F2", hash_generated_method = "39278CB6B9C6547F27484D81F3EDE677")
        
@Override
        public int getIntrinsicWidth() {
            return mWidth;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.110 -0500", hash_original_method = "3C735D6B09C7947D1D4F4735F7E16410", hash_generated_method = "0269A8752CCD1CA35B4E1D43155EB161")
        
@Override
        public int getIntrinsicHeight() {
            return mHeight;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.113 -0500", hash_original_method = "6C36D8FD6C4DA506CC2056E38D29BDE3", hash_generated_method = "47EC8A0025261E6AF82A087E108CE991")
        
@Override
        public int getMinimumWidth() {
            return mWidth;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.116 -0500", hash_original_method = "F7F1B37FEC841079758C9B817D6DD4F6", hash_generated_method = "8343B0F17FD22297CF3F42DBD8628A43")
        
@Override
        public int getMinimumHeight() {
            return mHeight;
        }
        
    }
    
    static class Globals extends IWallpaperManagerCallback.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.128 -0500", hash_original_field = "12191AA107C8AF466787A7E732BFB527", hash_generated_field = "C11BAEA45DDA2586D27A4A6A9EBDE72E")
        
        private static final int MSG_CLEAR_WALLPAPER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.121 -0500", hash_original_field = "8503206D1FF0CFB5D6EC319F272DF4BA", hash_generated_field = "5245D2ACF9BCB6EB2851F6A6EAF2BF16")

        private IWallpaperManager mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.123 -0500", hash_original_field = "BB53972DF4EEB29247EA288F1683678A", hash_generated_field = "C4E8C03ED548D1B4E21D66638AE05698")

        private Bitmap mWallpaper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.125 -0500", hash_original_field = "17439627EFB9CF50F96EC96E0A4F1B4E", hash_generated_field = "2C326FED1949B0798BBC7F12C35F2605")

        private Bitmap mDefaultWallpaper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.130 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")
        
        private  Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.136 -0500", hash_original_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C", hash_generated_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C")
        
Globals(Looper looper) {
            IBinder b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            mService = IWallpaperManager.Stub.asInterface(b);
            mHandler = new Handler(looper) {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case MSG_CLEAR_WALLPAPER:
                            synchronized (this) {
                                mWallpaper = null;
                                mDefaultWallpaper = null;
                            }
                            break;
                    }
                }
            };
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.138 -0500", hash_original_method = "F846E10F84F4E35E470DA1B587CB2864", hash_generated_method = "253B043EE2950098ABCCD7E8C61D003E")
        
public void onWallpaperChanged() {
            /* The wallpaper has changed but we shouldn't eagerly load the
             * wallpaper as that would be inefficient. Reset the cached wallpaper
             * to null so if the user requests the wallpaper again then we'll
             * fetch it.
             */
            mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.140 -0500", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "5553470799CBD6C40F98FB733AE4E7EA")
        
public Handler getHandler() {
            return mHandler;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.143 -0500", hash_original_method = "D22E4158438EA0372FD1CBCCE67470DB", hash_generated_method = "195985320E3A3ED2B112023C35B1E98F")
        
public Bitmap peekWallpaperBitmap(Context context, boolean returnDefault) {
            synchronized (this) {
                if (mWallpaper != null) {
                    return mWallpaper;
                }
                if (mDefaultWallpaper != null) {
                    return mDefaultWallpaper;
                }
                mWallpaper = null;
                try {
                    mWallpaper = getCurrentWallpaperLocked();
                } catch (OutOfMemoryError e) {
                    Log.w(TAG, "No memory load current wallpaper", e);
                }
                if (returnDefault) {
                    if (mWallpaper == null) {
                        mDefaultWallpaper = getDefaultWallpaperLocked(context);
                        return mDefaultWallpaper;
                    } else {
                        mDefaultWallpaper = null;
                    }
                }
                return mWallpaper;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.146 -0500", hash_original_method = "0171ADD4BBF298493CC8451FAA0D3640", hash_generated_method = "443BC88E73A01C669DD8623D0CD4C931")
        
public void forgetLoadedWallpaper() {
            synchronized (this) {
                mWallpaper = null;
                mDefaultWallpaper = null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.149 -0500", hash_original_method = "16667119AC99E737F53C6C4F154ADE70", hash_generated_method = "7BC481367F8404D97484C7F09E2B75E6")
        
private Bitmap getCurrentWallpaperLocked() {
            try {
                Bundle params = new Bundle();
                ParcelFileDescriptor fd = mService.getWallpaper(this, params);
                if (fd != null) {
                    int width = params.getInt("width", 0);
                    int height = params.getInt("height", 0);

                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        Bitmap bm = BitmapFactory.decodeFileDescriptor(
                                fd.getFileDescriptor(), null, options);
                        return generateBitmap(bm, width, height);
                    } catch (OutOfMemoryError e) {
                        Log.w(TAG, "Can't decode file", e);
                    } finally {
                        try {
                            fd.close();
                        } catch (IOException e) {
                            // Ignore
                        }
                    }
                }
            } catch (RemoteException e) {
                // Ignore
            }
            return null;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.151 -0500", hash_original_method = "7D56EB02955E82C8DDBD02F9FFA3CE84", hash_generated_method = "3DE434BB2A0AB29EAC447CABF6ED45BB")
        
private Bitmap getDefaultWallpaperLocked(Context context) {
            try {
                InputStream is = context.getResources().openRawResource(
                        com.android.internal.R.drawable.default_wallpaper);
                if (is != null) {
                    int width = mService.getWidthHint();
                    int height = mService.getHeightHint();

                    try {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        Bitmap bm = BitmapFactory.decodeStream(is, null, options);
                        return generateBitmap(bm, width, height);
                    } catch (OutOfMemoryError e) {
                        Log.w(TAG, "Can't decode stream", e);
                    } finally {
                        try {
                            is.close();
                        } catch (IOException e) {
                            // Ignore
                        }
                    }
                }
            } catch (RemoteException e) {
                // Ignore
            }
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.193 -0500", hash_original_method = "4C0B3C480EF9954FF86E8D84EAD55CC1", hash_generated_method = "A3F6272B0DD833DC7243DA71F35D1D8A")
    
private void setWallpaper(InputStream data, FileOutputStream fos)
            throws IOException {
        byte[] buffer = new byte[32768];
        int amt;
        while ((amt=data.read(buffer)) > 0) {
            fos.write(buffer, 0, amt);
        }
    }

    /**
     * Returns the desired minimum width for the wallpaper. Callers of
     * {@link #setBitmap(android.graphics.Bitmap)} or
     * {@link #setStream(java.io.InputStream)} should check this value
     * beforehand to make sure the supplied wallpaper respects the desired
     * minimum width.
     *
     * If the returned value is <= 0, the caller should use the width of
     * the default display instead.
     *
     * @return The desired minimum width for the wallpaper. This value should
     * be honored by applications that set the wallpaper but it is not
     * mandatory.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.195 -0500", hash_original_method = "D1A5F81505B1F3B03FABBA4410A80898", hash_generated_method = "74541DCCB60B34A5B4B5411867669D39")
    
public int getDesiredMinimumWidth() {
        try {
            return sGlobals.mService.getWidthHint();
        } catch (RemoteException e) {
            // Shouldn't happen!
            return 0;
        }
    }

    /**
     * Returns the desired minimum height for the wallpaper. Callers of
     * {@link #setBitmap(android.graphics.Bitmap)} or
     * {@link #setStream(java.io.InputStream)} should check this value
     * beforehand to make sure the supplied wallpaper respects the desired
     * minimum height.
     *
     * If the returned value is <= 0, the caller should use the height of
     * the default display instead.
     *
     * @return The desired minimum height for the wallpaper. This value should
     * be honored by applications that set the wallpaper but it is not
     * mandatory.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.197 -0500", hash_original_method = "B18A5C89DB794D80A7E1B5CE60755D7A", hash_generated_method = "78B9329E0F1A91388BB9BC78870E3688")
    
public int getDesiredMinimumHeight() {
        try {
            return sGlobals.mService.getHeightHint();
        } catch (RemoteException e) {
            // Shouldn't happen!
            return 0;
        }
    }

    /**
     * For use only by the current home application, to specify the size of
     * wallpaper it would like to use.  This allows such applications to have
     * a virtual wallpaper that is larger than the physical screen, matching
     * the size of their workspace.
     * @param minimumWidth Desired minimum width
     * @param minimumHeight Desired minimum height
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.199 -0500", hash_original_method = "24150471411E1AC7EC2E370FB5C4066A", hash_generated_method = "BD6A75EB9045216B853F7E74C02E25EB")
    
public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        try {
            sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        } catch (RemoteException e) {
            // Ignore
        }
    }

    /**
     * Set the position of the current wallpaper within any larger space, when
     * that wallpaper is visible behind the given window.  The X and Y offsets
     * are floating point numbers ranging from 0 to 1, representing where the
     * wallpaper should be positioned within the screen space.  These only
     * make sense when the wallpaper is larger than the screen.
     * 
     * @param windowToken The window who these offsets should be associated
     * with, as returned by {@link android.view.View#getWindowToken()
     * View.getWindowToken()}.
     * @param xOffset The offset along the X dimension, from 0 to 1.
     * @param yOffset The offset along the Y dimension, from 0 to 1.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.204 -0500", hash_original_method = "50451375F0F7110E301C30296ACA8A65", hash_generated_method = "2B39E3618D2A8DCCE3CCE83472EB1153")
    
public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        final IBinder fWindowToken = windowToken;
        final float fXOffset = xOffset;
        final float fYOffset = yOffset;
        sGlobals.getHandler().post(new Runnable() {
            public void run() {
                try {
                    //Log.v(TAG, "Sending new wallpaper offsets from app...");
                    ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
                    //Log.v(TAG, "...app returning after sending offsets!");
                } catch (RemoteException e) {
                    // Ignore.
                } catch (IllegalArgumentException e) {
                    // Since this is being posted, it's possible that this windowToken is no longer
                    // valid, for example, if setWallpaperOffsets is called just before rotation.
                }
            }
        });
    }

    /**
     * For applications that use multiple virtual screens showing a wallpaper,
     * specify the step size between virtual screens. For example, if the
     * launcher has 3 virtual screens, it would specify an xStep of 0.5,
     * since the X offset for those screens are 0.0, 0.5 and 1.0
     * @param xStep The X offset delta from one screen to the next one 
     * @param yStep The Y offset delta from one screen to the next one
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.207 -0500", hash_original_method = "D2E7CBA6FEE1F1016E75D81DE5B86ECC", hash_generated_method = "400259FF5D8B2047613F32A117CED9E6")
    
public void setWallpaperOffsetSteps(float xStep, float yStep) {
        mWallpaperXStep = xStep;
        mWallpaperYStep = yStep;
    }
    
    /**
     * Send an arbitrary command to the current active wallpaper.
     * 
     * @param windowToken The window who these offsets should be associated
     * with, as returned by {@link android.view.View#getWindowToken()
     * View.getWindowToken()}.
     * @param action Name of the command to perform.  This must be a scoped
     * name to avoid collisions, such as "com.mycompany.wallpaper.DOIT".
     * @param x Arbitrary integer argument based on command.
     * @param y Arbitrary integer argument based on command.
     * @param z Arbitrary integer argument based on command.
     * @param extras Optional additional information for the command, or null.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.209 -0500", hash_original_method = "5FDBB12430A98A22274A04FEE86533CB", hash_generated_method = "1C68CDE5282EEAC0E6F1FE0611879BA3")
    
public void sendWallpaperCommand(IBinder windowToken, String action,
            int x, int y, int z, Bundle extras) {
        try {
            //Log.v(TAG, "Sending new wallpaper offsets from app...");
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    windowToken, action, x, y, z, extras, false);
            //Log.v(TAG, "...app returning after sending offsets!");
        } catch (RemoteException e) {
            // Ignore.
        }
    }
    
    /**
     * Clear the offsets previously associated with this window through
     * {@link #setWallpaperOffsets(IBinder, float, float)}.  This reverts
     * the window to its default state, where it does not cause the wallpaper
     * to scroll from whatever its last offsets were.
     * 
     * @param windowToken The window who these offsets should be associated
     * with, as returned by {@link android.view.View#getWindowToken()
     * View.getWindowToken()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.211 -0500", hash_original_method = "4003FD7579057D5A21D7509B89350DFE", hash_generated_method = "B1944A57C49879AE34854DB72368D143")
    
public void clearWallpaperOffsets(IBinder windowToken) {
        try {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    windowToken, -1, -1, -1, -1);
        } catch (RemoteException e) {
            // Ignore.
        }
    }
    
    /**
     * Remove any currently set wallpaper, reverting to the system's default
     * wallpaper. On success, the intent {@link Intent#ACTION_WALLPAPER_CHANGED}
     * is broadcast.
     *
     * @throws IOException If an error occurs reverting to the default
     * wallpaper.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:49.213 -0500", hash_original_method = "C7793256C05758E1D6CDFCE99A7FE546", hash_generated_method = "DD34A98A2CA84FA46F221065A92A0F28")
    
public void clear() throws IOException {
        setResource(com.android.internal.R.drawable.default_wallpaper);
    }
}

