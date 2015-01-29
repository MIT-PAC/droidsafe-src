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
public class OpenSSLKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.865 -0400", hash_original_field = "8215E0C121D6ABB0163C7AD91F0DBCC0", hash_generated_field = "BD1C84B906E542A0B7737CDBC958EBF4")

    private  int ctx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.865 -0400", hash_original_field = "5C56B4DF27E735403D16136885A130AA", hash_generated_field = "460F175189633448A068F46912EFB997")

    private  OpenSSLEngine engine;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.866 -0400", hash_original_method = "D5DEAE17F0F5966ABEFE2F4901C4EB55", hash_generated_method = "D5DEAE17F0F5966ABEFE2F4901C4EB55")
    
OpenSSLKey(int ctx) {
        this.ctx = ctx;
        engine = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.866 -0400", hash_original_method = "429A0D93F22E7B33703578C2D66CBF46", hash_generated_method = "429A0D93F22E7B33703578C2D66CBF46")
    
OpenSSLKey(int ctx, OpenSSLEngine engine) {
        this.ctx = ctx;
        this.engine = engine;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.867 -0400", hash_original_method = "CE28167840571296F7E66275819CAA3B", hash_generated_method = "44643193ADEF0A71BB339BEDC4491D02")
    
public int getPkeyContext() {
        return ctx;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.867 -0400", hash_original_method = "53C289429E63153A79293A6B6E11ACD6", hash_generated_method = "53C289429E63153A79293A6B6E11ACD6")
    
OpenSSLEngine getEngine() {
        return engine;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.867 -0400", hash_original_method = "5B20813B8F9701A6DFE59683C8AB4FAA", hash_generated_method = "5B20813B8F9701A6DFE59683C8AB4FAA")
    
boolean isEngineBased() {
        return engine != null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.868 -0400", hash_original_method = "42D5E551C4D40B684C14BAB7EDBF5755", hash_generated_method = "28EEC349C576A02458BC50C15E46787A")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (ctx != 0) {
                NativeCrypto.EVP_PKEY_free(ctx);
            }
        } finally {
            super.finalize();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.868 -0400", hash_original_method = "97505DB29D99D00F8564C9243E542B06", hash_generated_method = "393F08649BA51AE6644A73B1DC70C2C8")
    
@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof OpenSSLKey)) {
            return false;
        }

        OpenSSLKey other = (OpenSSLKey) o;
        if (ctx != other.getPkeyContext()) {
            return false;
        }

        if (engine == null) {
            return other.getEngine() == null;
        } else {
            return engine.equals(other.getEngine());
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:12.870 -0400", hash_original_method = "82D3407659631340B524C2B40C9AB98E", hash_generated_method = "2091F971A436BD62384F890E73E06B25")
    
@Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + ctx;
        hash = hash * 31 + (engine == null ? 0 : engine.getEngineContext());
        return hash;
    }
}
