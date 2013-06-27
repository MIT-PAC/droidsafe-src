package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

public class ByteArrayOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.345 -0400", hash_original_field = "5C95DA35A1E9B551FF33B21E0F020973", hash_generated_field = "C6E32FB99CF7F81977D1E3A4C0DB1670")

    private List<byte[]> buffers = new ArrayList<byte[]>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.345 -0400", hash_original_field = "6E58E87B4D1DCF157277536E96022E37", hash_generated_field = "121DC2F5F209A5CF6A7529656B151130")

    private int currentBufferIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.345 -0400", hash_original_field = "9D765BEE904915CB946A07802535DA83", hash_generated_field = "58DBD4C6AB1FD98F8632E734CCD11AF7")

    private int filledBufferSum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.345 -0400", hash_original_field = "488539971F69BCE841700639EA8339BA", hash_generated_field = "5C16BB3DBC9621F5FD7DC0AEF00B689C")

    private byte[] currentBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.345 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.346 -0400", hash_original_method = "9671436258BFA7D3534A417C2F91BAEF", hash_generated_method = "5CFBD06B5AAB5BB41AEC7B74E92E3B56")
    public  ByteArrayOutputStream() {
        this(1024);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.346 -0400", hash_original_method = "317B4445CD0CA27CAD8CF553156DB5CA", hash_generated_method = "417249D194EAAC7867155A9FF5504C1D")
    public  ByteArrayOutputStream(int size) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Negative initial size: " + size);
        } //End block
        {
            needNewBuffer(size);
        } //End block
        addTaint(size);
        // ---------- Original Method ----------
        //if (size < 0) {
            //throw new IllegalArgumentException(
                //"Negative initial size: " + size);
        //}
        //synchronized (this) {
            //needNewBuffer(size);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.350 -0400", hash_original_method = "50E20DF9BFC1ED04B1C83DE63D7D9AAA", hash_generated_method = "BC350F757C62035822D889826AD526D1")
    private void needNewBuffer(int newcount) {
        {
            boolean var373C0744BDC5BA222C6D9D8BB1C2FB7B_1766010573 = (currentBufferIndex < buffers.size() - 1);
            {
                filledBufferSum += currentBuffer.length;
                currentBuffer = buffers.get(currentBufferIndex);
            } //End block
            {
                int newBufferSize;
                {
                    newBufferSize = newcount;
                    filledBufferSum = 0;
                } //End block
                {
                    newBufferSize = Math.max(
                    currentBuffer.length << 1, 
                    newcount - filledBufferSum);
                    filledBufferSum += currentBuffer.length;
                } //End block
                currentBuffer = new byte[newBufferSize];
                buffers.add(currentBuffer);
            } //End block
        } //End collapsed parenthetic
        addTaint(newcount);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.367 -0400", hash_original_method = "A4829AD80420573041015F28AD207DA9", hash_generated_method = "38E793B38D8177AB8D03B599D95EF778")
    @Override
    public void write(byte[] b, int off, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            int newcount;
            newcount = count + len;
            int remaining;
            remaining = len;
            int inBufferPos;
            inBufferPos = count - filledBufferSum;
            {
                int part;
                part = Math.min(remaining, currentBuffer.length - inBufferPos);
                System.arraycopy(b, off + len - remaining, currentBuffer, inBufferPos, part);
                remaining -= part;
                {
                    needNewBuffer(newcount);
                    inBufferPos = 0;
                } //End block
            } //End block
            count = newcount;
        } //End block
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.368 -0400", hash_original_method = "8B0B5349E68519FC453F35485E73C8A6", hash_generated_method = "FF52AE83B0CD68EC31DA9943011DBAA2")
    @Override
    public synchronized void write(int b) {
        int inBufferPos;
        inBufferPos = count - filledBufferSum;
        {
            needNewBuffer(count + 1);
            inBufferPos = 0;
        } //End block
        currentBuffer[inBufferPos] = (byte) b;
        // ---------- Original Method ----------
        //int inBufferPos = count - filledBufferSum;
        //if (inBufferPos == currentBuffer.length) {
            //needNewBuffer(count + 1);
            //inBufferPos = 0;
        //}
        //currentBuffer[inBufferPos] = (byte) b;
        //count++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.369 -0400", hash_original_method = "BAEC3D3F780421802E8DF98D1AC17676", hash_generated_method = "3DFD37821AF96E74D921CDB1878BBD14")
    public synchronized int write(InputStream in) throws IOException {
        int readCount;
        readCount = 0;
        int inBufferPos;
        inBufferPos = count - filledBufferSum;
        int n;
        n = in.read(currentBuffer, inBufferPos, currentBuffer.length - inBufferPos);
        {
            readCount += n;
            inBufferPos += n;
            count += n;
            {
                needNewBuffer(currentBuffer.length);
                inBufferPos = 0;
            } //End block
            n = in.read(currentBuffer, inBufferPos, currentBuffer.length - inBufferPos);
        } //End block
        addTaint(in.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904114318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904114318;
        // ---------- Original Method ----------
        //int readCount = 0;
        //int inBufferPos = count - filledBufferSum;
        //int n = in.read(currentBuffer, inBufferPos, currentBuffer.length - inBufferPos);
        //while (n != -1) {
            //readCount += n;
            //inBufferPos += n;
            //count += n;
            //if (inBufferPos == currentBuffer.length) {
                //needNewBuffer(currentBuffer.length);
                //inBufferPos = 0;
            //}
            //n = in.read(currentBuffer, inBufferPos, currentBuffer.length - inBufferPos);
        //}
        //return readCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.369 -0400", hash_original_method = "F417CE3385B772AADA134FBE4FF63C9E", hash_generated_method = "69FF9DF9EFA717D71CB2F47852C314EA")
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617626315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1617626315;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.369 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "6B4749673D8A7A62B822BE7109DA1BE7")
    @Override
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.372 -0400", hash_original_method = "3BECEC90830A19D0B52FCB2C690A0903", hash_generated_method = "2F7314B92861EA657FFABE3544021731")
    public synchronized void reset() {
        count = 0;
        filledBufferSum = 0;
        currentBufferIndex = 0;
        currentBuffer = buffers.get(currentBufferIndex);
        // ---------- Original Method ----------
        //count = 0;
        //filledBufferSum = 0;
        //currentBufferIndex = 0;
        //currentBuffer = buffers.get(currentBufferIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.408 -0400", hash_original_method = "2C0F3D6FFED876F2881377B8BBDD2213", hash_generated_method = "859121609BB4D122B771F17CADA2EBDC")
    public synchronized void writeTo(OutputStream out) throws IOException {
        int remaining;
        remaining = count;
        {
            Iterator<byte[]> varA8A5CD9AA74F106C16B0FADFF101CA7B_1815861071 = (buffers).iterator();
            varA8A5CD9AA74F106C16B0FADFF101CA7B_1815861071.hasNext();
            byte[] buf = varA8A5CD9AA74F106C16B0FADFF101CA7B_1815861071.next();
            {
                int c;
                c = Math.min(buf.length, remaining);
                out.write(buf, 0, c);
                remaining -= c;
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //int remaining = count;
        //for (byte[] buf : buffers) {
            //int c = Math.min(buf.length, remaining);
            //out.write(buf, 0, c);
            //remaining -= c;
            //if (remaining == 0) {
                //break;
            //}
        //}
    }

    
        public static InputStream toBufferedInputStream(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(input);
        return output.toBufferedInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.439 -0400", hash_original_method = "09C3ED78BB694DA1C6BDA9FC224ED162", hash_generated_method = "46826C42095E3E8B6053B5C28CAB07A0")
    private InputStream toBufferedInputStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_706647664 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_167622355 = null; //Variable for return #2
        int remaining;
        remaining = count;
        {
            varB4EAC82CA7396A68D541C85D26508E83_706647664 = new ClosedInputStream();
        } //End block
        List<ByteArrayInputStream> list;
        list = new ArrayList<ByteArrayInputStream>(buffers.size());
        {
            Iterator<byte[]> varA8A5CD9AA74F106C16B0FADFF101CA7B_1819895604 = (buffers).iterator();
            varA8A5CD9AA74F106C16B0FADFF101CA7B_1819895604.hasNext();
            byte[] buf = varA8A5CD9AA74F106C16B0FADFF101CA7B_1819895604.next();
            {
                int c;
                c = Math.min(buf.length, remaining);
                list.add(new ByteArrayInputStream(buf, 0, c));
                remaining -= c;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_167622355 = new SequenceInputStream(Collections.enumeration(list));
        InputStream varA7E53CE21691AB073D9660D615818899_181839322; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_181839322 = varB4EAC82CA7396A68D541C85D26508E83_706647664;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_181839322 = varB4EAC82CA7396A68D541C85D26508E83_167622355;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_181839322.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_181839322;
        // ---------- Original Method ----------
        //int remaining = count;
        //if (remaining == 0) {
            //return new ClosedInputStream();
        //}
        //List<ByteArrayInputStream> list = new ArrayList<ByteArrayInputStream>(buffers.size());
        //for (byte[] buf : buffers) {
            //int c = Math.min(buf.length, remaining);
            //list.add(new ByteArrayInputStream(buf, 0, c));
            //remaining -= c;
            //if (remaining == 0) {
                //break;
            //}
        //}
        //return new SequenceInputStream(Collections.enumeration(list));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.475 -0400", hash_original_method = "CFE8F4A52457DD3D62650244F80C911C", hash_generated_method = "EEB05491757BFA537E766D41464BA3D2")
    public synchronized byte[] toByteArray() {
        int remaining;
        remaining = count;
        byte newbuf[];
        newbuf = new byte[remaining];
        int pos;
        pos = 0;
        {
            Iterator<byte[]> varA8A5CD9AA74F106C16B0FADFF101CA7B_1588630469 = (buffers).iterator();
            varA8A5CD9AA74F106C16B0FADFF101CA7B_1588630469.hasNext();
            byte[] buf = varA8A5CD9AA74F106C16B0FADFF101CA7B_1588630469.next();
            {
                int c;
                c = Math.min(buf.length, remaining);
                System.arraycopy(buf, 0, newbuf, pos, c);
                pos += c;
                remaining -= c;
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1380758580 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1380758580;
        // ---------- Original Method ----------
        //int remaining = count;
        //if (remaining == 0) {
            //return EMPTY_BYTE_ARRAY; 
        //}
        //byte newbuf[] = new byte[remaining];
        //int pos = 0;
        //for (byte[] buf : buffers) {
            //int c = Math.min(buf.length, remaining);
            //System.arraycopy(buf, 0, newbuf, pos, c);
            //pos += c;
            //remaining -= c;
            //if (remaining == 0) {
                //break;
            //}
        //}
        //return newbuf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.476 -0400", hash_original_method = "95976D81CB90569BB8CC4A3AB0B84125", hash_generated_method = "7B1049ACE2BCBFEEFA2121E4C688C84B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_314430808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_314430808 = new String(toByteArray());
        varB4EAC82CA7396A68D541C85D26508E83_314430808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_314430808;
        // ---------- Original Method ----------
        //return new String(toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.477 -0400", hash_original_method = "7182DDAFB743FF4AA8D7A019E67A4496", hash_generated_method = "D42329BDBF9A422DE3DAE8ED6BF86A0D")
    public String toString(String enc) throws UnsupportedEncodingException {
        String varB4EAC82CA7396A68D541C85D26508E83_1695894502 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1695894502 = new String(toByteArray(), enc);
        addTaint(enc.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1695894502.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1695894502;
        // ---------- Original Method ----------
        //return new String(toByteArray(), enc);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.477 -0400", hash_original_field = "5AA514BAD7F92AA663B3DEE266FE2CF4", hash_generated_field = "7B0575AFCB5FDF6D3719D2B32CF43D9E")

    private static byte[] EMPTY_BYTE_ARRAY = new byte[0];
}

