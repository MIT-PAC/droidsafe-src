package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.ParseException;
import android.net.WebAddress;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public final class CookieManager {
    private Map<String, ArrayList<Cookie>> mCookieMap = new LinkedHashMap
            <String, ArrayList<Cookie>>(MAX_DOMAIN_COUNT, 0.75f, true);
    private boolean mAcceptCookie = true;
    private int pendingCookieOperations = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.075 -0400", hash_original_method = "D1B429C0ADFDAAD2AA9A34491D464202", hash_generated_method = "7E9E6C54D01E5F13F7A4CCB58B878A0F")
    @DSModeled(DSC.SAFE)
    private CookieManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.075 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "5CC070BE034CF82B9F1557AD1EF2C83D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object clone() throws CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("doesn't implement Cloneable");
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    
        public static synchronized CookieManager getInstance() {
        if (sRef == null) {
            sRef = new CookieManager();
        }
        return sRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.076 -0400", hash_original_method = "0044CC48946D988BAC3F9C31DC5ECF6E", hash_generated_method = "B09BD8EFD1BBF5A94CD2BF4632367AE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setAcceptCookie(boolean accept) {
        dsTaint.addTaint(accept);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1768339826 = (JniUtil.useChromiumHttpStack());
            {
                nativeSetAcceptCookie(accept);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //nativeSetAcceptCookie(accept);
            //return;
        //}
        //mAcceptCookie = accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.076 -0400", hash_original_method = "EAEA6182C3DE8E7E3FA46C84A2197DA5", hash_generated_method = "EF1826ACE4E9D5ADDA6F048E3432C651")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean acceptCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1361953535 = (JniUtil.useChromiumHttpStack());
            {
                boolean var7A32826552223CCBC1277BE3318866F8_1450842612 = (nativeAcceptCookie());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return nativeAcceptCookie();
        //}
        //return mAcceptCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.076 -0400", hash_original_method = "3C733C3F28B1C91BBFDBB065F4DCBFE1", hash_generated_method = "1A6E4A9649DD6A9EB7D664BF76BE126C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCookie(String url, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(url);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_2021356315 = (JniUtil.useChromiumHttpStack());
            {
                setCookie(url, value, false);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        { }
        setCookie(uri, value);
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //setCookie(url, value, false);
            //return;
        //}
        //WebAddress uri;
        //try {
            //uri = new WebAddress(url);
        //} catch (ParseException ex) {
            //Log.e(LOGTAG, "Bad address: " + url);
            //return;
        //}
        //setCookie(uri, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.076 -0400", hash_original_method = "FD6DC9D8EE462ADB809067B2E36820B1", hash_generated_method = "94C90330D7B6C87A4BFC85C097E13C29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCookie(String url, String value, boolean privateBrowsing) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(privateBrowsing);
        dsTaint.addTaint(url);
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_2141636508 = (!JniUtil.useChromiumHttpStack());
            {
                setCookie(url, value);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        { }
        nativeSetCookie(uri.toString(), value, privateBrowsing);
        // ---------- Original Method ----------
        //if (!JniUtil.useChromiumHttpStack()) {
            //setCookie(url, value);
            //return;
        //}
        //WebAddress uri;
        //try {
            //uri = new WebAddress(url);
        //} catch (ParseException ex) {
            //Log.e(LOGTAG, "Bad address: " + url);
            //return;
        //}
        //nativeSetCookie(uri.toString(), value, privateBrowsing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.078 -0400", hash_original_method = "8AF5CC468B90A5A42A5116E5B0AA2987", hash_generated_method = "50DBAC56EC56948071468EE256A13E14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setCookie(WebAddress uri, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1558005210 = (JniUtil.useChromiumHttpStack());
            {
                nativeSetCookie(uri.toString(), value, false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF464C5570B08564435F758B79DFFB796_2075527225 = (value != null && value.length() > MAX_COOKIE_LENGTH);
        } //End collapsed parenthetic
        String[] hostAndPath;
        hostAndPath = getHostAndPath(uri);
        {
            boolean var4CD0D0571ACF6B1371CB0FD67E9488E5_251900831 = (hostAndPath[1].length() > 1);
            {
                int index;
                index = hostAndPath[1].lastIndexOf(PATH_DELIM);
                hostAndPath[1] = hostAndPath[1].substring(0, 
                    index > 0 ? index : index + 1);
            } //End block
        } //End collapsed parenthetic
        ArrayList<Cookie> cookies;
        cookies = null;
        try 
        {
            cookies = parseCookie(hostAndPath[0], hostAndPath[1], value);
        } //End block
        catch (RuntimeException ex)
        { }
        {
            boolean var639B145A70887FECCC495043A3AE58E5_2071676974 = (cookies == null || cookies.size() == 0);
        } //End collapsed parenthetic
        String baseDomain;
        baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList;
        cookieList = mCookieMap.get(baseDomain);
        {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        } //End block
        long now;
        now = System.currentTimeMillis();
        int size;
        size = cookies.size();
        {
            int i;
            i = 0;
            {
                Cookie cookie;
                cookie = cookies.get(i);
                boolean done;
                done = false;
                Iterator<Cookie> iter;
                iter = cookieList.iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_1256730769 = (iter.hasNext());
                    {
                        Cookie cookieEntry;
                        cookieEntry = iter.next();
                        {
                            boolean varAB7EC59C572994F733235AA847DF6EAC_598323769 = (cookie.exactMatch(cookieEntry));
                            {
                                {
                                    {
                                        boolean var0B3911FB1DADB1C34E5C5499C7BBE8E8_401850893 = (!cookieEntry.secure || HTTPS.equals(uri.getScheme()));
                                        {
                                            cookieEntry.value = cookie.value;
                                            cookieEntry.expires = cookie.expires;
                                            cookieEntry.secure = cookie.secure;
                                            cookieEntry.lastAcessTime = now;
                                            cookieEntry.lastUpdateTime = now;
                                            cookieEntry.mode = Cookie.MODE_REPLACED;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    cookieEntry.lastUpdateTime = now;
                                    cookieEntry.mode = Cookie.MODE_DELETED;
                                } //End block
                                done = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    cookie.lastAcessTime = now;
                    cookie.lastUpdateTime = now;
                    cookie.mode = Cookie.MODE_NEW;
                    {
                        boolean varA821449DF18F0433C732BA9E8F4FCABD_1575795224 = (cookieList.size() > MAX_COOKIE_COUNT_PER_BASE_DOMAIN);
                        {
                            Cookie toDelete;
                            toDelete = new Cookie();
                            toDelete.lastAcessTime = now;
                            Iterator<Cookie> iter2;
                            iter2 = cookieList.iterator();
                            {
                                boolean varF0EFB9A964C064E456621406FBF6CA8A_1339913866 = (iter2.hasNext());
                                {
                                    Cookie cookieEntry2;
                                    cookieEntry2 = iter2.next();
                                    {
                                        toDelete = cookieEntry2;
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                            toDelete.mode = Cookie.MODE_DELETED;
                        } //End block
                    } //End collapsed parenthetic
                    cookieList.add(cookie);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.078 -0400", hash_original_method = "CFFC2606C8B97641601C2B54714068BC", hash_generated_method = "C72AE3DE79DDC00CCEC5A8949B6AD9C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCookie(String url) {
        dsTaint.addTaint(url);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_543279937 = (JniUtil.useChromiumHttpStack());
            {
                String var893FA4D1A50424F800748D91C5AD1BD6_1663574881 = (getCookie(url, false));
            } //End block
        } //End collapsed parenthetic
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        { }
        String var217049A163701FE06662E63E411C862D_1197123330 = (getCookie(uri));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return getCookie(url, false);
        //}
        //WebAddress uri;
        //try {
            //uri = new WebAddress(url);
        //} catch (ParseException ex) {
            //Log.e(LOGTAG, "Bad address: " + url);
            //return null;
        //}
        //return getCookie(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.078 -0400", hash_original_method = "5ACC35EE5D78B03ACC91967E6F456E58", hash_generated_method = "3869DB69173B1E08B46D65B838A942D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCookie(String url, boolean privateBrowsing) {
        dsTaint.addTaint(privateBrowsing);
        dsTaint.addTaint(url);
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_725319478 = (!JniUtil.useChromiumHttpStack());
            {
                String var3987533A82AC362C4E325309AA855332_12479659 = (getCookie(url));
            } //End block
        } //End collapsed parenthetic
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        { }
        String var905C25A6BB952BF52ED19903EE110CE1_1387713015 = (nativeGetCookie(uri.toString(), privateBrowsing));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!JniUtil.useChromiumHttpStack()) {
            //return getCookie(url);
        //}
        //WebAddress uri;
        //try {
            //uri = new WebAddress(url);
        //} catch (ParseException ex) {
            //Log.e(LOGTAG, "Bad address: " + url);
            //return null;
        //}
        //return nativeGetCookie(uri.toString(), privateBrowsing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.079 -0400", hash_original_method = "BE3F143473537E9CE993D89B685428CF", hash_generated_method = "13FA362EDB1868340A37C373372EAD2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized String getCookie(WebAddress uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_305992632 = (JniUtil.useChromiumHttpStack());
            {
                String var186332A616BB4DE3770F84B9944B2C48_1078476055 = (nativeGetCookie(uri.toString(), false));
            } //End block
        } //End collapsed parenthetic
        String[] hostAndPath;
        hostAndPath = getHostAndPath(uri);
        String baseDomain;
        baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList;
        cookieList = mCookieMap.get(baseDomain);
        {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        } //End block
        long now;
        now = System.currentTimeMillis();
        boolean secure;
        secure = HTTPS.equals(uri.getScheme());
        Iterator<Cookie> iter;
        iter = cookieList.iterator();
        SortedSet<Cookie> cookieSet;
        cookieSet = new TreeSet<Cookie>(COMPARATOR);
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_804851296 = (iter.hasNext());
            {
                Cookie cookie;
                cookie = iter.next();
                {
                    boolean var81120406E156C6C87A676DABB6BB0054_1833198388 = (cookie.domainMatch(hostAndPath[0]) &&
                    cookie.pathMatch(hostAndPath[1])
                    && (cookie.expires < 0 || cookie.expires > now)
                    && (!cookie.secure || secure)
                    && cookie.mode != Cookie.MODE_DELETED);
                    {
                        cookie.lastAcessTime = now;
                        cookieSet.add(cookie);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        StringBuilder ret;
        ret = new StringBuilder(256);
        Iterator<Cookie> setIter;
        setIter = cookieSet.iterator();
        {
            boolean varD75D141127F254DD0E9A96ADF154DF93_118297040 = (setIter.hasNext());
            {
                Cookie cookie;
                cookie = setIter.next();
                {
                    boolean var1834F7F58970AEB3525D549FD6B87EA4_43394868 = (ret.length() > 0);
                    {
                        ret.append(SEMICOLON);
                        ret.append(WHITE_SPACE);
                    } //End block
                } //End collapsed parenthetic
                ret.append(cookie.name);
                {
                    ret.append(EQUAL);
                    ret.append(cookie.value);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5CF789B206995BB451A167ACD3C23235_117313767 = (ret.length() > 0);
            {
                String var3DF91CBB8A7B68AD681805740D6CFA82_978568522 = (ret.toString());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.079 -0400", hash_original_method = "E5896ED24A303B704C1A851D6E9894DE", hash_generated_method = "7B98E0CEF2ED0C681B8B18F98E262D5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void waitForCookieOperationsToComplete() {
        {
            {
                try 
                {
                    wait();
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //while (pendingCookieOperations > 0) {
                //try {
                    //wait();
                //} catch (InterruptedException e) { }
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.080 -0400", hash_original_method = "65B0411E3AAD9BA729084C50D7485B13", hash_generated_method = "B7CAADA5C52530BA6D97746E1DE452FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void signalCookieOperationsComplete() {
        notify();
        // ---------- Original Method ----------
        //pendingCookieOperations--;
        //assert pendingCookieOperations > -1;
        //notify();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.080 -0400", hash_original_method = "3D00699F37AF6D5720F5926DFEED864B", hash_generated_method = "48E8F9DDFD7E31FC7FD0C53F18A2E40C")
    @DSModeled(DSC.SAFE)
    private synchronized void signalCookieOperationsStart() {
        // ---------- Original Method ----------
        //pendingCookieOperations++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.081 -0400", hash_original_method = "E9CA847999E57130D19A4C553707D595", hash_generated_method = "987CBC16F71CD2E502462D6F05C8F53B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeSessionCookie() {
        signalCookieOperationsStart();
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1959284907 = (JniUtil.useChromiumHttpStack());
            {
                new AsyncTask<Void, Void, Void>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.080 -0400", hash_original_method = "DF560F823BF7C351EEB240AF10E95817", hash_generated_method = "9EA2C15162ECC4C26FE74467F9966CDC")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    protected Void doInBackground(Void... none) {
                        dsTaint.addTaint(none[0].dsTaint);
                        nativeRemoveSessionCookie();
                        signalCookieOperationsComplete();
                        return (Void)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //nativeRemoveSessionCookie();
                        //signalCookieOperationsComplete();
                        //return null;
                    }
}.execute();
            } //End block
        } //End collapsed parenthetic
        Runnable clearCache;
        clearCache = new Runnable() {
            public void run() {
                synchronized(CookieManager.this) {
                    Collection<ArrayList<Cookie>> cookieList = mCookieMap.values();
                    Iterator<ArrayList<Cookie>> listIter = cookieList.iterator();
                    while (listIter.hasNext()) {
                        ArrayList<Cookie> list = listIter.next();
                        Iterator<Cookie> iter = list.iterator();
                        while (iter.hasNext()) {
                            Cookie cookie = iter.next();
                            if (cookie.expires == -1) {
                                iter.remove();
                            }
                        }
                    }
                    CookieSyncManager.getInstance().clearSessionCookies();
                    signalCookieOperationsComplete();
                }
            }
        };
        new Thread(clearCache).start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.081 -0400", hash_original_method = "E6726E6A7287E971302CDEBC56D91ADA", hash_generated_method = "A5DF5668E5C4592C701705528AB3192B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAllCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1928535617 = (JniUtil.useChromiumHttpStack());
            {
                nativeRemoveAllCookie();
            } //End block
        } //End collapsed parenthetic
        Runnable clearCache;
        clearCache = new Runnable() {
            public void run() {
                synchronized(CookieManager.this) {
                    mCookieMap = new LinkedHashMap<String, ArrayList<Cookie>>(
                            MAX_DOMAIN_COUNT, 0.75f, true);
                    CookieSyncManager.getInstance().clearAllCookies();
                }
            }
        };
        new Thread(clearCache).start();
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //nativeRemoveAllCookie();
            //return;
        //}
        //final Runnable clearCache = new Runnable() {
            //public void run() {
                //synchronized(CookieManager.this) {
                    //mCookieMap = new LinkedHashMap<String, ArrayList<Cookie>>(
                            //MAX_DOMAIN_COUNT, 0.75f, true);
                    //CookieSyncManager.getInstance().clearAllCookies();
                //}
            //}
        //};
        //new Thread(clearCache).start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.081 -0400", hash_original_method = "2201D105B8AC0DA82BEBC1DB9FB29AE8", hash_generated_method = "014D663FFB0A790B8BA55992A22C4F44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean hasCookies() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1369005611 = (JniUtil.useChromiumHttpStack());
            {
                boolean var8A47D9F563B217F231C778B81E4E893A_21888079 = (hasCookies(false));
            } //End block
        } //End collapsed parenthetic
        boolean varA1156B6EC3BF3B16EC8E0EFFFE74477E_1177269621 = (CookieSyncManager.getInstance().hasCookies());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return hasCookies(false);
        //}
        //return CookieSyncManager.getInstance().hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.081 -0400", hash_original_method = "6C96B3E47AB792BE3053A98B747C02B0", hash_generated_method = "D43A97EE45E75D861B033FEC31CDB887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean hasCookies(boolean privateBrowsing) {
        dsTaint.addTaint(privateBrowsing);
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_57779136 = (!JniUtil.useChromiumHttpStack());
            {
                boolean var0675649B9D327117801A509BA1416818_1048547714 = (hasCookies());
            } //End block
        } //End collapsed parenthetic
        boolean var08F9F6B298BF2816AC0F7C70944E7CDA_207622540 = (nativeHasCookies(privateBrowsing));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!JniUtil.useChromiumHttpStack()) {
            //return hasCookies();
        //}
        //return nativeHasCookies(privateBrowsing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.082 -0400", hash_original_method = "EBBBDCC80F6ABDA541004A954FD75C00", hash_generated_method = "3A4D94634A49A697E27BC2E6E4E70385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeExpiredCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_120659811 = (JniUtil.useChromiumHttpStack());
            {
                nativeRemoveExpiredCookie();
            } //End block
        } //End collapsed parenthetic
        Runnable clearCache;
        clearCache = new Runnable() {
            public void run() {
                synchronized(CookieManager.this) {
                    long now = System.currentTimeMillis();
                    Collection<ArrayList<Cookie>> cookieList = mCookieMap.values();
                    Iterator<ArrayList<Cookie>> listIter = cookieList.iterator();
                    while (listIter.hasNext()) {
                        ArrayList<Cookie> list = listIter.next();
                        Iterator<Cookie> iter = list.iterator();
                        while (iter.hasNext()) {
                            Cookie cookie = iter.next();
                            if (cookie.expires > 0 && cookie.expires < now) {
                                iter.remove();
                            }
                        }
                    }
                    CookieSyncManager.getInstance().clearExpiredCookies(now);
                }
            }
        };
        new Thread(clearCache).start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.082 -0400", hash_original_method = "6E81366EB3EC21A5D57BD56704F05E83", hash_generated_method = "2C78044AACD55835BF066F04D2E934B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void flushCookieStore() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1673406798 = (JniUtil.useChromiumHttpStack());
            {
                nativeFlushCookieStore();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //nativeFlushCookieStore();
        //}
    }

    
        public static boolean allowFileSchemeCookies() {
        if (JniUtil.useChromiumHttpStack()) {
            return nativeAcceptFileSchemeCookies();
        } else {
            return true;
        }
    }

    
        public static void setAcceptFileSchemeCookies(boolean accept) {
        if (JniUtil.useChromiumHttpStack()) {
            nativeSetAcceptFileSchemeCookies(accept);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.083 -0400", hash_original_method = "F607692A589F63FF1216167E4F5DA44E", hash_generated_method = "068CAE11ECA1891D754172A40007A906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized ArrayList<Cookie> getUpdatedCookiesSince(long last) {
        dsTaint.addTaint(last);
        ArrayList<Cookie> cookies;
        cookies = new ArrayList<Cookie>();
        Collection<ArrayList<Cookie>> cookieList;
        cookieList = mCookieMap.values();
        Iterator<ArrayList<Cookie>> listIter;
        listIter = cookieList.iterator();
        {
            boolean var6418FFD41602BEB1548D9077877E8311_643456865 = (listIter.hasNext());
            {
                ArrayList<Cookie> list;
                list = listIter.next();
                Iterator<Cookie> iter;
                iter = list.iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_1438274185 = (iter.hasNext());
                    {
                        Cookie cookie;
                        cookie = iter.next();
                        {
                            cookies.add(cookie);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (ArrayList<Cookie>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<Cookie> cookies = new ArrayList<Cookie>();
        //Collection<ArrayList<Cookie>> cookieList = mCookieMap.values();
        //Iterator<ArrayList<Cookie>> listIter = cookieList.iterator();
        //while (listIter.hasNext()) {
            //ArrayList<Cookie> list = listIter.next();
            //Iterator<Cookie> iter = list.iterator();
            //while (iter.hasNext()) {
                //Cookie cookie = iter.next();
                //if (cookie.lastUpdateTime > last) {
                    //cookies.add(cookie);
                //}
            //}
        //}
        //return cookies;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.083 -0400", hash_original_method = "EBDE0BAE6A65E045698E84F7289F4664", hash_generated_method = "7181192CB1932F2C4CBEFB8399CB110F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized void deleteACookie(Cookie cookie) {
        dsTaint.addTaint(cookie.dsTaint);
        {
            String baseDomain;
            baseDomain = getBaseDomain(cookie.domain);
            ArrayList<Cookie> cookieList;
            cookieList = mCookieMap.get(baseDomain);
            {
                cookieList.remove(cookie);
                {
                    boolean varB40BC97479C649DE73A4798204316F84_1812260688 = (cookieList.isEmpty());
                    {
                        mCookieMap.remove(baseDomain);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (cookie.mode == Cookie.MODE_DELETED) {
            //String baseDomain = getBaseDomain(cookie.domain);
            //ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
            //if (cookieList != null) {
                //cookieList.remove(cookie);
                //if (cookieList.isEmpty()) {
                    //mCookieMap.remove(baseDomain);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.083 -0400", hash_original_method = "23D0913407E37C8868B97CA5EA461217", hash_generated_method = "9F9FA378ECFDD0C3BDCE88350F3B4CA8")
    @DSModeled(DSC.SAFE)
    synchronized void syncedACookie(Cookie cookie) {
        dsTaint.addTaint(cookie.dsTaint);
        cookie.mode = Cookie.MODE_NORMAL;
        // ---------- Original Method ----------
        //cookie.mode = Cookie.MODE_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.084 -0400", hash_original_method = "37E656A6EDF347445C1655B2E42F538E", hash_generated_method = "28C3A28011507065A5F293FC5E50FDBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized ArrayList<Cookie> deleteLRUDomain() {
        int count;
        count = 0;
        int byteCount;
        byteCount = 0;
        int mapSize;
        mapSize = mCookieMap.size();
        {
            Collection<ArrayList<Cookie>> cookieLists;
            cookieLists = mCookieMap.values();
            Iterator<ArrayList<Cookie>> listIter;
            listIter = cookieLists.iterator();
            {
                boolean var118F3A3E5092CF8856C75A8398E045D3_1407525300 = (listIter.hasNext() && count < MAX_RAM_COOKIES_COUNT);
                {
                    ArrayList<Cookie> list;
                    list = listIter.next();
                    {
                        Iterator<Cookie> iter;
                        iter = list.iterator();
                        {
                            boolean var923F5D856CBEA3FFF8E45A6435ECCB10_483174441 = (iter.hasNext() && count < MAX_RAM_COOKIES_COUNT);
                            {
                                Cookie cookie;
                                cookie = iter.next();
                                byteCount += cookie.domain.length()
                                + cookie.path.length()
                                + cookie.name.length()
                                + (cookie.value != null
                                        ? cookie.value.length()
                                        : 0)
                                + 14;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        count += list.size();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        ArrayList<Cookie> retlist;
        retlist = new ArrayList<Cookie>();
        {
            Object[] domains;
            domains = mCookieMap.keySet().toArray();
            int toGo;
            toGo = mapSize / 10 + 1;
            {
                String domain;
                domain = domains[toGo].toString();
                retlist.addAll(mCookieMap.get(domain));
                mCookieMap.remove(domain);
            } //End block
        } //End block
        return (ArrayList<Cookie>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.085 -0400", hash_original_method = "5193D0EACEE146C23C2F9C98185BC9CF", hash_generated_method = "A0388E3DBF6538EEB2043CFED1933873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] getHostAndPath(WebAddress uri) {
        dsTaint.addTaint(uri.dsTaint);
        {
            boolean varB5FF893C44F641B4F7CF23797BB4095A_383694630 = (uri.getHost() != null && uri.getPath() != null);
            {
                String[] ret;
                ret = new String[2];
                ret[0] = uri.getHost().toLowerCase();
                ret[1] = uri.getPath();
                int index;
                index = ret[0].indexOf(PERIOD);
                {
                    {
                        boolean var7AFAB69A16A288F76D0E2FCFA532519E_43751753 = (uri.getScheme().equalsIgnoreCase("file"));
                        {
                            ret[0] = "localhost";
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varB791FB78F104615FDEB847DBBFA3AAC1_440208677 = (index == ret[0].lastIndexOf(PERIOD));
                    {
                        ret[0] = PERIOD + ret[0];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBF520D714B28C887CB3153C5B5D328FA_1130595840 = (ret[1].charAt(0) != PATH_DELIM);
                } //End collapsed parenthetic
                index = ret[1].indexOf(QUESTION_MARK);
                {
                    ret[1] = ret[1].substring(0, index);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.085 -0400", hash_original_method = "0BC29AC3055E44155EBF14855C5D487F", hash_generated_method = "7C12AA7647A643ED0C1FDAB0FBBBCE65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getBaseDomain(String host) {
        dsTaint.addTaint(host);
        int startIndex;
        startIndex = 0;
        int nextIndex;
        nextIndex = host.indexOf(PERIOD);
        int lastIndex;
        lastIndex = host.lastIndexOf(PERIOD);
        {
            startIndex = nextIndex + 1;
            nextIndex = host.indexOf(PERIOD, startIndex);
        } //End block
        {
            String var2EF13598D17E1C07604C3AA08F946BBB_1277732752 = (host.substring(startIndex));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int startIndex = 0;
        //int nextIndex = host.indexOf(PERIOD);
        //int lastIndex = host.lastIndexOf(PERIOD);
        //while (nextIndex < lastIndex) {
            //startIndex = nextIndex + 1;
            //nextIndex = host.indexOf(PERIOD, startIndex);
        //}
        //if (startIndex > 0) {
            //return host.substring(startIndex);
        //} else {
            //return host;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.088 -0400", hash_original_method = "686D7BF75F67F22DBAC0E1E36B7A58EB", hash_generated_method = "119845E5019D561013FC41CD7574FB7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ArrayList<Cookie> parseCookie(String host, String path,
            String cookieString) {
        dsTaint.addTaint(host);
        dsTaint.addTaint(cookieString);
        dsTaint.addTaint(path);
        ArrayList<Cookie> ret;
        ret = new ArrayList<Cookie>();
        int index;
        index = 0;
        int length;
        length = cookieString.length();
        {
            Cookie cookie;
            cookie = null;
            {
                boolean varE8871F9653319A259571D06172D1AEE8_1481613142 = (cookieString.charAt(index) == WHITE_SPACE);
            } //End collapsed parenthetic
            int semicolonIndex;
            semicolonIndex = cookieString.indexOf(SEMICOLON, index);
            int equalIndex;
            equalIndex = cookieString.indexOf(EQUAL, index);
            cookie = new Cookie(host, path);
            {
                {
                    semicolonIndex = length;
                } //End block
                cookie.name = cookieString.substring(index, semicolonIndex);
                cookie.value = null;
            } //End block
            {
                cookie.name = cookieString.substring(index, equalIndex);
                {
                    boolean varEAC5CE96F1515E85A79CC4A57E69EE0C_1214662621 = ((equalIndex < length - 1) &&
                        (cookieString.charAt(equalIndex + 1) == QUOTATION));
                    {
                        index = cookieString.indexOf(QUOTATION, equalIndex + 2);
                    } //End block
                } //End collapsed parenthetic
                semicolonIndex = cookieString.indexOf(SEMICOLON, index);
                {
                    semicolonIndex = length;
                } //End block
                {
                    cookie.value = cookieString.substring(equalIndex + 1,
                            equalIndex + 1 + MAX_COOKIE_LENGTH);
                } //End block
                {
                    cookie.value = "";
                } //End block
                {
                    cookie.value = cookieString.substring(equalIndex + 1,
                            semicolonIndex);
                } //End block
            } //End block
            index = semicolonIndex;
            {
                {
                    boolean varBE5EE8D37CFA74C6E90C8AC330A66127_1380876031 = (cookieString.charAt(index) == WHITE_SPACE
                        || cookieString.charAt(index) == SEMICOLON);
                } //End collapsed parenthetic
                {
                    boolean var59917C993945A4C5AE1ABFE72D45B028_69934066 = (cookieString.charAt(index) == COMMA);
                } //End collapsed parenthetic
                {
                    boolean varF3A4A21C55D7FF52C4292FA83141D706_1552624527 = (length - index >= SECURE_LENGTH
                        && cookieString.substring(index, index + SECURE_LENGTH).
                        equalsIgnoreCase(SECURE));
                    {
                        index += SECURE_LENGTH;
                        cookie.secure = true;
                        {
                            boolean varC88233FC4DC8EC934257FE2094942F69_897084247 = (cookieString.charAt(index) == EQUAL);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var1D7438053E6770C42AF1477FD3B63C7B_435190591 = (length - index >= HTTP_ONLY_LENGTH
                        && cookieString.substring(index,
                            index + HTTP_ONLY_LENGTH).
                        equalsIgnoreCase(HTTP_ONLY));
                    {
                        index += HTTP_ONLY_LENGTH;
                        {
                            boolean varC88233FC4DC8EC934257FE2094942F69_48106131 = (cookieString.charAt(index) == EQUAL);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                equalIndex = cookieString.indexOf(EQUAL, index);
                {
                    String name;
                    name = cookieString.substring(index, equalIndex).toLowerCase();
                    int valueIndex;
                    valueIndex = equalIndex + 1;
                    {
                        boolean varD1FB05D7CF4103A1B6A2928ACA880533_176188419 = (valueIndex < length && cookieString.charAt(valueIndex) == WHITE_SPACE);
                    } //End collapsed parenthetic
                    {
                        boolean var7368C0CDE5A76B546A13F21527AC9C2B_398504580 = (name.equals(EXPIRES));
                        {
                            int comaIndex;
                            comaIndex = cookieString.indexOf(COMMA, equalIndex);
                            {
                                index = comaIndex + 1;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    semicolonIndex = cookieString.indexOf(SEMICOLON, index);
                    int commaIndex;
                    commaIndex = cookieString.indexOf(COMMA, index);
                    {
                        index = length;
                    } //End block
                    {
                        index = commaIndex;
                    } //End block
                    {
                        index = semicolonIndex;
                    } //End block
                    {
                        index = Math.min(semicolonIndex, commaIndex);
                    } //End block
                    String value;
                    value = cookieString.substring(valueIndex, index);
                    {
                        boolean varF3B26F622B3BA344243C3452C5EAD85F_1128032871 = (value.length() > 2 && value.charAt(0) == QUOTATION);
                        {
                            int endQuote;
                            endQuote = value.indexOf(QUOTATION, 1);
                            {
                                value = value.substring(1, endQuote);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var7368C0CDE5A76B546A13F21527AC9C2B_1355097912 = (name.equals(EXPIRES));
                        {
                            try 
                            {
                                cookie.expires = AndroidHttpClient.parseDate(value);
                            } //End block
                            catch (IllegalArgumentException ex)
                            { }
                        } //End block
                        {
                            boolean var6564460B5C30271EE1EFF78DDBB789FB_1756568059 = (name.equals(MAX_AGE));
                            {
                                try 
                                {
                                    cookie.expires = System.currentTimeMillis() + 1000
                                    * Long.parseLong(value);
                                } //End block
                                catch (NumberFormatException ex)
                                { }
                            } //End block
                            {
                                boolean var0A9AF45F54D476ACC0274E0E6DAC2FA0_302712199 = (name.equals(PATH));
                                {
                                    {
                                        boolean var0E83E73D0EFF9C33CBD153EB762D02A2_1131192168 = (value.length() > 0);
                                        {
                                            cookie.path = value;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varF74E07688049599069565E410921F574_607711899 = (name.equals(DOMAIN));
                                    {
                                        int lastPeriod;
                                        lastPeriod = value.lastIndexOf(PERIOD);
                                        {
                                            cookie.domain = null;
                                        } //End block
                                        try 
                                        {
                                            Integer.parseInt(value.substring(lastPeriod + 1));
                                            {
                                                boolean varE1CD484A077BCDA29486EAC1AD09FE74_1350290388 = (!value.equals(host));
                                                {
                                                    cookie.domain = null;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        catch (NumberFormatException ex)
                                        { }
                                        value = value.toLowerCase();
                                        {
                                            boolean varE2B53F95599A2D49216C544D11EF4ECC_2071861511 = (value.charAt(0) != PERIOD);
                                            {
                                                value = PERIOD + value;
                                            } //End block
                                        } //End collapsed parenthetic
                                        {
                                            boolean var10024EBAA7EEAAC0A256BE84E1366563_1906089107 = (host.endsWith(value.substring(1)));
                                            {
                                                int len;
                                                len = value.length();
                                                int hostLen;
                                                hostLen = host.length();
                                                {
                                                    boolean var0CE4FFED329EAEC88D1A8448E0EC8E7E_57516799 = (hostLen > (len - 1)
                                    && host.charAt(hostLen - len) != PERIOD);
                                                    {
                                                        cookie.domain = null;
                                                    } //End block
                                                } //End collapsed parenthetic
                                                {
                                                    String s;
                                                    s = value.substring(1, lastPeriod);
                                                    {
                                                        boolean var6C41572AF3F94E5C989F9F99887AAEBD_157730221 = (Arrays.binarySearch(BAD_COUNTRY_2LDS, s) >= 0);
                                                        {
                                                            cookie.domain = null;
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End block
                                                cookie.domain = value;
                                            } //End block
                                            {
                                                cookie.domain = null;
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    index = length;
                } //End block
            } //End block
            {
                ret.add(cookie);
            } //End block
        } //End block
        return (ArrayList<Cookie>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean nativeAcceptCookie() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static String nativeGetCookie(String url, boolean privateBrowsing) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static boolean nativeHasCookies(boolean privateBrowsing) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeRemoveAllCookie() {
    }

    
        private static void nativeRemoveExpiredCookie() {
    }

    
        private static void nativeRemoveSessionCookie() {
    }

    
        private static void nativeSetAcceptCookie(boolean accept) {
    }

    
        private static void nativeSetCookie(String url, String value, boolean privateBrowsing) {
    }

    
        private static void nativeFlushCookieStore() {
    }

    
        private static boolean nativeAcceptFileSchemeCookies() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeSetAcceptFileSchemeCookies(boolean accept) {
    }

    
    static class Cookie {
        String domain;
        String path;
        String name;
        String value;
        long expires;
        long lastAcessTime;
        long lastUpdateTime;
        boolean secure;
        byte mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.091 -0400", hash_original_method = "91108A58846CEDD8DA5905902DEE69F4", hash_generated_method = "0337FD9DF266AE2D58305A9F66087523")
        @DSModeled(DSC.SAFE)
         Cookie() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.091 -0400", hash_original_method = "E1F86FD348EBFCA5152C7C5B27A3DCAA", hash_generated_method = "8311AA60307A2F7D59B1FCF3F46B5D09")
        @DSModeled(DSC.SAFE)
         Cookie(String defaultDomain, String defaultPath) {
            dsTaint.addTaint(defaultPath);
            dsTaint.addTaint(defaultDomain);
            expires = -1;
            // ---------- Original Method ----------
            //domain = defaultDomain;
            //path = defaultPath;
            //expires = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.092 -0400", hash_original_method = "78A5F78070F927D77B7E42EE06AFDBC4", hash_generated_method = "5A7BEF8A4F3CC267A00A48AED6FA1E75")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean exactMatch(Cookie in) {
            dsTaint.addTaint(in.dsTaint);
            boolean valuesMatch;
            valuesMatch = !((value == null) ^ (in.value == null));
            boolean varB760F3D14A317E9E1240F1DD0EB08AC9_769446655 = (domain.equals(in.domain) && path.equals(in.path) &&
                    name.equals(in.name) && valuesMatch);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //boolean valuesMatch = !((value == null) ^ (in.value == null));
            //return domain.equals(in.domain) && path.equals(in.path) &&
                    //name.equals(in.name) && valuesMatch;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.092 -0400", hash_original_method = "AE74CD0D7D859A06FEAA31D7F99E4D83", hash_generated_method = "718146A09A67FFEEFEF8B16E91B110F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean domainMatch(String urlHost) {
            dsTaint.addTaint(urlHost);
            {
                boolean var1AA47E915A9A7BE21086DD3D0BA11DC5_1027638326 = (domain.startsWith("."));
                {
                    {
                        boolean varD1AD2EF5FF384B0F8B31A949A9373BE8_703484788 = (urlHost.endsWith(domain.substring(1)));
                        {
                            int len;
                            len = domain.length();
                            int urlLen;
                            urlLen = urlHost.length();
                            {
                                boolean var0474A224C63EE86B2A0F82273C401629_214162983 = (urlHost.charAt(urlLen - len) == PERIOD);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var92CC2FDDED6B31734455343B1116D0F1_1909824296 = (urlHost.equals(domain));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (domain.startsWith(".")) {
                //if (urlHost.endsWith(domain.substring(1))) {
                    //int len = domain.length();
                    //int urlLen = urlHost.length();
                    //if (urlLen > len - 1) {
                        //return urlHost.charAt(urlLen - len) == PERIOD;
                    //}
                    //return true;
                //}
                //return false;
            //} else {
                //return urlHost.equals(domain);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.093 -0400", hash_original_method = "0FD43CB7A1B51508534ED8D9F7B624E8", hash_generated_method = "4772C477E210BA2CB109CA1B2242448C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean pathMatch(String urlPath) {
            dsTaint.addTaint(urlPath);
            {
                boolean var6B3ADCF616A86BAB477653B4B7C748B5_1336381199 = (urlPath.startsWith(path));
                {
                    int len;
                    len = path.length();
                    int urlLen;
                    urlLen = urlPath.length();
                    {
                        boolean var652449ECDCA9F03141F3688013BBBCE1_1244735367 = (path.charAt(len-1) != PATH_DELIM && urlLen > len);
                        {
                            boolean var0556DC25417548B062FF41011508D659_601717369 = (urlPath.charAt(len) == PATH_DELIM);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (urlPath.startsWith(path)) {
                //int len = path.length();
                //if (len == 0) {
                    //Log.w(LOGTAG, "Empty cookie path");
                    //return false;
                //}
                //int urlLen = urlPath.length();
                //if (path.charAt(len-1) != PATH_DELIM && urlLen > len) {
                    //return urlPath.charAt(len) == PATH_DELIM;
                //}
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.093 -0400", hash_original_method = "08415E5687C0C693DFF8536ADAD3E2AA", hash_generated_method = "E1E963E869809B3BCD5DA6881DED7133")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "domain: " + domain + "; path: " + path + "; name: " + name
                    //+ "; value: " + value;
        }

        
        static final byte MODE_NEW = 0;
        static final byte MODE_NORMAL = 1;
        static final byte MODE_DELETED = 2;
        static final byte MODE_REPLACED = 3;
    }


    
    private static final class CookieComparator implements Comparator<Cookie> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.093 -0400", hash_original_method = "2ADAAB31220A2DFC0ACA9B5347F9E8C1", hash_generated_method = "2ADAAB31220A2DFC0ACA9B5347F9E8C1")
                public CookieComparator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.094 -0400", hash_original_method = "2F959C67E8DDB6BD10BD3460D506EDBA", hash_generated_method = "0F689B79363C3A4275B3998F295419AA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compare(Cookie cookie1, Cookie cookie2) {
            dsTaint.addTaint(cookie2.dsTaint);
            dsTaint.addTaint(cookie1.dsTaint);
            int diff;
            diff = cookie2.path.length() - cookie1.path.length();
            diff = cookie2.domain.length() - cookie1.domain.length();
            int varF72DD66A04AAB93721C41E4DC4180D39_174846800 = (cookie1.name.compareTo(cookie2.name));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int diff = cookie2.path.length() - cookie1.path.length();
            //if (diff != 0) return diff;
            //diff = cookie2.domain.length() - cookie1.domain.length();
            //if (diff != 0) return diff;
            //if (cookie2.value == null) {
                //if (cookie1.value != null) {
                    //return -1;
                //}
            //} else if (cookie1.value == null) {
                //return 1;
            //}
            //return cookie1.name.compareTo(cookie2.name);
        }

        
    }


    
    private static CookieManager sRef;
    private static final String LOGTAG = "webkit";
    private static final String DOMAIN = "domain";
    private static final String PATH = "path";
    private static final String EXPIRES = "expires";
    private static final String SECURE = "secure";
    private static final String MAX_AGE = "max-age";
    private static final String HTTP_ONLY = "httponly";
    private static final String HTTPS = "https";
    private static final char PERIOD = '.';
    private static final char COMMA = ',';
    private static final char SEMICOLON = ';';
    private static final char EQUAL = '=';
    private static final char PATH_DELIM = '/';
    private static final char QUESTION_MARK = '?';
    private static final char WHITE_SPACE = ' ';
    private static final char QUOTATION = '\"';
    private static final int SECURE_LENGTH = SECURE.length();
    private static final int HTTP_ONLY_LENGTH = HTTP_ONLY.length();
    private static final int MAX_COOKIE_LENGTH = 4 * 1024;
    private static final int MAX_COOKIE_COUNT_PER_BASE_DOMAIN = 50;
    private static final int MAX_DOMAIN_COUNT = 200;
    private static final int MAX_RAM_COOKIES_COUNT = 1000;
    private static final int MAX_RAM_DOMAIN_COUNT = 15;
    private final static String[] BAD_COUNTRY_2LDS =
          { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
    private static final CookieComparator COMPARATOR = new CookieComparator();
}

