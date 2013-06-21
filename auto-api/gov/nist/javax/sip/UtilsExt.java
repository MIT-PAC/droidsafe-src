package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface UtilsExt {

    
    public String generateCallIdentifier(String address);

    
    public String generateTag();
    
    public String generateBranchId();
    
    
}
