package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class ShortToByteBufferAdapter extends ShortBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.201 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.216 -0400", hash_original_method = "A7ACA037BB98388A15E54FB4598E481B", hash_generated_method = "99030E6A8F05267CDC21391C0846AEB3")
    private  ShortToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.SHORT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ShortToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.218 -0400", hash_original_method = "D0F8AEC70CAA4378FE6A82AD4DA3E011", hash_generated_method = "9A20981D2F94E5991D7534038806AAF2")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1226531339 = null; //Variable for return #1
        ShortToByteBufferAdapter buf;
        buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_1226531339 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1226531339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226531339;
        // ---------- Original Method ----------
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.219 -0400", hash_original_method = "05DE7B6CED27ACAA0A9F6BF73EB6C673", hash_generated_method = "1257A0D3206251B589430C2AACBA840D")
    @Override
    public ShortBuffer compact() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_268945889 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1587448681 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_268945889 = this;
        varB4EAC82CA7396A68D541C85D26508E83_268945889.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_268945889;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.229 -0400", hash_original_method = "D125FE991C052B0355B5B7F2D7D9870F", hash_generated_method = "B3F377EC3F308E3F80B0E6F0F95A1A44")
    @Override
    public ShortBuffer duplicate() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_160129297 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        ShortToByteBufferAdapter buf;
        buf = new ShortToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_160129297 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_160129297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_160129297;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.229 -0400", hash_original_method = "7C4E3224E8CBDBDF522D2B052ECE14D8", hash_generated_method = "A33804E1188323B827AC3EA9CF5978CB")
    @Override
    public short get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        short varF4A707B1B20CA460D36B00B15C262335_437803587 = (byteBuffer.getShort(position++ * SizeOf.SHORT));
        short var4F09DAA9D95BCB166A302407A0E0BABE_27540116 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_27540116;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getShort(position++ * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.230 -0400", hash_original_method = "99D353FC1689A601B3A3A0ABA15D7065", hash_generated_method = "FC749F583B4433ACD7184FD91801F1BC")
    @Override
    public short get(int index) {
        checkIndex(index);
        short varBE4C2F8B8B0709014E8FE2B3CF301305_585841416 = (byteBuffer.getShort(index * SizeOf.SHORT));
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1381157784 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1381157784;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getShort(index * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.230 -0400", hash_original_method = "01D384F7005F01D67D604B15B569F233", hash_generated_method = "6B0655F039E83874A30B684BE0BFB8DE")
    @Override
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1691389893 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        this.position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_1691389893 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_1691389893.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1691389893;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.231 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "6199B4516950AEE443AB76FE7C98D469")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_274686874 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161955824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161955824;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.231 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "7C5FBF15636CD9FE2A9B1C6EB0FE3A08")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_158026845 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783340193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783340193;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.242 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "A67F28126B31E7B20F69989A6E74AEC0")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_2133970422 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2133970422 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_2133970422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2133970422;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.243 -0400", hash_original_method = "797461B8F23A38201C61F803B025213F", hash_generated_method = "3B3F355AAA04352F3DE521E1F1C4DEB2")
    @Override
    protected short[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        short[] var48EE7E2DDF8A83602BC526873BD0F875_1754545728 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1754545728;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.244 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "291821785B28E93F386E39F9B0578E5B")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817212088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817212088;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.248 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "0E582D64AA531C2FF9C9F3F319DA160B")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916690394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916690394;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.248 -0400", hash_original_method = "BED9261A5E47204D4C26D68EDDB52578", hash_generated_method = "512BDBEA235DB2ACCF2454A9AC012C62")
    @Override
    public ShortBuffer put(short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_488192123 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        varB4EAC82CA7396A68D541C85D26508E83_488192123 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_488192123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_488192123;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.268 -0400", hash_original_method = "81BB381464177DAD01780ED6CBAA4133", hash_generated_method = "BEFBA17EEC8C63020E5CD72D807B971C")
    @Override
    public ShortBuffer put(int index, short c) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_546438348 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putShort(index * SizeOf.SHORT, c);
        varB4EAC82CA7396A68D541C85D26508E83_546438348 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_546438348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_546438348;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putShort(index * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.269 -0400", hash_original_method = "513A20FF10AFB87C25A95801BCBD1A6B", hash_generated_method = "B24DB7CA70F8F426F8C792F37B377F6C")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_86542827 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        this.position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_86542827 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_86542827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_86542827;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.272 -0400", hash_original_method = "1D11F07A1825F4A6C771FB33ADDF613C", hash_generated_method = "E58676F66C1ADE62EF620DB594BE9F46")
    @Override
    public ShortBuffer slice() {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_706442356 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        ShortBuffer result;
        result = new ShortToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_706442356 = result;
        varB4EAC82CA7396A68D541C85D26508E83_706442356.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_706442356;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //ShortBuffer result = new ShortToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

