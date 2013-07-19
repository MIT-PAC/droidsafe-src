package android.text;

// Droidsafe Imports

public interface TextDirectionHeuristic {
     boolean isRtl(char[] text, int start, int count);
}
