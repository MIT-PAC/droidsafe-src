package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.R;

public class StateSet {
    public static final int[] WILD_CARD = new int[0];
    public static final int[] NOTHING = new int[] { 0 };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.690 -0400", hash_original_method = "79AB7B9503F54BBEB1788CC595AD92D4", hash_generated_method = "3017D18085D73B5B3564A6D430C94FFB")
    @DSModeled(DSC.SAFE)
    public StateSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.690 -0400", hash_original_method = "D9DD3496C720D6870AF0B13C99983662", hash_generated_method = "A33CD97AE5E143DCA83821682B4A3FE2")
    public static boolean isWildCard(int[] stateSetOrSpec) {
        return stateSetOrSpec.length == 0 || stateSetOrSpec[0] == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.690 -0400", hash_original_method = "5B88EE78CFC8C735E181024E07BA80C7", hash_generated_method = "D166ACCB2202FA6605DF84C30040EB01")
    public static boolean stateSetMatches(int[] stateSpec, int[] stateSet) {
        if (stateSet == null) {
            return (stateSpec == null || isWildCard(stateSpec));
        }
        int stateSpecSize = stateSpec.length;
        int stateSetSize = stateSet.length;
        for (int i = 0; i < stateSpecSize; i++) {
            int stateSpecState = stateSpec[i];
            if (stateSpecState == 0) {
                return true;
            }
            final boolean mustMatch;
            if (stateSpecState > 0) {
                mustMatch = true;
            } else {
                mustMatch = false;
                stateSpecState = -stateSpecState;
            }
            boolean found = false;
            for (int j = 0; j < stateSetSize; j++) {
                final int state = stateSet[j];
                if (state == 0) {
                    if (mustMatch) {
                        return false;
                    } else {
                        break;
                    }
                }
                if (state == stateSpecState) {
                    if (mustMatch) {
                        found = true;
                        break;
                    } else {
                        return false;
                    }
                }
            }
            if (mustMatch && !found) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.690 -0400", hash_original_method = "1E9CEB0E6C412AC753472E7FDFD057DD", hash_generated_method = "459C155A510568EB507062E7703D480B")
    public static boolean stateSetMatches(int[] stateSpec, int state) {
        int stateSpecSize = stateSpec.length;
        for (int i = 0; i < stateSpecSize; i++) {
            int stateSpecState = stateSpec[i];
            if (stateSpecState == 0) {
                return true;
            }
            if (stateSpecState > 0) {
                if (state != stateSpecState) {
                   return false;
                }
            } else {
                if (state == -stateSpecState) {
                    return false;
                }
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.690 -0400", hash_original_method = "F4D8C2B12DF0FBFBD0B77F40370114EA", hash_generated_method = "186ADE6CE593FAB68FEE8D874E1CB31B")
    public static int[] trimStateSet(int[] states, int newSize) {
        if (states.length == newSize) {
            return states;
        }
        int[] trimmedStates = new int[newSize];
        System.arraycopy(states, 0, trimmedStates, 0, newSize);
        return trimmedStates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.690 -0400", hash_original_method = "440F2CE48A7851ADE7378E6EB6C06022", hash_generated_method = "4B04789FD933B47227086D20847CB49E")
    public static String dump(int[] states) {
        StringBuilder sb = new StringBuilder();
        int count = states.length;
        for (int i = 0; i < count; i++) {
            switch (states[i]) {
            case R.attr.state_window_focused:
                sb.append("W ");
                break;
            case R.attr.state_pressed:
                sb.append("P ");
                break;
            case R.attr.state_selected:
                sb.append("S ");
                break;
            case R.attr.state_focused:
                sb.append("F ");
                break;
            case R.attr.state_enabled:
                sb.append("E ");
                break;
            }
        }
        return sb.toString();
    }

    
}


