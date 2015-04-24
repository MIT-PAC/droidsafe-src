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
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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


package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.Comment;
import org.w3c.dom.Node;

public final class CommentImpl extends CharacterDataImpl implements Comment {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.389 -0500", hash_original_method = "73927E77C0FC42AE226BC21B47EED77C", hash_generated_method = "73927E77C0FC42AE226BC21B47EED77C")
    
CommentImpl(DocumentImpl document, String data) {
        super(document, data);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.392 -0500", hash_original_method = "AADC148D3C6535A85098796D78F74F64", hash_generated_method = "65E9386289DC6D5E243C8CF492D402D2")
    
@Override
    public String getNodeName() {
        return "#comment";
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.394 -0500", hash_original_method = "6EA19FED584EC66A374D4E0A8EF9DBF2", hash_generated_method = "7B8239D5167E5C46B44D979DF3CD3C79")
    
@Override
    public short getNodeType() {
        return Node.COMMENT_NODE;
    }

    /**
     * Returns true if this comment contains the illegal character sequence
     * "--". Such nodes may not be serialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.396 -0500", hash_original_method = "F249C6EFBACF4B954D25B46FE7AAC81B", hash_generated_method = "0B59CD366EE309AB27F9B51BD9267691")
    
public boolean containsDashDash() {
        return buffer.indexOf("--") != -1;
    }
    
}

