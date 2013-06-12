package android.os;

// Droidsafe Imports
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
// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class Parcel {
    private static boolean DEBUG_RECYCLE = false;
    private static String TAG = "Parcel";
    @SuppressWarnings({"UnusedDeclaration"}) private int mObject;
    @SuppressWarnings({"UnusedDeclaration"}) private int mOwnObject;
    private RuntimeException mStack;
    private static int POOL_SIZE = 6;
    private static Parcel[] sOwnedPool = new Parcel[POOL_SIZE];
    private static Parcel[] sHolderPool = new Parcel[POOL_SIZE];
    private static int VAL_NULL = -1;
    private static int VAL_STRING = 0;
    private static int VAL_INTEGER = 1;
    private static int VAL_MAP = 2;
    private static int VAL_BUNDLE = 3;
    private static int VAL_PARCELABLE = 4;
    private static int VAL_SHORT = 5;
    private static int VAL_LONG = 6;
    private static int VAL_FLOAT = 7;
    private static int VAL_DOUBLE = 8;
    private static int VAL_BOOLEAN = 9;
    private static int VAL_CHARSEQUENCE = 10;
    private static int VAL_LIST  = 11;
    private static int VAL_SPARSEARRAY = 12;
    private static int VAL_BYTEARRAY = 13;
    private static int VAL_STRINGARRAY = 14;
    private static int VAL_IBINDER = 15;
    private static int VAL_PARCELABLEARRAY = 16;
    private static int VAL_OBJECTARRAY = 17;
    private static int VAL_INTARRAY = 18;
    private static int VAL_LONGARRAY = 19;
    private static int VAL_BYTE = 20;
    private static int VAL_SERIALIZABLE = 21;
    private static int VAL_SPARSEBOOLEANARRAY = 22;
    private static int VAL_BOOLEANARRAY = 23;
    private static int VAL_CHARSEQUENCEARRAY = 24;
    private static int EX_SECURITY = -1;
    private static int EX_BAD_PARCELABLE = -2;
    private static int EX_ILLEGAL_ARGUMENT = -3;
    private static int EX_NULL_POINTER = -4;
    private static int EX_ILLEGAL_STATE = -5;
    private static int EX_HAS_REPLY_HEADER = -128;
    public final static Parcelable.Creator<String> STRING_CREATOR = new Parcelable.Creator<String>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.357 -0400", hash_original_method = "CF5066ADB23AB15A8F47A7B0F4466503", hash_generated_method = "5AF4A895DA660C858CD096E1D13E507D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            String var88E96AAFD724559F9FD3FC52BB174D27_799493943 = (source.readString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return source.readString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.358 -0400", hash_original_method = "6691A777569EDCC3CEA07BFC1CA591D5", hash_generated_method = "4339153BFEE48211D522B7693775C6B6")
        @DSModeled(DSC.SAFE)
        public String[] newArray(int size) {
            dsTaint.addTaint(size);
            String[] retVal = new String[1];
            retVal[0] = dsTaint.getTaintString();
            return retVal;
            // ---------- Original Method ----------
            //return new String[size];
        }

        
}; //Transformed anonymous class
    private static HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>
        mCreators = new HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.358 -0400", hash_original_method = "96328320E65E9E5C73AE1A423ABA09C7", hash_generated_method = "8CCADA16B7B7301630CB839596214A95")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.359 -0400", hash_original_method = "E48D9B167DAFEEA2F3B8018E4C82217B", hash_generated_method = "03CD2733333E9F3917A54AD7F72964B1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.359 -0400", hash_original_method = "0B6C271774CE05661982DF3B6AC078FF", hash_generated_method = "D39E5F2F68623088535D79FED64377C0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.360 -0400", hash_original_method = "DD534262B78755109918F5DCE98072D4", hash_generated_method = "24DC5D295274101846C80B1E4040FED3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataSize() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.360 -0400", hash_original_method = "0316AB8FD0A1B068176256EC0E481A72", hash_generated_method = "F678E4134707FF34893DD3825ABE035E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataAvail() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.360 -0400", hash_original_method = "D1BE237E96D29A914DD3E05EDFD3F272", hash_generated_method = "378CC22B61551701DC53648B1D2346A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataPosition() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.360 -0400", hash_original_method = "51F0EF05154419C189F36E1902F5F7AB", hash_generated_method = "C361DF2AE0A89EE4CA9CBB774265AF87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int dataCapacity() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "D8CB87D9AB1E01DFD8357CBF456AE1C5", hash_generated_method = "883AE5DD016FD3501E7BCCA05C1BF766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDataSize(int size) {
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "900D9C4DE4FE3C2709BAAFC39AA9B06F", hash_generated_method = "6EFAC12BB797D1D069FAEF4B69016CCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDataPosition(int pos) {
        dsTaint.addTaint(pos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "E063261D5EA5083378CEC188A4B78FE0", hash_generated_method = "413F8BB7F4B2CB6C09487B6081FE2C5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDataCapacity(int size) {
        dsTaint.addTaint(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "97650A42F80764D7062D6C7A9EDB6E4B", hash_generated_method = "28C007844F7377A2A1DF2129536ABD7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean pushAllowFds(boolean allowFds) {
        dsTaint.addTaint(allowFds);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "D9541DA181394F49233EDC85EBA11372", hash_generated_method = "A904A0E12CA84EF00B8674241BDAF8D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void restoreAllowFds(boolean lastValue) {
        dsTaint.addTaint(lastValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "203FAAB8CBC9466E61C8672BA6829403", hash_generated_method = "E665727BE97A40C520A774C1904E1F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] marshall() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.361 -0400", hash_original_method = "54EF2A5E543EFE1E280A4B6A4F3098CB", hash_generated_method = "035997D37646BBD5B69CBD4F8710A6B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void unmarshall(byte[] data, int offest, int length) {
        dsTaint.addTaint(offest);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "E8A5DF9275FDA0D9B0B70C7334CB1E59", hash_generated_method = "C6EF375498FC5116D702670D6A143F6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void appendFrom(Parcel parcel, int offset, int length) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "A1C2B053FCB3ADAB79F2D704E198BAB1", hash_generated_method = "F77F08F2B546D404287C0B3285136B25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasFileDescriptors() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "EBD07D08BBA21F0C5B4E86C34DC5CAC1", hash_generated_method = "3C8D53B5F26D411FFC87E91583D533F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeInterfaceToken(String interfaceName) {
        dsTaint.addTaint(interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "5F95BF99C2626C7B3640C2D1B3B7BEE7", hash_generated_method = "E7C69B5342B0746FB418C66717A7387D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void enforceInterface(String interfaceName) {
        dsTaint.addTaint(interfaceName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "6AA57281F567FED2151D4FF51C5ADD5D", hash_generated_method = "BFA5762C809C206648134E4AAFD16D0E")
    @DSModeled(DSC.SAFE)
    public final void writeByteArray(byte[] b) {
        dsTaint.addTaint(b[0]);
        writeByteArray(b, 0, (b != null) ? b.length : 0);
        // ---------- Original Method ----------
        //writeByteArray(b, 0, (b != null) ? b.length : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "292A0D9A6E9AD589E2915A38A2AF794D", hash_generated_method = "349D2351C89FAB30D5CEC94E98352DA9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.362 -0400", hash_original_method = "13EF9FAE46E0DC273567B76840FE8431", hash_generated_method = "E9EBAECD160105DB918B64F07F70F52B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeNative(byte[] b, int offset, int len) {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "EB7F50F11C67DFE7362846314C368039", hash_generated_method = "A3C6B9CA263ED609A836D67AF477AD5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeInt(int val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "6EE9E92592584E19EA2786245476EB1F", hash_generated_method = "F8882C7DD4742BABD50F6030C2A0D7B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeLong(long val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "8E6A3106AB0C4A6CA5D134BC13C79A46", hash_generated_method = "F8606E0AF4171C39D3DBFE840B66DF66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloat(float val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "580EB112F6684AC838EF0FAE39FE6143", hash_generated_method = "8A93EAA40C167AB2B0090E333B71B282")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDouble(double val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "148FED92CD1AE4975AE2973407FF84B1", hash_generated_method = "E35FD2592FF8C9F84F0B84CD35D90285")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeString(String val) {
        dsTaint.addTaint(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "CEAF068B566AB67AE8F044276645F78A", hash_generated_method = "DA0ACC9ACA3A4DDE4577E0806E027005")
    @DSModeled(DSC.SAFE)
    public final void writeCharSequence(CharSequence val) {
        dsTaint.addTaint(val);
        TextUtils.writeToParcel(val, this, 0);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(val, this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "7DA1E5E6DC1856828FF2B443CF2EA2D0", hash_generated_method = "69593813FC927CEC3A33907B5758EF54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeStrongBinder(IBinder val) {
        dsTaint.addTaint(val.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.363 -0400", hash_original_method = "D29D74B8509F3EDC680AC67A58B2AE11", hash_generated_method = "AA48910A3BC317EE2ACA6FEF262EE85D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeStrongInterface(IInterface val) {
        dsTaint.addTaint(val.dsTaint);
        writeStrongBinder(val == null ? null : val.asBinder());
        // ---------- Original Method ----------
        //writeStrongBinder(val == null ? null : val.asBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.364 -0400", hash_original_method = "F228581B9954F98E592DA68C1EE89409", hash_generated_method = "6F0669806F5887FE6DD53BC724AE93FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFileDescriptor(FileDescriptor val) {
        dsTaint.addTaint(val.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.364 -0400", hash_original_method = "B137ADD0EA125F15A647DF5EEF6060FE", hash_generated_method = "3327C4EF3104BF5F097FE019C066A83A")
    @DSModeled(DSC.SAFE)
    public final void writeByte(byte val) {
        dsTaint.addTaint(val);
        writeInt(val);
        // ---------- Original Method ----------
        //writeInt(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.364 -0400", hash_original_method = "028C08B0E96835B592DD57E92E1A9654", hash_generated_method = "B447F451B4885ECFDD2A7C46AD62BD33")
    @DSModeled(DSC.SAFE)
    public final void writeMap(Map val) {
        dsTaint.addTaint(val.dsTaint);
        writeMapInternal((Map<String,Object>) val);
        // ---------- Original Method ----------
        //writeMapInternal((Map<String,Object>) val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.364 -0400", hash_original_method = "254CF4BDBF55D33C4656934F15F7844A", hash_generated_method = "6B9BAEDC269B4990388A1B08F6979965")
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
            Iterator<Map.Entry<String,Object>> seatecAstronomy42 = entries.iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<String,Object> e = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.364 -0400", hash_original_method = "1B271C6B96886293B3F46C86D8594D62", hash_generated_method = "11FA71E14183006413B12B9E9AA610D7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.365 -0400", hash_original_method = "E7219AA1C86EB1036E36A514DFF44066", hash_generated_method = "5DEBB34F71C768FF1086E9BE429001AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.365 -0400", hash_original_method = "903390B15749D4F099959DBD9D939641", hash_generated_method = "21F02AFD414FA8DE6D7FBFFA92565240")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.365 -0400", hash_original_method = "932B15FDC26AECB59BA0DEB9D7727076", hash_generated_method = "91EDF9AF0977C2F51458706595A1C190")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.365 -0400", hash_original_method = "501AACE22AB4AEC41E440B95E2BF337F", hash_generated_method = "028008A065F0D14FF2D01D66D7BA4EBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.366 -0400", hash_original_method = "D75DEF1EB05EA54B4B0A6C775E789115", hash_generated_method = "6E9747727695178B4C1DB1662FB3A5BD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.370 -0400", hash_original_method = "636C08B3912226F5C58D74422D1E9CB4", hash_generated_method = "DB4B059B55FA7D4076B97E735A967811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean[] createBooleanArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_989748635 = (N >= 0 && N <= (dataAvail() >> 2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.370 -0400", hash_original_method = "15202BE45A888A7FAE449643C1F651D3", hash_generated_method = "CDFE879CA89C5E118AA4555824395DA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.371 -0400", hash_original_method = "FC1109029B4BAAFE0FA31EEEF8F95A5F", hash_generated_method = "9A25DA77FE2B5271254E3386C3E47F52")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.371 -0400", hash_original_method = "0F2CB9A0B4BA672805C5DC7ABC31D142", hash_generated_method = "6107C57122F51455B5ED2D698B80F340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char[] createCharArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_1716020624 = (N >= 0 && N <= (dataAvail() >> 2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.373 -0400", hash_original_method = "3577ABA10B4218BCCE6B69B6327658D6", hash_generated_method = "5D9212D57C279B377A692190AA49867D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.374 -0400", hash_original_method = "426B3599371B897BFC6196C71A9C351C", hash_generated_method = "4D04CBFBA5BC7AAEA69BFCD74B635AF6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.374 -0400", hash_original_method = "2BFE53BE4AFBC39913D7CD537675C77F", hash_generated_method = "28BBC52D149AFC201A06A6E4FD0A584E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int[] createIntArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_1653515931 = (N >= 0 && N <= (dataAvail() >> 2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.374 -0400", hash_original_method = "D30E6FBEFEE072DBADEACBC994232724", hash_generated_method = "0779F0BCA456FC589B0E6A72864DC6EE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.375 -0400", hash_original_method = "6AE17F1911C710D67F0B38E1A6953312", hash_generated_method = "B0BB84FBDF5F31DBECB950512A1A89F2")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.375 -0400", hash_original_method = "539AEF1878CDD8393DEC7B15A779334D", hash_generated_method = "150F55CD85D046A5F00C2FC006B81550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long[] createLongArray() {
        int N;
        N = readInt();
        {
            boolean varAFA9B411100B0C263F15734A2739C902_1787422370 = (N >= 0 && N <= (dataAvail() >> 3));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.376 -0400", hash_original_method = "EB1FE051AE6270C29877E320D05D2B1C", hash_generated_method = "2DFBF1ED299247CA31EC71991F53B1B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.376 -0400", hash_original_method = "914127CC1FF235613675A4097238AE87", hash_generated_method = "49435425728DE320DCFD45E6A66E66D8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.394 -0400", hash_original_method = "AD11D1594D734C1EBF478FFED3A5EA0B", hash_generated_method = "7389C27626733C3D082A0D2970C91F75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float[] createFloatArray() {
        int N;
        N = readInt();
        {
            boolean var677D811DE399D0DE094E279FE647ADA9_1531692702 = (N >= 0 && N <= (dataAvail() >> 2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.394 -0400", hash_original_method = "5BAAFA2155FE07D9BA992B0E92A02429", hash_generated_method = "901BE13D64FCE28177EA6D8686F57DAC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.397 -0400", hash_original_method = "30BB607A5C46B583A0E7A88D0830BB99", hash_generated_method = "A6E32A7E7139EC3E9C7F83485C2A8FB8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.398 -0400", hash_original_method = "EADE9932A44C79075558F2C2E2C44BF9", hash_generated_method = "E623E22C7A790365D8AA94FC8BBA2C35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double[] createDoubleArray() {
        int N;
        N = readInt();
        {
            boolean varAFA9B411100B0C263F15734A2739C902_295877129 = (N >= 0 && N <= (dataAvail() >> 3));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.398 -0400", hash_original_method = "1E5CFF0988982B6DD3E5010F6E58EAB2", hash_generated_method = "E3AA679DE2B9386723A2C7CF78C6AE5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.402 -0400", hash_original_method = "869784FDBD7A62BA6DC61589E5325593", hash_generated_method = "0ED3705CBDF59897D110B0D0BD099914")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.402 -0400", hash_original_method = "E25A6435806EEE9817C8F94878902077", hash_generated_method = "6A37B5C71EB1EE5AA071C8F638D5E426")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.403 -0400", hash_original_method = "856C598346084C5A7CB0C8EC3C30AFE8", hash_generated_method = "2EFFFF5E0AEE2BBAFB3223C5AAE99D5E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.403 -0400", hash_original_method = "EF4C8799E7CA7F11199E2A94E26473B3", hash_generated_method = "2200A068F067592B1BA54C83418BCDF4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.404 -0400", hash_original_method = "47477B6B20C2841826851A1DC451409B", hash_generated_method = "8E7A7A9FF865B0D15E59C69BBE2BEB51")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.404 -0400", hash_original_method = "4DE08401A529CB5616CDC9DFD50DAFB3", hash_generated_method = "6463AD4D37060C48BE258F170D9C10AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.404 -0400", hash_original_method = "3E3D11ECAF89B0D6B7212074DA0FB112", hash_generated_method = "384BB08FAA9E15A92C4487DE389E1366")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.432 -0400", hash_original_method = "5826C07CBD3614FC61FFE172F3E36C59", hash_generated_method = "38FB04B2C17E54391C06752A3D8B1C67")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.433 -0400", hash_original_method = "D0AECB36946CE861852315E400637CFF", hash_generated_method = "72BDB358B1E85E8A0A337BF393136CC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.433 -0400", hash_original_method = "7137D7435CDB5CC040EE6A964998B66D", hash_generated_method = "444C32F17930E477331EC8EF617E8E24")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.433 -0400", hash_original_method = "029988DBA55E380B93A4CDBDA2CB7F3E", hash_generated_method = "2E0F76F8912BE946A61B9CB6E9C779A4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.435 -0400", hash_original_method = "D9566C4BE63552F29703FA1385C84129", hash_generated_method = "6B5462A57D702F748CEE4C41AA8C41DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.435 -0400", hash_original_method = "A58184BC725C2FE85E17C583E1DA6016", hash_generated_method = "6F6F82515EEB21D07264F00270F02177")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.436 -0400", hash_original_method = "BCB9F78F7EC1F484C61BF7865779B2F9", hash_generated_method = "6609F39D4D0503AFAAA7C8685E9AA2B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.436 -0400", hash_original_method = "7DD11AC8769A37C0F9583E9AAFAA7192", hash_generated_method = "F34C1CF6BCB9102B1D83FF29F41A9866")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.463 -0400", hash_original_method = "123C62676F5EFD49547DAF82EF108740", hash_generated_method = "69B3CA8AF36E529FB21FD3BBEE899D78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeNoException() {
        {
            boolean var67AAFC75FFEDAFC4D52248FF88A9C8E7_1224479201 = (StrictMode.hasGatheredViolations());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.466 -0400", hash_original_method = "82EBD768B4FCE70E559935E5298055BB", hash_generated_method = "7E348822C82B4E52355C674815A6C039")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.466 -0400", hash_original_method = "38AAEB1276A409D21345CE71D5A4968D", hash_generated_method = "4F068A8A9EB08BF972159642E6D6C03A")
    @DSModeled(DSC.SAFE)
    public final int readExceptionCode() {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.468 -0400", hash_original_method = "16B6C7096EAAE541E38738222303A695", hash_generated_method = "083DCEA5D989D0E147D46994A2C585D9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.468 -0400", hash_original_method = "97FB920EA9544B24495059FF8518145E", hash_generated_method = "D0F3BF22FE8AF5C81728E46A04188598")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readInt() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.468 -0400", hash_original_method = "88765326927052F47E1B04CC1A370299", hash_generated_method = "1F066F89B8EE3E570CE87B2EA3527FAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long readLong() {
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.468 -0400", hash_original_method = "9BF95C525D78F630EDF572E34BF4D430", hash_generated_method = "1A8F4730E6EAD857A7203C8DD293F6AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float readFloat() {
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.468 -0400", hash_original_method = "FFE81D38F89970F2B0BAD4C68B43B4BA", hash_generated_method = "94D4111D533863847971B7B7E37BA2E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double readDouble() {
        return dsTaint.getTaintDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.468 -0400", hash_original_method = "E5D101F44C406F4D63DCAF323A3DBE7A", hash_generated_method = "E049C79EB14DD061A721FE94ADEFA6BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readString() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "1E262BAA6376F101519B67935298363E", hash_generated_method = "BD010028D748AEA7D36E460A5A1FF338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence readCharSequence() {
        CharSequence var09AE683B7FDC546955A024D23E40E19D_26904784 = (TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "5B57CBCFFAE68CC288C10DD7232B6ED1", hash_generated_method = "9CCFE9A5E22E32364132775A1102A0D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IBinder readStrongBinder() {
        return (IBinder)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "624419D3E87C84C27536CFAE1C7248DF", hash_generated_method = "13A932747D033DEF632DF8025FE2077B")
    @DSModeled(DSC.SAFE)
    public final ParcelFileDescriptor readFileDescriptor() {
        FileDescriptor fd;
        fd = internalReadFileDescriptor();
        return (ParcelFileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //FileDescriptor fd = internalReadFileDescriptor();
        //return fd != null ? new ParcelFileDescriptor(fd) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "33B415422717616FBFFA4D8F233FE3A4", hash_generated_method = "C9DA82E8209957DCA29C691B4E15DB1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FileDescriptor internalReadFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "B2F3F8B27CB4258286C773AA600B0EE8", hash_generated_method = "DAFE418B9F98DF02170136B16379440C")
    static FileDescriptor openFileDescriptor(String file,
            int mode) throws FileNotFoundException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new FileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "8061048C5D3A6AC0A450AD6A833E6532", hash_generated_method = "EBD5E96AFE25530733FFD4680526612E")
    static FileDescriptor dupFileDescriptor(FileDescriptor orig) throws IOException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new FileDescriptor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.469 -0400", hash_original_method = "E00AEB025A82FFA9488DE31DE8AED2D3", hash_generated_method = "CF82DB24673159DA179A346DD169CFDC")
    static void closeFileDescriptor(FileDescriptor desc) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.470 -0400", hash_original_method = "74882EB4DAA48F9CF87FAB5545E0723C", hash_generated_method = "3DA45F2EB397692DE0586AB3765DEE2B")
    static void clearFileDescriptor(FileDescriptor desc) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.470 -0400", hash_original_method = "12B71841CE7C7BEB8DB394B4DC6EF58B", hash_generated_method = "F1682EEEBAEE50C6D41D60B11BA90EA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte readByte() {
        byte varA3491D8E17C6029A18B5C5A7657736E0_1291416892 = ((byte)(readInt() & 0xff));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte)(readInt() & 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.470 -0400", hash_original_method = "82825CDD252FB884333A0468F1B46F6F", hash_generated_method = "346EFE2446C92285FDC2D81D57E99528")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.470 -0400", hash_original_method = "C60DBA65518C72AFC52918F8818E7A4A", hash_generated_method = "73D4330AD7C12B9FA7704E13E503F725")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.471 -0400", hash_original_method = "0DC8809E3B9E75AF0CC28567E6782BE5", hash_generated_method = "80AFADE882724BA4ECEF08657604AD35")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.471 -0400", hash_original_method = "30B879800FFE3D55BB9B30F39E994273", hash_generated_method = "49096AFE841E0CE2251211A6581300B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Bundle readBundle() {
        Bundle var9FCD0EFE653F67400EEFD6A452EB50FF_1884281700 = (readBundle(null));
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readBundle(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.471 -0400", hash_original_method = "7DBD463E649AEA6A8616F4943C405C7A", hash_generated_method = "46478CEB79369AA105C8A631808BC93F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.471 -0400", hash_original_method = "DCFF48487CDF8628FF2244CC4810775C", hash_generated_method = "BECE43711CE4C7B42EC7B40E5B7B6798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] createByteArray() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.472 -0400", hash_original_method = "40FE8430590711C6D2AB472A3973EA8A", hash_generated_method = "96C9E30DECB9A906B1376A056D015468")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.472 -0400", hash_original_method = "3F4E1D573E001DD6503628882E161682", hash_generated_method = "F8902C790E0999D37C9882F352CBAEA2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.472 -0400", hash_original_method = "0A6BC69D8060353BD0BABF3E9B4D1085", hash_generated_method = "A49986C7353D2473025DBC5895664644")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.473 -0400", hash_original_method = "0CB879EE6020D3E02716A43BE19D4D51", hash_generated_method = "DFB446F8FF3BEFBC5018154F441A1ABA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.497 -0400", hash_original_method = "BFE5C5C5F5678C281D93BB53C31E26A0", hash_generated_method = "0572D94F986357E6FD0E81B579C88FE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.498 -0400", hash_original_method = "53952EC2EA973438719A76F49C86D9F1", hash_generated_method = "1010E010F0726C6713A02CD1798A0335")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.498 -0400", hash_original_method = "04DCF387CF40E8397784231DC7CB64F8", hash_generated_method = "6DD5736ABB3A57D95C06FFEDCADBEBEB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.498 -0400", hash_original_method = "456F7B8C59883BEB9D747B5AF3A070B1", hash_generated_method = "3D1A03D80DFF5DA6BDCC7EE67C9EE3DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final <T> ArrayList<T> createTypedArrayList(Parcelable.Creator<T> c) {
        dsTaint.addTaint(c.dsTaint);
        int N;
        N = readInt();
        ArrayList<T> l;
        l = new ArrayList<T>(N);
        {
            {
                boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_878720740 = (readInt() != 0);
                {
                    l.add(c.createFromParcel(this));
                } //End block
                {
                    l.add(null);
                } //End block
            } //End collapsed parenthetic
            N--;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.499 -0400", hash_original_method = "B9FCE8B620ADC76BF3A577C32D057CDB", hash_generated_method = "9BC4CAE456974E52F19812C1D92760C9")
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
                boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_1031191217 = (readInt() != 0);
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
                boolean var3DB8322DDBEA41253B55CFA78FBE3A8A_1275226049 = (readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.499 -0400", hash_original_method = "6BB9790DD7CE6638433A98D5801460E1", hash_generated_method = "1272E0CF54B08017E28F89491B33690E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ArrayList<String> createStringArrayList() {
        int N;
        N = readInt();
        ArrayList<String> l;
        l = new ArrayList<String>(N);
        {
            l.add(readString());
            N--;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.500 -0400", hash_original_method = "4AA47F929C1AD4C6AA4FF7E97EBA01C3", hash_generated_method = "2ED582680CE6E9A4215F50857E67A4A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ArrayList<IBinder> createBinderArrayList() {
        int N;
        N = readInt();
        ArrayList<IBinder> l;
        l = new ArrayList<IBinder>(N);
        {
            l.add(readStrongBinder());
            N--;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.500 -0400", hash_original_method = "9CB504FEFB4242E237E17E2EB9A48FBD", hash_generated_method = "27E86C9C3785CEEE33F6968999BCE817")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.500 -0400", hash_original_method = "BD5E31C17A1894DBD3B1CCAA7C1D6816", hash_generated_method = "6378461A709187134A96F3E0FB06730E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.501 -0400", hash_original_method = "3CEF6E6386B4F00BA8155F93C3068CB0", hash_generated_method = "86BEE02CF6F6C0AFD4223CEBD9C9F348")
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
                    boolean varF3F4117B020949AD5A99383C367C3DCB_1875474423 = (readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.501 -0400", hash_original_method = "94DCFDEC159CF16A54AB9BC1543AACB0", hash_generated_method = "BAE0D43C041D43C1E3229DBA1FA17448")
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
                        boolean varDA2468261896472593A672B57BF55D76_130682617 = (readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.502 -0400", hash_original_method = "6C2CF48F71A46FC325FBB3DF7C6E0C74", hash_generated_method = "F2FDB782E9CA99FC9B75B63629B0F35F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final <T> T[] readTypedArray(Parcelable.Creator<T> c) {
        dsTaint.addTaint(c.dsTaint);
        T[] varE2F2E33FF1456B068E2A0AD4222378A3_389711588 = (createTypedArray(c));
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return createTypedArray(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.528 -0400", hash_original_method = "B6CF25F021EC35EAE7839E69AD502686", hash_generated_method = "C39458ECD3EEAA98858120DD59C9AB35")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.535 -0400", hash_original_method = "BC2BD16709D000C887B8D48E60CFBD74", hash_generated_method = "C90EB317FDF8DAB0AC18BECED44BB329")
    @DSModeled(DSC.BAN)
    public final Object readValue(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        int type;
        type = readInt();
        //Begin case VAL_STRING 
        Object var47A9A8CCD823AA4FC350471F0CE0A4D9_1288221779 = (readString());
        //End case VAL_STRING 
        //Begin case VAL_INTEGER 
        Object varC5FB9EBDFD702CC2CBDEAB5FB7412A2B_1277925570 = (readInt());
        //End case VAL_INTEGER 
        //Begin case VAL_MAP 
        Object varCB36CFAB316E49DEC6A95E3CDFA2C955_1757456980 = (readHashMap(loader));
        //End case VAL_MAP 
        //Begin case VAL_PARCELABLE 
        Object var81C62AF1D753B0568264BE3099E92A58_1476624626 = (readParcelable(loader));
        //End case VAL_PARCELABLE 
        //Begin case VAL_SHORT 
        Object varA670377579853C1DB5383F40B8ABE2F8_1863473231 = ((short) readInt());
        //End case VAL_SHORT 
        //Begin case VAL_LONG 
        Object varB70BB8A0900FE4C9696A5298E5BA7FB0_4188986 = (readLong());
        //End case VAL_LONG 
        //Begin case VAL_FLOAT 
        Object var1A5223190EBE1F207CF67E9121597E32_821702386 = (readFloat());
        //End case VAL_FLOAT 
        //Begin case VAL_DOUBLE 
        Object var2588635C6BECF8A2D9B29B0C372B2276_578133333 = (readDouble());
        //End case VAL_DOUBLE 
        //Begin case VAL_BOOLEAN 
        Object varA87E838ED7C4F762D5AF3A5387493CA2_1526561309 = (readInt() == 1);
        //End case VAL_BOOLEAN 
        //Begin case VAL_CHARSEQUENCE 
        Object var5678622BBD5F12A6676C580BC56CCBB9_1773165525 = (readCharSequence());
        //End case VAL_CHARSEQUENCE 
        //Begin case VAL_LIST 
        Object varCBB891A59619A1B4B4E1CF620B9FA670_1394195714 = (readArrayList(loader));
        //End case VAL_LIST 
        //Begin case VAL_BOOLEANARRAY 
        Object var8530F7223F0B29CE450D224343B048FC_408372586 = (createBooleanArray());
        //End case VAL_BOOLEANARRAY 
        //Begin case VAL_BYTEARRAY 
        Object var0A10D8AFBF9DE328C71E3F31971EF1FD_1575366173 = (createByteArray());
        //End case VAL_BYTEARRAY 
        //Begin case VAL_STRINGARRAY 
        Object var31F48A2A343436257E02B1C9C2596E69_466439509 = (readStringArray());
        //End case VAL_STRINGARRAY 
        //Begin case VAL_CHARSEQUENCEARRAY 
        Object varB715EE69CD0BD13EB2D234C8F8B0DE9D_443926154 = (readCharSequenceArray());
        //End case VAL_CHARSEQUENCEARRAY 
        //Begin case VAL_IBINDER 
        Object var84347B990B5BD97A3751B9E6FF7A7E4C_243515381 = (readStrongBinder());
        //End case VAL_IBINDER 
        //Begin case VAL_OBJECTARRAY 
        Object var98B7CD1D51AB7A9E018647E19EE11408_2023211886 = (readArray(loader));
        //End case VAL_OBJECTARRAY 
        //Begin case VAL_INTARRAY 
        Object var9B770EC710CB092D4C15D3930AE89784_1035175723 = (createIntArray());
        //End case VAL_INTARRAY 
        //Begin case VAL_LONGARRAY 
        Object varB4F4B96DD8F6421883038FA5C4BF1893_618718478 = (createLongArray());
        //End case VAL_LONGARRAY 
        //Begin case VAL_BYTE 
        Object var8CBBC12923715DCC37177943AB007F4D_896027866 = (readByte());
        //End case VAL_BYTE 
        //Begin case VAL_SERIALIZABLE 
        Object varAB56E33CE4ED87672E7A74630AA5F595_418920581 = (readSerializable());
        //End case VAL_SERIALIZABLE 
        //Begin case VAL_PARCELABLEARRAY 
        Object varA88A85626B2092C0698E1F3EF15DD193_1691729259 = (readParcelableArray(loader));
        //End case VAL_PARCELABLEARRAY 
        //Begin case VAL_SPARSEARRAY 
        Object var3C7CA5D427C57C7A3E723AE781E5498A_1968556716 = (readSparseArray(loader));
        //End case VAL_SPARSEARRAY 
        //Begin case VAL_SPARSEBOOLEANARRAY 
        Object varB95EF2623890BBA26DB5DB941C226CA3_925824962 = (readSparseBooleanArray());
        //End case VAL_SPARSEBOOLEANARRAY 
        //Begin case VAL_BUNDLE 
        Object varC28DE805DB11E75F1E7AEB0631CD7984_179952664 = (readBundle(loader));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.537 -0400", hash_original_method = "973DB4BA749CEAB3796DAD314F27DB98", hash_generated_method = "6BB0C1B26B401A3880EAC446C4E0EF97")
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
            T var04A095804F0DCA8BCDC30E7F0F81A79B_1809313914 = (((Parcelable.ClassLoaderCreator<T>)creator).createFromParcel(this, loader));
        } //End block
        T var6422C3E9192CB4780F5712002153692A_1212874220 = (creator.createFromParcel(this));
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.538 -0400", hash_original_method = "7F7B3246FDA8DADD28F39102743A1FDB", hash_generated_method = "5C0923B3242CDD648FC0CD96C1EF5872")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.539 -0400", hash_original_method = "71C92188775A0F7E9317C601C7CC8BB5", hash_generated_method = "0212419865B1B9DF35F0A7F36BD04BAE")
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
            Serializable var4E7D88FB15C7BF67252F0C6970AC8FB2_1470512704 = ((Serializable) ois.readObject());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.539 -0400", hash_original_method = "02940BA0E520BB755558CD4A620B4D95", hash_generated_method = "9BF62FC892875DD613A29EC8DE87E887")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.539 -0400", hash_original_method = "8123E4A6E665502F6F718041F61607F2", hash_generated_method = "ADB64DEA2C482AD4C619D1DFFE3EC6E8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.539 -0400", hash_original_method = "C0427B473F1AF57292972C32F441E719", hash_generated_method = "EDF4D4768A859F800E952C7B69829A3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void freeBuffer() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.539 -0400", hash_original_method = "70F6A5F1801DEC2DB8BE38968C81061C", hash_generated_method = "F563A422D96D29259F3D652266559A46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(int obj) {
        dsTaint.addTaint(obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.539 -0400", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "015526804BA90E1FA9719B20C3D8B806")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void destroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.540 -0400", hash_original_method = "377C79A0AFFA00A75F96A5842171AC58", hash_generated_method = "E381E0A02A6EC889F67A930C52A5DEF4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.561 -0400", hash_original_method = "9EEE2505D88E68CC65378BE9FEB363CC", hash_generated_method = "D562A689D8F7A3899F7B94F2DA1C4D5B")
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
            N--;
        } //End block
        // ---------- Original Method ----------
        //while (N > 0) {
            //Object value = readValue(loader);
            //outVal.add(value);
            //N--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.561 -0400", hash_original_method = "8048910DC1D629DD4CA2AB6051E757D5", hash_generated_method = "227F9A8DD6B4D07302BEA05E2EC10A66")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.563 -0400", hash_original_method = "43DDAB261C65CF1F1B4E5B19576BB376", hash_generated_method = "0CE25EB9DB39647FFD8DCD570BE3B883")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.563 -0400", hash_original_method = "687B1CF2F9242ACE26C54A0109BE177B", hash_generated_method = "3614A1E1943A7DC7838DE81C3BCC1C33")
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

    
}


