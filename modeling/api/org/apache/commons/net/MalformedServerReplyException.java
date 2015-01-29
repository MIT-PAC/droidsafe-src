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
package org.apache.commons.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/***
 * This exception is used to indicate that the reply from a server
 * could not be interpreted.  Most of the NetComponents classes attempt
 * to be as lenient as possible when receiving server replies.  Many
 * server implementations deviate from IETF protocol specifications, making
 * it necessary to be as flexible as possible.  However, there will be
 * certain situations where it is not possible to continue an operation
 * because the server reply could not be interpreted in a meaningful manner.
 * In these cases, a MalformedServerReplyException should be thrown.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public class MalformedServerReplyException extends IOException
{

    /*** Constructs a MalformedServerReplyException with no message ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:51.067 -0500", hash_original_method = "BD3412B94A9D5270DAB4E49CF4DCDC4E", hash_generated_method = "30E67CC927DD90B3E142FC63DA075985")
    
public MalformedServerReplyException()
    {
        super();
    }

    /***
     * Constructs a MalformedServerReplyException with a specified message.
     * <p>
     * @param message  The message explaining the reason for the exception.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:51.087 -0500", hash_original_method = "C82C5551751BCEB1A1B9782968036383", hash_generated_method = "561C7F8CC940BAC2190BD2357E257E33")
    
public MalformedServerReplyException(String message)
    {
        super(message);
    }

}
