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
import java.io.OutputStream;
import java.util.Arrays;

final class FixedLengthOutputStream extends AbstractHttpOutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.485 -0500", hash_original_field = "E040E41AD170B59C0C0B918B5BFE7983", hash_generated_field = "67AC7536EB45CC65D4356C94551DF297")

    private  OutputStream socketOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.487 -0500", hash_original_field = "85E14E76D885CFD0C41B5E514C78B157", hash_generated_field = "ECAE5742BF4A68ADC431E811786D5F2D")

    private int bytesRemaining;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.489 -0500", hash_original_method = "CD6D5F7765163EE89DC0FFBAC0DC51D9", hash_generated_method = "0C6D05D16D091EB795516BBF9E56B72B")
    
public FixedLengthOutputStream(OutputStream socketOut, int bytesRemaining) {
        this.socketOut = socketOut;
        this.bytesRemaining = bytesRemaining;
    }

    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.492 -0500", hash_original_method = "954563C6DA4D081D04FBFCB6C3DCBDF3", hash_generated_method = "2800F8B50156B94FD924ED7965570D8B")
    
@Override public void write(byte[] buffer, int offset, int count) throws IOException {
        checkNotClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        if (count > bytesRemaining) {
            throw new IOException("expected " + bytesRemaining + " bytes but received " + count);
        }
        socketOut.write(buffer, offset, count);
        bytesRemaining -= count;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.495 -0500", hash_original_method = "5CB5A053EE4A231C6D0A0D598E9BEDBB", hash_generated_method = "304DBF513455DAB903E1E5D173E3CB18")
    
@Override public void flush() throws IOException {
        if (closed) {
            return; // don't throw; this stream might have been closed on the caller's behalf
        }
        socketOut.flush();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:34.497 -0500", hash_original_method = "FCB6BF5DC7C6AA8912495FC6DAF3D35C", hash_generated_method = "079CB3A803854F6F5634D5FA3EFEAB3A")
    
@Override public void close() throws IOException {
        if (closed) {
            return;
        }
        closed = true;
        if (bytesRemaining > 0) {
            throw new IOException("unexpected end of stream");
        }
    }
    
}

