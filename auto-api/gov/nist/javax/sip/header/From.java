package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;
import javax.sip.header.FromHeader;
import java.text.ParseException;

public final class From extends AddressParametersHeader implements javax.sip.header.FromHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.946 -0400", hash_original_method = "A8AF16A2B82DF0D28539600E0CD03867", hash_generated_method = "8B4FB7A089C02734F178949F120FBE8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public From() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.946 -0400", hash_original_method = "DD530C3FC2E9C76342F91D9F2F4B8C8E", hash_generated_method = "91A0AA3892CB63579E767CA12D6B902E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public From(To to) {
        super(NAME);
        dsTaint.addTaint(to.dsTaint);
        address = to.address;
        parameters = to.parameters;
        // ---------- Original Method ----------
        //address = to.address;
        //parameters = to.parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.947 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "78B305F9FD3C2424754EBC760B26C3AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1382771235 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.947 -0400", hash_original_method = "27E6A85D53E8FED6E5ECB6F24D4DAAA6", hash_generated_method = "148A2BB5E64B10163F892E7DA05B242A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_226059435 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(LESS_THAN);
            } //End block
        } //End collapsed parenthetic
        address.encode(buffer);
        {
            boolean varA8A94084CEDB8AE131E76CDFE26F1997_11972643 = (address.getAddressType() == AddressImpl.ADDRESS_SPEC);
            {
                buffer.append(GREATER_THAN);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1221078567 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //buffer.append(LESS_THAN);
        //}
        //address.encode(buffer);
        //if (address.getAddressType() == AddressImpl.ADDRESS_SPEC) {
            //buffer.append(GREATER_THAN);
        //}
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.947 -0400", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "E621EF30602352F45F6BE0C835F2BD5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getHostPort() {
        HostPort varEEF9871E33E64F4E24422F40F5C745CE_1149627796 = (address.getHostPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return address.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.947 -0400", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "EBE5107ED258BE01C9D5560A35A0973D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDisplayName() {
        String var31866FBF526B94C8B9049BB4E32C34D2_1779381815 = (address.getDisplayName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address.getDisplayName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.947 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "47AE8E46DBF5238576DA4B414C4EDA8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTag() {
        String var2CBE987BEB64DE2AB52488AA15F8609C_90990930 = (getParameter(ParameterNames.TAG));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.948 -0400", hash_original_method = "17DACA856A7B157094F93A364689CD76", hash_generated_method = "B2E57B75B3E125B4BE029DFF10F5434A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasTag() {
        boolean var6FA539423622336D479E26E4BC38CB5D_671190408 = (hasParameter(ParameterNames.TAG));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.948 -0400", hash_original_method = "6CBAE502E931683D712FFCD149457FE9", hash_generated_method = "591C4D746C800825165C55AACDA722E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeTag() {
        parameters.delete(ParameterNames.TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.948 -0400", hash_original_method = "2BC13538206715D5DC8E4E386607DAE6", hash_generated_method = "951CB3414C18C28EEDC4D52722B73A4C")
    @DSModeled(DSC.SAFE)
    public void setAddress(javax.sip.address.Address address) {
        dsTaint.addTaint(address.dsTaint);
        this.address = (AddressImpl) address;
        // ---------- Original Method ----------
        //this.address = (AddressImpl) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.948 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "97D69F18C02152E862494A696E9EA9DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTag(String t) throws ParseException {
        dsTaint.addTaint(t);
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        // ---------- Original Method ----------
        //Parser.checkToken(t);
        //this.setParameter(ParameterNames.TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.948 -0400", hash_original_method = "37555C718EB6A285C8BC30DC0A9F7E97", hash_generated_method = "4526E5925ABAE661373C1143DE6A4ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserAtHostPort() {
        String varC05CA356E71E92F83BBFC5717562CC1F_1992442346 = (address.getUserAtHostPort());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address.getUserAtHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.949 -0400", hash_original_method = "C3BE149D6ECB953ABC4DB66247B816D2", hash_generated_method = "3464DB91C1A3B65C7200B00FD535C98C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean var26F738A7BDC5DB0DA65628E1DFDFF566_157995830 = ((other instanceof FromHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof FromHeader) && super.equals(other);
    }

    
    private static final long serialVersionUID = -6312727234330643892L;
}

