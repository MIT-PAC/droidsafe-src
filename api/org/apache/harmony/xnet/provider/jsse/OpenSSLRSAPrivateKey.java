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
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

public class OpenSSLRSAPrivateKey implements RSAPrivateKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.769 -0400", hash_original_field = "B7A0AE6CAD24E6CCA7F14F550FEF5246", hash_generated_field = "B619F8B400F2C540A0900D01686853D1")

    private static final long serialVersionUID = 4872170254439578735L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.773 -0400", hash_original_method = "FB67D4634DF979C13810873A068E9AAC", hash_generated_method = "4CA65914D5AF54FA929491462101785A")
    
private static OpenSSLKey init(RSAPrivateKeySpec rsaKeySpec) throws InvalidKeySpecException {
        final BigInteger modulus = rsaKeySpec.getModulus();
        final BigInteger privateExponent = rsaKeySpec.getPrivateExponent();

        if (modulus == null) {
            throw new InvalidKeySpecException("modulus == null");
        } else if (privateExponent == null) {
            throw new InvalidKeySpecException("privateExponent == null");
        }

        try {
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(
                    modulus.toByteArray(),
                    null,
                    privateExponent.toByteArray(),
                    null,
                    null,
                    null,
                    null,
                    null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.774 -0400", hash_original_method = "E71C4DB93F6D4C3D7C63508EAF690B59", hash_generated_method = "076592CA766D76E4B98A464B56FBFAA6")
    
static OpenSSLRSAPrivateKey getInstance(OpenSSLKey key) {
      byte[][] params = NativeCrypto.get_RSA_private_params(key.getPkeyContext());
      if (params[1] != null) {
          return new OpenSSLRSAPrivateCrtKey(key, params);
      }
      return new OpenSSLRSAPrivateKey(key, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.774 -0400", hash_original_method = "1A92D84CD4BAA83B1EBEE68D06ED0B8F", hash_generated_method = "5F7DA26AFB6D9B919E9DF14B87B08B98")
    
static OpenSSLKey getInstance(RSAPrivateKey rsaPrivateKey) throws InvalidKeyException {
        final BigInteger modulus = rsaPrivateKey.getModulus();
        final BigInteger privateExponent = rsaPrivateKey.getPrivateExponent();

        if (modulus == null) {
            throw new InvalidKeyException("modulus == null");
        } else if (privateExponent == null) {
            throw new InvalidKeyException("privateExponent == null");
        }

        try {
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_RSA(
                    modulus.toByteArray(),
                    null,
                    privateExponent.toByteArray(),
                    null,
                    null,
                    null,
                    null,
                    null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.770 -0400", hash_original_field = "2BBE151CD18F6BE43F2D71C92EFFD1B2", hash_generated_field = "DFD3BD9B1577440A925A39226A8408EA")

    private  OpenSSLKey key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.770 -0400", hash_original_field = "25CEE6432AEBE2A91CEA7F02499BDFB9", hash_generated_field = "CE8B534A4E4ACE7D3E4DABDBB639F277")

    private boolean fetchedParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.770 -0400", hash_original_field = "D547DBA0A38067ABD647006ED77692E3", hash_generated_field = "3E4E39310D57F50C3E323DC3AEC4D41E")

    private BigInteger modulus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.771 -0400", hash_original_field = "9D6B5BA90FEDFF37C5B6F5CC23882550", hash_generated_field = "C40656991088519C04EB55EF0874A837")

    private BigInteger privateExponent;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.771 -0400", hash_original_method = "4DFD00EDD3F903FA1A73B66BC3EB0DC1", hash_generated_method = "4DFD00EDD3F903FA1A73B66BC3EB0DC1")
    
OpenSSLRSAPrivateKey(OpenSSLKey key) {
        this.key = key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.772 -0400", hash_original_method = "9F9D7575DA6B57764A9131229B12E279", hash_generated_method = "9F9D7575DA6B57764A9131229B12E279")
    
OpenSSLRSAPrivateKey(OpenSSLKey key, byte[][] params) {
        this(key);
        readParams(params);
        fetchedParams = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.772 -0400", hash_original_method = "0A1535F350BEF04B68DC305D443487C3", hash_generated_method = "AB0151D6C0F71549EC798175E4B0CA50")
    
public OpenSSLRSAPrivateKey(RSAPrivateKeySpec rsaKeySpec) throws InvalidKeySpecException {
        this(init(rsaKeySpec));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.772 -0400", hash_original_method = "55DF8716BBFCEB54E01A56E3121067D7", hash_generated_method = "D507DB298AEE1B3744457617516313F0")
    
final OpenSSLKey getOpenSSLKey() {
        return key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.775 -0400", hash_original_method = "E388A291CFBF4E7C0448565A1B05D926", hash_generated_method = "DF3126AB619379B19D365E0AECE04D05")
    
synchronized final void ensureReadParams() {
        if (fetchedParams) {
            return;
        }
        readParams(NativeCrypto.get_RSA_private_params(key.getPkeyContext()));
        fetchedParams = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.775 -0400", hash_original_method = "760D17ACA30D6394BAFB071E740F12A7", hash_generated_method = "B2209DC992D75F9FC4C5F770A14A589C")
    
void readParams(byte[][] params) {
        if (params[0] == null) {
            throw new NullPointerException("modulus == null");
        } else if (params[2] == null && !key.isEngineBased()) {
            throw new NullPointerException("privateExponent == null");
        }

        modulus = new BigInteger(params[0]);

        // ENGINE-based keys are not guaranteed to have a private exponent.
        if (params[2] != null) {
            privateExponent = new BigInteger(params[2]);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.776 -0400", hash_original_method = "FC5D99F5BD3DD41164CF0B4C6B9B6F26", hash_generated_method = "22E177EB85FFF2AFC247398D738E7963")
    
@Override
    public final BigInteger getPrivateExponent() {
        ensureReadParams();
        return privateExponent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.776 -0400", hash_original_method = "FA84EBFBA475F49700880FAE45411B47", hash_generated_method = "0F2BC1604101C7A4BF4EB1C092FE1E4C")
    
@Override
    public final BigInteger getModulus() {
        ensureReadParams();
        return modulus;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.777 -0400", hash_original_method = "963F8F60B157D9DFF23A819C2961D890", hash_generated_method = "01416FBBCBF4DC3E61645EDAB6042194")
    
@Override
    public final byte[] getEncoded() {
        /*
         * If we're using an OpenSSL ENGINE, there's no guarantee we can export
         * the key. Returning {@code null} tells the caller that there's no
         * encoded format.
         */
        if (key.isEngineBased()) {
            return null;
        }

        return NativeCrypto.i2d_PKCS8_PRIV_KEY_INFO(key.getPkeyContext());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.778 -0400", hash_original_method = "5E81860D7834FDC6BD08699FC36E6C1D", hash_generated_method = "0B6566EA52DA181F232CF1B6515725C7")
    
public final String getFormat() {
        /*
         * If we're using an OpenSSL ENGINE, there's no guarantee we can export
         * the key. Returning {@code null} tells the caller that there's no
         * encoded format.
         */
        if (key.isEngineBased()) {
            return null;
        }

        return "PKCS#8";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.778 -0400", hash_original_method = "78865592484E57121CD3BAA8D15ABC0F", hash_generated_method = "18661AC8667223A886F007DC51B3C72F")
    
@Override
    public final String getAlgorithm() {
        return "RSA";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.778 -0400", hash_original_method = "6EB84CADC20644D6096C92AD5E44F4C9", hash_generated_method = "66DD6B7491274C8933CC2A24F068666C")
    
public int getPkeyContext() {
        return key.getPkeyContext();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.779 -0400", hash_original_method = "E979C61FA41A33C3C3C93FBB0ED3D599", hash_generated_method = "77A21B3DB1D0C57CDFA18DBCEA3EA02E")
    
@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof OpenSSLRSAPrivateKey) {
            OpenSSLRSAPrivateKey other = (OpenSSLRSAPrivateKey) o;

            /*
             * We can shortcut the true case, but it still may be equivalent but
             * different copies.
             */
            if (key.equals(other.getOpenSSLKey())) {
                return true;
            }
        }

        if (o instanceof RSAPrivateKey) {
            ensureReadParams();
            RSAPrivateKey other = (RSAPrivateKey) o;

            return modulus.equals(other.getModulus())
                    && privateExponent.equals(other.getPrivateExponent());
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.779 -0400", hash_original_method = "008BC99FEAE20A26FC52BEB373EA49D0", hash_generated_method = "B94BED972B99701FED32A9385AA11515")
    
@Override
    public int hashCode() {
        ensureReadParams();
        int hash = 1;

        hash = hash * 3 + modulus.hashCode();
        if (privateExponent != null) {
            hash = hash * 7 + privateExponent.hashCode();
        }

        return hash;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.780 -0400", hash_original_method = "2CD3C744C2985CC40BF751A42FE6CA48", hash_generated_method = "5BD20014A880AEE2F0597AF9871659C8")
    
@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenSSLRSAPrivateKey{");

        if (key.isEngineBased()) {
            sb.append("key=");
            sb.append(key);
            sb.append('}');
            return sb.toString();
        }

        ensureReadParams();
        sb.append("modulus=");
        sb.append(modulus.toString(16));
        sb.append(',');

        sb.append("privateExponent=");
        sb.append(privateExponent.toString(16));
        sb.append(',');

        return sb.toString();
    }
}
