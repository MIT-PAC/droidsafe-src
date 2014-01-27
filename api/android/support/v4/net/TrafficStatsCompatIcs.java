/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.support.v4.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.net.TrafficStats;

import java.net.Socket;
import java.net.SocketException;

/**
 * Implementation of TrafficStatsCompat that can call ICS APIs.
 */
public class TrafficStatsCompatIcs {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.968 -0500", hash_original_method = "1B1A2C5B3ED73724B1541EB75BEDA488", hash_generated_method = "40E2F1C688D4DA09DCA295CD5A93B264")
    
public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.975 -0500", hash_original_method = "2F5E2380C64748F1AB7F7F48F3D44F6F", hash_generated_method = "849535BD797979D410FF6BBE170FACF8")
    
public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.982 -0500", hash_original_method = "A015BA7E361802416DD059458C2735C0", hash_generated_method = "E7B0F41C435E769E8166698008BFD031")
    
public static void incrementOperationCount(int operationCount) {
        TrafficStats.incrementOperationCount(operationCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.990 -0500", hash_original_method = "6F4B307C646E5FB5C3EAE1EE19B7B893", hash_generated_method = "2ADC5DB7E1CF78FBB46916AE00CAA220")
    
public static void incrementOperationCount(int tag, int operationCount) {
        TrafficStats.incrementOperationCount(tag, operationCount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.993 -0500", hash_original_method = "2E16EEAC4DC43102B618BD8FF88B8964", hash_generated_method = "6B6DB1178A0DB49B5A1D4A16DD65E482")
    
public static void setThreadStatsTag(int tag) {
        TrafficStats.setThreadStatsTag(tag);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.998 -0500", hash_original_method = "186656EA33A53215CFA6B164CB08507B", hash_generated_method = "166341C058607BBE5C2F729D9834FF17")
    
public static void tagSocket(Socket socket) throws SocketException {
        TrafficStats.tagSocket(socket);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:57.003 -0500", hash_original_method = "782FED8A00BF68A0972D456343FEB26A", hash_generated_method = "8233FEE02FDEC366E044A1E9D0B765C7")
    
public static void untagSocket(Socket socket) throws SocketException {
        TrafficStats.untagSocket(socket);
    }
}
