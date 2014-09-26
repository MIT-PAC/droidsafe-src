package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.harmony.security.fortress.Engine;

public class Mac implements Cloneable {

    /**
     * Creates a new {@code Mac} instance that provides the specified MAC
     * algorithm.
     *
     * @param algorithm
     *            the name of the requested MAC algorithm.
     * @return the new {@code Mac} instance.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available by any provider.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release).
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.665 -0500", hash_original_method = "3E4BC559FFF8F8BDA507B13EF8AF490F", hash_generated_method = "14D7DD9047E39E52B5B033CEE35BB241")
    
public static final Mac getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new Mac((MacSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code Mac} instance that provides the specified MAC
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested MAC algorithm.
     * @param provider
     *            the name of the provider that is providing the algorithm.
     * @return the new {@code Mac} instance.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not provided by the specified
     *             provider.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws IllegalArgumentException
     *             if the specified provider name is {@code null} or empty.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.668 -0500", hash_original_method = "C36E3B39C5242D2DC122D797569C3E46", hash_generated_method = "E9261B2D7224D6220A041C3242BFAB74")
    
public static final Mac getInstance(String algorithm, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    /**
     * Creates a new {@code Mac} instance that provides the specified MAC
     * algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested MAC algorithm.
     * @param provider
     *            the provider that is providing the algorithm.
     * @return the new {@code Mac} instance.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not provided by the specified
     *             provider.
     * @throws IllegalArgumentException
     *             if {@code provider} is {@code null}.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null} (instead of
     *             NoSuchAlgorithmException as in 1.4 release).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.671 -0500", hash_original_method = "9F8E4A6494CB361657567F0DE6275A17", hash_generated_method = "C113D69E0F2931D2076D5442F6A65023")
    
public static final Mac getInstance(String algorithm, Provider provider)
            throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new Mac((MacSpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.646 -0500", hash_original_field = "2653E60AD4168F29BCBE957ABC770C28", hash_generated_field = "806BD6BDD2ABE5FBF629090CA696D2F6")

    private static final Engine ENGINE = new Engine("Mac");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.648 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.651 -0500", hash_original_field = "D5C6D39FF8B0FEC373455E53108A464C", hash_generated_field = "0128BA68CF49937E6689B3B2ABC40132")

    private  MacSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.653 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.655 -0500", hash_original_field = "7199DD0121DF2A6DCD548D72E04D0A40", hash_generated_field = "3ABD1385745F27F79CF607C339AD7462")

    private boolean isInitMac;

    /**
     * Creates a new {@code Mac} instance.
     *
     * @param macSpi
     *            the implementation delegate.
     * @param provider
     *            the implementation provider.
     * @param algorithm
     *            the name of the MAC algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.658 -0500", hash_original_method = "41257A854336509F555FDEC12089036E", hash_generated_method = "C350962D3304BAFED070EA865DB853EC")
    
protected Mac(MacSpi macSpi, Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = macSpi;
        this.isInitMac = false;
    }

    /**
     * Returns the name of the MAC algorithm.
     *
     * @return the name of the MAC algorithm.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.661 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider of this {@code Mac} instance.
     *
     * @return the provider of this {@code Mac} instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.663 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the length of this MAC (in bytes).
     *
     * @return the length of this MAC (in bytes).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.673 -0500", hash_original_method = "02AEE303A4D099BA107FB2CB7C60A1E3", hash_generated_method = "656E9EB0E4DD43379A7E6E6A9ECA9FA5")
    
public final int getMacLength() {
        return spiImpl.engineGetMacLength();
    }

    /**
     * Initializes this {@code Mac} instance with the specified key and
     * algorithm parameters.
     *
     * @param key
     *            the key to initialize this algorithm.
     * @param params
     *            the parameters for this algorithm.
     * @throws InvalidKeyException
     *             if the specified key cannot be used to initialize this
     *             algorithm, or it is null.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to initialize this
     *             algorithm.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.676 -0500", hash_original_method = "9228EAA32885A066BE953E8B5AE4C236", hash_generated_method = "E4A49B851F58AB4C9EBD03CD9A957F1A")
    
public final void init(Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        spiImpl.engineInit(key, params);
        isInitMac = true;
    }

    /**
     * Initializes this {@code Mac} instance with the specified key.
     *
     * @param key
     *            the key to initialize this algorithm.
     * @throws InvalidKeyException
     *             if initialization fails because the provided key is {@code
     *             null}.
     * @throws RuntimeException
     *             if the specified key cannot be used to initialize this
     *             algorithm.
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.679 -0500", hash_original_method = "874C36BA9BA67506DF1E27339862DC05", hash_generated_method = "C5C2C8365CA2E2386B03EF357C9A23D3")
    
public final void init(Key key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("key == null");
        }
        try {
            spiImpl.engineInit(key, null);
            isInitMac = true;
        } catch (InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Updates this {@code Mac} instance with the specified byte.
     *
     * @param input
     *            the byte
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.681 -0500", hash_original_method = "CE2C32417AC34B9F04F350B6B83BA3FB", hash_generated_method = "C7EFEC23D4621DF0A643E6D009872FA4")
    
public final void update(byte input) throws IllegalStateException {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        spiImpl.engineUpdate(input);
    }

    /**
     * Updates this {@code Mac} instance with the data from the specified buffer
     * {@code input} from the specified {@code offset} and length {@code len}.
     *
     * @param input
     *            the buffer.
     * @param offset
     *            the offset in the buffer.
     * @param len
     *            the length of the data in the buffer.
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     * @throws IllegalArgumentException
     *             if {@code offset} and {@code len} do not specified a valid
     *             chunk in {@code input} buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.684 -0500", hash_original_method = "715302E1C20F57A2A8D63A54A99663FC", hash_generated_method = "F3D72487E7A5A494D889A8EDFD1CF1E6")
    
public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        if (input == null) {
            return;
        }
        if ((offset < 0) || (len < 0) || ((offset + len) > input.length)) {
            throw new IllegalArgumentException("Incorrect arguments");
        }
        spiImpl.engineUpdate(input, offset, len);
    }

    /**
     * Copies the buffer provided as input for further processing.
     *
     * @param input
     *            the buffer.
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.687 -0500", hash_original_method = "3D6841DD3321DF543EE186C2C08CA7E2", hash_generated_method = "F8C03B01875AE3EA2298F5B7496851FE")
    
public final void update(byte[] input) throws IllegalStateException {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        if (input != null) {
            spiImpl.engineUpdate(input, 0, input.length);
        }
    }

    /**
     * Updates this {@code Mac} instance with the data from the specified
     * buffer, starting at {@link ByteBuffer#position()}, including the next
     * {@link ByteBuffer#remaining()} bytes.
     *
     * @param input
     *            the buffer.
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.689 -0500", hash_original_method = "A1BB43A6E7623A403344D1C2F2A132EB", hash_generated_method = "ADC74FDD8ACFD2F4407DF33AE46D9F42")
    
public final void update(ByteBuffer input) {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        if (input != null) {
            spiImpl.engineUpdate(input);
        } else {
            throw new IllegalArgumentException("input == null");
        }
    }

    /**
     * Computes the digest of this MAC based on the data previously specified in
     * {@link #update} calls.
     * <p>
     * This {@code Mac} instance is reverted to its initial state and can be
     * used to start the next MAC computation with the same parameters or
     * initialized with different parameters.
     *
     * @return the generated digest.
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.692 -0500", hash_original_method = "09A7E9E8BA2AA06F6A3808F7BB018D3B", hash_generated_method = "BBBC3271E7BF877707A76B4510A43D2F")
    
public final byte[] doFinal() throws IllegalStateException {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        return spiImpl.engineDoFinal();
    }

    /**
     * Computes the digest of this MAC based on the data previously specified in
     * {@link #update} calls and stores the digest in the specified {@code
     * output} buffer at offset {@code outOffset}.
     * <p>
     * This {@code Mac} instance is reverted to its initial state and can be
     * used to start the next MAC computation with the same parameters or
     * initialized with different parameters.
     *
     * @param output
     *            the output buffer
     * @param outOffset
     *            the offset in the output buffer
     * @throws ShortBufferException
     *             if the specified output buffer is either too small for the
     *             digest to be stored, the specified output buffer is {@code
     *             null}, or the specified offset is negative or past the length
     *             of the output buffer.
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     */
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.694 -0500", hash_original_method = "3A73D46F22DAF7149F49DD945D0B4F9C", hash_generated_method = "653C16F6A05A5770FF3136B1C69F8005")
    
public final void doFinal(byte[] output, int outOffset)
            throws ShortBufferException, IllegalStateException {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        if (output == null) {
            throw new ShortBufferException("output == null");
        }
        if ((outOffset < 0) || (outOffset >= output.length)) {
            throw new ShortBufferException("Incorrect outOffset: " + outOffset);
        }
        int t = spiImpl.engineGetMacLength();
        if (t > (output.length - outOffset)) {
            throw new ShortBufferException("Output buffer is short. Needed " + t + " bytes.");
        }
        byte[] result = spiImpl.engineDoFinal();
        System.arraycopy(result, 0, output, outOffset, result.length);

    }

    /**
     * Computes the digest of this MAC based on the data previously specified on
     * {@link #update} calls and on the final bytes specified by {@code input}
     * (or based on those bytes only).
     * <p>
     * This {@code Mac} instance is reverted to its initial state and can be
     * used to start the next MAC computation with the same parameters or
     * initialized with different parameters.
     *
     * @param input
     *            the final bytes.
     * @return the generated digest.
     * @throws IllegalStateException
     *             if this MAC is not initialized.
     */
    @DSComment("IO operations")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.697 -0500", hash_original_method = "D317760A96395810E5039143278FB4E4", hash_generated_method = "397FF92AD1E3086CF78C1865ECC76522")
    
public final byte[] doFinal(byte[] input) throws IllegalStateException {
        if (!isInitMac) {
            throw new IllegalStateException();
        }
        if (input != null) {
            spiImpl.engineUpdate(input, 0, input.length);
        }
        return spiImpl.engineDoFinal();
    }

    /**
     * Resets this {@code Mac} instance to its initial state.
     * <p>
     * This {@code Mac} instance is reverted to its initial state and can be
     * used to start the next MAC computation with the same parameters or
     * initialized with different parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.699 -0500", hash_original_method = "81378E48B4C25C37826FA808778D1291", hash_generated_method = "5B38A2D1110748DB3AFA8347F5147BA3")
    
public final void reset() {
        spiImpl.engineReset();
    }

    /**
     * Clones this {@code Mac} instance and the underlying implementation.
     *
     * @return the cloned instance.
     * @throws CloneNotSupportedException
     *             if the underlying implementation does not support cloning.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.702 -0500", hash_original_method = "D491B3C29A973D07513DEBD79BD84B18", hash_generated_method = "85156C9FA9461F9D0DB3DC1A0A2A08A2")
    
@Override
    public final Object clone() throws CloneNotSupportedException {
        MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        mac.isInitMac = this.isInitMac;
        return mac;
    }
}

