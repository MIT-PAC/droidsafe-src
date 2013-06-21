package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.stack.HopImpl;
import javax.sip.InvalidArgumentException;
import javax.sip.address.Hop;
import javax.sip.header.ViaHeader;
import java.text.ParseException;

public class Via extends ParametersHeader implements javax.sip.header.ViaHeader, ViaHeaderExt {
    protected Protocol sentProtocol;
    protected HostPort sentBy;
    protected String comment;
    private boolean rPortFlag = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.472 -0400", hash_original_method = "7D07E05C0BEE96603D98F8B1E7A2E317", hash_generated_method = "05BCC6515CD84F16CEE1E054ED6F0504")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Via() {
        super(NAME);
        sentProtocol = new Protocol();
        // ---------- Original Method ----------
        //sentProtocol = new Protocol();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.472 -0400", hash_original_method = "6B6D36FD3A79EE403682FF6F25A822A5", hash_generated_method = "A567D6BAF00F0EAA32E088FA411A40D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varBF864F33C9F93117F7F57C5BA4CB58C5_120667040 = (other==this);
        } //End collapsed parenthetic
        {
            ViaHeader o;
            o = (ViaHeader) other;
            boolean varC87927B8F9959A9F22D460E1EC42385E_142111715 = (getProtocol().equalsIgnoreCase( o.getProtocol() )
                && getTransport().equalsIgnoreCase( o.getTransport() )
                && getHost().equalsIgnoreCase( o.getHost() )
                && getPort() == o.getPort()
                && equalParameters( o ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other==this) return true;
        //if (other instanceof ViaHeader) {
            //final ViaHeader o = (ViaHeader) other;
            //return getProtocol().equalsIgnoreCase( o.getProtocol() )
                //&& getTransport().equalsIgnoreCase( o.getTransport() )
                //&& getHost().equalsIgnoreCase( o.getHost() )
                //&& getPort() == o.getPort()
                //&& equalParameters( o );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.472 -0400", hash_original_method = "F03A2761E3B9AF6DF371EC359829DB1F", hash_generated_method = "64E130308DD6EB1D72D714F19A95429A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProtocolVersion() {
        String var865794AF2475BA3F039B54C00B79DE1C_869876284 = (sentProtocol.getProtocolVersion());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //else
            //return sentProtocol.getProtocolVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.473 -0400", hash_original_method = "07C91BB13E357235D0646F9B1302A813", hash_generated_method = "636D36923AF78D047D3E1D38BC4CEBA9")
    @DSModeled(DSC.SAFE)
    public Protocol getSentProtocol() {
        return (Protocol)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sentProtocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.473 -0400", hash_original_method = "834E4BBD7298D05AE3719FD543779099", hash_generated_method = "12C782D342A0CB693E4E2B3AF03E3A4D")
    @DSModeled(DSC.SAFE)
    public HostPort getSentBy() {
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sentBy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.473 -0400", hash_original_method = "D671032CD8E13BB36667C287933AFA1D", hash_generated_method = "01588897A0AF059F723E95F92875D39E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Hop getHop() {
        HopImpl hop;
        hop = new HopImpl(sentBy.getHost().getHostname(),
                sentBy.getPort(),sentProtocol.getTransport());
        return (Hop)dsTaint.getTaint();
        // ---------- Original Method ----------
        //HopImpl hop = new HopImpl(sentBy.getHost().getHostname(),
                //sentBy.getPort(),sentProtocol.getTransport());
        //return hop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.473 -0400", hash_original_method = "50080B5B5AC1614DCB7B006B51F53E3F", hash_generated_method = "A2ED8D47EE86419588EFC10CA4F356DE")
    @DSModeled(DSC.SAFE)
    public NameValueList getViaParms() {
        return (NameValueList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.473 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E5CCC5133F55EB384CCE0D646E5A9DAF")
    @DSModeled(DSC.SAFE)
    public String getComment() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.473 -0400", hash_original_method = "60E8CE9FCECD3622E03D9910A9625801", hash_generated_method = "EC9D4A7F6B1AEE2169D7899B79813EAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasPort() {
        boolean varA9B995C4FEFE1CD5691B349CAE3F341B_2121841524 = ((getSentBy()).hasPort());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getSentBy()).hasPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.474 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "28EDF70094F4F88DC18410853BD0C212")
    @DSModeled(DSC.SAFE)
    public boolean hasComment() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return comment != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.474 -0400", hash_original_method = "944AB7146038DECB09A155E81BB22663", hash_generated_method = "79CD3AAB4B019027F3580A1A1672D020")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePort() {
        sentBy.removePort();
        // ---------- Original Method ----------
        //sentBy.removePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.474 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    @DSModeled(DSC.SAFE)
    public void removeComment() {
        comment = null;
        // ---------- Original Method ----------
        //comment = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.474 -0400", hash_original_method = "EAF98E914AE1C4A3745B20F70C227AC7", hash_generated_method = "40F9DF4D312CC576E7F6637D825DF9A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProtocolVersion(String protocolVersion) {
        dsTaint.addTaint(protocolVersion);
        sentProtocol = new Protocol();
        sentProtocol.setProtocolVersion(protocolVersion);
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setProtocolVersion(protocolVersion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.474 -0400", hash_original_method = "DC556AA065BEAF9D4C2B976D57E39DA8", hash_generated_method = "1FCB398EE4294A727EC11D1C56A966BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHost(Host host) {
        dsTaint.addTaint(host.dsTaint);
        {
            sentBy = new HostPort();
        } //End block
        sentBy.setHost(host);
        // ---------- Original Method ----------
        //if (sentBy == null) {
            //sentBy = new HostPort();
        //}
        //sentBy.setHost(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.474 -0400", hash_original_method = "F4FB101A445D5E49EE8B10DCE47E32FC", hash_generated_method = "2BE1D99ED082476863E948E01CDFC1B0")
    @DSModeled(DSC.SAFE)
    public void setSentProtocol(Protocol s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
        //sentProtocol = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.475 -0400", hash_original_method = "543B4EA18E4F8858630BB59B262697DA", hash_generated_method = "86C9A3E623609D01C3088EA18F1C70ED")
    @DSModeled(DSC.SAFE)
    public void setSentBy(HostPort s) {
        dsTaint.addTaint(s.dsTaint);
        // ---------- Original Method ----------
        //sentBy = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.475 -0400", hash_original_method = "DE8908B9CA5447E854A0D06D0B1B9195", hash_generated_method = "2EF3D603D879693C34DE2069E313D6D8")
    @DSModeled(DSC.SAFE)
    public void setComment(String c) {
        dsTaint.addTaint(c);
        // ---------- Original Method ----------
        //comment = c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.475 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "0F99913DACA86BCFA94E12C7A558A1DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_816593254 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.475 -0400", hash_original_method = "C937D3FA4F8C32F6B76B74CD5C9B4805", hash_generated_method = "C4A9A2880160627AF286E58859CB0EE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        sentProtocol.encode(buffer);
        buffer.append(SP);
        sentBy.encode(buffer);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2025170012 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        } //End block
        buffer.append(";rport");
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //sentProtocol.encode(buffer);
        //buffer.append(SP);
        //sentBy.encode(buffer);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //if (comment != null) {
            //buffer.append(SP).append(LPAREN).append(comment).append(RPAREN);
        //}
        //if (rPortFlag) buffer.append(";rport");
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.476 -0400", hash_original_method = "A6610C3C674AD8475435D641E21474E9", hash_generated_method = "CEE87D739A43968BDF319BE904C2D48D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHost(String host) throws ParseException {
        dsTaint.addTaint(host);
        sentBy = new HostPort();
        try 
        {
            Host h;
            h = new Host(host);
            sentBy.setHost(h);
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" host parameter is null");
        } //End block
        // ---------- Original Method ----------
        //if (sentBy == null)
            //sentBy = new HostPort();
        //try {
            //Host h = new Host(host);
            //sentBy.setHost(h);
        //} catch (Exception e) {
            //throw new NullPointerException(" host parameter is null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.476 -0400", hash_original_method = "C40590C8092ADD61F2FE2F813826D182", hash_generated_method = "18EDF04CB8EAAA913056ADFA55D9C5B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHost() {
        {
            Host host;
            host = sentBy.getHost();
            String varD39AFA8FB6E2E0442AB72741B07E75A5_1340455211 = (host.getHostname());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (sentBy == null)
            //return null;
        //else {
            //Host host = sentBy.getHost();
            //if (host == null)
                //return null;
            //else
                //return host.getHostname();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.476 -0400", hash_original_method = "3BFDF83597585B440A29B8E314A4320F", hash_generated_method = "2F9C9A448DBC6DB47600037C1FBE94BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPort(int port) throws InvalidArgumentException {
        dsTaint.addTaint(port);
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        } //End block
        sentBy = new HostPort();
        sentBy.setPort(port);
        // ---------- Original Method ----------
        //if ( port!=-1 && (port<1 || port>65535)) {
            //throw new InvalidArgumentException( "Port value out of range -1, [1..65535]" );
        //}
        //if (sentBy == null)
            //sentBy = new HostPort();
        //sentBy.setPort(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.476 -0400", hash_original_method = "524778E64DA2B969E2ED4D2BD7E92B55", hash_generated_method = "7B6A17B05EF5967791C55E81D8F72366")
    @DSModeled(DSC.SAFE)
    public void setRPort() {
        rPortFlag = true;
        // ---------- Original Method ----------
        //rPortFlag = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.476 -0400", hash_original_method = "E4A7E9B0C37CC00BF245A9AEF6038FD8", hash_generated_method = "D9619389A2D7C48A92C21E1590C30CFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int var1F971C6C371EAF98B044A213E0F08CE2_102513760 = (sentBy.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (sentBy == null)
            //return -1;
        //return sentBy.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.477 -0400", hash_original_method = "8F51D2BD996E5077EFE382EF5CCB28F7", hash_generated_method = "D54E4DCA496914D3ED91A654BB830095")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRPort() {
        String strRport;
        strRport = getParameter(ParameterNames.RPORT);
        {
            boolean var8E95033F2505B01B0D05C3D59477EE79_1070372142 = (strRport != null && ! strRport.equals(""));
            int varAEB3681EA4A53125B3833EAD829AB0EB_968398215 = (Integer.valueOf(strRport).intValue());
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //String strRport = getParameter(ParameterNames.RPORT);
        //if (strRport != null && ! strRport.equals(""))
            //return Integer.valueOf(strRport).intValue();
         //else
            //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.477 -0400", hash_original_method = "2C7D6CB162F307BBDEA3C529EA37600B", hash_generated_method = "E2CB41F101DC794153436C02DE6A8B23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTransport() {
        String var590162434A356032C98BBDB15C39D054_502316073 = (sentProtocol.getTransport());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //return sentProtocol.getTransport();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.477 -0400", hash_original_method = "DA10FBD3B27193627F0BF00A97E141AB", hash_generated_method = "358BF184313BFCA3679820AD4A183445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTransport(String transport) throws ParseException {
        dsTaint.addTaint(transport);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setTransport(), the transport parameter is null.");
        sentProtocol = new Protocol();
        sentProtocol.setTransport(transport);
        // ---------- Original Method ----------
        //if (transport == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setTransport(), the transport parameter is null.");
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setTransport(transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.477 -0400", hash_original_method = "076253ECD4074E0CF94E6CAE84ACD031", hash_generated_method = "E624B36637E56034ED63BAA61C194891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProtocol() {
        String var04B43CCA8F2DA2E60F996B9ECA0F5C23_1131816060 = (sentProtocol.getProtocol());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (sentProtocol == null)
            //return null;
        //return sentProtocol.getProtocol();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.477 -0400", hash_original_method = "983A1DB4807CBA4F5F74F526664C05F9", hash_generated_method = "B4118AB9D0D7EFA1EF25ACC632AE6560")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProtocol(String protocol) throws ParseException {
        dsTaint.addTaint(protocol);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setProtocol(), the protocol parameter is null.");
        sentProtocol = new Protocol();
        sentProtocol.setProtocol(protocol);
        // ---------- Original Method ----------
        //if (protocol == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setProtocol(), the protocol parameter is null.");
        //if (sentProtocol == null)
            //sentProtocol = new Protocol();
        //sentProtocol.setProtocol(protocol);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.478 -0400", hash_original_method = "AB2BF7863E6929FA549276BF1FCB8F41", hash_generated_method = "6ACE5DCC6951381947A84D73D79FB171")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getTTL() {
        int ttl;
        ttl = getParameterAsInt(ParameterNames.TTL);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int ttl = getParameterAsInt(ParameterNames.TTL);
        //return ttl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.478 -0400", hash_original_method = "275C0FDDD82C74D9D06FF2EBDF31F802", hash_generated_method = "E4E71E05DC5A14E37698BA09FE740B72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTTL(int ttl) throws InvalidArgumentException {
        dsTaint.addTaint(ttl);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", Via, setTTL(), the ttl parameter is < 0");
        setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
        // ---------- Original Method ----------
        //if (ttl < 0 && ttl != -1)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", Via, setTTL(), the ttl parameter is < 0");
        //setParameter(new NameValue(ParameterNames.TTL, Integer.valueOf(ttl)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.478 -0400", hash_original_method = "BA8497BF19C86E6498457C19F33C2BB1", hash_generated_method = "A3D224D7A9BD4DAC3F0E1C076F79F6DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMAddr() {
        String var8508806470D45E3AD5DF58C27E73E7C4_1351653085 = (getParameter(ParameterNames.MADDR));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.MADDR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.478 -0400", hash_original_method = "6AB0C98EE8B2466C821195A9A73846A0", hash_generated_method = "4639E3A78623C18587C976983EB839C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMAddr(String mAddr) throws ParseException {
        dsTaint.addTaint(mAddr);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setMAddr(), the mAddr parameter is null.");
        Host host;
        host = new Host();
        host.setAddress(mAddr);
        NameValue nameValue;
        nameValue = new NameValue(ParameterNames.MADDR, host);
        setParameter(nameValue);
        // ---------- Original Method ----------
        //if (mAddr == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setMAddr(), the mAddr parameter is null.");
        //Host host = new Host();
        //host.setAddress(mAddr);
        //NameValue nameValue = new NameValue(ParameterNames.MADDR, host);
        //setParameter(nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.478 -0400", hash_original_method = "25AF7C33721E5D780684174C5845DEAD", hash_generated_method = "FBE3771A09FEB2FD880FD595602EF42E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getReceived() {
        String var47AE1061F155ED15F0EEC8F95D473111_1223607447 = (getParameter(ParameterNames.RECEIVED));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.RECEIVED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.479 -0400", hash_original_method = "F727BD69B2536BBCBA80253D70F95056", hash_generated_method = "F730BF30E9B018F8A74DF13F301B802D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReceived(String received) throws ParseException {
        dsTaint.addTaint(received);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setReceived(), the received parameter is null.");
        setParameter(ParameterNames.RECEIVED, received);
        // ---------- Original Method ----------
        //if (received == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setReceived(), the received parameter is null.");
        //setParameter(ParameterNames.RECEIVED, received);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.479 -0400", hash_original_method = "9A958EF7B290CF5A27A4EB96F15158F0", hash_generated_method = "352B366F8937A35BD71DCA73D841AA7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getBranch() {
        String var6CE8F391224112A1649BD6E05E9328E3_637994543 = (getParameter(ParameterNames.BRANCH));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.BRANCH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.479 -0400", hash_original_method = "5A56F4FACEB17A95A8FCAD93BB83EA63", hash_generated_method = "4AA6C88F0FDC07E22DA6AC948166C597")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBranch(String branch) throws ParseException {
        dsTaint.addTaint(branch);
        {
            boolean var4C46677D9B30E6CB7B7BB28849DA9864_1586077929 = (branch == null || branch.length()==0);
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, "
                    + "Via, setBranch(), the branch parameter is null or length 0.");
        } //End collapsed parenthetic
        setParameter(ParameterNames.BRANCH, branch);
        // ---------- Original Method ----------
        //if (branch == null || branch.length()==0)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, "
                    //+ "Via, setBranch(), the branch parameter is null or length 0.");
        //setParameter(ParameterNames.BRANCH, branch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.479 -0400", hash_original_method = "252C53006150044E4EBAAC8A002E65B1", hash_generated_method = "C0251A56BD94D36F939D882EB072397E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Via retval;
        retval = (Via) super.clone();
        retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        retval.sentBy = (HostPort) this.sentBy.clone();
        {
            boolean var0F30CA1BAF298E42629D8419B9FFBC30_1591202444 = (this.getRPort() != -1);
            retval.setParameter(RPORT,this.getRPort());
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Via retval = (Via) super.clone();
        //if (this.sentProtocol != null)
            //retval.sentProtocol = (Protocol) this.sentProtocol.clone();
        //if (this.sentBy != null)
            //retval.sentBy = (HostPort) this.sentBy.clone();
        //if ( this.getRPort() != -1)
            //retval.setParameter(RPORT,this.getRPort());
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.479 -0400", hash_original_method = "5347FDDA2C7AAC95D7D1D2F666800B71", hash_generated_method = "7F29807AD9786D30B8CA9AFE2768F03B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSentByField() {
        String varB51E299CB38F25D4A24869EF300C6BE1_1061307175 = (sentBy.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if(sentBy != null)
            //return sentBy.encode();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.480 -0400", hash_original_method = "128FFEF5D307451BA5388B5193A6BF26", hash_generated_method = "16EF8934B1CEA8500AF108C47C58EE67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSentProtocolField() {
        String varFDFFF46B94BD1C5692C466D2DD182DC6_730554882 = (sentProtocol.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if(sentProtocol != null)
            //return sentProtocol.encode();
        //return null;
    }

    
    private static final long serialVersionUID = 5281728373401351378L;
    public static final String BRANCH = ParameterNames.BRANCH;
    public static final String RECEIVED = ParameterNames.RECEIVED;
    public static final String MADDR = ParameterNames.MADDR;
    public static final String TTL = ParameterNames.TTL;
    public static final String RPORT = ParameterNames.RPORT;
}

