package javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.Parameters;

public interface TelURL extends URI, Parameters {
    String getIsdnSubAddress();
    void setIsdnSubAddress(String isdnSubAddress) throws ParseException;

    String getPhoneContext();
    void setPhoneContext(String phoneContext) throws ParseException;

    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber) throws ParseException;

    String getPostDial();
    void setPostDial(String postDial) throws ParseException;

    boolean isGlobal();
    void setGlobal(boolean global);
}
