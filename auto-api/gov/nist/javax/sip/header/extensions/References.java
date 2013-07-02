package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.ParametersHeader;
import java.text.ParseException;
import java.util.Iterator;
import javax.sip.header.ExtensionHeader;

public class References extends ParametersHeader implements ReferencesHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.040 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "14745A902962E272FDA1DE862859D03C")

    private String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.040 -0400", hash_original_method = "6B62E640F31436F860F8D9827B037777", hash_generated_method = "768BC1B29AB1FAC713C1D8CE0EE02B20")
    public  References() {
        super(ReferencesHeader.NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.041 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "FC7E9092138A9369B9A8FCB995B0911D")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1587654818 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1587654818 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_1587654818.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1587654818;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.041 -0400", hash_original_method = "91B139942A314EFB2C4BD7B21FDCB20D", hash_generated_method = "659C5084D82F00F7E8F71F396773F308")
    public String getRel() {
        String varB4EAC82CA7396A68D541C85D26508E83_335796145 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_335796145 = this.getParameter(REL);
        varB4EAC82CA7396A68D541C85D26508E83_335796145.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335796145;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.042 -0400", hash_original_method = "6391CCCA5D3045DA0366706159D24F88", hash_generated_method = "89EAE1F620DB52540F2B1E2C4575CE19")
    public void setCallId(String callId) {
        this.callId = callId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.042 -0400", hash_original_method = "FC242B166942B60DF02BE0B79DEF218D", hash_generated_method = "85CA0BADDC54060FC0721DC5F32CBF1D")
    public void setRel(String rel) throws ParseException {
        {
            this.setParameter(REL,rel);
        } 
        addTaint(rel.getTaint());
        
        
          
      
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.043 -0400", hash_original_method = "1C9EBF6FB53478B12B2F8D939C3DAA09", hash_generated_method = "51E75AD2525DA69C6109E97102BE320E")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_483993535 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_483993535 = super.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_483993535.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_483993535;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.043 -0400", hash_original_method = "5B135F944D95FEB85E76FF3C1A46B535", hash_generated_method = "9FBD59A1D4E00BC7885BB95EB2343B0E")
    public Iterator getParameterNames() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_1726878630 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1726878630 = super.getParameterNames();
        varB4EAC82CA7396A68D541C85D26508E83_1726878630.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1726878630;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.043 -0400", hash_original_method = "3BCAED05568F294E5383E287ED81A26C", hash_generated_method = "78F391686A5E3DA20E10598898811EE7")
    public void removeParameter(String name) {
        super.removeParameter(name);
        addTaint(name.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.044 -0400", hash_original_method = "BB55D06717833A89C2B24ACE66FD668C", hash_generated_method = "242515E93F9B1414A9B34797457580B3")
    public void setParameter(String name, String value) throws ParseException {
        super.setParameter(name,value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.045 -0400", hash_original_method = "E46EA6665F0CD807BC3E748EE65E1EE2", hash_generated_method = "258B14CD301924253B2E5266D876D21C")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2067839604 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2067839604 = ReferencesHeader.NAME;
        varB4EAC82CA7396A68D541C85D26508E83_2067839604.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2067839604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.047 -0400", hash_original_method = "9EEB3319C6EED2658F191ED9602B88D2", hash_generated_method = "87B0CC8823905F273E1F56831D2FD731")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1631727081 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_422302162 = null; 
        {
            boolean varE23E644C9FCA722BF2C7FAA084D9FBE4_1690851393 = (super.parameters.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1631727081 = callId;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_422302162 = callId + ";" + super.parameters.encode();
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_783960929; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_783960929 = varB4EAC82CA7396A68D541C85D26508E83_1631727081;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_783960929 = varB4EAC82CA7396A68D541C85D26508E83_422302162;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_783960929.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_783960929;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.047 -0400", hash_original_method = "66E692F28E8D2B6D542E6103B4241B59", hash_generated_method = "8708F36ECE8DE3D81D2C9685B1A9DA94")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("operation not supported");
        addTaint(value.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.047 -0400", hash_original_field = "2CB8ABC26FB5C89D55D40BF36FA263FD", hash_generated_field = "C421C56BF00B0B8C72F8AAF383942C04")

    private static final long serialVersionUID = 8536961681006637622L;
}

