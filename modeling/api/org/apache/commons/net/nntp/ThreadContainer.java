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
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.nntp;

/**
 * A placeholder utility class, used for constructing a tree of Threadables
 * Original implementation by Jamie Zawinski.
 * See the Grendel source for more details <a href="http://lxr.mozilla.org/mozilla/source/grendel/sources/grendel/view/Threader.java#511">here</a>
 * Threadable objects
 * @author Rory Winston <rwinston@apache.org>
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
class ThreadContainer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.829 -0400", hash_original_field = "E3C10FFD6065D4832C4C40C0828ED098", hash_generated_field = "E3C10FFD6065D4832C4C40C0828ED098")

    Threadable threadable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.830 -0400", hash_original_field = "B113DECE535528E04DE6A2FF1D3A7A66", hash_generated_field = "B113DECE535528E04DE6A2FF1D3A7A66")

    ThreadContainer parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.832 -0400", hash_original_field = "2F04C3D045AFDDBFF1ADE1FB78CD106D", hash_generated_field = "2F04C3D045AFDDBFF1ADE1FB78CD106D")

    ThreadContainer next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.833 -0400", hash_original_field = "1FB26C6F4B4014B9E8F7155476C83917", hash_generated_field = "1FB26C6F4B4014B9E8F7155476C83917")

    ThreadContainer child;

    /**
     *
     * @param container
     * @return true if child is under self's tree. Detects circular references
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.834 -0400", hash_original_method = "F190E52C2CBEAF17E813F33854D9B2C0", hash_generated_method = "F190E52C2CBEAF17E813F33854D9B2C0")
    
boolean findChild(ThreadContainer target) {
        if (child == null) {
            return false;
        } else if (child == target) {
            return true;
        } else {
            return child.findChild(target);
        }
    }

    // Copy the ThreadContainer tree structure down into the underlying Threadable objects
    // (Make the Threadable tree look like the ThreadContainer tree)
    // TODO convert this to an iterative function - this can blow the stack
    // with very large Threadable trees
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.836 -0400", hash_original_method = "CD0172DF512F46B285B6B588683B265F", hash_generated_method = "CD0172DF512F46B285B6B588683B265F")
    
void flush() {
        if (parent != null && threadable == null) {
            throw new RuntimeException("no threadable in " + this.toString());
        }

        parent = null;

        if (threadable != null) {
            threadable.setChild(child == null ? null : child.threadable);
        }

        if (child != null) {
            child.flush();
            child = null;
        }

        if (threadable != null) {
            threadable.setNext(next == null ? null : next.threadable);
        }

        if (next != null) {
            next.flush();
            next = null;
        }

        threadable = null;
    }

    /**
     * Reverse the entire set of children
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:51.838 -0400", hash_original_method = "B04A2B3B6B1C783F73E39FBCC06ABA1D", hash_generated_method = "83C9C378E9AEAA0B06DB29B5CA1E4601")
    
void reverseChildren() {
        if (child != null) {
            ThreadContainer kid, prev, rest;
            for (prev = null, kid = child, rest = kid.next;
                kid != null;
                prev = kid,
                    kid = rest,
                    rest = (rest == null ? null : rest.next))
            {
                kid.next = prev;
            }

            child = prev;

            // Do it for the kids
            for (kid = child; kid != null; kid = kid.next) {
                kid.reverseChildren();
            }
        }
    }
}
