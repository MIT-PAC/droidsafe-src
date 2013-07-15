package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.309 -0400", hash_original_field = "55E7DD3016CE4AC57B9A0F56AF12F7C2", hash_generated_field = "889AFA10BF8703D281158D946DEF0E23")

    private ArrayList<Cookie> cookies;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.309 -0400", hash_original_field = "FBCB977535D84EAAA96CA6649D45EFEF", hash_generated_field = "7D5FE1B394E08AAC5030ED65F9BDE34B")

    private Comparator<Cookie> cookieComparator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.310 -0400", hash_original_method = "7CB52AB4B53860D7A09DB1DA893E1548", hash_generated_method = "22D06068CA70CB1411551B0651180E58")
    public  BasicCookieStore() {
        super();
        this.cookies = new ArrayList<Cookie>();
        this.cookieComparator = new CookieIdentityComparator();
        // ---------- Original Method ----------
        //this.cookies = new ArrayList<Cookie>();
        //this.cookieComparator = new CookieIdentityComparator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.310 -0400", hash_original_method = "47E381A9C2C1FA70862098466A29B040", hash_generated_method = "A7C9FBE88548C28F13DF9BB10F32BD2F")
    public synchronized void addCookie(Cookie cookie) {
        addTaint(cookie.getTaint());
    if(cookie != null)        
        {
for(Iterator<Cookie> it = cookies.iterator();it.hasNext();)
            {
    if(cookieComparator.compare(cookie, it.next()) == 0)                
                {
                    it.remove();
                    break;
                } //End block
            } //End block
    if(!cookie.isExpired(new Date()))            
            {
                cookies.add(cookie);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.310 -0400", hash_original_method = "E08AF67230303C760B74C49856ED8B12", hash_generated_method = "58E55FA9C878A3F9A0B27A6EB9825E28")
    public synchronized void addCookies(Cookie[] cookies) {
        addTaint(cookies[0].getTaint());
    if(cookies != null)        
        {
for(Cookie cooky : cookies)
            {
                this.addCookie(cooky);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (cookies != null) {
            //for (Cookie cooky : cookies) {
                //this.addCookie(cooky);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.311 -0400", hash_original_method = "4518D291A6406FB94614916CA57C71BE", hash_generated_method = "140B7AE84214CFA0039C2BBB10F9D2E8")
    public synchronized List<Cookie> getCookies() {
List<Cookie> varCBE2F43F7F720C22A8D82FB98D41DC23_251804217 =         Collections.unmodifiableList(this.cookies);
        varCBE2F43F7F720C22A8D82FB98D41DC23_251804217.addTaint(taint);
        return varCBE2F43F7F720C22A8D82FB98D41DC23_251804217;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(this.cookies);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.311 -0400", hash_original_method = "882C42ACB6CC9EA440C89C4BE76EF44B", hash_generated_method = "76BFA10C4D233C4A418A04CBB7E3998C")
    public synchronized boolean clearExpired(final Date date) {
        addTaint(date.getTaint());
    if(date == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_16391170 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863603921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_863603921;
        } //End block
        boolean removed = false;
for(Iterator<Cookie> it = cookies.iterator();it.hasNext();)
        {
    if(it.next().isExpired(date))            
            {
                it.remove();
                removed = true;
            } //End block
        } //End block
        boolean varB07286EBBB5BC7AA91CC3EAA8BC19711_1430641566 = (removed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649679040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649679040;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.312 -0400", hash_original_method = "3BF0AB240A348C3188E3D51149860C91", hash_generated_method = "8A9171BA2019EE1EE0FAE0452DCB7AEA")
    @Override
    public String toString() {
String var5FB4B77384CA93A6200A4A8905C96E29_1372250348 =         cookies.toString();
        var5FB4B77384CA93A6200A4A8905C96E29_1372250348.addTaint(taint);
        return var5FB4B77384CA93A6200A4A8905C96E29_1372250348;
        // ---------- Original Method ----------
        //return cookies.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.312 -0400", hash_original_method = "918F9BD76316B2620CCA2503ADA6AAF2", hash_generated_method = "31DAF4A715C672504B7C730D1B4A0A58")
    public synchronized void clear() {
        cookies.clear();
        // ---------- Original Method ----------
        //cookies.clear();
    }

    
}

