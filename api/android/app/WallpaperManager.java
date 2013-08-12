package android.app;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.435 -0400", hash_original_field = "84013B9B56B226FA2280C6FF3BE1B5D7", hash_generated_field = "79E763BC7220887CD284E78890CFBD39")

    private float mWallpaperXStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.435 -0400", hash_original_field = "D3C49CE46785D3C0A547BF9D502791F7", hash_generated_field = "4E298C71D3B5B2CA896AF40FC8DB3101")

    private float mWallpaperYStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.435 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.436 -0400", hash_original_method = "AA9944AB0F8A7F99E0205835B0AC132C", hash_generated_method = "E22DDA2EADD394D8855514A4922CD1B9")
      WallpaperManager(Context context, Handler handler) {
        addTaint(handler.getTaint());
        mContext = context;
        initGlobals(context.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //initGlobals(context.getMainLooper());
    }

    
    @DSModeled(DSC.BAN)
    static void initGlobals(Looper looper) {
        synchronized (sSync) {
            if (sGlobals == null) {
                sGlobals = new Globals(looper);
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static WallpaperManager getInstance(Context context) {
        return (WallpaperManager)context.getSystemService(
                Context.WALLPAPER_SERVICE);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.438 -0400", hash_original_method = "6F9497943DE7A2ADCF716329D67D9BA7", hash_generated_method = "C1980254BC9416C1574BFBB2E63CDC67")
    public IWallpaperManager getIWallpaperManager() {
IWallpaperManager varBC9BA9E0BC90EB794A65A5242E56B9CA_1871073191 =         sGlobals.mService;
        varBC9BA9E0BC90EB794A65A5242E56B9CA_1871073191.addTaint(taint);
        return varBC9BA9E0BC90EB794A65A5242E56B9CA_1871073191;
        // ---------- Original Method ----------
        //return sGlobals.mService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.439 -0400", hash_original_method = "983E953189104E5D3E1EF4C33892C5EB", hash_generated_method = "BB9E5D46CB476747FE3A6C5B6AD678CA")
    public Drawable getDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        if(bm != null)        
        {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_500139754 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_500139754.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_500139754;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_2076286107 =         null;
        var540C13E9E156B687226421B24F2DF178_2076286107.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2076286107;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        //if (bm != null) {
            //Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            //dr.setDither(false);
            //return dr;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.440 -0400", hash_original_method = "EA4956080FAF0CF8E371329CB76D5A40", hash_generated_method = "6FE81A8A927D50FEB88101DED48BB50C")
    public Drawable peekDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        if(bm != null)        
        {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_2022241912 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_2022241912.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_2022241912;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_60400103 =         null;
        var540C13E9E156B687226421B24F2DF178_60400103.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_60400103;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        //if (bm != null) {
            //Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            //dr.setDither(false);
            //return dr;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.440 -0400", hash_original_method = "8FF7C2E7F253EDCD7E0E3FAE36FB4E5D", hash_generated_method = "156404A82F57F52E763C3FFFD8BD7ADB")
    public Drawable getFastDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        if(bm != null)        
        {
Drawable var6679CB9AAED6402C21CF9F5F5B35DF1E_1482242467 =             new FastBitmapDrawable(bm);
            var6679CB9AAED6402C21CF9F5F5B35DF1E_1482242467.addTaint(taint);
            return var6679CB9AAED6402C21CF9F5F5B35DF1E_1482242467;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_313494845 =         null;
        var540C13E9E156B687226421B24F2DF178_313494845.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_313494845;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        //if (bm != null) {
            //return new FastBitmapDrawable(bm);
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.442 -0400", hash_original_method = "8A28F31302CE106CFE820B9CBC0915AE", hash_generated_method = "3B7DE77192860428731672E4EE7BD15C")
    public Drawable peekFastDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        if(bm != null)        
        {
Drawable var6679CB9AAED6402C21CF9F5F5B35DF1E_2105540221 =             new FastBitmapDrawable(bm);
            var6679CB9AAED6402C21CF9F5F5B35DF1E_2105540221.addTaint(taint);
            return var6679CB9AAED6402C21CF9F5F5B35DF1E_2105540221;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_96356134 =         null;
        var540C13E9E156B687226421B24F2DF178_96356134.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_96356134;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        //if (bm != null) {
            //return new FastBitmapDrawable(bm);
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.442 -0400", hash_original_method = "214C7E80807DBED0084465B1D80DE965", hash_generated_method = "986973D0A67ECED90AD9B6DAD0D8517C")
    public Bitmap getBitmap() {
Bitmap varCA837979D68D3CF2EF7A932B9188079C_1940508861 =         sGlobals.peekWallpaperBitmap(mContext, true);
        varCA837979D68D3CF2EF7A932B9188079C_1940508861.addTaint(taint);
        return varCA837979D68D3CF2EF7A932B9188079C_1940508861;
        // ---------- Original Method ----------
        //return sGlobals.peekWallpaperBitmap(mContext, true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.443 -0400", hash_original_method = "9DD74CD1F13AD5E4F4CF15160B046494", hash_generated_method = "E137D675DA1C337DD2F3C32778252113")
    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
        // ---------- Original Method ----------
        //sGlobals.forgetLoadedWallpaper();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.443 -0400", hash_original_method = "BFBEA651CA003E449BAD7FB6481A127E", hash_generated_method = "2A965A42474769969FF127C43E0827FF")
    public WallpaperInfo getWallpaperInfo() {
        try 
        {
WallpaperInfo var75A430F26FA0EDE23F28A1F72746D1D7_1421985777 =             sGlobals.mService.getWallpaperInfo();
            var75A430F26FA0EDE23F28A1F72746D1D7_1421985777.addTaint(taint);
            return var75A430F26FA0EDE23F28A1F72746D1D7_1421985777;
        } //End block
        catch (RemoteException e)
        {
WallpaperInfo var540C13E9E156B687226421B24F2DF178_1967506534 =             null;
            var540C13E9E156B687226421B24F2DF178_1967506534.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1967506534;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getWallpaperInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.445 -0400", hash_original_method = "A9B0C110F9B2DD6C9D3DF08018F94DD2", hash_generated_method = "4FDF4953CFC48C9DF6133B59C795090D")
    public void setResource(int resid) throws IOException {
        addTaint(resid);
        try 
        {
            Resources resources = mContext.getResources();
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(
                    "res:" + resources.getResourceName(resid));
            if(fd != null)            
            {
                FileOutputStream fos = null;
                try 
                {
                    fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                    setWallpaper(resources.openRawResource(resid), fos);
                } //End block
                finally 
                {
                    if(fos != null)                    
                    {
                        fos.close();
                    } //End block
                } //End block
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.447 -0400", hash_original_method = "24319E223B48D297B4260CBD63DF9776", hash_generated_method = "4D99E26E9DBB5DEC43DDFEF00E8BDFA5")
    public void setBitmap(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        try 
        {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            if(fd == null)            
            {
                return;
            } //End block
            FileOutputStream fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            } //End block
            finally 
            {
                if(fos != null)                
                {
                    fos.close();
                } //End block
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.449 -0400", hash_original_method = "201E3B54F176FDB2F716DB9554E16862", hash_generated_method = "13F594B88117DA16486D2F6D8674571D")
    public void setStream(InputStream data) throws IOException {
        addTaint(data.getTaint());
        try 
        {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            if(fd == null)            
            {
                return;
            } //End block
            FileOutputStream fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                setWallpaper(data, fos);
            } //End block
            finally 
            {
                if(fos != null)                
                {
                    fos.close();
                } //End block
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.451 -0400", hash_original_method = "4C0B3C480EF9954FF86E8D84EAD55CC1", hash_generated_method = "1CFC61DCCDA520DDD9ABBB665445DDB7")
    private void setWallpaper(InputStream data, FileOutputStream fos) throws IOException {
        addTaint(fos.getTaint());
        addTaint(data.getTaint());
        byte[] buffer = new byte[32768];
        int amt;
        while
((amt=data.read(buffer)) > 0)        
        {
            fos.write(buffer, 0, amt);
        } //End block
        // ---------- Original Method ----------
        //byte[] buffer = new byte[32768];
        //int amt;
        //while ((amt=data.read(buffer)) > 0) {
            //fos.write(buffer, 0, amt);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.452 -0400", hash_original_method = "D1A5F81505B1F3B03FABBA4410A80898", hash_generated_method = "037903C3D6C53821A387D00CDB1A141F")
    public int getDesiredMinimumWidth() {
        try 
        {
            int var5554EC7C8DA473A2EFE58312B6DE3DEB_732929512 = (sGlobals.mService.getWidthHint());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568896608 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568896608;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1388052712 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819811882 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819811882;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getWidthHint();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.453 -0400", hash_original_method = "B18A5C89DB794D80A7E1B5CE60755D7A", hash_generated_method = "EB35591DD153183C0B34A9DA4E55FC54")
    public int getDesiredMinimumHeight() {
        try 
        {
            int var8081CB13FA563EE91C3EEC65E27BBF83_111840558 = (sGlobals.mService.getHeightHint());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254715588 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254715588;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_693813165 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849660326 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849660326;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getHeightHint();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.454 -0400", hash_original_method = "24150471411E1AC7EC2E370FB5C4066A", hash_generated_method = "E59F0F9B8237A2ABEC8BD8F1B3745DAC")
    public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        addTaint(minimumHeight);
        addTaint(minimumWidth);
        try 
        {
            sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.456 -0400", hash_original_method = "50451375F0F7110E301C30296ACA8A65", hash_generated_method = "247111BB9B93BF1ECFF28D6FA392DA59")
    public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        addTaint(yOffset);
        addTaint(xOffset);
        addTaint(windowToken.getTaint());
        final IBinder fWindowToken = windowToken;
        final float fXOffset = xOffset;
        final float fYOffset = yOffset;
        sGlobals.getHandler().post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.455 -0400", hash_original_method = "FB60FC39BBF5735DAB5B94EDE4106EB9", hash_generated_method = "B1DBE325CF47545C6221D4AEFB96A7FD")
        public void run() {
            try 
            {
                ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            catch (IllegalArgumentException e)
            {
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.458 -0400", hash_original_method = "D2E7CBA6FEE1F1016E75D81DE5B86ECC", hash_generated_method = "EADA38664BEC7414A75FE025CEA53E62")
    public void setWallpaperOffsetSteps(float xStep, float yStep) {
        mWallpaperXStep = xStep;
        mWallpaperYStep = yStep;
        // ---------- Original Method ----------
        //mWallpaperXStep = xStep;
        //mWallpaperYStep = yStep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.460 -0400", hash_original_method = "5FDBB12430A98A22274A04FEE86533CB", hash_generated_method = "A61F41A8E5E07209C644A1D8A4409AB7")
    public void sendWallpaperCommand(IBinder windowToken, String action,
            int x, int y, int z, Bundle extras) {
        addTaint(extras.getTaint());
        addTaint(z);
        addTaint(y);
        addTaint(x);
        addTaint(action.getTaint());
        addTaint(windowToken.getTaint());
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    windowToken, action, x, y, z, extras, false);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    //windowToken, action, x, y, z, extras, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.461 -0400", hash_original_method = "4003FD7579057D5A21D7509B89350DFE", hash_generated_method = "22EF8AE9FC1287367E46FBEEB6795999")
    public void clearWallpaperOffsets(IBinder windowToken) {
        addTaint(windowToken.getTaint());
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    windowToken, -1, -1, -1, -1);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    //windowToken, -1, -1, -1, -1);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.462 -0400", hash_original_method = "C7793256C05758E1D6CDFCE99A7FE546", hash_generated_method = "AB99E5138557A852157F08526E2516F1")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.464 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

        private Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.464 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.464 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.464 -0400", hash_original_field = "E635C9C85981E1DCE6AEF62F70750A33", hash_generated_field = "DA577E86F21E75B26C2B7DE9380FC9DD")

        private int mDrawLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.464 -0400", hash_original_field = "F9576DC303B2C6B7B08894614FE4B0E1", hash_generated_field = "BC12CCF55C693145726833EAB6B40601")

        private int mDrawTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.464 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

        private Paint mPaint;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.466 -0400", hash_original_method = "A000E3823EF3583E37A464733E9034D5", hash_generated_method = "38655F32CD9DFD57679F12FD7FFD5218")
        private  FastBitmapDrawable(Bitmap bitmap) {
            mBitmap = bitmap;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.467 -0400", hash_original_method = "740DEE0C93073DC91C8FEF81BF30F5D6", hash_generated_method = "4BB8A8A6BEF2A0039A5B13820C5B8692")
        @Override
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
            // ---------- Original Method ----------
            //canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.468 -0400", hash_original_method = "20937ACEFD1116260A9689661466F3F7", hash_generated_method = "51DC6E2D403BDF069C7190617D98253B")
        @Override
        public int getOpacity() {
            int var159D51265084B78CCBC493D119AF4EAE_701252911 = (PixelFormat.OPAQUE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137940883 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137940883;
            // ---------- Original Method ----------
            //return PixelFormat.OPAQUE;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.469 -0400", hash_original_method = "AD75C11A4E8AD86B9F9EB3DCD5857128", hash_generated_method = "DD8AC77956034A39F37DA405A27E901A")
        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            mDrawLeft = left + (right-left - mWidth) / 2;
            mDrawTop = top + (bottom-top - mHeight) / 2;
            // ---------- Original Method ----------
            //mDrawLeft = left + (right-left - mWidth) / 2;
            //mDrawTop = top + (bottom-top - mHeight) / 2;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.470 -0400", hash_original_method = "51482143A770E9CBA4E27420DA4BB83A", hash_generated_method = "B036C63FEE8D28D4A506E760AE942317")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_143152478 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_143152478.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_143152478;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.471 -0400", hash_original_method = "6EF98891DC00D446E5280E44B83BE80B", hash_generated_method = "3378172AE363C3A4CFF3151873E9D71F")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_2119678022 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_2119678022.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_2119678022;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.472 -0400", hash_original_method = "BBAE54C669BC97BDF73F051E3161B7DC", hash_generated_method = "5E4B176023046CF7B623C44D7A17352E")
        @Override
        public void setDither(boolean dither) {
            addTaint(dither);
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_1429219512 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_1429219512.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_1429219512;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.472 -0400", hash_original_method = "072B9683A9FDD22E6BC18017D9B8BE50", hash_generated_method = "33CF041F7FB5C3CCF96CC0DC647EA0C8")
        @Override
        public void setFilterBitmap(boolean filter) {
            addTaint(filter);
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_658624064 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_658624064.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_658624064;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.473 -0400", hash_original_method = "7C6E7C05DAF2C7C11CBD631A19BA11F2", hash_generated_method = "8ADAB3ED3A88B0BBA477529D7D4EAB8A")
        @Override
        public int getIntrinsicWidth() {
            int varA3DB1626A190732E588FD0D14FC8FB31_2134409394 = (mWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663972734 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1663972734;
            // ---------- Original Method ----------
            //return mWidth;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.473 -0400", hash_original_method = "3C735D6B09C7947D1D4F4735F7E16410", hash_generated_method = "BDCDBB7DF4E7E1641923A9EB44C3532F")
        @Override
        public int getIntrinsicHeight() {
            int var483542B05A951AA16D89C7F809C20811_1812408016 = (mHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911065435 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911065435;
            // ---------- Original Method ----------
            //return mHeight;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.474 -0400", hash_original_method = "6C36D8FD6C4DA506CC2056E38D29BDE3", hash_generated_method = "02E5A143F827236E61B585DB6ACA2BCF")
        @Override
        public int getMinimumWidth() {
            int varA3DB1626A190732E588FD0D14FC8FB31_1038802148 = (mWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296607565 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296607565;
            // ---------- Original Method ----------
            //return mWidth;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.474 -0400", hash_original_method = "F7F1B37FEC841079758C9B817D6DD4F6", hash_generated_method = "4712C7339C9457B4D428126987E10B6F")
        @Override
        public int getMinimumHeight() {
            int var483542B05A951AA16D89C7F809C20811_1071085713 = (mHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641025825 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_641025825;
            // ---------- Original Method ----------
            //return mHeight;
        }

        
    }


    
    static class Globals extends IWallpaperManagerCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.475 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5245D2ACF9BCB6EB2851F6A6EAF2BF16")

        private IWallpaperManager mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.476 -0400", hash_original_field = "58B578A12BDF7C3A2A94BAD6A36D39B5", hash_generated_field = "C4E8C03ED548D1B4E21D66638AE05698")

        private Bitmap mWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.476 -0400", hash_original_field = "38E51BE28DE288EB99141B1F4A850676", hash_generated_field = "2C326FED1949B0798BBC7F12C35F2605")

        private Bitmap mDefaultWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.476 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.480 -0400", hash_original_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C", hash_generated_method = "A2A09AD7B2AB05C41295356F766682E6")
          Globals(Looper looper) {
            IBinder b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            mService = IWallpaperManager.Stub.asInterface(b);
            mHandler = new Handler(looper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.479 -0400", hash_original_method = "21A8DB01A9CD0DD17CF9725E26AFC9F4", hash_generated_method = "7E0C858A33640BEB5E8C376351967D9F")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
switch(msg.what){
                case MSG_CLEAR_WALLPAPER:
                synchronized
(this)                {
                    mWallpaper = null;
                    mDefaultWallpaper = null;
                } //End block
                break;
}
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.481 -0400", hash_original_method = "F846E10F84F4E35E470DA1B587CB2864", hash_generated_method = "288447422A981A1450135744449D6BD1")
        public void onWallpaperChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
            // ---------- Original Method ----------
            //mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.482 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "C1C58FA1813E3C4FE27D233AA7BA8DF0")
        public Handler getHandler() {
Handler varF60F4C595C5EF9EE40FAD1FE8119479B_1203374089 =             mHandler;
            varF60F4C595C5EF9EE40FAD1FE8119479B_1203374089.addTaint(taint);
            return varF60F4C595C5EF9EE40FAD1FE8119479B_1203374089;
            // ---------- Original Method ----------
            //return mHandler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.484 -0400", hash_original_method = "D22E4158438EA0372FD1CBCCE67470DB", hash_generated_method = "E03104FDC35B1D4458B09EE07F5302A3")
        public Bitmap peekWallpaperBitmap(Context context, boolean returnDefault) {
            addTaint(returnDefault);
            synchronized
(this)            {
                if(mWallpaper != null)                
                {
Bitmap varC038012FF42C722A2F248588A92BE2E9_1801842194 =                     mWallpaper;
                    varC038012FF42C722A2F248588A92BE2E9_1801842194.addTaint(taint);
                    return varC038012FF42C722A2F248588A92BE2E9_1801842194;
                } //End block
                if(mDefaultWallpaper != null)                
                {
Bitmap var3EEC6F8E322FB1EBD331F174E194038B_670964496 =                     mDefaultWallpaper;
                    var3EEC6F8E322FB1EBD331F174E194038B_670964496.addTaint(taint);
                    return var3EEC6F8E322FB1EBD331F174E194038B_670964496;
                } //End block
                mWallpaper = null;
                try 
                {
                    mWallpaper = getCurrentWallpaperLocked();
                } //End block
                catch (OutOfMemoryError e)
                {
                } //End block
                if(returnDefault)                
                {
                    if(mWallpaper == null)                    
                    {
                        mDefaultWallpaper = getDefaultWallpaperLocked(context);
Bitmap var3EEC6F8E322FB1EBD331F174E194038B_210396583 =                         mDefaultWallpaper;
                        var3EEC6F8E322FB1EBD331F174E194038B_210396583.addTaint(taint);
                        return var3EEC6F8E322FB1EBD331F174E194038B_210396583;
                    } //End block
                    else
                    {
                        mDefaultWallpaper = null;
                    } //End block
                } //End block
Bitmap varC038012FF42C722A2F248588A92BE2E9_952259215 =                 mWallpaper;
                varC038012FF42C722A2F248588A92BE2E9_952259215.addTaint(taint);
                return varC038012FF42C722A2F248588A92BE2E9_952259215;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.486 -0400", hash_original_method = "0171ADD4BBF298493CC8451FAA0D3640", hash_generated_method = "D9BB3FC4AB08399BDA57536FEC203D0F")
        public void forgetLoadedWallpaper() {
            synchronized
(this)            {
                mWallpaper = null;
                mDefaultWallpaper = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //mWallpaper = null;
                //mDefaultWallpaper = null;
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.487 -0400", hash_original_method = "16667119AC99E737F53C6C4F154ADE70", hash_generated_method = "8905A3A754B2145FB1221F30FEC48A5D")
        private Bitmap getCurrentWallpaperLocked() {
            try 
            {
                Bundle params = new Bundle();
                ParcelFileDescriptor fd = mService.getWallpaper(this, params);
                if(fd != null)                
                {
                    int width = params.getInt("width", 0);
                    int height = params.getInt("height", 0);
                    try 
                    {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        Bitmap bm = BitmapFactory.decodeFileDescriptor(
                                fd.getFileDescriptor(), null, options);
Bitmap var1D039D0CCDEFFF307D958D1412EFBD6C_127178641 =                         generateBitmap(bm, width, height);
                        var1D039D0CCDEFFF307D958D1412EFBD6C_127178641.addTaint(taint);
                        return var1D039D0CCDEFFF307D958D1412EFBD6C_127178641;
                    } //End block
                    catch (OutOfMemoryError e)
                    {
                    } //End block
                    finally 
                    {
                        try 
                        {
                            fd.close();
                        } //End block
                        catch (IOException e)
                        {
                        } //End block
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
Bitmap var540C13E9E156B687226421B24F2DF178_1740261013 =             null;
            var540C13E9E156B687226421B24F2DF178_1740261013.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1740261013;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.489 -0400", hash_original_method = "7D56EB02955E82C8DDBD02F9FFA3CE84", hash_generated_method = "8FAEDB966CC4186F3BA9A3F469430357")
        private Bitmap getDefaultWallpaperLocked(Context context) {
            addTaint(context.getTaint());
            try 
            {
                InputStream is = context.getResources().openRawResource(
                        com.android.internal.R.drawable.default_wallpaper);
                if(is != null)                
                {
                    int width = mService.getWidthHint();
                    int height = mService.getHeightHint();
                    try 
                    {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        Bitmap bm = BitmapFactory.decodeStream(is, null, options);
Bitmap var1D039D0CCDEFFF307D958D1412EFBD6C_1264610705 =                         generateBitmap(bm, width, height);
                        var1D039D0CCDEFFF307D958D1412EFBD6C_1264610705.addTaint(taint);
                        return var1D039D0CCDEFFF307D958D1412EFBD6C_1264610705;
                    } //End block
                    catch (OutOfMemoryError e)
                    {
                    } //End block
                    finally 
                    {
                        try 
                        {
                            is.close();
                        } //End block
                        catch (IOException e)
                        {
                        } //End block
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
Bitmap var540C13E9E156B687226421B24F2DF178_2127660874 =             null;
            var540C13E9E156B687226421B24F2DF178_2127660874.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2127660874;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.490 -0400", hash_original_field = "F1F1BF9B224FCAF5DF81E5526C089928", hash_generated_field = "C11BAEA45DDA2586D27A4A6A9EBDE72E")

        private static final int MSG_CLEAR_WALLPAPER = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.490 -0400", hash_original_field = "5E5CA8515FB353F692CCE4E2CD540205", hash_generated_field = "48A0CC9AB0B3F0E9E45F7F457712B59F")

    private static String TAG = "WallpaperManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.490 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.490 -0400", hash_original_field = "AE1D5613EB1ED29BAF3381A28C27DFAF", hash_generated_field = "DEFFCFE16339DBDBF08B336D28EF6A17")

    public static final String ACTION_LIVE_WALLPAPER_CHOOSER
            = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.491 -0400", hash_original_field = "DE257FD4977D6A04A6C5F5061AFDD7BC", hash_generated_field = "BF5D2A76907CE9E554A3FE854675BFD7")

    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.491 -0400", hash_original_field = "B4CED6A8F9ED2A8F59AB300E0C6705D4", hash_generated_field = "F96B596B27509EEB5AD3777B9E252E5D")

    public static final String COMMAND_TAP = "android.wallpaper.tap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.491 -0400", hash_original_field = "6455ECA38E74E9465D6048417F1532EA", hash_generated_field = "818BE2DF368F81E0A32AC1FE0FD288C9")

    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.491 -0400", hash_original_field = "A7FC4256BE49D01D37FE69B85AA024B5", hash_generated_field = "70F84F0650C85E3FC996BE9B45E4D2C5")

    public static final String COMMAND_DROP = "android.home.drop";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.491 -0400", hash_original_field = "43179E88F59B44607089B9CA3FB276A3", hash_generated_field = "EECB5088E51D82E124490D50E038120E")

    private static final Object sSync = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.491 -0400", hash_original_field = "7FD9B6E291F1091AAE6622BF638EAD65", hash_generated_field = "FAC961618570B702A278896949F1B020")

    private static Globals sGlobals;
}

