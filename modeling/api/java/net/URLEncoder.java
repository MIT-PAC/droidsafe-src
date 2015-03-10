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
import java.nio.charset.Charsets;

import libcore.net.UriCodec;

public class URLEncoder {

    /**
     * Equivalent to {@code encode(s, "UTF-8")}.
     *
     * @deprecated use {@link #encode(String, String)} instead.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.246 -0500", hash_original_method = "F3C1C4CFF9BE8725C4E7F6E8F952E701", hash_generated_method = "1A209DE22072754E840116F302F6A63F")
    
@Deprecated
    public static String encode(String s) {
        //simplifying for DS
        String ret = new String("DECODED-URL");
        ret.addTaint(s.getTaint());
        return ret;

        //return ENCODER.encode(s, Charsets.UTF_8);
    }

    /**
     * Encodes {@code s} using the {@link Charset} named by {@code charsetName}.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.249 -0500", hash_original_method = "D7709200003A991BD062A99EB5CFA293", hash_generated_method = "3CD8462111730A87D2D8B52FAAF90629")
    
public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
        //simplifying for DS
        String ret = new String("DECODED-URL");
        ret.addTaint(s.getTaint());
        return ret;

        //return ENCODER.encode(s, Charset.forName(charsetName));
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.616 -0400", hash_original_field = "BF744055ED759113AEBE28A0C00A3E54", hash_generated_field = "04F0CC19FD1C184FAF8112872B3FF045")

    static UriCodec ENCODER = new UriCodec() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.616 -0400", hash_original_method = "70778A5E4342F08CE32F374D86265937", hash_generated_method = "811C6B809939AF0583CA172372A0CFB9")
        @Override
        protected boolean isRetained(char c) {
            boolean varD34241CD5AA4B42C02ED3ACD4E671100_74379594 = (" .-*_".indexOf(c) != -1);
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527189368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527189368;
            
        }
        
};
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.238 -0500", hash_original_method = "B41CBCC9C76AA809E0DC45FDBBA0D268", hash_generated_method = "6546CA37BB594848B3235CCF30367527")
    
private URLEncoder() {}
}

