package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.SizeOf;

public class DataOutputStream extends FilterOutputStream implements DataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.697 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.699 -0400", hash_original_field = "9CC26FA09CE37BC95AFE01BC718836D1", hash_generated_field = "E741850208E8C13ED74657425073FA6A")

    protected int written;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.701 -0400", hash_original_method = "1F21B50AF2AC9DDDB6B0A66AE5784248", hash_generated_method = "9E5DB5C7F7B5409C1D3AE14446B961AE")
    public  DataOutputStream(OutputStream out) {
        super(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.702 -0400", hash_original_method = "85FD61C7B117729DDA17405FA5EDFA09", hash_generated_method = "44E353C81F2F5BBACFB91689B686E7A5")
    @Override
    public void flush() throws IOException {
        super.flush();
        // ---------- Original Method ----------
        //super.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.703 -0400", hash_original_method = "93505B8C7EE8964F6C5155AF365C502B", hash_generated_method = "8C40B78D6A840E40E94C5DDACD6716A9")
    public final int size() {
    if(written < 0)        
        {
            written = Integer.MAX_VALUE;
        } //End block
        int var9CC26FA09CE37BC95AFE01BC718836D1_411453709 = (written);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368784974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1368784974;
        // ---------- Original Method ----------
        //if (written < 0) {
            //written = Integer.MAX_VALUE;
        //}
        //return written;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.705 -0400", hash_original_method = "91D255AEAD2ED7375F2242249D64C3A6", hash_generated_method = "BD7E416BC607EE98AC7906AA21B1D6D7")
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        addTaint(offset);
        addTaint(buffer[0]);
    if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_47657961 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_47657961.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_47657961;
        } //End block
        out.write(buffer, offset, count);
        written += count;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //out.write(buffer, offset, count);
        //written += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.706 -0400", hash_original_method = "480870EC6BADBB21CCFBD983315F3126", hash_generated_method = "9838A5626C6527C941A5325E9C608F26")
    @Override
    public void write(int oneByte) throws IOException {
        addTaint(oneByte);
        out.write(oneByte);
        written++;
        // ---------- Original Method ----------
        //out.write(oneByte);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.708 -0400", hash_original_method = "A77584E214A9D3ECC7E83106209731E2", hash_generated_method = "85D0B82D52292C0E29D0617A1AB19785")
    public final void writeBoolean(boolean val) throws IOException {
        addTaint(val);
        out.write(val ? 1 : 0);
        written++;
        // ---------- Original Method ----------
        //out.write(val ? 1 : 0);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.710 -0400", hash_original_method = "3FF3B06C0E9CF4CECAE3125D160806A3", hash_generated_method = "B1BDA16A6E9FE01C00849DE0652F3443")
    public final void writeByte(int val) throws IOException {
        addTaint(val);
        out.write(val);
        written++;
        // ---------- Original Method ----------
        //out.write(val);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.712 -0400", hash_original_method = "2B2A2FBAAA2AE585E2D089CF030D969B", hash_generated_method = "8A7FDDD8E6807EFF62DA62E0A993867C")
    public final void writeBytes(String str) throws IOException {
        addTaint(str.getTaint());
    if(str.length() == 0)        
        {
            return;
        } //End block
        byte[] bytes = new byte[str.length()];
for(int index = 0;index < str.length();index++)
        {
            bytes[index] = (byte) str.charAt(index);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.714 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "1E31D82E4CCC1BDCFE3108E1328D9F76")
    public final void writeChar(int val) throws IOException {
        addTaint(val);
        writeShort(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.716 -0400", hash_original_method = "8A00B7ED3E4C8E18D5DAA971EE1A3300", hash_generated_method = "ADEB12ED03B85557EBF17CC6D6B3DEC2")
    public final void writeChars(String str) throws IOException {
        addTaint(str.getTaint());
        byte[] bytes = str.getBytes("UTF-16BE");
        out.write(bytes);
        written += bytes.length;
        // ---------- Original Method ----------
        //byte[] bytes = str.getBytes("UTF-16BE");
        //out.write(bytes);
        //written += bytes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.720 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "015AAB732EE3FB11ACE6574EE6EF9751")
    public final void writeDouble(double val) throws IOException {
        addTaint(val);
        writeLong(Double.doubleToLongBits(val));
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.723 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "D86DCBAF1163AA0C9FB91F716904211F")
    public final void writeFloat(float val) throws IOException {
        addTaint(val);
        writeInt(Float.floatToIntBits(val));
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.725 -0400", hash_original_method = "F03796591B445F12DEDD3500300CBF0A", hash_generated_method = "EF92336E807A82B5A842F3CE33CD0757")
    public final void writeInt(int val) throws IOException {
        addTaint(val);
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.INT);
        written += SizeOf.INT;
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.INT);
        //written += SizeOf.INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.726 -0400", hash_original_method = "95F3A047CFE8B2E6EECA757BB89D80AE", hash_generated_method = "69FCD2E5D7472A3BA57CD81BC90E8F0A")
    public final void writeLong(long val) throws IOException {
        addTaint(val);
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.LONG);
        written += SizeOf.LONG;
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.LONG);
        //written += SizeOf.LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.729 -0400", hash_original_method = "C58CFA32359226806A4206A3D5262CA2", hash_generated_method = "866DE674A62E4A5C0C2254D034856C48")
    public final void writeShort(int val) throws IOException {
        addTaint(val);
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.SHORT);
        written += SizeOf.SHORT;
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.SHORT);
        //written += SizeOf.SHORT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.730 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "F3F91246F6CBB42958111ACA3F00042D")
    public final void writeUTF(String str) throws IOException {
        addTaint(str.getTaint());
        write(ModifiedUtf8.encode(str));
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

