package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.parser.StringMsgParser;
import gov.nist.javax.sip.parser.URLParser;

import java.text.ParseException;

import javax.sip.address.SipURI;
import javax.sip.address.TelURL;





public class AddressFactoryImpl implements javax.sip.address.AddressFactory {

    /** Creates a new instance of AddressFactoryImpl
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.076 -0500", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "1F6A742B0361C640F57D2BBE59EB53D0")
    public AddressFactoryImpl() {
    }


    /**
     *
     *Create an empty address object.
     *
     *SPEC_REVISION
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.077 -0500", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "6364BAAC0F12484FDB7B269BE39D5FD2")
    public javax.sip.address.Address createAddress() {
        return new AddressImpl();
    }
    /**
     * Creates an Address with the new display name and URI attribute
     * values.
     *
     * @param displayName - the new string value of the display name of the
     * address. A <code>null</code> value does not set the display name.
     * @param uri - the new URI value of the address.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the displayName value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.078 -0500", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "E27A767163647451E623E9852DB7A221")
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        if (uri == null)
            throw new NullPointerException("null  URI");
        AddressImpl addressImpl = new AddressImpl();
        if (displayName != null)
            addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
        return addressImpl;

    }

    /** create a sip uri.
     *
     *@param uri -- the uri to parse.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.079 -0500", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "68DCE7C74489AFAF0B7F33A387BEB9DB")
    public javax.sip.address.SipURI createSipURI(String uri)
    //  throws java.net.URISyntaxException {
    throws ParseException {
        if (uri == null)
            throw new NullPointerException("null URI");
        try {
            StringMsgParser smp = new StringMsgParser();
            SipUri sipUri = smp.parseSIPUrl(uri);
            return (SipURI) sipUri;
        } catch (ParseException ex) {
            //  throw new java.net.URISyntaxException(uri, ex.getMessage());
            throw new ParseException(ex.getMessage(), 0);
        }

    }

    /** Create a SipURI
     *
     *@param user -- the user
     *@param host -- the host.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.080 -0500", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "E01E632F05C3B4BB240F0FFBFCB3F338")
    public javax.sip.address.SipURI createSipURI(String user, String host)
        throws ParseException {
        if (host == null)
            throw new NullPointerException("null host");

        StringBuffer uriString = new StringBuffer("sip:");
        if (user != null) {
            uriString.append(user);
            uriString.append("@");
        }

        //if host is an IPv6 string we should enclose it in sq brackets
        if (host.indexOf(':') != host.lastIndexOf(':')
            && host.trim().charAt(0) != '[')
            host = '[' + host + ']';

        uriString.append(host);

        StringMsgParser smp = new StringMsgParser();
        try {

            SipUri sipUri = smp.parseSIPUrl(uriString.toString());
            return sipUri;
        } catch (ParseException ex) {
            throw new ParseException(ex.getMessage(), 0);
        }
    }

    /**
     * Creates a TelURL based on given URI string. The scheme or '+' should
     * not be included in the phoneNumber string argument.
     *
     * @param uri - the new string value of the phoneNumber.
     * @throws URISyntaxException if the URI string is malformed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.081 -0500", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "D0834FD3313D808174EE2101B60F5D91")
    public javax.sip.address.TelURL createTelURL(String uri)
        throws ParseException {
        if (uri == null)
            throw new NullPointerException("null url");
        String telUrl = "tel:" + uri;
        try {
            StringMsgParser smp = new StringMsgParser();
            TelURLImpl timp = (TelURLImpl) smp.parseUrl(telUrl);
            return (TelURL) timp;
        } catch (ParseException ex) {
            throw new ParseException(ex.getMessage(), 0);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.082 -0500", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "0563443555044227E6DD6D3804424C13")
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        if (uri == null)
            throw new NullPointerException("null address");
        AddressImpl addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
        return addressImpl;
    }

    /**
     * Creates an Address with the new address string value. The address
     * string is parsed in order to create the new Address instance. Create
     * with a String value of "*" creates a wildcard address. The wildcard
     * can be determined if
     * <code>((SipURI)Address.getURI).getUser() == *;</code>.
     *
     * @param address - the new string value of the address.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the address value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.083 -0500", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "D1C00D2D9C7C9C5095A0BFA12F667944")
    public javax.sip.address.Address createAddress(String address)
        throws java.text.ParseException {
        if (address == null)
            throw new NullPointerException("null address");

        if (address.equals("*")) {
            AddressImpl addressImpl = new AddressImpl();
            addressImpl.setAddressType(AddressImpl.WILD_CARD);
            SipURI uri = new SipUri();
            uri.setUser("*");
            addressImpl.setURI( uri );
            return addressImpl;
        } else {
            StringMsgParser smp = new StringMsgParser();
            return smp.parseAddress(address);
        }
    }

    /**
     * Creates a URI based on given URI string. The URI string is parsed in
     * order to create the new URI instance. Depending on the scheme the
     * returned may or may not be a SipURI or TelURL cast as a URI.
     *
     * @param uri - the new string value of the URI.
     * @throws URISyntaxException if the URI string is malformed.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:04.084 -0500", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "FF0594EF58A5BB44303EA7FC093E4589")
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        if (uri == null)
            throw new NullPointerException("null arg");
        try {
            URLParser urlParser = new URLParser(uri);
            String scheme = urlParser.peekScheme();
            if (scheme == null)
                throw new ParseException("bad scheme", 0);
            if (scheme.equalsIgnoreCase("sip")) {
                return (javax.sip.address.URI) urlParser.sipURL(true);
            } else if (scheme.equalsIgnoreCase("sips")) {
                return (javax.sip.address.URI) urlParser.sipURL(true);
            } else if (scheme.equalsIgnoreCase("tel")) {
                return (javax.sip.address.URI) urlParser.telURL(true);
            }
        } catch (ParseException ex) {
            throw new ParseException(ex.getMessage(), 0);
        }
        return new gov.nist.javax.sip.address.GenericURI(uri);
    }

    
}

