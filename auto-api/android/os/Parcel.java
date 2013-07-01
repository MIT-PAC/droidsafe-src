package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Parcel {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.767 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "6861EF2C6719FB6BE9580A330103CA5F")
	@SuppressWarnings({ "UnusedDeclaration" })
	private int mObject;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.767 -0400", hash_original_field = "1E29C110658060053105607F6A69FCDF", hash_generated_field = "E2BD6B8F2FA33686C59551B5BF00B3B5")
	@SuppressWarnings({ "UnusedDeclaration" })
	private int mOwnObject;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.767 -0400", hash_original_field = "B1C29C43A1B3C1AF208A28E9F6889C94", hash_generated_field = "F06536DFCEF1B0A690687BA1BFE76D23")
	private RuntimeException mStack;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.768 -0400", hash_original_method = "96328320E65E9E5C73AE1A423ABA09C7", hash_generated_method = "FA39E9EC605AB9B220994F25AD2303F6")
	private Parcel(int obj) {
		{
			mStack = new RuntimeException();
		} // End block
		init(obj);
		addTaint(obj);
		// ---------- Original Method ----------
		// if (DEBUG_RECYCLE) {
		// mStack = new RuntimeException();
		// }
		// init(obj);
	}

	public static Parcel obtain() {
		final Parcel[] pool = sOwnedPool;
		synchronized (pool) {
			Parcel p;
			for (int i = 0; i < POOL_SIZE; i++) {
				p = pool[i];
				if (p != null) {
					pool[i] = null;
					if (DEBUG_RECYCLE) {
						p.mStack = new RuntimeException();
					}
					return p;
				}
			}
		}
		return new Parcel(0);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.768 -0400", hash_original_method = "0B6C271774CE05661982DF3B6AC078FF", hash_generated_method = "3C3824BFCF46D9EE19994792874A9D98")
	public final void recycle() {
		mStack = null;
		freeBuffer();
		Parcel[] pool;
		pool = sOwnedPool;
		pool = sHolderPool;
		{
			{
				int i = 0;
				{
					{
						pool[i] = this;
					} // End block
				} // End block
			} // End collapsed parenthetic
		} // End block
			// ---------- Original Method ----------
			// if (DEBUG_RECYCLE) mStack = null;
			// freeBuffer();
			// final Parcel[] pool = mOwnObject != 0 ? sOwnedPool : sHolderPool;
			// synchronized (pool) {
			// for (int i=0; i<POOL_SIZE; i++) {
			// if (pool[i] == null) {
			// pool[i] = this;
			// return;
		// }
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.769 -0400", hash_original_method = "DD534262B78755109918F5DCE98072D4", hash_generated_method = "B9F64836FAEBC9616826078463BDF310")
	public final int dataSize() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19316234 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_19316234;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.769 -0400", hash_original_method = "0316AB8FD0A1B068176256EC0E481A72", hash_generated_method = "FE15E6550F7B824D82B311A72518E5A3")
	public final int dataAvail() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072576661 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072576661;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.769 -0400", hash_original_method = "D1BE237E96D29A914DD3E05EDFD3F272", hash_generated_method = "F50049E04BB33D37E2C92A9087B27431")
	public final int dataPosition() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956438525 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956438525;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.769 -0400", hash_original_method = "51F0EF05154419C189F36E1902F5F7AB", hash_generated_method = "B42CDD36402B7D2304F390E325368B41")
	public final int dataCapacity() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788458049 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788458049;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.770 -0400", hash_original_method = "D8CB87D9AB1E01DFD8357CBF456AE1C5", hash_generated_method = "DBDC326A5AD13E4C052782BF36EE04CC")
	public final void setDataSize(int size) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.771 -0400", hash_original_method = "900D9C4DE4FE3C2709BAAFC39AA9B06F", hash_generated_method = "F3CD9D97BEE6A7C9B1EDA27A460B2114")
	public final void setDataPosition(int pos) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.771 -0400", hash_original_method = "E063261D5EA5083378CEC188A4B78FE0", hash_generated_method = "F1A8A9E75C383307D41FF1C854241F7F")
	public final void setDataCapacity(int size) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.771 -0400", hash_original_method = "97650A42F80764D7062D6C7A9EDB6E4B", hash_generated_method = "0C11C7E2FD68BE545925746032001136")
	public final boolean pushAllowFds(boolean allowFds) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39475348 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_39475348;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.772 -0400", hash_original_method = "D9541DA181394F49233EDC85EBA11372", hash_generated_method = "F726D88738028EDDB487D5C6B46AE462")
	public final void restoreAllowFds(boolean lastValue) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.772 -0400", hash_original_method = "203FAAB8CBC9466E61C8672BA6829403", hash_generated_method = "0DA9A900B08E3221A310807FC2205592")
	public final byte[] marshall() {
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1366153277 = { getTaintByte() };
		return var2F9C81BC6E497382285CD6B7A7E33DE1_1366153277;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.772 -0400", hash_original_method = "54EF2A5E543EFE1E280A4B6A4F3098CB", hash_generated_method = "9BFFC2D408472CD2885F9AA93E140122")
	public final void unmarshall(byte[] data, int offest, int length) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.773 -0400", hash_original_method = "E8A5DF9275FDA0D9B0B70C7334CB1E59", hash_generated_method = "06D0342998182488FBF1BB999A6534DB")
	public final void appendFrom(Parcel parcel, int offset, int length) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.773 -0400", hash_original_method = "A1C2B053FCB3ADAB79F2D704E198BAB1", hash_generated_method = "68820496D322AB6206EB7C2F66F76CD3")
	public final boolean hasFileDescriptors() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101016843 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101016843;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.773 -0400", hash_original_method = "EBD07D08BBA21F0C5B4E86C34DC5CAC1", hash_generated_method = "482712869E70BA49180853C184A16263")
	public final void writeInterfaceToken(String interfaceName) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.773 -0400", hash_original_method = "5F95BF99C2626C7B3640C2D1B3B7BEE7", hash_generated_method = "288CBAB1B96B3BD6C3E43589A43CAA3F")
	public final void enforceInterface(String interfaceName) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.774 -0400", hash_original_method = "6AA57281F567FED2151D4FF51C5ADD5D", hash_generated_method = "220C60356D70D7A283C931B346603A4A")
	public final void writeByteArray(byte[] b) {
		writeByteArray(b, 0, (b != null) ? b.length : 0);
		addTaint(b[0]);
		// ---------- Original Method ----------
		// writeByteArray(b, 0, (b != null) ? b.length : 0);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.774 -0400", hash_original_method = "292A0D9A6E9AD589E2915A38A2AF794D", hash_generated_method = "5914254446C5E9C25C64599B3132C419")
	public final void writeByteArray(byte[] b, int offset, int len) {
		{
			writeInt(-1);
		} // End block
		Arrays.checkOffsetAndCount(b.length, offset, len);
		writeNative(b, offset, len);
		addTaint(b[0]);
		addTaint(offset);
		addTaint(len);
		// ---------- Original Method ----------
		// if (b == null) {
		// writeInt(-1);
		// return;
		// }
		// Arrays.checkOffsetAndCount(b.length, offset, len);
		// writeNative(b, offset, len);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.774 -0400", hash_original_method = "13EF9FAE46E0DC273567B76840FE8431", hash_generated_method = "B7B1791B1819FAA4AC4DF261A54493B1")
	private void writeNative(byte[] b, int offset, int len) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.775 -0400", hash_original_method = "EB7F50F11C67DFE7362846314C368039", hash_generated_method = "BEE33504B34EACD5CA9D841430805B0B")
	public final void writeInt(int val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.775 -0400", hash_original_method = "6EE9E92592584E19EA2786245476EB1F", hash_generated_method = "0A06D5D9A178D52A875714A0E42A1A51")
	public final void writeLong(long val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.775 -0400", hash_original_method = "8E6A3106AB0C4A6CA5D134BC13C79A46", hash_generated_method = "1DF7BBEB8EFD1C1A257BF6B7DBAA6EE3")
	public final void writeFloat(float val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.775 -0400", hash_original_method = "580EB112F6684AC838EF0FAE39FE6143", hash_generated_method = "C77D5B12217694B3853A3DF91BCF81A4")
	public final void writeDouble(double val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.775 -0400", hash_original_method = "148FED92CD1AE4975AE2973407FF84B1", hash_generated_method = "8FFD4EB8B720B24188B168257146AA4B")
	public final void writeString(String val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.776 -0400", hash_original_method = "CEAF068B566AB67AE8F044276645F78A", hash_generated_method = "A2F25B64167993F48DA629A01FC4357A")
	public final void writeCharSequence(CharSequence val) {
		TextUtils.writeToParcel(val, this, 0);
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// TextUtils.writeToParcel(val, this, 0);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.776 -0400", hash_original_method = "7DA1E5E6DC1856828FF2B443CF2EA2D0", hash_generated_method = "0D95721DBACCC6601CFE11D2E34CD1FF")
	public final void writeStrongBinder(IBinder val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.776 -0400", hash_original_method = "D29D74B8509F3EDC680AC67A58B2AE11", hash_generated_method = "F7B8635B17AFAED7F650ABEB6D1734CF")
	public final void writeStrongInterface(IInterface val) {
		writeStrongBinder(val == null ? null : val.asBinder());
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// writeStrongBinder(val == null ? null : val.asBinder());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.776 -0400", hash_original_method = "F228581B9954F98E592DA68C1EE89409", hash_generated_method = "159C24B95EAD1045C52B3F0E4DD0B66A")
	public final void writeFileDescriptor(FileDescriptor val) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.777 -0400", hash_original_method = "B137ADD0EA125F15A647DF5EEF6060FE", hash_generated_method = "BB0303E6383EB2C6D21B8BBE98686C7B")
	public final void writeByte(byte val) {
		writeInt(val);
		addTaint(val);
		// ---------- Original Method ----------
		// writeInt(val);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.777 -0400", hash_original_method = "028C08B0E96835B592DD57E92E1A9654", hash_generated_method = "7CC3F53AC45D033B1436BAAAF054C373")
	public final void writeMap(Map val) {
		writeMapInternal((Map<String, Object>) val);
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// writeMapInternal((Map<String,Object>) val);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.783 -0400", hash_original_method = "254CF4BDBF55D33C4656934F15F7844A", hash_generated_method = "48605E73DD17BAB76B2CDA6A5B1B3719")
	void writeMapInternal(Map<String, Object> val) {
		{
			writeInt(-1);
		} // End block
		Set<Map.Entry<String, Object>> entries = val.entrySet();
		writeInt(entries.size());
		{
			Iterator<Map.Entry<String, Object>> var0067E06DB1A13B6A25DDEC4BA2402C0D_1744718492 = (entries).iterator();
			var0067E06DB1A13B6A25DDEC4BA2402C0D_1744718492.hasNext();
			Map.Entry<String, Object> e = var0067E06DB1A13B6A25DDEC4BA2402C0D_1744718492.next();
			{
				writeValue(e.getKey());
				writeValue(e.getValue());
			} // End block
		} // End collapsed parenthetic
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// Set<Map.Entry<String,Object>> entries = val.entrySet();
		// writeInt(entries.size());
		// for (Map.Entry<String,Object> e : entries) {
		// writeValue(e.getKey());
		// writeValue(e.getValue());
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.784 -0400", hash_original_method = "1B271C6B96886293B3F46C86D8594D62", hash_generated_method = "2FFA68CA9C86DB44455DF2AE49798B9A")
	public final void writeBundle(Bundle val) {
		{
			writeInt(-1);
		} // End block
		val.writeToParcel(this, 0);
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// val.writeToParcel(this, 0);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.784 -0400", hash_original_method = "E7219AA1C86EB1036E36A514DFF44066", hash_generated_method = "F2B07749CC535A3460F31E6B1ED70783")
	public final void writeList(List val) {
		{
			writeInt(-1);
		} // End block
		int N = val.size();
		int i = 0;
		writeInt(N);
		{
			writeValue(val.get(i));
		} // End block
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.size();
		// int i=0;
		// writeInt(N);
		// while (i < N) {
		// writeValue(val.get(i));
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.785 -0400", hash_original_method = "903390B15749D4F099959DBD9D939641", hash_generated_method = "1866C6133F4A985007521467365A1F4B")
	public final void writeArray(Object[] val) {
		{
			writeInt(-1);
		} // End block
		int N = val.length;
		int i = 0;
		writeInt(N);
		{
			writeValue(val[i]);
		} // End block
		addTaint(val[0].getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.length;
		// int i=0;
		// writeInt(N);
		// while (i < N) {
		// writeValue(val[i]);
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.785 -0400", hash_original_method = "932B15FDC26AECB59BA0DEB9D7727076", hash_generated_method = "B7500221DB1CDEA1D80F330EC6626D58")
	public final void writeSparseArray(SparseArray<Object> val) {
		{
			writeInt(-1);
		} // End block
		int N = val.size();
		writeInt(N);
		int i = 0;
		{
			writeInt(val.keyAt(i));
			writeValue(val.valueAt(i));
		} // End block
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.size();
		// writeInt(N);
		// int i=0;
		// while (i < N) {
		// writeInt(val.keyAt(i));
		// writeValue(val.valueAt(i));
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.786 -0400", hash_original_method = "501AACE22AB4AEC41E440B95E2BF337F", hash_generated_method = "05E140D393E45CA21F55EF2481201B6F")
	public final void writeSparseBooleanArray(SparseBooleanArray val) {
		{
			writeInt(-1);
		} // End block
		int N = val.size();
		writeInt(N);
		int i = 0;
		{
			writeInt(val.keyAt(i));
			writeByte((byte) (val.valueAt(i) ? 1 : 0));
		} // End block
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.size();
		// writeInt(N);
		// int i=0;
		// while (i < N) {
		// writeInt(val.keyAt(i));
		// writeByte((byte)(val.valueAt(i) ? 1 : 0));
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.786 -0400", hash_original_method = "D75DEF1EB05EA54B4B0A6C775E789115", hash_generated_method = "2A98AB1564AEE07F88C034175A77E96E")
	public final void writeBooleanArray(boolean[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeInt(val[i] ? 1 : 0);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeInt(val[i] ? 1 : 0);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.787 -0400", hash_original_method = "636C08B3912226F5C58D74422D1E9CB4", hash_generated_method = "CFE2562568E880AE20655FB43FE9876D")
	public final boolean[] createBooleanArray() {
		int N = readInt();
		{
			boolean var677D811DE399D0DE094E279FE647ADA9_1980696915 = (N >= 0 && N <= (dataAvail() >> 2));
			{
				boolean[] val = new boolean[N];
				{
					int i = 0;
					{
						val[i] = readInt() != 0;
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		boolean[] var503EB2F420079C4024483971CE5EDEA8_381550882 = { getTaintBoolean() };
		return var503EB2F420079C4024483971CE5EDEA8_381550882;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0 && N <= (dataAvail() >> 2)) {
		// boolean[] val = new boolean[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readInt() != 0;
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.787 -0400", hash_original_method = "15202BE45A888A7FAE449643C1F651D3", hash_generated_method = "5803D4E8BE7505BB9B451A8D8EC62400")
	public final void readBooleanArray(boolean[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readInt() != 0;
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readInt() != 0;
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.788 -0400", hash_original_method = "FC1109029B4BAAFE0FA31EEEF8F95A5F", hash_generated_method = "A0FAF98D19F74F9A4DB926ED5CAB75BB")
	public final void writeCharArray(char[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeInt((int) val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeInt((int)val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.788 -0400", hash_original_method = "0F2CB9A0B4BA672805C5DC7ABC31D142", hash_generated_method = "D369B6E003C7E46DADA02F2A079B2F95")
	public final char[] createCharArray() {
		int N = readInt();
		{
			boolean var677D811DE399D0DE094E279FE647ADA9_794729550 = (N >= 0 && N <= (dataAvail() >> 2));
			{
				char[] val = new char[N];
				{
					int i = 0;
					{
						val[i] = (char) readInt();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		char[] var50607924ABD4C17119BAF3A1CE41C0EC_1874004234 = { getTaintChar() };
		return var50607924ABD4C17119BAF3A1CE41C0EC_1874004234;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0 && N <= (dataAvail() >> 2)) {
		// char[] val = new char[N];
		// for (int i=0; i<N; i++) {
		// val[i] = (char)readInt();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.792 -0400", hash_original_method = "3577ABA10B4218BCCE6B69B6327658D6", hash_generated_method = "EE4F00CE6CD4A38BC02AEFC0749867AB")
	public final void readCharArray(char[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = (char) readInt();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = (char)readInt();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.793 -0400", hash_original_method = "426B3599371B897BFC6196C71A9C351C", hash_generated_method = "E793B7204395593C9A6EF1178F89021F")
	public final void writeIntArray(int[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeInt(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeInt(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.793 -0400", hash_original_method = "2BFE53BE4AFBC39913D7CD537675C77F", hash_generated_method = "B05D5C429315FA7591E0C99BCEBB51A5")
	public final int[] createIntArray() {
		int N = readInt();
		{
			boolean var677D811DE399D0DE094E279FE647ADA9_1373906420 = (N >= 0 && N <= (dataAvail() >> 2));
			{
				int[] val = new int[N];
				{
					int i = 0;
					{
						val[i] = readInt();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		int[] varB4CCCA26F9DB9189C32F33E82D425CFB_379556173 = { getTaintInt() };
		return varB4CCCA26F9DB9189C32F33E82D425CFB_379556173;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0 && N <= (dataAvail() >> 2)) {
		// int[] val = new int[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readInt();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.794 -0400", hash_original_method = "D30E6FBEFEE072DBADEACBC994232724", hash_generated_method = "B3FA7DF2E6B343C2554B2B79F98A3259")
	public final void readIntArray(int[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readInt();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readInt();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.794 -0400", hash_original_method = "6AE17F1911C710D67F0B38E1A6953312", hash_generated_method = "4005DCC97220EAD3B2E1E1CF04E52441")
	public final void writeLongArray(long[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeLong(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeLong(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.795 -0400", hash_original_method = "539AEF1878CDD8393DEC7B15A779334D", hash_generated_method = "CAA64DEDFF976366C7F1A0831FF029E1")
	public final long[] createLongArray() {
		int N = readInt();
		{
			boolean varAFA9B411100B0C263F15734A2739C902_1648663756 = (N >= 0 && N <= (dataAvail() >> 3));
			{
				long[] val = new long[N];
				{
					int i = 0;
					{
						val[i] = readLong();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1530835055 = { getTaintLong() };
		return var3908C7C3AF5171CEE1F112DAE77A5C4D_1530835055;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0 && N <= (dataAvail() >> 3)) {
		// long[] val = new long[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readLong();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.796 -0400", hash_original_method = "EB1FE051AE6270C29877E320D05D2B1C", hash_generated_method = "D7AE615F993C394509D6C43F404A7099")
	public final void readLongArray(long[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readLong();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readLong();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.797 -0400", hash_original_method = "914127CC1FF235613675A4097238AE87", hash_generated_method = "2EBC9A3CADCE45D0DF59082FD6380DCB")
	public final void writeFloatArray(float[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeFloat(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeFloat(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.798 -0400", hash_original_method = "AD11D1594D734C1EBF478FFED3A5EA0B", hash_generated_method = "FDBA09860B48ED0DD8FE8A979F7AFC35")
	public final float[] createFloatArray() {
		int N = readInt();
		{
			boolean var677D811DE399D0DE094E279FE647ADA9_677426217 = (N >= 0 && N <= (dataAvail() >> 2));
			{
				float[] val = new float[N];
				{
					int i = 0;
					{
						val[i] = readFloat();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		float[] varB2C245003BAB9224CFB496218F7DAFE0_58190586 = { getTaintFloat() };
		return varB2C245003BAB9224CFB496218F7DAFE0_58190586;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0 && N <= (dataAvail() >> 2)) {
		// float[] val = new float[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readFloat();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.799 -0400", hash_original_method = "5BAAFA2155FE07D9BA992B0E92A02429", hash_generated_method = "1B11D9AABA6F5E20364E4383C4CCD9A3")
	public final void readFloatArray(float[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readFloat();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readFloat();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.799 -0400", hash_original_method = "30BB607A5C46B583A0E7A88D0830BB99", hash_generated_method = "7AAC9AACC8F6C87826416D94CCC7F76C")
	public final void writeDoubleArray(double[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeDouble(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeDouble(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.800 -0400", hash_original_method = "EADE9932A44C79075558F2C2E2C44BF9", hash_generated_method = "D7EE82085928B40F498B991358F64D94")
	public final double[] createDoubleArray() {
		int N = readInt();
		{
			boolean varAFA9B411100B0C263F15734A2739C902_730952513 = (N >= 0 && N <= (dataAvail() >> 3));
			{
				double[] val = new double[N];
				{
					int i = 0;
					{
						val[i] = readDouble();
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		double[] var74D44D7D9EE6FE6C3433D694F869E521_1169933129 = { getTaintDouble() };
		return var74D44D7D9EE6FE6C3433D694F869E521_1169933129;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0 && N <= (dataAvail() >> 3)) {
		// double[] val = new double[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readDouble();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.800 -0400", hash_original_method = "1E5CFF0988982B6DD3E5010F6E58EAB2", hash_generated_method = "6FF3C4079675C059AA99C82A4F3A1D5D")
	public final void readDoubleArray(double[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readDouble();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readDouble();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.800 -0400", hash_original_method = "869784FDBD7A62BA6DC61589E5325593", hash_generated_method = "8C626EA11D1D9510398CF8E8EED8F580")
	public final void writeStringArray(String[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeString(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0].getTaint());
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeString(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.801 -0400", hash_original_method = "E25A6435806EEE9817C8F94878902077", hash_generated_method = "7EA9293E08FED213649E39111380344D")
	public final String[] createStringArray() {
		String[] varB4EAC82CA7396A68D541C85D26508E83_76913018 = null; // Variable
																		// for
																		// return
																		// #1
		String[] varB4EAC82CA7396A68D541C85D26508E83_1694210913 = null; // Variable
																		// for
																		// return
																		// #2
		int N = readInt();
		{
			String[] val = new String[N];
			{
				int i = 0;
				{
					val[i] = readString();
				} // End block
			} // End collapsed parenthetic
			varB4EAC82CA7396A68D541C85D26508E83_76913018 = val;
		} // End block
		{
			varB4EAC82CA7396A68D541C85D26508E83_1694210913 = null;
		} // End block
		String[] varA7E53CE21691AB073D9660D615818899_1523032269; // Final return
																	// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1523032269 = varB4EAC82CA7396A68D541C85D26508E83_76913018;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1523032269 = varB4EAC82CA7396A68D541C85D26508E83_1694210913;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1523032269.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1523032269;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0) {
		// String[] val = new String[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readString();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.801 -0400", hash_original_method = "856C598346084C5A7CB0C8EC3C30AFE8", hash_generated_method = "D69FCB1A188A39A54E5D49E779FBE02B")
	public final void readStringArray(String[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readString();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0].getTaint());
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readString();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.802 -0400", hash_original_method = "EF4C8799E7CA7F11199E2A94E26473B3", hash_generated_method = "F00FFDCA7721A21132A90A2999F5EEA7")
	public final void writeBinderArray(IBinder[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeStrongBinder(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0].getTaint());
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeStrongBinder(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.802 -0400", hash_original_method = "47477B6B20C2841826851A1DC451409B", hash_generated_method = "0B0BDCD7A074B6BE282A86A509D1E76B")
	public final void writeCharSequenceArray(CharSequence[] val) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeCharSequence(val[i]);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0].getTaint());
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeCharSequence(val[i]);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.803 -0400", hash_original_method = "4DE08401A529CB5616CDC9DFD50DAFB3", hash_generated_method = "5EA3B5F2C2F5358E07C6770D8AC34139")
	public final IBinder[] createBinderArray() {
		IBinder[] varB4EAC82CA7396A68D541C85D26508E83_1880544796 = null; // Variable
																			// for
																			// return
																			// #1
		IBinder[] varB4EAC82CA7396A68D541C85D26508E83_2061088831 = null; // Variable
																			// for
																			// return
																			// #2
		int N = readInt();
		{
			IBinder[] val = new IBinder[N];
			{
				int i = 0;
				{
					val[i] = readStrongBinder();
				} // End block
			} // End collapsed parenthetic
			varB4EAC82CA7396A68D541C85D26508E83_1880544796 = val;
		} // End block
		{
			varB4EAC82CA7396A68D541C85D26508E83_2061088831 = null;
		} // End block
		IBinder[] varA7E53CE21691AB073D9660D615818899_1147832672; // Final
																	// return
																	// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1147832672 = varB4EAC82CA7396A68D541C85D26508E83_1880544796;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1147832672 = varB4EAC82CA7396A68D541C85D26508E83_2061088831;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1147832672.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1147832672;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N >= 0) {
		// IBinder[] val = new IBinder[N];
		// for (int i=0; i<N; i++) {
		// val[i] = readStrongBinder();
		// }
		// return val;
		// } else {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.804 -0400", hash_original_method = "3E3D11ECAF89B0D6B7212074DA0FB112", hash_generated_method = "CDF75625FA6605B8478A5C034D404B4D")
	public final void readBinderArray(IBinder[] val) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					val[i] = readStrongBinder();
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0].getTaint());
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// val[i] = readStrongBinder();
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.805 -0400", hash_original_method = "5826C07CBD3614FC61FFE172F3E36C59", hash_generated_method = "5B7E13C104D8AA9BCF0E1B40898B0CAA")
	public final <T extends Parcelable> void writeTypedList(List<T> val) {
		{
			writeInt(-1);
		} // End block
		int N = val.size();
		int i = 0;
		writeInt(N);
		{
			T item = val.get(i);
			{
				writeInt(1);
				item.writeToParcel(this, 0);
			} // End block
			{
				writeInt(0);
			} // End block
		} // End block
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.size();
		// int i=0;
		// writeInt(N);
		// while (i < N) {
		// T item = val.get(i);
		// if (item != null) {
		// writeInt(1);
		// item.writeToParcel(this, 0);
		// } else {
		// writeInt(0);
		// }
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.805 -0400", hash_original_method = "D0AECB36946CE861852315E400637CFF", hash_generated_method = "4A3E1D0692F22D30B3CC1F79B6075600")
	public final void writeStringList(List<String> val) {
		{
			writeInt(-1);
		} // End block
		int N = val.size();
		int i = 0;
		writeInt(N);
		{
			writeString(val.get(i));
		} // End block
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.size();
		// int i=0;
		// writeInt(N);
		// while (i < N) {
		// writeString(val.get(i));
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.807 -0400", hash_original_method = "7137D7435CDB5CC040EE6A964998B66D", hash_generated_method = "EF498ACD099A2BEB06418D24116CFDB6")
	public final void writeBinderList(List<IBinder> val) {
		{
			writeInt(-1);
		} // End block
		int N = val.size();
		int i = 0;
		writeInt(N);
		{
			writeStrongBinder(val.get(i));
		} // End block
		addTaint(val.getTaint());
		// ---------- Original Method ----------
		// if (val == null) {
		// writeInt(-1);
		// return;
		// }
		// int N = val.size();
		// int i=0;
		// writeInt(N);
		// while (i < N) {
		// writeStrongBinder(val.get(i));
		// i++;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.808 -0400", hash_original_method = "029988DBA55E380B93A4CDBDA2CB7F3E", hash_generated_method = "71188B12456C3D515D1930D3FBC9A231")
	public final <T extends Parcelable> void writeTypedArray(T[] val, int parcelableFlags) {
		{
			int N = val.length;
			writeInt(N);
			{
				int i = 0;
				{
					T item = val[i];
					{
						writeInt(1);
						item.writeToParcel(this, parcelableFlags);
					} // End block
					{
						writeInt(0);
					} // End block
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(val[0].getTaint());
		addTaint(parcelableFlags);
		// ---------- Original Method ----------
		// if (val != null) {
		// int N = val.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// T item = val[i];
		// if (item != null) {
		// writeInt(1);
		// item.writeToParcel(this, parcelableFlags);
		// } else {
		// writeInt(0);
		// }
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.809 -0400", hash_original_method = "D9566C4BE63552F29703FA1385C84129", hash_generated_method = "013DA4F999026AAE579652781535EF9B")
	public final void writeValue(Object v) {
		{
			writeInt(VAL_NULL);
		} // End block
		{
			writeInt(VAL_STRING);
			writeString((String) v);
		} // End block
		{
			writeInt(VAL_INTEGER);
			writeInt((Integer) v);
		} // End block
		{
			writeInt(VAL_MAP);
			writeMap((Map) v);
		} // End block
		{
			writeInt(VAL_BUNDLE);
			writeBundle((Bundle) v);
		} // End block
		{
			writeInt(VAL_PARCELABLE);
			writeParcelable((Parcelable) v, 0);
		} // End block
		{
			writeInt(VAL_SHORT);
			writeInt(((Short) v).intValue());
		} // End block
		{
			writeInt(VAL_LONG);
			writeLong((Long) v);
		} // End block
		{
			writeInt(VAL_FLOAT);
			writeFloat((Float) v);
		} // End block
		{
			writeInt(VAL_DOUBLE);
			writeDouble((Double) v);
		} // End block
		{
			writeInt(VAL_BOOLEAN);
			writeInt((Boolean) v ? 1 : 0);
		} // End block
		{
			writeInt(VAL_CHARSEQUENCE);
			writeCharSequence((CharSequence) v);
		} // End block
		{
			writeInt(VAL_LIST);
			writeList((List) v);
		} // End block
		{
			writeInt(VAL_SPARSEARRAY);
			writeSparseArray((SparseArray) v);
		} // End block
		{
			writeInt(VAL_BOOLEANARRAY);
			writeBooleanArray((boolean[]) v);
		} // End block
		{
			writeInt(VAL_BYTEARRAY);
			writeByteArray((byte[]) v);
		} // End block
		{
			writeInt(VAL_STRINGARRAY);
			writeStringArray((String[]) v);
		} // End block
		{
			writeInt(VAL_CHARSEQUENCEARRAY);
			writeCharSequenceArray((CharSequence[]) v);
		} // End block
		{
			writeInt(VAL_IBINDER);
			writeStrongBinder((IBinder) v);
		} // End block
		{
			writeInt(VAL_PARCELABLEARRAY);
			writeParcelableArray((Parcelable[]) v, 0);
		} // End block
		{
			writeInt(VAL_OBJECTARRAY);
			writeArray((Object[]) v);
		} // End block
		{
			writeInt(VAL_INTARRAY);
			writeIntArray((int[]) v);
		} // End block
		{
			writeInt(VAL_LONGARRAY);
			writeLongArray((long[]) v);
		} // End block
		{
			writeInt(VAL_BYTE);
			writeInt((Byte) v);
		} // End block
		{
			writeInt(VAL_SERIALIZABLE);
			writeSerializable((Serializable) v);
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Parcel: unable to marshal value " + v);
		} // End block
		addTaint(v.getTaint());
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.809 -0400", hash_original_method = "A58184BC725C2FE85E17C583E1DA6016", hash_generated_method = "25BAD11D779A82C20E13B7A0DC184E29")
	public final void writeParcelable(Parcelable p, int parcelableFlags) {
		{
			writeString(null);
		} // End block
		String name = p.getClass().getName();
		writeString(name);
		p.writeToParcel(this, parcelableFlags);
		addTaint(p.getTaint());
		addTaint(parcelableFlags);
		// ---------- Original Method ----------
		// if (p == null) {
		// writeString(null);
		// return;
		// }
		// String name = p.getClass().getName();
		// writeString(name);
		// p.writeToParcel(this, parcelableFlags);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.810 -0400", hash_original_method = "BCB9F78F7EC1F484C61BF7865779B2F9", hash_generated_method = "04B67A41CD196848485DCC8D7CD78180")
	public final void writeSerializable(Serializable s) {
		{
			writeString(null);
		} // End block
		String name = s.getClass().getName();
		writeString(name);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(s);
			oos.close();
			writeByteArray(baos.toByteArray());
		} // End block
		catch (IOException ioe) {
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Parcelable encountered " + "IOException writing serializable object (name = " + name + ")", ioe);
		} // End block
		addTaint(s.getTaint());
		// ---------- Original Method ----------
		// if (s == null) {
		// writeString(null);
		// return;
		// }
		// String name = s.getClass().getName();
		// writeString(name);
		// ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// try {
		// ObjectOutputStream oos = new ObjectOutputStream(baos);
		// oos.writeObject(s);
		// oos.close();
		// writeByteArray(baos.toByteArray());
		// } catch (IOException ioe) {
		// throw new RuntimeException("Parcelable encountered " +
		// "IOException writing serializable object (name = " + name +
		// ")", ioe);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.810 -0400", hash_original_method = "7DD11AC8769A37C0F9583E9AAFAA7192", hash_generated_method = "9BE712E3A4DD3BF1A61E70590E0E931F")
	public final void writeException(Exception e) {
		int code = 0;
		{
			code = EX_SECURITY;
		} // End block
		{
			code = EX_BAD_PARCELABLE;
		} // End block
		{
			code = EX_ILLEGAL_ARGUMENT;
		} // End block
		{
			code = EX_NULL_POINTER;
		} // End block
		{
			code = EX_ILLEGAL_STATE;
		} // End block
		writeInt(code);
		StrictMode.clearGatheredViolations();
		{
			{
				if (DroidSafeAndroidRuntime.control)
					throw (RuntimeException) e;
			} // End block
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException(e);
		} // End block
		writeString(e.getMessage());
		addTaint(e.getTaint());
		// ---------- Original Method ----------
		// int code = 0;
		// if (e instanceof SecurityException) {
		// code = EX_SECURITY;
		// } else if (e instanceof BadParcelableException) {
		// code = EX_BAD_PARCELABLE;
		// } else if (e instanceof IllegalArgumentException) {
		// code = EX_ILLEGAL_ARGUMENT;
		// } else if (e instanceof NullPointerException) {
		// code = EX_NULL_POINTER;
		// } else if (e instanceof IllegalStateException) {
		// code = EX_ILLEGAL_STATE;
		// }
		// writeInt(code);
		// StrictMode.clearGatheredViolations();
		// if (code == 0) {
		// if (e instanceof RuntimeException) {
		// throw (RuntimeException) e;
		// }
		// throw new RuntimeException(e);
		// }
		// writeString(e.getMessage());
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.811 -0400", hash_original_method = "123C62676F5EFD49547DAF82EF108740", hash_generated_method = "66C7B5EA3F6FD85544EA30F9AF0730EA")
	public final void writeNoException() {
		{
			boolean var67AAFC75FFEDAFC4D52248FF88A9C8E7_2143349076 = (StrictMode.hasGatheredViolations());
			{
				writeInt(EX_HAS_REPLY_HEADER);
				final int sizePosition = dataPosition();
				writeInt(0);
				StrictMode.writeGatheredViolationsToParcel(this);
				final int payloadPosition = dataPosition();
				setDataPosition(sizePosition);
				writeInt(payloadPosition - sizePosition);
				setDataPosition(payloadPosition);
			} // End block
			{
				writeInt(0);
			} // End block
		} // End collapsed parenthetic
			// ---------- Original Method ----------
			// if (StrictMode.hasGatheredViolations()) {
			// writeInt(EX_HAS_REPLY_HEADER);
			// final int sizePosition = dataPosition();
			// writeInt(0);
			// StrictMode.writeGatheredViolationsToParcel(this);
			// final int payloadPosition = dataPosition();
			// setDataPosition(sizePosition);
			// writeInt(payloadPosition - sizePosition);
			// setDataPosition(payloadPosition);
		// } else {
		// writeInt(0);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.811 -0400", hash_original_method = "82EBD768B4FCE70E559935E5298055BB", hash_generated_method = "1CD8C245A8813DF6CD811477877B0667")
	public final void readException() {
		int code = readExceptionCode();
		{
			String msg = readString();
			readException(code, msg);
		} // End block
			// ---------- Original Method ----------
			// int code = readExceptionCode();
			// if (code != 0) {
			// String msg = readString();
			// readException(code, msg);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.811 -0400", hash_original_method = "38AAEB1276A409D21345CE71D5A4968D", hash_generated_method = "5953F2EB0A87D5D7EDEAC4BA16398DAF")
	public final int readExceptionCode() {
		int code = readInt();
		{
			int headerSize = readInt();
			{
				StrictMode.readAndHandleBinderCallViolations(this);
			} // End block
		} // End block
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547636276 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547636276;
		// ---------- Original Method ----------
		// int code = readInt();
		// if (code == EX_HAS_REPLY_HEADER) {
		// int headerSize = readInt();
		// if (headerSize == 0) {
		// Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
		// } else {
		// StrictMode.readAndHandleBinderCallViolations(this);
		// }
		// return 0;
		// }
		// return code;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.812 -0400", hash_original_method = "16B6C7096EAAE541E38738222303A695", hash_generated_method = "E1A6625007DA31B04BDAEDD7DCD27DD3")
	public final void readException(int code, String msg) {
		// Begin case EX_SECURITY
		if (DroidSafeAndroidRuntime.control)
			throw new SecurityException(msg);
		// End case EX_SECURITY
		// Begin case EX_BAD_PARCELABLE
		if (DroidSafeAndroidRuntime.control)
			throw new BadParcelableException(msg);
		// End case EX_BAD_PARCELABLE
		// Begin case EX_ILLEGAL_ARGUMENT
		if (DroidSafeAndroidRuntime.control)
			throw new IllegalArgumentException(msg);
		// End case EX_ILLEGAL_ARGUMENT
		// Begin case EX_NULL_POINTER
		if (DroidSafeAndroidRuntime.control)
			throw new NullPointerException(msg);
		// End case EX_NULL_POINTER
		// Begin case EX_ILLEGAL_STATE
		if (DroidSafeAndroidRuntime.control)
			throw new IllegalStateException(msg);
		// End case EX_ILLEGAL_STATE
		if (DroidSafeAndroidRuntime.control)
			throw new RuntimeException("Unknown exception code: " + code + " msg " + msg);
		addTaint(code);
		addTaint(msg.getTaint());
		// ---------- Original Method ----------
		// switch (code) {
		// case EX_SECURITY:
		// throw new SecurityException(msg);
		// case EX_BAD_PARCELABLE:
		// throw new BadParcelableException(msg);
		// case EX_ILLEGAL_ARGUMENT:
		// throw new IllegalArgumentException(msg);
		// case EX_NULL_POINTER:
		// throw new NullPointerException(msg);
		// case EX_ILLEGAL_STATE:
		// throw new IllegalStateException(msg);
		// }
		// throw new RuntimeException("Unknown exception code: " + code
		// + " msg " + msg);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.812 -0400", hash_original_method = "97FB920EA9544B24495059FF8518145E", hash_generated_method = "B932D00AFBFBA6CE14C7ACF1C7AFC448")
	public final int readInt() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593871247 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593871247;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.812 -0400", hash_original_method = "88765326927052F47E1B04CC1A370299", hash_generated_method = "EB13FADDD48C5C17A25731FC4EBBAABB")
	public final long readLong() {
		long var0F5264038205EDFB1AC05FBB0E8C5E94_1759023929 = getTaintLong();
		return var0F5264038205EDFB1AC05FBB0E8C5E94_1759023929;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.813 -0400", hash_original_method = "9BF95C525D78F630EDF572E34BF4D430", hash_generated_method = "D13CC2CE4CFB28E903C56E5A03945AE2")
	public final float readFloat() {
		float var546ADE640B6EDFBC8A086EF31347E768_1442070030 = getTaintFloat();
		return var546ADE640B6EDFBC8A086EF31347E768_1442070030;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.813 -0400", hash_original_method = "FFE81D38F89970F2B0BAD4C68B43B4BA", hash_generated_method = "A6DE429FE182315DE1023D9BA022EA1A")
	public final double readDouble() {
		double varE8CD7DA078A86726031AD64F35F5A6C0_677515149 = getTaintDouble();
		return varE8CD7DA078A86726031AD64F35F5A6C0_677515149;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.813 -0400", hash_original_method = "E5D101F44C406F4D63DCAF323A3DBE7A", hash_generated_method = "1C9A6574A6BB76E4DCFE30F009ECD100")
	public final String readString() {
		return new String();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.814 -0400", hash_original_method = "1E262BAA6376F101519B67935298363E", hash_generated_method = "73D30E3418F0DF45E343539664DB5E45")
	public final CharSequence readCharSequence() {
		CharSequence varB4EAC82CA7396A68D541C85D26508E83_1737118328 = null; // Variable
																			// for
																			// return
																			// #1
		varB4EAC82CA7396A68D541C85D26508E83_1737118328 = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
		varB4EAC82CA7396A68D541C85D26508E83_1737118328.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1737118328;
		// ---------- Original Method ----------
		// return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.814 -0400", hash_original_method = "5B57CBCFFAE68CC288C10DD7232B6ED1", hash_generated_method = "44CAE844D4E5A4CBF2E99C7605E5B931")
	public final IBinder readStrongBinder() {
		// DSFIXME: CODE0013: Native method returns a complex type and requires
		// manual reviews
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.815 -0400", hash_original_method = "624419D3E87C84C27536CFAE1C7248DF", hash_generated_method = "9584F170256FC97C276440AE5E1C9420")
	public final ParcelFileDescriptor readFileDescriptor() {
		ParcelFileDescriptor varB4EAC82CA7396A68D541C85D26508E83_804521395 = null; // Variable
																					// for
																					// return
																					// #1
		FileDescriptor fd = internalReadFileDescriptor();
		varB4EAC82CA7396A68D541C85D26508E83_804521395 = fd != null ? new ParcelFileDescriptor(fd) : null;
		varB4EAC82CA7396A68D541C85D26508E83_804521395.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_804521395;
		// ---------- Original Method ----------
		// FileDescriptor fd = internalReadFileDescriptor();
		// return fd != null ? new ParcelFileDescriptor(fd) : null;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.816 -0400", hash_original_method = "33B415422717616FBFFA4D8F233FE3A4", hash_generated_method = "0FD8D4B30F488C8E04BA04A3C811CF90")
	private FileDescriptor internalReadFileDescriptor() {
		FileDescriptor fd = new FileDescriptor();
		fd.addTaint(this.taint);
		return fd;
	}

	static FileDescriptor openFileDescriptor(String file, int mode) throws FileNotFoundException {
		return new FileDescriptor();
	}

	static FileDescriptor dupFileDescriptor(FileDescriptor orig) throws IOException {
		return new FileDescriptor();
	}

	static void closeFileDescriptor(FileDescriptor desc) throws IOException {
	}

	static void clearFileDescriptor(FileDescriptor desc) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.818 -0400", hash_original_method = "12B71841CE7C7BEB8DB394B4DC6EF58B", hash_generated_method = "234888288D57C72268F1A30319D2CAF8")
	public final byte readByte() {
		byte varA3491D8E17C6029A18B5C5A7657736E0_1603428365 = ((byte) (readInt() & 0xff));
		byte var40EA57D3EE3C07BF1C102B466E1C3091_414929780 = getTaintByte();
		return var40EA57D3EE3C07BF1C102B466E1C3091_414929780;
		// ---------- Original Method ----------
		// return (byte)(readInt() & 0xff);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.819 -0400", hash_original_method = "82825CDD252FB884333A0468F1B46F6F", hash_generated_method = "FFB96033B2A4BC37872D54359F1A77B7")
	public final void readMap(Map outVal, ClassLoader loader) {
		int N = readInt();
		readMapInternal(outVal, N, loader);
		addTaint(outVal.getTaint());
		addTaint(loader.getTaint());
		// ---------- Original Method ----------
		// int N = readInt();
		// readMapInternal(outVal, N, loader);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.819 -0400", hash_original_method = "C60DBA65518C72AFC52918F8818E7A4A", hash_generated_method = "01C8FB37955CA6F70FAC5667AAD90338")
	public final void readList(List outVal, ClassLoader loader) {
		int N = readInt();
		readListInternal(outVal, N, loader);
		addTaint(outVal.getTaint());
		addTaint(loader.getTaint());
		// ---------- Original Method ----------
		// int N = readInt();
		// readListInternal(outVal, N, loader);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.820 -0400", hash_original_method = "0DC8809E3B9E75AF0CC28567E6782BE5", hash_generated_method = "A65872F79D7C301520F949B65B1629B2")
	public final HashMap readHashMap(ClassLoader loader) {
		HashMap varB4EAC82CA7396A68D541C85D26508E83_166096724 = null; // Variable
																		// for
																		// return
																		// #1
		HashMap varB4EAC82CA7396A68D541C85D26508E83_1616919407 = null; // Variable
																		// for
																		// return
																		// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_166096724 = null;
		} // End block
		HashMap m = new HashMap(N);
		readMapInternal(m, N, loader);
		varB4EAC82CA7396A68D541C85D26508E83_1616919407 = m;
		addTaint(loader.getTaint());
		HashMap varA7E53CE21691AB073D9660D615818899_74198370; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_74198370 = varB4EAC82CA7396A68D541C85D26508E83_166096724;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_74198370 = varB4EAC82CA7396A68D541C85D26508E83_1616919407;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_74198370.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_74198370;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// HashMap m = new HashMap(N);
		// readMapInternal(m, N, loader);
		// return m;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.821 -0400", hash_original_method = "30B879800FFE3D55BB9B30F39E994273", hash_generated_method = "CCFBE894BA4AC9C30A41D60558D32244")
	public final Bundle readBundle() {
		Bundle varB4EAC82CA7396A68D541C85D26508E83_279583024 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_279583024 = readBundle(null);
		varB4EAC82CA7396A68D541C85D26508E83_279583024.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_279583024;
		// ---------- Original Method ----------
		// return readBundle(null);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.822 -0400", hash_original_method = "7DBD463E649AEA6A8616F4943C405C7A", hash_generated_method = "91E79C4FF7E28AA21C24373C8C84A423")
	public final Bundle readBundle(ClassLoader loader) {
		Bundle varB4EAC82CA7396A68D541C85D26508E83_1814659209 = null; // Variable
																		// for
																		// return
																		// #1
		Bundle varB4EAC82CA7396A68D541C85D26508E83_1648482506 = null; // Variable
																		// for
																		// return
																		// #2
		int length = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1814659209 = null;
		} // End block
		final Bundle bundle = new Bundle(this, length);
		{
			bundle.setClassLoader(loader);
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1648482506 = bundle;
		addTaint(loader.getTaint());
		Bundle varA7E53CE21691AB073D9660D615818899_1998826212; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1998826212 = varB4EAC82CA7396A68D541C85D26508E83_1814659209;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1998826212 = varB4EAC82CA7396A68D541C85D26508E83_1648482506;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1998826212.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1998826212;
		// ---------- Original Method ----------
		// int length = readInt();
		// if (length < 0) {
		// return null;
		// }
		// final Bundle bundle = new Bundle(this, length);
		// if (loader != null) {
		// bundle.setClassLoader(loader);
		// }
		// return bundle;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.823 -0400", hash_original_method = "DCFF48487CDF8628FF2244CC4810775C", hash_generated_method = "F2F00236DA8CE3D646D1E7E9C7D8D6B6")
	public final byte[] createByteArray() {
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1246086584 = { getTaintByte() };
		return var2F9C81BC6E497382285CD6B7A7E33DE1_1246086584;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.823 -0400", hash_original_method = "40FE8430590711C6D2AB472A3973EA8A", hash_generated_method = "6A4C775DD1881722BF16AE88DEA35135")
	public final void readByteArray(byte[] val) {
		byte[] ba = createByteArray();
		{
			System.arraycopy(ba, 0, val, 0, ba.length);
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0]);
		// ---------- Original Method ----------
		// byte[] ba = createByteArray();
		// if (ba.length == val.length) {
		// System.arraycopy(ba, 0, val, 0, ba.length);
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.824 -0400", hash_original_method = "3F4E1D573E001DD6503628882E161682", hash_generated_method = "2B6C13C020AAFE05B6863897C357F49B")
	public final String[] readStringArray() {
		String[] varB4EAC82CA7396A68D541C85D26508E83_1076562175 = null; // Variable
																		// for
																		// return
																		// #1
		String[] array = null;
		int length = readInt();
		{
			array = new String[length];
			{
				int i = 0;
				{
					array[i] = readString();
				} // End block
			} // End collapsed parenthetic
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1076562175 = array;
		varB4EAC82CA7396A68D541C85D26508E83_1076562175.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1076562175;
		// ---------- Original Method ----------
		// String[] array = null;
		// int length = readInt();
		// if (length >= 0)
		// {
		// array = new String[length];
		// for (int i = 0 ; i < length ; i++)
		// {
		// array[i] = readString();
		// }
		// }
		// return array;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.826 -0400", hash_original_method = "0A6BC69D8060353BD0BABF3E9B4D1085", hash_generated_method = "0E8C03E891BD626DF770A4C073B6D69E")
	public final CharSequence[] readCharSequenceArray() {
		CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1848957308 = null; // Variable
																				// for
																				// return
																				// #1
		CharSequence[] array = null;
		int length = readInt();
		{
			array = new CharSequence[length];
			{
				int i = 0;
				{
					array[i] = readCharSequence();
				} // End block
			} // End collapsed parenthetic
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1848957308 = array;
		varB4EAC82CA7396A68D541C85D26508E83_1848957308.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1848957308;
		// ---------- Original Method ----------
		// CharSequence[] array = null;
		// int length = readInt();
		// if (length >= 0)
		// {
		// array = new CharSequence[length];
		// for (int i = 0 ; i < length ; i++)
		// {
		// array[i] = readCharSequence();
		// }
		// }
		// return array;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.827 -0400", hash_original_method = "0CB879EE6020D3E02716A43BE19D4D51", hash_generated_method = "D0B2F4435FC4B838580BBC946DC0D822")
	public final ArrayList readArrayList(ClassLoader loader) {
		ArrayList varB4EAC82CA7396A68D541C85D26508E83_698019879 = null; // Variable
																		// for
																		// return
																		// #1
		ArrayList varB4EAC82CA7396A68D541C85D26508E83_867330974 = null; // Variable
																		// for
																		// return
																		// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_698019879 = null;
		} // End block
		ArrayList l = new ArrayList(N);
		readListInternal(l, N, loader);
		varB4EAC82CA7396A68D541C85D26508E83_867330974 = l;
		addTaint(loader.getTaint());
		ArrayList varA7E53CE21691AB073D9660D615818899_971229971; // Final return
																	// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_971229971 = varB4EAC82CA7396A68D541C85D26508E83_698019879;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_971229971 = varB4EAC82CA7396A68D541C85D26508E83_867330974;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_971229971.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_971229971;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// ArrayList l = new ArrayList(N);
		// readListInternal(l, N, loader);
		// return l;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.828 -0400", hash_original_method = "BFE5C5C5F5678C281D93BB53C31E26A0", hash_generated_method = "D8D2A31BA4FFA157EA6F4352A5631056")
	public final Object[] readArray(ClassLoader loader) {
		Object[] varB4EAC82CA7396A68D541C85D26508E83_1051212437 = null; // Variable
																		// for
																		// return
																		// #1
		Object[] varB4EAC82CA7396A68D541C85D26508E83_3193171 = null; // Variable
																		// for
																		// return
																		// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1051212437 = null;
		} // End block
		Object[] l = new Object[N];
		readArrayInternal(l, N, loader);
		varB4EAC82CA7396A68D541C85D26508E83_3193171 = l;
		addTaint(loader.getTaint());
		Object[] varA7E53CE21691AB073D9660D615818899_784137440; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_784137440 = varB4EAC82CA7396A68D541C85D26508E83_1051212437;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_784137440 = varB4EAC82CA7396A68D541C85D26508E83_3193171;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_784137440.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_784137440;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// Object[] l = new Object[N];
		// readArrayInternal(l, N, loader);
		// return l;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.829 -0400", hash_original_method = "53952EC2EA973438719A76F49C86D9F1", hash_generated_method = "3996729CBEB1A47A9FCC3CAC3389AC81")
	public final SparseArray readSparseArray(ClassLoader loader) {
		SparseArray varB4EAC82CA7396A68D541C85D26508E83_158385725 = null; // Variable
																			// for
																			// return
																			// #1
		SparseArray varB4EAC82CA7396A68D541C85D26508E83_1263177273 = null; // Variable
																			// for
																			// return
																			// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_158385725 = null;
		} // End block
		SparseArray sa = new SparseArray(N);
		readSparseArrayInternal(sa, N, loader);
		varB4EAC82CA7396A68D541C85D26508E83_1263177273 = sa;
		addTaint(loader.getTaint());
		SparseArray varA7E53CE21691AB073D9660D615818899_1602119489; // Final
																	// return
																	// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1602119489 = varB4EAC82CA7396A68D541C85D26508E83_158385725;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1602119489 = varB4EAC82CA7396A68D541C85D26508E83_1263177273;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1602119489.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1602119489;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// SparseArray sa = new SparseArray(N);
		// readSparseArrayInternal(sa, N, loader);
		// return sa;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.830 -0400", hash_original_method = "04DCF387CF40E8397784231DC7CB64F8", hash_generated_method = "48C8552EDEDEA5F27B13B8F3476DD7E8")
	public final SparseBooleanArray readSparseBooleanArray() {
		SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_1579946323 = null; // Variable
																					// for
																					// return
																					// #1
		SparseBooleanArray varB4EAC82CA7396A68D541C85D26508E83_303572187 = null; // Variable
																					// for
																					// return
																					// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1579946323 = null;
		} // End block
		SparseBooleanArray sa = new SparseBooleanArray(N);
		readSparseBooleanArrayInternal(sa, N);
		varB4EAC82CA7396A68D541C85D26508E83_303572187 = sa;
		SparseBooleanArray varA7E53CE21691AB073D9660D615818899_202089173; // Final
																			// return
																			// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_202089173 = varB4EAC82CA7396A68D541C85D26508E83_1579946323;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_202089173 = varB4EAC82CA7396A68D541C85D26508E83_303572187;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_202089173.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_202089173;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// SparseBooleanArray sa = new SparseBooleanArray(N);
		// readSparseBooleanArrayInternal(sa, N);
		// return sa;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.831 -0400", hash_original_method = "456F7B8C59883BEB9D747B5AF3A070B1", hash_generated_method = "83AB2C754E671E1B2EB58A5D4866DC7F")
	public final <T> ArrayList<T> createTypedArrayList(Parcelable.Creator<T> c) {
		ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_1163565105 = null; // Variable
																			// for
																			// return
																			// #1
		ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_1525894710 = null; // Variable
																			// for
																			// return
																			// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1163565105 = null;
		} // End block
		ArrayList<T> l = new ArrayList<T>(N);
		{
			{
				boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_373294250 = (readInt() != 0);
				{
					l.add(c.createFromParcel(this));
				} // End block
				{
					l.add(null);
				} // End block
			} // End collapsed parenthetic
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1525894710 = l;
		addTaint(c.getTaint());
		ArrayList<T> varA7E53CE21691AB073D9660D615818899_1254042929; // Final
																		// return
																		// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1254042929 = varB4EAC82CA7396A68D541C85D26508E83_1163565105;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1254042929 = varB4EAC82CA7396A68D541C85D26508E83_1525894710;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1254042929.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1254042929;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// ArrayList<T> l = new ArrayList<T>(N);
		// while (N > 0) {
		// if (readInt() != 0) {
		// l.add(c.createFromParcel(this));
		// } else {
		// l.add(null);
		// }
		// N--;
		// }
		// return l;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.831 -0400", hash_original_method = "B9FCE8B620ADC76BF3A577C32D057CDB", hash_generated_method = "CC41D5758DCB2424A14CC643983FB806")
	public final <T> void readTypedList(List<T> list, Parcelable.Creator<T> c) {
		int M = list.size();
		int N = readInt();
		int i = 0;
		{
			{
				boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_2121165555 = (readInt() != 0);
				{
					list.set(i, c.createFromParcel(this));
				} // End block
				{
					list.set(i, null);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			{
				boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_1408859145 = (readInt() != 0);
				{
					list.add(c.createFromParcel(this));
				} // End block
				{
					list.add(null);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			list.remove(N);
		} // End block
		addTaint(list.getTaint());
		addTaint(c.getTaint());
		// ---------- Original Method ----------
		// int M = list.size();
		// int N = readInt();
		// int i = 0;
		// for (; i < M && i < N; i++) {
		// if (readInt() != 0) {
		// list.set(i, c.createFromParcel(this));
		// } else {
		// list.set(i, null);
		// }
		// }
		// for (; i<N; i++) {
		// if (readInt() != 0) {
		// list.add(c.createFromParcel(this));
		// } else {
		// list.add(null);
		// }
		// }
		// for (; i<M; i++) {
		// list.remove(N);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.832 -0400", hash_original_method = "6BB9790DD7CE6638433A98D5801460E1", hash_generated_method = "03DAD2903DBCA749E71FA6AF3B5475B6")
	public final ArrayList<String> createStringArrayList() {
		ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1725555521 = null; // Variable
																					// for
																					// return
																					// #1
		ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1874851639 = null; // Variable
																					// for
																					// return
																					// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1725555521 = null;
		} // End block
		ArrayList<String> l = new ArrayList<String>(N);
		{
			l.add(readString());
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1874851639 = l;
		ArrayList<String> varA7E53CE21691AB073D9660D615818899_2107115726; // Final
																			// return
																			// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_2107115726 = varB4EAC82CA7396A68D541C85D26508E83_1725555521;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_2107115726 = varB4EAC82CA7396A68D541C85D26508E83_1874851639;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_2107115726.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_2107115726;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// ArrayList<String> l = new ArrayList<String>(N);
		// while (N > 0) {
		// l.add(readString());
		// N--;
		// }
		// return l;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.833 -0400", hash_original_method = "4AA47F929C1AD4C6AA4FF7E97EBA01C3", hash_generated_method = "868FB74DDD3AC410AA264FD4BB10CDA0")
	public final ArrayList<IBinder> createBinderArrayList() {
		ArrayList<IBinder> varB4EAC82CA7396A68D541C85D26508E83_1090141721 = null; // Variable
																					// for
																					// return
																					// #1
		ArrayList<IBinder> varB4EAC82CA7396A68D541C85D26508E83_1020680039 = null; // Variable
																					// for
																					// return
																					// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1090141721 = null;
		} // End block
		ArrayList<IBinder> l = new ArrayList<IBinder>(N);
		{
			l.add(readStrongBinder());
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_1020680039 = l;
		ArrayList<IBinder> varA7E53CE21691AB073D9660D615818899_1968887043; // Final
																			// return
																			// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1968887043 = varB4EAC82CA7396A68D541C85D26508E83_1090141721;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1968887043 = varB4EAC82CA7396A68D541C85D26508E83_1020680039;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1968887043.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1968887043;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// ArrayList<IBinder> l = new ArrayList<IBinder>(N);
		// while (N > 0) {
		// l.add(readStrongBinder());
		// N--;
		// }
		// return l;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.834 -0400", hash_original_method = "9CB504FEFB4242E237E17E2EB9A48FBD", hash_generated_method = "D072453E6B98467F82B67B578A05EBEE")
	public final void readStringList(List<String> list) {
		int M = list.size();
		int N = readInt();
		int i = 0;
		{
			list.set(i, readString());
		} // End block
		{
			list.add(readString());
		} // End block
		{
			list.remove(N);
		} // End block
		addTaint(list.getTaint());
		// ---------- Original Method ----------
		// int M = list.size();
		// int N = readInt();
		// int i = 0;
		// for (; i < M && i < N; i++) {
		// list.set(i, readString());
		// }
		// for (; i<N; i++) {
		// list.add(readString());
		// }
		// for (; i<M; i++) {
		// list.remove(N);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.834 -0400", hash_original_method = "BD5E31C17A1894DBD3B1CCAA7C1D6816", hash_generated_method = "2ED43DB882EA9C45A559591DAD1EFCC8")
	public final void readBinderList(List<IBinder> list) {
		int M = list.size();
		int N = readInt();
		int i = 0;
		{
			list.set(i, readStrongBinder());
		} // End block
		{
			list.add(readStrongBinder());
		} // End block
		{
			list.remove(N);
		} // End block
		addTaint(list.getTaint());
		// ---------- Original Method ----------
		// int M = list.size();
		// int N = readInt();
		// int i = 0;
		// for (; i < M && i < N; i++) {
		// list.set(i, readStrongBinder());
		// }
		// for (; i<N; i++) {
		// list.add(readStrongBinder());
		// }
		// for (; i<M; i++) {
		// list.remove(N);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.836 -0400", hash_original_method = "3CEF6E6386B4F00BA8155F93C3068CB0", hash_generated_method = "79552BADDDC0C799E9E0E050D885460E")
	public final <T> T[] createTypedArray(Parcelable.Creator<T> c) {
		T[] varB4EAC82CA7396A68D541C85D26508E83_1418242770 = null; // Variable
																	// for
																	// return #1
		T[] varB4EAC82CA7396A68D541C85D26508E83_1666849312 = null; // Variable
																	// for
																	// return #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_1418242770 = null;
		} // End block
		T[] l = c.newArray(N);
		{
			int i = 0;
			{
				{
					boolean varF3F4117B020949AD5A99383C367C3DCB_1444651954 = (readInt() != 0);
					{
						l[i] = c.createFromParcel(this);
					} // End block
				} // End collapsed parenthetic
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_1666849312 = l;
		addTaint(c.getTaint());
		T[] varA7E53CE21691AB073D9660D615818899_1880661450; // Final return
															// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1880661450 = varB4EAC82CA7396A68D541C85D26508E83_1418242770;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1880661450 = varB4EAC82CA7396A68D541C85D26508E83_1666849312;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1880661450.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1880661450;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// T[] l = c.newArray(N);
		// for (int i=0; i<N; i++) {
		// if (readInt() != 0) {
		// l[i] = c.createFromParcel(this);
		// }
		// }
		// return l;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.836 -0400", hash_original_method = "94DCFDEC159CF16A54AB9BC1543AACB0", hash_generated_method = "F70B7F71F2DA4F6C16CCC7C41FC02810")
	public final <T> void readTypedArray(T[] val, Parcelable.Creator<T> c) {
		int N = readInt();
		{
			{
				int i = 0;
				{
					{
						boolean varDA2468261896472593A672B57BF55D76_355992281 = (readInt() != 0);
						{
							val[i] = c.createFromParcel(this);
						} // End block
						{
							val[i] = null;
						} // End block
					} // End collapsed parenthetic
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("bad array lengths");
		} // End block
		addTaint(val[0].getTaint());
		addTaint(c.getTaint());
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N == val.length) {
		// for (int i=0; i<N; i++) {
		// if (readInt() != 0) {
		// val[i] = c.createFromParcel(this);
		// } else {
		// val[i] = null;
		// }
		// }
		// } else {
		// throw new RuntimeException("bad array lengths");
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.838 -0400", hash_original_method = "6C2CF48F71A46FC325FBB3DF7C6E0C74", hash_generated_method = "C318F8D5FDD3884811CDEC9D51E82AB3")
	@Deprecated
	public final <T> T[] readTypedArray(Parcelable.Creator<T> c) {
		T[] varB4EAC82CA7396A68D541C85D26508E83_1101667391 = null; // Variable
																	// for
																	// return #1
		varB4EAC82CA7396A68D541C85D26508E83_1101667391 = createTypedArray(c);
		addTaint(c.getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_1101667391.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1101667391;
		// ---------- Original Method ----------
		// return createTypedArray(c);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.839 -0400", hash_original_method = "B6CF25F021EC35EAE7839E69AD502686", hash_generated_method = "5D9AC2DE6B742A8033AA0DA0A55E7B4C")
	public final <T extends Parcelable> void writeParcelableArray(T[] value, int parcelableFlags) {
		{
			int N = value.length;
			writeInt(N);
			{
				int i = 0;
				{
					writeParcelable(value[i], parcelableFlags);
				} // End block
			} // End collapsed parenthetic
		} // End block
		{
			writeInt(-1);
		} // End block
		addTaint(value[0].getTaint());
		addTaint(parcelableFlags);
		// ---------- Original Method ----------
		// if (value != null) {
		// int N = value.length;
		// writeInt(N);
		// for (int i=0; i<N; i++) {
		// writeParcelable(value[i], parcelableFlags);
		// }
		// } else {
		// writeInt(-1);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.841 -0400", hash_original_method = "BC2BD16709D000C887B8D48E60CFBD74", hash_generated_method = "EB947FFD2017D0059129C667CFB825AA")
	public final Object readValue(ClassLoader loader) {
		Object varB4EAC82CA7396A68D541C85D26508E83_1684051088 = null; // Variable
																		// for
																		// return
																		// #1
		Object varB4EAC82CA7396A68D541C85D26508E83_1166194923 = null; // Variable
																		// for
																		// return
																		// #2
		Object varB4EAC82CA7396A68D541C85D26508E83_386845387 = null; // Variable
																		// for
																		// return
																		// #3
		Object varB4EAC82CA7396A68D541C85D26508E83_722922380 = null; // Variable
																		// for
																		// return
																		// #4
		Object varB4EAC82CA7396A68D541C85D26508E83_1016839958 = null; // Variable
																		// for
																		// return
																		// #5
		Object varB4EAC82CA7396A68D541C85D26508E83_26924907 = null; // Variable
																	// for
																	// return #6
		Object varB4EAC82CA7396A68D541C85D26508E83_198992746 = null; // Variable
																		// for
																		// return
																		// #7
		Object varB4EAC82CA7396A68D541C85D26508E83_143286103 = null; // Variable
																		// for
																		// return
																		// #8
		Object varB4EAC82CA7396A68D541C85D26508E83_710711622 = null; // Variable
																		// for
																		// return
																		// #9
		Object varB4EAC82CA7396A68D541C85D26508E83_1426139008 = null; // Variable
																		// for
																		// return
																		// #10
		Object varB4EAC82CA7396A68D541C85D26508E83_867965014 = null; // Variable
																		// for
																		// return
																		// #11
		Object varB4EAC82CA7396A68D541C85D26508E83_1783002410 = null; // Variable
																		// for
																		// return
																		// #12
		Object varB4EAC82CA7396A68D541C85D26508E83_1748671942 = null; // Variable
																		// for
																		// return
																		// #13
		Object varB4EAC82CA7396A68D541C85D26508E83_2093787363 = null; // Variable
																		// for
																		// return
																		// #14
		Object varB4EAC82CA7396A68D541C85D26508E83_1475522107 = null; // Variable
																		// for
																		// return
																		// #15
		Object varB4EAC82CA7396A68D541C85D26508E83_1866232980 = null; // Variable
																		// for
																		// return
																		// #16
		Object varB4EAC82CA7396A68D541C85D26508E83_1960501370 = null; // Variable
																		// for
																		// return
																		// #17
		Object varB4EAC82CA7396A68D541C85D26508E83_1254745871 = null; // Variable
																		// for
																		// return
																		// #18
		Object varB4EAC82CA7396A68D541C85D26508E83_2023700597 = null; // Variable
																		// for
																		// return
																		// #19
		Object varB4EAC82CA7396A68D541C85D26508E83_536684528 = null; // Variable
																		// for
																		// return
																		// #20
		Object varB4EAC82CA7396A68D541C85D26508E83_1320682209 = null; // Variable
																		// for
																		// return
																		// #21
		Object varB4EAC82CA7396A68D541C85D26508E83_337485411 = null; // Variable
																		// for
																		// return
																		// #22
		Object varB4EAC82CA7396A68D541C85D26508E83_307793637 = null; // Variable
																		// for
																		// return
																		// #23
		Object varB4EAC82CA7396A68D541C85D26508E83_1422827906 = null; // Variable
																		// for
																		// return
																		// #24
		Object varB4EAC82CA7396A68D541C85D26508E83_441909283 = null; // Variable
																		// for
																		// return
																		// #25
		Object varB4EAC82CA7396A68D541C85D26508E83_1276083288 = null; // Variable
																		// for
																		// return
																		// #26
		int type = readInt();
		// Begin case VAL_NULL
		varB4EAC82CA7396A68D541C85D26508E83_1684051088 = null;
		// End case VAL_NULL
		// Begin case VAL_STRING
		varB4EAC82CA7396A68D541C85D26508E83_1166194923 = readString();
		// End case VAL_STRING
		// Begin case VAL_INTEGER
		varB4EAC82CA7396A68D541C85D26508E83_386845387 = readInt();
		// End case VAL_INTEGER
		// Begin case VAL_MAP
		varB4EAC82CA7396A68D541C85D26508E83_722922380 = readHashMap(loader);
		// End case VAL_MAP
		// Begin case VAL_PARCELABLE
		varB4EAC82CA7396A68D541C85D26508E83_1016839958 = readParcelable(loader);
		// End case VAL_PARCELABLE
		// Begin case VAL_SHORT
		varB4EAC82CA7396A68D541C85D26508E83_26924907 = (short) readInt();
		// End case VAL_SHORT
		// Begin case VAL_LONG
		varB4EAC82CA7396A68D541C85D26508E83_198992746 = readLong();
		// End case VAL_LONG
		// Begin case VAL_FLOAT
		varB4EAC82CA7396A68D541C85D26508E83_143286103 = readFloat();
		// End case VAL_FLOAT
		// Begin case VAL_DOUBLE
		varB4EAC82CA7396A68D541C85D26508E83_710711622 = readDouble();
		// End case VAL_DOUBLE
		// Begin case VAL_BOOLEAN
		varB4EAC82CA7396A68D541C85D26508E83_1426139008 = readInt() == 1;
		// End case VAL_BOOLEAN
		// Begin case VAL_CHARSEQUENCE
		varB4EAC82CA7396A68D541C85D26508E83_867965014 = readCharSequence();
		// End case VAL_CHARSEQUENCE
		// Begin case VAL_LIST
		varB4EAC82CA7396A68D541C85D26508E83_1783002410 = readArrayList(loader);
		// End case VAL_LIST
		// Begin case VAL_BOOLEANARRAY
		varB4EAC82CA7396A68D541C85D26508E83_1748671942 = createBooleanArray();
		// End case VAL_BOOLEANARRAY
		// Begin case VAL_BYTEARRAY
		varB4EAC82CA7396A68D541C85D26508E83_2093787363 = createByteArray();
		// End case VAL_BYTEARRAY
		// Begin case VAL_STRINGARRAY
		varB4EAC82CA7396A68D541C85D26508E83_1475522107 = readStringArray();
		// End case VAL_STRINGARRAY
		// Begin case VAL_CHARSEQUENCEARRAY
		varB4EAC82CA7396A68D541C85D26508E83_1866232980 = readCharSequenceArray();
		// End case VAL_CHARSEQUENCEARRAY
		// Begin case VAL_IBINDER
		varB4EAC82CA7396A68D541C85D26508E83_1960501370 = readStrongBinder();
		// End case VAL_IBINDER
		// Begin case VAL_OBJECTARRAY
		varB4EAC82CA7396A68D541C85D26508E83_1254745871 = readArray(loader);
		// End case VAL_OBJECTARRAY
		// Begin case VAL_INTARRAY
		varB4EAC82CA7396A68D541C85D26508E83_2023700597 = createIntArray();
		// End case VAL_INTARRAY
		// Begin case VAL_LONGARRAY
		varB4EAC82CA7396A68D541C85D26508E83_536684528 = createLongArray();
		// End case VAL_LONGARRAY
		// Begin case VAL_BYTE
		varB4EAC82CA7396A68D541C85D26508E83_1320682209 = readByte();
		// End case VAL_BYTE
		// Begin case VAL_SERIALIZABLE
		varB4EAC82CA7396A68D541C85D26508E83_337485411 = readSerializable();
		// End case VAL_SERIALIZABLE
		// Begin case VAL_PARCELABLEARRAY
		varB4EAC82CA7396A68D541C85D26508E83_307793637 = readParcelableArray(loader);
		// End case VAL_PARCELABLEARRAY
		// Begin case VAL_SPARSEARRAY
		varB4EAC82CA7396A68D541C85D26508E83_1422827906 = readSparseArray(loader);
		// End case VAL_SPARSEARRAY
		// Begin case VAL_SPARSEBOOLEANARRAY
		varB4EAC82CA7396A68D541C85D26508E83_441909283 = readSparseBooleanArray();
		// End case VAL_SPARSEBOOLEANARRAY
		// Begin case VAL_BUNDLE
		varB4EAC82CA7396A68D541C85D26508E83_1276083288 = readBundle(loader);
		// End case VAL_BUNDLE
		// Begin case default
		int off = dataPosition() - 4;
		// End case default
		// Begin case default
		if (DroidSafeAndroidRuntime.control)
			throw new RuntimeException("Parcel " + this + ": Unmarshalling unknown type code " + type + " at offset " + off);
		// End case default
		addTaint(loader.getTaint());
		Object varA7E53CE21691AB073D9660D615818899_1186569650; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1684051088;
			break;
		case 2: // Assign result for return ordinal #2
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1166194923;
			break;
		case 3: // Assign result for return ordinal #3
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_386845387;
			break;
		case 4: // Assign result for return ordinal #4
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_722922380;
			break;
		case 5: // Assign result for return ordinal #5
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1016839958;
			break;
		case 6: // Assign result for return ordinal #6
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_26924907;
			break;
		case 7: // Assign result for return ordinal #7
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_198992746;
			break;
		case 8: // Assign result for return ordinal #8
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_143286103;
			break;
		case 9: // Assign result for return ordinal #9
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_710711622;
			break;
		case 10: // Assign result for return ordinal #10
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1426139008;
			break;
		case 11: // Assign result for return ordinal #11
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_867965014;
			break;
		case 12: // Assign result for return ordinal #12
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1783002410;
			break;
		case 13: // Assign result for return ordinal #13
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1748671942;
			break;
		case 14: // Assign result for return ordinal #14
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_2093787363;
			break;
		case 15: // Assign result for return ordinal #15
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1475522107;
			break;
		case 16: // Assign result for return ordinal #16
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1866232980;
			break;
		case 17: // Assign result for return ordinal #17
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1960501370;
			break;
		case 18: // Assign result for return ordinal #18
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1254745871;
			break;
		case 19: // Assign result for return ordinal #19
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_2023700597;
			break;
		case 20: // Assign result for return ordinal #20
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_536684528;
			break;
		case 21: // Assign result for return ordinal #21
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1320682209;
			break;
		case 22: // Assign result for return ordinal #22
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_337485411;
			break;
		case 23: // Assign result for return ordinal #23
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_307793637;
			break;
		case 24: // Assign result for return ordinal #24
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1422827906;
			break;
		case 25: // Assign result for return ordinal #25
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_441909283;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1186569650 = varB4EAC82CA7396A68D541C85D26508E83_1276083288;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1186569650.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1186569650;
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.842 -0400", hash_original_method = "973DB4BA749CEAB3796DAD314F27DB98", hash_generated_method = "0CB95AE51CF4E41F05D3AC6A36F8C47D")
	public final <T extends Parcelable> T readParcelable(ClassLoader loader) {
		T varB4EAC82CA7396A68D541C85D26508E83_743233603 = null; // Variable for
																// return #1
		T varB4EAC82CA7396A68D541C85D26508E83_1067709877 = null; // Variable for
																	// return #2
		T varB4EAC82CA7396A68D541C85D26508E83_297758736 = null; // Variable for
																// return #3
		String name = readString();
		{
			varB4EAC82CA7396A68D541C85D26508E83_743233603 = null;
		} // End block
		Parcelable.Creator<T> creator;
		{
			HashMap<String, Parcelable.Creator> map = mCreators.get(loader);
			{
				map = new HashMap<String, Parcelable.Creator>();
				mCreators.put(loader, map);
			} // End block
			creator = map.get(name);
			{
				try {
					Class c;
					c = Class.forName(name);
					c = Class.forName(name, true, loader);
					Field f = c.getField("CREATOR");
					creator = (Parcelable.Creator) f.get(null);
				} // End block
				catch (IllegalAccessException e) {
					if (DroidSafeAndroidRuntime.control)
						throw new BadParcelableException("IllegalAccessException when unmarshalling: " + name);
				} // End block
				catch (ClassNotFoundException e) {
					if (DroidSafeAndroidRuntime.control)
						throw new BadParcelableException("ClassNotFoundException when unmarshalling: " + name);
				} // End block
				catch (ClassCastException e) {
					if (DroidSafeAndroidRuntime.control)
						throw new BadParcelableException("Parcelable protocol requires a " + "Parcelable.Creator object called " + " CREATOR on class " + name);
				} // End block
				catch (NoSuchFieldException e) {
					if (DroidSafeAndroidRuntime.control)
						throw new BadParcelableException("Parcelable protocol requires a " + "Parcelable.Creator object called " + " CREATOR on class " + name);
				} // End block
				{
					if (DroidSafeAndroidRuntime.control)
						throw new BadParcelableException("Parcelable protocol requires a " + "Parcelable.Creator object called " + " CREATOR on class " + name);
				} // End block
				map.put(name, creator);
			} // End block
		} // End block
		{
			varB4EAC82CA7396A68D541C85D26508E83_1067709877 = ((Parcelable.ClassLoaderCreator<T>) creator).createFromParcel(this, loader);
		} // End block
		varB4EAC82CA7396A68D541C85D26508E83_297758736 = creator.createFromParcel(this);
		addTaint(loader.getTaint());
		T varA7E53CE21691AB073D9660D615818899_462959774; // Final return value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_462959774 = varB4EAC82CA7396A68D541C85D26508E83_743233603;
			break;
		case 2: // Assign result for return ordinal #2
			varA7E53CE21691AB073D9660D615818899_462959774 = varB4EAC82CA7396A68D541C85D26508E83_1067709877;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_462959774 = varB4EAC82CA7396A68D541C85D26508E83_297758736;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_462959774.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_462959774;
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.843 -0400", hash_original_method = "7F7B3246FDA8DADD28F39102743A1FDB", hash_generated_method = "882408FC1FCB1FC6A28D4EDD8E7E8E39")
	public final Parcelable[] readParcelableArray(ClassLoader loader) {
		Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_436141177 = null; // Variable
																			// for
																			// return
																			// #1
		Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_771677713 = null; // Variable
																			// for
																			// return
																			// #2
		int N = readInt();
		{
			varB4EAC82CA7396A68D541C85D26508E83_436141177 = null;
		} // End block
		Parcelable[] p = new Parcelable[N];
		{
			int i = 0;
			{
				p[i] = (Parcelable) readParcelable(loader);
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_771677713 = p;
		addTaint(loader.getTaint());
		Parcelable[] varA7E53CE21691AB073D9660D615818899_1162640187; // Final
																		// return
																		// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_1162640187 = varB4EAC82CA7396A68D541C85D26508E83_436141177;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_1162640187 = varB4EAC82CA7396A68D541C85D26508E83_771677713;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_1162640187.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_1162640187;
		// ---------- Original Method ----------
		// int N = readInt();
		// if (N < 0) {
		// return null;
		// }
		// Parcelable[] p = new Parcelable[N];
		// for (int i = 0; i < N; i++) {
		// p[i] = (Parcelable) readParcelable(loader);
		// }
		// return p;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.844 -0400", hash_original_method = "71C92188775A0F7E9317C601C7CC8BB5", hash_generated_method = "42511A77D4B1277BF46061731CE9C39C")
	public final Serializable readSerializable() {
		Serializable varB4EAC82CA7396A68D541C85D26508E83_900333484 = null; // Variable
																			// for
																			// return
																			// #1
		Serializable varB4EAC82CA7396A68D541C85D26508E83_1967018485 = null; // Variable
																			// for
																			// return
																			// #2
		String name = readString();
		{
			varB4EAC82CA7396A68D541C85D26508E83_900333484 = null;
		} // End block
		byte[] serializedData = createByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
		try {
			ObjectInputStream ois = new ObjectInputStream(bais);
			varB4EAC82CA7396A68D541C85D26508E83_1967018485 = (Serializable) ois.readObject();
		} // End block
		catch (IOException ioe) {
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Parcelable encountered " + "IOException reading a Serializable object (name = " + name + ")", ioe);
		} // End block
		catch (ClassNotFoundException cnfe) {
			if (DroidSafeAndroidRuntime.control)
				throw new RuntimeException("Parcelable encountered" + "ClassNotFoundException reading a Serializable object (name = " + name + ")", cnfe);
		} // End block
		Serializable varA7E53CE21691AB073D9660D615818899_2021129513; // Final
																		// return
																		// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_2021129513 = varB4EAC82CA7396A68D541C85D26508E83_900333484;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_2021129513 = varB4EAC82CA7396A68D541C85D26508E83_1967018485;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_2021129513.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varA7E53CE21691AB073D9660D615818899_2021129513;
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	static protected final Parcel obtain(int obj) {
		final Parcel[] pool = sHolderPool;
		synchronized (pool) {
			Parcel p;
			for (int i = 0; i < POOL_SIZE; i++) {
				p = pool[i];
				if (p != null) {
					pool[i] = null;
					if (DEBUG_RECYCLE) {
						p.mStack = new RuntimeException();
					}
					p.init(obj);
					return p;
				}
			}
		}
		return new Parcel(obj);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.845 -0400", hash_original_method = "8123E4A6E665502F6F718041F61607F2", hash_generated_method = "CB3AB49BF1BB21FE6CF409EBFB0090B3")
	@Override
	protected void finalize() throws Throwable {
		destroy();
		// ---------- Original Method ----------
		// if (DEBUG_RECYCLE) {
		// if (mStack != null) {
		// Log.w(TAG, "Client did not call Parcel.recycle()", mStack);
		// }
		// }
		// destroy();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.845 -0400", hash_original_method = "C0427B473F1AF57292972C32F441E719", hash_generated_method = "61A4E66F7E3CD1708E9FB208543A8E37")
	private void freeBuffer() {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.846 -0400", hash_original_method = "70F6A5F1801DEC2DB8BE38968C81061C", hash_generated_method = "2B68B9C20AB085D1D67AAC97913FD822")
	private void init(int obj) {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.846 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "870C0C4D9949E316DFA0E367EFD712A9")
	private void destroy() {
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.846 -0400", hash_original_method = "377C79A0AFFA00A75F96A5842171AC58", hash_generated_method = "4B9A23A5F06E09E3E250AB4A9539D654")
	void readMapInternal(Map outVal, int N, ClassLoader loader) {
		{
			Object key = readValue(loader);
			Object value = readValue(loader);
			outVal.put(key, value);
		} // End block
		addTaint(outVal.getTaint());
		addTaint(N);
		addTaint(loader.getTaint());
		// ---------- Original Method ----------
		// while (N > 0) {
		// Object key = readValue(loader);
		// Object value = readValue(loader);
		// outVal.put(key, value);
		// N--;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.847 -0400", hash_original_method = "9EEE2505D88E68CC65378BE9FEB363CC", hash_generated_method = "C3DDBC1DA80EBB50B48A827FDC0D2353")
	private void readListInternal(List outVal, int N, ClassLoader loader) {
		{
			Object value = readValue(loader);
			outVal.add(value);
		} // End block
		addTaint(outVal.getTaint());
		addTaint(N);
		addTaint(loader.getTaint());
		// ---------- Original Method ----------
		// while (N > 0) {
		// Object value = readValue(loader);
		// outVal.add(value);
		// N--;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.848 -0400", hash_original_method = "8048910DC1D629DD4CA2AB6051E757D5", hash_generated_method = "53D16C40149542FDB787F6413EC7F88F")
	private void readArrayInternal(Object[] outVal, int N, ClassLoader loader) {
		{
			int i = 0;
			{
				Object value = readValue(loader);
				outVal[i] = value;
			} // End block
		} // End collapsed parenthetic
		addTaint(outVal[0].getTaint());
		addTaint(N);
		addTaint(loader.getTaint());
		// ---------- Original Method ----------
		// for (int i = 0; i < N; i++) {
		// Object value = readValue(loader);
		// outVal[i] = value;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.848 -0400", hash_original_method = "43DDAB261C65CF1F1B4E5B19576BB376", hash_generated_method = "B4D5B9DE693BAA74BA9255235886081D")
	private void readSparseArrayInternal(SparseArray outVal, int N, ClassLoader loader) {
		{
			int key = readInt();
			Object value = readValue(loader);
			outVal.append(key, value);
		} // End block
		addTaint(outVal.getTaint());
		addTaint(N);
		addTaint(loader.getTaint());
		// ---------- Original Method ----------
		// while (N > 0) {
		// int key = readInt();
		// Object value = readValue(loader);
		// outVal.append(key, value);
		// N--;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_method = "687B1CF2F9242ACE26C54A0109BE177B", hash_generated_method = "791C42C924954608147774279732E9E7")
	private void readSparseBooleanArrayInternal(SparseBooleanArray outVal, int N) {
		{
			int key = readInt();
			boolean value = this.readByte() == 1;
			outVal.append(key, value);
		} // End block
		addTaint(outVal.getTaint());
		addTaint(N);
		// ---------- Original Method ----------
		// while (N > 0) {
		// int key = readInt();
		// boolean value = this.readByte() == 1;
		// outVal.append(key, value);
		// N--;
		// }
	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "A71BA10A20EF888B1EF8CA16D55D9309", hash_generated_field = "4C4C82AEA5D9854FC45DA5375C35C2B9")
	private static final boolean DEBUG_RECYCLE = false;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "B28A49621CF2334B275ADEDF6302D3FE", hash_generated_field = "8D4BB406013288DABCF21E3086232FF0")
	private static final String TAG = "Parcel";
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "8CC9C9BA8E0F199B497EC24ADC83BF65", hash_generated_field = "806F090E7CB08EA4F7BB25E21BB089B9")
	private static final int POOL_SIZE = 6;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "C8932CF14EADE23425A9D54B122FD8C9", hash_generated_field = "2B06E04682E05687F5FE1F91A80B5001")
	private static final Parcel[] sOwnedPool = new Parcel[POOL_SIZE];
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "7D0A268CFF89FF45FBD851483F1AA181", hash_generated_field = "6A8EC49B77FA2982F6172D9088BEE965")
	private static final Parcel[] sHolderPool = new Parcel[POOL_SIZE];
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "ACEA6349EAE0AE22FE138A1505C3AC43", hash_generated_field = "C083E5876DACD70ACA563A851C9BF80A")
	private static final int VAL_NULL = -1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "A383EB6C18224D1E8B49FDE74C52AD41", hash_generated_field = "45F7F878732CA50D8D10532C9B029700")
	private static final int VAL_STRING = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "90D1816FAD55D60EA32349F44BEE1FA1", hash_generated_field = "3105C6E283A2C8969131A51B9084E315")
	private static final int VAL_INTEGER = 1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "AE858B0C1836E5CD5EA56F704DF57D42", hash_generated_field = "1E3EDA05CA698B82AB90723508DE126A")
	private static final int VAL_MAP = 2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "31533D34B6E9C81E65DCAE4C34B5EE04", hash_generated_field = "77D016C4104C510EB61EAD16649E4B98")
	private static final int VAL_BUNDLE = 3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "25D66E9FE0A96FA5502CB8C017BA33A7", hash_generated_field = "A89ABF4349986B7E1CF429EF8B150F43")
	private static final int VAL_PARCELABLE = 4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "E4BD524F34367626F9C7CD376225C7FB", hash_generated_field = "97F320554483CFA3BD525573C34EEBF6")
	private static final int VAL_SHORT = 5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "5DEC1A4B3D9350FA566473650ABEDC26", hash_generated_field = "F2505784946CF430B6454C933AA64E43")
	private static final int VAL_LONG = 6;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "7C773DA5B01AAAE7B478B5183F72E7A5", hash_generated_field = "15249D8B4B676F2BF7A97F24D427B5AA")
	private static final int VAL_FLOAT = 7;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "B9673347A98E9E4F53B2D7677F3DB072", hash_generated_field = "1E7C612DDB2B7EF1312E741523E53799")
	private static final int VAL_DOUBLE = 8;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "CF553E461BBB2ACE9C33C7AE3EC116BF", hash_generated_field = "E46F341BE0E2D054D53CDEAD96F1959D")
	private static final int VAL_BOOLEAN = 9;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "C4EFFF2F54E9F7853F6083EFC9E9D109", hash_generated_field = "B7D4E411492999EB4EA9BF2AC586F223")
	private static final int VAL_CHARSEQUENCE = 10;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "CF19CCA45146ED659BC8BE0770B83850", hash_generated_field = "D4F1A8A9E0CE0974E2412812F0DA3F5D")
	private static final int VAL_LIST = 11;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "A48C77C1642DC44BF3193BE6A03A4F27", hash_generated_field = "A131BD3EB211C05E3C6DF73570243AEC")
	private static final int VAL_SPARSEARRAY = 12;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "7A27992AF9A0ABD9406AFAD7F69432D1", hash_generated_field = "B0915F7A6E4DB352FA67870120FDC8AE")
	private static final int VAL_BYTEARRAY = 13;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "D293DEB200879D8E15F5D077CCFC795E", hash_generated_field = "076CE7EDAA5BD7403EB30339E6786640")
	private static final int VAL_STRINGARRAY = 14;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "7864638DD0ECA8DB5FEA6648DBAC22C7", hash_generated_field = "4E84FC4E833FD58450A808B308F569C1")
	private static final int VAL_IBINDER = 15;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "8FF06F86C8A1DC58010E03FFF27D61BF", hash_generated_field = "0D7C7CC2E878323D6F87D50D47E3E125")
	private static final int VAL_PARCELABLEARRAY = 16;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "8DA9E444EB65D0B5DBF7F59EF7B370BB", hash_generated_field = "6AC2F3E2A41C5CBB0C87EBFBA40C82C5")
	private static final int VAL_OBJECTARRAY = 17;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "6857A57259DB7027514CD5286F44AA3D", hash_generated_field = "CCE7A715FCB460D5B4607A19AB0D3775")
	private static final int VAL_INTARRAY = 18;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "03AC5509ED82DD27DDD80111B0D6F105", hash_generated_field = "32BC10EA8947FB3B0761472950236075")
	private static final int VAL_LONGARRAY = 19;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "E4540E289F5D42A14E7DC05C4CA668C0", hash_generated_field = "8007D2C64A8C971CD877A22E5B760585")
	private static final int VAL_BYTE = 20;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "2E1327ABAE1B48B171CC4B553304BEA1", hash_generated_field = "69C2B09C1800B12048056C3570CC73EE")
	private static final int VAL_SERIALIZABLE = 21;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.849 -0400", hash_original_field = "A124CA776792D53D93CEC75233DBCF6A", hash_generated_field = "76413C216A3003CB555A68458846A3B3")
	private static final int VAL_SPARSEBOOLEANARRAY = 22;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "696AF07A4832CE39E55C7E5208DB7A0B", hash_generated_field = "59D72A13D8A7453CC576337F712A9C20")
	private static final int VAL_BOOLEANARRAY = 23;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "FF01C04E922A7030EA9D324CCA0814E4", hash_generated_field = "9EFA3FF92CCB2C8FEE3D6C5358430431")
	private static final int VAL_CHARSEQUENCEARRAY = 24;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "3565AB005C087B9C54508E43A859B614", hash_generated_field = "A3D419976A9106B09BDA82EB2BFFD162")
	private static final int EX_SECURITY = -1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "02188DB64D8756EDBDBEB9D7F6FE9E72", hash_generated_field = "F8C2B1DD68AD90CB95C1595F2C9A5242")
	private static final int EX_BAD_PARCELABLE = -2;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "4377EB88638F3CE9554BB7F18D23AE22", hash_generated_field = "CB37D327BBB5DFC9C44E983C8B41B091")
	private static final int EX_ILLEGAL_ARGUMENT = -3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "2A43B7B02F2CF68642F5BDF80DED8567", hash_generated_field = "5990AECC0626B57467FE5BBFA45A5C36")
	private static final int EX_NULL_POINTER = -4;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "6E8C36F4CB9BC94CE915825BFAAF4E3B", hash_generated_field = "336D3C5B9AFBD7D73F11E5473530DAD0")
	private static final int EX_ILLEGAL_STATE = -5;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "E1BCE24EB8484F3581021F6250445299", hash_generated_field = "DFC9983F0C453250258C48F81D356118")
	private static final int EX_HAS_REPLY_HEADER = -128;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "2D365FB9C0F84B811EE25074666800D6", hash_generated_field = "FB53F9F5DC3AAFE064E58E049D0C49AF")
	public final static Parcelable.Creator<String> STRING_CREATOR = new Parcelable.Creator<String>() {
		public String createFromParcel(Parcel source) {
			return source.readString();
		}

		public String[] newArray(int size) {
			return new String[size];
		}
	};
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.850 -0400", hash_original_field = "EAE59FB152640F6C5452B3D15C76FF4C", hash_generated_field = "30232A053737FDB52FF30B185E9D15EC")
	private static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator>> mCreators = new HashMap<ClassLoader, HashMap<String, Parcelable.Creator>>();

	// orphaned legacy method
	public String createFromParcel(Parcel source) {
		return source.readString();
	}

	// orphaned legacy method
	public String[] newArray(int size) {
		return new String[size];
	}

}
