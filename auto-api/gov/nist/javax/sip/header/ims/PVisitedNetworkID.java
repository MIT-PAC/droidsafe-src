package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Parameters;
import gov.nist.core.Token;

public class PVisitedNetworkID extends gov.nist.javax.sip.header.ParametersHeader implements PVisitedNetworkIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.421 -0400", hash_original_field = "6765D300ED0DF69297651AA67E1B8302", hash_generated_field = "C4CD23BC06318F8990510CDE3BD92C0F")

    private String networkID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.421 -0400", hash_original_field = "09410BFCF0E9D91B2406868E266A19B9", hash_generated_field = "2863DBAD0B0E1EA5F78AE4C051C969E2")

    private boolean isQuoted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.421 -0400", hash_original_method = "051A535620162843E1B90678BF3DA49E", hash_generated_method = "3CE366DEE4998CA432B3DC12C1B2E9D5")
    public  PVisitedNetworkID() {
        super(P_VISITED_NETWORK_ID);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.421 -0400", hash_original_method = "F3FD852440F29DF78156D2082B766F5C", hash_generated_method = "1DDF45E44ADC6793971E07ACBC64859A")
    public  PVisitedNetworkID(String networkID) {
        super(P_VISITED_NETWORK_ID);
        setVisitedNetworkID(networkID);
        addTaint(networkID.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.422 -0400", hash_original_method = "5824AB36695E623B7CAEFD86EE80361A", hash_generated_method = "A40E4F93D9A587C729929E2012817E48")
    public  PVisitedNetworkID(Token tok) {
        super(P_VISITED_NETWORK_ID);
        setVisitedNetworkID(tok.getTokenValue());
        addTaint(tok.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.422 -0400", hash_original_method = "90D5FECE17BBAD01000BE0E34EB90561", hash_generated_method = "46E6A1422C9797D218A1603B96ABCAC9")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1645780433 = null; 
        StringBuffer retval = new StringBuffer();
        {
            boolean varD46735F28D1AB9461F89ACF0E219DFC3_1658466735 = (getVisitedNetworkID() != null);
            {
                retval.append(DOUBLE_QUOTE + getVisitedNetworkID() + DOUBLE_QUOTE);
                retval.append(getVisitedNetworkID());
            } 
        } 
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_385232825 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1645780433 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1645780433.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1645780433;
        
        
        
        
            
                
            
                
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.423 -0400", hash_original_method = "F88375989912893742E68A8CB169C4C0", hash_generated_method = "C05966E255D9EAF5BA5893D03F93E029")
    public void setVisitedNetworkID(String networkID) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the networkID parameter is null");
        this.networkID = networkID;
        this.isQuoted = true;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.423 -0400", hash_original_method = "3764C600A7ABF764E75A7A0F8A4AD296", hash_generated_method = "8DD434E2000C61B23A7E1609DFF21B08")
    public void setVisitedNetworkID(Token networkID) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the networkID parameter is null");
        this.networkID = networkID.getTokenValue();
        this.isQuoted = false;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.424 -0400", hash_original_method = "C32CBAC6FBA17FDD7866AA432385EFB6", hash_generated_method = "51191DF9A62BE11CD908F1A9381DAAE0")
    public String getVisitedNetworkID() {
        String varB4EAC82CA7396A68D541C85D26508E83_795644532 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_795644532 = networkID;
        varB4EAC82CA7396A68D541C85D26508E83_795644532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_795644532;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.424 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException (value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.424 -0400", hash_original_method = "BB5BE6B7830212EF4C97BABF52359F44", hash_generated_method = "6CCA22EF2826F28F9B2950D1F2449024")
    public boolean equals(Object other) {
        {
            PVisitedNetworkIDHeader o = (PVisitedNetworkIDHeader) other;
            boolean var661AAE0247993E36076F6683D7B53893_459362763 = ((this.getVisitedNetworkID().equals( o.getVisitedNetworkID() )
                && this.equalParameters( (Parameters) o )));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306710593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306710593;
        
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.426 -0400", hash_original_method = "FDDED33F93F598CF66CA227B3E72EBB0", hash_generated_method = "667D5A6C11B693AF08744197DD3A862B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_328189368 = null; 
        PVisitedNetworkID retval = (PVisitedNetworkID) super.clone();
        retval.networkID = this.networkID;
        retval.isQuoted = this.isQuoted;
        varB4EAC82CA7396A68D541C85D26508E83_328189368 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_328189368.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_328189368;
        
        
        
            
        
        
    }

    
}

