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
    private byte[] scratch = new byte[8];
    protected int written;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.480 -0400", hash_original_method = "1F21B50AF2AC9DDDB6B0A66AE5784248", hash_generated_method = "22C03CBBCEDBEAA3A63BAEF962A6ED5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DataOutputStream(OutputStream out) {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.480 -0400", hash_original_method = "85FD61C7B117729DDA17405FA5EDFA09", hash_generated_method = "44E353C81F2F5BBACFB91689B686E7A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void flush() throws IOException {
        super.flush();
        // ---------- Original Method ----------
        //super.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.481 -0400", hash_original_method = "93505B8C7EE8964F6C5155AF365C502B", hash_generated_method = "356B960B7B1D9D9E0B07DC5466C7603A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.481 -0400", hash_original_method = "91D255AEAD2ED7375F2242249D64C3A6", hash_generated_method = "490ED73A0B68BC285AB03431B315AA43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } //End block
        out.write(buffer, offset, count);
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //out.write(buffer, offset, count);
        //written += count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.481 -0400", hash_original_method = "480870EC6BADBB21CCFBD983315F3126", hash_generated_method = "99FEC81A56BD1391A246104D0547C073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
        out.write(oneByte);
        // ---------- Original Method ----------
        //out.write(oneByte);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.481 -0400", hash_original_method = "A77584E214A9D3ECC7E83106209731E2", hash_generated_method = "8CD7CF7FA619F37630E47B9232844835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBoolean(boolean val) throws IOException {
        dsTaint.addTaint(val);
        out.write(val ? 1 : 0);
        // ---------- Original Method ----------
        //out.write(val ? 1 : 0);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.481 -0400", hash_original_method = "3FF3B06C0E9CF4CECAE3125D160806A3", hash_generated_method = "C07675FBDD9BC4443D867EE4B6784F52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeByte(int val) throws IOException {
        dsTaint.addTaint(val);
        out.write(val);
        // ---------- Original Method ----------
        //out.write(val);
        //written++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.482 -0400", hash_original_method = "2B2A2FBAAA2AE585E2D089CF030D969B", hash_generated_method = "552D03B2792B8108E181AABE80F91556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBytes(String str) throws IOException {
        dsTaint.addTaint(str);
        {
            boolean var3944F5EA93E11499373F86E2F272CA9A_1454047138 = (str.length() == 0);
        } //End collapsed parenthetic
        byte[] bytes;
        bytes = new byte[str.length()];
        {
            int index;
            index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_910450714 = (index < str.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.482 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "9B3F77BCDFD3570266EA5B4A54A6C490")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeChar(int val) throws IOException {
        dsTaint.addTaint(val);
        writeShort(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.482 -0400", hash_original_method = "8A00B7ED3E4C8E18D5DAA971EE1A3300", hash_generated_method = "03688A66C616D48472EECFD441885ADE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.482 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "D6A384EDF89A44EBC738C0D6A777FD58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDouble(double val) throws IOException {
        dsTaint.addTaint(val);
        writeLong(Double.doubleToLongBits(val));
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.482 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "51DC8D8BD51807ABFEDB0CC3CA019687")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloat(float val) throws IOException {
        dsTaint.addTaint(val);
        writeInt(Float.floatToIntBits(val));
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.483 -0400", hash_original_method = "F03796591B445F12DEDD3500300CBF0A", hash_generated_method = "B8EB1BA77B9EDDF0CFD4207BE2BA6B8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.483 -0400", hash_original_method = "95F3A047CFE8B2E6EECA757BB89D80AE", hash_generated_method = "A9463D771E9EA84FB607BA9D56CAC98D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.483 -0400", hash_original_method = "C58CFA32359226806A4206A3D5262CA2", hash_generated_method = "3BAD61796FE8FE758F700CA6322B87E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.483 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "9E671ED2F004E5E9D7B540ABCB063BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeUTF(String str) throws IOException {
        dsTaint.addTaint(str);
        write(ModifiedUtf8.encode(str));
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

