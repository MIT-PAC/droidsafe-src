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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.366 -0400", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "BC48FF6852307C189B528CA214114244")
    public  AddressFactoryImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.367 -0400", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "773FE0869D493D1F33E0C988C99E859F")
    public javax.sip.address.Address createAddress() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_856767092 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_856767092 = new AddressImpl();
        varB4EAC82CA7396A68D541C85D26508E83_856767092.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856767092;
        // ---------- Original Method ----------
        //return new AddressImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.367 -0400", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "7B8F84E1E9B51E0547DC990DAAF75265")
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1617328002 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null  URI");
        AddressImpl addressImpl;
        addressImpl = new AddressImpl();
        addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
        varB4EAC82CA7396A68D541C85D26508E83_1617328002 = addressImpl;
        addTaint(displayName.getTaint());
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1617328002.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1617328002;
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null  URI");
        //AddressImpl addressImpl = new AddressImpl();
        //if (displayName != null)
            //addressImpl.setDisplayName(displayName);
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.368 -0400", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "2AF9778A13C5993B0671637FBFA424F4")
    public javax.sip.address.SipURI createSipURI(String uri) throws ParseException {
        javax.sip.address.SipURI varB4EAC82CA7396A68D541C85D26508E83_271597841 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        try 
        {
            StringMsgParser smp;
            smp = new StringMsgParser();
            SipUri sipUri;
            sipUri = smp.parseSIPUrl(uri);
            varB4EAC82CA7396A68D541C85D26508E83_271597841 = (SipURI) sipUri;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_271597841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_271597841;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.374 -0400", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "335ED3B0981F154B5F1C8187BE3B7FDD")
    public javax.sip.address.SipURI createSipURI(String user, String host) throws ParseException {
        javax.sip.address.SipURI varB4EAC82CA7396A68D541C85D26508E83_81389891 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null host");
        StringBuffer uriString;
        uriString = new StringBuffer("sip:");
        {
            uriString.append(user);
            uriString.append("@");
        } //End block
        {
            boolean var2FAFE57E14E8948019EC1FCC7CC0D82E_14195133 = (host.indexOf(':') != host.lastIndexOf(':')
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
            varB4EAC82CA7396A68D541C85D26508E83_81389891 = sipUri;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        addTaint(user.getTaint());
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_81389891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_81389891;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.417 -0400", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "5F1694E53857CF805755CB5A779BFAAE")
    public javax.sip.address.TelURL createTelURL(String uri) throws ParseException {
        javax.sip.address.TelURL varB4EAC82CA7396A68D541C85D26508E83_1076546291 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null url");
        String telUrl;
        telUrl = "tel:" + uri;
        try 
        {
            StringMsgParser smp;
            smp = new StringMsgParser();
            TelURLImpl timp;
            timp = (TelURLImpl) smp.parseUrl(telUrl);
            varB4EAC82CA7396A68D541C85D26508E83_1076546291 = (TelURL) timp;
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1076546291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076546291;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.418 -0400", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "240EC84190485FBB53A8E3CCF6046642")
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_336394467 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        AddressImpl addressImpl;
        addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
        varB4EAC82CA7396A68D541C85D26508E83_336394467 = addressImpl;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_336394467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_336394467;
        // ---------- Original Method ----------
        //if (uri == null)
            //throw new NullPointerException("null address");
        //AddressImpl addressImpl = new AddressImpl();
        //addressImpl.setURI(uri);
        //return addressImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.419 -0400", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "1093660EC95F276CE3206385548A1595")
    public javax.sip.address.Address createAddress(String address) throws java.text.ParseException {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1161394110 = null; //Variable for return #1
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1791027046 = null; //Variable for return #2
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        {
            boolean var59CDB029431E23F05C0BDC176DF3E717_750579534 = (address.equals("*"));
            {
                AddressImpl addressImpl;
                addressImpl = new AddressImpl();
                addressImpl.setAddressType(AddressImpl.WILD_CARD);
                SipURI uri;
                uri = new SipUri();
                uri.setUser("*");
                addressImpl.setURI( uri );
                varB4EAC82CA7396A68D541C85D26508E83_1161394110 = addressImpl;
            } //End block
            {
                StringMsgParser smp;
                smp = new StringMsgParser();
                varB4EAC82CA7396A68D541C85D26508E83_1791027046 = smp.parseAddress(address);
            } //End block
        } //End collapsed parenthetic
        addTaint(address.getTaint());
        javax.sip.address.Address varA7E53CE21691AB073D9660D615818899_1908313655; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1908313655 = varB4EAC82CA7396A68D541C85D26508E83_1161394110;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1908313655 = varB4EAC82CA7396A68D541C85D26508E83_1791027046;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1908313655.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1908313655;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.421 -0400", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "ED8FA729FF4208ACC2D2821C9267B215")
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_2136535903 = null; //Variable for return #1
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_371552332 = null; //Variable for return #2
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_525870188 = null; //Variable for return #3
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_867371405 = null; //Variable for return #4
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        try 
        {
            URLParser urlParser;
            urlParser = new URLParser(uri);
            String scheme;
            scheme = urlParser.peekScheme();
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad scheme", 0);
            {
                boolean varE2F7924392B5C383F206C4D411500B61_671256198 = (scheme.equalsIgnoreCase("sip"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2136535903 = (javax.sip.address.URI) urlParser.sipURL(true);
                } //End block
                {
                    boolean var1AE11AE07B613BEE507AC5604A3ABAEB_576071586 = (scheme.equalsIgnoreCase("sips"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_371552332 = (javax.sip.address.URI) urlParser.sipURL(true);
                    } //End block
                    {
                        boolean var651E6735B443E1F2F7617E6D9D2AB450_520762556 = (scheme.equalsIgnoreCase("tel"));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_525870188 = (javax.sip.address.URI) urlParser.telURL(true);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_867371405 = new gov.nist.javax.sip.address.GenericURI(uri);
        addTaint(uri.getTaint());
        javax.sip.address.URI varA7E53CE21691AB073D9660D615818899_1237490815; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1237490815 = varB4EAC82CA7396A68D541C85D26508E83_2136535903;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1237490815 = varB4EAC82CA7396A68D541C85D26508E83_371552332;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1237490815 = varB4EAC82CA7396A68D541C85D26508E83_525870188;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1237490815 = varB4EAC82CA7396A68D541C85D26508E83_867371405;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1237490815.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1237490815;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

