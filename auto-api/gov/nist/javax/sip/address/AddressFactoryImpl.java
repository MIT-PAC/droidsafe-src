package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.address.*;

public class AddressFactoryImpl implements javax.sip.address.AddressFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.350 -0400", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "BC48FF6852307C189B528CA214114244")
    @DSModeled(DSC.SAFE)
    public AddressFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.351 -0400", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "67838FAA48A37A13F1D58D4405E2D913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.Address createAddress() {
        javax.sip.address.Address var22378AA9A09030BF4A5C35EBC4D9447B_1504312209 = (new AddressImpl());
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AddressImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.351 -0400", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "4EA222DAFFC15789FC5398C7AAB3D556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        dsTaint.addTaint(displayName);
        dsTaint.addTaint(uri.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null  URI");
        AddressImpl addressImpl;
        addressImpl = new AddressImpl();
        addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null  URI");
        //AddressImpl addressImpl = new AddressImpl();
        //if (displayName != null)
            //addressImpl.setDisplayName(displayName);
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.351 -0400", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "96A19AB970C31943579CEB3969A01172")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.SipURI createSipURI(String uri) throws ParseException {
        dsTaint.addTaint(uri);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        try 
        {
            StringMsgParser smp;
            smp = new StringMsgParser();
            SipUri sipUri;
            sipUri = smp.parseSIPUrl(uri);
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        return (javax.sip.address.SipURI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null URI");
        //try {
            //StringMsgParser smp = new StringMsgParser();
            //SipUri sipUri = smp.parseSIPUrl(uri);
            //return (SipURI) sipUri;
        //} catch (ParseException ex) {
            //throw new ParseException(ex.getMessage(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.352 -0400", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "4AE8F1101498784462E7852732DBD79A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.SipURI createSipURI(String user, String host) throws ParseException {
        dsTaint.addTaint(host);
        dsTaint.addTaint(user);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null host");
        StringBuffer uriString;
        uriString = new StringBuffer("sip:");
        {
            uriString.append(user);
            uriString.append("@");
        } //End block
        {
            boolean var2FAFE57E14E8948019EC1FCC7CC0D82E_1985436446 = (host.indexOf(':') != host.lastIndexOf(':')
            && host.trim().charAt(0) != '[');
            host = '[' + host + ']';
        } //End collapsed parenthetic
        uriString.append(host);
        StringMsgParser smp;
        smp = new StringMsgParser();
        try 
        {
            SipUri sipUri;
            sipUri = smp.parseSIPUrl(uriString.toString());
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        return (javax.sip.address.SipURI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException("null host");
        //StringBuffer uriString = new StringBuffer("sip:");
        //if (user != null) {
            //uriString.append(user);
            //uriString.append("@");
        //}
        //if (host.indexOf(':') != host.lastIndexOf(':')
            //&& host.trim().charAt(0) != '[')
            //host = '[' + host + ']';
        //uriString.append(host);
        //StringMsgParser smp = new StringMsgParser();
        //try {
            //SipUri sipUri = smp.parseSIPUrl(uriString.toString());
            //return sipUri;
        //} catch (ParseException ex) {
            //throw new ParseException(ex.getMessage(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.352 -0400", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "052A21FC01693A88730CA4292D5A9A9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.TelURL createTelURL(String uri) throws ParseException {
        dsTaint.addTaint(uri);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null url");
        String telUrl;
        telUrl = "tel:" + uri;
        try 
        {
            StringMsgParser smp;
            smp = new StringMsgParser();
            TelURLImpl timp;
            timp = (TelURLImpl) smp.parseUrl(telUrl);
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        return (javax.sip.address.TelURL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null url");
        //String telUrl = "tel:" + uri;
        //try {
            //StringMsgParser smp = new StringMsgParser();
            //TelURLImpl timp = (TelURLImpl) smp.parseUrl(telUrl);
            //return (TelURL) timp;
        //} catch (ParseException ex) {
            //throw new ParseException(ex.getMessage(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.352 -0400", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "A602A08CB5BE0B5795072BDD0F74AAFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        AddressImpl addressImpl;
        addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null address");
        //AddressImpl addressImpl = new AddressImpl();
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.352 -0400", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "67517DB0C0083CA39CFD21342F371128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.Address createAddress(String address) throws java.text.ParseException {
        dsTaint.addTaint(address);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        {
            boolean var59CDB029431E23F05C0BDC176DF3E717_615228652 = (address.equals("*"));
            {
                AddressImpl addressImpl;
                addressImpl = new AddressImpl();
                addressImpl.setAddressType(AddressImpl.WILD_CARD);
                SipURI uri;
                uri = new SipUri();
                uri.setUser("*");
                addressImpl.setURI( uri );
            } //End block
            {
                StringMsgParser smp;
                smp = new StringMsgParser();
                javax.sip.address.Address varC78D2C945B18F25BBD486183F742950E_476402102 = (smp.parseAddress(address));
            } //End block
        } //End collapsed parenthetic
        return (javax.sip.address.Address)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (address == null)
            //throw new NullPointerException("null address");
        //if (address.equals("*")) {
            //AddressImpl addressImpl = new AddressImpl();
            //addressImpl.setAddressType(AddressImpl.WILD_CARD);
            //SipURI uri = new SipUri();
            //uri.setUser("*");
            //addressImpl.setURI( uri );
            //return addressImpl;
        //} else {
            //StringMsgParser smp = new StringMsgParser();
            //return smp.parseAddress(address);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.353 -0400", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "315A4613D53E01D273491717B4B537B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        dsTaint.addTaint(uri);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        try 
        {
            URLParser urlParser;
            urlParser = new URLParser(uri);
            String scheme;
            scheme = urlParser.peekScheme();
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad scheme", 0);
            {
                boolean varE2F7924392B5C383F206C4D411500B61_612414525 = (scheme.equalsIgnoreCase("sip"));
                {
                    javax.sip.address.URI var13A425262908554B9E942D3FFBF7A32D_21997045 = ((javax.sip.address.URI) urlParser.sipURL(true));
                } //End block
                {
                    boolean var1AE11AE07B613BEE507AC5604A3ABAEB_890606526 = (scheme.equalsIgnoreCase("sips"));
                    {
                        javax.sip.address.URI var93C166D2AA7B9AE21CF334952D4C9FF2_741748386 = ((javax.sip.address.URI) urlParser.sipURL(true));
                    } //End block
                    {
                        boolean var651E6735B443E1F2F7617E6D9D2AB450_896823148 = (scheme.equalsIgnoreCase("tel"));
                        {
                            javax.sip.address.URI var37A1A50DC6C33E0008AAB87185BED918_65711080 = ((javax.sip.address.URI) urlParser.telURL(true));
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        javax.sip.address.URI varC76D0DF8C889D001806F66F1995FA73E_2116803368 = (new gov.nist.javax.sip.address.GenericURI(uri));
        return (javax.sip.address.URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

