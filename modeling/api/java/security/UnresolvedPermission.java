/*
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

package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import java.security.cert.Certificate;

/**
 * Legacy security code; do not use.
 */
public final class UnresolvedPermission extends Permission implements Serializable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.006 -0400", hash_original_method = "220A2ED3B122380CFE43347D99486B9A", hash_generated_method = "A2BA393304F850C62E6C0F4EB83A3E59")
    
public UnresolvedPermission(String type, String name, String actions, Certificate[] certs) {
        super("");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.007 -0400", hash_original_method = "7554671462990B9F8448E45D185B8E61", hash_generated_method = "DEE8369069A22E131349A6BB830C2C57")
    
public String getUnresolvedName() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.009 -0400", hash_original_method = "BEB02FB565B91959B51CE16F13D8076C", hash_generated_method = "D45CD1ADC74891E6B8FDA94C9B4141A8")
    
public String getUnresolvedActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.010 -0400", hash_original_method = "CDF8EA02D9447971DF89D1EAB5385BF4", hash_generated_method = "32BD0D9D0BEEAFB17708ADA6758E4167")
    
public String getUnresolvedType() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.011 -0400", hash_original_method = "F5B6E5DDC8AAB6B747A34503A207CA0F", hash_generated_method = "FA3A6BF317B450CE48C30F83E1E407E3")
    
public Certificate[] getUnresolvedCerts() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.013 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "3D225D3CE47DA77C079F578AAAC6007E")
    
@Override public String getActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.014 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    
@Override public boolean implies(Permission permission) { return true; }
}
