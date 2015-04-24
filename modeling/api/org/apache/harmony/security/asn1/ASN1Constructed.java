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

/**
* @author Vladimir N. Molotkov, Stepan M. Mishura
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class ASN1Constructed extends ASN1Type {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.020 -0500", hash_original_method = "9FFE4A234D2E2DB42C06DD57E257B3F5", hash_generated_method = "DDA4CA69895680CCA70E5259C13ABA9B")
    
protected ASN1Constructed(int tagNumber) {
        super(CLASS_UNIVERSAL, tagNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.022 -0500", hash_original_method = "0ED0D05BF14BE7B30955286BAE5204E3", hash_generated_method = "2EA06A250B4FC28D3ED6C6A2B565CACF")
    
protected ASN1Constructed(int tagClass, int tagNumber) {
        super(tagClass, tagNumber);
    }

    /**
     * Tests provided identifier.
     *
     * @param identifier - identifier to be verified
     * @return - true if identifier correspond to constructed identifier of
     *           this ASN.1 type, otherwise false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.024 -0500", hash_original_method = "B936C5375D6639A303C6027641033901", hash_generated_method = "0D91481D29B7299D61A329B8CF47B660")
    
public final boolean checkTag(int identifier) {
        return this.constrId == identifier;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.026 -0500", hash_original_method = "D76B5AEAE2B5495729712535531D2D80", hash_generated_method = "4E64FD309E4F4498BE08BC799A7BB31D")
    
public void encodeASN(BerOutputStream out) {
        out.encodeTag(constrId);
        encodeContent(out);
    }

    
}

