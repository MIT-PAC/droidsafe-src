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

/**
 * Legacy security code; do not use.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class SecurityPermission extends BasicPermission {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.868 -0400", hash_original_method = "7AE6B2D482BB6F722A3AD11771350486", hash_generated_method = "A92019097E4D56AFC420824B3A1C4DEE")
    
public SecurityPermission(String name) { super(""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.870 -0400", hash_original_method = "0840FA8C9F28F57701B57E15F0BF9837", hash_generated_method = "B00EBF584A72148A4426096A888D7CCB")
    
public SecurityPermission(String name, String action) { super("", ""); }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.871 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "3D225D3CE47DA77C079F578AAAC6007E")
    
@Override public String getActions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.873 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "7028504695C2B07EE227E4A73DB8D42F")
    
@Override public boolean implies(Permission permission) { return true; }
}
