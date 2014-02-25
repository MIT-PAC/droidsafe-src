/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/**
 * The CopyStreamException class is thrown by the org.apache.commons.io.Util
 * copyStream() methods.  It stores the number of bytes confirmed to
 * have been transferred before an I/O error as well as the IOException
 * responsible for the failure of a copy operation.
 * @see Util
 * @author <a href="mailto:savarese@apache.org">Daniel F. Savarese</a>
 * @version $Id: CopyStreamException.java 165675 2005-05-02 20:09:55Z rwinston $
 */
public class CopyStreamException extends IOException
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.054 -0500", hash_original_field = "588067F15A284DFD9EE3EB09D591673F", hash_generated_field = "837439953D51ECB492B4F24E0B76C052")

    private long totalBytesTransferred;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.057 -0500", hash_original_field = "16AF630F68F506CEC783A5935562EBA8", hash_generated_field = "23396777E455D0D6898C8E4450BC4F2D")

    private IOException ioException;

    /**
     * Creates a new CopyStreamException instance.
     * @param message  A message describing the error.
     * @param bytesTransferred  The total number of bytes transferred before
     *        an exception was thrown in a copy operation.
     * @param exception  The IOException thrown during a copy operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.061 -0500", hash_original_method = "3FBE7BF8C34BE1586BD3FB61F6724F2F", hash_generated_method = "2F77D8C2A02E8DDB4F8B16E6421D8E7F")
    
public CopyStreamException(String message,
                               long bytesTransferred,
                               IOException exception)
    {
        super(message);
        totalBytesTransferred = bytesTransferred;
        ioException = exception;
    }

    /**
     * Returns the total number of bytes confirmed to have
     * been transferred by a failed copy operation.
     * @return The total number of bytes confirmed to have
     * been transferred by a failed copy operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.064 -0500", hash_original_method = "C28B76EE4358A62CAE2EB5BA12A6EFD5", hash_generated_method = "CA66174706A724EDF639914843DF4E73")
    
public long getTotalBytesTransferred()
    {
        return totalBytesTransferred;
    }

    /**
     * Returns the IOException responsible for the failure of a copy operation.
     * @return The IOException responsible for the failure of a copy operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.068 -0500", hash_original_method = "E95CA5C5CC4C3C4034B99C0746930F29", hash_generated_method = "0368ABD64BA9D6CBD1FBE9C1A3A11E11")
    
public IOException getIOException()
    {
        return ioException;
    }
}
