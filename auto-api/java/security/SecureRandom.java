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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.700 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.700 -0400", hash_original_field = "2A9DF802799D43E18CBDCC1C0118F3D5", hash_generated_field = "3A956A531DB9FE4A5E154E058CE99C7C")

    private SecureRandomSpi secureRandomSpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.700 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.701 -0400", hash_original_method = "33F8886B5EAC6FEC4DE9DFB0ACBA3485", hash_generated_method = "1D1D43D1E40687EA94638A7BFFFC528F")
    public  SecureRandom() {
        super(0);
        Services.refresh();
        Provider.Service service = Services.getSecureRandomService();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.701 -0400", hash_original_method = "9BC52FCDF813ED3C3D5BC6E2620A6B25", hash_generated_method = "34351629464DFCA81E505765D6774B50")
    public  SecureRandom(byte[] seed) {
        this();
        setSeed(seed);
        addTaint(seed[0]);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.702 -0400", hash_original_method = "BD02DB0E23AA7BAA028ADD51586ACEB6", hash_generated_method = "348089E8EA7EEF2DFBDECE19D1D244A9")
    protected  SecureRandom(SecureRandomSpi secureRandomSpi,
                           Provider provider) {
        this(secureRandomSpi, provider, "unknown");
        addTaint(secureRandomSpi.getTaint());
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.702 -0400", hash_original_method = "8ED38FDA0C5F7DDB2E6327092A1339E9", hash_generated_method = "C16B4A5D340303DC7C3B28F2F7D9E05B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.703 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "D20DEE69BCFCAC293C69D2178A6CF508")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1798633621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798633621 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1798633621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798633621;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.704 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "A7B62048EBE740D4D0E138CF2E5598C0")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_655793597 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_655793597 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_655793597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_655793597;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.704 -0400", hash_original_method = "8CEEFEAA85939144164B3CD7D68FA666", hash_generated_method = "3C767607DE2FF46B8110D1DED4AFE59A")
    public synchronized void setSeed(byte[] seed) {
        secureRandomSpi.engineSetSeed(seed);
        addTaint(seed[0]);
        // ---------- Original Method ----------
        //secureRandomSpi.engineSetSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.705 -0400", hash_original_method = "9FF68F20EA17830E094095398C2F5999", hash_generated_method = "A8273A3406449DF1BABB3A81BB53F128")
    @Override
    public void setSeed(long seed) {
        byte[] byteSeed = new byte[SizeOf.LONG];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.705 -0400", hash_original_method = "AD0BFB52D4FF32A1ADE4FBCCEAA68479", hash_generated_method = "5ECEBFC043503CBF96EE0741EE222048")
    @Override
    public synchronized void nextBytes(byte[] bytes) {
        secureRandomSpi.engineNextBytes(bytes);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        //secureRandomSpi.engineNextBytes(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.706 -0400", hash_original_method = "5D37488B96B0B99188E69118313D10F5", hash_generated_method = "032914808E448E67C8AD0958202D19C3")
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
        int bytes = (numBits+7)/8;
        byte[] next = new byte[bytes];
        int ret = 0;
        nextBytes(next);
        {
            int i = 0;
            {
                ret = (next[i] & 0xFF) | (ret << 8);
            } //End block
        } //End collapsed parenthetic
        ret = ret >>> (bytes*8 - numBits);
        addTaint(numBits);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403074600 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1403074600;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.707 -0400", hash_original_method = "D819275281A9132149A7C81B1EB64271", hash_generated_method = "B40DFFC1C39714E264D42B9DF7F9B112")
    public byte[] generateSeed(int numBytes) {
        byte[] var15A980A0739C67DA04D9CD07E0145888_1403327985 = (secureRandomSpi.engineGenerateSeed(numBytes));
        addTaint(numBytes);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1736179602 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1736179602;
        // ---------- Original Method ----------
        //return secureRandomSpi.engineGenerateSeed(numBytes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.707 -0400", hash_original_field = "42918EFED80962D4305753FAC344C87E", hash_generated_field = "F54DA2B97CCF38D28060376DCA270C3F")

    private static final long serialVersionUID = 4940670005562187L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.707 -0400", hash_original_field = "98FB2C540761B08589242CC9820FD0DF", hash_generated_field = "C89A6BFB64905EC5F61459987A032A82")

    private static final String SERVICE = "SecureRandom";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.707 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.707 -0400", hash_original_field = "DF40A3D03CEB7B6E4DF4BD84688CE3F8", hash_generated_field = "31989AA54DF24BBD5CAEA96810169BB6")

    private static volatile SecureRandom internalSecureRandom;
}

