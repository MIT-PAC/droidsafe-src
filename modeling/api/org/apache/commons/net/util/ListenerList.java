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
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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


package org.apache.commons.net.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Vector;

/**
 * @author Daniel F. Savarese
 */

public class ListenerList implements Serializable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.523 -0500", hash_original_field = "C7F9394F892C32AA025717A5661B7937", hash_generated_field = "41E4AA27276EF8B05B5BF60C3C8A8B78")

    private Vector __listeners;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.526 -0500", hash_original_method = "584E60922940A736A6FF41CA4C8DA8F7", hash_generated_method = "26BF69FF81734FEC6734C9CFDCAE02FC")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public ListenerList()
    {
        __listeners = new Vector();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.529 -0500", hash_original_method = "0AC17197E5276DE7CBA010BDA5C2B2F2", hash_generated_method = "3384F3269FB19A8535D85D4667FDCC96")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public synchronized void addListener(EventListener listener)
    {
        __listeners.addElement(listener);
        if (listener != null) {
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.532 -0500", hash_original_method = "AFCF3089FC23AA9DA53FAB7053CC96B3", hash_generated_method = "0561F686518CCF4B9F8531919422C161")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public synchronized void removeListener(EventListener listener)
    {
        __listeners.removeElement(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.535 -0500", hash_original_method = "CB1546203AA20A5E0C4825E35116EE10", hash_generated_method = "5EFDEDCF7F1AFF303B1BB0928D921F5E")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE) 
public synchronized Enumeration getListeners()
    {
        return ((Vector)__listeners.clone()).elements();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.539 -0500", hash_original_method = "2C5BC93715E39FD3F47AA06A65E1F674", hash_generated_method = "CE2515F9B8892AD16CCAB0E998136EA0")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public int getListenerCount()
    {
        return __listeners.size();
    }

}
