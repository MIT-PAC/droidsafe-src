package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;

import java.text.ParseException;

import javax.sip.header.ToHeader;






public final class To extends AddressParametersHeader implements javax.sip.header.ToHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.618 -0400", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "668C3C4C9F8E59AA7D7644F10E61864F")
    public  To() {
        super(TO,true);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.619 -0400", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "097D153EC4F5E824438C8E5A2BDE56D1")
    public  To(From from) {
        super(TO);
        addTaint(from.getTaint());
        setAddress(from.address);
        setParameters(from.parameters);
        // ---------- Original Method ----------
        //setAddress(from.address);
        //setParameters(from.parameters);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.619 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "B3D01F7F4CB8748879ABA45B0C7C460F")
    public String encode() {
String var4D54AC96FDD6E716CB6C2C0211520077_789930009 =         headerName + COLON + SP + encodeBody() + NEWLINE;
        var4D54AC96FDD6E716CB6C2C0211520077_789930009.addTaint(taint);
        return var4D54AC96FDD6E716CB6C2C0211520077_789930009;
        // ---------- Original Method ----------
        //return headerName + COLON + SP + encodeBody() + NEWLINE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.619 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "4780047C08B0D8547E802C5B08FAAFE5")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1925935255 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1925935255.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1925935255;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.620 -0400", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "E8E5B35A8915DEDEE6C9073AB3FF6D3A")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(address != null)        
        {
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
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_786361709 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_786361709.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_786361709;
        // ---------- Original Method ----------
        //if (address != null) {
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
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.620 -0400", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "CE28CBF0EC78B3E233FD11CE2B5B8C7D")
    public HostPort getHostPort() {
        if(address == null)        
        {
HostPort var540C13E9E156B687226421B24F2DF178_1984682306 =         null;
        var540C13E9E156B687226421B24F2DF178_1984682306.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1984682306;
        }
HostPort var7605DBE171E4A11D1CF5181991039C28_1517399552 =         address.getHostPort();
        var7605DBE171E4A11D1CF5181991039C28_1517399552.addTaint(taint);
        return var7605DBE171E4A11D1CF5181991039C28_1517399552;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getHostPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.621 -0400", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "D123FCCDD91BCBC7B94072043B417CED")
    public String getDisplayName() {
        if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1103362056 =         null;
        var540C13E9E156B687226421B24F2DF178_1103362056.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1103362056;
        }
String var2D47464FECA9E570B1B7C27512E620BD_1301541366 =         address.getDisplayName();
        var2D47464FECA9E570B1B7C27512E620BD_1301541366.addTaint(taint);
        return var2D47464FECA9E570B1B7C27512E620BD_1301541366;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getDisplayName();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.621 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "F4BF20FC1F7137C3743896591A477C7D")
    public String getTag() {
        if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_168414969 =         null;
        var540C13E9E156B687226421B24F2DF178_168414969.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_168414969;
        }
String var6121204752E92B3AB21D35C13718F121_323564432 =         getParameter(ParameterNames.TAG);
        var6121204752E92B3AB21D35C13718F121_323564432.addTaint(taint);
        return var6121204752E92B3AB21D35C13718F121_323564432;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.621 -0400", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "080D7D698E478AAE313961F16D7DE087")
    public boolean hasTag() {
        if(parameters == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2117863331 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143354803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143354803;
        }
        boolean varE794A2B1FC5BFB81AE860CE890E72CBA_553880528 = (hasParameter(ParameterNames.TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366749909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366749909;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return false;
        //return hasParameter(ParameterNames.TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.622 -0400", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "34DB9DEB5FA7C5BF446D3F26EC55750D")
    public void removeTag() {
        if(parameters != null)        
        parameters.delete(ParameterNames.TAG);
        // ---------- Original Method ----------
        //if (parameters != null)
                //parameters.delete(ParameterNames.TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.622 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "06CB76253846346CADBED3445825C24C")
    public void setTag(String t) throws ParseException {
        addTaint(t.getTaint());
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        // ---------- Original Method ----------
        //Parser.checkToken(t);
        //this.setParameter(ParameterNames.TAG, t);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.622 -0400", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "B8925C17A57D2AEBB12E0D9521201DE7")
    public String getUserAtHostPort() {
        if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1260786371 =         null;
        var540C13E9E156B687226421B24F2DF178_1260786371.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1260786371;
        }
String var02793A4C7C5CEDDB6ECEC98A612C742B_933457172 =         address.getUserAtHostPort();
        var02793A4C7C5CEDDB6ECEC98A612C742B_933457172.addTaint(taint);
        return var02793A4C7C5CEDDB6ECEC98A612C742B_933457172;
        // ---------- Original Method ----------
        //if (address == null)
            //return null;
        //return address.getUserAtHostPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.623 -0400", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "739F9C291246DEC92DA2A8526F7BDE2E")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var466CB7345EDBAF7000AE9A5D38C08D1A_757215527 = ((other instanceof ToHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996688987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996688987;
        // ---------- Original Method ----------
        //return (other instanceof ToHeader) && super.equals(other);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.623 -0400", hash_original_field = "BD489DAD9E109F634ADCC2F1AC7467AA", hash_generated_field = "4A9712AFAA43552733CBA4D2014F2688")

    private static final long serialVersionUID = -4057413800584586316L;
}

