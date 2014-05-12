package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DEROutputStream extends FilterOutputStream implements DERTags {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.702 -0500", hash_original_method = "D6882926F90F93A386C7D4D8D57DD786", hash_generated_method = "A320D981703EC188191226365DD3CBBD")
    
public DEROutputStream(
        OutputStream    os)
    {
        super(os);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.704 -0500", hash_original_method = "9630CA34FB2F7F75F5B62885DAC93016", hash_generated_method = "338C20699D845F77BA969F3D1001FDB8")
    
private void writeLength(
        int length)
        throws IOException
    {
        if (length > 127)
        {
            int size = 1;
            int val = length;

            while ((val >>>= 8) != 0)
            {
                size++;
            }

            write((byte)(size | 0x80));

            for (int i = (size - 1) * 8; i >= 0; i -= 8)
            {
                write((byte)(length >> i));
            }
        }
        else
        {
            write((byte)length);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.707 -0500", hash_original_method = "6A5015CF78D45503CE00711383685F95", hash_generated_method = "6A5015CF78D45503CE00711383685F95")
    
void writeEncoded(
        int     tag,
        byte[]  bytes)
        throws IOException
    {
        write(tag);
        writeLength(bytes.length);
        write(bytes);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.709 -0500", hash_original_method = "ED4E90E4B3DD7ED52782F2B0BBD7912E", hash_generated_method = "ED4E90E4B3DD7ED52782F2B0BBD7912E")
    
void writeTag(int flags, int tagNo)
        throws IOException
    {
        if (tagNo < 31)
        {
            write(flags | tagNo);
        }
        else
        {
            write(flags | 0x1f);
            if (tagNo < 128)
            {
                write(tagNo);
            }
            else
            {
                byte[] stack = new byte[5];
                int pos = stack.length;

                stack[--pos] = (byte)(tagNo & 0x7F);

                do
                {
                    tagNo >>= 7;
                    stack[--pos] = (byte)(tagNo & 0x7F | 0x80);
                }
                while (tagNo > 127);

                write(stack, pos, stack.length - pos);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.712 -0500", hash_original_method = "7680EF084FC261D5865A989D21C79F36", hash_generated_method = "7680EF084FC261D5865A989D21C79F36")
    
void writeEncoded(int flags, int tagNo, byte[] bytes)
        throws IOException
    {
        writeTag(flags, tagNo);
        writeLength(bytes.length);
        write(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.714 -0500", hash_original_method = "42317E86533FAE5B23E236AC0365BD25", hash_generated_method = "2A07F1F62118227D173561056F8195A2")
    
protected void writeNull()
        throws IOException
    {
        write(NULL);
        write(0x00);
    }

    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.716 -0500", hash_original_method = "1AF5A1D8916987DB77C7DD8735718172", hash_generated_method = "8255F98DC4BB26AFEBBCA56A5E44F694")
    
public void write(byte[] buf)
        throws IOException
    {
        out.write(buf, 0, buf.length);
    }

    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.718 -0500", hash_original_method = "C3C674084F8E21E9786EAC52DFF53A81", hash_generated_method = "E7F15A8100E2CB670DD4790F2585555D")
    
public void write(byte[] buf, int offSet, int len)
        throws IOException
    {
        out.write(buf, offSet, len);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:17.721 -0500", hash_original_method = "F19F4C73BB689B28C331EE3D14B18253", hash_generated_method = "D442D0F2E17F162C92F058E0B47FDB91")
    
public void writeObject(
        Object    obj)
        throws IOException
    {
        if (obj == null)
        {
            writeNull();
        }
        else if (obj instanceof DERObject)
        {
            ((DERObject)obj).encode(this);
        }
        else if (obj instanceof DEREncodable)
        {
            ((DEREncodable)obj).getDERObject().encode(this);
        }
        else 
        {
            throw new IOException("object not DEREncodable");
        }
    }
    
}

