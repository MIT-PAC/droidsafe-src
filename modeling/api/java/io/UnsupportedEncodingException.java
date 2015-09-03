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


package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnsupportedEncodingException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.103 -0500", hash_original_field = "7D2555FC6BD2B35FFBE5730FF8988BCE", hash_generated_field = "16E0F2774CF4B9874F4A0527E666B383")

    private static final long serialVersionUID = -4274276298326136670L;

    /**
     * Constructs a new {@code UnsupportedEncodingException} with its stack
     * trace filled in.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.105 -0500", hash_original_method = "120B741722292072F71D190D9178D3DA", hash_generated_method = "8F10FE929352D2B7D8DE6A7330B7BA78")
    
public UnsupportedEncodingException() {
    }

    /**
     * Constructs a new {@code UnsupportedEncodingException} with its stack
     * trace and detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("exception message, is only a data structure")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.108 -0500", hash_original_method = "94DA8264158047F6F5B3A7DFC24D11B0", hash_generated_method = "760BBD0CBE2DD34CCC9FDB05C208A8D4")
    
public UnsupportedEncodingException(String detailMessage) {
        super(detailMessage);
    }
}

