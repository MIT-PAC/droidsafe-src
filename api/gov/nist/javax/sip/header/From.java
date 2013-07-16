package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;
import javax.sip.header.FromHeader;
import java.text.ParseException;

public final class From extends AddressParametersHeader implements javax.sip.header.FromHeader {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.412 -0400", hash_original_method = "A8AF16A2B82DF0D28539600E0CD03867", hash_generated_method = "8B4FB7A089C02734F178949F120FBE8D")
    public  From() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.413 -0400", hash_original_method = "DD530C3FC2E9C76342F91D9F2F4B8C8E", hash_generated_method = "BE6F04E5FC4E53BC9A0B4858FCF779D1")
    public  From(To to) {
        super(NAME);
        addTaint(to.getTaint());
        address = to.address;
        parameters = to.parameters;
        // ---------- Original Method ----------
        //address = to.address;
        //parameters = to.parameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.413 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "1748928AC238A836A6B99099CDB3C543")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1062483207 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1062483207.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1062483207;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.414 -0400", hash_original_method = "27E6A85D53E8FED6E5ECB6F24D4DAAA6", hash_generated_method = "9021623C123628A0EBEE0DBEBF9A048B")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            buffer.append(LESS_THAN);
        } //End block
        address.encode(buffer);
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)        
        {
            buffer.append(GREATER_THAN);
        } //End block
    if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_291482168 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_291482168.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_291482168;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.414 -0400", hash_original_method = "44C2A950FA90F046EF96B0A5F25DEA38", hash_generated_method = "4CFC3F530E015EFC804553C582C8B562")
    public HostPort getHostPort() {
HostPort var7605DBE171E4A11D1CF5181991039C28_305029604 =         address.getHostPort();
        var7605DBE171E4A11D1CF5181991039C28_305029604.addTaint(taint);
        return var7605DBE171E4A11D1CF5181991039C28_305029604;
        // ---------- Original Method ----------
        //return address.getHostPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.414 -0400", hash_original_method = "0AF5B36A8F5D506032669B65B9CFDD39", hash_generated_method = "4F2568F71484925F4A2175EF20FFE945")
    public String getDisplayName() {
String var2D47464FECA9E570B1B7C27512E620BD_1430080869 =         address.getDisplayName();
        var2D47464FECA9E570B1B7C27512E620BD_1430080869.addTaint(taint);
        return var2D47464FECA9E570B1B7C27512E620BD_1430080869;
        // ---------- Original Method ----------
        //return address.getDisplayName();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.415 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "F712D2FC5D1AF4911BDBD45F97EE9C0D")
    public String getTag() {
    if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_382823452 =         null;
        var540C13E9E156B687226421B24F2DF178_382823452.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_382823452;
        }
String var6121204752E92B3AB21D35C13718F121_463457739 =         getParameter(ParameterNames.TAG);
        var6121204752E92B3AB21D35C13718F121_463457739.addTaint(taint);
        return var6121204752E92B3AB21D35C13718F121_463457739;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.415 -0400", hash_original_method = "17DACA856A7B157094F93A364689CD76", hash_generated_method = "044EFE2011C580DA6544781387844468")
    public boolean hasTag() {
        boolean varE794A2B1FC5BFB81AE860CE890E72CBA_83139239 = (hasParameter(ParameterNames.TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707345444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707345444;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.415 -0400", hash_original_method = "6CBAE502E931683D712FFCD149457FE9", hash_generated_method = "591C4D746C800825165C55AACDA722E0")
    public void removeTag() {
        parameters.delete(ParameterNames.TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.416 -0400", hash_original_method = "2BC13538206715D5DC8E4E386607DAE6", hash_generated_method = "30F82A7321BA9D2259D472B0B5CE158F")
    public void setAddress(javax.sip.address.Address address) {
        addTaint(address.getTaint());
        this.address = (AddressImpl) address;
        // ---------- Original Method ----------
        //this.address = (AddressImpl) address;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.416 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "06CB76253846346CADBED3445825C24C")
    public void setTag(String t) throws ParseException {
        addTaint(t.getTaint());
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        // ---------- Original Method ----------
        //Parser.checkToken(t);
        //this.setParameter(ParameterNames.TAG, t);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.416 -0400", hash_original_method = "37555C718EB6A285C8BC30DC0A9F7E97", hash_generated_method = "FA2BAC4C686276F34B3DD42F60A5AA36")
    public String getUserAtHostPort() {
String var02793A4C7C5CEDDB6ECEC98A612C742B_2042533191 =         address.getUserAtHostPort();
        var02793A4C7C5CEDDB6ECEC98A612C742B_2042533191.addTaint(taint);
        return var02793A4C7C5CEDDB6ECEC98A612C742B_2042533191;
        // ---------- Original Method ----------
        //return address.getUserAtHostPort();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.416 -0400", hash_original_method = "C3BE149D6ECB953ABC4DB66247B816D2", hash_generated_method = "6026CC28595EA2A9645031FBF60FB555")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean varC846DC355765519AF6CB529CF789D6D8_1398740995 = ((other instanceof FromHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564695465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564695465;
        // ---------- Original Method ----------
        //return (other instanceof FromHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.417 -0400", hash_original_field = "E22E7B803F01166739DD9E9BEF3A661F", hash_generated_field = "7ED5DA8E48C4652B9F8E070E997B9D31")

    private static final long serialVersionUID = -6312727234330643892L;
}

