package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.X509Name;



public class X509Principal extends X509Name implements Principal {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.283 -0400", hash_original_method = "B0820FF823FE44437CE57E7CCF385599", hash_generated_method = "7C2C0D2B162C7B0FBED2088FF82682BE")
    public  X509Principal(
        byte[]  bytes) throws IOException {
        super(readSequence(new ASN1InputStream(bytes)));
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.283 -0400", hash_original_method = "0E5AD6E3648EC2E4F0A2CBF76D62FE6E", hash_generated_method = "7FA2300D5FAB52E8F0DE87ED00A0C534")
    public  X509Principal(
        X509Name  name) {
        super((ASN1Sequence)name.getDERObject());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.284 -0400", hash_original_method = "D3D6DABF2D2EE8D49403BBA6B447728D", hash_generated_method = "17864B7C5A8C9E650853114C17C4D4AF")
    public  X509Principal(
        Hashtable  attributes) {
        super(attributes);
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.284 -0400", hash_original_method = "33C0081C021F2AA73D8ACD68C98658C4", hash_generated_method = "54E46EA875C38CF765B84585C6104314")
    public  X509Principal(
        Vector      ordering,
        Hashtable   attributes) {
        super(ordering, attributes);
        addTaint(attributes.getTaint());
        addTaint(ordering.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.284 -0400", hash_original_method = "3B6A04762F0F16A7BA4938718F609D48", hash_generated_method = "AE8626085A947CD06A7EA6504A0D0C4C")
    public  X509Principal(
        Vector      oids,
        Vector      values) {
        super(oids, values);
        addTaint(values.getTaint());
        addTaint(oids.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.285 -0400", hash_original_method = "3167ECA848A59D0FB98E0257E20EB2C0", hash_generated_method = "8F759E22A75740EA44A03FBA22CEB932")
    public  X509Principal(
        String  dirName) {
        super(dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.285 -0400", hash_original_method = "8E38511E2EC0E52F81E91783DD99493A", hash_generated_method = "9EDA834132B1DD105E70D4BA4B37039C")
    public  X509Principal(
        boolean reverse,
        String  dirName) {
        super(reverse, dirName);
        addTaint(dirName.getTaint());
        addTaint(reverse);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.285 -0400", hash_original_method = "F7CF19656BE8328A59A7894CA6394ACC", hash_generated_method = "48C3FDDF4D6BF8BBFF7A6F641FB789DF")
    public  X509Principal(
        boolean     reverse,
        Hashtable   lookUp,
        String      dirName) {
        super(reverse, lookUp, dirName);
        addTaint(dirName.getTaint());
        addTaint(lookUp.getTaint());
        addTaint(reverse);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    private static ASN1Sequence readSequence(
        ASN1InputStream aIn) throws IOException {
        try
        {
            return ASN1Sequence.getInstance(aIn.readObject());
        }
        catch (IllegalArgumentException e)
        {
            throw new IOException("not an ASN.1 Sequence: " + e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.286 -0400", hash_original_method = "73EC4210941682DD4DF1478421683765", hash_generated_method = "83505683307A6048A87FA3E7A5FCC530")
    public String getName() {
String var4014743B4FB5C9F0052F04A16DA88A03_1946787728 =         this.toString();
        var4014743B4FB5C9F0052F04A16DA88A03_1946787728.addTaint(taint);
        return var4014743B4FB5C9F0052F04A16DA88A03_1946787728;
        // ---------- Original Method ----------
        //return this.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.286 -0400", hash_original_method = "FFCAA10D74329AA15B8FE83335744F82", hash_generated_method = "3CE74E71A0806D5274F661F6C2DDB732")
    public byte[] getEncoded() {
        try 
        {
            byte[] var75679B9D6E0C3BD65FFE938E240A5B3B_1017085543 = (this.getEncoded(ASN1Encodable.DER));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1873804388 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1873804388;
        } //End block
        catch (IOException e)
        {
            RuntimeException var7731B7FAF9DB516E410EE38D728795B2_189529727 = new RuntimeException(e.toString());
            var7731B7FAF9DB516E410EE38D728795B2_189529727.addTaint(taint);
            throw var7731B7FAF9DB516E410EE38D728795B2_189529727;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return this.getEncoded(ASN1Encodable.DER);
        //}
        //catch (IOException e)
        //{
            //throw new RuntimeException(e.toString());
        //}
    }

    
}

