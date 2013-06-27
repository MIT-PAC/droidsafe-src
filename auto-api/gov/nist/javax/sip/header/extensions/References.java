package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.ParametersHeader;
import java.text.ParseException;
import java.util.Iterator;
import javax.sip.header.ExtensionHeader;

public class References extends ParametersHeader implements ReferencesHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.985 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "14745A902962E272FDA1DE862859D03C")

    private String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.999 -0400", hash_original_method = "6B62E640F31436F860F8D9827B037777", hash_generated_method = "768BC1B29AB1FAC713C1D8CE0EE02B20")
    public  References() {
        super(ReferencesHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.000 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "8F5A9A8D0C7C7F50C6DDF70F33C5AFE5")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1393770965 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1393770965 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_1393770965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393770965;
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.000 -0400", hash_original_method = "91B139942A314EFB2C4BD7B21FDCB20D", hash_generated_method = "34588EA3165360C0713A170C208ACE97")
    public String getRel() {
        String varB4EAC82CA7396A68D541C85D26508E83_1141483906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1141483906 = this.getParameter(REL);
        varB4EAC82CA7396A68D541C85D26508E83_1141483906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1141483906;
        // ---------- Original Method ----------
        //return this.getParameter(REL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.000 -0400", hash_original_method = "6391CCCA5D3045DA0366706159D24F88", hash_generated_method = "89EAE1F620DB52540F2B1E2C4575CE19")
    public void setCallId(String callId) {
        this.callId = callId;
        // ---------- Original Method ----------
        //this.callId = callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.005 -0400", hash_original_method = "FC242B166942B60DF02BE0B79DEF218D", hash_generated_method = "85CA0BADDC54060FC0721DC5F32CBF1D")
    public void setRel(String rel) throws ParseException {
        {
            this.setParameter(REL,rel);
        } //End block
        addTaint(rel.getTaint());
        // ---------- Original Method ----------
        //if ( rel != null ) {
          //this.setParameter(REL,rel);
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.006 -0400", hash_original_method = "1C9EBF6FB53478B12B2F8D939C3DAA09", hash_generated_method = "0E133C56AA5A45181C048531EA05D478")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1620797015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1620797015 = super.getParameter(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1620797015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1620797015;
        // ---------- Original Method ----------
        //return super.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.006 -0400", hash_original_method = "5B135F944D95FEB85E76FF3C1A46B535", hash_generated_method = "F8F289292AE8ECCF03BD436FFA23C8D2")
    public Iterator getParameterNames() {
        Iterator varB4EAC82CA7396A68D541C85D26508E83_1310565896 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1310565896 = super.getParameterNames();
        varB4EAC82CA7396A68D541C85D26508E83_1310565896.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1310565896;
        // ---------- Original Method ----------
        //return super.getParameterNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.007 -0400", hash_original_method = "3BCAED05568F294E5383E287ED81A26C", hash_generated_method = "78F391686A5E3DA20E10598898811EE7")
    public void removeParameter(String name) {
        super.removeParameter(name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //super.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.007 -0400", hash_original_method = "BB55D06717833A89C2B24ACE66FD668C", hash_generated_method = "242515E93F9B1414A9B34797457580B3")
    public void setParameter(String name, String value) throws ParseException {
        super.setParameter(name,value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //super.setParameter(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.007 -0400", hash_original_method = "E46EA6665F0CD807BC3E748EE65E1EE2", hash_generated_method = "D0E0DA65F08E109FC3D9965E3EEC2CE0")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1063042808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1063042808 = ReferencesHeader.NAME;
        varB4EAC82CA7396A68D541C85D26508E83_1063042808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1063042808;
        // ---------- Original Method ----------
        //return ReferencesHeader.NAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.021 -0400", hash_original_method = "9EEB3319C6EED2658F191ED9602B88D2", hash_generated_method = "87BD89EF0680FA6CB358443CA0CDC2C5")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_554349981 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1030765177 = null; //Variable for return #2
        {
            boolean varE23E644C9FCA722BF2C7FAA084D9FBE4_1165700363 = (super.parameters.isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_554349981 = callId;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1030765177 = callId + ";" + super.parameters.encode();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1488903307; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1488903307 = varB4EAC82CA7396A68D541C85D26508E83_554349981;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1488903307 = varB4EAC82CA7396A68D541C85D26508E83_1030765177;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1488903307.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1488903307;
        // ---------- Original Method ----------
        //if ( super.parameters.isEmpty()) {
            //return callId ;
        //} else {
            //return callId + ";" + super.parameters.encode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.022 -0400", hash_original_method = "66E692F28E8D2B6D542E6103B4241B59", hash_generated_method = "8708F36ECE8DE3D81D2C9685B1A9DA94")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("operation not supported");
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("operation not supported");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.022 -0400", hash_original_field = "2CB8ABC26FB5C89D55D40BF36FA263FD", hash_generated_field = "F5F98D9D48932D38B041EDA880CA3780")

    private static long serialVersionUID = 8536961681006637622L;
}

