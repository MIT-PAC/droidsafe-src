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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.053 -0400", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "BC48FF6852307C189B528CA214114244")
    public  AddressFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.061 -0400", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "7ECA99EC934A7BB3D6C422799688CFA3")
    public javax.sip.address.Address createAddress() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_267085888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_267085888 = new AddressImpl();
        varB4EAC82CA7396A68D541C85D26508E83_267085888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_267085888;
        // ---------- Original Method ----------
        //return new AddressImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.062 -0400", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "42CBF2BE131F9CFCDA6EA411861BF500")
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1614103629 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null  URI");
        AddressImpl addressImpl;
        addressImpl = new AddressImpl();
        addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
        varB4EAC82CA7396A68D541C85D26508E83_1614103629 = addressImpl;
        addTaint(displayName.getTaint());
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1614103629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1614103629;
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null  URI");
        //AddressImpl addressImpl = new AddressImpl();
        //if (displayName != null)
            //addressImpl.setDisplayName(displayName);
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.066 -0400", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "072B41AF65A8CBC0D445778765E9AA9F")
    public javax.sip.address.SipURI createSipURI(String uri) throws ParseException {
        javax.sip.address.SipURI varB4EAC82CA7396A68D541C85D26508E83_41305907 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        try 
        {
            StringMsgParser smp;
            smp = new StringMsgParser();
            SipUri sipUri;
            sipUri = smp.parseSIPUrl(uri);
            varB4EAC82CA7396A68D541C85D26508E83_41305907 = (SipURI) sipUri;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_41305907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_41305907;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.081 -0400", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "B2551853DF3130ED5012C11611E3DE4C")
    public javax.sip.address.SipURI createSipURI(String user, String host) throws ParseException {
        javax.sip.address.SipURI varB4EAC82CA7396A68D541C85D26508E83_11363646 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null host");
        StringBuffer uriString;
        uriString = new StringBuffer("sip:");
        {
            uriString.append(user);
            uriString.append("@");
        } //End block
        {
            boolean var2FAFE57E14E8948019EC1FCC7CC0D82E_725993806 = (host.indexOf(':') != host.lastIndexOf(':')
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
            varB4EAC82CA7396A68D541C85D26508E83_11363646 = sipUri;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        addTaint(user.getTaint());
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_11363646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_11363646;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.081 -0400", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "51E11A2F790AA3A4FE622474473CAA16")
    public javax.sip.address.TelURL createTelURL(String uri) throws ParseException {
        javax.sip.address.TelURL varB4EAC82CA7396A68D541C85D26508E83_366913671 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null url");
        String telUrl;
        telUrl = "tel:" + uri;
        try 
        {
            StringMsgParser smp;
            smp = new StringMsgParser();
            TelURLImpl timp;
            timp = (TelURLImpl) smp.parseUrl(telUrl);
            varB4EAC82CA7396A68D541C85D26508E83_366913671 = (TelURL) timp;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_366913671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_366913671;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.083 -0400", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "C5E02D1788CC9BABD0A1B0CF8F4BB868")
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1226646634 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        AddressImpl addressImpl;
        addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
        varB4EAC82CA7396A68D541C85D26508E83_1226646634 = addressImpl;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1226646634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226646634;
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null address");
        //AddressImpl addressImpl = new AddressImpl();
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.090 -0400", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "79452533D33606981F7A4F27383325E3")
    public javax.sip.address.Address createAddress(String address) throws java.text.ParseException {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_531022320 = null; //Variable for return #1
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_7169458 = null; //Variable for return #2
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        {
            boolean var59CDB029431E23F05C0BDC176DF3E717_1207921857 = (address.equals("*"));
            {
                AddressImpl addressImpl;
                addressImpl = new AddressImpl();
                addressImpl.setAddressType(AddressImpl.WILD_CARD);
                SipURI uri;
                uri = new SipUri();
                uri.setUser("*");
                addressImpl.setURI( uri );
                varB4EAC82CA7396A68D541C85D26508E83_531022320 = addressImpl;
            } //End block
            {
                StringMsgParser smp;
                smp = new StringMsgParser();
                varB4EAC82CA7396A68D541C85D26508E83_7169458 = smp.parseAddress(address);
            } //End block
        } //End collapsed parenthetic
        addTaint(address.getTaint());
        javax.sip.address.Address varA7E53CE21691AB073D9660D615818899_1186823555; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1186823555 = varB4EAC82CA7396A68D541C85D26508E83_531022320;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1186823555 = varB4EAC82CA7396A68D541C85D26508E83_7169458;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1186823555.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1186823555;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:29.110 -0400", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "92FBBF6FCF7EEAFFDCE5F9859D204E6B")
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_236563011 = null; //Variable for return #1
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_121887614 = null; //Variable for return #2
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_1663883151 = null; //Variable for return #3
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_168634719 = null; //Variable for return #4
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        try 
        {
            URLParser urlParser;
            urlParser = new URLParser(uri);
            String scheme;
            scheme = urlParser.peekScheme();
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad scheme", 0);
            {
                boolean varE2F7924392B5C383F206C4D411500B61_372862013 = (scheme.equalsIgnoreCase("sip"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_236563011 = (javax.sip.address.URI) urlParser.sipURL(true);
                } //End block
                {
                    boolean var1AE11AE07B613BEE507AC5604A3ABAEB_1245935039 = (scheme.equalsIgnoreCase("sips"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_121887614 = (javax.sip.address.URI) urlParser.sipURL(true);
                    } //End block
                    {
                        boolean var651E6735B443E1F2F7617E6D9D2AB450_505143494 = (scheme.equalsIgnoreCase("tel"));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1663883151 = (javax.sip.address.URI) urlParser.telURL(true);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_168634719 = new gov.nist.javax.sip.address.GenericURI(uri);
        addTaint(uri.getTaint());
        javax.sip.address.URI varA7E53CE21691AB073D9660D615818899_205123482; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_205123482 = varB4EAC82CA7396A68D541C85D26508E83_236563011;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_205123482 = varB4EAC82CA7396A68D541C85D26508E83_121887614;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_205123482 = varB4EAC82CA7396A68D541C85D26508E83_1663883151;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_205123482 = varB4EAC82CA7396A68D541C85D26508E83_168634719;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_205123482.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_205123482;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

