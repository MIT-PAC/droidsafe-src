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
 * Copyright (C) 2006 The Android Open Source Project
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
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import android.net.ParseException;
import android.net.WebAddress;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import droidsafe.helpers.DSUtils;

public final class CookieManager {

    /**
     * Get a singleton CookieManager. If this is called before any
     * {@link WebView} is created or outside of {@link WebView} context, the
     * caller needs to call {@link CookieSyncManager#createInstance(Context)}
     * first.
     * 
     * @return CookieManager
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.569 -0500", hash_original_method = "320195B5814A82CDAD5D188DBD73B8D9", hash_generated_method = "041F3F39198BFF3134D422820E8011E0")
    
public static synchronized CookieManager getInstance() {
        if (sRef == null) {
            sRef = new CookieManager();
        }
        return sRef;
    }

    /**
     * Whether cookies are accepted for file scheme URLs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.632 -0500", hash_original_method = "B431463E1C39FBF9835A224B363A2DCD", hash_generated_method = "88C4D72F6317DC1B05F9A8117880A962")
    
public static boolean allowFileSchemeCookies() {
        if (JniUtil.useChromiumHttpStack()) {
            return nativeAcceptFileSchemeCookies();
        } else {
            return true;
        }
    }

    /**
     * Sets whether cookies are accepted for file scheme URLs.
     *
     * Use of cookies with file scheme URLs is potentially insecure. Do not use this feature unless
     * you can be sure that no unintentional sharing of cookie data can take place.
     * <p>
     * Note that calls to this method will have no effect if made after a WebView or CookieManager
     * instance has been created.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.634 -0500", hash_original_method = "DDDF3B365E373BA27DDF165EB75D805C", hash_generated_method = "919ED282712AA5CB733CFC020940955F")
    
public static void setAcceptFileSchemeCookies(boolean accept) {
        if (JniUtil.useChromiumHttpStack()) {
            nativeSetAcceptFileSchemeCookies(accept);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeAcceptCookie() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69788974 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69788974;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String nativeGetCookie(String url, boolean privateBrowsing) {
        	String s = new String();
        	s.addTaint(url.getTaint());
        	return s;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeHasCookies(boolean privateBrowsing) {
        return privateBrowsing;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRemoveAllCookie() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRemoveExpiredCookie() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeRemoveSessionCookie() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetAcceptCookie(boolean accept) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetCookie(String url, String value, boolean privateBrowsing) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeFlushCookieStore() {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeAcceptFileSchemeCookies() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842509513 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842509513;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeSetAcceptFileSchemeCookies(boolean accept) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.441 -0500", hash_original_field = "E0557A7A649926C8CE19F6226ADACE2C", hash_generated_field = "F3E12733AF62A9958A559C9B68C05600")

    private static CookieManager sRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.444 -0500", hash_original_field = "CF5103981B618784F76950E4558FDBCC", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.446 -0500", hash_original_field = "27043D2583D10F5C11A5DA11E81058CD", hash_generated_field = "5430298A9897B69B0A98E2CC4D81D311")

    private static final String DOMAIN = "domain";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.449 -0500", hash_original_field = "F72D5783F800DBD83E9904759EECFA11", hash_generated_field = "487DA3D0E0435A01D919AD07E7109D33")

    private static final String PATH = "path";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.451 -0500", hash_original_field = "002E36B52DB598DD795E59C99EE81CCD", hash_generated_field = "066A210975164BE5260662AAE6EB4D7C")

    private static final String EXPIRES = "expires";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.454 -0500", hash_original_field = "9758C225BB938A3B0AD67594CBA9CFC7", hash_generated_field = "854A2BF9C58B1D456228AC3164C91937")

    private static final String SECURE = "secure";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.456 -0500", hash_original_field = "04D54F7257534E50A6A60C8A9BACF9EA", hash_generated_field = "17FDE42B196035B579C4AE0481D84D7C")

    private static final String MAX_AGE = "max-age";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.458 -0500", hash_original_field = "1CFA4328BF4632BE6B446A4D108D2C9F", hash_generated_field = "8B75A58E3869C3DA24B83475B2775E3B")

    private static final String HTTP_ONLY = "httponly";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.462 -0500", hash_original_field = "F2AD625CF02F5E5AE2151E99043F3F65", hash_generated_field = "6FC6F50ECB134EEDF902652D4FB1FA39")

    private static final String HTTPS = "https";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.464 -0500", hash_original_field = "36032EADE678241AC6D9F441EE69CB3A", hash_generated_field = "5A20D569DC0501B46372E384E70DCE74")

    private static final char PERIOD = '.';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.466 -0500", hash_original_field = "8BB6C4236B31068A1306757F1B35C6D8", hash_generated_field = "E7AE80758443AFBC3D01DB1788C8C0D3")

    private static final char COMMA = ',';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.468 -0500", hash_original_field = "258ADCDD90C6B7575CD98259D7ACF59C", hash_generated_field = "4358BD4872C7B54C285E161294F74EAE")

    private static final char SEMICOLON = ';';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.471 -0500", hash_original_field = "E3D68564A4FC2FD24BBCF5369DEDB319", hash_generated_field = "340B33BC049413F4F0AFE836879E9796")

    private static final char EQUAL = '=';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.473 -0500", hash_original_field = "F1DABF63D16B5BF613835EA1B0B830D7", hash_generated_field = "C33C95C10EDB14BB946C605F87F0993F")

    private static final char PATH_DELIM = '/';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.476 -0500", hash_original_field = "CF3EED31B695BB343A263C84A4EC2261", hash_generated_field = "1712D6DC544FB52547AA3F9EFF9A0265")

    private static final char QUESTION_MARK = '?';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.478 -0500", hash_original_field = "FE2F512CCB95E31ED8510ED04D4A34E0", hash_generated_field = "A797569C73AC5864E7DB653CB9E83AD5")

    private static final char WHITE_SPACE = ' ';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.481 -0500", hash_original_field = "8D966EAFFEE59C2062B1509F414834CD", hash_generated_field = "EE4E21B4CF81F5D51BBD3F71550541EA")

    private static final char QUOTATION = '\"';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.483 -0500", hash_original_field = "8A36CC6070E9C4F5B749337DE00CB115", hash_generated_field = "961A1ADB46113FB181B555DA4F33FEF9")

    private static final int SECURE_LENGTH = SECURE.length();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.485 -0500", hash_original_field = "0DA6F57A0AAC62B67D3CD75C3F60852B", hash_generated_field = "FA80D5C271D5DC9600F2ED7151FE4E42")

    private static final int HTTP_ONLY_LENGTH = HTTP_ONLY.length();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.488 -0500", hash_original_field = "C6241C8B52C7FBEF23F7372AEBBEE270", hash_generated_field = "DDFF82DC777498CEEC17430F3F2218D5")

    private static final int MAX_COOKIE_LENGTH = 4 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.491 -0500", hash_original_field = "839AB7B188139F0EF0DBC307F24AC201", hash_generated_field = "D65F2AA66F092420104FA12D92E51FD9")

    // domain, we allow 50 per base domain
    private static final int MAX_COOKIE_COUNT_PER_BASE_DOMAIN = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.493 -0500", hash_original_field = "34487FBA10CCB8004B0A3970E604EA72", hash_generated_field = "BD58EF0B6FF13EA11D5D4DE30C73046C")

    // domain, we set 200 as max base domain count
    private static final int MAX_DOMAIN_COUNT = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.496 -0500", hash_original_field = "29CA77A715008F1B71EE63409D072F5E", hash_generated_field = "2EB403D7ACD0A44BEA01650EB311C606")

    // average cookie entry size is less than 100 bytes
    private static final int MAX_RAM_COOKIES_COUNT = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.498 -0500", hash_original_field = "A76EA322406CCCA5B08EFE5F57C0D0B8", hash_generated_field = "88188D2D99FE8F90CB26B5E79B041F22")

    private static final int MAX_RAM_DOMAIN_COUNT = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.507 -0500", hash_original_field = "CF832AED4ED292DEBA2E1483360AB57F", hash_generated_field = "6968AEDC2C31A50F6ADB7A7EFEF7EBAD")

    private final static String[] BAD_COUNTRY_2LDS =
          { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info",
            "lg", "ne", "net", "or", "org" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.557 -0500", hash_original_field = "0F7D50A59029816A4D368B97BE6BE48C", hash_generated_field = "EF91073A1DCAEA8DA1E091E70D6320E1")

    private static final CookieComparator COMPARATOR = new CookieComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.500 -0500", hash_original_field = "B2867ECF89E84A901A71873E5DD9AA88", hash_generated_field = "FBED18CAF24013DA0D8FA265CFF0028E")

    private Map<String, ArrayList<Cookie>> mCookieMap = new LinkedHashMap
            <String, ArrayList<Cookie>>(MAX_DOMAIN_COUNT, 0.75f, true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.503 -0500", hash_original_field = "C0091976776BBAF1BB48ECDA03611FA0", hash_generated_field = "EA988CB62FE4EFBF1E2849AAB3DDD6B9")

    private boolean mAcceptCookie = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.505 -0500", hash_original_field = "35C4CBAC80990DDC8FB84CEF632D2149", hash_generated_field = "E7DA179CDB1C423BB7FF952CDAC068A2")

    private int pendingCookieOperations = 0;
    
    static class Cookie {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.511 -0500", hash_original_field = "C8F8D160D63A5816E439772AD5DBC925", hash_generated_field = "58722C253669E0810A7E8B6D3908054B")

        static final byte MODE_NEW = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.514 -0500", hash_original_field = "DE4016D737F4E23403016FD47F84932B", hash_generated_field = "BC0224E6D81C7EF3B83B8B7EFE2FE5E3")

        static final byte MODE_NORMAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.516 -0500", hash_original_field = "8B4F9E6B93623B1ACBD28CF43F79FEC9", hash_generated_field = "94113342DF84F1B38CF08AE47B6FF64D")

        static final byte MODE_DELETED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.518 -0500", hash_original_field = "99B4577D1F6EDAD32AB7E19A64E4666F", hash_generated_field = "CD378DA107C809D64EE250CC5FAF59F0")

        static final byte MODE_REPLACED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.521 -0500", hash_original_field = "B45971700BE10ABC690F6ABCD38C274A", hash_generated_field = "B45971700BE10ABC690F6ABCD38C274A")

        String domain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.524 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.526 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "BF45F7481B8091DE3CBF80E94F7F940B")

        String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.528 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "EE6B270D979EDA88DA18EA680B9EE570")

        String value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.530 -0500", hash_original_field = "79E45F34FE773E697DAD830A242384A5", hash_generated_field = "79E45F34FE773E697DAD830A242384A5")

        long expires;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.532 -0500", hash_original_field = "6AE4DE9DE049C06174725EC4E5976F6D", hash_generated_field = "6AE4DE9DE049C06174725EC4E5976F6D")

        long lastAcessTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.534 -0500", hash_original_field = "357B404F32323702F25D563FFF0505BF", hash_generated_field = "357B404F32323702F25D563FFF0505BF")

        long lastUpdateTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.536 -0500", hash_original_field = "63DC6869FF37EDAA23661806B080C4ED", hash_generated_field = "63DC6869FF37EDAA23661806B080C4ED")

        boolean secure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.538 -0500", hash_original_field = "E1716F24954CF03C4F874BC683AC0606", hash_generated_field = "E1716F24954CF03C4F874BC683AC0606")

        byte mode;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.540 -0500", hash_original_method = "91108A58846CEDD8DA5905902DEE69F4", hash_generated_method = "91108A58846CEDD8DA5905902DEE69F4")
        
Cookie() {
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.543 -0500", hash_original_method = "E1F86FD348EBFCA5152C7C5B27A3DCAA", hash_generated_method = "E1F86FD348EBFCA5152C7C5B27A3DCAA")
        
Cookie(String defaultDomain, String defaultPath) {
            domain = defaultDomain;
            path = defaultPath;
            expires = -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.545 -0500", hash_original_method = "78A5F78070F927D77B7E42EE06AFDBC4", hash_generated_method = "D4CAC9EE6014BA038508EEAE8A25E0B2")
        
boolean exactMatch(Cookie in) {
            // An exact match means that domain, path, and name are equal. If
            // both values are null, the cookies match. If both values are
            // non-null, the cookies match. If one value is null and the other
            // is non-null, the cookies do not match (i.e. "foo=;" and "foo;")
            boolean valuesMatch = !((value == null) ^ (in.value == null));
            return domain.equals(in.domain) && path.equals(in.path) &&
                    name.equals(in.name) && valuesMatch;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.548 -0500", hash_original_method = "AE74CD0D7D859A06FEAA31D7F99E4D83", hash_generated_method = "5EA36DC3E57D31AA105F550302CDD607")
        
boolean domainMatch(String urlHost) {
            if (domain.startsWith(".")) {
                if (urlHost.endsWith(domain.substring(1))) {
                    int len = domain.length();
                    int urlLen = urlHost.length();
                    if (urlLen > len - 1) {
                        // make sure bar.com doesn't match .ar.com
                        return urlHost.charAt(urlLen - len) == PERIOD;
                    }
                    return true;
                }
                return false;
            } else {
                // exact match if domain is not leading w/ dot
                return urlHost.equals(domain);
            }
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.551 -0500", hash_original_method = "0FD43CB7A1B51508534ED8D9F7B624E8", hash_generated_method = "9C66539CC742B320686392AD36889B54")
        
boolean pathMatch(String urlPath) {
            if (urlPath.startsWith(path)) {
                int len = path.length();
                if (len == 0) {
                    Log.w(LOGTAG, "Empty cookie path");
                    return false;
                }
                int urlLen = urlPath.length();
                if (path.charAt(len-1) != PATH_DELIM && urlLen > len) {
                    // make sure /wee doesn't match /we
                    return urlPath.charAt(len) == PATH_DELIM;
                }
                return true;
            }
            return false;
        }

        @DSSource({DSSourceKind.NETWORK})
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.553 -0500", hash_original_method = "08415E5687C0C693DFF8536ADAD3E2AA", hash_generated_method = "66C3B49355618198D7266A87F8C66D10")
        
public String toString() {
            return "domain: " + domain + "; path: " + path + "; name: " + name
                    + "; value: " + value;
        }
    }
    
    private static final class CookieComparator implements Comparator<Cookie> {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.157 -0400", hash_original_method = "EA07F3AA36DD3B1C5469CE7D110356B0", hash_generated_method = "EA07F3AA36DD3B1C5469CE7D110356B0")
        public CookieComparator ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.560 -0500", hash_original_method = "2F959C67E8DDB6BD10BD3460D506EDBA", hash_generated_method = "2E07D6C1DA3B791E7C764D88671094B7")
        
public int compare(Cookie cookie1, Cookie cookie2) {
            // According to RFC 2109, multiple cookies are ordered in a way such
            // that those with more specific Path attributes precede those with
            // less specific. Ordering with respect to other attributes (e.g.,
            // Domain) is unspecified.
            // As Set is not modified if the two objects are same, we do want to
            // assign different value for each cookie.
            int diff = cookie2.path.length() - cookie1.path.length();
            if (diff != 0) return diff;

            diff = cookie2.domain.length() - cookie1.domain.length();
            if (diff != 0) return diff;

            // If cookie2 has a null value, it should come later in
            // the list.
            if (cookie2.value == null) {
                // If both cookies have null values, fall back to using the name
                // difference.
                if (cookie1.value != null) {
                    return -1;
                }
            } else if (cookie1.value == null) {
                // Now we know that cookie2 does not have a null value, if
                // cookie1 has a null value, place it later in the list.
                return 1;
            }

            // Fallback to comparing the name to ensure consistent order.
            return cookie1.name.compareTo(cookie2.name);
        }
        
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.565 -0500", hash_original_method = "D1B429C0ADFDAAD2AA9A34491D464202", hash_generated_method = "7CA78116DACA37A676690D998A505551")
    
private CookieManager() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.567 -0500", hash_original_method = "192983167FE22E48CC26A3CAFDDD8D6B", hash_generated_method = "6D3F334E8E934FE8B33726A6E75490EE")
    
protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    /**
     * Control whether cookie is enabled or disabled
     * @param accept TRUE if accept cookie
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.572 -0500", hash_original_method = "0044CC48946D988BAC3F9C31DC5ECF6E", hash_generated_method = "B7376D77B769A65F1CC07D0018DDB18B")
    
public synchronized void setAcceptCookie(boolean accept) {
        if (JniUtil.useChromiumHttpStack()) {
            nativeSetAcceptCookie(accept);
            return;
        }

        mAcceptCookie = accept;
    }

    /**
     * Return whether cookie is enabled
     * @return TRUE if accept cookie
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.574 -0500", hash_original_method = "EAEA6182C3DE8E7E3FA46C84A2197DA5", hash_generated_method = "B180F6983476FEA8B8920141905124B4")
    
public synchronized boolean acceptCookie() {
        if (JniUtil.useChromiumHttpStack()) {
            return nativeAcceptCookie();
        }

        return mAcceptCookie;
    }

    /**
     * Set cookie for a given url. The old cookie with same host/path/name will
     * be removed. The new cookie will be added if it is not expired or it does
     * not have expiration which implies it is session cookie.
     * @param url The url which cookie is set for
     * @param value The value for set-cookie: in http response header
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.577 -0500", hash_original_method = "3C733C3F28B1C91BBFDBB065F4DCBFE1", hash_generated_method = "FE8729DC115F9EBD9D55754063D2EA3A")
    
public void setCookie(String url, String value) {
        if (JniUtil.useChromiumHttpStack()) {
            setCookie(url, value, false);
            return;
        }

        WebAddress uri;
        try {
            uri = new WebAddress(url);
        } catch (ParseException ex) {
            Log.e(LOGTAG, "Bad address: " + url);
            return;
        }

        setCookie(uri, value);
    }

    /**
     * Set cookie for a given url. The old cookie with same host/path/name will
     * be removed. The new cookie will be added if it is not expired or it does
     * not have expiration which implies it is session cookie.
     * @param url The url which cookie is set for
     * @param value The value for set-cookie: in http response header
     * @param privateBrowsing cookie jar to use
     * @hide hiding private browsing
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.579 -0500", hash_original_method = "FD6DC9D8EE462ADB809067B2E36820B1", hash_generated_method = "FDEB59589056420D1A8219C370655CD0")
    
public void setCookie(String url, String value, boolean privateBrowsing) {
        if (!JniUtil.useChromiumHttpStack()) {
            setCookie(url, value);
            return;
        }

        WebAddress uri;
        try {
            uri = new WebAddress(url);
        } catch (ParseException ex) {
            Log.e(LOGTAG, "Bad address: " + url);
            return;
        }

        nativeSetCookie(uri.toString(), value, privateBrowsing);
    }

    /**
     * Set cookie for a given uri. The old cookie with same host/path/name will
     * be removed. The new cookie will be added if it is not expired or it does
     * not have expiration which implies it is session cookie.
     * @param uri The uri which cookie is set for
     * @param value The value for set-cookie: in http response header
     * @hide - hide this because it takes in a parameter of type WebAddress,
     * a system private class.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.583 -0500", hash_original_method = "8AF5CC468B90A5A42A5116E5B0AA2987", hash_generated_method = "68A5F5C13A312CF02575B2A8F28C0224")
    
public synchronized void setCookie(WebAddress uri, String value) {
        if (JniUtil.useChromiumHttpStack()) {
            nativeSetCookie(uri.toString(), value, false);
            return;
        }

        if (value != null && value.length() > MAX_COOKIE_LENGTH) {
            return;
        }
        if (!mAcceptCookie || uri == null) {
            return;
        }
        if (DebugFlags.COOKIE_MANAGER) {
            Log.v(LOGTAG, "setCookie: uri: " + uri + " value: " + value);
        }

        String[] hostAndPath = getHostAndPath(uri);
        if (hostAndPath == null) {
            return;
        }
        
        // For default path, when setting a cookie, the spec says:
        //Path:   Defaults to the path of the request URL that generated the
        // Set-Cookie response, up to, but not including, the
        // right-most /.
        if (hostAndPath[1].length() > 1) {
            int index = hostAndPath[1].lastIndexOf(PATH_DELIM);
            hostAndPath[1] = hostAndPath[1].substring(0, 
                    index > 0 ? index : index + 1);
        }

        ArrayList<Cookie> cookies = null;
        try {
            cookies = parseCookie(hostAndPath[0], hostAndPath[1], value);
        } catch (RuntimeException ex) {
            Log.e(LOGTAG, "parse cookie failed for: " + value);
        }

        if (cookies == null || cookies.size() == 0) {
            return;
        }

        String baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
        if (cookieList == null) {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        }

        long now = System.currentTimeMillis();
        int size = cookies.size();
        for (int i = 0; i < size; i++) {
            Cookie cookie = cookies.get(i);

            boolean done = false;
            Iterator<Cookie> iter = cookieList.iterator();
            while (iter.hasNext()) {
                Cookie cookieEntry = iter.next();
                if (cookie.exactMatch(cookieEntry)) {
                    // expires == -1 means no expires defined. Otherwise
                    // negative means far future
                    if (cookie.expires < 0 || cookie.expires > now) {
                        // secure cookies can't be overwritten by non-HTTPS url
                        if (!cookieEntry.secure || HTTPS.equals(uri.getScheme())) {
                            cookieEntry.value = cookie.value;
                            cookieEntry.expires = cookie.expires;
                            cookieEntry.secure = cookie.secure;
                            cookieEntry.lastAcessTime = now;
                            cookieEntry.lastUpdateTime = now;
                            cookieEntry.mode = Cookie.MODE_REPLACED;
                        }
                    } else {
                        cookieEntry.lastUpdateTime = now;
                        cookieEntry.mode = Cookie.MODE_DELETED;
                    }
                    done = true;
                    break;
                }
            }

            // expires == -1 means no expires defined. Otherwise negative means
            // far future
            if (!done && (cookie.expires < 0 || cookie.expires > now)) {
                cookie.lastAcessTime = now;
                cookie.lastUpdateTime = now;
                cookie.mode = Cookie.MODE_NEW;
                if (cookieList.size() > MAX_COOKIE_COUNT_PER_BASE_DOMAIN) {
                    Cookie toDelete = new Cookie();
                    toDelete.lastAcessTime = now;
                    Iterator<Cookie> iter2 = cookieList.iterator();
                    while (iter2.hasNext()) {
                        Cookie cookieEntry2 = iter2.next();
                        if ((cookieEntry2.lastAcessTime < toDelete.lastAcessTime)
                                && cookieEntry2.mode != Cookie.MODE_DELETED) {
                            toDelete = cookieEntry2;
                        }
                    }
                    toDelete.mode = Cookie.MODE_DELETED;
                }
                cookieList.add(cookie);
            }
        }
    }

    /**
     * Get cookie(s) for a given url so that it can be set to "cookie:" in http
     * request header.
     * @param url The url needs cookie
     * @return The cookies in the format of NAME=VALUE [; NAME=VALUE]
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.586 -0500", hash_original_method = "CFFC2606C8B97641601C2B54714068BC", hash_generated_method = "830F33A2CDAF3F84C95EBE9D142A6A26")
    
public String getCookie(String url) {
        if (JniUtil.useChromiumHttpStack()) {
            return getCookie(url, false);
        }

        WebAddress uri;
        try {
            uri = new WebAddress(url);
        } catch (ParseException ex) {
            Log.e(LOGTAG, "Bad address: " + url);
            return null;
        }

        return getCookie(uri);
    }

    /**
     * Get cookie(s) for a given url so that it can be set to "cookie:" in http
     * request header.
     * @param url The url needs cookie
     * @param privateBrowsing cookie jar to use
     * @return The cookies in the format of NAME=VALUE [; NAME=VALUE]
     * @hide Private mode is not very well exposed for now
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.588 -0500", hash_original_method = "5ACC35EE5D78B03ACC91967E6F456E58", hash_generated_method = "4D5DBE5CE059E56BD529F447878E5099")
    
public String getCookie(String url, boolean privateBrowsing) {
        if (!JniUtil.useChromiumHttpStack()) {
            // Just redirect to regular get cookie for android stack
            return getCookie(url);
        }

        WebAddress uri;
        try {
            uri = new WebAddress(url);
        } catch (ParseException ex) {
            Log.e(LOGTAG, "Bad address: " + url);
            return null;
        }

        return nativeGetCookie(uri.toString(), privateBrowsing);
    }

    /**
     * Get cookie(s) for a given uri so that it can be set to "cookie:" in http
     * request header.
     * @param uri The uri needs cookie
     * @return The cookies in the format of NAME=VALUE [; NAME=VALUE]
     * @hide - hide this because it has a parameter of type WebAddress, which
     * is a system private class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.593 -0500", hash_original_method = "BE3F143473537E9CE993D89B685428CF", hash_generated_method = "AA990C1922C046F320802845178EDD5E")
    
public synchronized String getCookie(WebAddress uri) {
        if (JniUtil.useChromiumHttpStack()) {
            return nativeGetCookie(uri.toString(), false);
        }

        if (!mAcceptCookie || uri == null) {
            return null;
        }
   
        String[] hostAndPath = getHostAndPath(uri);
        if (hostAndPath == null) {
            return null;
        }

        String baseDomain = getBaseDomain(hostAndPath[0]);
        ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
        if (cookieList == null) {
            cookieList = CookieSyncManager.getInstance()
                    .getCookiesForDomain(baseDomain);
            mCookieMap.put(baseDomain, cookieList);
        }

        long now = System.currentTimeMillis();
        boolean secure = HTTPS.equals(uri.getScheme());
        Iterator<Cookie> iter = cookieList.iterator();

        SortedSet<Cookie> cookieSet = new TreeSet<Cookie>(COMPARATOR);
        while (iter.hasNext()) {
            Cookie cookie = iter.next();
            if (cookie.domainMatch(hostAndPath[0]) &&
                    cookie.pathMatch(hostAndPath[1])
                    // expires == -1 means no expires defined. Otherwise
                    // negative means far future
                    && (cookie.expires < 0 || cookie.expires > now)
                    && (!cookie.secure || secure)
                    && cookie.mode != Cookie.MODE_DELETED) {
                cookie.lastAcessTime = now;
                cookieSet.add(cookie);
            }
        }

        StringBuilder ret = new StringBuilder(256);
        Iterator<Cookie> setIter = cookieSet.iterator();
        while (setIter.hasNext()) {
            Cookie cookie = setIter.next();
            if (ret.length() > 0) {
                ret.append(SEMICOLON);
                // according to RC2109, SEMICOLON is official separator,
                // but when log in yahoo.com, it needs WHITE_SPACE too.
                ret.append(WHITE_SPACE);
            }

            ret.append(cookie.name);
            if (cookie.value != null) {
                ret.append(EQUAL);
                ret.append(cookie.value);
            }
        }

        if (ret.length() > 0) {
            if (DebugFlags.COOKIE_MANAGER) {
                Log.v(LOGTAG, "getCookie: uri: " + uri + " value: " + ret);
            }
            return ret.toString();
        } else {
            if (DebugFlags.COOKIE_MANAGER) {
                Log.v(LOGTAG, "getCookie: uri: " + uri
                        + " But can't find cookie.");
            }
            return null;
        }
    }

    /**
     * Waits for pending operations to completed.
     * {@hide}  Too late to release publically.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.596 -0500", hash_original_method = "E5896ED24A303B704C1A851D6E9894DE", hash_generated_method = "168696F32F6CF2E9BFE1784A56B00332")
    
public void waitForCookieOperationsToComplete() {
        // Note that this function is applicable for both the java
        // and native http stacks, and works correctly with either.
        synchronized (this) {
            while (pendingCookieOperations > 0) {
                try {
                    wait();
                } catch (InterruptedException e) { }
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.598 -0500", hash_original_method = "65B0411E3AAD9BA729084C50D7485B13", hash_generated_method = "546BDABBE3929411E17F576BE1FD9961")
    
private synchronized void signalCookieOperationsComplete() {
        pendingCookieOperations--;
        assert pendingCookieOperations > -1;
        notify();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.600 -0500", hash_original_method = "3D00699F37AF6D5720F5926DFEED864B", hash_generated_method = "040CAD6D5912124CE2A118841C2472B4")
    
private synchronized void signalCookieOperationsStart() {
        pendingCookieOperations++;
    }

    /**
     * Remove all session cookies, which are cookies without expiration date
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.609 -0500", hash_original_method = "E9CA847999E57130D19A4C553707D595", hash_generated_method = "35A6245350BA89B9D1AFC9D1408998A0")
    
public void removeSessionCookie() {
        signalCookieOperationsStart();
        if (JniUtil.useChromiumHttpStack()) {
            new AsyncTask<Void, Void, Void>() {
                protected Void doInBackground(Void... none) {
                    nativeRemoveSessionCookie();
                    signalCookieOperationsComplete();
                    return null;
                }
            }.execute();
            return;
        }

        final Runnable clearCache = new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
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
    }

    /**
     * Remove all cookies
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.616 -0500", hash_original_method = "E6726E6A7287E971302CDEBC56D91ADA", hash_generated_method = "F7782F661BDC204D435810D6A8CA9452")
    
public void removeAllCookie() {
        if (JniUtil.useChromiumHttpStack()) {
            nativeRemoveAllCookie();
            return;
        }

        final Runnable clearCache = new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        public void run() {
                synchronized(CookieManager.this) {
                    mCookieMap = new LinkedHashMap<String, ArrayList<Cookie>>(
                            MAX_DOMAIN_COUNT, 0.75f, true);
                    CookieSyncManager.getInstance().clearAllCookies();
                }
            }
        };
        new Thread(clearCache).start();
    }

    /**
     *  Return true if there are stored cookies.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.618 -0500", hash_original_method = "2201D105B8AC0DA82BEBC1DB9FB29AE8", hash_generated_method = "4EEF790287B80339924484EFECFB0831")
    
public synchronized boolean hasCookies() {
        if (JniUtil.useChromiumHttpStack()) {
            return hasCookies(false);
        }

        return CookieSyncManager.getInstance().hasCookies();
    }

    /**
     *  Return true if there are stored cookies.
     *  @param privateBrowsing cookie jar to use
     *  @hide Hiding private mode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.621 -0500", hash_original_method = "6C96B3E47AB792BE3053A98B747C02B0", hash_generated_method = "762C6F42E9E67BA3B76C7151964CBF27")
    
public synchronized boolean hasCookies(boolean privateBrowsing) {
        if (!JniUtil.useChromiumHttpStack()) {
            return hasCookies();
        }

        return nativeHasCookies(privateBrowsing);
    }

    /**
     * Remove all expired cookies
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.627 -0500", hash_original_method = "EBBBDCC80F6ABDA541004A954FD75C00", hash_generated_method = "6D0268756977AA60E0FD133F74344ED7")
    
public void removeExpiredCookie() {
        if (JniUtil.useChromiumHttpStack()) {
            nativeRemoveExpiredCookie();
            return;
        }

        final Runnable clearCache = new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
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
                            // expires == -1 means no expires defined. Otherwise 
                            // negative means far future
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
    }

    /**
     * Package level api, called from CookieSyncManager
     *
     * Flush all cookies managed by the Chrome HTTP stack to flash.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.629 -0500", hash_original_method = "6E81366EB3EC21A5D57BD56704F05E83", hash_generated_method = "6E81366EB3EC21A5D57BD56704F05E83")
    
void flushCookieStore() {
        if (JniUtil.useChromiumHttpStack()) {
            nativeFlushCookieStore();
        }
    }

    /**
     * Package level api, called from CookieSyncManager
     *
     * Get a list of cookies which are updated since a given time.
     * @param last The given time in millisec
     * @return A list of cookies
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.637 -0500", hash_original_method = "F607692A589F63FF1216167E4F5DA44E", hash_generated_method = "1BE8C4C7D6C04AEB757CF034AA70A1A5")
    
synchronized ArrayList<Cookie> getUpdatedCookiesSince(long last) {
        ArrayList<Cookie> cookies = new ArrayList<Cookie>();
        Collection<ArrayList<Cookie>> cookieList = mCookieMap.values();
        Iterator<ArrayList<Cookie>> listIter = cookieList.iterator();
        while (listIter.hasNext()) {
            ArrayList<Cookie> list = listIter.next();
            Iterator<Cookie> iter = list.iterator();
            while (iter.hasNext()) {
                Cookie cookie = iter.next();
                if (cookie.lastUpdateTime > last) {
                    cookies.add(cookie);
                }
            }
        }
        return cookies;
    }

    /**
     * Package level api, called from CookieSyncManager
     *
     * Delete a Cookie in the RAM
     * @param cookie Cookie to be deleted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.639 -0500", hash_original_method = "EBDE0BAE6A65E045698E84F7289F4664", hash_generated_method = "0E4864763233876F8875A8560CBC3873")
    
synchronized void deleteACookie(Cookie cookie) {
        if (cookie.mode == Cookie.MODE_DELETED) {
            String baseDomain = getBaseDomain(cookie.domain);
            ArrayList<Cookie> cookieList = mCookieMap.get(baseDomain);
            if (cookieList != null) {
                cookieList.remove(cookie);
                if (cookieList.isEmpty()) {
                    mCookieMap.remove(baseDomain);
                }
            }
        }
    }

    /**
     * Package level api, called from CookieSyncManager
     *
     * Called after a cookie is synced to FLASH
     * @param cookie Cookie to be synced
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.641 -0500", hash_original_method = "23D0913407E37C8868B97CA5EA461217", hash_generated_method = "A389FCA1130A717D740B7FD1F0E2C17E")
    
synchronized void syncedACookie(Cookie cookie) {
        cookie.mode = Cookie.MODE_NORMAL;
    }

    /**
     * Package level api, called from CookieSyncManager
     *
     * Delete the least recent used domains if the total cookie count in RAM
     * exceeds the limit
     * @return A list of cookies which are removed from RAM
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.645 -0500", hash_original_method = "37E656A6EDF347445C1655B2E42F538E", hash_generated_method = "37AF33C9029C525839FDBA472304273B")
    
synchronized ArrayList<Cookie> deleteLRUDomain() {
        int count = 0;
        int byteCount = 0;
        int mapSize = mCookieMap.size();

        if (mapSize < MAX_RAM_DOMAIN_COUNT) {
            Collection<ArrayList<Cookie>> cookieLists = mCookieMap.values();
            Iterator<ArrayList<Cookie>> listIter = cookieLists.iterator();
            while (listIter.hasNext() && count < MAX_RAM_COOKIES_COUNT) {
                ArrayList<Cookie> list = listIter.next();
                if (DebugFlags.COOKIE_MANAGER) {
                    Iterator<Cookie> iter = list.iterator();
                    while (iter.hasNext() && count < MAX_RAM_COOKIES_COUNT) {
                        Cookie cookie = iter.next();
                        // 14 is 3 * sizeof(long) + sizeof(boolean)
                        // + sizeof(byte)
                        byteCount += cookie.domain.length()
                                + cookie.path.length()
                                + cookie.name.length()
                                + (cookie.value != null
                                        ? cookie.value.length()
                                        : 0)
                                + 14;
                        count++;
                    }
                } else {
                    count += list.size();
                }
            }
        }

        ArrayList<Cookie> retlist = new ArrayList<Cookie>();
        if (mapSize >= MAX_RAM_DOMAIN_COUNT || count >= MAX_RAM_COOKIES_COUNT) {
            if (DebugFlags.COOKIE_MANAGER) {
                Log.v(LOGTAG, count + " cookies used " + byteCount
                        + " bytes with " + mapSize + " domains");
            }
            Object[] domains = mCookieMap.keySet().toArray();
            int toGo = mapSize / 10 + 1;
            while (toGo-- > 0){
                String domain = domains[toGo].toString();
                if (DebugFlags.COOKIE_MANAGER) {
                    Log.v(LOGTAG, "delete domain: " + domain
                            + " from RAM cache");
                }
                retlist.addAll(mCookieMap.get(domain));
                mCookieMap.remove(domain);
            }
        }
        return retlist;
    }

    /**
     * Extract the host and path out of a uri
     * @param uri The given WebAddress
     * @return The host and path in the format of String[], String[0] is host
     *          which has at least two periods, String[1] is path which always
     *          ended with "/"
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.648 -0500", hash_original_method = "5193D0EACEE146C23C2F9C98185BC9CF", hash_generated_method = "B7D42267FECCB5489BFD758DC7726422")
    
private String[] getHostAndPath(WebAddress uri) {
        if (uri.getHost() != null && uri.getPath() != null) {

            /*
             * The domain (i.e. host) portion of the cookie is supposed to be
             * case-insensitive. We will consistently return the domain in lower
             * case, which allows us to do the more efficient equals comparison
             * instead of equalIgnoreCase.
             *
             * See: http://www.ieft.org/rfc/rfc2965.txt (Section 3.3.3)
             */
            String[] ret = new String[2];
            ret[0] = uri.getHost().toLowerCase();
            ret[1] = uri.getPath();

            int index = ret[0].indexOf(PERIOD);
            if (index == -1) {
                if (uri.getScheme().equalsIgnoreCase("file")) {
                    // There is a potential bug where a local file path matches
                    // another file in the local web server directory. Still
                    // "localhost" is the best pseudo domain name.
                    ret[0] = "localhost";
                }
            } else if (index == ret[0].lastIndexOf(PERIOD)) {
                // cookie host must have at least two periods
                ret[0] = PERIOD + ret[0];
            }

            if (ret[1].charAt(0) != PATH_DELIM) {
                return null;
            }

            /*
             * find cookie path, e.g. for http://www.google.com, the path is "/"
             * for http://www.google.com/lab/, the path is "/lab"
             * for http://www.google.com/lab/foo, the path is "/lab/foo"
             * for http://www.google.com/lab?hl=en, the path is "/lab"
             * for http://www.google.com/lab.asp?hl=en, the path is "/lab.asp"
             * Note: the path from URI has at least one "/"
             * See:
             * http://www.unix.com.ua/rfc/rfc2109.html
             */
            index = ret[1].indexOf(QUESTION_MARK);
            if (index != -1) {
                ret[1] = ret[1].substring(0, index);
            }

            return ret;
        } else
            return null;
    }

    /**
     * Get the base domain for a give host. E.g. mail.google.com will return
     * google.com
     * @param host The give host
     * @return the base domain
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.650 -0500", hash_original_method = "0BC29AC3055E44155EBF14855C5D487F", hash_generated_method = "EEC25C8F6A177D8FA6AAD21B22507415")
    
private String getBaseDomain(String host) {
        int startIndex = 0;
        int nextIndex = host.indexOf(PERIOD);
        int lastIndex = host.lastIndexOf(PERIOD);
        while (nextIndex < lastIndex) {
            startIndex = nextIndex + 1;
            nextIndex = host.indexOf(PERIOD, startIndex);
        }
        if (startIndex > 0) {
            return host.substring(startIndex);
        } else {
            return host;
        }
    }
    static {
        Arrays.sort(BAD_COUNTRY_2LDS);
    }

    /**
     * parseCookie() parses the cookieString which is a comma-separated list of
     * one or more cookies in the format of "NAME=VALUE; expires=DATE;
     * path=PATH; domain=DOMAIN_NAME; secure httponly" to a list of Cookies.
     * Here is a sample: IGDND=1, IGPC=ET=UB8TSNwtDmQ:AF=0; expires=Sun,
     * 17-Jan-2038 19:14:07 GMT; path=/ig; domain=.google.com, =,
     * PREF=ID=408909b1b304593d:TM=1156459854:LM=1156459854:S=V-vCAU6Sh-gobCfO;
     * expires=Sun, 17-Jan-2038 19:14:07 GMT; path=/; domain=.google.com which
     * contains 3 cookies IGDND, IGPC, PREF and an empty cookie
     * @param host The default host
     * @param path The default path
     * @param cookieString The string coming from "Set-Cookie:"
     * @return A list of Cookies
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:16.657 -0500", hash_original_method = "686D7BF75F67F22DBAC0E1E36B7A58EB", hash_generated_method = "212251E1BC3E86E873859FCFE5219FB9")
    
private ArrayList<Cookie> parseCookie(String host, String path,
            String cookieString) {
        ArrayList<Cookie> ret = new ArrayList<Cookie>();

        int index = 0;
        int length = cookieString.length();
        while (true) {
            Cookie cookie = null;

            // done
            if (index < 0 || index >= length) {
                break;
            }

            // skip white space
            if (cookieString.charAt(index) == WHITE_SPACE) {
                index++;
                continue;
            }

            /*
             * get NAME=VALUE; pair. detecting the end of a pair is tricky, it
             * can be the end of a string, like "foo=bluh", it can be semicolon
             * like "foo=bluh;path=/"; or it can be enclosed by \", like
             * "foo=\"bluh bluh\";path=/"
             *
             * Note: in the case of "foo=bluh, bar=bluh;path=/", we interpret
             * it as one cookie instead of two cookies.
             */
            int semicolonIndex = cookieString.indexOf(SEMICOLON, index);
            int equalIndex = cookieString.indexOf(EQUAL, index);
            cookie = new Cookie(host, path);

            // Cookies like "testcookie; path=/;" are valid and used
            // (lovefilm.se).
            // Look for 2 cases:
            // 1. "foo" or "foo;" where equalIndex is -1
            // 2. "foo; path=..." where the first semicolon is before an equal
            //    and a semicolon exists.
            if ((semicolonIndex != -1 && (semicolonIndex < equalIndex)) ||
                    equalIndex == -1) {
                // Fix up the index in case we have a string like "testcookie"
                if (semicolonIndex == -1) {
                    semicolonIndex = length;
                }
                cookie.name = cookieString.substring(index, semicolonIndex);
                cookie.value = null;
            } else {
                cookie.name = cookieString.substring(index, equalIndex);
                // Make sure we do not throw an exception if the cookie is like
                // "foo="
                if ((equalIndex < length - 1) &&
                        (cookieString.charAt(equalIndex + 1) == QUOTATION)) {
                    index = cookieString.indexOf(QUOTATION, equalIndex + 2);
                    if (index == -1) {
                        // bad format, force return
                        break;
                    }
                }
                // Get the semicolon index again in case it was contained within
                // the quotations.
                semicolonIndex = cookieString.indexOf(SEMICOLON, index);
                if (semicolonIndex == -1) {
                    semicolonIndex = length;
                }
                if (semicolonIndex - equalIndex > MAX_COOKIE_LENGTH) {
                    // cookie is too big, trim it
                    cookie.value = cookieString.substring(equalIndex + 1,
                            equalIndex + 1 + MAX_COOKIE_LENGTH);
                } else if (equalIndex + 1 == semicolonIndex
                        || semicolonIndex < equalIndex) {
                    // this is an unusual case like "foo=;" or "foo="
                    cookie.value = "";
                } else {
                    cookie.value = cookieString.substring(equalIndex + 1,
                            semicolonIndex);
                }
            }
            // get attributes
            index = semicolonIndex;
            while (true) {
                // done
                if (index < 0 || index >= length) {
                    break;
                }

                // skip white space and semicolon
                if (cookieString.charAt(index) == WHITE_SPACE
                        || cookieString.charAt(index) == SEMICOLON) {
                    index++;
                    continue;
                }

                // comma means next cookie
                if (cookieString.charAt(index) == COMMA) {
                    index++;
                    break;
                }

                // "secure" is a known attribute doesn't use "=";
                // while sites like live.com uses "secure="
                if (length - index >= SECURE_LENGTH
                        && cookieString.substring(index, index + SECURE_LENGTH).
                        equalsIgnoreCase(SECURE)) {
                    index += SECURE_LENGTH;
                    cookie.secure = true;
                    if (index == length) break;
                    if (cookieString.charAt(index) == EQUAL) index++;
                    continue;
                }

                // "httponly" is a known attribute doesn't use "=";
                // while sites like live.com uses "httponly="
                if (length - index >= HTTP_ONLY_LENGTH
                        && cookieString.substring(index,
                            index + HTTP_ONLY_LENGTH).
                        equalsIgnoreCase(HTTP_ONLY)) {
                    index += HTTP_ONLY_LENGTH;
                    if (index == length) break;
                    if (cookieString.charAt(index) == EQUAL) index++;
                    // FIXME: currently only parse the attribute
                    continue;
                }
                equalIndex = cookieString.indexOf(EQUAL, index);
                if (equalIndex > 0) {
                    String name = cookieString.substring(index, equalIndex).toLowerCase();
                    int valueIndex = equalIndex + 1;
                    while (valueIndex < length && cookieString.charAt(valueIndex) == WHITE_SPACE) {
                        valueIndex++;
                    }

                    if (name.equals(EXPIRES)) {
                        int comaIndex = cookieString.indexOf(COMMA, equalIndex);

                        // skip ',' in (Wdy, DD-Mon-YYYY HH:MM:SS GMT) or
                        // (Weekday, DD-Mon-YY HH:MM:SS GMT) if it applies.
                        // "Wednesday" is the longest Weekday which has length 9
                        if ((comaIndex != -1) &&
                                (comaIndex - valueIndex <= 10)) {
                            index = comaIndex + 1;
                        }
                    }
                    semicolonIndex = cookieString.indexOf(SEMICOLON, index);
                    int commaIndex = cookieString.indexOf(COMMA, index);
                    if (semicolonIndex == -1 && commaIndex == -1) {
                        index = length;
                    } else if (semicolonIndex == -1) {
                        index = commaIndex;
                    } else if (commaIndex == -1) {
                        index = semicolonIndex;
                    } else {
                        index = Math.min(semicolonIndex, commaIndex);
                    }
                    String value = cookieString.substring(valueIndex, index);
                    
                    // Strip quotes if they exist
                    if (value.length() > 2 && value.charAt(0) == QUOTATION) {
                        int endQuote = value.indexOf(QUOTATION, 1);
                        if (endQuote > 0) {
                            value = value.substring(1, endQuote);
                        }
                    }
                    if (name.equals(EXPIRES)) {
                        try {
                            cookie.expires = AndroidHttpClient.parseDate(value);
                        } catch (IllegalArgumentException ex) {
                            Log.e(LOGTAG,
                                    "illegal format for expires: " + value);
                        }
                    } else if (name.equals(MAX_AGE)) {
                        try {
                            cookie.expires = System.currentTimeMillis() + 1000
                                    * Long.parseLong(value);
                        } catch (NumberFormatException ex) {
                            Log.e(LOGTAG,
                                    "illegal format for max-age: " + value);
                        }
                    } else if (name.equals(PATH)) {
                        // only allow non-empty path value
                        if (value.length() > 0) {
                            cookie.path = value;
                        }
                    } else if (name.equals(DOMAIN)) {
                        int lastPeriod = value.lastIndexOf(PERIOD);
                        if (lastPeriod == 0) {
                            // disallow cookies set for TLDs like [.com]
                            cookie.domain = null;
                            continue;
                        }
                        try {
                            Integer.parseInt(value.substring(lastPeriod + 1));
                            // no wildcard for ip address match
                            if (!value.equals(host)) {
                                // no cross-site cookie
                                cookie.domain = null;
                            }
                            continue;
                        } catch (NumberFormatException ex) {
                            // ignore the exception, value is a host name
                        }
                        value = value.toLowerCase();
                        if (value.charAt(0) != PERIOD) {
                            // pre-pended dot to make it as a domain cookie
                            value = PERIOD + value;
                            lastPeriod++;
                        }
                        if (host.endsWith(value.substring(1))) {
                            int len = value.length();
                            int hostLen = host.length();
                            if (hostLen > (len - 1)
                                    && host.charAt(hostLen - len) != PERIOD) {
                                // make sure the bar.com doesn't match .ar.com
                                cookie.domain = null;
                                continue;
                            }
                            // disallow cookies set on ccTLDs like [.co.uk]
                            if ((len == lastPeriod + 3)
                                    && (len >= 6 && len <= 8)) {
                                String s = value.substring(1, lastPeriod);
                                if (Arrays.binarySearch(BAD_COUNTRY_2LDS, s) >= 0) {
                                    cookie.domain = null;
                                    continue;
                                }
                            }
                            cookie.domain = value;
                        } else {
                            // no cross-site or more specific sub-domain cookie
                            cookie.domain = null;
                        }
                    }
                } else {
                    // bad format, force return
                    index = length;
                }
            }
            if (cookie != null && cookie.domain != null) {
                ret.add(cookie);
            }
        }
        return ret;
    }
}

