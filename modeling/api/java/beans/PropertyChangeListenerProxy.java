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


package java.beans;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.EventListenerProxy;

public class PropertyChangeListenerProxy extends EventListenerProxy implements PropertyChangeListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.311 -0500", hash_original_field = "F6E23082B68F75302CA6A0F5F57467FF", hash_generated_field = "F6E23082B68F75302CA6A0F5F57467FF")

    String propertyName;

    /**
     * Creates a new listener proxy that associates a listener with a property
     * name.
     *
     * @param propertyName
     *            the name of the associated property.
     * @param listener
     *            the listener to delegate incoming events to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.314 -0500", hash_original_method = "0B942B492C5F8BB18EE120311A2A0D6B", hash_generated_method = "678F242E04D04F6D88BA9B8744D64E7F")
    
public PropertyChangeListenerProxy(String propertyName,
            PropertyChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
    }

    /**
     * Returns the name of the property associated with this listener proxy.
     *
     * @return the name of the associated property.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.316 -0500", hash_original_method = "F855330D0A49F166D335D3D735B1EC12", hash_generated_method = "79D137ECBA6D10D7E0F2DC15CD7EDB65")
    
public String getPropertyName() {
        return propertyName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.318 -0500", hash_original_method = "BBFB0B3B3DD9FEC3EABA35E8C67A978E", hash_generated_method = "AF25D61E9DB4ACA7583E68CD25FCD032")
    
public void propertyChange(PropertyChangeEvent event) {
        PropertyChangeListener listener = (PropertyChangeListener) getListener();
        listener.propertyChange(event);
    }
    
}

