package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.X509Name;

public class X509Principal extends X509Name implements Principal {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.214 -0400", hash_original_method = "B0820FF823FE44437CE57E7CCF385599", hash_generated_method = "7C2C0D2B162C7B0FBED2088FF82682BE")
    public  X509Principal(
        byte[]  bytes) throws IOException {
        super(readSequence(new ASN1InputStream(bytes)));
        addTaint(bytes[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.214 -0400", hash_original_method = "0E5AD6E3648EC2E4F0A2CBF76D62FE6E", hash_generated_method = "7FA2300D5FAB52E8F0DE87ED00A0C534")
    public  X509Principal(
        X509Name  name) {
        super((ASN1Sequence)name.getDERObject());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.214 -0400", hash_original_method = "D3D6DABF2D2EE8D49403BBA6B447728D", hash_generated_method = "17864B7C5A8C9E650853114C17C4D4AF")
    public  X509Principal(
        Hashtable  attributes) {
        super(attributes);
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.214 -0400", hash_original_method = "33C0081C021F2AA73D8ACD68C98658C4", hash_generated_method = "8EA12BEA01705862C8F3B255CB859A79")
    public  X509Principal(
        Vector      ordering,
        Hashtable   attributes) {
        super(ordering, attributes);
        addTaint(ordering.getTaint());
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.214 -0400", hash_original_method = "3B6A04762F0F16A7BA4938718F609D48", hash_generated_method = "51FB81BE59DD5F09D418A13A87CDEE9E")
    public  X509Principal(
        Vector      oids,
        Vector      values) {
        super(oids, values);
        addTaint(oids.getTaint());
        addTaint(values.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.215 -0400", hash_original_method = "3167ECA848A59D0FB98E0257E20EB2C0", hash_generated_method = "8F759E22A75740EA44A03FBA22CEB932")
    public  X509Principal(
        String  dirName) {
        super(dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.215 -0400", hash_original_method = "8E38511E2EC0E52F81E91783DD99493A", hash_generated_method = "4F85513D30F30CEA8370C8A7E832A479")
    public  X509Principal(
        boolean reverse,
        String  dirName) {
        super(reverse, dirName);
        addTaint(reverse);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.215 -0400", hash_original_method = "F7CF19656BE8328A59A7894CA6394ACC", hash_generated_method = "9AA1B6EE71B38652E48027EE99AA919F")
    public  X509Principal(
        boolean     reverse,
        Hashtable   lookUp,
        String      dirName) {
        super(reverse, lookUp, dirName);
        addTaint(reverse);
        addTaint(lookUp.getTaint());
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.216 -0400", hash_original_method = "73EC4210941682DD4DF1478421683765", hash_generated_method = "8E53742389FAB39148962293E9E1E7D7")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_499680567 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_499680567 = this.toString();
        varB4EAC82CA7396A68D541C85D26508E83_499680567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_499680567;
        // ---------- Original Method ----------
        //return this.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.216 -0400", hash_original_method = "FFCAA10D74329AA15B8FE83335744F82", hash_generated_method = "D8ABEA63752AA822153571C725591AF4")
    public byte[] getEncoded() {
        try 
        {
            byte[] var29AE989CF6B7F50AE5155A143357E72F_69096097 = (this.getEncoded(ASN1Encodable.DER));
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.toString());
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1883095751 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1883095751;
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

