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
    private String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.508 -0400", hash_original_method = "6B62E640F31436F860F8D9827B037777", hash_generated_method = "768BC1B29AB1FAC713C1D8CE0EE02B20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public References() {
        super(ReferencesHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.508 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "A4C78CA17EF88B23534EF15A5A75B5C8")
    @DSModeled(DSC.SAFE)
    public String getCallId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.508 -0400", hash_original_method = "91B139942A314EFB2C4BD7B21FDCB20D", hash_generated_method = "E489B76429BDC1B6209D33E37395B106")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRel() {
        String varD264EF5C7E432D97ABBDD4177E85037B_227171575 = (this.getParameter(REL));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter(REL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.508 -0400", hash_original_method = "6391CCCA5D3045DA0366706159D24F88", hash_generated_method = "38C77BABB430891A7511814A20D7DB96")
    @DSModeled(DSC.SAFE)
    public void setCallId(String callId) {
        dsTaint.addTaint(callId);
        // ---------- Original Method ----------
        //this.callId = callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.508 -0400", hash_original_method = "FC242B166942B60DF02BE0B79DEF218D", hash_generated_method = "46DC5CDE55BF28A5B0A64245E31D8CE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRel(String rel) throws ParseException {
        dsTaint.addTaint(rel);
        {
            this.setParameter(REL,rel);
        } //End block
        // ---------- Original Method ----------
        //if ( rel != null ) {
          //this.setParameter(REL,rel);
      //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.508 -0400", hash_original_method = "1C9EBF6FB53478B12B2F8D939C3DAA09", hash_generated_method = "BA729DD11345787CC8D3624C48982252")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        String varD2999B367DE21AEFAC6574585D97F5BD_938374265 = (super.getParameter(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.getParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.509 -0400", hash_original_method = "5B135F944D95FEB85E76FF3C1A46B535", hash_generated_method = "83465E5C31B06D25FC80C0E0AA9F5767")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator getParameterNames() {
        Iterator var660CD6A48337178BDDCC77C86A9F83F5_2143398241 = (super.getParameterNames());
        return (Iterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.getParameterNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.509 -0400", hash_original_method = "3BCAED05568F294E5383E287ED81A26C", hash_generated_method = "02600E4DBA16B02920CA4B6BDB1E5A74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameter(String name) {
        dsTaint.addTaint(name);
        super.removeParameter(name);
        // ---------- Original Method ----------
        //super.removeParameter(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.509 -0400", hash_original_method = "BB55D06717833A89C2B24ACE66FD668C", hash_generated_method = "6B00E8F65CBD11DF167A63C3B0577B78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameter(String name, String value) throws ParseException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        super.setParameter(name,value);
        // ---------- Original Method ----------
        //super.setParameter(name,value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.509 -0400", hash_original_method = "E46EA6665F0CD807BC3E748EE65E1EE2", hash_generated_method = "94713BF732FBE6EEE3EF62311F52D11B")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ReferencesHeader.NAME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.509 -0400", hash_original_method = "9EEB3319C6EED2658F191ED9602B88D2", hash_generated_method = "673311BE1969FBA2B81E22F1079EA419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        {
            boolean varE23E644C9FCA722BF2C7FAA084D9FBE4_484610514 = (super.parameters.isEmpty());
            {
                String varA5AA6DB00AE4305F7A35B62CBB7D50E3_1384851123 = (callId + ";" + super.parameters.encode());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if ( super.parameters.isEmpty()) {
            //return callId ;
        //} else {
            //return callId + ";" + super.parameters.encode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.509 -0400", hash_original_method = "66E692F28E8D2B6D542E6103B4241B59", hash_generated_method = "7A5BAD5B5D598AE070E912A3CCFFE49C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("operation not supported");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("operation not supported");
    }

    
    private static final long serialVersionUID = 8536961681006637622L;
}

