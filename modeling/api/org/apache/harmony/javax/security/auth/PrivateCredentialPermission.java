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


package org.apache.harmony.javax.security.auth;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Principal;
import java.util.Set;

/**
 * Protects private credential objects belonging to a {@code Subject}. It has
 * only one action which is "read". The target name of this permission has a
 * special syntax:
 *
 * <pre>
 * targetName = CredentialClass {PrincipalClass &quot;PrincipalName&quot;}*
 * </pre>
 *
 * First it states a credential class and is followed then by a list of one or
 * more principals identifying the subject.
 * <p>
 * The principals on their part are specified as the name of the {@code
 * Principal} class followed by the principal name in quotes. For example, the
 * following file may define permission to read the private credentials of a
 * principal named "Bob": "com.sun.PrivateCredential com.sun.Principal \"Bob\""
 * <p>
 * The syntax also allows the use of the wildcard "*" in place of {@code
 * CredentialClass} or {@code PrincipalClass} and/or {@code PrincipalName}.
 *
 * @see Principal
 */
public final class PrivateCredentialPermission extends Permission {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.210 -0400", hash_original_field = "43361E2A1C28813A722BD9DD150412DB", hash_generated_field = "7114C054D5F447F0A1E97C088FF3E205")

    private static final long serialVersionUID = 5284372143517237068L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.211 -0400", hash_original_field = "02CA0F815C9046A41BB7F65F33E27346", hash_generated_field = "BF1293380551AD7E940FECCAFCDC0160")

    private static final String READ = "read";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.211 -0400", hash_original_field = "D13AEF3FEA1F86F8ABF27FA7C7A87354", hash_generated_field = "90E0555C227B90007F21EDA38F47D45F")

    private String credentialClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.211 -0400", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "5AFCF1F4E0687291CC7CA4D3055A48FA")

    private transient int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.212 -0400", hash_original_field = "CF1800CC1901A3075AA905052E41B6A7", hash_generated_field = "522B1D8FFAFEC98878EF974AAB3943DB")

    private transient CredOwner[] set;
    
    /**
     * Creates a new permission for private credentials specified by the target
     * name {@code name} and an {@code action}. The action is always
     * {@code "read"}.
     *
     * @param name
     *            the target name of the permission.
     * @param action
     *            the action {@code "read"}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.213 -0400", hash_original_method = "4F2ADFDE3AD70686FDA8372281E1EC9C", hash_generated_method = "2B65E9D19FCF1089AE051959EE4A39EA")
    
public PrivateCredentialPermission(String name, String action) {
        super(name);
        if (READ.equalsIgnoreCase(action)) {
            initTargetName(name);
        } else {
            throw new IllegalArgumentException("auth.11"); //$NON-NLS-1$
        }
    }

    /**
     * Creates a {@code PrivateCredentialPermission} from the {@code Credential}
     * class and set of principals.
     * 
     * @param credentialClass
     *            the credential class name.
     * @param principals
     *            the set of principals.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.213 -0400", hash_original_method = "AFC9A1FA93B486F9CADDAB6C7356797E", hash_generated_method = "E9E4C153C994890EEC9EA7AC38A5E3D2")
    
PrivateCredentialPermission(String credentialClass, Set<Principal> principals) {
        super(credentialClass);
        this.credentialClass = credentialClass;

        set = new CredOwner[principals.size()];
        for (Principal p : principals) {
            CredOwner element = new CredOwner(p.getClass().getName(), p.getName());
            // check for duplicate elements
            boolean found = false;
            for (int ii = 0; ii < offset; ii++) {
                if (set[ii].equals(element)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                set[offset++] = element;
            }
        }
    }

    /**
     * Initialize a PrivateCredentialPermission object and checks that a target
     * name has a correct format: CredentialClass 1*(PrincipalClass
     * "PrincipalName")
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.215 -0400", hash_original_method = "F5A0E19D9D1F2531226B3B43BC9AECC5", hash_generated_method = "64EE037A78D29A1E2753014EACA4C479")
    
private void initTargetName(String name) {

        if (name == null) {
            throw new NullPointerException("auth.0E"); //$NON-NLS-1$
        }

        // check empty string
        name = name.trim();
        if (name.length() == 0) {
            throw new IllegalArgumentException("auth.0F"); //$NON-NLS-1$
        }

        // get CredentialClass
        int beg = name.indexOf(' ');
        if (beg == -1) {
            throw new IllegalArgumentException("auth.10"); //$NON-NLS-1$
        }
        credentialClass = name.substring(0, beg);

        // get a number of pairs: PrincipalClass "PrincipalName"
        beg++;
        int count = 0;
        int nameLength = name.length();
        for (int i, j = 0; beg < nameLength; beg = j + 2, count++) {
            i = name.indexOf(' ', beg);
            j = name.indexOf('"', i + 2);

            if (i == -1 || j == -1 || name.charAt(i + 1) != '"') {
                throw new IllegalArgumentException("auth.10"); //$NON-NLS-1$
            }
        }

        // name MUST have one pair at least
        if (count < 1) {
            throw new IllegalArgumentException("auth.10"); //$NON-NLS-1$
        }

        beg = name.indexOf(' ');
        beg++;

        // populate principal set with instances of CredOwner class
        String principalClass;
        String principalName;

        set = new CredOwner[count];
        for (int index = 0, i, j; index < count; beg = j + 2, index++) {
            i = name.indexOf(' ', beg);
            j = name.indexOf('"', i + 2);

            principalClass = name.substring(beg, i);
            principalName = name.substring(i + 2, j);

            CredOwner element = new CredOwner(principalClass, principalName);
            // check for duplicate elements
            boolean found = false;
            for (int ii = 0; ii < offset; ii++) {
                if (set[ii].equals(element)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                set[offset++] = element;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.215 -0400", hash_original_method = "5CDB3052B2A6380D119795D444CA31C1", hash_generated_method = "7B549B12EEFB244B52AF5807E66CA6C6")
    
private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        initTargetName(getName());
    }

    /**
     * Returns the principal's classes and names associated with this {@code
     * PrivateCredentialPermission} as a two dimensional array. The first
     * dimension of the array corresponds to the number of principals. The
     * second dimension defines either the name of the {@code PrincipalClass}
     * [x][0] or the value of {@code PrincipalName} [x][1].
     * <p>
     * This corresponds to the the target name's syntax:
     *
     * <pre>
     * targetName = CredentialClass {PrincipalClass &quot;PrincipalName&quot;}*
     * </pre>
     *
     * @return the principal classes and names associated with this {@code
     *         PrivateCredentialPermission}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.216 -0400", hash_original_method = "24FBFC5FA49BF098DE3F58D4965D3686", hash_generated_method = "A5477E1025E2E70217E2D40D75B2DCC9")
    
public String[][] getPrincipals() {

        String[][] s = new String[offset][2];

        for (int i = 0; i < s.length; i++) {
            s[i][0] = set[i].principalClass;
            s[i][1] = set[i].principalName;
        }
        return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.216 -0400", hash_original_method = "EBFA1F6C605557F0A76F9875769AC581", hash_generated_method = "EA5852F44C566996CA450ADF2208FB05")
    
@Override
    public String getActions() {
        return READ;
    }

    /**
     * Returns the class name of the credential associated with this permission.
     *
     * @return the class name of the credential associated with this permission.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.217 -0400", hash_original_method = "92595E1B074EEA1AC40006DE5D65F330", hash_generated_method = "90E6091A3297F7CC78D7A2585E8260BA")
    
public String getCredentialClass() {
        return credentialClass;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.218 -0400", hash_original_method = "F0E6B2B42C825A02B0E1D6534B0F62F0", hash_generated_method = "D0B0454FC174E5DC7B0049AA834D9733")
    
@Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < offset; i++) {
            hash = hash + set[i].hashCode();
        }
        return getCredentialClass().hashCode() + hash;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.218 -0400", hash_original_method = "9674C8E6D6A6C595215B15DDC108D395", hash_generated_method = "CBC429B90EF1C5A3BF74420E0A2E0589")
    
@Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        PrivateCredentialPermission that = (PrivateCredentialPermission) obj;

        return credentialClass.equals(that.credentialClass) && (offset == that.offset)
                && sameMembers(set, that.set, offset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.219 -0400", hash_original_method = "5E3384C36C9BBC5DF8FED7E4A25F1AA7", hash_generated_method = "9E71EFE00166A201AE80CDB92D765927")
    
@Override
    public boolean implies(Permission permission) {

        if (permission == null || this.getClass() != permission.getClass()) {
            return false;
        }

        PrivateCredentialPermission that = (PrivateCredentialPermission) permission;

        if (!("*".equals(credentialClass) || credentialClass //$NON-NLS-1$
                .equals(that.getCredentialClass()))) {
            return false;
        }

        if (that.offset == 0) {
            return true;
        }

        CredOwner[] thisCo = set;
        CredOwner[] thatCo = that.set;
        int thisPrincipalsSize = offset;
        int thatPrincipalsSize = that.offset;
        for (int i = 0, j; i < thisPrincipalsSize; i++) {
            for (j = 0; j < thatPrincipalsSize; j++) {
                if (thisCo[i].implies(thatCo[j])) {
                    break;
                }
            }
            if (j == thatCo.length) {
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.220 -0400", hash_original_method = "DA96D46784C8FF1A364A51D34D35D507", hash_generated_method = "153DBC21B1C7592E079031F5B3A0E0D0")
    
@Override
    public PermissionCollection newPermissionCollection() {
        return null;
    }

    /**
     * Returns true if the two arrays have the same length, and every member of
     * one array is contained in another array
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.220 -0400", hash_original_method = "F2C311997B1BD2792B1132EA724E574F", hash_generated_method = "38C9B028E6E8B805F65CD5A833DC0539")
    
private boolean sameMembers(Object[] ar1, Object[] ar2, int length) {
        if (ar1 == null && ar2 == null) {
            return true;
        }
        if (ar1 == null || ar2 == null) {
            return false;
        }
        boolean found;
        for (int i = 0; i < length; i++) {
            found = false;
            for (int j = 0; j < length; j++) {
                if (ar1[i].equals(ar2[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    private static final class CredOwner implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.221 -0400", hash_original_field = "575B7DDFFAB8E9583B2F445B42A0AB64", hash_generated_field = "26BE30F45BEBE3D27035897CBEA7310C")

        private static final long serialVersionUID = -5607449830436408266L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.221 -0400", hash_original_field = "1570946915C8504A39DAB3B85BCBC553", hash_generated_field = "1570946915C8504A39DAB3B85BCBC553")

        String principalClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.222 -0400", hash_original_field = "9D5B4F034B59281BD3070F47F745E7CF", hash_generated_field = "9D5B4F034B59281BD3070F47F745E7CF")

        String principalName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.222 -0400", hash_original_field = "D34B5D0F055F4DB0FF5563D109DCCF5B", hash_generated_field = "A9B5A235C3CB596AC78FCC61E0F64085")

        private transient boolean isClassWildcard;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.223 -0400", hash_original_field = "10F61D94D0E3AC7C864E2B24356237F7", hash_generated_field = "59949B32E9483C27BBBE4200242ACD2C")

        private transient boolean isPNameWildcard;

        // Creates a new CredOwner with the specified Principal Class and Principal Name 
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.224 -0400", hash_original_method = "B65DE5DBA4196245C0C0DDC35429CE3B", hash_generated_method = "2CDC25F133465C1CCC6992E27AAC993C")
        
CredOwner(String principalClass, String principalName) {
            super();
            if ("*".equals(principalClass)) { //$NON-NLS-1$
                isClassWildcard = true;
            }

            if ("*".equals(principalName)) { //$NON-NLS-1$
                isPNameWildcard = true;
            }

            if (isClassWildcard && !isPNameWildcard) {
                throw new IllegalArgumentException("auth.12"); //$NON-NLS-1$
            }

            this.principalClass = principalClass;
            this.principalName = principalName;
        }

        // Checks if this CredOwner implies the specified Object. 
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.225 -0400", hash_original_method = "9F0EDFA95BE2D4CD4833B8DA622FEBD9", hash_generated_method = "9F0EDFA95BE2D4CD4833B8DA622FEBD9")
        
boolean implies(Object obj) {
            if (obj == this) {
                return true;
            }

            CredOwner co = (CredOwner) obj;

            if (isClassWildcard || principalClass.equals(co.principalClass)) {
                if (isPNameWildcard || principalName.equals(co.principalName)) {
                    return true;
                }
            }
            return false;
        }

        // Checks two CredOwner objects for equality. 
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.225 -0400", hash_original_method = "EF17C73AD8F7227B2959368EE77536F2", hash_generated_method = "2B41756CE1DF0075C0FE638DB686FF70")
        
@Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CredOwner) {
                CredOwner that = (CredOwner) obj;
                return principalClass.equals(that.principalClass)
                    && principalName.equals(that.principalName);
            }
            return false;
        }

        // Returns the hash code value for this object.
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.226 -0400", hash_original_method = "2DABB14DB78F341F713ED031333CD30C", hash_generated_method = "FB3525764277FED541110154673D1E19")
        
@Override
        public int hashCode() {
            return principalClass.hashCode() + principalName.hashCode();
        }
    }
}
