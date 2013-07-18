package android.webkit;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.webkit.CookieManager.Cookie;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public final class CookieSyncManager extends WebSyncManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.196 -0400", hash_original_field = "987C70772419D69E3D25E6A1F99457DA", hash_generated_field = "67C891CCE0BBDCBA776A2A7129D5A0E9")

    private long mLastUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.197 -0400", hash_original_method = "5E4F0B174A675D28BE31D2D74DFE21DE", hash_generated_method = "320941A299E83C604E95EABFA239D955")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.197 -0400", hash_original_method = "A7C987CCC15AF0CAF990686404E67664", hash_generated_method = "8E1B2D02C24D7F05BC2E4F1C859FD3B4")
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        addTaint(domain.getTaint());
        if(mDataBase == null)        
        {
ArrayList<Cookie> var3225A295C909FE34C2F651B1B1E38297_980823703 =             new ArrayList<Cookie>();
            var3225A295C909FE34C2F651B1B1E38297_980823703.addTaint(taint);
            return var3225A295C909FE34C2F651B1B1E38297_980823703;
        } //End block
ArrayList<Cookie> var632770A87E3F4018887846A1E06A14AE_1354625075 =         mDataBase.getCookiesForDomain(domain);
        var632770A87E3F4018887846A1E06A14AE_1354625075.addTaint(taint);
        return var632770A87E3F4018887846A1E06A14AE_1354625075;
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return new ArrayList<Cookie>();
        //}
        //return mDataBase.getCookiesForDomain(domain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.198 -0400", hash_original_method = "04ED664127B5DCE8177E313009734B8D", hash_generated_method = "56DF1169E1F544FCF8D9D9E2D55D0DBA")
     void clearAllCookies() {
        if(mDataBase == null)        
        {
            return;
        } //End block
        mDataBase.clearCookies();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.198 -0400", hash_original_method = "8FADF93798BEC10B7C24976655D3DFB0", hash_generated_method = "6F719A6AFE6B7079CBD43D1E701C7468")
     boolean hasCookies() {
        if(mDataBase == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1932974596 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355300709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_355300709;
        } //End block
        boolean var27C29B458C338D3EBC7707B36B390E0F_762445487 = (mDataBase.hasCookies());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110636910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_110636910;
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return false;
        //}
        //return mDataBase.hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.198 -0400", hash_original_method = "C551147CF3F803C4BE33E46DD1A6FC76", hash_generated_method = "DB5E862EAF4476CD2AAC6C135238852F")
     void clearSessionCookies() {
        if(mDataBase == null)        
        {
            return;
        } //End block
        mDataBase.clearSessionCookies();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearSessionCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.199 -0400", hash_original_method = "C17F5F6F39FEAB50212EA7D808E14AB6", hash_generated_method = "376263A331BF5A37EFC28D249C653C23")
     void clearExpiredCookies(long now) {
        addTaint(now);
        if(mDataBase == null)        
        {
            return;
        } //End block
        mDataBase.clearExpiredCookies(now);
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearExpiredCookies(now);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.199 -0400", hash_original_method = "05B4AB2BDA2D583135C82323F50F29AB", hash_generated_method = "3A63D579C07CECE2FCF5968A5562D878")
    protected void syncFromRamToFlash() {
        if(DebugFlags.COOKIE_SYNC_MANAGER)        
        {
        } //End block
        CookieManager manager = CookieManager.getInstance();
        if(!manager.acceptCookie())        
        {
            return;
        } //End block
        if(JniUtil.useChromiumHttpStack())        
        {
            manager.flushCookieStore();
        } //End block
        else
        {
            ArrayList<Cookie> cookieList = manager.getUpdatedCookiesSince(mLastUpdate);
            mLastUpdate = System.currentTimeMillis();
            syncFromRamToFlash(cookieList);
            ArrayList<Cookie> lruList = manager.deleteLRUDomain();
            syncFromRamToFlash(lruList);
        } //End block
        if(DebugFlags.COOKIE_SYNC_MANAGER)        
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.200 -0400", hash_original_method = "CE02A4B6AAF984780597D96D08B33D6E", hash_generated_method = "F3F17D28298E164139FE38FACE024DB3")
    private void syncFromRamToFlash(ArrayList<Cookie> list) {
        addTaint(list.getTaint());
        Iterator<Cookie> iter = list.iterator();
        while
(iter.hasNext())        
        {
            Cookie cookie = iter.next();
            if(cookie.mode != Cookie.MODE_NORMAL)            
            {
                if(cookie.mode != Cookie.MODE_NEW)                
                {
                    mDataBase.deleteCookies(cookie.domain, cookie.path,
                            cookie.name);
                } //End block
                if(cookie.mode != Cookie.MODE_DELETED)                
                {
                    mDataBase.addCookie(cookie);
                    CookieManager.getInstance().syncedACookie(cookie);
                } //End block
                else
                {
                    CookieManager.getInstance().deleteACookie(cookie);
                } //End block
            } //End block
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.200 -0400", hash_original_field = "E6BA83C33E70ACF527403866BBE81365", hash_generated_field = "73C10A9E9156F9CA0177FC69B4C20965")

    private static CookieSyncManager sRef;
}

