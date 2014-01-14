package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;
import java.util.Iterator;

import javax.sip.header.ExtensionHeader;

public class References extends ParametersHeader implements ReferencesHeader, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.089 -0500", hash_original_field = "74F5FFE09C906773747468BAC3911F89", hash_generated_field = "C421C56BF00B0B8C72F8AAF383942C04")

    private static final long serialVersionUID = 8536961681006637622L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.092 -0500", hash_original_field = "2657C3812CAC2EE2FF30C5C628C0A470", hash_generated_field = "14745A902962E272FDA1DE862859D03C")
    
    private String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.096 -0500", hash_original_method = "6B62E640F31436F860F8D9827B037777", hash_generated_method = "41066D355824B0A21C80A54990B2CD49")
    
public References() {
        super(ReferencesHeader.NAME);
    }
  
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.100 -0500", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "EB02B081C7AB467A549CA8E38E41CE27")
    
public String getCallId() {
       return callId;
    }
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.103 -0500", hash_original_method = "91B139942A314EFB2C4BD7B21FDCB20D", hash_generated_method = "7C5859080605FC6164060D9F46FB703E")
    
public String getRel() {
        return this.getParameter(REL);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.106 -0500", hash_original_method = "6391CCCA5D3045DA0366706159D24F88", hash_generated_method = "D73B3C0F97AC60C19C24132020D37C98")
    
public void setCallId(String callId) {
        this.callId = callId;
    }
       
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.109 -0500", hash_original_method = "FC242B166942B60DF02BE0B79DEF218D", hash_generated_method = "90B2190496B23D04999106A81A276488")
    
public void setRel(String rel) throws ParseException{
      if ( rel != null ) {
          this.setParameter(REL,rel);
      }
    }
  
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.112 -0500", hash_original_method = "1C9EBF6FB53478B12B2F8D939C3DAA09", hash_generated_method = "B38238191E589CFAEF4BB037653484B0")
    
public String getParameter(String name) {
        return super.getParameter(name);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.115 -0500", hash_original_method = "5B135F944D95FEB85E76FF3C1A46B535", hash_generated_method = "7CFD2C15B08C6E9707C72FE644E43B7B")
    
public Iterator getParameterNames() {
        return super.getParameterNames();
    }
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.118 -0500", hash_original_method = "3BCAED05568F294E5383E287ED81A26C", hash_generated_method = "BEC31D8F0041D11D83210F2AAE130303")
    
public void removeParameter(String name) {
       super.removeParameter(name);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.121 -0500", hash_original_method = "BB55D06717833A89C2B24ACE66FD668C", hash_generated_method = "3CD264EEA34F2BE0345E562615DCDEE7")
    
public void setParameter(String name, String value) throws ParseException {
       super.setParameter(name,value); 
    }
 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.124 -0500", hash_original_method = "E46EA6665F0CD807BC3E748EE65E1EE2", hash_generated_method = "4D9D938D379CD0F657536DC58015AA16")
    
public String getName() {
        return ReferencesHeader.NAME;
    }
   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.127 -0500", hash_original_method = "9EEB3319C6EED2658F191ED9602B88D2", hash_generated_method = "E9520BA1C7ABBABEE0F2BA7444D38810")
    
protected String encodeBody() {
        if ( super.parameters.isEmpty()) {
            return callId ;
        } else {
            return callId + ";" + super.parameters.encode();
        }
    }
   
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:59.130 -0500", hash_original_method = "66E692F28E8D2B6D542E6103B4241B59", hash_generated_method = "45FFC0D343CF1D2C05109A828FC32784")
    
public void setValue(String value) throws ParseException {
        throw new UnsupportedOperationException("operation not supported");
    }
}

