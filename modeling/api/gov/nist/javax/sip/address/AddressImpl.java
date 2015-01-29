package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.HostPort;

import javax.sip.address.Address;
import javax.sip.address.URI;

public final class AddressImpl extends NetObject implements javax.sip.address.Address {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.438 -0500", hash_original_field = "D3862CE7BD5E2E0EB6C4FD16D8FA0E41", hash_generated_field = "2326BD2A1EC89625540C772C74ACDC21")

    private static final long serialVersionUID = 429592779568617259L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.441 -0500", hash_original_field = "3E30F676CECF94C9F304EF86BAF61685", hash_generated_field = "222B3DF6AA7EC58590F0AE49E8EC6A9D")

    public static final int NAME_ADDR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.444 -0500", hash_original_field = "E0FB64AEE8B42EDA9A0FB1A77A6AE3CA", hash_generated_field = "2E93044CF8C5AA42D1F0A2CA07805A14")

    public static final int ADDRESS_SPEC = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.446 -0500", hash_original_field = "DC00844A9654C624B03BC71F335D9E39", hash_generated_field = "AA1965AB7CEEE0F896A9EFD409064D60")

    public static final int WILD_CARD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.449 -0500", hash_original_field = "4869FD8940D9617B6A2FA4DD94896EC8", hash_generated_field = "86D11EC31389BCB4DD7EA8E060BE2214")

    protected int addressType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.451 -0500", hash_original_field = "BB0F3128C925598F592DB9E6926FCA25", hash_generated_field = "1A7036061B9FC3789F96C7F5C73AF8A8")

    protected String displayName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.453 -0500", hash_original_field = "0C79A81FEDE26686F50577BC79325DF0", hash_generated_field = "F84007EB7463857C9E0240DCE9E79680")

    protected GenericURI address;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.477 -0500", hash_original_method = "19BCE3FEC6F8BEE2FAC9ED705C20C9DE", hash_generated_method = "773AFF092714F5016BA7C1575D84CA80")
    
public AddressImpl() {
        this.addressType = NAME_ADDR;
    }

    /** Match on the address only.
     * Dont care about the display name.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.456 -0500", hash_original_method = "22D6B687019E482F52E54287A969D6A5", hash_generated_method = "C32D6CB831C1F0D7542068CB05AFBD33")
    
public boolean match(Object other) {
        // TODO -- add the matcher;
        if (other == null)
            return true;
        if (!(other instanceof Address))
            return false;
        else {
            AddressImpl that = (AddressImpl) other;
            if (that.getMatcher() != null)
                return that.getMatcher().match(this.encode());
            else if (that.displayName != null && this.displayName == null)
                return false;
            else if (that.displayName == null)
                return address.match(that.address);
            else
                return displayName.equalsIgnoreCase(that.displayName)
                    && address.match(that.address);
        }

    }

    /** Get the host port portion of the address spec.
     *@return host:port in a HostPort structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.459 -0500", hash_original_method = "A988603BA6459B5E85F0C286224314DC", hash_generated_method = "9D8413F7EEAD8DC50B7F65B47DE691E3")
    
public HostPort getHostPort() {
        if (!(address instanceof SipUri))
            throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        return uri.getHostPort();
    }

    /** Get the port from the imbedded URI. This assumes that a SIP URL
     * is encapsulated in this address object.
     *
     *@return the port from the address.
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.461 -0500", hash_original_method = "D8DDF6A069BBACCEBB239C4EC58E5A27", hash_generated_method = "2658FFBAB8512477B02D434A2BC07C6A")
    
public int getPort() {
        if (!(address instanceof SipUri))
            throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        return uri.getHostPort().getPort();
    }

    /** Get the user@host:port for the address field. This assumes
     * that the encapsulated object is a SipUri.
     *
     *
     *@return string containing user@host:port.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.464 -0500", hash_original_method = "172515F4F60E1E2B63F4DF9418CB15A7", hash_generated_method = "48F095971EC03451A590E7C3D51DAAD7")
    
public String getUserAtHostPort() {
        if (address instanceof SipUri) {
            SipUri uri = (SipUri) address;
            return uri.getUserAtHostPort();
        } else
            return address.toString();
    }

    /** Get the host name from the address.
     *
     *@return the host name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.466 -0500", hash_original_method = "C2899C61B0488A683F191A3E8A7E482B", hash_generated_method = "228E50EBFAA930F23EF6E50703924DFB")
    
public String getHost() {
        if (!(address instanceof SipUri))
            throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        return uri.getHostPort().getHost().getHostname();
    }

    /** Remove a parameter from the address.
     *
     *@param parameterName is the name of the parameter to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.468 -0500", hash_original_method = "0E39EDEFDBAD265D57AEBE040714053D", hash_generated_method = "28389AACF03C7529BD68E2054F6204CB")
    
public void removeParameter(String parameterName) {
        if (!(address instanceof SipUri))
            throw new RuntimeException("address is not a SipUri");
        SipUri uri = (SipUri) address;
        uri.removeParameter(parameterName);
    }

    /**
     * Encode the address as a string and return it.
     * @return String canonical encoded version of this address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.471 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.473 -0500", hash_original_method = "F68604FD786D42AC18C162475B2762A0", hash_generated_method = "D06FEB3ECE4DB98C1637B473EBA78B7D")
    
public StringBuffer encode(StringBuffer buffer) {
        if (this.addressType == WILD_CARD) {
            buffer.append('*');
        }
        else {
            if (displayName != null) {
                buffer.append(DOUBLE_QUOTE)
                        .append(displayName)
                        .append(DOUBLE_QUOTE)
                        .append(SP);
            }
            if (address != null) {
                if (addressType == NAME_ADDR || displayName != null)
                    buffer.append(LESS_THAN);
                address.encode(buffer);
                if (addressType == NAME_ADDR || displayName != null)
                    buffer.append(GREATER_THAN);
            }
        }
        return buffer;
    }

    /**
     * Get the address type;
     * @return int
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.480 -0500", hash_original_method = "93137A429171577005AC852AA3CBD92B", hash_generated_method = "9FE7D25FEEBA724876BC9521E4BF81F7")
    
public int getAddressType() {
        return addressType;
    }

    /**
     * Set the address type. The address can be NAME_ADDR, ADDR_SPEC or
     * WILD_CARD
     *
     * @param atype int to set
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.482 -0500", hash_original_method = "9F1FE4476648947E875579C9BD408A94", hash_generated_method = "D7418B155CF49881FFF1AAD2766C514B")
    
public void setAddressType(int atype) {
        addressType = atype;
    }

    /**
     * get the display name
     *
     * @return String
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.484 -0500", hash_original_method = "050EB531E383683E34CFFBB41EC12665", hash_generated_method = "545FD95471F8EB7D6B0B64FDF9222FB3")
    
public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the displayName member
     *
     * @param displayName String to set
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.487 -0500", hash_original_method = "20237627212B7A29DEC009BA073F5A0F", hash_generated_method = "C21E1C60A1878BCE15BBE2FF0790176E")
    
public void setDisplayName(String displayName) {
        this.displayName = displayName;
        this.addressType = NAME_ADDR;
    }

    /**
     * Set the address field
     *
     * @param address SipUri to set
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.489 -0500", hash_original_method = "EB99F908657CD76194DE95632B999EA3", hash_generated_method = "31B15F65909FD287B89500CC942A69EF")
    
public void setAddess(javax.sip.address.URI address) {
        this.address = (GenericURI) address;
    }

    /**
     * hashCode impelmentation
     *
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.492 -0500", hash_original_method = "3B6DAA204E499460163C13A0179862F4", hash_generated_method = "282C4815616568D494CFF50146B0716A")
    
public int hashCode() {
        return this.address.hashCode();
    }

    /**
     * Compare two address specs for equality.
     *
     * @param other Object to compare this this address
     *
     * @return boolean
     *
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.494 -0500", hash_original_method = "2FE036AE685D31E73E4BA8A8E1238828", hash_generated_method = "D152F181C92FF38DA4914B0E1B0F1C5D")
    
public boolean equals(Object other) {

        if (this==other) return true;

        if (other instanceof Address) {
            final Address o = (Address) other;

            // Don't compare display name (?)
            return this.getURI().equals( o.getURI() );
        }
        return false;
    }

    /** return true if DisplayName exist.
     *
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.497 -0500", hash_original_method = "B0F53EB98996816F5E75DFC90AF9D2B6", hash_generated_method = "9BD22407E4A803D0343BA36C0A2A2920")
    
public boolean hasDisplayName() {
        return (displayName != null);
    }

    /** remove the displayName field
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.499 -0500", hash_original_method = "1C9F40C92EDF6ED97BB2D87B31D06D96", hash_generated_method = "20CA82C52FF6FF6318BA96E52A574212")
    
public void removeDisplayName() {
        displayName = null;
    }

    /** Return true if the imbedded URI is a sip URI.
     *
     * @return true if the imbedded URI is a SIP URI.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.501 -0500", hash_original_method = "DEDDE1E197FB1DB769CF6C0A06F1A55D", hash_generated_method = "D6230129008326DA3C02099C8E2CA524")
    
public boolean isSIPAddress() {
        return address instanceof SipUri;
    }

    /** Returns the URI address of this Address. The type of URI can be
     * determined by the scheme.
     *
     * @return address parmater of the Address object
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.504 -0500", hash_original_method = "1CCD793210D749E7DAD6ED996CE553FC", hash_generated_method = "DA30A205B7EC59B99C8E39DB930E9DAB")
    
public URI getURI() {
        return this.address;
    }

    /** This determines if this address is a wildcard address. That is
     * <code>Address.getAddress.getUserInfo() == *;</code>
     *
     * @return true if this name address is a wildcard, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.506 -0500", hash_original_method = "6DCA089E698119AE5E5CAA45D8347BA0", hash_generated_method = "D8E4CE4B18148E063615B4C3F682702D")
    
public boolean isWildcard() {
        return this.addressType == WILD_CARD;
    }

    /** Sets the URI address of this Address. The URI can be either a
     * TelURL or a SipURI.
     *
     * @param address - the new URI address value of this NameAddress.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.509 -0500", hash_original_method = "EE5571D54561E1127EBAFF3098CB1511", hash_generated_method = "1C82F174043A0DB0A7E6528B88B4CC48")
    
public void setURI(URI address) {
        this.address = (GenericURI) address;
    }

    /** Set the user name for the imbedded URI.
     *
     *@param user -- user name to set for the imbedded URI.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.512 -0500", hash_original_method = "0E80639575489DB45C2F9AFF28620E23", hash_generated_method = "481C4F2252C802944F1F6CF0C5BCB8B1")
    
public void setUser(String user) {
        ((SipUri) this.address).setUser(user);
    }

    /** Mark this a wild card address type.
     * Also set the SIP URI to a special wild card address.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.514 -0500", hash_original_method = "4CDCC5D804344627E65CF6AE2B92722E", hash_generated_method = "DA2CF9F8528F9464A0E7FA7A833C409E")
    
public void setWildCardFlag() {
        this.addressType = WILD_CARD;
        this.address = new SipUri();
        ((SipUri)this.address).setUser("*");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:34.516 -0500", hash_original_method = "0B091F8828B1420FFE66EE8D50F59446", hash_generated_method = "F03C3833613B9827C1B07D6213F1B077")
    
public Object clone() {
        AddressImpl retval = (AddressImpl) super.clone();
        if (this.address != null)
            retval.address = (GenericURI) this.address.clone();
        return retval;
    }
}

