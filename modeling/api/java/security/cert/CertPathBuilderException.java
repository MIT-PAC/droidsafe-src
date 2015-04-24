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


package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.GeneralSecurityException;

/**
 * The exception that is thrown when a {@code CertPathBuilder} method fails.
 */
public class CertPathBuilderException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.154 -0400", hash_original_field = "6E70AC9755FE61CC749FBAB2B81F3966", hash_generated_field = "3A4301039F44E055F23B413FAD69645A")


    private static final long serialVersionUID = 5316471420178794402L;

    /**
     * Creates a new {@code CertPathBuilderException} with the specified message
     * and cause.
     *
     * @param msg
     *            the detail message for the exception
     * @param cause
     *            why the building of the certification path failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.156 -0400", hash_original_method = "16EDCFC5FCDC241A8C5698D07EDC6786", hash_generated_method = "0B179E3DBC05743BFE6061808A687B10")
    
public CertPathBuilderException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Creates a new {@code CertPathBuilderException} with the specified cause.
     *
     * @param cause
     *            why the building of the certification path failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.157 -0400", hash_original_method = "B0D28631671975BE727422556FE5A355", hash_generated_method = "2AE527E732D3E3FB0127637D8962387C")
    
public CertPathBuilderException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@code CertPathBuilderException} with the specified
     * message.
     *
     * @param msg
     *            the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.158 -0400", hash_original_method = "103D185F3BBC7498AB8EEB822E639F3F", hash_generated_method = "DFD0ECF201D8904EAD6E3BBA35706491")
    
public CertPathBuilderException(String msg) {
        super(msg);
    }

    /**
     * Creates a new {@code CertPathBuilderException}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.160 -0400", hash_original_method = "86705E4945DBDB26D8860EB374F1CF20", hash_generated_method = "9216A4C622D233E018519162B24ECF58")
    
public CertPathBuilderException() {
    }
}
