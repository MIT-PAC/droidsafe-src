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
    private static final long serialVersionUID = 4940670005562187L;
    private static final String SERVICE = "SecureRandom";
    private static final Engine ENGINE = new Engine(SERVICE);
    private  Provider provider;
    private  SecureRandomSpi secureRandomSpi;
    private  String algorithm;
    private static volatile SecureRandom internalSecureRandom;
    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.689 -0400",hash_original_method="D819275281A9132149A7C81B1EB64271",hash_generated_method="0B53CFBBF1B244182AFD676A7611D5AD")
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
                throw new RuntimeException(e);
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.689 -0400",hash_original_method="D819275281A9132149A7C81B1EB64271",hash_generated_method="0B53CFBBF1B244182AFD676A7611D5AD")
public SecureRandom(byte[] seed) {
        this();
        dsTaint.addTaint(seed);
        setSeed(seed);
        // ---------- Original Method ----------
        //setSeed(seed);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.689 -0400",hash_original_method="D819275281A9132149A7C81B1EB64271",hash_generated_method="0B53CFBBF1B244182AFD676A7611D5AD")
protected SecureRandom(SecureRandomSpi secureRandomSpi,
                           Provider provider) {
        this(secureRandomSpi, provider, "unknown");
        dsTaint.addTaint(secureRandomSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.689 -0400",hash_original_method="D819275281A9132149A7C81B1EB64271",hash_generated_method="0B53CFBBF1B244182AFD676A7611D5AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.925 -0400", hash_original_method = "4857474807562CBFBD7813A9B58F56F0", hash_generated_method = "FDEBE827545D7E04D2A1C0D6CBDBD07B")
    public static SecureRandom getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new SecureRandom((SecureRandomSpi) sap.spi, sap.provider,
                                algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.926 -0400", hash_original_method = "DE97096A3B9FE3F043FDC55F6D0E2300", hash_generated_method = "6146C77DBE8442048A0AABE34E0AE58D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.927 -0400", hash_original_method = "AC11452CE9958E1D0E60D203EE825B8B", hash_generated_method = "3E3FB0A7C163821919ECD821587E5937")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.928 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "45F6335264F85F3B8D73CAC979348AC1")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.935 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "75DDA5B74AE9E48C88748DEDB99D3006")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.936 -0400", hash_original_method = "8CEEFEAA85939144164B3CD7D68FA666", hash_generated_method = "F49FC4D54EEA1C3F186FD4D543489F2F")
    @DSModeled(DSC.SAFE)
    public synchronized void setSeed(byte[] seed) {
        dsTaint.addTaint(seed);
        secureRandomSpi.engineSetSeed(seed);
        // ---------- Original Method ----------
        //secureRandomSpi.engineSetSeed(seed);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.938 -0400", hash_original_method = "9FF68F20EA17830E094095398C2F5999", hash_generated_method = "D5023303E52B07698BEFA28F3E8666BD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.939 -0400", hash_original_method = "AD0BFB52D4FF32A1ADE4FBCCEAA68479", hash_generated_method = "A06D6C81DAA9947F4754E99456985387")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void nextBytes(byte[] bytes) {
        dsTaint.addTaint(bytes);
        secureRandomSpi.engineNextBytes(bytes);
        // ---------- Original Method ----------
        //secureRandomSpi.engineNextBytes(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.959 -0400", hash_original_method = "5D37488B96B0B99188E69118313D10F5", hash_generated_method = "1F032DE8C34F9B73517850791770C651")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.961 -0400", hash_original_method = "3FA575BF722059F581C0BCCB1A57BEED", hash_generated_method = "25DD3FF5037B779BB1ACF76ED0F86DA1")
    public static byte[] getSeed(int numBytes) {
        SecureRandom result = internalSecureRandom;
        if (result == null) {
            internalSecureRandom = result = new SecureRandom();
        }
        return result.generateSeed(numBytes);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.689 -0400",hash_original_method="D819275281A9132149A7C81B1EB64271",hash_generated_method="0B53CFBBF1B244182AFD676A7611D5AD")
public byte[] generateSeed(int numBytes) {
        dsTaint.addTaint(numBytes);
        byte[] var15A980A0739C67DA04D9CD07E0145888_1391850274 = (secureRandomSpi.engineGenerateSeed(numBytes));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return secureRandomSpi.engineGenerateSeed(numBytes);
    }

    
}


