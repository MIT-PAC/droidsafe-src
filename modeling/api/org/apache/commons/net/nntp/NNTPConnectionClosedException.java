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
package org.apache.commons.net.nntp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/***
 * NNTPConnectionClosedException is used to indicate the premature or
 * unexpected closing of an NNTP connection resulting from a
 * {@link org.apache.commons.net.nntp.NNTPReply#SERVICE_DISCONTINUED NNTPReply.SERVICE_DISCONTINUED }
 *  response (NNTP reply code 400) to a
 * failed NNTP command.  This exception is derived from IOException and
 * therefore may be caught either as an IOException or specifically as an
 * NNTPConnectionClosedException.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see NNTP
 * @see NNTPClient
 ***/

public final class NNTPConnectionClosedException extends IOException
{

    /*** Constructs a NNTPConnectionClosedException with no message ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.993 -0500", hash_original_method = "4E1EBB3BBAC8D401DF269C3E01907C25", hash_generated_method = "3F41CB72EDBFBA4B8071CFDBE53B872B")
    
public NNTPConnectionClosedException()
    {
        super();
    }

    /***
     * Constructs a NNTPConnectionClosedException with a specified message.
     * <p>
     * @param message  The message explaining the reason for the exception.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.996 -0500", hash_original_method = "6054E23D0D81F613FCE07FC6523D2D13", hash_generated_method = "245D71CD2C0456855913E82F38D75EE9")
    
public NNTPConnectionClosedException(String message)
    {
        super(message);
    }

}
