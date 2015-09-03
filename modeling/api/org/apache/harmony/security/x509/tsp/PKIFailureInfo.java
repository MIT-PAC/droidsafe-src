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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x509.tsp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.InvalidParameterException;

/**
   Corresponds to PKIFailureInfo structure.
   See RFC 3161 -
   Internet X.509 Public Key Infrastructure
   Time-Stamp Protocol (TSP)
   http://www.ietf.org/rfc/rfc3161.txt)

   PKIFailureInfo ::= BIT STRING {
   badAlg               (0),
     -- unrecognized or unsupported Algorithm Identifier
   badRequest           (2),
     -- transaction not permitted or supported
   badDataFormat        (5),
     -- the data submitted has the wrong format
   timeNotAvailable    (14),
     -- the TSA's time source is not available
   unacceptedPolicy    (15),
     -- the requested TSA policy is not supported by the TSA
   unacceptedExtension (16),
     -- the requested extension is not supported by the TSA
    addInfoNotAvailable (17)
      -- the additional information requested could not be understood
      -- or is not available
    systemFailure       (25)
      -- the request cannot be handled due to system failure  }

    The value of PKIFailureInfo can take only one of the values,
    so it is represented by an integer here.
 */
public enum PKIFailureInfo {
    /**
     *  Unrecognized algorithm ID
     */
    BAD_ALG(0),

    /**
     *  Transaction is not supported
     */
    BAD_REQUEST(2),

    /**
     *  Data format is wrong
     */
    BAD_DATA_FORMAT(5),

    /**
     *  TSA cannot use the time source
     */
    TIME_NOT_AVAILABLE(14),

    /**
     *  The policy is not supported
     */
    UNACCEPTED_POLICY(15),

    /**
     *  The extension is not supported
     */
    UNACCEPTED_EXTENSION(16),

    /**
     *  The requested additional info is not available
     */
    ADD_INFO_NOT_AVAILABLE(17),

    /**
     *  System failure has occured
     */
    SYSTEM_FAILURE(25);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.471 -0400", hash_original_field = "2A5EA2B60261C751D318C2CB32BF7CEC", hash_generated_field = "810C3DA5CE7DA1BA423D6BE76816E5C9")



    private  int value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.471 -0400", hash_original_field = "7DA2A75C473A278A8F6F887510D3D88C", hash_generated_field = "C6A37CBECE398EF0E09EB3D408689319")


    private static int maxValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.472 -0400", hash_original_method = "7ABA7EC3CE66DD4DAF9892CB2730F163", hash_generated_method = "7ABA7EC3CE66DD4DAF9892CB2730F163")
        
PKIFailureInfo(int value) {
        this.value = value;
    }

    /**
     * @return int value of the failure
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.472 -0400", hash_original_method = "9F663685BA7FCCD9D6DBB56939AFA7D3", hash_generated_method = "154C2F490240140E7BE8E4F6FBAB8F76")
        
public int getValue() {
        return value;
    }

    /**
     * @return maximum of values in the enum
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.473 -0400", hash_original_method = "A2259879762D5426EBB6BA16C39CF0B5", hash_generated_method = "746496193449B2BAE43BAB1D64D0F7B8")
        
public static int getMaxValue() {
        if (maxValue == 0) {
            for (PKIFailureInfo cur : values())
                if (cur.value > maxValue) {
                    maxValue = cur.value;
                }
        }
        return maxValue;
    }

    /**
     * @param value
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.473 -0400", hash_original_method = "BC6E355C38BDA8ADEFCA9C4ECF1E2CC7", hash_generated_method = "C18B568D25FB0004845A9887005A63CE")
        
public static PKIFailureInfo getInstance(int value) {
        for (PKIFailureInfo info : values()){
            if (value == info.value) {
                return info;
            }
        }
        throw new InvalidParameterException("Unknown PKIFailureInfo value");
    }
}

