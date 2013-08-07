package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HeaderElement {

    String getName();

    String getValue();

    NameValuePair[] getParameters();
    
    NameValuePair getParameterByName(String name);

    int getParameterCount();

    NameValuePair getParameter(int index);
}
