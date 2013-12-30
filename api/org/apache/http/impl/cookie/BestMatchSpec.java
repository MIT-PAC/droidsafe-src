package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;






public class BestMatchSpec implements CookieSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.419 -0500", hash_original_field = "6ECCC683F151EE6CE57F2B5BB3F18FF6", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")


    private  String[] datepatterns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.421 -0500", hash_original_field = "9FF87D24DBC0DA1B27533708A63D8684", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")

    private  boolean oneHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.424 -0500", hash_original_field = "2BAFAED536256D8B65C349DC3041690E", hash_generated_field = "5F8A86FC9473ADC174C31D624DCA621C")

    
    private RFC2965Spec strict;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.426 -0500", hash_original_field = "AE84E39EEC737A72A300D1B6C77E5FB6", hash_generated_field = "3F2E5D6C469AB40A87A13CDDD8535A4F")

    private BrowserCompatSpec compat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.428 -0500", hash_original_field = "F5F02B8B1529E862C8DD5399F24E0921", hash_generated_field = "FD04D8CDCAA721EF2A6418020A2C9297")

    private NetscapeDraftSpec netscape;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.430 -0500", hash_original_method = "731191B1A044208B9E7613B169B88CBF", hash_generated_method = "94DCCFB21BD74048734BCD61B28876C0")
    
public BestMatchSpec(final String[] datepatterns, boolean oneHeader) {
        super();
        this.datepatterns = datepatterns;
        this.oneHeader = oneHeader;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.432 -0500", hash_original_method = "4DB7B6528BCAE4846E927270A5376336", hash_generated_method = "4DD3C5F85A6982498A68B4C61A462C0C")
    
public BestMatchSpec() {
        this(null, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.435 -0500", hash_original_method = "F5D458E4620E2EBF824493C3536FD1C3", hash_generated_method = "B8AC8CFFD7542208D13E0CD7C5572BB3")
    
private RFC2965Spec getStrict() {
        if (this.strict == null) {
             this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        }
        return strict;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.437 -0500", hash_original_method = "FE28D7A5554F455D8D7B5F3F6FCB0BC9", hash_generated_method = "C15C304ACB8391E6DE3FA3BD059FE33E")
    
private BrowserCompatSpec getCompat() {
        if (this.compat == null) {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        }
        return compat;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.440 -0500", hash_original_method = "31CE28BB07784CC0AF4C8F0ADF6151C2", hash_generated_method = "5FF685AE5382C82CF6BE0CE9A15EA91F")
    
private NetscapeDraftSpec getNetscape() {
        if (this.netscape == null) {
            String[] patterns = this.datepatterns;
            if (patterns == null) {
                patterns = BrowserCompatSpec.DATE_PATTERNS;
            }
            this.netscape = new NetscapeDraftSpec(patterns);
        }
        return netscape;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.443 -0500", hash_original_method = "C499DBBDC8B4546015F801D03A85521F", hash_generated_method = "29A4870DD942AC4091B182BBCD989AE8")
    
public List<Cookie> parse(
            final Header header, 
            final CookieOrigin origin) throws MalformedCookieException {
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        }
        if (origin == null) {
           throw new IllegalArgumentException("Cookie origin may not be null");
        }
        HeaderElement[] helems = header.getElements();
        boolean versioned = false;
        boolean netscape = false;
        for (HeaderElement helem: helems) {
            if (helem.getParameterByName("version") != null) {
                versioned = true;
            }
            if (helem.getParameterByName("expires") != null) {
               netscape = true;
            }
        }
        if (netscape) {
            
        }
        // Do we have a cookie with a version attribute?
        if (versioned) {
            return getStrict().parse(helems, origin);
        } else if (netscape) {
            // Need to parse the header again,
            // because Netscape draft cannot handle
            // comma separators
            return getNetscape().parse(header, origin);
        } else {
            return getCompat().parse(helems, origin);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.446 -0500", hash_original_method = "D9C3CD1F657AAA3A889AB4D60086CD32", hash_generated_method = "59B866E413CF4A548ED11253781AFAAC")
    
public void validate(
            final Cookie cookie, 
            final CookieOrigin origin) throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        if (cookie.getVersion() > 0) {
            getStrict().validate(cookie, origin);
        } else {
            getCompat().validate(cookie, origin);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.448 -0500", hash_original_method = "095C5B7B4EC1692AF511C9147FBDCB17", hash_generated_method = "7D7C1737EEC51207951F3484F08E296D")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        if (cookie.getVersion() > 0) {
            return getStrict().match(cookie, origin);
        } else {
            return getCompat().match(cookie, origin);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.450 -0500", hash_original_method = "C8CEC6D04CCA02851E16316FDE4218F3", hash_generated_method = "FE4850AF187A16740568D47C42D8F683")
    
public List<Header> formatCookies(final List<Cookie> cookies) {
        if (cookies == null) {
            throw new IllegalArgumentException("List of cookie may not be null");
        }
        int version = Integer.MAX_VALUE;
        for (Cookie cookie: cookies) {
            if (cookie.getVersion() < version) {
                version = cookie.getVersion();
            }
        }
        if (version > 0) {
            return getStrict().formatCookies(cookies);
        } else {
            return getCompat().formatCookies(cookies);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.452 -0500", hash_original_method = "812B69FBF27003910CA721BA7B572F16", hash_generated_method = "0C08EBE7DDE45A14800DBEAD81605967")
    
public int getVersion() {
        return getStrict().getVersion();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.455 -0500", hash_original_method = "B06045A369F60BC64D5D46F6D34F8F3E", hash_generated_method = "9A6C7E6C6D167B0B85A4DFF880CA777C")
    
public Header getVersionHeader() {
        return getStrict().getVersionHeader();
    }

    
}

