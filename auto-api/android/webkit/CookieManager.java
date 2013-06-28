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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.326 -0400", hash_original_field = "33B8F6A3D163A5424381884F05DEEE3C", hash_generated_field = "FBED18CAF24013DA0D8FA265CFF0028E")

    private Map<String, ArrayList<Cookie>> mCookieMap = new LinkedHashMap
            <String, ArrayList<Cookie>>(MAX_DOMAIN_COUNT, 0.75f, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.326 -0400", hash_original_field = "4C8CE05AB6E764DAAAEA4703562B22CB", hash_generated_field = "EA988CB62FE4EFBF1E2849AAB3DDD6B9")

    private boolean mAcceptCookie = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.326 -0400", hash_original_field = "9AB401A6E848CD08C3892BEAD196B99B", hash_generated_field = "E7DA179CDB1C423BB7FF952CDAC068A2")

    private int pendingCookieOperations = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.327 -0400", hash_original_method = "D1B429C0ADFDAAD2AA9A34491D464202", hash_generated_method = "7E9E6C54D01E5F13F7A4CCB58B878A0F")
    private  CookieManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.327 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "485516C5E5A309F67F3624B095CDFF25")
    protected Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException("doesn't implement Cloneable");
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    
    public static synchronized CookieManager getInstance() {
        if (sRef == null) {
            sRef = new CookieManager();
        }
        return sRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.328 -0400", hash_original_method = "0044CC48946D988BAC3F9C31DC5ECF6E", hash_generated_method = "76D823D5CA8360461CDF5C8015802AA8")
    public synchronized void setAcceptCookie(boolean accept) {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1818593435 = (JniUtil.useChromiumHttpStack());
            {
                nativeSetAcceptCookie(accept);
            } //End block
        } //End collapsed parenthetic
        mAcceptCookie = accept;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //nativeSetAcceptCookie(accept);
            //return;
        //}
        //mAcceptCookie = accept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.328 -0400", hash_original_method = "EAEA6182C3DE8E7E3FA46C84A2197DA5", hash_generated_method = "C9CC0B6433DE95497D691B2726D89E4D")
    public synchronized boolean acceptCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1589689784 = (JniUtil.useChromiumHttpStack());
            {
                boolean var7A32826552223CCBC1277BE3318866F8_1218323380 = (nativeAcceptCookie());
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501663062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501663062;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return nativeAcceptCookie();
        //}
        //return mAcceptCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.328 -0400", hash_original_method = "3C733C3F28B1C91BBFDBB065F4DCBFE1", hash_generated_method = "C393BA430BA76EA586202A104F33ABBB")
    public void setCookie(String url, String value) {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1774041081 = (JniUtil.useChromiumHttpStack());
            {
                setCookie(url, value, false);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri = null;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        { }
        setCookie(uri, value);
        addTaint(url.getTaint());
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.329 -0400", hash_original_method = "FD6DC9D8EE462ADB809067B2E36820B1", hash_generated_method = "EA7AB975A2C8211500BF3856CD90576D")
    public void setCookie(String url, String value, boolean privateBrowsing) {
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_1940015526 = (!JniUtil.useChromiumHttpStack());
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
        { return; }
        nativeSetCookie(uri.toString(), value, privateBrowsing);
        addTaint(url.getTaint());
        addTaint(value.getTaint());
        addTaint(privateBrowsing);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.331 -0400", hash_original_method = "8AF5CC468B90A5A42A5116E5B0AA2987", hash_generated_method = "2D6F427F6B24154FB9910AF2C8BB0CF8")
    public synchronized void setCookie(WebAddress uri, String value) {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1579583878 = (JniUtil.useChromiumHttpStack());
            {
                nativeSetCookie(uri.toString(), value, false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF464C5570B08564435F758B79DFFB796_549183055 = (value != null && value.length() > MAX_COOKIE_LENGTH);
        } //End collapsed parenthetic
        String[] hostAndPath = getHostAndPath(uri);
        {
            boolean var4CD0D0571ACF6B1371CB0FD67E9488E5_420607116 = (hostAndPath[1].length() > 1);
            {
                int index = hostAndPath[1].lastIndexOf(PATH_DELIM);
                hostAndPath[1] = hostAndPath[1].substring(0, 
                    index > 0 ? index : index + 1);
            } //End block
        } //End collapsed parenthetic
        ArrayList<Cookie> cookies = null;
        try 
        {
            cookies = parseCookie(hostAndPath[0], hostAndPath[1], value);
        } //End block
        catch (RuntimeException ex)
        { }
        {
            boolean var639B145A70887FECCC495043A3AE58E5_2109920704 = (cookies == null || cookies.size() == 0);
        } //End collapsed parenthetic
        String baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
        {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        } //End block
        long now = System.currentTimeMillis();
        int size = cookies.size();
        {
            int i = 0;
            {
                Cookie cookie = cookies.get(i);
                boolean done = false;
                Iterator<Cookie> iter = cookieList.iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_840166645 = (iter.hasNext());
                    {
                        Cookie cookieEntry = iter.next();
                        {
                            boolean varAB7EC59C572994F733235AA847DF6EAC_588299496 = (cookie.exactMatch(cookieEntry));
                            {
                                {
                                    {
                                        boolean var0B3911FB1DADB1C34E5C5499C7BBE8E8_405541957 = (!cookieEntry.secure || HTTPS.equals(uri.getScheme()));
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
                        boolean varA821449DF18F0433C732BA9E8F4FCABD_949709022 = (cookieList.size() > MAX_COOKIE_COUNT_PER_BASE_DOMAIN);
                        {
                            Cookie toDelete = new Cookie();
                            toDelete.lastAcessTime = now;
                            Iterator<Cookie> iter2 = cookieList.iterator();
                            {
                                boolean varF0EFB9A964C064E456621406FBF6CA8A_226375619 = (iter2.hasNext());
                                {
                                    Cookie cookieEntry2 = iter2.next();
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
        addTaint(uri.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.332 -0400", hash_original_method = "CFFC2606C8B97641601C2B54714068BC", hash_generated_method = "2A4A387CCC655F27EB6F944CF8C1156E")
    public String getCookie(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1489391904 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1831573257 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1388646436 = null; //Variable for return #3
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_962686201 = (JniUtil.useChromiumHttpStack());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1489391904 = getCookie(url, false);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri = null;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1831573257 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1388646436 = getCookie(uri);
        addTaint(url.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1992456544; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1992456544 = varB4EAC82CA7396A68D541C85D26508E83_1489391904;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1992456544 = varB4EAC82CA7396A68D541C85D26508E83_1831573257;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1992456544 = varB4EAC82CA7396A68D541C85D26508E83_1388646436;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1992456544.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1992456544;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.332 -0400", hash_original_method = "5ACC35EE5D78B03ACC91967E6F456E58", hash_generated_method = "60331A4C503BC7AD6BB8B060FC5DB4FB")
    public String getCookie(String url, boolean privateBrowsing) {
        String varB4EAC82CA7396A68D541C85D26508E83_410582073 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1931050294 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_95345666 = null; //Variable for return #3
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_493522644 = (!JniUtil.useChromiumHttpStack());
            {
                varB4EAC82CA7396A68D541C85D26508E83_410582073 = getCookie(url);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri = null;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1931050294 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_95345666 = nativeGetCookie(uri.toString(), privateBrowsing);
        addTaint(url.getTaint());
        addTaint(privateBrowsing);
        String varA7E53CE21691AB073D9660D615818899_1687302162; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1687302162 = varB4EAC82CA7396A68D541C85D26508E83_410582073;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1687302162 = varB4EAC82CA7396A68D541C85D26508E83_1931050294;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1687302162 = varB4EAC82CA7396A68D541C85D26508E83_95345666;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1687302162.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1687302162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.334 -0400", hash_original_method = "BE3F143473537E9CE993D89B685428CF", hash_generated_method = "2919582E026D50B8B6D00EBAC46D7FD0")
    public synchronized String getCookie(WebAddress uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1310710554 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_482470672 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_994632699 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1105672333 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1042643477 = null; //Variable for return #5
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_963683872 = (JniUtil.useChromiumHttpStack());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1310710554 = nativeGetCookie(uri.toString(), false);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_482470672 = null;
        } //End block
        String[] hostAndPath = getHostAndPath(uri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_994632699 = null;
        } //End block
        String baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
        {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        } //End block
        long now = System.currentTimeMillis();
        boolean secure = HTTPS.equals(uri.getScheme());
        Iterator<Cookie> iter = cookieList.iterator();
        SortedSet<Cookie> cookieSet = new TreeSet<Cookie>(COMPARATOR);
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_2066141002 = (iter.hasNext());
            {
                Cookie cookie = iter.next();
                {
                    boolean var81120406E156C6C87A676DABB6BB0054_1330633389 = (cookie.domainMatch(hostAndPath[0]) &&
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
        StringBuilder ret = new StringBuilder(256);
        Iterator<Cookie> setIter = cookieSet.iterator();
        {
            boolean varD75D141127F254DD0E9A96ADF154DF93_1960242877 = (setIter.hasNext());
            {
                Cookie cookie = setIter.next();
                {
                    boolean var1834F7F58970AEB3525D549FD6B87EA4_750611319 = (ret.length() > 0);
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
            boolean var5CF789B206995BB451A167ACD3C23235_1405722750 = (ret.length() > 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1105672333 = ret.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1042643477 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1392702392; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1392702392 = varB4EAC82CA7396A68D541C85D26508E83_1310710554;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1392702392 = varB4EAC82CA7396A68D541C85D26508E83_482470672;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1392702392 = varB4EAC82CA7396A68D541C85D26508E83_994632699;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1392702392 = varB4EAC82CA7396A68D541C85D26508E83_1105672333;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1392702392 = varB4EAC82CA7396A68D541C85D26508E83_1042643477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1392702392.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1392702392;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.334 -0400", hash_original_method = "E5896ED24A303B704C1A851D6E9894DE", hash_generated_method = "7B98E0CEF2ED0C681B8B18F98E262D5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.335 -0400", hash_original_method = "65B0411E3AAD9BA729084C50D7485B13", hash_generated_method = "B7CAADA5C52530BA6D97746E1DE452FA")
    private synchronized void signalCookieOperationsComplete() {
        notify();
        // ---------- Original Method ----------
        //pendingCookieOperations--;
        //assert pendingCookieOperations > -1;
        //notify();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.335 -0400", hash_original_method = "3D00699F37AF6D5720F5926DFEED864B", hash_generated_method = "48E8F9DDFD7E31FC7FD0C53F18A2E40C")
    private synchronized void signalCookieOperationsStart() {
        // ---------- Original Method ----------
        //pendingCookieOperations++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.336 -0400", hash_original_method = "E9CA847999E57130D19A4C553707D595", hash_generated_method = "3075E0E17540D1D09AEA10BAA0EA8239")
    public void removeSessionCookie() {
        signalCookieOperationsStart();
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_3983718 = (JniUtil.useChromiumHttpStack());
            {
                new AsyncTask<Void, Void, Void>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.336 -0400", hash_original_method = "DF560F823BF7C351EEB240AF10E95817", hash_generated_method = "5831163CAECB214436390548D0A80F67")
                    protected Void doInBackground(Void... none) {
                        Void varB4EAC82CA7396A68D541C85D26508E83_817561305 = null; //Variable for return #1
                        nativeRemoveSessionCookie();
                        signalCookieOperationsComplete();
                        varB4EAC82CA7396A68D541C85D26508E83_817561305 = null;
                        addTaint(none[0].getTaint());
                        varB4EAC82CA7396A68D541C85D26508E83_817561305.addTaint(getTaint()); //Add taint from parent
                        return varB4EAC82CA7396A68D541C85D26508E83_817561305;
                        // ---------- Original Method ----------
                        //nativeRemoveSessionCookie();
                        //signalCookieOperationsComplete();
                        //return null;
                    }
}.execute();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.337 -0400", hash_original_method = "E6726E6A7287E971302CDEBC56D91ADA", hash_generated_method = "DF1A3D3BAA8DAB51A2C505A423006254")
    public void removeAllCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_18080270 = (JniUtil.useChromiumHttpStack());
            {
                nativeRemoveAllCookie();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.337 -0400", hash_original_method = "2201D105B8AC0DA82BEBC1DB9FB29AE8", hash_generated_method = "644C8D6A4BE90D5182DF5AD4C58638E7")
    public synchronized boolean hasCookies() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1015674747 = (JniUtil.useChromiumHttpStack());
            {
                boolean var8A47D9F563B217F231C778B81E4E893A_1439996718 = (hasCookies(false));
            } //End block
        } //End collapsed parenthetic
        boolean varA1156B6EC3BF3B16EC8E0EFFFE74477E_510328400 = (CookieSyncManager.getInstance().hasCookies());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_620106917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_620106917;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return hasCookies(false);
        //}
        //return CookieSyncManager.getInstance().hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.338 -0400", hash_original_method = "6C96B3E47AB792BE3053A98B747C02B0", hash_generated_method = "34BFD6B7D66DD70A8BCA4FAF6D873E90")
    public synchronized boolean hasCookies(boolean privateBrowsing) {
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_2066198322 = (!JniUtil.useChromiumHttpStack());
            {
                boolean var0675649B9D327117801A509BA1416818_64491194 = (hasCookies());
            } //End block
        } //End collapsed parenthetic
        boolean var08F9F6B298BF2816AC0F7C70944E7CDA_1085587478 = (nativeHasCookies(privateBrowsing));
        addTaint(privateBrowsing);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613353394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_613353394;
        // ---------- Original Method ----------
        //if (!JniUtil.useChromiumHttpStack()) {
            //return hasCookies();
        //}
        //return nativeHasCookies(privateBrowsing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.338 -0400", hash_original_method = "EBBBDCC80F6ABDA541004A954FD75C00", hash_generated_method = "09405D5A8F32F92BCEABF6265E5BE0A9")
    public void removeExpiredCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_567896982 = (JniUtil.useChromiumHttpStack());
            {
                nativeRemoveExpiredCookie();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.339 -0400", hash_original_method = "6E81366EB3EC21A5D57BD56704F05E83", hash_generated_method = "2AE9B906A19C52793E0455669A9BC5E9")
     void flushCookieStore() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_3653846 = (JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.340 -0400", hash_original_method = "F607692A589F63FF1216167E4F5DA44E", hash_generated_method = "8A8295E1D83B98365F4D2B64C34DA7F6")
    synchronized ArrayList<Cookie> getUpdatedCookiesSince(long last) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1778794560 = null; //Variable for return #1
        ArrayList<Cookie> cookies = new ArrayList<Cookie>();
        Collection<ArrayList<Cookie>> cookieList = mCookieMap.values();
        Iterator<ArrayList<Cookie>> listIter = cookieList.iterator();
        {
            boolean var6418FFD41602BEB1548D9077877E8311_1353831671 = (listIter.hasNext());
            {
                ArrayList<Cookie> list = listIter.next();
                Iterator<Cookie> iter = list.iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_861294438 = (iter.hasNext());
                    {
                        Cookie cookie = iter.next();
                        {
                            cookies.add(cookie);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1778794560 = cookies;
        addTaint(last);
        varB4EAC82CA7396A68D541C85D26508E83_1778794560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1778794560;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.340 -0400", hash_original_method = "EBDE0BAE6A65E045698E84F7289F4664", hash_generated_method = "90112C4BD91C519ABB92E794C896A0EB")
    synchronized void deleteACookie(Cookie cookie) {
        {
            String baseDomain = getBaseDomain(cookie.domain);
            ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
            {
                cookieList.remove(cookie);
                {
                    boolean varB40BC97479C649DE73A4798204316F84_125077289 = (cookieList.isEmpty());
                    {
                        mCookieMap.remove(baseDomain);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(cookie.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.341 -0400", hash_original_method = "23D0913407E37C8868B97CA5EA461217", hash_generated_method = "E870E684A572A3835743B7C29096A760")
    synchronized void syncedACookie(Cookie cookie) {
        cookie.mode = Cookie.MODE_NORMAL;
        addTaint(cookie.getTaint());
        // ---------- Original Method ----------
        //cookie.mode = Cookie.MODE_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.343 -0400", hash_original_method = "37E656A6EDF347445C1655B2E42F538E", hash_generated_method = "D0D0202CD46F987DAC46665B4998BD84")
    synchronized ArrayList<Cookie> deleteLRUDomain() {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1735604353 = null; //Variable for return #1
        int count = 0;
        int byteCount = 0;
        int mapSize = mCookieMap.size();
        {
            Collection<ArrayList<Cookie>> cookieLists = mCookieMap.values();
            Iterator<ArrayList<Cookie>> listIter = cookieLists.iterator();
            {
                boolean var118F3A3E5092CF8856C75A8398E045D3_1113773409 = (listIter.hasNext() && count < MAX_RAM_COOKIES_COUNT);
                {
                    ArrayList<Cookie> list = listIter.next();
                    {
                        Iterator<Cookie> iter = list.iterator();
                        {
                            boolean var923F5D856CBEA3FFF8E45A6435ECCB10_1231398151 = (iter.hasNext() && count < MAX_RAM_COOKIES_COUNT);
                            {
                                Cookie cookie = iter.next();
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
        ArrayList<Cookie> retlist = new ArrayList<Cookie>();
        {
            Object[] domains = mCookieMap.keySet().toArray();
            int toGo = mapSize / 10 + 1;
            {
                String domain = domains[toGo].toString();
                retlist.addAll(mCookieMap.get(domain));
                mCookieMap.remove(domain);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1735604353 = retlist;
        varB4EAC82CA7396A68D541C85D26508E83_1735604353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1735604353;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.344 -0400", hash_original_method = "5193D0EACEE146C23C2F9C98185BC9CF", hash_generated_method = "5FA356BA0EEF6AA35F07FDFD4383C6F9")
    private String[] getHostAndPath(WebAddress uri) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1066740513 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_584433328 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_1375888019 = null; //Variable for return #3
        {
            boolean varB5FF893C44F641B4F7CF23797BB4095A_1524654262 = (uri.getHost() != null && uri.getPath() != null);
            {
                String[] ret = new String[2];
                ret[0] = uri.getHost().toLowerCase();
                ret[1] = uri.getPath();
                int index = ret[0].indexOf(PERIOD);
                {
                    {
                        boolean var7AFAB69A16A288F76D0E2FCFA532519E_258303902 = (uri.getScheme().equalsIgnoreCase("file"));
                        {
                            ret[0] = "localhost";
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varB791FB78F104615FDEB847DBBFA3AAC1_484913411 = (index == ret[0].lastIndexOf(PERIOD));
                    {
                        ret[0] = PERIOD + ret[0];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBF520D714B28C887CB3153C5B5D328FA_1175557709 = (ret[1].charAt(0) != PATH_DELIM);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1066740513 = null;
                    } //End block
                } //End collapsed parenthetic
                index = ret[1].indexOf(QUESTION_MARK);
                {
                    ret[1] = ret[1].substring(0, index);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_584433328 = ret;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1375888019 = null;
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1554538235; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1554538235 = varB4EAC82CA7396A68D541C85D26508E83_1066740513;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1554538235 = varB4EAC82CA7396A68D541C85D26508E83_584433328;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1554538235 = varB4EAC82CA7396A68D541C85D26508E83_1375888019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1554538235.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1554538235;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.345 -0400", hash_original_method = "0BC29AC3055E44155EBF14855C5D487F", hash_generated_method = "4F01DF92278297380F5D8D87B67DC966")
    private String getBaseDomain(String host) {
        String varB4EAC82CA7396A68D541C85D26508E83_1465357665 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_523780621 = null; //Variable for return #2
        int startIndex = 0;
        int nextIndex = host.indexOf(PERIOD);
        int lastIndex = host.lastIndexOf(PERIOD);
        {
            startIndex = nextIndex + 1;
            nextIndex = host.indexOf(PERIOD, startIndex);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1465357665 = host.substring(startIndex);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_523780621 = host;
        } //End block
        addTaint(host.getTaint());
        String varA7E53CE21691AB073D9660D615818899_612917063; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_612917063 = varB4EAC82CA7396A68D541C85D26508E83_1465357665;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_612917063 = varB4EAC82CA7396A68D541C85D26508E83_523780621;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_612917063.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_612917063;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.348 -0400", hash_original_method = "686D7BF75F67F22DBAC0E1E36B7A58EB", hash_generated_method = "39B74C769B7865DB328AE63D768F5393")
    private ArrayList<Cookie> parseCookie(String host, String path,
            String cookieString) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1975461344 = null; //Variable for return #1
        ArrayList<Cookie> ret = new ArrayList<Cookie>();
        int index = 0;
        int length = cookieString.length();
        {
            Cookie cookie = null;
            {
                boolean varE8871F9653319A259571D06172D1AEE8_837995981 = (cookieString.charAt(index) == WHITE_SPACE);
            } //End collapsed parenthetic
            int semicolonIndex = cookieString.indexOf(SEMICOLON, index);
            int equalIndex = cookieString.indexOf(EQUAL, index);
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
                    boolean varEAC5CE96F1515E85A79CC4A57E69EE0C_439438893 = ((equalIndex < length - 1) &&
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
                    boolean varBE5EE8D37CFA74C6E90C8AC330A66127_1065024182 = (cookieString.charAt(index) == WHITE_SPACE
                        || cookieString.charAt(index) == SEMICOLON);
                } //End collapsed parenthetic
                {
                    boolean var59917C993945A4C5AE1ABFE72D45B028_1224530173 = (cookieString.charAt(index) == COMMA);
                } //End collapsed parenthetic
                {
                    boolean varF3A4A21C55D7FF52C4292FA83141D706_2132881109 = (length - index >= SECURE_LENGTH
                        && cookieString.substring(index, index + SECURE_LENGTH).
                        equalsIgnoreCase(SECURE));
                    {
                        index += SECURE_LENGTH;
                        cookie.secure = true;
                        {
                            boolean varC88233FC4DC8EC934257FE2094942F69_1893931561 = (cookieString.charAt(index) == EQUAL);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var1D7438053E6770C42AF1477FD3B63C7B_1487708226 = (length - index >= HTTP_ONLY_LENGTH
                        && cookieString.substring(index,
                            index + HTTP_ONLY_LENGTH).
                        equalsIgnoreCase(HTTP_ONLY));
                    {
                        index += HTTP_ONLY_LENGTH;
                        {
                            boolean varC88233FC4DC8EC934257FE2094942F69_350648450 = (cookieString.charAt(index) == EQUAL);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                equalIndex = cookieString.indexOf(EQUAL, index);
                {
                    String name = cookieString.substring(index, equalIndex).toLowerCase();
                    int valueIndex = equalIndex + 1;
                    {
                        boolean varD1FB05D7CF4103A1B6A2928ACA880533_1645326251 = (valueIndex < length && cookieString.charAt(valueIndex) == WHITE_SPACE);
                    } //End collapsed parenthetic
                    {
                        boolean var7368C0CDE5A76B546A13F21527AC9C2B_1274814444 = (name.equals(EXPIRES));
                        {
                            int comaIndex = cookieString.indexOf(COMMA, equalIndex);
                            {
                                index = comaIndex + 1;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    semicolonIndex = cookieString.indexOf(SEMICOLON, index);
                    int commaIndex = cookieString.indexOf(COMMA, index);
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
                    String value = cookieString.substring(valueIndex, index);
                    {
                        boolean varF3B26F622B3BA344243C3452C5EAD85F_979108272 = (value.length() > 2 && value.charAt(0) == QUOTATION);
                        {
                            int endQuote = value.indexOf(QUOTATION, 1);
                            {
                                value = value.substring(1, endQuote);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var7368C0CDE5A76B546A13F21527AC9C2B_1007744649 = (name.equals(EXPIRES));
                        {
                            try 
                            {
                                cookie.expires = AndroidHttpClient.parseDate(value);
                            } //End block
                            catch (IllegalArgumentException ex)
                            { }
                        } //End block
                        {
                            boolean var6564460B5C30271EE1EFF78DDBB789FB_802532391 = (name.equals(MAX_AGE));
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
                                boolean var0A9AF45F54D476ACC0274E0E6DAC2FA0_1735046441 = (name.equals(PATH));
                                {
                                    {
                                        boolean var0E83E73D0EFF9C33CBD153EB762D02A2_1150459580 = (value.length() > 0);
                                        {
                                            cookie.path = value;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varF74E07688049599069565E410921F574_1640526725 = (name.equals(DOMAIN));
                                    {
                                        int lastPeriod = value.lastIndexOf(PERIOD);
                                        {
                                            cookie.domain = null;
                                        } //End block
                                        try 
                                        {
                                            Integer.parseInt(value.substring(lastPeriod + 1));
                                            {
                                                boolean varE1CD484A077BCDA29486EAC1AD09FE74_1299867402 = (!value.equals(host));
                                                {
                                                    cookie.domain = null;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        catch (NumberFormatException ex)
                                        { }
                                        value = value.toLowerCase();
                                        {
                                            boolean varE2B53F95599A2D49216C544D11EF4ECC_2121431251 = (value.charAt(0) != PERIOD);
                                            {
                                                value = PERIOD + value;
                                            } //End block
                                        } //End collapsed parenthetic
                                        {
                                            boolean var10024EBAA7EEAAC0A256BE84E1366563_117349691 = (host.endsWith(value.substring(1)));
                                            {
                                                int len = value.length();
                                                int hostLen = host.length();
                                                {
                                                    boolean var0CE4FFED329EAEC88D1A8448E0EC8E7E_377187895 = (hostLen > (len - 1)
                                    && host.charAt(hostLen - len) != PERIOD);
                                                    {
                                                        cookie.domain = null;
                                                    } //End block
                                                } //End collapsed parenthetic
                                                {
                                                    String s = value.substring(1, lastPeriod);
                                                    {
                                                        boolean var6C41572AF3F94E5C989F9F99887AAEBD_1514473709 = (Arrays.binarySearch(BAD_COUNTRY_2LDS, s) >= 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1975461344 = ret;
        addTaint(host.getTaint());
        addTaint(path.getTaint());
        addTaint(cookieString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1975461344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1975461344;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean nativeAcceptCookie() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69788974 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69788974;
    }

    
        private static String nativeGetCookie(String url, boolean privateBrowsing) {
        	String s = new String();
        	s.addTaint(url.getTaint());
        	return s;
    }

    
        private static boolean nativeHasCookies(boolean privateBrowsing) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281785784 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_281785784;
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
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842509513 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842509513;
    }

    
        private static void nativeSetAcceptFileSchemeCookies(boolean accept) {
    }

    
    static class Cookie {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "AD5F82E879A9C5D6B5B442EB37E50551", hash_generated_field = "B45971700BE10ABC690F6ABCD38C274A")

        String domain;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "79E45F34FE773E697DAD830A242384A5")

        long expires;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "7D892431B152BBFFEDEC812251E45ADD", hash_generated_field = "6AE4DE9DE049C06174725EC4E5976F6D")

        long lastAcessTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "34635AE52863B6F106A6490644A4C5BB", hash_generated_field = "357B404F32323702F25D563FFF0505BF")

        long lastUpdateTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "63DC6869FF37EDAA23661806B080C4ED")

        boolean secure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.353 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "E1716F24954CF03C4F874BC683AC0606")

        byte mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.354 -0400", hash_original_method = "91108A58846CEDD8DA5905902DEE69F4", hash_generated_method = "0337FD9DF266AE2D58305A9F66087523")
          Cookie() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.354 -0400", hash_original_method = "E1F86FD348EBFCA5152C7C5B27A3DCAA", hash_generated_method = "8010E05032C6AA7B338CE8179C520774")
          Cookie(String defaultDomain, String defaultPath) {
            domain = defaultDomain;
            path = defaultPath;
            expires = -1;
            // ---------- Original Method ----------
            //domain = defaultDomain;
            //path = defaultPath;
            //expires = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.357 -0400", hash_original_method = "78A5F78070F927D77B7E42EE06AFDBC4", hash_generated_method = "8B560225DABF0B375307C12910B0299F")
         boolean exactMatch(Cookie in) {
            boolean valuesMatch = !((value == null) ^ (in.value == null));
            boolean varB760F3D14A317E9E1240F1DD0EB08AC9_806219954 = (domain.equals(in.domain) && path.equals(in.path) &&
                    name.equals(in.name) && valuesMatch);
            addTaint(in.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879266888 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_879266888;
            // ---------- Original Method ----------
            //boolean valuesMatch = !((value == null) ^ (in.value == null));
            //return domain.equals(in.domain) && path.equals(in.path) &&
                    //name.equals(in.name) && valuesMatch;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.357 -0400", hash_original_method = "AE74CD0D7D859A06FEAA31D7F99E4D83", hash_generated_method = "A68A3A746E93463DAB2F15334124592D")
         boolean domainMatch(String urlHost) {
            {
                boolean var1AA47E915A9A7BE21086DD3D0BA11DC5_1168570929 = (domain.startsWith("."));
                {
                    {
                        boolean varD1AD2EF5FF384B0F8B31A949A9373BE8_1352003061 = (urlHost.endsWith(domain.substring(1)));
                        {
                            int len = domain.length();
                            int urlLen = urlHost.length();
                            {
                                boolean var0474A224C63EE86B2A0F82273C401629_119736022 = (urlHost.charAt(urlLen - len) == PERIOD);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var92CC2FDDED6B31734455343B1116D0F1_2000141609 = (urlHost.equals(domain));
                } //End block
            } //End collapsed parenthetic
            addTaint(urlHost.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_740734510 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_740734510;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.358 -0400", hash_original_method = "0FD43CB7A1B51508534ED8D9F7B624E8", hash_generated_method = "9110BA6A1119ED1C76B9C9ECE1EBDFB5")
         boolean pathMatch(String urlPath) {
            {
                boolean var6B3ADCF616A86BAB477653B4B7C748B5_851511925 = (urlPath.startsWith(path));
                {
                    int len = path.length();
                    int urlLen = urlPath.length();
                    {
                        boolean var652449ECDCA9F03141F3688013BBBCE1_1556679846 = (path.charAt(len-1) != PATH_DELIM && urlLen > len);
                        {
                            boolean var0556DC25417548B062FF41011508D659_1822417620 = (urlPath.charAt(len) == PATH_DELIM);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(urlPath.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254132644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_254132644;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.359 -0400", hash_original_method = "08415E5687C0C693DFF8536ADAD3E2AA", hash_generated_method = "4B079B01994B961C935F884FB0A83EE0")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1754047897 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1754047897 = "domain: " + domain + "; path: " + path + "; name: " + name
                    + "; value: " + value;
            varB4EAC82CA7396A68D541C85D26508E83_1754047897.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1754047897;
            // ---------- Original Method ----------
            //return "domain: " + domain + "; path: " + path + "; name: " + name
                    //+ "; value: " + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.359 -0400", hash_original_field = "1373AC0A3E23F4267D6303E56EFA672F", hash_generated_field = "58722C253669E0810A7E8B6D3908054B")

        static final byte MODE_NEW = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.359 -0400", hash_original_field = "9F763DB46A48E5315C1E1EDC1CA5635F", hash_generated_field = "BC0224E6D81C7EF3B83B8B7EFE2FE5E3")

        static final byte MODE_NORMAL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.359 -0400", hash_original_field = "AA5825DEFAEA0E34C79E13FF3E565114", hash_generated_field = "94113342DF84F1B38CF08AE47B6FF64D")

        static final byte MODE_DELETED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.359 -0400", hash_original_field = "05F4B5C57DFBFFCD0E4F92EAC31EFECE", hash_generated_field = "CD378DA107C809D64EE250CC5FAF59F0")

        static final byte MODE_REPLACED = 3;
    }


    
    private static final class CookieComparator implements Comparator<Cookie> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.359 -0400", hash_original_method = "EA07F3AA36DD3B1C5469CE7D110356B0", hash_generated_method = "EA07F3AA36DD3B1C5469CE7D110356B0")
        public CookieComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_method = "2F959C67E8DDB6BD10BD3460D506EDBA", hash_generated_method = "76FA820C63DEA3E7BBE9583F2CED10AF")
        public int compare(Cookie cookie1, Cookie cookie2) {
            int diff = cookie2.path.length() - cookie1.path.length();
            diff = cookie2.domain.length() - cookie1.domain.length();
            int varF72DD66A04AAB93721C41E4DC4180D39_192476468 = (cookie1.name.compareTo(cookie2.name));
            addTaint(cookie1.getTaint());
            addTaint(cookie2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814568922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814568922;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "E6BA83C33E70ACF527403866BBE81365", hash_generated_field = "F3E12733AF62A9958A559C9B68C05600")

    private static CookieManager sRef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "419533E410B7DE0CC9F5934C3A2D19C5", hash_generated_field = "5430298A9897B69B0A98E2CC4D81D311")

    private static final String DOMAIN = "domain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "C9FFF77EC130ACB59E8320718C687E06", hash_generated_field = "487DA3D0E0435A01D919AD07E7109D33")

    private static final String PATH = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "899162B90BDD687F90078C4CDC23D4AA", hash_generated_field = "066A210975164BE5260662AAE6EB4D7C")

    private static final String EXPIRES = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "CADF62F6B9B615DBFC4A91AB2470A969", hash_generated_field = "854A2BF9C58B1D456228AC3164C91937")

    private static final String SECURE = "secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "2D4FDC7F9F47E8939FD8E883ADA3143E", hash_generated_field = "17FDE42B196035B579C4AE0481D84D7C")

    private static final String MAX_AGE = "max-age";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "AB306205B084AA7306512423EA8A4F37", hash_generated_field = "8B75A58E3869C3DA24B83475B2775E3B")

    private static final String HTTP_ONLY = "httponly";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "B4503B87E0F867CC16DA4DA30EFB1B4E", hash_generated_field = "6FC6F50ECB134EEDF902652D4FB1FA39")

    private static final String HTTPS = "https";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "3086B699DF6C21833EC8465ABB1D5EDE", hash_generated_field = "5A20D569DC0501B46372E384E70DCE74")

    private static final char PERIOD = '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "6699AC2D718BB4662AD28663BE3D755B", hash_generated_field = "E7AE80758443AFBC3D01DB1788C8C0D3")

    private static final char COMMA = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "D943B9D72E9E95DF1EF616456AC4F309", hash_generated_field = "4358BD4872C7B54C285E161294F74EAE")

    private static final char SEMICOLON = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "78AD75A262DFBD4281DB52940BC918B7", hash_generated_field = "340B33BC049413F4F0AFE836879E9796")

    private static final char EQUAL = '=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "F94280598CD8F530D9DBDE0BB1C7CD08", hash_generated_field = "C33C95C10EDB14BB946C605F87F0993F")

    private static final char PATH_DELIM = '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "357120CD258B53E76605EEAE5416C9E1", hash_generated_field = "1712D6DC544FB52547AA3F9EFF9A0265")

    private static final char QUESTION_MARK = '?';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "E740A1049DEFC7A54C45F361F5359873", hash_generated_field = "A797569C73AC5864E7DB653CB9E83AD5")

    private static final char WHITE_SPACE = ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "A19CF4D2A809874EAEB72E6329B2E2E7", hash_generated_field = "EE4E21B4CF81F5D51BBD3F71550541EA")

    private static final char QUOTATION = '\"';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "6E9F518585624ED7D2970848AC7295EB", hash_generated_field = "961A1ADB46113FB181B555DA4F33FEF9")

    private static final int SECURE_LENGTH = SECURE.length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "18288EFA26CFF3B6879ECC3C3442CD56", hash_generated_field = "FA80D5C271D5DC9600F2ED7151FE4E42")

    private static final int HTTP_ONLY_LENGTH = HTTP_ONLY.length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "A06622DE12BE98909AA145AB6E7296F1", hash_generated_field = "DDFF82DC777498CEEC17430F3F2218D5")

    private static final int MAX_COOKIE_LENGTH = 4 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "CE4EFB8A8F2B82EBBDF7D0D24ED77D75", hash_generated_field = "988CE43ABC85AAF1E21A0369A3CF3E1D")

    private static final int MAX_COOKIE_COUNT_PER_BASE_DOMAIN = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "A3454E54AB97537D29472E7494E77F4A", hash_generated_field = "7D7E1A712A3654F480A074BC90220E37")

    private static final int MAX_DOMAIN_COUNT = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.360 -0400", hash_original_field = "7538240BC29EFCD49CC35AF219A38F74", hash_generated_field = "E2CAA1BE5E9E81CFA3F064A7AEC4E8A8")

    private static final int MAX_RAM_COOKIES_COUNT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.361 -0400", hash_original_field = "0B6C4B4D8968CF7C7D47B287812753E8", hash_generated_field = "88188D2D99FE8F90CB26B5E79B041F22")

    private static final int MAX_RAM_DOMAIN_COUNT = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.361 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "6968AEDC2C31A50F6ADB7A7EFEF7EBAD")

    private final static String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.361 -0400", hash_original_field = "369E0B214F297D12A5AB6D68DE5A8F0F", hash_generated_field = "EF91073A1DCAEA8DA1E091E70D6320E1")

    private static final CookieComparator COMPARATOR = new CookieComparator();
}

