package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import javax.sip.address.*;

public final class AddressImpl extends NetObject implements javax.sip.address.Address {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.000 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.000 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "1A7036061B9FC3789F96C7F5C73AF8A8")

    protected String displayName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.000 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "F84007EB7463857C9E0240DCE9E79680")

    protected GenericURI address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.001 -0400", hash_original_method = "19BCE3FEC6F8BEE2FAC9ED705C20C9DE", hash_generated_method = "15E1C9067611157B0772065A0F22AF77")
    public  AddressImpl() {
        this.addressType = NAME_ADDR;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.001 -0400", hash_original_method = "22D6B687019E482F52E54287A969D6A5", hash_generated_method = "EC30517ECA79EAB4182B69519A969C89")
    public boolean match(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2062784523 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928492668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928492668;
        }
    if(!(other instanceof Address))        
        {
        boolean var68934A3E9455FA72420237EB05902327_501524644 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068756080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068756080;
        }
        else
        {
            AddressImpl that = (AddressImpl) other;
    if(that.getMatcher() != null)            
            {
            boolean varCE18E34142C4D51F18C724B249AF59E1_1151908289 = (that.getMatcher().match(this.encode()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008057145 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008057145;
            }
            else
    if(that.displayName != null && this.displayName == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_259694028 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529180028 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_529180028;
            }
            else
    if(that.displayName == null)            
            {
            boolean varA0B4D523C3AEDD6CAD8E5860A994817E_2066054145 = (address.match(that.address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813008044 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813008044;
            }
            else
            {
            boolean var8F3C90541EF71E92205AA8404AF332A4_271788432 = (displayName.equalsIgnoreCase(that.displayName)
                    && address.match(that.address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490086668 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490086668;
            }
        } 
        
        
            
        
            
        
            
            
                
            
                
            
                
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.002 -0400", hash_original_method = "A988603BA6459B5E85F0C286224314DC", hash_generated_method = "ECDE1742B0C2511B1BAC8F00A9172450")
    public HostPort getHostPort() {
    if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_1958754778 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_1958754778.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_1958754778;
        }
        SipUri uri = (SipUri) address;
HostPort varE7993041D19004E68232C123B2777A75_151078611 =         uri.getHostPort();
        varE7993041D19004E68232C123B2777A75_151078611.addTaint(taint);
        return varE7993041D19004E68232C123B2777A75_151078611;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.002 -0400", hash_original_method = "D8DDF6A069BBACCEBB239C4EC58E5A27", hash_generated_method = "336615575E6ABD9587F43CE697261EDF")
    public int getPort() {
    if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_570529768 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_570529768.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_570529768;
        }
        SipUri uri = (SipUri) address;
        int varD85BD639CCE29AFAD3562F9520C9363C_515725373 = (uri.getHostPort().getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359935994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359935994;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.003 -0400", hash_original_method = "172515F4F60E1E2B63F4DF9418CB15A7", hash_generated_method = "223E968D85C4E6CC43613E7FFA14F48B")
    public String getUserAtHostPort() {
    if(address instanceof SipUri)        
        {
            SipUri uri = (SipUri) address;
String var9543FAD4B7973B3269B2FDA49D7BEB32_1330653674 =             uri.getUserAtHostPort();
            var9543FAD4B7973B3269B2FDA49D7BEB32_1330653674.addTaint(taint);
            return var9543FAD4B7973B3269B2FDA49D7BEB32_1330653674;
        } 
        else
        {
String varF5977316C55FA2EB17D2CA1600D45F48_707698059 =         address.toString();
        varF5977316C55FA2EB17D2CA1600D45F48_707698059.addTaint(taint);
        return varF5977316C55FA2EB17D2CA1600D45F48_707698059;
        }
        
        
            
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.003 -0400", hash_original_method = "C2899C61B0488A683F191A3E8A7E482B", hash_generated_method = "41BCE078470D4CB15FC3FCC29A569269")
    public String getHost() {
    if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_1399946850 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_1399946850.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_1399946850;
        }
        SipUri uri = (SipUri) address;
String varAA7210FD5162D7F477B57C943C6F39E5_1068219885 =         uri.getHostPort().getHost().getHostname();
        varAA7210FD5162D7F477B57C943C6F39E5_1068219885.addTaint(taint);
        return varAA7210FD5162D7F477B57C943C6F39E5_1068219885;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.004 -0400", hash_original_method = "0E39EDEFDBAD265D57AEBE040714053D", hash_generated_method = "94F805235E7A50749F9189E13D8D82E3")
    public void removeParameter(String parameterName) {
        addTaint(parameterName.getTaint());
    if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_1358746297 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_1358746297.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_1358746297;
        }
        SipUri uri = (SipUri) address;
        uri.removeParameter(parameterName);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.004 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "E8584707C847535D868153920E098490")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_37456173 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_37456173.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_37456173;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.005 -0400", hash_original_method = "F68604FD786D42AC18C162475B2762A0", hash_generated_method = "FAD3F24013080D429A8777DC57CEC295")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(this.addressType == WILD_CARD)        
        {
            buffer.append('*');
        } 
        else
        {
    if(displayName != null)            
            {
                buffer.append(DOUBLE_QUOTE)
                        .append(displayName)
                        .append(DOUBLE_QUOTE)
                        .append(SP);
            } 
    if(address != null)            
            {
    if(addressType == NAME_ADDR || displayName != null)                
                buffer.append(LESS_THAN);
                address.encode(buffer);
    if(addressType == NAME_ADDR || displayName != null)                
                buffer.append(GREATER_THAN);
            } 
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1362354669 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1362354669.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1362354669;
        
        
            
        
        
            
                
                        
                        
                        
            
            
                
                    
                
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.005 -0400", hash_original_method = "93137A429171577005AC852AA3CBD92B", hash_generated_method = "3DC3237FE22AFE349EF07322A4C538D6")
    public int getAddressType() {
        int var40179AAEEFAA5FF10EF85408F632A065_1509052110 = (addressType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329641208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329641208;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.006 -0400", hash_original_method = "9F1FE4476648947E875579C9BD408A94", hash_generated_method = "9C4A3E70947FB3FDA091FB999E129026")
    public void setAddressType(int atype) {
        addressType = atype;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.006 -0400", hash_original_method = "050EB531E383683E34CFFBB41EC12665", hash_generated_method = "2BA0645CFB7E67EE4FD953A94FE62D1A")
    public String getDisplayName() {
String var850CACFC55D2C2C5428453BF9853A088_159722761 =         displayName;
        var850CACFC55D2C2C5428453BF9853A088_159722761.addTaint(taint);
        return var850CACFC55D2C2C5428453BF9853A088_159722761;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.007 -0400", hash_original_method = "20237627212B7A29DEC009BA073F5A0F", hash_generated_method = "22F780AE0AAD394C441B1705A60742F1")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.addressType = NAME_ADDR;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.007 -0400", hash_original_method = "EB99F908657CD76194DE95632B999EA3", hash_generated_method = "5BB3C8C1253F38C0663C21B0AFC0573D")
    public void setAddess(javax.sip.address.URI address) {
        this.address = (GenericURI) address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.007 -0400", hash_original_method = "3B6DAA204E499460163C13A0179862F4", hash_generated_method = "9D3ABAB4E1374AFB6F7C241CFEE0D72F")
    public int hashCode() {
        int var9DFEDBBDB6902A3ACDAAD70F54E7EEC7_792268197 = (this.address.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431729246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431729246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.008 -0400", hash_original_method = "2FE036AE685D31E73E4BA8A8E1238828", hash_generated_method = "0E1908CD59F12AB5640ABE4F15A85A94")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1788776697 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938247106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_938247106;
        }
    if(other instanceof Address)        
        {
            final Address o = (Address) other;
            boolean var20A154666F5F31869936F16233D7830C_1093897700 = (this.getURI().equals( o.getURI() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183527427 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183527427;
        } 
        boolean var68934A3E9455FA72420237EB05902327_295325938 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689233915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689233915;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.008 -0400", hash_original_method = "B0F53EB98996816F5E75DFC90AF9D2B6", hash_generated_method = "70CF35F04A1D837858F2B4CD881C857A")
    public boolean hasDisplayName() {
        boolean varB14AA91EBB45365E021220596C75B0E1_145967617 = ((displayName != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149753090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149753090;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.008 -0400", hash_original_method = "1C9F40C92EDF6ED97BB2D87B31D06D96", hash_generated_method = "5CD955E1E7F6119F595EEFAF2698F225")
    public void removeDisplayName() {
        displayName = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.009 -0400", hash_original_method = "DEDDE1E197FB1DB769CF6C0A06F1A55D", hash_generated_method = "C6B3CE642B21FA6A69760E036AAE0C96")
    public boolean isSIPAddress() {
        boolean var8C849DBBC993A1F97EB64E15DEE9DC3E_1058275885 = (address instanceof SipUri);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_329756657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_329756657;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.009 -0400", hash_original_method = "1CCD793210D749E7DAD6ED996CE553FC", hash_generated_method = "AF21BD6F1F932EAB7F6528E3BB162E83")
    public URI getURI() {
URI varE9D6173C4BDEF381CE1BBEB54B394E2F_513288899 =         this.address;
        varE9D6173C4BDEF381CE1BBEB54B394E2F_513288899.addTaint(taint);
        return varE9D6173C4BDEF381CE1BBEB54B394E2F_513288899;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.009 -0400", hash_original_method = "6DCA089E698119AE5E5CAA45D8347BA0", hash_generated_method = "AB0B5A754EAD91D555CDDD8B6E3CAAEB")
    public boolean isWildcard() {
        boolean var0584F1C2B3CDB2E6545FF2AC474D1B32_292311479 = (this.addressType == WILD_CARD);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529639152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529639152;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.009 -0400", hash_original_method = "EE5571D54561E1127EBAFF3098CB1511", hash_generated_method = "07B1C81B131244B8D0886DCB048597CC")
    public void setURI(URI address) {
        this.address = (GenericURI) address;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.010 -0400", hash_original_method = "0E80639575489DB45C2F9AFF28620E23", hash_generated_method = "119184E0DFE1CF53C2B846B312CE7D67")
    public void setUser(String user) {
        addTaint(user.getTaint());
        ((SipUri) this.address).setUser(user);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.010 -0400", hash_original_method = "4CDCC5D804344627E65CF6AE2B92722E", hash_generated_method = "67822606963D210D20A964DD86A6F039")
    public void setWildCardFlag() {
        this.addressType = WILD_CARD;
        this.address = new SipUri();
        ((SipUri)this.address).setUser("*");
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.011 -0400", hash_original_method = "0B091F8828B1420FFE66EE8D50F59446", hash_generated_method = "A087B568A5F42B7C81D931E582CB7440")
    public Object clone() {
        AddressImpl retval = (AddressImpl) super.clone();
    if(this.address != null)        
        retval.address = (GenericURI) this.address.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1658537937 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1658537937.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1658537937;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.011 -0400", hash_original_field = "B507F603877B2D8A3AA8AA4419600CFE", hash_generated_field = "2326BD2A1EC89625540C772C74ACDC21")

    private static final long serialVersionUID = 429592779568617259L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.011 -0400", hash_original_field = "BE8003BF2E9AA0082803EE27135CDC7C", hash_generated_field = "222B3DF6AA7EC58590F0AE49E8EC6A9D")

    public static final int NAME_ADDR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.011 -0400", hash_original_field = "C1E542609A4B1773F293F63B2222A709", hash_generated_field = "2E93044CF8C5AA42D1F0A2CA07805A14")

    public static final int ADDRESS_SPEC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.011 -0400", hash_original_field = "EF31971D96CF2A18B45B5D6CAA869866", hash_generated_field = "AA1965AB7CEEE0F896A9EFD409064D60")

    public static final int WILD_CARD = 3;
}

