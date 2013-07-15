package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.703 -0400", hash_original_field = "33B8F6A3D163A5424381884F05DEEE3C", hash_generated_field = "FBED18CAF24013DA0D8FA265CFF0028E")

    private Map<String, ArrayList<Cookie>> mCookieMap = new LinkedHashMap
            <String, ArrayList<Cookie>>(MAX_DOMAIN_COUNT, 0.75f, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.703 -0400", hash_original_field = "4C8CE05AB6E764DAAAEA4703562B22CB", hash_generated_field = "EA988CB62FE4EFBF1E2849AAB3DDD6B9")

    private boolean mAcceptCookie = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.703 -0400", hash_original_field = "9AB401A6E848CD08C3892BEAD196B99B", hash_generated_field = "E7DA179CDB1C423BB7FF952CDAC068A2")

    private int pendingCookieOperations = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.703 -0400", hash_original_method = "D1B429C0ADFDAAD2AA9A34491D464202", hash_generated_method = "7E9E6C54D01E5F13F7A4CCB58B878A0F")
    private  CookieManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.703 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "CA52ADFBDEFC500949C0271D05AC5501")
    protected Object clone() throws CloneNotSupportedException {
        CloneNotSupportedException var526F0275412AAA8782D17897499AAE9F_794930757 = new CloneNotSupportedException("doesn't implement Cloneable");
        var526F0275412AAA8782D17897499AAE9F_794930757.addTaint(taint);
        throw var526F0275412AAA8782D17897499AAE9F_794930757;
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    
        public static synchronized CookieManager getInstance() {
        if (sRef == null) {
            sRef = new CookieManager();
        }
        return sRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.704 -0400", hash_original_method = "0044CC48946D988BAC3F9C31DC5ECF6E", hash_generated_method = "4FBB921F151D5F041D99E7A219E5115B")
    public synchronized void setAcceptCookie(boolean accept) {
    if(JniUtil.useChromiumHttpStack())        
        {
            nativeSetAcceptCookie(accept);
            return;
        } //End block
        mAcceptCookie = accept;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //nativeSetAcceptCookie(accept);
            //return;
        //}
        //mAcceptCookie = accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.704 -0400", hash_original_method = "EAEA6182C3DE8E7E3FA46C84A2197DA5", hash_generated_method = "A7F291B244370B34FB6C1433BE5FD268")
    public synchronized boolean acceptCookie() {
    if(JniUtil.useChromiumHttpStack())        
        {
            boolean varE5E4502D52B670C93AEA2A7AA47C6D71_1988842214 = (nativeAcceptCookie());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972631437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972631437;
        } //End block
        boolean var49A4E18BE20202FF3725A646D0AC31F6_477564007 = (mAcceptCookie);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313785980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313785980;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return nativeAcceptCookie();
        //}
        //return mAcceptCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.705 -0400", hash_original_method = "3C733C3F28B1C91BBFDBB065F4DCBFE1", hash_generated_method = "C180863BA5B4BE6CE662DE263AAD10E9")
    public void setCookie(String url, String value) {
        addTaint(value.getTaint());
        addTaint(url.getTaint());
    if(JniUtil.useChromiumHttpStack())        
        {
            setCookie(url, value, false);
            return;
        } //End block
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.705 -0400", hash_original_method = "FD6DC9D8EE462ADB809067B2E36820B1", hash_generated_method = "6012AA7553EA542D21EDEFB9480AA444")
    public void setCookie(String url, String value, boolean privateBrowsing) {
        addTaint(privateBrowsing);
        addTaint(value.getTaint());
        addTaint(url.getTaint());
    if(!JniUtil.useChromiumHttpStack())        
        {
            setCookie(url, value);
            return;
        } //End block
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.708 -0400", hash_original_method = "8AF5CC468B90A5A42A5116E5B0AA2987", hash_generated_method = "A18DFAB557E9BC8E225ECB52AEBEE109")
    public synchronized void setCookie(WebAddress uri, String value) {
        addTaint(value.getTaint());
        addTaint(uri.getTaint());
    if(JniUtil.useChromiumHttpStack())        
        {
            nativeSetCookie(uri.toString(), value, false);
            return;
        } //End block
    if(value != null && value.length() > MAX_COOKIE_LENGTH)        
        {
            return;
        } //End block
    if(!mAcceptCookie || uri == null)        
        {
            return;
        } //End block
    if(DebugFlags.COOKIE_MANAGER)        
        {
        } //End block
        String[] hostAndPath = getHostAndPath(uri);
    if(hostAndPath == null)        
        {
            return;
        } //End block
    if(hostAndPath[1].length() > 1)        
        {
            int index = hostAndPath[1].lastIndexOf(PATH_DELIM);
            hostAndPath[1] = hostAndPath[1].substring(0, 
                    index > 0 ? index : index + 1);
        } //End block
        ArrayList<Cookie> cookies = null;
        try 
        {
            cookies = parseCookie(hostAndPath[0], hostAndPath[1], value);
        } //End block
        catch (RuntimeException ex)
        {
        } //End block
    if(cookies == null || cookies.size() == 0)        
        {
            return;
        } //End block
        String baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
    if(cookieList == null)        
        {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        } //End block
        long now = System.currentTimeMillis();
        int size = cookies.size();
for(int i = 0;i < size;i++)
        {
            Cookie cookie = cookies.get(i);
            boolean done = false;
            Iterator<Cookie> iter = cookieList.iterator();
            while
(iter.hasNext())            
            {
                Cookie cookieEntry = iter.next();
    if(cookie.exactMatch(cookieEntry))                
                {
    if(cookie.expires < 0 || cookie.expires > now)                    
                    {
    if(!cookieEntry.secure || HTTPS.equals(uri.getScheme()))                        
                        {
                            cookieEntry.value = cookie.value;
                            cookieEntry.expires = cookie.expires;
                            cookieEntry.secure = cookie.secure;
                            cookieEntry.lastAcessTime = now;
                            cookieEntry.lastUpdateTime = now;
                            cookieEntry.mode = Cookie.MODE_REPLACED;
                        } //End block
                    } //End block
                    else
                    {
                        cookieEntry.lastUpdateTime = now;
                        cookieEntry.mode = Cookie.MODE_DELETED;
                    } //End block
                    done = true;
                    break;
                } //End block
            } //End block
    if(!done && (cookie.expires < 0 || cookie.expires > now))            
            {
                cookie.lastAcessTime = now;
                cookie.lastUpdateTime = now;
                cookie.mode = Cookie.MODE_NEW;
    if(cookieList.size() > MAX_COOKIE_COUNT_PER_BASE_DOMAIN)                
                {
                    Cookie toDelete = new Cookie();
                    toDelete.lastAcessTime = now;
                    Iterator<Cookie> iter2 = cookieList.iterator();
                    while
(iter2.hasNext())                    
                    {
                        Cookie cookieEntry2 = iter2.next();
    if((cookieEntry2.lastAcessTime < toDelete.lastAcessTime)
                                && cookieEntry2.mode != Cookie.MODE_DELETED)                        
                        {
                            toDelete = cookieEntry2;
                        } //End block
                    } //End block
                    toDelete.mode = Cookie.MODE_DELETED;
                } //End block
                cookieList.add(cookie);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.709 -0400", hash_original_method = "CFFC2606C8B97641601C2B54714068BC", hash_generated_method = "43DBDE6232E0DA194333EADCB2F4103A")
    public String getCookie(String url) {
        addTaint(url.getTaint());
    if(JniUtil.useChromiumHttpStack())        
        {
String varF4013E3CDCD90AC74FFF8590033F8AB4_789441834 =             getCookie(url, false);
            varF4013E3CDCD90AC74FFF8590033F8AB4_789441834.addTaint(taint);
            return varF4013E3CDCD90AC74FFF8590033F8AB4_789441834;
        } //End block
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
String var540C13E9E156B687226421B24F2DF178_1177016121 =             null;
            var540C13E9E156B687226421B24F2DF178_1177016121.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1177016121;
        } //End block
String var407A51A1DFAF9AAFAEF8FC170E67F8D8_124778341 =         getCookie(uri);
        var407A51A1DFAF9AAFAEF8FC170E67F8D8_124778341.addTaint(taint);
        return var407A51A1DFAF9AAFAEF8FC170E67F8D8_124778341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.710 -0400", hash_original_method = "5ACC35EE5D78B03ACC91967E6F456E58", hash_generated_method = "04029B9FB53268B2CAA7D671AC92F6B9")
    public String getCookie(String url, boolean privateBrowsing) {
        addTaint(privateBrowsing);
        addTaint(url.getTaint());
    if(!JniUtil.useChromiumHttpStack())        
        {
String varBB2B84388E474811EBE3C854A52081D4_1936293468 =             getCookie(url);
            varBB2B84388E474811EBE3C854A52081D4_1936293468.addTaint(taint);
            return varBB2B84388E474811EBE3C854A52081D4_1936293468;
        } //End block
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
String var540C13E9E156B687226421B24F2DF178_219945880 =             null;
            var540C13E9E156B687226421B24F2DF178_219945880.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_219945880;
        } //End block
String varDC437723AB9FFD70AC3DBD8C655741B2_340415472 =         nativeGetCookie(uri.toString(), privateBrowsing);
        varDC437723AB9FFD70AC3DBD8C655741B2_340415472.addTaint(taint);
        return varDC437723AB9FFD70AC3DBD8C655741B2_340415472;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.711 -0400", hash_original_method = "BE3F143473537E9CE993D89B685428CF", hash_generated_method = "6A6DDF0B8B293D334C899479ED1A5D85")
    public synchronized String getCookie(WebAddress uri) {
        addTaint(uri.getTaint());
    if(JniUtil.useChromiumHttpStack())        
        {
String varC5032DF947036C987207202C98CE27A2_1040543617 =             nativeGetCookie(uri.toString(), false);
            varC5032DF947036C987207202C98CE27A2_1040543617.addTaint(taint);
            return varC5032DF947036C987207202C98CE27A2_1040543617;
        } //End block
    if(!mAcceptCookie || uri == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1268611834 =             null;
            var540C13E9E156B687226421B24F2DF178_1268611834.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1268611834;
        } //End block
        String[] hostAndPath = getHostAndPath(uri);
    if(hostAndPath == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2022454515 =             null;
            var540C13E9E156B687226421B24F2DF178_2022454515.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2022454515;
        } //End block
        String baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
    if(cookieList == null)        
        {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        } //End block
        long now = System.currentTimeMillis();
        boolean secure = HTTPS.equals(uri.getScheme());
        Iterator<Cookie> iter = cookieList.iterator();
        SortedSet<Cookie> cookieSet = new TreeSet<Cookie>(COMPARATOR);
        while
(iter.hasNext())        
        {
            Cookie cookie = iter.next();
    if(cookie.domainMatch(hostAndPath[0]) &&
                    cookie.pathMatch(hostAndPath[1])
                    && (cookie.expires < 0 || cookie.expires > now)
                    && (!cookie.secure || secure)
                    && cookie.mode != Cookie.MODE_DELETED)            
            {
                cookie.lastAcessTime = now;
                cookieSet.add(cookie);
            } //End block
        } //End block
        StringBuilder ret = new StringBuilder(256);
        Iterator<Cookie> setIter = cookieSet.iterator();
        while
(setIter.hasNext())        
        {
            Cookie cookie = setIter.next();
    if(ret.length() > 0)            
            {
                ret.append(SEMICOLON);
                ret.append(WHITE_SPACE);
            } //End block
            ret.append(cookie.name);
    if(cookie.value != null)            
            {
                ret.append(EQUAL);
                ret.append(cookie.value);
            } //End block
        } //End block
    if(ret.length() > 0)        
        {
    if(DebugFlags.COOKIE_MANAGER)            
            {
            } //End block
String varBF0416CC9C97BA8F7D7771199729A131_1802437046 =             ret.toString();
            varBF0416CC9C97BA8F7D7771199729A131_1802437046.addTaint(taint);
            return varBF0416CC9C97BA8F7D7771199729A131_1802437046;
        } //End block
        else
        {
    if(DebugFlags.COOKIE_MANAGER)            
            {
            } //End block
String var540C13E9E156B687226421B24F2DF178_1856118514 =             null;
            var540C13E9E156B687226421B24F2DF178_1856118514.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1856118514;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.712 -0400", hash_original_method = "E5896ED24A303B704C1A851D6E9894DE", hash_generated_method = "15F08066BA9FFD9F2340FB970B163BE5")
    public void waitForCookieOperationsToComplete() {
        synchronized
(this)        {
            while
(pendingCookieOperations > 0)            
            {
                try 
                {
                    wait();
                } //End block
                catch (InterruptedException e)
                {
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.712 -0400", hash_original_method = "65B0411E3AAD9BA729084C50D7485B13", hash_generated_method = "A9E6A312E809291F60B900D7678FD37D")
    private synchronized void signalCookieOperationsComplete() {
        pendingCookieOperations--;
        notify();
        // ---------- Original Method ----------
        //pendingCookieOperations--;
        //assert pendingCookieOperations > -1;
        //notify();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.712 -0400", hash_original_method = "3D00699F37AF6D5720F5926DFEED864B", hash_generated_method = "E349E3171C584B41701676E3CC873736")
    private synchronized void signalCookieOperationsStart() {
        pendingCookieOperations++;
        // ---------- Original Method ----------
        //pendingCookieOperations++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.713 -0400", hash_original_method = "E9CA847999E57130D19A4C553707D595", hash_generated_method = "2BB5DA26A87F809A69634DD02697C441")
    public void removeSessionCookie() {
        signalCookieOperationsStart();
    if(JniUtil.useChromiumHttpStack())        
        {
            new AsyncTask<Void, Void, Void>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.713 -0400", hash_original_method = "DF560F823BF7C351EEB240AF10E95817", hash_generated_method = "AF8DF9B7D3BED2460731F0954D057931")
        protected Void doInBackground(Void... none) {
            addTaint(none[0].getTaint());
            nativeRemoveSessionCookie();
            signalCookieOperationsComplete();
Void var540C13E9E156B687226421B24F2DF178_1268020359 =             null;
            var540C13E9E156B687226421B24F2DF178_1268020359.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1268020359;
            // ---------- Original Method ----------
            //nativeRemoveSessionCookie();
            //signalCookieOperationsComplete();
            //return null;
        }
}.execute();
            return;
        } //End block
        final Runnable clearCache = new Runnable() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.713 -0400", hash_original_method = "E6726E6A7287E971302CDEBC56D91ADA", hash_generated_method = "436F546B5A6EA9D0AA57CF8692050EBE")
    public void removeAllCookie() {
    if(JniUtil.useChromiumHttpStack())        
        {
            nativeRemoveAllCookie();
            return;
        } //End block
        final Runnable clearCache = new Runnable() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.714 -0400", hash_original_method = "2201D105B8AC0DA82BEBC1DB9FB29AE8", hash_generated_method = "FF8FF02B26660AB733CDE8B6F1985E27")
    public synchronized boolean hasCookies() {
    if(JniUtil.useChromiumHttpStack())        
        {
            boolean var95F7A9F99520A76FCBA60C13FE542A6E_1199986318 = (hasCookies(false));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568720262 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_568720262;
        } //End block
        boolean var91293B5C020EF0EB227BF89D9D25910B_425374320 = (CookieSyncManager.getInstance().hasCookies());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_887491649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_887491649;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return hasCookies(false);
        //}
        //return CookieSyncManager.getInstance().hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.714 -0400", hash_original_method = "6C96B3E47AB792BE3053A98B747C02B0", hash_generated_method = "0CA54A98B16B551A674B90CD80FFA996")
    public synchronized boolean hasCookies(boolean privateBrowsing) {
        addTaint(privateBrowsing);
    if(!JniUtil.useChromiumHttpStack())        
        {
            boolean var64FF49FA7F904E536DCB9813EC3FE843_1017907001 = (hasCookies());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686723910 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686723910;
        } //End block
        boolean varE6D541A0DC8E3A114D73BFC1B78BCF9A_2074040091 = (nativeHasCookies(privateBrowsing));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_820942553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_820942553;
        // ---------- Original Method ----------
        //if (!JniUtil.useChromiumHttpStack()) {
            //return hasCookies();
        //}
        //return nativeHasCookies(privateBrowsing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.714 -0400", hash_original_method = "EBBBDCC80F6ABDA541004A954FD75C00", hash_generated_method = "7D31AFBB1DAA261E2402E064E68310C8")
    public void removeExpiredCookie() {
    if(JniUtil.useChromiumHttpStack())        
        {
            nativeRemoveExpiredCookie();
            return;
        } //End block
        final Runnable clearCache = new Runnable() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.715 -0400", hash_original_method = "6E81366EB3EC21A5D57BD56704F05E83", hash_generated_method = "1286D4FA450AEC22FD9DB55D5A26A55A")
     void flushCookieStore() {
    if(JniUtil.useChromiumHttpStack())        
        {
            nativeFlushCookieStore();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.715 -0400", hash_original_method = "F607692A589F63FF1216167E4F5DA44E", hash_generated_method = "B852A0B95057CD3C61D5FC1C0ABC588A")
    synchronized ArrayList<Cookie> getUpdatedCookiesSince(long last) {
        addTaint(last);
        ArrayList<Cookie> cookies = new ArrayList<Cookie>();
        Collection<ArrayList<Cookie>> cookieList = mCookieMap.values();
        Iterator<ArrayList<Cookie>> listIter = cookieList.iterator();
        while
(listIter.hasNext())        
        {
            ArrayList<Cookie> list = listIter.next();
            Iterator<Cookie> iter = list.iterator();
            while
(iter.hasNext())            
            {
                Cookie cookie = iter.next();
    if(cookie.lastUpdateTime > last)                
                {
                    cookies.add(cookie);
                } //End block
            } //End block
        } //End block
ArrayList<Cookie> var7A32AB0BC299936B4ABF6C972D767041_1110539045 =         cookies;
        var7A32AB0BC299936B4ABF6C972D767041_1110539045.addTaint(taint);
        return var7A32AB0BC299936B4ABF6C972D767041_1110539045;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.716 -0400", hash_original_method = "EBDE0BAE6A65E045698E84F7289F4664", hash_generated_method = "0672E003619078B13DD64A4CF92666B2")
    synchronized void deleteACookie(Cookie cookie) {
        addTaint(cookie.getTaint());
    if(cookie.mode == Cookie.MODE_DELETED)        
        {
            String baseDomain = getBaseDomain(cookie.domain);
            ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
    if(cookieList != null)            
            {
                cookieList.remove(cookie);
    if(cookieList.isEmpty())                
                {
                    mCookieMap.remove(baseDomain);
                } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.716 -0400", hash_original_method = "23D0913407E37C8868B97CA5EA461217", hash_generated_method = "E9139E4036FB7922E32DF7EF47AF9E4A")
    synchronized void syncedACookie(Cookie cookie) {
        addTaint(cookie.getTaint());
        cookie.mode = Cookie.MODE_NORMAL;
        // ---------- Original Method ----------
        //cookie.mode = Cookie.MODE_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.718 -0400", hash_original_method = "37E656A6EDF347445C1655B2E42F538E", hash_generated_method = "07E0ABCCA171F4BFF77694EC699DBCE0")
    synchronized ArrayList<Cookie> deleteLRUDomain() {
        int count = 0;
        int byteCount = 0;
        int mapSize = mCookieMap.size();
    if(mapSize < MAX_RAM_DOMAIN_COUNT)        
        {
            Collection<ArrayList<Cookie>> cookieLists = mCookieMap.values();
            Iterator<ArrayList<Cookie>> listIter = cookieLists.iterator();
            while
(listIter.hasNext() && count < MAX_RAM_COOKIES_COUNT)            
            {
                ArrayList<Cookie> list = listIter.next();
    if(DebugFlags.COOKIE_MANAGER)                
                {
                    Iterator<Cookie> iter = list.iterator();
                    while
(iter.hasNext() && count < MAX_RAM_COOKIES_COUNT)                    
                    {
                        Cookie cookie = iter.next();
                        byteCount += cookie.domain.length()
                                + cookie.path.length()
                                + cookie.name.length()
                                + (cookie.value != null
                                        ? cookie.value.length()
                                        : 0)
                                + 14;
                        count++;
                    } //End block
                } //End block
                else
                {
                    count += list.size();
                } //End block
            } //End block
        } //End block
        ArrayList<Cookie> retlist = new ArrayList<Cookie>();
    if(mapSize >= MAX_RAM_DOMAIN_COUNT || count >= MAX_RAM_COOKIES_COUNT)        
        {
    if(DebugFlags.COOKIE_MANAGER)            
            {
            } //End block
            Object[] domains = mCookieMap.keySet().toArray();
            int toGo = mapSize / 10 + 1;
            while
(toGo-- > 0)            
            {
                String domain = domains[toGo].toString();
    if(DebugFlags.COOKIE_MANAGER)                
                {
                } //End block
                retlist.addAll(mCookieMap.get(domain));
                mCookieMap.remove(domain);
            } //End block
        } //End block
ArrayList<Cookie> var74ABD4429824C0B59980227BA1F53471_285953652 =         retlist;
        var74ABD4429824C0B59980227BA1F53471_285953652.addTaint(taint);
        return var74ABD4429824C0B59980227BA1F53471_285953652;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.720 -0400", hash_original_method = "5193D0EACEE146C23C2F9C98185BC9CF", hash_generated_method = "C0361BD1BEB6D40ADD95616C0028E21B")
    private String[] getHostAndPath(WebAddress uri) {
        addTaint(uri.getTaint());
    if(uri.getHost() != null && uri.getPath() != null)        
        {
            String[] ret = new String[2];
            ret[0] = uri.getHost().toLowerCase();
            ret[1] = uri.getPath();
            int index = ret[0].indexOf(PERIOD);
    if(index == -1)            
            {
    if(uri.getScheme().equalsIgnoreCase("file"))                
                {
                    ret[0] = "localhost";
                } //End block
            } //End block
            else
    if(index == ret[0].lastIndexOf(PERIOD))            
            {
                ret[0] = PERIOD + ret[0];
            } //End block
    if(ret[1].charAt(0) != PATH_DELIM)            
            {
String[] var540C13E9E156B687226421B24F2DF178_1276333412 =                 null;
                var540C13E9E156B687226421B24F2DF178_1276333412.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1276333412;
            } //End block
            index = ret[1].indexOf(QUESTION_MARK);
    if(index != -1)            
            {
                ret[1] = ret[1].substring(0, index);
            } //End block
String[] varEDFF4FBBF053B5DC2B444ADFA049EE0F_723794581 =             ret;
            varEDFF4FBBF053B5DC2B444ADFA049EE0F_723794581.addTaint(taint);
            return varEDFF4FBBF053B5DC2B444ADFA049EE0F_723794581;
        } //End block
        else
        {
String[] var540C13E9E156B687226421B24F2DF178_674705440 =         null;
        var540C13E9E156B687226421B24F2DF178_674705440.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_674705440;
        }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.780 -0400", hash_original_method = "0BC29AC3055E44155EBF14855C5D487F", hash_generated_method = "FC33237DEC14CCB194570BF87674E848")
    private String getBaseDomain(String host) {
        addTaint(host.getTaint());
        int startIndex = 0;
        int nextIndex = host.indexOf(PERIOD);
        int lastIndex = host.lastIndexOf(PERIOD);
        while
(nextIndex < lastIndex)        
        {
            startIndex = nextIndex + 1;
            nextIndex = host.indexOf(PERIOD, startIndex);
        } //End block
    if(startIndex > 0)        
        {
String varEB32A0C667C3D67123A0EA3E65CE6484_201453620 =             host.substring(startIndex);
            varEB32A0C667C3D67123A0EA3E65CE6484_201453620.addTaint(taint);
            return varEB32A0C667C3D67123A0EA3E65CE6484_201453620;
        } //End block
        else
        {
String var872E07117C05F1A34EC24B57B694B8E3_785496457 =             host;
            var872E07117C05F1A34EC24B57B694B8E3_785496457.addTaint(taint);
            return var872E07117C05F1A34EC24B57B694B8E3_785496457;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.782 -0400", hash_original_method = "686D7BF75F67F22DBAC0E1E36B7A58EB", hash_generated_method = "3BC57BE83BF5C3DFEA410713928DFA0A")
    private ArrayList<Cookie> parseCookie(String host, String path,
            String cookieString) {
        addTaint(cookieString.getTaint());
        addTaint(path.getTaint());
        addTaint(host.getTaint());
        ArrayList<Cookie> ret = new ArrayList<Cookie>();
        int index = 0;
        int length = cookieString.length();
        while
(true)        
        {
            Cookie cookie = null;
    if(index < 0 || index >= length)            
            {
                break;
            } //End block
    if(cookieString.charAt(index) == WHITE_SPACE)            
            {
                index++;
                continue;
            } //End block
            int semicolonIndex = cookieString.indexOf(SEMICOLON, index);
            int equalIndex = cookieString.indexOf(EQUAL, index);
            cookie = new Cookie(host, path);
    if((semicolonIndex != -1 && (semicolonIndex < equalIndex)) ||
                    equalIndex == -1)            
            {
    if(semicolonIndex == -1)                
                {
                    semicolonIndex = length;
                } //End block
                cookie.name = cookieString.substring(index, semicolonIndex);
                cookie.value = null;
            } //End block
            else
            {
                cookie.name = cookieString.substring(index, equalIndex);
    if((equalIndex < length - 1) &&
                        (cookieString.charAt(equalIndex + 1) == QUOTATION))                
                {
                    index = cookieString.indexOf(QUOTATION, equalIndex + 2);
    if(index == -1)                    
                    {
                        break;
                    } //End block
                } //End block
                semicolonIndex = cookieString.indexOf(SEMICOLON, index);
    if(semicolonIndex == -1)                
                {
                    semicolonIndex = length;
                } //End block
    if(semicolonIndex - equalIndex > MAX_COOKIE_LENGTH)                
                {
                    cookie.value = cookieString.substring(equalIndex + 1,
                            equalIndex + 1 + MAX_COOKIE_LENGTH);
                } //End block
                else
    if(equalIndex + 1 == semicolonIndex
                        || semicolonIndex < equalIndex)                
                {
                    cookie.value = "";
                } //End block
                else
                {
                    cookie.value = cookieString.substring(equalIndex + 1,
                            semicolonIndex);
                } //End block
            } //End block
            index = semicolonIndex;
            while
(true)            
            {
    if(index < 0 || index >= length)                
                {
                    break;
                } //End block
    if(cookieString.charAt(index) == WHITE_SPACE
                        || cookieString.charAt(index) == SEMICOLON)                
                {
                    index++;
                    continue;
                } //End block
    if(cookieString.charAt(index) == COMMA)                
                {
                    index++;
                    break;
                } //End block
    if(length - index >= SECURE_LENGTH
                        && cookieString.substring(index, index + SECURE_LENGTH).
                        equalsIgnoreCase(SECURE))                
                {
                    index += SECURE_LENGTH;
                    cookie.secure = true;
    if(index == length)                    
                    break;
    if(cookieString.charAt(index) == EQUAL)                    
                    index++;
                    continue;
                } //End block
    if(length - index >= HTTP_ONLY_LENGTH
                        && cookieString.substring(index,
                            index + HTTP_ONLY_LENGTH).
                        equalsIgnoreCase(HTTP_ONLY))                
                {
                    index += HTTP_ONLY_LENGTH;
    if(index == length)                    
                    break;
    if(cookieString.charAt(index) == EQUAL)                    
                    index++;
                    continue;
                } //End block
                equalIndex = cookieString.indexOf(EQUAL, index);
    if(equalIndex > 0)                
                {
                    String name = cookieString.substring(index, equalIndex).toLowerCase();
                    int valueIndex = equalIndex + 1;
                    while
(valueIndex < length && cookieString.charAt(valueIndex) == WHITE_SPACE)                    
                    {
                        valueIndex++;
                    } //End block
    if(name.equals(EXPIRES))                    
                    {
                        int comaIndex = cookieString.indexOf(COMMA, equalIndex);
    if((comaIndex != -1) &&
                                (comaIndex - valueIndex <= 10))                        
                        {
                            index = comaIndex + 1;
                        } //End block
                    } //End block
                    semicolonIndex = cookieString.indexOf(SEMICOLON, index);
                    int commaIndex = cookieString.indexOf(COMMA, index);
    if(semicolonIndex == -1 && commaIndex == -1)                    
                    {
                        index = length;
                    } //End block
                    else
    if(semicolonIndex == -1)                    
                    {
                        index = commaIndex;
                    } //End block
                    else
    if(commaIndex == -1)                    
                    {
                        index = semicolonIndex;
                    } //End block
                    else
                    {
                        index = Math.min(semicolonIndex, commaIndex);
                    } //End block
                    String value = cookieString.substring(valueIndex, index);
    if(value.length() > 2 && value.charAt(0) == QUOTATION)                    
                    {
                        int endQuote = value.indexOf(QUOTATION, 1);
    if(endQuote > 0)                        
                        {
                            value = value.substring(1, endQuote);
                        } //End block
                    } //End block
    if(name.equals(EXPIRES))                    
                    {
                        try 
                        {
                            cookie.expires = AndroidHttpClient.parseDate(value);
                        } //End block
                        catch (IllegalArgumentException ex)
                        {
                        } //End block
                    } //End block
                    else
    if(name.equals(MAX_AGE))                    
                    {
                        try 
                        {
                            cookie.expires = System.currentTimeMillis() + 1000
                                    * Long.parseLong(value);
                        } //End block
                        catch (NumberFormatException ex)
                        {
                        } //End block
                    } //End block
                    else
    if(name.equals(PATH))                    
                    {
    if(value.length() > 0)                        
                        {
                            cookie.path = value;
                        } //End block
                    } //End block
                    else
    if(name.equals(DOMAIN))                    
                    {
                        int lastPeriod = value.lastIndexOf(PERIOD);
    if(lastPeriod == 0)                        
                        {
                            cookie.domain = null;
                            continue;
                        } //End block
                        try 
                        {
                            Integer.parseInt(value.substring(lastPeriod + 1));
    if(!value.equals(host))                            
                            {
                                cookie.domain = null;
                            } //End block
                            continue;
                        } //End block
                        catch (NumberFormatException ex)
                        {
                        } //End block
                        value = value.toLowerCase();
    if(value.charAt(0) != PERIOD)                        
                        {
                            value = PERIOD + value;
                            lastPeriod++;
                        } //End block
    if(host.endsWith(value.substring(1)))                        
                        {
                            int len = value.length();
                            int hostLen = host.length();
    if(hostLen > (len - 1)
                                    && host.charAt(hostLen - len) != PERIOD)                            
                            {
                                cookie.domain = null;
                                continue;
                            } //End block
    if((len == lastPeriod + 3)
                                    && (len >= 6 && len <= 8))                            
                            {
                                String s = value.substring(1, lastPeriod);
    if(Arrays.binarySearch(BAD_COUNTRY_2LDS, s) >= 0)                                
                                {
                                    cookie.domain = null;
                                    continue;
                                } //End block
                            } //End block
                            cookie.domain = value;
                        } //End block
                        else
                        {
                            cookie.domain = null;
                        } //End block
                    } //End block
                } //End block
                else
                {
                    index = length;
                } //End block
            } //End block
    if(cookie != null && cookie.domain != null)            
            {
                ret.add(cookie);
            } //End block
        } //End block
ArrayList<Cookie> varEDFF4FBBF053B5DC2B444ADFA049EE0F_1442522919 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_1442522919.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1442522919;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeAcceptCookie() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69788974 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69788974;
    }

    
    @DSModeled(DSC.SAFE)
    private static String nativeGetCookie(String url, boolean privateBrowsing) {
        	String s = new String();
        	s.addTaint(url.getTaint());
        	return s;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeHasCookies(boolean privateBrowsing) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281785784 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281785784;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRemoveAllCookie() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRemoveExpiredCookie() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeRemoveSessionCookie() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetAcceptCookie(boolean accept) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetCookie(String url, String value, boolean privateBrowsing) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeFlushCookieStore() {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeAcceptFileSchemeCookies() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842509513 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842509513;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetAcceptFileSchemeCookies(boolean accept) {
    }

    
    static class Cookie {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "AD5F82E879A9C5D6B5B442EB37E50551", hash_generated_field = "B45971700BE10ABC690F6ABCD38C274A")

        String domain;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "79E45F34FE773E697DAD830A242384A5")

        long expires;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "7D892431B152BBFFEDEC812251E45ADD", hash_generated_field = "6AE4DE9DE049C06174725EC4E5976F6D")

        long lastAcessTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "34635AE52863B6F106A6490644A4C5BB", hash_generated_field = "357B404F32323702F25D563FFF0505BF")

        long lastUpdateTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "63DC6869FF37EDAA23661806B080C4ED")

        boolean secure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "E1716F24954CF03C4F874BC683AC0606")

        byte mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_method = "91108A58846CEDD8DA5905902DEE69F4", hash_generated_method = "0337FD9DF266AE2D58305A9F66087523")
          Cookie() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.783 -0400", hash_original_method = "E1F86FD348EBFCA5152C7C5B27A3DCAA", hash_generated_method = "8010E05032C6AA7B338CE8179C520774")
          Cookie(String defaultDomain, String defaultPath) {
            domain = defaultDomain;
            path = defaultPath;
            expires = -1;
            // ---------- Original Method ----------
            //domain = defaultDomain;
            //path = defaultPath;
            //expires = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_method = "78A5F78070F927D77B7E42EE06AFDBC4", hash_generated_method = "BEFE531351020D76CC255D3ED73C9B41")
         boolean exactMatch(Cookie in) {
            addTaint(in.getTaint());
            boolean valuesMatch = !((value == null) ^ (in.value == null));
            boolean varEBD92DB9890DB2A598915E607BEEEBAD_1323653893 = (domain.equals(in.domain) && path.equals(in.path) &&
                    name.equals(in.name) && valuesMatch);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686715149 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_686715149;
            // ---------- Original Method ----------
            //boolean valuesMatch = !((value == null) ^ (in.value == null));
            //return domain.equals(in.domain) && path.equals(in.path) &&
                    //name.equals(in.name) && valuesMatch;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_method = "AE74CD0D7D859A06FEAA31D7F99E4D83", hash_generated_method = "A6F7CCDF798D3B898E82B972FA9E54EB")
         boolean domainMatch(String urlHost) {
            addTaint(urlHost.getTaint());
    if(domain.startsWith("."))            
            {
    if(urlHost.endsWith(domain.substring(1)))                
                {
                    int len = domain.length();
                    int urlLen = urlHost.length();
    if(urlLen > len - 1)                    
                    {
                        boolean var7F040CFFB39F147413F4D230F7D31224_1607320873 = (urlHost.charAt(urlLen - len) == PERIOD);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660772152 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660772152;
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_980530694 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666699439 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_666699439;
                } //End block
                boolean var68934A3E9455FA72420237EB05902327_99391946 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1454978548 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1454978548;
            } //End block
            else
            {
                boolean var50CE1E37988004E04494AA05F0E6D7E0_1713882891 = (urlHost.equals(domain));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651415762 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651415762;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_method = "0FD43CB7A1B51508534ED8D9F7B624E8", hash_generated_method = "2EC7D3040C25BA9847E204454D387F61")
         boolean pathMatch(String urlPath) {
            addTaint(urlPath.getTaint());
    if(urlPath.startsWith(path))            
            {
                int len = path.length();
    if(len == 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1835340524 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585159992 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585159992;
                } //End block
                int urlLen = urlPath.length();
    if(path.charAt(len-1) != PATH_DELIM && urlLen > len)                
                {
                    boolean var198C0DA975F6F5AE12CF132B8EBCACF8_384629421 = (urlPath.charAt(len) == PATH_DELIM);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400942959 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_400942959;
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1226873342 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363162400 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_363162400;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_295570589 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196184592 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_196184592;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_method = "08415E5687C0C693DFF8536ADAD3E2AA", hash_generated_method = "FD9A3B3D64885FC91AFDAE751F6FCE50")
        public String toString() {
String var350011719E9D74BBEF287BFDF99EFDD8_378391513 =             "domain: " + domain + "; path: " + path + "; name: " + name
                    + "; value: " + value;
            var350011719E9D74BBEF287BFDF99EFDD8_378391513.addTaint(taint);
            return var350011719E9D74BBEF287BFDF99EFDD8_378391513;
            // ---------- Original Method ----------
            //return "domain: " + domain + "; path: " + path + "; name: " + name
                    //+ "; value: " + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_field = "1373AC0A3E23F4267D6303E56EFA672F", hash_generated_field = "58722C253669E0810A7E8B6D3908054B")

        static final byte MODE_NEW = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_field = "9F763DB46A48E5315C1E1EDC1CA5635F", hash_generated_field = "BC0224E6D81C7EF3B83B8B7EFE2FE5E3")

        static final byte MODE_NORMAL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_field = "AA5825DEFAEA0E34C79E13FF3E565114", hash_generated_field = "94113342DF84F1B38CF08AE47B6FF64D")

        static final byte MODE_DELETED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_field = "05F4B5C57DFBFFCD0E4F92EAC31EFECE", hash_generated_field = "CD378DA107C809D64EE250CC5FAF59F0")

        static final byte MODE_REPLACED = 3;
    }


    
    private static final class CookieComparator implements Comparator<Cookie> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.784 -0400", hash_original_method = "EA07F3AA36DD3B1C5469CE7D110356B0", hash_generated_method = "EA07F3AA36DD3B1C5469CE7D110356B0")
        public CookieComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_method = "2F959C67E8DDB6BD10BD3460D506EDBA", hash_generated_method = "394E14234D1993CB30AC6DDE30AA2218")
        public int compare(Cookie cookie1, Cookie cookie2) {
            addTaint(cookie2.getTaint());
            addTaint(cookie1.getTaint());
            int diff = cookie2.path.length() - cookie1.path.length();
    if(diff != 0)            
            {
            int var2D2DEE7AF60385A060EAE7F556845A8B_374698147 = (diff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671643938 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671643938;
            }
            diff = cookie2.domain.length() - cookie1.domain.length();
    if(diff != 0)            
            {
            int var2D2DEE7AF60385A060EAE7F556845A8B_896645102 = (diff);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172474762 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_172474762;
            }
    if(cookie2.value == null)            
            {
    if(cookie1.value != null)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_481111414 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045676423 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1045676423;
                } //End block
            } //End block
            else
    if(cookie1.value == null)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1988943751 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1239497054 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1239497054;
            } //End block
            int varC9641A8BBE5000FAE8F810E0F8D51C9B_517135551 = (cookie1.name.compareTo(cookie2.name));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042278080 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042278080;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "E6BA83C33E70ACF527403866BBE81365", hash_generated_field = "F3E12733AF62A9958A559C9B68C05600")

    private static CookieManager sRef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "419533E410B7DE0CC9F5934C3A2D19C5", hash_generated_field = "5430298A9897B69B0A98E2CC4D81D311")

    private static final String DOMAIN = "domain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "C9FFF77EC130ACB59E8320718C687E06", hash_generated_field = "487DA3D0E0435A01D919AD07E7109D33")

    private static final String PATH = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "899162B90BDD687F90078C4CDC23D4AA", hash_generated_field = "066A210975164BE5260662AAE6EB4D7C")

    private static final String EXPIRES = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "CADF62F6B9B615DBFC4A91AB2470A969", hash_generated_field = "854A2BF9C58B1D456228AC3164C91937")

    private static final String SECURE = "secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "2D4FDC7F9F47E8939FD8E883ADA3143E", hash_generated_field = "17FDE42B196035B579C4AE0481D84D7C")

    private static final String MAX_AGE = "max-age";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "AB306205B084AA7306512423EA8A4F37", hash_generated_field = "8B75A58E3869C3DA24B83475B2775E3B")

    private static final String HTTP_ONLY = "httponly";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "B4503B87E0F867CC16DA4DA30EFB1B4E", hash_generated_field = "6FC6F50ECB134EEDF902652D4FB1FA39")

    private static final String HTTPS = "https";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "3086B699DF6C21833EC8465ABB1D5EDE", hash_generated_field = "5A20D569DC0501B46372E384E70DCE74")

    private static final char PERIOD = '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "6699AC2D718BB4662AD28663BE3D755B", hash_generated_field = "E7AE80758443AFBC3D01DB1788C8C0D3")

    private static final char COMMA = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "D943B9D72E9E95DF1EF616456AC4F309", hash_generated_field = "4358BD4872C7B54C285E161294F74EAE")

    private static final char SEMICOLON = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "78AD75A262DFBD4281DB52940BC918B7", hash_generated_field = "340B33BC049413F4F0AFE836879E9796")

    private static final char EQUAL = '=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "F94280598CD8F530D9DBDE0BB1C7CD08", hash_generated_field = "C33C95C10EDB14BB946C605F87F0993F")

    private static final char PATH_DELIM = '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "357120CD258B53E76605EEAE5416C9E1", hash_generated_field = "1712D6DC544FB52547AA3F9EFF9A0265")

    private static final char QUESTION_MARK = '?';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "E740A1049DEFC7A54C45F361F5359873", hash_generated_field = "A797569C73AC5864E7DB653CB9E83AD5")

    private static final char WHITE_SPACE = ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "A19CF4D2A809874EAEB72E6329B2E2E7", hash_generated_field = "EE4E21B4CF81F5D51BBD3F71550541EA")

    private static final char QUOTATION = '\"';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "6E9F518585624ED7D2970848AC7295EB", hash_generated_field = "961A1ADB46113FB181B555DA4F33FEF9")

    private static final int SECURE_LENGTH = SECURE.length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.785 -0400", hash_original_field = "18288EFA26CFF3B6879ECC3C3442CD56", hash_generated_field = "FA80D5C271D5DC9600F2ED7151FE4E42")

    private static final int HTTP_ONLY_LENGTH = HTTP_ONLY.length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "A06622DE12BE98909AA145AB6E7296F1", hash_generated_field = "DDFF82DC777498CEEC17430F3F2218D5")

    private static final int MAX_COOKIE_LENGTH = 4 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "CE4EFB8A8F2B82EBBDF7D0D24ED77D75", hash_generated_field = "988CE43ABC85AAF1E21A0369A3CF3E1D")

    private static final int MAX_COOKIE_COUNT_PER_BASE_DOMAIN = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "A3454E54AB97537D29472E7494E77F4A", hash_generated_field = "7D7E1A712A3654F480A074BC90220E37")

    private static final int MAX_DOMAIN_COUNT = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "7538240BC29EFCD49CC35AF219A38F74", hash_generated_field = "E2CAA1BE5E9E81CFA3F064A7AEC4E8A8")

    private static final int MAX_RAM_COOKIES_COUNT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "0B6C4B4D8968CF7C7D47B287812753E8", hash_generated_field = "88188D2D99FE8F90CB26B5E79B041F22")

    private static final int MAX_RAM_DOMAIN_COUNT = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "6968AEDC2C31A50F6ADB7A7EFEF7EBAD")

    private final static String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.786 -0400", hash_original_field = "369E0B214F297D12A5AB6D68DE5A8F0F", hash_generated_field = "EF91073A1DCAEA8DA1E091E70D6320E1")

    private static final CookieComparator COMPARATOR = new CookieComparator();
}

