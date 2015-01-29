package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.bouncycastle.util.encoders.Base64;

public class PemWriter extends BufferedWriter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.640 -0500", hash_original_field = "2703D5EA5438FFBD051A78AF908B80A3", hash_generated_field = "EDD822F24FA43922022593BF50854718")

    private static final int LINE_LENGTH = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.643 -0500", hash_original_field = "08690A93D50AD3D36BE35AD299FEA207", hash_generated_field = "B698C3A4519A55108C89592990062E26")

    private  int nlLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.645 -0500", hash_original_field = "6A72737E6CE4840CF1721E5C8565ED98", hash_generated_field = "4AE54445A000A5FDAE606F6B2655F1C8")

    private char[]  buf = new char[LINE_LENGTH];

    /**
     * Base constructor.
     *
     * @param out output stream to use.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.648 -0500", hash_original_method = "FE3DCCF7A57AE41AA2B9ABB8B6650E80", hash_generated_method = "22D2ABCA7296FD2295DAB4E5937CF45B")
    
public PemWriter(Writer out)
    {
        super(out);

        String nl = System.getProperty("line.separator");
        if (nl != null)
        {
            nlLength = nl.length();
        }
        else
        {
            nlLength = 2;
        }
    }

    /**
     * Return the number of bytes or characters required to contain the
     * passed in object if it is PEM encoded.
     *
     * @param obj pem object to be output
     * @return an estimate of the number of bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.651 -0500", hash_original_method = "1011C811490561236947BE193FC22C40", hash_generated_method = "EB8B5526AAFB256FC296BE1E2F228FFD")
    
public int getOutputSize(PemObject obj)
    {
        // BEGIN and END boundaries.
        int size = (2 * (obj.getType().length() + 10 + nlLength)) + 6 + 4;

        if (!obj.getHeaders().isEmpty())
        {
            for (Iterator it = obj.getHeaders().iterator(); it.hasNext();)
            {
                PemHeader hdr = (PemHeader)it.next();

                size += hdr.getName().length() + ": ".length() + hdr.getValue().length() + nlLength;
            }

            size += nlLength;
        }

        // base64 encoding
        int dataLen = ((obj.getContent().length + 2) / 3) * 4;
        
        size += dataLen + (((dataLen + LINE_LENGTH - 1) / LINE_LENGTH) * nlLength);

        return size;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.654 -0500", hash_original_method = "7DC9EFDB066BC03515C2F692EE0CAAF1", hash_generated_method = "129EED88BE3D45AB79B1AFDF81CACA3A")
    
public void writeObject(PemObjectGenerator objGen)
        throws IOException
    {
        PemObject obj = objGen.generate();

        writePreEncapsulationBoundary(obj.getType());

        if (!obj.getHeaders().isEmpty())
        {
            for (Iterator it = obj.getHeaders().iterator(); it.hasNext();)
            {
                PemHeader hdr = (PemHeader)it.next();

                this.write(hdr.getName());
                this.write(": ");
                this.write(hdr.getValue());
                this.newLine();
            }

            this.newLine();
        }
        
        writeEncoded(obj.getContent());
        writePostEncapsulationBoundary(obj.getType());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.656 -0500", hash_original_method = "68336F0D98EECA9F6E841F3ED0087F4A", hash_generated_method = "165608343CF68BD2BCBF23DFC04C7E28")
    
private void writeEncoded(byte[] bytes)
        throws IOException
    {
        bytes = Base64.encode(bytes);

        for (int i = 0; i < bytes.length; i += buf.length)
        {
            int index = 0;

            while (index != buf.length)
            {
                if ((i + index) >= bytes.length)
                {
                    break;
                }
                buf[index] = (char)bytes[i + index];
                index++;
            }
            this.write(buf, 0, index);
            this.newLine();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.658 -0500", hash_original_method = "B0C6E0FE046A2BB4F1EE412D60500B94", hash_generated_method = "ED83F0DC50D604EDC069A4D127BCC5CD")
    
private void writePreEncapsulationBoundary(
        String type)
        throws IOException
    {
        this.write("-----BEGIN " + type + "-----");
        this.newLine();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.660 -0500", hash_original_method = "F04AE80D2D9D0D11E28641848118BF80", hash_generated_method = "FE467242A9A358FC5A524E5E8A2A30D1")
    
private void writePostEncapsulationBoundary(
        String type)
        throws IOException
    {
        this.write("-----END " + type + "-----");
        this.newLine();
    }
}

