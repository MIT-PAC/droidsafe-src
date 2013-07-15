package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;

public class BestMatchSpec implements CookieSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.003 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.004 -0400", hash_original_field = "1DC8E1B30B1B1279E15BB73B4101C43C", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")

    private boolean oneHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.004 -0400", hash_original_field = "2133FD717402A7966EE88D06F9E0B792", hash_generated_field = "5F8A86FC9473ADC174C31D624DCA621C")

    private RFC2965Spec strict;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.004 -0400", hash_original_field = "6805D2EB09708DDE50E925B430024691", hash_generated_field = "3F2E5D6C469AB40A87A13CDDD8535A4F")

    private BrowserCompatSpec compat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.004 -0400", hash_original_field = "B618A1516E37844BEDDD72A162970289", hash_generated_field = "FD04D8CDCAA721EF2A6418020A2C9297")

    private NetscapeDraftSpec netscape;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.004 -0400", hash_original_method = "731191B1A044208B9E7613B169B88CBF", hash_generated_method = "A69D33C92E4D9E64E3F98F29AE8B482E")
    public  BestMatchSpec(final String[] datepatterns, boolean oneHeader) {
        super();
        this.datepatterns = datepatterns;
        this.oneHeader = oneHeader;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.004 -0400", hash_original_method = "4DB7B6528BCAE4846E927270A5376336", hash_generated_method = "1B481E0A7CB25F3CE48335830A9955C0")
    public  BestMatchSpec() {
        this(null, false);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.005 -0400", hash_original_method = "F5D458E4620E2EBF824493C3536FD1C3", hash_generated_method = "052853FE810842C8480B5120A5739B19")
    private RFC2965Spec getStrict() {
        RFC2965Spec varB4EAC82CA7396A68D541C85D26508E83_27388344 = null; 
        {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_27388344 = strict;
        varB4EAC82CA7396A68D541C85D26508E83_27388344.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_27388344;
        
        
             
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.005 -0400", hash_original_method = "FE28D7A5554F455D8D7B5F3F6FCB0BC9", hash_generated_method = "47EC3F8E33BD85CD9A61A5B593823C35")
    private BrowserCompatSpec getCompat() {
        BrowserCompatSpec varB4EAC82CA7396A68D541C85D26508E83_1323336379 = null; 
        {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1323336379 = compat;
        varB4EAC82CA7396A68D541C85D26508E83_1323336379.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1323336379;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.005 -0400", hash_original_method = "31CE28BB07784CC0AF4C8F0ADF6151C2", hash_generated_method = "932A1F1A8049A53813D590E271043CB5")
    private NetscapeDraftSpec getNetscape() {
        NetscapeDraftSpec varB4EAC82CA7396A68D541C85D26508E83_1941096124 = null; 
        {
            String[] patterns = this.datepatterns;
            {
                patterns = BrowserCompatSpec.DATE_PATTERNS;
            } 
            this.netscape = new NetscapeDraftSpec(patterns);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1941096124 = netscape;
        varB4EAC82CA7396A68D541C85D26508E83_1941096124.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1941096124;
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.008 -0400", hash_original_method = "C499DBBDC8B4546015F801D03A85521F", hash_generated_method = "559395CD6A1D46851680349C8B18AC8F")
    public List<Cookie> parse(
            final Header header, 
            final CookieOrigin origin) throws MalformedCookieException {
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_1832178830 = null; 
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_2073742068 = null; 
        List<Cookie> varB4EAC82CA7396A68D541C85D26508E83_156394059 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        HeaderElement[] helems = header.getElements();
        boolean versioned = false;
        boolean netscape = false;
        {
            HeaderElement helem = helems[0];
            {
                {
                    boolean varE34162F97A451B6F70D25E27B65335FF_402891061 = (helem.getParameterByName("version") != null);
                    {
                        versioned = true;
                    } 
                } 
                {
                    boolean var30ABBABD65ED5275AD26722D787207C9_501543763 = (helem.getParameterByName("expires") != null);
                    {
                        netscape = true;
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1832178830 = getStrict().parse(helems, origin);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2073742068 = getNetscape().parse(header, origin);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_156394059 = getCompat().parse(helems, origin);
        } 
        addTaint(header.getTaint());
        addTaint(origin.getTaint());
        List<Cookie> varA7E53CE21691AB073D9660D615818899_1062088090; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1062088090 = varB4EAC82CA7396A68D541C85D26508E83_1832178830;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1062088090 = varB4EAC82CA7396A68D541C85D26508E83_2073742068;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1062088090 = varB4EAC82CA7396A68D541C85D26508E83_156394059;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1062088090.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1062088090;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.009 -0400", hash_original_method = "D9C3CD1F657AAA3A889AB4D60086CD32", hash_generated_method = "5E1E474428868A76A69BE75D0CD1C57C")
    public void validate(
            final Cookie cookie, 
            final CookieOrigin origin) throws MalformedCookieException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        {
            boolean var7C061BAB4E408A319BECFD80532577E4_1543427810 = (cookie.getVersion() > 0);
            {
                getStrict().validate(cookie, origin);
            } 
            {
                getCompat().validate(cookie, origin);
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.009 -0400", hash_original_method = "095C5B7B4EC1692AF511C9147FBDCB17", hash_generated_method = "194990991666E24E00C4B4D3E9867411")
    public boolean match(final Cookie cookie, final CookieOrigin origin) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cookie origin may not be null");
        } 
        {
            boolean var7C061BAB4E408A319BECFD80532577E4_949230119 = (cookie.getVersion() > 0);
            {
                boolean varC0B954260FA8552DB5ADBF83B4940C28_1438762661 = (getStrict().match(cookie, origin));
            } 
            {
                boolean var5EB97C746B96612AB8104B7213F823A1_619084888 = (getCompat().match(cookie, origin));
            } 
        } 
        addTaint(cookie.getTaint());
        addTaint(origin.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287404252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287404252;
        
        
            
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.011 -0400", hash_original_method = "C8CEC6D04CCA02851E16316FDE4218F3", hash_generated_method = "7C2E26C357BD4AF39E2AA88263477F51")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_618995396 = null; 
        List<Header> varB4EAC82CA7396A68D541C85D26508E83_1392004188 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List of cookie may not be null");
        } 
        int version = Integer.MAX_VALUE;
        {
            Iterator<Cookie> varAB1853DFB2E7344B04B78F423AD80A1F_1587847433 = (cookies).iterator();
            varAB1853DFB2E7344B04B78F423AD80A1F_1587847433.hasNext();
            Cookie cookie = varAB1853DFB2E7344B04B78F423AD80A1F_1587847433.next();
            {
                {
                    boolean varC06D11AB8DE40C0800CE09D6D4EEFC3D_720344713 = (cookie.getVersion() < version);
                    {
                        version = cookie.getVersion();
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_618995396 = getStrict().formatCookies(cookies);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1392004188 = getCompat().formatCookies(cookies);
        } 
        addTaint(cookies.getTaint());
        List<Header> varA7E53CE21691AB073D9660D615818899_650941693; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_650941693 = varB4EAC82CA7396A68D541C85D26508E83_618995396;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_650941693 = varB4EAC82CA7396A68D541C85D26508E83_1392004188;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_650941693.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_650941693;
        
        
            
        
        
        
            
                
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.011 -0400", hash_original_method = "812B69FBF27003910CA721BA7B572F16", hash_generated_method = "DD53354506788F4DF04B612FCE4BFF2B")
    public int getVersion() {
        int var406AEB8A3BC540C6B1B701CBFE212A1F_1114716312 = (getStrict().getVersion());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303179932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303179932;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.012 -0400", hash_original_method = "B06045A369F60BC64D5D46F6D34F8F3E", hash_generated_method = "8352C1567ADBF6BB0E15946A4B3EA32D")
    public Header getVersionHeader() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1986345596 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1986345596 = getStrict().getVersionHeader();
        varB4EAC82CA7396A68D541C85D26508E83_1986345596.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1986345596;
        
        
    }

    
}

