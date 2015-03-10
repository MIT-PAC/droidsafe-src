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
import java.math.BigInteger;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1StringType;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;

/**
 * As defined in Time-Stamp Protocol (TSP)
 * (http://www.ietf.org/rfc/rfc3161.txt)
 *
 * PKIStatusInfo ::= SEQUENCE {
 *    status PKIStatus,
 *    statusString PKIFreeText OPTIONAL,
 *    failInfo PKIFailureInfo OPTIONAL
 * }
 *
 */
public class PKIStatusInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.448 -0400", hash_original_field = "A56D68DC99625024E94797FDAFCC57E5", hash_generated_field = "D09306F5ED5D2096CBBD89AE2CD121CE")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
        ASN1Integer.getInstance(),                      // status
        new ASN1SequenceOf(ASN1StringType.UTF8STRING),  // statusString
        ASN1BitString.getInstance() }) {                // failInfo
        {
            setOptional(1);
            setOptional(2);
        }

        protected void getValues(Object object, Object[] values) {
            PKIStatusInfo psi = (PKIStatusInfo) object;
            values[0] = BigInteger.valueOf(psi.status.getStatus())
                    .toByteArray();
            values[1] = psi.statusString;
            if (psi.failInfo != null) {
                // set the needed bit in the bit string
                boolean[] failInfoBoolArray = new boolean[PKIFailureInfo
                        .getMaxValue()];
                failInfoBoolArray[psi.failInfo.getValue()] = true;
                values[2] = new BitString(failInfoBoolArray);
            } else {
                values[2] = null;
            }
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;

            int failInfoValue = -1;
            if (values[2] != null) {
                boolean[] failInfoBoolArray = ((BitString) values[2]).toBooleanArray();
                for (int i = 0; i < failInfoBoolArray.length; i++) {
                    if (failInfoBoolArray[i]) {
                        failInfoValue = i;
                        break;
                    }
                }
            }
            return new PKIStatusInfo(
                    PKIStatus.getInstance(ASN1Integer.toIntValue(values[0])),
                    (List)values[1],
                    PKIFailureInfo.getInstance(failInfoValue));
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.440 -0400", hash_original_field = "BD0BBAD4FB64788ED0D0F5E6D9D91C85", hash_generated_field = "6BB563F292CF64B00E8B26BFA1602C8D")

    private  PKIStatus status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.441 -0400", hash_original_field = "17DB11D6175E29F7F1D9EC572C44A359", hash_generated_field = "40C0DC815B3C092349CBF32DF33DA0D4")

    private  List statusString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.441 -0400", hash_original_field = "A5CAE78FEDE532831EE13EE7820D27AA", hash_generated_field = "1010DC049DEFAF2D1F3EC876AE24661E")

    private  PKIFailureInfo failInfo;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.442 -0400", hash_original_method = "C2DFE4192244082680A5F11B0460441B", hash_generated_method = "232C10BF72E08DBCAF2363DA19D7E08C")
    
public PKIStatusInfo(PKIStatus pKIStatus, List statusString,
            PKIFailureInfo failInfo) {
        this.status = pKIStatus;
        this.statusString = statusString;
        this.failInfo = failInfo;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.443 -0400", hash_original_method = "87519E6CC0B0976A9EBB1FEB9A8EFB9B", hash_generated_method = "EF072626C91E3DB11F62042351ED47BA")
    
public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("-- PKIStatusInfo:");
        res.append("\nPKIStatus : ");
        res.append(status);
        res.append("\nstatusString:  ");
        res.append(statusString);
        res.append("\nfailInfo:  ");
        res.append(failInfo);
        res.append("\n-- PKIStatusInfo End\n");
        return res.toString();
    }

    /**
     * @return Returns the failInfo.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.443 -0400", hash_original_method = "AA15AABA574F0B4A218B0AD14410F00B", hash_generated_method = "CB90938771841BC9420991D1E60DB3AB")
    
public PKIFailureInfo getFailInfo() {
        return failInfo;
    }

    /**
     * @return Returns the pKIStatus.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.444 -0400", hash_original_method = "88B54ED47602D6986722DCC6BE89541C", hash_generated_method = "4A80A5480147C32D2CAC88455123A049")
    
public PKIStatus getStatus() {
        return status;
    }

    /**
     * @return Returns the statusString.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:58.444 -0400", hash_original_method = "EEED5A6F8246E731CD96C760CEAD236C", hash_generated_method = "3C4716FF15AFCC390D39252BCEC2DB79")
    
public List getStatusString() {
        return statusString;
    }
}

