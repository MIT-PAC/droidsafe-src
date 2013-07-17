package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

public abstract class CipherSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.058 -0400", hash_original_method = "57088A35FB2104AD2CEDD2998A7B7578", hash_generated_method = "B175E18BC1028895593001486C8188AB")
    public  CipherSpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineSetMode(String mode)
            throws NoSuchAlgorithmException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineSetPadding(String padding)
            throws NoSuchPaddingException;

    
    @DSModeled(DSC.SAFE)
    protected abstract int engineGetBlockSize();

    
    @DSModeled(DSC.SAFE)
    protected abstract int engineGetOutputSize(int inputLen);

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineGetIV();

    
    @DSModeled(DSC.SAFE)
    protected abstract AlgorithmParameters engineGetParameters();

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(int opmode, Key key, SecureRandom random)
            throws InvalidKeyException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(int opmode, Key key,
            AlgorithmParameterSpec params, SecureRandom random)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineInit(int opmode, Key key,
            AlgorithmParameters params, SecureRandom random)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineUpdate(byte[] input, int inputOffset,
            int inputLen);

    
    @DSModeled(DSC.SAFE)
    protected abstract int engineUpdate(byte[] input, int inputOffset,
            int inputLen, byte[] output, int outputOffset)
            throws ShortBufferException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.063 -0400", hash_original_method = "A2736EFE3A54B9C2C8D99150445AC571", hash_generated_method = "F3245D2AC5AC77D6E8E531EEE2669F5A")
    protected int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
        if(input == null)        
        {
            NullPointerException var80D12A66DA4390DDDA2651FD3A45533D_352317797 = new NullPointerException("input == null");
            var80D12A66DA4390DDDA2651FD3A45533D_352317797.addTaint(taint);
            throw var80D12A66DA4390DDDA2651FD3A45533D_352317797;
        } //End block
        if(output == null)        
        {
            NullPointerException varBF4B938C40C694CB6BD4546A6615BEC2_1780093879 = new NullPointerException("output == null");
            varBF4B938C40C694CB6BD4546A6615BEC2_1780093879.addTaint(taint);
            throw varBF4B938C40C694CB6BD4546A6615BEC2_1780093879;
        } //End block
        int position = input.position();
        int limit = input.limit();
        if((limit - position) <= 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_2114648166 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685353009 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1685353009;
        } //End block
        byte[] bInput;
        byte[] bOutput;
        if(input.hasArray())        
        {
            bInput = input.array();
            int offset = input.arrayOffset();
            bOutput = engineUpdate(bInput, offset + position, limit - position);
            input.position(limit);
        } //End block
        else
        {
            bInput = new byte[limit - position];
            input.get(bInput);
            bOutput = engineUpdate(bInput, 0, limit - position);
        } //End block
        if(bOutput == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_501128005 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288778359 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288778359;
        } //End block
        if(output.remaining() < bOutput.length)        
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_1809337037 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_1809337037.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_1809337037;
        } //End block
        try 
        {
            output.put(bOutput);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_314659352 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_314659352.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_314659352;
        } //End block
        int varB4034539969FD5731B0199F2A7627E7D_231683955 = (bOutput.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394545720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394545720;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineDoFinal(byte[] input, int inputOffset,
            int inputLen) throws IllegalBlockSizeException, BadPaddingException;

    
    @DSModeled(DSC.SAFE)
    protected abstract int engineDoFinal(byte[] input, int inputOffset,
            int inputLen, byte[] output, int outputOffset)
            throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.066 -0400", hash_original_method = "EB2370CFCF7CAD7D2D42FF2FD39E8FD0", hash_generated_method = "F9087688E3F2B60BDC96AECE2B884F16")
    protected int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
        if(input == null)        
        {
            NullPointerException var80D12A66DA4390DDDA2651FD3A45533D_1537098979 = new NullPointerException("input == null");
            var80D12A66DA4390DDDA2651FD3A45533D_1537098979.addTaint(taint);
            throw var80D12A66DA4390DDDA2651FD3A45533D_1537098979;
        } //End block
        if(output == null)        
        {
            NullPointerException varBF4B938C40C694CB6BD4546A6615BEC2_354196975 = new NullPointerException("output == null");
            varBF4B938C40C694CB6BD4546A6615BEC2_354196975.addTaint(taint);
            throw varBF4B938C40C694CB6BD4546A6615BEC2_354196975;
        } //End block
        int position = input.position();
        int limit = input.limit();
        if((limit - position) <= 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1141171582 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997353203 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997353203;
        } //End block
        byte[] bInput;
        byte[] bOutput;
        if(input.hasArray())        
        {
            bInput = input.array();
            int offset = input.arrayOffset();
            bOutput = engineDoFinal(bInput, offset + position, limit - position);
            input.position(limit);
        } //End block
        else
        {
            bInput = new byte[limit - position];
            input.get(bInput);
            bOutput = engineDoFinal(bInput, 0, limit - position);
        } //End block
        if(output.remaining() < bOutput.length)        
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_413185066 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_413185066.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_413185066;
        } //End block
        try 
        {
            output.put(bOutput);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_772821588 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_772821588.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_772821588;
        } //End block
        int varB4034539969FD5731B0199F2A7627E7D_18330383 = (bOutput.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559999783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559999783;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.067 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "211BC753C9C2DBAB9121D742EAD5273E")
    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1257395334 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1257395334.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1257395334;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.068 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "06950BED5A9FFC2116A53E496727C4E7")
    protected Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        addTaint(wrappedKeyType);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKey[0]);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_647694311 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_647694311.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_647694311;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.068 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "16A7ACBD76345828A0E50C37FB3EDD50")
    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_764704432 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_764704432.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_764704432;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

