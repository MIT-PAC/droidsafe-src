/*
 * Copyright (C) 2014 The Android Open Source Project
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

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Notification;
import android.app.NotificationManager;

class NotificationManagerCompatEclair {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:06.579 -0400", hash_original_method = "74FF0DDA2E79BFBF230DBB58F231F75E", hash_generated_method = "1E2FE2DC9D4D4045BAEED653D66F22E8")
    
static void cancelNotification(NotificationManager notificationManager, String tag,
            int id) {
        notificationManager.cancel(tag, id);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 12:06:06.582 -0400", hash_original_method = "5F64BEC44C12D87BC3F53167FF59C7E0", hash_generated_method = "809F6F95CBC96967938BE2812C3500DB")
    
public static void postNotification(NotificationManager notificationManager, String tag, int id,
            Notification notification) {
        notificationManager.notify(tag, id, notification);
    }
}
