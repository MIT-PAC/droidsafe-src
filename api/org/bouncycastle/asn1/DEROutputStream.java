package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DEROutputStream extends FilterOutputStream implements DERTags {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.149 -0400", hash_original_method = "D6882926F90F93A386C7D4D8D57DD786", hash_generated_method = "BFCE9163E9403BC3EAA2B2ADD4A25C35")
    public  DEROutputStream(
        OutputStream    os) {
        super(os);
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.149 -0400", hash_original_method = "9630CA34FB2F7F75F5B62885DAC93016", hash_generated_method = "391E32B79C2B6ACECE7A1D11B605EE1E")
    private void writeLength(
        int length) throws IOException {
        addTaint(length);
    if(length > 127)        
        {
            int size = 1;
            int val = length;
            while
((val >>>= 8) != 0)            
            {
                size++;
            } //End block
            write((byte)(size | 0x80));
for(int i = (size - 1) * 8;i >= 0;i -= 8)
            {
                write((byte)(length >> i));
            } //End block
        } //End block
        else
        {
            write((byte)length);
        } //End block
        // ---------- Original Method ----------
        //if (length > 127)
        //{
            //int size = 1;
            //int val = length;
            //while ((val >>>= 8) != 0)
            //{
                //size++;
            //}
            //write((byte)(size | 0x80));
            //for (int i = (size - 1) * 8; i >= 0; i -= 8)
            //{
                //write((byte)(length >> i));
            //}
        //}
        //else
        //{
            //write((byte)length);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.150 -0400", hash_original_method = "6A5015CF78D45503CE00711383685F95", hash_generated_method = "C3F2B4BDA10BD5E8E3576D3B82282BC8")
     void writeEncoded(
        int     tag,
        byte[]  bytes) throws IOException {
        addTaint(bytes[0]);
        addTaint(tag);
        write(tag);
        writeLength(bytes.length);
        write(bytes);
        // ---------- Original Method ----------
        //write(tag);
        //writeLength(bytes.length);
        //write(bytes);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.151 -0400", hash_original_method = "ED4E90E4B3DD7ED52782F2B0BBD7912E", hash_generated_method = "0FDB1AD5CE01895F0C1BD2B3470D8BDA")
     void writeTag(int flags, int tagNo) throws IOException {
        addTaint(tagNo);
        addTaint(flags);
    if(tagNo < 31)        
        {
            write(flags | tagNo);
        } //End block
        else
        {
            write(flags | 0x1f);
    if(tagNo < 128)            
            {
                write(tagNo);
            } //End block
            else
            {
                byte[] stack = new byte[5];
                int pos = stack.length;
                stack[--pos] = (byte)(tagNo & 0x7F);
                do {
                    {
                        tagNo >>= 7;
                        stack[--pos] = (byte)(tagNo & 0x7F | 0x80);
                    } //End block
} while (tagNo > 127);
                write(stack, pos, stack.length - pos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (tagNo < 31)
        //{
            //write(flags | tagNo);
        //}
        //else
        //{
            //write(flags | 0x1f);
            //if (tagNo < 128)
            //{
                //write(tagNo);
            //}
            //else
            //{
                //byte[] stack = new byte[5];
                //int pos = stack.length;
                //stack[--pos] = (byte)(tagNo & 0x7F);
                //do
                //{
                    //tagNo >>= 7;
                    //stack[--pos] = (byte)(tagNo & 0x7F | 0x80);
                //}
                //while (tagNo > 127);
                //write(stack, pos, stack.length - pos);
            //}
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.151 -0400", hash_original_method = "7680EF084FC261D5865A989D21C79F36", hash_generated_method = "63FA737404C7B1FD6797BC2D7EBE0D58")
     void writeEncoded(int flags, int tagNo, byte[] bytes) throws IOException {
        addTaint(bytes[0]);
        addTaint(tagNo);
        addTaint(flags);
        writeTag(flags, tagNo);
        writeLength(bytes.length);
        write(bytes);
        // ---------- Original Method ----------
        //writeTag(flags, tagNo);
        //writeLength(bytes.length);
        //write(bytes);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.152 -0400", hash_original_method = "42317E86533FAE5B23E236AC0365BD25", hash_generated_method = "F9103E21E41CA9234FA57E1DA6B62BE5")
    protected void writeNull() throws IOException {
        write(NULL);
        write(0x00);
        // ---------- Original Method ----------
        //write(NULL);
        //write(0x00);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.152 -0400", hash_original_method = "1AF5A1D8916987DB77C7DD8735718172", hash_generated_method = "3CBD9648A0867717D0D4F498C034076B")
    public void write(byte[] buf) throws IOException {
        addTaint(buf[0]);
        out.write(buf, 0, buf.length);
        // ---------- Original Method ----------
        //out.write(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.152 -0400", hash_original_method = "C3C674084F8E21E9786EAC52DFF53A81", hash_generated_method = "08DB4CD72E0EA53D6D53240610079F3B")
    public void write(byte[] buf, int offSet, int len) throws IOException {
        addTaint(len);
        addTaint(offSet);
        addTaint(buf[0]);
        out.write(buf, offSet, len);
        // ---------- Original Method ----------
        //out.write(buf, offSet, len);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.153 -0400", hash_original_method = "F19F4C73BB689B28C331EE3D14B18253", hash_generated_method = "B2B38922847BB8BA83F7C2D79E0FD728")
    public void writeObject(
        Object    obj) throws IOException {
        addTaint(obj.getTaint());
    if(obj == null)        
        {
            writeNull();
        } //End block
        else
    if(obj instanceof DERObject)        
        {
            ((DERObject)obj).encode(this);
        } //End block
        else
    if(obj instanceof DEREncodable)        
        {
            ((DEREncodable)obj).getDERObject().encode(this);
        } //End block
        else
        {
            IOException var73E9FE5DD68FF5A265BB6FC7D1A21AE7_32391256 = new IOException("object not DEREncodable");
            var73E9FE5DD68FF5A265BB6FC7D1A21AE7_32391256.addTaint(taint);
            throw var73E9FE5DD68FF5A265BB6FC7D1A21AE7_32391256;
        } //End block
        // ---------- Original Method ----------
        //if (obj == null)
        //{
            //writeNull();
        //}
        //else if (obj instanceof DERObject)
        //{
            //((DERObject)obj).encode(this);
        //}
        //else if (obj instanceof DEREncodable)
        //{
            //((DEREncodable)obj).getDERObject().encode(this);
        //}
        //else 
        //{
            //throw new IOException("object not DEREncodable");
        //}
    }

    
}

