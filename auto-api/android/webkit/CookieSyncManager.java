package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.Log;
import android.webkit.CookieManager.Cookie;
import java.util.ArrayList;
import java.util.Iterator;

public final class CookieSyncManager extends WebSyncManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.393 -0400", hash_original_field = "987C70772419D69E3D25E6A1F99457DA", hash_generated_field = "67C891CCE0BBDCBA776A2A7129D5A0E9")

    private long mLastUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.393 -0400", hash_original_method = "5E4F0B174A675D28BE31D2D74DFE21DE", hash_generated_method = "320941A299E83C604E95EABFA239D955")
    private  CookieSyncManager(Context context) {
        super(context, "CookieSyncManager");
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    public static synchronized CookieSyncManager getInstance() {
        checkInstanceIsCreated();
        return sRef;
    }

    
    public static synchronized CookieSyncManager createInstance(
            Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        JniUtil.setContext(context);
        Context appContext = context.getApplicationContext();
        if (sRef == null) {
            sRef = new CookieSyncManager(appContext);
        }
        return sRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.394 -0400", hash_original_method = "A7C987CCC15AF0CAF990686404E67664", hash_generated_method = "7C6454BE04E517A2147DCFCEA7DDD137")
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_2133810150 = null; //Variable for return #1
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1767909270 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2133810150 = new ArrayList<Cookie>();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1767909270 = mDataBase.getCookiesForDomain(domain);
        addTaint(domain.getTaint());
        ArrayList<Cookie> varA7E53CE21691AB073D9660D615818899_1350742201; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1350742201 = varB4EAC82CA7396A68D541C85D26508E83_2133810150;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1350742201 = varB4EAC82CA7396A68D541C85D26508E83_1767909270;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1350742201.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1350742201;
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return new ArrayList<Cookie>();
        //}
        //return mDataBase.getCookiesForDomain(domain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.394 -0400", hash_original_method = "04ED664127B5DCE8177E313009734B8D", hash_generated_method = "2843214E3A3E2EC85FFC4FCD19EE28DA")
     void clearAllCookies() {
        mDataBase.clearCookies();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.395 -0400", hash_original_method = "8FADF93798BEC10B7C24976655D3DFB0", hash_generated_method = "44058A46F6EF25088EFF637647360A41")
     boolean hasCookies() {
        boolean var07D4D8FF84F9BA965A9EB458725E1CA1_859926267 = (mDataBase.hasCookies());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522374052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_522374052;
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return false;
        //}
        //return mDataBase.hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.395 -0400", hash_original_method = "C551147CF3F803C4BE33E46DD1A6FC76", hash_generated_method = "E2B0F86A0B4DA97650D6F56B401C475F")
     void clearSessionCookies() {
        mDataBase.clearSessionCookies();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearSessionCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.395 -0400", hash_original_method = "C17F5F6F39FEAB50212EA7D808E14AB6", hash_generated_method = "96E78EA379BB1E871D458D38F722703E")
     void clearExpiredCookies(long now) {
        mDataBase.clearExpiredCookies(now);
        addTaint(now);
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearExpiredCookies(now);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.396 -0400", hash_original_method = "05B4AB2BDA2D583135C82323F50F29AB", hash_generated_method = "F728272CA22514131588A332474DEAA9")
    protected void syncFromRamToFlash() {
        CookieManager manager = CookieManager.getInstance();
        {
            boolean varC9B51255ADF56E24A3D4B4F425E75C21_1118888103 = (!manager.acceptCookie());
        } //End collapsed parenthetic
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_208046290 = (JniUtil.useChromiumHttpStack());
            {
                manager.flushCookieStore();
            } //End block
            {
                ArrayList<Cookie> cookieList = manager.getUpdatedCookiesSince(mLastUpdate);
                mLastUpdate = System.currentTimeMillis();
                syncFromRamToFlash(cookieList);
                ArrayList<Cookie> lruList = manager.deleteLRUDomain();
                syncFromRamToFlash(lruList);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DebugFlags.COOKIE_SYNC_MANAGER) {
            //Log.v(LOGTAG, "CookieSyncManager::syncFromRamToFlash STARTS");
        //}
        //CookieManager manager = CookieManager.getInstance();
        //if (!manager.acceptCookie()) {
            //return;
        //}
        //if (JniUtil.useChromiumHttpStack()) {
            //manager.flushCookieStore();
        //} else {
            //ArrayList<Cookie> cookieList = manager.getUpdatedCookiesSince(mLastUpdate);
            //mLastUpdate = System.currentTimeMillis();
            //syncFromRamToFlash(cookieList);
            //ArrayList<Cookie> lruList = manager.deleteLRUDomain();
            //syncFromRamToFlash(lruList);
        //}
        //if (DebugFlags.COOKIE_SYNC_MANAGER) {
            //Log.v(LOGTAG, "CookieSyncManager::syncFromRamToFlash DONE");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.397 -0400", hash_original_method = "CE02A4B6AAF984780597D96D08B33D6E", hash_generated_method = "560E43C38B9965FFC68A36394575434B")
    private void syncFromRamToFlash(ArrayList<Cookie> list) {
        Iterator<Cookie> iter = list.iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1728590597 = (iter.hasNext());
            {
                Cookie cookie = iter.next();
                {
                    {
                        mDataBase.deleteCookies(cookie.domain, cookie.path,
                            cookie.name);
                    } //End block
                    {
                        mDataBase.addCookie(cookie);
                        CookieManager.getInstance().syncedACookie(cookie);
                    } //End block
                    {
                        CookieManager.getInstance().deleteACookie(cookie);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(list.getTaint());
        // ---------- Original Method ----------
        //Iterator<Cookie> iter = list.iterator();
        //while (iter.hasNext()) {
            //Cookie cookie = iter.next();
            //if (cookie.mode != Cookie.MODE_NORMAL) {
                //if (cookie.mode != Cookie.MODE_NEW) {
                    //mDataBase.deleteCookies(cookie.domain, cookie.path,
                            //cookie.name);
                //}
                //if (cookie.mode != Cookie.MODE_DELETED) {
                    //mDataBase.addCookie(cookie);
                    //CookieManager.getInstance().syncedACookie(cookie);
                //} else {
                    //CookieManager.getInstance().deleteACookie(cookie);
                //}
            //}
        //}
    }

    
    private static void checkInstanceIsCreated() {
        if (sRef == null) {
            throw new IllegalStateException(
                    "CookieSyncManager::createInstance() needs to be called "
                            + "before CookieSyncManager::getInstance()");
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.397 -0400", hash_original_field = "E6BA83C33E70ACF527403866BBE81365", hash_generated_field = "73C10A9E9156F9CA0177FC69B4C20965")

    private static CookieSyncManager sRef;
}

