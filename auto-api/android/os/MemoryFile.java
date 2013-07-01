package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MemoryFile {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.474 -0400", hash_original_field = "651CEF29F37C9F53091FD6A9046D9F00", hash_generated_field = "472902F3844A9738091A7090C080AB6E")
	private FileDescriptor mFD;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.474 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")
	private int mAddress;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.474 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")
	private int mLength;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.474 -0400", hash_original_field = "D56569F1BD1DB3D7FF8A7B1E40755DF0", hash_generated_field = "7D003ADAD6B352F39344F33BE33DE0E3")
	private boolean mAllowPurging = false;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.474 -0400", hash_original_method = "DB289001A1CA8608ADAAFD372FAC3009", hash_generated_method = "9F1420795173186650A51F7155E52B33")
	public MemoryFile(String name, int length) throws IOException {
		mLength = length;
		mFD = native_open(name, length);
		{
			mAddress = native_mmap(mFD, length, PROT_READ | PROT_WRITE);
		} // End block
		{
			mAddress = 0;
		} // End block
			// ---------- Original Method ----------
			// mLength = length;
			// mFD = native_open(name, length);
			// if (length > 0) {
			// mAddress = native_mmap(mFD, length, PROT_READ | PROT_WRITE);
		// } else {
		// mAddress = 0;
		// }
	}

	private static FileDescriptor native_open(String name, int length) throws IOException {
		return new FileDescriptor();
	}

	private static int native_mmap(FileDescriptor fd, int length, int mode) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437101719 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437101719;
	}

	private static void native_munmap(int addr, int length) throws IOException {
	}

	private static void native_close(FileDescriptor fd) {
	}

	private static int native_read(FileDescriptor fd, int address, byte[] buffer, int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563409879 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563409879;
	}

	private static void native_write(FileDescriptor fd, int address, byte[] buffer, int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
	}

	private static void native_pin(FileDescriptor fd, boolean pin) throws IOException {
	}

	private static int native_get_size(FileDescriptor fd) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962429955 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962429955;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.476 -0400", hash_original_method = "DD734A9458D0580E341A373C2DD4F619", hash_generated_method = "B125B21C7E297744B04651E816F707B9")
	public void close() {
		deactivate();
		{
			boolean var87E69C193F176802B13B2F1C81F5377B_993408477 = (!isClosed());
			{
				native_close(mFD);
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// deactivate();
			// if (!isClosed()) {
			// native_close(mFD);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.476 -0400", hash_original_method = "08DA91581CCCF703195AD89F50B4F4A1", hash_generated_method = "2B2CAEDDFDA198E2866BDBCBBFAB5D42")
	void deactivate() {
		{
			boolean var941F9BDB19A5D518067C6257AB508A03_20335744 = (!isDeactivated());
			{
				try {
					native_munmap(mAddress, mLength);
					mAddress = 0;
				} // End block
				catch (IOException ex) {
				}
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// if (!isDeactivated()) {
			// try {
			// native_munmap(mAddress, mLength);
			// mAddress = 0;
		// } catch (IOException ex) {
		// Log.e(TAG, ex.toString());
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.477 -0400", hash_original_method = "6DDBFC199C19310599F0713304591847", hash_generated_method = "C74E3B600761E7B1EFE27692DF37CAD4")
	private boolean isDeactivated() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153815136 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153815136;
		// ---------- Original Method ----------
		// return mAddress == 0;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.477 -0400", hash_original_method = "3246A0B1468E43E22E475A6EAB25C98D", hash_generated_method = "1434DDD1F5EB9BBA9D0832C691C16013")
	private boolean isClosed() {
		boolean varFA3F4C45AF333D629D1394D6A839E3C9_14685681 = (!mFD.valid());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468816025 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468816025;
		// ---------- Original Method ----------
		// return !mFD.valid();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.478 -0400", hash_original_method = "41074FB4CF57E698C714BECD1DB74DD1", hash_generated_method = "1BBA6E064359ABB9F4D84BFAB2E9EB48")
	@Override
	protected void finalize() {
		{
			boolean var87E69C193F176802B13B2F1C81F5377B_234830999 = (!isClosed());
			{
				close();
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// if (!isClosed()) {
			// Log.e(TAG,
			// "MemoryFile.finalize() called while ashmem still open");
			// close();
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.478 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "95E92E37CC542BE224FF7663FE62E06D")
	public int length() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151650476 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1151650476;
		// ---------- Original Method ----------
		// return mLength;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.479 -0400", hash_original_method = "36BC15D120E9C0B3759A6273F0B6F394", hash_generated_method = "97936AFEF6AA92CD571A05C22FA94B4E")
	public boolean isPurgingAllowed() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522151635 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_522151635;
		// ---------- Original Method ----------
		// return mAllowPurging;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.479 -0400", hash_original_method = "4E65A3A585AE016FD322D2CFB53AD9E7", hash_generated_method = "F2EE4E8B42FAC200D593A3E7730D0E2E")
	synchronized public boolean allowPurging(boolean allowPurging) throws IOException {
		boolean oldValue = mAllowPurging;
		{
			native_pin(mFD, !allowPurging);
			mAllowPurging = allowPurging;
		} // End block
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221790048 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_221790048;
		// ---------- Original Method ----------
		// boolean oldValue = mAllowPurging;
		// if (oldValue != allowPurging) {
		// native_pin(mFD, !allowPurging);
		// mAllowPurging = allowPurging;
		// }
		// return oldValue;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.480 -0400", hash_original_method = "1F9A300CE55BE9E69C06FFD4C6B98E29", hash_generated_method = "9FCB63A4A9B400D2F00E9C57091AD7B8")
	public InputStream getInputStream() {
		InputStream varB4EAC82CA7396A68D541C85D26508E83_1978968768 = null; // Variable
																			// for
																			// return
																			// #1
		varB4EAC82CA7396A68D541C85D26508E83_1978968768 = new MemoryInputStream();
		varB4EAC82CA7396A68D541C85D26508E83_1978968768.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1978968768;
		// ---------- Original Method ----------
		// return new MemoryInputStream();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.480 -0400", hash_original_method = "0A8C4757301CE72EF10D99AE7CF53794", hash_generated_method = "204FA8AB06257F713FB1543E124AB0D4")
	public OutputStream getOutputStream() {
		OutputStream varB4EAC82CA7396A68D541C85D26508E83_2114032971 = null; // Variable
																			// for
																			// return
																			// #1
		varB4EAC82CA7396A68D541C85D26508E83_2114032971 = new MemoryOutputStream();
		varB4EAC82CA7396A68D541C85D26508E83_2114032971.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_2114032971;
		// ---------- Original Method ----------
		// return new MemoryOutputStream();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.481 -0400", hash_original_method = "E94CD8A455128D534B69DAAECC501B12", hash_generated_method = "C6D8CFB050B0D57796E10DB69866EFF5")
	public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
		{
			boolean var69AE6633AAE7BF7BCBFA61A26FCE0675_573550986 = (isDeactivated());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IOException("Can't read from deactivated memory file.");
			} // End block
		} // End collapsed parenthetic
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IndexOutOfBoundsException();
		} // End block
		int varBC098400FC4EDE9D23C50CE46391CB5B_275797605 = (native_read(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging));
		addTaint(buffer[0]);
		addTaint(srcOffset);
		addTaint(destOffset);
		addTaint(count);
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575036041 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575036041;
		// ---------- Original Method ----------
		// if (isDeactivated()) {
		// throw new IOException("Can't read from deactivated memory file.");
		// }
		// if (destOffset < 0 || destOffset > buffer.length || count < 0
		// || count > buffer.length - destOffset
		// || srcOffset < 0 || srcOffset > mLength
		// || count > mLength - srcOffset) {
		// throw new IndexOutOfBoundsException();
		// }
		// return native_read(mFD, mAddress, buffer, srcOffset, destOffset,
		// count, mAllowPurging);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.481 -0400", hash_original_method = "6737AABC2F88EDB7F71CE587CF7F9739", hash_generated_method = "BAC20DC8F636D87FB92478233752B9D2")
	public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
		{
			boolean var69AE6633AAE7BF7BCBFA61A26FCE0675_194650585 = (isDeactivated());
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IOException("Can't write to deactivated memory file.");
			} // End block
		} // End collapsed parenthetic
		{
			if (DroidSafeAndroidRuntime.control)
				throw new IndexOutOfBoundsException();
		} // End block
		native_write(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging);
		addTaint(buffer[0]);
		addTaint(srcOffset);
		addTaint(destOffset);
		addTaint(count);
		// ---------- Original Method ----------
		// if (isDeactivated()) {
		// throw new IOException("Can't write to deactivated memory file.");
		// }
		// if (srcOffset < 0 || srcOffset > buffer.length || count < 0
		// || count > buffer.length - srcOffset
		// || destOffset < 0 || destOffset > mLength
		// || count > mLength - destOffset) {
		// throw new IndexOutOfBoundsException();
		// }
		// native_write(mFD, mAddress, buffer, srcOffset, destOffset, count,
		// mAllowPurging);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.482 -0400", hash_original_method = "2D6523548F3A6408618EC64E9280F841", hash_generated_method = "9B9AC70C8126792768D44A323C78B3BA")
	public FileDescriptor getFileDescriptor() throws IOException {
		FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1817813123 = null; // Variable
																				// for
																				// return
																				// #1
		varB4EAC82CA7396A68D541C85D26508E83_1817813123 = mFD;
		varB4EAC82CA7396A68D541C85D26508E83_1817813123.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1817813123;
		// ---------- Original Method ----------
		// return mFD;
	}

	public static int getSize(FileDescriptor fd) throws IOException {
		return native_get_size(fd);
	}

	private class MemoryInputStream extends InputStream {
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.482 -0400", hash_original_field = "347231F94AB7C260D952FF25D7F7F6C4", hash_generated_field = "1CE465393F7752DBE05602CD816C716E")
		private int mMark = 0;
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.482 -0400", hash_original_field = "7870015E19539D5B7C0F8E6D8A862618", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")
		private int mOffset = 0;
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.482 -0400", hash_original_field = "9893382187B6BE4A813F3C19CC69B8AF", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")
		private byte[] mSingleByte;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.482 -0400", hash_original_method = "8819C64327DEAF910328E1B34E1904BC", hash_generated_method = "8819C64327DEAF910328E1B34E1904BC")
		public MemoryInputStream() {
			// Synthesized constructor
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.483 -0400", hash_original_method = "C946C15ECBD8592757BE5150DF65639B", hash_generated_method = "F7A893A570C5839F81A869939BAB1CB2")
		@Override
		public int available() throws IOException {
			int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899350901 = getTaintInt();
			return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899350901;
			// ---------- Original Method ----------
			// if (mOffset >= mLength) {
			// return 0;
			// }
			// return mLength - mOffset;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.483 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "451A179FED5C23535E8470FCC117D8AE")
		@Override
		public boolean markSupported() {
			boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_203256060 = getTaintBoolean();
			return var84E2C64F38F78BA3EA5C905AB5A2DA27_203256060;
			// ---------- Original Method ----------
			// return true;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.483 -0400", hash_original_method = "D9C9FB514524CC537FCE6FACAF9A295C", hash_generated_method = "AF5321611A336F9FC05FFEE23E084B6E")
		@Override
		public void mark(int readlimit) {
			mMark = mOffset;
			addTaint(readlimit);
			// ---------- Original Method ----------
			// mMark = mOffset;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.484 -0400", hash_original_method = "35916CEFACB2EEB27C627D30B06B91CE", hash_generated_method = "51C43F06C3033D3370FC41BB3D926B97")
		@Override
		public void reset() throws IOException {
			mOffset = mMark;
			// ---------- Original Method ----------
			// mOffset = mMark;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.484 -0400", hash_original_method = "A1D8D948EA118F9A15401118B0635D27", hash_generated_method = "9084E885D4989E3EBE3CAD53A652E479")
		@Override
		public int read() throws IOException {
			{
				mSingleByte = new byte[1];
			} // End block
			int result = read(mSingleByte, 0, 1);
			int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26772329 = getTaintInt();
			return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26772329;
			// ---------- Original Method ----------
			// if (mSingleByte == null) {
			// mSingleByte = new byte[1];
			// }
			// int result = read(mSingleByte, 0, 1);
			// if (result != 1) {
			// return -1;
			// }
			// return mSingleByte[0];
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.484 -0400", hash_original_method = "BFF461741A45AAAD780835BEF712AE09", hash_generated_method = "722E08441396EA5E3C62B1D4DD57FBE3")
		@Override
		public int read(byte buffer[], int offset, int count) throws IOException {
			{
				if (DroidSafeAndroidRuntime.control)
					throw new IndexOutOfBoundsException();
			} // End block
			count = Math.min(count, available());
			int result = readBytes(buffer, mOffset, offset, count);
			{
				mOffset += result;
			} // End block
			addTaint(buffer[0]);
			addTaint(offset);
			addTaint(count);
			int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360813533 = getTaintInt();
			return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360813533;
			// ---------- Original Method ----------
			// if (offset < 0 || count < 0 || offset + count > buffer.length) {
			// throw new IndexOutOfBoundsException();
			// }
			// count = Math.min(count, available());
			// if (count < 1) {
			// return -1;
			// }
			// int result = readBytes(buffer, mOffset, offset, count);
			// if (result > 0) {
			// mOffset += result;
			// }
			// return result;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.485 -0400", hash_original_method = "9D84182613F8631FDE5947AEAB012BC6", hash_generated_method = "F108AEBEF7B046B114486B3CD8C2D95C")
		@Override
		public long skip(long n) throws IOException {
			{
				n = mLength - mOffset;
			} // End block
			mOffset += n;
			long var0F5264038205EDFB1AC05FBB0E8C5E94_989559986 = getTaintLong();
			return var0F5264038205EDFB1AC05FBB0E8C5E94_989559986;
			// ---------- Original Method ----------
			// if (mOffset + n > mLength) {
			// n = mLength - mOffset;
			// }
			// mOffset += n;
			// return n;
		}

	}

	private class MemoryOutputStream extends OutputStream {
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.485 -0400", hash_original_field = "7870015E19539D5B7C0F8E6D8A862618", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")
		private int mOffset = 0;
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.485 -0400", hash_original_field = "9893382187B6BE4A813F3C19CC69B8AF", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")
		private byte[] mSingleByte;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.485 -0400", hash_original_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB", hash_generated_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB")
		public MemoryOutputStream() {
			// Synthesized constructor
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.485 -0400", hash_original_method = "E169D47904A982CBC090A3E5EE81FFA1", hash_generated_method = "FCA21DCA875BE6BCAD8D24CA428191CC")
		@Override
		public void write(byte buffer[], int offset, int count) throws IOException {
			writeBytes(buffer, offset, mOffset, count);
			mOffset += count;
			addTaint(buffer[0]);
			addTaint(offset);
			// ---------- Original Method ----------
			// writeBytes(buffer, offset, mOffset, count);
			// mOffset += count;
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.486 -0400", hash_original_method = "873021528A0C471EBDB778DCC5A89FEF", hash_generated_method = "2C99C99CEE6FD721A4133C5DC1E17E10")
		@Override
		public void write(int oneByte) throws IOException {
			{
				mSingleByte = new byte[1];
			} // End block
			mSingleByte[0] = (byte) oneByte;
			write(mSingleByte, 0, 1);
			// ---------- Original Method ----------
			// if (mSingleByte == null) {
			// mSingleByte = new byte[1];
			// }
			// mSingleByte[0] = (byte)oneByte;
			// write(mSingleByte, 0, 1);
		}

	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.486 -0400", hash_original_field = "3081A19470620560723AFCCFD231D233", hash_generated_field = "5D3F94A828767D0FA960A9A7B583EDC1")
	private static String TAG = "MemoryFile";
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.486 -0400", hash_original_field = "8485B64C5FEEDD71B9F0C2B303033EAA", hash_generated_field = "266C128FB04586E6755B38B52173946D")
	private static final int PROT_READ = 0x1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.486 -0400", hash_original_field = "4AC8997208999500EC0C56E354EE8162", hash_generated_field = "BDAF7D4E803BF7BEA3AAAA94A46AE56A")
	private static final int PROT_WRITE = 0x2;
}
