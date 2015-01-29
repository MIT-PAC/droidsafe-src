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
package org.apache.commons.net.pop3;

/***
 * POP3MessageInfo is used to return information about messages stored on
 * a POP3 server.  Its fields are used to mean slightly different things
 * depending on the information being returned.
 * <p>
 * In response to a status command, <code> number </code>
 * contains the number of messages in the mailbox, <code> size </code>
 * contains the size of the mailbox in bytes, and <code> identifier </code>
 * is null.
 * <p>
 * In response to a message listings, <code> number </code>
 * contains the message number, <code> size </code> contains the
 * size of the message in bytes, and <code> identifier </code> is null.
 * <p>
 * In response to unique identifier listings, <code> number </code> contains
 * the message number, <code> size </code> is undefined, and
 * <code> identifier </code> contains the message's unique identifier.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class POP3MessageInfo
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.670 -0500", hash_original_field = "75B782B0DE9A9BBA8740638F419D560B", hash_generated_field = "54FA7EDC40A989145447D14354DC9F9A")

    public int number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.673 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "608D12146C44565EEB8B9B2690E84DCB")

    public int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.678 -0500", hash_original_field = "67D18ED1400CD458B308847E018D0637", hash_generated_field = "C197BD9D81901C2624E6982248525E38")

    public String identifier;

    /***
     * Creates a POP3MessageInfo instance with <code>number</code> and
     * <code> size </code> set to 0, and <code>identifier</code> set to
     * null.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.681 -0500", hash_original_method = "13B1FF58505B03B773361DF63AF568E6", hash_generated_method = "9F267A49ADDC5290BF7F6DFE87C65E78")
    
public POP3MessageInfo()
    {
        number = size = 0;
        identifier = null;
    }

    /***
     * Creates a POP3MessageInfo instance with <code>number</code> set
     * to <code> num </code>, <code> size </code> set to <code> octets </code>,
     * and <code>identifier</code> set to null.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.684 -0500", hash_original_method = "1757F8CB7D197100A6D4F4829ACDA873", hash_generated_method = "1C44EC8B18898D825646F1BBF512C4AC")
    
public POP3MessageInfo(int num, int octets)
    {
        number = num;
        size = octets;
        identifier = null;
    }

    /***
     * Creates a POP3MessageInfo instance with <code>number</code> set
     * to <code> num </code>, <code> size </code> undefined,
     * and <code>identifier</code> set to <code>uid</code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.687 -0500", hash_original_method = "4C773697C01488587E0CD1FEDC292579", hash_generated_method = "D29815CDD3E63F07AFEC088B2A7B7EC8")
    
public POP3MessageInfo(int num, String uid)
    {
        number = num;
        size = -1;
        identifier = uid;
    }
}
