package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.ParametersHeader;
import java.text.ParseException;
import java.util.Iterator;
import javax.sip.header.ExtensionHeader;

public class References extends ParametersHeader implements ReferencesHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.725 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "14745A902962E272FDA1DE862859D03C")

    private String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.725 -0400", hash_original_method = "6B62E640F31436F860F8D9827B037777", hash_generated_method = "768BC1B29AB1FAC713C1D8CE0EE02B20")
    public  References() {
        super(ReferencesHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.726 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "1D86390EEE27886727F9BF659D02B974")
    public String getCallId() {
String var5E6A5595C014DC7657F3E7EDB5AB9AD0_1245966909 =         callId;
        var5E6A5595C014DC7657F3E7EDB5AB9AD0_1245966909.addTaint(taint);
        return var5E6A5595C014DC7657F3E7EDB5AB9AD0_1245966909;
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.726 -0400", hash_original_method = "91B139942A314EFB2C4BD7B21FDCB20D", hash_generated_method = "554015206FE5AB2B6C217E13CA6331D3")
    public String getRel() {
String varEA085D01929B1B42394A68C55CC5EB34_342568854 =         this.getParameter(REL);
        varEA085D01929B1B42394A68C55CC5EB34_342568854.addTaint(taint);
        return varEA085D01929B1B42394A68C55CC5EB34_342568854;
        // ---------- Original Method ----------
        //return this.getParameter(REL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.727 -0400", hash_original_method = "6391CCCA5D3045DA0366706159D24F88", hash_generated_method = "89EAE1F620DB52540F2B1E2C4575CE19")
    public void setCallId(String callId) {
        this.callId = callId;
        // ---------- Original Method ----------
        //this.callId = callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.727 -0400", hash_original_method = "FC242B166942B60DF02BE0B79DEF218D", hash_generated_method = "1E099169185A36190E99B89A2D2FAA11")
    public void setRel(String rel) throws ParseException {
        addTaint(rel.getTaint());
    if(rel != null)        
        {
            this.setParameter(REL,rel);
        } //End block
        // ---------- Original Method ----------
        //if ( rel != null ) {
          //this.setParameter(REL,rel);
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.727 -0400", hash_original_method = "1C9EBF6FB53478B12B2F8D939C3DAA09", hash_generated_method = "DF0659AE73ACE790D5FAFF574427DEB1")
    public String getParameter(String name) {
        addTaint(name.getTaint());
String var93ABFC9A758D64F9CF0A48E2109D5044_1835841862 =         super.getParameter(name);
        var93ABFC9A758D64F9CF0A48E2109D5044_1835841862.addTaint(taint);
        return var93ABFC9A758D64F9CF0A48E2109D5044_1835841862;
        // ---------- Original Method ----------
        //return super.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.728 -0400", hash_original_method = "5B135F944D95FEB85E76FF3C1A46B535", hash_generated_method = "C7AEB18B08FA0915230EE1517137664E")
    public Iterator getParameterNames() {
Iterator var94DC65FB2EC0E6D50D73D04A0A1EDA98_310469284 =         super.getParameterNames();
        var94DC65FB2EC0E6D50D73D04A0A1EDA98_310469284.addTaint(taint);
        return var94DC65FB2EC0E6D50D73D04A0A1EDA98_310469284;
        // ---------- Original Method ----------
        //return super.getParameterNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.728 -0400", hash_original_method = "3BCAED05568F294E5383E287ED81A26C", hash_generated_method = "B4862296FA97F2DCD35B6969D77FB5F9")
    public void removeParameter(String name) {
        addTaint(name.getTaint());
        super.removeParameter(name);
        // ---------- Original Method ----------
        //super.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.728 -0400", hash_original_method = "BB55D06717833A89C2B24ACE66FD668C", hash_generated_method = "456493E0BA8EE79DFF94DE0859F7617E")
    public void setParameter(String name, String value) throws ParseException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        super.setParameter(name,value);
        // ---------- Original Method ----------
        //super.setParameter(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.729 -0400", hash_original_method = "E46EA6665F0CD807BC3E748EE65E1EE2", hash_generated_method = "2112FEBF1CD89EDE43D48E4C1DBAC918")
    public String getName() {
String var3CAE5995445ABD1DAEB0EE0A43C2A8EA_1830584497 =         ReferencesHeader.NAME;
        var3CAE5995445ABD1DAEB0EE0A43C2A8EA_1830584497.addTaint(taint);
        return var3CAE5995445ABD1DAEB0EE0A43C2A8EA_1830584497;
        // ---------- Original Method ----------
        //return ReferencesHeader.NAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.729 -0400", hash_original_method = "9EEB3319C6EED2658F191ED9602B88D2", hash_generated_method = "E98B5271D7FC72EAF0C317913FAAF244")
    protected String encodeBody() {
    if(super.parameters.isEmpty())        
        {
String var5E6A5595C014DC7657F3E7EDB5AB9AD0_93777225 =             callId;
            var5E6A5595C014DC7657F3E7EDB5AB9AD0_93777225.addTaint(taint);
            return var5E6A5595C014DC7657F3E7EDB5AB9AD0_93777225;
        } //End block
        else
        {
String var9E25CF61F2A135B94A4051F3E07DACF2_1364893277 =             callId + ";" + super.parameters.encode();
            var9E25CF61F2A135B94A4051F3E07DACF2_1364893277.addTaint(taint);
            return var9E25CF61F2A135B94A4051F3E07DACF2_1364893277;
        } //End block
        // ---------- Original Method ----------
        //if ( super.parameters.isEmpty()) {
            //return callId ;
        //} else {
            //return callId + ";" + super.parameters.encode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.730 -0400", hash_original_method = "66E692F28E8D2B6D542E6103B4241B59", hash_generated_method = "DF41B084A3894F56950F0A2674879B8F")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        UnsupportedOperationException varC0F97110833DF7AE83952ACC5DAEC8C5_1476779234 = new UnsupportedOperationException("operation not supported");
        varC0F97110833DF7AE83952ACC5DAEC8C5_1476779234.addTaint(taint);
        throw varC0F97110833DF7AE83952ACC5DAEC8C5_1476779234;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("operation not supported");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.730 -0400", hash_original_field = "2CB8ABC26FB5C89D55D40BF36FA263FD", hash_generated_field = "C421C56BF00B0B8C72F8AAF383942C04")

    private static final long serialVersionUID = 8536961681006637622L;
}

