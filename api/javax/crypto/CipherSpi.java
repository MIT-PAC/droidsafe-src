package javax.crypto;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.660 -0400", hash_original_method = "57088A35FB2104AD2CEDD2998A7B7578", hash_generated_method = "B175E18BC1028895593001486C8188AB")
    public  CipherSpi() {
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.666 -0400", hash_original_method = "A2736EFE3A54B9C2C8D99150445AC571", hash_generated_method = "12E38CD5175D60CD9C7B52452793F14A")
    protected int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
    if(input == null)        
        {
            NullPointerException var80D12A66DA4390DDDA2651FD3A45533D_431660413 = new NullPointerException("input == null");
            var80D12A66DA4390DDDA2651FD3A45533D_431660413.addTaint(taint);
            throw var80D12A66DA4390DDDA2651FD3A45533D_431660413;
        } 
    if(output == null)        
        {
            NullPointerException varBF4B938C40C694CB6BD4546A6615BEC2_197327809 = new NullPointerException("output == null");
            varBF4B938C40C694CB6BD4546A6615BEC2_197327809.addTaint(taint);
            throw varBF4B938C40C694CB6BD4546A6615BEC2_197327809;
        } 
        int position = input.position();
        int limit = input.limit();
    if((limit - position) <= 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_664171176 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092057217 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1092057217;
        } 
        byte[] bInput;
        byte[] bOutput;
    if(input.hasArray())        
        {
            bInput = input.array();
            int offset = input.arrayOffset();
            bOutput = engineUpdate(bInput, offset + position, limit - position);
            input.position(limit);
        } 
        else
        {
            bInput = new byte[limit - position];
            input.get(bInput);
            bOutput = engineUpdate(bInput, 0, limit - position);
        } 
    if(bOutput == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_664291530 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861458577 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861458577;
        } 
    if(output.remaining() < bOutput.length)        
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_2058248955 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_2058248955.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_2058248955;
        } 
        try 
        {
            output.put(bOutput);
        } 
        catch (java.nio.BufferOverflowException e)
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_549433152 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_549433152.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_549433152;
        } 
        int varB4034539969FD5731B0199F2A7627E7D_59971044 = (bOutput.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464818064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464818064;
        
        
    }

    
    protected abstract byte[] engineDoFinal(byte[] input, int inputOffset,
            int inputLen) throws IllegalBlockSizeException, BadPaddingException;

    
    protected abstract int engineDoFinal(byte[] input, int inputOffset,
            int inputLen, byte[] output, int outputOffset)
            throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.670 -0400", hash_original_method = "EB2370CFCF7CAD7D2D42FF2FD39E8FD0", hash_generated_method = "DAD95AC0DCF3075042BD90F29B90F62B")
    protected int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
    if(input == null)        
        {
            NullPointerException var80D12A66DA4390DDDA2651FD3A45533D_1382153702 = new NullPointerException("input == null");
            var80D12A66DA4390DDDA2651FD3A45533D_1382153702.addTaint(taint);
            throw var80D12A66DA4390DDDA2651FD3A45533D_1382153702;
        } 
    if(output == null)        
        {
            NullPointerException varBF4B938C40C694CB6BD4546A6615BEC2_1401995240 = new NullPointerException("output == null");
            varBF4B938C40C694CB6BD4546A6615BEC2_1401995240.addTaint(taint);
            throw varBF4B938C40C694CB6BD4546A6615BEC2_1401995240;
        } 
        int position = input.position();
        int limit = input.limit();
    if((limit - position) <= 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1293491186 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632267918 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1632267918;
        } 
        byte[] bInput;
        byte[] bOutput;
    if(input.hasArray())        
        {
            bInput = input.array();
            int offset = input.arrayOffset();
            bOutput = engineDoFinal(bInput, offset + position, limit - position);
            input.position(limit);
        } 
        else
        {
            bInput = new byte[limit - position];
            input.get(bInput);
            bOutput = engineDoFinal(bInput, 0, limit - position);
        } 
    if(output.remaining() < bOutput.length)        
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_925453241 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_925453241.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_925453241;
        } 
        try 
        {
            output.put(bOutput);
        } 
        catch (java.nio.BufferOverflowException e)
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_100047424 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_100047424.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_100047424;
        } 
        int varB4034539969FD5731B0199F2A7627E7D_2027315967 = (bOutput.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008497038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008497038;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.671 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "8DE99F6F360D9B3FA1313EB2D4CFD708")
    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1897847288 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1897847288.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1897847288;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.672 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "62489F93C1345648F878F4ECC6BB434C")
    protected Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        addTaint(wrappedKeyType);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKey[0]);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_949307390 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_949307390.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_949307390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.672 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "713EEE60A59CAF945A24FB34ADFA45BB")
    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2071490054 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2071490054.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2071490054;
        
        
    }

    
}

