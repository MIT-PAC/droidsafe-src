package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import javax.sip.address.*;

public final class AddressImpl extends NetObject implements javax.sip.address.Address {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.092 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.092 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "1A7036061B9FC3789F96C7F5C73AF8A8")

    protected String displayName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.092 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "F84007EB7463857C9E0240DCE9E79680")

    protected GenericURI address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.093 -0400", hash_original_method = "19BCE3FEC6F8BEE2FAC9ED705C20C9DE", hash_generated_method = "15E1C9067611157B0772065A0F22AF77")
    public  AddressImpl() {
        this.addressType = NAME_ADDR;
        // ---------- Original Method ----------
        //this.addressType = NAME_ADDR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.104 -0400", hash_original_method = "22D6B687019E482F52E54287A969D6A5", hash_generated_method = "4E886289665A068EEED123150DBA1D5C")
    public boolean match(Object other) {
        {
            AddressImpl that;
            that = (AddressImpl) other;
            {
                boolean var702C910B5325E5C2A5847E8F6A867289_1166243277 = (that.getMatcher() != null);
                boolean varCBA521E4644E20B802AFE04533C02C53_581333667 = (that.getMatcher().match(this.encode()));
                boolean var60CA5F2E78075997A880589878115E51_1729285670 = (address.match(that.address));
                boolean varCACD682A5D1E34F205E5DFC71C0D0D91_845910962 = (displayName.equalsIgnoreCase(that.displayName)
                    && address.match(that.address));
            } //End collapsed parenthetic
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_371716899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_371716899;
        // ---------- Original Method ----------
        //if (other == null)
            //return true;
        //if (!(other instanceof Address))
            //return false;
        //else {
            //AddressImpl that = (AddressImpl) other;
            //if (that.getMatcher() != null)
                //return that.getMatcher().match(this.encode());
            //else if (that.displayName != null && this.displayName == null)
                //return false;
            //else if (that.displayName == null)
                //return address.match(that.address);
            //else
                //return displayName.equalsIgnoreCase(that.displayName)
                    //&& address.match(that.address);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.105 -0400", hash_original_method = "A988603BA6459B5E85F0C286224314DC", hash_generated_method = "54746D021F67598F576E7A59C22CA6B5")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_844911932 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        varB4EAC82CA7396A68D541C85D26508E83_844911932 = uri.getHostPort();
        varB4EAC82CA7396A68D541C85D26508E83_844911932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_844911932;
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.106 -0400", hash_original_method = "D8DDF6A069BBACCEBB239C4EC58E5A27", hash_generated_method = "58C39E3263D35285A006DE8B18280CB7")
    public int getPort() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        int var29430954332FCA6688F9B47637AA218C_256372555 = (uri.getHostPort().getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724506042 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724506042;
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort().getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.106 -0400", hash_original_method = "172515F4F60E1E2B63F4DF9418CB15A7", hash_generated_method = "A5477E58DD0965C8E3E6669C565A7362")
    public String getUserAtHostPort() {
        String varB4EAC82CA7396A68D541C85D26508E83_1590493644 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_94264190 = null; //Variable for return #2
        {
            SipUri uri;
            uri = (SipUri) address;
            varB4EAC82CA7396A68D541C85D26508E83_1590493644 = uri.getUserAtHostPort();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_94264190 = address.toString();
        String varA7E53CE21691AB073D9660D615818899_2136677122; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2136677122 = varB4EAC82CA7396A68D541C85D26508E83_1590493644;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2136677122 = varB4EAC82CA7396A68D541C85D26508E83_94264190;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2136677122.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2136677122;
        // ---------- Original Method ----------
        //if (address instanceof SipUri) {
            //SipUri uri = (SipUri) address;
            //return uri.getUserAtHostPort();
        //} else
            //return address.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.109 -0400", hash_original_method = "C2899C61B0488A683F191A3E8A7E482B", hash_generated_method = "E11DB719FFC1DCA492ACABDCD30C9FA3")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1049331029 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        varB4EAC82CA7396A68D541C85D26508E83_1049331029 = uri.getHostPort().getHost().getHostname();
        varB4EAC82CA7396A68D541C85D26508E83_1049331029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049331029;
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort().getHost().getHostname();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.110 -0400", hash_original_method = "0E39EDEFDBAD265D57AEBE040714053D", hash_generated_method = "11A6E61BAFE3C37BA72210B69AE5ECB2")
    public void removeParameter(String parameterName) {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        uri.removeParameter(parameterName);
        addTaint(parameterName.getTaint());
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //uri.removeParameter(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.110 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "44E8B9D94D021CC9E5A6266030612A97")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1744203714 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1744203714 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1744203714.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744203714;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.111 -0400", hash_original_method = "F68604FD786D42AC18C162475B2762A0", hash_generated_method = "53F4F1217E3D53B64C64087BACAFB46F")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_678881630 = null; //Variable for return #1
        {
            buffer.append('*');
        } //End block
        {
            {
                buffer.append(DOUBLE_QUOTE)
                        .append(displayName)
                        .append(DOUBLE_QUOTE)
                        .append(SP);
            } //End block
            {
                buffer.append(LESS_THAN);
                address.encode(buffer);
                buffer.append(GREATER_THAN);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_678881630 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_678881630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_678881630;
        // ---------- Original Method ----------
        //if (this.addressType == WILD_CARD) {
            //buffer.append('*');
        //}
        //else {
            //if (displayName != null) {
                //buffer.append(DOUBLE_QUOTE)
                        //.append(displayName)
                        //.append(DOUBLE_QUOTE)
                        //.append(SP);
            //}
            //if (address != null) {
                //if (addressType == NAME_ADDR || displayName != null)
                    //buffer.append(LESS_THAN);
                //address.encode(buffer);
                //if (addressType == NAME_ADDR || displayName != null)
                    //buffer.append(GREATER_THAN);
            //}
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.111 -0400", hash_original_method = "93137A429171577005AC852AA3CBD92B", hash_generated_method = "9C7AADCD150AED7BC39171361C7330EF")
    public int getAddressType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437296587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437296587;
        // ---------- Original Method ----------
        //return addressType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.111 -0400", hash_original_method = "9F1FE4476648947E875579C9BD408A94", hash_generated_method = "9C4A3E70947FB3FDA091FB999E129026")
    public void setAddressType(int atype) {
        addressType = atype;
        // ---------- Original Method ----------
        //addressType = atype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.122 -0400", hash_original_method = "050EB531E383683E34CFFBB41EC12665", hash_generated_method = "70C4DF7B395CDB56681AAE2E31CDB4F0")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1414936549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1414936549 = displayName;
        varB4EAC82CA7396A68D541C85D26508E83_1414936549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1414936549;
        // ---------- Original Method ----------
        //return displayName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.122 -0400", hash_original_method = "20237627212B7A29DEC009BA073F5A0F", hash_generated_method = "22F780AE0AAD394C441B1705A60742F1")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.addressType = NAME_ADDR;
        // ---------- Original Method ----------
        //this.displayName = displayName;
        //this.addressType = NAME_ADDR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.122 -0400", hash_original_method = "EB99F908657CD76194DE95632B999EA3", hash_generated_method = "5BB3C8C1253F38C0663C21B0AFC0573D")
    public void setAddess(javax.sip.address.URI address) {
        this.address = (GenericURI) address;
        // ---------- Original Method ----------
        //this.address = (GenericURI) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.123 -0400", hash_original_method = "3B6DAA204E499460163C13A0179862F4", hash_generated_method = "B968406B72076CBCBA96BED3CECDCD26")
    public int hashCode() {
        int var061A8066721511703856EB3A8F80EC74_714954867 = (this.address.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850505874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850505874;
        // ---------- Original Method ----------
        //return this.address.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.123 -0400", hash_original_method = "2FE036AE685D31E73E4BA8A8E1238828", hash_generated_method = "2F2A9FEF166F914FC2C86EC592796BC1")
    public boolean equals(Object other) {
        {
            Address o;
            o = (Address) other;
            boolean var34AFE256CC6216D17FE120A6537E01FB_1928267938 = (this.getURI().equals( o.getURI() ));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1511149299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1511149299;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof Address) {
            //final Address o = (Address) other;
            //return this.getURI().equals( o.getURI() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.123 -0400", hash_original_method = "B0F53EB98996816F5E75DFC90AF9D2B6", hash_generated_method = "C80C0845C214557AE03B2A9D9C8F8CF0")
    public boolean hasDisplayName() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011270969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011270969;
        // ---------- Original Method ----------
        //return (displayName != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.131 -0400", hash_original_method = "1C9F40C92EDF6ED97BB2D87B31D06D96", hash_generated_method = "5CD955E1E7F6119F595EEFAF2698F225")
    public void removeDisplayName() {
        displayName = null;
        // ---------- Original Method ----------
        //displayName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.132 -0400", hash_original_method = "DEDDE1E197FB1DB769CF6C0A06F1A55D", hash_generated_method = "CFC1F965C7C5AC881B43EC7D808557C0")
    public boolean isSIPAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449133739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449133739;
        // ---------- Original Method ----------
        //return address instanceof SipUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.132 -0400", hash_original_method = "1CCD793210D749E7DAD6ED996CE553FC", hash_generated_method = "BA7A982B9221767BA8D611C86DB83953")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1754786290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1754786290 = this.address;
        varB4EAC82CA7396A68D541C85D26508E83_1754786290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1754786290;
        // ---------- Original Method ----------
        //return this.address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.132 -0400", hash_original_method = "6DCA089E698119AE5E5CAA45D8347BA0", hash_generated_method = "4700FB0A147EA48720A3CD5B104554B7")
    public boolean isWildcard() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1140730763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1140730763;
        // ---------- Original Method ----------
        //return this.addressType == WILD_CARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.138 -0400", hash_original_method = "EE5571D54561E1127EBAFF3098CB1511", hash_generated_method = "07B1C81B131244B8D0886DCB048597CC")
    public void setURI(URI address) {
        this.address = (GenericURI) address;
        // ---------- Original Method ----------
        //this.address = (GenericURI) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.139 -0400", hash_original_method = "0E80639575489DB45C2F9AFF28620E23", hash_generated_method = "1C2FA3B94EDDE018E1E554932AD46F77")
    public void setUser(String user) {
        ((SipUri) this.address).setUser(user);
        addTaint(user.getTaint());
        // ---------- Original Method ----------
        //((SipUri) this.address).setUser(user);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.139 -0400", hash_original_method = "4CDCC5D804344627E65CF6AE2B92722E", hash_generated_method = "67822606963D210D20A964DD86A6F039")
    public void setWildCardFlag() {
        this.addressType = WILD_CARD;
        this.address = new SipUri();
        ((SipUri)this.address).setUser("*");
        // ---------- Original Method ----------
        //this.addressType = WILD_CARD;
        //this.address = new SipUri();
        //((SipUri)this.address).setUser("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.139 -0400", hash_original_method = "0B091F8828B1420FFE66EE8D50F59446", hash_generated_method = "45ACEEA77C9999BC4E769FFD6605638F")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2107424194 = null; //Variable for return #1
        AddressImpl retval;
        retval = (AddressImpl) super.clone();
        retval.address = (GenericURI) this.address.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2107424194 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2107424194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2107424194;
        // ---------- Original Method ----------
        //AddressImpl retval = (AddressImpl) super.clone();
        //if (this.address != null)
            //retval.address = (GenericURI) this.address.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.140 -0400", hash_original_field = "B507F603877B2D8A3AA8AA4419600CFE", hash_generated_field = "90C65EB47E3A467319F1CF869F07E825")

    private static long serialVersionUID = 429592779568617259L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.140 -0400", hash_original_field = "BE8003BF2E9AA0082803EE27135CDC7C", hash_generated_field = "222B3DF6AA7EC58590F0AE49E8EC6A9D")

    public static final int NAME_ADDR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.140 -0400", hash_original_field = "C1E542609A4B1773F293F63B2222A709", hash_generated_field = "2E93044CF8C5AA42D1F0A2CA07805A14")

    public static final int ADDRESS_SPEC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.140 -0400", hash_original_field = "EF31971D96CF2A18B45B5D6CAA869866", hash_generated_field = "AA1965AB7CEEE0F896A9EFD409064D60")

    public static final int WILD_CARD = 3;
}

