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
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.beans;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class IndexedPropertyChangeEvent extends PropertyChangeEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.620 -0500", hash_original_field = "6D3B98F4853D9FAFDBF67D5E996F7D2E", hash_generated_field = "15EE4A8E739861F82460428634C59170")

    private static final long serialVersionUID = -320227448495806870L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.623 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private  int index;

    /**
     * Creates a new property changed event with an indication of the property
     * index.
     *
     * @param source
     *            the changed bean.
     * @param propertyName
     *            the changed property, or <code>null</code> to indicate an
     *            unspecified set of the properties has changed.
     * @param oldValue
     *            the previous value of the property, or <code>null</code> if
     *            the <code>propertyName</code> is <code>null</code> or the
     *            previous value is unknown.
     * @param newValue
     *            the new value of the property, or <code>null</code> if the
     *            <code>propertyName</code> is <code>null</code> or the new
     *            value is unknown..
     * @param index
     *            the index of the property.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.626 -0500", hash_original_method = "860D1012434BA4F5294622CC094A8203", hash_generated_method = "B432C0392C87ECF9CB7377C3B98ECD77")
    
public IndexedPropertyChangeEvent(Object source, String propertyName,
            Object oldValue, Object newValue, int index) {
        super(source, propertyName, oldValue, newValue);
        this.index = index;
    }

    /**
     * Returns the index of the property that was changed in this event.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.629 -0500", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "96CCC69099797392A28F97F5383D17E0")
    
public int getIndex() {
        return index;
    }
}

