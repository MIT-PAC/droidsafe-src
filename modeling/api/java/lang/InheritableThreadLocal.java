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


package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InheritableThreadLocal<T> extends ThreadLocal<T> {

    /**
     * Creates a new inheritable thread-local variable.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.537 -0500", hash_original_method = "013FA75455B3B99BD273198992B6DC3D", hash_generated_method = "E13EE25F4E019254954C6350304C79AC")
    
public InheritableThreadLocal() {
    }

    /**
     * Computes the initial value of this thread-local variable for the child
     * thread given the parent thread's value. Called from the parent thread when
     * creating a child thread. The default implementation returns the parent
     * thread's value.
     *
     * @param parentValue the value of the variable in the parent thread.
     * @return the initial value of the variable for the child thread.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.541 -0500", hash_original_method = "21950621664F241C91FE4E959BCE80F5", hash_generated_method = "8D17A7D6545AFF55B795464598770CC6")
    
protected T childValue(T parentValue) {
        return parentValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.543 -0500", hash_original_method = "5F640D0B7D2E60FEE01A049AD8233DEB", hash_generated_method = "663009C2DB6D2EF65EB42BB969A6976E")
    
@Override
    Values values(Thread current) {
        return current.inheritableValues;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.545 -0500", hash_original_method = "198C51D572472BCFE1CF3566F6918855", hash_generated_method = "7476F3413E3E995DF44BCBC94333B86C")
    
@Override
    Values initializeValues(Thread current) {
        return current.inheritableValues = new Values();
    }
    
}

