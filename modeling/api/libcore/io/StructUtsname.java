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

public final class StructUtsname {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.035 -0500", hash_original_field = "97ED6A6DCDD685F9B3DC68D91EF7195D", hash_generated_field = "06EE67511C7267E177679ED8D9906A87")

    public  String sysname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.038 -0500", hash_original_field = "063CA11C88281A66D3723E0AA05932E2", hash_generated_field = "5A29BC3D798865B30AF3074E4C0D6EEE")

    public  String nodename;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.041 -0500", hash_original_field = "1274981E6885D0667CEE13BB63F79D31", hash_generated_field = "704FF7DA5C540CEA121D5F9E29DC7423")

    public  String release;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.043 -0500", hash_original_field = "E7C7F9C42A2A22D94FED803CEAE19197", hash_generated_field = "541C5F053DD8C944D595E47B62A0349B")

    public  String version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.045 -0500", hash_original_field = "9081D9187256DBF84B010DA1BCB2D192", hash_generated_field = "E93761CEF58612877F770D81A7789428")

    public  String machine;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:28.048 -0500", hash_original_method = "ABD276C824D50C395959B30AFCABD3AD", hash_generated_method = "ABD276C824D50C395959B30AFCABD3AD")
    
StructUtsname(String sysname, String nodename, String release, String version, String machine) {
        this.sysname = sysname;
        this.nodename = nodename;
        this.release = release;
        this.version = version;
        this.machine = machine;
    }
    
}

