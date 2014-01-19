package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

public final class CookieOrigin {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.123 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private  String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.125 -0500", hash_original_field = "5A948EF636511EF149269A68FE278AED", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private  int port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.127 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private  String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.130 -0500", hash_original_field = "63DC6869FF37EDAA23661806B080C4ED", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private  boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.133 -0500", hash_original_method = "FC001BCC5683C2BE05FA1882BEE28B67", hash_generated_method = "312018F409891434B68F6E2B2D3FDAE7")
    
public CookieOrigin(final String host, int port, final String path, boolean secure) {
        super();
        if (host == null) {
            throw new IllegalArgumentException(
                    "Host of origin may not be null");
        }
        if (host.trim().length() == 0) {
            throw new IllegalArgumentException(
                    "Host of origin may not be blank");
        }
        if (port < 0) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }
        if (path == null) {
            throw new IllegalArgumentException(
                    "Path of origin may not be null.");
        }
        this.host = host.toLowerCase(Locale.ENGLISH);
        this.port = port;
        if (path.trim().length() != 0) {
            this.path = path;
        } else {
            this.path = "/";
        }
        this.secure = secure;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.136 -0500", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "C50FCE23852EDA3AF845FEC4AC445DA3")
    
public String getHost() {
        return this.host;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.139 -0500", hash_original_method = "1447F7E138124D077576DF2B2413D348", hash_generated_method = "71B5B2BA13545228F6995E189446BF30")
    
public String getPath() {
        return this.path;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.141 -0500", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "2827709310D4A6354CC4E0B95B5C1D5F")
    
public int getPort() {
        return this.port;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.143 -0500", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "DC2D38DA21582359FAB387AF8E65432C")
    
public boolean isSecure() {
        return this.secure;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.146 -0500", hash_original_method = "04B66E71C7D8EF5D2D79480EE2BA7CE8", hash_generated_method = "8AF37DDDBD5EC73A7F74FFD2CB07087A")
    
@Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append('[');
        if (this.secure) {
            buffer.append("(secure)");
        }
        buffer.append(this.host);
        buffer.append(':');
        buffer.append(Integer.toString(this.port));
        buffer.append(this.path);
        buffer.append(']');
        return buffer.toString();
    }
    
}

