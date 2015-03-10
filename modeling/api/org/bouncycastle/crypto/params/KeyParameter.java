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






public class KeyParameter implements CipherParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.423 -0500", hash_original_field = "874EBF47D328D135486F03BCE6DDD19A", hash_generated_field = "AEF19C0A7530E140588DCBA91FF66D28")

    private byte[]  key;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.425 -0500", hash_original_method = "63385B3E5C2FC85A4948D309DD0E5CB6", hash_generated_method = "C88ED3DD3DEBB066D26FFA6500109306")
    
public KeyParameter(
        byte[]  key)
    {
        this(key, 0, key.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.428 -0500", hash_original_method = "B61F1FEDEF5D4C73DB3CB7494F513C96", hash_generated_method = "6741BACA86A9DA894D9B323E620BE0C5")
    
public KeyParameter(
        byte[]  key,
        int     keyOff,
        int     keyLen)
    {
        this.key = new byte[keyLen];

        System.arraycopy(key, keyOff, this.key, 0, keyLen);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.430 -0500", hash_original_method = "4D0869BDED080E6228BF118F17313DFD", hash_generated_method = "F6BA40ED41B35932060F7CD0F4D88932")
    
public byte[] getKey()
    {
        return key;
    }

    
}

