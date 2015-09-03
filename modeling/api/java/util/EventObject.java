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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public class EventObject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.341 -0500", hash_original_field = "FCFD693445D5C91823A585314B80016E", hash_generated_field = "7EDA1B54A84BB88DBCC9E4ADB18207F4")

    private static final long serialVersionUID = 5516075349620653480L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.343 -0500", hash_original_field = "B1F1A09178B285CE5A5A0F0FA17DB436", hash_generated_field = "B89FD14140C3D96FD5EE1AB3347DDB03")

    @FindBugsSuppressWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    protected transient Object source;

    /**
     * Constructs a new instance of this class.
     *
     * @param source
     *            the object which fired the event.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.346 -0500", hash_original_method = "19E83C4C00CF513D7C219A8F2CE4B9FA", hash_generated_method = "31254B198F68157457014067B2589821")
    
public EventObject(Object source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        this.source = source;
    }

    /**
     * Returns the object which fired the event.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.348 -0500", hash_original_method = "9C6E9403B2BCB843296731DEDAEEBBC7", hash_generated_method = "3D28168EFE76736511F32DF40C7D247E")
    
public Object getSource() {
        return source;
    }

    /**
     * Returns the string representation of this {@code EventObject}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.351 -0500", hash_original_method = "50A98C78FE68558BA94E5BDF90A15613", hash_generated_method = "2A2B8D705213FD04B84EB4BB1F536CF0")
    
@Override public String toString() {
        return getClass().getName() + "[source=" + source + ']';
    }
}

