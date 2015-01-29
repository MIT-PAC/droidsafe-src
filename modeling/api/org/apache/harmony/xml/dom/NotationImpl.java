/*
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

package org.apache.harmony.xml.dom;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.w3c.dom.Node;
import org.w3c.dom.Notation;

/**
 * Provides a straightforward implementation of the corresponding W3C DOM
 * interface. The class is used internally only, thus only notable members that
 * are not in the original interface are documented (the W3C docs are quite
 * extensive). Hope that's ok.
 * <p>
 * Some of the fields may have package visibility, so other classes belonging to
 * the DOM implementation can easily access them while maintaining the DOM tree
 * structure.
 */
public class NotationImpl extends LeafNodeImpl implements Notation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.847 -0400", hash_original_field = "AB961B0AB0EBA4C02135EE56EEB553A7", hash_generated_field = "EE265551263A48E4C9A95C64170C0E22")


    private String notationName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.847 -0400", hash_original_field = "ECC82A593B8CAF77D5E8E35978CAB7C3", hash_generated_field = "665F39758BD14ED3FA65D5A90F8F6DA5")


    private String publicID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.848 -0400", hash_original_field = "0EFEFA79FB9C455CF108F420D8462143", hash_generated_field = "83BD3571475BC4C0C301203EC49F6EAB")


    private String systemID;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.848 -0400", hash_original_method = "6E102E79F9FE396AC0B76DE522930080", hash_generated_method = "6E102E79F9FE396AC0B76DE522930080")
    
NotationImpl(DocumentImpl document, String notationName, String publicID,
            String systemID) {
        super(document);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.849 -0400", hash_original_method = "DD0BA530717328F1A227F3EB4B7DF4C5", hash_generated_method = "91A49F922D86D20CE3F1237BCDF3BA1C")
    
@Override
    public String getNodeName() {
        return notationName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.849 -0400", hash_original_method = "41593D1F994160644B756545114DB0D9", hash_generated_method = "4120C29315073847492AC65451AEF053")
    
@Override
    public short getNodeType() {
        return Node.NOTATION_NODE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.850 -0400", hash_original_method = "3764ACF5E228A5599B315FEFAA7ED63E", hash_generated_method = "768F9DC03D137583E5D201961F42D03A")
    
public String getPublicId() {
        return publicID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.850 -0400", hash_original_method = "FC31E76A50E6C53D464FD8A722D84896", hash_generated_method = "4709370369E81AB22F35AFC6936C021E")
    
public String getSystemId() {
        return systemID;
    }

}
