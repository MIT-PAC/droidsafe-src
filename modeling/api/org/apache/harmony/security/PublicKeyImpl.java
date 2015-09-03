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
import java.security.PublicKey;


/**
 * PublicKeyImpl
 */
public class PublicKeyImpl implements PublicKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.929 -0400", hash_original_field = "FED5EC8314206E9DE89005C2D126FC0B", hash_generated_field = "675A0864719F804C6A1A391EDE186691")

    private static final long serialVersionUID = 7179022516819534075L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.929 -0400", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")



    private byte[] encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.930 -0400", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")


    private String algorithm;


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.930 -0400", hash_original_method = "38832340CE126F874E90E61D5A30CC1B", hash_generated_method = "8573E5CAE85CBF2252852B17729BA1B6")
    
public PublicKeyImpl(String algorithm) {
        this.algorithm = algorithm;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.931 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "09B8CB0F05513E7BA5A386900D5BF6E6")
    
public String getAlgorithm() {
        return algorithm;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.931 -0400", hash_original_method = "52CFE6084CDA819966418EDF944DBC96", hash_generated_method = "7238AE3F6AC2664EEF973F2CB2EA7A49")
    
public String getFormat() {
        return "X.509";
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.932 -0400", hash_original_method = "E4C5AD3A0D102522A98A0D7703725F48", hash_generated_method = "0811E068D75C5AE9699C47C1F0DB2EEA")
    
public byte[] getEncoded() {
        byte[] result = new byte[encoding.length];
        System.arraycopy(encoding, 0, result, 0, encoding.length);
        return result;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.932 -0400", hash_original_method = "FB39469046999E87384F199ABFD48628", hash_generated_method = "5329B317B8654D6CDD75F163A5B36E96")
    
public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:07.933 -0400", hash_original_method = "D4C3CF018F2C15159F48F96E9A675D91", hash_generated_method = "1F7DC8F32E818A4073B2F1EAE0B1106D")
    
public void setEncoding(byte[] encoding) {
        this.encoding = new byte[encoding.length];
        System.arraycopy(encoding, 0, this.encoding, 0, encoding.length);
    }
}

