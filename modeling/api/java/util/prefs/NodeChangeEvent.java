/* Licensed to the Apache Software Foundation (ASF) under one or more
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
 * This is the event class to indicate that one child of the preference node has
 * been added or deleted.
 * <p>
 * Please note that although the class is marked as {@code Serializable} by
 * inheritance from {@code EventObject}, this type is not intended to be serialized
 * so the serialization methods do nothing but throw a {@code NotSerializableException}.
 *
 * @see java.util.prefs.Preferences
 * @see java.util.prefs.NodeChangeListener
 *
 * @since 1.4
 */
public class NodeChangeEvent extends EventObject implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.050 -0400", hash_original_field = "E253B3365351758F8E7FCB534C7B1A75", hash_generated_field = "E7EC324E9230A0D0B712B1D8804AA636")


    private static final long serialVersionUID = 8068949086596572957L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.051 -0400", hash_original_field = "E523DF303D568BD1811C4F2D90A3F007", hash_generated_field = "2053076B3278DAD34D847F5B91322C9F")


    private  Preferences parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.051 -0400", hash_original_field = "0C395366ABBF313DCAD2C4CE96574C96", hash_generated_field = "B1325B907AD6C2C5DC44C68CFB0B56D2")

    private  Preferences child;

    /**
     * Constructs a new {@code NodeChangeEvent} instance.
     *
     * @param p
     *            the {@code Preferences} instance that fired this event; this object is
     *            considered as the event source.
     * @param c
     *            the child {@code Preferences} instance that was added or deleted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.052 -0400", hash_original_method = "674B3BAC71C713DB8BEEE04B45C5DCC6", hash_generated_method = "2B8CADC0391D4C4DFBC40D5DD85CC468")
    
public NodeChangeEvent (Preferences p, Preferences c) {
        super(p);
        parent = p;
        child = c;
    }

    /**
     * Gets the {@code Preferences} instance that fired this event.
     *
     * @return the {@code Preferences} instance that fired this event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.052 -0400", hash_original_method = "7F38DEA34DC2AF59E14644A322169E2D", hash_generated_method = "1F16607DF9FBF363A6E13F5CB4F7764D")
    
public Preferences getParent() {
        return parent;
    }

    /**
     * Gets the child {@code Preferences} node that was added or removed.
     *
     * @return the added or removed child {@code Preferences} node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.052 -0400", hash_original_method = "54331EEE2663158455B5C71A3E26BC78", hash_generated_method = "3344B874CDD30A9A26ACE42210EF20C0")
    
public Preferences getChild() {
        return child;
    }

    /**
     * This method always throws a <code>NotSerializableException</code>,
     * because this object cannot be serialized,
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.053 -0400", hash_original_method = "FAEDC6A34DDF69892256309EA97E7CD3", hash_generated_method = "E49CDB19A0AE3B003E170829C6DC2BAC")
    
private void writeObject (ObjectOutputStream out) throws IOException {
        throw new NotSerializableException();
    }

    /**
     * This method always throws a <code>NotSerializableException</code>,
     * because this object cannot be serialized,
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.053 -0400", hash_original_method = "56227BC78914E69D5BB5837C37E02869", hash_generated_method = "427EB60DA47DD5CB266DE75BAAB297A7")
    
private void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new NotSerializableException();
    }
}
