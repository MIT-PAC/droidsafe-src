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
   Corresponds to PKIStatus structure.
   See RFC 3161 -
   Internet X.509 Public Key Infrastructure
   Time-Stamp Protocol (TSP)
   http://www.ietf.org/rfc/rfc3161.txt)

   PKIStatus ::= INTEGER {
      granted                (0),
      -- when the PKIStatus contains the value zero a TimeStampToken, as
         requested, is present.
      grantedWithMods        (1),
       -- when the PKIStatus contains the value one a TimeStampToken,
         with modifications, is present.
      rejection              (2),
      waiting                (3),
      revocationWarning      (4),
       -- this message contains a warning that a revocation is
       -- imminent
      revocationNotification (5)
       -- notification that a revocation has occurred  }
 */
public enum PKIStatus {
    /**
     * TimeStampToken is present as requested
     */
    GRANTED(0),
    /**
     * TimeStampToken is present with modifications
     */
    GRANTED_WITH_MODS(1),
    /**
     * rejected
     */
    REJECTION(2),
    /**
     * waiting
     */
    WAITING(3),
    /**
     * revocation time comes soon
     */
    REVOCATION_WARNING(4),
    /**
     * revoked
     */
    REVOCATION_NOTIFICATION(5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.247 -0400", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")


    private  int status;
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.248 -0400", hash_original_method = "C6821F10BAD20C2AE3420CD7CB077CD2", hash_generated_method = "C6821F10BAD20C2AE3420CD7CB077CD2")
        
PKIStatus(int status) {
        this.status = status;
    }

    /**
     * @return int value of the status
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.248 -0400", hash_original_method = "A6874122EB6D2A9BF852845259D73D4C", hash_generated_method = "81FC680243CB1A2EBB4EA9FFFB802536")
        
public int getStatus(){
        return status;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.249 -0400", hash_original_method = "EA0335D4B16A870E44BE80D295471BDB", hash_generated_method = "866BC739F8CED62A9CB1CDF74DB0491B")
        
public static PKIStatus getInstance(int status) {
        for (PKIStatus curStatus : values()) {
            if (status == curStatus.status) {
                return curStatus;
            }
        }
        throw new InvalidParameterException("Unknown PKIStatus value");
    }
}

