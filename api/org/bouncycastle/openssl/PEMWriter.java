package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Writer;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;






public class PEMWriter extends PemWriter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.145 -0500", hash_original_field = "A5A1D795BB0E6A860404CE54547A2FCF", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

    private String provider;

    /**
     * Base constructor.
     * 
     * @param out output stream to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.147 -0500", hash_original_method = "B56F352F75A7EE5ED66D1919C9935D1C", hash_generated_method = "946695F5B327A7727FC03A7E7E6005C9")
    
public PEMWriter(Writer out)
    {
        this(out, "BC");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.150 -0500", hash_original_method = "99674EEDDF74A689A2172353FAA6EC72", hash_generated_method = "1F311664373E41850C8DC5F46496B694")
    
public PEMWriter(
        Writer  out,
        String  provider)
    {
        super(out);

        this.provider = provider;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.152 -0500", hash_original_method = "996091F5D25AD49D59450216DEC51F49", hash_generated_method = "7CB893726A0A5BBC7E264E409C979B5E")
    
public void writeObject(
        Object  obj)
        throws IOException
    {
        try
        {
            super.writeObject(new MiscPEMGenerator(obj));
        }
        catch (PemGenerationException e)
        {
            if (e.getCause() instanceof IOException)
            {
                throw (IOException)e.getCause();
            }

            throw e;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.155 -0500", hash_original_method = "E0AF395E658580FE02EB9102C3B67CCE", hash_generated_method = "E3D2FAF639E209883C0A5DF5BE9B142A")
    
public void writeObject(
        PemObjectGenerator obj)
        throws IOException
    {
        super.writeObject(obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:33.157 -0500", hash_original_method = "FE40F27E2DA82EBBE9E1DFDF41871C25", hash_generated_method = "5958F652D3CAD7EAE6B4AE73C8917183")
    
public void writeObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random)
        throws IOException
    {
        try
        {
            super.writeObject(new MiscPEMGenerator(obj, algorithm, password, random, provider));
        }
        catch (NoSuchProviderException e)
        {
            throw new EncryptionException(e.getMessage(), e);
        }
    }

    
}

