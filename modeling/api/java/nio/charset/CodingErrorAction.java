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


package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CodingErrorAction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.598 -0500", hash_original_field = "36280811176184BD58DAE93CABA1A5DB", hash_generated_field = "180E61F2E81DA6FA0483F69131029064")

    public static final CodingErrorAction IGNORE = new CodingErrorAction(
            "IGNORE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.600 -0500", hash_original_field = "483D08839D36B31B21EB1ADFC1E03915", hash_generated_field = "71B23436B9F036A6D96826127DFB318D")

    public static final CodingErrorAction REPLACE = new CodingErrorAction(
            "REPLACE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.603 -0500", hash_original_field = "98C8D23B755BE4CDFBAB6BAA4C1CB9BA", hash_generated_field = "D805EA59DDF422B4EBEECDD03C0F17B7")

    public static final CodingErrorAction REPORT = new CodingErrorAction(
            "REPORT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.606 -0500", hash_original_field = "F0D53334D1D58D4E79746838A9C851E9", hash_generated_field = "B1982569D823DF720405855D93182845")

    private String action;

    /*
     * Can't instantiate outside.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.608 -0500", hash_original_method = "97CD51F500ABFE41AE4BD609F91C5F74", hash_generated_method = "53D432196C6DD13986E47F240213F053")
    
private CodingErrorAction(String action) {
        this.action = action;
    }

    /**
     * Returns a text description of this action indication.
     *
     * @return a text description of this action indication.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.610 -0500", hash_original_method = "A74604AE646C671FE46897A241086F47", hash_generated_method = "5056D2985CC88098CE33EFAAF49CE7F6")
    
@Override
    public String toString() {
        return "Action: " + this.action;
    }
}

