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


package android.test.suitebuilder.annotation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;

import android.test.suitebuilder.TestMethod;

import com.android.internal.util.Predicate;



class HasMethodAnnotation implements Predicate<TestMethod> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.827 -0500", hash_original_field = "C2B636B3436AAE938C27736789A704F2", hash_generated_field = "DE2305164AC5A8D49939E7B2C7A8CA75")


    private  Class<? extends Annotation> annotationClass;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.830 -0500", hash_original_method = "5B83FF39DFA831FA6A7CD406ADF7D177", hash_generated_method = "FCC1EE875CEB1969522A4C6C5DC9083C")
    
public HasMethodAnnotation(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.832 -0500", hash_original_method = "B0E427C0DE73550E3FD588188632FEB8", hash_generated_method = "8D1E7590A30E6E663F44636BDED47A68")
    
public boolean apply(TestMethod testMethod) {
        return testMethod.getAnnotation(annotationClass) != null;
    }

    
}

