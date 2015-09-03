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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Date;
import libcore.io.IoUtils;

/**
 * {@code SimpleFormatter} can be used to print a summary of the information
 * contained in a {@code LogRecord} object in a human readable format.
 */
public class SimpleFormatter extends Formatter {
    /**
     * Constructs a new {@code SimpleFormatter}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.907 -0400", hash_original_method = "773C34FC35CF84F2185AF50CEBDF6A1B", hash_generated_method = "13FB1AC6B46D4C055E19BA1B183CED6C")
    
public SimpleFormatter() {
    }

    /**
     * Converts a {@link LogRecord} object into a human readable string
     * representation.
     *
     * @param r
     *            the log record to be formatted into a string.
     * @return the formatted string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.908 -0400", hash_original_method = "1B38C52674B02C584D4FAD37E0EA74D1", hash_generated_method = "E01BE6DA26F89ADC08332D15B8D77C14")
    
@Override
    public String format(LogRecord r) {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format("{0, date} {0, time} ",
                new Object[] { new Date(r.getMillis()) }));
        sb.append(r.getSourceClassName()).append(" ");
        sb.append(r.getSourceMethodName()).append(System.lineSeparator());
        sb.append(r.getLevel().getName()).append(": ");
        sb.append(formatMessage(r)).append(System.lineSeparator());
        if (r.getThrown() != null) {
            sb.append("Throwable occurred: ");
            Throwable t = r.getThrown();
            PrintWriter pw = null;
            try {
                StringWriter sw = new StringWriter();
                pw = new PrintWriter(sw);
                t.printStackTrace(pw);
                sb.append(sw.toString());
            } finally {
                IoUtils.closeQuietly(pw);
            }
        }
        return sb.toString();
    }
}
