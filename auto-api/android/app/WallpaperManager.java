package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.Intent;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WallpaperManager {
    private float mWallpaperXStep = -1;
    private float mWallpaperYStep = -1;
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.140 -0400", hash_original_method = "AA9944AB0F8A7F99E0205835B0AC132C", hash_generated_method = "6E9AD51953EF3B4B39555E789855F3B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WallpaperManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        initGlobals(context.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //initGlobals(context.getMainLooper());
    }

    
        static void initGlobals(Looper looper) {
        synchronized (sSync) {
            if (sGlobals == null) {
                sGlobals = new Globals(looper);
            }
        }
    }

    
        public static WallpaperManager getInstance(Context context) {
        return (WallpaperManager)context.getSystemService(
                Context.WALLPAPER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.141 -0400", hash_original_method = "6F9497943DE7A2ADCF716329D67D9BA7", hash_generated_method = "80629E77D345986E7B42BF6F6E4104EA")
    @DSModeled(DSC.SAFE)
    public IWallpaperManager getIWallpaperManager() {
        return (IWallpaperManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sGlobals.mService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.142 -0400", hash_original_method = "983E953189104E5D3E1EF4C33892C5EB", hash_generated_method = "5AA6F091BC3AE0165BF0C79EFA0A7FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDrawable() {
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, true);
        {
            Drawable dr;
            dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        //if (bm != null) {
            //Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            //dr.setDither(false);
            //return dr;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.142 -0400", hash_original_method = "EA4956080FAF0CF8E371329CB76D5A40", hash_generated_method = "C3BEB62EF7B2C30179F9479A8EACBE5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable peekDrawable() {
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, false);
        {
            Drawable dr;
            dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        //if (bm != null) {
            //Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            //dr.setDither(false);
            //return dr;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.143 -0400", hash_original_method = "8FF7C2E7F253EDCD7E0E3FAE36FB4E5D", hash_generated_method = "40DBBD500A5A6D9730F2267AE9F80F48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getFastDrawable() {
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, true);
        {
            Drawable var57BB4CA893E8B65CF0B8D723649ACF1C_2114878735 = (new FastBitmapDrawable(bm));
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        //if (bm != null) {
            //return new FastBitmapDrawable(bm);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.143 -0400", hash_original_method = "8A28F31302CE106CFE820B9CBC0915AE", hash_generated_method = "80334FF660B7391A1E2379AF87692BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable peekFastDrawable() {
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, false);
        {
            Drawable var57BB4CA893E8B65CF0B8D723649ACF1C_1709012055 = (new FastBitmapDrawable(bm));
        } //End block
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        //if (bm != null) {
            //return new FastBitmapDrawable(bm);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.144 -0400", hash_original_method = "214C7E80807DBED0084465B1D80DE965", hash_generated_method = "DCCEF115656E0608A0875270087578D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getBitmap() {
        Bitmap varC5A62E31C8CF28EAB4E8CD7BF5D73C26_1675024992 = (sGlobals.peekWallpaperBitmap(mContext, true));
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sGlobals.peekWallpaperBitmap(mContext, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.144 -0400", hash_original_method = "9DD74CD1F13AD5E4F4CF15160B046494", hash_generated_method = "E137D675DA1C337DD2F3C32778252113")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
        // ---------- Original Method ----------
        //sGlobals.forgetLoadedWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.154 -0400", hash_original_method = "BFBEA651CA003E449BAD7FB6481A127E", hash_generated_method = "E6BD335F4C5F9EA77D3B171E4738859D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WallpaperInfo getWallpaperInfo() {
        try 
        {
            WallpaperInfo var8D7349806B95D51C01BB29F9D9446009_1961736443 = (sGlobals.mService.getWallpaperInfo());
        } //End block
        catch (RemoteException e)
        { }
        return (WallpaperInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getWallpaperInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.156 -0400", hash_original_method = "A9B0C110F9B2DD6C9D3DF08018F94DD2", hash_generated_method = "C67FA620D63EA5D83C1F793C8F7477AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setResource(int resid) throws IOException {
        dsTaint.addTaint(resid);
        try 
        {
            Resources resources;
            resources = mContext.getResources();
            ParcelFileDescriptor fd;
            fd = sGlobals.mService.setWallpaper(
                    "res:" + resources.getResourceName(resid));
            {
                FileOutputStream fos;
                fos = null;
                try 
                {
                    fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                    setWallpaper(resources.openRawResource(resid), fos);
                } //End block
                finally 
                {
                    {
                        fos.close();
                    } //End block
                } //End block
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //Resources resources = mContext.getResources();
            //ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(
                    //"res:" + resources.getResourceName(resid));
            //if (fd != null) {
                //FileOutputStream fos = null;
                //try {
                    //fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                    //setWallpaper(resources.openRawResource(resid), fos);
                //} finally {
                    //if (fos != null) {
                        //fos.close();
                    //}
                //}
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.159 -0400", hash_original_method = "24319E223B48D297B4260CBD63DF9776", hash_generated_method = "E8245E3BEE43A99C010D89DFF0BA5EBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBitmap(Bitmap bitmap) throws IOException {
        dsTaint.addTaint(bitmap.dsTaint);
        try 
        {
            ParcelFileDescriptor fd;
            fd = sGlobals.mService.setWallpaper(null);
            FileOutputStream fos;
            fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            } //End block
            finally 
            {
                {
                    fos.close();
                } //End block
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            //if (fd == null) {
                //return;
            //}
            //FileOutputStream fos = null;
            //try {
                //fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                //bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            //} finally {
                //if (fos != null) {
                    //fos.close();
                //}
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.160 -0400", hash_original_method = "201E3B54F176FDB2F716DB9554E16862", hash_generated_method = "2487F7F075FE0D619864502FC10CD16D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStream(InputStream data) throws IOException {
        dsTaint.addTaint(data.dsTaint);
        try 
        {
            ParcelFileDescriptor fd;
            fd = sGlobals.mService.setWallpaper(null);
            FileOutputStream fos;
            fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                setWallpaper(data, fos);
            } //End block
            finally 
            {
                {
                    fos.close();
                } //End block
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            //if (fd == null) {
                //return;
            //}
            //FileOutputStream fos = null;
            //try {
                //fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                //setWallpaper(data, fos);
            //} finally {
                //if (fos != null) {
                    //fos.close();
                //}
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.162 -0400", hash_original_method = "4C0B3C480EF9954FF86E8D84EAD55CC1", hash_generated_method = "1B0F7D88C08F288AEC2923005297DC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setWallpaper(InputStream data, FileOutputStream fos) throws IOException {
        dsTaint.addTaint(fos.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        byte[] buffer;
        buffer = new byte[32768];
        int amt;
        {
            boolean var2B17B59B4F2F4E2A010AD44AD7A027B9_1562140725 = ((amt=data.read(buffer)) > 0);
            {
                fos.write(buffer, 0, amt);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //byte[] buffer = new byte[32768];
        //int amt;
        //while ((amt=data.read(buffer)) > 0) {
            //fos.write(buffer, 0, amt);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.163 -0400", hash_original_method = "D1A5F81505B1F3B03FABBA4410A80898", hash_generated_method = "8C5571BA87E9FCE574680CB4BEC466AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDesiredMinimumWidth() {
        try 
        {
            int varF4210454002966C2A27768BDBD596292_53946768 = (sGlobals.mService.getWidthHint());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getWidthHint();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.165 -0400", hash_original_method = "B18A5C89DB794D80A7E1B5CE60755D7A", hash_generated_method = "7B2681A21804C5DAA7A517757AD75D60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDesiredMinimumHeight() {
        try 
        {
            int var73CA9014DB323FE5C953F725553245A9_2085073853 = (sGlobals.mService.getHeightHint());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getHeightHint();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.165 -0400", hash_original_method = "24150471411E1AC7EC2E370FB5C4066A", hash_generated_method = "6E8FB9E147AA2C0A9930F151CAF4F817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        dsTaint.addTaint(minimumWidth);
        dsTaint.addTaint(minimumHeight);
        try 
        {
            sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.166 -0400", hash_original_method = "50451375F0F7110E301C30296ACA8A65", hash_generated_method = "1091BE2FE61AF4D81F765D8AD289311B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        dsTaint.addTaint(yOffset);
        dsTaint.addTaint(xOffset);
        dsTaint.addTaint(windowToken.dsTaint);
        IBinder fWindowToken;
        fWindowToken = windowToken;
        float fXOffset;
        fXOffset = xOffset;
        float fYOffset;
        fYOffset = yOffset;
        sGlobals.getHandler().post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.166 -0400", hash_original_method = "FB60FC39BBF5735DAB5B94EDE4106EB9", hash_generated_method = "87E65C58A468E8226DAED1B7F431869A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                try 
                {
                    ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
                } //End block
                catch (RemoteException e)
                { }
                catch (IllegalArgumentException e)
                { }
                // ---------- Original Method ----------
                //try {
                    //ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            //fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
                //} catch (RemoteException e) {
                //} catch (IllegalArgumentException e) {
                //}
            }
});
        // ---------- Original Method ----------
        //final IBinder fWindowToken = windowToken;
        //final float fXOffset = xOffset;
        //final float fYOffset = yOffset;
        //sGlobals.getHandler().post(new Runnable() {
            //public void run() {
                //try {
                    //ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            //fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
                //} catch (RemoteException e) {
                //} catch (IllegalArgumentException e) {
                //}
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.167 -0400", hash_original_method = "D2E7CBA6FEE1F1016E75D81DE5B86ECC", hash_generated_method = "8B46853DE256BA635130B2008BFCF534")
    @DSModeled(DSC.SAFE)
    public void setWallpaperOffsetSteps(float xStep, float yStep) {
        dsTaint.addTaint(xStep);
        dsTaint.addTaint(yStep);
        // ---------- Original Method ----------
        //mWallpaperXStep = xStep;
        //mWallpaperYStep = yStep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.167 -0400", hash_original_method = "5FDBB12430A98A22274A04FEE86533CB", hash_generated_method = "BC54562C39D83E1BAFE186A3F0F48182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendWallpaperCommand(IBinder windowToken, String action,
            int x, int y, int z, Bundle extras) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(windowToken.dsTaint);
        dsTaint.addTaint(z);
        dsTaint.addTaint(y);
        dsTaint.addTaint(extras.dsTaint);
        dsTaint.addTaint(x);
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    windowToken, action, x, y, z, extras, false);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    //windowToken, action, x, y, z, extras, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.167 -0400", hash_original_method = "4003FD7579057D5A21D7509B89350DFE", hash_generated_method = "42D361038B62B5273E9649334C9D43A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearWallpaperOffsets(IBinder windowToken) {
        dsTaint.addTaint(windowToken.dsTaint);
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    windowToken, -1, -1, -1, -1);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    //windowToken, -1, -1, -1, -1);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.168 -0400", hash_original_method = "C7793256C05758E1D6CDFCE99A7FE546", hash_generated_method = "AB99E5138557A852157F08526E2516F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() throws IOException {
        setResource(com.android.internal.R.drawable.default_wallpaper);
        // ---------- Original Method ----------
        //setResource(com.android.internal.R.drawable.default_wallpaper);
    }

    
        static Bitmap generateBitmap(Bitmap bm, int width, int height) {
        if (bm == null) {
            return null;
        }
        bm.setDensity(DisplayMetrics.DENSITY_DEVICE);
        if (width <= 0 || height <= 0
                || (bm.getWidth() == width && bm.getHeight() == height)) {
            return bm;
        }
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

    
    static class FastBitmapDrawable extends Drawable {
        private Bitmap mBitmap;
        private int mWidth;
        private int mHeight;
        private int mDrawLeft;
        private int mDrawTop;
        private Paint mPaint;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.169 -0400", hash_original_method = "A000E3823EF3583E37A464733E9034D5", hash_generated_method = "F4617B733C6BED9B2000871A2D9E7989")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private FastBitmapDrawable(Bitmap bitmap) {
            dsTaint.addTaint(bitmap.dsTaint);
            mWidth = bitmap.getWidth();
            mHeight = bitmap.getHeight();
            setBounds(0, 0, mWidth, mHeight);
            mPaint = new Paint();
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            // ---------- Original Method ----------
            //mBitmap = bitmap;
            //mWidth = bitmap.getWidth();
            //mHeight = bitmap.getHeight();
            //setBounds(0, 0, mWidth, mHeight);
            //mPaint = new Paint();
            //mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.169 -0400", hash_original_method = "740DEE0C93073DC91C8FEF81BF30F5D6", hash_generated_method = "3D54186EEC1031948389938B9F2AD936")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void draw(Canvas canvas) {
            dsTaint.addTaint(canvas.dsTaint);
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
            // ---------- Original Method ----------
            //canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.170 -0400", hash_original_method = "20937ACEFD1116260A9689661466F3F7", hash_generated_method = "19E72E8AB5576C6CA1E35275077EED2E")
        @DSModeled(DSC.SAFE)
        @Override
        public int getOpacity() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return PixelFormat.OPAQUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.170 -0400", hash_original_method = "AD75C11A4E8AD86B9F9EB3DCD5857128", hash_generated_method = "390FD5357CA51E9055173F6E498864F2")
        @DSModeled(DSC.SAFE)
        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            dsTaint.addTaint(bottom);
            dsTaint.addTaint(left);
            dsTaint.addTaint(right);
            dsTaint.addTaint(top);
            mDrawLeft = left + (right-left - mWidth) / 2;
            mDrawTop = top + (bottom-top - mHeight) / 2;
            // ---------- Original Method ----------
            //mDrawLeft = left + (right-left - mWidth) / 2;
            //mDrawTop = top + (bottom-top - mHeight) / 2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.170 -0400", hash_original_method = "51482143A770E9CBA4E27420DA4BB83A", hash_generated_method = "E6C8C0555D605E678827E9D05FAEE678")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setAlpha(int alpha) {
            dsTaint.addTaint(alpha);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.171 -0400", hash_original_method = "6EF98891DC00D446E5280E44B83BE80B", hash_generated_method = "C96F29F6C490136DD09F8799A1A5AA1F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setColorFilter(ColorFilter cf) {
            dsTaint.addTaint(cf.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.171 -0400", hash_original_method = "BBAE54C669BC97BDF73F051E3161B7DC", hash_generated_method = "94201CB36FD22C4FE95E354456A14195")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setDither(boolean dither) {
            dsTaint.addTaint(dither);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.172 -0400", hash_original_method = "072B9683A9FDD22E6BC18017D9B8BE50", hash_generated_method = "8D383E352F877CBC2BF84AA433971E40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setFilterBitmap(boolean filter) {
            dsTaint.addTaint(filter);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.172 -0400", hash_original_method = "7C6E7C05DAF2C7C11CBD631A19BA11F2", hash_generated_method = "38BEC3E71D17563C4CD2A100A7508A63")
        @DSModeled(DSC.SAFE)
        @Override
        public int getIntrinsicWidth() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.172 -0400", hash_original_method = "3C735D6B09C7947D1D4F4735F7E16410", hash_generated_method = "12A97A4C1391C4E0C5E5133813BAFA58")
        @DSModeled(DSC.SAFE)
        @Override
        public int getIntrinsicHeight() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.173 -0400", hash_original_method = "6C36D8FD6C4DA506CC2056E38D29BDE3", hash_generated_method = "F89E15DD00F93E87461D8C90ED8203AB")
        @DSModeled(DSC.SAFE)
        @Override
        public int getMinimumWidth() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.173 -0400", hash_original_method = "F7F1B37FEC841079758C9B817D6DD4F6", hash_generated_method = "8BADF994D917E73285FE9128CDBF2D07")
        @DSModeled(DSC.SAFE)
        @Override
        public int getMinimumHeight() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHeight;
        }

        
    }


    
    static class Globals extends IWallpaperManagerCallback.Stub {
        private IWallpaperManager mService;
        private Bitmap mWallpaper;
        private Bitmap mDefaultWallpaper;
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.174 -0400", hash_original_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C", hash_generated_method = "C26CA93779833D02D5915F4434503EA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Globals(Looper looper) {
            dsTaint.addTaint(looper.dsTaint);
            IBinder b;
            b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            mService = IWallpaperManager.Stub.asInterface(b);
            mHandler = new Handler(looper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.174 -0400", hash_original_method = "21A8DB01A9CD0DD17CF9725E26AFC9F4", hash_generated_method = "EA21E5B1FFADAB4682FA94B20FAAE848")
                @DSModeled(DSC.SAFE)
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case MSG_CLEAR_WALLPAPER 
                    {
                        mWallpaper = null;
                        mDefaultWallpaper = null;
                    } //End block
                    //End case MSG_CLEAR_WALLPAPER 
                    // ---------- Original Method ----------
                    //switch (msg.what) {
                        //case MSG_CLEAR_WALLPAPER:
                            //synchronized (this) {
                                //mWallpaper = null;
                                //mDefaultWallpaper = null;
                            //}
                            //break;
                    //}
                }
};
            // ---------- Original Method ----------
            //IBinder b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            //mService = IWallpaperManager.Stub.asInterface(b);
            //mHandler = new Handler(looper) {
                //@Override
                //public void handleMessage(Message msg) {
                    //switch (msg.what) {
                        //case MSG_CLEAR_WALLPAPER:
                            //synchronized (this) {
                                //mWallpaper = null;
                                //mDefaultWallpaper = null;
                            //}
                            //break;
                    //}
                //}
            //};
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.174 -0400", hash_original_method = "F846E10F84F4E35E470DA1B587CB2864", hash_generated_method = "288447422A981A1450135744449D6BD1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onWallpaperChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
            // ---------- Original Method ----------
            //mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.185 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "8F54973AA943C2C00E08B8BBB03BB7F6")
        @DSModeled(DSC.SAFE)
        public Handler getHandler() {
            return (Handler)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mHandler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.189 -0400", hash_original_method = "D22E4158438EA0372FD1CBCCE67470DB", hash_generated_method = "27CA0A0963166DAD4A11F7E49C89FE8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bitmap peekWallpaperBitmap(Context context, boolean returnDefault) {
            dsTaint.addTaint(returnDefault);
            dsTaint.addTaint(context.dsTaint);
            {
                mWallpaper = null;
                try 
                {
                    mWallpaper = getCurrentWallpaperLocked();
                } //End block
                catch (OutOfMemoryError e)
                { }
                {
                    {
                        mDefaultWallpaper = getDefaultWallpaperLocked(context);
                    } //End block
                    {
                        mDefaultWallpaper = null;
                    } //End block
                } //End block
            } //End block
            return (Bitmap)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.190 -0400", hash_original_method = "0171ADD4BBF298493CC8451FAA0D3640", hash_generated_method = "3151A98DD7FE11BDFB8D5F0E76230461")
        @DSModeled(DSC.SAFE)
        public void forgetLoadedWallpaper() {
            {
                mWallpaper = null;
                mDefaultWallpaper = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mWallpaper = null;
                //mDefaultWallpaper = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.190 -0400", hash_original_method = "16667119AC99E737F53C6C4F154ADE70", hash_generated_method = "0E3F8B41966DBBEAE5D4931D79EC184E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Bitmap getCurrentWallpaperLocked() {
            try 
            {
                Bundle params;
                params = new Bundle();
                ParcelFileDescriptor fd;
                fd = mService.getWallpaper(this, params);
                {
                    int width;
                    width = params.getInt("width", 0);
                    int height;
                    height = params.getInt("height", 0);
                    try 
                    {
                        BitmapFactory.Options options;
                        options = new BitmapFactory.Options();
                        Bitmap bm;
                        bm = BitmapFactory.decodeFileDescriptor(
                                fd.getFileDescriptor(), null, options);
                        Bitmap var76262638CC71A7993D218B6125912D78_1582177041 = (generateBitmap(bm, width, height));
                    } //End block
                    catch (OutOfMemoryError e)
                    { }
                    finally 
                    {
                        try 
                        {
                            fd.close();
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            { }
            return (Bitmap)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.192 -0400", hash_original_method = "7D56EB02955E82C8DDBD02F9FFA3CE84", hash_generated_method = "D887C0B3D08510D2CCD8354314340DE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Bitmap getDefaultWallpaperLocked(Context context) {
            dsTaint.addTaint(context.dsTaint);
            try 
            {
                InputStream is;
                is = context.getResources().openRawResource(
                        com.android.internal.R.drawable.default_wallpaper);
                {
                    int width;
                    width = mService.getWidthHint();
                    int height;
                    height = mService.getHeightHint();
                    try 
                    {
                        BitmapFactory.Options options;
                        options = new BitmapFactory.Options();
                        Bitmap bm;
                        bm = BitmapFactory.decodeStream(is, null, options);
                        Bitmap var76262638CC71A7993D218B6125912D78_2053818908 = (generateBitmap(bm, width, height));
                    } //End block
                    catch (OutOfMemoryError e)
                    { }
                    finally 
                    {
                        try 
                        {
                            is.close();
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            { }
            return (Bitmap)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int MSG_CLEAR_WALLPAPER = 1;
    }


    
    private static String TAG = "WallpaperManager";
    private static boolean DEBUG = false;
    public static final String ACTION_LIVE_WALLPAPER_CHOOSER
            = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    public static final String COMMAND_TAP = "android.wallpaper.tap";
    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    public static final String COMMAND_DROP = "android.home.drop";
    private static final Object sSync = new Object[0];
    private static Globals sGlobals;
}

