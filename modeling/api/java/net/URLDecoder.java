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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import libcore.net.UriCodec;

public class URLDecoder {
    /**
     * Decodes the argument which is assumed to be encoded in the {@code
     * x-www-form-urlencoded} MIME content type.
     * <p>
     *'+' will be converted to space, '%' and two following hex digit
     * characters are converted to the equivalent byte value. All other
     * characters are passed through unmodified. For example "A+B+C %24%25" ->
     * "A B C $%".
     *
     * @param s
     *            the encoded string.
     * @return the decoded clear-text representation of the given string.
     * @deprecated use {@link #decode(String, String)} instead.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.559 -0500", hash_original_method = "B615A2BC4F9E0B242EB3A9536009FA28", hash_generated_method = "22C6E19760682FCDD3324068D65B539B")
    @DSSafe(DSCat.SAFE_LIST)
    @Deprecated
    public static String decode(String s) {
        //simplifying for DS
        String ret = new String("DECODED-URL");
        ret.addTaint(s.getTaint());
        return ret;
        //return UriCodec.decode(s, true, Charset.defaultCharset());
    }

    /**
     * Decodes the argument which is assumed to be encoded in the {@code
     * x-www-form-urlencoded} MIME content type using the specified encoding
     * scheme.
     * <p>
     *'+' will be converted to space, '%' and two following hex digit
     * characters are converted to the equivalent byte value. All other
     * characters are passed through unmodified. For example "A+B+C %24%25" ->
     * "A B C $%".
     *
     * @param s
     *            the encoded string.
     * @param encoding
     *            the encoding scheme to be used.
     * @return the decoded clear-text representation of the given string.
     * @throws UnsupportedEncodingException
     *             if the specified encoding scheme is invalid.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.561 -0500", hash_original_method = "08FCF3E03A800113A7194CB72BB59DA9", hash_generated_method = "E0C46DB131A739C4A90A1AC029D9124F")
    
    public static String decode(String s, String encoding) throws UnsupportedEncodingException {
        //simplifying for DS
        String ret = new String("DECODED-URL");
        ret.addTaint(s.getTaint());
        return ret;

        //return UriCodec.decode(s, true, Charset.forName(encoding));
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.082 -0400", hash_original_method = "857A327B54EFC5B6C22CAE0D3F8923A2", hash_generated_method = "857A327B54EFC5B6C22CAE0D3F8923A2")
    public URLDecoder ()
    {
        //Synthesized constructor
    }
    
}

