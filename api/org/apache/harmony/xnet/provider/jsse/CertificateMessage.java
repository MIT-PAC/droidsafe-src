package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class CertificateMessage extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.835 -0400", hash_original_field = "5C99E9C56C11BC780A27097694149CBA", hash_generated_field = "9B4CC3CF13ACA419D4B9B38AD77D3648")

    X509Certificate[] certs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.836 -0400", hash_original_field = "1BADBD8AD1CD27E7BFE9874C7A4827EB", hash_generated_field = "57935D50E807950C7290BDE1C251A925")

    byte[][] encoded_certs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.837 -0400", hash_original_method = "3441A786FC97408CA6232DAAE3F595DF", hash_generated_method = "A04A02F7028ABFA3F0B49BB43AD40487")
    public  CertificateMessage(HandshakeIODataStream in, int length) throws IOException {
        addTaint(length);
        addTaint(in.getTaint());
        int l = in.readUint24();
    if(l == 0)        
        {
    if(length != 3)            
            {
                fatalAlert(AlertProtocol.DECODE_ERROR,
                        "DECODE ERROR: incorrect CertificateMessage");
            } //End block
            certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            this.length = 3;
            return;
        } //End block
        CertificateFactory cf;
        try 
        {
            cf = CertificateFactory.getInstance("X509");
        } //End block
        catch (CertificateException e)
        {
            fatalAlert(AlertProtocol.INTERNAL_ERROR, "INTERNAL ERROR", e);
            return;
        } //End block
        ArrayList<X509Certificate> certsList = new ArrayList<X509Certificate>();
        int size = 0;
        int enc_size = 0;
        while
(l > 0)        
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
    if(this.length != length)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect CertificateMessage");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.839 -0400", hash_original_method = "A869E13906426823448DC988F0CB5F8A", hash_generated_method = "296962B6C9A284843495F5AD92EA77AA")
    public  CertificateMessage(X509Certificate[] certs) {
    if(certs == null)        
        {
            this.certs = new X509Certificate[0];
            encoded_certs = new byte[0][0];
            length = 3;
            return;
        } //End block
        this.certs = certs;
    if(encoded_certs == null)        
        {
            encoded_certs = new byte[certs.length][];
for(int i = 0;i < certs.length;i++)
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
        } //End block
        length = 3 + 3 * encoded_certs.length;
for(int i = 0;i < encoded_certs.length;i++)
        {
            length += encoded_certs[i].length;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.841 -0400", hash_original_method = "345309F322E0CB3C0BD3B9A37C988F09", hash_generated_method = "BC46345C1188639EBD19AC7917340C77")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        int total_length = 0;
    if(encoded_certs == null)        
        {
            encoded_certs = new byte[certs.length][];
for(int i = 0;i < certs.length;i++)
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
        } //End block
        total_length = 3 * encoded_certs.length;
for(int i = 0;i < encoded_certs.length;i++)
        {
            total_length += encoded_certs[i].length;
        } //End block
        out.writeUint24(total_length);
for(int i = 0;i < encoded_certs.length;i++)
        {
            out.writeUint24(encoded_certs[i].length);
            out.write(encoded_certs[i]);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.842 -0400", hash_original_method = "B57A0154C34F76610C0A1E207F806B75", hash_generated_method = "EC1C4F5EDFBFE39AB91A58750BC93A56")
    public String getAuthType() {
String varF523B99BFF261AB8239F9E49DE817850_1805125093 =         certs[0].getPublicKey().getAlgorithm();
        varF523B99BFF261AB8239F9E49DE817850_1805125093.addTaint(taint);
        return varF523B99BFF261AB8239F9E49DE817850_1805125093;
        // ---------- Original Method ----------
        //return certs[0].getPublicKey().getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:31.842 -0400", hash_original_method = "F562E1306C68C131628B54BA54665996", hash_generated_method = "C02F2F2673A624860D9BA4D1D2B076F8")
    @Override
    public int getType() {
        int varDF620CF8FED61A025C3C908A131BC9A7_1241664923 = (Handshake.CERTIFICATE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305440671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1305440671;
        // ---------- Original Method ----------
        //return Handshake.CERTIFICATE;
    }

    
}

