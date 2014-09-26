/*
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

package java.security;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Vector;
import libcore.util.Objects;

/**
 * {@code Identity} represents an identity like a person or a company.
 *
 * @deprecated The functionality of this class has been replace by
 *             {@link Principal}, {@link KeyStore} and the {@code
 *             java.security.cert} package.
 */
@Deprecated
public abstract class Identity implements Principal, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.594 -0400", hash_original_field = "7D1D8D1E40783B595CB479C47C859622", hash_generated_field = "AF947E3D468016E83E3D9E37E534BE07")

    private static final long serialVersionUID = 3609922007826600659L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.609 -0400", hash_original_method = "A7F954CB46F413424643C7740B97FB5F", hash_generated_method = "C0A226B026402D480128430F6FED80E7")
    
private static boolean checkKeysEqual(PublicKey pk1, PublicKey pk2) {
        // first, they should have the same format
        // second, their encoded form must be the same

        // assert(pk1 != null);
        // assert(pk2 != null);

        String format1 = pk1.getFormat();
        String format2;
        if ((pk2 == null)
                || (((format2 = pk2.getFormat()) != null) ^ (format1 != null))
                || ((format1 != null) && !format1.equals(format2))) {
            return false;
        }

        return Arrays.equals(pk1.getEncoded(), pk2.getEncoded());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.595 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.597 -0400", hash_original_field = "B73719A7AAE8E737607C294F86B7D620", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private PublicKey publicKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.598 -0400", hash_original_field = "87C33EF884FDE9521F60810C2FE15099", hash_generated_field = "90D0AEADD30C88032A037E70A0C8661F")

    private String info = "no additional info";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.600 -0400", hash_original_field = "0E992AB0315E9C305D6F564C9151C1AC", hash_generated_field = "10F836343A6E51420CBD354BDB02B198")

    private IdentityScope scope;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.601 -0400", hash_original_field = "6385EC815594AAFE2429349D3CF59D2C", hash_generated_field = "0CAAE4A2364060511805E2AEDE7AE5E7")

    private Vector<Certificate> certificates;

    /**
     * Constructs a new instance of {@code Identity}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.602 -0400", hash_original_method = "CB97BE8665681C1FD82290A9CE03A1A5", hash_generated_method = "E272C8BEAABC3123340CEF4ACE80B66D")
    
protected Identity() {
    }

    /**
     * Creates a new instance of {@code Identity} with the specified name.
     *
     * @param name
     *            the name of this {@code Identity}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.604 -0400", hash_original_method = "E3097DC280CDD60CEDED62E099A03390", hash_generated_method = "96C27D0C6F298A949A4FF1EBADAB812B")
    
public Identity(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of {@code Identity} with the specified name and
     * the scope of this {@code Identity}.
     *
     * @param name
     *            the name of this {@code Identity}.
     * @param scope
     *            the {@code IdentityScope} of this {@code Identity}.
     * @throws KeyManagementException
     *             if an {@code Identity} with the same name is already present
     *             in the specified scope.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.605 -0400", hash_original_method = "056EF7AAEF101945E5FA5DDD5A73826E", hash_generated_method = "E18E20984EEA9C6F17CABDE0BA71D458")
    
public Identity(String name, IdentityScope scope)
            throws KeyManagementException {
        this(name);
        if (scope != null) {
            scope.addIdentity(this);
            this.scope = scope;
        }
    }

    /**
     * Adds a {@code Certificate} to this {@code Identity}.
     *
     * @param certificate
     *            the {@code Certificate} to be added to this {@code Identity}.
     * @throws KeyManagementException
     *             if the certificate is not valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.607 -0400", hash_original_method = "6EA8EF86DEC278922106CB5EF72B83B4", hash_generated_method = "CF95CA4507E4046F2447AFA1CFD5288D")
    
public void addCertificate(Certificate certificate) throws KeyManagementException {
        PublicKey certPK = certificate.getPublicKey();
        if (publicKey != null) {
            if (!checkKeysEqual(publicKey, certPK)) {
                throw new KeyManagementException("Cert's public key does not match Identity's public key");
            }
        } else {
            publicKey = certPK;
        }
        if (certificates == null) {
            certificates = new Vector<Certificate>();
        }
        certificates.add(certificate);
    }

    /**
     * Removes the specified {@code Certificate} from this {@code Identity}.
     *
     * @param certificate
     *            the {@code Certificate} to be removed.
     * @throws KeyManagementException
     *             if the certificate is not found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.610 -0400", hash_original_method = "42A1B6EBD3EEE559BD4DDA5DBC195E2F", hash_generated_method = "312C5373954F6895ECF240DF7CF517DA")
    
public void removeCertificate(Certificate certificate) throws KeyManagementException {
        if (certificates != null) {
            if (!certificates.contains(certificate)) {
                throw new KeyManagementException("Certificate not found");
            }
            certificates.removeElement(certificate);
        }
    }

    /**
     * Returns the certificates for this {@code Identity}. External
     * modifications of the returned array has no impact on this {@code
     * Identity}.
     *
     * @return the {@code Certificates} for this {@code Identity}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.612 -0400", hash_original_method = "D104920E77D8EC15C97C271CBCE1A883", hash_generated_method = "ED82F2173E90A235E48F2FF1556519E6")
    
public Certificate[] certificates() {
        if (certificates == null) {
            return new Certificate[0];
        }
        Certificate[] ret = new Certificate[certificates.size()];
        certificates.copyInto(ret);
        return ret;
    }

    /**
     * Compares the specified {@code Identity} with this {@code Identity} for
     * equality and returns {@code true} if the specified object is equal,
     * {@code false} otherwise.
     * <p>
     * To be equal, two {@code Identity} objects need to have the same name and
     * the same public keys.
     *
     * @param identity
     *            the identity to check for equality.
     * @return {@code true} if the {@code Identity} objects are equal, {@code
     *         false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.613 -0400", hash_original_method = "8454658419A5853813F711419FB84605", hash_generated_method = "07C8E7EBE0E3DBFA82A2B869A111550F")
    
protected boolean identityEquals(Identity identity) {
        if (!name.equals(identity.name)) {
            return false;
        }

        if (publicKey == null) {
            return (identity.publicKey == null);
        }

        return checkKeysEqual(publicKey, identity.publicKey);
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * this {@code Identity}.
     *
     * @param detailed
     *            whether or not this method should return detailed information.
     * @return a printable representation for this {@code Permission}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.615 -0400", hash_original_method = "32CCAF145BA814644094D517611ECCBD", hash_generated_method = "3DA3492FEB2C578A9D39A00EA0D25793")
    
public String toString(boolean detailed) {
        String s = toString();
        if (detailed) {
            s += " " + info;
        }
        return s;
    }

    /**
     * Returns the {@code IdentityScope} of this {@code Identity}.
     *
     * @return the {@code IdentityScope} of this {@code Identity}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.616 -0400", hash_original_method = "8D3716D60EC95206095ECECDF797D909", hash_generated_method = "4537210F77D6F9A1F9C3E4DA1D67CDE7")
    
public final IdentityScope getScope() {
        return scope;
    }

    /**
     * Sets the specified {@code PublicKey} to this {@code Identity}.
     *
     * @param key
     *            the {@code PublicKey} to be set.
     * @throws KeyManagementException
     *             if another {@code Identity} in the same scope as this {@code
     *             Identity} already has the same {@code PublicKey}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.618 -0400", hash_original_method = "07746AFA5BE01C744813A985C0B6B9B4", hash_generated_method = "4419EF9BFD98C94ABEAC02454B7ABD31")
    
public void setPublicKey(PublicKey key) throws KeyManagementException {
        // this check does not always work
        if ((scope != null) && (key != null)) {
            Identity i = scope.getIdentity(key);
            //System.out.println("###DEBUG## Identity: "+i);
            if ((i != null) && (i != this)) {
                throw new KeyManagementException("key already used in scope");
            }
        }
        this.publicKey = key;
        certificates = null;
    }

    /**
     * Returns the {@code PublicKey} associated with this {@code Identity}.
     *
     * @return the {@code PublicKey} associated with this {@code Identity}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.619 -0400", hash_original_method = "B22ED6AD84A8045C26D2FCA0D3FE359F", hash_generated_method = "6D989835A5BCEB3A2B35B428E8306F42")
    
public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * Sets an information string for this {@code Identity}.
     * @param info
     *            the information to be set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.620 -0400", hash_original_method = "F0039B0F0E829540AA4965ACFEFD07F6", hash_generated_method = "68F128964CFAEF7D2F6FC280D863E479")
    
public void setInfo(String info) {
        this.info = info;
    }

    /**
     * Returns the information string of this {@code Identity}.
     *
     * @return the information string of this {@code Identity}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.622 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "68C60099DFA11F525DDAC7E8AE6EF591")
    
public String getInfo() {
        return info;
    }

    /**
     * Compares the specified object with this {@code Identity} for equality and
     * returns {@code true} if the specified object is equal, {@code false}
     * otherwise. {@code Identity} objects are considered equal, if they have
     * the same name and are in the same scope.
     *
     * @param obj
     *            object to be compared for equality with this {@code
     *            Identity}.
     * @return {@code true} if the specified object is equal to this {@code
     *         Identity}, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.624 -0400", hash_original_method = "C1638042E8E9C99D965D888EF717C8C0", hash_generated_method = "24E6F2A1D62152C28ED0A94695759E79")
    
@Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Identity)) {
            return false;
        }
        Identity i = (Identity) obj;
        if (Objects.equal(name, i.name) && (Objects.equal(scope, i.scope))) {
            return true;
        }
        return identityEquals(i);
    }

    /**
     * Returns the name of this {@code Identity}.
     *
     * @return the name of this {@code Identity}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.625 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "CEAA3BC43A9BFF97F5638C3D9028D82D")
    
public final String getName() {
        return name;
    }

    /**
     * Returns the hash code value for this {@code Identity}. Returns the same
     * hash code for {@code Identity}s that are equal to each other as required
     * by the general contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this {@code Identity}.
     * @see Object#equals(Object)
     * @see Identity#equals(Object)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.626 -0400", hash_original_method = "13B260E109E0D57E7588A8E3E585468A", hash_generated_method = "3648D7BD57CF7BA370B057BF0FBE68F6")
    
@Override
    public int hashCode() {
        int hash = 0;
        if (name != null) {
            hash += name.hashCode();
        }
        if (scope != null) {
            hash += scope.hashCode();
        }
        return hash;
    }

    /**
     * Returns a string containing a concise, human-readable description of the
     * this {@code Identity} including its name and its scope.
     *
     * @return a printable representation for this {@code Identity}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.628 -0400", hash_original_method = "8DD06C79BE55073D14DB567FC2A10727", hash_generated_method = "5907867FDB3372C3804123E180797D7A")
    
@Override
    public String toString() {
        String s = (this.name == null ? "" : this.name);
        if (scope != null) {
            s += " [" + scope.getName() + "]";
        }
        return s;
    }
}
