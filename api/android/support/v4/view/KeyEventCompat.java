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

package android.support.v4.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.view.KeyEvent;
import android.view.View;

/**
 * Helper for accessing features in {@link KeyEvent} introduced after
 * API level 4 in a backwards compatible fashion.
 */
public class KeyEventCompat {
    /**
     * Interface for the full API.
     */
    interface KeyEventVersionImpl {
        public int normalizeMetaState(int metaState);
        public boolean metaStateHasModifiers(int metaState, int modifiers);
        public boolean metaStateHasNoModifiers(int metaState);
        public void startTracking(KeyEvent event);
        public boolean isTracking(KeyEvent event);
        public Object getKeyDispatcherState(View view);
        public boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state,
                    Object target);
    }

    /**
     * Interface implementation that doesn't use anything about v4 APIs.
     */
    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_MODIFIER_MASK =
                KeyEvent.META_SHIFT_ON | KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON
                | KeyEvent.META_ALT_ON | KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON
                | KeyEvent.META_SYM_ON;

        // Mask of all lock key meta states.
        private static final int META_ALL_MASK = META_MODIFIER_MASK;

        private static int metaStateFilterDirectionalModifiers(int metaState,
                int modifiers, int basic, int left, int right) {
            final boolean wantBasic = (modifiers & basic) != 0;
            final int directional = left | right;
            final boolean wantLeftOrRight = (modifiers & directional) != 0;

            if (wantBasic) {
                if (wantLeftOrRight) {
                    throw new IllegalArgumentException("bad arguments");
                }
                return metaState & ~directional;
            } else if (wantLeftOrRight) {
                return metaState & ~basic;
            } else {
                return metaState;
            }
        }

        @Override
        public int normalizeMetaState(int metaState) {
            if ((metaState & (KeyEvent.META_SHIFT_LEFT_ON | KeyEvent.META_SHIFT_RIGHT_ON)) != 0) {
                metaState |= KeyEvent.META_SHIFT_ON;
            }
            if ((metaState & (KeyEvent.META_ALT_LEFT_ON | KeyEvent.META_ALT_RIGHT_ON)) != 0) {
                metaState |= KeyEvent.META_ALT_ON;
            }
            return metaState & META_ALL_MASK;
        }
 
        @Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            metaState = normalizeMetaState(metaState) & META_MODIFIER_MASK;
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_SHIFT_ON, KeyEvent.META_SHIFT_LEFT_ON, KeyEvent.META_SHIFT_RIGHT_ON);
            metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                    KeyEvent.META_ALT_ON, KeyEvent.META_ALT_LEFT_ON, KeyEvent.META_ALT_RIGHT_ON);
            return metaState == modifiers;
        }

        @Override
        public boolean metaStateHasNoModifiers(int metaState) {
            return (normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0;
        }

        @Override
        public void startTracking(KeyEvent event) {
        }

        @Override
        public boolean isTracking(KeyEvent event) {
            return false;
        }

        @Override
        public Object getKeyDispatcherState(View view) {
            return null;
        }

        @Override
        public boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state,
                    Object target) {
            return event.dispatch(receiver);
        }
    }

    static class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        @Override
        public void startTracking(KeyEvent event) {
            KeyEventCompatEclair.startTracking(event);
        }

        @Override
        public boolean isTracking(KeyEvent event) {
            return KeyEventCompatEclair.isTracking(event);
        }

        @Override
        public Object getKeyDispatcherState(View view) {
            return KeyEventCompatEclair.getKeyDispatcherState(view);
        }

        @Override
        public boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state,
                    Object target) {
            return KeyEventCompatEclair.dispatch(event, receiver, state, target);
        }
    }

    /**
     * Interface implementation for devices with at least v11 APIs.
     */
    static class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        @Override
        public int normalizeMetaState(int metaState) {
            return KeyEventCompatHoneycomb.normalizeMetaState(metaState);
        }
        
        @Override
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(metaState, modifiers);
        }

        @Override
        public boolean metaStateHasNoModifiers(int metaState) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(metaState);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.565 -0400", hash_original_field = "49ED0D05159F507ACCC32A40A6511184", hash_generated_field = "8BC9A90D0CC72A26BB6A0C00C70BEEDE")

    static  KeyEventVersionImpl IMPL;
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }

    // -------------------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.570 -0400", hash_original_method = "E8349ABDADBC992226D468F337E5445D", hash_generated_method = "07A97D7ACE856A0375E03E292BAD6C95")
        
public static int normalizeMetaState(int metaState) {
        return IMPL.normalizeMetaState(metaState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.575 -0400", hash_original_method = "3CE05E6B558DBB2C1B3F782D7F65E5E2", hash_generated_method = "6DE8B6A725AAE8B0CDE486BD8E835660")
        
public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return IMPL.metaStateHasModifiers(metaState, modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.580 -0400", hash_original_method = "7D14DDC1AD0050C76B07AC3FF657CFA1", hash_generated_method = "428EFD88539E07C6072424F2B4344E2A")
        
public static boolean metaStateHasNoModifiers(int metaState) {
        return IMPL.metaStateHasNoModifiers(metaState);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.585 -0400", hash_original_method = "3459CD70A7471F910F70EFC30C291EC4", hash_generated_method = "E98B8C680069F3DBBF1CE6913C768C7D")
        
public static boolean hasModifiers(KeyEvent event, int modifiers) {
        return IMPL.metaStateHasModifiers(event.getMetaState(), modifiers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.589 -0400", hash_original_method = "53CEAEB414B0F10FB842AFA317D8BBA2", hash_generated_method = "AEF3647D1E5748BCE037970C04A9E6AB")
        
public static boolean hasNoModifiers(KeyEvent event) {
        return IMPL.metaStateHasNoModifiers(event.getMetaState());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.594 -0400", hash_original_method = "150D3F3A2D88B85D95E14A5F3CCB7DBB", hash_generated_method = "AFF0231763CDAB8820474AC9C1AADFDA")
        
public static void startTracking(KeyEvent event) {
        IMPL.startTracking(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.598 -0400", hash_original_method = "AE7F0A220F105852CD8B3C1F0819B0AC", hash_generated_method = "50C62839AB647EC7A91C6692AC90423F")
        
public static boolean isTracking(KeyEvent event) {
        return IMPL.isTracking(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.602 -0400", hash_original_method = "8051F30CD8FA23D1EB4FA2ED2D510E92", hash_generated_method = "0DA5F111CD1FC0BFD32D12331D2247B2")
        
public static Object getKeyDispatcherState(View view) {
        return IMPL.getKeyDispatcherState(view);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:29:00.606 -0400", hash_original_method = "BDA4303712F8F48EECAD505574D2CF95", hash_generated_method = "44C4A5E4422A4A403D295F13B5965909")
        
public static boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state,
                Object target) {
        return IMPL.dispatch(event, receiver, state, target);
    }
}
