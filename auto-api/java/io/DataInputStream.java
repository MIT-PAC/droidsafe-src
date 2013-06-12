package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.Streams;
import libcore.io.SizeOf;

public class DataInputStream extends FilterInputStream implements DataInput {
    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.410 -0400", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "97B82D8648A823F7487BD846A4C8ADBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataInputStream(InputStream in) {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.410 -0400", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "60DA4CF4614DEE2B5FB8BEC22A00B51B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int read(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer);
        int var5D20304CDE93C454B73A071B58B41FC2_2137033357 = (super.read(buffer));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.read(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.410 -0400", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "6615335A653B4DA95016431B76A28DD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int varD4EC737F94C97A2DC68884F821BEA260_1334989739 = (in.read(buffer, offset, length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return in.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.410 -0400", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "354E921BE49A0FEBB032DE59ABCEEC36")
    @DSModeled(DSC.SAFE)
    public final boolean readBoolean() throws IOException {
        int temp;
        temp = in.read();
        if(DroidSafeAndroidRuntime.control) {
            throw new EOFException();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "7F852FA85F542A4DFACB349BD176A36B")
    @DSModeled(DSC.SAFE)
    public final byte readByte() throws IOException {
        int temp;
        temp = in.read();
        if(DroidSafeAndroidRuntime.control) {
            throw new EOFException();
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "4B67E8C8A002CC28D48D491C402D97FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_1599264986 = ((char) readShort());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "8C8E461FE57980E596E566890288C06B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_659177060 = (Double.longBitsToDouble(readLong()));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "92FCB0450CD49789E2CFA2B45D909E95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_1591751909 = (Float.intBitsToFloat(readInt()));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "C1CBB04FBF7269F52C32DF32F806BDA7")
    @DSModeled(DSC.SAFE)
    public final void readFully(byte[] dst) throws IOException {
        dsTaint.addTaint(dst);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "E389B25D4EF1673C65004FEDCBC90E54")
    @DSModeled(DSC.SAFE)
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(offset);
        Streams.readFully(in, dst, offset, byteCount);
        // ---------- Original Method ----------
        //Streams.readFully(in, dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "C56FEDE836ACB45873C802978A8E54D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_763421647 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "8FFFA7F035FE62DEE794F480158C4AB1")
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
                boolean var9283EC23547FB4E91F8ADED78FB3824E_23579958 = (line.length() == 0 && !foundTerminator);
            } //End collapsed parenthetic
            //End case -1 
            //Begin case -1 
            String var1EC93FDCAE6CEDB0F6DB29587930777B_204338429 = (line.toString());
            //End case -1 
            //Begin case (byte) '\r' 
            {
                ((PushbackInputStream) in).unread(nextByte);
                String var17A15FA5FFB6049E90AD08C06406E86F_1302088991 = (line.toString());
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            {
                boolean var2EF3DF204DF2FA3A280904C5F67B208D_1657490108 = (!(in.getClass() == PushbackInputStream.class));
                {
                    in = new PushbackInputStream(in);
                } //End block
            } //End collapsed parenthetic
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            String var1EC93FDCAE6CEDB0F6DB29587930777B_2022043660 = (line.toString());
            //End case (byte) '\n' 
            //Begin case default 
            {
                ((PushbackInputStream) in).unread(nextByte);
                String var17A15FA5FFB6049E90AD08C06406E86F_794854176 = (line.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "6684C25B36B4C5381534C324572DC7D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_370394036 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "4E00C67CD5BD5AFB052455300436B025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_1153246307 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "F361837ED0A70B6CEA2B81E5FBE29153")
    @DSModeled(DSC.SAFE)
    public final int readUnsignedByte() throws IOException {
        int temp;
        temp = in.read();
        if(DroidSafeAndroidRuntime.control) {
            throw new EOFException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.411 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "79A5BA7D8A5AE495F3C92008B67FF957")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_2045563881 = (((int) readShort()) & 0xffff);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.412 -0400", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "1CEA7E937B25B3679299FEEEE7B2F880")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readUTF() throws IOException {
        String var0D024495AAE2316E3574D56748D3AA56_2098546394 = (decodeUTF(readUnsignedShort()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decodeUTF(readUnsignedShort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.412 -0400", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "823A35FFA421FE6F63D5DA05EE0288F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String decodeUTF(int utfSize) throws IOException {
        dsTaint.addTaint(utfSize);
        String varC91A29A259C45A5FFDDB0B109353520A_22249937 = (decodeUTF(utfSize, this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decodeUTF(utfSize, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.412 -0400", hash_original_method = "67FCD1C79AA5AB7081ED61CA977F833F", hash_generated_method = "155E09981B88266614B7B0331C008BE8")
    private static String decodeUTF(int utfSize, DataInput in) throws IOException {
        byte[] buf = new byte[utfSize];
        in.readFully(buf, 0, utfSize);
        return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.412 -0400", hash_original_method = "48D45EEAED3352F596D800D5190ACC41", hash_generated_method = "9EA8D8A168036339E307513D7F2AD7AD")
    public static final String readUTF(DataInput in) throws IOException {
        return decodeUTF(in.readUnsignedShort(), in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.412 -0400", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "3AC132C7FE386F8C4C6DB7FF5209C4F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int skipBytes(int count) throws IOException {
        dsTaint.addTaint(count);
        int skipped;
        skipped = 0;
        long skip;
        {
            skip = in.skip(count - skipped);
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


