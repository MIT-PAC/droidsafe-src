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
import java.net.URL;
import java.security.cert.Certificate;

/**
 * Legacy security code; do not use.
 */
public class CodeSource implements Serializable {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:20.371 -0400", hash_original_method = "D4C876668FE9471607615AC9FAAE5380", hash_generated_method = "4AC795EDF30B2A224BD909067ADEE364")
    
public CodeSource(URL location, Certificate[] certs) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:20.371 -0400", hash_original_method = "6BB9DB68AFF3AD3D92949D5AEF316C19", hash_generated_method = "31C07D379FD6CC9B7F4C008AC6D3D219")
    
public CodeSource(URL location, CodeSigner[] signers) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:20.372 -0400", hash_original_method = "6020A065662221000E3F20D70138382C", hash_generated_method = "8096D1555B361C831A1EAD8FA5B1BEAF")
    
public final Certificate[] getCertificates() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:20.372 -0400", hash_original_method = "38815E69C10DF8AAA74DCF93B8EB81FB", hash_generated_method = "E943745B24B581CEA5B012F459F73DDC")
    
public final CodeSigner[] getCodeSigners() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:20.373 -0400", hash_original_method = "7F43974786C9B6766E0F06D3AFC89834", hash_generated_method = "37916840BC780A87C3FD7230239D6B2A")
    
public final URL getLocation() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:20.373 -0400", hash_original_method = "4B9CE524AB17149E2583F1CD133D00E2", hash_generated_method = "1E2D2E329B960E434C6A2D07ADCE2FE7")
    
public boolean implies(CodeSource cs) { return true; }
}
