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
    @SuppressWarnings({"UnusedDeclaration"}) private int mObject;
    @SuppressWarnings({"UnusedDeclaration"}) private int mOwnObject;
    private RuntimeException mStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.975 -0400", hash_original_method = "96328320E65E9E5C73AE1A423ABA09C7", hash_generated_method = "57A60F4A70685317C40FE87B7CAC04E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Parcel(int obj) {
        dsTaint.addTaint(obj);
        {
            mStack = new RuntimeException();
        } //End block
        init(obj);
        // ---------- Original Method ----------
        //if (DEBUG_RECYCLE) {
            //mStack = new RuntimeException();
        //}
        //init(obj);
    }

    
        public static Parcel obtain() {
        final Parcel[] pool = sOwnedPool;
        synchronized (pool) {
            Parcel p;
            for (int i=0; i<POOL_SIZE; i++) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.975 -0400", hash_original_method = "0B6C271774CE05661982DF3B6AC078FF", hash_generated_method = "FFB9A2A5872308A85CBFAE99E476A46C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void recycle() {
        mStack = null;
        freeBuffer();
        Parcel[] pool;
        pool = sOwnedPool;
        pool = sHolderPool;
        {
            {
                int i;
                i = 0;
                {
                    {
                        pool[i] = this;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG_RECYCLE) mStack = null;
        //freeBuffer();
        //final Parcel[] pool = mOwnObject != 0 ? sOwnedPool : sHolderPool;
        //synchronized (pool) {
            //for (int i=0; i<POOL_SIZE; i++) {
                //if (pool[i] == null) {
                    //pool[i] = this;
                    //return;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.975 -0400", hash_original_method = "DD534262B78755109918F5DCE98072D4", hash_generated_method = "C489A5D49C9521CDC1795FF0CDB9C97A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataSize() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.975 -0400", hash_original_method = "0316AB8FD0A1B068176256EC0E481A72", hash_generated_method = "9F2FBAD37A0F2055B3E7EADC9882ACA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataAvail() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.976 -0400", hash_original_method = "D1BE237E96D29A914DD3E05EDFD3F272", hash_generated_method = "B0084F1274E1E201AD5CF0A55E1990B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataPosition() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.976 -0400", hash_original_method = "51F0EF05154419C189F36E1902F5F7AB", hash_generated_method = "24A73639D9D22CED73CF3DF59DD1AFA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataCapacity() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.976 -0400", hash_original_method = "D8CB87D9AB1E01DFD8357CBF456AE1C5", hash_generated_method = "A40908A631403E482291B84EF95E7807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDataSize(int size) {
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.976 -0400", hash_original_method = "900D9C4DE4FE3C2709BAAFC39AA9B06F", hash_generated_method = "779E878A8ED3DF460008E1ED6AC8B1C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDataPosition(int pos) {
        dsTaint.addTaint(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.977 -0400", hash_original_method = "E063261D5EA5083378CEC188A4B78FE0", hash_generated_method = "BDB6FBC603CA1E7ADB6F7475CBAA952E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDataCapacity(int size) {
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.977 -0400", hash_original_method = "97650A42F80764D7062D6C7A9EDB6E4B", hash_generated_method = "C847343659A6473C04E0D236AC7F9A1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean pushAllowFds(boolean allowFds) {
        dsTaint.addTaint(allowFds);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.977 -0400", hash_original_method = "D9541DA181394F49233EDC85EBA11372", hash_generated_method = "14B39C35E930877E20CEF5E74C960C04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void restoreAllowFds(boolean lastValue) {
        dsTaint.addTaint(lastValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.977 -0400", hash_original_method = "203FAAB8CBC9466E61C8672BA6829403", hash_generated_method = "175CE96461D92F0DF3D9C5D10E04E097")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] marshall() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.977 -0400", hash_original_method = "54EF2A5E543EFE1E280A4B6A4F3098CB", hash_generated_method = "C83E98FF3AC792D81D080E092105A230")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void unmarshall(byte[] data, int offest, int length) {
        dsTaint.addTaint(offest);
        dsTaint.addTaint(length);
        dsTaint.addTaint(data[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.978 -0400", hash_original_method = "E8A5DF9275FDA0D9B0B70C7334CB1E59", hash_generated_method = "73E7700E55C8A79E942C328B213005F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void appendFrom(Parcel parcel, int offset, int length) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.978 -0400", hash_original_method = "A1C2B053FCB3ADAB79F2D704E198BAB1", hash_generated_method = "8E3E6A262BCB3731F8E46D986DC4BFFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasFileDescriptors() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.978 -0400", hash_original_method = "EBD07D08BBA21F0C5B4E86C34DC5CAC1", hash_generated_method = "D2F7C1BFFBCC5788AD6A16B8FADAD99F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeInterfaceToken(String interfaceName) {
        dsTaint.addTaint(interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.978 -0400", hash_original_method = "5F95BF99C2626C7B3640C2D1B3B7BEE7", hash_generated_method = "AB308B325DDDC5B09E062CDD65C2D20F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void enforceInterface(String interfaceName) {
        dsTaint.addTaint(interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.978 -0400", hash_original_method = "6AA57281F567FED2151D4FF51C5ADD5D", hash_generated_method = "41A2F5C461CC41C491CF0F36AAD769CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeByteArray(byte[] b) {
        dsTaint.addTaint(b[0]);
        writeByteArray(b, 0, (b != null) ? b.length : 0);
        // ---------- Original Method ----------
        //writeByteArray(b, 0, (b != null) ? b.length : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.979 -0400", hash_original_method = "292A0D9A6E9AD589E2915A38A2AF794D", hash_generated_method = "E6B3C96148104491F6380583AE56AE4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeByteArray(byte[] b, int offset, int len) {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            writeInt(-1);
        } //End block
        Arrays.checkOffsetAndCount(b.length, offset, len);
        writeNative(b, offset, len);
        // ---------- Original Method ----------
        //if (b == null) {
            //writeInt(-1);
            //return;
        //}
        //Arrays.checkOffsetAndCount(b.length, offset, len);
        //writeNative(b, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.979 -0400", hash_original_method = "13EF9FAE46E0DC273567B76840FE8431", hash_generated_method = "35BEA743119F28EA2555E594EB40C502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeNative(byte[] b, int offset, int len) {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.979 -0400", hash_original_method = "EB7F50F11C67DFE7362846314C368039", hash_generated_method = "35EEC0A27503ED95643DF326AFBF4DF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeInt(int val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.979 -0400", hash_original_method = "6EE9E92592584E19EA2786245476EB1F", hash_generated_method = "8FF91417EC9F7DFBD44FF01E8EF4053D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeLong(long val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.979 -0400", hash_original_method = "8E6A3106AB0C4A6CA5D134BC13C79A46", hash_generated_method = "6D9AEC4EFE17E5CE98EF636FFE677BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloat(float val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.980 -0400", hash_original_method = "580EB112F6684AC838EF0FAE39FE6143", hash_generated_method = "99841A3F9806EDB380A39D4BB2B1E1A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDouble(double val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.980 -0400", hash_original_method = "148FED92CD1AE4975AE2973407FF84B1", hash_generated_method = "64CC817B70450E8047A7127A95E18C23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeString(String val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.980 -0400", hash_original_method = "CEAF068B566AB67AE8F044276645F78A", hash_generated_method = "1CBF73DCAF53DBAC77615348DBECB889")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeCharSequence(CharSequence val) {
        dsTaint.addTaint(val);
        TextUtils.writeToParcel(val, this, 0);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(val, this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.980 -0400", hash_original_method = "7DA1E5E6DC1856828FF2B443CF2EA2D0", hash_generated_method = "1C3342A7610B31B878AA2285E93E8B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeStrongBinder(IBinder val) {
        dsTaint.addTaint(val.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.980 -0400", hash_original_method = "D29D74B8509F3EDC680AC67A58B2AE11", hash_generated_method = "8EFFE908336CBE43422C9FEFD492D2CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeStrongInterface(IInterface val) {
        dsTaint.addTaint(val.dsTaint);
        writeStrongBinder(val == null ? null : val.asBinder());
        // ---------- Original Method ----------
        //writeStrongBinder(val == null ? null : val.asBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.981 -0400", hash_original_method = "F228581B9954F98E592DA68C1EE89409", hash_generated_method = "67571D25636EE10FF06E4B540B84CD40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFileDescriptor(FileDescriptor val) {
        dsTaint.addTaint(val.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.981 -0400", hash_original_method = "B137ADD0EA125F15A647DF5EEF6060FE", hash_generated_method = "F11A11933007DA8090856CFAC5CE2D26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeByte(byte val) {
        dsTaint.addTaint(val);
        writeInt(val);
        // ---------- Original Method ----------
        //writeInt(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.981 -0400", hash_original_method = "028C08B0E96835B592DD57E92E1A9654", hash_generated_method = "2EE1AFBFA8C365A25C7A6D6BC006A72B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeMap(Map val) {
        dsTaint.addTaint(val.dsTaint);
        writeMapInternal((Map<String,Object>) val);
        // ---------- Original Method ----------
        //writeMapInternal((Map<String,Object>) val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.985 -0400", hash_original_method = "254CF4BDBF55D33C4656934F15F7844A", hash_generated_method = "63711C62C889462411F9681BE1966693")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void writeMapInternal(Map<String,Object> val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        Set<Map.Entry<String,Object>> entries;
        entries = val.entrySet();
        writeInt(entries.size());
        {
            Iterator<Map.Entry<String,Object>> var0067E06DB1A13B6A25DDEC4BA2402C0D_1939167971 = (entries).iterator();
            var0067E06DB1A13B6A25DDEC4BA2402C0D_1939167971.hasNext();
            Map.Entry<String,Object> e = var0067E06DB1A13B6A25DDEC4BA2402C0D_1939167971.next();
            {
                writeValue(e.getKey());
                writeValue(e.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //Set<Map.Entry<String,Object>> entries = val.entrySet();
        //writeInt(entries.size());
        //for (Map.Entry<String,Object> e : entries) {
            //writeValue(e.getKey());
            //writeValue(e.getValue());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.985 -0400", hash_original_method = "1B271C6B96886293B3F46C86D8594D62", hash_generated_method = "874ECC22D4CF768CC2CB93E1F2674945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBundle(Bundle val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        val.writeToParcel(this, 0);
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //val.writeToParcel(this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.985 -0400", hash_original_method = "E7219AA1C86EB1036E36A514DFF44066", hash_generated_method = "045A557B25063272D591E9F54957B544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeList(List val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.size();
        int i;
        i = 0;
        writeInt(N);
        {
            writeValue(val.get(i));
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.size();
        //int i=0;
        //writeInt(N);
        //while (i < N) {
            //writeValue(val.get(i));
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.986 -0400", hash_original_method = "903390B15749D4F099959DBD9D939641", hash_generated_method = "0EE7CBF76065353AB4D5E63E28184858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeArray(Object[] val) {
        dsTaint.addTaint(val[0].dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.length;
        int i;
        i = 0;
        writeInt(N);
        {
            writeValue(val[i]);
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.length;
        //int i=0;
        //writeInt(N);
        //while (i < N) {
            //writeValue(val[i]);
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.986 -0400", hash_original_method = "932B15FDC26AECB59BA0DEB9D7727076", hash_generated_method = "645FED01A167CCE1B6469CC733B52419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeSparseArray(SparseArray<Object> val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.size();
        writeInt(N);
        int i;
        i = 0;
        {
            writeInt(val.keyAt(i));
            writeValue(val.valueAt(i));
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.size();
        //writeInt(N);
        //int i=0;
        //while (i < N) {
            //writeInt(val.keyAt(i));
            //writeValue(val.valueAt(i));
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.986 -0400", hash_original_method = "501AACE22AB4AEC41E440B95E2BF337F", hash_generated_method = "58275489326B9A9529219A65048C7004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeSparseBooleanArray(SparseBooleanArray val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.size();
        writeInt(N);
        int i;
        i = 0;
        {
            writeInt(val.keyAt(i));
            writeByte((byte)(val.valueAt(i) ? 1 : 0));
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.size();
        //writeInt(N);
        //int i=0;
        //while (i < N) {
            //writeInt(val.keyAt(i));
            //writeByte((byte)(val.valueAt(i) ? 1 : 0));
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.987 -0400", hash_original_method = "D75DEF1EB05EA54B4B0A6C775E789115", hash_generated_method = "3745ABD95F78230BD0075B96FDA9AED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBooleanArray(boolean[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeInt(val[i] ? 1 : 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeInt(val[i] ? 1 : 0);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.987 -0400", hash_original_method = "636C08B3912226F5C58D74422D1E9CB4", hash_generated_method = "A5A23A6C12CC4D557D85C65BB391BA82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean[] createBooleanArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_342890401 = (N >= 0 && N <= (dataAvail() >> 2));
            {
                boolean[] val;
                val = new boolean[N];
                {
                    int i;
                    i = 0;
                    {
                        val[i] = readInt() != 0;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0 && N <= (dataAvail() >> 2)) {
            //boolean[] val = new boolean[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readInt() != 0;
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.987 -0400", hash_original_method = "15202BE45A888A7FAE449643C1F651D3", hash_generated_method = "44482F0E6254BF40516891745D819EEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readBooleanArray(boolean[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readInt() != 0;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readInt() != 0;
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.988 -0400", hash_original_method = "FC1109029B4BAAFE0FA31EEEF8F95A5F", hash_generated_method = "C4BAF72D01AA0BFA8ADFDD3E653EBAF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeCharArray(char[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeInt((int)val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeInt((int)val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.988 -0400", hash_original_method = "0F2CB9A0B4BA672805C5DC7ABC31D142", hash_generated_method = "E4B15EA13613F724AEE094FBEBB651E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char[] createCharArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_527812833 = (N >= 0 && N <= (dataAvail() >> 2));
            {
                char[] val;
                val = new char[N];
                {
                    int i;
                    i = 0;
                    {
                        val[i] = (char)readInt();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0 && N <= (dataAvail() >> 2)) {
            //char[] val = new char[N];
            //for (int i=0; i<N; i++) {
                //val[i] = (char)readInt();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.988 -0400", hash_original_method = "3577ABA10B4218BCCE6B69B6327658D6", hash_generated_method = "0D64ED784731A456139ED865931619D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readCharArray(char[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = (char)readInt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = (char)readInt();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.988 -0400", hash_original_method = "426B3599371B897BFC6196C71A9C351C", hash_generated_method = "E1A959CBBEFFD0E38D21217DFCD0253E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeIntArray(int[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeInt(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeInt(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.989 -0400", hash_original_method = "2BFE53BE4AFBC39913D7CD537675C77F", hash_generated_method = "AC02EC2822D65F462A371B275E592F87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int[] createIntArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_1844937468 = (N >= 0 && N <= (dataAvail() >> 2));
            {
                int[] val;
                val = new int[N];
                {
                    int i;
                    i = 0;
                    {
                        val[i] = readInt();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0 && N <= (dataAvail() >> 2)) {
            //int[] val = new int[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readInt();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.989 -0400", hash_original_method = "D30E6FBEFEE072DBADEACBC994232724", hash_generated_method = "1A8F1E85D5000B77BE252C60244E9D55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readIntArray(int[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readInt();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readInt();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.989 -0400", hash_original_method = "6AE17F1911C710D67F0B38E1A6953312", hash_generated_method = "051D8BAA7B4A607C714CCC3B63E45B0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeLongArray(long[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeLong(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeLong(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.990 -0400", hash_original_method = "539AEF1878CDD8393DEC7B15A779334D", hash_generated_method = "68E00BCA64D6D7C6F1F1E30983874994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long[] createLongArray() {
        int N;
        N = readInt();
        {
            boolean varAFA9B411100B0C263F15734A2739C902_1758394661 = (N >= 0 && N <= (dataAvail() >> 3));
            {
                long[] val;
                val = new long[N];
                {
                    int i;
                    i = 0;
                    {
                        val[i] = readLong();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0 && N <= (dataAvail() >> 3)) {
            //long[] val = new long[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readLong();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.990 -0400", hash_original_method = "EB1FE051AE6270C29877E320D05D2B1C", hash_generated_method = "81436D511F714A89F777EC04C40FABAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readLongArray(long[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readLong();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readLong();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.991 -0400", hash_original_method = "914127CC1FF235613675A4097238AE87", hash_generated_method = "F6264F082DDF9035305322943F0E7316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloatArray(float[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeFloat(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeFloat(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.991 -0400", hash_original_method = "AD11D1594D734C1EBF478FFED3A5EA0B", hash_generated_method = "0A8F75C2C3B9F200AD5F55F39434D08C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float[] createFloatArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_537273768 = (N >= 0 && N <= (dataAvail() >> 2));
            {
                float[] val;
                val = new float[N];
                {
                    int i;
                    i = 0;
                    {
                        val[i] = readFloat();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0 && N <= (dataAvail() >> 2)) {
            //float[] val = new float[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readFloat();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.992 -0400", hash_original_method = "5BAAFA2155FE07D9BA992B0E92A02429", hash_generated_method = "17FCF48466754FDEDEDDFBD9904524F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readFloatArray(float[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readFloat();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readFloat();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.992 -0400", hash_original_method = "30BB607A5C46B583A0E7A88D0830BB99", hash_generated_method = "206A9900FB83EB700850049561009539")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDoubleArray(double[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeDouble(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeDouble(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.993 -0400", hash_original_method = "EADE9932A44C79075558F2C2E2C44BF9", hash_generated_method = "08718DA039F10930993CD8F02E451315")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double[] createDoubleArray() {
        int N;
        N = readInt();
        {
            boolean varAFA9B411100B0C263F15734A2739C902_887853327 = (N >= 0 && N <= (dataAvail() >> 3));
            {
                double[] val;
                val = new double[N];
                {
                    int i;
                    i = 0;
                    {
                        val[i] = readDouble();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0 && N <= (dataAvail() >> 3)) {
            //double[] val = new double[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readDouble();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.993 -0400", hash_original_method = "1E5CFF0988982B6DD3E5010F6E58EAB2", hash_generated_method = "262BCBBD242187DA0645B7CBA59423CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readDoubleArray(double[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readDouble();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readDouble();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.993 -0400", hash_original_method = "869784FDBD7A62BA6DC61589E5325593", hash_generated_method = "29276E9B124BF9BEDD675727505DF2C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeStringArray(String[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeString(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeString(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.994 -0400", hash_original_method = "E25A6435806EEE9817C8F94878902077", hash_generated_method = "C8D411EC5E51A9654E3168045D842977")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String[] createStringArray() {
        int N;
        N = readInt();
        {
            String[] val;
            val = new String[N];
            {
                int i;
                i = 0;
                {
                    val[i] = readString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0) {
            //String[] val = new String[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readString();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.994 -0400", hash_original_method = "856C598346084C5A7CB0C8EC3C30AFE8", hash_generated_method = "014040F55A7685712E11BD616AEE498A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readStringArray(String[] val) {
        dsTaint.addTaint(val[0]);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readString();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.994 -0400", hash_original_method = "EF4C8799E7CA7F11199E2A94E26473B3", hash_generated_method = "4F19E6C92E494BE4FE420A12D4AB2D3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBinderArray(IBinder[] val) {
        dsTaint.addTaint(val[0].dsTaint);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeStrongBinder(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeStrongBinder(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.995 -0400", hash_original_method = "47477B6B20C2841826851A1DC451409B", hash_generated_method = "0287BE4F597C1251065B771325A197D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeCharSequenceArray(CharSequence[] val) {
        dsTaint.addTaint(val[0]);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeCharSequence(val[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeCharSequence(val[i]);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.995 -0400", hash_original_method = "4DE08401A529CB5616CDC9DFD50DAFB3", hash_generated_method = "A8B002DAE98008B62F4B8151219145B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IBinder[] createBinderArray() {
        int N;
        N = readInt();
        {
            IBinder[] val;
            val = new IBinder[N];
            {
                int i;
                i = 0;
                {
                    val[i] = readStrongBinder();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (IBinder[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N >= 0) {
            //IBinder[] val = new IBinder[N];
            //for (int i=0; i<N; i++) {
                //val[i] = readStrongBinder();
            //}
            //return val;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.995 -0400", hash_original_method = "3E3D11ECAF89B0D6B7212074DA0FB112", hash_generated_method = "EB72B8A171CA1FC5C3C25BBCD3B5086A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readBinderArray(IBinder[] val) {
        dsTaint.addTaint(val[0].dsTaint);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    val[i] = readStrongBinder();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //val[i] = readStrongBinder();
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.996 -0400", hash_original_method = "5826C07CBD3614FC61FFE172F3E36C59", hash_generated_method = "554839F076282A99C036C64C5BF8D788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T extends Parcelable> void writeTypedList(List<T> val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.size();
        int i;
        i = 0;
        writeInt(N);
        {
            T item;
            item = val.get(i);
            {
                writeInt(1);
                item.writeToParcel(this, 0);
            } //End block
            {
                writeInt(0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.size();
        //int i=0;
        //writeInt(N);
        //while (i < N) {
            //T item = val.get(i);
            //if (item != null) {
                //writeInt(1);
                //item.writeToParcel(this, 0);
            //} else {
                //writeInt(0);
            //}
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.996 -0400", hash_original_method = "D0AECB36946CE861852315E400637CFF", hash_generated_method = "6D56B32C8516FF1142A9EA54946110E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeStringList(List<String> val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.size();
        int i;
        i = 0;
        writeInt(N);
        {
            writeString(val.get(i));
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.size();
        //int i=0;
        //writeInt(N);
        //while (i < N) {
            //writeString(val.get(i));
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.996 -0400", hash_original_method = "7137D7435CDB5CC040EE6A964998B66D", hash_generated_method = "953F2FF8AE3A8E4604BAF410DF8425F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBinderList(List<IBinder> val) {
        dsTaint.addTaint(val.dsTaint);
        {
            writeInt(-1);
        } //End block
        int N;
        N = val.size();
        int i;
        i = 0;
        writeInt(N);
        {
            writeStrongBinder(val.get(i));
        } //End block
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //int N = val.size();
        //int i=0;
        //writeInt(N);
        //while (i < N) {
            //writeStrongBinder(val.get(i));
            //i++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.996 -0400", hash_original_method = "029988DBA55E380B93A4CDBDA2CB7F3E", hash_generated_method = "682558C1F82D73E9BFCAD4F11DEE2C30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T extends Parcelable> void writeTypedArray(T[] val,
            int parcelableFlags) {
        dsTaint.addTaint(val[0].dsTaint);
        dsTaint.addTaint(parcelableFlags);
        {
            int N;
            N = val.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    T item;
                    item = val[i];
                    {
                        writeInt(1);
                        item.writeToParcel(this, parcelableFlags);
                    } //End block
                    {
                        writeInt(0);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (val != null) {
            //int N = val.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //T item = val[i];
                //if (item != null) {
                    //writeInt(1);
                    //item.writeToParcel(this, parcelableFlags);
                //} else {
                    //writeInt(0);
                //}
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.997 -0400", hash_original_method = "D9566C4BE63552F29703FA1385C84129", hash_generated_method = "B1DDF9DA74AEAA1EE356DA9AF0E3FA68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeValue(Object v) {
        dsTaint.addTaint(v.dsTaint);
        {
            writeInt(VAL_NULL);
        } //End block
        {
            writeInt(VAL_STRING);
            writeString((String) v);
        } //End block
        {
            writeInt(VAL_INTEGER);
            writeInt((Integer) v);
        } //End block
        {
            writeInt(VAL_MAP);
            writeMap((Map) v);
        } //End block
        {
            writeInt(VAL_BUNDLE);
            writeBundle((Bundle) v);
        } //End block
        {
            writeInt(VAL_PARCELABLE);
            writeParcelable((Parcelable) v, 0);
        } //End block
        {
            writeInt(VAL_SHORT);
            writeInt(((Short) v).intValue());
        } //End block
        {
            writeInt(VAL_LONG);
            writeLong((Long) v);
        } //End block
        {
            writeInt(VAL_FLOAT);
            writeFloat((Float) v);
        } //End block
        {
            writeInt(VAL_DOUBLE);
            writeDouble((Double) v);
        } //End block
        {
            writeInt(VAL_BOOLEAN);
            writeInt((Boolean) v ? 1 : 0);
        } //End block
        {
            writeInt(VAL_CHARSEQUENCE);
            writeCharSequence((CharSequence) v);
        } //End block
        {
            writeInt(VAL_LIST);
            writeList((List) v);
        } //End block
        {
            writeInt(VAL_SPARSEARRAY);
            writeSparseArray((SparseArray) v);
        } //End block
        {
            writeInt(VAL_BOOLEANARRAY);
            writeBooleanArray((boolean[]) v);
        } //End block
        {
            writeInt(VAL_BYTEARRAY);
            writeByteArray((byte[]) v);
        } //End block
        {
            writeInt(VAL_STRINGARRAY);
            writeStringArray((String[]) v);
        } //End block
        {
            writeInt(VAL_CHARSEQUENCEARRAY);
            writeCharSequenceArray((CharSequence[]) v);
        } //End block
        {
            writeInt(VAL_IBINDER);
            writeStrongBinder((IBinder) v);
        } //End block
        {
            writeInt(VAL_PARCELABLEARRAY);
            writeParcelableArray((Parcelable[]) v, 0);
        } //End block
        {
            writeInt(VAL_OBJECTARRAY);
            writeArray((Object[]) v);
        } //End block
        {
            writeInt(VAL_INTARRAY);
            writeIntArray((int[]) v);
        } //End block
        {
            writeInt(VAL_LONGARRAY);
            writeLongArray((long[]) v);
        } //End block
        {
            writeInt(VAL_BYTE);
            writeInt((Byte) v);
        } //End block
        {
            writeInt(VAL_SERIALIZABLE);
            writeSerializable((Serializable) v);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Parcel: unable to marshal value " + v);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.998 -0400", hash_original_method = "A58184BC725C2FE85E17C583E1DA6016", hash_generated_method = "017755E8A428B26C5793738EDEE8E3CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeParcelable(Parcelable p, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(p.dsTaint);
        {
            writeString(null);
        } //End block
        String name;
        name = p.getClass().getName();
        writeString(name);
        p.writeToParcel(this, parcelableFlags);
        // ---------- Original Method ----------
        //if (p == null) {
            //writeString(null);
            //return;
        //}
        //String name = p.getClass().getName();
        //writeString(name);
        //p.writeToParcel(this, parcelableFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.998 -0400", hash_original_method = "BCB9F78F7EC1F484C61BF7865779B2F9", hash_generated_method = "ACC4747E3E6262ADDA2685D329C44266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeSerializable(Serializable s) {
        dsTaint.addTaint(s.dsTaint);
        {
            writeString(null);
        } //End block
        String name;
        name = s.getClass().getName();
        writeString(name);
        ByteArrayOutputStream baos;
        baos = new ByteArrayOutputStream();
        try 
        {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(baos);
            oos.writeObject(s);
            oos.close();
            writeByteArray(baos.toByteArray());
        } //End block
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Parcelable encountered " +
                "IOException writing serializable object (name = " + name +
                ")", ioe);
        } //End block
        // ---------- Original Method ----------
        //if (s == null) {
            //writeString(null);
            //return;
        //}
        //String name = s.getClass().getName();
        //writeString(name);
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //try {
            //ObjectOutputStream oos = new ObjectOutputStream(baos);
            //oos.writeObject(s);
            //oos.close();
            //writeByteArray(baos.toByteArray());
        //} catch (IOException ioe) {
            //throw new RuntimeException("Parcelable encountered " +
                //"IOException writing serializable object (name = " + name +
                //")", ioe);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.998 -0400", hash_original_method = "7DD11AC8769A37C0F9583E9AAFAA7192", hash_generated_method = "37B9DA4C88392626B400B78C4328FD81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeException(Exception e) {
        dsTaint.addTaint(e.dsTaint);
        int code;
        code = 0;
        {
            code = EX_SECURITY;
        } //End block
        {
            code = EX_BAD_PARCELABLE;
        } //End block
        {
            code = EX_ILLEGAL_ARGUMENT;
        } //End block
        {
            code = EX_NULL_POINTER;
        } //End block
        {
            code = EX_ILLEGAL_STATE;
        } //End block
        writeInt(code);
        StrictMode.clearGatheredViolations();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw (RuntimeException) e;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        writeString(e.getMessage());
        // ---------- Original Method ----------
        //int code = 0;
        //if (e instanceof SecurityException) {
            //code = EX_SECURITY;
        //} else if (e instanceof BadParcelableException) {
            //code = EX_BAD_PARCELABLE;
        //} else if (e instanceof IllegalArgumentException) {
            //code = EX_ILLEGAL_ARGUMENT;
        //} else if (e instanceof NullPointerException) {
            //code = EX_NULL_POINTER;
        //} else if (e instanceof IllegalStateException) {
            //code = EX_ILLEGAL_STATE;
        //}
        //writeInt(code);
        //StrictMode.clearGatheredViolations();
        //if (code == 0) {
            //if (e instanceof RuntimeException) {
                //throw (RuntimeException) e;
            //}
            //throw new RuntimeException(e);
        //}
        //writeString(e.getMessage());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.999 -0400", hash_original_method = "123C62676F5EFD49547DAF82EF108740", hash_generated_method = "93570DC3D4B078045ED137150941CB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeNoException() {
        {
            boolean var67AAFC75FFEDAFC4D52248FF88A9C8E7_2031018265 = (StrictMode.hasGatheredViolations());
            {
                writeInt(EX_HAS_REPLY_HEADER);
                int sizePosition;
                sizePosition = dataPosition();
                writeInt(0);
                StrictMode.writeGatheredViolationsToParcel(this);
                int payloadPosition;
                payloadPosition = dataPosition();
                setDataPosition(sizePosition);
                writeInt(payloadPosition - sizePosition);
                setDataPosition(payloadPosition);
            } //End block
            {
                writeInt(0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (StrictMode.hasGatheredViolations()) {
            //writeInt(EX_HAS_REPLY_HEADER);
            //final int sizePosition = dataPosition();
            //writeInt(0);  
            //StrictMode.writeGatheredViolationsToParcel(this);
            //final int payloadPosition = dataPosition();
            //setDataPosition(sizePosition);
            //writeInt(payloadPosition - sizePosition);  
            //setDataPosition(payloadPosition);
        //} else {
            //writeInt(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.999 -0400", hash_original_method = "82EBD768B4FCE70E559935E5298055BB", hash_generated_method = "F55C6933CEB93ACE162731DB834588A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readException() {
        int code;
        code = readExceptionCode();
        {
            String msg;
            msg = readString();
            readException(code, msg);
        } //End block
        // ---------- Original Method ----------
        //int code = readExceptionCode();
        //if (code != 0) {
            //String msg = readString();
            //readException(code, msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.999 -0400", hash_original_method = "38AAEB1276A409D21345CE71D5A4968D", hash_generated_method = "0F4A009FA5B8B7E7BDF6F45E0C7D6FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readExceptionCode() {
        int code;
        code = readInt();
        {
            int headerSize;
            headerSize = readInt();
            {
                StrictMode.readAndHandleBinderCallViolations(this);
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int code = readInt();
        //if (code == EX_HAS_REPLY_HEADER) {
            //int headerSize = readInt();
            //if (headerSize == 0) {
                //Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
            //} else {
                //StrictMode.readAndHandleBinderCallViolations(this);
            //}
            //return 0;
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.000 -0400", hash_original_method = "16B6C7096EAAE541E38738222303A695", hash_generated_method = "C25B9B6293E56E754C460B9DF95B5DFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readException(int code, String msg) {
        dsTaint.addTaint(code);
        dsTaint.addTaint(msg);
        //Begin case EX_SECURITY 
        if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
        //End case EX_SECURITY 
        //Begin case EX_BAD_PARCELABLE 
        if (DroidSafeAndroidRuntime.control) throw new BadParcelableException(msg);
        //End case EX_BAD_PARCELABLE 
        //Begin case EX_ILLEGAL_ARGUMENT 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(msg);
        //End case EX_ILLEGAL_ARGUMENT 
        //Begin case EX_NULL_POINTER 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(msg);
        //End case EX_NULL_POINTER 
        //Begin case EX_ILLEGAL_STATE 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(msg);
        //End case EX_ILLEGAL_STATE 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unknown exception code: " + code
                + " msg " + msg);
        // ---------- Original Method ----------
        //switch (code) {
            //case EX_SECURITY:
                //throw new SecurityException(msg);
            //case EX_BAD_PARCELABLE:
                //throw new BadParcelableException(msg);
            //case EX_ILLEGAL_ARGUMENT:
                //throw new IllegalArgumentException(msg);
            //case EX_NULL_POINTER:
                //throw new NullPointerException(msg);
            //case EX_ILLEGAL_STATE:
                //throw new IllegalStateException(msg);
        //}
        //throw new RuntimeException("Unknown exception code: " + code
                //+ " msg " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.000 -0400", hash_original_method = "97FB920EA9544B24495059FF8518145E", hash_generated_method = "4D27D11A07BD16D1BD00B62220B262D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readInt() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.000 -0400", hash_original_method = "88765326927052F47E1B04CC1A370299", hash_generated_method = "1BED32960CC7B30FFB0566915F909F77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long readLong() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.000 -0400", hash_original_method = "9BF95C525D78F630EDF572E34BF4D430", hash_generated_method = "0319B5675729D6F24FE91D7F2546EC22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float readFloat() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.000 -0400", hash_original_method = "FFE81D38F89970F2B0BAD4C68B43B4BA", hash_generated_method = "82AA2E162EED57F9D911FEF2C9C8EBEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double readDouble() {
        return dsTaint.getTaintDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.000 -0400", hash_original_method = "E5D101F44C406F4D63DCAF323A3DBE7A", hash_generated_method = "F7D4B4078EFF3339328CFA46C807C963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readString() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.001 -0400", hash_original_method = "1E262BAA6376F101519B67935298363E", hash_generated_method = "5F0F98F0644A8FFB46F230B0B1B9139E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence readCharSequence() {
        CharSequence var09AE683B7FDC546955A024D23E40E19D_1562930675 = (TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.001 -0400", hash_original_method = "5B57CBCFFAE68CC288C10DD7232B6ED1", hash_generated_method = "83B272477F5B18FDE0C84B6561812E6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IBinder readStrongBinder() {
        return (IBinder)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.001 -0400", hash_original_method = "624419D3E87C84C27536CFAE1C7248DF", hash_generated_method = "C1F55EA2F1A2FD7BAFD8E2B51A2AB813")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ParcelFileDescriptor readFileDescriptor() {
        FileDescriptor fd;
        fd = internalReadFileDescriptor();
        {
            Object varB83E08AB54891903402517AD6E315E36_896404013 = (new ParcelFileDescriptor(fd));
        } //End flattened ternary
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //FileDescriptor fd = internalReadFileDescriptor();
        //return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.001 -0400", hash_original_method = "33B415422717616FBFFA4D8F233FE3A4", hash_generated_method = "7D5582C3B6F1E2A7E9117AF4EF5C7609")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FileDescriptor internalReadFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
    }

    
        static FileDescriptor openFileDescriptor(String file,
            int mode) throws FileNotFoundException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static FileDescriptor dupFileDescriptor(FileDescriptor orig) throws IOException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static void closeFileDescriptor(FileDescriptor desc) throws IOException {
    }

    
        static void clearFileDescriptor(FileDescriptor desc) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.002 -0400", hash_original_method = "12B71841CE7C7BEB8DB394B4DC6EF58B", hash_generated_method = "CE62BAB0D0F45BA2C2E3E9C48C8C389C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte readByte() {
        byte varA3491D8E17C6029A18B5C5A7657736E0_125925747 = ((byte)(readInt() & 0xff));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte)(readInt() & 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.002 -0400", hash_original_method = "82825CDD252FB884333A0468F1B46F6F", hash_generated_method = "73814C12EFA23335E067919C67148854")
    @DSModeled(DSC.BAN)
    public final void readMap(Map outVal, ClassLoader loader) {
        dsTaint.addTaint(outVal.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        readMapInternal(outVal, N, loader);
        // ---------- Original Method ----------
        //int N = readInt();
        //readMapInternal(outVal, N, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.003 -0400", hash_original_method = "C60DBA65518C72AFC52918F8818E7A4A", hash_generated_method = "87C2F25E0240077FCF4966A0E56453D8")
    @DSModeled(DSC.BAN)
    public final void readList(List outVal, ClassLoader loader) {
        dsTaint.addTaint(outVal.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        readListInternal(outVal, N, loader);
        // ---------- Original Method ----------
        //int N = readInt();
        //readListInternal(outVal, N, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.003 -0400", hash_original_method = "0DC8809E3B9E75AF0CC28567E6782BE5", hash_generated_method = "6C09DF5FA92EF6872DC6CCE1138343E5")
    @DSModeled(DSC.BAN)
    public final HashMap readHashMap(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        HashMap m;
        m = new HashMap(N);
        readMapInternal(m, N, loader);
        return (HashMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //HashMap m = new HashMap(N);
        //readMapInternal(m, N, loader);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.003 -0400", hash_original_method = "30B879800FFE3D55BB9B30F39E994273", hash_generated_method = "DCAB8CF8EA9ECF92C31EDFF7612A2681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Bundle readBundle() {
        Bundle var9FCD0EFE653F67400EEFD6A452EB50FF_207692786 = (readBundle(null));
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readBundle(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.003 -0400", hash_original_method = "7DBD463E649AEA6A8616F4943C405C7A", hash_generated_method = "7CB5D3413A7CFE65AB4DD159F1BADFC7")
    @DSModeled(DSC.BAN)
    public final Bundle readBundle(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int length;
        length = readInt();
        Bundle bundle;
        bundle = new Bundle(this, length);
        {
            bundle.setClassLoader(loader);
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int length = readInt();
        //if (length < 0) {
            //return null;
        //}
        //final Bundle bundle = new Bundle(this, length);
        //if (loader != null) {
            //bundle.setClassLoader(loader);
        //}
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.003 -0400", hash_original_method = "DCFF48487CDF8628FF2244CC4810775C", hash_generated_method = "D29A79680C2294D02518727A5DDE6ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] createByteArray() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.004 -0400", hash_original_method = "40FE8430590711C6D2AB472A3973EA8A", hash_generated_method = "EECD3C4F5D816852F6AA013E99A7109D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readByteArray(byte[] val) {
        dsTaint.addTaint(val[0]);
        byte[] ba;
        ba = createByteArray();
        {
            System.arraycopy(ba, 0, val, 0, ba.length);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //byte[] ba = createByteArray();
        //if (ba.length == val.length) {
           //System.arraycopy(ba, 0, val, 0, ba.length);
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.004 -0400", hash_original_method = "3F4E1D573E001DD6503628882E161682", hash_generated_method = "69ABF5EB46BB43B0C00A73277BB909E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String[] readStringArray() {
        String[] array;
        array = null;
        int length;
        length = readInt();
        {
            array = new String[length];
            {
                int i;
                i = 0;
                {
                    array[i] = readString();
                } //End block
            } //End collapsed parenthetic
        } //End block
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //String[] array = null;
        //int length = readInt();
        //if (length >= 0)
        //{
            //array = new String[length];
            //for (int i = 0 ; i < length ; i++)
            //{
                //array[i] = readString();
            //}
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.004 -0400", hash_original_method = "0A6BC69D8060353BD0BABF3E9B4D1085", hash_generated_method = "E0D7AFFDBAA53AC1F1573CCF0649AC54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence[] readCharSequenceArray() {
        CharSequence[] array;
        array = null;
        int length;
        length = readInt();
        {
            array = new CharSequence[length];
            {
                int i;
                i = 0;
                {
                    array[i] = readCharSequence();
                } //End block
            } //End collapsed parenthetic
        } //End block
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //CharSequence[] array = null;
        //int length = readInt();
        //if (length >= 0)
        //{
            //array = new CharSequence[length];
            //for (int i = 0 ; i < length ; i++)
            //{
                //array[i] = readCharSequence();
            //}
        //}
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.004 -0400", hash_original_method = "0CB879EE6020D3E02716A43BE19D4D51", hash_generated_method = "794F5733049EC592E2A5D7CC48C8490B")
    @DSModeled(DSC.BAN)
    public final ArrayList readArrayList(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        ArrayList l;
        l = new ArrayList(N);
        readListInternal(l, N, loader);
        return (ArrayList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //ArrayList l = new ArrayList(N);
        //readListInternal(l, N, loader);
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.005 -0400", hash_original_method = "BFE5C5C5F5678C281D93BB53C31E26A0", hash_generated_method = "E421B10841DA6D15D95F93A403BA7E76")
    @DSModeled(DSC.BAN)
    public final Object[] readArray(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        Object[] l;
        l = new Object[N];
        readArrayInternal(l, N, loader);
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //Object[] l = new Object[N];
        //readArrayInternal(l, N, loader);
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.005 -0400", hash_original_method = "53952EC2EA973438719A76F49C86D9F1", hash_generated_method = "8A476B6C7F79A1BD97DB63359EDBEF15")
    @DSModeled(DSC.BAN)
    public final SparseArray readSparseArray(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        SparseArray sa;
        sa = new SparseArray(N);
        readSparseArrayInternal(sa, N, loader);
        return (SparseArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //SparseArray sa = new SparseArray(N);
        //readSparseArrayInternal(sa, N, loader);
        //return sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.005 -0400", hash_original_method = "04DCF387CF40E8397784231DC7CB64F8", hash_generated_method = "A5705A0A63081B1551A23D5169B8D000")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SparseBooleanArray readSparseBooleanArray() {
        int N;
        N = readInt();
        SparseBooleanArray sa;
        sa = new SparseBooleanArray(N);
        readSparseBooleanArrayInternal(sa, N);
        return (SparseBooleanArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //SparseBooleanArray sa = new SparseBooleanArray(N);
        //readSparseBooleanArrayInternal(sa, N);
        //return sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.006 -0400", hash_original_method = "456F7B8C59883BEB9D747B5AF3A070B1", hash_generated_method = "E093CF6632FB75A49CBDAB614FE355C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T> ArrayList<T> createTypedArrayList(Parcelable.Creator<T> c) {
        dsTaint.addTaint(c.dsTaint);
        int N;
        N = readInt();
        ArrayList<T> l;
        l = new ArrayList<T>(N);
        {
            {
                boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_1359038404 = (readInt() != 0);
                {
                    l.add(c.createFromParcel(this));
                } //End block
                {
                    l.add(null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ArrayList<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //ArrayList<T> l = new ArrayList<T>(N);
        //while (N > 0) {
            //if (readInt() != 0) {
                //l.add(c.createFromParcel(this));
            //} else {
                //l.add(null);
            //}
            //N--;
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.006 -0400", hash_original_method = "B9FCE8B620ADC76BF3A577C32D057CDB", hash_generated_method = "EB27C5E0F93CEDBEC39C8A5756DB8FD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T> void readTypedList(List<T> list, Parcelable.Creator<T> c) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(list.dsTaint);
        int M;
        M = list.size();
        int N;
        N = readInt();
        int i;
        i = 0;
        {
            {
                boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_586620296 = (readInt() != 0);
                {
                    list.set(i, c.createFromParcel(this));
                } //End block
                {
                    list.set(i, null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_1334791854 = (readInt() != 0);
                {
                    list.add(c.createFromParcel(this));
                } //End block
                {
                    list.add(null);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            list.remove(N);
        } //End block
        // ---------- Original Method ----------
        //int M = list.size();
        //int N = readInt();
        //int i = 0;
        //for (; i < M && i < N; i++) {
            //if (readInt() != 0) {
                //list.set(i, c.createFromParcel(this));
            //} else {
                //list.set(i, null);
            //}
        //}
        //for (; i<N; i++) {
            //if (readInt() != 0) {
                //list.add(c.createFromParcel(this));
            //} else {
                //list.add(null);
            //}
        //}
        //for (; i<M; i++) {
            //list.remove(N);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.006 -0400", hash_original_method = "6BB9790DD7CE6638433A98D5801460E1", hash_generated_method = "2D8A6121984A62F7CB6949EE5C58870C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ArrayList<String> createStringArrayList() {
        int N;
        N = readInt();
        ArrayList<String> l;
        l = new ArrayList<String>(N);
        {
            l.add(readString());
        } //End block
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //ArrayList<String> l = new ArrayList<String>(N);
        //while (N > 0) {
            //l.add(readString());
            //N--;
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.007 -0400", hash_original_method = "4AA47F929C1AD4C6AA4FF7E97EBA01C3", hash_generated_method = "F5B8626BD6D78CA0724D7C7C65138F6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ArrayList<IBinder> createBinderArrayList() {
        int N;
        N = readInt();
        ArrayList<IBinder> l;
        l = new ArrayList<IBinder>(N);
        {
            l.add(readStrongBinder());
        } //End block
        return (ArrayList<IBinder>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //ArrayList<IBinder> l = new ArrayList<IBinder>(N);
        //while (N > 0) {
            //l.add(readStrongBinder());
            //N--;
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.007 -0400", hash_original_method = "9CB504FEFB4242E237E17E2EB9A48FBD", hash_generated_method = "1F1C16477E9E9BF8D2D05C1FCF571A95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readStringList(List<String> list) {
        dsTaint.addTaint(list.dsTaint);
        int M;
        M = list.size();
        int N;
        N = readInt();
        int i;
        i = 0;
        {
            list.set(i, readString());
        } //End block
        {
            list.add(readString());
        } //End block
        {
            list.remove(N);
        } //End block
        // ---------- Original Method ----------
        //int M = list.size();
        //int N = readInt();
        //int i = 0;
        //for (; i < M && i < N; i++) {
            //list.set(i, readString());
        //}
        //for (; i<N; i++) {
            //list.add(readString());
        //}
        //for (; i<M; i++) {
            //list.remove(N);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.007 -0400", hash_original_method = "BD5E31C17A1894DBD3B1CCAA7C1D6816", hash_generated_method = "A3BFFDED1B0AACAAE5AC2CC14EE12221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readBinderList(List<IBinder> list) {
        dsTaint.addTaint(list.dsTaint);
        int M;
        M = list.size();
        int N;
        N = readInt();
        int i;
        i = 0;
        {
            list.set(i, readStrongBinder());
        } //End block
        {
            list.add(readStrongBinder());
        } //End block
        {
            list.remove(N);
        } //End block
        // ---------- Original Method ----------
        //int M = list.size();
        //int N = readInt();
        //int i = 0;
        //for (; i < M && i < N; i++) {
            //list.set(i, readStrongBinder());
        //}
        //for (; i<N; i++) {
            //list.add(readStrongBinder());
        //}
        //for (; i<M; i++) {
            //list.remove(N);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.008 -0400", hash_original_method = "3CEF6E6386B4F00BA8155F93C3068CB0", hash_generated_method = "5B64FFC22639041223C2C50799B56611")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T> T[] createTypedArray(Parcelable.Creator<T> c) {
        dsTaint.addTaint(c.dsTaint);
        int N;
        N = readInt();
        T[] l;
        l = c.newArray(N);
        {
            int i;
            i = 0;
            {
                {
                    boolean varF3F4117B020949AD5A99383C367C3DCB_596505353 = (readInt() != 0);
                    {
                        l[i] = c.createFromParcel(this);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //T[] l = c.newArray(N);
        //for (int i=0; i<N; i++) {
            //if (readInt() != 0) {
                //l[i] = c.createFromParcel(this);
            //}
        //}
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.008 -0400", hash_original_method = "94DCFDEC159CF16A54AB9BC1543AACB0", hash_generated_method = "E8A9C782BFF464C9D79DDBF348C9DAD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T> void readTypedArray(T[] val, Parcelable.Creator<T> c) {
        dsTaint.addTaint(val[0].dsTaint);
        dsTaint.addTaint(c.dsTaint);
        int N;
        N = readInt();
        {
            {
                int i;
                i = 0;
                {
                    {
                        boolean varDA2468261896472593A672B57BF55D76_598270221 = (readInt() != 0);
                        {
                            val[i] = c.createFromParcel(this);
                        } //End block
                        {
                            val[i] = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad array lengths");
        } //End block
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N == val.length) {
            //for (int i=0; i<N; i++) {
                //if (readInt() != 0) {
                    //val[i] = c.createFromParcel(this);
                //} else {
                    //val[i] = null;
                //}
            //}
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.009 -0400", hash_original_method = "6C2CF48F71A46FC325FBB3DF7C6E0C74", hash_generated_method = "A4C7D4FCDCDAAC4783368A4ACEC5999A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final <T> T[] readTypedArray(Parcelable.Creator<T> c) {
        dsTaint.addTaint(c.dsTaint);
        T[] varE2F2E33FF1456B068E2A0AD4222378A3_756923313 = (createTypedArray(c));
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createTypedArray(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.009 -0400", hash_original_method = "B6CF25F021EC35EAE7839E69AD502686", hash_generated_method = "F24400B37FD6F8F5A8C245039A606925")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T extends Parcelable> void writeParcelableArray(T[] value,
            int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(value[0].dsTaint);
        {
            int N;
            N = value.length;
            writeInt(N);
            {
                int i;
                i = 0;
                {
                    writeParcelable(value[i], parcelableFlags);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        //if (value != null) {
            //int N = value.length;
            //writeInt(N);
            //for (int i=0; i<N; i++) {
                //writeParcelable(value[i], parcelableFlags);
            //}
        //} else {
            //writeInt(-1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.010 -0400", hash_original_method = "BC2BD16709D000C887B8D48E60CFBD74", hash_generated_method = "C19671D157E021B9BE52FED3B48BD1CA")
    @DSModeled(DSC.BAN)
    public final Object readValue(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int type;
        type = readInt();
        //Begin case VAL_STRING 
        Object var47A9A8CCD823AA4FC350471F0CE0A4D9_2120472796 = (readString());
        //End case VAL_STRING 
        //Begin case VAL_INTEGER 
        Object varC5FB9EBDFD702CC2CBDEAB5FB7412A2B_588751371 = (readInt());
        //End case VAL_INTEGER 
        //Begin case VAL_MAP 
        Object varCB36CFAB316E49DEC6A95E3CDFA2C955_1675258535 = (readHashMap(loader));
        //End case VAL_MAP 
        //Begin case VAL_PARCELABLE 
        Object var81C62AF1D753B0568264BE3099E92A58_2089852713 = (readParcelable(loader));
        //End case VAL_PARCELABLE 
        //Begin case VAL_SHORT 
        Object varA670377579853C1DB5383F40B8ABE2F8_602995913 = ((short) readInt());
        //End case VAL_SHORT 
        //Begin case VAL_LONG 
        Object varB70BB8A0900FE4C9696A5298E5BA7FB0_1638636734 = (readLong());
        //End case VAL_LONG 
        //Begin case VAL_FLOAT 
        Object var1A5223190EBE1F207CF67E9121597E32_174200828 = (readFloat());
        //End case VAL_FLOAT 
        //Begin case VAL_DOUBLE 
        Object var2588635C6BECF8A2D9B29B0C372B2276_1450582051 = (readDouble());
        //End case VAL_DOUBLE 
        //Begin case VAL_BOOLEAN 
        Object varA87E838ED7C4F762D5AF3A5387493CA2_2020558780 = (readInt() == 1);
        //End case VAL_BOOLEAN 
        //Begin case VAL_CHARSEQUENCE 
        Object var5678622BBD5F12A6676C580BC56CCBB9_852630213 = (readCharSequence());
        //End case VAL_CHARSEQUENCE 
        //Begin case VAL_LIST 
        Object varCBB891A59619A1B4B4E1CF620B9FA670_2089824259 = (readArrayList(loader));
        //End case VAL_LIST 
        //Begin case VAL_BOOLEANARRAY 
        Object var8530F7223F0B29CE450D224343B048FC_1871570020 = (createBooleanArray());
        //End case VAL_BOOLEANARRAY 
        //Begin case VAL_BYTEARRAY 
        Object var0A10D8AFBF9DE328C71E3F31971EF1FD_466112243 = (createByteArray());
        //End case VAL_BYTEARRAY 
        //Begin case VAL_STRINGARRAY 
        Object var31F48A2A343436257E02B1C9C2596E69_454772639 = (readStringArray());
        //End case VAL_STRINGARRAY 
        //Begin case VAL_CHARSEQUENCEARRAY 
        Object varB715EE69CD0BD13EB2D234C8F8B0DE9D_1687025427 = (readCharSequenceArray());
        //End case VAL_CHARSEQUENCEARRAY 
        //Begin case VAL_IBINDER 
        Object var84347B990B5BD97A3751B9E6FF7A7E4C_1598720479 = (readStrongBinder());
        //End case VAL_IBINDER 
        //Begin case VAL_OBJECTARRAY 
        Object var98B7CD1D51AB7A9E018647E19EE11408_70882969 = (readArray(loader));
        //End case VAL_OBJECTARRAY 
        //Begin case VAL_INTARRAY 
        Object var9B770EC710CB092D4C15D3930AE89784_1091093573 = (createIntArray());
        //End case VAL_INTARRAY 
        //Begin case VAL_LONGARRAY 
        Object varB4F4B96DD8F6421883038FA5C4BF1893_1153356694 = (createLongArray());
        //End case VAL_LONGARRAY 
        //Begin case VAL_BYTE 
        Object var8CBBC12923715DCC37177943AB007F4D_1193129766 = (readByte());
        //End case VAL_BYTE 
        //Begin case VAL_SERIALIZABLE 
        Object varAB56E33CE4ED87672E7A74630AA5F595_2008320263 = (readSerializable());
        //End case VAL_SERIALIZABLE 
        //Begin case VAL_PARCELABLEARRAY 
        Object varA88A85626B2092C0698E1F3EF15DD193_1194494577 = (readParcelableArray(loader));
        //End case VAL_PARCELABLEARRAY 
        //Begin case VAL_SPARSEARRAY 
        Object var3C7CA5D427C57C7A3E723AE781E5498A_1141567398 = (readSparseArray(loader));
        //End case VAL_SPARSEARRAY 
        //Begin case VAL_SPARSEBOOLEANARRAY 
        Object varB95EF2623890BBA26DB5DB941C226CA3_438780697 = (readSparseBooleanArray());
        //End case VAL_SPARSEBOOLEANARRAY 
        //Begin case VAL_BUNDLE 
        Object varC28DE805DB11E75F1E7AEB0631CD7984_2133289827 = (readBundle(loader));
        //End case VAL_BUNDLE 
        //Begin case default 
        int off;
        off = dataPosition() - 4;
        //End case default 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Parcel " + this + ": Unmarshalling unknown type code " + type + " at offset " + off);
        //End case default 
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.011 -0400", hash_original_method = "973DB4BA749CEAB3796DAD314F27DB98", hash_generated_method = "C7D03C872B185E080002305B315220C5")
    @DSModeled(DSC.BAN)
    public final <T extends Parcelable> T readParcelable(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        String name;
        name = readString();
        Parcelable.Creator<T> creator;
        {
            HashMap<String,Parcelable.Creator> map;
            map = mCreators.get(loader);
            {
                map = new HashMap<String,Parcelable.Creator>();
                mCreators.put(loader, map);
            } //End block
            creator = map.get(name);
            {
                try 
                {
                    Class c;
                    c = Class.forName(name);
                    c = Class.forName(name, true, loader);
                    Field f;
                    f = c.getField("CREATOR");
                    creator = (Parcelable.Creator)f.get(null);
                } //End block
                catch (IllegalAccessException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new BadParcelableException(
                            "IllegalAccessException when unmarshalling: " + name);
                } //End block
                catch (ClassNotFoundException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new BadParcelableException(
                            "ClassNotFoundException when unmarshalling: " + name);
                } //End block
                catch (ClassCastException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new BadParcelableException("Parcelable protocol requires a "
                                        + "Parcelable.Creator object called "
                                        + " CREATOR on class " + name);
                } //End block
                catch (NoSuchFieldException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new BadParcelableException("Parcelable protocol requires a "
                                        + "Parcelable.Creator object called "
                                        + " CREATOR on class " + name);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new BadParcelableException("Parcelable protocol requires a "
                                        + "Parcelable.Creator object called "
                                        + " CREATOR on class " + name);
                } //End block
                map.put(name, creator);
            } //End block
        } //End block
        {
            T var04A095804F0DCA8BCDC30E7F0F81A79B_381489373 = (((Parcelable.ClassLoaderCreator<T>)creator).createFromParcel(this, loader));
        } //End block
        T var6422C3E9192CB4780F5712002153692A_1810843688 = (creator.createFromParcel(this));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.011 -0400", hash_original_method = "7F7B3246FDA8DADD28F39102743A1FDB", hash_generated_method = "3410A57621B8A048460ECF7F1C156AC4")
    @DSModeled(DSC.BAN)
    public final Parcelable[] readParcelableArray(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int N;
        N = readInt();
        Parcelable[] p;
        p = new Parcelable[N];
        {
            int i;
            i = 0;
            {
                p[i] = (Parcelable) readParcelable(loader);
            } //End block
        } //End collapsed parenthetic
        return (Parcelable[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //Parcelable[] p = new Parcelable[N];
        //for (int i = 0; i < N; i++) {
            //p[i] = (Parcelable) readParcelable(loader);
        //}
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.011 -0400", hash_original_method = "71C92188775A0F7E9317C601C7CC8BB5", hash_generated_method = "43183220CB8FA291D8DB639D5F0CE2DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Serializable readSerializable() {
        String name;
        name = readString();
        byte[] serializedData;
        serializedData = createByteArray();
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(serializedData);
        try 
        {
            ObjectInputStream ois;
            ois = new ObjectInputStream(bais);
            Serializable var4E7D88FB15C7BF67252F0C6970AC8FB2_1092588785 = ((Serializable) ois.readObject());
        } //End block
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Parcelable encountered " +
                "IOException reading a Serializable object (name = " + name +
                ")", ioe);
        } //End block
        catch (ClassNotFoundException cnfe)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Parcelable encountered" +
                "ClassNotFoundException reading a Serializable object (name = "
                + name + ")", cnfe);
        } //End block
        return (Serializable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static protected final Parcel obtain(int obj) {
        final Parcel[] pool = sHolderPool;
        synchronized (pool) {
            Parcel p;
            for (int i=0; i<POOL_SIZE; i++) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.012 -0400", hash_original_method = "8123E4A6E665502F6F718041F61607F2", hash_generated_method = "CB3AB49BF1BB21FE6CF409EBFB0090B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        destroy();
        // ---------- Original Method ----------
        //if (DEBUG_RECYCLE) {
            //if (mStack != null) {
                //Log.w(TAG, "Client did not call Parcel.recycle()", mStack);
            //}
        //}
        //destroy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.012 -0400", hash_original_method = "C0427B473F1AF57292972C32F441E719", hash_generated_method = "61A4E66F7E3CD1708E9FB208543A8E37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void freeBuffer() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.012 -0400", hash_original_method = "70F6A5F1801DEC2DB8BE38968C81061C", hash_generated_method = "33F1A2AAB805399E51FE7F9BC259EA10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(int obj) {
        dsTaint.addTaint(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.013 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "870C0C4D9949E316DFA0E367EFD712A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.013 -0400", hash_original_method = "377C79A0AFFA00A75F96A5842171AC58", hash_generated_method = "51747A1666695CC69EFC2A8FFE815DF5")
    @DSModeled(DSC.BAN)
     void readMapInternal(Map outVal, int N,
        ClassLoader loader) {
        dsTaint.addTaint(outVal.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(N);
        {
            Object key;
            key = readValue(loader);
            Object value;
            value = readValue(loader);
            outVal.put(key, value);
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //Object key = readValue(loader);
            //Object value = readValue(loader);
            //outVal.put(key, value);
            //N--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.013 -0400", hash_original_method = "9EEE2505D88E68CC65378BE9FEB363CC", hash_generated_method = "8B325B9A0EA2A9B987ADA85C60BABB9C")
    @DSModeled(DSC.BAN)
    private void readListInternal(List outVal, int N,
        ClassLoader loader) {
        dsTaint.addTaint(outVal.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(N);
        {
            Object value;
            value = readValue(loader);
            outVal.add(value);
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //Object value = readValue(loader);
            //outVal.add(value);
            //N--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.014 -0400", hash_original_method = "8048910DC1D629DD4CA2AB6051E757D5", hash_generated_method = "E3B978CAD012264BD6F95EDBC4CF7A15")
    @DSModeled(DSC.BAN)
    private void readArrayInternal(Object[] outVal, int N,
        ClassLoader loader) {
        dsTaint.addTaint(outVal[0].dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(N);
        {
            int i;
            i = 0;
            {
                Object value;
                value = readValue(loader);
                outVal[i] = value;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < N; i++) {
            //Object value = readValue(loader);
            //outVal[i] = value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.014 -0400", hash_original_method = "43DDAB261C65CF1F1B4E5B19576BB376", hash_generated_method = "4AB2612845A3C3EEF33DB06AD1CCFA0E")
    @DSModeled(DSC.BAN)
    private void readSparseArrayInternal(SparseArray outVal, int N,
        ClassLoader loader) {
        dsTaint.addTaint(outVal.dsTaint);
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(N);
        {
            int key;
            key = readInt();
            Object value;
            value = readValue(loader);
            outVal.append(key, value);
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //int key = readInt();
            //Object value = readValue(loader);
            //outVal.append(key, value);
            //N--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.015 -0400", hash_original_method = "687B1CF2F9242ACE26C54A0109BE177B", hash_generated_method = "4C89AA11C257335E68E7BB71990A540F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readSparseBooleanArrayInternal(SparseBooleanArray outVal, int N) {
        dsTaint.addTaint(outVal.dsTaint);
        dsTaint.addTaint(N);
        {
            int key;
            key = readInt();
            boolean value;
            value = this.readByte() == 1;
            outVal.append(key, value);
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //int key = readInt();
            //boolean value = this.readByte() == 1;
            //outVal.append(key, value);
            //N--;
        //}
    }

    
    private static final boolean DEBUG_RECYCLE = false;
    private static final String TAG = "Parcel";
    private static final int POOL_SIZE = 6;
    private static final Parcel[] sOwnedPool = new Parcel[POOL_SIZE];
    private static final Parcel[] sHolderPool = new Parcel[POOL_SIZE];
    private static final int VAL_NULL = -1;
    private static final int VAL_STRING = 0;
    private static final int VAL_INTEGER = 1;
    private static final int VAL_MAP = 2;
    private static final int VAL_BUNDLE = 3;
    private static final int VAL_PARCELABLE = 4;
    private static final int VAL_SHORT = 5;
    private static final int VAL_LONG = 6;
    private static final int VAL_FLOAT = 7;
    private static final int VAL_DOUBLE = 8;
    private static final int VAL_BOOLEAN = 9;
    private static final int VAL_CHARSEQUENCE = 10;
    private static final int VAL_LIST  = 11;
    private static final int VAL_SPARSEARRAY = 12;
    private static final int VAL_BYTEARRAY = 13;
    private static final int VAL_STRINGARRAY = 14;
    private static final int VAL_IBINDER = 15;
    private static final int VAL_PARCELABLEARRAY = 16;
    private static final int VAL_OBJECTARRAY = 17;
    private static final int VAL_INTARRAY = 18;
    private static final int VAL_LONGARRAY = 19;
    private static final int VAL_BYTE = 20;
    private static final int VAL_SERIALIZABLE = 21;
    private static final int VAL_SPARSEBOOLEANARRAY = 22;
    private static final int VAL_BOOLEANARRAY = 23;
    private static final int VAL_CHARSEQUENCEARRAY = 24;
    private static final int EX_SECURITY = -1;
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_HAS_REPLY_HEADER = -128;
    public final static Parcelable.Creator<String> STRING_CREATOR = new Parcelable.Creator<String>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.015 -0400", hash_original_method = "CF5066ADB23AB15A8F47A7B0F4466503", hash_generated_method = "AE7E51AE7FA7CB39139E1AFDFC55A351")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            String var88E96AAFD724559F9FD3FC52BB174D27_1061472089 = (source.readString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return source.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.016 -0400", hash_original_method = "6691A777569EDCC3CEA07BFC1CA591D5", hash_generated_method = "572E8B5360CBE3FE771840257DA2DE72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String[] newArray(int size) {
            dsTaint.addTaint(size);
            String[] var37E331573B49E6579C9EDCED9427AA6D_902642584 = (new String[size]);
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return new String[size];
        }

        
}; //Transformed anonymous class
    private static final HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>
        mCreators = new HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>();
}

