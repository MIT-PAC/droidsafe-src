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


package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

abstract class DoubleArrayBuffer extends DoubleBuffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.049 -0500", hash_original_field = "DF557CDEA557661E312EE6624F170134", hash_generated_field = "72A67E62C40D09BAE43910B3E5CACC06")

    protected  double[] backingArray;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.052 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected  int offset;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.054 -0500", hash_original_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE", hash_generated_method = "3F3E4A2A5ABE550DAD549AD9F5CD19DE")
    
DoubleArrayBuffer(double[] array) {
        this(array.length, array, 0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.057 -0500", hash_original_method = "6003BB432EE138547D90D60175004272", hash_generated_method = "6003BB432EE138547D90D60175004272")
    
DoubleArrayBuffer(int capacity) {
        this(capacity, new double[capacity], 0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.060 -0500", hash_original_method = "BFD112F1B44B2A6AED2367002E1D0285", hash_generated_method = "BFD112F1B44B2A6AED2367002E1D0285")
    
DoubleArrayBuffer(int capacity, double[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.062 -0500", hash_original_method = "CBBA623098702DBD3F5C6B97B033DEBD", hash_generated_method = "B3440A5BDF7CECE3A1A8DB037413481B")
    
@Override
    public final double get() {
        if (position == limit) {
            throw new BufferUnderflowException();
        }
        return backingArray[offset + position++];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.065 -0500", hash_original_method = "0637023D2B498B1330CE2AA53BD56A5A", hash_generated_method = "E3D15485047DEFFEAA5C31631B0A3500")
    
@Override
    public final double get(int index) {
        checkIndex(index);
        return backingArray[offset + index];
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.067 -0500", hash_original_method = "DBA28E4E7AFB8E492F1C52FCFBB2DA2D", hash_generated_method = "60DDA695F6712D9BDB0521D60F26295C")
    
@Override
    public final DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        if (doubleCount > remaining()) {
            throw new BufferUnderflowException();
        }
        System.arraycopy(backingArray, offset + position, dst, dstOffset, doubleCount);
        position += doubleCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.071 -0500", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "1EC9A508074FE2792E86546C8EBA9E2B")
    
@Override
    public final boolean isDirect() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.074 -0500", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "FF53E3A2EB4F54AB08FAE8FA7C0C29DD")
    
@Override
    public final ByteOrder order() {
        return ByteOrder.nativeOrder();
    }
    
}

