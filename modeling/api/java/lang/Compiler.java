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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;

/**
 * Does nothing on Android.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class Compiler {

    /**
     * Executes an operation according to the specified command object. This
     * method is the low-level interface to the JIT compiler. It may return any
     * object or {@code null} if no JIT compiler is available. Returns null
     * on Android, whether or not the system has a JIT.
     *
     * @param cmd
     *            the command object for the JIT compiler.
     * @return the result of executing command or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.872 -0400", hash_original_method = "4C19443A138826605555098A19A128E8", hash_generated_method = "A4B3667D0206982137D442CF9C626D1A")
    
public static Object command(Object cmd) {
        return null;
    }

    /**
     * Compiles the specified class using the JIT compiler and indicates if
     * compilation has been successful. Does nothing and returns false on
     * Android.
     *
     * @param classToCompile
     *            java.lang.Class the class to JIT compile
     * @return {@code true} if the compilation has been successful;
     *         {@code false} if it has failed or if there is no JIT compiler
     *         available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.874 -0400", hash_original_method = "FDD74557385AB5C43DFFBCC40B0F400F", hash_generated_method = "6E6BE198B271B0C8D8C3D445653B788B")
    
public static boolean compileClass(Class<?> classToCompile) {
        return false;
    }

    /**
     * Compiles all classes whose name matches the specified name using the JIT
     * compiler and indicates if compilation has been successful. Does nothing
     * and returns false on Android.
     *
     * @param nameRoot
     *            the string to match class names with.
     * @return {@code true} if the compilation has been successful;
     *         {@code false} if it has failed or if there is no JIT compiler
     *         available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.875 -0400", hash_original_method = "10E48FF5F36DFDEA8A99B2FC92DCE5A3", hash_generated_method = "84CEB1CC881AF97A0D11AEE26EFE3C7D")
    
public static boolean compileClasses(String nameRoot) {
        return false;
    }

    /**
     * Disables the JIT compiler. Does nothing on Android.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.877 -0400", hash_original_method = "450793B14B2760672928AE5911F3EF0A", hash_generated_method = "D61AB6A8D39F54AA6F6EE26C3F3F9493")
    
public static void disable() {
    }

    /**
     * Enables the JIT compiler. Does nothing on Android.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.878 -0400", hash_original_method = "25BE7F1A3C205E6611494C34BFEDC156", hash_generated_method = "E85BD8A99A155BF179CB59A2650B80D8")
    
public static void enable() {
    }
    /**
     * Prevent this class from being instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.871 -0400", hash_original_method = "15C7E5CD881CE32D9F06A99D4D026E34", hash_generated_method = "9BBAC45502CCD82775DB6C6E87E290BA")
    
private Compiler() {
        //do nothing
    }
}
