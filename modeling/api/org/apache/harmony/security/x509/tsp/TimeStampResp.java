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
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;

/**
 * As defined in Time-Stamp Protocol (TSP)
 * (http://www.ietf.org/rfc/rfc3161.txt)
 *
 * TimeStampResp ::= SEQUENCE {
 *    status PKIStatusInfo,
 *    timeStampToken TimeStampToken OPTIONAL
 * }
 *
 */
public class TimeStampResp {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.584 -0400", hash_original_field = "8293E5367943A55668888B4ECE6A377A", hash_generated_field = "4D133DA8AD71845556D36F741B3BF5B5")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            PKIStatusInfo.ASN1,     // status
            ContentInfo.ASN1}) {    // timeStampToken

        {
            setOptional(1);
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new TimeStampResp(
                    (PKIStatusInfo) values[0],
                    (ContentInfo) values[1]);
        }

        protected void getValues(Object object, Object[] values) {
            TimeStampResp resp = (TimeStampResp) object;

            values[0] = resp.status;
            values[1] = resp.timeStampToken;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.579 -0400", hash_original_field = "46D81AA163FACCDDACBAC5910FF81F34", hash_generated_field = "CF106481194A83C6697EEAF91D779B64")

    private  PKIStatusInfo status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.579 -0400", hash_original_field = "A5C079C243D1E481A410E305F89122AD", hash_generated_field = "078C69BED3F108C1499D13E92501E3AB")

    private  ContentInfo timeStampToken;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.580 -0400", hash_original_method = "4883B373201A34F712904E89480FC780", hash_generated_method = "8FF60A268F5EF7FD2ABF4939602FAA9D")
    
public TimeStampResp(PKIStatusInfo status, ContentInfo timeStampToken) {
        this.status = status;
        this.timeStampToken = timeStampToken;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.580 -0400", hash_original_method = "BFC7E920FC2E3699AD3FB0A4A1246D04", hash_generated_method = "480D253617B1577E0A5749D24F85932D")
    
public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("-- TimeStampResp:");
        res.append("\nstatus:  ");
        res.append(status);
        res.append("\ntimeStampToken:  ");
        res.append(timeStampToken);
        res.append("\n-- TimeStampResp End\n");
        return res.toString();
    }

    /**
     * @return Returns the status.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.581 -0400", hash_original_method = "153BF4F4660E49EEE2B6F5A0D301FC92", hash_generated_method = "EBD2D21FD984D2EF556FD8151E05E9D2")
    
public PKIStatusInfo getStatus() {
        return status;
    }

    /**
     * @return Returns the timeStampToken.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.581 -0400", hash_original_method = "36AC1B4C8222E0847EB0AF7B34470338", hash_generated_method = "BC424BC0425962B5AA3B3C879E491DEB")
    
public ContentInfo getTimeStampToken() {
        return timeStampToken;
    }
}

