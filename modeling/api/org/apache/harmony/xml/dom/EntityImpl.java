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
import org.w3c.dom.Entity;
import org.w3c.dom.Node;

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
public class EntityImpl extends NodeImpl implements Entity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.198 -0400", hash_original_field = "AB961B0AB0EBA4C02135EE56EEB553A7", hash_generated_field = "EE265551263A48E4C9A95C64170C0E22")


    private String notationName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.198 -0400", hash_original_field = "ECC82A593B8CAF77D5E8E35978CAB7C3", hash_generated_field = "665F39758BD14ED3FA65D5A90F8F6DA5")


    private String publicID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.199 -0400", hash_original_field = "0EFEFA79FB9C455CF108F420D8462143", hash_generated_field = "83BD3571475BC4C0C301203EC49F6EAB")


    private String systemID;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.199 -0400", hash_original_method = "527545919EE53A32282AE5F689A509DF", hash_generated_method = "527545919EE53A32282AE5F689A509DF")
    
EntityImpl(DocumentImpl document, String notationName, String publicID,
            String systemID) {
        super(document);
        this.notationName = notationName;
        this.publicID = publicID;
        this.systemID = systemID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.200 -0400", hash_original_method = "36F1E8AF8F3C6AA0D06D1AA52B88D6D8", hash_generated_method = "12DDE34F139E140E64895CD09FECDE0B")
    
@Override
    public String getNodeName() {
        return getNotationName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.200 -0400", hash_original_method = "CDBC1E71CDC4298FA4D79AB345AF6A66", hash_generated_method = "688671E95AF0552FC51C11F2C60130A4")
    
@Override
    public short getNodeType() {
        return Node.ENTITY_NODE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.201 -0400", hash_original_method = "2F85A26F14E1183904EAFE038A85BD7A", hash_generated_method = "C9189A7A3C1BDF47C607FD8FCCAF76C2")
    
public String getNotationName() {
        return notationName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.201 -0400", hash_original_method = "3764ACF5E228A5599B315FEFAA7ED63E", hash_generated_method = "768F9DC03D137583E5D201961F42D03A")
    
public String getPublicId() {
        return publicID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.202 -0400", hash_original_method = "FC31E76A50E6C53D464FD8A722D84896", hash_generated_method = "4709370369E81AB22F35AFC6936C021E")
    
public String getSystemId() {
        return systemID;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.202 -0400", hash_original_method = "8DE6085BB37FEB7D3F0CBBFA966BC3EE", hash_generated_method = "EEE332D5A34C980E0E175F7D1BC0C9AB")
    
public String getInputEncoding() {
        throw new UnsupportedOperationException(); // TODO
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.203 -0400", hash_original_method = "C16CB050B209DA4AA0A56B31127D7A46", hash_generated_method = "BFA060EF12D4F3D99C7B90A3E6F92DBA")
    
public String getXmlEncoding() {
        throw new UnsupportedOperationException(); // TODO
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:11.203 -0400", hash_original_method = "A505435E4BE6E9F8C2F75C62958CE981", hash_generated_method = "94EF80E3193AA939E5F9A0645A67C5EB")
    
public String getXmlVersion() {
        throw new UnsupportedOperationException(); // TODO
    }
}
