package org.apache.harmony.crypto.internal;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.842 -0400", hash_original_method = "FDE7F108401C679AA53E658D57386CA0", hash_generated_method = "FDE7F108401C679AA53E658D57386CA0")
    public NullCipherSpi ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.842 -0400", hash_original_method = "706F671562845F3E8688B6825B7BB7B5", hash_generated_method = "FD68E1F39F1A9AABEDDC863ED78C32FC")
    @Override
    public void engineSetMode(String arg0) throws NoSuchAlgorithmException {
        addTaint(arg0.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.842 -0400", hash_original_method = "F467B7E30ACE18A6916FD5129C6E9D6D", hash_generated_method = "052707AC6A6E1EE316864DCEE29A17AA")
    @Override
    public void engineSetPadding(String arg0) throws NoSuchPaddingException {
        addTaint(arg0.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.842 -0400", hash_original_method = "AA3F68511E1542DF3672139FD15FAFBD", hash_generated_method = "9563B8C32048887C6B973D92099F4E81")
    @Override
    public int engineGetBlockSize() {
        int varC4CA4238A0B923820DCC509A6F75849B_1047791073 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399543254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399543254;
        // ---------- Original Method ----------
        //return 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "F5B40F368FE57EF79892E9499088FA98", hash_generated_method = "5932E55C50CD99BDD4F18FEA09EB95C4")
    @Override
    public int engineGetOutputSize(int inputLen) {
        addTaint(inputLen);
        int varBC6DD90C5EB9206BDC7F34401CDF4607_1423371839 = (inputLen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431205981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431205981;
        // ---------- Original Method ----------
        //return inputLen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "D58BACA19EEF36A04C3196887019A068", hash_generated_method = "597EDEEA50BECD5ED87E5938947E0977")
    @Override
    public byte[] engineGetIV() {
        byte[] varF06A60EAE173B2E0D234C61D5F9EAA77_396329540 = (new byte[8]);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1433856398 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1433856398;
        // ---------- Original Method ----------
        //return new byte[8];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "5ACBCE845ECFAD3699BFF222B46DB669", hash_generated_method = "8F1BE4AA067339F8B6A30FF38472BA97")
    @Override
    public AlgorithmParameters engineGetParameters() {
AlgorithmParameters var540C13E9E156B687226421B24F2DF178_1418274210 =         null;
        var540C13E9E156B687226421B24F2DF178_1418274210.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1418274210;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "B46A0FD4E768F51B64954CE33560D103", hash_generated_method = "A0BE11F4AAA3182B4CE6F9044915DFC1")
    @Override
    public void engineInit(int opmode, Key key, SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "17F5EBD605D037DD2AE1BC60DE6A1892", hash_generated_method = "0AB640691F86C8C7BAE222E3C0633E01")
    @Override
    public void engineInit(int opmode, Key key, AlgorithmParameterSpec params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "34E3729604DBD7C3DE21E55F909979C4", hash_generated_method = "AD93FF58E782E81E049552E6FB01E20B")
    @Override
    public void engineInit(int opmode, Key key, AlgorithmParameters params,
            SecureRandom random) throws InvalidKeyException,
            InvalidAlgorithmParameterException {
        addTaint(random.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        addTaint(opmode);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "09310CB0118160B29BD7A01C1B70DD45", hash_generated_method = "7AE34FF3A3E560F4C4A70D40909DFB86")
    @Override
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(input == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_429433279 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_206717881 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_206717881;
        } //End block
        byte[] result = new byte[inputLen];
        System.arraycopy(input, inputOffset, result, 0, inputLen);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1999210972 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1769034885 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1769034885;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //byte[] result = new byte[inputLen];
        //System.arraycopy(input, inputOffset, result, 0, inputLen);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.843 -0400", hash_original_method = "60A1BA3728F191B40038A2CE01896EE6", hash_generated_method = "9CD763A0E177D37590D3026FC1506DAE")
    @Override
    public int engineUpdate(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException {
        addTaint(outputOffset);
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(input == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1389797629 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8128948 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8128948;
        } //End block
        System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        int varBC6DD90C5EB9206BDC7F34401CDF4607_1145150867 = (inputLen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008928503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008928503;
        // ---------- Original Method ----------
        //if (input == null) {
            //return 0;
        //}
        //System.arraycopy(input, inputOffset, output, outputOffset, inputLen);
        //return inputLen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "52F18BDADF6C5DE31B16AD29ECF185DD", hash_generated_method = "CF443B36FEEE9C4E189C577FBA41EF3A")
    @Override
    public int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
        if(input == null || output == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1647834757 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1647834757.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1647834757;
        } //End block
        int result = input.limit() - input.position();
        try 
        {
            output.put(input);
        } //End block
        catch (java.nio.BufferOverflowException e)
        {
            ShortBufferException varDAD5F610721385D9E15DD53D0E564C0D_328413506 = new ShortBufferException("output buffer too small");
            varDAD5F610721385D9E15DD53D0E564C0D_328413506.addTaint(taint);
            throw varDAD5F610721385D9E15DD53D0E564C0D_328413506;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_189479984 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250576843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250576843;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "BACBD39F75A04196004D2E06D99366CD", hash_generated_method = "B907BC915B51C7A76671342F457DF8FC")
    @Override
    public byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) throws IllegalBlockSizeException, BadPaddingException {
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        if(input == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_820011490 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_843297351 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_843297351;
        } //End block
        byte[] varB5FD44896078D874A56A5C4B39D16F92_117679280 = (engineUpdate(input, inputOffset, inputLen));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_771555875 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_771555875;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //return engineUpdate(input, inputOffset, inputLen);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "C78AB3EC778278E6CB8FDDB4DDEF61A0", hash_generated_method = "DF128EFB0679F7D0B2761F41FA3188A5")
    @Override
    public int engineDoFinal(byte[] input, int inputOffset, int inputLen,
            byte[] output, int outputOffset) throws ShortBufferException,
            IllegalBlockSizeException, BadPaddingException {
        addTaint(outputOffset);
        addTaint(output[0]);
        addTaint(inputLen);
        addTaint(inputOffset);
        addTaint(input[0]);
        int result = engineUpdate(input, inputOffset, inputLen, output,
                outputOffset);
        int varB4A88417B3D0170D754C647C30B7216A_179128168 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124107571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124107571;
        // ---------- Original Method ----------
        //int result = engineUpdate(input, inputOffset, inputLen, output,
                //outputOffset);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "245FFB9EDA02A1B2DEFFE10111DCBE72", hash_generated_method = "FF57FC2FB6BE9F7088A22D9D61F0E916")
    @Override
    public int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException,
            BadPaddingException {
        addTaint(output.getTaint());
        addTaint(input.getTaint());
        int varDDEA2AC630D7953F6CE7284CD8B69E7F_127973022 = (engineUpdate(input, output));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839342410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1839342410;
        // ---------- Original Method ----------
        //return engineUpdate(input, output);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "39FE6C15BFF89C7EBC497DBB2542410E", hash_generated_method = "C36024C51B943AE7B59C714A10CF8ED8")
    @Override
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1394565572 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1394565572.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1394565572;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "6B4157CFE5E357119D9C5A035C31A1F5", hash_generated_method = "112E40C5460033D801F5B935564D42C8")
    @Override
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm,
            int wrappedKeyType) throws InvalidKeyException,
            NoSuchAlgorithmException {
        addTaint(wrappedKeyType);
        addTaint(wrappedKeyAlgorithm.getTaint());
        addTaint(wrappedKey[0]);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1067340594 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1067340594.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1067340594;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.844 -0400", hash_original_method = "3103A3DFE966B970FCF19F267AD5457A", hash_generated_method = "10E60E80F59157D3AD793DE0EDCC7554")
    @Override
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_471703452 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_471703452.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_471703452;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

