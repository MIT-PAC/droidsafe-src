package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.Writer;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

public class PEMWriter extends PemWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.709 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

    private String provider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.709 -0400", hash_original_method = "B56F352F75A7EE5ED66D1919C9935D1C", hash_generated_method = "7F8B2D7502CA930D9AF4063081EE6961")
    public  PEMWriter(Writer out) {
        this(out, "BC");
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.710 -0400", hash_original_method = "99674EEDDF74A689A2172353FAA6EC72", hash_generated_method = "6F0E1193C16EDE49175BF67432E9996C")
    public  PEMWriter(
        Writer  out,
        String  provider) {
        super(out);
        this.provider = provider;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //this.provider = provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.710 -0400", hash_original_method = "996091F5D25AD49D59450216DEC51F49", hash_generated_method = "EC7902369D3FDD081D01808B17EC6704")
    public void writeObject(
        Object  obj) throws IOException {
        try 
        {
            super.writeObject(new MiscPEMGenerator(obj));
        } //End block
        catch (PemGenerationException e)
        {
            {
                boolean var67625E0ED8D01D5826DCC347A874C9DD_910246919 = (e.getCause() instanceof IOException);
                {
                    if (DroidSafeAndroidRuntime.control) throw (IOException)e.getCause();
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //try
        //{
            //super.writeObject(new MiscPEMGenerator(obj));
        //}
        //catch (PemGenerationException e)
        //{
            //if (e.getCause() instanceof IOException)
            //{
                //throw (IOException)e.getCause();
            //}
            //throw e;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.711 -0400", hash_original_method = "E0AF395E658580FE02EB9102C3B67CCE", hash_generated_method = "3CF20F1A50257069DADE483912B3E916")
    public void writeObject(
        PemObjectGenerator obj) throws IOException {
        super.writeObject(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //super.writeObject(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:21.711 -0400", hash_original_method = "FE40F27E2DA82EBBE9E1DFDF41871C25", hash_generated_method = "E84B40AF16F75CA7D91749ACDF549FF3")
    public void writeObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random) throws IOException {
        try 
        {
            super.writeObject(new MiscPEMGenerator(obj, algorithm, password, random, provider));
        } //End block
        catch (NoSuchProviderException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new EncryptionException(e.getMessage(), e);
        } //End block
        addTaint(obj.getTaint());
        addTaint(algorithm.getTaint());
        addTaint(password[0]);
        addTaint(random.getTaint());
        // ---------- Original Method ----------
        //try
        //{
            //super.writeObject(new MiscPEMGenerator(obj, algorithm, password, random, provider));
        //}
        //catch (NoSuchProviderException e)
        //{
            //throw new EncryptionException(e.getMessage(), e);
        //}
    }

    
}

