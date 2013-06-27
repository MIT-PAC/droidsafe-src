package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public final class CookieOrigin {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.733 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.733 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.733 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.733 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.740 -0400", hash_original_method = "FC001BCC5683C2BE05FA1882BEE28B67", hash_generated_method = "6A4AB1465CBA130ADE2C9627BCDD3CC1")
    public  CookieOrigin(final String host, int port, final String path, boolean secure) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Host of origin may not be null");
        } //End block
        {
            boolean var38D5D932AA4F9C313FE6D4227A1EDA26_536096380 = (host.trim().length() == 0);
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
            boolean var18EA4D7CF05FC60A9FE5C172FC0380F5_1687324554 = (path.trim().length() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.740 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "3F51F4036E5C2188F8CFFA4DB9293EDC")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1561239442 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1561239442 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_1561239442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1561239442;
        // ---------- Original Method ----------
        //return this.host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.741 -0400", hash_original_method = "1447F7E138124D077576DF2B2413D348", hash_generated_method = "D95763FF92681395E640577CAC1D060B")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1374590214 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1374590214 = this.path;
        varB4EAC82CA7396A68D541C85D26508E83_1374590214.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1374590214;
        // ---------- Original Method ----------
        //return this.path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.741 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "C96F74FBA973501BC8CCAF65EE87F38B")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221905900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221905900;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.741 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "852388A9482AAB154D09A3A954134712")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607869347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607869347;
        // ---------- Original Method ----------
        //return this.secure;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.742 -0400", hash_original_method = "04B66E71C7D8EF5D2D79480EE2BA7CE8", hash_generated_method = "1701786951A0DB8BA402F92F5A5A08A6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_75576521 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_75576521 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_75576521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75576521;
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

