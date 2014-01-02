package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

import org.apache.harmony.security.fortress.Engine;






public class AlgorithmParameters {

    /**
     * Returns a new instance of {@code AlgorithmParameters} for the specified
     * algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @return a new instance of {@code AlgorithmParameters} for the specified
     *         algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.942 -0500", hash_original_method = "DC5D93AFAABA216D2504A813B834D6CA", hash_generated_method = "AFA69B810C3CBBDCFED9F1B8680D5F5B")
    
public static AlgorithmParameters getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Returns a new instance of {@code AlgorithmParameters} from the specified
     * provider for the specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            name of the provider of the {@code AlgorithmParameters}.
     * @return a new instance of {@code AlgorithmParameters} for the specified
     *         algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.945 -0500", hash_original_method = "C2C2EC01024A6B49BB2E941E05C66526", hash_generated_method = "26833208D3CE93A392B1E964F664C4BF")
    
public static AlgorithmParameters getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    /**
     * Returns a new instance of {@code AlgorithmParameters} from the specified
     * provider for the specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            the provider of the {@code AlgorithmParameters}.
     * @return a new instance of {@code AlgorithmParameters} for the specified
     *         algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.948 -0500", hash_original_method = "7B13EBBD6929DB755B15BB9995ABE950", hash_generated_method = "83F482073F167CCE99F2558E019CE775")
    
public static AlgorithmParameters getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.924 -0500", hash_original_field = "0FCDC856007B81E0CB5C85C093C27715", hash_generated_field = "2A5FC69C67235739D89B6E72871223E3")

    private static final String SEVICE = "AlgorithmParameters";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.927 -0500", hash_original_field = "ADBB0C64F9DE4D45E937EA4C4B84EA61", hash_generated_field = "00A78935B1DF849DB7CCEEA674A30AFE")

    private static final Engine ENGINE = new Engine(SEVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.929 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.932 -0500", hash_original_field = "7FD3F93E39A4D5293CDF7F423F3BB6A8", hash_generated_field = "9D41D4F6030CE195996EC7214F8C92A4")

    private  AlgorithmParametersSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.934 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.937 -0500", hash_original_field = "6FBE6536E7CE204510C4979FD7989151", hash_generated_field = "D96AC35F2092AB08D47BC799DE8F3A01")

    private boolean initialized;

    /**
     * Constructs a new instance of {@code AlgorithmParameters} with the given
     * arguments.
     *
     * @param algPramSpi
     *            the concrete implementation.
     * @param provider
     *            the security provider.
     * @param algorithm
     *            the name of the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.939 -0500", hash_original_method = "8DBC0799ED7E4900EBC29238B9DE7938", hash_generated_method = "4B65AC216190E6D0A6D36DE7E12BEB9F")
    
protected AlgorithmParameters(AlgorithmParametersSpi algPramSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = algPramSpi;
    }

    /**
     * Returns the provider associated with this {@code AlgorithmParameters}.
     *
     * @return the provider associated with this {@code AlgorithmParameters}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.951 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the name of the algorithm.
     *
     * @return the name of the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.953 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Initializes this {@code AlgorithmParameters} with the specified {@code
     * AlgorithmParameterSpec}.
     *
     * @param paramSpec
     *            the parameter specification.
     * @throws InvalidParameterSpecException
     *             if this {@code AlgorithmParameters} has already been
     *             initialized or the given {@code paramSpec} is not appropriate
     *             for initializing this {@code AlgorithmParameters}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.955 -0500", hash_original_method = "7E6C59119732596BEFEB2E6E8A90EC10", hash_generated_method = "44D0FA33002C5953CDB40B19856ABC88")
    
public final void init(AlgorithmParameterSpec paramSpec)
            throws InvalidParameterSpecException {
        if (initialized) {
            throw new InvalidParameterSpecException("Parameter has already been initialized");
        }
        spiImpl.engineInit(paramSpec);
        initialized = true;
    }

    /**
     * Initializes this {@code AlgorithmParameters} with the specified {@code
     * byte[]} using the default decoding format for parameters. The default
     * encoding format is ASN.1.
     *
     * @param params
     *            the encoded parameters.
     * @throws IOException
     *             if this {@code AlgorithmParameters} has already been
     *             initialized, or the parameter could not be encoded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.958 -0500", hash_original_method = "617D5B707C3D1A91A18634DFC0D9F364", hash_generated_method = "5F70E00BD154F130EC77FCFF24CCEB2C")
    
public final void init(byte[] params) throws IOException {
        if (initialized) {
            throw new IOException("Parameter has already been initialized");
        }
        spiImpl.engineInit(params);
        initialized = true;
    }

    /**
     * Initializes this {@code AlgorithmParameters} with the specified {@code
     * byte[]} using the specified decoding format.
     *
     * @param params
     *            the encoded parameters.
     * @param format
     *            the name of the decoding format.
     * @throws IOException
     *             if this {@code AlgorithmParameters} has already been
     *             initialized, or the parameter could not be encoded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.961 -0500", hash_original_method = "7B3B0E8CD7575D668CB68D6510D827CC", hash_generated_method = "CEEB9842CD678FA22CEC1F9D058C61A1")
    
public final void init(byte[] params, String format) throws IOException {
        if (initialized) {
            throw new IOException("Parameter has already been initialized");
        }
        spiImpl.engineInit(params, format);
        initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.765 -0400", hash_original_method = "9BE0AC13DE94D992E08BA6CD89DD9D38", hash_generated_method = "DAA561BDD29669502F20C03B7972ADA6")
    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> paramSpec) throws InvalidParameterSpecException {
        addTaint(paramSpec.getTaint());
        if(!initialized)        
        {
            InvalidParameterSpecException var54E4AE85F53D5769EC35860EC68CC518_1569405853 = new InvalidParameterSpecException("Parameter has not been initialized");
            var54E4AE85F53D5769EC35860EC68CC518_1569405853.addTaint(taint);
            throw var54E4AE85F53D5769EC35860EC68CC518_1569405853;
        } //End block
T var85314A191FE096CEB6FC1BB15A481DB0_510525874 =         spiImpl.engineGetParameterSpec(paramSpec);
        var85314A191FE096CEB6FC1BB15A481DB0_510525874.addTaint(taint);
        return var85314A191FE096CEB6FC1BB15A481DB0_510525874;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new InvalidParameterSpecException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetParameterSpec(paramSpec);
    }

    /**
     * Returns this {@code AlgorithmParameters} in their default encoding
     * format. The default encoding format is ASN.1.
     *
     * @return the encoded parameters.
     * @throws IOException
     *             if this {@code AlgorithmParameters} has already been
     *             initialized, or if this parameters could not be encoded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.965 -0500", hash_original_method = "2345D83B19F14D228FA4A748BB5C0696", hash_generated_method = "5798FBF69FA064167E6238428A1B2D3B")
    
public final byte[] getEncoded() throws IOException {
        if (!initialized) {
            throw new IOException("Parameter has not been initialized");
        }
        return spiImpl.engineGetEncoded();
    }

    /**
     * Returns this {@code AlgorithmParameters} in the specified encoding
     * format.
     *
     * @param format
     *            the name of the encoding format.
     * @return the encoded parameters.
     * @throws IOException
     *             if this {@code AlgorithmParameters} has already been
     *             initialized, or if this parameters could not be encoded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.968 -0500", hash_original_method = "5F0B9F7B1E2AFA510F6DA0646E7306FA", hash_generated_method = "361CDB3F64F8985DC91A54ED6E0860A7")
    
public final byte[] getEncoded(String format) throws IOException {
        if (!initialized) {
            throw new IOException("Parameter has not been initialized");
        }
        return spiImpl.engineGetEncoded(format);
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * {@code AlgorithmParameters}.
     *
     * @return a printable representation for this {@code AlgorithmParameters}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.971 -0500", hash_original_method = "3487587F52CF5404E8DAC6B47C5FD08C", hash_generated_method = "6F4D8CA2BCED524EC1B179ECDC4095CB")
    
@Override
    public final String toString() {
        if (!initialized) {
            return null;
        }
        return spiImpl.engineToString();
    }
}

