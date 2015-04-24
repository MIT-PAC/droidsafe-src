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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Enumeration;

/**
 * Legacy security code; do not use.
 */
public abstract class Policy {
    /**
     * Legacy security code; do not use.
     */
    public static interface Parameters { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.807 -0400", hash_original_method = "BE2589FEC497CE3A3342418CEC8CAEB2", hash_generated_method = "7B362933912FC5B21DEF6E4FE5D59FDD")
    
public static Policy getInstance(String type, Policy.Parameters params) throws NoSuchAlgorithmException { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.808 -0400", hash_original_method = "4BB1C28BBCD15F47D94B43E068687140", hash_generated_method = "A50FCAD509FF6E4E67DA6867DE07DED5")
    
public static Policy getInstance(String type, Policy.Parameters params, String provider) throws NoSuchProviderException, NoSuchAlgorithmException { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.810 -0400", hash_original_method = "CCB05B9B9FD0F4420A8BDE6D714E39B4", hash_generated_method = "4C810BE6BCA95A031D6F23FDBEE60BB0")
    
public static Policy getInstance(String type, Policy.Parameters params, Provider provider) throws NoSuchAlgorithmException { return null; }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.816 -0400", hash_original_field = "78DED7E02183DCAA1FF812AA864B94C5", hash_generated_field = "007BFF7BEB8F273B0D27DC2BDFF4F1B3")


    public static final PermissionCollection UNSUPPORTED_EMPTY_COLLECTION = new AllPermissionCollection();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.823 -0400", hash_original_method = "9D82993D0932A62BD70000FF81975D90", hash_generated_method = "B8629171D8BBF7DB7AC94049D7D199CF")
    
public static Policy getPolicy() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.824 -0400", hash_original_method = "C9F1B1B9B736EBACA39EA75132DF0DDE", hash_generated_method = "9B33CDE17CD854508DDBDEA43E430DBE")
    
public static void setPolicy(Policy policy) { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.805 -0400", hash_original_method = "FC340901D3FFE96336885119E5E12783", hash_generated_method = "82EDBA7D4A27E18DE3BDB3E136CE799F")
    
public Policy() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.811 -0400", hash_original_method = "793E7F3E47CCF4FC16021D02404F78D6", hash_generated_method = "8FA91C6DFD96BB47930A244213129943")
    
public Policy.Parameters getParameters() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.812 -0400", hash_original_method = "93B0103D3606EA893FDB01FF974DCC75", hash_generated_method = "DB0477A4E4938AF064512B1B0C0F824B")
    
public Provider getProvider() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.813 -0400", hash_original_method = "3F0C20E3E5F8C5B29218C6820B7654DE", hash_generated_method = "406BD09246BEA79F711BCB8472391F3F")
    
public String getType() { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.817 -0400", hash_original_method = "9C95A983C72011A948690A6663166CCA", hash_generated_method = "5BBFD6A6DD5FB8D849648C047A7B7173")
    
public PermissionCollection getPermissions(CodeSource cs) { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.819 -0400", hash_original_method = "4A6E93C3985784ADBB4ABAE6DA6231A6", hash_generated_method = "8E2FD5A070FD8BF4881349D35C0738FB")
    
public void refresh() { }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.820 -0400", hash_original_method = "98FE30FC2B505FEA21B5BCD18FD20B86", hash_generated_method = "089844372DAE03993369AEC21AC3A9CF")
    
public PermissionCollection getPermissions(ProtectionDomain domain) { return null; }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.821 -0400", hash_original_method = "DD60462D7AE61A4B83CD64B93410AE50", hash_generated_method = "363E72618DD14C24A8F1656E695FFEDA")
    
public boolean implies(ProtectionDomain domain, Permission permission) { return true; }
}
