/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.harmony.xnet.provider.jsse;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateCrtKeySpec;

public class OpenSSLRSAPrivateCrtKey extends OpenSSLRSAPrivateKey implements RSAPrivateCrtKey {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.583 -0400", hash_original_method = "9734F7BCDDF35C7F11636B5AF478DED7", hash_generated_method = "40E956E73F84D652868A45A01188A861")
    
private static OpenSSLKey init(RSAPrivateCrtKeySpec rsaKeySpec) throws InvalidKeySpecException {
        BigInteger modulus = rsaKeySpec.getModulus();
        BigInteger privateExponent = rsaKeySpec.getPrivateExponent();

        if (modulus == null) {
            throw new InvalidKeySpecException("modulus == null");
        } else if (privateExponent == null) {
            throw new InvalidKeySpecException("privateExponent == null");
        }

        try {
            /*
             * OpenSSL uses the public modulus to do RSA blinding. If
             * the public modulus is not available, the call to
             * EVP_PKEY_new_RSA will turn off blinding for this key
             * instance.
             */
            final BigInteger publicExponent = rsaKeySpec.getPublicExponent();
            final BigInteger primeP = rsaKeySpec.getPrimeP();
            final BigInteger primeQ = rsaKeySpec.getPrimeQ();
            final BigInteger primeExponentP = rsaKeySpec.getPrimeExponentP();
            final BigInteger primeExponentQ = rsaKeySpec.getPrimeExponentQ();
            final BigInteger crtCoefficient = rsaKeySpec.getCrtCoefficient();

            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(
                    modulus.toByteArray(),
                    publicExponent == null ? null : publicExponent.toByteArray(),
                    privateExponent.toByteArray(),
                    primeP == null ? null : primeP.toByteArray(),
                    primeQ == null ? null : primeQ.toByteArray(),
                    primeExponentP == null ? null : primeExponentP.toByteArray(),
                    primeExponentQ == null ? null : primeExponentQ.toByteArray(),
                    crtCoefficient == null ? null : crtCoefficient.toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.584 -0400", hash_original_method = "B05456F8995AD812B9764A4A82FC2908", hash_generated_method = "E0F81A0099C4ED66B98579B27EBC4ABC")
    
static OpenSSLKey getInstance(RSAPrivateCrtKey rsaPrivateKey) throws InvalidKeyException {
        BigInteger modulus = rsaPrivateKey.getModulus();
        BigInteger privateExponent = rsaPrivateKey.getPrivateExponent();

        if (modulus == null) {
            throw new InvalidKeyException("modulus == null");
        } else if (privateExponent == null) {
            throw new InvalidKeyException("privateExponent == null");
        }

        try {
            /*
             * OpenSSL uses the public modulus to do RSA blinding. If
             * the public modulus is not available, the call to
             * EVP_PKEY_new_RSA will turn off blinding for this key
             * instance.
             */
            final BigInteger publicExponent = rsaPrivateKey.getPublicExponent();
            final BigInteger primeP = rsaPrivateKey.getPrimeP();
            final BigInteger primeQ = rsaPrivateKey.getPrimeQ();
            final BigInteger primeExponentP = rsaPrivateKey.getPrimeExponentP();
            final BigInteger primeExponentQ = rsaPrivateKey.getPrimeExponentQ();
            final BigInteger crtCoefficient = rsaPrivateKey.getCrtCoefficient();

            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(
                    modulus.toByteArray(),
                    publicExponent == null ? null : publicExponent.toByteArray(),
                    privateExponent.toByteArray(),
                    primeP == null ? null : primeP.toByteArray(),
                    primeQ == null ? null : primeQ.toByteArray(),
                    primeExponentP == null ? null : primeExponentP.toByteArray(),
                    primeExponentQ == null ? null : primeExponentQ.toByteArray(),
                    crtCoefficient == null ? null : crtCoefficient.toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.579 -0400", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private BigInteger publicExponent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.579 -0400", hash_original_field = "7A3E1BB8B91AABDAC8096A6AF946B79F", hash_generated_field = "9A9C713E9D8E7513F2417C506E73722A")

    private BigInteger primeP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.579 -0400", hash_original_field = "1C81CE9A16FD4AC10BD085B1B94422AB", hash_generated_field = "9F91AA93693120FB89947F1BE699F0CA")

    private BigInteger primeQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.580 -0400", hash_original_field = "40B3FB6881B01131E42A79EC00848D20", hash_generated_field = "D5FB562D58D86204E98F2195C5586E56")

    private BigInteger primeExponentP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.580 -0400", hash_original_field = "6467AFAE24BDCED779196424DCB2176F", hash_generated_field = "1ACB6AF17AD2472C87AB927F2F837C22")

    private BigInteger primeExponentQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.581 -0400", hash_original_field = "A68F5C4250913ADDC701F6FCEA9C0282", hash_generated_field = "222659EB722B867F4069225DE0B214AA")

    private BigInteger crtCoefficient;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.581 -0400", hash_original_method = "F0ACEF8499B22610D9E62CF05C74413F", hash_generated_method = "F0ACEF8499B22610D9E62CF05C74413F")
    
OpenSSLRSAPrivateCrtKey(OpenSSLKey key) {
        super(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.582 -0400", hash_original_method = "C29BCD99F6C7AF228FCD1449B238DD65", hash_generated_method = "C29BCD99F6C7AF228FCD1449B238DD65")
    
OpenSSLRSAPrivateCrtKey(OpenSSLKey key, byte[][] params) {
        super(key, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.582 -0400", hash_original_method = "67BEA6A3EF597AD525246CA6E5807720", hash_generated_method = "588F8A5ED16EDBCD60AEF85906C256ED")
    
public OpenSSLRSAPrivateCrtKey(RSAPrivateCrtKeySpec rsaKeySpec) throws InvalidKeySpecException {
        super(init(rsaKeySpec));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.585 -0400", hash_original_method = "E120BECFE55AAFE17D2E8DD9199E3A17", hash_generated_method = "05EDB8AB1FE43471E447887FA2FF5D38")
    
@Override
    synchronized void readParams(byte[][] params) {
        super.readParams(params);
        // params[0] read in super.readParams
        if (params[1] != null) {
            publicExponent = new BigInteger(params[1]);
        }
        // params[2] read in super.readParams
        if (params[3] != null) {
            primeP = new BigInteger(params[3]);
        }
        if (params[4] != null) {
            primeQ = new BigInteger(params[4]);
        }
        if (params[5] != null) {
            primeExponentP = new BigInteger(params[5]);
        }
        if (params[6] != null) {
            primeExponentQ = new BigInteger(params[6]);
        }
        if (params[7] != null) {
            crtCoefficient = new BigInteger(params[7]);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.586 -0400", hash_original_method = "40126C150618E915FCF1A9EA6A263CF1", hash_generated_method = "DEB7A5DEE5274054EEEF762ED139D4B4")
    
@Override
    public BigInteger getPublicExponent() {
        ensureReadParams();
        return publicExponent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.586 -0400", hash_original_method = "500FAB52FB2150A515BF61E32981BD66", hash_generated_method = "A2DDBB36AC1687EA29E56B24A449EEEE")
    
@Override
    public BigInteger getPrimeP() {
        ensureReadParams();
        return primeP;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.586 -0400", hash_original_method = "DD2549D97A920AFB420B74A6E3EBFE0D", hash_generated_method = "740D1A96273693464E1E67A2EA94CDD4")
    
@Override
    public BigInteger getPrimeQ() {
        ensureReadParams();
        return primeQ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.587 -0400", hash_original_method = "B89A9413698FB939D83B76F98249272A", hash_generated_method = "770918F143CAABBDF2D395950790756F")
    
@Override
    public BigInteger getPrimeExponentP() {
        ensureReadParams();
        return primeExponentP;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.587 -0400", hash_original_method = "A2A54570D71EEEB296DBD07AF1271883", hash_generated_method = "269B98ECC7D52A7810207D6FA5C483DD")
    
@Override
    public BigInteger getPrimeExponentQ() {
        ensureReadParams();
        return primeExponentQ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.588 -0400", hash_original_method = "3F12EFFEB93C521D937E8F74272079B4", hash_generated_method = "947D3BC3CC98EED9EEEAEB83A16998E1")
    
@Override
    public BigInteger getCrtCoefficient() {
        ensureReadParams();
        return crtCoefficient;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.589 -0400", hash_original_method = "1429BB928872A7F4F3A71701C58D7693", hash_generated_method = "6E9776C36CA898B20918E4F1036C5999")
    
@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof OpenSSLRSAPrivateCrtKey) {
            OpenSSLRSAPrivateCrtKey other = (OpenSSLRSAPrivateCrtKey) o;

            /*
             * We can shortcut the true case, but it still may be equivalent but
             * different copies.
             */
            if (getOpenSSLKey().equals(other.getOpenSSLKey())) {
                return true;
            }
        }

        if (o instanceof RSAPrivateCrtKey) {
            ensureReadParams();
            RSAPrivateCrtKey other = (RSAPrivateCrtKey) o;

            return getModulus().equals(other.getModulus())
                    && publicExponent.equals(other.getPublicExponent())
                    && getPrivateExponent().equals(other.getPrivateExponent())
                    && primeP.equals(other.getPrimeP()) && primeQ.equals(other.getPrimeQ())
                    && primeExponentP.equals(other.getPrimeExponentP())
                    && primeExponentQ.equals(other.getPrimeExponentQ())
                    && crtCoefficient.equals(other.getCrtCoefficient());
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.589 -0400", hash_original_method = "82905360E2B008EEC8F4E3DE971DAE8F", hash_generated_method = "3CA9BD30EE489FAF604598AE69057AEF")
    
@Override
    public final int hashCode() {
        int hashCode = super.hashCode();
        if (publicExponent != null) {
            hashCode ^= publicExponent.hashCode();
        }
        return hashCode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.590 -0400", hash_original_method = "AD48F225387AC59133F875DB7CA49790", hash_generated_method = "E16F807D698E8319ED3A5C86A1D0C041")
    
@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateCrtKey{");

        if (getOpenSSLKey().isEngineBased()) {
            sb.append("key=");
            sb.append(getOpenSSLKey());
            sb.append('}');
            return sb.toString();
        }

        ensureReadParams();
        sb.append("modulus=");
        sb.append(getModulus().toString(16));
        sb.append(',');

        if (publicExponent != null) {
            sb.append("publicExponent=");
            sb.append(publicExponent.toString(16));
            sb.append(',');
        }

        sb.append("privateExponent=");
        sb.append(getPrivateExponent().toString(16));
        sb.append(',');

        if (primeP != null) {
            sb.append("primeP=");
            sb.append(primeP.toString(16));
            sb.append(',');
        }

        if (primeQ != null) {
            sb.append("primeQ=");
            sb.append(primeQ.toString(16));
            sb.append(',');
        }

        if (primeExponentP != null) {
            sb.append("primeExponentP=");
            sb.append(primeExponentP.toString(16));
            sb.append(',');
        }

        if (primeExponentQ != null) {
            sb.append("primeExponentQ=");
            sb.append(primeExponentQ.toString(16));
            sb.append(',');
        }

        if (crtCoefficient != null) {
            sb.append("crtCoefficient=");
            sb.append(crtCoefficient.toString(16));
            sb.append(',');
        }

        return sb.toString();
    }
}
