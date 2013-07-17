package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteOrder;
import java.util.Random;
import libcore.io.Memory;
import libcore.io.SizeOf;
import org.apache.harmony.security.fortress.Engine;
import org.apache.harmony.security.fortress.Services;
import org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl;

public class SecureRandom extends Random {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.352 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.352 -0400", hash_original_field = "2A9DF802799D43E18CBDCC1C0118F3D5", hash_generated_field = "3A956A531DB9FE4A5E154E058CE99C7C")

    private SecureRandomSpi secureRandomSpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.353 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.354 -0400", hash_original_method = "33F8886B5EAC6FEC4DE9DFB0ACBA3485", hash_generated_method = "29048687EE25D7D4906D69AA4CC00F6A")
    public  SecureRandom() {
        super(0);
        Services.refresh();
        Provider.Service service = Services.getSecureRandomService();
        if(service == null)        
        {
            this.provider = null;
            this.secureRandomSpi = new SHA1PRNG_SecureRandomImpl();
            this.algorithm = "SHA1PRNG";
        } //End block
        else
        {
            try 
            {
                this.provider = service.getProvider();
                this.secureRandomSpi = (SecureRandomSpi)service.newInstance(null);
                this.algorithm = service.getAlgorithm();
            } //End block
            catch (Exception e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_2066859880 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_2066859880.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_2066859880;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Services.refresh();
        //Provider.Service service = Services.getSecureRandomService();
        //if (service == null) {
            //this.provider = null;
            //this.secureRandomSpi = new SHA1PRNG_SecureRandomImpl();
            //this.algorithm = "SHA1PRNG";
        //} else {
            //try {
                //this.provider = service.getProvider();
                //this.secureRandomSpi = (SecureRandomSpi)service.newInstance(null);
                //this.algorithm = service.getAlgorithm();
            //} catch (Exception e) {
                //throw new RuntimeException(e);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.354 -0400", hash_original_method = "9BC52FCDF813ED3C3D5BC6E2620A6B25", hash_generated_method = "E8BC2A0795EA174DE6D7C4E375EEE7EC")
    public  SecureRandom(byte[] seed) {
        this();
        addTaint(seed[0]);
        setSeed(seed);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.354 -0400", hash_original_method = "BD02DB0E23AA7BAA028ADD51586ACEB6", hash_generated_method = "79A96A60F49CBED4ED102533D70B59AA")
    protected  SecureRandom(SecureRandomSpi secureRandomSpi,
                           Provider provider) {
        this(secureRandomSpi, provider, "unknown");
        addTaint(provider.getTaint());
        addTaint(secureRandomSpi.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.355 -0400", hash_original_method = "8ED38FDA0C5F7DDB2E6327092A1339E9", hash_generated_method = "C16B4A5D340303DC7C3B28F2F7D9E05B")
    private  SecureRandom(SecureRandomSpi secureRandomSpi,
                         Provider provider,
                         String algorithm) {
        super(0);
        this.provider = provider;
        this.algorithm = algorithm;
        this.secureRandomSpi = secureRandomSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.secureRandomSpi = secureRandomSpi;
    }

    
    public static SecureRandom getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new SecureRandom((SecureRandomSpi) sap.spi, sap.provider,
                                algorithm);
    }

    
    public static SecureRandom getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    
    public static SecureRandom getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new SecureRandom((SecureRandomSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.355 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "1C9C1CBDC972479F70AFCEFFB509BD9F")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1939243500 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1939243500.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1939243500;
        // ---------- Original Method ----------
        //return provider;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.355 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "DD3D79B10433F93F4C76F134311F1659")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_124656861 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_124656861.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_124656861;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.355 -0400", hash_original_method = "8CEEFEAA85939144164B3CD7D68FA666", hash_generated_method = "C305C24A0BDACA76013F2E18E9D375BB")
    public synchronized void setSeed(byte[] seed) {
        addTaint(seed[0]);
        secureRandomSpi.engineSetSeed(seed);
        // ---------- Original Method ----------
        //secureRandomSpi.engineSetSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.355 -0400", hash_original_method = "9FF68F20EA17830E094095398C2F5999", hash_generated_method = "6A47EE20B63FBB6F25D4EC6D49EAB781")
    @Override
    public void setSeed(long seed) {
        addTaint(seed);
        if(seed == 0)        
        {
            return;
        } //End block
        byte[] byteSeed = new byte[SizeOf.LONG];
        Memory.pokeLong(byteSeed, 0, seed, ByteOrder.BIG_ENDIAN);
        setSeed(byteSeed);
        // ---------- Original Method ----------
        //if (seed == 0) {    
            //return;
        //}
        //byte[] byteSeed = new byte[SizeOf.LONG];
        //Memory.pokeLong(byteSeed, 0, seed, ByteOrder.BIG_ENDIAN);
        //setSeed(byteSeed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.355 -0400", hash_original_method = "AD0BFB52D4FF32A1ADE4FBCCEAA68479", hash_generated_method = "AAB5DEBD428C06FD5026F50D10A270C2")
    @Override
    public synchronized void nextBytes(byte[] bytes) {
        addTaint(bytes[0]);
        secureRandomSpi.engineNextBytes(bytes);
        // ---------- Original Method ----------
        //secureRandomSpi.engineNextBytes(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.356 -0400", hash_original_method = "5D37488B96B0B99188E69118313D10F5", hash_generated_method = "E96BD3A325B63F1AEBD60045E3166708")
    @Override
    protected final int next(int numBits) {
        addTaint(numBits);
        if(numBits < 0)        
        {
            numBits = 0;
        } //End block
        else
        {
            if(numBits > 32)            
            {
                numBits = 32;
            } //End block
        } //End block
        int bytes = (numBits+7)/8;
        byte[] next = new byte[bytes];
        int ret = 0;
        nextBytes(next);
for(int i = 0;i < bytes;i++)
        {
            ret = (next[i] & 0xFF) | (ret << 8);
        } //End block
        ret = ret >>> (bytes*8 - numBits);
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_1423174960 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701187427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701187427;
        // ---------- Original Method ----------
        //if (numBits < 0) {
            //numBits = 0;
        //} else {
            //if (numBits > 32) {
                //numBits = 32;
            //}
        //}
        //int bytes = (numBits+7)/8;
        //byte[] next = new byte[bytes];
        //int ret = 0;
        //nextBytes(next);
        //for (int i = 0; i < bytes; i++) {
            //ret = (next[i] & 0xFF) | (ret << 8);
        //}
        //ret = ret >>> (bytes*8 - numBits);
        //return ret;
    }

    
    public static byte[] getSeed(int numBytes) {
        SecureRandom result = internalSecureRandom;
        if (result == null) {
            internalSecureRandom = result = new SecureRandom();
        }
        return result.generateSeed(numBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.356 -0400", hash_original_method = "D819275281A9132149A7C81B1EB64271", hash_generated_method = "83B875F17EEE0BB14B7B4A8C7B6197AE")
    public byte[] generateSeed(int numBytes) {
        addTaint(numBytes);
        byte[] var97A56C9A99A47BD0462A7C39E603268E_91316182 = (secureRandomSpi.engineGenerateSeed(numBytes));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_572808329 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_572808329;
        // ---------- Original Method ----------
        //return secureRandomSpi.engineGenerateSeed(numBytes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.356 -0400", hash_original_field = "42918EFED80962D4305753FAC344C87E", hash_generated_field = "F54DA2B97CCF38D28060376DCA270C3F")

    private static final long serialVersionUID = 4940670005562187L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.356 -0400", hash_original_field = "98FB2C540761B08589242CC9820FD0DF", hash_generated_field = "C89A6BFB64905EC5F61459987A032A82")

    private static final String SERVICE = "SecureRandom";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.356 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.356 -0400", hash_original_field = "DF40A3D03CEB7B6E4DF4BD84688CE3F8", hash_generated_field = "31989AA54DF24BBD5CAEA96810169BB6")

    private static volatile SecureRandom internalSecureRandom;
}

