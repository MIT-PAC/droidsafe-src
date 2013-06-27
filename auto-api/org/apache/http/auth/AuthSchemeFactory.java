package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.params.HttpParams;

public interface AuthSchemeFactory {    

    AuthScheme newInstance(HttpParams params);

}
