/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.webkit.CookieManager.Cookie;

public final class CookieSyncManager extends WebSyncManager {

    /**
     * Singleton access to a {@link CookieSyncManager}. An
     * IllegalStateException will be thrown if
     * {@link CookieSyncManager#createInstance(Context)} is not called before.
     * 
     * @return CookieSyncManager
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.503 -0500", hash_original_method = "83EC64FDE4CD3EC572033742220CA586", hash_generated_method = "C0B59F4B2889699A3BE2CD28FC0B4CA9")
    
public static synchronized CookieSyncManager getInstance() {
        checkInstanceIsCreated();
        return sRef;
    }

    /**
     * Create a singleton CookieSyncManager within a context
     * @param context
     * @return CookieSyncManager
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.505 -0500", hash_original_method = "FECD0925F77067421139B3F6378E5A1A", hash_generated_method = "D91D0794826C7B69CEA64EF6210C0BA0")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.523 -0500", hash_original_method = "19427D791526EDA33E0F88047E0F811C", hash_generated_method = "44A56C2C146D3BE33671B1B125BE25DC")
    
private static void checkInstanceIsCreated() {
        if (sRef == null) {
            throw new IllegalStateException(
                    "CookieSyncManager::createInstance() needs to be called "
                            + "before CookieSyncManager::getInstance()");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.495 -0500", hash_original_field = "EEB1F1468D42B181F568B7BDEF16A397", hash_generated_field = "73C10A9E9156F9CA0177FC69B4C20965")

    private static CookieSyncManager sRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.497 -0500", hash_original_field = "932778EB5A230AC63F2530AFAA9ECF3D", hash_generated_field = "67C891CCE0BBDCBA776A2A7129D5A0E9")

    private long mLastUpdate;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.500 -0500", hash_original_method = "5E4F0B174A675D28BE31D2D74DFE21DE", hash_generated_method = "8F21A0EF040A408BAEFF22186E770579")
    
private CookieSyncManager(Context context) {
        super(context, "CookieSyncManager");
    }

    /**
     * Package level api, called from CookieManager. Get all the cookies which
     * matches a given base domain.
     * @param domain
     * @return A list of Cookie
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.507 -0500", hash_original_method = "A7C987CCC15AF0CAF990686404E67664", hash_generated_method = "D7930072548DF6657AB45C5EAC426887")
    
ArrayList<Cookie> getCookiesForDomain(String domain) {
        // null mDataBase implies that the host application doesn't support
        // persistent cookie. No sync needed.
        if (mDataBase == null) {
            return new ArrayList<Cookie>();
        }

        return mDataBase.getCookiesForDomain(domain);
    }

    /**
     * Package level api, called from CookieManager Clear all cookies in the
     * database
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.509 -0500", hash_original_method = "04ED664127B5DCE8177E313009734B8D", hash_generated_method = "99F8393036AA0731DEF10D2000CDEAD2")
    
void clearAllCookies() {
        // null mDataBase implies that the host application doesn't support
        // persistent cookie.
        if (mDataBase == null) {
            return;
        }

        mDataBase.clearCookies();
    }

    /**
     * Returns true if there are any saved cookies.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.511 -0500", hash_original_method = "8FADF93798BEC10B7C24976655D3DFB0", hash_generated_method = "4501EF37F3AFF95A4F9D02168B7BE25C")
    
boolean hasCookies() {
        // null mDataBase implies that the host application doesn't support
        // persistent cookie.
        if (mDataBase == null) {
            return false;
        }

        return mDataBase.hasCookies();
    }

    /**
     * Package level api, called from CookieManager Clear all session cookies in
     * the database
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.513 -0500", hash_original_method = "C551147CF3F803C4BE33E46DD1A6FC76", hash_generated_method = "90A59F4AAB447180ED46FB5FC398298B")
    
void clearSessionCookies() {
        // null mDataBase implies that the host application doesn't support
        // persistent cookie.
        if (mDataBase == null) {
            return;
        }

        mDataBase.clearSessionCookies();
    }

    /**
     * Package level api, called from CookieManager Clear all expired cookies in
     * the database
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.516 -0500", hash_original_method = "C17F5F6F39FEAB50212EA7D808E14AB6", hash_generated_method = "14895F7A4DF93FE4018C5567C0185149")
    
void clearExpiredCookies(long now) {
        // null mDataBase implies that the host application doesn't support
        // persistent cookie.
        if (mDataBase == null) {
            return;
        }

        mDataBase.clearExpiredCookies(now);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.518 -0500", hash_original_method = "05B4AB2BDA2D583135C82323F50F29AB", hash_generated_method = "2949922225E553A4CC72393AD7C680E5")
    
protected void syncFromRamToFlash() {
        if (DebugFlags.COOKIE_SYNC_MANAGER) {
            Log.v(LOGTAG, "CookieSyncManager::syncFromRamToFlash STARTS");
        }

        CookieManager manager = CookieManager.getInstance();

        if (!manager.acceptCookie()) {
            return;
        }

        if (JniUtil.useChromiumHttpStack()) {
            manager.flushCookieStore();
        } else {
            ArrayList<Cookie> cookieList = manager.getUpdatedCookiesSince(mLastUpdate);
            mLastUpdate = System.currentTimeMillis();
            syncFromRamToFlash(cookieList);

            ArrayList<Cookie> lruList = manager.deleteLRUDomain();
            syncFromRamToFlash(lruList);
        }

        if (DebugFlags.COOKIE_SYNC_MANAGER) {
            Log.v(LOGTAG, "CookieSyncManager::syncFromRamToFlash DONE");
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:03.521 -0500", hash_original_method = "CE02A4B6AAF984780597D96D08B33D6E", hash_generated_method = "EF405A617A398059AF6BF8DD1DC573CE")
    
private void syncFromRamToFlash(ArrayList<Cookie> list) {
        Iterator<Cookie> iter = list.iterator();
        while (iter.hasNext()) {
            Cookie cookie = iter.next();
            if (cookie.mode != Cookie.MODE_NORMAL) {
                if (cookie.mode != Cookie.MODE_NEW) {
                    mDataBase.deleteCookies(cookie.domain, cookie.path,
                            cookie.name);
                }
                if (cookie.mode != Cookie.MODE_DELETED) {
                    mDataBase.addCookie(cookie);
                    CookieManager.getInstance().syncedACookie(cookie);
                } else {
                    CookieManager.getInstance().deleteACookie(cookie);
                }
            }
        }
    }
}

