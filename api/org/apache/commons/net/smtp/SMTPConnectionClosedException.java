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
package org.apache.commons.net.smtp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/***
 * SMTPConnectionClosedException is used to indicate the premature or
 * unexpected closing of an SMTP connection resulting from a
 * {@link org.apache.commons.net.smtp.SMTPReply#SERVICE_NOT_AVAILABLE SMTPReply.SERVICE_NOT_AVAILABLE }
 *  response (SMTP reply code 421) to a
 * failed SMTP command.  This exception is derived from IOException and
 * therefore may be caught either as an IOException or specifically as an
 * SMTPConnectionClosedException.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SMTP
 * @see SMTPClient
 ***/

public final class SMTPConnectionClosedException extends IOException
{

    /*** Constructs a SMTPConnectionClosedException with no message ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.846 -0500", hash_original_method = "18514752AF9765DC2B592BA63E6E31BB", hash_generated_method = "0BBE24FD00D06DA5CCB82C2749A74814")
    
public SMTPConnectionClosedException()
    {
        super();
    }

    /***
     * Constructs a SMTPConnectionClosedException with a specified message.
     * <p>
     * @param message  The message explaining the reason for the exception.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.850 -0500", hash_original_method = "662F89856A3B1E88FA54A5AA5FC0E396", hash_generated_method = "737A6B97701E0AB20FAA2BFB74B032C0")
    
public SMTPConnectionClosedException(String message)
    {
        super(message);
    }

}
