package javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public interface AddressFactory {
    Address createAddress();
    Address createAddress(String address) throws ParseException;
    Address createAddress(URI uri);
    Address createAddress(String displayName, URI uri)
            throws ParseException;
    SipURI createSipURI(String uri) throws ParseException;
    SipURI createSipURI(String user, String host) throws ParseException;
    TelURL createTelURL(String uri) throws ParseException;
    URI createURI(String uri) throws ParseException;
}
