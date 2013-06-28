package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.bouncycastle.util.encoders.Base64;

public class PemWriter extends BufferedWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.422 -0400", hash_original_field = "9D1675F1DBAEA15C69A38DF9986D6F7F", hash_generated_field = "B698C3A4519A55108C89592990062E26")

    private int nlLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.422 -0400", hash_original_field = "60659A97AF392D2030642C39C5C01C04", hash_generated_field = "4AE54445A000A5FDAE606F6B2655F1C8")

    private char[] buf = new char[LINE_LENGTH];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.423 -0400", hash_original_method = "FE3DCCF7A57AE41AA2B9ABB8B6650E80", hash_generated_method = "66E525E08D73AD10CE3CB3970ABEBE36")
    public  PemWriter(Writer out) {
        super(out);
        String nl = System.getProperty("line.separator");
        {
            nlLength = nl.length();
        } //End block
        {
            nlLength = 2;
        } //End block
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.423 -0400", hash_original_method = "1011C811490561236947BE193FC22C40", hash_generated_method = "AB2B858860B1D7C6E41241B8CB08437A")
    public int getOutputSize(PemObject obj) {
        int size = (2 * (obj.getType().length() + 10 + nlLength)) + 6 + 4;
        {
            boolean var9BD9310AC4BE7C68FA6FA62329F5ADF6_1077725571 = (!obj.getHeaders().isEmpty());
            {
                {
                    Iterator it = obj.getHeaders().iterator();
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_735458046 = (it.hasNext());
                    {
                        PemHeader hdr = (PemHeader)it.next();
                        size += hdr.getName().length() + ": ".length() + hdr.getValue().length() + nlLength;
                    } //End block
                } //End collapsed parenthetic
                size += nlLength;
            } //End block
        } //End collapsed parenthetic
        int dataLen = ((obj.getContent().length + 2) / 3) * 4;
        size += dataLen + (((dataLen + LINE_LENGTH - 1) / LINE_LENGTH) * nlLength);
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489313434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1489313434;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.424 -0400", hash_original_method = "7DC9EFDB066BC03515C2F692EE0CAAF1", hash_generated_method = "1E25D808A0A21B9BD97713B3E5546E77")
    public void writeObject(PemObjectGenerator objGen) throws IOException {
        PemObject obj = objGen.generate();
        writePreEncapsulationBoundary(obj.getType());
        {
            boolean var9BD9310AC4BE7C68FA6FA62329F5ADF6_1839331254 = (!obj.getHeaders().isEmpty());
            {
                {
                    Iterator it = obj.getHeaders().iterator();
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1712969350 = (it.hasNext());
                    {
                        PemHeader hdr = (PemHeader)it.next();
                        this.write(hdr.getName());
                        this.write(": ");
                        this.write(hdr.getValue());
                        this.newLine();
                    } //End block
                } //End collapsed parenthetic
                this.newLine();
            } //End block
        } //End collapsed parenthetic
        writeEncoded(obj.getContent());
        writePostEncapsulationBoundary(obj.getType());
        addTaint(objGen.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.425 -0400", hash_original_method = "68336F0D98EECA9F6E841F3ED0087F4A", hash_generated_method = "FA54C0B21A01C23FBC3204FBC765E47E")
    private void writeEncoded(byte[] bytes) throws IOException {
        bytes = Base64.encode(bytes);
        {
            int i = 0;
            i += buf.length;
            {
                int index = 0;
                {
                    buf[index] = (char)bytes[i + index];
                } //End block
                this.write(buf, 0, index);
                this.newLine();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.426 -0400", hash_original_method = "B0C6E0FE046A2BB4F1EE412D60500B94", hash_generated_method = "157E609C1EFBEC91C0BD9DAF4F6E473E")
    private void writePreEncapsulationBoundary(
        String type) throws IOException {
        this.write("-----BEGIN " + type + "-----");
        this.newLine();
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //this.write("-----BEGIN " + type + "-----");
        //this.newLine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.426 -0400", hash_original_method = "F04AE80D2D9D0D11E28641848118BF80", hash_generated_method = "9EBFC78AC3F68D46DA4B8BFBBC6703EF")
    private void writePostEncapsulationBoundary(
        String type) throws IOException {
        this.write("-----END " + type + "-----");
        this.newLine();
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //this.write("-----END " + type + "-----");
        //this.newLine();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.426 -0400", hash_original_field = "54783865208FA7928405DDFEA752F6D3", hash_generated_field = "EDD822F24FA43922022593BF50854718")

    private static final int LINE_LENGTH = 64;
}

