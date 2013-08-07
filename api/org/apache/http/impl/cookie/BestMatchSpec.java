package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;






public class BestMatchSpec implements CookieSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.704 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.704 -0400", hash_original_field = "1DC8E1B30B1B1279E15BB73B4101C43C", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")

    private boolean oneHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.704 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "5F8A86FC9473ADC174C31D624DCA621C")

    private RFC2965Spec strict;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.704 -0400", hash_original_field = "6805D2EB09708DDE50E925B430024691", hash_generated_field = "3F2E5D6C469AB40A87A13CDDD8535A4F")

    private BrowserCompatSpec compat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.704 -0400", hash_original_field = "B618A1516E37844BEDDD72A162970289", hash_generated_field = "FD04D8CDCAA721EF2A6418020A2C9297")

    private NetscapeDraftSpec netscape;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.704 -0400", hash_original_method = "731191B1A044208B9E7613B169B88CBF", hash_generated_method = "A69D33C92E4D9E64E3F98F29AE8B482E")
    public  BestMatchSpec(final String[] datepatterns, boolean oneHeader) {
        super();
        this.datepatterns = datepatterns;
        this.oneHeader = oneHeader;
        // ---------- Original Method ----------
        //this.datepatterns = datepatterns;
        //this.oneHeader = oneHeader;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.705 -0400", hash_original_method = "4DB7B6528BCAE4846E927270A5376336", hash_generated_method = "1B481E0A7CB25F3CE48335830A9955C0")
    public  BestMatchSpec() {
        this(null, false);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.705 -0400", hash_original_method = "F5D458E4620E2EBF824493C3536FD1C3", hash_generated_method = "EEE457974DC6D712B2C4E7B18CD9D902")
    private RFC2965Spec getStrict() {
        if(this.strict == null)        
        {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        } //End block
RFC2965Spec varDB6279AFE8E7F0A60897A3819FA9FC75_265585704 =         strict;
        varDB6279AFE8E7F0A60897A3819FA9FC75_265585704.addTaint(taint);
        return varDB6279AFE8E7F0A60897A3819FA9FC75_265585704;
        // ---------- Original Method ----------
        //if (this.strict == null) {
             //this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        //}
        //return strict;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.706 -0400", hash_original_method = "FE28D7A5554F455D8D7B5F3F6FCB0BC9", hash_generated_method = "49F2BEA21A3CC7F000A0143604C29D77")
    private BrowserCompatSpec getCompat() {
        if(this.compat == null)        
        {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        } //End block
BrowserCompatSpec varAFEEE60A042EE3ADCC984CE27FD0517C_950606512 =         compat;
        varAFEEE60A042EE3ADCC984CE27FD0517C_950606512.addTaint(taint);
        return varAFEEE60A042EE3ADCC984CE27FD0517C_950606512;
        // ---------- Original Method ----------
        //if (this.compat == null) {
            //this.compat = new BrowserCompatSpec(this.datepatterns);
        //}
        //return compat;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.706 -0400", hash_original_method = "31CE28BB07784CC0AF4C8F0ADF6151C2", hash_generated_method = "4B7761F88C2D5E475113BE722FD0CD70")
    private NetscapeDraftSpec getNetscape() {
        if(this.netscape == null)        
        {
            String[] patterns = this.datepatterns;
            if(patterns == null)            
            {
                patterns = BrowserCompatSpec.DATE_PATTERNS;
            } //End block
            this.netscape = new NetscapeDraftSpec(patterns);
        } //End block
NetscapeDraftSpec varA6AFB74D38C0E33A485127020BAF6F60_1223658543 =         netscape;
        varA6AFB74D38C0E33A485127020BAF6F60_1223658543.addTaint(taint);
        return varA6AFB74D38C0E33A485127020BAF6F60_1223658543;
        // ---------- Original Method ----------
        //if (this.netscape == null) {
            //String[] patterns = this.datepatterns;
            //if (patterns == null) {
                //patterns = BrowserCompatSpec.DATE_PATTERNS;
            //}
            //this.netscape = new NetscapeDraftSpec(patterns);
        //}
        //return netscape;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.707 -0400", hash_original_method = "C499DBBDC8B4546015F801D03A85521F", hash_generated_method = "11A463BC01CF42F267D0F9726C547825")
    public List<Cookie> parse(
            final Header header, 
            final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(header.getTaint());
        if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_1879219606 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_1879219606.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_1879219606;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_856495798 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_856495798.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_856495798;
        } //End block
        HeaderElement[] helems = header.getElements();
        boolean versioned = false;
        boolean netscape = false;
for(HeaderElement helem : helems)
        {
            if(helem.getParameterByName("version") != null)            
            {
                versioned = true;
            } //End block
            if(helem.getParameterByName("expires") != null)            
            {
                netscape = true;
            } //End block
        } //End block
        if(netscape)        
        {
        } //End block
        if(versioned)        
        {
List<Cookie> var144B2AF856CEFCDF62FEA882BAE28DC4_931895511 =             getStrict().parse(helems, origin);
            var144B2AF856CEFCDF62FEA882BAE28DC4_931895511.addTaint(taint);
            return var144B2AF856CEFCDF62FEA882BAE28DC4_931895511;
        } //End block
        else
        if(netscape)        
        {
List<Cookie> varDE69359E4B79DFA0A30FC1CF6AF0BFF1_1297156833 =             getNetscape().parse(header, origin);
            varDE69359E4B79DFA0A30FC1CF6AF0BFF1_1297156833.addTaint(taint);
            return varDE69359E4B79DFA0A30FC1CF6AF0BFF1_1297156833;
        } //End block
        else
        {
List<Cookie> varD28DD8C21FB75510B75EB2B0FA23C310_602164161 =             getCompat().parse(helems, origin);
            varD28DD8C21FB75510B75EB2B0FA23C310_602164161.addTaint(taint);
            return varD28DD8C21FB75510B75EB2B0FA23C310_602164161;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.708 -0400", hash_original_method = "D9C3CD1F657AAA3A889AB4D60086CD32", hash_generated_method = "F56FD0A9E6900AAD62F8C03F9C1D2E71")
    public void validate(
            final Cookie cookie, 
            final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_302032709 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_302032709.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_302032709;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_136577248 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_136577248.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_136577248;
        } //End block
        if(cookie.getVersion() > 0)        
        {
            getStrict().validate(cookie, origin);
        } //End block
        else
        {
            getCompat().validate(cookie, origin);
        } //End block
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //if (cookie.getVersion() > 0) {
            //getStrict().validate(cookie, origin);
        //} else {
            //getCompat().validate(cookie, origin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.709 -0400", hash_original_method = "095C5B7B4EC1692AF511C9147FBDCB17", hash_generated_method = "8899B4E43BAD12E602DFCBC07F5A90A1")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        addTaint(origin.getTaint());
        addTaint(cookie.getTaint());
        if(cookie == null)        
        {
            IllegalArgumentException varFBA11BCFA12F6CB336E0E79489ED6755_698356963 = new IllegalArgumentException("Cookie may not be null");
            varFBA11BCFA12F6CB336E0E79489ED6755_698356963.addTaint(taint);
            throw varFBA11BCFA12F6CB336E0E79489ED6755_698356963;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1101805878 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1101805878.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1101805878;
        } //End block
        if(cookie.getVersion() > 0)        
        {
            boolean var55F26A7F3413453990271745504DF02D_1307772541 = (getStrict().match(cookie, origin));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2137377261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2137377261;
        } //End block
        else
        {
            boolean varF34BDA44AFC980695168819089F123EB_1265605946 = (getCompat().match(cookie, origin));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31769433 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_31769433;
        } //End block
        // ---------- Original Method ----------
        //if (cookie == null) {
            //throw new IllegalArgumentException("Cookie may not be null");
        //}
        //if (origin == null) {
            //throw new IllegalArgumentException("Cookie origin may not be null");
        //}
        //if (cookie.getVersion() > 0) {
            //return getStrict().match(cookie, origin);
        //} else {
            //return getCompat().match(cookie, origin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.710 -0400", hash_original_method = "C8CEC6D04CCA02851E16316FDE4218F3", hash_generated_method = "3CFBDBA27048B71607AB478D11072B28")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        addTaint(cookies.getTaint());
        if(cookies == null)        
        {
            IllegalArgumentException varC98EC06C13B9ED3EC11BA3A392A04A9A_1333349104 = new IllegalArgumentException("List of cookie may not be null");
            varC98EC06C13B9ED3EC11BA3A392A04A9A_1333349104.addTaint(taint);
            throw varC98EC06C13B9ED3EC11BA3A392A04A9A_1333349104;
        } //End block
        int version = Integer.MAX_VALUE;
for(Cookie cookie : cookies)
        {
            if(cookie.getVersion() < version)            
            {
                version = cookie.getVersion();
            } //End block
        } //End block
        if(version > 0)        
        {
List<Header> varCFFD1751E0023DFB00C0294CEE896231_1878937290 =             getStrict().formatCookies(cookies);
            varCFFD1751E0023DFB00C0294CEE896231_1878937290.addTaint(taint);
            return varCFFD1751E0023DFB00C0294CEE896231_1878937290;
        } //End block
        else
        {
List<Header> varEB37B0D1D69A9232E98DB934D003B70F_763051691 =             getCompat().formatCookies(cookies);
            varEB37B0D1D69A9232E98DB934D003B70F_763051691.addTaint(taint);
            return varEB37B0D1D69A9232E98DB934D003B70F_763051691;
        } //End block
        // ---------- Original Method ----------
        //if (cookies == null) {
            //throw new IllegalArgumentException("List of cookie may not be null");
        //}
        //int version = Integer.MAX_VALUE;
        //for (Cookie cookie: cookies) {
            //if (cookie.getVersion() < version) {
                //version = cookie.getVersion();
            //}
        //}
        //if (version > 0) {
            //return getStrict().formatCookies(cookies);
        //} else {
            //return getCompat().formatCookies(cookies);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.711 -0400", hash_original_method = "812B69FBF27003910CA721BA7B572F16", hash_generated_method = "EF6123C13B8CC45F0546290455642454")
    public int getVersion() {
        int varA4D724EE0BD7DBB859A9CE0F27E2410E_1578355506 = (getStrict().getVersion());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892944897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892944897;
        // ---------- Original Method ----------
        //return getStrict().getVersion();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.711 -0400", hash_original_method = "B06045A369F60BC64D5D46F6D34F8F3E", hash_generated_method = "7C0622CAAEB6D07D6B31395B901B063D")
    public Header getVersionHeader() {
Header var10B0C59FF75F86BE086DF23FCDEEF9A2_211445800 =         getStrict().getVersionHeader();
        var10B0C59FF75F86BE086DF23FCDEEF9A2_211445800.addTaint(taint);
        return var10B0C59FF75F86BE086DF23FCDEEF9A2_211445800;
        // ---------- Original Method ----------
        //return getStrict().getVersionHeader();
    }

    
}

