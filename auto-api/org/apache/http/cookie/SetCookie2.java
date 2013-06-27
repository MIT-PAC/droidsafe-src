package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SetCookie2 extends SetCookie {

    
    void setCommentURL(String commentURL);
    
    
    void setPorts(int[] ports);
    
    
    void setDiscard(boolean discard);
    
}
