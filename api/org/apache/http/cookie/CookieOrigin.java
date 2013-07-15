package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public final class CookieOrigin {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.843 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.843 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.844 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.844 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.845 -0400", hash_original_method = "FC001BCC5683C2BE05FA1882BEE28B67", hash_generated_method = "927CEFC2D3C50A7300C5C30A6EE61C19")
    public  CookieOrigin(final String host, int port, final String path, boolean secure) {
        super();
    if(host == null)        
        {
            IllegalArgumentException var5210F90DBC495B6CAA2913B24A1904EB_1436589954 = new IllegalArgumentException(
                    "Host of origin may not be null");
            var5210F90DBC495B6CAA2913B24A1904EB_1436589954.addTaint(taint);
            throw var5210F90DBC495B6CAA2913B24A1904EB_1436589954;
        } //End block
    if(host.trim().length() == 0)        
        {
            IllegalArgumentException var7A1751FBB64BF865A822994441612D49_1482135772 = new IllegalArgumentException(
                    "Host of origin may not be blank");
            var7A1751FBB64BF865A822994441612D49_1482135772.addTaint(taint);
            throw var7A1751FBB64BF865A822994441612D49_1482135772;
        } //End block
    if(port < 0)        
        {
            IllegalArgumentException var8DF79D831A57825B62FB7074BA74CA20_422042079 = new IllegalArgumentException("Invalid port: " + port);
            var8DF79D831A57825B62FB7074BA74CA20_422042079.addTaint(taint);
            throw var8DF79D831A57825B62FB7074BA74CA20_422042079;
        } //End block
    if(path == null)        
        {
            IllegalArgumentException var8C49CDD441D2F3C1BD4723F64CEF01BD_2019277239 = new IllegalArgumentException(
                    "Path of origin may not be null.");
            var8C49CDD441D2F3C1BD4723F64CEF01BD_2019277239.addTaint(taint);
            throw var8C49CDD441D2F3C1BD4723F64CEF01BD_2019277239;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.845 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "EAC6A96B96FC0F809ABD2EA2B7B6B109")
    public String getHost() {
String var66CBD60FD8EB006652E02A446703F8AC_2098672108 =         this.host;
        var66CBD60FD8EB006652E02A446703F8AC_2098672108.addTaint(taint);
        return var66CBD60FD8EB006652E02A446703F8AC_2098672108;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.846 -0400", hash_original_method = "1447F7E138124D077576DF2B2413D348", hash_generated_method = "ABC3304CC0EAE9C7BC6DFB2AE183AC8A")
    public String getPath() {
String varCEA6D4C764DAAC99DE6B9EB26F6F3E54_844796093 =         this.path;
        varCEA6D4C764DAAC99DE6B9EB26F6F3E54_844796093.addTaint(taint);
        return varCEA6D4C764DAAC99DE6B9EB26F6F3E54_844796093;
        // ---------- Original Method ----------
        //return this.path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.846 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "444BFE3D3EC068FB94627023AD3D3524")
    public int getPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_749988338 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528080393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528080393;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.846 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "F9A4D1518093CF40BF34AB85307680E9")
    public boolean isSecure() {
        boolean var1A6CF3022022F86E5EAF7A933D51276A_1747323755 = (this.secure);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1478323514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1478323514;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.847 -0400", hash_original_method = "04B66E71C7D8EF5D2D79480EE2BA7CE8", hash_generated_method = "96172CF5271E1AF58D3017268541BC32")
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
String varD03843288D33B9E1D3062E25339ECF6D_2039120025 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_2039120025.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_2039120025;
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

