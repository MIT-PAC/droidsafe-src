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
    private Provider provider;
    private SecureRandomSpi secureRandomSpi;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.516 -0400", hash_original_method = "33F8886B5EAC6FEC4DE9DFB0ACBA3485", hash_generated_method = "FA1B742AD8977CBA524703B3467B70F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecureRandom() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.517 -0400", hash_original_method = "9BC52FCDF813ED3C3D5BC6E2620A6B25", hash_generated_method = "926B8D2BA5F45CB76424E05C331C638D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecureRandom(byte[] seed) {
        this();
        dsTaint.addTaint(seed[0]);
        setSeed(seed);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.517 -0400", hash_original_method = "BD02DB0E23AA7BAA028ADD51586ACEB6", hash_generated_method = "6B0937D482614AD556DAB8A61FDA4257")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SecureRandom(SecureRandomSpi secureRandomSpi,
                           Provider provider) {
        this(secureRandomSpi, provider, "unknown");
        dsTaint.addTaint(secureRandomSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.517 -0400", hash_original_method = "8ED38FDA0C5F7DDB2E6327092A1339E9", hash_generated_method = "F81A1048C508AC66E146DA9FB3EFEEC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SecureRandom(SecureRandomSpi secureRandomSpi,
                         Provider provider,
                         String algorithm) {
        super(0);
        dsTaint.addTaint(secureRandomSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(algorithm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.518 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.518 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "AB6B64DEEAE2006CFA3127C5F18A75FB")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.519 -0400", hash_original_method = "8CEEFEAA85939144164B3CD7D68FA666", hash_generated_method = "B8BC6676E6FA6F554C231B1CA32BE0B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSeed(byte[] seed) {
        dsTaint.addTaint(seed[0]);
        secureRandomSpi.engineSetSeed(seed);
        // ---------- Original Method ----------
        //secureRandomSpi.engineSetSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.519 -0400", hash_original_method = "9FF68F20EA17830E094095398C2F5999", hash_generated_method = "601DEBDA00310D44FC83CC4B60005DB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSeed(long seed) {
        dsTaint.addTaint(seed);
        byte[] byteSeed;
        byteSeed = new byte[SizeOf.LONG];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.520 -0400", hash_original_method = "AD0BFB52D4FF32A1ADE4FBCCEAA68479", hash_generated_method = "B5D29A883165EF0128F5EF365C9FB1D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void nextBytes(byte[] bytes) {
        dsTaint.addTaint(bytes[0]);
        secureRandomSpi.engineNextBytes(bytes);
        // ---------- Original Method ----------
        //secureRandomSpi.engineNextBytes(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.521 -0400", hash_original_method = "5D37488B96B0B99188E69118313D10F5", hash_generated_method = "1992CC90381CA5708EF9D9A88F64900D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected final int next(int numBits) {
        dsTaint.addTaint(numBits);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.523 -0400", hash_original_method = "D819275281A9132149A7C81B1EB64271", hash_generated_method = "075C215D12732BDE33E3413C0B677B10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] generateSeed(int numBytes) {
        dsTaint.addTaint(numBytes);
        byte[] var15A980A0739C67DA04D9CD07E0145888_466463083 = (secureRandomSpi.engineGenerateSeed(numBytes));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return secureRandomSpi.engineGenerateSeed(numBytes);
    }

    
    private static final long serialVersionUID = 4940670005562187L;
    private static final String SERVICE = "SecureRandom";
    private static final Engine ENGINE = new Engine(SERVICE);
    private static volatile SecureRandom internalSecureRandom;
}

