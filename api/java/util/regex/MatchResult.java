package java.util.regex;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface MatchResult {

    
    int end();

    
    int end(int group);

    
    String group();

    
    String group(int group);

    
    int groupCount();

    
    int start();

    
    int start(int group);
}
