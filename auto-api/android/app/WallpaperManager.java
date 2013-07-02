package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.722 -0400", hash_original_field = "84013B9B56B226FA2280C6FF3BE1B5D7", hash_generated_field = "79E763BC7220887CD284E78890CFBD39")

    private float mWallpaperXStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.722 -0400", hash_original_field = "D3C49CE46785D3C0A547BF9D502791F7", hash_generated_field = "4E298C71D3B5B2CA896AF40FC8DB3101")

    private float mWallpaperYStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.722 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.723 -0400", hash_original_method = "AA9944AB0F8A7F99E0205835B0AC132C", hash_generated_method = "A419C48CEE082980FF6F01DBE73F398D")
      WallpaperManager(Context context, Handler handler) {
        mContext = context;
        initGlobals(context.getMainLooper());
        addTaint(handler.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.724 -0400", hash_original_method = "6F9497943DE7A2ADCF716329D67D9BA7", hash_generated_method = "15B4D554F468A923C55105A3497A4407")
    public IWallpaperManager getIWallpaperManager() {
        IWallpaperManager varB4EAC82CA7396A68D541C85D26508E83_725348181 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_725348181 = sGlobals.mService;
        varB4EAC82CA7396A68D541C85D26508E83_725348181.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_725348181;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.725 -0400", hash_original_method = "983E953189104E5D3E1EF4C33892C5EB", hash_generated_method = "A25E9EAA6F1E1ACF5B02359414737FFB")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1822099554 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1336439170 = null; 
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
            varB4EAC82CA7396A68D541C85D26508E83_1822099554 = dr;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1336439170 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1264530256; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1264530256 = varB4EAC82CA7396A68D541C85D26508E83_1822099554;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1264530256 = varB4EAC82CA7396A68D541C85D26508E83_1336439170;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1264530256.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1264530256;
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.727 -0400", hash_original_method = "EA4956080FAF0CF8E371329CB76D5A40", hash_generated_method = "03CDA64B9D325B188B49B6E935A48207")
    public Drawable peekDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1653416728 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_146171437 = null; 
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        {
            Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
            varB4EAC82CA7396A68D541C85D26508E83_1653416728 = dr;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_146171437 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1908524621; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1908524621 = varB4EAC82CA7396A68D541C85D26508E83_1653416728;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1908524621 = varB4EAC82CA7396A68D541C85D26508E83_146171437;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1908524621.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1908524621;
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.728 -0400", hash_original_method = "8FF7C2E7F253EDCD7E0E3FAE36FB4E5D", hash_generated_method = "38E9B1E293A23DF8AE816B0835478ED2")
    public Drawable getFastDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1561150603 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_441790300 = null; 
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1561150603 = new FastBitmapDrawable(bm);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_441790300 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1549819080; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1549819080 = varB4EAC82CA7396A68D541C85D26508E83_1561150603;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1549819080 = varB4EAC82CA7396A68D541C85D26508E83_441790300;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1549819080.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1549819080;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.729 -0400", hash_original_method = "8A28F31302CE106CFE820B9CBC0915AE", hash_generated_method = "38F98277F217B5E025DE295C0AAEAF42")
    public Drawable peekFastDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_822243881 = null; 
        Drawable varB4EAC82CA7396A68D541C85D26508E83_959847627 = null; 
        Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        {
            varB4EAC82CA7396A68D541C85D26508E83_822243881 = new FastBitmapDrawable(bm);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_959847627 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1504892145; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1504892145 = varB4EAC82CA7396A68D541C85D26508E83_822243881;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1504892145 = varB4EAC82CA7396A68D541C85D26508E83_959847627;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1504892145.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1504892145;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.730 -0400", hash_original_method = "214C7E80807DBED0084465B1D80DE965", hash_generated_method = "B448AF4987EA1D157EA42E08948ABE0E")
    public Bitmap getBitmap() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_428903002 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_428903002 = sGlobals.peekWallpaperBitmap(mContext, true);
        varB4EAC82CA7396A68D541C85D26508E83_428903002.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_428903002;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.730 -0400", hash_original_method = "9DD74CD1F13AD5E4F4CF15160B046494", hash_generated_method = "E137D675DA1C337DD2F3C32778252113")
    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.731 -0400", hash_original_method = "BFBEA651CA003E449BAD7FB6481A127E", hash_generated_method = "9B2706361D6A4B18E01CA671A5C5372C")
    public WallpaperInfo getWallpaperInfo() {
        WallpaperInfo varB4EAC82CA7396A68D541C85D26508E83_1068012133 = null; 
        WallpaperInfo varB4EAC82CA7396A68D541C85D26508E83_768019541 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1068012133 = sGlobals.mService.getWallpaperInfo();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_768019541 = null;
        } 
        WallpaperInfo varA7E53CE21691AB073D9660D615818899_1403063986; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1403063986 = varB4EAC82CA7396A68D541C85D26508E83_1068012133;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1403063986 = varB4EAC82CA7396A68D541C85D26508E83_768019541;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1403063986.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1403063986;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.731 -0400", hash_original_method = "A9B0C110F9B2DD6C9D3DF08018F94DD2", hash_generated_method = "C234A603BF20175EC51434C755369AD9")
    public void setResource(int resid) throws IOException {
        try 
        {
            Resources resources = mContext.getResources();
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(
                    "res:" + resources.getResourceName(resid));
            {
                FileOutputStream fos = null;
                try 
                {
                    fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                    setWallpaper(resources.openRawResource(resid), fos);
                } 
                finally 
                {
                    {
                        fos.close();
                    } 
                } 
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(resid);
        
        
            
            
                    
            
                
                
                    
                    
                
                    
                        
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.732 -0400", hash_original_method = "24319E223B48D297B4260CBD63DF9776", hash_generated_method = "DC230E2D72F00D79155C52E23EE02C34")
    public void setBitmap(Bitmap bitmap) throws IOException {
        try 
        {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            FileOutputStream fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            } 
            finally 
            {
                {
                    fos.close();
                } 
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(bitmap.getTaint());
        
        
            
            
                
            
            
            
                
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.733 -0400", hash_original_method = "201E3B54F176FDB2F716DB9554E16862", hash_generated_method = "81A1E44241EC2549F55205E3982AF6AC")
    public void setStream(InputStream data) throws IOException {
        try 
        {
            ParcelFileDescriptor fd = sGlobals.mService.setWallpaper(null);
            FileOutputStream fos = null;
            try 
            {
                fos = new ParcelFileDescriptor.AutoCloseOutputStream(fd);
                setWallpaper(data, fos);
            } 
            finally 
            {
                {
                    fos.close();
                } 
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(data.getTaint());
        
        
            
            
                
            
            
            
                
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.733 -0400", hash_original_method = "4C0B3C480EF9954FF86E8D84EAD55CC1", hash_generated_method = "E7731F96D6818E0FFF78E25F732CA259")
    private void setWallpaper(InputStream data, FileOutputStream fos) throws IOException {
        byte[] buffer = new byte[32768];
        int amt;
        {
            boolean var2B17B59B4F2F4E2A010AD44AD7A027B9_1582534457 = ((amt=data.read(buffer)) > 0);
            {
                fos.write(buffer, 0, amt);
            } 
        } 
        addTaint(data.getTaint());
        addTaint(fos.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.734 -0400", hash_original_method = "D1A5F81505B1F3B03FABBA4410A80898", hash_generated_method = "B9A704B3F0EFC62E32C05BBA53D13FF9")
    public int getDesiredMinimumWidth() {
        try 
        {
            int varF4210454002966C2A27768BDBD596292_866995802 = (sGlobals.mService.getWidthHint());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342518835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342518835;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.735 -0400", hash_original_method = "B18A5C89DB794D80A7E1B5CE60755D7A", hash_generated_method = "AC162357CC03FDE8A6230C8658AE3B45")
    public int getDesiredMinimumHeight() {
        try 
        {
            int var73CA9014DB323FE5C953F725553245A9_815928037 = (sGlobals.mService.getHeightHint());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372314359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372314359;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.736 -0400", hash_original_method = "24150471411E1AC7EC2E370FB5C4066A", hash_generated_method = "7442132A8A7D3CCB68C1A224E0CB2303")
    public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        try 
        {
            sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        } 
        catch (RemoteException e)
        { }
        addTaint(minimumWidth);
        addTaint(minimumHeight);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.992 -0400", hash_original_method = "50451375F0F7110E301C30296ACA8A65", hash_generated_method = "8325861BE77889B2D2FDB2E3063A49D8")
    public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        final IBinder fWindowToken;
        fWindowToken = windowToken;
        final float fXOffset;
        fXOffset = xOffset;
        final float fYOffset;
        fYOffset = yOffset;
        sGlobals.getHandler().post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.991 -0400", hash_original_method = "FB60FC39BBF5735DAB5B94EDE4106EB9", hash_generated_method = "87E65C58A468E8226DAED1B7F431869A")
            public void run() {
                try 
                {
                    ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                            fWindowToken, fXOffset, fYOffset, mWallpaperXStep, mWallpaperYStep);
                } 
                catch (RemoteException e)
                { }
                catch (IllegalArgumentException e)
                { }
                
                
                    
                            
                
                
                
            }
});
        addTaint(windowToken.getTaint());
        addTaint(xOffset);
        addTaint(yOffset);
        
        
        
        
        
            
                
                    
                            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.739 -0400", hash_original_method = "D2E7CBA6FEE1F1016E75D81DE5B86ECC", hash_generated_method = "EADA38664BEC7414A75FE025CEA53E62")
    public void setWallpaperOffsetSteps(float xStep, float yStep) {
        mWallpaperXStep = xStep;
        mWallpaperYStep = yStep;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.740 -0400", hash_original_method = "5FDBB12430A98A22274A04FEE86533CB", hash_generated_method = "74198F7DAD6A1E6DB7BE47885B3B17C2")
    public void sendWallpaperCommand(IBinder windowToken, String action,
            int x, int y, int z, Bundle extras) {
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    windowToken, action, x, y, z, extras, false);
        } 
        catch (RemoteException e)
        { }
        addTaint(windowToken.getTaint());
        addTaint(action.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(z);
        addTaint(extras.getTaint());
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.741 -0400", hash_original_method = "4003FD7579057D5A21D7509B89350DFE", hash_generated_method = "D360D5ABD82CAE5BA1F439042FF6AA02")
    public void clearWallpaperOffsets(IBinder windowToken) {
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    windowToken, -1, -1, -1, -1);
        } 
        catch (RemoteException e)
        { }
        addTaint(windowToken.getTaint());
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.741 -0400", hash_original_method = "C7793256C05758E1D6CDFCE99A7FE546", hash_generated_method = "AB99E5138557A852157F08526E2516F1")
    public void clear() throws IOException {
        setResource(com.android.internal.R.drawable.default_wallpaper);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.742 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

        private Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.742 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.742 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.742 -0400", hash_original_field = "E635C9C85981E1DCE6AEF62F70750A33", hash_generated_field = "DA577E86F21E75B26C2B7DE9380FC9DD")

        private int mDrawLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.743 -0400", hash_original_field = "F9576DC303B2C6B7B08894614FE4B0E1", hash_generated_field = "BC12CCF55C693145726833EAB6B40601")

        private int mDrawTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.743 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

        private Paint mPaint;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.743 -0400", hash_original_method = "A000E3823EF3583E37A464733E9034D5", hash_generated_method = "38655F32CD9DFD57679F12FD7FFD5218")
        private  FastBitmapDrawable(Bitmap bitmap) {
            mBitmap = bitmap;
            mWidth = bitmap.getWidth();
            mHeight = bitmap.getHeight();
            setBounds(0, 0, mWidth, mHeight);
            mPaint = new Paint();
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.744 -0400", hash_original_method = "740DEE0C93073DC91C8FEF81BF30F5D6", hash_generated_method = "CDB3E3C8DD4FC718A8B6F97DA4AAB1F9")
        @Override
        public void draw(Canvas canvas) {
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
            addTaint(canvas.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.745 -0400", hash_original_method = "20937ACEFD1116260A9689661466F3F7", hash_generated_method = "80D512788A067001B9F953B14B19E30C")
        @Override
        public int getOpacity() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125244571 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125244571;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.747 -0400", hash_original_method = "AD75C11A4E8AD86B9F9EB3DCD5857128", hash_generated_method = "DD8AC77956034A39F37DA405A27E901A")
        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            mDrawLeft = left + (right-left - mWidth) / 2;
            mDrawTop = top + (bottom-top - mHeight) / 2;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.749 -0400", hash_original_method = "51482143A770E9CBA4E27420DA4BB83A", hash_generated_method = "F1E157EB267A3FB00B5413AB828345AB")
        @Override
        public void setAlpha(int alpha) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(alpha);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.749 -0400", hash_original_method = "6EF98891DC00D446E5280E44B83BE80B", hash_generated_method = "B9935E48B330368A7D876CC9E6CBAC47")
        @Override
        public void setColorFilter(ColorFilter cf) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(cf.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.750 -0400", hash_original_method = "BBAE54C669BC97BDF73F051E3161B7DC", hash_generated_method = "8894EC0F2ED6D14203A39CF91C6FE296")
        @Override
        public void setDither(boolean dither) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(dither);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.751 -0400", hash_original_method = "072B9683A9FDD22E6BC18017D9B8BE50", hash_generated_method = "05E5DEE1948BF85AD3E710E8ADAB697B")
        @Override
        public void setFilterBitmap(boolean filter) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(filter);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.751 -0400", hash_original_method = "7C6E7C05DAF2C7C11CBD631A19BA11F2", hash_generated_method = "62290B4EA1B152EF5FD12F60220734D7")
        @Override
        public int getIntrinsicWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657657475 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657657475;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.752 -0400", hash_original_method = "3C735D6B09C7947D1D4F4735F7E16410", hash_generated_method = "66A16CF00E8337AB83190ABCEFA1DFDB")
        @Override
        public int getIntrinsicHeight() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205103692 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205103692;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.753 -0400", hash_original_method = "6C36D8FD6C4DA506CC2056E38D29BDE3", hash_generated_method = "2FAF6BD5FE0A024B82BCF2ED39A9A8DC")
        @Override
        public int getMinimumWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797447434 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797447434;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.753 -0400", hash_original_method = "F7F1B37FEC841079758C9B817D6DD4F6", hash_generated_method = "EC10ED73575C48C2B433A889D63796F4")
        @Override
        public int getMinimumHeight() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139120746 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139120746;
            
            
        }

        
    }


    
    static class Globals extends IWallpaperManagerCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.753 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5245D2ACF9BCB6EB2851F6A6EAF2BF16")

        private IWallpaperManager mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.753 -0400", hash_original_field = "58B578A12BDF7C3A2A94BAD6A36D39B5", hash_generated_field = "C4E8C03ED548D1B4E21D66638AE05698")

        private Bitmap mWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.754 -0400", hash_original_field = "38E51BE28DE288EB99141B1F4A850676", hash_generated_field = "2C326FED1949B0798BBC7F12C35F2605")

        private Bitmap mDefaultWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.754 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.756 -0400", hash_original_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C", hash_generated_method = "05EB24021C498C3E5FE551FB8625E129")
          Globals(Looper looper) {
            IBinder b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            mService = IWallpaperManager.Stub.asInterface(b);
            mHandler = new Handler(looper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.755 -0400", hash_original_method = "21A8DB01A9CD0DD17CF9725E26AFC9F4", hash_generated_method = "EC73ECE13B5E38BA6AF1AF45966D0B62")
                @Override
                public void handleMessage(Message msg) {
                    
                    {
                        mWallpaper = null;
                        mDefaultWallpaper = null;
                    } 
                    
                    addTaint(msg.getTaint());
                    
                    
                        
                            
                                
                                
                            
                            
                    
                }
};
            
            
            
            
                
                
                    
                        
                            
                                
                                
                            
                            
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.757 -0400", hash_original_method = "F846E10F84F4E35E470DA1B587CB2864", hash_generated_method = "288447422A981A1450135744449D6BD1")
        public void onWallpaperChanged() {
            
            mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.759 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "14ED117A6115E7666262A8966D0A4332")
        public Handler getHandler() {
            Handler varB4EAC82CA7396A68D541C85D26508E83_564660297 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_564660297 = mHandler;
            varB4EAC82CA7396A68D541C85D26508E83_564660297.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_564660297;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.761 -0400", hash_original_method = "D22E4158438EA0372FD1CBCCE67470DB", hash_generated_method = "123A56891FFD7B8B60D623E71D268614")
        public Bitmap peekWallpaperBitmap(Context context, boolean returnDefault) {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_379671098 = null; 
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_686519015 = null; 
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_222662193 = null; 
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1013697430 = null; 
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_379671098 = mWallpaper;
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_686519015 = mDefaultWallpaper;
                } 
                mWallpaper = null;
                try 
                {
                    mWallpaper = getCurrentWallpaperLocked();
                } 
                catch (OutOfMemoryError e)
                { }
                {
                    {
                        mDefaultWallpaper = getDefaultWallpaperLocked(context);
                        varB4EAC82CA7396A68D541C85D26508E83_222662193 = mDefaultWallpaper;
                    } 
                    {
                        mDefaultWallpaper = null;
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1013697430 = mWallpaper;
            } 
            addTaint(returnDefault);
            Bitmap varA7E53CE21691AB073D9660D615818899_454287637; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_454287637 = varB4EAC82CA7396A68D541C85D26508E83_379671098;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_454287637 = varB4EAC82CA7396A68D541C85D26508E83_686519015;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_454287637 = varB4EAC82CA7396A68D541C85D26508E83_222662193;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_454287637 = varB4EAC82CA7396A68D541C85D26508E83_1013697430;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_454287637.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_454287637;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.762 -0400", hash_original_method = "0171ADD4BBF298493CC8451FAA0D3640", hash_generated_method = "3151A98DD7FE11BDFB8D5F0E76230461")
        public void forgetLoadedWallpaper() {
            {
                mWallpaper = null;
                mDefaultWallpaper = null;
            } 
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.764 -0400", hash_original_method = "16667119AC99E737F53C6C4F154ADE70", hash_generated_method = "4B88BA412A158490DC9039EA3DFE7D35")
        private Bitmap getCurrentWallpaperLocked() {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1877877170 = null; 
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1699633873 = null; 
            try 
            {
                Bundle params = new Bundle();
                ParcelFileDescriptor fd = mService.getWallpaper(this, params);
                {
                    int width = params.getInt("width", 0);
                    int height = params.getInt("height", 0);
                    try 
                    {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        Bitmap bm = BitmapFactory.decodeFileDescriptor(
                                fd.getFileDescriptor(), null, options);
                        varB4EAC82CA7396A68D541C85D26508E83_1877877170 = generateBitmap(bm, width, height);
                    } 
                    catch (OutOfMemoryError e)
                    { }
                    finally 
                    {
                        try 
                        {
                            fd.close();
                        } 
                        catch (IOException e)
                        { }
                    } 
                } 
            } 
            catch (RemoteException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1699633873 = null;
            Bitmap varA7E53CE21691AB073D9660D615818899_1906139603; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1906139603 = varB4EAC82CA7396A68D541C85D26508E83_1877877170;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1906139603 = varB4EAC82CA7396A68D541C85D26508E83_1699633873;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1906139603.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1906139603;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.766 -0400", hash_original_method = "7D56EB02955E82C8DDBD02F9FFA3CE84", hash_generated_method = "7E0F4E407B3B3EB3FCC73BCD4B34FD39")
        private Bitmap getDefaultWallpaperLocked(Context context) {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1624407120 = null; 
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1902519071 = null; 
            try 
            {
                InputStream is = context.getResources().openRawResource(
                        com.android.internal.R.drawable.default_wallpaper);
                {
                    int width = mService.getWidthHint();
                    int height = mService.getHeightHint();
                    try 
                    {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        Bitmap bm = BitmapFactory.decodeStream(is, null, options);
                        varB4EAC82CA7396A68D541C85D26508E83_1624407120 = generateBitmap(bm, width, height);
                    } 
                    catch (OutOfMemoryError e)
                    { }
                    finally 
                    {
                        try 
                        {
                            is.close();
                        } 
                        catch (IOException e)
                        { }
                    } 
                } 
            } 
            catch (RemoteException e)
            { }
            varB4EAC82CA7396A68D541C85D26508E83_1902519071 = null;
            addTaint(context.getTaint());
            Bitmap varA7E53CE21691AB073D9660D615818899_2094431270; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_2094431270 = varB4EAC82CA7396A68D541C85D26508E83_1624407120;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2094431270 = varB4EAC82CA7396A68D541C85D26508E83_1902519071;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2094431270.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_2094431270;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "F1F1BF9B224FCAF5DF81E5526C089928", hash_generated_field = "C11BAEA45DDA2586D27A4A6A9EBDE72E")

        private static final int MSG_CLEAR_WALLPAPER = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "5E5CA8515FB353F692CCE4E2CD540205", hash_generated_field = "48A0CC9AB0B3F0E9E45F7F457712B59F")

    private static String TAG = "WallpaperManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "AE1D5613EB1ED29BAF3381A28C27DFAF", hash_generated_field = "DEFFCFE16339DBDBF08B336D28EF6A17")

    public static final String ACTION_LIVE_WALLPAPER_CHOOSER
            = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "DE257FD4977D6A04A6C5F5061AFDD7BC", hash_generated_field = "BF5D2A76907CE9E554A3FE854675BFD7")

    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "B4CED6A8F9ED2A8F59AB300E0C6705D4", hash_generated_field = "F96B596B27509EEB5AD3777B9E252E5D")

    public static final String COMMAND_TAP = "android.wallpaper.tap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.767 -0400", hash_original_field = "6455ECA38E74E9465D6048417F1532EA", hash_generated_field = "818BE2DF368F81E0A32AC1FE0FD288C9")

    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.768 -0400", hash_original_field = "A7FC4256BE49D01D37FE69B85AA024B5", hash_generated_field = "70F84F0650C85E3FC996BE9B45E4D2C5")

    public static final String COMMAND_DROP = "android.home.drop";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.768 -0400", hash_original_field = "43179E88F59B44607089B9CA3FB276A3", hash_generated_field = "EECB5088E51D82E124490D50E038120E")

    private static final Object sSync = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.768 -0400", hash_original_field = "7FD9B6E291F1091AAE6622BF638EAD65", hash_generated_field = "FAC961618570B702A278896949F1B020")

    private static Globals sGlobals;
}

