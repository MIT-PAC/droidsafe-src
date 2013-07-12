package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.HostPort;
import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.parser.Parser;
import javax.sip.header.ToHeader;
import java.text.ParseException;

public final class To extends AddressParametersHeader implements javax.sip.header.ToHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.536 -0400", hash_original_method = "7CFB3ABB21EF244A9FD6E54AD9CC5173", hash_generated_method = "668C3C4C9F8E59AA7D7644F10E61864F")
    public  To() {
        super(TO,true);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.537 -0400", hash_original_method = "10EA715D50A25194DE35700E69984D3D", hash_generated_method = "097D153EC4F5E824438C8E5A2BDE56D1")
    public  To(From from) {
        super(TO);
        addTaint(from.getTaint());
        setAddress(from.address);
        setParameters(from.parameters);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.538 -0400", hash_original_method = "DA29AB595B7A4A125EF99100FA337502", hash_generated_method = "72D71AB85FD4D5E61964376819EFA29F")
    public String encode() {
String var4D54AC96FDD6E716CB6C2C0211520077_1233845804 =         headerName + COLON + SP + encodeBody() + NEWLINE;
        var4D54AC96FDD6E716CB6C2C0211520077_1233845804.addTaint(taint);
        return var4D54AC96FDD6E716CB6C2C0211520077_1233845804;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.538 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "4A9F96C2B4742F1C3BD013E3FA4616D1")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_983549983 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_983549983.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_983549983;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.539 -0400", hash_original_method = "6379DF107AEAFFCF06677344FE0DDDB5", hash_generated_method = "8F8BD28F212F4C9149A2036B82BC3EF9")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(address != null)        
        {
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)            
            {
                buffer.append(LESS_THAN);
            } 
            address.encode(buffer);
    if(address.getAddressType() == AddressImpl.ADDRESS_SPEC)            
            {
                buffer.append(GREATER_THAN);
            } 
    if(!parameters.isEmpty())            
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } 
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_330389839 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_330389839.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_330389839;
        
        
            
                
            
            
            
                
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.539 -0400", hash_original_method = "465066D205BCB0CD35C4F9A4E5087389", hash_generated_method = "B17419CF857CF0BE9BD31045D61AE470")
    public HostPort getHostPort() {
    if(address == null)        
        {
HostPort var540C13E9E156B687226421B24F2DF178_841055959 =         null;
        var540C13E9E156B687226421B24F2DF178_841055959.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_841055959;
        }
HostPort var7605DBE171E4A11D1CF5181991039C28_1761886524 =         address.getHostPort();
        var7605DBE171E4A11D1CF5181991039C28_1761886524.addTaint(taint);
        return var7605DBE171E4A11D1CF5181991039C28_1761886524;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.540 -0400", hash_original_method = "3C83E52D0C85786FBC54CBD0510A4886", hash_generated_method = "0EA96FF0DAB12827ADDDA25F491F2267")
    public String getDisplayName() {
    if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1119596689 =         null;
        var540C13E9E156B687226421B24F2DF178_1119596689.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1119596689;
        }
String var2D47464FECA9E570B1B7C27512E620BD_186024133 =         address.getDisplayName();
        var2D47464FECA9E570B1B7C27512E620BD_186024133.addTaint(taint);
        return var2D47464FECA9E570B1B7C27512E620BD_186024133;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.540 -0400", hash_original_method = "2057D1C8F1E8BB8C55512212A4FDB01D", hash_generated_method = "862D18B8A0C543569C67CA7C46D0B37B")
    public String getTag() {
    if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1823418320 =         null;
        var540C13E9E156B687226421B24F2DF178_1823418320.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1823418320;
        }
String var6121204752E92B3AB21D35C13718F121_1951960572 =         getParameter(ParameterNames.TAG);
        var6121204752E92B3AB21D35C13718F121_1951960572.addTaint(taint);
        return var6121204752E92B3AB21D35C13718F121_1951960572;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.540 -0400", hash_original_method = "DE9D34178B7493C9CBB9357375B774A4", hash_generated_method = "834D3E1019168665207583424149C850")
    public boolean hasTag() {
    if(parameters == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_813041966 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960999854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960999854;
        }
        boolean varE794A2B1FC5BFB81AE860CE890E72CBA_1244817585 = (hasParameter(ParameterNames.TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687886159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_687886159;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.541 -0400", hash_original_method = "EECFB5B736A479D5AC464F374A1DB439", hash_generated_method = "34DB9DEB5FA7C5BF446D3F26EC55750D")
    public void removeTag() {
    if(parameters != null)        
        parameters.delete(ParameterNames.TAG);
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.541 -0400", hash_original_method = "8317B37B8D85C50DB928305D5320BE87", hash_generated_method = "06CB76253846346CADBED3445825C24C")
    public void setTag(String t) throws ParseException {
        addTaint(t.getTaint());
        Parser.checkToken(t);
        this.setParameter(ParameterNames.TAG, t);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.541 -0400", hash_original_method = "ED5A65C9FFE9E87462C7980633990418", hash_generated_method = "FEE3C3EFFFA5FC86FF13C48734708452")
    public String getUserAtHostPort() {
    if(address == null)        
        {
String var540C13E9E156B687226421B24F2DF178_982740097 =         null;
        var540C13E9E156B687226421B24F2DF178_982740097.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_982740097;
        }
String var02793A4C7C5CEDDB6ECEC98A612C742B_355580104 =         address.getUserAtHostPort();
        var02793A4C7C5CEDDB6ECEC98A612C742B_355580104.addTaint(taint);
        return var02793A4C7C5CEDDB6ECEC98A612C742B_355580104;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.542 -0400", hash_original_method = "A8E3E290BA3A80BEE74A86D8FFE8EF4A", hash_generated_method = "43904BD773F33F07DD6BB975EF57B83D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var466CB7345EDBAF7000AE9A5D38C08D1A_724276453 = ((other instanceof ToHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995140746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_995140746;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.542 -0400", hash_original_field = "BD489DAD9E109F634ADCC2F1AC7467AA", hash_generated_field = "4A9712AFAA43552733CBA4D2014F2688")

    private static final long serialVersionUID = -4057413800584586316L;
}

