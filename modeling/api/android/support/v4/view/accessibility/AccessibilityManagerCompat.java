/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.v4.view.accessibility;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge;
import android.view.accessibility.AccessibilityManager;

import java.util.Collections;
import java.util.List;

/**
 * Helper for accessing features in {@link AccessibilityManager}
 * introduced after API level 4 in a backwards compatible fashion.
 */
public class AccessibilityManagerCompat {

    interface AccessibilityManagerVersionImpl {
        public Object newAccessiblityStateChangeListener(
                AccessibilityStateChangeListenerCompat listener);
        public boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener);
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener);
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
                AccessibilityManager manager,int feedbackTypeFlags);
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
                AccessibilityManager manager);
        public boolean isTouchExplorationEnabled(AccessibilityManager manager);
    }

    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.732 -0500", hash_original_method = "7D59B8882263E438CB4361275EA728A2", hash_generated_method = "5BE5C5B37C8535D1E43838A444F7AAC9")
        
public Object newAccessiblityStateChangeListener(
                AccessibilityStateChangeListenerCompat listener) {
            return null;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.734 -0500", hash_original_method = "33A1F684547BED5D3B48AAD04779CA50", hash_generated_method = "E86C8C67EFCF91393C4D8B024DEC279D")
        
public boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.735 -0500", hash_original_method = "3EC1834EAD9521199DD8CC1AEEEE93EE", hash_generated_method = "CDD35DD8173F3CBB4397B64559E0A34F")
        
public boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener) {
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.736 -0500", hash_original_method = "0B155E7439E18F95389B186D3A0B1547", hash_generated_method = "EFAAB99040A105AA6026A7BB2FBA2141")
        
public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
                AccessibilityManager manager, int feedbackTypeFlags) {
            return Collections.emptyList();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.737 -0500", hash_original_method = "1B9F4BA5149600AFD41B481B12F75C04", hash_generated_method = "A6FB6AE9C32F6C4C218DE60F99CFCCBC")
        
public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
                AccessibilityManager manager) {
            return Collections.emptyList();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.738 -0500", hash_original_method = "D41A4A15681F6206C5A89225952F89E0", hash_generated_method = "E3E790F946DAB4A915FF178C43B77FA3")
        
public boolean isTouchExplorationEnabled(AccessibilityManager manager) {
            return false;
        }
    }

    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.743 -0500", hash_original_method = "9605D56F845E05772D756797E8C103EB", hash_generated_method = "10832E3213B6323E21E6084561AA9C6B")
        
@Override
        public Object newAccessiblityStateChangeListener(
                final AccessibilityStateChangeListenerCompat listener) {
            return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(
                new AccessibilityStateChangeListenerBridge() {
                    @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:36.601 -0500", hash_original_method = "706B1DB534372D0F01F68C0278EBDA59", hash_generated_method = "9331EEE62D2F77566EE62384C10B1567")
                
public void onAccessibilityStateChanged(boolean enabled) {
                        listener.onAccessibilityStateChanged(enabled);
                    }
                });
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.745 -0500", hash_original_method = "DDED9713E60FF2ACC487AE68FB5B1EF0", hash_generated_method = "5D0285AD964A874B0722C317AC598079")
        
@Override
        public boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
                AccessibilityStateChangeListenerCompat listener) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(manager,
                    listener.mListener);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.747 -0500", hash_original_method = "7219CB250AC0A0DE22055706F7853760", hash_generated_method = "C365E9F4FE5909B2ED27FE73F1BA14F3")
        
@Override
        public boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
                final AccessibilityStateChangeListenerCompat listener) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(manager,
                    listener.mListener);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.749 -0500", hash_original_method = "45A7C83CCFEDDE0EAF6164AEE534859C", hash_generated_method = "FF1A0BC9FD950CB8652AD6647FF5103F")
        
@Override
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
                AccessibilityManager manager, int feedbackTypeFlags) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(manager,
                    feedbackTypeFlags);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.751 -0500", hash_original_method = "024643C1E057DD1DCC44ABD9C44E9BD0", hash_generated_method = "F5D17976DD550833087CD08C261DE174")
        
@Override
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
                AccessibilityManager manager) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(manager);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.752 -0500", hash_original_method = "BFE7EE6F020C3B9F8FFE4E032E4A4E03", hash_generated_method = "C679F5D0F0906EF8A60CFAD540C962F3")
        
@Override
        public boolean isTouchExplorationEnabled(AccessibilityManager manager) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(manager);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) { // ICS
            IMPL = new AccessibilityManagerIcsImpl();
        } else {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.757 -0500", hash_original_field = "B87EEC05DAFC17C0065D438877226C06", hash_generated_field = "11030A36D1F404B868FA2500FC50C900")

    private static  AccessibilityManagerVersionImpl IMPL;

    /**
     * Registers an {@link AccessibilityManager.AccessibilityStateChangeListener} for changes in
     * the global accessibility state of the system.
     *
     * @param manager The accessibility manager.
     * @param listener The listener.
     * @return True if successfully registered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.758 -0500", hash_original_method = "FEAC8E30E4AA4A2D9D117503F9844D6A", hash_generated_method = "857E31614DE2C196FC18DA37EC2A91F6")
    
public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager,
            AccessibilityStateChangeListenerCompat listener) {
        return IMPL.addAccessibilityStateChangeListener(manager, listener);
    }

    /**
     * Unregisters an {@link AccessibilityManager.AccessibilityStateChangeListener}.
     *
     * @param manager The accessibility manager.
     * @param listener The listener.
     * @return True if successfully unregistered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.760 -0500", hash_original_method = "85D1977120BF894DB6D502E802751A51", hash_generated_method = "5094E87C679446776BE2E4EBCCB14803")
    
public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager,
            AccessibilityStateChangeListenerCompat listener) {
        return IMPL.removeAccessibilityStateChangeListener(manager, listener);
    }

    /**
     * Returns the {@link AccessibilityServiceInfo}s of the installed accessibility services.
     *
     * @param manager The accessibility manager.
     * @return An unmodifiable list with {@link AccessibilityServiceInfo}s.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.761 -0500", hash_original_method = "F41A17C251437712742AB7874160E4E3", hash_generated_method = "7C9B457519F535F60902B740864C70FC")
    
public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(
            AccessibilityManager manager) {
        return IMPL.getInstalledAccessibilityServiceList(manager);
    }

    /**
     * Returns the {@link AccessibilityServiceInfo}s of the enabled accessibility services
     * for a given feedback type.
     *
     * @param manager The accessibility manager.
     * @param feedbackTypeFlags The feedback type flags.
     * @return An unmodifiable list with {@link AccessibilityServiceInfo}s.
     *
     * @see AccessibilityServiceInfo#FEEDBACK_AUDIBLE
     * @see AccessibilityServiceInfo#FEEDBACK_GENERIC
     * @see AccessibilityServiceInfo#FEEDBACK_HAPTIC
     * @see AccessibilityServiceInfo#FEEDBACK_SPOKEN
     * @see AccessibilityServiceInfo#FEEDBACK_VISUAL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.762 -0500", hash_original_method = "C5E8FD744480C4BD4219B45DB8567ACA", hash_generated_method = "6CB3607DFE8859269F28F410A4A000CF")
    
public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            AccessibilityManager manager, int feedbackTypeFlags) {
        return IMPL.getEnabledAccessibilityServiceList(manager, feedbackTypeFlags);
    }

    /**
     * Returns if the touch exploration in the system is enabled.
     *
     * @param manager The accessibility manager.
     * @return True if touch exploration is enabled, false otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.763 -0500", hash_original_method = "081A6C993311DD0069AD71C21860A0A0", hash_generated_method = "E83D58A36641645BA5F51FDC97DF960D")
    
public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return IMPL.isTouchExplorationEnabled(manager);
    }

    /**
     * Listener for the accessibility state.
     */
    public static abstract class AccessibilityStateChangeListenerCompat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.765 -0500", hash_original_field = "6298872A0C122A375C2BF0CC5B8647C6", hash_generated_field = "6298872A0C122A375C2BF0CC5B8647C6")

         Object mListener;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.766 -0500", hash_original_method = "FA0620266C265FA0D90FCFE5DA96B3B2", hash_generated_method = "258522D982E7FA16C9311C52D349CD01")
        
public AccessibilityStateChangeListenerCompat() {
            mListener = IMPL.newAccessiblityStateChangeListener(this);
        }

        /**
         * Called back on change in the accessibility state.
         *
         * @param enabled Whether accessibility is enabled.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:54:22.767 -0500", hash_original_method = "6804C344279CBDCCA29C6F05BBCCE672", hash_generated_method = "2D31C1D817B2CF3EE1D7D8C79CD3A20D")
        
public abstract void onAccessibilityStateChanged(boolean enabled);
    }
}
