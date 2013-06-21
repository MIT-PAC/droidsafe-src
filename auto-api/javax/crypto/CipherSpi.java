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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.965 -0400", hash_original_method = "57088A35FB2104AD2CEDD2998A7B7578", hash_generated_method = "B175E18BC1028895593001486C8188AB")
    @DSModeled(DSC.SAFE)
    public CipherSpi() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.967 -0400", hash_original_method = "A2736EFE3A54B9C2C8D99150445AC571", hash_generated_method = "71B8D65A545F3F64FC140A231AE9F895")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(output.dsTaint);
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
            boolean var011961AA1A198646CB962085FB0562D5_82164910 = (input.hasArray());
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
            boolean var57E518510FEB6FAA6CB151B8CC86FE3E_319925850 = (output.remaining() < bOutput.length);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    protected abstract byte[] engineDoFinal(byte[] input, int inputOffset,
            int inputLen) throws IllegalBlockSizeException, BadPaddingException;

    
    protected abstract int engineDoFinal(byte[] input, int inputOffset,
            int inputLen, byte[] output, int outputOffset)
            throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.968 -0400", hash_original_method = "EB2370CFCF7CAD7D2D42FF2FD39E8FD0", hash_generated_method = "CD1A0CDF17942482DEBF47F162F10A56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        dsTaint.addTaint(input.dsTaint);
        dsTaint.addTaint(output.dsTaint);
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
            boolean var011961AA1A198646CB962085FB0562D5_1572024908 = (input.hasArray());
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
            boolean var57E518510FEB6FAA6CB151B8CC86FE3E_1434929184 = (output.remaining() < bOutput.length);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.969 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "A9E2FFAA71F9D0B9DF6FFF2484FC4144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.969 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "2E4BBE6A45DACDF1A7435E6459D3FAD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        dsTaint.addTaint(wrappedKeyAlgorithm);
        dsTaint.addTaint(wrappedKey[0]);
        dsTaint.addTaint(wrappedKeyType);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Key)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.970 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "8EA98DF4057B1458522C001E45E55175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

