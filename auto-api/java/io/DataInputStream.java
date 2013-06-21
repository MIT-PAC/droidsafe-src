package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.Streams;
import libcore.io.SizeOf;

public class DataInputStream extends FilterInputStream implements DataInput {
    private byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.470 -0400", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "6568A68D251971EB73073D4179F14986")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataInputStream(InputStream in) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.471 -0400", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "741C1475B292AF2A5074F745A7D55711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int read(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer[0]);
        int var5D20304CDE93C454B73A071B58B41FC2_1058549845 = (super.read(buffer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.read(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.472 -0400", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "24B5094D34D6FBA1863FD41F24BD21EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int varD4EC737F94C97A2DC68884F821BEA260_1603067951 = (in.read(buffer, offset, length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.472 -0400", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "BC3A5E53C89FFDE5201A105BEEA66D06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean readBoolean() throws IOException {
        int temp;
        temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.472 -0400", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "4048E3A3EA46873F1F9A94E1C633F770")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte readByte() throws IOException {
        int temp;
        temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.472 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "4B2BB1F6326C5A2A59ADC259BB765DCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_64068447 = ((char) readShort());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.473 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "5E478C4EDD0FD57B7CFDE73FBF09273E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_1340547622 = (Double.longBitsToDouble(readLong()));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.473 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "27F83C8F8AFA492A52E83C7F988A191E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_616352104 = (Float.intBitsToFloat(readInt()));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.473 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "381A158999691B7214AD4191BE2969BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readFully(byte[] dst) throws IOException {
        dsTaint.addTaint(dst[0]);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.473 -0400", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "AE55CE07B27DEDCAE1396D6EA9D51FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        Streams.readFully(in, dst, offset, byteCount);
        // ---------- Original Method ----------
        //Streams.readFully(in, dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.473 -0400", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "4616DF28EC4BF8F29816AEB2AA782C8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_34405969 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.474 -0400", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "54557125B4FBD1EF545A9CBD3CD61F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final String readLine() throws IOException {
        StringBuilder line;
        line = new StringBuilder(80);
        boolean foundTerminator;
        foundTerminator = false;
        {
            int nextByte;
            nextByte = in.read();
            //Begin case -1 
            {
                boolean var9283EC23547FB4E91F8ADED78FB3824E_1731609821 = (line.length() == 0 && !foundTerminator);
            } //End collapsed parenthetic
            //End case -1 
            //Begin case -1 
            String var1EC93FDCAE6CEDB0F6DB29587930777B_752590890 = (line.toString());
            //End case -1 
            //Begin case (byte) '\r' 
            {
                ((PushbackInputStream) in).unread(nextByte);
                String var17A15FA5FFB6049E90AD08C06406E86F_155470240 = (line.toString());
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            {
                boolean var2EF3DF204DF2FA3A280904C5F67B208D_275391971 = (!(in.getClass() == PushbackInputStream.class));
                {
                    in = new PushbackInputStream(in);
                } //End block
            } //End collapsed parenthetic
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            String var1EC93FDCAE6CEDB0F6DB29587930777B_341592332 = (line.toString());
            //End case (byte) '\n' 
            //Begin case default 
            {
                ((PushbackInputStream) in).unread(nextByte);
                String var17A15FA5FFB6049E90AD08C06406E86F_77092277 = (line.toString());
            } //End block
            //End case default 
            //Begin case default 
            line.append((char) nextByte);
            //End case default 
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.474 -0400", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "CAE437433346B12DD849CDBE78DC1031")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_892196724 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.474 -0400", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "50FC5786146E55AD386ED82DF15D40AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_834164032 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.474 -0400", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "078148A6818FD7EE4734DE6A1E5579B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readUnsignedByte() throws IOException {
        int temp;
        temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.475 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "616EEBAF86E57BD6E5841BA55C0A6996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_165293263 = (((int) readShort()) & 0xffff);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.475 -0400", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "C562233EEC534D7C969505A2C17A0B12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readUTF() throws IOException {
        String var0D024495AAE2316E3574D56748D3AA56_357245738 = (decodeUTF(readUnsignedShort()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decodeUTF(readUnsignedShort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.475 -0400", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "A298F5D6C14D10DF1F940A5528583E37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String decodeUTF(int utfSize) throws IOException {
        dsTaint.addTaint(utfSize);
        String varC91A29A259C45A5FFDDB0B109353520A_1475902175 = (decodeUTF(utfSize, this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decodeUTF(utfSize, this);
    }

    
        private static String decodeUTF(int utfSize, DataInput in) throws IOException {
        byte[] buf = new byte[utfSize];
        in.readFully(buf, 0, utfSize);
        return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    
        public static final String readUTF(DataInput in) throws IOException {
        return decodeUTF(in.readUnsignedShort(), in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.475 -0400", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "33028977BA10A36AA757ED2C5739FC8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int skipBytes(int count) throws IOException {
        dsTaint.addTaint(count);
        int skipped;
        skipped = 0;
        long skip;
        {
            boolean var2A4115B73034251059ADD8819B331806_1650928994 = (skipped < count && (skip = in.skip(count - skipped)) != 0);
            {
                skipped += skip;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int skipped = 0;
        //long skip;
        //while (skipped < count && (skip = in.skip(count - skipped)) != 0) {
            //skipped += skip;
        //}
        //return skipped;
    }

    
}

