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
import libcore.io.SizeOf;

public class DataOutputStream extends FilterOutputStream implements DataOutput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.674 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "D820A674F7D8FF0413B54161C23F9DAA")

    private byte[] scratch = new byte[8];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.674 -0400", hash_original_field = "9CC26FA09CE37BC95AFE01BC718836D1", hash_generated_field = "E741850208E8C13ED74657425073FA6A")

    protected int written;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.675 -0400", hash_original_method = "1F21B50AF2AC9DDDB6B0A66AE5784248", hash_generated_method = "9E5DB5C7F7B5409C1D3AE14446B961AE")
    public  DataOutputStream(OutputStream out) {
        super(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.675 -0400", hash_original_method = "85FD61C7B117729DDA17405FA5EDFA09", hash_generated_method = "44E353C81F2F5BBACFB91689B686E7A5")
    @Override
    public void flush() throws IOException {
        super.flush();
        // ---------- Original Method ----------
        //super.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.676 -0400", hash_original_method = "93505B8C7EE8964F6C5155AF365C502B", hash_generated_method = "FEA359A5455C984BB90EBD57EBA8658D")
    public final int size() {
        {
            written = Integer.MAX_VALUE;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725790396 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725790396;
        // ---------- Original Method ----------
        //if (written < 0) {
            //written = Integer.MAX_VALUE;
        //}
        //return written;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.676 -0400", hash_original_method = "91D255AEAD2ED7375F2242249D64C3A6", hash_generated_method = "74A0825E9A717E8A1D423283AB8624CB")
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } //End block
        out.write(buffer, offset, count);
        written += count;
        addTaint(buffer[0]);
        addTaint(offset);
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //out.write(buffer, offset, count);
        //written += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.676 -0400", hash_original_method = "480870EC6BADBB21CCFBD983315F3126", hash_generated_method = "60AB6CE8A4E02876865F585A7643BE17")
    @Override
    public void write(int oneByte) throws IOException {
        out.write(oneByte);
        addTaint(oneByte);
        // ---------- Original Method ----------
        //out.write(oneByte);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.677 -0400", hash_original_method = "A77584E214A9D3ECC7E83106209731E2", hash_generated_method = "08FF3792F06904345CEA5DC8214C9D8D")
    public final void writeBoolean(boolean val) throws IOException {
        out.write(val ? 1 : 0);
        addTaint(val);
        // ---------- Original Method ----------
        //out.write(val ? 1 : 0);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.677 -0400", hash_original_method = "3FF3B06C0E9CF4CECAE3125D160806A3", hash_generated_method = "CA41929A2BC63FE09864D2D536D30D55")
    public final void writeByte(int val) throws IOException {
        out.write(val);
        addTaint(val);
        // ---------- Original Method ----------
        //out.write(val);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.678 -0400", hash_original_method = "2B2A2FBAAA2AE585E2D089CF030D969B", hash_generated_method = "50164682D0B9E9626457D02FD20BED20")
    public final void writeBytes(String str) throws IOException {
        {
            boolean var3944F5EA93E11499373F86E2F272CA9A_1371505367 = (str.length() == 0);
        } //End collapsed parenthetic
        byte[] bytes;
        bytes = new byte[str.length()];
        {
            int index;
            index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_123574384 = (index < str.length());
            {
                bytes[index] = (byte) str.charAt(index);
            } //End block
        } //End collapsed parenthetic
        out.write(bytes);
        written += bytes.length;
        addTaint(str.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.678 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "DD808167E0A0638EDB5F24AB5B6A989B")
    public final void writeChar(int val) throws IOException {
        writeShort(val);
        addTaint(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.678 -0400", hash_original_method = "8A00B7ED3E4C8E18D5DAA971EE1A3300", hash_generated_method = "FA3CD3CEE406CD10FFD8D86C044CA395")
    public final void writeChars(String str) throws IOException {
        byte[] bytes;
        bytes = str.getBytes("UTF-16BE");
        out.write(bytes);
        written += bytes.length;
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //byte[] bytes = str.getBytes("UTF-16BE");
        //out.write(bytes);
        //written += bytes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.679 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "3DBCD431F669B61280931467601A41C3")
    public final void writeDouble(double val) throws IOException {
        writeLong(Double.doubleToLongBits(val));
        addTaint(val);
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.679 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "23BFEF07C67385B17FCF73AD5AC52B24")
    public final void writeFloat(float val) throws IOException {
        writeInt(Float.floatToIntBits(val));
        addTaint(val);
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.692 -0400", hash_original_method = "F03796591B445F12DEDD3500300CBF0A", hash_generated_method = "87FABE0EC3B2781AC22A3F8269A07049")
    public final void writeInt(int val) throws IOException {
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.INT);
        written += SizeOf.INT;
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.INT);
        //written += SizeOf.INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.693 -0400", hash_original_method = "95F3A047CFE8B2E6EECA757BB89D80AE", hash_generated_method = "2BFB99C8127351A95B45768B311CD511")
    public final void writeLong(long val) throws IOException {
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.LONG);
        written += SizeOf.LONG;
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.LONG);
        //written += SizeOf.LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.694 -0400", hash_original_method = "C58CFA32359226806A4206A3D5262CA2", hash_generated_method = "77218455B7BEF28008AD0ED03DEBD021")
    public final void writeShort(int val) throws IOException {
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        out.write(scratch, 0, SizeOf.SHORT);
        written += SizeOf.SHORT;
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //out.write(scratch, 0, SizeOf.SHORT);
        //written += SizeOf.SHORT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.694 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "D46F217503ADED3A09B4FFB1E313F623")
    public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

