package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.address.Address;

public interface HeaderAddress {
    Address getAddress();
    void setAddress(Address address);
}
