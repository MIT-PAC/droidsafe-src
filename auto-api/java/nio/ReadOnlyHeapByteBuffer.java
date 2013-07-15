package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadOnlyHeapByteBuffer extends HeapByteBuffer {

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.940 -0400", hash_original_method = "2F2ACF3B9ABB2D0DAB5827DF665B4EAD", hash_generated_method = "9423D30F9DF81CE7C9A24AE261E339B9")
	ReadOnlyHeapByteBuffer(byte[] backingArray, int capacity, int arrayOffset) {
		super(backingArray, capacity, arrayOffset);
		addTaint(backingArray[0]);
		addTaint(capacity);
		addTaint(arrayOffset);
		
	}

	@DSModeled(DSC.SAFE)
    static ReadOnlyHeapByteBuffer copy(HeapByteBuffer other, int markOfOther) {
		ReadOnlyHeapByteBuffer buf = new ReadOnlyHeapByteBuffer(other.backingArray, other.capacity(), other.offset);
		buf.limit = other.limit;
		buf.position = other.position();
		buf.mark = markOfOther;
		return buf;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.941 -0400", hash_original_method = "DAFC57596AF38F7142398219C2B48840", hash_generated_method = "DAD63EC5AB0F9194A30E7DF9D055A549")
	@Override
	public ByteBuffer asReadOnlyBuffer() {
		ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1732601702 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_1732601702 = ReadOnlyHeapByteBuffer.copy(this, mark);
		varB4EAC82CA7396A68D541C85D26508E83_1732601702.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1732601702;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.941 -0400", hash_original_method = "E9BD68C2A3E399E8B6F437AA7B03F4EC", hash_generated_method = "D5E46093681AF6A8F8AD951CFA704E70")
	@Override
	public ByteBuffer compact() {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.942 -0400", hash_original_method = "C2883EB2B7E86A704D76356E1AAB194F", hash_generated_method = "99374C07F5AA2B2ED410DAE97AE7B517")
	@Override
	public ByteBuffer duplicate() {
		ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1385143944 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_1385143944 = copy(this, mark);
		varB4EAC82CA7396A68D541C85D26508E83_1385143944.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1385143944;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.942 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "3D02F69B0B646D8920F6E165EC61E7CF")
	@Override
	public boolean isReadOnly() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630195516 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_630195516;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.942 -0400", hash_original_method = "722C56C70277A2AF29EF09DE3FC2E957", hash_generated_method = "A57F12C2EA18B15D6A85790E6213E236")
	@Override
	protected byte[] protectedArray() {
		if (DroidSafeAndroidRuntime.control)
			throw new ReadOnlyBufferException();
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1005664128 = { getTaintByte() };
		return var2F9C81BC6E497382285CD6B7A7E33DE1_1005664128;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.942 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "323519BDB90827D523BC23E24831E8AA")
	@Override
	protected int protectedArrayOffset() {
		if (DroidSafeAndroidRuntime.control)
			throw new ReadOnlyBufferException();
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962117463 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962117463;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.943 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "8716CE31B52355F28C54F9887CD90560")
	@Override
	protected boolean protectedHasArray() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060120576 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060120576;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.943 -0400", hash_original_method = "F6BE9BC005619EB0DCAA2A874D1401FC", hash_generated_method = "A932AABF0DE153C2BDF3652CE90417A3")
	@Override
	public ByteBuffer put(byte b) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.944 -0400", hash_original_method = "3C5952D8FAADE293E2AA7CAEA3FBDFDE", hash_generated_method = "96F0CDBCB30B153A5E85C990445D020B")
	@Override
	public ByteBuffer put(int index, byte b) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.944 -0400", hash_original_method = "951D4EAC88501D9206E4E1A989B35D3E", hash_generated_method = "FDF56450842EBED47B98E414D691AC0C")
	@Override
	public ByteBuffer put(byte[] src, int srcOffset, int byteCount) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.945 -0400", hash_original_method = "A805DD85D5AD0B04A08295FCAF525294", hash_generated_method = "D70859699741A6891DCEA0F5409BEFC2")
	@Override
	public ByteBuffer putDouble(double value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.945 -0400", hash_original_method = "B21C449764944752357064F64E16A04C", hash_generated_method = "1C7A537CC802D3829D7FC4A928A62556")
	@Override
	public ByteBuffer putDouble(int index, double value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.946 -0400", hash_original_method = "0936EB19B88AD6A1540E67EF21842269", hash_generated_method = "7FBAE86B9FFB68D33B671BDD9D245E19")
	@Override
	public ByteBuffer putFloat(float value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.946 -0400", hash_original_method = "6EDCFEA9CE18908F355474CE24EE73F3", hash_generated_method = "0AFEFAA6FED13154E3C147AD9EB2A042")
	@Override
	public ByteBuffer putFloat(int index, float value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.946 -0400", hash_original_method = "6D4DC7AF194DC54CDF161D65F1FDDEA8", hash_generated_method = "CB96D7D28156A59A32CFEB7A913328E7")
	@Override
	public ByteBuffer putInt(int value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.947 -0400", hash_original_method = "596A6D4589A1478BD0E76A52D09F2DF6", hash_generated_method = "A16FBFAB90E8A7D3AA329600BBB1BBF6")
	@Override
	public ByteBuffer putInt(int index, int value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.947 -0400", hash_original_method = "6CDC02834F940A2320A4AB5E7F512207", hash_generated_method = "801A42EFD5AB018EC4D38A73586C4D6D")
	@Override
	public ByteBuffer putLong(int index, long value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.948 -0400", hash_original_method = "4935387395F1528D3182F7E3202284B4", hash_generated_method = "4C2A2570CCABB47FB826876A8A454017")
	@Override
	public ByteBuffer putLong(long value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.948 -0400", hash_original_method = "3FFCBC2284BD734FFA5002B7F6F7C258", hash_generated_method = "0BF978FBE2613C05BA52A754063443D2")
	@Override
	public ByteBuffer putShort(int index, short value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.949 -0400", hash_original_method = "1212B9E4C2EAD5C33D73EC873813CB4B", hash_generated_method = "415AD4B6ED60213B12BB212CE2906F94")
	@Override
	public ByteBuffer putShort(short value) {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.949 -0400", hash_original_method = "927CD040BA02D17CD9D13CDD471B3CCF", hash_generated_method = "3C60D238D34B91E8F4288E5C1E8E295A")
	@Override
	public ByteBuffer put(ByteBuffer buf) {
		throw new ReadOnlyBufferException();

		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.949 -0400", hash_original_method = "6FE9FDD30B055D5D0C17F2FBAA978884", hash_generated_method = "AFAFCAE41D901DB25CB5B6C56556115F")
	@Override
	public ByteBuffer slice() {
		ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1185840022 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_1185840022 = new ReadOnlyHeapByteBuffer(backingArray, remaining(), offset + position);
		varB4EAC82CA7396A68D541C85D26508E83_1185840022.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1185840022;
		
		
		
	}

}
