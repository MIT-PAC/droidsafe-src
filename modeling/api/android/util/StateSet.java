package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.R;

public class StateSet {

    /**
     * Return whether the stateSetOrSpec is matched by all StateSets.
     *
     * @param stateSetOrSpec a state set or state spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.374 -0500", hash_original_method = "D9DD3496C720D6870AF0B13C99983662", hash_generated_method = "A33CD97AE5E143DCA83821682B4A3FE2")
    
public static boolean isWildCard(int[] stateSetOrSpec) {
        return stateSetOrSpec.length == 0 || stateSetOrSpec[0] == 0;
    }

    /**
     * Return whether the stateSet matches the desired stateSpec.
     *
     * @param stateSpec an array of required (if positive) or
     *        prohibited (if negative) {@link android.view.View} states.
     * @param stateSet an array of {@link android.view.View} states
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.376 -0500", hash_original_method = "5B88EE78CFC8C735E181024E07BA80C7", hash_generated_method = "208C9AE8277836D87A163F35AC278E5D")
    
public static boolean stateSetMatches(int[] stateSpec, int[] stateSet) {
        if (stateSet == null) {
            return (stateSpec == null || isWildCard(stateSpec));
        }
        int stateSpecSize = stateSpec.length;
        int stateSetSize = stateSet.length;
        for (int i = 0; i < stateSpecSize; i++) {
            int stateSpecState = stateSpec[i];
            if (stateSpecState == 0) {
                // We've reached the end of the cases to match against.
                return true;
            }
            final boolean mustMatch;
            if (stateSpecState > 0) {
                mustMatch = true;
            } else {
                // We use negative values to indicate must-NOT-match states.
                mustMatch = false;
                stateSpecState = -stateSpecState;
            }
            boolean found = false;
            for (int j = 0; j < stateSetSize; j++) {
                final int state = stateSet[j];
                if (state == 0) {
                    // We've reached the end of states to match.
                    if (mustMatch) {
                        // We didn't find this must-match state.
                        return false;
                    } else {
                        // Continue checking other must-not-match states.
                        break;
                    }
                }
                if (state == stateSpecState) {
                    if (mustMatch) {
                        found = true;
                        // Continue checking other other must-match states.
                        break;
                    } else {
                        // Any match of a must-not-match state returns false.
                        return false;
                    }
                }
            }
            if (mustMatch && !found) {
                // We've reached the end of states to match and we didn't
                // find a must-match state.
                return false;
            }
        }
        return true;
    }

    /**
     * Return whether the state matches the desired stateSpec.
     *
     * @param stateSpec an array of required (if positive) or
     *        prohibited (if negative) {@link android.view.View} states.
     * @param state a {@link android.view.View} state
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.379 -0500", hash_original_method = "1E9CEB0E6C412AC753472E7FDFD057DD", hash_generated_method = "4B2365B4FEF06CC32036F5F5B1C16B06")
    
public static boolean stateSetMatches(int[] stateSpec, int state) {
        int stateSpecSize = stateSpec.length;
        for (int i = 0; i < stateSpecSize; i++) {
            int stateSpecState = stateSpec[i];
            if (stateSpecState == 0) {
                // We've reached the end of the cases to match against.
                return true;
            }
            if (stateSpecState > 0) {
                if (state != stateSpecState) {
                   return false;
                }
            } else {
                // We use negative values to indicate must-NOT-match states.
                if (state == -stateSpecState) {
                    // We matched a must-not-match case.
                    return false;
                }
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.382 -0500", hash_original_method = "F4D8C2B12DF0FBFBD0B77F40370114EA", hash_generated_method = "186ADE6CE593FAB68FEE8D874E1CB31B")
    
public static int[] trimStateSet(int[] states, int newSize) {
        if (states.length == newSize) {
            return states;
        }

        int[] trimmedStates = new int[newSize];
        System.arraycopy(states, 0, trimmedStates, 0, newSize);
        return trimmedStates;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.384 -0500", hash_original_method = "440F2CE48A7851ADE7378E6EB6C06022", hash_generated_method = "4B04789FD933B47227086D20847CB49E")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.369 -0500", hash_original_field = "79D0C37080C510F8FE894AED6839F7EB", hash_generated_field = "BBCDB5A3ADE5DE7629B847ADCE0E35A0")

    public static final int[] WILD_CARD = new int[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.371 -0500", hash_original_field = "7089E518E3F996A9D873AB431350B75E", hash_generated_field = "FAD61E8722399A25F2FC6B2DDAC2CAD2")

    public static final int[] NOTHING = new int[] { 0 };
    /** @hide */ @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.366 -0500", hash_original_method = "79AB7B9503F54BBEB1788CC595AD92D4", hash_generated_method = "488F22D2CBEC08C5F9781ED20E8E125F")
    
public StateSet() {}
}

