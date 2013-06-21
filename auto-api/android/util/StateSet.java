package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;

public class StateSet {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.382 -0400", hash_original_method = "79AB7B9503F54BBEB1788CC595AD92D4", hash_generated_method = "8101277388431BDA9DE6F2CA5C72C0FA")
    @DSModeled(DSC.SAFE)
    public StateSet() {
        // ---------- Original Method ----------
    }

    
        public static boolean isWildCard(int[] stateSetOrSpec) {
        return stateSetOrSpec.length == 0 || stateSetOrSpec[0] == 0;
    }

    
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

    
        public static int[] trimStateSet(int[] states, int newSize) {
        if (states.length == newSize) {
            return states;
        }
        int[] trimmedStates = new int[newSize];
        System.arraycopy(states, 0, trimmedStates, 0, newSize);
        return trimmedStates;
    }

    
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

    
    public static final int[] WILD_CARD = new int[0];
    public static final int[] NOTHING = new int[] { 0 };
}

