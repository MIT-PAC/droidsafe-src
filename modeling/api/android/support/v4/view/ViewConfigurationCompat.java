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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {

    // -------------------------------------------------------------------

    /**
     * Call {@link ViewConfiguration#getScaledPagingTouchSlop()}.
     * If running on a pre-{@link android.os.Build.VERSION_CODES#FROYO} device,
     * returns {@link ViewConfiguration#getScaledTouchSlop()}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.438 -0500", hash_original_method = "3528C0183AFB79CCB68AA739BEF357FF", hash_generated_method = "1BC52F06F2C8ECA5BEC4194ED7F7B291")
    
public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return IMPL.getScaledPagingTouchSlop(config);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.436 -0500", hash_original_field = "757E23C6B8816B26A38274C90DED08B4", hash_generated_field = "4BAEFA1DBA6789946690ACEDFD86419E")

    static  ViewConfigurationVersionImpl IMPL;
    
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.387 -0400", hash_original_method = "A69B2452C79DFBE1CA7B04111C2A43A4", hash_generated_method = "A69B2452C79DFBE1CA7B04111C2A43A4")
        public BaseViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.426 -0500", hash_original_method = "40A95D8EF0A43B6ED733EDF4744F0469", hash_generated_method = "1D7E3EB014AE3CF651A36DC6CE49B7BB")
        
@Override
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return config.getScaledTouchSlop();
        }
        
    }
    
    static class FroyoViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.387 -0400", hash_original_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583", hash_generated_method = "6DBEE8295DE3B0BBCD4D937DD1B1D583")
        public FroyoViewConfigurationVersionImpl ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:19.432 -0500", hash_original_method = "5FB3C1F49AB507E1F7081F1E34699ECD", hash_generated_method = "36E3FC06272A4B4387BED92E9254E9DD")
        
@Override
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config);
        }
        
    }
    
    interface ViewConfigurationVersionImpl {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getScaledPagingTouchSlop(ViewConfiguration config);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.387 -0400", hash_original_method = "4E5705462ABC07218BC228DFC04D8AC2", hash_generated_method = "4E5705462ABC07218BC228DFC04D8AC2")
    public ViewConfigurationCompat ()
    {
        //Synthesized constructor
    }
    static {
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }
    
}

