package org.bouncycastle.openssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.Writer;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

public class PEMWriter extends PemWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.346 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "0595F09DA04DDB6CAB7E48663879A009")

    private String provider;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.346 -0400", hash_original_method = "B56F352F75A7EE5ED66D1919C9935D1C", hash_generated_method = "7F8B2D7502CA930D9AF4063081EE6961")
    public  PEMWriter(Writer out) {
        this(out, "BC");
        addTaint(out.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.347 -0400", hash_original_method = "99674EEDDF74A689A2172353FAA6EC72", hash_generated_method = "4703E97518B8CC62FA5438B2F48A506A")
    public  PEMWriter(
        Writer  out,
        String  provider) {
        super(out);
        addTaint(out.getTaint());
        this.provider = provider;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.347 -0400", hash_original_method = "996091F5D25AD49D59450216DEC51F49", hash_generated_method = "1DB51AC4578E422112C38F6280819EB1")
    public void writeObject(
        Object  obj) throws IOException {
        addTaint(obj.getTaint());
        try 
        {
            super.writeObject(new MiscPEMGenerator(obj));
        } 
        catch (PemGenerationException e)
        {
    if(e.getCause() instanceof IOException)            
            {
                IOException var311ABEA3F84164DA1688048948DE5101_589554328 = (IOException)e.getCause();
                var311ABEA3F84164DA1688048948DE5101_589554328.addTaint(taint);
                throw var311ABEA3F84164DA1688048948DE5101_589554328;
            } 
            e.addTaint(taint);
            throw e;
        } 
        
        
        
            
        
        
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.348 -0400", hash_original_method = "E0AF395E658580FE02EB9102C3B67CCE", hash_generated_method = "C8384EEC406644D31327A18CF885BA82")
    public void writeObject(
        PemObjectGenerator obj) throws IOException {
        addTaint(obj.getTaint());
        super.writeObject(obj);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.349 -0400", hash_original_method = "FE40F27E2DA82EBBE9E1DFDF41871C25", hash_generated_method = "2FB306D667E49043CA49F47D5671539D")
    public void writeObject(
        Object       obj,
        String       algorithm,
        char[]       password,
        SecureRandom random) throws IOException {
        addTaint(random.getTaint());
        addTaint(password[0]);
        addTaint(algorithm.getTaint());
        addTaint(obj.getTaint());
        try 
        {
            super.writeObject(new MiscPEMGenerator(obj, algorithm, password, random, provider));
        } 
        catch (NoSuchProviderException e)
        {
            EncryptionException var9C94B02AD7A7877E74823FC6C0C4925C_1616345206 = new EncryptionException(e.getMessage(), e);
            var9C94B02AD7A7877E74823FC6C0C4925C_1616345206.addTaint(taint);
            throw var9C94B02AD7A7877E74823FC6C0C4925C_1616345206;
        } 
        
        
        
            
        
        
        
            
        
    }

    
}

