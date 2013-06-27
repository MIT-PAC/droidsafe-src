package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteOrder;
import java.util.Random;
import libcore.io.Memory;
import libcore.io.SizeOf;
import org.apache.harmony.security.fortress.Engine;
import org.apache.harmony.security.fortress.Services;
import org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl;

public class SecureRandom extends Random {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.470 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.470 -0400", hash_original_field = "2A9DF802799D43E18CBDCC1C0118F3D5", hash_generated_field = "3A956A531DB9FE4A5E154E058CE99C7C")

    private SecureRandomSpi secureRandomSpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.470 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.471 -0400", hash_original_method = "33F8886B5EAC6FEC4DE9DFB0ACBA3485", hash_generated_method = "FA1B742AD8977CBA524703B3467B70F8")
    public  SecureRandom() {
        super(0);
        Services.refresh();
        Provider.Service service;
        service = Services.getSecureRandomService();
        {
            this.provider = null;
            this.secureRandomSpi = new SHA1PRNG_SecureRandomImpl();
            this.algorithm = "SHA1PRNG";
        } //End block
        {
            try 
            {
                this.provider = service.getProvider();
                this.secureRandomSpi = (SecureRandomSpi)service.newInstance(null);
                this.algorithm = service.getAlgorithm();
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.471 -0400", hash_original_method = "9BC52FCDF813ED3C3D5BC6E2620A6B25", hash_generated_method = "34351629464DFCA81E505765D6774B50")
    public  SecureRandom(byte[] seed) {
        this();
        setSeed(seed);
        addTaint(seed[0]);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.471 -0400", hash_original_method = "BD02DB0E23AA7BAA028ADD51586ACEB6", hash_generated_method = "348089E8EA7EEF2DFBDECE19D1D244A9")
    protected  SecureRandom(SecureRandomSpi secureRandomSpi,
                           Provider provider) {
        this(secureRandomSpi, provider, "unknown");
        addTaint(secureRandomSpi.getTaint());
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.472 -0400", hash_original_method = "8ED38FDA0C5F7DDB2E6327092A1339E9", hash_generated_method = "C16B4A5D340303DC7C3B28F2F7D9E05B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.481 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "A16AD703ADA807AD5353FC8E4BE06301")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_713790898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_713790898 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_713790898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_713790898;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.514 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "679F21D61A021815322FAC97357EA0C1")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_148977335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_148977335 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_148977335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_148977335;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.515 -0400", hash_original_method = "8CEEFEAA85939144164B3CD7D68FA666", hash_generated_method = "3C767607DE2FF46B8110D1DED4AFE59A")
    public synchronized void setSeed(byte[] seed) {
        secureRandomSpi.engineSetSeed(seed);
        addTaint(seed[0]);
        // ---------- Original Method ----------
        //secureRandomSpi.engineSetSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.515 -0400", hash_original_method = "9FF68F20EA17830E094095398C2F5999", hash_generated_method = "5C582EDB03C343BC682B72BB798463B3")
    @Override
    public void setSeed(long seed) {
        byte[] byteSeed;
        byteSeed = new byte[SizeOf.LONG];
        Memory.pokeLong(byteSeed, 0, seed, ByteOrder.BIG_ENDIAN);
        setSeed(byteSeed);
        addTaint(seed);
        // ---------- Original Method ----------
        //if (seed == 0) {    
            //return;
        //}
        //byte[] byteSeed = new byte[SizeOf.LONG];
        //Memory.pokeLong(byteSeed, 0, seed, ByteOrder.BIG_ENDIAN);
        //setSeed(byteSeed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.515 -0400", hash_original_method = "AD0BFB52D4FF32A1ADE4FBCCEAA68479", hash_generated_method = "5ECEBFC043503CBF96EE0741EE222048")
    @Override
    public synchronized void nextBytes(byte[] bytes) {
        secureRandomSpi.engineNextBytes(bytes);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        //secureRandomSpi.engineNextBytes(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.516 -0400", hash_original_method = "5D37488B96B0B99188E69118313D10F5", hash_generated_method = "BB88EAEE6894EEB522BF68BD67A97B53")
    @Override
    protected final int next(int numBits) {
        {
            numBits = 0;
        } //End block
        {
            {
                numBits = 32;
            } //End block
        } //End block
        int bytes;
        bytes = (numBits+7)/8;
        byte[] next;
        next = new byte[bytes];
        int ret;
        ret = 0;
        nextBytes(next);
        {
            int i;
            i = 0;
            {
                ret = (next[i] & 0xFF) | (ret << 8);
            } //End block
        } //End collapsed parenthetic
        ret = ret >>> (bytes*8 - numBits);
        addTaint(numBits);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420119378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420119378;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.521 -0400", hash_original_method = "D819275281A9132149A7C81B1EB64271", hash_generated_method = "EEA804C0798CD24100F6D0E3CE9507C1")
    public byte[] generateSeed(int numBytes) {
        byte[] var15A980A0739C67DA04D9CD07E0145888_1995809639 = (secureRandomSpi.engineGenerateSeed(numBytes));
        addTaint(numBytes);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1174528325 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1174528325;
        // ---------- Original Method ----------
        //return secureRandomSpi.engineGenerateSeed(numBytes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.521 -0400", hash_original_field = "42918EFED80962D4305753FAC344C87E", hash_generated_field = "F2B52BD93751D0A8B4E72284F6ECEBB6")

    private static long serialVersionUID = 4940670005562187L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.521 -0400", hash_original_field = "98FB2C540761B08589242CC9820FD0DF", hash_generated_field = "A9FBCEB1B91393AEF05A1C02E3B5CDC4")

    private static String SERVICE = "SecureRandom";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.521 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.521 -0400", hash_original_field = "DF40A3D03CEB7B6E4DF4BD84688CE3F8", hash_generated_field = "31989AA54DF24BBD5CAEA96810169BB6")

    private static volatile SecureRandom internalSecureRandom;
}

