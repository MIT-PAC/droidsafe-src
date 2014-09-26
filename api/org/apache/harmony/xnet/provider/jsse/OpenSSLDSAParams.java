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
import java.security.interfaces.DSAParams;
import java.security.spec.AlgorithmParameterSpec;

public class OpenSSLDSAParams implements DSAParams, AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.836 -0400", hash_original_field = "2BBE151CD18F6BE43F2D71C92EFFD1B2", hash_generated_field = "DFD3BD9B1577440A925A39226A8408EA")

    private OpenSSLKey key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.837 -0400", hash_original_field = "25CEE6432AEBE2A91CEA7F02499BDFB9", hash_generated_field = "CE8B534A4E4ACE7D3E4DABDBB639F277")

    private boolean fetchedParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.837 -0400", hash_original_field = "12F45ECD0F75F4702B861E1DEFDA99B3", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private BigInteger g;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.837 -0400", hash_original_field = "36A2346422FAB1A0484079E02615C501", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private BigInteger p;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.838 -0400", hash_original_field = "F819999E3B2036A19089F4FD0B5D94F4", hash_generated_field = "7F0CB7A9968EC0E34C6D35217A4E048F")

    private BigInteger q;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.838 -0400", hash_original_field = "7C667BA619B926582BFC8401F882439D", hash_generated_field = "E87E2F8BC9A92B0C676B9ECF48E707BE")

    private BigInteger y;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.838 -0400", hash_original_field = "8A69D3B9CF67CA1128DF293842071E77", hash_generated_field = "3D78E4B6D398CF86CC9666CFD1AA5B41")

    private BigInteger x;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.839 -0400", hash_original_method = "9BF0356021F438F27CA30896C3E7056B", hash_generated_method = "9BF0356021F438F27CA30896C3E7056B")
    
OpenSSLDSAParams(OpenSSLKey key) {
        this.key = key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.839 -0400", hash_original_method = "55DF8716BBFCEB54E01A56E3121067D7", hash_generated_method = "55DF8716BBFCEB54E01A56E3121067D7")
    
OpenSSLKey getOpenSSLKey() {
        return key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.840 -0400", hash_original_method = "16676928144BFF8B4B693291E53C34C4", hash_generated_method = "F1D14F56BD76F259328776462D1DDDCE")
    
private synchronized final void ensureReadParams() {
        if (fetchedParams) {
            return;
        }

        byte[][] params = NativeCrypto.get_DSA_params(key.getPkeyContext());
        g = new BigInteger(params[0]);
        p = new BigInteger(params[1]);
        q = new BigInteger(params[2]);
        if (params[3] != null) {
            y = new BigInteger(params[3]);
        }
        if (params[4] != null) {
            x = new BigInteger(params[4]);
        }

        fetchedParams = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.840 -0400", hash_original_method = "A8E76146701BD1A403D26A7E710DA7A6", hash_generated_method = "5D90346649FAC4EFA76AFE0DDAA4AD0E")
    
@Override
    public BigInteger getG() {
        ensureReadParams();
        return g;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.841 -0400", hash_original_method = "352ED2F1B0F40E79B0935D6DDB9366D4", hash_generated_method = "D62B8F957E4B7FA969E5A42F756E07ED")
    
@Override
    public BigInteger getP() {
        ensureReadParams();
        return p;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.841 -0400", hash_original_method = "A9560A55B69502543DA642CFBA58C5F5", hash_generated_method = "1D523D782981C94C5135AE61C0D9FE13")
    
@Override
    public BigInteger getQ() {
        ensureReadParams();
        return q;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.841 -0400", hash_original_method = "C85952FAC7CFF394F830655430559859", hash_generated_method = "C85952FAC7CFF394F830655430559859")
    
BigInteger getY() {
        ensureReadParams();
        return y;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.842 -0400", hash_original_method = "B1FB527E7C355EA82FDE87274B75F7BA", hash_generated_method = "B1FB527E7C355EA82FDE87274B75F7BA")
    
BigInteger getX() {
        ensureReadParams();
        return x;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.842 -0400", hash_original_method = "88BBECE09CFCD0C903B9A63F26FB4290", hash_generated_method = "4BCEF8510E87705E36E8F26C57E0BF6D")
    
@Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o instanceof OpenSSLDSAParams) {
            OpenSSLDSAParams other = (OpenSSLDSAParams) o;

            /*
             * We can shortcut the true case, but it still may be equivalent but
             * different copies.
             */
            if (key == other.getOpenSSLKey()) {
                return true;
            }
        }

        if (!(o instanceof DSAParams)) {
            return false;
        }

        ensureReadParams();

        DSAParams other = (DSAParams) o;
        return g.equals(other.getG()) && p.equals(other.getP()) && q.equals(other.getQ());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.843 -0400", hash_original_method = "C2F947D042953ED951D25BD1E240F908", hash_generated_method = "00E74E54A21F45EEA3F38CD90431DE05")
    
@Override
    public int hashCode() {
        ensureReadParams();

        return g.hashCode() ^ p.hashCode() ^ q.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.844 -0400", hash_original_method = "5A8E2061D3D4FAFE7CF506FC8345D5E9", hash_generated_method = "6038F80391F497E73843CC9BEF1F75E7")
    
@Override
    public String toString() {
        ensureReadParams();

        final StringBuilder sb = new StringBuilder("OpenSSLDSAParams{");
        sb.append("G=");
        sb.append(g.toString(16));
        sb.append(",P=");
        sb.append(p.toString(16));
        sb.append(",Q=");
        sb.append(q.toString(16));
        sb.append('}');

        return sb.toString();
    }
}
