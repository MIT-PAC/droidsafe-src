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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.test.mock;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Application;
import android.content.res.Configuration;

public class MockApplication extends Application {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.971 -0500", hash_original_method = "1B19C6453B2D07E5BCC8816EA82B0228", hash_generated_method = "15C3A0A61B7C0F3007C3F2D0670A6F02")
    
public MockApplication() {
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.973 -0500", hash_original_method = "AB55BCFD90D9CF641566BDB5BAD65AFF", hash_generated_method = "D7E69C6D9C3495D5EF31B1477698DA4C")
    
@Override
    public void onCreate() {
        throw new UnsupportedOperationException();
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.976 -0500", hash_original_method = "9991613DFAC855235B415C4774CC80EA", hash_generated_method = "16F7ED9664099BE606754E50B16E01CC")
    
@Override
    public void onTerminate() {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:44.978 -0500", hash_original_method = "7E56559F8B4EC145CBEC91305D6CF8F3", hash_generated_method = "A98CE60F4C41025303976C5973E48F2E")
    
@Override
    public void onConfigurationChanged(Configuration newConfig) {
        throw new UnsupportedOperationException();
    }
    
}

