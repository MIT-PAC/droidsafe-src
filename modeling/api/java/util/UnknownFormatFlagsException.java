/* Licensed to the Apache Software Foundation (ASF) under one or more
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


package java.util;

/**
 * An {@code UnknownFormatFlagsException} will be thrown if there is
 * an unknown flag.
 *
 * @see java.lang.RuntimeException
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class UnknownFormatFlagsException extends IllegalFormatException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.589 -0400", hash_original_field = "A224D6FD062053780FB877F166AA84BC", hash_generated_field = "673917F14258B85D75E7450B8DB8C1B7")

    private static final long serialVersionUID = 19370506L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.590 -0400", hash_original_field = "806B57DB0428E85D2726FB0E46248D66", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private  String flags;

    /**
     * Constructs a new {@code UnknownFormatFlagsException} with the specified
     * flags.
     *
     * @param f
     *           the specified flags.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.590 -0400", hash_original_method = "FB796ED53E889B96A7C07D410FC3FDF0", hash_generated_method = "F73F349C2343909228D4A19CEB45DCEC")
    
public UnknownFormatFlagsException(String f) {
        if (f == null) {
            throw new NullPointerException("f == null");
        }
        flags = f;
    }

    /**
     * Returns the flags associated with the exception.
     *
     * @return the flags associated with the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.591 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "755C27A527F4F0B24180AE62DAAD9815")
    
public String getFlags() {
        return flags;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:01.591 -0400", hash_original_method = "58A1FE0D4A5171FD802A92BA519741E7", hash_generated_method = "CF9AA932853A2CB8E9687DDB85C3EFD9")
    
@Override
    public String getMessage() {
        return "Flags: " + flags;
    }
}
