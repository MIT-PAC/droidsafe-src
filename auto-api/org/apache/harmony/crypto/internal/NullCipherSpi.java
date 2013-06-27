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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.753 -0400", hash_original_method = "FDE7F108401C679AA53E658D57386CA0", hash_generated_method = "FDE7F108401C679AA53E658D57386CA0")
    public NullCipherSpi ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.755 -0400", hash_original_method = "706F671562845F3E8688B6825B7BB7B5", hash_generated_method = "FD68E1F39F1A9AABEDDC863ED78C32FC")
    @Override
    public void engineSetMode(String arg0) throws NoSuchAlgorithmException {
        addTaint(arg0.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.756 -0400", hash_original_method = "F467B7E30ACE18A6916FD5129C6E9D6D", hash_generated_method = "052707AC6A6E1EE316864DCEE29A17AA")
    @Override
    public void engineSetPadding(String arg0) throws NoSuchPaddingException {
        addTaint(arg0.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.757 -0400", hash_original_method = "AA3F68511E1542DF3672139FD15FAFBD", hash_generated_method = "47784093EBFDB1A12107CEF17D5969BE")
    @Override
    public int engineGetBlockSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549966454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_549966454;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.772 -0400", hash_original_method = "F5B40F368FE57EF79892E9499088FA98", hash_generated_method = "EDF1CAD2AA5D984527957E407BBB1EA3")
    @Override
    public int engineGetOutputSize(int inputLen) {
        addTaint(inputLen);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509318918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_509318918;
        // ---------- Original Method ----------
        //return inputLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.773 -0400", hash_original_method = "D58BACA19EEF36A04C3196887019A068", hash_generated_method = "8022AA249D78990F8A01E74680C6539A")
    @Override
    public byte[] engineGetIV() {
        byte[] varB9E113C96366097BE0A8A860277D6E97_1870388130 = (new byte[8]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1686547258 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1686547258;
        // ---------- Original Method ----------
        //return new byte[8];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.775 -0400", hash_original_method = "5ACBCE845ECFAD3699BFF222B46DB669", hash_generated_method = "B7DB34677B9B0D15BE0A05971E1704AC")
    @Override
    public AlgorithmParameters engineGetParameters() {
        AlgorithmParameters varB4EAC82CA7396A68D541C85D26508E83_1023594833 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1023594833 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1023594833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1023594833;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.776 -0400", hash_original_method = "B46A0FD4E768F51B64954CE33560D103", hash_generated_method = "E8851E4BAA7182F4A2F402D371FAB35C")
    @Override
    public void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        addTaint(opmode);
        addTaint(key.getTaint());
        addTaint(random.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.777 -0400", hash_original_method = "17F5EBD605D037DD2AE1BC60DE6A1892", hash_generated_method = "1CCFF2551B6546A4CF66CB18D5670EA4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.777 -0400", hash_original_method = "34E3729604DBD7C3DE21E55F909979C4", hash_generated_method = "0C627444DB7D098C6FB2D0CD8F63C37A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.777 -0400", hash_original_method = "09310CB0118160B29BD7A01C1B70DD45", hash_generated_method = "164384A00A03C1204C6AB1DA1050545B")
    @Override
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        byte[] result;
        result = new byte[inputLen];
        System.arraycopy(input, inputOffset, result, 0, inputLen);
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1668692551 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1668692551;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //byte[] result = new byte[inputLen];
        //System.arraycopy(input, inputOffset, result, 0, inputLen);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.778 -0400", hash_original_method = "60A1BA3728F191B40038A2CE01896EE6", hash_generated_method = "57516004BFBD95988B64C4ED7885DA5E")
    @Override
    public int engineUpdate(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408318229 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408318229;
        // ---------- Original Method ----------
        //if (input == null) {
            //return 0;
        //}
        //System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        //return inputLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.779 -0400", hash_original_method = "52F18BDADF6C5DE31B16AD29ECF185DD", hash_generated_method = "5594FE50CE620E5F8A8DA16E3A4EAC0E")
    @Override
    public int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
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
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850122055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850122055;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.780 -0400", hash_original_method = "BACBD39F75A04196004D2E06D99366CD", hash_generated_method = "6672701D462EED413C5145FB71A1CCF1")
    @Override
    public byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        byte[] var74E9904579F3D1676B0230EF88A25000_473931713 = (engineUpdate(input, inputOffset, inputLen));
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_832569686 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_832569686;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //return engineUpdate(input, inputOffset, inputLen);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.785 -0400", hash_original_method = "C78AB3EC778278E6CB8FDDB4DDEF61A0", hash_generated_method = "FFD8A1FF051A6966F49C7940F4E565B6")
    @Override
    public int engineDoFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        int result;
        result = engineUpdate(input, inputOffset, inputLen, output,
                outputOffset);
        addTaint(input[0]);
        addTaint(inputOffset);
        addTaint(inputLen);
        addTaint(output[0]);
        addTaint(outputOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686906016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686906016;
        // ---------- Original Method ----------
        //int result = engineUpdate(input, inputOffset, inputLen, output,
                //outputOffset);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.785 -0400", hash_original_method = "245FFB9EDA02A1B2DEFFE10111DCBE72", hash_generated_method = "3D19EAF3EB40B085FA21ED09008366D4")
    @Override
    public int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        int var8B566363162AEDBA40DAE89A1004DADE_738903421 = (engineUpdate(input, output));
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102037655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102037655;
        // ---------- Original Method ----------
        //return engineUpdate(input, output);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.791 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "D21C0F70ADF04BD5BCBB72EF21EFABB8")
    @Override
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1110477874 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1110477874;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.801 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "B8B6316E4D9E6171378BB468661BC164")
    @Override
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(wrappedKey[0]);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKeyType);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.801 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "2DC35DB6CFFCE7C9C41355F5B6C82932")
    @Override
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993152158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993152158;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

