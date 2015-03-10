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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.logging;

/**
 * A handler that writes log messages to the standard output stream
 * {@code System.err}.
 * <p>
 * This handler reads the following properties from the log manager to
 * initialize itself:
 * <ul>
 * <li>java.util.logging.ConsoleHandler.level specifies the logging level,
 * defaults to {@code Level.INFO} if this property is not found or has an
 * invalid value.
 * <li>java.util.logging.ConsoleHandler.filter specifies the name of the filter
 * class to be associated with this handler, defaults to {@code null} if this
 * property is not found or has an invalid value.
 * <li>java.util.logging.ConsoleHandler.formatter specifies the name of the
 * formatter class to be associated with this handler, defaults to
 * {@code java.util.logging.SimpleFormatter} if this property is not found or
 * has an invalid value.
 * <li>java.util.logging.ConsoleHandler.encoding specifies the encoding this
 * handler will use to encode log messages, defaults to {@code null} if this
 * property is not found or has an invalid value.
 * </ul>
 * <p>
 * This class is not thread-safe.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ConsoleHandler extends StreamHandler {

    /**
     * Constructs a {@code ConsoleHandler} object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.058 -0400", hash_original_method = "1C8323B058B53DC7B3E2D4F2E0A240E8", hash_generated_method = "4CB23C7872FBFCBD0B270090107114A8")
    
public ConsoleHandler() {
        super(System.err);
    }

    /**
     * Closes this handler. The {@code System.err} is flushed but not closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.058 -0400", hash_original_method = "AA59BAFBC11966C31EB82342F9638A96", hash_generated_method = "2082C64D4EB3D40C71B5A500E22D7083")
    
@Override
    public void close() {
        super.close(false);
    }

    /**
     * Logs a record if necessary. A flush operation will be done.
     *
     * @param record
     *            the log record to be logged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.059 -0400", hash_original_method = "50E37064F43FB111250793273CC27B2F", hash_generated_method = "5EDB523FEB7611F8337B49DDF83B9BF4")
    
@Override
    public void publish(LogRecord record) {
        super.publish(record);
        super.flush();
    }
}
