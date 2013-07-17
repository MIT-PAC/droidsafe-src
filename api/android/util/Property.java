package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Property<T, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.022 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.022 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "044FCC1E758F4DBF4DDAD38EDF0B8FEE")

    private Class<V> mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.023 -0400", hash_original_method = "74C6113835E416F987A9EF157CFAA5F3", hash_generated_method = "9BC8D81123C569546DBA273A46924C06")
    public  Property(Class<V> type, String name) {
        mName = name;
        mType = type;
        // ---------- Original Method ----------
        //mName = name;
        //mType = type;
    }

    
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.025 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "F31E4BB43C98323E7F7068C121946C53")
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_774540525 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630421113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630421113;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.025 -0400", hash_original_method = "D4D656EA66F575192422159E9E949A42", hash_generated_method = "1992968883C7A6873A6255E7674943E4")
    public void set(T object, V value) {
        addTaint(value.getTaint());
        addTaint(object.getTaint());
        UnsupportedOperationException var7C18E98A72208702C7C0661FD2550E26_1055046619 = new UnsupportedOperationException("Property " + getName() +" is read-only");
        var7C18E98A72208702C7C0661FD2550E26_1055046619.addTaint(taint);
        throw var7C18E98A72208702C7C0661FD2550E26_1055046619;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Property " + getName() +" is read-only");
    }

    
    public abstract V get(T object);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.026 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1F97B1468523F7E82FE069D891C71860")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_2084512381 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_2084512381.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_2084512381;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.039 -0400", hash_original_method = "016782D9983A30CCA54FD921B5345587", hash_generated_method = "4491967907C0B0EA2F651496FD47024F")
    public Class<V> getType() {
Class<V> var4BA7381699FCDF343F6526506FD5D65C_1908784369 =         mType;
        var4BA7381699FCDF343F6526506FD5D65C_1908784369.addTaint(taint);
        return var4BA7381699FCDF343F6526506FD5D65C_1908784369;
        // ---------- Original Method ----------
        //return mType;
    }

    
}

