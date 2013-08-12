package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Comparator;




public class CookiePathComparator implements Serializable, Comparator<Cookie> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.138 -0400", hash_original_method = "29A50A9D1E136547D3D05BF6575A3E25", hash_generated_method = "29A50A9D1E136547D3D05BF6575A3E25")
    public CookiePathComparator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.139 -0400", hash_original_method = "679ADE09B30DFC8534697854331FFCFD", hash_generated_method = "2DDF7D41345915514496DFA792287917")
    private String normalizePath(final Cookie cookie) {
        addTaint(cookie.getTaint());
        String path = cookie.getPath();
        if(path == null)        
        {
            path = "/";
        } //End block
        if(!path.endsWith("/"))        
        {
            path = path + '/';
        } //End block
String var535F4D9720F3B0C96D8143873CE0638C_1393623156 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1393623156.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1393623156;
        // ---------- Original Method ----------
        //String path = cookie.getPath();
        //if (path == null) {
            //path = "/";
        //}
        //if (!path.endsWith("/")) {
            //path = path + '/';
        //}
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.140 -0400", hash_original_method = "38114A956CA6EEFF2831D01642E4D39A", hash_generated_method = "B651B70142DE6706EBBA1F93A8C5EA08")
    public int compare(final Cookie c1, final Cookie c2) {
        addTaint(c2.getTaint());
        addTaint(c1.getTaint());
        String path1 = normalizePath(c1);
        String path2 = normalizePath(c2);
        if(path1.equals(path2))        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_610884505 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672760294 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_672760294;
        } //End block
        else
        if(path1.startsWith(path2))        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1483681059 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652451630 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652451630;
        } //End block
        else
        if(path2.startsWith(path1))        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_730815854 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720913299 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720913299;
        } //End block
        else
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_326312307 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131767223 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131767223;
        } //End block
        // ---------- Original Method ----------
        //String path1 = normalizePath(c1);
        //String path2 = normalizePath(c2);
        //if (path1.equals(path2)) {
            //return 0;
        //} else if (path1.startsWith(path2)) {
            //return -1;
        //} else if (path2.startsWith(path1)) {
            //return 1;
        //} else {
            //return 0;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.140 -0400", hash_original_field = "0F87541D9DDA243624A2462D4F476B97", hash_generated_field = "72EE05E0928858A1E51BAE2345CB995B")

    private static final long serialVersionUID = 7523645369616405818L;
}

