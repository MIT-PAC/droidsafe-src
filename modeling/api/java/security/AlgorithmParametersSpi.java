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


package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public abstract class AlgorithmParametersSpi {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.769 -0400", hash_original_method = "0323D51824F6B2D78575D923F8282326", hash_generated_method = "0323D51824F6B2D78575D923F8282326")
    public AlgorithmParametersSpi ()
    {
        //Synthesized constructor
    }

    /**
     * Initializes this {@code AlgorithmParametersSpi} with the specified
     * {@code AlgorithmParameterSpec}.
     *
     * @param paramSpec
     *            the parameter specification.
     * @throws InvalidParameterSpecException
     *             if this {@code AlgorithmParametersSpi} has already been
     *             initialized or the given {@code paramSpec} is not appropriate
     *             for initializing this {@code AlgorithmParametersSpi}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.597 -0500", hash_original_method = "BB724E18709555803DE3B7595DD979E6", hash_generated_method = "EF3615924AF5E2F0A08F6722E4F8C88B")
    
protected abstract void engineInit(AlgorithmParameterSpec paramSpec)
            throws InvalidParameterSpecException;

    /**
     * Initializes this {@code AlgorithmParametersSpi} with the specified
     * {@code byte[]} using the default decoding format for parameters. The
     * default encoding format is ASN.1.
     *
     * @param params
     *            the encoded parameters.
     * @throws IOException
     *             if this {@code AlgorithmParametersSpi} has already been
     *             initialized, or the parameter could not be encoded.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.599 -0500", hash_original_method = "5819766A8470DAA7E812A93E78EA2924", hash_generated_method = "28761889CDDF493C9306A0C3C403AA42")
    
protected abstract void engineInit(byte[] params) throws IOException;

    /**
     * Initializes this {@code AlgorithmParametersSpi} with the specified
     * {@code byte[]} using the specified decoding format.
     *
     * @param params
     *            the encoded parameters.
     * @param format
     *            the name of the decoding format.
     * @throws IOException
     *             if this {@code AlgorithmParametersSpi} has already been
     *             initialized, or the parameter could not be encoded.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.601 -0500", hash_original_method = "72ADEDA191FF5C096142BED5B54069A2", hash_generated_method = "F84A98955BD4ABBC988E168D2C6C8566")
    
protected abstract void engineInit(byte[] params, String format)
            throws IOException;
    
    protected abstract <T extends AlgorithmParameterSpec> T engineGetParameterSpec(
            Class<T> paramSpec) throws InvalidParameterSpecException;

    /**
     * Returns the parameters in their default encoding format. The default
     * encoding format is ASN.1.
     *
     * @return the encoded parameters.
     * @throws IOException
     *             if this {@code AlgorithmParametersSpi} has already been
     *             initialized, or if this parameters could not be encoded.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.605 -0500", hash_original_method = "300A06570E551B1E63470AD8E1298467", hash_generated_method = "0B74881D127A61F69E1E3EB203D61CCE")
    
protected abstract byte[] engineGetEncoded() throws IOException;

    /**
     * Returns the parameters in the specified encoding format.
     *
     * @param format
     *            the name of the encoding format.
     * @return the encoded parameters.
     * @throws IOException
     *             if this {@code AlgorithmParametersSpi} has already been
     *             initialized, or if this parameters could not be encoded.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.607 -0500", hash_original_method = "5870BB532A1F6A4336949B1EA7701D5A", hash_generated_method = "14F80CA517EC611985D67AE0CDE1D60D")
    
protected abstract byte[] engineGetEncoded(String format)
            throws IOException;

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code AlgorithmParametersSpi}.
     *
     * @return a printable representation for this {@code
     *         AlgorithmParametersSpi}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:01.610 -0500", hash_original_method = "239E82FF12564536AD4240443AF0BE5A", hash_generated_method = "9DBF754E255E71C13F2322E202B70420")
    
protected abstract String engineToString();
    
}

