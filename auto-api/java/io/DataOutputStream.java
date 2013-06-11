package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.SizeOf;

public class DataOutputStream extends FilterOutputStream implements DataOutput {
    private final byte[] scratch = new byte[8];
    protected int written;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "1F21B50AF2AC9DDDB6B0A66AE5784248", hash_generated_method = "EBEC62158AD6C19FEABB72A0992A0183")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataOutputStream(OutputStream out) {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "85FD61C7B117729DDA17405FA5EDFA09", hash_generated_method = "98D5A6A02B5A046E07EDDF2815CE7FBD")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() throws IOException {
        super.flush();
        // ---------- Original Method ----------
        //super.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "93505B8C7EE8964F6C5155AF365C502B", hash_generated_method = "752ACD3FCA29FF3112C79314E524D36A")
    @DSModeled(DSC.SAFE)
    public final int size() {
        {
            written = Integer.MAX_VALUE;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (written < 0) {
            //written = Integer.MAX_VALUE;
        //}
        //return written;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "91D255AEAD2ED7375F2242249D64C3A6", hash_generated_method = "DCF6E9BD1E0C29FD321A0699EA00F4FD")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            throw new NullPointerException("buffer == null");
        } //End block
        out.write(buffer, offset, count);
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //out.write(buffer, offset, count);
        //written += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "480870EC6BADBB21CCFBD983315F3126", hash_generated_method = "8EDC731C4A25048D1F75FA4027DC0D26")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
        out.write(oneByte);
        written++;
        // ---------- Original Method ----------
        //out.write(oneByte);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "A77584E214A9D3ECC7E83106209731E2", hash_generated_method = "E8CC4399AD32E69C59526CAFD367AA5F")
    @DSModeled(DSC.SAFE)
    public final void writeBoolean(boolean val) throws IOException {
        dsTaint.addTaint(val);
        out.write(val ? 1 : 0);
        written++;
        // ---------- Original Method ----------
        //out.write(val ? 1 : 0);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "3FF3B06C0E9CF4CECAE3125D160806A3", hash_generated_method = "4E85F33AB2D29CA4E897F4CCBE4851CE")
    @DSModeled(DSC.SAFE)
    public final void writeByte(int val) throws IOException {
        dsTaint.addTaint(val);
        out.write(val);
        written++;
        // ---------- Original Method ----------
        //out.write(val);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "2B2A2FBAAA2AE585E2D089CF030D969B", hash_generated_method = "101CDCD86B2DECEF8C964D522A7B7825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBytes(String str) throws IOException {
        dsTaint.addTaint(str);
        {
            boolean var3944F5EA93E11499373F86E2F272CA9A_314015724 = (str.length() == 0);
        } //End collapsed parenthetic
        byte[] bytes;
        bytes = new byte[str.length()];
        {
            int index;
            index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_185308850 = (index < str.length());
            {
                bytes[index] = (byte) str.charAt(index);
            } //End block
        } //End collapsed parenthetic
        out.write(bytes);
        written += bytes.length;
        // ---------- Original Method ----------
        //if (str.length() == 0) {
            //return;
        //}
        //byte[] bytes = new byte[str.length()];
        //for (int index = 0; index < str.length(); index++) {
            //bytes[index] = (byte) str.charAt(index);
        //}
        //out.write(bytes);
        //written += bytes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.415 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "12C19891F61CFBC3E746AD0E6AEE8AE8")
    @DSModeled(DSC.SAFE)
    public final void writeChar(int val) throws IOException {
        dsTaint.addTaint(val);
        writeShort(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "8A00B7ED3E4C8E18D5DAA971EE1A3300", hash_generated_method = "484A7FE4F2CE10D6CEBC3B6AC72ED923")
    @DSModeled(DSC.SAFE)
    public final void writeChars(String str) throws IOException {
        dsTaint.addTaint(str);
        byte[] bytes;
        bytes = str.getBytes("UTF-16BE");
        out.write(bytes);
        written += bytes.length;
        // ---------- Original Method ----------
        //byte[] bytes = str.getBytes("UTF-16BE");
        //out.write(bytes);
        //written += bytes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "D1EEB7713D6304552B5377F83A84DF41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDouble(double val) throws IOException {
        dsTaint.addTaint(val);
        writeLong(Double.doubleToLongBits(val));
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "66AE7CFE9293D88FB6E5F68B9F3CB17D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloat(float val) throws IOException {
        dsTaint.addTaint(val);
        writeInt(Float.floatToIntBits(val));
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "F03796591B445F12DEDD3500300CBF0A", hash_generated_method = "450BBD3ECD812841F121BEB3B854DA84")
    @DSModeled(DSC.SAFE)
    public final void writeInt(int val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.INT);
        written += SizeOf.INT;
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.INT);
        //written += SizeOf.INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "95F3A047CFE8B2E6EECA757BB89D80AE", hash_generated_method = "BCF91169E6EA6AC613A965080BF3838A")
    @DSModeled(DSC.SAFE)
    public final void writeLong(long val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.LONG);
        written += SizeOf.LONG;
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.LONG);
        //written += SizeOf.LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "C58CFA32359226806A4206A3D5262CA2", hash_generated_method = "F4A7D15C35F00328EBB89EC165115F32")
    @DSModeled(DSC.SAFE)
    public final void writeShort(int val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.SHORT);
        written += SizeOf.SHORT;
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.SHORT);
        //written += SizeOf.SHORT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.416 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "7EB3DC8AD349F52AB6B902F2F6AA463E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeUTF(String str) throws IOException {
        dsTaint.addTaint(str);
        write(ModifiedUtf8.encode(str));
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}


