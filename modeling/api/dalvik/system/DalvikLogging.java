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
 * Copyright (C) 2009 The Android Open Source Project
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


package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class DalvikLogging {

    /**
     * Returns the short logger tag (up to 23 chars) for the given logger name.
     * Traditionally loggers are named by fully-qualified Java classes; this
     * method attempts to return a concise identifying part of such names.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.150 -0500", hash_original_method = "0985A29138FED57B817275CA373E16BB", hash_generated_method = "C8AE084F0A43B82FC7C2DB9FAC19AA61")
    
public static String loggerNameToTag(String loggerName) {
        // Anonymous logger.
        if (loggerName == null) {
            return "null";
        }

        int length = loggerName.length();
        if (length <= 23) {
            return loggerName;
        }

        int lastPeriod = loggerName.lastIndexOf(".");
        return length - (lastPeriod + 1) <= 23
                ? loggerName.substring(lastPeriod + 1)
                : loggerName.substring(loggerName.length() - 23);
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:42.148 -0500", hash_original_method = "A5E4F7DD8D6CBC86B82114507B3451BF", hash_generated_method = "E1DD2A0114CBCFB6FC98080C422CA57D")
    
private DalvikLogging() {}
    
}

