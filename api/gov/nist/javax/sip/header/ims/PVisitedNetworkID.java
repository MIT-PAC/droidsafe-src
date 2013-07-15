package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import javax.sip.header.Parameters;
import gov.nist.core.Token;

public class PVisitedNetworkID extends gov.nist.javax.sip.header.ParametersHeader implements PVisitedNetworkIDHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.096 -0400", hash_original_field = "6765D300ED0DF69297651AA67E1B8302", hash_generated_field = "C4CD23BC06318F8990510CDE3BD92C0F")

    private String networkID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.096 -0400", hash_original_field = "09410BFCF0E9D91B2406868E266A19B9", hash_generated_field = "2863DBAD0B0E1EA5F78AE4C051C969E2")

    private boolean isQuoted;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.096 -0400", hash_original_method = "051A535620162843E1B90678BF3DA49E", hash_generated_method = "3CE366DEE4998CA432B3DC12C1B2E9D5")
    public  PVisitedNetworkID() {
        super(P_VISITED_NETWORK_ID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.096 -0400", hash_original_method = "F3FD852440F29DF78156D2082B766F5C", hash_generated_method = "30D2F8F6796EF6A2C2BB59E74881FC25")
    public  PVisitedNetworkID(String networkID) {
        super(P_VISITED_NETWORK_ID);
        addTaint(networkID.getTaint());
        setVisitedNetworkID(networkID);
        // ---------- Original Method ----------
        //setVisitedNetworkID(networkID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.097 -0400", hash_original_method = "5824AB36695E623B7CAEFD86EE80361A", hash_generated_method = "013D487482F9576F961EAF1CCFA59767")
    public  PVisitedNetworkID(Token tok) {
        super(P_VISITED_NETWORK_ID);
        addTaint(tok.getTaint());
        setVisitedNetworkID(tok.getTokenValue());
        // ---------- Original Method ----------
        //setVisitedNetworkID(tok.getTokenValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.097 -0400", hash_original_method = "90D5FECE17BBAD01000BE0E34EB90561", hash_generated_method = "3E1D2A444ADE56FD8670F84408D79DC7")
    protected String encodeBody() {
        StringBuffer retval = new StringBuffer();
    if(getVisitedNetworkID() != null)        
        {
    if(isQuoted)            
            retval.append(DOUBLE_QUOTE + getVisitedNetworkID() + DOUBLE_QUOTE);
            else
            retval.append(getVisitedNetworkID());
        } //End block
    if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
String var1B324365A764C077A55854483509F4AB_320957795 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_320957795.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_320957795;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //if (getVisitedNetworkID() != null)
        //{
            //if (isQuoted)
                //retval.append(DOUBLE_QUOTE + getVisitedNetworkID() + DOUBLE_QUOTE);
            //else
                //retval.append(getVisitedNetworkID());
        //}
        //if (!parameters.isEmpty())
            //retval.append(SEMICOLON + this.parameters.encode());
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.098 -0400", hash_original_method = "F88375989912893742E68A8CB169C4C0", hash_generated_method = "E11899E665C5FB2180B12AB8FF45DC68")
    public void setVisitedNetworkID(String networkID) {
    if(networkID == null)        
        {
        NullPointerException var0CC9126B3134D7EB10C634AE36E02BCD_656634372 = new NullPointerException(" the networkID parameter is null");
        var0CC9126B3134D7EB10C634AE36E02BCD_656634372.addTaint(taint);
        throw var0CC9126B3134D7EB10C634AE36E02BCD_656634372;
        }
        this.networkID = networkID;
        this.isQuoted = true;
        // ---------- Original Method ----------
        //if (networkID == null)
            //throw new NullPointerException(" the networkID parameter is null");
        //this.networkID = networkID;
        //this.isQuoted = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.099 -0400", hash_original_method = "3764C600A7ABF764E75A7A0F8A4AD296", hash_generated_method = "28568253EF3D05509B33F9D846EBE557")
    public void setVisitedNetworkID(Token networkID) {
    if(networkID == null)        
        {
        NullPointerException var0CC9126B3134D7EB10C634AE36E02BCD_812034319 = new NullPointerException(" the networkID parameter is null");
        var0CC9126B3134D7EB10C634AE36E02BCD_812034319.addTaint(taint);
        throw var0CC9126B3134D7EB10C634AE36E02BCD_812034319;
        }
        this.networkID = networkID.getTokenValue();
        this.isQuoted = false;
        // ---------- Original Method ----------
        //if (networkID == null)
            //throw new NullPointerException(" the networkID parameter is null");
        //this.networkID = networkID.getTokenValue();
        //this.isQuoted = false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.099 -0400", hash_original_method = "C32CBAC6FBA17FDD7866AA432385EFB6", hash_generated_method = "0E7206A61F7DE30DB9D44B0F937A47AB")
    public String getVisitedNetworkID() {
String var4407FF7AA9ED0126D0C1885DD8BF4B81_234322984 =         networkID;
        var4407FF7AA9ED0126D0C1885DD8BF4B81_234322984.addTaint(taint);
        return var4407FF7AA9ED0126D0C1885DD8BF4B81_234322984;
        // ---------- Original Method ----------
        //return networkID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.099 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "519F592F0661ED26F42E8F7FB0D9118E")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_611541353 = new ParseException (value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_611541353.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_611541353;
        // ---------- Original Method ----------
        //throw new ParseException (value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.100 -0400", hash_original_method = "BB5BE6B7830212EF4C97BABF52359F44", hash_generated_method = "1297CF582C8C674CC39345DEB469151D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof PVisitedNetworkIDHeader)        
        {
            PVisitedNetworkIDHeader o = (PVisitedNetworkIDHeader) other;
            boolean varF3AB667860A047747DB8DCC7D4B962FD_256807246 = ((this.getVisitedNetworkID().equals( o.getVisitedNetworkID() )
                && this.equalParameters( (Parameters) o )));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386614841 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_386614841;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_204474083 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_898164153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_898164153;
        // ---------- Original Method ----------
        //if (other instanceof PVisitedNetworkIDHeader)
        //{
            //PVisitedNetworkIDHeader o = (PVisitedNetworkIDHeader) other;
            //return (this.getVisitedNetworkID().equals( o.getVisitedNetworkID() )
                //&& this.equalParameters( (Parameters) o ));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.101 -0400", hash_original_method = "FDDED33F93F598CF66CA227B3E72EBB0", hash_generated_method = "87AA1254D45B14DD7F12462C0F4E1970")
    public Object clone() {
        PVisitedNetworkID retval = (PVisitedNetworkID) super.clone();
    if(this.networkID != null)        
        retval.networkID = this.networkID;
        retval.isQuoted = this.isQuoted;
Object varF9E19AD6135C970F387F77C6F3DE4477_1955259654 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1955259654.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1955259654;
        // ---------- Original Method ----------
        //PVisitedNetworkID retval = (PVisitedNetworkID) super.clone();
        //if (this.networkID != null)
            //retval.networkID = this.networkID;
        //retval.isQuoted = this.isQuoted;
        //return retval;
    }

    
}

