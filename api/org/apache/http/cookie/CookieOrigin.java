package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;






public final class CookieOrigin {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.127 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.127 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.127 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.127 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.129 -0400", hash_original_method = "FC001BCC5683C2BE05FA1882BEE28B67", hash_generated_method = "507E6D1DB59FE0AF4B8C228D0DA75632")
    public  CookieOrigin(final String host, int port, final String path, boolean secure) {
        super();
        if(host == null)        
        {
            IllegalArgumentException var5210F90DBC495B6CAA2913B24A1904EB_1319166844 = new IllegalArgumentException(
                    "Host of origin may not be null");
            var5210F90DBC495B6CAA2913B24A1904EB_1319166844.addTaint(taint);
            throw var5210F90DBC495B6CAA2913B24A1904EB_1319166844;
        } //End block
        if(host.trim().length() == 0)        
        {
            IllegalArgumentException var7A1751FBB64BF865A822994441612D49_327210064 = new IllegalArgumentException(
                    "Host of origin may not be blank");
            var7A1751FBB64BF865A822994441612D49_327210064.addTaint(taint);
            throw var7A1751FBB64BF865A822994441612D49_327210064;
        } //End block
        if(port < 0)        
        {
            IllegalArgumentException var8DF79D831A57825B62FB7074BA74CA20_1384415468 = new IllegalArgumentException("Invalid port: " + port);
            var8DF79D831A57825B62FB7074BA74CA20_1384415468.addTaint(taint);
            throw var8DF79D831A57825B62FB7074BA74CA20_1384415468;
        } //End block
        if(path == null)        
        {
            IllegalArgumentException var8C49CDD441D2F3C1BD4723F64CEF01BD_355126493 = new IllegalArgumentException(
                    "Path of origin may not be null.");
            var8C49CDD441D2F3C1BD4723F64CEF01BD_355126493.addTaint(taint);
            throw var8C49CDD441D2F3C1BD4723F64CEF01BD_355126493;
        } //End block
        this.host = host.toLowerCase(Locale.ENGLISH);
        this.port = port;
        if(path.trim().length() != 0)        
        {
            this.path = path;
        } //End block
        else
        {
            this.path = "/";
        } //End block
        this.secure = secure;
        // ---------- Original Method ----------
        //if (host == null) {
            //throw new IllegalArgumentException(
                    //"Host of origin may not be null");
        //}
        //if (host.trim().length() == 0) {
            //throw new IllegalArgumentException(
                    //"Host of origin may not be blank");
        //}
        //if (port < 0) {
            //throw new IllegalArgumentException("Invalid port: " + port);
        //}
        //if (path == null) {
            //throw new IllegalArgumentException(
                    //"Path of origin may not be null.");
        //}
        //this.host = host.toLowerCase(Locale.ENGLISH);
        //this.port = port;
        //if (path.trim().length() != 0) {
            //this.path = path;
        //} else {
            //this.path = "/";
        //}
        //this.secure = secure;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.130 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "42826C9E20DF15F0DC5789A3DBD4D4A7")
    public String getHost() {
String var66CBD60FD8EB006652E02A446703F8AC_931724768 =         this.host;
        var66CBD60FD8EB006652E02A446703F8AC_931724768.addTaint(taint);
        return var66CBD60FD8EB006652E02A446703F8AC_931724768;
        // ---------- Original Method ----------
        //return this.host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.130 -0400", hash_original_method = "1447F7E138124D077576DF2B2413D348", hash_generated_method = "A333C3720D11435448FD2C5DF3DB24BC")
    public String getPath() {
String varCEA6D4C764DAAC99DE6B9EB26F6F3E54_1826012099 =         this.path;
        varCEA6D4C764DAAC99DE6B9EB26F6F3E54_1826012099.addTaint(taint);
        return varCEA6D4C764DAAC99DE6B9EB26F6F3E54_1826012099;
        // ---------- Original Method ----------
        //return this.path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.131 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "0CFC689C550660D0FA984AD7D9CCE428")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_1813978433 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76118683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_76118683;
        // ---------- Original Method ----------
        //return this.port;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.131 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "08D889B3D75E34BDAC81CD4716958C6A")
    public boolean isSecure() {
        boolean var1A6CF3022022F86E5EAF7A933D51276A_1450316392 = (this.secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695588867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695588867;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.131 -0400", hash_original_method = "04B66E71C7D8EF5D2D79480EE2BA7CE8", hash_generated_method = "E25CF0C464F2E2A2A0AB71CEBF321FBE")
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append('[');
        if(this.secure)        
        {
            buffer.append("(secure)");
        } //End block
        buffer.append(this.host);
        buffer.append(':');
        buffer.append(Integer.toString(this.port));
        buffer.append(this.path);
        buffer.append(']');
String varD03843288D33B9E1D3062E25339ECF6D_290453802 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_290453802.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_290453802;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append('[');
        //if (this.secure) {
            //buffer.append("(secure)");
        //}
        //buffer.append(this.host);
        //buffer.append(':');
        //buffer.append(Integer.toString(this.port));
        //buffer.append(this.path);
        //buffer.append(']');
        //return buffer.toString();
    }

    
}

