package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

import android.net.http.SslError;
import android.os.Bundle;

final class SslCertLookupTable {

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.931 -0500", hash_original_method = "CD6DF52A90A28734AE0DB5D95ED8CB7E", hash_generated_method = "7710C9504BE0F8C0A11727C58728E8B2")
    
public static SslCertLookupTable getInstance() {
        if (sTable == null) {
            sTable = new SslCertLookupTable();
        }
        return sTable;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.926 -0500", hash_original_field = "1F112B7EB0096F3346C6F0EE0EC0E85C", hash_generated_field = "2A9D3A10505DE76D3665C10F8539BC83")

    private static SslCertLookupTable sTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.929 -0500", hash_original_field = "F952A7965DCC23EBC93DE1080DD00948", hash_generated_field = "E7D6180A9A0AC63D2200ADF169A7E529")

    private  Bundle table;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.933 -0500", hash_original_method = "81BA7CE42C429B1D2F4A8FA68B131FF3", hash_generated_method = "0B6004FF78C212B86ADA49F111537F2F")
    
private SslCertLookupTable() {
        table = new Bundle();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.936 -0500", hash_original_method = "D1D349299054A2A05843F53D2271E3F3", hash_generated_method = "E561224C57EB1B8CF63C7D6BC20B2C9C")
    
public void setIsAllowed(SslError sslError) {
        String host;
        try {
            host = new URL(sslError.getUrl()).getHost();
        } catch(MalformedURLException e) {
            return;
        }
        table.putInt(host, sslError.getPrimaryError());
    }

    // We allow the decision to be re-used if it's for the same host and is for
    // an error of equal or greater severity than this error.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.938 -0500", hash_original_method = "BE69D625DE69B336FE62B540E51D9D21", hash_generated_method = "63DB6FAE29895048381E99DE149D3E9C")
    
public boolean isAllowed(SslError sslError) {
        String host;
        try {
            host = new URL(sslError.getUrl()).getHost();
        } catch(MalformedURLException e) {
            return false;
        }
        return table.containsKey(host) && sslError.getPrimaryError() <= table.getInt(host);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:01.941 -0500", hash_original_method = "ACAE13D192212363EBD03A770903E836", hash_generated_method = "9C8EE8940EE2479AF1820BB5C5F9166A")
    
public void clear() {
        table.clear();
    }
}

