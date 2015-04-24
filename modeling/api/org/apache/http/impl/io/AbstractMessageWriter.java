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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/AbstractMessageWriter.java $
 * $Revision: 569673 $
 * $Date: 2007-08-25 06:58:51 -0700 (Sat, 25 Aug 2007) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Iterator;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageWriter implements HttpMessageWriter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.069 -0500", hash_original_field = "E995C38DC29F4C5C462B356FE2FC4784", hash_generated_field = "7546C8F84D7739D4A1BA10808E25B0AE")
    
    protected  SessionOutputBuffer sessionBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.071 -0500", hash_original_field = "FC03653F373BA80D3DD2EC29A605B1FD", hash_generated_field = "3CE530BC037559228F5322CB75C414E0")
    
    protected  CharArrayBuffer lineBuf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.073 -0500", hash_original_field = "0711EFF92851F784AC1E3F00CD50F47D", hash_generated_field = "9B2BF02A5898CE488D537E86AD344847")

    protected  LineFormatter lineFormatter;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.076 -0500", hash_original_method = "81470EB0FA2062B136A4D8177B3454ED", hash_generated_method = "BCC422C386FE00AF5FA80520802F9861")
    
public AbstractMessageWriter(final SessionOutputBuffer buffer,
                                 final LineFormatter formatter,
                                 final HttpParams params) {
        super();
        if (buffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        this.sessionBuffer = buffer;
        this.lineBuf = new CharArrayBuffer(128);
        this.lineFormatter = (formatter != null) ?
            formatter : BasicLineFormatter.DEFAULT;
    }
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.078 -0500", hash_original_method = "857D62785BA62AC1D00D243630A84326", hash_generated_method = "370DDC2BFC6829600C21197F5D5DE4A4")
    
protected abstract void writeHeadLine(HttpMessage message)
        throws IOException
        ;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.080 -0500", hash_original_method = "33F4F2FFED23975C76AB7BEDB0A8854B", hash_generated_method = "C867B2589F2E08B9A4783B1BFEA5E901")
    
public void write(
            final HttpMessage message) throws IOException, HttpException {
        if (message == null) {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
        writeHeadLine(message);
        for (Iterator it = message.headerIterator(); it.hasNext(); ) {
            Header header = (Header) it.next();
            this.sessionBuffer.writeLine
                (lineFormatter.formatHeader(this.lineBuf, header));
        }
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }
    
}

