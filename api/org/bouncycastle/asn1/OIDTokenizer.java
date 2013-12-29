package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class OIDTokenizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.976 -0500", hash_original_field = "9C420410CA5A3136C0764F58D4287A0B", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String  oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.976 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int     index;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.977 -0500", hash_original_method = "88D58AFE0405FCD9AB8F5CA4BE2D1534", hash_generated_method = "F9201CCECE94837619BE562993F21309")
    public OIDTokenizer(
        String oid)
    {
        this.oid = oid;
        this.index = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.978 -0500", hash_original_method = "F35D489C40702BC97B5927032D797DB7", hash_generated_method = "089986D074A3455ED2BCC78F70C2FC5A")
    public boolean hasMoreTokens()
    {
        return (index != -1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.979 -0500", hash_original_method = "4BAC87A2A9C681CC296BE2241CAA6D87", hash_generated_method = "81407B15D41440E84EB8A71FEB2F7BA4")
    public String nextToken()
    {
        if (index == -1)
        {
            return null;
        }

        String  token;
        int     end = oid.indexOf('.', index);

        if (end == -1)
        {
            token = oid.substring(index);
            index = -1;
            return token;
        }

        token = oid.substring(index, end);

        index = end + 1;
        return token;
    }

    
}

