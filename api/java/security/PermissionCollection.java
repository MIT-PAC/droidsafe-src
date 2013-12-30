package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Enumeration;





public abstract class PermissionCollection implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.124 -0400", hash_original_method = "9068D0108294B13066862778786146D9", hash_generated_method = "9068D0108294B13066862778786146D9")
    public PermissionCollection ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.049 -0500", hash_original_method = "A893CEBA2C1B71EC9B6720287A34E992", hash_generated_method = "51058B02CF300A57D579EC9F1DE7873E")
    
public abstract void add(Permission permission);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.052 -0500", hash_original_method = "F81820C7A45D25FB2ECB06B8428FC1F6", hash_generated_method = "DAB6A40E19EF8A6639F31AB37799F968")
    
public abstract Enumeration<Permission> elements();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.054 -0500", hash_original_method = "EFDD42BDCC8AFC7DB3076C40E1EA19C3", hash_generated_method = "7DCD9075AD00F391A9B7B11ED234E399")
    
public abstract boolean implies(Permission permission);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.057 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "2994F1C62F4372688739CAB83B342357")
    
public boolean isReadOnly() { return true; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.059 -0500", hash_original_method = "32FE512F278ECF7FA2513E0F8F8332CC", hash_generated_method = "B136FF95B5A3D3070009D24507706350")
    
public void setReadOnly() { }

    
}

