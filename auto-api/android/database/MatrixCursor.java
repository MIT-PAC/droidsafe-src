package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.180 -0400", hash_original_field = "0A0FFB19F00AC5DAD30A4E7D26990EE1", hash_generated_field = "E79D10B9148CF1E07E28DC9A748C915B")

    private String[] columnNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.181 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "87FB4EC33D38D4927074FCDA32A55471")

    private Object[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.184 -0400", hash_original_field = "6902C32850E8F821E6188453A9C497ED", hash_generated_field = "810BFDF75806195B8CA1DAC6D50D1648")

    private int rowCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.184 -0400", hash_original_field = "36A82AA80E5982C3171D42E9E6E96B6F", hash_generated_field = "AC3D45A4623161E9CCA649A2C8BB13FE")

    private int columnCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.195 -0400", hash_original_method = "2D581361992135FCD53B75EF54E93588", hash_generated_method = "339A7A86DFDE34C701089BB99615AC6A")
    public  MatrixCursor(String[] columnNames, int initialCapacity) {
        this.columnNames = columnNames;
        this.columnCount = columnNames.length;
        {
            initialCapacity = 1;
        } //End block
        this.data = new Object[columnCount * initialCapacity];
        // ---------- Original Method ----------
        //this.columnNames = columnNames;
        //this.columnCount = columnNames.length;
        //if (initialCapacity < 1) {
            //initialCapacity = 1;
        //}
        //this.data = new Object[columnCount * initialCapacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.199 -0400", hash_original_method = "520E9D572328080C8A52E1417D8346F4", hash_generated_method = "3BF546AA863074DA52C5D1E020F748F0")
    public  MatrixCursor(String[] columnNames) {
        this(columnNames, 16);
        addTaint(columnNames[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.201 -0400", hash_original_method = "A7EF9562410A67389E3E61A73FDE647E", hash_generated_method = "A7CCBCC937B17F837EFE4DA269E37DBA")
    private Object get(int column) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1853544876 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException("Requested column: "
                    + column + ", # of columns: " +  columnCount);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException("Before first row.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException("After last row.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1853544876 = data[mPos * columnCount + column];
        addTaint(column);
        varB4EAC82CA7396A68D541C85D26508E83_1853544876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853544876;
        // ---------- Original Method ----------
        //if (column < 0 || column >= columnCount) {
            //throw new CursorIndexOutOfBoundsException("Requested column: "
                    //+ column + ", # of columns: " +  columnCount);
        //}
        //if (mPos < 0) {
            //throw new CursorIndexOutOfBoundsException("Before first row.");
        //}
        //if (mPos >= rowCount) {
            //throw new CursorIndexOutOfBoundsException("After last row.");
        //}
        //return data[mPos * columnCount + column];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.213 -0400", hash_original_method = "4585CF8720D3AF6A9C9A961267CD63E3", hash_generated_method = "C583811823FB21291C019ECE192BECD7")
    public RowBuilder newRow() {
        RowBuilder varB4EAC82CA7396A68D541C85D26508E83_264553282 = null; //Variable for return #1
        int endIndex;
        endIndex = rowCount * columnCount;
        ensureCapacity(endIndex);
        int start;
        start = endIndex - columnCount;
        varB4EAC82CA7396A68D541C85D26508E83_264553282 = new RowBuilder(start, endIndex);
        varB4EAC82CA7396A68D541C85D26508E83_264553282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_264553282;
        // ---------- Original Method ----------
        //rowCount++;
        //int endIndex = rowCount * columnCount;
        //ensureCapacity(endIndex);
        //int start = endIndex - columnCount;
        //return new RowBuilder(start, endIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.217 -0400", hash_original_method = "48B10D52D633E686D99B492C35189F09", hash_generated_method = "B8A8A25E229951B91320A35DD5EB182D")
    public void addRow(Object[] columnValues) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("columnNames.length = "
                    + columnCount + ", columnValues.length = "
                    + columnValues.length);
        } //End block
        int start;
        start = rowCount++ * columnCount;
        ensureCapacity(start + columnCount);
        System.arraycopy(columnValues, 0, data, start, columnCount);
        addTaint(columnValues[0].getTaint());
        // ---------- Original Method ----------
        //if (columnValues.length != columnCount) {
            //throw new IllegalArgumentException("columnNames.length = "
                    //+ columnCount + ", columnValues.length = "
                    //+ columnValues.length);
        //}
        //int start = rowCount++ * columnCount;
        //ensureCapacity(start + columnCount);
        //System.arraycopy(columnValues, 0, data, start, columnCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.305 -0400", hash_original_method = "30233D359459EB079BFCFD374250902B", hash_generated_method = "383EA1B2B167E1C557DB23238955EF67")
    public void addRow(Iterable<?> columnValues) {
        int start;
        start = rowCount * columnCount;
        int end;
        end = start + columnCount;
        ensureCapacity(end);
        {
            addRow((ArrayList<?>) columnValues, start);
        } //End block
        int current;
        current = start;
        Object[] localData;
        localData = data;
        {
            Iterator<Object> var13C88AECC8F34AE5DABB05EE76133C5C_653441862 = (columnValues).iterator();
            var13C88AECC8F34AE5DABB05EE76133C5C_653441862.hasNext();
            Object columnValue = var13C88AECC8F34AE5DABB05EE76133C5C_653441862.next();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "columnValues.size() > columnNames.length");
                } //End block
                localData[current++] = columnValue;
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "columnValues.size() < columnNames.length");
        } //End block
        addTaint(columnValues.getTaint());
        // ---------- Original Method ----------
        //int start = rowCount * columnCount;
        //int end = start + columnCount;
        //ensureCapacity(end);
        //if (columnValues instanceof ArrayList<?>) {
            //addRow((ArrayList<?>) columnValues, start);
            //return;
        //}
        //int current = start;
        //Object[] localData = data;
        //for (Object columnValue : columnValues) {
            //if (current == end) {
                //throw new IllegalArgumentException(
                        //"columnValues.size() > columnNames.length");
            //}
            //localData[current++] = columnValue;
        //}
        //if (current != end) {
            //throw new IllegalArgumentException(
                    //"columnValues.size() < columnNames.length");
        //}
        //rowCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.310 -0400", hash_original_method = "F5D0F3FA334A37A2680A290D6DEEBDBE", hash_generated_method = "120BA8D962E36184B8161F28885EB38C")
    private void addRow(ArrayList<?> columnValues, int start) {
        int size;
        size = columnValues.size();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("columnNames.length = "
                    + columnCount + ", columnValues.size() = " + size);
        } //End block
        Object[] localData;
        localData = data;
        {
            int i;
            i = 0;
            {
                localData[start + i] = columnValues.get(i);
            } //End block
        } //End collapsed parenthetic
        addTaint(columnValues.getTaint());
        addTaint(start);
        // ---------- Original Method ----------
        //int size = columnValues.size();
        //if (size != columnCount) {
            //throw new IllegalArgumentException("columnNames.length = "
                    //+ columnCount + ", columnValues.size() = " + size);
        //}
        //rowCount++;
        //Object[] localData = data;
        //for (int i = 0; i < size; i++) {
            //localData[start + i] = columnValues.get(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.315 -0400", hash_original_method = "0FD21978EF299D1119588B65FAE6C3BE", hash_generated_method = "51DE7BA11272B32A72E7FFBA3A21BEA2")
    private void ensureCapacity(int size) {
        {
            Object[] oldData;
            oldData = this.data;
            int newSize;
            newSize = data.length * 2;
            {
                newSize = size;
            } //End block
            this.data = new Object[newSize];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        } //End block
        addTaint(size);
        // ---------- Original Method ----------
        //if (size > data.length) {
            //Object[] oldData = this.data;
            //int newSize = data.length * 2;
            //if (newSize < size) {
                //newSize = size;
            //}
            //this.data = new Object[newSize];
            //System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.316 -0400", hash_original_method = "3C738FD66B9E4F046395F2884F1D431C", hash_generated_method = "1B54C3AE8B073482A4C3A86FCD4A4688")
    @Override
    public int getCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890675218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890675218;
        // ---------- Original Method ----------
        //return rowCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.323 -0400", hash_original_method = "438CBE048C14BFF65A950EB22F18A5DC", hash_generated_method = "AF1ACF0B82ED3E96213ABFD56532B827")
    @Override
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1338004378 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1338004378 = columnNames;
        varB4EAC82CA7396A68D541C85D26508E83_1338004378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1338004378;
        // ---------- Original Method ----------
        //return columnNames;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.328 -0400", hash_original_method = "FF3178260B85D85D43C7EA714D59B46B", hash_generated_method = "ADA4C76C33734F6B257CFA9B34ED8580")
    @Override
    public String getString(int column) {
        String varB4EAC82CA7396A68D541C85D26508E83_2069410785 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1626836718 = null; //Variable for return #2
        Object value;
        value = get(column);
        varB4EAC82CA7396A68D541C85D26508E83_2069410785 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1626836718 = value.toString();
        addTaint(column);
        String varA7E53CE21691AB073D9660D615818899_1092556843; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1092556843 = varB4EAC82CA7396A68D541C85D26508E83_2069410785;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1092556843 = varB4EAC82CA7396A68D541C85D26508E83_1626836718;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1092556843.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1092556843;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return null;
        //return value.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.329 -0400", hash_original_method = "60FD43E3A8DF3780BF7590D38393B65C", hash_generated_method = "AA86570D6CE44784E1AC06BA24B82768")
    @Override
    public short getShort(int column) {
        Object value;
        value = get(column);
        short varBB7C5BB7BA9A40DDC697E118771A57D5_2129350629 = (((Number) value).shortValue());
        short var2BC31F0BF6F6153C59E2794C0D57EC9E_1116705867 = (Short.parseShort(value.toString()));
        addTaint(column);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1729423102 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1729423102;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0;
        //if (value instanceof Number) return ((Number) value).shortValue();
        //return Short.parseShort(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.341 -0400", hash_original_method = "20798CD66C6EBCBDA86BE86A1F5C23AA", hash_generated_method = "DCE2E7DFE4B971EB36D44AC655D42263")
    @Override
    public int getInt(int column) {
        Object value;
        value = get(column);
        int var7369A469871C45B86B3E0743901E0F32_563283822 = (((Number) value).intValue());
        int var892F09ABFE8F54AE5DF6A630942CEA37_1985968870 = (Integer.parseInt(value.toString()));
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611015066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611015066;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0;
        //if (value instanceof Number) return ((Number) value).intValue();
        //return Integer.parseInt(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.343 -0400", hash_original_method = "95E2F837C77BDD8697A8850547DFE4D6", hash_generated_method = "E06246FB39DBC3229431C126FD863844")
    @Override
    public long getLong(int column) {
        Object value;
        value = get(column);
        long var290D600C28740D1121B4957FA3052082_1637252264 = (((Number) value).longValue());
        long var1BFD44A99C8990319B3B5DECAF322A6E_1599702968 = (Long.parseLong(value.toString()));
        addTaint(column);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1472850139 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1472850139;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0;
        //if (value instanceof Number) return ((Number) value).longValue();
        //return Long.parseLong(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.351 -0400", hash_original_method = "5F37DCAACCAC42556DC41D90A8D016BB", hash_generated_method = "0F6100B7BFAB7BB248B450D2E066920C")
    @Override
    public float getFloat(int column) {
        Object value;
        value = get(column);
        float varEA13C03C743067F5A26655EFE1F8319F_1271726624 = (((Number) value).floatValue());
        float varDE7F761C985FFB6576593BC73FD0C361_148315797 = (Float.parseFloat(value.toString()));
        addTaint(column);
        float var546ADE640B6EDFBC8A086EF31347E768_199033969 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_199033969;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0.0f;
        //if (value instanceof Number) return ((Number) value).floatValue();
        //return Float.parseFloat(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.353 -0400", hash_original_method = "C2298AFC87949D13E5DEC28EBEE5D1A6", hash_generated_method = "FF83DB747937666970BD7A0145EF60F5")
    @Override
    public double getDouble(int column) {
        Object value;
        value = get(column);
        double varA1013D0D599B8782A9185D986000DF58_1158389860 = (((Number) value).doubleValue());
        double var0AA175213E403FA414FC876D1643017B_433943152 = (Double.parseDouble(value.toString()));
        addTaint(column);
        double varE8CD7DA078A86726031AD64F35F5A6C0_850665121 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_850665121;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0.0d;
        //if (value instanceof Number) return ((Number) value).doubleValue();
        //return Double.parseDouble(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.353 -0400", hash_original_method = "9C5D46FB06759EAD0808F8E5E3B27C37", hash_generated_method = "3A6FB6AD1D1B93B3EF56E1367B15EEAE")
    @Override
    public byte[] getBlob(int column) {
        Object value;
        value = get(column);
        addTaint(column);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1710022335 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1710022335;
        // ---------- Original Method ----------
        //Object value = get(column);
        //return (byte[]) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.357 -0400", hash_original_method = "8CE769D01E691B0A57CC7218B148D0E1", hash_generated_method = "D879A5FEFE4ED6AE87B8D4D088E3A44C")
    @Override
    public int getType(int column) {
        int varC8B8B382A19BDA028E3AF8DC8EF8C035_322139020 = (DatabaseUtils.getTypeOfObject(get(column)));
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49744299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49744299;
        // ---------- Original Method ----------
        //return DatabaseUtils.getTypeOfObject(get(column));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.358 -0400", hash_original_method = "8D2032D2DB514B96136D4116CF16B3F3", hash_generated_method = "F01EA120055555D6C4A9BBD889AAC14B")
    @Override
    public boolean isNull(int column) {
        boolean var7B345FA577CBFF26610C8754E7F8092E_2075865488 = (get(column) == null);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146539362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146539362;
        // ---------- Original Method ----------
        //return get(column) == null;
    }

    
    public class RowBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.358 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

        private int index;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.358 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

        private int endIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.420 -0400", hash_original_method = "5B64B028890135457EF6EA7D7258F6D8", hash_generated_method = "3724B9270867611742E22D9949DEFAE1")
          RowBuilder(int index, int endIndex) {
            this.index = index;
            this.endIndex = endIndex;
            // ---------- Original Method ----------
            //this.index = index;
            //this.endIndex = endIndex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.431 -0400", hash_original_method = "2C7305D6C3442E9FCBF185523D5AEB72", hash_generated_method = "69726CF2A5C492F04B887D8F28870490")
        public RowBuilder add(Object columnValue) {
            RowBuilder varB4EAC82CA7396A68D541C85D26508E83_338349799 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new CursorIndexOutOfBoundsException(
                        "No more columns left.");
            } //End block
            data[index++] = columnValue;
            varB4EAC82CA7396A68D541C85D26508E83_338349799 = this;
            varB4EAC82CA7396A68D541C85D26508E83_338349799.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_338349799;
            // ---------- Original Method ----------
            //if (index == endIndex) {
                //throw new CursorIndexOutOfBoundsException(
                        //"No more columns left.");
            //}
            //data[index++] = columnValue;
            //return this;
        }

        
    }


    
}

