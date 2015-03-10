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


package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.util.Arrays;

final class UnknownLengthHttpInputStream extends AbstractHttpInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.957 -0500", hash_original_field = "7C8ED02256EE7A13CC64F8BE47E22974", hash_generated_field = "A47BA202024AEED5382C6DACAC7B8715")

    private boolean inputExhausted;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.959 -0500", hash_original_method = "03287555569090C6D887554C44738812", hash_generated_method = "03287555569090C6D887554C44738812")
    
UnknownLengthHttpInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine) throws IOException {
        super(is, httpEngine, cacheRequest);
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.962 -0500", hash_original_method = "E2336783F7D37948479E1E76BEFE0EF2", hash_generated_method = "60867053817CC2934DD47C29AA0D185D")
    
@Override public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        if (in == null || inputExhausted) {
            return -1;
        }
        int read = in.read(buffer, offset, count);
        if (read == -1) {
            inputExhausted = true;
            endOfInput(false);
            return -1;
        }
        cacheWrite(buffer, offset, read);
        return read;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.964 -0500", hash_original_method = "10BF8275103D8B9D888D9077AFBF2526", hash_generated_method = "4B5A7EDE8E8172FFEB7CB29CB95E1A05")
    
@Override public int available() throws IOException {
        checkNotClosed();
        return in == null ? 0 : in.available();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:31.967 -0500", hash_original_method = "EFD48677D2EFEA5B0824ED8113A97C5A", hash_generated_method = "1F08B95B8160B2DAB74AFA7EBD977F9A")
    
@Override public void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (!inputExhausted) {
            unexpectedEndOfInput();
        }
    }
    
}

