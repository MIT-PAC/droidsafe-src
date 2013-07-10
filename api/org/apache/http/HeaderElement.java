package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface HeaderElement {

    String getName();

    String getValue();

    NameValuePair[] getParameters();
    
    NameValuePair getParameterByName(String name);

    int getParameterCount();

    NameValuePair getParameter(int index);
}
