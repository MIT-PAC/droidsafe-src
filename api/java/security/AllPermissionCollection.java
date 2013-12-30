package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Enumeration;





final class AllPermissionCollection extends PermissionCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.787 -0400", hash_original_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF", hash_generated_method = "0FDD5C4A8E9AC1DDB2FA5A64417EADFF")
    public AllPermissionCollection ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.104 -0500", hash_original_method = "4200EBEC7A86784BE2F7368AF2D9C4EB", hash_generated_method = "2081635398ECBDAECDDEF289F86B0B3A")
    
@Override public void add(Permission permission) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.108 -0500", hash_original_method = "9354983A4C01BAC9D52E1AE4692A1F83", hash_generated_method = "1FD87B31768971C715431B639D6A127C")
    
@Override public Enumeration<Permission> elements() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.113 -0500", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    
@Override public boolean implies(Permission permission) { return true; }

    
}

