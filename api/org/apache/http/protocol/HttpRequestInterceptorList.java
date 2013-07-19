package org.apache.http.protocol;

// Droidsafe Imports
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
