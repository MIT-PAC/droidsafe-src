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
import java.security.InvalidKeyException;
import java.security.PrivateKey;

public class OpenSSLEngine {
    static {
        NativeCrypto.ENGINE_load_dynamic();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.157 -0400", hash_original_method = "EB136D56A1B1CCA786E5715883DC3BEE", hash_generated_method = "30EBDA390E902109F1002B191242F250")
    
public static OpenSSLEngine getInstance(String engine) throws IllegalArgumentException {
        if (engine == null) {
            throw new NullPointerException("engine == null");
        }

        final int engineCtx = NativeCrypto.ENGINE_by_id(engine);

        if (engineCtx == 0) {
            throw new IllegalArgumentException("Unknown ENGINE id: " + engine);
        }

        return new OpenSSLEngine(engineCtx);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.150 -0400", hash_original_field = "8215E0C121D6ABB0163C7AD91F0DBCC0", hash_generated_field = "BD1C84B906E542A0B7737CDBC958EBF4")

    private  int ctx;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.161 -0400", hash_original_method = "80DDEE09679739B36A68ABBE22948182", hash_generated_method = "900E24F45E41DC5A37E410ED56C0F25D")
    
private OpenSSLEngine(int engineCtx) {
        ctx = engineCtx;

        if (NativeCrypto.ENGINE_init(engineCtx) == 0) {
            throw new IllegalArgumentException("Could not initialize engine");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.168 -0400", hash_original_method = "34A70160A4CA171D4D6462E6FF5CF2A5", hash_generated_method = "5DFF05F492209127F06150DE85C5B79A")
    
public PrivateKey getPrivateKeyById(String id) throws InvalidKeyException {
        if (id == null) {
            throw new NullPointerException("id == null");
        }

        final int keyRef = NativeCrypto.ENGINE_load_private_key(ctx, id);
        if (keyRef == 0) {
            return null;
        }

        final int keyType = NativeCrypto.EVP_PKEY_type(keyRef);
        switch (keyType) {
            case NativeCrypto.EVP_PKEY_RSA:
                return OpenSSLRSAPrivateKey.getInstance(new OpenSSLKey(keyRef, this));
            case NativeCrypto.EVP_PKEY_DSA:
                return new OpenSSLDSAPrivateKey(new OpenSSLKey(keyRef, this));
            default:
                throw new InvalidKeyException("Unknown key type: " + keyType);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.171 -0400", hash_original_method = "37A204B0947BF77F99C02317BBC56DF5", hash_generated_method = "37A204B0947BF77F99C02317BBC56DF5")
    
int getEngineContext() {
        return ctx;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.176 -0400", hash_original_method = "5C7547596E72A5FF3E9521F6AF3D3B12", hash_generated_method = "A19FFCE416992CD34D1E3A4A779424D7")
    
@Override
    protected void finalize() throws Throwable {
        try {
            NativeCrypto.ENGINE_finish(ctx);
            NativeCrypto.ENGINE_free(ctx);
        } finally {
            super.finalize();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.180 -0400", hash_original_method = "6B4F3C29FCDC2A85938601ECC31EE1A5", hash_generated_method = "721C5A37F949F002F7AD0EE96D1C06C0")
    
@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof OpenSSLEngine)) {
            return false;
        }

        OpenSSLEngine other = (OpenSSLEngine) o;

        return other.getEngineContext() == ctx;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:30:59.188 -0400", hash_original_method = "89F66D92F3B199777B411A7716B061A8", hash_generated_method = "8E37BC3CA2E7F1AC054B54A2DEB2E115")
    
@Override
    public int hashCode() {
        return ctx;
    }
}
