package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.179 -0400", hash_original_field = "55E7DD3016CE4AC57B9A0F56AF12F7C2", hash_generated_field = "889AFA10BF8703D281158D946DEF0E23")

    private ArrayList<Cookie> cookies;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.179 -0400", hash_original_field = "FBCB977535D84EAAA96CA6649D45EFEF", hash_generated_field = "7D5FE1B394E08AAC5030ED65F9BDE34B")

    private Comparator<Cookie> cookieComparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.179 -0400", hash_original_method = "7CB52AB4B53860D7A09DB1DA893E1548", hash_generated_method = "22D06068CA70CB1411551B0651180E58")
    public  BasicCookieStore() {
        super();
        this.cookies = new ArrayList<Cookie>();
        this.cookieComparator = new CookieIdentityComparator();
        // ---------- Original Method ----------
        //this.cookies = new ArrayList<Cookie>();
        //this.cookieComparator = new CookieIdentityComparator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.180 -0400", hash_original_method = "47E381A9C2C1FA70862098466A29B040", hash_generated_method = "3AF70D86A1DC14A375A98C948DE4DAD9")
    public synchronized void addCookie(Cookie cookie) {
        {
            {
                Iterator<Cookie> it;
                it = cookies.iterator();
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1370004078 = (it.hasNext());
                {
                    {
                        boolean var39AA3484C1B326B513DA1E2E0D03DBDA_182778413 = (cookieComparator.compare(cookie, it.next()) == 0);
                        {
                            it.remove();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean var81F836D123110EAEA44D780EC254A0E1_59889162 = (!cookie.isExpired(new Date()));
                {
                    cookies.add(cookie);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(cookie.getTaint());
        // ---------- Original Method ----------
        //if (cookie != null) {
            //for (Iterator<Cookie> it = cookies.iterator(); it.hasNext();) {
                //if (cookieComparator.compare(cookie, it.next()) == 0) {
                    //it.remove();
                    //break;
                //}
            //}
            //if (!cookie.isExpired(new Date())) {
                //cookies.add(cookie);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.185 -0400", hash_original_method = "E08AF67230303C760B74C49856ED8B12", hash_generated_method = "8172B712B9DD6F537580CE04D85A684D")
    public synchronized void addCookies(Cookie[] cookies) {
        {
            {
                Cookie cooky = cookies[0];
                {
                    this.addCookie(cooky);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(cookies[0].getTaint());
        // ---------- Original Method ----------
        //if (cookies != null) {
            //for (Cookie cooky : cookies) {
                //this.addCookie(cooky);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.186 -0400", hash_original_method = "4518D291A6406FB94614916CA57C71BE", hash_generated_method = "C5A709216F97FD0A5FE114EB0A78FD78")
    public synchronized List<Cookie> getCookies() {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1332803941 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1332803941 = Collections.unmodifiableList(this.cookies);
        varB4EAC82CA7396A68D541C85D26508E83_1332803941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1332803941;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(this.cookies);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.186 -0400", hash_original_method = "882C42ACB6CC9EA440C89C4BE76EF44B", hash_generated_method = "CCE0D5B566ACC964EBA2E5EAEC11B229")
    public synchronized boolean clearExpired(final Date date) {
        boolean removed;
        removed = false;
        {
            Iterator<Cookie> it;
            it = cookies.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_221606168 = (it.hasNext());
            {
                {
                    boolean var5F97C8AE6F8247FAF80BB094BE784ECA_64660498 = (it.next().isExpired(date));
                    {
                        it.remove();
                        removed = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(date.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057007402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057007402;
        // ---------- Original Method ----------
        //if (date == null) {
            //return false;
        //}
        //boolean removed = false;
        //for (Iterator<Cookie> it = cookies.iterator(); it.hasNext();) {
            //if (it.next().isExpired(date)) {
                //it.remove();
                //removed = true;
            //}
        //}
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.201 -0400", hash_original_method = "3BF0AB240A348C3188E3D51149860C91", hash_generated_method = "A8F758AB97544CFE1D0BDC6624900FEB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_617588075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_617588075 = cookies.toString();
        varB4EAC82CA7396A68D541C85D26508E83_617588075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_617588075;
        // ---------- Original Method ----------
        //return cookies.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.202 -0400", hash_original_method = "918F9BD76316B2620CCA2503ADA6AAF2", hash_generated_method = "31DAF4A715C672504B7C730D1B4A0A58")
    public synchronized void clear() {
        cookies.clear();
        // ---------- Original Method ----------
        //cookies.clear();
    }

    
}

