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
    private long mLastUpdate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.108 -0400", hash_original_method = "5E4F0B174A675D28BE31D2D74DFE21DE", hash_generated_method = "A248BB3A9B7303938FF6D3433BE7E163")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CookieSyncManager(Context context) {
        super(context, "CookieSyncManager");
        dsTaint.addTaint(context.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.109 -0400", hash_original_method = "A7C987CCC15AF0CAF990686404E67664", hash_generated_method = "FD0BC1C12C046AF97E99D64F76BC97A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<Cookie> getCookiesForDomain(String domain) {
        dsTaint.addTaint(domain);
        {
            ArrayList<Cookie> varCD1D4F0CCCE0B88B0FAECC50A854B647_1017542537 = (new ArrayList<Cookie>());
        } //End block
        ArrayList<Cookie> var50D8772B2CE5B2DA0171563A61D4998D_2066615772 = (mDataBase.getCookiesForDomain(domain));
        return (ArrayList<Cookie>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return new ArrayList<Cookie>();
        //}
        //return mDataBase.getCookiesForDomain(domain);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.109 -0400", hash_original_method = "04ED664127B5DCE8177E313009734B8D", hash_generated_method = "2843214E3A3E2EC85FFC4FCD19EE28DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearAllCookies() {
        mDataBase.clearCookies();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.109 -0400", hash_original_method = "8FADF93798BEC10B7C24976655D3DFB0", hash_generated_method = "658DE9011D0B6C32ED4ABEB0EA379D14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean hasCookies() {
        boolean var07D4D8FF84F9BA965A9EB458725E1CA1_2061093853 = (mDataBase.hasCookies());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return false;
        //}
        //return mDataBase.hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.109 -0400", hash_original_method = "C551147CF3F803C4BE33E46DD1A6FC76", hash_generated_method = "E2B0F86A0B4DA97650D6F56B401C475F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearSessionCookies() {
        mDataBase.clearSessionCookies();
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearSessionCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.110 -0400", hash_original_method = "C17F5F6F39FEAB50212EA7D808E14AB6", hash_generated_method = "F955DCBC6C94E0FACC67A8604C718C5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearExpiredCookies(long now) {
        dsTaint.addTaint(now);
        mDataBase.clearExpiredCookies(now);
        // ---------- Original Method ----------
        //if (mDataBase == null) {
            //return;
        //}
        //mDataBase.clearExpiredCookies(now);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.110 -0400", hash_original_method = "05B4AB2BDA2D583135C82323F50F29AB", hash_generated_method = "1792153DCA882B472A4A0E0754568D97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void syncFromRamToFlash() {
        CookieManager manager;
        manager = CookieManager.getInstance();
        {
            boolean varC9B51255ADF56E24A3D4B4F425E75C21_241672195 = (!manager.acceptCookie());
        } //End collapsed parenthetic
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_585826511 = (JniUtil.useChromiumHttpStack());
            {
                manager.flushCookieStore();
            } //End block
            {
                ArrayList<Cookie> cookieList;
                cookieList = manager.getUpdatedCookiesSince(mLastUpdate);
                mLastUpdate = System.currentTimeMillis();
                syncFromRamToFlash(cookieList);
                ArrayList<Cookie> lruList;
                lruList = manager.deleteLRUDomain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.111 -0400", hash_original_method = "CE02A4B6AAF984780597D96D08B33D6E", hash_generated_method = "52A8178E570676CCA7C1328DA65FB76B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void syncFromRamToFlash(ArrayList<Cookie> list) {
        dsTaint.addTaint(list.dsTaint);
        Iterator<Cookie> iter;
        iter = list.iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_753229758 = (iter.hasNext());
            {
                Cookie cookie;
                cookie = iter.next();
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

    
    private static CookieSyncManager sRef;
}

