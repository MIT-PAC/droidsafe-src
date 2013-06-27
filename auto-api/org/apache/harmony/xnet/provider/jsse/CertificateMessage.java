package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class CertificateMessage extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.404 -0400", hash_original_field = "5C99E9C56C11BC780A27097694149CBA", hash_generated_field = "9B4CC3CF13ACA419D4B9B38AD77D3648")

    X509Certificate[] certs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.404 -0400", hash_original_field = "1BADBD8AD1CD27E7BFE9874C7A4827EB", hash_generated_field = "57935D50E807950C7290BDE1C251A925")

    byte[][] encoded_certs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.417 -0400", hash_original_method = "3441A786FC97408CA6232DAAE3F595DF", hash_generated_method = "0C618BEB7D70527927D39EA560DD165D")
    public  CertificateMessage(HandshakeIODataStream in, int length) throws IOException {
        int l;
        l = in.readUint24();
        {
            {
                fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateMessage");
            } //End block
            certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            this.length = 3;
        } //End block
        CertificateFactory cf;
        try 
        {
            cf = CertificateFactory.getInstance("X509");
        } //End block
        catch (CertificateException e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
        } //End block
        ArrayList<X509Certificate> certsList;
        certsList = new ArrayList<X509Certificate>();
        int size;
        size = 0;
        int enc_size;
        enc_size = 0;
        {
            size = in.readUint24();
            l -= 3;
            try 
            {
                certsList.add((X509Certificate) cf.generateCertificate(in));
            } //End block
            catch (CertificateException e)
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR", e);
            } //End block
            l -= size;
            enc_size += size;
        } //End block
        certs = certsList.toArray(new X509Certificate[certsList.size()]);
        this.length = 3 + 3 * certs.length + enc_size;
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateMessage");
        } //End block
        addTaint(in.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.419 -0400", hash_original_method = "A869E13906426823448DC988F0CB5F8A", hash_generated_method = "1C6B875D377CA6915A3A9D71F0CCE836")
    public  CertificateMessage(X509Certificate[] certs) {
        {
            this.certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            length = 3;
        } //End block
        this.certs = certs;
        {
            encoded_certs = new byte[certs.length][];
            {
                int i;
                i = 0;
                {
                    try 
                    {
                        encoded_certs[i] = certs[i].getEncoded();
                    } //End block
                    catch (CertificateEncodingException e)
                    {
                        fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR",
                            e);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        length = 3 + 3 * encoded_certs.length;
        {
            int i;
            i = 0;
            {
                length += encoded_certs[i].length;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (certs == null) {
            //this.certs = new X509Certificate[0];
            //encoded_certs = new byte[0][0];
            //length = 3;
            //return;
        //}
        //this.certs = certs;
        //if (encoded_certs == null) {
            //encoded_certs = new byte[certs.length][];
            //for (int i = 0; i < certs.length; i++) {
                //try {
                    //encoded_certs[i] = certs[i].getEncoded();
                //} catch (CertificateEncodingException e) {
                    //fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR",
                            //e);
                //}
            //}
        //}
        //length = 3 + 3 * encoded_certs.length;
        //for (int i = 0; i < encoded_certs.length; i++) {
            //length += encoded_certs[i].length;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.426 -0400", hash_original_method = "345309F322E0CB3C0BD3B9A37C988F09", hash_generated_method = "5F82DDABC1316F0102E04CB0ABD4E501")
    @Override
    public void send(HandshakeIODataStream out) {
        int total_length;
        total_length = 0;
        {
            encoded_certs = new byte[certs.length][];
            {
                int i;
                i = 0;
                {
                    try 
                    {
                        encoded_certs[i] = certs[i].getEncoded();
                    } //End block
                    catch (CertificateEncodingException e)
                    {
                        fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR",
                            e);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        total_length = 3 * encoded_certs.length;
        {
            int i;
            i = 0;
            {
                total_length += encoded_certs[i].length;
            } //End block
        } //End collapsed parenthetic
        out.writeUint24(total_length);
        {
            int i;
            i = 0;
            {
                out.writeUint24(encoded_certs[i].length);
                out.write(encoded_certs[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.427 -0400", hash_original_method = "B57A0154C34F76610C0A1E207F806B75", hash_generated_method = "AA1587BBBC4BE5659556BBB8CC9601A2")
    public String getAuthType() {
        String varB4EAC82CA7396A68D541C85D26508E83_978705663 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978705663 = certs[0].getPublicKey().getAlgorithm();
        varB4EAC82CA7396A68D541C85D26508E83_978705663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978705663;
        // ---------- Original Method ----------
        //return certs[0].getPublicKey().getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.430 -0400", hash_original_method = "F562E1306C68C131628B54BA54665996", hash_generated_method = "015EBE5C7B09824CCCDB2DC3C7DF8D23")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711403206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711403206;
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE;
    }

    
}

