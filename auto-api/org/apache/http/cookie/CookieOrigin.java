package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public final class CookieOrigin {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.760 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.760 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.760 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.760 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.762 -0400", hash_original_method = "FC001BCC5683C2BE05FA1882BEE28B67", hash_generated_method = "05180B477D6EFA5E3CCF68E8442E9DD6")
    public  CookieOrigin(final String host, int port, final String path, boolean secure) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Host of origin may not be null");
        } //End block
        {
            boolean var38D5D932AA4F9C313FE6D4227A1EDA26_229371438 = (host.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Host of origin may not be blank");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid port: " + port);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Path of origin may not be null.");
        } //End block
        this.host = host.toLowerCase(Locale.ENGLISH);
        this.port = port;
        {
            boolean var18EA4D7CF05FC60A9FE5C172FC0380F5_935965697 = (path.trim().length() != 0);
            {
                this.path = path;
            } //End block
            {
                this.path = "/";
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.762 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "E382A1361C2D88C185B662ED3B9A6A85")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_271031040 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_271031040 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_271031040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_271031040;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.763 -0400", hash_original_method = "1447F7E138124D077576DF2B2413D348", hash_generated_method = "41D3149018F33D083A8CB82EF23F1BD2")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_627073654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_627073654 = this.path;
        varB4EAC82CA7396A68D541C85D26508E83_627073654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_627073654;
        // ---------- Original Method ----------
        //return this.path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.763 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "2BF460CAB4A6D4575FFD8532AE50D788")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193154575 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193154575;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.763 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "A8DFFBA44FD865D898315A42CA598E19")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434882403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434882403;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.764 -0400", hash_original_method = "04B66E71C7D8EF5D2D79480EE2BA7CE8", hash_generated_method = "98D4E3D5491946F268744923D917581B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1591052480 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append('[');
        {
            buffer.append("(secure)");
        } //End block
        buffer.append(this.host);
        buffer.append(':');
        buffer.append(Integer.toString(this.port));
        buffer.append(this.path);
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1591052480 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1591052480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1591052480;
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

