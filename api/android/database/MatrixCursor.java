package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.379 -0400", hash_original_field = "0A0FFB19F00AC5DAD30A4E7D26990EE1", hash_generated_field = "E79D10B9148CF1E07E28DC9A748C915B")

    private String[] columnNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.379 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "87FB4EC33D38D4927074FCDA32A55471")

    private Object[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.380 -0400", hash_original_field = "6902C32850E8F821E6188453A9C497ED", hash_generated_field = "810BFDF75806195B8CA1DAC6D50D1648")

    private int rowCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.380 -0400", hash_original_field = "36A82AA80E5982C3171D42E9E6E96B6F", hash_generated_field = "AC3D45A4623161E9CCA649A2C8BB13FE")

    private int columnCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.381 -0400", hash_original_method = "2D581361992135FCD53B75EF54E93588", hash_generated_method = "C1A44B737EBC2E84B5CA9670BD2B8293")
    public  MatrixCursor(String[] columnNames, int initialCapacity) {
        this.columnNames = columnNames;
        this.columnCount = columnNames.length;
    if(initialCapacity < 1)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.381 -0400", hash_original_method = "520E9D572328080C8A52E1417D8346F4", hash_generated_method = "3BF546AA863074DA52C5D1E020F748F0")
    public  MatrixCursor(String[] columnNames) {
        this(columnNames, 16);
        addTaint(columnNames[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.382 -0400", hash_original_method = "A7EF9562410A67389E3E61A73FDE647E", hash_generated_method = "592CED3805551CB2016AA9EFCA09310E")
    private Object get(int column) {
        addTaint(column);
    if(column < 0 || column >= columnCount)        
        {
            CursorIndexOutOfBoundsException varAA6C033199A3FA24CC2FA97E38C9B3F5_199025639 = new CursorIndexOutOfBoundsException("Requested column: "
                    + column + ", # of columns: " +  columnCount);
            varAA6C033199A3FA24CC2FA97E38C9B3F5_199025639.addTaint(taint);
            throw varAA6C033199A3FA24CC2FA97E38C9B3F5_199025639;
        } //End block
    if(mPos < 0)        
        {
            CursorIndexOutOfBoundsException var3D21778C7346A6FF4A05ADBEC270ADAB_1754928069 = new CursorIndexOutOfBoundsException("Before first row.");
            var3D21778C7346A6FF4A05ADBEC270ADAB_1754928069.addTaint(taint);
            throw var3D21778C7346A6FF4A05ADBEC270ADAB_1754928069;
        } //End block
    if(mPos >= rowCount)        
        {
            CursorIndexOutOfBoundsException varEB90D69B196AA1A76BB78C83907BAFE1_1556218385 = new CursorIndexOutOfBoundsException("After last row.");
            varEB90D69B196AA1A76BB78C83907BAFE1_1556218385.addTaint(taint);
            throw varEB90D69B196AA1A76BB78C83907BAFE1_1556218385;
        } //End block
Object varCE665E50DCCC5F5ACA9B01B763AFAADC_2108878429 =         data[mPos * columnCount + column];
        varCE665E50DCCC5F5ACA9B01B763AFAADC_2108878429.addTaint(taint);
        return varCE665E50DCCC5F5ACA9B01B763AFAADC_2108878429;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.382 -0400", hash_original_method = "4585CF8720D3AF6A9C9A961267CD63E3", hash_generated_method = "8C2EEF12A106B5612A2DA2B19B34E0D2")
    public RowBuilder newRow() {
        rowCount++;
        int endIndex = rowCount * columnCount;
        ensureCapacity(endIndex);
        int start = endIndex - columnCount;
RowBuilder var7950EA17E1868E3E572BA7A944BA99FF_1353133149 =         new RowBuilder(start, endIndex);
        var7950EA17E1868E3E572BA7A944BA99FF_1353133149.addTaint(taint);
        return var7950EA17E1868E3E572BA7A944BA99FF_1353133149;
        // ---------- Original Method ----------
        //rowCount++;
        //int endIndex = rowCount * columnCount;
        //ensureCapacity(endIndex);
        //int start = endIndex - columnCount;
        //return new RowBuilder(start, endIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.383 -0400", hash_original_method = "48B10D52D633E686D99B492C35189F09", hash_generated_method = "2B85D183745513669BAC8F9A16FA98DA")
    public void addRow(Object[] columnValues) {
        addTaint(columnValues[0].getTaint());
    if(columnValues.length != columnCount)        
        {
            IllegalArgumentException var1B6D919EAA44EC098D9B8D13AD643A68_1135831291 = new IllegalArgumentException("columnNames.length = "
                    + columnCount + ", columnValues.length = "
                    + columnValues.length);
            var1B6D919EAA44EC098D9B8D13AD643A68_1135831291.addTaint(taint);
            throw var1B6D919EAA44EC098D9B8D13AD643A68_1135831291;
        } //End block
        int start = rowCount++ * columnCount;
        ensureCapacity(start + columnCount);
        System.arraycopy(columnValues, 0, data, start, columnCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.383 -0400", hash_original_method = "30233D359459EB079BFCFD374250902B", hash_generated_method = "F4A4B5F113F67748A5FC769D3D2685CE")
    public void addRow(Iterable<?> columnValues) {
        addTaint(columnValues.getTaint());
        int start = rowCount * columnCount;
        int end = start + columnCount;
        ensureCapacity(end);
    if(columnValues instanceof ArrayList<?>)        
        {
            addRow((ArrayList<?>) columnValues, start);
            return;
        } //End block
        int current = start;
        Object[] localData = data;
for(Object columnValue : columnValues)
        {
    if(current == end)            
            {
                IllegalArgumentException var202E1063591A52171D9986809A374055_784460009 = new IllegalArgumentException(
                        "columnValues.size() > columnNames.length");
                var202E1063591A52171D9986809A374055_784460009.addTaint(taint);
                throw var202E1063591A52171D9986809A374055_784460009;
            } //End block
            localData[current++] = columnValue;
        } //End block
    if(current != end)        
        {
            IllegalArgumentException var364C5F88481296176AB11E0A8F4AE466_1470137212 = new IllegalArgumentException(
                    "columnValues.size() < columnNames.length");
            var364C5F88481296176AB11E0A8F4AE466_1470137212.addTaint(taint);
            throw var364C5F88481296176AB11E0A8F4AE466_1470137212;
        } //End block
        rowCount++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.384 -0400", hash_original_method = "F5D0F3FA334A37A2680A290D6DEEBDBE", hash_generated_method = "AEE1574E53E8B96D761CDD3CA869C2D9")
    private void addRow(ArrayList<?> columnValues, int start) {
        addTaint(start);
        addTaint(columnValues.getTaint());
        int size = columnValues.size();
    if(size != columnCount)        
        {
            IllegalArgumentException varFEDC0437535BD4EA0EC316BDBEA60742_1928776904 = new IllegalArgumentException("columnNames.length = "
                    + columnCount + ", columnValues.size() = " + size);
            varFEDC0437535BD4EA0EC316BDBEA60742_1928776904.addTaint(taint);
            throw varFEDC0437535BD4EA0EC316BDBEA60742_1928776904;
        } //End block
        rowCount++;
        Object[] localData = data;
for(int i = 0;i < size;i++)
        {
            localData[start + i] = columnValues.get(i);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.385 -0400", hash_original_method = "0FD21978EF299D1119588B65FAE6C3BE", hash_generated_method = "6C0130B0E6C8078E67E641ACD2395A22")
    private void ensureCapacity(int size) {
        addTaint(size);
    if(size > data.length)        
        {
            Object[] oldData = this.data;
            int newSize = data.length * 2;
    if(newSize < size)            
            {
                newSize = size;
            } //End block
            this.data = new Object[newSize];
            System.arraycopy(oldData, 0, this.data, 0, oldData.length);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.385 -0400", hash_original_method = "3C738FD66B9E4F046395F2884F1D431C", hash_generated_method = "869CE8DED294E5F9A7541771BC6C9D80")
    @Override
    public int getCount() {
        int var2262F69C6A73B803935283AD598F5007_737150939 = (rowCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914858393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914858393;
        // ---------- Original Method ----------
        //return rowCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.386 -0400", hash_original_method = "438CBE048C14BFF65A950EB22F18A5DC", hash_generated_method = "EEA81837275BF5DCD5118484A8634B4E")
    @Override
    public String[] getColumnNames() {
String[] var4DF41AA96E4B5CE54D79E2350D77438A_47385753 =         columnNames;
        var4DF41AA96E4B5CE54D79E2350D77438A_47385753.addTaint(taint);
        return var4DF41AA96E4B5CE54D79E2350D77438A_47385753;
        // ---------- Original Method ----------
        //return columnNames;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.386 -0400", hash_original_method = "FF3178260B85D85D43C7EA714D59B46B", hash_generated_method = "0E74B697B41D974CE312286EB1CB1C5C")
    @Override
    public String getString(int column) {
        addTaint(column);
        Object value = get(column);
    if(value == null)        
        {
String var540C13E9E156B687226421B24F2DF178_934819611 =         null;
        var540C13E9E156B687226421B24F2DF178_934819611.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_934819611;
        }
String var066A638514F2DD1476BFFD2A1D516E60_2077782415 =         value.toString();
        var066A638514F2DD1476BFFD2A1D516E60_2077782415.addTaint(taint);
        return var066A638514F2DD1476BFFD2A1D516E60_2077782415;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return null;
        //return value.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.387 -0400", hash_original_method = "60FD43E3A8DF3780BF7590D38393B65C", hash_generated_method = "D93A40D5BE8BA3EF5E4FFF0EB6141FD1")
    @Override
    public short getShort(int column) {
        addTaint(column);
        Object value = get(column);
    if(value == null)        
        {
        short varCFCD208495D565EF66E7DFF9F98764DA_359754855 = (0);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1714877121 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1714877121;
        }
    if(value instanceof Number)        
        {
        short var4CD69B6E53315590303D67A056CC6149_1245019038 = (((Number) value).shortValue());
                short var4F09DAA9D95BCB166A302407A0E0BABE_1682242977 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1682242977;
        }
        short var0F4B5C7FF1012118D6E587DC44FEE1B5_1303799348 = (Short.parseShort(value.toString()));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1206168307 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1206168307;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0;
        //if (value instanceof Number) return ((Number) value).shortValue();
        //return Short.parseShort(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.388 -0400", hash_original_method = "20798CD66C6EBCBDA86BE86A1F5C23AA", hash_generated_method = "4D94732CF185C69E3B6731ABE8ADF404")
    @Override
    public int getInt(int column) {
        addTaint(column);
        Object value = get(column);
    if(value == null)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1240362871 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183291015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183291015;
        }
    if(value instanceof Number)        
        {
        int var4A5A9F6B6FD5CBED3C8621F308A9D94A_18966201 = (((Number) value).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118524765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1118524765;
        }
        int varAA0CFC143BDFA635BAFF8C731C6BD0D6_208786648 = (Integer.parseInt(value.toString()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694854554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1694854554;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0;
        //if (value instanceof Number) return ((Number) value).intValue();
        //return Integer.parseInt(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.389 -0400", hash_original_method = "95E2F837C77BDD8697A8850547DFE4D6", hash_generated_method = "0139D5C43183C16E214EC0503CD540C1")
    @Override
    public long getLong(int column) {
        addTaint(column);
        Object value = get(column);
    if(value == null)        
        {
        long varCFCD208495D565EF66E7DFF9F98764DA_1814825732 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_501998069 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_501998069;
        }
    if(value instanceof Number)        
        {
        long var549FFC67B1385FA5168D322CA424A731_1196549528 = (((Number) value).longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1432388109 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1432388109;
        }
        long var786E5C1CC9E41B7C575B548C12B9111C_595301419 = (Long.parseLong(value.toString()));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1735239300 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1735239300;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0;
        //if (value instanceof Number) return ((Number) value).longValue();
        //return Long.parseLong(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.391 -0400", hash_original_method = "5F37DCAACCAC42556DC41D90A8D016BB", hash_generated_method = "70D39EC6C4D444CDC0A928A0E8BAEF4F")
    @Override
    public float getFloat(int column) {
        addTaint(column);
        Object value = get(column);
    if(value == null)        
        {
        float var2C64466C1DFC5FC617E8E7707C276CC3_230072365 = (0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1841733768 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1841733768;
        }
    if(value instanceof Number)        
        {
        float var51B5D5EDE3B16AB2515E5C9C90E07F4C_177569369 = (((Number) value).floatValue());
                float var546ADE640B6EDFBC8A086EF31347E768_106855198 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_106855198;
        }
        float var177994F88C4044A63D747B7B6EB92C50_306911702 = (Float.parseFloat(value.toString()));
                float var546ADE640B6EDFBC8A086EF31347E768_2107389001 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2107389001;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0.0f;
        //if (value instanceof Number) return ((Number) value).floatValue();
        //return Float.parseFloat(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.393 -0400", hash_original_method = "C2298AFC87949D13E5DEC28EBEE5D1A6", hash_generated_method = "D28C94393FE779FFF427B8DF2800585C")
    @Override
    public double getDouble(int column) {
        addTaint(column);
        Object value = get(column);
    if(value == null)        
        {
        double var4C8F2F703002F183FF6CE7D8B3CDBB84_740831327 = (0.0d);
                double varE8CD7DA078A86726031AD64F35F5A6C0_2063460541 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2063460541;
        }
    if(value instanceof Number)        
        {
        double var4CA5852970D1E67CF349AF84ADCE0E71_1323460309 = (((Number) value).doubleValue());
                double varE8CD7DA078A86726031AD64F35F5A6C0_1940909294 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1940909294;
        }
        double var3F33CACB5D37F77FF4C28C49AEA451BB_1176302432 = (Double.parseDouble(value.toString()));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1548806748 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1548806748;
        // ---------- Original Method ----------
        //Object value = get(column);
        //if (value == null) return 0.0d;
        //if (value instanceof Number) return ((Number) value).doubleValue();
        //return Double.parseDouble(value.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.394 -0400", hash_original_method = "9C5D46FB06759EAD0808F8E5E3B27C37", hash_generated_method = "3273DD7E7168BBCE9D9E8CB33E9682A9")
    @Override
    public byte[] getBlob(int column) {
        addTaint(column);
        Object value = get(column);
        byte[] var80878A6C3D4EF9BCAD0DC4FE999679F3_2069150029 = ((byte[]) value);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1672993950 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1672993950;
        // ---------- Original Method ----------
        //Object value = get(column);
        //return (byte[]) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.395 -0400", hash_original_method = "8CE769D01E691B0A57CC7218B148D0E1", hash_generated_method = "EBA6E05E04DD5EB7BF11E5DBAC5ED98A")
    @Override
    public int getType(int column) {
        addTaint(column);
        int var48F1D216A75947BCCF8945DE13063F13_2033492573 = (DatabaseUtils.getTypeOfObject(get(column)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648957116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648957116;
        // ---------- Original Method ----------
        //return DatabaseUtils.getTypeOfObject(get(column));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.396 -0400", hash_original_method = "8D2032D2DB514B96136D4116CF16B3F3", hash_generated_method = "347E8B8FA1E85662DE9B73FD216A6EEB")
    @Override
    public boolean isNull(int column) {
        addTaint(column);
        boolean var46B2337F542FDA0323ED7EE69DC685FC_1345804657 = (get(column) == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377394914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377394914;
        // ---------- Original Method ----------
        //return get(column) == null;
    }

    
    public class RowBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.396 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

        private int index;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.396 -0400", hash_original_field = "6C7C6ECF23A364EB2EC70B77C92E7A4E", hash_generated_field = "CFF06DF4D49F0CFE0C83824C6EB05DF9")

        private int endIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.397 -0400", hash_original_method = "5B64B028890135457EF6EA7D7258F6D8", hash_generated_method = "3724B9270867611742E22D9949DEFAE1")
          RowBuilder(int index, int endIndex) {
            this.index = index;
            this.endIndex = endIndex;
            // ---------- Original Method ----------
            //this.index = index;
            //this.endIndex = endIndex;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.398 -0400", hash_original_method = "2C7305D6C3442E9FCBF185523D5AEB72", hash_generated_method = "59D95CAEC27C6B2D24FF1988C2A67E11")
        public RowBuilder add(Object columnValue) {
    if(index == endIndex)            
            {
                CursorIndexOutOfBoundsException var7E5AAD6AD133D510DFD22F4FBC6E743F_216535215 = new CursorIndexOutOfBoundsException(
                        "No more columns left.");
                var7E5AAD6AD133D510DFD22F4FBC6E743F_216535215.addTaint(taint);
                throw var7E5AAD6AD133D510DFD22F4FBC6E743F_216535215;
            } //End block
            data[index++] = columnValue;
RowBuilder var72A74007B2BE62B849F475C7BDA4658B_1908580439 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1908580439.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1908580439;
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

