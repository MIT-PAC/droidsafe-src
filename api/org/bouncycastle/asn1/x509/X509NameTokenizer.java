package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class X509NameTokenizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.842 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String          value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.844 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int             index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.846 -0500", hash_original_field = "450887207B167A57F0B6A51538C1CEB3", hash_generated_field = "9FFFB1A798BF85E8FA366500A206FB25")

    private char            seperator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.848 -0500", hash_original_field = "6BF29059F9FE86F9640C085A7CC351C5", hash_generated_field = "22C3EB28ABC67744D189D37B59EAF1C4")

    private StringBuffer    buf = new StringBuffer();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.851 -0500", hash_original_method = "E29DC46EF5738DAFDF44DDEEECCCD2C0", hash_generated_method = "365D8F9D27DE1D152FAFDB5EB9B7580E")
    
public X509NameTokenizer(
        String  oid)
    {
        this(oid, ',');
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.853 -0500", hash_original_method = "6C4980154E892C5E33B9260977D1D61C", hash_generated_method = "509BF036648707CEC8873B7D138A7B64")
    
public X509NameTokenizer(
        String  oid,
        char    seperator)
    {
        this.value = oid;
        this.index = -1;
        this.seperator = seperator;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.856 -0500", hash_original_method = "A840AC1B987121BDC7999220A560F7B6", hash_generated_method = "BBE665AA7ABD6B9803FDCCBFD3A685E9")
    
public boolean hasMoreTokens()
    {
        return (index != value.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.859 -0500", hash_original_method = "609C206EB69C69406C6D19A5ED0989AC", hash_generated_method = "FCAE940CF4FF0ECB3EA0AEBD3A5B8F62")
    
public String nextToken()
    {
        if (index == value.length())
        {
            return null;
        }

        int     end = index + 1;
        boolean quoted = false;
        boolean escaped = false;

        buf.setLength(0);

        while (end != value.length())
        {
            char    c = value.charAt(end);

            if (c == '"')
            {
                if (!escaped)
                {
                    quoted = !quoted;
                }
                else
                {
                    // BEGIN android-added
                    // copied from a newer version of BouncyCastle
                    if (c == '#' && buf.charAt(buf.length() - 1) == '=')
                    {
                        buf.append('\\');
                    }
                    else if (c == '+' && seperator != '+')
                    {
                        buf.append('\\');
                    }
                    // END android-added
                    buf.append(c);
                }
                escaped = false;
            }
            else
            {
                if (escaped || quoted)
                {
                    if (c == '#' && buf.charAt(buf.length() - 1) == '=')
                    {
                        buf.append('\\');
                    }
                    else if (c == '+' && seperator != '+')
                    {
                        buf.append('\\');
                    }
                    buf.append(c);
                    escaped = false;
                }
                else if (c == '\\')
                {
                    escaped = true;
                }
                else if (c == seperator)
                {
                    break;
                }
                else
                {
                    buf.append(c);
                }
            }
            end++;
        }

        index = end;
        return buf.toString().trim();
    }

    
}

