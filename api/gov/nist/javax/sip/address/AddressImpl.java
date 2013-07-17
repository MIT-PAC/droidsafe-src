package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import javax.sip.address.*;

public final class AddressImpl extends NetObject implements javax.sip.address.Address {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.947 -0400", hash_original_field = "40179AAEEFAA5FF10EF85408F632A065", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.947 -0400", hash_original_field = "4498E82679F1B611EFB2C09E044EDE31", hash_generated_field = "1A7036061B9FC3789F96C7F5C73AF8A8")

    protected String displayName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.947 -0400", hash_original_field = "884D9804999FC47A3C2694E49AD2536A", hash_generated_field = "F84007EB7463857C9E0240DCE9E79680")

    protected GenericURI address;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.948 -0400", hash_original_method = "19BCE3FEC6F8BEE2FAC9ED705C20C9DE", hash_generated_method = "15E1C9067611157B0772065A0F22AF77")
    public  AddressImpl() {
        this.addressType = NAME_ADDR;
        // ---------- Original Method ----------
        //this.addressType = NAME_ADDR;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.948 -0400", hash_original_method = "22D6B687019E482F52E54287A969D6A5", hash_generated_method = "2A92ED0E53E0619BCF5C42E27BCBBBE0")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_194758104 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290322260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290322260;
        }
        if(!(other instanceof Address))        
        {
        boolean var68934A3E9455FA72420237EB05902327_2034104878 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940263580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940263580;
        }
        else
        {
            AddressImpl that = (AddressImpl) other;
            if(that.getMatcher() != null)            
            {
            boolean varCE18E34142C4D51F18C724B249AF59E1_1295205525 = (that.getMatcher().match(this.encode()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652040755 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652040755;
            }
            else
            if(that.displayName != null && this.displayName == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_2052738393 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181769818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181769818;
            }
            else
            if(that.displayName == null)            
            {
            boolean varA0B4D523C3AEDD6CAD8E5860A994817E_179439232 = (address.match(that.address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1793561121 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1793561121;
            }
            else
            {
            boolean var8F3C90541EF71E92205AA8404AF332A4_2034908683 = (displayName.equalsIgnoreCase(that.displayName)
                    && address.match(that.address));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402960803 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_402960803;
            }
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.949 -0400", hash_original_method = "A988603BA6459B5E85F0C286224314DC", hash_generated_method = "71D4991068BD1D93D3304208DA396049")
    public HostPort getHostPort() {
        if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_195975233 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_195975233.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_195975233;
        }
        SipUri uri = (SipUri) address;
HostPort varE7993041D19004E68232C123B2777A75_814260668 =         uri.getHostPort();
        varE7993041D19004E68232C123B2777A75_814260668.addTaint(taint);
        return varE7993041D19004E68232C123B2777A75_814260668;
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.950 -0400", hash_original_method = "D8DDF6A069BBACCEBB239C4EC58E5A27", hash_generated_method = "1D275998DB60940F791811B38AAF6FB3")
    public int getPort() {
        if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_1078226764 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_1078226764.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_1078226764;
        }
        SipUri uri = (SipUri) address;
        int varD85BD639CCE29AFAD3562F9520C9363C_1845475886 = (uri.getHostPort().getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712523781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712523781;
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort().getPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.950 -0400", hash_original_method = "172515F4F60E1E2B63F4DF9418CB15A7", hash_generated_method = "19BD6D7787ED08D799ECF175D618057A")
    public String getUserAtHostPort() {
        if(address instanceof SipUri)        
        {
            SipUri uri = (SipUri) address;
String var9543FAD4B7973B3269B2FDA49D7BEB32_1316404104 =             uri.getUserAtHostPort();
            var9543FAD4B7973B3269B2FDA49D7BEB32_1316404104.addTaint(taint);
            return var9543FAD4B7973B3269B2FDA49D7BEB32_1316404104;
        } //End block
        else
        {
String varF5977316C55FA2EB17D2CA1600D45F48_1717224945 =         address.toString();
        varF5977316C55FA2EB17D2CA1600D45F48_1717224945.addTaint(taint);
        return varF5977316C55FA2EB17D2CA1600D45F48_1717224945;
        }
        // ---------- Original Method ----------
        //if (address instanceof SipUri) {
            //SipUri uri = (SipUri) address;
            //return uri.getUserAtHostPort();
        //} else
            //return address.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.950 -0400", hash_original_method = "C2899C61B0488A683F191A3E8A7E482B", hash_generated_method = "B0F3E20F2FE5A897F5657D05D56CADF3")
    public String getHost() {
        if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_1832150980 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_1832150980.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_1832150980;
        }
        SipUri uri = (SipUri) address;
String varAA7210FD5162D7F477B57C943C6F39E5_76897858 =         uri.getHostPort().getHost().getHostname();
        varAA7210FD5162D7F477B57C943C6F39E5_76897858.addTaint(taint);
        return varAA7210FD5162D7F477B57C943C6F39E5_76897858;
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort().getHost().getHostname();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.951 -0400", hash_original_method = "0E39EDEFDBAD265D57AEBE040714053D", hash_generated_method = "7154CBF8E89304DF5A7B6331A70780D0")
    public void removeParameter(String parameterName) {
        addTaint(parameterName.getTaint());
        if(!(address instanceof SipUri))        
        {
        RuntimeException var3EE2E7292DEDFCDAA8437EA496F0B164_1522252659 = new RuntimeException("address is not a SipUri");
        var3EE2E7292DEDFCDAA8437EA496F0B164_1522252659.addTaint(taint);
        throw var3EE2E7292DEDFCDAA8437EA496F0B164_1522252659;
        }
        SipUri uri = (SipUri) address;
        uri.removeParameter(parameterName);
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //uri.removeParameter(parameterName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.951 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3D9B81A8EFCB60802A1B73D3C1FE7E31")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1028036072 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1028036072.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1028036072;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.951 -0400", hash_original_method = "F68604FD786D42AC18C162475B2762A0", hash_generated_method = "4D11BCFDED1BF15C91E6B8EA160E47EB")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(this.addressType == WILD_CARD)        
        {
            buffer.append('*');
        } //End block
        else
        {
            if(displayName != null)            
            {
                buffer.append(DOUBLE_QUOTE)
                        .append(displayName)
                        .append(DOUBLE_QUOTE)
                        .append(SP);
            } //End block
            if(address != null)            
            {
                if(addressType == NAME_ADDR || displayName != null)                
                buffer.append(LESS_THAN);
                address.encode(buffer);
                if(addressType == NAME_ADDR || displayName != null)                
                buffer.append(GREATER_THAN);
            } //End block
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2002592894 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_2002592894.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2002592894;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.952 -0400", hash_original_method = "93137A429171577005AC852AA3CBD92B", hash_generated_method = "FCDBCCFDDAB8ADEB3A7B6A7CD32A3CFD")
    public int getAddressType() {
        int var40179AAEEFAA5FF10EF85408F632A065_1014420781 = (addressType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278577929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278577929;
        // ---------- Original Method ----------
        //return addressType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.952 -0400", hash_original_method = "9F1FE4476648947E875579C9BD408A94", hash_generated_method = "9C4A3E70947FB3FDA091FB999E129026")
    public void setAddressType(int atype) {
        addressType = atype;
        // ---------- Original Method ----------
        //addressType = atype;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.952 -0400", hash_original_method = "050EB531E383683E34CFFBB41EC12665", hash_generated_method = "E50AE3FF1906348BBA0C34ADF3DD9BED")
    public String getDisplayName() {
String var850CACFC55D2C2C5428453BF9853A088_1118130839 =         displayName;
        var850CACFC55D2C2C5428453BF9853A088_1118130839.addTaint(taint);
        return var850CACFC55D2C2C5428453BF9853A088_1118130839;
        // ---------- Original Method ----------
        //return displayName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.953 -0400", hash_original_method = "20237627212B7A29DEC009BA073F5A0F", hash_generated_method = "22F780AE0AAD394C441B1705A60742F1")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.addressType = NAME_ADDR;
        // ---------- Original Method ----------
        //this.displayName = displayName;
        //this.addressType = NAME_ADDR;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.954 -0400", hash_original_method = "EB99F908657CD76194DE95632B999EA3", hash_generated_method = "5BB3C8C1253F38C0663C21B0AFC0573D")
    public void setAddess(javax.sip.address.URI address) {
        this.address = (GenericURI) address;
        // ---------- Original Method ----------
        //this.address = (GenericURI) address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.954 -0400", hash_original_method = "3B6DAA204E499460163C13A0179862F4", hash_generated_method = "8FC8E821A00E8F533DB0BFCF5D02A14F")
    public int hashCode() {
        int var9DFEDBBDB6902A3ACDAAD70F54E7EEC7_127760333 = (this.address.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649384773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649384773;
        // ---------- Original Method ----------
        //return this.address.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.954 -0400", hash_original_method = "2FE036AE685D31E73E4BA8A8E1238828", hash_generated_method = "0896550DAA2453A15E2383418EE415E5")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(this==other)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1254860856 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750015972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750015972;
        }
        if(other instanceof Address)        
        {
            final Address o = (Address) other;
            boolean var20A154666F5F31869936F16233D7830C_1344852693 = (this.getURI().equals( o.getURI() ));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748209570 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748209570;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_286508274 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068529989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068529989;
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof Address) {
            //final Address o = (Address) other;
            //return this.getURI().equals( o.getURI() );
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.955 -0400", hash_original_method = "B0F53EB98996816F5E75DFC90AF9D2B6", hash_generated_method = "DA90DBE7086765A549A464FC724B6599")
    public boolean hasDisplayName() {
        boolean varB14AA91EBB45365E021220596C75B0E1_1055941609 = ((displayName != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035758379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035758379;
        // ---------- Original Method ----------
        //return (displayName != null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.955 -0400", hash_original_method = "1C9F40C92EDF6ED97BB2D87B31D06D96", hash_generated_method = "5CD955E1E7F6119F595EEFAF2698F225")
    public void removeDisplayName() {
        displayName = null;
        // ---------- Original Method ----------
        //displayName = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.956 -0400", hash_original_method = "DEDDE1E197FB1DB769CF6C0A06F1A55D", hash_generated_method = "CA45ACC7DB2CAE2C8FAC374EB83B137C")
    public boolean isSIPAddress() {
        boolean var8C849DBBC993A1F97EB64E15DEE9DC3E_1489129125 = (address instanceof SipUri);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772251272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_772251272;
        // ---------- Original Method ----------
        //return address instanceof SipUri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.956 -0400", hash_original_method = "1CCD793210D749E7DAD6ED996CE553FC", hash_generated_method = "2D11E7EE71D6358E3A334BD40941C0E5")
    public URI getURI() {
URI varE9D6173C4BDEF381CE1BBEB54B394E2F_1623686331 =         this.address;
        varE9D6173C4BDEF381CE1BBEB54B394E2F_1623686331.addTaint(taint);
        return varE9D6173C4BDEF381CE1BBEB54B394E2F_1623686331;
        // ---------- Original Method ----------
        //return this.address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.956 -0400", hash_original_method = "6DCA089E698119AE5E5CAA45D8347BA0", hash_generated_method = "1754F339A2C73A70C115C49BAAA02A3B")
    public boolean isWildcard() {
        boolean var0584F1C2B3CDB2E6545FF2AC474D1B32_1280971769 = (this.addressType == WILD_CARD);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108663768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_108663768;
        // ---------- Original Method ----------
        //return this.addressType == WILD_CARD;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_method = "EE5571D54561E1127EBAFF3098CB1511", hash_generated_method = "07B1C81B131244B8D0886DCB048597CC")
    public void setURI(URI address) {
        this.address = (GenericURI) address;
        // ---------- Original Method ----------
        //this.address = (GenericURI) address;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_method = "0E80639575489DB45C2F9AFF28620E23", hash_generated_method = "119184E0DFE1CF53C2B846B312CE7D67")
    public void setUser(String user) {
        addTaint(user.getTaint());
        ((SipUri) this.address).setUser(user);
        // ---------- Original Method ----------
        //((SipUri) this.address).setUser(user);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_method = "4CDCC5D804344627E65CF6AE2B92722E", hash_generated_method = "67822606963D210D20A964DD86A6F039")
    public void setWildCardFlag() {
        this.addressType = WILD_CARD;
        this.address = new SipUri();
        ((SipUri)this.address).setUser("*");
        // ---------- Original Method ----------
        //this.addressType = WILD_CARD;
        //this.address = new SipUri();
        //((SipUri)this.address).setUser("*");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_method = "0B091F8828B1420FFE66EE8D50F59446", hash_generated_method = "77603F9FBAC3194FF85FF69F91AB1F45")
    public Object clone() {
        AddressImpl retval = (AddressImpl) super.clone();
        if(this.address != null)        
        retval.address = (GenericURI) this.address.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1265732561 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1265732561.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1265732561;
        // ---------- Original Method ----------
        //AddressImpl retval = (AddressImpl) super.clone();
        //if (this.address != null)
            //retval.address = (GenericURI) this.address.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_field = "B507F603877B2D8A3AA8AA4419600CFE", hash_generated_field = "2326BD2A1EC89625540C772C74ACDC21")

    private static final long serialVersionUID = 429592779568617259L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_field = "BE8003BF2E9AA0082803EE27135CDC7C", hash_generated_field = "222B3DF6AA7EC58590F0AE49E8EC6A9D")

    public static final int NAME_ADDR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_field = "C1E542609A4B1773F293F63B2222A709", hash_generated_field = "2E93044CF8C5AA42D1F0A2CA07805A14")

    public static final int ADDRESS_SPEC = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.957 -0400", hash_original_field = "EF31971D96CF2A18B45B5D6CAA869866", hash_generated_field = "AA1965AB7CEEE0F896A9EFD409064D60")

    public static final int WILD_CARD = 3;
}

