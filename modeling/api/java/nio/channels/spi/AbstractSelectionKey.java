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


package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.channels.SelectionKey;

public abstract class AbstractSelectionKey extends SelectionKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.225 -0500", hash_original_field = "FFFCC50D3A278EF95DEB022E99DE2B21", hash_generated_field = "FFFCC50D3A278EF95DEB022E99DE2B21")

    boolean isValid = true;

    /**
     * Constructs a new {@code AbstractSelectionKey}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.228 -0500", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "9B4E27A7807670D7CB0964E7593083F7")
    
protected AbstractSelectionKey() {
    }

    /**
     * Indicates whether this key is valid. A key is valid as long as it has not
     * been canceled.
     *
     * @return {@code true} if this key has not been canceled, {@code false}
     *         otherwise.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.232 -0500", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "5CAB1804A992395EE26A5B382908E240")
    
@Override
    public final boolean isValid() {
        return isValid;
    }

    /**
     * Cancels this key.
     * <p>
     * A key that has been canceled is no longer valid. Calling this method on
     * an already canceled key does nothing.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.234 -0500", hash_original_method = "A279029257087CE11FC7A37CBDFB5215", hash_generated_method = "BBF29FCAD5F9A043B65C4DCCD2050B9A")
    
@Override
    public final void cancel() {
        if (isValid) {
            isValid = false;
            ((AbstractSelector) selector()).cancel(this);
        }
    }
    
}

