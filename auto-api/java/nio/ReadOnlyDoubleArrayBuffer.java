package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadOnlyDoubleArrayBuffer extends DoubleArrayBuffer {

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.905 -0400", hash_original_method = "3FFC117F0906E795E350A76B08676C14", hash_generated_method = "4AC7A4214CE2689D43A9E5A40E330204")
	ReadOnlyDoubleArrayBuffer(int capacity, double[] backingArray, int arrayOffset) {
		super(capacity, backingArray, arrayOffset);
		addTaint(capacity);
		addTaint(backingArray[0]);
		addTaint(arrayOffset);
		
	}

	@DSModeled(DSC.SAFE)
    static ReadOnlyDoubleArrayBuffer copy(DoubleArrayBuffer other, int markOfOther) {
		ReadOnlyDoubleArrayBuffer buf = new ReadOnlyDoubleArrayBuffer(other.capacity(), other.backingArray, other.offset);
		buf.limit = other.limit;
		buf.position = other.position();
		buf.mark = markOfOther;
		return buf;
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.907 -0400", hash_original_method = "D0795F45904A3274E0D7958444D9D8FF", hash_generated_method = "7101A3D53CB487C1D10B095020B03502")
	@Override
	public DoubleBuffer asReadOnlyBuffer() {
		DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_1308490956 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_1308490956 = duplicate();
		varB4EAC82CA7396A68D541C85D26508E83_1308490956.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1308490956;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.908 -0400", hash_original_method = "CD5EB2CF4409DC8F2ECB88FE902C9443", hash_generated_method = "B7B6949530B843CAC56ED08A96607A4D")
	@Override
	public DoubleBuffer compact() {
		throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.909 -0400", hash_original_method = "BCF332FB26078E1D870C2E24915718AE", hash_generated_method = "4AB71E81B008920784F86C585B06EE93")
	@Override
	public DoubleBuffer duplicate() {
		DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_2042601018 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_2042601018 = copy(this, mark);
		varB4EAC82CA7396A68D541C85D26508E83_2042601018.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_2042601018;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.911 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "1FD3DB8E45181B6F69DAF45C660A3B9B")
	@Override
	public boolean isReadOnly() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822433220 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_822433220;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.912 -0400", hash_original_method = "76BCA3BE19863C28A8D1735E632EB441", hash_generated_method = "FE27C791E245470999F8A212FC12A5E5")
	@Override
	protected double[] protectedArray() {
		if (DroidSafeAndroidRuntime.control)
			throw new ReadOnlyBufferException();
		double[] var74D44D7D9EE6FE6C3433D694F869E521_1541311008 = { getTaintDouble() };
		return var74D44D7D9EE6FE6C3433D694F869E521_1541311008;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.912 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "723DAD9B7B7D221024495FA13B760B6C")
	@Override
	protected int protectedArrayOffset() {
		if (DroidSafeAndroidRuntime.control)
			throw new ReadOnlyBufferException();
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471860804 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471860804;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.913 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "3E8264BC905A5D8A34DA54B6ACA457C8")
	@Override
	protected boolean protectedHasArray() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902291719 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_902291719;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.914 -0400", hash_original_method = "E5C4F08E8681AF4EC36C77A34D3981AA", hash_generated_method = "E1F74B0E5953E5238A127FA14A91B416")
	@Override
	public DoubleBuffer put(double c) {

			throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.914 -0400", hash_original_method = "FE1D1321B1031173065E240BA4BCC6BC", hash_generated_method = "BD0556756292DDFDA09ECAEA42440CCF")
	@Override
	public DoubleBuffer put(int index, double c) {

			throw new ReadOnlyBufferException();
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.915 -0400", hash_original_method = "817A5808CCAD86E249EA0880FB43BA43", hash_generated_method = "9551BF5C45E8866E8CEC1F30C2E78E1C")
	@Override
	public final DoubleBuffer put(double[] src, int srcOffset, int byteCount) {

			throw new ReadOnlyBufferException();
		
		
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.915 -0400", hash_original_method = "9B0D4970C825DBBBAE90A7583E6AACE4", hash_generated_method = "76B6A5374B6AE5A0CD574F3F2408582B")
	@Override
	public final DoubleBuffer put(DoubleBuffer buf) {

			throw new ReadOnlyBufferException();
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.916 -0400", hash_original_method = "CFD0B1420E5034874759174E514350BC", hash_generated_method = "DBD1C0DC4DA57893C6ADCDEB489EFA77")
	@Override
	public DoubleBuffer slice() {
		DoubleBuffer varB4EAC82CA7396A68D541C85D26508E83_776676669 = null; 
																			
																			
																			
		varB4EAC82CA7396A68D541C85D26508E83_776676669 = new ReadOnlyDoubleArrayBuffer(remaining(), backingArray, offset + position);
		varB4EAC82CA7396A68D541C85D26508E83_776676669.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_776676669;
		
		
		
	}

}
