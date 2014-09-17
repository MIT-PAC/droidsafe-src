/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v4.content;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;

import java.io.File;

class ContextCompatFroyo {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.316 -0400", hash_original_method = "829D266D3097B64611E6B410B500B7A0", hash_generated_method = "B9515FEA486117A1AF4B28FCAD3A9842")
    
public static File getExternalCacheDir(Context context) {
        return context.getExternalCacheDir();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:02:00.323 -0400", hash_original_method = "4E87EE22D7D6997F84FE9665941D9624", hash_generated_method = "678B25824087ECCFB538A73FD0E72922")
    
public static File getExternalFilesDir(Context context, String type) {
        return context.getExternalFilesDir(type);
    }
}
