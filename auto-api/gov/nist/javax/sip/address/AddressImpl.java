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
    protected int addressType;
    protected String displayName;
    protected GenericURI address;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.359 -0400", hash_original_method = "19BCE3FEC6F8BEE2FAC9ED705C20C9DE", hash_generated_method = "15E1C9067611157B0772065A0F22AF77")
    @DSModeled(DSC.SAFE)
    public AddressImpl() {
        this.addressType = NAME_ADDR;
        // ---------- Original Method ----------
        //this.addressType = NAME_ADDR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.360 -0400", hash_original_method = "22D6B687019E482F52E54287A969D6A5", hash_generated_method = "FF60C47D3078256A1545DB6858B2DA85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            AddressImpl that;
            that = (AddressImpl) other;
            {
                boolean var702C910B5325E5C2A5847E8F6A867289_938296534 = (that.getMatcher() != null);
                boolean varCBA521E4644E20B802AFE04533C02C53_284914552 = (that.getMatcher().match(this.encode()));
                boolean var60CA5F2E78075997A880589878115E51_2089174430 = (address.match(that.address));
                boolean varCACD682A5D1E34F205E5DFC71C0D0D91_1452602445 = (displayName.equalsIgnoreCase(that.displayName)
                    && address.match(that.address));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.361 -0400", hash_original_method = "A988603BA6459B5E85F0C286224314DC", hash_generated_method = "D05128E360CB87392D5710A4575B75A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HostPort getHostPort() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        HostPort var0C3E672B8C27F2DA26B482BD399E1620_1920338232 = (uri.getHostPort());
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.361 -0400", hash_original_method = "D8DDF6A069BBACCEBB239C4EC58E5A27", hash_generated_method = "94F2D714CF877C0461A0CA6753D9AAD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        int var29430954332FCA6688F9B47637AA218C_432915522 = (uri.getHostPort().getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort().getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.362 -0400", hash_original_method = "172515F4F60E1E2B63F4DF9418CB15A7", hash_generated_method = "3109476896E0E9D59C42D4EE52420178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserAtHostPort() {
        {
            SipUri uri;
            uri = (SipUri) address;
            String var2C22EF2320A455E59D260858FAB5B4DF_358932138 = (uri.getUserAtHostPort());
        } //End block
        String varE3DD4439D5C32938DF9FA9FDF2C9921E_915621662 = (address.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (address instanceof SipUri) {
            //SipUri uri = (SipUri) address;
            //return uri.getUserAtHostPort();
        //} else
            //return address.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.363 -0400", hash_original_method = "C2899C61B0488A683F191A3E8A7E482B", hash_generated_method = "0023E8598FB9A640090F73BCF3E6AFC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHost() {
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        String varDD3AEAD5FC9EF5FF06B42AA2F00BFC8E_1935289829 = (uri.getHostPort().getHost().getHostname());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //return uri.getHostPort().getHost().getHostname();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.363 -0400", hash_original_method = "0E39EDEFDBAD265D57AEBE040714053D", hash_generated_method = "BADD657106D77228D7D267BBEEC12E32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeParameter(String parameterName) {
        dsTaint.addTaint(parameterName);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("address is not a SipUri");
        SipUri uri;
        uri = (SipUri) address;
        uri.removeParameter(parameterName);
        // ---------- Original Method ----------
        //if (!(address instanceof SipUri))
            //throw new RuntimeException("address is not a SipUri");
        //SipUri uri = (SipUri) address;
        //uri.removeParameter(parameterName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.363 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "CF8CB3EB0EAF1ADEE330CA7EECAE2793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_1351746587 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.364 -0400", hash_original_method = "F68604FD786D42AC18C162475B2762A0", hash_generated_method = "927B936C222964AE9971CF4E2771716B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
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
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.364 -0400", hash_original_method = "93137A429171577005AC852AA3CBD92B", hash_generated_method = "6F26BB7BC99B78E306FE2431F0976FDC")
    @DSModeled(DSC.SAFE)
    public int getAddressType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return addressType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.364 -0400", hash_original_method = "9F1FE4476648947E875579C9BD408A94", hash_generated_method = "1F37375BDF12A284482CE81759896136")
    @DSModeled(DSC.SAFE)
    public void setAddressType(int atype) {
        dsTaint.addTaint(atype);
        // ---------- Original Method ----------
        //addressType = atype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.364 -0400", hash_original_method = "050EB531E383683E34CFFBB41EC12665", hash_generated_method = "576B9E4B17A6203A085CD235FC918897")
    @DSModeled(DSC.SAFE)
    public String getDisplayName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return displayName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.364 -0400", hash_original_method = "20237627212B7A29DEC009BA073F5A0F", hash_generated_method = "FF42FD73A02D2763B78F32E93357BEE6")
    @DSModeled(DSC.SAFE)
    public void setDisplayName(String displayName) {
        dsTaint.addTaint(displayName);
        this.addressType = NAME_ADDR;
        // ---------- Original Method ----------
        //this.displayName = displayName;
        //this.addressType = NAME_ADDR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.365 -0400", hash_original_method = "EB99F908657CD76194DE95632B999EA3", hash_generated_method = "C65BA15C55886AD90B461691C7C15CD1")
    @DSModeled(DSC.SAFE)
    public void setAddess(javax.sip.address.URI address) {
        dsTaint.addTaint(address.dsTaint);
        this.address = (GenericURI) address;
        // ---------- Original Method ----------
        //this.address = (GenericURI) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.365 -0400", hash_original_method = "3B6DAA204E499460163C13A0179862F4", hash_generated_method = "ABCF896247BC65DA5FB22357097103B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int var061A8066721511703856EB3A8F80EC74_905215949 = (this.address.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.address.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.365 -0400", hash_original_method = "2FE036AE685D31E73E4BA8A8E1238828", hash_generated_method = "2C111207BFBEE63CFCE85243B51F1A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            Address o;
            o = (Address) other;
            boolean var34AFE256CC6216D17FE120A6537E01FB_2007598323 = (this.getURI().equals( o.getURI() ));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this==other) return true;
        //if (other instanceof Address) {
            //final Address o = (Address) other;
            //return this.getURI().equals( o.getURI() );
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.365 -0400", hash_original_method = "B0F53EB98996816F5E75DFC90AF9D2B6", hash_generated_method = "34DF7C22A87D65BA6ED345B7CBDA4735")
    @DSModeled(DSC.SAFE)
    public boolean hasDisplayName() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (displayName != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.365 -0400", hash_original_method = "1C9F40C92EDF6ED97BB2D87B31D06D96", hash_generated_method = "5CD955E1E7F6119F595EEFAF2698F225")
    @DSModeled(DSC.SAFE)
    public void removeDisplayName() {
        displayName = null;
        // ---------- Original Method ----------
        //displayName = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.365 -0400", hash_original_method = "DEDDE1E197FB1DB769CF6C0A06F1A55D", hash_generated_method = "F7141BE08B90E4CF63DE17C2262F63E9")
    @DSModeled(DSC.SAFE)
    public boolean isSIPAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return address instanceof SipUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.366 -0400", hash_original_method = "1CCD793210D749E7DAD6ED996CE553FC", hash_generated_method = "9DF0FC42E07B229A3629967A4DFB9447")
    @DSModeled(DSC.SAFE)
    public URI getURI() {
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.366 -0400", hash_original_method = "6DCA089E698119AE5E5CAA45D8347BA0", hash_generated_method = "BB13705512B4E71DD4A56494DB0F5BF8")
    @DSModeled(DSC.SAFE)
    public boolean isWildcard() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.addressType == WILD_CARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.366 -0400", hash_original_method = "EE5571D54561E1127EBAFF3098CB1511", hash_generated_method = "A989C60B5D53E909AA0F5C31408016E1")
    @DSModeled(DSC.SAFE)
    public void setURI(URI address) {
        dsTaint.addTaint(address.dsTaint);
        this.address = (GenericURI) address;
        // ---------- Original Method ----------
        //this.address = (GenericURI) address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.366 -0400", hash_original_method = "0E80639575489DB45C2F9AFF28620E23", hash_generated_method = "273DD6DFC5CF3EA61EB5A4F560476FCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUser(String user) {
        dsTaint.addTaint(user);
        ((SipUri) this.address).setUser(user);
        // ---------- Original Method ----------
        //((SipUri) this.address).setUser(user);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.366 -0400", hash_original_method = "4CDCC5D804344627E65CF6AE2B92722E", hash_generated_method = "67822606963D210D20A964DD86A6F039")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWildCardFlag() {
        this.addressType = WILD_CARD;
        this.address = new SipUri();
        ((SipUri)this.address).setUser("*");
        // ---------- Original Method ----------
        //this.addressType = WILD_CARD;
        //this.address = new SipUri();
        //((SipUri)this.address).setUser("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.366 -0400", hash_original_method = "0B091F8828B1420FFE66EE8D50F59446", hash_generated_method = "1D773E64D48F484486878FDB6D451504")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AddressImpl retval;
        retval = (AddressImpl) super.clone();
        retval.address = (GenericURI) this.address.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AddressImpl retval = (AddressImpl) super.clone();
        //if (this.address != null)
            //retval.address = (GenericURI) this.address.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = 429592779568617259L;
    public static final int NAME_ADDR = 1;
    public static final int ADDRESS_SPEC = 2;
    public static final int WILD_CARD = 3;
}

