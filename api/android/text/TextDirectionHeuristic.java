package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TextDirectionHeuristic {
     boolean isRtl(char[] text, int start, int count);
}
