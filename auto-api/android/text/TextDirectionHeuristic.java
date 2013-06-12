package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface TextDirectionHeuristic {
     boolean isRtl(char[] text, int start, int count);
}

