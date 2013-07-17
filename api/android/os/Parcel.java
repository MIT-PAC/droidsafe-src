package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.920 -0400", hash_original_field = "48FF959108CFB83B8A6F31854D7CE0B4", hash_generated_field = "6861EF2C6719FB6BE9580A330103CA5F")

    @SuppressWarnings({"UnusedDeclaration"}) private int mObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.920 -0400", hash_original_field = "1E29C110658060053105607F6A69FCDF", hash_generated_field = "E2BD6B8F2FA33686C59551B5BF00B3B5")

    @SuppressWarnings({"UnusedDeclaration"}) private int mOwnObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.920 -0400", hash_original_field = "B1C29C43A1B3C1AF208A28E9F6889C94", hash_generated_field = "F06536DFCEF1B0A690687BA1BFE76D23")

    private RuntimeException mStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.921 -0400", hash_original_method = "96328320E65E9E5C73AE1A423ABA09C7", hash_generated_method = "BFBDC310BB8C273E151964EAAF16D2A6")
    private  Parcel(int obj) {
        addTaint(obj);
        if(DEBUG_RECYCLE)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.922 -0400", hash_original_method = "0B6C271774CE05661982DF3B6AC078FF", hash_generated_method = "738006E5E35CD7C2599EEC5139A808DB")
    public final void recycle() {
        if(DEBUG_RECYCLE)        
        mStack = null;
        freeBuffer();
        final Parcel[] pool = mOwnObject != 0 ? sOwnedPool : sHolderPool;
        synchronized
(pool)        {
for(int i=0;i<POOL_SIZE;i++)
            {
                if(pool[i] == null)                
                {
                    pool[i] = this;
                    return;
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.922 -0400", hash_original_method = "DD534262B78755109918F5DCE98072D4", hash_generated_method = "71FE21595B4FE9EB58657F4A3A139217")
    public final int dataSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445752044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445752044;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.923 -0400", hash_original_method = "0316AB8FD0A1B068176256EC0E481A72", hash_generated_method = "A7767B27EED14E7656E651167E97396C")
    public final int dataAvail() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165672053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165672053;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.923 -0400", hash_original_method = "D1BE237E96D29A914DD3E05EDFD3F272", hash_generated_method = "338D20EAFDDA9A5D90A3D1170D5605D1")
    public final int dataPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234393935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234393935;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.923 -0400", hash_original_method = "51F0EF05154419C189F36E1902F5F7AB", hash_generated_method = "D99F3887610CB59C9A5BBAC88E2091A8")
    public final int dataCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144617688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144617688;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.923 -0400", hash_original_method = "D8CB87D9AB1E01DFD8357CBF456AE1C5", hash_generated_method = "DBDC326A5AD13E4C052782BF36EE04CC")
    public final void setDataSize(int size) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.924 -0400", hash_original_method = "900D9C4DE4FE3C2709BAAFC39AA9B06F", hash_generated_method = "F3CD9D97BEE6A7C9B1EDA27A460B2114")
    public final void setDataPosition(int pos) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.924 -0400", hash_original_method = "E063261D5EA5083378CEC188A4B78FE0", hash_generated_method = "F1A8A9E75C383307D41FF1C854241F7F")
    public final void setDataCapacity(int size) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.924 -0400", hash_original_method = "97650A42F80764D7062D6C7A9EDB6E4B", hash_generated_method = "224EB6225F612892D00A6EC859A20E43")
    public final boolean pushAllowFds(boolean allowFds) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1604049421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1604049421;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.924 -0400", hash_original_method = "D9541DA181394F49233EDC85EBA11372", hash_generated_method = "F726D88738028EDDB487D5C6B46AE462")
    public final void restoreAllowFds(boolean lastValue) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.925 -0400", hash_original_method = "203FAAB8CBC9466E61C8672BA6829403", hash_generated_method = "73B4464BE5F45A873CF39E20FE162B8F")
    public final byte[] marshall() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_110703245 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_110703245;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.925 -0400", hash_original_method = "54EF2A5E543EFE1E280A4B6A4F3098CB", hash_generated_method = "9BFFC2D408472CD2885F9AA93E140122")
    public final void unmarshall(byte[] data, int offest, int length) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.925 -0400", hash_original_method = "E8A5DF9275FDA0D9B0B70C7334CB1E59", hash_generated_method = "06D0342998182488FBF1BB999A6534DB")
    public final void appendFrom(Parcel parcel, int offset, int length) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.925 -0400", hash_original_method = "A1C2B053FCB3ADAB79F2D704E198BAB1", hash_generated_method = "746E5E190316816ADA51E4D0A2CC2884")
    public final boolean hasFileDescriptors() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201201321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201201321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.926 -0400", hash_original_method = "EBD07D08BBA21F0C5B4E86C34DC5CAC1", hash_generated_method = "482712869E70BA49180853C184A16263")
    public final void writeInterfaceToken(String interfaceName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.926 -0400", hash_original_method = "5F95BF99C2626C7B3640C2D1B3B7BEE7", hash_generated_method = "288CBAB1B96B3BD6C3E43589A43CAA3F")
    public final void enforceInterface(String interfaceName) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.926 -0400", hash_original_method = "6AA57281F567FED2151D4FF51C5ADD5D", hash_generated_method = "6D6DA9D4FE2105A50EFC9CF637135EC5")
    public final void writeByteArray(byte[] b) {
        addTaint(b[0]);
        writeByteArray(b, 0, (b != null) ? b.length : 0);
        // ---------- Original Method ----------
        //writeByteArray(b, 0, (b != null) ? b.length : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.933 -0400", hash_original_method = "292A0D9A6E9AD589E2915A38A2AF794D", hash_generated_method = "79AF26EAB56ECDBDED8EE23125A0B041")
    public final void writeByteArray(byte[] b, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(b[0]);
        if(b == null)        
        {
            writeInt(-1);
            return;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.934 -0400", hash_original_method = "13EF9FAE46E0DC273567B76840FE8431", hash_generated_method = "B7B1791B1819FAA4AC4DF261A54493B1")
    private void writeNative(byte[] b, int offset, int len) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.934 -0400", hash_original_method = "EB7F50F11C67DFE7362846314C368039", hash_generated_method = "BEE33504B34EACD5CA9D841430805B0B")
    public final void writeInt(int val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.934 -0400", hash_original_method = "6EE9E92592584E19EA2786245476EB1F", hash_generated_method = "0A06D5D9A178D52A875714A0E42A1A51")
    public final void writeLong(long val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.934 -0400", hash_original_method = "8E6A3106AB0C4A6CA5D134BC13C79A46", hash_generated_method = "1DF7BBEB8EFD1C1A257BF6B7DBAA6EE3")
    public final void writeFloat(float val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.935 -0400", hash_original_method = "580EB112F6684AC838EF0FAE39FE6143", hash_generated_method = "C77D5B12217694B3853A3DF91BCF81A4")
    public final void writeDouble(double val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.935 -0400", hash_original_method = "148FED92CD1AE4975AE2973407FF84B1", hash_generated_method = "8FFD4EB8B720B24188B168257146AA4B")
    public final void writeString(String val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.935 -0400", hash_original_method = "CEAF068B566AB67AE8F044276645F78A", hash_generated_method = "7752FBC54D80EFED4C5A3D4127E7CA3A")
    public final void writeCharSequence(CharSequence val) {
        addTaint(val.getTaint());
        TextUtils.writeToParcel(val, this, 0);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(val, this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.935 -0400", hash_original_method = "7DA1E5E6DC1856828FF2B443CF2EA2D0", hash_generated_method = "0D95721DBACCC6601CFE11D2E34CD1FF")
    public final void writeStrongBinder(IBinder val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.936 -0400", hash_original_method = "D29D74B8509F3EDC680AC67A58B2AE11", hash_generated_method = "DD9E52CFD74FB53FEEE6359389A037A4")
    public final void writeStrongInterface(IInterface val) {
        addTaint(val.getTaint());
        writeStrongBinder(val == null ? null : val.asBinder());
        // ---------- Original Method ----------
        //writeStrongBinder(val == null ? null : val.asBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.937 -0400", hash_original_method = "F228581B9954F98E592DA68C1EE89409", hash_generated_method = "159C24B95EAD1045C52B3F0E4DD0B66A")
    public final void writeFileDescriptor(FileDescriptor val) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.941 -0400", hash_original_method = "B137ADD0EA125F15A647DF5EEF6060FE", hash_generated_method = "5A5F34BC861BE772F704A26FC865CAD7")
    public final void writeByte(byte val) {
        addTaint(val);
        writeInt(val);
        // ---------- Original Method ----------
        //writeInt(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.943 -0400", hash_original_method = "028C08B0E96835B592DD57E92E1A9654", hash_generated_method = "7A55FB5104DE4EF074FC334B618B9F0C")
    public final void writeMap(Map val) {
        addTaint(val.getTaint());
        writeMapInternal((Map<String,Object>) val);
        // ---------- Original Method ----------
        //writeMapInternal((Map<String,Object>) val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.947 -0400", hash_original_method = "254CF4BDBF55D33C4656934F15F7844A", hash_generated_method = "F64A7B6B5DACDCE98D4A6893A7ACCD31")
     void writeMapInternal(Map<String,Object> val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        Set<Map.Entry<String,Object>> entries = val.entrySet();
        writeInt(entries.size());
for(Map.Entry<String,Object> e : entries)
        {
            writeValue(e.getKey());
            writeValue(e.getValue());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.951 -0400", hash_original_method = "1B271C6B96886293B3F46C86D8594D62", hash_generated_method = "0E2D314369C34E0B7DF9E00D02E8F4DC")
    public final void writeBundle(Bundle val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        val.writeToParcel(this, 0);
        // ---------- Original Method ----------
        //if (val == null) {
            //writeInt(-1);
            //return;
        //}
        //val.writeToParcel(this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.955 -0400", hash_original_method = "E7219AA1C86EB1036E36A514DFF44066", hash_generated_method = "D18AB00B4ACC2CBF8A8B6797C52FD314")
    public final void writeList(List val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.size();
        int i = 0;
        writeInt(N);
        while
(i < N)        
        {
            writeValue(val.get(i));
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.960 -0400", hash_original_method = "903390B15749D4F099959DBD9D939641", hash_generated_method = "B2B204B0A5EE5749A86FBF25C3121184")
    public final void writeArray(Object[] val) {
        addTaint(val[0].getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.length;
        int i = 0;
        writeInt(N);
        while
(i < N)        
        {
            writeValue(val[i]);
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.963 -0400", hash_original_method = "932B15FDC26AECB59BA0DEB9D7727076", hash_generated_method = "991B50550ADDC4392EA004E072666C9B")
    public final void writeSparseArray(SparseArray<Object> val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.size();
        writeInt(N);
        int i = 0;
        while
(i < N)        
        {
            writeInt(val.keyAt(i));
            writeValue(val.valueAt(i));
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.969 -0400", hash_original_method = "501AACE22AB4AEC41E440B95E2BF337F", hash_generated_method = "D9EC556ABB25DAB8150D3340E388DA86")
    public final void writeSparseBooleanArray(SparseBooleanArray val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.size();
        writeInt(N);
        int i = 0;
        while
(i < N)        
        {
            writeInt(val.keyAt(i));
            writeByte((byte)(val.valueAt(i) ? 1 : 0));
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.971 -0400", hash_original_method = "D75DEF1EB05EA54B4B0A6C775E789115", hash_generated_method = "9A3A7BE05F620DC0D133176644456534")
    public final void writeBooleanArray(boolean[] val) {
        addTaint(val[0]);
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeInt(val[i] ? 1 : 0);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.978 -0400", hash_original_method = "636C08B3912226F5C58D74422D1E9CB4", hash_generated_method = "A3610E5167D30DCC741EB758F85853D9")
    public final boolean[] createBooleanArray() {
        int N = readInt();
        if(N >= 0 && N <= (dataAvail() >> 2))        
        {
            boolean[] val = new boolean[N];
for(int i=0;i<N;i++)
            {
                val[i] = readInt() != 0;
            } //End block
            boolean[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_875745961 = (val);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_1027732389 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_1027732389;
        } //End block
        else
        {
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_1792544550 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_558713717 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_558713717;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.984 -0400", hash_original_method = "15202BE45A888A7FAE449643C1F651D3", hash_generated_method = "76EE9C02C8C91F717973B1FD03510B60")
    public final void readBooleanArray(boolean[] val) {
        addTaint(val[0]);
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readInt() != 0;
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_928159969 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_928159969.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_928159969;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.987 -0400", hash_original_method = "FC1109029B4BAAFE0FA31EEEF8F95A5F", hash_generated_method = "EC09345C238263FA8150FF1D565C0747")
    public final void writeCharArray(char[] val) {
        addTaint(val[0]);
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeInt((int)val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.992 -0400", hash_original_method = "0F2CB9A0B4BA672805C5DC7ABC31D142", hash_generated_method = "57C5BB7CB6AA5B543E9D61FD7AB19C73")
    public final char[] createCharArray() {
        int N = readInt();
        if(N >= 0 && N <= (dataAvail() >> 2))        
        {
            char[] val = new char[N];
for(int i=0;i<N;i++)
            {
                val[i] = (char)readInt();
            } //End block
            char[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_604493447 = (val);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_944921218 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_944921218;
        } //End block
        else
        {
            char[] var37A6259CC0C1DAE299A7866489DFF0BD_1858925276 = (null);
                        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1864535190 = {getTaintChar()};
            return var50607924ABD4C17119BAF3A1CE41C0EC_1864535190;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.997 -0400", hash_original_method = "3577ABA10B4218BCCE6B69B6327658D6", hash_generated_method = "CC0D983B835661C0925AF5F0C651E084")
    public final void readCharArray(char[] val) {
        addTaint(val[0]);
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = (char)readInt();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_1908312978 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_1908312978.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_1908312978;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.001 -0400", hash_original_method = "426B3599371B897BFC6196C71A9C351C", hash_generated_method = "3B24B24C89B206D8A0E713A3320AE47E")
    public final void writeIntArray(int[] val) {
        addTaint(val[0]);
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeInt(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.003 -0400", hash_original_method = "2BFE53BE4AFBC39913D7CD537675C77F", hash_generated_method = "D97FB27761DF6030D9F3A76BC0CA6B40")
    public final int[] createIntArray() {
        int N = readInt();
        if(N >= 0 && N <= (dataAvail() >> 2))        
        {
            int[] val = new int[N];
for(int i=0;i<N;i++)
            {
                val[i] = readInt();
            } //End block
            int[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_1353043997 = (val);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1225894202 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1225894202;
        } //End block
        else
        {
            int[] var37A6259CC0C1DAE299A7866489DFF0BD_149261229 = (null);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_710562843 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_710562843;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.005 -0400", hash_original_method = "D30E6FBEFEE072DBADEACBC994232724", hash_generated_method = "7DBAFFB1890CF077770C71CA0750D029")
    public final void readIntArray(int[] val) {
        addTaint(val[0]);
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readInt();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_862845752 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_862845752.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_862845752;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.006 -0400", hash_original_method = "6AE17F1911C710D67F0B38E1A6953312", hash_generated_method = "2CCDFB9C0438C00064D952CABA3EB275")
    public final void writeLongArray(long[] val) {
        addTaint(val[0]);
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeLong(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.008 -0400", hash_original_method = "539AEF1878CDD8393DEC7B15A779334D", hash_generated_method = "82C55695E061CE4EED740F8FD30A8CBF")
    public final long[] createLongArray() {
        int N = readInt();
        if(N >= 0 && N <= (dataAvail() >> 3))        
        {
            long[] val = new long[N];
for(int i=0;i<N;i++)
            {
                val[i] = readLong();
            } //End block
            long[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_1949636757 = (val);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1269929260 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_1269929260;
        } //End block
        else
        {
            long[] var37A6259CC0C1DAE299A7866489DFF0BD_645274500 = (null);
                        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_703708201 = {getTaintLong()};
            return var3908C7C3AF5171CEE1F112DAE77A5C4D_703708201;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.010 -0400", hash_original_method = "EB1FE051AE6270C29877E320D05D2B1C", hash_generated_method = "730FF14BEDBBA4EA4CBD4B1CF55DDC98")
    public final void readLongArray(long[] val) {
        addTaint(val[0]);
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readLong();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_2130122182 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_2130122182.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_2130122182;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.011 -0400", hash_original_method = "914127CC1FF235613675A4097238AE87", hash_generated_method = "271D77185CE443C48A0483D98976F240")
    public final void writeFloatArray(float[] val) {
        addTaint(val[0]);
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeFloat(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.012 -0400", hash_original_method = "AD11D1594D734C1EBF478FFED3A5EA0B", hash_generated_method = "229D58D3EDCEAA684A8885224EACF3AE")
    public final float[] createFloatArray() {
        int N = readInt();
        if(N >= 0 && N <= (dataAvail() >> 2))        
        {
            float[] val = new float[N];
for(int i=0;i<N;i++)
            {
                val[i] = readFloat();
            } //End block
            float[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_166242707 = (val);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_92224425 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_92224425;
        } //End block
        else
        {
            float[] var37A6259CC0C1DAE299A7866489DFF0BD_631141710 = (null);
                        float[] varB2C245003BAB9224CFB496218F7DAFE0_1884184794 = {getTaintFloat()};
            return varB2C245003BAB9224CFB496218F7DAFE0_1884184794;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.013 -0400", hash_original_method = "5BAAFA2155FE07D9BA992B0E92A02429", hash_generated_method = "D428B9B582DCE02E1179A4B06FCCF0BF")
    public final void readFloatArray(float[] val) {
        addTaint(val[0]);
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readFloat();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_1272682738 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_1272682738.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_1272682738;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.014 -0400", hash_original_method = "30BB607A5C46B583A0E7A88D0830BB99", hash_generated_method = "E37F33E8553D174A063EE499A25846DE")
    public final void writeDoubleArray(double[] val) {
        addTaint(val[0]);
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeDouble(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.015 -0400", hash_original_method = "EADE9932A44C79075558F2C2E2C44BF9", hash_generated_method = "779D90D065EDBD498DB7D87416EEAAED")
    public final double[] createDoubleArray() {
        int N = readInt();
        if(N >= 0 && N <= (dataAvail() >> 3))        
        {
            double[] val = new double[N];
for(int i=0;i<N;i++)
            {
                val[i] = readDouble();
            } //End block
            double[] var3A6D0284E743DC4A9B86F97D6DD1A3BF_66603417 = (val);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_478657774 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_478657774;
        } //End block
        else
        {
            double[] var37A6259CC0C1DAE299A7866489DFF0BD_1779970642 = (null);
                        double[] var74D44D7D9EE6FE6C3433D694F869E521_539912677 = {getTaintDouble()};
            return var74D44D7D9EE6FE6C3433D694F869E521_539912677;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.016 -0400", hash_original_method = "1E5CFF0988982B6DD3E5010F6E58EAB2", hash_generated_method = "795E474D24BE15DA29A2030319F3766F")
    public final void readDoubleArray(double[] val) {
        addTaint(val[0]);
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readDouble();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_336594265 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_336594265.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_336594265;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.017 -0400", hash_original_method = "869784FDBD7A62BA6DC61589E5325593", hash_generated_method = "26F7CAA92BD79AAC25CE08FF82E3AEE6")
    public final void writeStringArray(String[] val) {
        addTaint(val[0].getTaint());
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeString(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.017 -0400", hash_original_method = "E25A6435806EEE9817C8F94878902077", hash_generated_method = "7A4517E350B6094BA077ECF56B669EEC")
    public final String[] createStringArray() {
        int N = readInt();
        if(N >= 0)        
        {
            String[] val = new String[N];
for(int i=0;i<N;i++)
            {
                val[i] = readString();
            } //End block
String[] varD943F4EF06EF0FF7F541DA63567F3076_1718303946 =             val;
            varD943F4EF06EF0FF7F541DA63567F3076_1718303946.addTaint(taint);
            return varD943F4EF06EF0FF7F541DA63567F3076_1718303946;
        } //End block
        else
        {
String[] var540C13E9E156B687226421B24F2DF178_1427095254 =             null;
            var540C13E9E156B687226421B24F2DF178_1427095254.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1427095254;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.018 -0400", hash_original_method = "856C598346084C5A7CB0C8EC3C30AFE8", hash_generated_method = "B1F9F9A91398D95B5215AD56F2D51989")
    public final void readStringArray(String[] val) {
        addTaint(val[0].getTaint());
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readString();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_1149747334 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_1149747334.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_1149747334;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.019 -0400", hash_original_method = "EF4C8799E7CA7F11199E2A94E26473B3", hash_generated_method = "74519DD9A91F8DCFC5FDF4C3698B15E1")
    public final void writeBinderArray(IBinder[] val) {
        addTaint(val[0].getTaint());
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeStrongBinder(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.019 -0400", hash_original_method = "47477B6B20C2841826851A1DC451409B", hash_generated_method = "FBA998409CF8387E4533DE4ED2341ABC")
    public final void writeCharSequenceArray(CharSequence[] val) {
        addTaint(val[0].getTaint());
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeCharSequence(val[i]);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.020 -0400", hash_original_method = "4DE08401A529CB5616CDC9DFD50DAFB3", hash_generated_method = "E108E5D233082FB94469CB07E6A139EB")
    public final IBinder[] createBinderArray() {
        int N = readInt();
        if(N >= 0)        
        {
            IBinder[] val = new IBinder[N];
for(int i=0;i<N;i++)
            {
                val[i] = readStrongBinder();
            } //End block
IBinder[] varD943F4EF06EF0FF7F541DA63567F3076_1841989065 =             val;
            varD943F4EF06EF0FF7F541DA63567F3076_1841989065.addTaint(taint);
            return varD943F4EF06EF0FF7F541DA63567F3076_1841989065;
        } //End block
        else
        {
IBinder[] var540C13E9E156B687226421B24F2DF178_123830828 =             null;
            var540C13E9E156B687226421B24F2DF178_123830828.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_123830828;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.021 -0400", hash_original_method = "3E3D11ECAF89B0D6B7212074DA0FB112", hash_generated_method = "60084D4581F0DD7A88AC7842000F3304")
    public final void readBinderArray(IBinder[] val) {
        addTaint(val[0].getTaint());
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                val[i] = readStrongBinder();
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_503243679 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_503243679.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_503243679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.021 -0400", hash_original_method = "5826C07CBD3614FC61FFE172F3E36C59", hash_generated_method = "2E06498E304914F89932BA8B9F2624D2")
    public final <T extends Parcelable> void writeTypedList(List<T> val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.size();
        int i = 0;
        writeInt(N);
        while
(i < N)        
        {
            T item = val.get(i);
            if(item != null)            
            {
                writeInt(1);
                item.writeToParcel(this, 0);
            } //End block
            else
            {
                writeInt(0);
            } //End block
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.022 -0400", hash_original_method = "D0AECB36946CE861852315E400637CFF", hash_generated_method = "B4C49CA825AF6F36FDF31ACA700C31C7")
    public final void writeStringList(List<String> val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.size();
        int i = 0;
        writeInt(N);
        while
(i < N)        
        {
            writeString(val.get(i));
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.022 -0400", hash_original_method = "7137D7435CDB5CC040EE6A964998B66D", hash_generated_method = "76BCFA0F33DD24F496A84C1DD3924F84")
    public final void writeBinderList(List<IBinder> val) {
        addTaint(val.getTaint());
        if(val == null)        
        {
            writeInt(-1);
            return;
        } //End block
        int N = val.size();
        int i = 0;
        writeInt(N);
        while
(i < N)        
        {
            writeStrongBinder(val.get(i));
            i++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.023 -0400", hash_original_method = "029988DBA55E380B93A4CDBDA2CB7F3E", hash_generated_method = "39F418F456BBB75EEC4779B75C5A1830")
    public final <T extends Parcelable> void writeTypedArray(T[] val,
            int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(val[0].getTaint());
        if(val != null)        
        {
            int N = val.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                T item = val[i];
                if(item != null)                
                {
                    writeInt(1);
                    item.writeToParcel(this, parcelableFlags);
                } //End block
                else
                {
                    writeInt(0);
                } //End block
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.025 -0400", hash_original_method = "D9566C4BE63552F29703FA1385C84129", hash_generated_method = "38FD3478FB896718EC10830A771C5C51")
    public final void writeValue(Object v) {
        addTaint(v.getTaint());
        if(v == null)        
        {
            writeInt(VAL_NULL);
        } //End block
        else
        if(v instanceof String)        
        {
            writeInt(VAL_STRING);
            writeString((String) v);
        } //End block
        else
        if(v instanceof Integer)        
        {
            writeInt(VAL_INTEGER);
            writeInt((Integer) v);
        } //End block
        else
        if(v instanceof Map)        
        {
            writeInt(VAL_MAP);
            writeMap((Map) v);
        } //End block
        else
        if(v instanceof Bundle)        
        {
            writeInt(VAL_BUNDLE);
            writeBundle((Bundle) v);
        } //End block
        else
        if(v instanceof Parcelable)        
        {
            writeInt(VAL_PARCELABLE);
            writeParcelable((Parcelable) v, 0);
        } //End block
        else
        if(v instanceof Short)        
        {
            writeInt(VAL_SHORT);
            writeInt(((Short) v).intValue());
        } //End block
        else
        if(v instanceof Long)        
        {
            writeInt(VAL_LONG);
            writeLong((Long) v);
        } //End block
        else
        if(v instanceof Float)        
        {
            writeInt(VAL_FLOAT);
            writeFloat((Float) v);
        } //End block
        else
        if(v instanceof Double)        
        {
            writeInt(VAL_DOUBLE);
            writeDouble((Double) v);
        } //End block
        else
        if(v instanceof Boolean)        
        {
            writeInt(VAL_BOOLEAN);
            writeInt((Boolean) v ? 1 : 0);
        } //End block
        else
        if(v instanceof CharSequence)        
        {
            writeInt(VAL_CHARSEQUENCE);
            writeCharSequence((CharSequence) v);
        } //End block
        else
        if(v instanceof List)        
        {
            writeInt(VAL_LIST);
            writeList((List) v);
        } //End block
        else
        if(v instanceof SparseArray)        
        {
            writeInt(VAL_SPARSEARRAY);
            writeSparseArray((SparseArray) v);
        } //End block
        else
        if(v instanceof boolean[])        
        {
            writeInt(VAL_BOOLEANARRAY);
            writeBooleanArray((boolean[]) v);
        } //End block
        else
        if(v instanceof byte[])        
        {
            writeInt(VAL_BYTEARRAY);
            writeByteArray((byte[]) v);
        } //End block
        else
        if(v instanceof String[])        
        {
            writeInt(VAL_STRINGARRAY);
            writeStringArray((String[]) v);
        } //End block
        else
        if(v instanceof CharSequence[])        
        {
            writeInt(VAL_CHARSEQUENCEARRAY);
            writeCharSequenceArray((CharSequence[]) v);
        } //End block
        else
        if(v instanceof IBinder)        
        {
            writeInt(VAL_IBINDER);
            writeStrongBinder((IBinder) v);
        } //End block
        else
        if(v instanceof Parcelable[])        
        {
            writeInt(VAL_PARCELABLEARRAY);
            writeParcelableArray((Parcelable[]) v, 0);
        } //End block
        else
        if(v instanceof Object[])        
        {
            writeInt(VAL_OBJECTARRAY);
            writeArray((Object[]) v);
        } //End block
        else
        if(v instanceof int[])        
        {
            writeInt(VAL_INTARRAY);
            writeIntArray((int[]) v);
        } //End block
        else
        if(v instanceof long[])        
        {
            writeInt(VAL_LONGARRAY);
            writeLongArray((long[]) v);
        } //End block
        else
        if(v instanceof Byte)        
        {
            writeInt(VAL_BYTE);
            writeInt((Byte) v);
        } //End block
        else
        if(v instanceof Serializable)        
        {
            writeInt(VAL_SERIALIZABLE);
            writeSerializable((Serializable) v);
        } //End block
        else
        {
            RuntimeException var284A4D973E14F821446B28DBFEF37100_1636306695 = new RuntimeException("Parcel: unable to marshal value " + v);
            var284A4D973E14F821446B28DBFEF37100_1636306695.addTaint(taint);
            throw var284A4D973E14F821446B28DBFEF37100_1636306695;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.027 -0400", hash_original_method = "A58184BC725C2FE85E17C583E1DA6016", hash_generated_method = "F8E173BE63C2C10B73E3441C5C3323A0")
    public final void writeParcelable(Parcelable p, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(p.getTaint());
        if(p == null)        
        {
            writeString(null);
            return;
        } //End block
        String name = p.getClass().getName();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.028 -0400", hash_original_method = "BCB9F78F7EC1F484C61BF7865779B2F9", hash_generated_method = "9C19C5DC1BC415AE20098D923508CAAB")
    public final void writeSerializable(Serializable s) {
        addTaint(s.getTaint());
        if(s == null)        
        {
            writeString(null);
            return;
        } //End block
        String name = s.getClass().getName();
        writeString(name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try 
        {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(s);
            oos.close();
            writeByteArray(baos.toByteArray());
        } //End block
        catch (IOException ioe)
        {
            RuntimeException var97FAFC1E20C33DAA9290D0BA6BCBCF76_174136694 = new RuntimeException("Parcelable encountered " +
                "IOException writing serializable object (name = " + name +
                ")", ioe);
            var97FAFC1E20C33DAA9290D0BA6BCBCF76_174136694.addTaint(taint);
            throw var97FAFC1E20C33DAA9290D0BA6BCBCF76_174136694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.028 -0400", hash_original_method = "7DD11AC8769A37C0F9583E9AAFAA7192", hash_generated_method = "F543FAAA69CC1EAC54C1DAD7EAD8BE54")
    public final void writeException(Exception e) {
        addTaint(e.getTaint());
        int code = 0;
        if(e instanceof SecurityException)        
        {
            code = EX_SECURITY;
        } //End block
        else
        if(e instanceof BadParcelableException)        
        {
            code = EX_BAD_PARCELABLE;
        } //End block
        else
        if(e instanceof IllegalArgumentException)        
        {
            code = EX_ILLEGAL_ARGUMENT;
        } //End block
        else
        if(e instanceof NullPointerException)        
        {
            code = EX_NULL_POINTER;
        } //End block
        else
        if(e instanceof IllegalStateException)        
        {
            code = EX_ILLEGAL_STATE;
        } //End block
        writeInt(code);
        StrictMode.clearGatheredViolations();
        if(code == 0)        
        {
            if(e instanceof RuntimeException)            
            {
                RuntimeException var5C191DD520881308BE807157DCE34F5D_754223960 = (RuntimeException) e;
                var5C191DD520881308BE807157DCE34F5D_754223960.addTaint(taint);
                throw var5C191DD520881308BE807157DCE34F5D_754223960;
            } //End block
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1980443481 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1980443481.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1980443481;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.028 -0400", hash_original_method = "123C62676F5EFD49547DAF82EF108740", hash_generated_method = "37B064D4EC4B9C8695D06A8553F3998E")
    public final void writeNoException() {
        if(StrictMode.hasGatheredViolations())        
        {
            writeInt(EX_HAS_REPLY_HEADER);
            final int sizePosition = dataPosition();
            writeInt(0);
            StrictMode.writeGatheredViolationsToParcel(this);
            final int payloadPosition = dataPosition();
            setDataPosition(sizePosition);
            writeInt(payloadPosition - sizePosition);
            setDataPosition(payloadPosition);
        } //End block
        else
        {
            writeInt(0);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.029 -0400", hash_original_method = "82EBD768B4FCE70E559935E5298055BB", hash_generated_method = "9EE79051DB7061B359DA4F3100273447")
    public final void readException() {
        int code = readExceptionCode();
        if(code != 0)        
        {
            String msg = readString();
            readException(code, msg);
        } //End block
        // ---------- Original Method ----------
        //int code = readExceptionCode();
        //if (code != 0) {
            //String msg = readString();
            //readException(code, msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.029 -0400", hash_original_method = "38AAEB1276A409D21345CE71D5A4968D", hash_generated_method = "9979CFD50C5EDB94F7A2CEF019CDE5D5")
    public final int readExceptionCode() {
        int code = readInt();
        if(code == EX_HAS_REPLY_HEADER)        
        {
            int headerSize = readInt();
            if(headerSize == 0)            
            {
            } //End block
            else
            {
                StrictMode.readAndHandleBinderCallViolations(this);
            } //End block
            int varCFCD208495D565EF66E7DFF9F98764DA_1974511655 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607458100 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607458100;
        } //End block
        int varC13367945D5D4C91047B3B50234AA7AB_1421666774 = (code);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6304393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6304393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.029 -0400", hash_original_method = "16B6C7096EAAE541E38738222303A695", hash_generated_method = "2796FFF05FDF9474B68642640C4575FC")
    public final void readException(int code, String msg) {
        addTaint(msg.getTaint());
        addTaint(code);
switch(code){
        case EX_SECURITY:
        SecurityException varC5EE93F1F5A2A36B7796B378C69384FB_450816335 = new SecurityException(msg);
        varC5EE93F1F5A2A36B7796B378C69384FB_450816335.addTaint(taint);
        throw varC5EE93F1F5A2A36B7796B378C69384FB_450816335;
        case EX_BAD_PARCELABLE:
        BadParcelableException varF56706F70BBF0C0E6F90D6B0D4C34B43_669438912 = new BadParcelableException(msg);
        varF56706F70BBF0C0E6F90D6B0D4C34B43_669438912.addTaint(taint);
        throw varF56706F70BBF0C0E6F90D6B0D4C34B43_669438912;
        case EX_ILLEGAL_ARGUMENT:
        IllegalArgumentException varBF1DE0EBB10945813AF140C2533CC7FB_1358990658 = new IllegalArgumentException(msg);
        varBF1DE0EBB10945813AF140C2533CC7FB_1358990658.addTaint(taint);
        throw varBF1DE0EBB10945813AF140C2533CC7FB_1358990658;
        case EX_NULL_POINTER:
        NullPointerException varA743264392F227C5A2ED11535EBCA197_1021154153 = new NullPointerException(msg);
        varA743264392F227C5A2ED11535EBCA197_1021154153.addTaint(taint);
        throw varA743264392F227C5A2ED11535EBCA197_1021154153;
        case EX_ILLEGAL_STATE:
        IllegalStateException var7F2D17CA90B318AA0541B6F6070295DF_1951811748 = new IllegalStateException(msg);
        var7F2D17CA90B318AA0541B6F6070295DF_1951811748.addTaint(taint);
        throw var7F2D17CA90B318AA0541B6F6070295DF_1951811748;
}        RuntimeException var54B7A65DDF30FE54BECB8935C80BD0C3_2066149983 = new RuntimeException("Unknown exception code: " + code
                + " msg " + msg);
        var54B7A65DDF30FE54BECB8935C80BD0C3_2066149983.addTaint(taint);
        throw var54B7A65DDF30FE54BECB8935C80BD0C3_2066149983;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.030 -0400", hash_original_method = "97FB920EA9544B24495059FF8518145E", hash_generated_method = "A2B6DEB52D35DB2455AD05DB74DC90F6")
    public final int readInt() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109477627 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109477627;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.030 -0400", hash_original_method = "88765326927052F47E1B04CC1A370299", hash_generated_method = "C515893C0E58F85659638E0923E6CE94")
    public final long readLong() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1979331462 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1979331462;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.030 -0400", hash_original_method = "9BF95C525D78F630EDF572E34BF4D430", hash_generated_method = "D861216B18B6F0495EE1DF25E9A27569")
    public final float readFloat() {
        float var546ADE640B6EDFBC8A086EF31347E768_1995543761 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1995543761;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.030 -0400", hash_original_method = "FFE81D38F89970F2B0BAD4C68B43B4BA", hash_generated_method = "2B703104B0228B05CC143E855D5A75C2")
    public final double readDouble() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_1217784755 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1217784755;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.813 -0400", hash_original_method = "E5D101F44C406F4D63DCAF323A3DBE7A", hash_generated_method = "1C9A6574A6BB76E4DCFE30F009ECD100")
	public final String readString() {
		return new String();
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.031 -0400", hash_original_method = "1E262BAA6376F101519B67935298363E", hash_generated_method = "9675408C110D1853F93521A1455F56A3")
    public final CharSequence readCharSequence() {
CharSequence var9AAE8D340A8F9D8FD499074EA0575B81_278296870 =         TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
        var9AAE8D340A8F9D8FD499074EA0575B81_278296870.addTaint(taint);
        return var9AAE8D340A8F9D8FD499074EA0575B81_278296870;
        // ---------- Original Method ----------
        //return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.814 -0400", hash_original_method = "5B57CBCFFAE68CC288C10DD7232B6ED1", hash_generated_method = "44CAE844D4E5A4CBF2E99C7605E5B931")
	public final IBinder readStrongBinder() {
		Binder b = new Binder();
		b.addTaint(this.taint);
		return b;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.031 -0400", hash_original_method = "624419D3E87C84C27536CFAE1C7248DF", hash_generated_method = "CEC7811F075F823A824F767C552E2CCA")
    public final ParcelFileDescriptor readFileDescriptor() {
        FileDescriptor fd = internalReadFileDescriptor();
ParcelFileDescriptor var725A79CEA33B3AFB56482C39608FC1A3_1049014500 =         fd != null ? new ParcelFileDescriptor(fd) : null;
        var725A79CEA33B3AFB56482C39608FC1A3_1049014500.addTaint(taint);
        return var725A79CEA33B3AFB56482C39608FC1A3_1049014500;
        // ---------- Original Method ----------
        //FileDescriptor fd = internalReadFileDescriptor();
        //return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.816 -0400", hash_original_method = "33B415422717616FBFFA4D8F233FE3A4", hash_generated_method = "0FD8D4B30F488C8E04BA04A3C811CF90")
	private FileDescriptor internalReadFileDescriptor() {
		FileDescriptor fd = new FileDescriptor();
		fd.addTaint(this.taint);
		return fd;
	}

    
    @DSModeled(DSC.SAFE)
    static FileDescriptor openFileDescriptor(String file, int mode) throws FileNotFoundException {
		return new FileDescriptor();
	}

    
    @DSModeled(DSC.SAFE)
    static FileDescriptor dupFileDescriptor(FileDescriptor orig) throws IOException {
		return new FileDescriptor();
	}

    
    @DSModeled(DSC.SAFE)
    static void closeFileDescriptor(FileDescriptor desc) throws IOException {
	}

    
    @DSModeled(DSC.SAFE)
    static void clearFileDescriptor(FileDescriptor desc) {
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.032 -0400", hash_original_method = "12B71841CE7C7BEB8DB394B4DC6EF58B", hash_generated_method = "41C493E2A18C48084B1C956760886C74")
    public final byte readByte() {
        byte varE071C5D630A02AE6A4948158962BC9D3_1998656938 = ((byte)(readInt() & 0xff));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_816823809 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_816823809;
        // ---------- Original Method ----------
        //return (byte)(readInt() & 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.032 -0400", hash_original_method = "82825CDD252FB884333A0468F1B46F6F", hash_generated_method = "721FC418A3F806FEEAD92F0AB009AEAF")
    public final void readMap(Map outVal, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(outVal.getTaint());
        int N = readInt();
        readMapInternal(outVal, N, loader);
        // ---------- Original Method ----------
        //int N = readInt();
        //readMapInternal(outVal, N, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.032 -0400", hash_original_method = "C60DBA65518C72AFC52918F8818E7A4A", hash_generated_method = "5CBC0741E621F792C0F076E3ADA89B15")
    public final void readList(List outVal, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(outVal.getTaint());
        int N = readInt();
        readListInternal(outVal, N, loader);
        // ---------- Original Method ----------
        //int N = readInt();
        //readListInternal(outVal, N, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.032 -0400", hash_original_method = "0DC8809E3B9E75AF0CC28567E6782BE5", hash_generated_method = "2FB81C3302DA989A0D2A22C44258401E")
    public final HashMap readHashMap(ClassLoader loader) {
        addTaint(loader.getTaint());
        int N = readInt();
        if(N < 0)        
        {
HashMap var540C13E9E156B687226421B24F2DF178_1822243693 =             null;
            var540C13E9E156B687226421B24F2DF178_1822243693.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1822243693;
        } //End block
        HashMap m = new HashMap(N);
        readMapInternal(m, N, loader);
HashMap varBD22C5ECD1F8BC3EE2416AF7A8014FD2_210280915 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_210280915.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_210280915;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //HashMap m = new HashMap(N);
        //readMapInternal(m, N, loader);
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.033 -0400", hash_original_method = "30B879800FFE3D55BB9B30F39E994273", hash_generated_method = "CA1855DB501F95308F3A7A5339E247C2")
    public final Bundle readBundle() {
Bundle var9904488AC49D8F932DD98395B8FD50F4_102346314 =         readBundle(null);
        var9904488AC49D8F932DD98395B8FD50F4_102346314.addTaint(taint);
        return var9904488AC49D8F932DD98395B8FD50F4_102346314;
        // ---------- Original Method ----------
        //return readBundle(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.033 -0400", hash_original_method = "7DBD463E649AEA6A8616F4943C405C7A", hash_generated_method = "2CF59BE2E8F74C22DD5E6EDB1ACD2082")
    public final Bundle readBundle(ClassLoader loader) {
        addTaint(loader.getTaint());
        int length = readInt();
        if(length < 0)        
        {
Bundle var540C13E9E156B687226421B24F2DF178_1700793525 =             null;
            var540C13E9E156B687226421B24F2DF178_1700793525.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1700793525;
        } //End block
        final Bundle bundle = new Bundle(this, length);
        if(loader != null)        
        {
            bundle.setClassLoader(loader);
        } //End block
Bundle var7B2862195409742DCA365D8C6330AB92_2038373251 =         bundle;
        var7B2862195409742DCA365D8C6330AB92_2038373251.addTaint(taint);
        return var7B2862195409742DCA365D8C6330AB92_2038373251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.036 -0400", hash_original_method = "DCFF48487CDF8628FF2244CC4810775C", hash_generated_method = "BA7BBD78EBA25BC4AA2640E4B7E19A05")
    public final byte[] createByteArray() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_266686621 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_266686621;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.036 -0400", hash_original_method = "40FE8430590711C6D2AB472A3973EA8A", hash_generated_method = "13A5DC7BBDC03D0C2E9ED3A099FCEC6F")
    public final void readByteArray(byte[] val) {
        addTaint(val[0]);
        byte[] ba = createByteArray();
        if(ba.length == val.length)        
        {
            System.arraycopy(ba, 0, val, 0, ba.length);
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_1111946931 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_1111946931.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_1111946931;
        } //End block
        // ---------- Original Method ----------
        //byte[] ba = createByteArray();
        //if (ba.length == val.length) {
           //System.arraycopy(ba, 0, val, 0, ba.length);
        //} else {
            //throw new RuntimeException("bad array lengths");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.036 -0400", hash_original_method = "3F4E1D573E001DD6503628882E161682", hash_generated_method = "1BD0ED41AC8CBD4B4157358FD4E26B22")
    public final String[] readStringArray() {
        String[] array = null;
        int length = readInt();
        if(length >= 0)        
        {
            array = new String[length];
for(int i = 0;i < length;i++)
            {
                array[i] = readString();
            } //End block
        } //End block
String[] var1270D5B74B756F17D644A15D775499D9_732980699 =         array;
        var1270D5B74B756F17D644A15D775499D9_732980699.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_732980699;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.036 -0400", hash_original_method = "0A6BC69D8060353BD0BABF3E9B4D1085", hash_generated_method = "AAFFC702BE86803142E3984F780FF7BF")
    public final CharSequence[] readCharSequenceArray() {
        CharSequence[] array = null;
        int length = readInt();
        if(length >= 0)        
        {
            array = new CharSequence[length];
for(int i = 0;i < length;i++)
            {
                array[i] = readCharSequence();
            } //End block
        } //End block
CharSequence[] var1270D5B74B756F17D644A15D775499D9_2044581599 =         array;
        var1270D5B74B756F17D644A15D775499D9_2044581599.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_2044581599;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.037 -0400", hash_original_method = "0CB879EE6020D3E02716A43BE19D4D51", hash_generated_method = "79D299811EEB43E6CB1612BD54087FA9")
    public final ArrayList readArrayList(ClassLoader loader) {
        addTaint(loader.getTaint());
        int N = readInt();
        if(N < 0)        
        {
ArrayList var540C13E9E156B687226421B24F2DF178_2087365461 =             null;
            var540C13E9E156B687226421B24F2DF178_2087365461.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2087365461;
        } //End block
        ArrayList l = new ArrayList(N);
        readListInternal(l, N, loader);
ArrayList var792FD495AAD83D144D2F19BF9BB22987_1837081623 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_1837081623.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_1837081623;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //ArrayList l = new ArrayList(N);
        //readListInternal(l, N, loader);
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.037 -0400", hash_original_method = "BFE5C5C5F5678C281D93BB53C31E26A0", hash_generated_method = "0F82136E3F9ACE84183434F6487FA359")
    public final Object[] readArray(ClassLoader loader) {
        addTaint(loader.getTaint());
        int N = readInt();
        if(N < 0)        
        {
Object[] var540C13E9E156B687226421B24F2DF178_432580458 =             null;
            var540C13E9E156B687226421B24F2DF178_432580458.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_432580458;
        } //End block
        Object[] l = new Object[N];
        readArrayInternal(l, N, loader);
Object[] var792FD495AAD83D144D2F19BF9BB22987_1933198972 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_1933198972.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_1933198972;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //Object[] l = new Object[N];
        //readArrayInternal(l, N, loader);
        //return l;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.037 -0400", hash_original_method = "53952EC2EA973438719A76F49C86D9F1", hash_generated_method = "81FFB97D81BE5ACF5917CECEA9071C35")
    public final SparseArray readSparseArray(ClassLoader loader) {
        addTaint(loader.getTaint());
        int N = readInt();
        if(N < 0)        
        {
SparseArray var540C13E9E156B687226421B24F2DF178_1612464755 =             null;
            var540C13E9E156B687226421B24F2DF178_1612464755.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1612464755;
        } //End block
        SparseArray sa = new SparseArray(N);
        readSparseArrayInternal(sa, N, loader);
SparseArray varDB7E08DF6F59CAA1AFB42C12F35ED909_156630958 =         sa;
        varDB7E08DF6F59CAA1AFB42C12F35ED909_156630958.addTaint(taint);
        return varDB7E08DF6F59CAA1AFB42C12F35ED909_156630958;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //SparseArray sa = new SparseArray(N);
        //readSparseArrayInternal(sa, N, loader);
        //return sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.038 -0400", hash_original_method = "04DCF387CF40E8397784231DC7CB64F8", hash_generated_method = "4F692C815EED26E50A7BE30AFA1ED1F2")
    public final SparseBooleanArray readSparseBooleanArray() {
        int N = readInt();
        if(N < 0)        
        {
SparseBooleanArray var540C13E9E156B687226421B24F2DF178_1778406631 =             null;
            var540C13E9E156B687226421B24F2DF178_1778406631.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1778406631;
        } //End block
        SparseBooleanArray sa = new SparseBooleanArray(N);
        readSparseBooleanArrayInternal(sa, N);
SparseBooleanArray varDB7E08DF6F59CAA1AFB42C12F35ED909_1536504884 =         sa;
        varDB7E08DF6F59CAA1AFB42C12F35ED909_1536504884.addTaint(taint);
        return varDB7E08DF6F59CAA1AFB42C12F35ED909_1536504884;
        // ---------- Original Method ----------
        //int N = readInt();
        //if (N < 0) {
            //return null;
        //}
        //SparseBooleanArray sa = new SparseBooleanArray(N);
        //readSparseBooleanArrayInternal(sa, N);
        //return sa;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.038 -0400", hash_original_method = "456F7B8C59883BEB9D747B5AF3A070B1", hash_generated_method = "F21026394671967AE49ED7E937008133")
    public final <T> ArrayList<T> createTypedArrayList(Parcelable.Creator<T> c) {
        addTaint(c.getTaint());
        int N = readInt();
        if(N < 0)        
        {
ArrayList<T> var540C13E9E156B687226421B24F2DF178_2106399565 =             null;
            var540C13E9E156B687226421B24F2DF178_2106399565.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2106399565;
        } //End block
        ArrayList<T> l = new ArrayList<T>(N);
        while
(N > 0)        
        {
            if(readInt() != 0)            
            {
                l.add(c.createFromParcel(this));
            } //End block
            else
            {
                l.add(null);
            } //End block
            N--;
        } //End block
ArrayList<T> var792FD495AAD83D144D2F19BF9BB22987_768472746 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_768472746.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_768472746;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.038 -0400", hash_original_method = "B9FCE8B620ADC76BF3A577C32D057CDB", hash_generated_method = "65CF1AD2257BFEFF93F30C1F33EEDA77")
    public final <T> void readTypedList(List<T> list, Parcelable.Creator<T> c) {
        addTaint(c.getTaint());
        addTaint(list.getTaint());
        int M = list.size();
        int N = readInt();
        int i = 0;
for(;i < M && i < N;i++)
        {
            if(readInt() != 0)            
            {
                list.set(i, c.createFromParcel(this));
            } //End block
            else
            {
                list.set(i, null);
            } //End block
        } //End block
for(;i<N;i++)
        {
            if(readInt() != 0)            
            {
                list.add(c.createFromParcel(this));
            } //End block
            else
            {
                list.add(null);
            } //End block
        } //End block
for(;i<M;i++)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.038 -0400", hash_original_method = "6BB9790DD7CE6638433A98D5801460E1", hash_generated_method = "CABF0AC6A9F36C61CB5DADA67A0CE3DF")
    public final ArrayList<String> createStringArrayList() {
        int N = readInt();
        if(N < 0)        
        {
ArrayList<String> var540C13E9E156B687226421B24F2DF178_1131298320 =             null;
            var540C13E9E156B687226421B24F2DF178_1131298320.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1131298320;
        } //End block
        ArrayList<String> l = new ArrayList<String>(N);
        while
(N > 0)        
        {
            l.add(readString());
            N--;
        } //End block
ArrayList<String> var792FD495AAD83D144D2F19BF9BB22987_2077694188 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_2077694188.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_2077694188;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.038 -0400", hash_original_method = "4AA47F929C1AD4C6AA4FF7E97EBA01C3", hash_generated_method = "99040799A5CBD116F1B54603E6C8B096")
    public final ArrayList<IBinder> createBinderArrayList() {
        int N = readInt();
        if(N < 0)        
        {
ArrayList<IBinder> var540C13E9E156B687226421B24F2DF178_1717594819 =             null;
            var540C13E9E156B687226421B24F2DF178_1717594819.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1717594819;
        } //End block
        ArrayList<IBinder> l = new ArrayList<IBinder>(N);
        while
(N > 0)        
        {
            l.add(readStrongBinder());
            N--;
        } //End block
ArrayList<IBinder> var792FD495AAD83D144D2F19BF9BB22987_1005336864 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_1005336864.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_1005336864;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.039 -0400", hash_original_method = "9CB504FEFB4242E237E17E2EB9A48FBD", hash_generated_method = "372E034A2F4ABC77332B99E3459086ED")
    public final void readStringList(List<String> list) {
        addTaint(list.getTaint());
        int M = list.size();
        int N = readInt();
        int i = 0;
for(;i < M && i < N;i++)
        {
            list.set(i, readString());
        } //End block
for(;i<N;i++)
        {
            list.add(readString());
        } //End block
for(;i<M;i++)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.039 -0400", hash_original_method = "BD5E31C17A1894DBD3B1CCAA7C1D6816", hash_generated_method = "3D2F441B730AD7BA3867AC4E2172A199")
    public final void readBinderList(List<IBinder> list) {
        addTaint(list.getTaint());
        int M = list.size();
        int N = readInt();
        int i = 0;
for(;i < M && i < N;i++)
        {
            list.set(i, readStrongBinder());
        } //End block
for(;i<N;i++)
        {
            list.add(readStrongBinder());
        } //End block
for(;i<M;i++)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.054 -0400", hash_original_method = "3CEF6E6386B4F00BA8155F93C3068CB0", hash_generated_method = "711C689B08BF0A1B5EA92CF2B6A8CA39")
    public final <T> T[] createTypedArray(Parcelable.Creator<T> c) {
        addTaint(c.getTaint());
        int N = readInt();
        if(N < 0)        
        {
T[] var540C13E9E156B687226421B24F2DF178_960863247 =             null;
            var540C13E9E156B687226421B24F2DF178_960863247.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_960863247;
        } //End block
        T[] l = c.newArray(N);
for(int i=0;i<N;i++)
        {
            if(readInt() != 0)            
            {
                l[i] = c.createFromParcel(this);
            } //End block
        } //End block
T[] var792FD495AAD83D144D2F19BF9BB22987_1247033320 =         l;
        var792FD495AAD83D144D2F19BF9BB22987_1247033320.addTaint(taint);
        return var792FD495AAD83D144D2F19BF9BB22987_1247033320;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.054 -0400", hash_original_method = "94DCFDEC159CF16A54AB9BC1543AACB0", hash_generated_method = "A2BC1EF036C8423C8CF9531FF342F7FC")
    public final <T> void readTypedArray(T[] val, Parcelable.Creator<T> c) {
        addTaint(c.getTaint());
        addTaint(val[0].getTaint());
        int N = readInt();
        if(N == val.length)        
        {
for(int i=0;i<N;i++)
            {
                if(readInt() != 0)                
                {
                    val[i] = c.createFromParcel(this);
                } //End block
                else
                {
                    val[i] = null;
                } //End block
            } //End block
        } //End block
        else
        {
            RuntimeException varABCC3A7B1CC9FF559D2CBC4762AA26B5_1216004091 = new RuntimeException("bad array lengths");
            varABCC3A7B1CC9FF559D2CBC4762AA26B5_1216004091.addTaint(taint);
            throw varABCC3A7B1CC9FF559D2CBC4762AA26B5_1216004091;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.055 -0400", hash_original_method = "6C2CF48F71A46FC325FBB3DF7C6E0C74", hash_generated_method = "60C91B1196961618749EFE14D424D98A")
    @Deprecated
    public final <T> T[] readTypedArray(Parcelable.Creator<T> c) {
        addTaint(c.getTaint());
T[] varD8B9B68676FCD05D5EF0D55511663E8B_443422968 =         createTypedArray(c);
        varD8B9B68676FCD05D5EF0D55511663E8B_443422968.addTaint(taint);
        return varD8B9B68676FCD05D5EF0D55511663E8B_443422968;
        // ---------- Original Method ----------
        //return createTypedArray(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.055 -0400", hash_original_method = "B6CF25F021EC35EAE7839E69AD502686", hash_generated_method = "693309CE89BE06170CBA2F60A71F714E")
    public final <T extends Parcelable> void writeParcelableArray(T[] value,
            int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(value[0].getTaint());
        if(value != null)        
        {
            int N = value.length;
            writeInt(N);
for(int i=0;i<N;i++)
            {
                writeParcelable(value[i], parcelableFlags);
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.055 -0400", hash_original_method = "BC2BD16709D000C887B8D48E60CFBD74", hash_generated_method = "52331FC0AE8972B649CBD92204B05340")
    public final Object readValue(ClassLoader loader) {
        addTaint(loader.getTaint());
        int type = readInt();
switch(type){
        case VAL_NULL:
Object var540C13E9E156B687226421B24F2DF178_645662134 =         null;
        var540C13E9E156B687226421B24F2DF178_645662134.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_645662134;
        case VAL_STRING:
Object var44C20206C1D72E81B2F49EF5B9651D83_1986754144 =         readString();
        var44C20206C1D72E81B2F49EF5B9651D83_1986754144.addTaint(taint);
        return var44C20206C1D72E81B2F49EF5B9651D83_1986754144;
        case VAL_INTEGER:
Object varAF6FD0C4D77B6F9AC29131990947C3F7_1385246604 =         readInt();
        varAF6FD0C4D77B6F9AC29131990947C3F7_1385246604.addTaint(taint);
        return varAF6FD0C4D77B6F9AC29131990947C3F7_1385246604;
        case VAL_MAP:
Object varBF0DE35B900D1F9514C8E99BAD67E3B3_1360557860 =         readHashMap(loader);
        varBF0DE35B900D1F9514C8E99BAD67E3B3_1360557860.addTaint(taint);
        return varBF0DE35B900D1F9514C8E99BAD67E3B3_1360557860;
        case VAL_PARCELABLE:
Object var6A65DF55A01F0AF4ECFAE5584F21E34D_421192956 =         readParcelable(loader);
        var6A65DF55A01F0AF4ECFAE5584F21E34D_421192956.addTaint(taint);
        return var6A65DF55A01F0AF4ECFAE5584F21E34D_421192956;
        case VAL_SHORT:
Object var7F52263540D3EE5313328EE567711CFC_711611804 =         (short) readInt();
        var7F52263540D3EE5313328EE567711CFC_711611804.addTaint(taint);
        return var7F52263540D3EE5313328EE567711CFC_711611804;
        case VAL_LONG:
Object var3111FB3B8323973C08BF4F55007760ED_1572703816 =         readLong();
        var3111FB3B8323973C08BF4F55007760ED_1572703816.addTaint(taint);
        return var3111FB3B8323973C08BF4F55007760ED_1572703816;
        case VAL_FLOAT:
Object var40C52B803E28B2DFCF2AD0D31D88205D_1533840052 =         readFloat();
        var40C52B803E28B2DFCF2AD0D31D88205D_1533840052.addTaint(taint);
        return var40C52B803E28B2DFCF2AD0D31D88205D_1533840052;
        case VAL_DOUBLE:
Object varEAFEFFE4975C485DA754B9DD476D1880_2129191445 =         readDouble();
        varEAFEFFE4975C485DA754B9DD476D1880_2129191445.addTaint(taint);
        return varEAFEFFE4975C485DA754B9DD476D1880_2129191445;
        case VAL_BOOLEAN:
Object var990D28CB2C40EC0B42E839F9AE8F112C_1172543076 =         readInt() == 1;
        var990D28CB2C40EC0B42E839F9AE8F112C_1172543076.addTaint(taint);
        return var990D28CB2C40EC0B42E839F9AE8F112C_1172543076;
        case VAL_CHARSEQUENCE:
Object var9C5CD27CECE4A73DE03CCADDF6F1439A_802822984 =         readCharSequence();
        var9C5CD27CECE4A73DE03CCADDF6F1439A_802822984.addTaint(taint);
        return var9C5CD27CECE4A73DE03CCADDF6F1439A_802822984;
        case VAL_LIST:
Object varA73C9412F7C2714D363DE6039A19BB51_1639248792 =         readArrayList(loader);
        varA73C9412F7C2714D363DE6039A19BB51_1639248792.addTaint(taint);
        return varA73C9412F7C2714D363DE6039A19BB51_1639248792;
        case VAL_BOOLEANARRAY:
Object var090EDCF5359E6AFF1E069B2B4A4527BC_195538541 =         createBooleanArray();
        var090EDCF5359E6AFF1E069B2B4A4527BC_195538541.addTaint(taint);
        return var090EDCF5359E6AFF1E069B2B4A4527BC_195538541;
        case VAL_BYTEARRAY:
Object var968A726FE75A92DABACEA157498200A4_1125260124 =         createByteArray();
        var968A726FE75A92DABACEA157498200A4_1125260124.addTaint(taint);
        return var968A726FE75A92DABACEA157498200A4_1125260124;
        case VAL_STRINGARRAY:
Object var029247E979DA007EC5A1E913C3E682A1_231667674 =         readStringArray();
        var029247E979DA007EC5A1E913C3E682A1_231667674.addTaint(taint);
        return var029247E979DA007EC5A1E913C3E682A1_231667674;
        case VAL_CHARSEQUENCEARRAY:
Object varB0C85792072E0779C102C04325DB8CE7_1715556574 =         readCharSequenceArray();
        varB0C85792072E0779C102C04325DB8CE7_1715556574.addTaint(taint);
        return varB0C85792072E0779C102C04325DB8CE7_1715556574;
        case VAL_IBINDER:
Object varD77C57B9225BDA93D484EA50DAB94009_1782384223 =         readStrongBinder();
        varD77C57B9225BDA93D484EA50DAB94009_1782384223.addTaint(taint);
        return varD77C57B9225BDA93D484EA50DAB94009_1782384223;
        case VAL_OBJECTARRAY:
Object var7F18C9F840AFEBFEB5185B37953974C8_203401449 =         readArray(loader);
        var7F18C9F840AFEBFEB5185B37953974C8_203401449.addTaint(taint);
        return var7F18C9F840AFEBFEB5185B37953974C8_203401449;
        case VAL_INTARRAY:
Object var271BA127D5B0198228F89D3FF39D9353_1593070519 =         createIntArray();
        var271BA127D5B0198228F89D3FF39D9353_1593070519.addTaint(taint);
        return var271BA127D5B0198228F89D3FF39D9353_1593070519;
        case VAL_LONGARRAY:
Object var69818E0DBA9CDE6E9BCF45809E743B8C_95662018 =         createLongArray();
        var69818E0DBA9CDE6E9BCF45809E743B8C_95662018.addTaint(taint);
        return var69818E0DBA9CDE6E9BCF45809E743B8C_95662018;
        case VAL_BYTE:
Object varBEADCED4CB036F53FC55E0DA0AA310E3_1528547189 =         readByte();
        varBEADCED4CB036F53FC55E0DA0AA310E3_1528547189.addTaint(taint);
        return varBEADCED4CB036F53FC55E0DA0AA310E3_1528547189;
        case VAL_SERIALIZABLE:
Object var8FA2376C2D5704ED5EE67E8F8253CDF6_1583438223 =         readSerializable();
        var8FA2376C2D5704ED5EE67E8F8253CDF6_1583438223.addTaint(taint);
        return var8FA2376C2D5704ED5EE67E8F8253CDF6_1583438223;
        case VAL_PARCELABLEARRAY:
Object var970CE1BEAB8EB55DE320CACC9FD46058_1185547522 =         readParcelableArray(loader);
        var970CE1BEAB8EB55DE320CACC9FD46058_1185547522.addTaint(taint);
        return var970CE1BEAB8EB55DE320CACC9FD46058_1185547522;
        case VAL_SPARSEARRAY:
Object var22AEBE6EFBB266AE70608CC0A6598442_1048071756 =         readSparseArray(loader);
        var22AEBE6EFBB266AE70608CC0A6598442_1048071756.addTaint(taint);
        return var22AEBE6EFBB266AE70608CC0A6598442_1048071756;
        case VAL_SPARSEBOOLEANARRAY:
Object var6FF710DF0D6C54A12A99014F03C3D77B_1920066914 =         readSparseBooleanArray();
        var6FF710DF0D6C54A12A99014F03C3D77B_1920066914.addTaint(taint);
        return var6FF710DF0D6C54A12A99014F03C3D77B_1920066914;
        case VAL_BUNDLE:
Object var18CCBE7D54870399D34EEB9384F84276_1436221574 =         readBundle(loader);
        var18CCBE7D54870399D34EEB9384F84276_1436221574.addTaint(taint);
        return var18CCBE7D54870399D34EEB9384F84276_1436221574;
        default:
        int off = dataPosition() - 4;
        RuntimeException var77BBFA44455436A2B6822FCECC83B1A2_1195375502 = new RuntimeException(
                "Parcel " + this + ": Unmarshalling unknown type code " + type + " at offset " + off);
        var77BBFA44455436A2B6822FCECC83B1A2_1195375502.addTaint(taint);
        throw var77BBFA44455436A2B6822FCECC83B1A2_1195375502;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.056 -0400", hash_original_method = "973DB4BA749CEAB3796DAD314F27DB98", hash_generated_method = "DB31E714A43DA04DBEBEDA79E5163E5D")
    public final <T extends Parcelable> T readParcelable(ClassLoader loader) {
        addTaint(loader.getTaint());
        String name = readString();
        if(name == null)        
        {
T var540C13E9E156B687226421B24F2DF178_1208725751 =             null;
            var540C13E9E156B687226421B24F2DF178_1208725751.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1208725751;
        } //End block
        Parcelable.Creator<T> creator;
        synchronized
(mCreators)        {
            HashMap<String,Parcelable.Creator> map = mCreators.get(loader);
            if(map == null)            
            {
                map = new HashMap<String,Parcelable.Creator>();
                mCreators.put(loader, map);
            } //End block
            creator = map.get(name);
            if(creator == null)            
            {
                try 
                {
                    Class c = loader == null ?
                        Class.forName(name) : Class.forName(name, true, loader);
                    Field f = c.getField("CREATOR");
                    creator = (Parcelable.Creator)f.get(null);
                } //End block
                catch (IllegalAccessException e)
                {
                    BadParcelableException var15FCD9AA54D8944C231B211507F3334B_1908462721 = new BadParcelableException(
                            "IllegalAccessException when unmarshalling: " + name);
                    var15FCD9AA54D8944C231B211507F3334B_1908462721.addTaint(taint);
                    throw var15FCD9AA54D8944C231B211507F3334B_1908462721;
                } //End block
                catch (ClassNotFoundException e)
                {
                    BadParcelableException var9884CE22BD75DBF2AB51DBB6570AD212_1841743944 = new BadParcelableException(
                            "ClassNotFoundException when unmarshalling: " + name);
                    var9884CE22BD75DBF2AB51DBB6570AD212_1841743944.addTaint(taint);
                    throw var9884CE22BD75DBF2AB51DBB6570AD212_1841743944;
                } //End block
                catch (ClassCastException e)
                {
                    BadParcelableException var22C8D62E6BDC114FCD2BA76A51A5950F_877971866 = new BadParcelableException("Parcelable protocol requires a "
                                        + "Parcelable.Creator object called "
                                        + " CREATOR on class " + name);
                    var22C8D62E6BDC114FCD2BA76A51A5950F_877971866.addTaint(taint);
                    throw var22C8D62E6BDC114FCD2BA76A51A5950F_877971866;
                } //End block
                catch (NoSuchFieldException e)
                {
                    BadParcelableException var22C8D62E6BDC114FCD2BA76A51A5950F_478697695 = new BadParcelableException("Parcelable protocol requires a "
                                        + "Parcelable.Creator object called "
                                        + " CREATOR on class " + name);
                    var22C8D62E6BDC114FCD2BA76A51A5950F_478697695.addTaint(taint);
                    throw var22C8D62E6BDC114FCD2BA76A51A5950F_478697695;
                } //End block
                if(creator == null)                
                {
                    BadParcelableException var22C8D62E6BDC114FCD2BA76A51A5950F_1677994219 = new BadParcelableException("Parcelable protocol requires a "
                                        + "Parcelable.Creator object called "
                                        + " CREATOR on class " + name);
                    var22C8D62E6BDC114FCD2BA76A51A5950F_1677994219.addTaint(taint);
                    throw var22C8D62E6BDC114FCD2BA76A51A5950F_1677994219;
                } //End block
                map.put(name, creator);
            } //End block
        } //End block
        if(creator instanceof Parcelable.ClassLoaderCreator<?>)        
        {
T var887616FA43D03675155AEBD7DCF83E91_154971612 =             ((Parcelable.ClassLoaderCreator<T>)creator).createFromParcel(this, loader);
            var887616FA43D03675155AEBD7DCF83E91_154971612.addTaint(taint);
            return var887616FA43D03675155AEBD7DCF83E91_154971612;
        } //End block
T var0C23B451CBB62FD5D8C4AD9A5BFF5338_1284816494 =         creator.createFromParcel(this);
        var0C23B451CBB62FD5D8C4AD9A5BFF5338_1284816494.addTaint(taint);
        return var0C23B451CBB62FD5D8C4AD9A5BFF5338_1284816494;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.056 -0400", hash_original_method = "7F7B3246FDA8DADD28F39102743A1FDB", hash_generated_method = "3347B9879C7F9B58834B35037F4F8B3A")
    public final Parcelable[] readParcelableArray(ClassLoader loader) {
        addTaint(loader.getTaint());
        int N = readInt();
        if(N < 0)        
        {
Parcelable[] var540C13E9E156B687226421B24F2DF178_725405704 =             null;
            var540C13E9E156B687226421B24F2DF178_725405704.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_725405704;
        } //End block
        Parcelable[] p = new Parcelable[N];
for(int i = 0;i < N;i++)
        {
            p[i] = (Parcelable) readParcelable(loader);
        } //End block
Parcelable[] var74E4690D9F2A026504928C017944E149_2113237687 =         p;
        var74E4690D9F2A026504928C017944E149_2113237687.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_2113237687;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.056 -0400", hash_original_method = "71C92188775A0F7E9317C601C7CC8BB5", hash_generated_method = "11A022EC9D6DA87818748092F7F35901")
    public final Serializable readSerializable() {
        String name = readString();
        if(name == null)        
        {
Serializable var540C13E9E156B687226421B24F2DF178_2061310753 =             null;
            var540C13E9E156B687226421B24F2DF178_2061310753.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2061310753;
        } //End block
        byte[] serializedData = createByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
        try 
        {
            ObjectInputStream ois = new ObjectInputStream(bais);
Serializable var930DCC71CFA7380BC4F670D7295108B3_1137978770 =             (Serializable) ois.readObject();
            var930DCC71CFA7380BC4F670D7295108B3_1137978770.addTaint(taint);
            return var930DCC71CFA7380BC4F670D7295108B3_1137978770;
        } //End block
        catch (IOException ioe)
        {
            RuntimeException var1C12C41CD3F67C30067ECC5DE54279D9_746579721 = new RuntimeException("Parcelable encountered " +
                "IOException reading a Serializable object (name = " + name +
                ")", ioe);
            var1C12C41CD3F67C30067ECC5DE54279D9_746579721.addTaint(taint);
            throw var1C12C41CD3F67C30067ECC5DE54279D9_746579721;
        } //End block
        catch (ClassNotFoundException cnfe)
        {
            RuntimeException var0BFE3BC28DCFBA5DD5D3128C443C298B_1813179074 = new RuntimeException("Parcelable encountered" +
                "ClassNotFoundException reading a Serializable object (name = "
                + name + ")", cnfe);
            var0BFE3BC28DCFBA5DD5D3128C443C298B_1813179074.addTaint(taint);
            throw var0BFE3BC28DCFBA5DD5D3128C443C298B_1813179074;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "8123E4A6E665502F6F718041F61607F2", hash_generated_method = "C05C3850DB23684102D64680B5D04F60")
    @Override
    protected void finalize() throws Throwable {
        if(DEBUG_RECYCLE)        
        {
            if(mStack != null)            
            {
            } //End block
        } //End block
        destroy();
        // ---------- Original Method ----------
        //if (DEBUG_RECYCLE) {
            //if (mStack != null) {
                //Log.w(TAG, "Client did not call Parcel.recycle()", mStack);
            //}
        //}
        //destroy();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "C0427B473F1AF57292972C32F441E719", hash_generated_method = "61A4E66F7E3CD1708E9FB208543A8E37")
    private void freeBuffer() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "70F6A5F1801DEC2DB8BE38968C81061C", hash_generated_method = "2B68B9C20AB085D1D67AAC97913FD822")
    private void init(int obj) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "870C0C4D9949E316DFA0E367EFD712A9")
    private void destroy() {
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "377C79A0AFFA00A75F96A5842171AC58", hash_generated_method = "C3E38E9D387FCF808198E9F74199C991")
     void readMapInternal(Map outVal, int N,
        ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(N);
        addTaint(outVal.getTaint());
        while
(N > 0)        
        {
            Object key = readValue(loader);
            Object value = readValue(loader);
            outVal.put(key, value);
            N--;
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //Object key = readValue(loader);
            //Object value = readValue(loader);
            //outVal.put(key, value);
            //N--;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "9EEE2505D88E68CC65378BE9FEB363CC", hash_generated_method = "6B5827457146BEB0975595F45FF3C4BD")
    private void readListInternal(List outVal, int N,
        ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(N);
        addTaint(outVal.getTaint());
        while
(N > 0)        
        {
            Object value = readValue(loader);
            outVal.add(value);
            N--;
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //Object value = readValue(loader);
            //outVal.add(value);
            //N--;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "8048910DC1D629DD4CA2AB6051E757D5", hash_generated_method = "6A537B36D083B1B8A5017BE43AA2DBBB")
    private void readArrayInternal(Object[] outVal, int N,
        ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(N);
        addTaint(outVal[0].getTaint());
for(int i = 0;i < N;i++)
        {
            Object value = readValue(loader);
            outVal[i] = value;
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < N; i++) {
            //Object value = readValue(loader);
            //outVal[i] = value;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.057 -0400", hash_original_method = "43DDAB261C65CF1F1B4E5B19576BB376", hash_generated_method = "AF3AB278C20FB2120ED94E0370ECB013")
    private void readSparseArrayInternal(SparseArray outVal, int N,
        ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(N);
        addTaint(outVal.getTaint());
        while
(N > 0)        
        {
            int key = readInt();
            Object value = readValue(loader);
            outVal.append(key, value);
            N--;
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //int key = readInt();
            //Object value = readValue(loader);
            //outVal.append(key, value);
            //N--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_method = "687B1CF2F9242ACE26C54A0109BE177B", hash_generated_method = "278364B595C3F319181522E5BE62EBA2")
    private void readSparseBooleanArrayInternal(SparseBooleanArray outVal, int N) {
        addTaint(N);
        addTaint(outVal.getTaint());
        while
(N > 0)        
        {
            int key = readInt();
            boolean value = this.readByte() == 1;
            outVal.append(key, value);
            N--;
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //int key = readInt();
            //boolean value = this.readByte() == 1;
            //outVal.append(key, value);
            //N--;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "A71BA10A20EF888B1EF8CA16D55D9309", hash_generated_field = "4C4C82AEA5D9854FC45DA5375C35C2B9")

    private static final boolean DEBUG_RECYCLE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "B28A49621CF2334B275ADEDF6302D3FE", hash_generated_field = "8D4BB406013288DABCF21E3086232FF0")

    private static final String TAG = "Parcel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "8CC9C9BA8E0F199B497EC24ADC83BF65", hash_generated_field = "806F090E7CB08EA4F7BB25E21BB089B9")

    private static final int POOL_SIZE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "C8932CF14EADE23425A9D54B122FD8C9", hash_generated_field = "2B06E04682E05687F5FE1F91A80B5001")

    private static final Parcel[] sOwnedPool = new Parcel[POOL_SIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "7D0A268CFF89FF45FBD851483F1AA181", hash_generated_field = "6A8EC49B77FA2982F6172D9088BEE965")

    private static final Parcel[] sHolderPool = new Parcel[POOL_SIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "ACEA6349EAE0AE22FE138A1505C3AC43", hash_generated_field = "C083E5876DACD70ACA563A851C9BF80A")

    private static final int VAL_NULL = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "A383EB6C18224D1E8B49FDE74C52AD41", hash_generated_field = "45F7F878732CA50D8D10532C9B029700")

    private static final int VAL_STRING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "90D1816FAD55D60EA32349F44BEE1FA1", hash_generated_field = "3105C6E283A2C8969131A51B9084E315")

    private static final int VAL_INTEGER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "AE858B0C1836E5CD5EA56F704DF57D42", hash_generated_field = "1E3EDA05CA698B82AB90723508DE126A")

    private static final int VAL_MAP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "31533D34B6E9C81E65DCAE4C34B5EE04", hash_generated_field = "77D016C4104C510EB61EAD16649E4B98")

    private static final int VAL_BUNDLE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "25D66E9FE0A96FA5502CB8C017BA33A7", hash_generated_field = "A89ABF4349986B7E1CF429EF8B150F43")

    private static final int VAL_PARCELABLE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "E4BD524F34367626F9C7CD376225C7FB", hash_generated_field = "97F320554483CFA3BD525573C34EEBF6")

    private static final int VAL_SHORT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "5DEC1A4B3D9350FA566473650ABEDC26", hash_generated_field = "F2505784946CF430B6454C933AA64E43")

    private static final int VAL_LONG = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "7C773DA5B01AAAE7B478B5183F72E7A5", hash_generated_field = "15249D8B4B676F2BF7A97F24D427B5AA")

    private static final int VAL_FLOAT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "B9673347A98E9E4F53B2D7677F3DB072", hash_generated_field = "1E7C612DDB2B7EF1312E741523E53799")

    private static final int VAL_DOUBLE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "CF553E461BBB2ACE9C33C7AE3EC116BF", hash_generated_field = "E46F341BE0E2D054D53CDEAD96F1959D")

    private static final int VAL_BOOLEAN = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "C4EFFF2F54E9F7853F6083EFC9E9D109", hash_generated_field = "B7D4E411492999EB4EA9BF2AC586F223")

    private static final int VAL_CHARSEQUENCE = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "CF19CCA45146ED659BC8BE0770B83850", hash_generated_field = "D4F1A8A9E0CE0974E2412812F0DA3F5D")

    private static final int VAL_LIST = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "A48C77C1642DC44BF3193BE6A03A4F27", hash_generated_field = "A131BD3EB211C05E3C6DF73570243AEC")

    private static final int VAL_SPARSEARRAY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "7A27992AF9A0ABD9406AFAD7F69432D1", hash_generated_field = "B0915F7A6E4DB352FA67870120FDC8AE")

    private static final int VAL_BYTEARRAY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "D293DEB200879D8E15F5D077CCFC795E", hash_generated_field = "076CE7EDAA5BD7403EB30339E6786640")

    private static final int VAL_STRINGARRAY = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "7864638DD0ECA8DB5FEA6648DBAC22C7", hash_generated_field = "4E84FC4E833FD58450A808B308F569C1")

    private static final int VAL_IBINDER = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "8FF06F86C8A1DC58010E03FFF27D61BF", hash_generated_field = "0D7C7CC2E878323D6F87D50D47E3E125")

    private static final int VAL_PARCELABLEARRAY = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "8DA9E444EB65D0B5DBF7F59EF7B370BB", hash_generated_field = "6AC2F3E2A41C5CBB0C87EBFBA40C82C5")

    private static final int VAL_OBJECTARRAY = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "6857A57259DB7027514CD5286F44AA3D", hash_generated_field = "CCE7A715FCB460D5B4607A19AB0D3775")

    private static final int VAL_INTARRAY = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "03AC5509ED82DD27DDD80111B0D6F105", hash_generated_field = "32BC10EA8947FB3B0761472950236075")

    private static final int VAL_LONGARRAY = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "E4540E289F5D42A14E7DC05C4CA668C0", hash_generated_field = "8007D2C64A8C971CD877A22E5B760585")

    private static final int VAL_BYTE = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "2E1327ABAE1B48B171CC4B553304BEA1", hash_generated_field = "69C2B09C1800B12048056C3570CC73EE")

    private static final int VAL_SERIALIZABLE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "A124CA776792D53D93CEC75233DBCF6A", hash_generated_field = "76413C216A3003CB555A68458846A3B3")

    private static final int VAL_SPARSEBOOLEANARRAY = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "696AF07A4832CE39E55C7E5208DB7A0B", hash_generated_field = "59D72A13D8A7453CC576337F712A9C20")

    private static final int VAL_BOOLEANARRAY = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "FF01C04E922A7030EA9D324CCA0814E4", hash_generated_field = "9EFA3FF92CCB2C8FEE3D6C5358430431")

    private static final int VAL_CHARSEQUENCEARRAY = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "3565AB005C087B9C54508E43A859B614", hash_generated_field = "A3D419976A9106B09BDA82EB2BFFD162")

    private static final int EX_SECURITY = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "02188DB64D8756EDBDBEB9D7F6FE9E72", hash_generated_field = "F8C2B1DD68AD90CB95C1595F2C9A5242")

    private static final int EX_BAD_PARCELABLE = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.058 -0400", hash_original_field = "4377EB88638F3CE9554BB7F18D23AE22", hash_generated_field = "CB37D327BBB5DFC9C44E983C8B41B091")

    private static final int EX_ILLEGAL_ARGUMENT = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.059 -0400", hash_original_field = "2A43B7B02F2CF68642F5BDF80DED8567", hash_generated_field = "5990AECC0626B57467FE5BBFA45A5C36")

    private static final int EX_NULL_POINTER = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.059 -0400", hash_original_field = "6E8C36F4CB9BC94CE915825BFAAF4E3B", hash_generated_field = "336D3C5B9AFBD7D73F11E5473530DAD0")

    private static final int EX_ILLEGAL_STATE = -5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.059 -0400", hash_original_field = "E1BCE24EB8484F3581021F6250445299", hash_generated_field = "DFC9983F0C453250258C48F81D356118")

    private static final int EX_HAS_REPLY_HEADER = -128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.059 -0400", hash_original_field = "2D365FB9C0F84B811EE25074666800D6", hash_generated_field = "FB53F9F5DC3AAFE064E58E049D0C49AF")

    public final static Parcelable.Creator<String> STRING_CREATOR
             = new Parcelable.Creator<String>() {
        public String createFromParcel(Parcel source) {
            return source.readString();
        }
        public String[] newArray(int size) {
            return new String[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.059 -0400", hash_original_field = "EAE59FB152640F6C5452B3D15C76FF4C", hash_generated_field = "30232A053737FDB52FF30B185E9D15EC")

    private static final HashMap<ClassLoader,HashMap<String,Parcelable.Creator>> mCreators = new HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>();
    // orphaned legacy method
    public String createFromParcel(Parcel source) {
		return source.readString();
	}
    
    // orphaned legacy method
    public String[] newArray(int size) {
		return new String[size];
	}
    
}

