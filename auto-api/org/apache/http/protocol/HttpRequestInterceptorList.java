package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpRequestInterceptor;

public interface HttpRequestInterceptorList {

    
    void addRequestInterceptor(HttpRequestInterceptor itcp)
        ;


    
    void addRequestInterceptor(HttpRequestInterceptor itcp, int index);
    
    
    
    int getRequestInterceptorCount()
        ;


    
    HttpRequestInterceptor getRequestInterceptor(int index)
        ;


    
    void clearRequestInterceptors()
        ;


    
    void removeRequestInterceptorByClass(Class clazz);
    
    
    
    void setInterceptors(List itcps)
        ;


}
