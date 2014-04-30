package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Debug;
import gov.nist.core.GenericObject;
import gov.nist.core.Host;
import gov.nist.core.HostPort;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;

import java.text.ParseException;
import java.util.Iterator;

import javax.sip.PeerUnavailableException;
import javax.sip.SipFactory;
import javax.sip.address.SipURI;
import javax.sip.header.Header;
import javax.sip.header.HeaderFactory;

public class SipUri extends GenericURI implements javax.sip.address.SipURI, SipURIExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.574 -0500", hash_original_field = "8FC6527BA99010599F5B30018ECB1D0B", hash_generated_field = "2F69FD556F8E9767DDE2D2177EBF6C40")
 
    private static final long serialVersionUID = 7749781076218987044L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.577 -0500", hash_original_field = "9DBC425F3635DA6CB30834F07F3E129E", hash_generated_field = "AD4D5BC0220CFD82443737C52505C486")

    protected Authority authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.580 -0500", hash_original_field = "A5A50FDAB8265AE4028202FF5DC412E9", hash_generated_field = "F6A59563ED5E856D9CD91C684F4FC813")

    protected NameValueList uriParms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.583 -0500", hash_original_field = "68E3E5B90EBE7E336D971B4C25B5A976", hash_generated_field = "45901905C5831FBB34F7DCD157856090")

    protected NameValueList qheaders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.586 -0500", hash_original_field = "1BD3B5542C032F57E8E0FD1BF5D9B934", hash_generated_field = "486D6B81CF5C668276377979467C5D05")

    protected TelephoneNumber telephoneSubscriber;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.589 -0500", hash_original_method = "4581AC1C0AE43A94306BF80DA76A0B36", hash_generated_method = "C8E16539FAB337F317DAC05A532E9D7B")
    
public SipUri() {
        this.scheme = SIP;
        this.uriParms = new NameValueList();
        this.qheaders = new NameValueList();
        this.qheaders.setSeparator("&");
    }

    /** Constructor given the scheme.
    * The scheme must be either Sip or Sips
    */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.591 -0500", hash_original_method = "40F35B976B5ABD0FB641A4F1A08DC6DF", hash_generated_method = "4D70B9DD05DE37768124621E277D03A6")
    
public void setScheme(String scheme) {
        if (scheme.compareToIgnoreCase(SIP) != 0
            && scheme.compareToIgnoreCase(SIPS) != 0)
            throw new IllegalArgumentException("bad scheme " + scheme);
        this.scheme = scheme.toLowerCase();
    }

    /** Get the scheme.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.594 -0500", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9D11AD0B611F352DC84C8E1A6B825617")
    
public String getScheme() {
        return scheme;
    }

    /**
     * clear all URI Parameters.
     * @since v1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.596 -0500", hash_original_method = "B97988479159B246DBD5976667FAE614", hash_generated_method = "86482F0887C0BE97C5C9F2ACEB0A65C9")
    
public void clearUriParms() {
        uriParms = new NameValueList();
    }
    /**
    *Clear the password from the user part if it exists.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.598 -0500", hash_original_method = "FDFE9380996AC8B536679A9DC84D64BE", hash_generated_method = "98297AC5A418129FD6D317BC6BFE856D")
    
public void clearPassword() {
        if (this.authority != null) {
            UserInfo userInfo = authority.getUserInfo();
            if (userInfo != null)
                userInfo.clearPassword();
        }
    }

    /** Get the authority.
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.601 -0500", hash_original_method = "92C8D5BE70E6877E725894DF3752DAAD", hash_generated_method = "1426884E5ABC071DBB8D5A0DD4939808")
    
public Authority getAuthority() {
        return this.authority;
    }

    /**
     * Clear all Qheaders.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.604 -0500", hash_original_method = "44A5F82F772B2346E44573FA04C5E6BF", hash_generated_method = "3ABBE2A803DFB1C29B76770F492B12EA")
    
public void clearQheaders() {
        qheaders = new NameValueList();
    }

    /**
     * Compare two URIs and return true if they are equal.
     * @param that the object to compare to.
     * @return true if the object is equal to this object.
     *
     * JvB: Updated to define equality in terms of API methods, according to the rules
     * in RFC3261 section 19.1.4
     *
     * Jean Deruelle: Updated to define equality of API methods, according to the rules
     * in RFC3261 section 19.1.4 convert potential ie :
     *    %HEX HEX encoding parts of the URI before comparing them
     *    transport param added in comparison
     *    header equality enforced in comparison
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.609 -0500", hash_original_method = "9EAD5694A977A9D6081FC9F5B163E148", hash_generated_method = "ABE289723C8E0EAB8A9BF25C2A487D9F")
    
@SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object that) {

        // Shortcut for same object
        if (that==this) return true;

        if (that instanceof SipURI) {
            final SipURI a = this;
            final SipURI b = (SipURI) that;

            // A SIP and SIPS URI are never equivalent
            if ( a.isSecure() ^ b.isSecure() ) return false;

            // For two URIs to be equal, the user, password, host, and port
            // components must match; comparison of userinfo is case-sensitive
            if (a.getUser()==null ^ b.getUser()==null) return false;
            if (a.getUserPassword()==null ^ b.getUserPassword()==null) return false;

            if (a.getUser()!=null && !RFC2396UrlDecoder.decode(a.getUser()).equals(RFC2396UrlDecoder.decode(b.getUser()))) return false;
            if (a.getUserPassword()!=null && !RFC2396UrlDecoder.decode(a.getUserPassword()).equals(RFC2396UrlDecoder.decode(b.getUserPassword()))) return false;
            if (a.getHost() == null ^ b.getHost() == null) return false;
            if (a.getHost() != null && !a.getHost().equalsIgnoreCase(b.getHost())) return false;
            if (a.getPort() != b.getPort()) return false;

            // URI parameters
            for (Iterator i = a.getParameterNames(); i.hasNext();) {
                String pname = (String) i.next();

                String p1 = a.getParameter(pname);
                String p2 = b.getParameter(pname);

                // those present in both must match (case-insensitive)
                if (p1!=null && p2!=null && !RFC2396UrlDecoder.decode(p1).equalsIgnoreCase(RFC2396UrlDecoder.decode(p2))) return false;
            }

            // transport, user, ttl or method must match when present in either
            if (a.getTransportParam()==null ^ b.getTransportParam()==null) return false;
            if (a.getUserParam()==null ^ b.getUserParam()==null) return false;
            if (a.getTTLParam()==-1 ^ b.getTTLParam()==-1) return false;
            if (a.getMethodParam()==null ^ b.getMethodParam()==null) return false;
            if (a.getMAddrParam()==null ^ b.getMAddrParam()==null) return false;

            // Headers: must match according to their definition.
            if(a.getHeaderNames().hasNext() && !b.getHeaderNames().hasNext()) return false;
            if(!a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext()) return false;

            if(a.getHeaderNames().hasNext() && b.getHeaderNames().hasNext()) {
                HeaderFactory headerFactory = null;
                try {
                    headerFactory = SipFactory.getInstance().createHeaderFactory();
                } catch (PeerUnavailableException e) {
                    Debug.logError("Cannot get the header factory to parse the header of the sip uris to compare", e);
                    return false;
                }
                for (Iterator i = a.getHeaderNames(); i.hasNext();) {
                    String hname = (String) i.next();

                    String h1 = a.getHeader(hname);
                    String h2 = b.getHeader(hname);

                    if(h1 == null && h2 != null) return false;
                    if(h2 == null && h1 != null) return false;
                    // The following check should not be needed but we add it for findbugs.
                    if(h1 == null && h2 == null) continue; 
                    try {
                        Header header1 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h1));
                        Header header2 = headerFactory.createHeader(hname, RFC2396UrlDecoder.decode(h2));
                        // those present in both must match according to the equals method of the corresponding header
                        if (!header1.equals(header2)) return false;
                    } catch (ParseException e) {
                        Debug.logError("Cannot parse one of the header of the sip uris to compare " + a + " " + b, e);
                        return false;
                    }
                }
            }

            // Finally, we can conclude that they are indeed equal
            return true;
        }
        return false;
    }

    /**
     * Construct a URL from the parsed structure.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.612 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.614 -0500", hash_original_method = "C22033B09BF680257BC2551F51CC4682", hash_generated_method = "428257B757877B6289837961B24A3AD0")
    
public StringBuffer encode(StringBuffer buffer) {
        buffer.append(scheme).append(COLON);
        if (authority != null)
            authority.encode(buffer);
        if (!uriParms.isEmpty()) {
            buffer.append(SEMICOLON);
            uriParms.encode(buffer);
        }
        if (!qheaders.isEmpty()) {
            buffer.append(QUESTION);
            qheaders.encode(buffer);
        }
        return buffer;
    }

    /** Return a string representation.
    *
    *@return the String representation of this URI.
    *
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.617 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }

    /**
     * getUser@host
     * @return user@host portion of the uri (null if none exists).
     *
     * Peter Musgrave - handle null user
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.620 -0500", hash_original_method = "000995A40BE4F62572B4CEC75CD27D06", hash_generated_method = "F153F4BB4AD53CE7808D7FA7A16B21FD")
    
public String getUserAtHost() {
        String user = "";
        if (authority.getUserInfo() != null)
            user = authority.getUserInfo().getUser();

        String host = authority.getHost().encode();
        StringBuffer s = null;
        if (user.equals("")) {
            s = new StringBuffer();
        } else {
            s = new StringBuffer(user).append(AT);
        }
        return s.append(host).toString();
    }

    /**
     * getUser@host
     * @return user@host portion of the uri (null if none exists).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.623 -0500", hash_original_method = "6F248E410BDCE844EE042BFFA98482C9", hash_generated_method = "0B2B4D7DDDA1BC4B146FF64C448A6027")
    
public String getUserAtHostPort() {
        String user = "";
        if (authority.getUserInfo() != null)
            user = authority.getUserInfo().getUser();

        String host = authority.getHost().encode();
        int port = authority.getPort();
        // If port not set assign the default.
        StringBuffer s = null;
        if (user.equals("")) {
            s = new StringBuffer();
        } else {
            s = new StringBuffer(user).append(AT);
        }
        if (port != -1) {
            return s.append(host).append(COLON).append(port).toString();
        } else
            return s.append(host).toString();

    }

    /**
     * get the parameter (do a name lookup) and return null if none exists.
     * @param parmname Name of the parameter to get.
     * @return Parameter of the given name (null if none exists).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.626 -0500", hash_original_method = "208FE04DEC7ECCEEFC5A47E5D08BA557", hash_generated_method = "EBBB0573D9EA29221B55C057A3D774A0")
    
public Object getParm(String parmname) {
        Object obj = uriParms.getValue(parmname);
        return obj;
    }

    /**
     * Get the method parameter.
     * @return Method parameter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.628 -0500", hash_original_method = "DA8D1E67518AA478AB8C96314B0F321C", hash_generated_method = "0E7912D3CBABC340B8A574D732787776")
    
public String getMethod() {
        return (String) getParm(METHOD);
    }

    /**
     * Accessor for URI parameters
     * @return A name-value list containing the parameters.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.631 -0500", hash_original_method = "5EDAD210CE239248A46B40B8A7E4E067", hash_generated_method = "A0587C0605869DEB0FED11174C98A2F3")
    
public NameValueList getParameters() {
        return uriParms;
    }

    /** Remove the URI parameters.
    *
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.633 -0500", hash_original_method = "F23607C60777A1A36911A6FE06B11E71", hash_generated_method = "4341A3BA405D3D7EA980906662C2F7D0")
    
public void removeParameters() {
        this.uriParms = new NameValueList();
    }

    /**
     * Accessor forSIPObjects
     * @return Get the query headers (that appear after the ? in
     * the URL)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.636 -0500", hash_original_method = "69A77D050D6DE602ACFB758F18CE1C2E", hash_generated_method = "4D8BDCD095F52C5984E59A24BB5FB672")
    
public NameValueList getQheaders() {
        return qheaders;
    }

    /**
     * Get the urse parameter.
     * @return User parameter (user= phone or user=ip).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.638 -0500", hash_original_method = "C4F4158359E9C3CE01C658AE1B903AEE", hash_generated_method = "A1206154083433ACC39B41A99B363CDD")
    
public String getUserType() {
        return (String) uriParms.getValue(USER);
    }

    /**
     * Get the password of the user.
     * @return User password when it embedded as part of the uri
     * ( a very bad idea).
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.640 -0500", hash_original_method = "F7BA3F65C36127DC85DBDC366FBE67EC", hash_generated_method = "3198E0B0083B25F8D5ECFD56BB42716A")
    
public String getUserPassword() {
        if (authority == null)
            return null;
        return authority.getPassword();
    }

    /** Set the user password.
     *@param password - password to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.643 -0500", hash_original_method = "EB4E37E6319716C20DB55C1D8565711A", hash_generated_method = "6177871D7FFD769C6D15225FED5F602C")
    
public void setUserPassword(String password) {
        if (this.authority == null)
            this.authority = new Authority();
        authority.setPassword(password);
    }

    /**
     * Returns the stucture corresponding to the telephone number
     * provided that the user is a telephone subscriber.
     * @return TelephoneNumber part of the url (only makes sense
     * when user = phone is specified)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.646 -0500", hash_original_method = "FBB7E1AC9741B23BB5B3EA84041A8793", hash_generated_method = "AA9F8D8AB2E83E2208B7C6067D0DD769")
    
public TelephoneNumber getTelephoneSubscriber() {
        if (telephoneSubscriber == null) {

            telephoneSubscriber = new TelephoneNumber();
        }
        return telephoneSubscriber;
    }

    /**
     * Get the host and port of the server.
     * @return get the host:port part of the url parsed into a
     * structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.648 -0500", hash_original_method = "B2DE769DC5E0088684B143D456F129CF", hash_generated_method = "9A76B9A647B4D17E09229A81F38940E2")
    
public HostPort getHostPort() {

        if (authority == null || authority.getHost() == null )
            return null;
        else {
            return authority.getHostPort();
        }
    }

    /** Get the port from the authority field.
    *
    *@return the port from the authority field.
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.651 -0500", hash_original_method = "7F780725D3A26A9FAAA917ED82465734", hash_generated_method = "2F442A3DD0B302A67DBC465080665272")
    
public int getPort() {
        HostPort hp = this.getHostPort();
        if (hp == null)
            return -1;
        return hp.getPort();
    }

    /** Get the host protion of the URI.
    * @return the host portion of the url.
    */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.653 -0500", hash_original_method = "40B106F658B1B0B8AE55FF744395EB77", hash_generated_method = "B04DD2CCF03CA392865EE9C7B30DAC52")
    
public String getHost() {
        if ( authority == null) return null;
        else if (authority.getHost() == null ) return null;
        else return authority.getHost().encode();
    }

    /**
     * returns true if the user is a telephone subscriber.
     *  If the host is an Internet telephony
     * gateway, a telephone-subscriber field MAY be used instead
     * of a user field. The telephone-subscriber field uses the
     * notation of RFC 2806 [19]. Any characters of the un-escaped
     * "telephone-subscriber" that are not either in the set
     * "unreserved" or "user-unreserved" MUST be escaped. The set
     * of characters not reserved in the RFC 2806 description of
     * telephone-subscriber contains a number of characters in
     * various syntax elements that need to be escaped when used
     * in SIP URLs, for example quotation marks (%22), hash (%23),
     * colon (%3a), at-sign (%40) and the "unwise" characters,
     * i.e., punctuation of %5b and above.
     *
     * The telephone number is a special case of a user name and
     * cannot be distinguished by a BNF. Thus, a URL parameter,
     * user, is added to distinguish telephone numbers from user
     * names.
     *
     * The user parameter value "phone" indicates that the user
     * part contains a telephone number. Even without this
     * parameter, recipients of SIP URLs MAY interpret the pre-@
     * part as a telephone number if local restrictions on the
     * @return true if the user is a telephone subscriber.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.657 -0500", hash_original_method = "56CDDCF4149582CE88DAE7137BB51FB6", hash_generated_method = "92D26EC8E44EA331B298DDBE3B401F3A")
    
public boolean isUserTelephoneSubscriber() {
        String usrtype = (String) uriParms.getValue(USER);
        if (usrtype == null)
            return false;
        return usrtype.equalsIgnoreCase(PHONE);
    }

    /**
     *remove the ttl value from the parameter list if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.659 -0500", hash_original_method = "31B2EAABC2E978FD5373BC4C4C4BC54F", hash_generated_method = "F90DC233681EAF1A64DC1578856C0693")
    
public void removeTTL() {
        if (uriParms != null)
            uriParms.delete(TTL);
    }

    /**
     *Remove the maddr param if it exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.662 -0500", hash_original_method = "26682CE55BB39CA926871319A4C06C7F", hash_generated_method = "0FF86BF8D4B3CAD907CC2B42FD37E314")
    
public void removeMAddr() {
        if (uriParms != null)
            uriParms.delete(MADDR);
    }

    /**
     *Delete the transport string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.665 -0500", hash_original_method = "17C4DDD354C5E051E7720776FDB1621B", hash_generated_method = "8338E2915F438BB5FC2143FBC58A704E")
    
public void removeTransport() {
        if (uriParms != null)
            uriParms.delete(TRANSPORT);
    }

    /** Remove a header given its name (provided it exists).
     * @param name name of the header to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.667 -0500", hash_original_method = "3200AD1B535820580583A49AC076B7CA", hash_generated_method = "091B4BCA24C4E6AD35584E292DBA491D")
    
public void removeHeader(String name) {
        if (qheaders != null)
            qheaders.delete(name);
    }

    /** Remove all headers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.670 -0500", hash_original_method = "69EBEDDBEBD5610928D56ADB554A973E", hash_generated_method = "373724F1F422F41885B691E997E2DD7B")
    
public void removeHeaders() {
        qheaders = new NameValueList();
    }

    /**
     * Set the user type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.672 -0500", hash_original_method = "4C60E3731E2F1A6A961C2EAF6730B8EA", hash_generated_method = "2CDCA23B58D35C8E8E168DF40A730FA4")
    
public void removeUserType() {
        if (uriParms != null)
            uriParms.delete(USER);
    }

    /**
     *remove the port setting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.675 -0500", hash_original_method = "A557BD8F16E39F3D746BC7787E72C291", hash_generated_method = "C0122007B2F65595FDA683997AE07770")
    
public void removePort() {
        authority.removePort();
    }

    /**
     * remove the Method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.677 -0500", hash_original_method = "80293F715FFD7AE029130C857C03E1EB", hash_generated_method = "2F96630F11F01B239FEFE4E825456CFB")
    
public void removeMethod() {
        if (uriParms != null)
            uriParms.delete(METHOD);
    }

    /** Sets the user of SipURI. The identifier of a particular resource at
     * the host being addressed. The user and the user password including the
     * "at" sign make up the user-info.
     *
     * @param uname The new String value of the user.
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the user value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.680 -0500", hash_original_method = "8653C52476DAA9902FEC7B8799779AA0", hash_generated_method = "63003664D5AA30FDB649405CEA049D71")
    
public void setUser(String uname) {
        if (this.authority == null) {
            this.authority = new Authority();
        }

        this.authority.setUser(uname);
    }

    /** Remove the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.683 -0500", hash_original_method = "D79A18951B63A09462A96884D78AF17C", hash_generated_method = "5B833CF768F6F2BDC6475CB76511D792")
    
public void removeUser() {
        this.authority.removeUserInfo();
    }

    /** Set the default parameters for this URI.
     * Do nothing if the parameter is already set to some value.
     * Otherwise set it to the given value.
     * @param name Name of the parameter to set.
     * @param value value of the parameter to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.686 -0500", hash_original_method = "29256DC0D79112DA6F3456FF1FC7A4DA", hash_generated_method = "6B510269C355509DD2140207D680C604")
    
public void setDefaultParm(String name, Object value) {
        if (uriParms.getValue(name) == null) {
            NameValue nv = new NameValue(name, value);
            uriParms.set(nv);
        }
    }

    /** Set the authority member
     * @param authority Authority to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.690 -0500", hash_original_method = "8155A130BB5ECD11F95AAB0DA6526B6B", hash_generated_method = "DAF1C1F3FBD41635FEC400880AC438FE")
    
public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    /** Set the host for this URI.
     * @param h host to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.693 -0500", hash_original_method = "448F841326C9DE5F0C1061A977ECCF57", hash_generated_method = "ED2475C2F34131C9C21B4A010FBAB612")
    
public void setHost(Host h) {
        if (this.authority == null)
            this.authority = new Authority();
        this.authority.setHost(h);
    }

    /** Set the uriParms member
     * @param parms URI parameters to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.696 -0500", hash_original_method = "BF30B120DCA846B2AB31EE4276940CB4", hash_generated_method = "73692A420BC66C2380AAD35DBEFB29FE")
    
public void setUriParms(NameValueList parms) {
        uriParms = parms;
    }

    /**
     * Set a given URI parameter. Note - parameter must be properly
    *  encoded before the function is called.
     * @param name Name of the parameter to set.
     * @param value value of the parameter to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.699 -0500", hash_original_method = "B486DF9BA471DAAE60D8533B7C47A65D", hash_generated_method = "FDBA0DF4C5293E07053A04A6D3C509C9")
    
public void setUriParm(String name, Object value) {
        NameValue nv = new NameValue(name, value);
        uriParms.set(nv);
    }

    /** Set the qheaders member
     * @param parms query headers to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.701 -0500", hash_original_method = "3BCF6EC7FF3BBA5809384A38F15B6A45", hash_generated_method = "53C8F72327F77FB74BB513416F1BEEF8")
    
public void setQheaders(NameValueList parms) {
        qheaders = parms;
    }

    /**
     * Set the MADDR parameter .
     * @param mAddr Host Name to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.705 -0500", hash_original_method = "5C181333E4641A8C388789644A11AD43", hash_generated_method = "BD528FF3D72DD4DD780458FB41AD237B")
    
public void setMAddr(String mAddr) {
        NameValue nameValue = uriParms.getNameValue(MADDR);
        Host host = new Host();
        host.setAddress(mAddr);
        if (nameValue != null)
            nameValue.setValueAsObject(host);
        else {
            nameValue = new NameValue(MADDR, host);
            uriParms.set(nameValue);
        }
    }

    /** Sets the value of the user parameter. The user URI parameter exists to
     * distinguish telephone numbers from user names that happen to look like
     * telephone numbers.  This is equivalent to setParameter("user", user).
     *
     * @param usertype New value String value of the method parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.707 -0500", hash_original_method = "FBDBB9DDA2030458399AB3B5F3F4F0C6", hash_generated_method = "2AE57B42599260DE26C77E8F61C6D30D")
    
public void setUserParam(String usertype) {
        uriParms.set(USER, usertype);
    }

    /**
     * Set the Method
     * @param method method parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.710 -0500", hash_original_method = "4C629B888B40F45F11F6D780770DFFA5", hash_generated_method = "56C3B2E442DABACE0D9424C9AB6A89F5")
    
public void setMethod(String method) {
        uriParms.set(METHOD, method);
    }

    /**
    * Sets ISDN subaddress of SipURL
    * @param isdnSubAddress ISDN subaddress
    */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.713 -0500", hash_original_method = "E57262682E1156419367692D3CFC45F4", hash_generated_method = "70852EF590789211AB949EBEE0BF81E6")
    
public void setIsdnSubAddress(String isdnSubAddress) {
        if (telephoneSubscriber == null)
            telephoneSubscriber = new TelephoneNumber();
        telephoneSubscriber.setIsdnSubaddress(isdnSubAddress);
    }

    /**
     * Set the telephone subscriber field.
     * @param tel Telephone subscriber field to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.716 -0500", hash_original_method = "988EFE784E2C119D10B2A809CB388B9F", hash_generated_method = "324ADB803824EA3EF904739FC58092DD")
    
public void setTelephoneSubscriber(TelephoneNumber tel) {
        telephoneSubscriber = tel;
    }

    /** set the port to a given value.
     * @param p Port to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.718 -0500", hash_original_method = "92A3A80BC1BE07F5BFACEB6CB4FB4561", hash_generated_method = "1DCA256BF4481228A256AF576C42080F")
    
public void setPort(int p) {
        if (authority == null)
            authority = new Authority();
        authority.setPort(p);
    }

    /**
     * Boolean to check if a parameter of a given name exists.
     * @param name Name of the parameter to check on.
     * @return a boolean indicating whether the parameter exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.721 -0500", hash_original_method = "6341E21CDA970E0B49B9800DCF1B5945", hash_generated_method = "624D979B6FE2FB064D5874DCDEC81C44")
    
public boolean hasParameter(String name) {

        return uriParms.getValue(name) != null;
    }

    /**
     * Set the query header when provided as a name-value pair.
     * @param nameValue qeuery header provided as a name,value pair.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.724 -0500", hash_original_method = "93D043490BF44801AA76F19310D9D034", hash_generated_method = "66A76546B57CA50A4685E8DF29B937E3")
    
public void setQHeader(NameValue nameValue) {
        this.qheaders.set(nameValue);
    }

    /** Set the parameter as given.
     *@param nameValue - parameter to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.726 -0500", hash_original_method = "CF8B8270AAB7EE0DBD09C8A6E6FE77D2", hash_generated_method = "30E9CB7D077E4A0723FC18546E233B53")
    
public void setUriParameter(NameValue nameValue) {
        this.uriParms.set(nameValue);
    }

    /** Return true if the transport parameter is defined.
     * @return true if transport appears as a parameter and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.728 -0500", hash_original_method = "79BAB25129164A5068BFAB9AA7EFB4C6", hash_generated_method = "522F5176B4DE1AC9DB1BB686305E68CE")
    
public boolean hasTransport() {
        return hasParameter(TRANSPORT);
    }

    /**
     * Remove a parameter given its name
     * @param name -- name of the parameter to remove.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.731 -0500", hash_original_method = "80DDF5AC1394722FFD3DB956063197F8", hash_generated_method = "2356D507E2722697A2CB39BCE5AF7681")
    
public void removeParameter(String name) {
        uriParms.delete(name);
    }

    /** Set the hostPort field of the imbedded authority field.
     *@param hostPort is the hostPort to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.733 -0500", hash_original_method = "C8CB16861890EEF599D006A2C41B9058", hash_generated_method = "7962EDBDF0FC82223AEFE2DDFF175610")
    
public void setHostPort(HostPort hostPort) {
        if (this.authority == null) {
            this.authority = new Authority();
        }
        authority.setHostPort(hostPort);
    }

    /** clone this.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.736 -0500", hash_original_method = "4FA40F4F8EA124691CF5F7EB5079802B", hash_generated_method = "85A33A80C3DB89D134F237C5E9C16940")
    
public Object clone() {
        SipUri retval = (SipUri) super.clone();
        if (this.authority != null)
            retval.authority = (Authority) this.authority.clone();
        if (this.uriParms != null)
            retval.uriParms = (NameValueList) this.uriParms.clone();
        if (this.qheaders != null)
            retval.qheaders = (NameValueList) this.qheaders.clone();
        if (this.telephoneSubscriber != null)
            retval.telephoneSubscriber = (TelephoneNumber) this.telephoneSubscriber.clone();
        return retval;
    }

    /**
     * Returns the value of the named header, or null if it is not set.
     * SIP/SIPS URIs may specify headers. As an example, the URI
     * sip:joe@jcp.org?priority=urgent has a header "priority" whose
     * value is "urgent".
     *
     * @param name name of header to retrieve
     * @return the value of specified header
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.740 -0500", hash_original_method = "D620A31F761EF988C6C51AF3A40C0F6E", hash_generated_method = "F81B4EFFB4E35ADC74FC53F4333AC738")
    
public String getHeader(String name) {
        return this.qheaders.getValue(name) != null
            ? this.qheaders.getValue(name).toString()
            : null;

    }

    /**
     * Returns an Iterator over the names (Strings) of all headers present
     * in this SipURI.
     *
     * @return an Iterator over all the header names
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.744 -0500", hash_original_method = "4530375C3CFB28EF39A61BC561477425", hash_generated_method = "6969B372148BA3049D74099420B0849A")
    
public Iterator<String> getHeaderNames() {
        return this.qheaders.getNames();

    }

    /** Returns the value of the <code>lr</code> parameter, or null if this
     * is not set. This is equivalent to getParameter("lr").
     *
     * @return the value of the <code>lr</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.747 -0500", hash_original_method = "3F7D698AA93119CDF4AD07DDC087B33E", hash_generated_method = "3B4CFBD9F30A387255478993C0A4662F")
    
public String getLrParam() {
        boolean haslr = this.hasParameter(LR);
        return haslr ? "true" : null;
    }

    /** Returns the value of the <code>maddr</code> parameter, or null if this
     * is not set. This is equivalent to getParameter("maddr").
     *
     * @return the value of the <code>maddr</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.750 -0500", hash_original_method = "8D33CC87FEAA658432B140BA930B3AED", hash_generated_method = "793752ABBD69F6775299093FC3661F51")
    
public String getMAddrParam() {
        NameValue maddr = uriParms.getNameValue(MADDR);
        if (maddr == null)
            return null;
        String host = (String) maddr.getValueAsObject();
        return host;
    }

    /**
     * Returns the value of the <code>method</code> parameter, or null if this
     * is not set. This is equivalent to getParameter("method").
     *
     * @return  the value of the <code>method</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.752 -0500", hash_original_method = "B0014A6E847FE8E425D38FE4F75F3375", hash_generated_method = "D998DF3FFBD04FB85DBAEA756C7F0352")
    
public String getMethodParam() {
        return this.getParameter(METHOD);
    }

    /**
     * Returns the value of the named parameter, or null if it is not set. A
     * zero-length String indicates flag parameter.
     *
     * @param name name of parameter to retrieve
     * @return the value of specified parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.755 -0500", hash_original_method = "B72E21D53820BAFF3F91285B817E8F6B", hash_generated_method = "04E7B029CC7CCD88DBBA92BCBBC6C127")
    
public String getParameter(String name) {
        Object val = uriParms.getValue(name);
        if (val == null)
            return null;
        if (val instanceof GenericObject)
            return ((GenericObject) val).encode();
        else
            return val.toString();
    }

    /**
     * Returns an Iterator over the names (Strings) of all parameters present
     *
     * in this ParametersHeader.
     *
     *
     *
     * @return an Iterator over all the parameter names
     *
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.760 -0500", hash_original_method = "6E1DB232C6AA1FEC4050F87B0DECFBEC", hash_generated_method = "65E4AF5DE91728ED57E1EB67554FDA4A")
    
public Iterator<String> getParameterNames() {
        return this.uriParms.getNames();
    }

    /** Returns the value of the "ttl" parameter, or -1 if this is not set.
     * This method is equivalent to getParameter("ttl").
     *
     * @return the value of the <code>ttl</code> parameter
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.765 -0500", hash_original_method = "EE7A560BCE3AD39DE27697785FE9A0B4", hash_generated_method = "5DC10E5CD22F6A46A88A89FC8068C315")
    
public int getTTLParam() {
        Integer ttl = (Integer) uriParms.getValue("ttl");
        if (ttl != null)
            return ttl.intValue();
        else
            return -1;
    }

    /** Returns the value of the "transport" parameter, or null if this is not
     * set. This is equivalent to getParameter("transport").
     *
     * @return the transport paramter of the SipURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.769 -0500", hash_original_method = "D0FE42FB772BF560666581278B9E7996", hash_generated_method = "86AFA584DB8DF0B35D94A7A4290661D2")
    
public String getTransportParam() {
        if (uriParms != null) {
            return (String) uriParms.getValue(TRANSPORT);
        } else
            return null;
    }

    /** Returns the value of the <code>userParam</code>,
     *or null if this is not set.
     * <p>
     * This is equivalent to getParameter("user").
     *
     * @return the value of the <code>userParam</code> of the SipURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.773 -0500", hash_original_method = "3B107DCD343091F4FCEB3378B44D2024", hash_generated_method = "6B08B9AAAB1C1CB971802CA51EE1212F")
    
public String getUser() {
        return authority.getUser();
    }

    /** Returns true if this SipURI is secure i.e. if this SipURI represents a
     * sips URI. A sip URI returns false.
     *
     * @return  <code>true</code> if this SipURI represents a sips URI, and
     * <code>false</code> if it represents a sip URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.779 -0500", hash_original_method = "5246336FD52DFE5F131EDCED707C7332", hash_generated_method = "ED3C500AF22D7EC0F8DFCE04924B39D5")
    
public boolean isSecure() {
        return this.getScheme().equalsIgnoreCase(SIPS);
    }

    /** This method determines if this is a URI with a scheme of "sip" or "sips".
     *
     * @return true if the scheme is "sip" or "sips", false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.784 -0500", hash_original_method = "56D579416E6E52BEF406E20E9865D4C4", hash_generated_method = "E206BEF00DC7D59B3ECBC64D0C607341")
    
public boolean isSipURI() {
        return true;
    }

    /** Sets the value of the specified header fields to be included in a
     * request constructed from the URI. If the header already had a value it
     * will be overwritten.
     *
     * @param name - a String specifying the header name
     * @param value - a String specifying the header value
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.789 -0500", hash_original_method = "DE18AAB14C75B00C0640CE3E9515471C", hash_generated_method = "5BF345169800E2FFD384D6DA1B8960C0")
    
public void setHeader(String name, String value) {
        NameValue nv = new NameValue(name, value);
        qheaders.set(nv);

    }

    /**
     * Set the host portion of the SipURI
     *
     * @param host host to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.794 -0500", hash_original_method = "8BEE64CFFA20AF8C2536A2ECB59F51EE", hash_generated_method = "AE47CB57CE9C4A7A6032B064D0A33169")
    
public void setHost(String host) throws ParseException {
        Host h = new Host(host);
        this.setHost(h);
    }

    /** Sets the value of the <code>lr</code> parameter of this SipURI. The lr
     * parameter, when present, indicates that the element responsible for
     * this resource implements the routing mechanisms specified in RFC 3261.
     * This parameter will be used in the URIs proxies place in the
     * Record-Route header field values, and may appear in the URIs in a
     * pre-existing route set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.799 -0500", hash_original_method = "DD9F3D6DD0A955FE88B26C596147A545", hash_generated_method = "B97360C887A7F938174FEAB24E69321F")
    
public void setLrParam() {
        this.uriParms.set("lr",null);   // JvB: fixed to not add duplicates
    }

    /**
     * Sets the value of the <code>maddr</code> parameter of this SipURI. The
     * maddr parameter indicates the server address to be contacted for this
     * user, overriding any address derived from the host field. This is
     * equivalent to setParameter("maddr", maddr).
     *
     * @param  maddr New value of the <code>maddr</code> parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.802 -0500", hash_original_method = "E9B55C57ECC7FC0F2DF8B4804D377AFB", hash_generated_method = "149BAB467FDECD9C9B4CAE4B2AC0A408")
    
public void setMAddrParam(String maddr) throws ParseException {
        if (maddr == null)
            throw new NullPointerException("bad maddr");
        setParameter("maddr", maddr);
    }

    /** Sets the value of the <code>method</code> parameter. This specifies
     * which SIP method to use in requests directed at this URI. This is
     * equivalent to setParameter("method", method).
     *
     * @param  method - new value String value of the method parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.805 -0500", hash_original_method = "378F5AA5131E869E77C4B19F60BAAC21", hash_generated_method = "02F6F7679ADB179237F5249E5A8F3B28")
    
public void setMethodParam(String method) throws ParseException {
        setParameter("method", method);
    }

    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten. A zero-length String indicates flag
     *
     * parameter.
     *
     *
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - a String specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.809 -0500", hash_original_method = "B29E45FE1B913173FAF4035EBB51958B", hash_generated_method = "B1A01C9FE12E3F0EB6A143B030EF7629")
    
public void setParameter(String name, String value) throws ParseException {
        if (name.equalsIgnoreCase("ttl")) {
            try {
                Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                throw new ParseException("bad parameter " + value, 0);
            }
        }
        uriParms.set(name,value);
    }

    /** Sets the scheme of this URI to sip or sips depending on whether the
     * argument is true or false. The default value is false.
     *
     * @param secure - the boolean value indicating if the SipURI is secure.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.814 -0500", hash_original_method = "93EA8C8ECDAC523AC50E68B355F469C8", hash_generated_method = "EB21546D579EBE3159181A9CF431946C")
    
public void setSecure(boolean secure) {
        if (secure)
            this.scheme = SIPS;
        else
            this.scheme = SIP;
    }

    /** Sets the value of the <code>ttl</code> parameter. The ttl parameter
     * specifies the time-to-live value when packets are sent using UDP
     * multicast. This is equivalent to setParameter("ttl", ttl).
     *
     * @param ttl - new value of the <code>ttl</code> parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.819 -0500", hash_original_method = "8785DA0B69A8C30F98EFE6C5EB1879AC", hash_generated_method = "7C22C62870F0267AAFBA0F1D9DC5466F")
    
public void setTTLParam(int ttl) {
        if (ttl <= 0)
            throw new IllegalArgumentException("Bad ttl value");
        if (uriParms != null) {
            NameValue nv = new NameValue("ttl", Integer.valueOf(ttl));
            uriParms.set(nv);
        }
    }

    /** Sets the value of the "transport" parameter. This parameter specifies
     * which transport protocol to use for sending requests and responses to
     * this entity. The following values are defined: "udp", "tcp", "sctp",
     * "tls", but other values may be used also. This method is equivalent to
     * setParameter("transport", transport). Transport parameter constants
     * are defined in the {@link javax.sip.ListeningPoint}.
     *
     * @param transport - new value for the "transport" parameter
     * @see javax.sip.ListeningPoint
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.823 -0500", hash_original_method = "D4B3823C982965112DA168F305C25048", hash_generated_method = "67CC949E1BF328DBD8A8A59151181D4A")
    
public void setTransportParam(String transport) throws ParseException {
        if (transport == null)
            throw new NullPointerException("null arg");
        if (transport.compareToIgnoreCase("UDP") == 0
            || transport.compareToIgnoreCase("TLS") == 0
            || transport.compareToIgnoreCase("TCP") == 0
            || transport.compareToIgnoreCase("SCTP") == 0) {
            NameValue nv = new NameValue(TRANSPORT, transport.toLowerCase());
            uriParms.set(nv);
        } else
            throw new ParseException("bad transport " + transport, 0);
    }

    /** Returns the user part of this SipURI, or null if it is not set.
     *
     * @return  the user part of this SipURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.826 -0500", hash_original_method = "1E6ECA3F7C52B01B50446520797B0E33", hash_generated_method = "592D7439DF0BD2FABF65063EA9267E9B")
    
public String getUserParam() {
        return getParameter("user");

    }

    /** Returns whether the the <code>lr</code> parameter is set. This is
     * equivalent to hasParameter("lr"). This interface has no getLrParam as
     * RFC3261 does not specify any values for the "lr" paramater.
     *
     * @return true if the "lr" parameter is set, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.829 -0500", hash_original_method = "23F3E2D78AEB517CE17DC4369118F50D", hash_generated_method = "22901CDB72E9C4745CFCB1E17C33D51C")
    
public boolean hasLrParam() {
        return uriParms.getNameValue("lr") != null;
    }
  
    /**
     * Returns whether the <code>gr</code> parameter is set.
     *
     * Not part on the interface since gruu is not part of the base RFC3261.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.832 -0500", hash_original_method = "BF370972F662FF42728C27309BA84910", hash_generated_method = "C5C64ABD9C75DC1810405BCB3E1C1E02")
    
public boolean hasGrParam() {
        return uriParms.getNameValue(GRUU) != null;
    }

    /**
     * Sets the <code>gr</code> parameter.
     *
     * Not part on the interface since gruu is not part of the base RFC3261.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.834 -0500", hash_original_method = "80955EE8A827F28D322398606EB833AF", hash_generated_method = "0F86E415816F091A3DDA3D6E7696C59C")
    
public void setGrParam(String value) {
            this.uriParms.set(GRUU, value); // JvB: fixed to not add duplicates
    }

    /**
     * Sets the <code>gr</code> parameter.
     *
     * Not part on the interface since gruu is not part of the base RFC3261.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:32.837 -0500", hash_original_method = "215DF01DBB1883D8F30CF584508D27CC", hash_generated_method = "8E2E8A04F3A66CEA3D4EE2B4869C3C03")
    
public String getGrParam() {
            return (String) this.uriParms.getValue(GRUU);   // JvB: fixed to not add duplicates
    }
}

