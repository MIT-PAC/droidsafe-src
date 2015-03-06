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


package java.security;

/**
 * Legacy security code; do not use.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ProtectionDomain {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.480 -0400", hash_original_method = "5891D211AA04A5FA0D83B61A16578B35", hash_generated_method = "C3EF6EE5247B6056B520EF809B624A37")
    
public ProtectionDomain(CodeSource cs, PermissionCollection permissions) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.480 -0400", hash_original_method = "8AF9E2C6AF4543AE654FB8AC965041A0", hash_generated_method = "10074C4FAFDD9190AC332DC5C2967FC3")
    
public ProtectionDomain(CodeSource cs, PermissionCollection permissions, ClassLoader cl, Principal[] principals) { }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.481 -0400", hash_original_method = "36D40DB51CE149D4D173272547E45D89", hash_generated_method = "70F20CE8BCE745598B2DC86A45BFB223")
    
public final ClassLoader getClassLoader() { return null; }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.481 -0400", hash_original_method = "65FBCDB1EF6730AA4782FE733CA5126A", hash_generated_method = "19B037FE5853EFBB77A0BF8E2F0601D2")
    
public final CodeSource getCodeSource() { return null; }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.482 -0400", hash_original_method = "CFFE4D5B0E68CF921A8B9CFC68B153D5", hash_generated_method = "0B37283FDD7953EDEB83CB5D5D2EF1E5")
    
public final PermissionCollection getPermissions() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.482 -0400", hash_original_method = "FC0016516B863D9708ADC9DFA60C3A75", hash_generated_method = "35145459D0AB071D705347D9B55F7C93")
    
public final Principal[] getPrincipals() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:22.483 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "F69C9FF3AB3B493B9445100E2E9B7695")
    
public boolean implies(Permission permission) { return true; }
}
