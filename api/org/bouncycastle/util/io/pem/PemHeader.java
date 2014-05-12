package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class PemHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.323 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.325 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.328 -0500", hash_original_method = "4509DA5CCC6D5B482BEA6C1D7CD04168", hash_generated_method = "4CFAA7B932940724E40AF49FA5DE062D")
    
public PemHeader(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.330 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName()
    {
        return name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.333 -0500", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "60823E74DAC88C5FAC14BD2BA786CA0E")
    
public String getValue()
    {
        return value;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.335 -0500", hash_original_method = "D2F99D4FA1F9F9DCD18FFC2807839B4D", hash_generated_method = "44AE669F9D9EDF2C34C9D2B824BEB573")
    
public int hashCode()
    {
        return getHashCode(this.name) + 31 * getHashCode(this.value);    
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.337 -0500", hash_original_method = "008350332C23D1093274CD2597D3DC3D", hash_generated_method = "85C5D51D94A7DE75BFA8195ACDA071EC")
    
public boolean equals(Object o)
    {
        if (!(o instanceof PemHeader))
        {
            return false;
        }

        PemHeader other = (PemHeader)o;

        return other == this || (isEqual(this.name, other.name) && isEqual(this.value, other.value));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.339 -0500", hash_original_method = "552BFCCB5F897360ADAD8A79D56E72F9", hash_generated_method = "8CE35C1399F8AC3D09351D2FD671746F")
    
private int getHashCode(String s)
    {
        if (s == null)
        {
            return 1;
        }

        return s.hashCode();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.341 -0500", hash_original_method = "56C7E9071A8414DCCD1359B9AFE0CC30", hash_generated_method = "A99870F16E25AC263849C9A12FC58B8C")
    
private boolean isEqual(String s1, String s2)
    {
        if (s1 == s2)
        {
            return true;
        }

        if (s1 == null || s2 == null)
        {
            return false;
        }

        return s1.equals(s2);
    }
    
}

