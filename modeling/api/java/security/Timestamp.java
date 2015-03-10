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
import java.io.Serializable;
import java.security.cert.CertPath;
import java.util.Date;

public final class Timestamp implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.463 -0500", hash_original_field = "529AC4FFFAC5DC689D83B9A3B7E7FD73", hash_generated_field = "E7A91C55874DE95C878CDAFEDEEC7D72")

    private static final long serialVersionUID = -5502683707821851294L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.465 -0500", hash_original_field = "5125D667CFD62C509F415BF608A962E5", hash_generated_field = "19EEE56AC3C62FACD5625A14E692FA43")

    private Date timestamp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.468 -0500", hash_original_field = "C6569135C27F1E6021BDE7485FB065B4", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.471 -0500", hash_original_field = "5ED776CD81502BA181156D7F28EBC9C8", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;

    /**
     * Constructs a new instance of {@code Timestamp} with the specified {@code
     * timestamp} and the given certificate path.
     *
     * @param timestamp
     *            date and time.
     * @param signerCertPath
     *            the certificate path.
     * @throws NullPointerException
     *             if {@code timestamp} is {@code null} or if {@code
     *             signerCertPath} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.474 -0500", hash_original_method = "AAE6CDDCBB2AA770835AE5337F9257E2", hash_generated_method = "62997408F96BB9B1481D25EFD32C7ACE")
    
public Timestamp(Date timestamp, CertPath signerCertPath) {
        if (timestamp == null) {
            throw new NullPointerException("timestamp == null");
        }
        if (signerCertPath == null) {
            throw new NullPointerException("signerCertPath == null");
        }
        // Clone timestamp to prevent modifications
        this.timestamp = new Date(timestamp.getTime());
        this.signerCertPath = signerCertPath;
    }

    /**
     * Compares the specified object with this {@code Timestamp} for equality
     * and returns {@code true} if the specified object is equal, {@code false}
     * otherwise. The given object is equal to this {@code Timestamp}, if it is
     * an instance of {@code Timestamp}, the two timestamps have an equal date
     * and time and their certificate paths are equal.
     *
     * @param obj
     *            object to be compared for equality with this {@code
     *            Timestamp}.
     * @return {@code true} if the specified object is equal to this {@code
     *         Timestamp}, otherwise {@code false}.
     * @see #hashCode
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.476 -0500", hash_original_method = "5EC26C09389FD151E3B15C0B386F0A3D", hash_generated_method = "04806647303882213952ACCB540E827A")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Timestamp) {
            Timestamp that = (Timestamp) obj;
            return timestamp.equals(that.timestamp)
                    && signerCertPath.equals(that.signerCertPath);
        }
        return false;
    }

    /**
     * Returns the certificate path of this {@code Timestamp}.
     *
     * @return the certificate path of this {@code Timestamp}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.479 -0500", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "01A5353F5016822816912028EB92BCE2")
    
public CertPath getSignerCertPath() {
        return signerCertPath;
    }

    /**
     * Returns the date and time of this {@code Timestamp}.
     *
     * @return the date and time of this {@code Timestamp}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.481 -0500", hash_original_method = "9F5E9DF58C2165A57C2B03C2ABFACB32", hash_generated_method = "B93722C6E04275D49478F0FBC17C1C88")
    
public Date getTimestamp() {
        return (Date) timestamp.clone();
    }

    /**
     * Returns the hash code value for this {@code Timestamp}. Returns the same
     * hash code for {@code Timestamp}s that are equal to each other as
     * required by the general contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this {@code Timestamp}.
     * @see Object#equals(Object)
     * @see Timestamp#equals(Object)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.485 -0500", hash_original_method = "31DF5B7E8A0074E9903AAC481766C16B", hash_generated_method = "788AC10C4AEEBDC9C6213FC47D81982C")
    
@Override
    public int hashCode() {
        if (hash == 0) {
            hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        }
        return hash;
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code Timestamp}.
     *
     * @return a printable representation for this {@code Timestamp}.
     */
    @DSSource({DSSourceKind.DATE_TIME})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:57.487 -0500", hash_original_method = "515CC78E7249E5726FD47C9B8B62F1A0", hash_generated_method = "60F4998D56F07749F99B2C39530A9A82")
    
@Override
    public String toString() {
        StringBuilder buf = new StringBuilder(256);
        // Dump only the first certificate
        buf.append("Timestamp [").append(timestamp).append(" certPath=");
        buf.append(signerCertPath.getCertificates().get(0)).append("]");
        return buf.toString();
    }
}

