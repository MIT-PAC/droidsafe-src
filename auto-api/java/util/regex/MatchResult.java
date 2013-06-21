package java.util.regex;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface MatchResult {

    
    int end();

    
    int end(int group);

    
    String group();

    
    String group(int group);

    
    int groupCount();

    
    int start();

    
    int start(int group);
}
