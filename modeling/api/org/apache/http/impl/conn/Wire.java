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
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//httpclient/src/java/org/apache/commons/httpclient/Wire.java,v 1.9 2004/06/24 21:39:52 mbecke Exp $
 * $Revision: 653041 $
 * $Date: 2008-05-03 03:39:28 -0700 (Sat, 03 May 2008) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;

public class Wire {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.563 -0500", hash_original_field = "9928E38BCEFDA1EEA4B4B3BA7730094E", hash_generated_field = "B44E589F36524A8564E741C819F5943D")

    private  Log log;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.566 -0500", hash_original_method = "B4B1AB4B499B8A15063D0CC014BEC991", hash_generated_method = "232A8B2A2D69411C0F4B0DFA7DA84F28")
    
public Wire(Log log) {
        this.log = log;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.568 -0500", hash_original_method = "8AB487D8D5FB9334AB649D48E9DFB74A", hash_generated_method = "129627B3F223330EC78D4BA01BEA0271")
    
private void wire(String header, InputStream instream)
      throws IOException {
        StringBuilder buffer = new StringBuilder();
        int ch;
        while ((ch = instream.read()) != -1) {
            if (ch == 13) {
                buffer.append("[\\r]");
            } else if (ch == 10) {
                    buffer.append("[\\n]\"");
                    buffer.insert(0, "\"");
                    buffer.insert(0, header);
                    log.debug(buffer.toString());
                    buffer.setLength(0);
            } else if ((ch < 32) || (ch > 127)) {
                buffer.append("[0x");
                buffer.append(Integer.toHexString(ch));
                buffer.append("]");
            } else {
                buffer.append((char) ch);
            }
        } 
        if (buffer.length() > 0) {
            buffer.append('\"');
            buffer.insert(0, '\"');
            buffer.insert(0, header);
            log.debug(buffer.toString());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.571 -0500", hash_original_method = "3293A063039621258FD717F75AAE20F6", hash_generated_method = "7429CF7FB1ECB3C33D1AD16DB24C713B")
    
public boolean enabled() {
        return log.isDebugEnabled();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.573 -0500", hash_original_method = "41909751022A9CA66D19EAE8E0D21F96", hash_generated_method = "E7C108C60829EC6D59683354FF91AFCF")
    
public void output(InputStream outstream)
      throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output may not be null"); 
        }
        wire(">> ", outstream);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.575 -0500", hash_original_method = "9B3D263B2ABEC36BE45DD8B457A2FB5F", hash_generated_method = "417301DC12574F64755A6D014BDC8492")
    
public void input(InputStream instream)
      throws IOException {
        if (instream == null) {
            throw new IllegalArgumentException("Input may not be null"); 
        }
        wire("<< ", instream);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.578 -0500", hash_original_method = "FC3E92A1F886275998FB021C6804D6A9", hash_generated_method = "94BF3CD80B044F4C766D23DCA3433D6B")
    
public void output(byte[] b, int off, int len)
      throws IOException {
        if (b == null) {
            throw new IllegalArgumentException("Output may not be null"); 
        }
        wire(">> ", new ByteArrayInputStream(b, off, len));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.581 -0500", hash_original_method = "7AB6B9BAC192F7B379ECF2E9CAEC39DE", hash_generated_method = "93EEFBEB7BA93F760EB2070D94D1BB19")
    
public void input(byte[] b, int off, int len)
      throws IOException {
        if (b == null) {
            throw new IllegalArgumentException("Input may not be null"); 
        }
        wire("<< ", new ByteArrayInputStream(b, off, len));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.583 -0500", hash_original_method = "C456100C17A97A0094094ACD8A59EB30", hash_generated_method = "A41956EF7230EFF56518145157E1CFEB")
    
public void output(byte[] b)
      throws IOException {
        if (b == null) {
            throw new IllegalArgumentException("Output may not be null"); 
        }
        wire(">> ", new ByteArrayInputStream(b));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.585 -0500", hash_original_method = "CACCE18D78F1F755698157152E4CF23A", hash_generated_method = "4F964A276C53AEC92E1A8274CF28A6FD")
    
public void input(byte[] b)
      throws IOException {
        if (b == null) {
            throw new IllegalArgumentException("Input may not be null"); 
        }
        wire("<< ", new ByteArrayInputStream(b));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.587 -0500", hash_original_method = "98C5B0073473ADAA98ACDF73DE6F6267", hash_generated_method = "63AE11186EAD6B7C1E94BBB63125F85C")
    
public void output(int b)
      throws IOException {
        output(new byte[] {(byte) b});
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.590 -0500", hash_original_method = "95BA17E717E6FE2824B7813CA2829BC6", hash_generated_method = "4C16FFADA7A2D78CA73A2512FAA47B9D")
    
public void input(int b)
      throws IOException {
        input(new byte[] {(byte) b});
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.592 -0500", hash_original_method = "F3C5064419E81BE1694ED79F4A4E0F84", hash_generated_method = "F9951302DABB6767C4AAFE559D013B33")
    
public void output(final String s)
      throws IOException {
        if (s == null) {
            throw new IllegalArgumentException("Output may not be null"); 
        }
        output(s.getBytes());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:32.594 -0500", hash_original_method = "A406219181E10CB21A7EC7720CD1AF08", hash_generated_method = "0E4D8B439D30B7D49744D92EBFD06FE9")
    
public void input(final String s)
      throws IOException {
        if (s == null) {
            throw new IllegalArgumentException("Input may not be null"); 
        }
        input(s.getBytes());
    }
    
}

