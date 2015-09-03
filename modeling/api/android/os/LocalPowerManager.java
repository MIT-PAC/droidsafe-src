/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.os;

/** @hide */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public interface LocalPowerManager {
    // Note: be sure to update BatteryStats if adding or modifying event constants.
    
    public static final int OTHER_EVENT = 0;
    public static final int BUTTON_EVENT = 1;
    public static final int TOUCH_EVENT = 2;

    public static final int POKE_LOCK_IGNORE_TOUCH_EVENTS = 0x1;

    public static final int POKE_LOCK_SHORT_TIMEOUT = 0x2;
    public static final int POKE_LOCK_MEDIUM_TIMEOUT = 0x4;
    public static final int POKE_LOCK_TIMEOUT_MASK = 0x6;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void goToSleep(long time);
    
    // notify power manager when keyboard is opened/closed
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setKeyboardVisibility(boolean visible);

    // when the keyguard is up, it manages the power state, and userActivity doesn't do anything.
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void enableUserActivity(boolean enabled);

    // the same as the method on PowerManager
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void userActivity(long time, boolean noChangeLights, int eventType);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isScreenOn();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setScreenBrightnessOverride(int brightness);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setButtonBrightnessOverride(int brightness);
}
