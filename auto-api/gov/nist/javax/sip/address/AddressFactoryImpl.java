package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.address.*;

public class AddressFactoryImpl implements javax.sip.address.AddressFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.115 -0400", hash_original_method = "5EAE66D49E862BAEE0E410CA69871D83", hash_generated_method = "BC48FF6852307C189B528CA214114244")
    public  AddressFactoryImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.115 -0400", hash_original_method = "BCAEEC1C0FA5608D92211F34DF6950F5", hash_generated_method = "26578CEE0AABD0419499BD716CD62428")
    public javax.sip.address.Address createAddress() {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_858854630 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_858854630 = new AddressImpl();
        varB4EAC82CA7396A68D541C85D26508E83_858854630.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_858854630;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.116 -0400", hash_original_method = "8ECE0FD94D831C743ACA34A8ACB9471A", hash_generated_method = "DE5A9C5153FD70462D4DE9C358DC3B74")
    public javax.sip.address.Address createAddress(
        String displayName,
        javax.sip.address.URI uri) {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1088158142 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null  URI");
        AddressImpl addressImpl = new AddressImpl();
        addressImpl.setDisplayName(displayName);
        addressImpl.setURI(uri);
        varB4EAC82CA7396A68D541C85D26508E83_1088158142 = addressImpl;
        addTaint(displayName.getTaint());
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1088158142.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1088158142;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.116 -0400", hash_original_method = "606F4ADF8EBB5ECDC152643EADDC0AC8", hash_generated_method = "E0C93E3A81BDB3079044FF1C1F989A30")
    public javax.sip.address.SipURI createSipURI(String uri) throws ParseException {
        javax.sip.address.SipURI varB4EAC82CA7396A68D541C85D26508E83_246671450 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null URI");
        try 
        {
            StringMsgParser smp = new StringMsgParser();
            SipUri sipUri = smp.parseSIPUrl(uri);
            varB4EAC82CA7396A68D541C85D26508E83_246671450 = (SipURI) sipUri;
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } 
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_246671450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_246671450;
        
        
            
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.118 -0400", hash_original_method = "97FF8506F533416A8B40E097933B45CB", hash_generated_method = "62140B07867936C67873DA37A58C9F3B")
    public javax.sip.address.SipURI createSipURI(String user, String host) throws ParseException {
        javax.sip.address.SipURI varB4EAC82CA7396A68D541C85D26508E83_1619136729 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null host");
        StringBuffer uriString = new StringBuffer("sip:");
        {
            uriString.append(user);
            uriString.append("@");
        } 
        {
            boolean var2FAFE57E14E8948019EC1FCC7CC0D82E_1402200150 = (host.indexOf(':') != host.lastIndexOf(':')
            && host.trim().charAt(0) != '[');
            host = '[' + host + ']';
        } 
        uriString.append(host);
        StringMsgParser smp = new StringMsgParser();
        try 
        {
            SipUri sipUri = smp.parseSIPUrl(uriString.toString());
            varB4EAC82CA7396A68D541C85D26508E83_1619136729 = sipUri;
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } 
        addTaint(user.getTaint());
        addTaint(host.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1619136729.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1619136729;
        
        
            
        
        
            
            
        
        
            
            
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.119 -0400", hash_original_method = "D04D6AFFDB458F909DE8ED46FFEF9C7A", hash_generated_method = "DB876E4A87C04A29BD3C3A5EBE762693")
    public javax.sip.address.TelURL createTelURL(String uri) throws ParseException {
        javax.sip.address.TelURL varB4EAC82CA7396A68D541C85D26508E83_1799895269 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null url");
        String telUrl = "tel:" + uri;
        try 
        {
            StringMsgParser smp = new StringMsgParser();
            TelURLImpl timp = (TelURLImpl) smp.parseUrl(telUrl);
            varB4EAC82CA7396A68D541C85D26508E83_1799895269 = (TelURL) timp;
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } 
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1799895269.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1799895269;
        
        
            
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.120 -0400", hash_original_method = "5762E0D071920DC6C61FB0E25B45CBE7", hash_generated_method = "F012D386CDE9E2460C5FFB99AC47BD91")
    public javax.sip.address.Address createAddress(javax.sip.address.URI uri) {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_2006972670 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        AddressImpl addressImpl = new AddressImpl();
        addressImpl.setURI(uri);
        varB4EAC82CA7396A68D541C85D26508E83_2006972670 = addressImpl;
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2006972670.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2006972670;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.121 -0400", hash_original_method = "9FCBFE264C415F40E8FC1E843482D494", hash_generated_method = "91565ECFD3EC877FBB058DB4DE59A163")
    public javax.sip.address.Address createAddress(String address) throws java.text.ParseException {
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1729787401 = null; 
        javax.sip.address.Address varB4EAC82CA7396A68D541C85D26508E83_1632600199 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null address");
        {
            boolean var59CDB029431E23F05C0BDC176DF3E717_1091157282 = (address.equals("*"));
            {
                AddressImpl addressImpl = new AddressImpl();
                addressImpl.setAddressType(AddressImpl.WILD_CARD);
                SipURI uri = new SipUri();
                uri.setUser("*");
                addressImpl.setURI( uri );
                varB4EAC82CA7396A68D541C85D26508E83_1729787401 = addressImpl;
            } 
            {
                StringMsgParser smp = new StringMsgParser();
                varB4EAC82CA7396A68D541C85D26508E83_1632600199 = smp.parseAddress(address);
            } 
        } 
        addTaint(address.getTaint());
        javax.sip.address.Address varA7E53CE21691AB073D9660D615818899_464440974; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_464440974 = varB4EAC82CA7396A68D541C85D26508E83_1729787401;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_464440974 = varB4EAC82CA7396A68D541C85D26508E83_1632600199;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_464440974.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_464440974;
        
        
            
        
            
            
            
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.122 -0400", hash_original_method = "6FB194DE255E537B19EA8E2695800E2E", hash_generated_method = "9A30E615A05DA7A2B525C97F4FADE42C")
    public javax.sip.address.URI createURI(String uri) throws ParseException {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_1052709301 = null; 
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_300205395 = null; 
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_257315134 = null; 
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_1570371443 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        try 
        {
            URLParser urlParser = new URLParser(uri);
            String scheme = urlParser.peekScheme();
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad scheme", 0);
            {
                boolean varE2F7924392B5C383F206C4D411500B61_1113996360 = (scheme.equalsIgnoreCase("sip"));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1052709301 = (javax.sip.address.URI) urlParser.sipURL(true);
                } 
                {
                    boolean var1AE11AE07B613BEE507AC5604A3ABAEB_354037378 = (scheme.equalsIgnoreCase("sips"));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_300205395 = (javax.sip.address.URI) urlParser.sipURL(true);
                    } 
                    {
                        boolean var651E6735B443E1F2F7617E6D9D2AB450_1843051836 = (scheme.equalsIgnoreCase("tel"));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_257315134 = (javax.sip.address.URI) urlParser.telURL(true);
                        } 
                    } 
                } 
            } 
        } 
        catch (ParseException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(ex.getMessage(), 0);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1570371443 = new gov.nist.javax.sip.address.GenericURI(uri);
        addTaint(uri.getTaint());
        javax.sip.address.URI varA7E53CE21691AB073D9660D615818899_1912025407; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1912025407 = varB4EAC82CA7396A68D541C85D26508E83_1052709301;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1912025407 = varB4EAC82CA7396A68D541C85D26508E83_300205395;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1912025407 = varB4EAC82CA7396A68D541C85D26508E83_257315134;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1912025407 = varB4EAC82CA7396A68D541C85D26508E83_1570371443;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1912025407.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1912025407;
        
        
    }

    
}

