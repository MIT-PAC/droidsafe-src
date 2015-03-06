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


package java.security.spec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;

/**
 * The parameters specifying a <i>prime finite field</i> of an
 * elliptic curve.
 */
public class ECFieldFp implements ECField {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.078 -0400", hash_original_field = "36A2346422FAB1A0484079E02615C501", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private  BigInteger p;

    /**
     * Creates a new prime finite field of an elliptic curve with the specified
     * prime {@code p}.
     *
     * @param p
     *            the prime value {@code p}.
     * @throws IllegalArgumentException
     *             if {@code p <= zero}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.079 -0400", hash_original_method = "AAEE055AC189AAA69190297D497E0E78", hash_generated_method = "0D2B60D2EAA939F88A6CBDB5A51B4689")
    
public ECFieldFp(BigInteger p) {
        this.p = p;

        if (this.p == null) {
            throw new NullPointerException("p == null");
        }
        if (this.p.signum() != 1) {
            throw new IllegalArgumentException("p <= 0");
        }
    }

    /**
     * Returns the size of the finite field (in bits).
     *
     * @return the size of the finite field (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.081 -0400", hash_original_method = "C2220C454DE6F6463DE49A822E72B820", hash_generated_method = "F070EDBBB89B6F4D552370E45CD426D4")
    
public int getFieldSize() {
        return p.bitLength();
    }

    /**
     * Returns the prime value {@code p} for this finite field.
     *
     * @return the prime value {@code p} for this finite field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.082 -0400", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "FA39994F0F567A64C38613032682F7D7")
    
public BigInteger getP() {
        return p;
    }

    /**
     * Returns whether the specified object is equal to this finite field.
     *
     * @param obj
     *            the object to compare to this finite field.
     * @return {@code true} if the specified object is equal to this finite field,
     *         otherwise {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.083 -0400", hash_original_method = "13CBEB5F84026BAB57A09069F12B4679", hash_generated_method = "CBB08CBAF3A6BF1693C490D95205D74E")
    
public boolean equals(Object obj) {
        // object equals itself
        if (this == obj) {
            return true;
        }
        if (obj instanceof ECFieldFp) {
            return (this.p.equals(((ECFieldFp)obj).p));
        }
        return false;
    }

    /**
     * Returns the hashcode value for this finite field.
     *
     * @return the hashcode value for this finite field.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.085 -0400", hash_original_method = "DBFAB43DC10C305AAA2F5A4ED4232E05", hash_generated_method = "97D7592B797FF65F95E75C69432B963A")
    
public int hashCode() {
        return p.hashCode();
    }
}
