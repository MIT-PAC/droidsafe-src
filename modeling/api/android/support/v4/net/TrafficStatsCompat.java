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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Build;

import java.net.Socket;
import java.net.SocketException;

/**
 * Helper for accessing features in TrafficStats introduced after API level 14
 * in a backwards compatible fashion.
 */
public class TrafficStatsCompat {

    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();
        int getThreadStatsTag();
        void incrementOperationCount(int operationCount);
        void incrementOperationCount(int tag, int operationCount);
        void setThreadStatsTag(int tag);
        void tagSocket(Socket socket) throws SocketException;
        void untagSocket(Socket socket) throws SocketException;
    }

    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private static class SocketTags {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.088 -0500", hash_original_field = "428DFC4B7464E02F8075B1184461884F", hash_generated_field = "50A065B7832C2F855A22AFE5278B6084")

            public int statsTag = -1;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.110 -0500", hash_original_field = "B25EEFE942F3522AE9B7C87C81A575B6", hash_generated_field = "F94787120B7DCB7AB43791A107524046")

        private ThreadLocal<SocketTags> mThreadSocketTags = new ThreadLocal<SocketTags>() {
            @DSSafe(DSCat.SAFE_LIST)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:55:10.568 -0500", hash_original_method = "917426AFC28735098682F2B9D9CB79DB", hash_generated_method = "33F4ECD1E86E2B8E57F485FE00B0D17E")
            
@Override
            protected SocketTags initialValue() {
                return new SocketTags();
            }
        };

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.117 -0500", hash_original_method = "29F40184016458593923928B54B72D58", hash_generated_method = "80A109C59EA99F23123176D30E91DFD9")
        
@Override
        public void clearThreadStatsTag() {
            mThreadSocketTags.get().statsTag = -1;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.123 -0500", hash_original_method = "A544838E51C242497C15D6C7B9A1DB6E", hash_generated_method = "8E20A3F2D078921B3E7D46BFDBF3B9DE")
        
@Override
        public int getThreadStatsTag() {
            return mThreadSocketTags.get().statsTag;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.130 -0500", hash_original_method = "ADC5B446D7FD7ADEC8E6E99BE6A89ACD", hash_generated_method = "D7B91E7E1FAD02CA0DB14B052CA702B3")
        
@Override
        public void incrementOperationCount(int operationCount) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.136 -0500", hash_original_method = "C2D2CABC8BAA7DE31FFBC5C61CBBFF4B", hash_generated_method = "46122297344479221A99BF173B5CD1BD")
        
@Override
        public void incrementOperationCount(int tag, int operationCount) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.142 -0500", hash_original_method = "9E4D6173C835AE0B3ACB1B95EE549A39", hash_generated_method = "D2741C37BD8EDC73E7CA77FD70C29DE1")
        
@Override
        public void setThreadStatsTag(int tag) {
            mThreadSocketTags.get().statsTag = tag;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.149 -0500", hash_original_method = "28BB71644E0B41424DD4E7871B3DCC8E", hash_generated_method = "9A2DFEB15CB0DFEE3E3753A2A9E66D83")
        
@Override
        public void tagSocket(Socket socket) {
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.155 -0500", hash_original_method = "5A2A1CCFECD670B6FBDB133DA240D623", hash_generated_method = "827AD048CE7F254E007562036A773EAD")
        
@Override
        public void untagSocket(Socket socket) {
        }
    }

    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.172 -0500", hash_original_method = "D5F8F40C9A6EF9C3E2D80BDD13420E3C", hash_generated_method = "0DEC5FB669806F5FB311B93BBA17BFCD")
        
@Override
        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.176 -0500", hash_original_method = "C607CD6AC1DFBE73A196F08B4FC9F846", hash_generated_method = "2929EA68FF0C6DEFABE566439D0038AD")
        
@Override
        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.181 -0500", hash_original_method = "7826ADD4BD4CFED6127952D7C225D733", hash_generated_method = "A793C7905EE77DE8466B53C6E1B09323")
        
@Override
        public void incrementOperationCount(int operationCount) {
            TrafficStatsCompatIcs.incrementOperationCount(operationCount);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.185 -0500", hash_original_method = "036A1A617530622DBDCD1BDAD5B43CE3", hash_generated_method = "B29A4F080D15CB73CFA6B7BFB088AD2E")
        
@Override
        public void incrementOperationCount(int tag, int operationCount) {
            TrafficStatsCompatIcs.incrementOperationCount(tag, operationCount);
        }

        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.188 -0500", hash_original_method = "1738DCB0EBCA30BF1C05152FFD4491B7", hash_generated_method = "009CF9C13BB840465EB25F63CA293850")
        
@Override
        public void setThreadStatsTag(int tag) {
            TrafficStatsCompatIcs.setThreadStatsTag(tag);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.193 -0500", hash_original_method = "B6FE1385E96F3D2720B2284B417D81E5", hash_generated_method = "050ADB6056B7550D259E23C44E76045F")
        
@Override
        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.199 -0500", hash_original_method = "749F735AEEA0FACC46E02DE25255B9A4", hash_generated_method = "85EE4B0945106617829A3F3182E66640")
        
@Override
        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.211 -0500", hash_original_field = "4B98C7C8ECB5D559E993CDD8D7BD112C", hash_generated_field = "9FAF7A77D1E139709D9A712232752488")

    private static  TrafficStatsCompatImpl IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsTrafficStatsCompatImpl();
        } else {
            IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    /**
     * Clear active tag used when accounting {@link Socket} traffic originating
     * from the current thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.216 -0500", hash_original_method = "018E4EBB4BD4EF31F37DF94F7902B448", hash_generated_method = "0BDBD212CC447222DEEBC437B61C88A4")
    
public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    /**
     * Get the active tag used when accounting {@link Socket} traffic originating
     * from the current thread. Only one active tag per thread is supported.
     * {@link #tagSocket(Socket)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.222 -0500", hash_original_method = "18679BF3BD63C6FC81E41BDECE59E6B2", hash_generated_method = "003BA23173DD57B9AD319412B72AC922")
    
public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    /**
     * Increment count of network operations performed under the accounting tag
     * currently active on the calling thread. This can be used to derive
     * bytes-per-operation.
     *
     * @param operationCount Number of operations to increment count by.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.228 -0500", hash_original_method = "E6F1BEA77C026036C2CD8E9051F9B16E", hash_generated_method = "369504BAB81A583CCBBB807A4832883A")
    
public static void incrementOperationCount(int operationCount) {
        IMPL.incrementOperationCount(operationCount);
    }

    /**
     * Increment count of network operations performed under the given
     * accounting tag. This can be used to derive bytes-per-operation.
     *
     * @param tag Accounting tag used in {@link #setThreadStatsTag(int)}.
     * @param operationCount Number of operations to increment count by.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.235 -0500", hash_original_method = "172B8DB91BD70259E39E79E8E91BEE6D", hash_generated_method = "BD58994E0E9E2700E7AF697B380C68B6")
    
public static void incrementOperationCount(int tag, int operationCount) {
        IMPL.incrementOperationCount(tag, operationCount);
    }

    /**
     * Set active tag to use when accounting {@link Socket} traffic originating
     * from the current thread. Only one active tag per thread is supported.
     * <p>
     * Changes only take effect during subsequent calls to
     * {@link #tagSocket(Socket)}.
     * <p>
     * Tags between {@code 0xFFFFFF00} and {@code 0xFFFFFFFF} are reserved and
     * used internally by system services like DownloadManager when performing
     * traffic on behalf of an application.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.240 -0500", hash_original_method = "2BBDBF9BBAB4164DE099624469E8DDCA", hash_generated_method = "58711509537BDEF7EC94C8ADD400A44D")
    
public static void setThreadStatsTag(int tag) {
        IMPL.setThreadStatsTag(tag);
    }

    /**
     * Tag the given {@link Socket} with any statistics parameters active for
     * the current thread. Subsequent calls always replace any existing
     * parameters. When finished, call {@link #untagSocket(Socket)} to remove
     * statistics parameters.
     *
     * @see #setThreadStatsTag(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.243 -0500", hash_original_method = "1747BE9BB9981EA1DDC4695E9518C921", hash_generated_method = "2957FB94AD1B1DB4F997EF46DA4FACA3")
    
public static void tagSocket(Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }

    /**
     * Remove any statistics parameters from the given {@link Socket}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 09:53:56.247 -0500", hash_original_method = "291957CDDAD0AC8A4BF7483AAB4FF4D0", hash_generated_method = "BF30B09721AD49C66E6209B35F9AD801")
    
public static void untagSocket(Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }
}
