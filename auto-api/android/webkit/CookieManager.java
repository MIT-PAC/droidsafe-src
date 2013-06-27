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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.730 -0400", hash_original_field = "33B8F6A3D163A5424381884F05DEEE3C", hash_generated_field = "FBED18CAF24013DA0D8FA265CFF0028E")

    private Map<String, ArrayList<Cookie>> mCookieMap = new LinkedHashMap
            <String, ArrayList<Cookie>>(MAX_DOMAIN_COUNT, 0.75f, true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.730 -0400", hash_original_field = "4C8CE05AB6E764DAAAEA4703562B22CB", hash_generated_field = "EA988CB62FE4EFBF1E2849AAB3DDD6B9")

    private boolean mAcceptCookie = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.730 -0400", hash_original_field = "9AB401A6E848CD08C3892BEAD196B99B", hash_generated_field = "E7DA179CDB1C423BB7FF952CDAC068A2")

    private int pendingCookieOperations = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.730 -0400", hash_original_method = "D1B429C0ADFDAAD2AA9A34491D464202", hash_generated_method = "7E9E6C54D01E5F13F7A4CCB58B878A0F")
    private  CookieManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.731 -0400", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "485516C5E5A309F67F3624B095CDFF25")
    protected Object clone() throws CloneNotSupportedException {
        if (DroidSafeAndroidRuntime.control) throw new CloneNotSupportedException("doesn't implement Cloneable");
        // ---------- Original Method ----------
        //throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    
        public static synchronized CookieManager getInstance() {
        if (sRef == null) {
            sRef = new CookieManager();
        }
        return sRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.731 -0400", hash_original_method = "0044CC48946D988BAC3F9C31DC5ECF6E", hash_generated_method = "A3E7656BA84F5475C681B0E72AFE48BC")
    public synchronized void setAcceptCookie(boolean accept) {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1133941484 = (JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.732 -0400", hash_original_method = "EAEA6182C3DE8E7E3FA46C84A2197DA5", hash_generated_method = "37E863E4C4A76F8F4BA027871EEC8635")
    public synchronized boolean acceptCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1340289326 = (JniUtil.useChromiumHttpStack());
            {
                boolean var7A32826552223CCBC1277BE3318866F8_770152523 = (nativeAcceptCookie());
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_360174537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_360174537;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return nativeAcceptCookie();
        //}
        //return mAcceptCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.732 -0400", hash_original_method = "3C733C3F28B1C91BBFDBB065F4DCBFE1", hash_generated_method = "9F4C6B74B76EF99B9924107634F21813")
    public void setCookie(String url, String value) {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1666124670 = (JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.733 -0400", hash_original_method = "FD6DC9D8EE462ADB809067B2E36820B1", hash_generated_method = "681374C2594E77913FB892E4305EAFDE")
    public void setCookie(String url, String value, boolean privateBrowsing) {
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_222519762 = (!JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.741 -0400", hash_original_method = "8AF5CC468B90A5A42A5116E5B0AA2987", hash_generated_method = "28C04E9072C2A8B692711745D70E85C4")
    public synchronized void setCookie(WebAddress uri, String value) {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_180178067 = (JniUtil.useChromiumHttpStack());
            {
                nativeSetCookie(uri.toString(), value, false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF464C5570B08564435F758B79DFFB796_386308389 = (value != null && value.length() > MAX_COOKIE_LENGTH);
        } //End collapsed parenthetic
        String[] hostAndPath;
        hostAndPath = getHostAndPath(uri);
        {
            boolean var4CD0D0571ACF6B1371CB0FD67E9488E5_1593717079 = (hostAndPath[1].length() > 1);
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
            boolean var639B145A70887FECCC495043A3AE58E5_1485655968 = (cookies == null || cookies.size() == 0);
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
                    boolean var2533A21149F7AACF984863A299EFC64E_955510203 = (iter.hasNext());
                    {
                        Cookie cookieEntry;
                        cookieEntry = iter.next();
                        {
                            boolean varAB7EC59C572994F733235AA847DF6EAC_463510037 = (cookie.exactMatch(cookieEntry));
                            {
                                {
                                    {
                                        boolean var0B3911FB1DADB1C34E5C5499C7BBE8E8_1865424714 = (!cookieEntry.secure || HTTPS.equals(uri.getScheme()));
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
                        boolean varA821449DF18F0433C732BA9E8F4FCABD_916800166 = (cookieList.size() > MAX_COOKIE_COUNT_PER_BASE_DOMAIN);
                        {
                            Cookie toDelete;
                            toDelete = new Cookie();
                            toDelete.lastAcessTime = now;
                            Iterator<Cookie> iter2;
                            iter2 = cookieList.iterator();
                            {
                                boolean varF0EFB9A964C064E456621406FBF6CA8A_602421215 = (iter2.hasNext());
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
        addTaint(uri.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.758 -0400", hash_original_method = "CFFC2606C8B97641601C2B54714068BC", hash_generated_method = "8383270BE67F72D2B12818EAF1BEB6E6")
    public String getCookie(String url) {
        String varB4EAC82CA7396A68D541C85D26508E83_976351085 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1464264928 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_598821169 = null; //Variable for return #3
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_737303437 = (JniUtil.useChromiumHttpStack());
            {
                varB4EAC82CA7396A68D541C85D26508E83_976351085 = getCookie(url, false);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1464264928 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_598821169 = getCookie(uri);
        addTaint(url.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1421608553; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1421608553 = varB4EAC82CA7396A68D541C85D26508E83_976351085;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1421608553 = varB4EAC82CA7396A68D541C85D26508E83_1464264928;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1421608553 = varB4EAC82CA7396A68D541C85D26508E83_598821169;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1421608553.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1421608553;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.759 -0400", hash_original_method = "5ACC35EE5D78B03ACC91967E6F456E58", hash_generated_method = "AFA065D4D578DD71D3A6831BECF02535")
    public String getCookie(String url, boolean privateBrowsing) {
        String varB4EAC82CA7396A68D541C85D26508E83_2045259351 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_494303792 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1981471534 = null; //Variable for return #3
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_1374704994 = (!JniUtil.useChromiumHttpStack());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2045259351 = getCookie(url);
            } //End block
        } //End collapsed parenthetic
        WebAddress uri;
        try 
        {
            uri = new WebAddress(url);
        } //End block
        catch (ParseException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_494303792 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1981471534 = nativeGetCookie(uri.toString(), privateBrowsing);
        addTaint(url.getTaint());
        addTaint(privateBrowsing);
        String varA7E53CE21691AB073D9660D615818899_1594194708; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1594194708 = varB4EAC82CA7396A68D541C85D26508E83_2045259351;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1594194708 = varB4EAC82CA7396A68D541C85D26508E83_494303792;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1594194708 = varB4EAC82CA7396A68D541C85D26508E83_1981471534;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1594194708.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1594194708;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.777 -0400", hash_original_method = "BE3F143473537E9CE993D89B685428CF", hash_generated_method = "B3C52FE90378BC928C571EABD8FB209E")
    public synchronized String getCookie(WebAddress uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1906409903 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1461084422 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1108893514 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1673443814 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_632229603 = null; //Variable for return #5
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_880600975 = (JniUtil.useChromiumHttpStack());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1906409903 = nativeGetCookie(uri.toString(), false);
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1461084422 = null;
        } //End block
        String[] hostAndPath;
        hostAndPath = getHostAndPath(uri);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1108893514 = null;
        } //End block
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
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_828469435 = (iter.hasNext());
            {
                Cookie cookie;
                cookie = iter.next();
                {
                    boolean var81120406E156C6C87A676DABB6BB0054_122630894 = (cookie.domainMatch(hostAndPath[0]) &&
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
            boolean varD75D141127F254DD0E9A96ADF154DF93_818940120 = (setIter.hasNext());
            {
                Cookie cookie;
                cookie = setIter.next();
                {
                    boolean var1834F7F58970AEB3525D549FD6B87EA4_521017056 = (ret.length() > 0);
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
            boolean var5CF789B206995BB451A167ACD3C23235_1893090290 = (ret.length() > 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1673443814 = ret.toString();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_632229603 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1178429210; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1178429210 = varB4EAC82CA7396A68D541C85D26508E83_1906409903;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1178429210 = varB4EAC82CA7396A68D541C85D26508E83_1461084422;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1178429210 = varB4EAC82CA7396A68D541C85D26508E83_1108893514;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1178429210 = varB4EAC82CA7396A68D541C85D26508E83_1673443814;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1178429210 = varB4EAC82CA7396A68D541C85D26508E83_632229603;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1178429210.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1178429210;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.778 -0400", hash_original_method = "E5896ED24A303B704C1A851D6E9894DE", hash_generated_method = "7B98E0CEF2ED0C681B8B18F98E262D5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.778 -0400", hash_original_method = "65B0411E3AAD9BA729084C50D7485B13", hash_generated_method = "B7CAADA5C52530BA6D97746E1DE452FA")
    private synchronized void signalCookieOperationsComplete() {
        notify();
        // ---------- Original Method ----------
        //pendingCookieOperations--;
        //assert pendingCookieOperations > -1;
        //notify();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.778 -0400", hash_original_method = "3D00699F37AF6D5720F5926DFEED864B", hash_generated_method = "48E8F9DDFD7E31FC7FD0C53F18A2E40C")
    private synchronized void signalCookieOperationsStart() {
        // ---------- Original Method ----------
        //pendingCookieOperations++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.792 -0400", hash_original_method = "E9CA847999E57130D19A4C553707D595", hash_generated_method = "E3E35E020F6A228B49F0EA08E0EB1F2C")
    public void removeSessionCookie() {
        signalCookieOperationsStart();
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1286432107 = (JniUtil.useChromiumHttpStack());
            {
                new AsyncTask<Void, Void, Void>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.779 -0400", hash_original_method = "DF560F823BF7C351EEB240AF10E95817", hash_generated_method = "25DF5407A5E3F138168A9A2AC2134C99")
                    protected Void doInBackground(Void... none) {
                        Void varB4EAC82CA7396A68D541C85D26508E83_1054030056 = null; //Variable for return #1
                        nativeRemoveSessionCookie();
                        signalCookieOperationsComplete();
                        varB4EAC82CA7396A68D541C85D26508E83_1054030056 = null;
                        addTaint(none[0].getTaint());
                        varB4EAC82CA7396A68D541C85D26508E83_1054030056.addTaint(getTaint()); //Add taint from parent
                        return varB4EAC82CA7396A68D541C85D26508E83_1054030056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.793 -0400", hash_original_method = "E6726E6A7287E971302CDEBC56D91ADA", hash_generated_method = "09F61224011D72DD369B013BE71F6D86")
    public void removeAllCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1915226043 = (JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.793 -0400", hash_original_method = "2201D105B8AC0DA82BEBC1DB9FB29AE8", hash_generated_method = "61F623D8AECC94E78A45FE5DA0404799")
    public synchronized boolean hasCookies() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1135767247 = (JniUtil.useChromiumHttpStack());
            {
                boolean var8A47D9F563B217F231C778B81E4E893A_811639777 = (hasCookies(false));
            } //End block
        } //End collapsed parenthetic
        boolean varA1156B6EC3BF3B16EC8E0EFFFE74477E_9218715 = (CookieSyncManager.getInstance().hasCookies());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389718191 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389718191;
        // ---------- Original Method ----------
        //if (JniUtil.useChromiumHttpStack()) {
            //return hasCookies(false);
        //}
        //return CookieSyncManager.getInstance().hasCookies();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.794 -0400", hash_original_method = "6C96B3E47AB792BE3053A98B747C02B0", hash_generated_method = "2D5C25BBA1482464215DD4D538FADE36")
    public synchronized boolean hasCookies(boolean privateBrowsing) {
        {
            boolean var0C0A67311072ACF9A11F251AEC847BBE_1792193378 = (!JniUtil.useChromiumHttpStack());
            {
                boolean var0675649B9D327117801A509BA1416818_1245758363 = (hasCookies());
            } //End block
        } //End collapsed parenthetic
        boolean var08F9F6B298BF2816AC0F7C70944E7CDA_2008895068 = (nativeHasCookies(privateBrowsing));
        addTaint(privateBrowsing);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951654660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951654660;
        // ---------- Original Method ----------
        //if (!JniUtil.useChromiumHttpStack()) {
            //return hasCookies();
        //}
        //return nativeHasCookies(privateBrowsing);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.798 -0400", hash_original_method = "EBBBDCC80F6ABDA541004A954FD75C00", hash_generated_method = "C3828DE4948364FB4F6FDF4580286174")
    public void removeExpiredCookie() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1508669208 = (JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.798 -0400", hash_original_method = "6E81366EB3EC21A5D57BD56704F05E83", hash_generated_method = "4278BB261C7AD1BA1CAFD6452D34EA6D")
     void flushCookieStore() {
        {
            boolean var9ACB1B3B30D2C0CED704DA8C8B3FC1B9_1523289696 = (JniUtil.useChromiumHttpStack());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.816 -0400", hash_original_method = "F607692A589F63FF1216167E4F5DA44E", hash_generated_method = "8A75C3897337A11E49F5E36E5BC41607")
    synchronized ArrayList<Cookie> getUpdatedCookiesSince(long last) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_385701337 = null; //Variable for return #1
        ArrayList<Cookie> cookies;
        cookies = new ArrayList<Cookie>();
        Collection<ArrayList<Cookie>> cookieList;
        cookieList = mCookieMap.values();
        Iterator<ArrayList<Cookie>> listIter;
        listIter = cookieList.iterator();
        {
            boolean var6418FFD41602BEB1548D9077877E8311_2082545574 = (listIter.hasNext());
            {
                ArrayList<Cookie> list;
                list = listIter.next();
                Iterator<Cookie> iter;
                iter = list.iterator();
                {
                    boolean var2533A21149F7AACF984863A299EFC64E_605815719 = (iter.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_385701337 = cookies;
        addTaint(last);
        varB4EAC82CA7396A68D541C85D26508E83_385701337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_385701337;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.817 -0400", hash_original_method = "EBDE0BAE6A65E045698E84F7289F4664", hash_generated_method = "672B1C0B0488E601CA0DCD5381FB9D22")
    synchronized void deleteACookie(Cookie cookie) {
        {
            String baseDomain;
            baseDomain = getBaseDomain(cookie.domain);
            ArrayList<Cookie> cookieList;
            cookieList = mCookieMap.get(baseDomain);
            {
                cookieList.remove(cookie);
                {
                    boolean varB40BC97479C649DE73A4798204316F84_708223841 = (cookieList.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.817 -0400", hash_original_method = "23D0913407E37C8868B97CA5EA461217", hash_generated_method = "E870E684A572A3835743B7C29096A760")
    synchronized void syncedACookie(Cookie cookie) {
        cookie.mode = Cookie.MODE_NORMAL;
        addTaint(cookie.getTaint());
        // ---------- Original Method ----------
        //cookie.mode = Cookie.MODE_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.818 -0400", hash_original_method = "37E656A6EDF347445C1655B2E42F538E", hash_generated_method = "41CA1A74F9BA8F41BC47AB4B729C0A18")
    synchronized ArrayList<Cookie> deleteLRUDomain() {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_619575586 = null; //Variable for return #1
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
                boolean var118F3A3E5092CF8856C75A8398E045D3_38445114 = (listIter.hasNext() && count < MAX_RAM_COOKIES_COUNT);
                {
                    ArrayList<Cookie> list;
                    list = listIter.next();
                    {
                        Iterator<Cookie> iter;
                        iter = list.iterator();
                        {
                            boolean var923F5D856CBEA3FFF8E45A6435ECCB10_1986478356 = (iter.hasNext() && count < MAX_RAM_COOKIES_COUNT);
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
        varB4EAC82CA7396A68D541C85D26508E83_619575586 = retlist;
        varB4EAC82CA7396A68D541C85D26508E83_619575586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_619575586;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.831 -0400", hash_original_method = "5193D0EACEE146C23C2F9C98185BC9CF", hash_generated_method = "6899555CC5D92BA8A9685A256C228A62")
    private String[] getHostAndPath(WebAddress uri) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1725771921 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1171358752 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_445909056 = null; //Variable for return #3
        {
            boolean varB5FF893C44F641B4F7CF23797BB4095A_1175033875 = (uri.getHost() != null && uri.getPath() != null);
            {
                String[] ret;
                ret = new String[2];
                ret[0] = uri.getHost().toLowerCase();
                ret[1] = uri.getPath();
                int index;
                index = ret[0].indexOf(PERIOD);
                {
                    {
                        boolean var7AFAB69A16A288F76D0E2FCFA532519E_1741705951 = (uri.getScheme().equalsIgnoreCase("file"));
                        {
                            ret[0] = "localhost";
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varB791FB78F104615FDEB847DBBFA3AAC1_1723933148 = (index == ret[0].lastIndexOf(PERIOD));
                    {
                        ret[0] = PERIOD + ret[0];
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varBF520D714B28C887CB3153C5B5D328FA_2047626577 = (ret[1].charAt(0) != PATH_DELIM);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1725771921 = null;
                    } //End block
                } //End collapsed parenthetic
                index = ret[1].indexOf(QUESTION_MARK);
                {
                    ret[1] = ret[1].substring(0, index);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1171358752 = ret;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_445909056 = null;
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_782551847; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_782551847 = varB4EAC82CA7396A68D541C85D26508E83_1725771921;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_782551847 = varB4EAC82CA7396A68D541C85D26508E83_1171358752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_782551847 = varB4EAC82CA7396A68D541C85D26508E83_445909056;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_782551847.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_782551847;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.848 -0400", hash_original_method = "0BC29AC3055E44155EBF14855C5D487F", hash_generated_method = "667BDCCC13E3B8FA7CC6A7C45FB6D08C")
    private String getBaseDomain(String host) {
        String varB4EAC82CA7396A68D541C85D26508E83_723159454 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_528871461 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_723159454 = host.substring(startIndex);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_528871461 = host;
        } //End block
        addTaint(host.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1833602624; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1833602624 = varB4EAC82CA7396A68D541C85D26508E83_723159454;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1833602624 = varB4EAC82CA7396A68D541C85D26508E83_528871461;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1833602624.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1833602624;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.865 -0400", hash_original_method = "686D7BF75F67F22DBAC0E1E36B7A58EB", hash_generated_method = "97EBC3D80F77B1C67F8F2D35A91FDFFE")
    private ArrayList<Cookie> parseCookie(String host, String path,
            String cookieString) {
        ArrayList<Cookie> varB4EAC82CA7396A68D541C85D26508E83_732439427 = null; //Variable for return #1
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
                boolean varE8871F9653319A259571D06172D1AEE8_1313639154 = (cookieString.charAt(index) == WHITE_SPACE);
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
                    boolean varEAC5CE96F1515E85A79CC4A57E69EE0C_803347152 = ((equalIndex < length - 1) &&
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
                    boolean varBE5EE8D37CFA74C6E90C8AC330A66127_844049543 = (cookieString.charAt(index) == WHITE_SPACE
                        || cookieString.charAt(index) == SEMICOLON);
                } //End collapsed parenthetic
                {
                    boolean var59917C993945A4C5AE1ABFE72D45B028_848966013 = (cookieString.charAt(index) == COMMA);
                } //End collapsed parenthetic
                {
                    boolean varF3A4A21C55D7FF52C4292FA83141D706_1347250445 = (length - index >= SECURE_LENGTH
                        && cookieString.substring(index, index + SECURE_LENGTH).
                        equalsIgnoreCase(SECURE));
                    {
                        index += SECURE_LENGTH;
                        cookie.secure = true;
                        {
                            boolean varC88233FC4DC8EC934257FE2094942F69_1472295492 = (cookieString.charAt(index) == EQUAL);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var1D7438053E6770C42AF1477FD3B63C7B_426793033 = (length - index >= HTTP_ONLY_LENGTH
                        && cookieString.substring(index,
                            index + HTTP_ONLY_LENGTH).
                        equalsIgnoreCase(HTTP_ONLY));
                    {
                        index += HTTP_ONLY_LENGTH;
                        {
                            boolean varC88233FC4DC8EC934257FE2094942F69_1469542138 = (cookieString.charAt(index) == EQUAL);
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
                        boolean varD1FB05D7CF4103A1B6A2928ACA880533_514759278 = (valueIndex < length && cookieString.charAt(valueIndex) == WHITE_SPACE);
                    } //End collapsed parenthetic
                    {
                        boolean var7368C0CDE5A76B546A13F21527AC9C2B_763738712 = (name.equals(EXPIRES));
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
                        boolean varF3B26F622B3BA344243C3452C5EAD85F_2077906037 = (value.length() > 2 && value.charAt(0) == QUOTATION);
                        {
                            int endQuote;
                            endQuote = value.indexOf(QUOTATION, 1);
                            {
                                value = value.substring(1, endQuote);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var7368C0CDE5A76B546A13F21527AC9C2B_234112648 = (name.equals(EXPIRES));
                        {
                            try 
                            {
                                cookie.expires = AndroidHttpClient.parseDate(value);
                            } //End block
                            catch (IllegalArgumentException ex)
                            { }
                        } //End block
                        {
                            boolean var6564460B5C30271EE1EFF78DDBB789FB_1190056187 = (name.equals(MAX_AGE));
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
                                boolean var0A9AF45F54D476ACC0274E0E6DAC2FA0_1667680948 = (name.equals(PATH));
                                {
                                    {
                                        boolean var0E83E73D0EFF9C33CBD153EB762D02A2_1699053177 = (value.length() > 0);
                                        {
                                            cookie.path = value;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varF74E07688049599069565E410921F574_270823688 = (name.equals(DOMAIN));
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
                                                boolean varE1CD484A077BCDA29486EAC1AD09FE74_1389428127 = (!value.equals(host));
                                                {
                                                    cookie.domain = null;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        catch (NumberFormatException ex)
                                        { }
                                        value = value.toLowerCase();
                                        {
                                            boolean varE2B53F95599A2D49216C544D11EF4ECC_323847547 = (value.charAt(0) != PERIOD);
                                            {
                                                value = PERIOD + value;
                                            } //End block
                                        } //End collapsed parenthetic
                                        {
                                            boolean var10024EBAA7EEAAC0A256BE84E1366563_564204599 = (host.endsWith(value.substring(1)));
                                            {
                                                int len;
                                                len = value.length();
                                                int hostLen;
                                                hostLen = host.length();
                                                {
                                                    boolean var0CE4FFED329EAEC88D1A8448E0EC8E7E_1812336383 = (hostLen > (len - 1)
                                    && host.charAt(hostLen - len) != PERIOD);
                                                    {
                                                        cookie.domain = null;
                                                    } //End block
                                                } //End collapsed parenthetic
                                                {
                                                    String s;
                                                    s = value.substring(1, lastPeriod);
                                                    {
                                                        boolean var6C41572AF3F94E5C989F9F99887AAEBD_734744523 = (Arrays.binarySearch(BAD_COUNTRY_2LDS, s) >= 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_732439427 = ret;
        addTaint(host.getTaint());
        addTaint(path.getTaint());
        addTaint(cookieString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_732439427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732439427;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static boolean nativeAcceptCookie() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static String nativeGetCookie(String url, boolean privateBrowsing) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "AD5F82E879A9C5D6B5B442EB37E50551", hash_generated_field = "B45971700BE10ABC690F6ABCD38C274A")

        String domain;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "79E45F34FE773E697DAD830A242384A5")

        long expires;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "7D892431B152BBFFEDEC812251E45ADD", hash_generated_field = "6AE4DE9DE049C06174725EC4E5976F6D")

        long lastAcessTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "34635AE52863B6F106A6490644A4C5BB", hash_generated_field = "357B404F32323702F25D563FFF0505BF")

        long lastUpdateTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "63DC6869FF37EDAA23661806B080C4ED")

        boolean secure;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.882 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "E1716F24954CF03C4F874BC683AC0606")

        byte mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.885 -0400", hash_original_method = "91108A58846CEDD8DA5905902DEE69F4", hash_generated_method = "0337FD9DF266AE2D58305A9F66087523")
          Cookie() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.898 -0400", hash_original_method = "E1F86FD348EBFCA5152C7C5B27A3DCAA", hash_generated_method = "8010E05032C6AA7B338CE8179C520774")
          Cookie(String defaultDomain, String defaultPath) {
            domain = defaultDomain;
            path = defaultPath;
            expires = -1;
            // ---------- Original Method ----------
            //domain = defaultDomain;
            //path = defaultPath;
            //expires = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.898 -0400", hash_original_method = "78A5F78070F927D77B7E42EE06AFDBC4", hash_generated_method = "A2F81BA5C71B1D9CEB11CA50B581AEBF")
         boolean exactMatch(Cookie in) {
            boolean valuesMatch;
            valuesMatch = !((value == null) ^ (in.value == null));
            boolean varB760F3D14A317E9E1240F1DD0EB08AC9_1527487427 = (domain.equals(in.domain) && path.equals(in.path) &&
                    name.equals(in.name) && valuesMatch);
            addTaint(in.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517834638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517834638;
            // ---------- Original Method ----------
            //boolean valuesMatch = !((value == null) ^ (in.value == null));
            //return domain.equals(in.domain) && path.equals(in.path) &&
                    //name.equals(in.name) && valuesMatch;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.899 -0400", hash_original_method = "AE74CD0D7D859A06FEAA31D7F99E4D83", hash_generated_method = "91FDCA6D836019E245959927CCE7A134")
         boolean domainMatch(String urlHost) {
            {
                boolean var1AA47E915A9A7BE21086DD3D0BA11DC5_673478914 = (domain.startsWith("."));
                {
                    {
                        boolean varD1AD2EF5FF384B0F8B31A949A9373BE8_1359262000 = (urlHost.endsWith(domain.substring(1)));
                        {
                            int len;
                            len = domain.length();
                            int urlLen;
                            urlLen = urlHost.length();
                            {
                                boolean var0474A224C63EE86B2A0F82273C401629_633463430 = (urlHost.charAt(urlLen - len) == PERIOD);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var92CC2FDDED6B31734455343B1116D0F1_1811795101 = (urlHost.equals(domain));
                } //End block
            } //End collapsed parenthetic
            addTaint(urlHost.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482146759 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_482146759;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.899 -0400", hash_original_method = "0FD43CB7A1B51508534ED8D9F7B624E8", hash_generated_method = "F14C2ED33DD5C7A60EC3BB900C713D12")
         boolean pathMatch(String urlPath) {
            {
                boolean var6B3ADCF616A86BAB477653B4B7C748B5_1151640977 = (urlPath.startsWith(path));
                {
                    int len;
                    len = path.length();
                    int urlLen;
                    urlLen = urlPath.length();
                    {
                        boolean var652449ECDCA9F03141F3688013BBBCE1_273453086 = (path.charAt(len-1) != PATH_DELIM && urlLen > len);
                        {
                            boolean var0556DC25417548B062FF41011508D659_528513208 = (urlPath.charAt(len) == PATH_DELIM);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(urlPath.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473254575 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473254575;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.910 -0400", hash_original_method = "08415E5687C0C693DFF8536ADAD3E2AA", hash_generated_method = "C6CA76D1272D472147875F20353D0C0A")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_73063014 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_73063014 = "domain: " + domain + "; path: " + path + "; name: " + name
                    + "; value: " + value;
            varB4EAC82CA7396A68D541C85D26508E83_73063014.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_73063014;
            // ---------- Original Method ----------
            //return "domain: " + domain + "; path: " + path + "; name: " + name
                    //+ "; value: " + value;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.910 -0400", hash_original_field = "1373AC0A3E23F4267D6303E56EFA672F", hash_generated_field = "F9FCA0F715D9AACE0B8BB9410D6274DE")

        static byte MODE_NEW = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.910 -0400", hash_original_field = "9F763DB46A48E5315C1E1EDC1CA5635F", hash_generated_field = "B9A70BF730AD4A088EB123BAAF9BAE6E")

        static byte MODE_NORMAL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.911 -0400", hash_original_field = "AA5825DEFAEA0E34C79E13FF3E565114", hash_generated_field = "BB7AC59BC94796FD070E513A01E055FA")

        static byte MODE_DELETED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.911 -0400", hash_original_field = "05F4B5C57DFBFFCD0E4F92EAC31EFECE", hash_generated_field = "1B33C635B23DF63289160AE0E7B61389")

        static byte MODE_REPLACED = 3;
    }


    
    private static final class CookieComparator implements Comparator<Cookie> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.911 -0400", hash_original_method = "EA07F3AA36DD3B1C5469CE7D110356B0", hash_generated_method = "EA07F3AA36DD3B1C5469CE7D110356B0")
        public CookieComparator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.911 -0400", hash_original_method = "2F959C67E8DDB6BD10BD3460D506EDBA", hash_generated_method = "3A33122C3D11816EBD59D23B15F16B99")
        public int compare(Cookie cookie1, Cookie cookie2) {
            int diff;
            diff = cookie2.path.length() - cookie1.path.length();
            diff = cookie2.domain.length() - cookie1.domain.length();
            int varF72DD66A04AAB93721C41E4DC4180D39_1703633167 = (cookie1.name.compareTo(cookie2.name));
            addTaint(cookie1.getTaint());
            addTaint(cookie2.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851297961 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851297961;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.911 -0400", hash_original_field = "E6BA83C33E70ACF527403866BBE81365", hash_generated_field = "F3E12733AF62A9958A559C9B68C05600")

    private static CookieManager sRef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.911 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "E56CE2F3E60B73E43C117C0293F7827E")

    private static String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "419533E410B7DE0CC9F5934C3A2D19C5", hash_generated_field = "591D0BDC8F2134B512FD7AF0BE424234")

    private static String DOMAIN = "domain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "C9FFF77EC130ACB59E8320718C687E06", hash_generated_field = "DECD8BABB6583C91F5D71D4D73594FDB")

    private static String PATH = "path";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "899162B90BDD687F90078C4CDC23D4AA", hash_generated_field = "7D4C5E12B7AEB1C98ADAC4218499C03F")

    private static String EXPIRES = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "CADF62F6B9B615DBFC4A91AB2470A969", hash_generated_field = "1B13127C504E0A38FA4264AAA5F04158")

    private static String SECURE = "secure";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "2D4FDC7F9F47E8939FD8E883ADA3143E", hash_generated_field = "AB7EE20F9BB23851EB4D7257B39DDA94")

    private static String MAX_AGE = "max-age";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "AB306205B084AA7306512423EA8A4F37", hash_generated_field = "C2FB49E7256B4DB73DB4F2561BF3ADBB")

    private static String HTTP_ONLY = "httponly";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "B4503B87E0F867CC16DA4DA30EFB1B4E", hash_generated_field = "6E2782FEC196F8F10DA104CD65C8A8BC")

    private static String HTTPS = "https";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "3086B699DF6C21833EC8465ABB1D5EDE", hash_generated_field = "B23E37201870D6076681425FEDB960B3")

    private static char PERIOD = '.';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "6699AC2D718BB4662AD28663BE3D755B", hash_generated_field = "B960AE70EC9F5034816CD56BB8AAEA94")

    private static char COMMA = ',';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "D943B9D72E9E95DF1EF616456AC4F309", hash_generated_field = "47573A70A65ADB8BD715E6F60D3024AE")

    private static char SEMICOLON = ';';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "78AD75A262DFBD4281DB52940BC918B7", hash_generated_field = "6EBCE74E09541CDF8CCDEDBEC2042A05")

    private static char EQUAL = '=';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "F94280598CD8F530D9DBDE0BB1C7CD08", hash_generated_field = "1807048B4CFE9CF1FC5081090D90020C")

    private static char PATH_DELIM = '/';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "357120CD258B53E76605EEAE5416C9E1", hash_generated_field = "8B4A624BE0C00641DB2071D9F09D5F7D")

    private static char QUESTION_MARK = '?';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "E740A1049DEFC7A54C45F361F5359873", hash_generated_field = "0C39E8FC4822819C4A71C5D68C0723E4")

    private static char WHITE_SPACE = ' ';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "A19CF4D2A809874EAEB72E6329B2E2E7", hash_generated_field = "06C94F3816DE31C2106D754A0451B193")

    private static char QUOTATION = '\"';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "6E9F518585624ED7D2970848AC7295EB", hash_generated_field = "DEB55661AFFEEFA3DB8422E3E8E8EC0B")

    private static int SECURE_LENGTH = SECURE.length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "18288EFA26CFF3B6879ECC3C3442CD56", hash_generated_field = "2DC6588AFC6A59966F95407A2CA0B16E")

    private static int HTTP_ONLY_LENGTH = HTTP_ONLY.length();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "A06622DE12BE98909AA145AB6E7296F1", hash_generated_field = "B489F90D327CE6D89212B643B32E7180")

    private static int MAX_COOKIE_LENGTH = 4 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "CE4EFB8A8F2B82EBBDF7D0D24ED77D75", hash_generated_field = "FB29D49EB1689194D2FA253D989C456F")

    private static int MAX_COOKIE_COUNT_PER_BASE_DOMAIN = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "A3454E54AB97537D29472E7494E77F4A", hash_generated_field = "585D330FC7527CA674E6527E88384623")

    private static int MAX_DOMAIN_COUNT = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "7538240BC29EFCD49CC35AF219A38F74", hash_generated_field = "92CA3EEA37F4728B3213B63D88C31078")

    private static int MAX_RAM_COOKIES_COUNT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "0B6C4B4D8968CF7C7D47B287812753E8", hash_generated_field = "C008C5265DACAF3E85C5BBDD2F8283A6")

    private static int MAX_RAM_DOMAIN_COUNT = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "76B1D705F0ADC634FC0CFCB99B6D9F38", hash_generated_field = "28A8061CDF15FD396E8AFC89C5D72DEE")

    private static String[] BAD_COUNTRY_2LDS = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.912 -0400", hash_original_field = "369E0B214F297D12A5AB6D68DE5A8F0F", hash_generated_field = "8FCDC89B543F85429E341E22ED460A8D")

    private static CookieComparator COMPARATOR = new CookieComparator();
}

