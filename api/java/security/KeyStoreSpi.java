package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;

import javax.crypto.SecretKey;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;

public abstract class KeyStoreSpi {

    /*
     * This method returns password which is encapsulated in
     * CallbackHandlerProtection object If there is no implementation of
     * CallbackHandler then this method returns null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.053 -0500", hash_original_method = "9280B34CDA1A5A9448497987FEA339C2", hash_generated_method = "42CA4D99D6E4E75B9E069AA97023098F")
    
static char[] getPasswordFromCallBack(KeyStore.ProtectionParameter protParam)
            throws UnrecoverableEntryException {

        if (protParam == null) {
            return null;
        }

        if (!(protParam instanceof KeyStore.CallbackHandlerProtection)) {
            throw new UnrecoverableEntryException("Incorrect ProtectionParameter");
        }

        String clName = Security.getProperty("auth.login.defaultCallbackHandler");
        if (clName == null) {
            throw new UnrecoverableEntryException("Default CallbackHandler was not defined");

        }

        try {
            Class<?> cl = Class.forName(clName);
            CallbackHandler cbHand = (CallbackHandler) cl.newInstance();
            PasswordCallback[] pwCb = { new PasswordCallback("password: ", true) };
            cbHand.handle(pwCb);
            return pwCb[0].getPassword();
        } catch (Exception e) {
            throw new UnrecoverableEntryException(e.toString());
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.039 -0400", hash_original_method = "0F44DABB4B3060793D573A941E7E27B4", hash_generated_method = "0F44DABB4B3060793D573A941E7E27B4")
    public KeyStoreSpi ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the key with the given alias, using the password to recover the
     * key from the store.
     *
     * @param alias
     *            the alias for the entry.
     * @param password
     *            the password used to recover the key.
     * @return the key with the specified alias, or {@code null} if the
     *         specified alias is not bound to an entry.
     * @throws NoSuchAlgorithmException
     *             if the algorithm for recovering the key is not available.
     * @throws UnrecoverableKeyException
     *             if the key can not be recovered.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.998 -0500", hash_original_method = "262C45119F8A2E446CA7A6F639C0529E", hash_generated_method = "7C41AEC5800B546B1ED3DC912C133FCA")
    
public abstract Key engineGetKey(String alias, char[] password)
            throws NoSuchAlgorithmException, UnrecoverableKeyException;

    /**
     * Returns the certificate chain for the entry with the given alias.
     *
     * @param alias
     *            the alias for the entry
     * @return the certificate chain for the entry with the given alias, or
     *         {@code null} if the specified alias is not bound to an entry.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.000 -0500", hash_original_method = "767AA73CFF647726061680736B200CC3", hash_generated_method = "1597C6175CBAF4DA6968D8FD71AF507A")
    
public abstract Certificate[] engineGetCertificateChain(String alias);

    /**
     * Returns the trusted certificate for the entry with the given alias.
     *
     * @param alias
     *            the alias for the entry.
     * @return the trusted certificate for the entry with the given alias, or
     *         {@code null} if the specified alias is not bound to an entry.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.003 -0500", hash_original_method = "CBF968F9BC3E3120432BA9EC88472B26", hash_generated_method = "711ACB7274379F9A47964550FB689ED0")
    
public abstract Certificate engineGetCertificate(String alias);

    /**
     * Returns the creation date of the entry with the given alias.
     *
     * @param alias
     *            the alias for the entry.
     * @return the creation date, or {@code null} if the specified alias is not
     *         bound to an entry.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.006 -0500", hash_original_method = "1FF1D16CCFB598DBA5D5922E27AD1C78", hash_generated_method = "06FA8CB1BA04BD1353EE50E6F27A674D")
    
public abstract Date engineGetCreationDate(String alias);

    /**
     * Associates the given alias with the key, password and certificate chain.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the key.
     * @param key
     *            the key.
     * @param password
     *            the password.
     * @param chain
     *            the certificate chain.
     * @throws KeyStoreException
     *             if the specified key can not be protected, or if this
     *             operation fails for another reason.
     * @throws IllegalArgumentException
     *             if {@code key} is a {@code PrivateKey} and {@code chain} does
     *             not contain any certificates.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.008 -0500", hash_original_method = "7B9992925D33D09A69431FACE43D3F70", hash_generated_method = "E4EC2ECDAA3E49D08A2EE6F1E5D5DED2")
    
public abstract void engineSetKeyEntry(String alias, Key key,
            char[] password, Certificate[] chain) throws KeyStoreException;

    /**
     * Associates the given alias with a key and a certificate chain.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the key.
     * @param key
     *            the key in an encoded format.
     * @param chain
     *            the certificate chain.
     * @throws KeyStoreException
     *             if this operation fails.
     * @throws IllegalArgumentException
     *             if {@code key} is a {@code PrivateKey} and {@code chain}
     *             does.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.011 -0500", hash_original_method = "1FB1A60189EEE0CCB39F83936C39CD91", hash_generated_method = "5E5F66B91A3636FD7255D4D5CD412B62")
    
public abstract void engineSetKeyEntry(String alias, byte[] key,
            Certificate[] chain) throws KeyStoreException;

    /**
     * Associates the given alias with a certificate.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the certificate.
     * @param cert
     *            the certificate.
     * @throws KeyStoreException
     *             if an existing alias is not associated to an entry containing
     *             a trusted certificate, or this method fails for any other
     *             reason.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.013 -0500", hash_original_method = "BC85260036254C3D1D46D5A4CD54C631", hash_generated_method = "4C0F01CD8302A545971F539DF0B9C54C")
    
public abstract void engineSetCertificateEntry(String alias,
            Certificate cert) throws KeyStoreException;

    /**
     * Deletes the entry identified with the given alias from this {@code
     * KeyStoreSpi}.
     *
     * @param alias
     *            the alias for the entry.
     * @throws KeyStoreException
     *             if the entry can not be deleted.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.016 -0500", hash_original_method = "C5912624DCC25C81C7DE5ED28688DDD7", hash_generated_method = "9D1EAB4D7E6162F9727775F5D68BD345")
    
public abstract void engineDeleteEntry(String alias)
            throws KeyStoreException;

    /**
     * Returns an {@code Enumeration} over all alias names stored in this
     * {@code KeyStoreSpi}.
     *
     * @return an {@code Enumeration} over all alias names stored in this
     *         {@code KeyStoreSpi}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.019 -0500", hash_original_method = "82588BB61594FA8A73A0F3F355DEE11B", hash_generated_method = "8530AC63B6A06CF06635BB177F956E18")
    
public abstract Enumeration<String> engineAliases();

    /**
     * Indicates whether the given alias is present in this {@code KeyStoreSpi}.
     *
     * @param alias
     *            the alias of an entry.
     * @return {@code true} if the alias exists, {@code false} otherwise.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.021 -0500", hash_original_method = "6DA9587D712F71675D6F7DC0C5D937C9", hash_generated_method = "D7EB33403E187670A7D78C574FE82CA4")
    
public abstract boolean engineContainsAlias(String alias);

    /**
     * Returns the number of entries stored in this {@code KeyStoreSpi}.
     *
     * @return the number of entries stored in this {@code KeyStoreSpi}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.024 -0500", hash_original_method = "D8BF35C2ACCF94F2EC69DC5A85C9A8F9", hash_generated_method = "AAB35F0278EF378424EF1D9A79DC8958")
    
public abstract int engineSize();

    /**
     * Indicates whether the specified alias is associated with either a
     * {@link KeyStore.PrivateKeyEntry} or a {@link KeyStore.SecretKeyEntry}.
     *
     * @param alias
     *            the alias of an entry.
     * @return {@code true} if the given alias is associated with a key entry.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.026 -0500", hash_original_method = "71F16054A5D04622A625AC31B4079294", hash_generated_method = "25F8AA154C072AC08B5A33430488A928")
    
public abstract boolean engineIsKeyEntry(String alias);

    /**
     * Indicates whether the specified alias is associated with a
     * {@link KeyStore.TrustedCertificateEntry}.
     *
     * @param alias
     *            the alias of an entry.
     * @return {@code true} if the given alias is associated with a certificate
     *         entry.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.028 -0500", hash_original_method = "30990670F3D1088F0ED6A72446296413", hash_generated_method = "12A128D8AD937B8CD994B42A277D697A")
    
public abstract boolean engineIsCertificateEntry(String alias);

    /**
     * Returns the alias associated with the first entry whose certificate
     * matches the specified certificate.
     *
     * @param cert
     *            the certificate to find the associated entry's alias for.
     * @return the alias or {@code null} if no entry with the specified
     *         certificate can be found.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.031 -0500", hash_original_method = "5AE9B6FD007D8046B16D2117DA368E0A", hash_generated_method = "CBF05E94E3E7E99E079268AAC92D0B57")
    
public abstract String engineGetCertificateAlias(Certificate cert);

    /**
     * Writes this {@code KeyStoreSpi} to the specified {@code OutputStream}.
     * The data written to the {@code OutputStream} is protected by the
     * specified password.
     *
     * @param stream
     *            the {@code OutputStream} to write the store's data to.
     * @param password
     *            the password to protect the data.
     * @throws IOException
     *             if a problem occurred while writing to the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if the an exception occurred while storing the certificates
     *             of this code {@code KeyStoreSpi}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.033 -0500", hash_original_method = "116C689EA990E9A410716324F8AFB01B", hash_generated_method = "B2F76E8D126862F6C7E56AA7935D6C60")
    
public abstract void engineStore(OutputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    /**
     * Stores this {@code KeyStoreSpi} using the specified {@code
     * LoadStoreParameter}.
     *
     * @param param
     *            the {@code LoadStoreParameter} that specifies how to store
     *            this {@code KeyStoreSpi}, maybe {@code null}.
     * @throws IOException
     *             if a problem occurred while writing to the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if the an exception occurred while storing the certificates
     *             of this code {@code KeyStoreSpi}.
     * @throws IllegalArgumentException
     *             if the given {@link KeyStore.LoadStoreParameter} is not
     *             recognized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.036 -0500", hash_original_method = "2DD87D7240BCBB9F96BACA77A06CD528", hash_generated_method = "725AE982153DF31074411DE3E1C9B096")
    
public void engineStore(KeyStore.LoadStoreParameter param)
            throws IOException, NoSuchAlgorithmException, CertificateException {
        throw new UnsupportedOperationException();
    }

    /**
     * Loads this {@code KeyStoreSpi} from the given {@code InputStream}.
     * Utilizes the given password to verify the stored data.
     *
     * @param stream
     *            the {@code InputStream} to load this {@code KeyStoreSpi}'s
     *            data from.
     * @param password
     *            the password to verify the stored data, maybe {@code null}.
     * @throws IOException
     *             if a problem occurred while reading from the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if the an exception occurred while loading the certificates
     *             of this code {@code KeyStoreSpi}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.038 -0500", hash_original_method = "F9333B030A9B14BD70E7C9DB7BF90F67", hash_generated_method = "5622AE494536C4D0FE444C23B330469F")
    
public abstract void engineLoad(InputStream stream, char[] password)
            throws IOException, NoSuchAlgorithmException, CertificateException;

    /**
     * Loads this {@code KeyStoreSpi} using the specified {@code
     * LoadStoreParameter}.
     *
     * @param param
     *            the {@code LoadStoreParameter} that specifies how to load this
     *            {@code KeyStoreSpi}, maybe {@code null}.
     * @throws IOException
     *             if a problem occurred while reading from the stream.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws CertificateException
     *             if the an exception occurred while loading the certificates
     *             of this code {@code KeyStoreSpi}.
     * @throws IllegalArgumentException
     *             if the given {@link KeyStore.LoadStoreParameter} is not
     *             recognized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.041 -0500", hash_original_method = "C2F8D415FB9276C7A503B37F207C6477", hash_generated_method = "317F64B260C6E114C4A5ABA44FB44456")
    
public void engineLoad(KeyStore.LoadStoreParameter param)
            throws IOException, NoSuchAlgorithmException, CertificateException {
        if (param == null) {
            engineLoad(null, null);
            return;
        }
        char[] pwd;
        KeyStore.ProtectionParameter pp = param.getProtectionParameter();
        if (pp instanceof KeyStore.PasswordProtection) {
            try {
                pwd = ((KeyStore.PasswordProtection) pp).getPassword();
                engineLoad(null, pwd);
                return;
            } catch (IllegalStateException e) {
                throw new IllegalArgumentException(e);
            }
        }
        if (pp instanceof KeyStore.CallbackHandlerProtection) {
            try {
                pwd = getPasswordFromCallBack(pp);
                engineLoad(null, pwd);
                return;
            } catch (UnrecoverableEntryException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new UnsupportedOperationException("protectionParameter is neither PasswordProtection "
                                                + "nor CallbackHandlerProtection instance");
    }

    /**
     * Returns the {@code Entry} with the given alias, using the specified
     * {@code ProtectionParameter}.
     *
     * @param alias
     *            the alias of the requested entry.
     * @param protParam
     *            the {@code ProtectionParameter}, used to protect the requested
     *            entry, maybe {@code null}.
     * @return he {@code Entry} with the given alias, using the specified
     *         {@code ProtectionParameter}.
     * @throws NoSuchAlgorithmException
     *             if the required algorithm is not available.
     * @throws UnrecoverableEntryException
     *             if the entry can not be recovered.
     * @throws KeyStoreException
     *             if this operation fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.044 -0500", hash_original_method = "B68FB53D4042F1FDA8275FB481793ECB", hash_generated_method = "D89E94EAE7AD7281734E2328D3004E85")
    
public KeyStore.Entry engineGetEntry(String alias,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException,
            NoSuchAlgorithmException, UnrecoverableEntryException {
        if (!engineContainsAlias(alias)) {
            return null;
        }
        if (engineIsCertificateEntry(alias)) {
            return new KeyStore.TrustedCertificateEntry(
                    engineGetCertificate(alias));
        }
        char[] passW = null;
        if (protParam != null) {
            if (protParam instanceof KeyStore.PasswordProtection) {
                try {
                    passW = ((KeyStore.PasswordProtection) protParam)
                            .getPassword();
                } catch (IllegalStateException ee) {
                    throw new KeyStoreException("Password was destroyed", ee);
                }
            } else if (protParam instanceof KeyStore.CallbackHandlerProtection) {
                passW = getPasswordFromCallBack(protParam);
            } else {
                throw new UnrecoverableEntryException("ProtectionParameter object is not "
                                                      + "PasswordProtection: " + protParam);
            }
        }
        if (engineIsKeyEntry(alias)) {
            Key key = engineGetKey(alias, passW);
            if (key instanceof PrivateKey) {
                return new KeyStore.PrivateKeyEntry((PrivateKey) key,
                                                    engineGetCertificateChain(alias));
            }
            if (key instanceof SecretKey) {
                return new KeyStore.SecretKeyEntry((SecretKey) key);
            }
        }
        throw new NoSuchAlgorithmException("Unknown KeyStore.Entry object");
    }

    /**
     * Stores the given {@code Entry} in this {@code KeyStoreSpi} and associates
     * the entry with the given {@code alias}. The entry is protected by the
     * specified {@code ProtectionParameter}.
     * <p>
     * If the specified alias already exists, it will be reassigned.
     *
     * @param alias
     *            the alias for the entry.
     * @param entry
     *            the entry to store.
     * @param protParam
     *            the {@code ProtectionParameter} to protect the entry.
     * @throws KeyStoreException
     *             if this operation fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.048 -0500", hash_original_method = "3D4613712C6A1FF15305C05DDF5D1E0F", hash_generated_method = "B0209E5EEE37F52F3850ED8A8EC4F707")
    
public void engineSetEntry(String alias, KeyStore.Entry entry,
            KeyStore.ProtectionParameter protParam) throws KeyStoreException {
        if (entry == null) {
            throw new KeyStoreException("entry == null");
        }

        if (engineContainsAlias(alias)) {
            engineDeleteEntry(alias);
        }

        if (entry instanceof KeyStore.TrustedCertificateEntry) {
            KeyStore.TrustedCertificateEntry trE = (KeyStore.TrustedCertificateEntry) entry;
            engineSetCertificateEntry(alias, trE.getTrustedCertificate());
            return;
        }

        char[] passW = null;
        if (protParam instanceof KeyStore.PasswordProtection) {
            try {
                passW = ((KeyStore.PasswordProtection) protParam).getPassword();
            } catch (IllegalStateException ee) {
                throw new KeyStoreException("Password was destroyed", ee);
            }
        } else {
            if (protParam instanceof KeyStore.CallbackHandlerProtection) {
                try {
                    passW = getPasswordFromCallBack(protParam);
                } catch (Exception e) {
                    throw new KeyStoreException(e);
                }
            } else {
                throw new KeyStoreException("protParam should be PasswordProtection or "
                                            + "CallbackHandlerProtection");
            }
        }

        if (entry instanceof KeyStore.PrivateKeyEntry) {
            KeyStore.PrivateKeyEntry prE = (KeyStore.PrivateKeyEntry) entry;
            engineSetKeyEntry(alias, prE.getPrivateKey(), passW, prE
                    .getCertificateChain());
            return;
        }

        if (entry instanceof KeyStore.SecretKeyEntry) {
            KeyStore.SecretKeyEntry skE = (KeyStore.SecretKeyEntry) entry;
            engineSetKeyEntry(alias, skE.getSecretKey(), passW, null);
            //            engineSetKeyEntry(alias, skE.getSecretKey().getEncoded(), null);
            return;
        }

        throw new KeyStoreException("Entry object is neither PrivateKeyObject nor SecretKeyEntry "
                                    + "nor TrustedCertificateEntry: " + entry);
    }

    /**
     * Indicates whether the entry for the given alias is assignable to the
     * provided {@code Class}.
     *
     * @param alias
     *            the alias for the entry.
     * @param entryClass
     *            the type of the entry.
     * @return {@code true} if the {@code Entry} for the alias is assignable to
     *         the specified {@code entryClass}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.050 -0500", hash_original_method = "E646126BAF6D7B233BE960C73341BBD0", hash_generated_method = "74B6C04DDFF2D06ADB16447EAA4C3E2F")
    
public boolean engineEntryInstanceOf(String alias,
            Class<? extends KeyStore.Entry> entryClass) {
        if (!engineContainsAlias(alias)) {
            return false;
        }

        try {
            if (engineIsCertificateEntry(alias)) {
                return entryClass
                        .isAssignableFrom(Class
                                .forName("java.security.KeyStore$TrustedCertificateEntry"));
            }

            if (engineIsKeyEntry(alias)) {
                if (entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$PrivateKeyEntry"))) {
                    return engineGetCertificate(alias) != null;
                }

                if (entryClass.isAssignableFrom(Class
                        .forName("java.security.KeyStore$SecretKeyEntry"))) {
                    return engineGetCertificate(alias) == null;
                }
            }
        } catch (ClassNotFoundException ignore) {}

        return false;
    }
    
}

