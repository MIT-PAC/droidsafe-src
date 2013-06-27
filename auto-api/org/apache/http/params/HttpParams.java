package org.apache.http.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface HttpParams {

    
    Object getParameter(String name);

    
    HttpParams setParameter(String name, Object value);

    
    HttpParams copy();
    
    
    boolean removeParameter(String name);

    
    long getLongParameter(String name, long defaultValue);

     
    HttpParams setLongParameter(String name, long value);

    
    int getIntParameter(String name, int defaultValue);

     
    HttpParams setIntParameter(String name, int value);

    
    double getDoubleParameter(String name, double defaultValue);

     
    HttpParams setDoubleParameter(String name, double value);

    
    boolean getBooleanParameter(String name, boolean defaultValue);

     
    HttpParams setBooleanParameter(String name, boolean value);

    
    boolean isParameterTrue(String name);

    
    boolean isParameterFalse(String name);

}
