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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.CipherParameters;






public class AsymmetricKeyParameter implements CipherParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.099 -0500", hash_original_field = "B7CB1A33B0CE83673F166D8478A09AB7", hash_generated_field = "B7CB1A33B0CE83673F166D8478A09AB7")

    boolean privateKey;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.102 -0500", hash_original_method = "DD522CA24B87E383EA27DC7A872D3AC1", hash_generated_method = "898C7CED24B393AF329032EDF86A00A2")
    
public AsymmetricKeyParameter(
        boolean privateKey)
    {
        this.privateKey = privateKey;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.104 -0500", hash_original_method = "47130025E2A64A0FEA07D9052329E298", hash_generated_method = "C8569D7CC05279C4DCB51755F3509364")
    
public boolean isPrivate()
    {
        return privateKey;
    }

    
}

