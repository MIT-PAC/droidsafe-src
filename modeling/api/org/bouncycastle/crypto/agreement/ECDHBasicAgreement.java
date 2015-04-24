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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.crypto.agreement;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;

public class ECDHBasicAgreement implements BasicAgreement {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.468 -0500", hash_original_field = "CF6232C3E0511A4B7D31E1B88F324CFB", hash_generated_field = "33F61DD1418CAC13EC66C645A8578DF2")

    private ECPrivateKeyParameters key;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.493 -0400", hash_original_method = "96D932906701A5168A9F039F437639FE", hash_generated_method = "96D932906701A5168A9F039F437639FE")
    public ECDHBasicAgreement ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.470 -0500", hash_original_method = "C673BA12443BA4859FBCFCA898D52D2A", hash_generated_method = "39917E5490CC18BD63A70FFCADE7E15B")
    
public void init(
        CipherParameters key)
    {
        this.key = (ECPrivateKeyParameters)key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.472 -0500", hash_original_method = "A4626478FBEED8D6DC4BEF1AE35576B3", hash_generated_method = "E57B437FB90F9CA071355CDDABF453E6")
    
public BigInteger calculateAgreement(
        CipherParameters pubKey)
    {
        ECPublicKeyParameters pub = (ECPublicKeyParameters)pubKey;
        ECPoint P = pub.getQ().multiply(key.getD());

        // if (p.isInfinity()) throw new RuntimeException("d*Q == infinity");

        return P.getX().toBigInteger();
    }
    
}

