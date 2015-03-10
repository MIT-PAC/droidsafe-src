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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ConsoleMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.633 -0500", hash_original_field = "F8DBE95D4F9FC496EF752033A947CDF7", hash_generated_field = "97B0FE7DDC2696309CFA4856C37F4CCB")


    private MessageLevel mLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.635 -0500", hash_original_field = "AA6F183B8C0E9B6C851D4101DE6EFB65", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

    private String mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.637 -0500", hash_original_field = "CC44D0A5A7ED4E3D9B0336B49DE14711", hash_generated_field = "B2CDD87A3B1C8A195FBE30ADD11DDBDF")

    private String mSourceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.639 -0500", hash_original_field = "DEE863AC3FDA1E17F5CF881E973FC5C9", hash_generated_field = "5A9E17AF4C282DA03F1D6A7DDEDBF4FD")

    private int mLineNumber;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.642 -0500", hash_original_method = "054E47655FB4B805E39E1B05003FB12B", hash_generated_method = "2F5D3148E4FCB4C360EE2AEFE0793083")
    
public ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        mMessage = message;
        mSourceId = sourceId;
        mLineNumber = lineNumber;
        mLevel = msgLevel;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.644 -0500", hash_original_method = "25C4EE735F0CFD6521F32D3F800D92AC", hash_generated_method = "18210675C93B752F02E9F36B0D2705A0")
    
public MessageLevel messageLevel() {
        return mLevel;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.647 -0500", hash_original_method = "52DD879A1942417F2863E1B67C410E21", hash_generated_method = "696134DC9B45CAD98841BD668933B616")
    
public String message() {
        return mMessage;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.649 -0500", hash_original_method = "215864977BD1865913F9AFF2A58F69AA", hash_generated_method = "2B7A356270C97681BD159D243FB405BC")
    
public String sourceId() {
        return mSourceId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.651 -0500", hash_original_method = "C9721078850915D930C57EA652CD2BDC", hash_generated_method = "5F771892077D7F83A1324845BF2E2355")
    
public int lineNumber() {
        return mLineNumber;
    }

    
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    
}

