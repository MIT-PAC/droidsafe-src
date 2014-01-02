package org.bouncycastle.asn1.x500.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



class X500NameTokenizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.945 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String          value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.948 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int             index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.950 -0500", hash_original_field = "450887207B167A57F0B6A51538C1CEB3", hash_generated_field = "9FFFB1A798BF85E8FA366500A206FB25")

    private char            seperator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.953 -0500", hash_original_field = "6BF29059F9FE86F9640C085A7CC351C5", hash_generated_field = "22C3EB28ABC67744D189D37B59EAF1C4")

    private StringBuffer    buf = new StringBuffer();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.956 -0500", hash_original_method = "87C1EB4E958A465E857DAC381279FD5A", hash_generated_method = "87A1F48DFDF738BEE2F41AA36EEEC112")
    
public X500NameTokenizer(
        String  oid)
    {
        this(oid, ',');
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.959 -0500", hash_original_method = "C3EF91B48B2B40246915FB55098DB430", hash_generated_method = "8F5C06A22E81DBC1873932DAF0BAC996")
    
public X500NameTokenizer(
        String  oid,
        char    seperator)
    {
        this.value = oid;
        this.index = -1;
        this.seperator = seperator;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.961 -0500", hash_original_method = "A840AC1B987121BDC7999220A560F7B6", hash_generated_method = "BBE665AA7ABD6B9803FDCCBFD3A685E9")
    
public boolean hasMoreTokens()
    {
        return (index != value.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.964 -0500", hash_original_method = "A2F2FA85B4C6A562CE43722C053D9F00", hash_generated_method = "7B9EC08A6A7ECB150E613464CE0AC887")
    
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

