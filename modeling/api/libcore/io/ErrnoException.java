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
import java.io.IOException;
import java.net.SocketException;

public final class ErrnoException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.436 -0500", hash_original_field = "4E55026DE98CFA86DA317EEAE8A270FB", hash_generated_field = "3A7419DC5D02B665865D1D41C31D2769")

    private  String functionName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.438 -0500", hash_original_field = "D78075B01C885E74DB3E5E6E1FCBE2D1", hash_generated_field = "D05FB512281BC7A92BFD5BEF738B1D62")

    public  int errno;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.441 -0500", hash_original_method = "0DF4193C9C2664F33DC38063504784DA", hash_generated_method = "B2880BEA366EDF151377A615B38D8D92")
    
public ErrnoException(String functionName, int errno) {
        this.functionName = functionName;
        this.errno = errno;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.443 -0500", hash_original_method = "BE4619378388F8812C9CF2AE8895CE85", hash_generated_method = "5FD42C0EA20824E6D1160D760B2F930B")
    
public ErrnoException(String functionName, int errno, Throwable cause) {
        super(cause);
        this.functionName = functionName;
        this.errno = errno;
    }

    /**
     * Converts the stashed function name and errno value to a human-readable string.
     * We do this here rather than in the constructor so that callers only pay for
     * this if they need it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.446 -0500", hash_original_method = "911EB712B1CEA729911922ADFC942179", hash_generated_method = "53A9666ACEFF8B8418191A69426AAC6E")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @Override public String getMessage() {
        String errnoName = OsConstants.errnoName(errno);
        if (errnoName == null) {
            errnoName = "errno " + errno;
        }
        String description = Libcore.os.strerror(errno);
        return functionName + " failed: " + errnoName + " (" + description + ")";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.448 -0500", hash_original_method = "F39DB956D71AD491CF421ED6963B5FCE", hash_generated_method = "E421CEF79B6715545A4D27BF5CA5E054")
    
public IOException rethrowAsIOException() throws IOException {
        IOException newException = new IOException(getMessage());
        newException.initCause(this);
        throw newException;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.450 -0500", hash_original_method = "8BB4A81BC702A752206578FEF42C6BB1", hash_generated_method = "E8789691CFB60648E153334A3F2E15D9")
    
public SocketException rethrowAsSocketException() throws SocketException {
        throw new SocketException(getMessage(), this);
    }
    
}

