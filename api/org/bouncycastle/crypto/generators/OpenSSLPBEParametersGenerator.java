package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;






public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.707 -0500", hash_original_field = "5E1DE11F0B1BCDF1B09E413E2E26EF96", hash_generated_field = "91AB1A516766E39A2EE21B008511F72A")

    private Digest  digest = new MD5Digest();

    /**
     * Construct a OpenSSL Parameters generator. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.709 -0500", hash_original_method = "469CB0205646D06181D1559BA7D61CF9", hash_generated_method = "81337774ED506DBA26C3B2CACBFB0825")
    
public OpenSSLPBEParametersGenerator()
    {
    }

    /**
     * Initialise - note the iteration count for this algorithm is fixed at 1.
     * 
     * @param password password to use.
     * @param salt salt to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.712 -0500", hash_original_method = "2CA180C614EC01706903EAD38F06E97B", hash_generated_method = "8688346755F07E40936A0E7E989988A5")
    
public void init(
       byte[] password,
       byte[] salt)
    {
        super.init(password, salt, 1);
    }
    
    /**
     * the derived key function, the ith hash of the password and the salt.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.715 -0500", hash_original_method = "4E618B69222EA698951005FED9FF9FA3", hash_generated_method = "3E5BDE21AA2CFEDEC5F6B5AD711B6446")
    
private byte[] generateDerivedKey(
        int bytesNeeded)
    {
        byte[]  buf = new byte[digest.getDigestSize()];
        byte[]  key = new byte[bytesNeeded];
        int     offset = 0;
        
        for (;;)
        {
            digest.update(password, 0, password.length);
            digest.update(salt, 0, salt.length);

            digest.doFinal(buf, 0);
            
            int len = (bytesNeeded > buf.length) ? buf.length : bytesNeeded;
            System.arraycopy(buf, 0, key, offset, len);
            offset += len;

            // check if we need any more
            bytesNeeded -= len;
            if (bytesNeeded == 0)
            {
                break;
            }

            // do another round
            digest.reset();
            digest.update(buf, 0, buf.length);
        }
        
        return key;
    }

    /**
     * Generate a key parameter derived from the password, salt, and iteration
     * count we are currently initialised with.
     *
     * @param keySize the size of the key we want (in bits)
     * @return a KeyParameter object.
     * @exception IllegalArgumentException if the key length larger than the base hash size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.717 -0500", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "FE92A991493A370A91578410E0107D1F")
    
public CipherParameters generateDerivedParameters(
        int keySize)
    {
        keySize = keySize / 8;

        byte[]  dKey = generateDerivedKey(keySize);

        return new KeyParameter(dKey, 0, keySize);
    }

    /**
     * Generate a key with initialisation vector parameter derived from
     * the password, salt, and iteration count we are currently initialised
     * with.
     *
     * @param keySize the size of the key we want (in bits)
     * @param ivSize the size of the iv we want (in bits)
     * @return a ParametersWithIV object.
     * @exception IllegalArgumentException if keySize + ivSize is larger than the base hash size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.719 -0500", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "C303AAB7EA511965A225079A754DF7E1")
    
public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize)
    {
        keySize = keySize / 8;
        ivSize = ivSize / 8;

        byte[]  dKey = generateDerivedKey(keySize + ivSize);

        return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    /**
     * Generate a key parameter for use with a MAC derived from the password,
     * salt, and iteration count we are currently initialised with.
     *
     * @param keySize the size of the key we want (in bits)
     * @return a KeyParameter object.
     * @exception IllegalArgumentException if the key length larger than the base hash size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.722 -0500", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "394172050377204AF59B47DCF537242A")
    
public CipherParameters generateDerivedMacParameters(
        int keySize)
    {
        return generateDerivedParameters(keySize);
    }

    
}

