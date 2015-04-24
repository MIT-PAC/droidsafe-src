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
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

/**
 * Subclasses IOException with the {@link Throwable} constructors missing before Java 6. If you are using Java 6,
 * consider this class deprecated and use {@link IOException}.
 * 
 * @version $Id: IOExceptionWithCause.java 1307459 2012-03-30 15:11:44Z ggregory $
 * @since 1.4
 */
public class IOExceptionWithCause extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.467 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new instance with the given message and cause.
     * <p>
     * As specified in {@link Throwable}, the message in the given <code>cause</code> is not used in this instance's
     * message.
     * </p>
     * 
     * @param message
     *            the message (see {@link #getMessage()})
     * @param cause
     *            the cause (see {@link #getCause()}). A {@code null} value is allowed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.467 -0400", hash_original_method = "D35AEE75131A73F58A55104946C95348", hash_generated_method = "60C1227788F21907E663697D2D6B2D1D")
    
public IOExceptionWithCause(String message, Throwable cause) {
        super(message);
        this.initCause(cause);
    }

    /**
     * Constructs a new instance with the given cause.
     * <p>
     * The message is set to <code>cause==null ? null : cause.toString()</code>, which by default contains the class
     * and message of <code>cause</code>. This constructor is useful for call sites that just wrap another throwable.
     * </p>
     * 
     * @param cause
     *            the cause (see {@link #getCause()}). A {@code null} value is allowed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:50.468 -0400", hash_original_method = "A43E17313B2999FA9C6013736C0761D0", hash_generated_method = "01C4829FFE76582BDA7D7FA069D15E58")
    
public IOExceptionWithCause(Throwable cause) {
        super(cause == null ? null : cause.toString());
        this.initCause(cause);
    }

}
