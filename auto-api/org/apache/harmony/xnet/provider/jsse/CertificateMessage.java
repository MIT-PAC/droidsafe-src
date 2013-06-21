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
    X509Certificate[] certs;
    byte[][] encoded_certs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.539 -0400", hash_original_method = "3441A786FC97408CA6232DAAE3F595DF", hash_generated_method = "9E212FAEDB277DBCBE7ECC36DB31D732")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateMessage(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.540 -0400", hash_original_method = "A869E13906426823448DC988F0CB5F8A", hash_generated_method = "88D69C1ACB3EAF600AC5D2AFD50F187D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertificateMessage(X509Certificate[] certs) {
        dsTaint.addTaint(certs[0].dsTaint);
        {
            this.certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            length = 3;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.540 -0400", hash_original_method = "345309F322E0CB3C0BD3B9A37C988F09", hash_generated_method = "510A14FC19332C170075FA5805CD15A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.541 -0400", hash_original_method = "B57A0154C34F76610C0A1E207F806B75", hash_generated_method = "EA44E242DAEDD87266F46C0FFC2F575E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAuthType() {
        String var2051A9F00BCB268D31B8DADFB8F28858_785834809 = (certs[0].getPublicKey().getAlgorithm());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return certs[0].getPublicKey().getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.541 -0400", hash_original_method = "F562E1306C68C131628B54BA54665996", hash_generated_method = "BB33FA91DEA2BC507BBD6297240C799D")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE;
    }

    
}

