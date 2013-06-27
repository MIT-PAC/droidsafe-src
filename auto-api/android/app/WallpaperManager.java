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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.788 -0400", hash_original_field = "84013B9B56B226FA2280C6FF3BE1B5D7", hash_generated_field = "79E763BC7220887CD284E78890CFBD39")

    private float mWallpaperXStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.788 -0400", hash_original_field = "D3C49CE46785D3C0A547BF9D502791F7", hash_generated_field = "4E298C71D3B5B2CA896AF40FC8DB3101")

    private float mWallpaperYStep = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.789 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.811 -0400", hash_original_method = "AA9944AB0F8A7F99E0205835B0AC132C", hash_generated_method = "A419C48CEE082980FF6F01DBE73F398D")
      WallpaperManager(Context context, Handler handler) {
        mContext = context;
        initGlobals(context.getMainLooper());
        addTaint(handler.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.829 -0400", hash_original_method = "6F9497943DE7A2ADCF716329D67D9BA7", hash_generated_method = "3F50A9ECFCD2820B8C3A41DB96F13331")
    public IWallpaperManager getIWallpaperManager() {
        IWallpaperManager varB4EAC82CA7396A68D541C85D26508E83_1845959031 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1845959031 = sGlobals.mService;
        varB4EAC82CA7396A68D541C85D26508E83_1845959031.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1845959031;
        // ---------- Original Method ----------
        //return sGlobals.mService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.857 -0400", hash_original_method = "983E953189104E5D3E1EF4C33892C5EB", hash_generated_method = "FCBEFB5A4ADA0079660FD5CA66A6E471")
    public Drawable getDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1024542111 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_62254755 = null; //Variable for return #2
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, true);
        {
            Drawable dr;
            dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
            varB4EAC82CA7396A68D541C85D26508E83_1024542111 = dr;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_62254755 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_1501453857; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1501453857 = varB4EAC82CA7396A68D541C85D26508E83_1024542111;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1501453857 = varB4EAC82CA7396A68D541C85D26508E83_62254755;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1501453857.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1501453857;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        //if (bm != null) {
            //Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            //dr.setDither(false);
            //return dr;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.875 -0400", hash_original_method = "EA4956080FAF0CF8E371329CB76D5A40", hash_generated_method = "FB4BBCB63CD57268DEAE6C8B6A274B48")
    public Drawable peekDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_615251493 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1752850899 = null; //Variable for return #2
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, false);
        {
            Drawable dr;
            dr = new BitmapDrawable(mContext.getResources(), bm);
            dr.setDither(false);
            varB4EAC82CA7396A68D541C85D26508E83_615251493 = dr;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1752850899 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_207905683; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_207905683 = varB4EAC82CA7396A68D541C85D26508E83_615251493;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_207905683 = varB4EAC82CA7396A68D541C85D26508E83_1752850899;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_207905683.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_207905683;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        //if (bm != null) {
            //Drawable dr = new BitmapDrawable(mContext.getResources(), bm);
            //dr.setDither(false);
            //return dr;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.020 -0400", hash_original_method = "8FF7C2E7F253EDCD7E0E3FAE36FB4E5D", hash_generated_method = "BF44BD38C368D9F2AAFBD8EBDFDFB062")
    public Drawable getFastDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1416246763 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_887675814 = null; //Variable for return #2
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, true);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1416246763 = new FastBitmapDrawable(bm);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_887675814 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_903139947; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_903139947 = varB4EAC82CA7396A68D541C85D26508E83_1416246763;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_903139947 = varB4EAC82CA7396A68D541C85D26508E83_887675814;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_903139947.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_903139947;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, true);
        //if (bm != null) {
            //return new FastBitmapDrawable(bm);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.035 -0400", hash_original_method = "8A28F31302CE106CFE820B9CBC0915AE", hash_generated_method = "59F16624962948AF1951E583E03FE527")
    public Drawable peekFastDrawable() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_429525381 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1922249133 = null; //Variable for return #2
        Bitmap bm;
        bm = sGlobals.peekWallpaperBitmap(mContext, false);
        {
            varB4EAC82CA7396A68D541C85D26508E83_429525381 = new FastBitmapDrawable(bm);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1922249133 = null;
        Drawable varA7E53CE21691AB073D9660D615818899_734396905; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_734396905 = varB4EAC82CA7396A68D541C85D26508E83_429525381;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_734396905 = varB4EAC82CA7396A68D541C85D26508E83_1922249133;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_734396905.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_734396905;
        // ---------- Original Method ----------
        //Bitmap bm = sGlobals.peekWallpaperBitmap(mContext, false);
        //if (bm != null) {
            //return new FastBitmapDrawable(bm);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.042 -0400", hash_original_method = "214C7E80807DBED0084465B1D80DE965", hash_generated_method = "E83D5BD20D95EF4FFBFAD0FF9876C32E")
    public Bitmap getBitmap() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_725045102 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725045102 = sGlobals.peekWallpaperBitmap(mContext, true);
        varB4EAC82CA7396A68D541C85D26508E83_725045102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725045102;
        // ---------- Original Method ----------
        //return sGlobals.peekWallpaperBitmap(mContext, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.064 -0400", hash_original_method = "9DD74CD1F13AD5E4F4CF15160B046494", hash_generated_method = "E137D675DA1C337DD2F3C32778252113")
    public void forgetLoadedWallpaper() {
        sGlobals.forgetLoadedWallpaper();
        // ---------- Original Method ----------
        //sGlobals.forgetLoadedWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.071 -0400", hash_original_method = "BFBEA651CA003E449BAD7FB6481A127E", hash_generated_method = "0748C0E78D32E96965AFF2C1F35BD240")
    public WallpaperInfo getWallpaperInfo() {
        WallpaperInfo varB4EAC82CA7396A68D541C85D26508E83_338990156 = null; //Variable for return #1
        WallpaperInfo varB4EAC82CA7396A68D541C85D26508E83_1108022262 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_338990156 = sGlobals.mService.getWallpaperInfo();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1108022262 = null;
        } //End block
        WallpaperInfo varA7E53CE21691AB073D9660D615818899_560172431; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_560172431 = varB4EAC82CA7396A68D541C85D26508E83_338990156;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_560172431 = varB4EAC82CA7396A68D541C85D26508E83_1108022262;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_560172431.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_560172431;
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getWallpaperInfo();
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.101 -0400", hash_original_method = "A9B0C110F9B2DD6C9D3DF08018F94DD2", hash_generated_method = "68F1388EE0FD5134A237B196D86F23E5")
    public void setResource(int resid) throws IOException {
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
        addTaint(resid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.108 -0400", hash_original_method = "24319E223B48D297B4260CBD63DF9776", hash_generated_method = "2F93477BD3838ACA61A3FFC42B246C10")
    public void setBitmap(Bitmap bitmap) throws IOException {
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
        addTaint(bitmap.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.131 -0400", hash_original_method = "201E3B54F176FDB2F716DB9554E16862", hash_generated_method = "C71CB75BF227E6E0926F3DD8719F88D3")
    public void setStream(InputStream data) throws IOException {
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
        addTaint(data.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.133 -0400", hash_original_method = "4C0B3C480EF9954FF86E8D84EAD55CC1", hash_generated_method = "5076A27174A19843B924CDD997842BF6")
    private void setWallpaper(InputStream data, FileOutputStream fos) throws IOException {
        byte[] buffer;
        buffer = new byte[32768];
        int amt;
        {
            boolean var2B17B59B4F2F4E2A010AD44AD7A027B9_708477199 = ((amt=data.read(buffer)) > 0);
            {
                fos.write(buffer, 0, amt);
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        addTaint(fos.getTaint());
        // ---------- Original Method ----------
        //byte[] buffer = new byte[32768];
        //int amt;
        //while ((amt=data.read(buffer)) > 0) {
            //fos.write(buffer, 0, amt);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.151 -0400", hash_original_method = "D1A5F81505B1F3B03FABBA4410A80898", hash_generated_method = "4EFF2614EF238A92E88F22E04BE85201")
    public int getDesiredMinimumWidth() {
        try 
        {
            int varF4210454002966C2A27768BDBD596292_361416955 = (sGlobals.mService.getWidthHint());
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308117511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308117511;
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getWidthHint();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.167 -0400", hash_original_method = "B18A5C89DB794D80A7E1B5CE60755D7A", hash_generated_method = "508F95040EEB30AD87A6D3494DF87154")
    public int getDesiredMinimumHeight() {
        try 
        {
            int var73CA9014DB323FE5C953F725553245A9_1962090424 = (sGlobals.mService.getHeightHint());
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683830505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683830505;
        // ---------- Original Method ----------
        //try {
            //return sGlobals.mService.getHeightHint();
        //} catch (RemoteException e) {
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.169 -0400", hash_original_method = "24150471411E1AC7EC2E370FB5C4066A", hash_generated_method = "7442132A8A7D3CCB68C1A224E0CB2303")
    public void suggestDesiredDimensions(int minimumWidth, int minimumHeight) {
        try 
        {
            sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(minimumWidth);
        addTaint(minimumHeight);
        // ---------- Original Method ----------
        //try {
            //sGlobals.mService.setDimensionHints(minimumWidth, minimumHeight);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.197 -0400", hash_original_method = "50451375F0F7110E301C30296ACA8A65", hash_generated_method = "407746CE8C25C463352F25EC550EB7B0")
    public void setWallpaperOffsets(IBinder windowToken, float xOffset, float yOffset) {
        IBinder fWindowToken;
        fWindowToken = windowToken;
        float fXOffset;
        fXOffset = xOffset;
        float fYOffset;
        fYOffset = yOffset;
        sGlobals.getHandler().post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.195 -0400", hash_original_method = "FB60FC39BBF5735DAB5B94EDE4106EB9", hash_generated_method = "87E65C58A468E8226DAED1B7F431869A")
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
        addTaint(windowToken.getTaint());
        addTaint(xOffset);
        addTaint(yOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.211 -0400", hash_original_method = "D2E7CBA6FEE1F1016E75D81DE5B86ECC", hash_generated_method = "EADA38664BEC7414A75FE025CEA53E62")
    public void setWallpaperOffsetSteps(float xStep, float yStep) {
        mWallpaperXStep = xStep;
        mWallpaperYStep = yStep;
        // ---------- Original Method ----------
        //mWallpaperXStep = xStep;
        //mWallpaperYStep = yStep;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.213 -0400", hash_original_method = "5FDBB12430A98A22274A04FEE86533CB", hash_generated_method = "74198F7DAD6A1E6DB7BE47885B3B17C2")
    public void sendWallpaperCommand(IBinder windowToken, String action,
            int x, int y, int z, Bundle extras) {
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    windowToken, action, x, y, z, extras, false);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(windowToken.getTaint());
        addTaint(action.getTaint());
        addTaint(x);
        addTaint(y);
        addTaint(z);
        addTaint(extras.getTaint());
        // ---------- Original Method ----------
        //try {
            //ViewRootImpl.getWindowSession(mContext.getMainLooper()).sendWallpaperCommand(
                    //windowToken, action, x, y, z, extras, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.233 -0400", hash_original_method = "4003FD7579057D5A21D7509B89350DFE", hash_generated_method = "D360D5ABD82CAE5BA1F439042FF6AA02")
    public void clearWallpaperOffsets(IBinder windowToken) {
        try 
        {
            ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    windowToken, -1, -1, -1, -1);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(windowToken.getTaint());
        // ---------- Original Method ----------
        //try {
            //ViewRootImpl.getWindowSession(mContext.getMainLooper()).setWallpaperPosition(
                    //windowToken, -1, -1, -1, -1);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.244 -0400", hash_original_method = "C7793256C05758E1D6CDFCE99A7FE546", hash_generated_method = "AB99E5138557A852157F08526E2516F1")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.247 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "4EFA3179E01F3A6C04DAAC2298E5BFE4")

        private Bitmap mBitmap;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.247 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "380984B6D3BA888BD05804A5D24041AE")

        private int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.247 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "9A13F430E09A05B31C551CE62B9A37C1")

        private int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.248 -0400", hash_original_field = "E635C9C85981E1DCE6AEF62F70750A33", hash_generated_field = "DA577E86F21E75B26C2B7DE9380FC9DD")

        private int mDrawLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.248 -0400", hash_original_field = "F9576DC303B2C6B7B08894614FE4B0E1", hash_generated_field = "BC12CCF55C693145726833EAB6B40601")

        private int mDrawTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.267 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

        private Paint mPaint;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.281 -0400", hash_original_method = "A000E3823EF3583E37A464733E9034D5", hash_generated_method = "38655F32CD9DFD57679F12FD7FFD5218")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.288 -0400", hash_original_method = "740DEE0C93073DC91C8FEF81BF30F5D6", hash_generated_method = "CDB3E3C8DD4FC718A8B6F97DA4AAB1F9")
        @Override
        public void draw(Canvas canvas) {
            canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
            addTaint(canvas.getTaint());
            // ---------- Original Method ----------
            //canvas.drawBitmap(mBitmap, mDrawLeft, mDrawTop, mPaint);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.290 -0400", hash_original_method = "20937ACEFD1116260A9689661466F3F7", hash_generated_method = "256CCC1336BE974835E9BF497D3B98E7")
        @Override
        public int getOpacity() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402888283 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402888283;
            // ---------- Original Method ----------
            //return PixelFormat.OPAQUE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.296 -0400", hash_original_method = "AD75C11A4E8AD86B9F9EB3DCD5857128", hash_generated_method = "DD8AC77956034A39F37DA405A27E901A")
        @Override
        public void setBounds(int left, int top, int right, int bottom) {
            mDrawLeft = left + (right-left - mWidth) / 2;
            mDrawTop = top + (bottom-top - mHeight) / 2;
            // ---------- Original Method ----------
            //mDrawLeft = left + (right-left - mWidth) / 2;
            //mDrawTop = top + (bottom-top - mHeight) / 2;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.297 -0400", hash_original_method = "51482143A770E9CBA4E27420DA4BB83A", hash_generated_method = "F1E157EB267A3FB00B5413AB828345AB")
        @Override
        public void setAlpha(int alpha) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(alpha);
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.327 -0400", hash_original_method = "6EF98891DC00D446E5280E44B83BE80B", hash_generated_method = "B9935E48B330368A7D876CC9E6CBAC47")
        @Override
        public void setColorFilter(ColorFilter cf) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(cf.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.328 -0400", hash_original_method = "BBAE54C669BC97BDF73F051E3161B7DC", hash_generated_method = "8894EC0F2ED6D14203A39CF91C6FE296")
        @Override
        public void setDither(boolean dither) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(dither);
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.341 -0400", hash_original_method = "072B9683A9FDD22E6BC18017D9B8BE50", hash_generated_method = "05E5DEE1948BF85AD3E710E8ADAB697B")
        @Override
        public void setFilterBitmap(boolean filter) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Not supported with this drawable");
            addTaint(filter);
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException("Not supported with this drawable");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.342 -0400", hash_original_method = "7C6E7C05DAF2C7C11CBD631A19BA11F2", hash_generated_method = "4AD0856BD2F27CF8841A82A300AABE5C")
        @Override
        public int getIntrinsicWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023983814 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023983814;
            // ---------- Original Method ----------
            //return mWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.363 -0400", hash_original_method = "3C735D6B09C7947D1D4F4735F7E16410", hash_generated_method = "9D9B77BF4ABD581D89A5E02EA43DB664")
        @Override
        public int getIntrinsicHeight() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759770459 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759770459;
            // ---------- Original Method ----------
            //return mHeight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.368 -0400", hash_original_method = "6C36D8FD6C4DA506CC2056E38D29BDE3", hash_generated_method = "D58DAF3CE1C52B0593E9260B1BD8DD74")
        @Override
        public int getMinimumWidth() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312354841 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312354841;
            // ---------- Original Method ----------
            //return mWidth;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.391 -0400", hash_original_method = "F7F1B37FEC841079758C9B817D6DD4F6", hash_generated_method = "2970B6A5ECB7E1BB1E1596A73682E4FC")
        @Override
        public int getMinimumHeight() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481595502 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481595502;
            // ---------- Original Method ----------
            //return mHeight;
        }

        
    }


    
    static class Globals extends IWallpaperManagerCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.391 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "5245D2ACF9BCB6EB2851F6A6EAF2BF16")

        private IWallpaperManager mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.392 -0400", hash_original_field = "58B578A12BDF7C3A2A94BAD6A36D39B5", hash_generated_field = "C4E8C03ED548D1B4E21D66638AE05698")

        private Bitmap mWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.406 -0400", hash_original_field = "38E51BE28DE288EB99141B1F4A850676", hash_generated_field = "2C326FED1949B0798BBC7F12C35F2605")

        private Bitmap mDefaultWallpaper;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.406 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.417 -0400", hash_original_method = "0C6EE30FFC6BD0B5A33D648A5B68FF7C", hash_generated_method = "402F4D1700F821D8CF1CCC4CA60BF0A6")
          Globals(Looper looper) {
            IBinder b;
            b = ServiceManager.getService(Context.WALLPAPER_SERVICE);
            mService = IWallpaperManager.Stub.asInterface(b);
            mHandler = new Handler(looper) {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.416 -0400", hash_original_method = "21A8DB01A9CD0DD17CF9725E26AFC9F4", hash_generated_method = "EC73ECE13B5E38BA6AF1AF45966D0B62")
                @Override
                public void handleMessage(Message msg) {
                    //Begin case MSG_CLEAR_WALLPAPER 
                    {
                        mWallpaper = null;
                        mDefaultWallpaper = null;
                    } //End block
                    //End case MSG_CLEAR_WALLPAPER 
                    addTaint(msg.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.442 -0400", hash_original_method = "F846E10F84F4E35E470DA1B587CB2864", hash_generated_method = "288447422A981A1450135744449D6BD1")
        public void onWallpaperChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
            // ---------- Original Method ----------
            //mHandler.sendEmptyMessage(MSG_CLEAR_WALLPAPER);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.461 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "411F21BDC3E0E466F884C21D2FD918E6")
        public Handler getHandler() {
            Handler varB4EAC82CA7396A68D541C85D26508E83_1804843539 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1804843539 = mHandler;
            varB4EAC82CA7396A68D541C85D26508E83_1804843539.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1804843539;
            // ---------- Original Method ----------
            //return mHandler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.492 -0400", hash_original_method = "D22E4158438EA0372FD1CBCCE67470DB", hash_generated_method = "A3AAE930D02948E25044278953D0FA65")
        public Bitmap peekWallpaperBitmap(Context context, boolean returnDefault) {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1204434170 = null; //Variable for return #1
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1879918960 = null; //Variable for return #2
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1676905827 = null; //Variable for return #3
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_52533388 = null; //Variable for return #4
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1204434170 = mWallpaper;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1879918960 = mDefaultWallpaper;
                } //End block
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
                        varB4EAC82CA7396A68D541C85D26508E83_1676905827 = mDefaultWallpaper;
                    } //End block
                    {
                        mDefaultWallpaper = null;
                    } //End block
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_52533388 = mWallpaper;
            } //End block
            addTaint(returnDefault);
            Bitmap varA7E53CE21691AB073D9660D615818899_772756586; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_772756586 = varB4EAC82CA7396A68D541C85D26508E83_1204434170;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_772756586 = varB4EAC82CA7396A68D541C85D26508E83_1879918960;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_772756586 = varB4EAC82CA7396A68D541C85D26508E83_1676905827;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_772756586 = varB4EAC82CA7396A68D541C85D26508E83_52533388;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_772756586.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_772756586;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.494 -0400", hash_original_method = "0171ADD4BBF298493CC8451FAA0D3640", hash_generated_method = "3151A98DD7FE11BDFB8D5F0E76230461")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.522 -0400", hash_original_method = "16667119AC99E737F53C6C4F154ADE70", hash_generated_method = "6AF16C83F3B71979D513AB3A06D9B7E5")
        private Bitmap getCurrentWallpaperLocked() {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_2048666049 = null; //Variable for return #1
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_2041455907 = null; //Variable for return #2
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
                        varB4EAC82CA7396A68D541C85D26508E83_2048666049 = generateBitmap(bm, width, height);
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
            varB4EAC82CA7396A68D541C85D26508E83_2041455907 = null;
            Bitmap varA7E53CE21691AB073D9660D615818899_677970098; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_677970098 = varB4EAC82CA7396A68D541C85D26508E83_2048666049;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_677970098 = varB4EAC82CA7396A68D541C85D26508E83_2041455907;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_677970098.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_677970098;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.543 -0400", hash_original_method = "7D56EB02955E82C8DDBD02F9FFA3CE84", hash_generated_method = "F2200250EC093B75D43594F156D14BA4")
        private Bitmap getDefaultWallpaperLocked(Context context) {
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_1722499540 = null; //Variable for return #1
            Bitmap varB4EAC82CA7396A68D541C85D26508E83_761844700 = null; //Variable for return #2
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
                        varB4EAC82CA7396A68D541C85D26508E83_1722499540 = generateBitmap(bm, width, height);
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
            varB4EAC82CA7396A68D541C85D26508E83_761844700 = null;
            addTaint(context.getTaint());
            Bitmap varA7E53CE21691AB073D9660D615818899_80317912; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_80317912 = varB4EAC82CA7396A68D541C85D26508E83_1722499540;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_80317912 = varB4EAC82CA7396A68D541C85D26508E83_761844700;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_80317912.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_80317912;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.544 -0400", hash_original_field = "F1F1BF9B224FCAF5DF81E5526C089928", hash_generated_field = "CDA052AD3D01AEB981F8DA96F863DC71")

        private static int MSG_CLEAR_WALLPAPER = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.544 -0400", hash_original_field = "5E5CA8515FB353F692CCE4E2CD540205", hash_generated_field = "48A0CC9AB0B3F0E9E45F7F457712B59F")

    private static String TAG = "WallpaperManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.544 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.545 -0400", hash_original_field = "AE1D5613EB1ED29BAF3381A28C27DFAF", hash_generated_field = "DEFFCFE16339DBDBF08B336D28EF6A17")

    public static final String ACTION_LIVE_WALLPAPER_CHOOSER
            = "android.service.wallpaper.LIVE_WALLPAPER_CHOOSER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.545 -0400", hash_original_field = "DE257FD4977D6A04A6C5F5061AFDD7BC", hash_generated_field = "BF5D2A76907CE9E554A3FE854675BFD7")

    public static final String WALLPAPER_PREVIEW_META_DATA = "android.wallpaper.preview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.569 -0400", hash_original_field = "B4CED6A8F9ED2A8F59AB300E0C6705D4", hash_generated_field = "F96B596B27509EEB5AD3777B9E252E5D")

    public static final String COMMAND_TAP = "android.wallpaper.tap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.569 -0400", hash_original_field = "6455ECA38E74E9465D6048417F1532EA", hash_generated_field = "818BE2DF368F81E0A32AC1FE0FD288C9")

    public static final String COMMAND_SECONDARY_TAP = "android.wallpaper.secondaryTap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.569 -0400", hash_original_field = "A7FC4256BE49D01D37FE69B85AA024B5", hash_generated_field = "70F84F0650C85E3FC996BE9B45E4D2C5")

    public static final String COMMAND_DROP = "android.home.drop";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.570 -0400", hash_original_field = "43179E88F59B44607089B9CA3FB276A3", hash_generated_field = "8ADC9D5409EF08C11599C5B6EABC3165")

    private static Object sSync = new Object[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.576 -0400", hash_original_field = "7FD9B6E291F1091AAE6622BF638EAD65", hash_generated_field = "FAC961618570B702A278896949F1B020")

    private static Globals sGlobals;
}

