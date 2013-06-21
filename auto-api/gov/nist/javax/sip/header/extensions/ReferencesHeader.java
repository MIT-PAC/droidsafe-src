package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface ReferencesHeader extends Parameters, Header {
    
    public static final String NAME = "References";
    
    public static final String CHAIN = "chain";
    
    public static final String INQUIRY =  "inquiry";
    
    public static final String REFER = "refer" ;
    
    public static final String SEQUEL = "sequel";
    
    public static final String XFER =  "xfer";
      
    public static final String REL = "rel";
    
    public static final String SERVICE = "service";
    
    public void setCallId(String callId) throws ParseException;
       
    public String getCallId();
       
    public void setRel (String rel) throws ParseException;
    
    public String getRel();
        

}
