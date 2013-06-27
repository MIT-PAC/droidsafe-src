package javax.crypto;

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

public abstract class CipherSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.784 -0400", hash_original_method = "57088A35FB2104AD2CEDD2998A7B7578", hash_generated_method = "B175E18BC1028895593001486C8188AB")
    public  CipherSpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract void engineSetMode(String mode)
            throws NoSuchAlgorithmException;

    
    protected abstract void engineSetPadding(String padding)
            throws NoSuchPaddingException;

    
    protected abstract int engineGetBlockSize();

    
    protected abstract int engineGetOutputSize(int inputLen);

    
    protected abstract byte[] engineGetIV();

    
    protected abstract AlgorithmParameters engineGetParameters();

    
    protected abstract void engineInit(int opmode, Key key, SecureRandom random)
            throws InvalidKeyException;

    
    protected abstract void engineInit(int opmode, Key key,
            AlgorithmParameterSpec params, SecureRandom random)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    protected abstract void engineInit(int opmode, Key key,
            AlgorithmParameters params, SecureRandom random)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    protected abstract byte[] engineUpdate(byte[] input, int inputOffset,
            int inputLen);

    
    protected abstract int engineUpdate(byte[] input, int inputOffset,
            int inputLen, byte[] output, int outputOffset)
            throws ShortBufferException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.811 -0400", hash_original_method = "A2736EFE3A54B9C2C8D99150445AC571", hash_generated_method = "90B55FBE93939985CF26E2730BED71E5")
    protected int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("input == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("output == null");
        } //End block
        int position;
        position = input.position();
        int limit;
        limit = input.limit();
        byte[] bInput;
        byte[] bOutput;
        {
            boolean var011961AA1A198646CB962085FB0562D5_1404143011 = (input.hasArray());
            {
                bInput = input.array();
                int offset;
                offset = input.arrayOffset();
                bOutput = engineUpdate(bInput, offset + position, limit - position);
                input.position(limit);
            } //End block
            {
                bInput = new byte[limit - position];
                input.get(bInput);
                bOutput = engineUpdate(bInput, 0, limit - position);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var57E518510FEB6FAA6CB151B8CC86FE3E_288159751 = (output.remaining() < bOutput.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output buffer too small");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            output.put(bOutput);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output buffer too small");
        } //End block
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913194947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913194947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract byte[] engineDoFinal(byte[] input, int inputOffset,
            int inputLen) throws IllegalBlockSizeException, BadPaddingException;

    
    protected abstract int engineDoFinal(byte[] input, int inputOffset,
            int inputLen, byte[] output, int outputOffset)
            throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.812 -0400", hash_original_method = "EB2370CFCF7CAD7D2D42FF2FD39E8FD0", hash_generated_method = "79BA61BF0738934D809B3998D4056F4F")
    protected int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("input == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("output == null");
        } //End block
        int position;
        position = input.position();
        int limit;
        limit = input.limit();
        byte[] bInput;
        byte[] bOutput;
        {
            boolean var011961AA1A198646CB962085FB0562D5_1804920689 = (input.hasArray());
            {
                bInput = input.array();
                int offset;
                offset = input.arrayOffset();
                bOutput = engineDoFinal(bInput, offset + position, limit - position);
                input.position(limit);
            } //End block
            {
                bInput = new byte[limit - position];
                input.get(bInput);
                bOutput = engineDoFinal(bInput, 0, limit - position);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var57E518510FEB6FAA6CB151B8CC86FE3E_18200763 = (output.remaining() < bOutput.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output buffer too small");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            output.put(bOutput);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output buffer too small");
        } //End block
        addTaint(input.getTaint());
        addTaint(output.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645876132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645876132;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.817 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "884403F4AF67D2409672D23F267155B4")
    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2144826074 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2144826074;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.821 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "6F6C9C17AA5B39A8A3D807E57401C88D")
    protected Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(wrappedKey[0]);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKeyType);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.821 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "30EF0CA8997A8A5C310EA01F1FCE2F85")
    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111473234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_111473234;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

