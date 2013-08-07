package android.text;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface TextDirectionHeuristic {
     boolean isRtl(char[] text, int start, int count);
}
