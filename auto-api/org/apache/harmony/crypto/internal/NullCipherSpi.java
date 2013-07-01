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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.010 -0400", hash_original_method = "FDE7F108401C679AA53E658D57386CA0", hash_generated_method = "FDE7F108401C679AA53E658D57386CA0")
    public NullCipherSpi ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.011 -0400", hash_original_method = "706F671562845F3E8688B6825B7BB7B5", hash_generated_method = "FD68E1F39F1A9AABEDDC863ED78C32FC")
    @Override
    public void engineSetMode(String arg0) throws NoSuchAlgorithmException {
        addTaint(arg0.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.012 -0400", hash_original_method = "F467B7E30ACE18A6916FD5129C6E9D6D", hash_generated_method = "052707AC6A6E1EE316864DCEE29A17AA")
    @Override
    public void engineSetPadding(String arg0) throws NoSuchPaddingException {
        addTaint(arg0.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.013 -0400", hash_original_method = "AA3F68511E1542DF3672139FD15FAFBD", hash_generated_method = "15AA839855B9469D071B26D52F9F7703")
    @Override
    public int engineGetBlockSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644175689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644175689;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.014 -0400", hash_original_method = "F5B40F368FE57EF79892E9499088FA98", hash_generated_method = "B64624BC545AE4A3C4AF5D2892AFA9CF")
    @Override
    public int engineGetOutputSize(int inputLen) {
        addTaint(inputLen);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733324333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733324333;
        // ---------- Original Method ----------
        //return inputLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.014 -0400", hash_original_method = "D58BACA19EEF36A04C3196887019A068", hash_generated_method = "3148D1DFCD21082B21C4A2A4BB62E952")
    @Override
    public byte[] engineGetIV() {
        byte[] varB9E113C96366097BE0A8A860277D6E97_567627341 = (new byte[8]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1937542414 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1937542414;
        // ---------- Original Method ----------
        //return new byte[8];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.015 -0400", hash_original_method = "5ACBCE845ECFAD3699BFF222B46DB669", hash_generated_method = "FCF7CEBA72CF663640CAE32CD641D52A")
    @Override
    public AlgorithmParameters engineGetParameters() {
        AlgorithmParameters varB4EAC82CA7396A68D541C85D26508E83_93593807 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_93593807 = null;
        varB4EAC82CA7396A68D541C85D26508E83_93593807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93593807;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.015 -0400", hash_original_method = "B46A0FD4E768F51B64954CE33560D103", hash_generated_method = "E8851E4BAA7182F4A2F402D371FAB35C")
    @Override
    public void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        addTaint(opmode);
        addTaint(key.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.016 -0400", hash_original_method = "17F5EBD605D037DD2AE1BC60DE6A1892", hash_generated_method = "1CCFF2551B6546A4CF66CB18D5670EA4")
    @Override
    public void engineInit(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(opmode);
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.016 -0400", hash_original_method = "34E3729604DBD7C3DE21E55F909979C4", hash_generated_method = "0C627444DB7D098C6FB2D0CD8F63C37A")
    @Override
    public void engineInit(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(opmode);
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.016 -0400", hash_original_method = "09310CB0118160B29BD7A01C1B70DD45", hash_generated_method = "44F5C9DAC6E00F4CD6BD9E9EA00F1A84")
    @Override
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        byte[] result = new byte[inputLen];
        System.arraycopy(input, inputOffset, result, 0, inputLen);
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1562001308 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1562001308;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //byte[] result = new byte[inputLen];
        //System.arraycopy(input, inputOffset, result, 0, inputLen);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.017 -0400", hash_original_method = "60A1BA3728F191B40038A2CE01896EE6", hash_generated_method = "EFAB22CB981F7E6C69E202C931F2809B")
    @Override
    public int engineUpdate(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445620612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445620612;
        // ---------- Original Method ----------
        //if (input == null) {
            //return 0;
        //}
        //System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        //return inputLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.017 -0400", hash_original_method = "52F18BDADF6C5DE31B16AD29ECF185DD", hash_generated_method = "DD45B51607A636ED5B93F6A6CC45FC2D")
    @Override
    public int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        int result = input.limit() - input.position();
        try 
        {
            output.put(input);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output buffer too small");
        } //End block
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097160268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097160268;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.017 -0400", hash_original_method = "BACBD39F75A04196004D2E06D99366CD", hash_generated_method = "6A081F76A156E101DCEE84A6478CCA7D")
    @Override
    public byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        byte[] var74E9904579F3D1676B0230EF88A25000_1457608701 = (engineUpdate(input, inputOffset, inputLen));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1035468444 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1035468444;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //return engineUpdate(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.018 -0400", hash_original_method = "C78AB3EC778278E6CB8FDDB4DDEF61A0", hash_generated_method = "CAA5EEF3777D89734258A78C8FBD5608")
    @Override
    public int engineDoFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        int result = engineUpdate(input, inputOffset, inputLen, output,
                outputOffset);
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823786401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1823786401;
        // ---------- Original Method ----------
        //int result = engineUpdate(input, inputOffset, inputLen, output,
                //outputOffset);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.018 -0400", hash_original_method = "245FFB9EDA02A1B2DEFFE10111DCBE72", hash_generated_method = "EB513D346A8EF8C63895CBA3891F13C3")
    @Override
    public int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        int var8B566363162AEDBA40DAE89A1004DADE_699613042 = (engineUpdate(input, output));
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753538293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753538293;
        // ---------- Original Method ----------
        //return engineUpdate(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.019 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "49181DDEC1D950BDDEFF1ED20A1742D0")
    @Override
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1192875904 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1192875904;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.019 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "B8B6316E4D9E6171378BB468661BC164")
    @Override
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        addTaint(wrappedKey[0]);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKeyType);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.019 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "8F2E3B5024421B5E72C5B39524D01EFC")
    @Override
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070214465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2070214465;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

