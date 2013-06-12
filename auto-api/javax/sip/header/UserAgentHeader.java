package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.text.ParseException;
import java.util.List;
import java.util.ListIterator;

public interface UserAgentHeader extends Header {
    String NAME = "User-Agent";

    ListIterator getProduct();
    void setProduct(List product) throws ParseException;
    void addProductToken(String productToken);
}

