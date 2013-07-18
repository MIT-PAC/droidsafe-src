package org.apache.http.conn;

// Droidsafe Imports
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

public interface ClientConnectionManagerFactory {    

    ClientConnectionManager newInstance(
            HttpParams params, 
            SchemeRegistry schemeRegistry);

}
