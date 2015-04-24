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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.SSLException;

public class AlertException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.414 -0500", hash_original_field = "93BAD4977ECA98BFF8CF4CFAAEAFE6D7", hash_generated_field = "49414C5F100260BFB79C458FA4822DE5")

    private static final long serialVersionUID = -4448327177165687581L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.416 -0500", hash_original_field = "6E497387AC14EA196BB0BE1BDE11805E", hash_generated_field = "C530EE3CBD485644D7525A400EA925B6")

    private  SSLException reason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.419 -0500", hash_original_field = "74F280F6E7E26FDCFDB578AAFF84DF3E", hash_generated_field = "970155BA799F3943C9383598DE4C30A5")

    private  byte description;

    /**
     * Constructs the instance.
     *
     * @param description The alert description code from {@link AlertProtocol}
     * @param reason The SSLException to be thrown to application side after alert processing
     *            (sending the record with alert, shutdown work, etc).
     * @see AlertProtocol
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.421 -0500", hash_original_method = "76164594E21D6CE99D1A0A90A760CF7A", hash_generated_method = "25B1C1BA84DF5BEBAF46122E1A31B670")
    
protected AlertException(byte description, SSLException reason) {
        super(reason);
        this.reason = reason;
        this.description = description;
    }

    /**
     * Returns the reason of alert. This reason should be rethrown after alert processing.
     *
     * @return the reason of alert.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.423 -0500", hash_original_method = "5B702ECC4BAE0D4CD4DED59A097CDBFC", hash_generated_method = "30CB20ECF89290BA04D7334DD1E64E5F")
    
protected SSLException getReason() {
        return reason;
    }

    /**
     * Returns alert's description code.
     *
     * @return alert description code from {@link AlertProtocol}
     * @see AlertProtocol for more information about possible reason codes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:18.425 -0500", hash_original_method = "4016638ED8025AA5C043B11675AF3321", hash_generated_method = "406210F086F3DA6DDF270588E443BAA5")
    
protected byte getDescriptionCode() {
        return description;
    }
}

