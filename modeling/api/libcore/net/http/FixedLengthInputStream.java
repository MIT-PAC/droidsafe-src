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

final class FixedLengthInputStream extends AbstractHttpInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.130 -0500", hash_original_field = "85E14E76D885CFD0C41B5E514C78B157", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.133 -0500", hash_original_method = "049E0503B3705DE79405E1FD5D2A2E5D", hash_generated_method = "2865748CFF0E77743A85D7999CAA3463")
    
public FixedLengthInputStream(InputStream is, CacheRequest cacheRequest,
            HttpEngine httpEngine, int length) throws IOException {
        super(is, httpEngine, cacheRequest);
        bytesRemaining = length;
        if (bytesRemaining == 0) {
            endOfInput(true);
        }
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.136 -0500", hash_original_method = "5B284B9FC407E028AC176D716362F3C7", hash_generated_method = "CE6C6291522C34C8FBC42B445E42AA67")
    
@Override public int read(byte[] buffer, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        checkNotClosed();
        if (bytesRemaining == 0) {
            return -1;
        }
        int read = in.read(buffer, offset, Math.min(count, bytesRemaining));
        if (read == -1) {
            unexpectedEndOfInput(); // the server didn't supply the promised content length
            throw new IOException("unexpected end of stream");
        }
        bytesRemaining -= read;
        cacheWrite(buffer, offset, read);
        if (bytesRemaining == 0) {
            endOfInput(true);
        }
        return read;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.139 -0500", hash_original_method = "7AFD793A00CEC972BF0DC212CD2F3F7C", hash_generated_method = "A6DF3D5156AB0C395F5392D7373836BD")
    
@Override public int available() throws IOException {
        checkNotClosed();
        return bytesRemaining == 0 ? 0 : Math.min(in.available(), bytesRemaining);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:32.141 -0500", hash_original_method = "D3AA3AF2615FFDD211E9642D1EBA797E", hash_generated_method = "768FDB1E6D57C7631928CDD6A6DF191F")
    
@Override public void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (bytesRemaining != 0) {
            unexpectedEndOfInput();
        }
    }
    
}

