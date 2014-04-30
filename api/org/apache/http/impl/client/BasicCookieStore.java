package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieIdentityComparator;

public class BasicCookieStore implements CookieStore {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.540 -0500", hash_original_field = "857FB572661B8DF2EA46EDCCE0F39FF4", hash_generated_field = "889AFA10BF8703D281158D946DEF0E23")

    private  ArrayList<Cookie> cookies;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.542 -0500", hash_original_field = "530902EC2CBE0E7B976D4A090E07685B", hash_generated_field = "7D5FE1B394E08AAC5030ED65F9BDE34B")

    private  Comparator<Cookie> cookieComparator;
    
    // -------------------------------------------------------- Class Variables

    /**
     * Default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.545 -0500", hash_original_method = "7CB52AB4B53860D7A09DB1DA893E1548", hash_generated_method = "888F20966991AE81C667B903F9B4799E")
    
public BasicCookieStore() {
        super();
        this.cookies = new ArrayList<Cookie>();
        this.cookieComparator = new CookieIdentityComparator();
    }

    /**
     * Adds an {@link Cookie HTTP cookie}, replacing any existing equivalent cookies.
     * If the given cookie has already expired it will not be added, but existing 
     * values will still be removed.
     * 
     * @param cookie the {@link Cookie cookie} to be added
     * 
     * @see #addCookies(Cookie[])
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.548 -0500", hash_original_method = "47E381A9C2C1FA70862098466A29B040", hash_generated_method = "71248FA2B4A9118200223D402E4C25A9")
    
public synchronized void addCookie(Cookie cookie) {
        if (cookie != null) {
            // first remove any old cookie that is equivalent
            for (Iterator<Cookie> it = cookies.iterator(); it.hasNext();) {
                if (cookieComparator.compare(cookie, it.next()) == 0) {
                    it.remove();
                    break;
                }
            }
            if (!cookie.isExpired(new Date())) {
                cookies.add(cookie);
            }
        }
    }

    /**
     * Adds an array of {@link Cookie HTTP cookies}. Cookies are added individually and 
     * in the given array order. If any of the given cookies has already expired it will 
     * not be added, but existing values will still be removed.
     * 
     * @param cookies the {@link Cookie cookies} to be added
     * 
     * @see #addCookie(Cookie)
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.550 -0500", hash_original_method = "E08AF67230303C760B74C49856ED8B12", hash_generated_method = "008F927C6A22C75725D8F408C043D635")
    
public synchronized void addCookies(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                this.addCookie(cooky);
            }
        }
    }

    /**
     * Returns an immutable array of {@link Cookie cookies} that this HTTP
     * state currently contains.
     * 
     * @return an array of {@link Cookie cookies}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.553 -0500", hash_original_method = "4518D291A6406FB94614916CA57C71BE", hash_generated_method = "B03207FF93EBC9252776C36B81C2329D")
    
public synchronized List<Cookie> getCookies() {
        return Collections.unmodifiableList(this.cookies);
    }

    /**
     * Removes all of {@link Cookie cookies} in this HTTP state
     * that have expired by the specified {@link java.util.Date date}. 
     * 
     * @return true if any cookies were purged.
     * 
     * @see Cookie#isExpired(Date)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.556 -0500", hash_original_method = "882C42ACB6CC9EA440C89C4BE76EF44B", hash_generated_method = "9BD6C188A5E52262005E7053BA74231C")
    
public synchronized boolean clearExpired(final Date date) {
        if (date == null) {
            return false;
        }
        boolean removed = false;
        for (Iterator<Cookie> it = cookies.iterator(); it.hasNext();) {
            if (it.next().isExpired(date)) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.559 -0500", hash_original_method = "3BF0AB240A348C3188E3D51149860C91", hash_generated_method = "DD60D1499FF9AAF6DD237D4EE34C3711")
    
@Override
    public String toString() {
        return cookies.toString();
    }
    
    /**
     * Clears all cookies.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.561 -0500", hash_original_method = "918F9BD76316B2620CCA2503ADA6AAF2", hash_generated_method = "949F95E24D4D8B7381B3B7E2455D8467")
    
public synchronized void clear() {
        cookies.clear();
    }
    
}

