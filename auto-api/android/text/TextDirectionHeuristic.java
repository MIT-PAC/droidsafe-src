package android.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface TextDirectionHeuristic {
     boolean isRtl(char[] text, int start, int count);
}
