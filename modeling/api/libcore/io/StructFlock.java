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
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StructFlock {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.436 -0500", hash_original_field = "195DBF6C9F07DA1D55577092198A87FA", hash_generated_field = "F9D431F6400B333E4DEC5C071DC91AEB")

    public short l_type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.439 -0500", hash_original_field = "F08ADF56A835E767C27635F2587B9464", hash_generated_field = "0463453A1AA9CF88BDF12C2A0B513A73")

    public short l_whence;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.441 -0500", hash_original_field = "92BFDEF8DC1A6D45DA6A60AA6A1C1BA2", hash_generated_field = "0348CDD1CD8793E70282CBBC56AD1394")

    public long l_start;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.443 -0500", hash_original_field = "BC96892751020D7ACFD00E2D350DE668", hash_generated_field = "7D66A4AF407BCCCD334EC982CFAE22BF")

    /** Byte count to operate on. */
    public long l_len;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:20.445 -0500", hash_original_field = "EF00B22C10DD3F1951DAFDD4F788B882", hash_generated_field = "DF56723A36435A1A3E6E9853DC718F84")

    /** Process blocking our lock (filled in by F_GETLK, otherwise unused). */
    public int l_pid;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:24.794 -0400", hash_original_method = "DFA63A134B73478BDD4F5CF409821F5F", hash_generated_method = "DFA63A134B73478BDD4F5CF409821F5F")
    public StructFlock ()
    {
        //Synthesized constructor
    }

}

