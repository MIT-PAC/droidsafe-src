package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.301 -0400", hash_original_field = "84013B9B56B226FA2280C6FF3BE1B5D7", hash_generated_field = "79E763BC7220887CD284E78890CFBD39")

    private float mWallpaperXStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.302 -0400", hash_original_field = "D3C49CE46785D3C0A547BF9D502791F7", hash_generated_field = "4E298C71D3B5B2CA896AF40FC8DB3101")

    private float mWallpaperYStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.302 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.302 -0400", hash_original_method = "AA9944AB0F8A7F99E0205835B0AC132C", hash_generated_method = "E22DDA2EADD394D8855514A4922CD1B9")
      WallpaperManager(Context context, Handler handler) {
        addTaint(handler.getTaint());
        mContext = context;
        initGlobals(context.getMainLooper());
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.304 -0400", hash_original_method = "6F9497943DE7A2ADCF716329D67D9BA7", hash_generated_method = "0DF23B316BCFAD91E49DAA7A41EAC113")
    public IWallpaperManager getIWallpaperManager() {
IWallpaperManager varBC9BA9E0BC90EB794A65A5242E56B9CA_772098920 =         sGlobals.mService;
        varBC9BA9E0BC90EB794A65A5242E56B9CA_772098920.addTaint(taint);
        return varBC9BA9E0BC90EB794A65A5242E56B9CA_772098920;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.304 -0400", hash_original_method = "983E953189104E5D3E1EF4C33892C5EB", hash_generated_method = "C9B4BCBC28224E4D957FC2F0836C5528")
    public Drawable getDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
    if(bm != null)        
        {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_924182653 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_924182653.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_924182653;
        } 
Drawable var540C13E9E156B687226421B24F2DF178_1625069622 =         null;
        var540C13E9E156B687226421B24F2DF178_1625069622.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1625069622;
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.305 -0400", hash_original_method = "EA4956080FAF0CF8E371329CB76D5A40", hash_generated_method = "9D66B5DB7C911F2033067820F06BF5F9")
    public Drawable peekDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
    if(bm != null)        
        {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1892665996 =             dr;
            varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1892665996.addTaint(taint);
            return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1892665996;
        } 
Drawable var540C13E9E156B687226421B24F2DF178_1300967474 =         null;
        var540C13E9E156B687226421B24F2DF178_1300967474.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1300967474;
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.306 -0400", hash_original_method = "8FF7C2E7F253EDCD7E0E3FAE36FB4E5D", hash_generated_method = "F6B3B900E49CF9DEB02B40629880CB2F")
    public Drawable getFastDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
    if(bm != null)        
        {
Drawable var6679CB9AAED6402C21CF9F5F5B35DF1E_1133671270 =             new FastBitmapDrawable(bm);
            var6679CB9AAED6402C21CF9F5F5B35DF1E_1133671270.addTaint(taint);
            return var6679CB9AAED6402C21CF9F5F5B35DF1E_1133671270;
        } 
Drawable var540C13E9E156B687226421B24F2DF178_1179085623 =         null;
        var540C13E9E156B687226421B24F2DF178_1179085623.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1179085623;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.307 -0400", hash_original_method = "8A28F31302CE106CFE820B9CBC0915AE", hash_generated_method = "0E1C243C4729B30D00AFFB359CC5DDA4")
    public Drawable peekFastDrawable() {
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
    if(bm != null)        
        {
Drawable var6679CB9AAED6402C21CF9F5F5B35DF1E_1349430969 =             new FastBitmapDrawable(bm);
            var6679CB9AAED6402C21CF9F5F5B35DF1E_1349430969.addTaint(taint);
            return var6679CB9AAED6402C21CF9F5F5B35DF1E_1349430969;
        } 
Drawable var540C13E9E156B687226421B24F2DF178_445443300 =         null;
        var540C13E9E156B687226421B24F2DF178_445443300.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_445443300;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.307 -0400", hash_original_method = "214C7E80807DBED0084465B1D80DE965", hash_generated_method = "E02C57C510B95B471997C1165F707BED")
    public Bitmap getBitmap() {
Bitmap varCA837979D68D3CF2EF7A932B9188079C_158455143 =         sGlobals.peekWallpaperBitmap(mContext, true);
        varCA837979D68D3CF2EF7A932B9188079C_158455143.addTaint(taint);
        return varCA837979D68D3CF2EF7A932B9188079C_158455143;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.308 -0400", hash_original_method = "9DD74CD1F13AD5E4F4CF15160B046494", hash_generated_method = "E137D675DA1C337DD2F3C32778252113")
    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.308 -0400", hash_original_method = "BFBEA651CA003E449BAD7FB6481A127E", hash_generated_method = "E3FBBBB0C7B4AC9B4C065D5215DB36EF")
    public WallpaperInfo getWallpaperInfo() {
        try 
        {
WallpaperInfo var75A430F26FA0EDE23F28A1F72746D1D7_541820165 =             sGlobals.mService.getWallpaperInfo();
            var75A430F26FA0EDE23F28A1F72746D1D7_541820165.addTaint(taint);
            return var75A430F26FA0EDE23F28A1F72746D1D7_541820165;
        } 
        catch (RemoteException e)
        {
WallpaperInfo var540C13E9E156B687226421B24F2DF178_1344622307 =             null;
            var540C13E9E156B687226421B24F2DF178_1344622307.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1344622307;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.309 -0400", hash_original_method = "A9B0C110F9B2DD6C9D3DF08018F94DD2", hash_generated_method = "4FDF4953CFC48C9DF6133B59C795090D")
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
                } 
                finally 
                {
    if(fos != null)                    
                    {
                        fos.close();
                    } 
                } 
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
            
                    
            
                
                
                    
                    
                
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.310 -0400", hash_original_method = "24319E223B48D297B4260CBD63DF9776", hash_generated_method = "4D99E26E9DBB5DEC43DDFEF00E8BDFA5")
    public void setBitmap(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        try 
        {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
    if(fd == null)            
            {
                return;
            } 
            FileOutputStream fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            } 
            finally 
            {
    if(fos != null)                
                {
                    fos.close();
                } 
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
            
                
            
            
            
                
                
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.312 -0400", hash_original_method = "201E3B54F176FDB2F716DB9554E16862", hash_generated_method = "13F594B88117DA16486D2F6D8674571D")
    public void setStream(InputStream data) throws IOException {
        addTaint(data.getTaint());
        try 
        {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
    if(fd == null)            
            {
                return;
            } 
            FileOutputStream fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                setWallpaper(data, fos);
            } 
            finally 
            {
    if(fos != null)                
                {
                    fos.close();
                } 
            } 
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
            
                
            
            
            
                
                
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.315 -0400", hash_original_method = "4C0B3C480EF9954FF86E8D84EAD55CC1", hash_generated_method = "1CFC61DCCDA520DDD9ABBB665445DDB7")
    private void setWallpaper(InputStream data, FileOutputStream fos) throws IOException {
        addTaint(fos.getTaint());
        addTaint(data.getTaint());
        byte[] buffer = new byte[32768];
        int amt;
        while
((amt=data.read(buffer)) > 0)        
        {
            fos.write(buffer, 0, amt);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.316 -0400", hash_original_method = "D1A5F81505B1F3B03FABBA4410A80898", hash_generated_method = "0D925BC5CA11A700A91474B2EAD10D70")
    public int getDesiredMinimumWidth() {
        try 
        {
            int var5554EC7C8DA473A2EFE58312B6DE3DEB_1937590868 = (sGlobals.mService.getWidthHint());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222695432 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222695432;
        } 
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1332021905 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869307364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869307364;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.317 -0400", hash_original_method = "B18A5C89DB794D80A7E1B5CE60755D7A", hash_generated_method = "8E72FFB1FC3672569A730C5C3FB047FC")
    public int getDesiredMinimumHeight() {
        try 
        {
            int var8081CB13FA563EE91C3EEC65E27BBF83_1656153351 = (sGlobals.mService.getHeightHint());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119899921 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119899921;
        } 
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1502718564 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952508304 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952508304;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.318 -0400", hash_original_method = "24150471411E1AC7EC2E370FB5C4066A", hash_generated_method = "E59F0F9B8237A2ABEC8BD8F1B3745DAC")
    public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        addTaint(minimumHeight);
        addTaint(minimumWidth);
        try 
        {
            sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.320 -0400", hash_original_method = "50451375F0F7110E301C30296ACA8A65", hash_generated_method = "282421CD0A9A9C4EC80F958067D845E6")
    public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        addTaint(yOffset);
        addTaint(xOffset);
        addTaint(windowToken.getTaint());
        final IBinder fWindowToken = windowToken;
        final float fXOffset = xOffset;
        final float fYOffset = yOffset;
        sGlobals.getHandler().post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.320 -0400", hash_original_method = "FB60FC39BBF5735DAB5B94EDE4106EB9", hash_generated_method = "B1DBE325CF47545C6221D4AEFB96A7FD")
        public void run() {
            try 
            {
                ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
            } 
            catch (RemoteException e)
            {
            } 
            catch (IllegalArgumentException e)
            {
            } 
            
            
                    
                            
                
                
                
        }
});
        
        
        
        
        
            
                
                    
                            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.322 -0400", hash_original_method = "D2E7CBA6FEE1F1016E75D81DE5B86ECC", hash_generated_method = "EADA38664BEC7414A75FE025CEA53E62")
    public void setWallpaperOffsetSteps(float xStep, float yStep) {
        mWallpaperXStep = xStep;
        mWallpaperYStep = yStep;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.324 -0400", hash_original_method = "5FDBB12430A98A22274A04FEE86533CB", hash_generated_method = "A61F41A8E5E07209C644A1D8A4409AB7")
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
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.325 -0400", hash_original_method = "4003FD7579057D5A21D7509B89350DFE", hash_generated_method = "22EF8AE9FC1287367E46FBEEB6795999")
    public void clearWallpaperOffsets(IBinder windowToken) {
        addTaint(windowToken.getTaint());
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    windowToken, -1, -1, -1, -1);
        } 
        catch (RemoteException e)
        {
        } 
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.326 -0400", hash_original_method = "C7793256C05758E1D6CDFCE99A7FE546", hash_generated_method = "AB99E5138557A852157F08526E2516F1")
    public void clear() throws IOException {
        setResource(com.android.internal.R.drawable.default_wallpaper);
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.327 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

        private Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.327 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.327 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.327 -0400", hash_original_field = "E635C9C85981E1DCE6AEF62F70750A33", hash_generated_field = "DA577E86F21E75B26C2B7DE9380FC9DD")

        private int mDrawLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.327 -0400", hash_original_field = "F9576DC303B2C6B7B08894614FE4B0E1", hash_generated_field = "BC12CCF55C693145726833EAB6B40601")

        private int mDrawTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.327 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

        private Paint mPaint;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.336 -0400", hash_original_method = "A000E3823EF3583E37A464733E9034D5", hash_generated_method = "38655F32CD9DFD57679F12FD7FFD5218")
        private  FastBitmapDrawable(Bitmap bitmap) {
            mBitmap = bitmap;
            mWidth = bitmap.getWidth();
            mHeight = bitmap.getHeight();
            setBounds(0, 0, mWidth, mHeight);
            mPaint = new Paint();
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.342 -0400", hash_original_method = "740DEE0C93073DC91C8FEF81BF30F5D6", hash_generated_method = "4BB8A8A6BEF2A0039A5B13820C5B8692")
        @Override
        public void draw(Canvas canvas) {
            addTaint(canvas.getTaint());
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.348 -0400", hash_original_method = "20937ACEFD1116260A9689661466F3F7", hash_generated_method = "4F8B14AE94C3B06D810568C3EBF00CBB")
        @Override
        public int getOpacity() {
            int var159D51265084B78CCBC493D119AF4EAE_1448485951 = (PixelFormat.OPAQUE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822609351 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822609351;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.349 -0400", hash_original_method = "AD75C11A4E8AD86B9F9EB3DCD5857128", hash_generated_method = "DD8AC77956034A39F37DA405A27E901A")
        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            mDrawLeft = left + (right-left - mWidth) / 2;
            mDrawTop = top + (bottom-top - mHeight) / 2;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.350 -0400", hash_original_method = "51482143A770E9CBA4E27420DA4BB83A", hash_generated_method = "268C7DAC393CACCCC3A3A499A7C36527")
        @Override
        public void setAlpha(int alpha) {
            addTaint(alpha);
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_705444590 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_705444590.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_705444590;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.352 -0400", hash_original_method = "6EF98891DC00D446E5280E44B83BE80B", hash_generated_method = "A0A991DB538F8751B58F5AF54854619E")
        @Override
        public void setColorFilter(ColorFilter cf) {
            addTaint(cf.getTaint());
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_1945034712 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_1945034712.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_1945034712;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.353 -0400", hash_original_method = "BBAE54C669BC97BDF73F051E3161B7DC", hash_generated_method = "0444F6E6C01FC433A971FE741F322071")
        @Override
        public void setDither(boolean dither) {
            addTaint(dither);
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_1404873863 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_1404873863.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_1404873863;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.354 -0400", hash_original_method = "072B9683A9FDD22E6BC18017D9B8BE50", hash_generated_method = "4D4D6BA873B039689CAB3B34A96C7175")
        @Override
        public void setFilterBitmap(boolean filter) {
            addTaint(filter);
            UnsupportedOperationException var263E7B902D67C7095DD2E4F557985957_390482022 = new UnsupportedOperationException("Not supported with this drawable");
            var263E7B902D67C7095DD2E4F557985957_390482022.addTaint(taint);
            throw var263E7B902D67C7095DD2E4F557985957_390482022;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.355 -0400", hash_original_method = "7C6E7C05DAF2C7C11CBD631A19BA11F2", hash_generated_method = "859BD912F069127B4386A6F414559BFA")
        @Override
        public int getIntrinsicWidth() {
            int varA3DB1626A190732E588FD0D14FC8FB31_272140552 = (mWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756166477 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756166477;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.356 -0400", hash_original_method = "3C735D6B09C7947D1D4F4735F7E16410", hash_generated_method = "F0C3254A881E1DD5DDA26B10399B69C7")
        @Override
        public int getIntrinsicHeight() {
            int var483542B05A951AA16D89C7F809C20811_44669318 = (mHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781868437 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781868437;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.356 -0400", hash_original_method = "6C36D8FD6C4DA506CC2056E38D29BDE3", hash_generated_method = "B9FDC2303677DFE6FF9E52B39C33E744")
        @Override
        public int getMinimumWidth() {
            int varA3DB1626A190732E588FD0D14FC8FB31_1836327012 = (mWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833675413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833675413;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.357 -0400", hash_original_method = "F7F1B37FEC841079758C9B817D6DD4F6", hash_generated_method = "03029CFC55C8775BC4F3C810069E84A6")
        @Override
        public int getMinimumHeight() {
            int var483542B05A951AA16D89C7F809C20811_1651981764 = (mHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956240312 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956240312;
            
            
        }

        
    }


    
    static class Globals extends IWallpaperManagerCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.358 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5245D2ACF9BCB6EB2851F6A6EAF2BF16")

        private IWallpaperManager mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.358 -0400", hash_original_field = "58B578A12BDF7C3A2A94BAD6A36D39B5", hash_generated_field = "C4E8C03ED548D1B4E21D66638AE05698")

        private Bitmap mWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.358 -0400", hash_original_field = "38E51BE28DE288EB99141B1F4A850676", hash_generated_field = "2C326FED1949B0798BBC7F12C35F2605")

        private Bitmap mDefaultWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.358 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.360 -0400", hash_original_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C", hash_generated_method = "24331FBB1F86328A26B49ADAA8FE1633")
          Globals(Looper looper) {
            IBinder b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            mService = IWallpaperManager.Stub.asInterface(b);
            mHandler = new Handler(looper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.360 -0400", hash_original_method = "21A8DB01A9CD0DD17CF9725E26AFC9F4", hash_generated_method = "7E0C858A33640BEB5E8C376351967D9F")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
switch(msg.what){
                case MSG_CLEAR_WALLPAPER:
                synchronized
(this)                {
                    mWallpaper = null;
                    mDefaultWallpaper = null;
                } 
                break;
}
                
                
                        
                            
                                
                                
                            
                            
                    
            }
};
            
            
            
            
                
                
                    
                        
                            
                                
                                
                            
                            
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.360 -0400", hash_original_method = "F846E10F84F4E35E470DA1B587CB2864", hash_generated_method = "288447422A981A1450135744449D6BD1")
        public void onWallpaperChanged() {
            
            mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.361 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "2888D0CDB055AB93CC886D9545029A22")
        public Handler getHandler() {
Handler varF60F4C595C5EF9EE40FAD1FE8119479B_1647084 =             mHandler;
            varF60F4C595C5EF9EE40FAD1FE8119479B_1647084.addTaint(taint);
            return varF60F4C595C5EF9EE40FAD1FE8119479B_1647084;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.362 -0400", hash_original_method = "D22E4158438EA0372FD1CBCCE67470DB", hash_generated_method = "5425C877DFF6F2804CFCCED98B3E4235")
        public Bitmap peekWallpaperBitmap(Context context, boolean returnDefault) {
            addTaint(returnDefault);
            synchronized
(this)            {
    if(mWallpaper != null)                
                {
Bitmap varC038012FF42C722A2F248588A92BE2E9_678628758 =                     mWallpaper;
                    varC038012FF42C722A2F248588A92BE2E9_678628758.addTaint(taint);
                    return varC038012FF42C722A2F248588A92BE2E9_678628758;
                } 
    if(mDefaultWallpaper != null)                
                {
Bitmap var3EEC6F8E322FB1EBD331F174E194038B_346974005 =                     mDefaultWallpaper;
                    var3EEC6F8E322FB1EBD331F174E194038B_346974005.addTaint(taint);
                    return var3EEC6F8E322FB1EBD331F174E194038B_346974005;
                } 
                mWallpaper = null;
                try 
                {
                    mWallpaper = getCurrentWallpaperLocked();
                } 
                catch (OutOfMemoryError e)
                {
                } 
    if(returnDefault)                
                {
    if(mWallpaper == null)                    
                    {
                        mDefaultWallpaper = getDefaultWallpaperLocked(context);
Bitmap var3EEC6F8E322FB1EBD331F174E194038B_1779670379 =                         mDefaultWallpaper;
                        var3EEC6F8E322FB1EBD331F174E194038B_1779670379.addTaint(taint);
                        return var3EEC6F8E322FB1EBD331F174E194038B_1779670379;
                    } 
                    else
                    {
                        mDefaultWallpaper = null;
                    } 
                } 
Bitmap varC038012FF42C722A2F248588A92BE2E9_2075052419 =                 mWallpaper;
                varC038012FF42C722A2F248588A92BE2E9_2075052419.addTaint(taint);
                return varC038012FF42C722A2F248588A92BE2E9_2075052419;
            } 
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.364 -0400", hash_original_method = "0171ADD4BBF298493CC8451FAA0D3640", hash_generated_method = "D9BB3FC4AB08399BDA57536FEC203D0F")
        public void forgetLoadedWallpaper() {
            synchronized
(this)            {
                mWallpaper = null;
                mDefaultWallpaper = null;
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.365 -0400", hash_original_method = "16667119AC99E737F53C6C4F154ADE70", hash_generated_method = "308F283EA7E66EE78501F2E770175B6D")
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
Bitmap var1D039D0CCDEFFF307D958D1412EFBD6C_318376113 =                         generateBitmap(bm, width, height);
                        var1D039D0CCDEFFF307D958D1412EFBD6C_318376113.addTaint(taint);
                        return var1D039D0CCDEFFF307D958D1412EFBD6C_318376113;
                    } 
                    catch (OutOfMemoryError e)
                    {
                    } 
                    finally 
                    {
                        try 
                        {
                            fd.close();
                        } 
                        catch (IOException e)
                        {
                        } 
                    } 
                } 
            } 
            catch (RemoteException e)
            {
            } 
Bitmap var540C13E9E156B687226421B24F2DF178_1921250402 =             null;
            var540C13E9E156B687226421B24F2DF178_1921250402.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1921250402;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.367 -0400", hash_original_method = "7D56EB02955E82C8DDBD02F9FFA3CE84", hash_generated_method = "31C42666C59C1FED546A3D7B1411F8A0")
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
Bitmap var1D039D0CCDEFFF307D958D1412EFBD6C_976886073 =                         generateBitmap(bm, width, height);
                        var1D039D0CCDEFFF307D958D1412EFBD6C_976886073.addTaint(taint);
                        return var1D039D0CCDEFFF307D958D1412EFBD6C_976886073;
                    } 
                    catch (OutOfMemoryError e)
                    {
                    } 
                    finally 
                    {
                        try 
                        {
                            is.close();
                        } 
                        catch (IOException e)
                        {
                        } 
                    } 
                } 
            } 
            catch (RemoteException e)
            {
            } 
Bitmap var540C13E9E156B687226421B24F2DF178_1741994858 =             null;
            var540C13E9E156B687226421B24F2DF178_1741994858.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1741994858;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.368 -0400", hash_original_field = "F1F1BF9B224FCAF5DF81E5526C089928", hash_generated_field = "C11BAEA45DDA2586D27A4A6A9EBDE72E")

        private static final int MSG_CLEAR_WALLPAPER = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.368 -0400", hash_original_field = "5E5CA8515FB353F692CCE4E2CD540205", hash_generated_field = "48A0CC9AB0B3F0E9E45F7F457712B59F")

    private static String TAG = "WallpaperManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.369 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.369 -0400", hash_original_field = "AE1D5613EB1ED29BAF3381A28C27DFAF", hash_generated_field = "DEFFCFE16339DBDBF08B336D28EF6A17")

    public static final String ACTION_LIVE_WALLPAPER_CHOOSER
            = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.369 -0400", hash_original_field = "DE257FD4977D6A04A6C5F5061AFDD7BC", hash_generated_field = "BF5D2A76907CE9E554A3FE854675BFD7")

    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.369 -0400", hash_original_field = "B4CED6A8F9ED2A8F59AB300E0C6705D4", hash_generated_field = "F96B596B27509EEB5AD3777B9E252E5D")

    public static final String COMMAND_TAP = "android.wallpaper.tap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.369 -0400", hash_original_field = "6455ECA38E74E9465D6048417F1532EA", hash_generated_field = "818BE2DF368F81E0A32AC1FE0FD288C9")

    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.369 -0400", hash_original_field = "A7FC4256BE49D01D37FE69B85AA024B5", hash_generated_field = "70F84F0650C85E3FC996BE9B45E4D2C5")

    public static final String COMMAND_DROP = "android.home.drop";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.370 -0400", hash_original_field = "43179E88F59B44607089B9CA3FB276A3", hash_generated_field = "EECB5088E51D82E124490D50E038120E")

    private static final Object sSync = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.370 -0400", hash_original_field = "7FD9B6E291F1091AAE6622BF638EAD65", hash_generated_field = "FAC961618570B702A278896949F1B020")

    private static Globals sGlobals;
}

