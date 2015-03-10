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


package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class AnimatorListenerAdapter implements Animator.AnimatorListener {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.968 -0400", hash_original_method = "577D05693184EE178A20150D84A37CD4", hash_generated_method = "577D05693184EE178A20150D84A37CD4")
        
    public AnimatorListenerAdapter ()
    {
        //Synthesized constructor
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.297 -0500", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "09F3DCB3B2C6F194F589204D6CEA1D02")
    
@Override
    public void onAnimationCancel(Animator animation) {
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.ANDROID_ANIMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.299 -0500", hash_original_method = "5CF474E58C527E8964A758ECD279FAE2", hash_generated_method = "C2ECE5469BDB91F3EC103716966680AA")
    
@Override
    public void onAnimationEnd(Animator animation) {
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.302 -0500", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "10E9921CB3298EBACCE8F83DAB252AF1")
    
@Override
    public void onAnimationRepeat(Animator animation) {
    }

    /**
     * {@inheritDoc}
     */
    @DSSafe(DSCat.ANDROID_ANIMATION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:33.304 -0500", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "A0DF4431BC87990F62C49C1D9C1CE1F8")
    
@Override
    public void onAnimationStart(Animator animation) {
    }
    
}

