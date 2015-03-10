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


package org.apache.harmony.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.PrivateKey;

/**
 * PrivateKeyImpl
 */
public class PrivateKeyImpl implements PrivateKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.237 -0400", hash_original_field = "3BA9379725219D7AABC1298B23DD49BB", hash_generated_field = "DBBFA2F4EC54A18442D7FA3383CD1141")

    private static final long serialVersionUID = 7776497482533790279L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.238 -0400", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")


    private String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.238 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")


    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.239 -0400", hash_original_method = "E183852E8B149F1DFC8D6640C740C43F", hash_generated_method = "A83A56E3DAAF4D66E714BBED11A175A5")
    
public PrivateKeyImpl(String algorithm) {
        this.algorithm = algorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.239 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.240 -0400", hash_original_method = "CC009CA66A5AFAFE0E87AA4EEC147948", hash_generated_method = "43296CF6FBF412872B3D9B986E95DFE6")
    
public String getFormat() {
        return "PKCS#8";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.240 -0400", hash_original_method = "599FA5A22426F4F74806600ADBE75211", hash_generated_method = "20B9841DBB9916D37ECB09E8A6674F14")
    
public byte[] getEncoded() {

        byte[] toReturn = new byte[encoding.length];
        System.arraycopy(encoding, 0, toReturn, 0, encoding.length);

        return toReturn;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.241 -0400", hash_original_method = "FB39469046999E87384F199ABFD48628", hash_generated_method = "5329B317B8654D6CDD75F163A5B36E96")
    
public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.241 -0400", hash_original_method = "D4C3CF018F2C15159F48F96E9A675D91", hash_generated_method = "1F7DC8F32E818A4073B2F1EAE0B1106D")
    
public void setEncoding(byte[] encoding) {
        this.encoding = new byte[encoding.length];
        System.arraycopy(encoding, 0, this.encoding, 0, encoding.length);
    }

}
