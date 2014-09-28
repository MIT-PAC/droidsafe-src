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
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.InvalidKeySpecException;

public class OpenSSLDSAPrivateKey implements DSAPrivateKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.703 -0400", hash_original_field = "945A737F419DFA71AF13956EF9DBAB4B", hash_generated_field = "F5337AC2DB8C1C6A96296A248F58D518")

    private static final long serialVersionUID = 6524734576187424628L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.706 -0400", hash_original_method = "0F410C9B7D6D4D0D891BB154A372EB6A", hash_generated_method = "0880B12E084BBBF87632FA45EF6EF000")
    
static OpenSSLKey getInstance(DSAPrivateKey dsaPrivateKey) throws InvalidKeyException {
        try {
            DSAParams dsaParams = dsaPrivateKey.getParams();
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(
                    dsaParams.getP().toByteArray(),
                    dsaParams.getQ().toByteArray(),
                    dsaParams.getG().toByteArray(),
                    null,
                    dsaPrivateKey.getX().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.704 -0400", hash_original_field = "2BBE151CD18F6BE43F2D71C92EFFD1B2", hash_generated_field = "DFD3BD9B1577440A925A39226A8408EA")

    private  OpenSSLKey key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.704 -0400", hash_original_field = "BA37D59CC8048BC359FD1D0C6C36E808", hash_generated_field = "0DDD5F5CCFF0EF2DAC9F4BEA040264BA")

    private OpenSSLDSAParams params;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.705 -0400", hash_original_method = "D0D219F50270560D819FB23BCF1E385B", hash_generated_method = "D0D219F50270560D819FB23BCF1E385B")
    
OpenSSLDSAPrivateKey(OpenSSLKey key) {
        this.key = key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.706 -0400", hash_original_method = "DBFFB0D978304E6BD0CE5B8848A1AF8D", hash_generated_method = "DBFFB0D978304E6BD0CE5B8848A1AF8D")
    
OpenSSLDSAPrivateKey(DSAPrivateKeySpec dsaKeySpec) throws InvalidKeySpecException {
        try {
            key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_DSA(
                    dsaKeySpec.getP().toByteArray(),
                    dsaKeySpec.getQ().toByteArray(),
                    dsaKeySpec.getG().toByteArray(),
                    null,
                    dsaKeySpec.getX().toByteArray()));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.705 -0400", hash_original_method = "55DF8716BBFCEB54E01A56E3121067D7", hash_generated_method = "55DF8716BBFCEB54E01A56E3121067D7")
    
OpenSSLKey getOpenSSLKey() {
        return key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.706 -0400", hash_original_method = "BAE461DA26736A1AA8817522747AFAD3", hash_generated_method = "7CACE29E870549EE95204543B7EC77A4")
    
private void ensureReadParams() {
        if (params == null) {
            params = new OpenSSLDSAParams(key);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.707 -0400", hash_original_method = "31C093F6192C3E35581E5FD577ADD713", hash_generated_method = "CCE23EB2DC1F21FD9FCA7CCD42666436")
    
@Override
    public DSAParams getParams() {
        ensureReadParams();
        return params;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.707 -0400", hash_original_method = "5C4C6F336B235577E2CC589FC9611E6D", hash_generated_method = "44F71DE2467A62AA6509673B3D468273")
    
@Override
    public String getAlgorithm() {
        return "DSA";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.708 -0400", hash_original_method = "5E81860D7834FDC6BD08699FC36E6C1D", hash_generated_method = "B56A519D4605584A44C1BB85180811E5")
    
@Override
    public String getFormat() {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.708 -0400", hash_original_method = "963F8F60B157D9DFF23A819C2961D890", hash_generated_method = "1FB2431DF5A15E0FA847A2965C674703")
    
@Override
    public byte[] getEncoded() {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.709 -0400", hash_original_method = "F1C06941A2EE2C8CAE24F62D51DD0FB1", hash_generated_method = "A91223C4F19661B643B2DADA4F22DE3C")
    
@Override
    public BigInteger getX() {
        ensureReadParams();
        return params.getX();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.709 -0400", hash_original_method = "6EB84CADC20644D6096C92AD5E44F4C9", hash_generated_method = "66DD6B7491274C8933CC2A24F068666C")
    
public int getPkeyContext() {
        return key.getPkeyContext();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.710 -0400", hash_original_method = "A96CFD8B51A526612FB301412BB544A6", hash_generated_method = "6CF7A1D18375C03B8AED135A2E160487")
    
@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof OpenSSLDSAPrivateKey) {
            OpenSSLDSAPrivateKey other = (OpenSSLDSAPrivateKey) o;

            /*
             * We can shortcut the true case, but it still may be equivalent but
             * different copies.
             */
            if (key.equals(other.getOpenSSLKey())) {
                return true;
            }
        }

        if (!(o instanceof DSAPrivateKey)) {
            return false;
        }

        ensureReadParams();

        final BigInteger x = params.getX();
        if (x == null) {
            /*
             * If our X is null, we can't tell if these two private keys are
             * equivalent. This usually happens if this key is ENGINE-based. If
             * the other key was ENGINE-based, we should have caught it in the
             * OpenSSLDSAPrivateKey case.
             */
            return false;
        }

        final DSAPrivateKey other = (DSAPrivateKey) o;
        return x.equals(other.getX()) && params.equals(other.getParams());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.711 -0400", hash_original_method = "EBD4C840DFC595BD40B159B1E8DF840D", hash_generated_method = "F6E56EC725B938764CA2CBD00880FA7D")
    
@Override
    public int hashCode() {
        ensureReadParams();

        int hash = 1;

        final BigInteger x = getX();
        if (x != null) {
            hash = hash * 3 + x.hashCode();
        }

        hash = hash * 7 + params.hashCode();

        return hash;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.711 -0400", hash_original_method = "B889887C183ADF87A87ED14C717A57E5", hash_generated_method = "7C118C6D92B314068DD333A63B4D57BA")
    
@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OpenSSLDSAPrivateKey{");

        if (key.isEngineBased()) {
            sb.append("key=");
            sb.append(key);
            sb.append('}');
            return sb.toString();
        }

        ensureReadParams();
        sb.append("X=");
        sb.append(params.getX().toString(16));
        sb.append(',');
        sb.append("params=");
        sb.append(params.toString());
        sb.append('}');

        return sb.toString();
    }
}
