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

package android.support.v4.app;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

class NotificationCompatGingerbread {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 15:44:19.519 -0400", hash_original_method = "BB98833C866B9B0EC8F71A492651344F", hash_generated_method = "FB86650C68E6116AB9356E26C54FC0AB")
    
public static Notification add(Notification notification, Context context,
            CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent,
            PendingIntent fullScreenIntent) {
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.fullScreenIntent = fullScreenIntent;
        return notification;
    }
}
