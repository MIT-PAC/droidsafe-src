package org.apache.harmony.crypto.internal;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public class NullCipherSpi extends CipherSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "D258A9498ECF4D2DC15F12303B48B2AA", hash_generated_method = "D258A9498ECF4D2DC15F12303B48B2AA")
        public NullCipherSpi ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "706F671562845F3E8688B6825B7BB7B5", hash_generated_method = "ADC8D770DFBC44B979169C6D85282A6E")
    @DSModeled(DSC.SAFE)
    @Override
    public void engineSetMode(String arg0) throws NoSuchAlgorithmException {
        dsTaint.addTaint(arg0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "F467B7E30ACE18A6916FD5129C6E9D6D", hash_generated_method = "EED50FA145B687385B06E14D34098CBE")
    @DSModeled(DSC.SAFE)
    @Override
    public void engineSetPadding(String arg0) throws NoSuchPaddingException {
        dsTaint.addTaint(arg0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "AA3F68511E1542DF3672139FD15FAFBD", hash_generated_method = "4A6CF5BD0AF1507D000C2C2D997394A5")
    @DSModeled(DSC.SAFE)
    @Override
    public int engineGetBlockSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "F5B40F368FE57EF79892E9499088FA98", hash_generated_method = "5599749C943B9E108078C80F911F3179")
    @DSModeled(DSC.SAFE)
    @Override
    public int engineGetOutputSize(int inputLen) {
        dsTaint.addTaint(inputLen);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return inputLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "D58BACA19EEF36A04C3196887019A068", hash_generated_method = "BF0311F81CE3559858065840AC27F155")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] engineGetIV() {
        byte[] varB9E113C96366097BE0A8A860277D6E97_1509082684 = (new byte[8]);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return new byte[8];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.772 -0400", hash_original_method = "5ACBCE845ECFAD3699BFF222B46DB669", hash_generated_method = "D29E4D48A8DE75E2D9A464F9E852D739")
    @DSModeled(DSC.SAFE)
    @Override
    public AlgorithmParameters engineGetParameters() {
        return (AlgorithmParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.773 -0400", hash_original_method = "B46A0FD4E768F51B64954CE33560D103", hash_generated_method = "1AEE17AAA4EE307F6B2A0E0D0A3D3CCF")
    @DSModeled(DSC.SAFE)
    @Override
    public void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.773 -0400", hash_original_method = "17F5EBD605D037DD2AE1BC60DE6A1892", hash_generated_method = "A8F13AA40239C61459F803C663C25EBB")
    @DSModeled(DSC.SAFE)
    @Override
    public void engineInit(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.773 -0400", hash_original_method = "34E3729604DBD7C3DE21E55F909979C4", hash_generated_method = "41853D74324B4EF2C630FC051D6DA55A")
    @DSModeled(DSC.SAFE)
    @Override
    public void engineInit(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        dsTaint.addTaint(opmode);
        dsTaint.addTaint(random.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.773 -0400", hash_original_method = "09310CB0118160B29BD7A01C1B70DD45", hash_generated_method = "6E33EB31B4AA12A4A96EFC2918BD7DF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        byte[] result;
        result = new byte[inputLen];
        System.arraycopy(input, inputOffset, result, 0, inputLen);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //byte[] result = new byte[inputLen];
        //System.arraycopy(input, inputOffset, result, 0, inputLen);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.773 -0400", hash_original_method = "60A1BA3728F191B40038A2CE01896EE6", hash_generated_method = "53673DE20D0C7B00E48FE1AED44DE006")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int engineUpdate(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(outputOffset);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        dsTaint.addTaint(output[0]);
        System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (input == null) {
            //return 0;
        //}
        //System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        //return inputLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.773 -0400", hash_original_method = "52F18BDADF6C5DE31B16AD29ECF185DD", hash_generated_method = "524D39DDE9D58EC2F93600DD822FCAB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(output.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int result;
        result = input.limit() - input.position();
        try 
        {
            output.put(input);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output buffer too small");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (input == null || output == null) {
            //throw new NullPointerException();
        //}
        //int result = input.limit() - input.position();
        //try {
            //output.put(input);
        //} catch (java.nio.BufferOverflowException e) {
            //throw new ShortBufferException("output buffer too small");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.774 -0400", hash_original_method = "BACBD39F75A04196004D2E06D99366CD", hash_generated_method = "A614F0DD75DC199F5CA2B64254E90DBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        byte[] var74E9904579F3D1676B0230EF88A25000_1792527709 = (engineUpdate(input, inputOffset, inputLen));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //return engineUpdate(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.774 -0400", hash_original_method = "C78AB3EC778278E6CB8FDDB4DDEF61A0", hash_generated_method = "144D455078B1FBE99D005FC2C636FA44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int engineDoFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(outputOffset);
        dsTaint.addTaint(inputOffset);
        dsTaint.addTaint(inputLen);
        dsTaint.addTaint(output[0]);
        int result;
        result = engineUpdate(input, inputOffset, inputLen, output,
                outputOffset);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = engineUpdate(input, inputOffset, inputLen, output,
                //outputOffset);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.774 -0400", hash_original_method = "245FFB9EDA02A1B2DEFFE10111DCBE72", hash_generated_method = "112585E35F3E7262750A89F52796D699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(output.dsTaint);
        int var8B566363162AEDBA40DAE89A1004DADE_1610922044 = (engineUpdate(input, output));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return engineUpdate(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.774 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "64860BE30DD63AB63F6FAFCEB68DD5B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.774 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "F4C37074F193C3ACF80E235D3AAD49D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        dsTaint.addTaint(wrappedKeyAlgorithm);
        dsTaint.addTaint(wrappedKey[0]);
        dsTaint.addTaint(wrappedKeyType);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Key)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.774 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "AF954AD694C5A170C2A2367C0281DD5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

