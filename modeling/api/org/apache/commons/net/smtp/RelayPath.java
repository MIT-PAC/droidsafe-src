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
import java.util.Enumeration;
import java.util.Vector;

/***
 * A class used to represent forward and reverse relay paths.  The
 * SMTP MAIL command requires a reverse relay path while the SMTP RCPT
 * command requires a forward relay path.  See RFC 821 for more details.
 * In general, you will not have to deal with relay paths.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SMTPClient
 ***/

public final class RelayPath
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.750 -0500", hash_original_field = "39AF19FC1C5F602993083D9B674B9515", hash_generated_field = "39AF19FC1C5F602993083D9B674B9515")

    Vector _path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.753 -0500", hash_original_field = "813E6AD7BE51C8624C89B9E3A5A1B35D", hash_generated_field = "813E6AD7BE51C8624C89B9E3A5A1B35D")

    String _emailAddress;

    /***
     * Create a relay path with the specified email address as the ultimate
     * destination.
     * <p>
     * @param emailAddress The destination email address.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.756 -0500", hash_original_method = "5F136D339506768265D1EADC5C1F6BBD", hash_generated_method = "A22A62F74CBC653ED8E2E0F0C2E714A5")
    @DSComment("Constructor")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public RelayPath(String emailAddress)
    {
        _path = new Vector();
        _emailAddress = emailAddress;
    }

    /***
     * Add a mail relay host to the relay path.  Hosts are added left to
     * right.  For example, the following will create the path
     * <code><b> &lt @bar.com,@foo.com:foobar@foo.com &gt </b></code>
     * <pre>
     * path = new RelayPath("foobar@foo.com");
     * path.addRelay("bar.com");
     * path.addRelay("foo.com");
     * </pre>
     * <p>
     * @param hostname The host to add to the relay path.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.760 -0500", hash_original_method = "7912556ED62AEE2B5498669D6D968833", hash_generated_method = "AAC5FEE875714E8157FED6F87A0F39FE")
    
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void addRelay(String hostname)
    {
        _path.addElement(hostname);
    }

    /***
     * Return the properly formatted string representation of the relay path.
     * <p>
     * @return The properly formatted string representation of the relay path.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:00.768 -0500", hash_original_method = "8E799345410D5A9E18D25167F32F6404", hash_generated_method = "5E5CABB43821B92D3373B636ACA540B2")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    
public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        Enumeration hosts;

        buffer.append('<');

        hosts = _path.elements();

        if (hosts.hasMoreElements())
        {
            buffer.append('@');
            buffer.append((String)hosts.nextElement());

            while (hosts.hasMoreElements())
            {
                buffer.append(",@");
                buffer.append((String)hosts.nextElement());
            }
            buffer.append(':');
        }

        buffer.append(_emailAddress);
        buffer.append('>');

        return buffer.toString();
    }

}
