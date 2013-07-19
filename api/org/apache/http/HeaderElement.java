package org.apache.http;

// Droidsafe Imports

public interface HeaderElement {

    String getName();

    String getValue();

    NameValuePair[] getParameters();
    
    NameValuePair getParameterByName(String name);

    int getParameterCount();

    NameValuePair getParameter(int index);
}
