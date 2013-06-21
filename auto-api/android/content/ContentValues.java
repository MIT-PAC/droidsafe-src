package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ContentValues implements Parcelable {
    private HashMap<String, Object> mValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.870 -0400", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "83FF0F0E418B834B6E273F883D6E85A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentValues() {
        mValues = new HashMap<String, Object>(8);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.871 -0400", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "CD5019864C6551C5764E097E07D2162C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentValues(int size) {
        dsTaint.addTaint(size);
        mValues = new HashMap<String, Object>(size, 1.0f);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(size, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.872 -0400", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "DFFD4814538CDBE885AEB60E20F4A34B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentValues(ContentValues from) {
        dsTaint.addTaint(from.dsTaint);
        mValues = new HashMap<String, Object>(from.mValues);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(from.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.872 -0400", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "B07EFC5460DFA63669098D456D4E10A6")
    @DSModeled(DSC.SAFE)
    private ContentValues(HashMap<String, Object> values) {
        dsTaint.addTaint(values.dsTaint);
        // ---------- Original Method ----------
        //mValues = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.873 -0400", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "9155FD2F160AF458C1B6920043EC2CDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varCE35AA2414ECA57986478B874E61D0DF_1264465725 = (mValues.equals(((ContentValues) object).mValues));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof ContentValues)) {
            //return false;
        //}
        //return mValues.equals(((ContentValues) object).mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.873 -0400", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "2D37A1D7B092B2E19DCF2796A6F5BA00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var77745914D15D7334241B586923DBF077_341978914 = (mValues.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValues.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.873 -0400", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "F68F4CDFA84F6DF64EA26B17716837F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.874 -0400", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "E5E9EB9E6EDF7AC02DAFD6B64D0CF904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(ContentValues other) {
        dsTaint.addTaint(other.dsTaint);
        mValues.putAll(other.mValues);
        // ---------- Original Method ----------
        //mValues.putAll(other.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.875 -0400", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "77C44937EFD37783004952B5C9B680A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Byte value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.875 -0400", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "A3769DD239A681E4CD3361E4E5801C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Short value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.876 -0400", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "FE617BF5F739B886FE15C430CCD4D90F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Integer value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.877 -0400", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "782849F211A58BCDC81E089A20B79215")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Long value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.886 -0400", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "9BF771701D3E00EF27269C56AFD73723")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Float value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.887 -0400", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "AE030E5846D7AD005795100B2B033198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Double value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.888 -0400", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "514D28C4AB5FA613D3F4A36D6ABD92EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, Boolean value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.888 -0400", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "819EF68501B7CCDAF25CE567517BA192")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String key, byte[] value) {
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.889 -0400", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "33D76004FB6CE97A4F6D1F685BBA5B53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putNull(String key) {
        dsTaint.addTaint(key);
        mValues.put(key, null);
        // ---------- Original Method ----------
        //mValues.put(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.889 -0400", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "DA575F68760E050BE65F699E14D450BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varF779B1E04A2732336D06BD8C9C52B50E_2046230721 = (mValues.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValues.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.890 -0400", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "92EA65B7B6E2553A8DE98464211695B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove(String key) {
        dsTaint.addTaint(key);
        mValues.remove(key);
        // ---------- Original Method ----------
        //mValues.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.890 -0400", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "BF85B5F668E6CB7B60B49325EA514CB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        mValues.clear();
        // ---------- Original Method ----------
        //mValues.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.890 -0400", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "C02BF1BDA7E91C13E7FE8ED6D64C4E80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(String key) {
        dsTaint.addTaint(key);
        boolean var1A922EEE95FE1D978384090336DB26E0_333274150 = (mValues.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mValues.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.891 -0400", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "B8A0BFD27539011E894082E170AB5853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(String key) {
        dsTaint.addTaint(key);
        Object varD3458E5C1B6FC3CC2B7CDCBD51B76618_1659511428 = (mValues.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.893 -0400", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "3731F8E4EDA84B3C8F7EF54F486DB2F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAsString(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        {
            Object varBBD94B29008FCC1DD1EB3B362BCBF9D8_37165356 = (value.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //return value != null ? value.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.894 -0400", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "02C6C845185A76213501C2ED309E3906")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Long getAsLong(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var0C458C54E2216422FF1489EE52D25DBE_496482374 = (((Number) value).longValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Long var592CB393B68685A4088473AAD15AFD78_1971614057 = (Long.valueOf(value.toString()));
                } //End block
                catch (NumberFormatException e2)
                { }
            } //End block
        } //End block
        return (Long)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).longValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Long.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Long value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Long: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.895 -0400", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "3E199720C486C2D72671E97E5EDB6722")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Integer getAsInteger(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var5F266B0C4CDA00E5B9756027C07CC69C_1518135828 = (((Number) value).intValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Integer varFFE9F80B3F0FB84ABB77635B667F6531_2040721165 = (Integer.valueOf(value.toString()));
                } //End block
                catch (NumberFormatException e2)
                { }
            } //End block
        } //End block
        return (Integer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).intValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Integer.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Integer value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Integer: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.903 -0400", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "FF95EF5F941D06C74D8204CBE52656ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Short getAsShort(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var9EC3AE8E7D5E10A89390B67BBF63F8BE_910933854 = (((Number) value).shortValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Short var6AD6CF6EB763D0BEF0D5CFA3F7AA2B15_1848950592 = (Short.valueOf(value.toString()));
                } //End block
                catch (NumberFormatException e2)
                { }
            } //End block
        } //End block
        return (Short)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).shortValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Short.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Short value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Short: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.904 -0400", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "1DADCA075BF93DED01D0C21A745F85D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Byte getAsByte(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object varBB340FB2D1EB1A27D3A6D56D19CB3B81_117349256 = (((Number) value).byteValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Byte varB4A89381A271B3B7DAA9B9E3B34BFA96_157137209 = (Byte.valueOf(value.toString()));
                } //End block
                catch (NumberFormatException e2)
                { }
            } //End block
        } //End block
        return (Byte)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).byteValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Byte.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Byte value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Byte: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.905 -0400", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "150B5635E9BA97875E503CB0FADFC7A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Double getAsDouble(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var4C341ED01BB178F82EB0BFB9BB37D4FA_364876761 = (((Number) value).doubleValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Double varEAD3D25140529155B0B459649F76AFDE_1619132952 = (Double.valueOf(value.toString()));
                } //End block
                catch (NumberFormatException e2)
                { }
            } //End block
        } //End block
        return (Double)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).doubleValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Double.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Double value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Double: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.908 -0400", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "F9393DE35C056567DE9D1994BA53D812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Float getAsFloat(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var51568D4E851772BB791ED165B907C0E4_509971150 = (((Number) value).floatValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Float varB6720A0CEC9D7471E41B54009EA31258_728891519 = (Float.valueOf(value.toString()));
                } //End block
                catch (NumberFormatException e2)
                { }
            } //End block
        } //End block
        return (Float)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return value != null ? ((Number) value).floatValue() : null;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //try {
                    //return Float.valueOf(value.toString());
                //} catch (NumberFormatException e2) {
                    //Log.e(TAG, "Cannot parse Float value for " + value + " at key " + key);
                    //return null;
                //}
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Float: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.918 -0400", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "E8189359C21E616B8161FD360543B711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Boolean getAsBoolean(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        return (Boolean)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //try {
            //return (Boolean) value;
        //} catch (ClassCastException e) {
            //if (value instanceof CharSequence) {
                //return Boolean.valueOf(value.toString());
            //} else if (value instanceof Number) {
                //return ((Number) value).intValue() != 0;
            //} else {
                //Log.e(TAG, "Cannot cast value for " + key + " to a Boolean: " + value, e);
                //return null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.919 -0400", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "E00EAEA332961FF025F6EE8B64E233A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getAsByteArray(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //if (value instanceof byte[]) {
            //return (byte[]) value;
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.920 -0400", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "5AC3A92E978BF69275A9C8118BFD7561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<String, Object>> valueSet() {
        Set<Map.Entry<String, Object>> var98CDE00EE0834F44E2F3323BBCE893C0_1937505081 = (mValues.entrySet());
        return (Set<Map.Entry<String, Object>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.920 -0400", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "05AC7E805F47D2A9E764A7F35936EF3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        Set<String> varBFAF58BFC2D6DB1E757FC5C02380E632_1117552413 = (mValues.keySet());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.921 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.921 -0400", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "597453FEB7CB4697AA4830DED9FBEBFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeMap(mValues);
        // ---------- Original Method ----------
        //parcel.writeMap(mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.930 -0400", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "89B1A70076654EC05FCFB447CED1D687")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.931 -0400", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "EE5F01EC7FD47A503884E74CE7F4B8D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        dsTaint.addTaint(key);
        ArrayList<String> var59566692DDF4F7CBC6D6E591B77C0EF8_1647078548 = ((ArrayList<String>) mValues.get(key));
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ArrayList<String>) mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.940 -0400", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "9A2F4A29FCF9DC86489544E6F2D5B197")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        {
            Iterator<String> varC858E3D8CE741BE1E06DE4187B96D0A0_1896214082 = (mValues.keySet()).iterator();
            varC858E3D8CE741BE1E06DE4187B96D0A0_1896214082.hasNext();
            String name = varC858E3D8CE741BE1E06DE4187B96D0A0_1896214082.next();
            {
                String value;
                value = getAsString(name);
                {
                    boolean var44E9D3A0138A31D1E5A269420690E988_235637887 = (sb.length() > 0);
                    sb.append(" ");
                } //End collapsed parenthetic
                sb.append(name + "=" + value);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1643611540 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //for (String name : mValues.keySet()) {
            //String value = getAsString(name);
            //if (sb.length() > 0) sb.append(" ");
            //sb.append(name + "=" + value);
        //}
        //return sb.toString();
    }

    
    public static final String TAG = "ContentValues";
    public static final Parcelable.Creator<ContentValues> CREATOR = new Parcelable.Creator<ContentValues>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.950 -0400", hash_original_method = "408F12EF384AFD72C1D92CDACF4EC38C", hash_generated_method = "A1AC47620ACB1567F673E1CFDB16A739")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            HashMap<String, Object> values;
            values = in.readHashMap(null);
            ContentValues varB79A9B53466E6942E247B0C7E749BCEF_59255666 = (new ContentValues(values));
            return (ContentValues)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HashMap<String, Object> values = in.readHashMap(null);
            //return new ContentValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.951 -0400", hash_original_method = "E7BE33AD94ACBD14D20A573DAFF34DE4", hash_generated_method = "05572ADD456C408AED00E9411E163DC2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ContentValues[] newArray(int size) {
            dsTaint.addTaint(size);
            ContentValues[] var36D081C0682D08D75730A34D85E97228_927787191 = (new ContentValues[size]);
            return (ContentValues[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentValues[size];
        }

        
}; //Transformed anonymous class
}

