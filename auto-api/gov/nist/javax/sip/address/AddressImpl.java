package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;
import javax.sip.address.*;

public final class AddressImpl extends NetObject implements javax.sip.address.Address {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.164 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.164 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "1A7036061B9FC3789F96C7F5C73AF8A8")

    protected String displayName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.164 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "F84007EB7463857C9E0240DCE9E79680")

    protected GenericURI address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.165 -0400", hash_original_method = "19BCE3FEC6F8BEE2FAC9ED705C20C9DE", hash_generated_method = "15E1C9067611157B0772065A0F22AF77")
    public  AddressImpl() {
        this.addressType = NAME_ADDR;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.165 -0400", hash_original_method = "22D6B687019E482F52E54287A969D6A5", hash_generated_method = "756B61C81C70FB93F63437601287C523")
    public boolean match(Object other) {
        {
            AddressImpl that = (AddressImpl) other;
            {
                boolean var702C910B5325E5C2A5847E8F6A867289_520146230 = (that.getMatcher() != null);
                boolean varCBA521E4644E20B802AFE04533C02C53_1882600743 = (that.getMatcher().match(this.encode()));
                boolean var60CA5F2E78075997A880589878115E51_279396846 = (address.match(that.address));
                boolean varCACD682A5D1E34F205E5DFC71C0D0D91_575197441 = (displayName.equalsIgnoreCase(that.displayName)
                    && address.match(that.address));
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_754706276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_754706276;
        
        
            
        
            
        
            
            
                
            
                
            
                
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.166 -0400", hash_original_method = "A988603BA6459B5E85F0C286224314DC", hash_generated_method = "D97C9DD704D09E1802DA23E3D631D76B")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1652352785 = null; 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        varB4EAC82CA7396A68D541C85D26508E83_1652352785 = uri.getHostPort();
        varB4EAC82CA7396A68D541C85D26508E83_1652352785.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1652352785;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.166 -0400", hash_original_method = "D8DDF6A069BBACCEBB239C4EC58E5A27", hash_generated_method = "FE4C96222DB994DA3E60C77845C149CD")
    public int getPort() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        int var29430954332FCA6688F9B47637AA218C_73535361 = (uri.getHostPort().getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40530690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_40530690;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.167 -0400", hash_original_method = "172515F4F60E1E2B63F4DF9418CB15A7", hash_generated_method = "7ADB07341E6202ECE720B0BAFA484D80")
    public String getUserAtHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_1065785058 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1427224535 = null; 
        {
            SipUri uri = (SipUri) address;
            varB4EAC82CA7396A68D541C85D26508E83_1065785058 = uri.getUserAtHostPort();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1427224535 = address.toString();
        String varA7E53CE21691AB073D9660D615818899_599399552; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_599399552 = varB4EAC82CA7396A68D541C85D26508E83_1065785058;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_599399552 = varB4EAC82CA7396A68D541C85D26508E83_1427224535;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_599399552.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_599399552;
        
        
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.168 -0400", hash_original_method = "C2899C61B0488A683F191A3E8A7E482B", hash_generated_method = "D9AE27F7898D0F516F5F7C34328250E3")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1577046735 = null; 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        varB4EAC82CA7396A68D541C85D26508E83_1577046735 = uri.getHostPort().getHost().getHostname();
        varB4EAC82CA7396A68D541C85D26508E83_1577046735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1577046735;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.169 -0400", hash_original_method = "0E39EDEFDBAD265D57AEBE040714053D", hash_generated_method = "661D6DAC2E27E16396D14ABA5C1BF10C")
    public void removeParameter(String parameterName) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        uri.removeParameter(parameterName);
        addTaint(parameterName.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.171 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "C8776556AE33E8F7F05B2683BECBB4A1")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1317387607 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1317387607 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1317387607.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1317387607;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.172 -0400", hash_original_method = "F68604FD786D42AC18C162475B2762A0", hash_generated_method = "01FB100C7F375ABB8F45438DAC4167BD")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_268076212 = null; 
        {
            buffer.append('*');
        } 
        {
            {
                buffer.append(DOUBLE_QUOTE)
                        .append(displayName)
                        .append(DOUBLE_QUOTE)
                        .append(SP);
            } 
            {
                buffer.append(LESS_THAN);
                address.encode(buffer);
                buffer.append(GREATER_THAN);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_268076212 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_268076212.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_268076212;
        
        
            
        
        
            
                
                        
                        
                        
            
            
                
                    
                
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.173 -0400", hash_original_method = "93137A429171577005AC852AA3CBD92B", hash_generated_method = "A44FC3660D4E209A4E35DC19A50AAFD3")
    public int getAddressType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215300267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215300267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.173 -0400", hash_original_method = "9F1FE4476648947E875579C9BD408A94", hash_generated_method = "9C4A3E70947FB3FDA091FB999E129026")
    public void setAddressType(int atype) {
        addressType = atype;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.174 -0400", hash_original_method = "050EB531E383683E34CFFBB41EC12665", hash_generated_method = "CB2C8D114E99EB672520005A06950FD4")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_117155212 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_117155212 = displayName;
        varB4EAC82CA7396A68D541C85D26508E83_117155212.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_117155212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.174 -0400", hash_original_method = "20237627212B7A29DEC009BA073F5A0F", hash_generated_method = "22F780AE0AAD394C441B1705A60742F1")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.addressType = NAME_ADDR;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.174 -0400", hash_original_method = "EB99F908657CD76194DE95632B999EA3", hash_generated_method = "5BB3C8C1253F38C0663C21B0AFC0573D")
    public void setAddess(javax.sip.address.URI address) {
        this.address = (GenericURI) address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.175 -0400", hash_original_method = "3B6DAA204E499460163C13A0179862F4", hash_generated_method = "F322C07ACBD97E6FA4258DB590CF2265")
    public int hashCode() {
        int var061A8066721511703856EB3A8F80EC74_869513497 = (this.address.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108570576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_108570576;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.175 -0400", hash_original_method = "2FE036AE685D31E73E4BA8A8E1238828", hash_generated_method = "7F05BD51B65641333A0503074473FA7C")
    public boolean equals(Object other) {
        {
            final Address o = (Address) other;
            boolean var34AFE256CC6216D17FE120A6537E01FB_258372592 = (this.getURI().equals( o.getURI() ));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196625296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_196625296;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.175 -0400", hash_original_method = "B0F53EB98996816F5E75DFC90AF9D2B6", hash_generated_method = "86BD0B6DEB4300E57B84C635345130FC")
    public boolean hasDisplayName() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985594755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985594755;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.175 -0400", hash_original_method = "1C9F40C92EDF6ED97BB2D87B31D06D96", hash_generated_method = "5CD955E1E7F6119F595EEFAF2698F225")
    public void removeDisplayName() {
        displayName = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.176 -0400", hash_original_method = "DEDDE1E197FB1DB769CF6C0A06F1A55D", hash_generated_method = "542F8D629390932E6A8BA185F235D866")
    public boolean isSIPAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844373987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844373987;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.176 -0400", hash_original_method = "1CCD793210D749E7DAD6ED996CE553FC", hash_generated_method = "00C7135BD92FD0101EE20B7F8598A213")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1124937113 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1124937113 = this.address;
        varB4EAC82CA7396A68D541C85D26508E83_1124937113.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1124937113;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.177 -0400", hash_original_method = "6DCA089E698119AE5E5CAA45D8347BA0", hash_generated_method = "239789603FD327C51072A2AB53770919")
    public boolean isWildcard() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1175799711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1175799711;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.177 -0400", hash_original_method = "EE5571D54561E1127EBAFF3098CB1511", hash_generated_method = "07B1C81B131244B8D0886DCB048597CC")
    public void setURI(URI address) {
        this.address = (GenericURI) address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.178 -0400", hash_original_method = "0E80639575489DB45C2F9AFF28620E23", hash_generated_method = "1C2FA3B94EDDE018E1E554932AD46F77")
    public void setUser(String user) {
        ((SipUri) this.address).setUser(user);
        addTaint(user.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.178 -0400", hash_original_method = "4CDCC5D804344627E65CF6AE2B92722E", hash_generated_method = "67822606963D210D20A964DD86A6F039")
    public void setWildCardFlag() {
        this.addressType = WILD_CARD;
        this.address = new SipUri();
        ((SipUri)this.address).setUser("*");
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.179 -0400", hash_original_method = "0B091F8828B1420FFE66EE8D50F59446", hash_generated_method = "E4E7CF72AC4D51C5E88E88AF8D69D65E")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_357364891 = null; 
        AddressImpl retval = (AddressImpl) super.clone();
        retval.address = (GenericURI) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_357364891 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_357364891.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_357364891;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.179 -0400", hash_original_field = "B507F603877B2D8A3AA8AA4419600CFE", hash_generated_field = "2326BD2A1EC89625540C772C74ACDC21")

    private static final long serialVersionUID = 429592779568617259L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.179 -0400", hash_original_field = "BE8003BF2E9AA0082803EE27135CDC7C", hash_generated_field = "222B3DF6AA7EC58590F0AE49E8EC6A9D")

    public static final int NAME_ADDR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.179 -0400", hash_original_field = "C1E542609A4B1773F293F63B2222A709", hash_generated_field = "2E93044CF8C5AA42D1F0A2CA07805A14")

    public static final int ADDRESS_SPEC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.179 -0400", hash_original_field = "EF31971D96CF2A18B45B5D6CAA869866", hash_generated_field = "AA1965AB7CEEE0F896A9EFD409064D60")

    public static final int WILD_CARD = 3;
}

