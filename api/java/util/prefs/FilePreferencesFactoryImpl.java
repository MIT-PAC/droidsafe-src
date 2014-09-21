/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.util.prefs;

/**
 * The default implementation of <code>PreferencesFactory</code> for the Linux
 * platform, using the file system as its back end.
 *
 * @since 1.4
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class FilePreferencesFactoryImpl implements PreferencesFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.630 -0400", hash_original_field = "9DDAD387C531C74FBF5C9F1B74FFB2B1", hash_generated_field = "7231B408A3A18720974071997FFF0E07")

    private static final Preferences USER_ROOT = new FilePreferencesImpl(true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.630 -0400", hash_original_field = "EE7858A8DC1839B8682131BE4B02FF1B", hash_generated_field = "85331E56740B9B3209F3C3F4A1677D2F")

    private static final Preferences SYSTEM_ROOT = new FilePreferencesImpl(false);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.631 -0400", hash_original_method = "E41AA8F41818D5BE9ED988FD29EE6D5B", hash_generated_method = "A4CD6D21DC07A6A3A8394E5FCF0AD2C7")
    
public FilePreferencesFactoryImpl() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.631 -0400", hash_original_method = "246AD725AA82B1D744FD8C024359356A", hash_generated_method = "EAC4D9C5BE2E3F1CFE0403268FCC41DB")
    
public Preferences userRoot() {
        return USER_ROOT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.631 -0400", hash_original_method = "73DE65B074C4D281463677430B2BD926", hash_generated_method = "02DA9642C3038EE3D0758BCCA031A08C")
    
public Preferences systemRoot() {
        return SYSTEM_ROOT;
    }

}
