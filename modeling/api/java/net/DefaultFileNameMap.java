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
 * Copyright (C) 2010 The Android Open Source Project
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


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import libcore.net.MimeUtils;

class DefaultFileNameMap implements FileNameMap {
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.439 -0400", hash_original_method = "967DDE3A9286E19D23037DF9EB0654B3", hash_generated_method = "967DDE3A9286E19D23037DF9EB0654B3")
    public DefaultFileNameMap ()
    {
        //Synthesized constructor
    }
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.535 -0500", hash_original_method = "CD3BB5C1D36DDF595D7942DB441DE716", hash_generated_method = "383DA40FA4C20B646270A71CD8C2DB89")
    
public String getContentTypeFor(String filename) {
        if (filename.endsWith("/")) {
            // a directory, return html
            return MimeUtils.guessMimeTypeFromExtension("html");
        }
        int lastCharInExtension = filename.lastIndexOf('#');
        if (lastCharInExtension < 0) {
            lastCharInExtension = filename.length();
        }
        int firstCharInExtension = filename.lastIndexOf('.') + 1;
        String ext = "";
        if (firstCharInExtension > filename.lastIndexOf('/')) {
            ext = filename.substring(firstCharInExtension, lastCharInExtension);
        }
        return MimeUtils.guessMimeTypeFromExtension(ext.toLowerCase(Locale.US));
    }
    
}

