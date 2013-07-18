package org.apache.http.protocol;

// Droidsafe Imports
import java.util.List;

import org.apache.http.HttpResponseInterceptor;

public interface HttpResponseInterceptorList {

    
    void addResponseInterceptor(HttpResponseInterceptor itcp)
        ;

    
    void addResponseInterceptor(HttpResponseInterceptor itcp, int index);
    
    
    
    int getResponseInterceptorCount()
        ;


    
    HttpResponseInterceptor getResponseInterceptor(int index)
        ;


    
    void clearResponseInterceptors()
        ;

    
    
    void removeResponseInterceptorByClass(Class clazz);

    
    
    void setInterceptors(List itcps)
        ;


}
