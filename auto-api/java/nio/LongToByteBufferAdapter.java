package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import libcore.io.SizeOf;

final class LongToByteBufferAdapter extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.674 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.674 -0400", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "57E6A47D4A49ACF7C2EEBE80CADCBC3B")
    private  LongToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.LONG);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static LongBuffer asLongBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new LongToByteBufferAdapter(slice);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.675 -0400", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "D1F2295CEEBBC7130A830817A2F868EC")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1785820101 = null; 
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_1785820101 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1785820101.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1785820101;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.677 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "63A38FB77DDED60577DE1CBE91F93050")
    @Override
    public LongBuffer compact() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_282645268 = null; 
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_987399233 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } 
        } 
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_282645268 = this;
        varB4EAC82CA7396A68D541C85D26508E83_282645268.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_282645268;
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.680 -0400", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "904CD86F611B8F50B8C2BDE1F3C5EA51")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1173903963 = null; 
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1173903963 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1173903963.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1173903963;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.681 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "F2FCBAE4BB20A619190421EB86088038")
    @Override
    public long get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } 
        long varDCE94F842B30BE56FD0BC4850A846E4B_272561673 = (byteBuffer.getLong(position++ * SizeOf.LONG));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_604164615 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_604164615;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.682 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "B84D8331EF411B2E1A5103FE4B476A32")
    @Override
    public long get(int index) {
        checkIndex(index);
        long var506B8B5E6E1E832DCB35F22FB6DE70FB_1640922884 = (byteBuffer.getLong(index * SizeOf.LONG));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_706134560 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_706134560;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.684 -0400", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "D3490959F3AB60FBAA4EA2A9EFACDBA2")
    @Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1642956176 = null; 
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } 
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } 
        this.position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_1642956176 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1642956176.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1642956176;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.685 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "A9A282E9AF81761891C59417DCD45EC6")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_277472426 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029582464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029582464;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.685 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "ADDECE0BC45DA0E13876A0454E75FE35")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1670714811 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1096236792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1096236792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.686 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "F6407D67D6BF3DEBF5D9B6E5F0409287")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_10421995 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_10421995 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_10421995.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_10421995;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.686 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "F81C75A84657ED1D9863CB524C1087EB")
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_2055271032 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_2055271032;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.687 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "9185F95914AD3D05105C6C11C6A7109C")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_868081491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_868081491;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.687 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "E07DB176D8B31C040D7B693DD05CCFFF")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697745862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697745862;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.688 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "C3AA3A1AFDE8481F6F1218C41A614470")
    @Override
    public LongBuffer put(long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1705933812 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
        varB4EAC82CA7396A68D541C85D26508E83_1705933812 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1705933812.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1705933812;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.689 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "19F24915E958F4F3570B05EEA4EE5A23")
    @Override
    public LongBuffer put(int index, long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1593487150 = null; 
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
        varB4EAC82CA7396A68D541C85D26508E83_1593487150 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1593487150.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1593487150;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.690 -0400", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "A8B3324133AE6F6519609E65411C8EDC")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_2109063013 = null; 
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } 
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } 
        this.position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_2109063013 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_2109063013.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2109063013;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.691 -0400", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "13672F79C61855AC4EE181726070B3E1")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_423994466 = null; 
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_423994466 = result;
        varB4EAC82CA7396A68D541C85D26508E83_423994466.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_423994466;
        
        
        
        
        
        
        
    }

    
}

