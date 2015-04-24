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


package java.util.prefs;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventObject;

/**
 * This is the event class to indicate that a preference has been added, deleted
 * or updated.
 * <p>
 * Please note that although the class is marked as {@code Serializable} by
 * inheritance from {@code EventObject}, this type is not intended to be serialized
 * so the serialization methods do nothing but throw a {@code NotSerializableException}.
 *
 * @see java.util.prefs.Preferences
 * @see java.util.prefs.PreferenceChangeListener
 *
 * @since 1.4
 */
public class PreferenceChangeEvent extends EventObject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.611 -0400", hash_original_field = "ED19FE4D38EDBD2E812C1BB1F656D67C", hash_generated_field = "1BD666595B45279DD6015125C3BB9934")


    private static final long serialVersionUID = 793724513368024975L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.612 -0400", hash_original_field = "49AAD540236D6CB55A476E6F81B6855C", hash_generated_field = "5EAC742ECE86944E7714B70033F86A63")


    private  Preferences node;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.612 -0400", hash_original_field = "FFE7EE17DFA37A68070A0F0495753B29", hash_generated_field = "2E3018221E30480EB0F957E72002C7D8")


    private  String key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.612 -0400", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")


    private  String value;

    /**
     * Construct a new {@code PreferenceChangeEvent} instance.
     *
     * @param p
     *            the {@code Preferences} instance that fired this event; this object is
     *            considered as the event's source.
     * @param k
     *            the changed preference key.
     * @param v
     *            the new value of the changed preference, this value can be
     *            {@code null}, which means the preference has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.613 -0400", hash_original_method = "8691170822E4190A5E0A7153C404116B", hash_generated_method = "0688E981520ABBFAC7714D57A8309EF5")
    
public PreferenceChangeEvent(Preferences p, String k, String v) {
        super(p);
        node = p;
        key = k;
        value = v;
    }

    /**
     * Gets the key of the changed preference.
     *
     * @return the changed preference's key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.613 -0400", hash_original_method = "C39C8C9D5BC81C2FE68967748762171F", hash_generated_method = "864E9B692EEA007ED2B72251C0EF6A1F")
    
public String getKey() {
        return key;
    }

    /**
     * Gets the new value of the changed preference or {@code null} if the
     * preference has been removed.
     *
     * @return the new value of the changed preference or {@code null} if the
     *         preference has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.614 -0400", hash_original_method = "0325F8A2F62EA98F881CD395FDC57D8A", hash_generated_method = "F939CFDC42F33C0D68A62DAA490DBCB1")
    
public String getNewValue() {
        return value;
    }

    /**
     * Gets the {@code Preferences} instance that fired this event.
     *
     * @return the {@code Preferences} instance that fired this event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.614 -0400", hash_original_method = "D67C9A676B9C4FB958C43427A297287F", hash_generated_method = "96B3B3C3676CAF3F6EE56BFD4CC4F34A")
    
public Preferences getNode() {
        return node;
    }

    /**
     * This method always throws a <code>NotSerializableException</code>,
     * because this object cannot be serialized,
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.614 -0400", hash_original_method = "FAEDC6A34DDF69892256309EA97E7CD3", hash_generated_method = "E49CDB19A0AE3B003E170829C6DC2BAC")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        throw new NotSerializableException();
    }

    /**
     * This method always throws a <code>NotSerializableException</code>,
     * because this object cannot be serialized,
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.615 -0400", hash_original_method = "ECD12CC4BADF47D1D8366DBA2900D232", hash_generated_method = "3FB2B72032A3F3E152773D9A88A56A2A")
    
private void readObject(ObjectInputStream in) throws IOException{
        throw new NotSerializableException();
    }
}
