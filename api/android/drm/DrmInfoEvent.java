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
 * {@link DrmManagerClient.OnInfoListener#onInfo onInfo()} callback.
 *
 */
public class DrmInfoEvent extends DrmEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.762 -0400", hash_original_field = "9BB1F761920953A272399CE4DC0D0993", hash_generated_field = "CC76772805A6CAC49CB6BB8CF1239283")

    public static final int TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.766 -0400", hash_original_field = "F17BBFFDC17E4BE60EFFB044D92039E5", hash_generated_field = "3F7748136270320AB46B505ABD138C93")

    public static final int TYPE_REMOVE_RIGHTS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.770 -0400", hash_original_field = "6AF86E031D924FC735F6D3B855E103B1", hash_generated_field = "D45A08EE90B8E8B666A6746B6E03609E")

    public static final int TYPE_RIGHTS_INSTALLED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.775 -0400", hash_original_field = "148E17A974C41B063B4337C5F649EC92", hash_generated_field = "324717491FB7E8784B3B9287E4166F50")

    public static final int TYPE_WAIT_FOR_RIGHTS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.779 -0400", hash_original_field = "D2A76B3CB8B1B0D14CCCE67D8821BE77", hash_generated_field = "AFCEBB840948ADEB5C8D9ACAF2E35909")

    public static final int TYPE_ACCOUNT_ALREADY_REGISTERED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.783 -0400", hash_original_field = "6CBCE2908AF1933E29C00A58F51E3FD5", hash_generated_field = "CC40362F617278CAA383ECD116F8A277")

    public static final int TYPE_RIGHTS_REMOVED = 6;

    /**
     * Creates a <code>DrmInfoEvent</code> object with the specified parameters.
     *
     * @param uniqueId Unique session identifier.
     * @param type Type of the event. Could be any of the event types defined above.
     * @param message Message description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.787 -0400", hash_original_method = "6DD92E82542F1890919DF52E279E0B68", hash_generated_method = "28297192B7420F026BD550B67F1ED570")
    
public DrmInfoEvent(int uniqueId, int type, String message) {
        super(uniqueId, type, message);
    }

    /**
     * Creates a <code>DrmInfoEvent</code> object with the specified parameters.
     *
     * @param uniqueId Unique session identifier.
     * @param type Type of the event. Could be any of the event types defined above.
     * @param message Message description.
     * @param attributes Attributes for extensible information. Could be any
     * information provided by the plug-in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:54:53.791 -0400", hash_original_method = "D37A8255718A20CFB0E781875CD2288C", hash_generated_method = "9764CBBE0E7E33F7F76A65E296AEBE51")
    
public DrmInfoEvent(int uniqueId, int type, String message,
                            HashMap<String, Object> attributes) {
        super(uniqueId, type, message, attributes);
    }
}

