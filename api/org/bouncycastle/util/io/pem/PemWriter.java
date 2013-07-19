package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.bouncycastle.util.encoders.Base64;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class PemWriter extends BufferedWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.461 -0400", hash_original_field = "9D1675F1DBAEA15C69A38DF9986D6F7F", hash_generated_field = "B698C3A4519A55108C89592990062E26")

    private int nlLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.461 -0400", hash_original_field = "60659A97AF392D2030642C39C5C01C04", hash_generated_field = "4AE54445A000A5FDAE606F6B2655F1C8")

    private char[] buf = new char[LINE_LENGTH];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.461 -0400", hash_original_method = "FE3DCCF7A57AE41AA2B9ABB8B6650E80", hash_generated_method = "489E82C32FF6260E4BFBFDF3ADC927DC")
    public  PemWriter(Writer out) {
        super(out);
        addTaint(out.getTaint());
        String nl = System.getProperty("line.separator");
        if(nl != null)        
        {
            nlLength = nl.length();
        } //End block
        else
        {
            nlLength = 2;
        } //End block
        // ---------- Original Method ----------
        //String nl = System.getProperty("line.separator");
        //if (nl != null)
        //{
            //nlLength = nl.length();
        //}
        //else
        //{
            //nlLength = 2;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.462 -0400", hash_original_method = "1011C811490561236947BE193FC22C40", hash_generated_method = "F31CC243ED64E568E9F4D75BCF4D421E")
    public int getOutputSize(PemObject obj) {
        addTaint(obj.getTaint());
        int size = (2 * (obj.getType().length() + 10 + nlLength)) + 6 + 4;
        if(!obj.getHeaders().isEmpty())        
        {
for(Iterator it = obj.getHeaders().iterator();it.hasNext();)
            {
                PemHeader hdr = (PemHeader)it.next();
                size += hdr.getName().length() + ": ".length() + hdr.getValue().length() + nlLength;
            } //End block
            size += nlLength;
        } //End block
        int dataLen = ((obj.getContent().length + 2) / 3) * 4;
        size += dataLen + (((dataLen + LINE_LENGTH - 1) / LINE_LENGTH) * nlLength);
        int varF7BD60B75B29D79B660A2859395C1A24_340202298 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371422296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371422296;
        // ---------- Original Method ----------
        //int size = (2 * (obj.getType().length() + 10 + nlLength)) + 6 + 4;
        //if (!obj.getHeaders().isEmpty())
        //{
            //for (Iterator it = obj.getHeaders().iterator(); it.hasNext();)
            //{
                //PemHeader hdr = (PemHeader)it.next();
                //size += hdr.getName().length() + ": ".length() + hdr.getValue().length() + nlLength;
            //}
            //size += nlLength;
        //}
        //int dataLen = ((obj.getContent().length + 2) / 3) * 4;
        //size += dataLen + (((dataLen + LINE_LENGTH - 1) / LINE_LENGTH) * nlLength);
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.463 -0400", hash_original_method = "7DC9EFDB066BC03515C2F692EE0CAAF1", hash_generated_method = "3E45C2F3E6847EA5C286FC9BB64ECF40")
    public void writeObject(PemObjectGenerator objGen) throws IOException {
        addTaint(objGen.getTaint());
        PemObject obj = objGen.generate();
        writePreEncapsulationBoundary(obj.getType());
        if(!obj.getHeaders().isEmpty())        
        {
for(Iterator it = obj.getHeaders().iterator();it.hasNext();)
            {
                PemHeader hdr = (PemHeader)it.next();
                this.write(hdr.getName());
                this.write(": ");
                this.write(hdr.getValue());
                this.newLine();
            } //End block
            this.newLine();
        } //End block
        writeEncoded(obj.getContent());
        writePostEncapsulationBoundary(obj.getType());
        // ---------- Original Method ----------
        //PemObject obj = objGen.generate();
        //writePreEncapsulationBoundary(obj.getType());
        //if (!obj.getHeaders().isEmpty())
        //{
            //for (Iterator it = obj.getHeaders().iterator(); it.hasNext();)
            //{
                //PemHeader hdr = (PemHeader)it.next();
                //this.write(hdr.getName());
                //this.write(": ");
                //this.write(hdr.getValue());
                //this.newLine();
            //}
            //this.newLine();
        //}
        //writeEncoded(obj.getContent());
        //writePostEncapsulationBoundary(obj.getType());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.464 -0400", hash_original_method = "68336F0D98EECA9F6E841F3ED0087F4A", hash_generated_method = "4EF62BA2E0454445BE13247FEA2E2D26")
    private void writeEncoded(byte[] bytes) throws IOException {
        bytes = Base64.encode(bytes);
for(int i = 0;i < bytes.length;i += buf.length)
        {
            int index = 0;
            while
(index != buf.length)            
            {
                if((i + index) >= bytes.length)                
                {
                    break;
                } //End block
                buf[index] = (char)bytes[i + index];
                index++;
            } //End block
            this.write(buf, 0, index);
            this.newLine();
        } //End block
        // ---------- Original Method ----------
        //bytes = Base64.encode(bytes);
        //for (int i = 0; i < bytes.length; i += buf.length)
        //{
            //int index = 0;
            //while (index != buf.length)
            //{
                //if ((i + index) >= bytes.length)
                //{
                    //break;
                //}
                //buf[index] = (char)bytes[i + index];
                //index++;
            //}
            //this.write(buf, 0, index);
            //this.newLine();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.464 -0400", hash_original_method = "B0C6E0FE046A2BB4F1EE412D60500B94", hash_generated_method = "88B3238FDCFDC671F62E9F603BBC9C35")
    private void writePreEncapsulationBoundary(
        String type) throws IOException {
        addTaint(type.getTaint());
        this.write("-----BEGIN " + type + "-----");
        this.newLine();
        // ---------- Original Method ----------
        //this.write("-----BEGIN " + type + "-----");
        //this.newLine();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.465 -0400", hash_original_method = "F04AE80D2D9D0D11E28641848118BF80", hash_generated_method = "248981DAD4C65BB0CC7BC4EBBD42F949")
    private void writePostEncapsulationBoundary(
        String type) throws IOException {
        addTaint(type.getTaint());
        this.write("-----END " + type + "-----");
        this.newLine();
        // ---------- Original Method ----------
        //this.write("-----END " + type + "-----");
        //this.newLine();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.465 -0400", hash_original_field = "54783865208FA7928405DDFEA752F6D3", hash_generated_field = "EDD822F24FA43922022593BF50854718")

    private static final int LINE_LENGTH = 64;
}

