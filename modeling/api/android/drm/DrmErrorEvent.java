/*
 * Copyright (C) 2010 The Android Open Source Project
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

package android.drm;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.HashMap;

/**
 * An entity class that is passed to the
 * {@link DrmManagerClient.OnErrorListener#onError onError()} callback.
 *
 */
public class DrmErrorEvent extends DrmEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.947 -0400", hash_original_field = "232A1AC1CC90CB1B04BB238855C96A96", hash_generated_field = "01238B8312D4D5FFE726F4D7016CCE5C")

    public static final int TYPE_RIGHTS_NOT_INSTALLED = 2001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.952 -0400", hash_original_field = "05EE3EE0542B38D5100A418323B15775", hash_generated_field = "B455DADA3FBC8E60376852D7518E75F9")

    public static final int TYPE_RIGHTS_RENEWAL_NOT_ALLOWED = 2002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.956 -0400", hash_original_field = "83FDABA9E9011DC51C5190FB6F63F22D", hash_generated_field = "1C087B774E93683A898D8FF305DF47C9")

    public static final int TYPE_NOT_SUPPORTED = 2003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.961 -0400", hash_original_field = "1EC0707AF6702F20EA5B578465D72DA4", hash_generated_field = "FDF3B76D39FF69E48F95C7DCD17330EC")

    public static final int TYPE_OUT_OF_MEMORY = 2004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.966 -0400", hash_original_field = "9AFB8277955CBB8D309CA52A5F2CD01B", hash_generated_field = "05524B44057D78E9D9E6631199EEBA51")

    public static final int TYPE_NO_INTERNET_CONNECTION = 2005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.971 -0400", hash_original_field = "BBABB04A1A6D6618743D4B8B56C6BA3C", hash_generated_field = "48BB993F5FA0150C81BD7C025CF86435")

    public static final int TYPE_PROCESS_DRM_INFO_FAILED = 2006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.975 -0400", hash_original_field = "B4737CEC0FBE73319FD46A730E50777C", hash_generated_field = "0F6DF450F99FDC0DE04BD324DD52B312")

    public static final int TYPE_REMOVE_ALL_RIGHTS_FAILED = 2007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.980 -0400", hash_original_field = "672CEF141C1F952E4A54925DE1A7EE8F", hash_generated_field = "48F7CE3E97058CB90D994A31507AEE05")

    public static final int TYPE_ACQUIRE_DRM_INFO_FAILED = 2008;

    /**
     * Creates a <code>DrmErrorEvent</code> object with the specified parameters.
     *
     * @param uniqueId Unique session identifier.
     * @param type Type of the event. Could be any of the event types defined above.
     * @param message Message description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.985 -0400", hash_original_method = "76D06BC41176CFA4728FC56D7F0473D6", hash_generated_method = "BAB954591AA10BA3342EE623BD599B20")
    
public DrmErrorEvent(int uniqueId, int type, String message) {
        super(uniqueId, type, message);
    }

    /**
     * Creates a <code>DrmErrorEvent</code> object with the specified parameters.
     *
     * @param uniqueId Unique session identifier.
     * @param type Type of the event. Could be any of the event types defined above.
     * @param message Message description.
     * @param attributes Attributes for extensible information. Could be any
     * information provided by the plug-in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:52.989 -0400", hash_original_method = "2701BC26AA1CE42F778C037C4B6D7CAD", hash_generated_method = "BE0EC71A9AF8CDF3877BE4D49EE24869")
    
public DrmErrorEvent(int uniqueId, int type, String message,
                            HashMap<String, Object> attributes) {
        super(uniqueId, type, message, attributes);
    }
}
