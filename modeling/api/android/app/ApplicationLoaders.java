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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.PathClassLoader;

class ApplicationLoaders {
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.968 -0500", hash_original_method = "76DB5D07DDEAAF71FF7BD101A2CCF328", hash_generated_method = "164C60B2F6F9D106EE1CEAF9EA0DCC60")
    
public static ApplicationLoaders getDefault()
    {
        return gApplicationLoaders;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.975 -0500", hash_original_field = "EAC090BECD5412DDCDEA99C0EA394D14", hash_generated_field = "FDBBA88BBDA6D0EE426E19208B3BA381")

    private static final ApplicationLoaders gApplicationLoaders
        = new ApplicationLoaders();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.973 -0500", hash_original_field = "64F1E474B03EB6AA58F12CB4E98D2462", hash_generated_field = "8341D47F664C030006757000CF63480B")

    private final Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.316 -0400", hash_original_method = "B28ECCCB6DE1A645261BEF05FE1982E7", hash_generated_method = "B28ECCCB6DE1A645261BEF05FE1982E7")
    public ApplicationLoaders ()
    {
        //Synthesized constructor
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.971 -0500", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "CBA9A0CE4A50ED64B8154F5699F116CF")
    
public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent)
    {
        /*
         * This is the parent we use if they pass "null" in.  In theory
         * this should be the "system" class loader; in practice we
         * don't use that and can happily (and more efficiently) use the
         * bootstrap class loader.
         */
        ClassLoader baseParent = ClassLoader.getSystemClassLoader().getParent();

        synchronized (mLoaders) {
            if (parent == null) {
                parent = baseParent;
            }

            /*
             * If we're one step up from the base class loader, find
             * something in our cache.  Otherwise, we create a whole
             * new ClassLoader for the zip archive.
             */
            if (parent == baseParent) {
                ClassLoader loader = mLoaders.get(zip);
                if (loader != null) {
                    return loader;
                }
    
                PathClassLoader pathClassloader =
                    new PathClassLoader(zip, libPath, parent);
                
                mLoaders.put(zip, pathClassloader);
                return pathClassloader;
            }

            return new PathClassLoader(zip, parent);
        }
    }
}

