package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;

public class BestMatchSpec implements CookieSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.252 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.252 -0400", hash_original_field = "1DC8E1B30B1B1279E15BB73B4101C43C", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")

    private boolean oneHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.252 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "5F8A86FC9473ADC174C31D624DCA621C")

    private RFC2965Spec strict;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.252 -0400", hash_original_field = "6805D2EB09708DDE50E925B430024691", hash_generated_field = "3F2E5D6C469AB40A87A13CDDD8535A4F")

    private BrowserCompatSpec compat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.252 -0400", hash_original_field = "B618A1516E37844BEDDD72A162970289", hash_generated_field = "FD04D8CDCAA721EF2A6418020A2C9297")

    private NetscapeDraftSpec netscape;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.264 -0400", hash_original_method = "731191B1A044208B9E7613B169B88CBF", hash_generated_method = "A69D33C92E4D9E64E3F98F29AE8B482E")
    public  BestMatchSpec(final String[] datepatterns, boolean oneHeader) {
        super();
        this.datepatterns = datepatterns;
        this.oneHeader = oneHeader;
        // ---------- Original Method ----------
        //this.datepatterns = datepatterns;
        //this.oneHeader = oneHeader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.265 -0400", hash_original_method = "4DB7B6528BCAE4846E927270A5376336", hash_generated_method = "1B481E0A7CB25F3CE48335830A9955C0")
    public  BestMatchSpec() {
        this(null, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.268 -0400", hash_original_method = "F5D458E4620E2EBF824493C3536FD1C3", hash_generated_method = "EBA9694F3333BC39973D2E0FD28E46B2")
    private RFC2965Spec getStrict() {
        RFC2965Spec varB4EAC82CA7396A68D541C85D26508E83_595047325 = null; //Variable for return #1
        {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_595047325 = strict;
        varB4EAC82CA7396A68D541C85D26508E83_595047325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_595047325;
        // ---------- Original Method ----------
        //if (this.strict == null) {
             //this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        //}
        //return strict;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.269 -0400", hash_original_method = "FE28D7A5554F455D8D7B5F3F6FCB0BC9", hash_generated_method = "3A7C8AB85A626BA6F3A2E02C296E2DD0")
    private BrowserCompatSpec getCompat() {
        BrowserCompatSpec varB4EAC82CA7396A68D541C85D26508E83_825831131 = null; //Variable for return #1
        {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_825831131 = compat;
        varB4EAC82CA7396A68D541C85D26508E83_825831131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825831131;
        // ---------- Original Method ----------
        //if (this.compat == null) {
            //this.compat = new BrowserCompatSpec(this.datepatterns);
        //}
        //return compat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.280 -0400", hash_original_method = "31CE28BB07784CC0AF4C8F0ADF6151C2", hash_generated_method = "204D57EAFDBC869CF7E9D6EEC0202128")
    private NetscapeDraftSpec getNetscape() {
        NetscapeDraftSpec varB4EAC82CA7396A68D541C85D26508E83_344866537 = null; //Variable for return #1
        {
            String[] patterns;
            patterns = this.datepatterns;
            {
                patterns = BrowserCompatSpec.DATE_PATTERNS;
            } //End block
            this.netscape = new NetscapeDraftSpec(patterns);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_344866537 = netscape;
        varB4EAC82CA7396A68D541C85D26508E83_344866537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_344866537;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.291 -0400", hash_original_method = "C499DBBDC8B4546015F801D03A85521F", hash_generated_method = "6B9C0FF97397495729D7E4EB30216716")
    public List<Cookie> parse(
            final Header header, 
            final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_978392561 = null; //Variable for return #1
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_967672793 = null; //Variable for return #2
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1263160288 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        HeaderElement[] helems;
        helems = header.getElements();
        boolean versioned;
        versioned = false;
        boolean netscape;
        netscape = false;
        {
            Iterator<HeaderElement> var439D9EF276A31E7FACE3630192C7AAE7_439358466 = (helems).iterator();
            var439D9EF276A31E7FACE3630192C7AAE7_439358466.hasNext();
            HeaderElement helem = var439D9EF276A31E7FACE3630192C7AAE7_439358466.next();
            {
                {
                    boolean varE34162F97A451B6F70D25E27B65335FF_1954528781 = (helem.getParameterByName("version") != null);
                    {
                        versioned = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var30ABBABD65ED5275AD26722D787207C9_1415461383 = (helem.getParameterByName("expires") != null);
                    {
                        netscape = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_978392561 = getStrict().parse(helems, origin);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_967672793 = getNetscape().parse(header, origin);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1263160288 = getCompat().parse(helems, origin);
        } //End block
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        List<Cookie> varA7E53CE21691AB073D9660D615818899_982907306; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_982907306 = varB4EAC82CA7396A68D541C85D26508E83_978392561;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_982907306 = varB4EAC82CA7396A68D541C85D26508E83_967672793;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_982907306 = varB4EAC82CA7396A68D541C85D26508E83_1263160288;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_982907306.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_982907306;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.294 -0400", hash_original_method = "D9C3CD1F657AAA3A889AB4D60086CD32", hash_generated_method = "A2DCD94162E937EC525AEC23911D1C82")
    public void validate(
            final Cookie cookie, 
            final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        {
            boolean var7C061BAB4E408A319BECFD80532577E4_2079304526 = (cookie.getVersion() > 0);
            {
                getStrict().validate(cookie, origin);
            } //End block
            {
                getCompat().validate(cookie, origin);
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.306 -0400", hash_original_method = "095C5B7B4EC1692AF511C9147FBDCB17", hash_generated_method = "D0C353D9E782BD88DA0CBCBDA3F1DD9F")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } //End block
        {
            boolean var7C061BAB4E408A319BECFD80532577E4_278873143 = (cookie.getVersion() > 0);
            {
                boolean varC0B954260FA8552DB5ADBF83B4940C28_22380744 = (getStrict().match(cookie, origin));
            } //End block
            {
                boolean var5EB97C746B96612AB8104B7213F823A1_402055885 = (getCompat().match(cookie, origin));
            } //End block
        } //End collapsed parenthetic
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368047636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368047636;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.308 -0400", hash_original_method = "C8CEC6D04CCA02851E16316FDE4218F3", hash_generated_method = "2B9E213E32FF848260F2A7948859D9BB")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_1655279666 = null; //Variable for return #1
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_2140802050 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookie may not be null");
        } //End block
        int version;
        version = Integer.MAX_VALUE;
        {
            Iterator<Cookie> varAB1853DFB2E7344B04B78F423AD80A1F_653097811 = (cookies).iterator();
            varAB1853DFB2E7344B04B78F423AD80A1F_653097811.hasNext();
            Cookie cookie = varAB1853DFB2E7344B04B78F423AD80A1F_653097811.next();
            {
                {
                    boolean varC06D11AB8DE40C0800CE09D6D4EEFC3D_1301965967 = (cookie.getVersion() < version);
                    {
                        version = cookie.getVersion();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1655279666 = getStrict().formatCookies(cookies);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2140802050 = getCompat().formatCookies(cookies);
        } //End block
        addTaint(cookies.getTaint());
        List<Header> varA7E53CE21691AB073D9660D615818899_1311525316; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1311525316 = varB4EAC82CA7396A68D541C85D26508E83_1655279666;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1311525316 = varB4EAC82CA7396A68D541C85D26508E83_2140802050;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1311525316.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1311525316;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.308 -0400", hash_original_method = "812B69FBF27003910CA721BA7B572F16", hash_generated_method = "55FD647535396E2B3C07F84DB6D3A3B2")
    public int getVersion() {
        int var406AEB8A3BC540C6B1B701CBFE212A1F_888590386 = (getStrict().getVersion());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417802830 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417802830;
        // ---------- Original Method ----------
        //return getStrict().getVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.317 -0400", hash_original_method = "B06045A369F60BC64D5D46F6D34F8F3E", hash_generated_method = "70D67B277978F05F8F676FED9B4074C9")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_234814088 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_234814088 = getStrict().getVersionHeader();
        varB4EAC82CA7396A68D541C85D26508E83_234814088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234814088;
        // ---------- Original Method ----------
        //return getStrict().getVersionHeader();
    }

    
}

