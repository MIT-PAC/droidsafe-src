package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ContentValues implements Parcelable {
    public static final String TAG = "ContentValues";
    private HashMap<String, Object> mValues;
    public static final Parcelable.Creator<ContentValues> CREATOR = new Parcelable.Creator<ContentValues>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.463 -0400", hash_original_method = "408F12EF384AFD72C1D92CDACF4EC38C", hash_generated_method = "0DC4439DC615791D3C6A95CB7093EC46")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings({"deprecation", "unchecked"})
        public ContentValues createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            HashMap<String, Object> values;
            values = in.readHashMap(null);
            return (ContentValues)dsTaint.getTaint();
            // ---------- Original Method ----------
            //HashMap<String, Object> values = in.readHashMap(null);
            //return new ContentValues(values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.464 -0400", hash_original_method = "E7BE33AD94ACBD14D20A573DAFF34DE4", hash_generated_method = "E84A9E90808AE11439437CFB578A15B6")
        @DSModeled(DSC.SAFE)
        public ContentValues[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ContentValues[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ContentValues[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.464 -0400", hash_original_method = "5E7EA6E1821501C5972B7C7CC639145B", hash_generated_method = "B4ADFC792F1F2D72168853B5ACC63793")
    @DSModeled(DSC.SAFE)
    public ContentValues() {
        mValues = new HashMap<String, Object>(8);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.464 -0400", hash_original_method = "8E588067C2537376173067FE549DA446", hash_generated_method = "EE34AA9C5BFD30E46DE0E8593B51D49B")
    @DSModeled(DSC.SAFE)
    public ContentValues(int size) {
        dsTaint.addTaint(size);
        mValues = new HashMap<String, Object>(size, 1.0f);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(size, 1.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.464 -0400", hash_original_method = "6386ACC7AEA70584EF32F8CAA1BD0C6A", hash_generated_method = "78A22D9095C074AE0893782B3610FF88")
    @DSModeled(DSC.SAFE)
    public ContentValues(ContentValues from) {
        dsTaint.addTaint(from.dsTaint);
        mValues = new HashMap<String, Object>(from.mValues);
        // ---------- Original Method ----------
        //mValues = new HashMap<String, Object>(from.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.464 -0400", hash_original_method = "79B820032F5D7F722A5DF12324BC548A", hash_generated_method = "92BE7B1A0F7CBCBEB4BA5B5EFECF1EC1")
    @DSModeled(DSC.SAFE)
    private ContentValues(HashMap<String, Object> values) {
        dsTaint.addTaint(values.dsTaint);
        // ---------- Original Method ----------
        //mValues = values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.465 -0400", hash_original_method = "B119129681FC05E44686163A6A753063", hash_generated_method = "70B43D081CDD4D2232FFF16FF50DA6CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varCE35AA2414ECA57986478B874E61D0DF_1214103970 = (mValues.equals(((ContentValues) object).mValues));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(object instanceof ContentValues)) {
            //return false;
        //}
        //return mValues.equals(((ContentValues) object).mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.465 -0400", hash_original_method = "61C7B1D258FDF4A8DE4F58009B844658", hash_generated_method = "592DD98203C3E5B90F970601D0C7F2DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var77745914D15D7334241B586923DBF077_533900778 = (mValues.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValues.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.465 -0400", hash_original_method = "65B11A528910ED48D0A8C0B3A81DCA11", hash_generated_method = "88A600F3CB6617B60CAA16D6890F7AF6")
    @DSModeled(DSC.SAFE)
    public void put(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.465 -0400", hash_original_method = "0A271D2A4C7890E9466C28EF447DC416", hash_generated_method = "79D32974F7A980CF1A0881A1C1282402")
    @DSModeled(DSC.SAFE)
    public void putAll(ContentValues other) {
        dsTaint.addTaint(other.dsTaint);
        mValues.putAll(other.mValues);
        // ---------- Original Method ----------
        //mValues.putAll(other.mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.466 -0400", hash_original_method = "46309CD6AABC048E549ED8D367B97222", hash_generated_method = "E0D2144BA68385DC046160355A8B2727")
    @DSModeled(DSC.SAFE)
    public void put(String key, Byte value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.466 -0400", hash_original_method = "19B45CF10C6274AA18ED4281EBB4A7D5", hash_generated_method = "6AA90EDA07D56085121A7F61F769619B")
    @DSModeled(DSC.SAFE)
    public void put(String key, Short value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.466 -0400", hash_original_method = "519D763DA29CBC7E3659F73066396076", hash_generated_method = "BA8DED03F0DD35EC988F0B6B822A4DB2")
    @DSModeled(DSC.SAFE)
    public void put(String key, Integer value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.466 -0400", hash_original_method = "68C6754D41E6DE24B60EFC88A41FDF20", hash_generated_method = "D47AAB7E2A7E9E23637B3D2E81264E7A")
    @DSModeled(DSC.SAFE)
    public void put(String key, Long value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.466 -0400", hash_original_method = "66DA1C106B1B7F2AFB03D110B785A501", hash_generated_method = "34D53BD5847E8F127A441550E678D6A8")
    @DSModeled(DSC.SAFE)
    public void put(String key, Float value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.467 -0400", hash_original_method = "1050A4E9D6DF2BBB4B07F9E50B35502F", hash_generated_method = "31D33AA8B7449E8284C746FBC3C52AC6")
    @DSModeled(DSC.SAFE)
    public void put(String key, Double value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.467 -0400", hash_original_method = "C35988B4D54806692C616FB01B8C7793", hash_generated_method = "85A9FFAE3D91BB4FDA1974CB299401F9")
    @DSModeled(DSC.SAFE)
    public void put(String key, Boolean value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.467 -0400", hash_original_method = "79D16814F7AC00D5B324C095EC421557", hash_generated_method = "23B9F059C0EAACF99ED55069066E586A")
    @DSModeled(DSC.SAFE)
    public void put(String key, byte[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.467 -0400", hash_original_method = "8F0D800F5C28B5CCC219C4767FE49E89", hash_generated_method = "900F166AB2B3787C887D58CB6BA9F484")
    @DSModeled(DSC.SAFE)
    public void putNull(String key) {
        dsTaint.addTaint(key);
        mValues.put(key, null);
        // ---------- Original Method ----------
        //mValues.put(key, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.467 -0400", hash_original_method = "C7AE6CE1280D5E080A32F66907E851BD", hash_generated_method = "6C7369B326AA2536163FE2FFEE7AA8E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varF779B1E04A2732336D06BD8C9C52B50E_1698858066 = (mValues.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mValues.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.468 -0400", hash_original_method = "377B4DB42071C90137241E64BA4CBF0D", hash_generated_method = "EDFAE0474116B7AC475AAE2A772A7D21")
    @DSModeled(DSC.SAFE)
    public void remove(String key) {
        dsTaint.addTaint(key);
        mValues.remove(key);
        // ---------- Original Method ----------
        //mValues.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.468 -0400", hash_original_method = "08286611C689211C8F9484889D0FA29C", hash_generated_method = "D47A5ECCA6E72CD141B26EA9B4656F49")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mValues.clear();
        // ---------- Original Method ----------
        //mValues.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.468 -0400", hash_original_method = "26760966C3F3EED5AADC7592B64BFAAE", hash_generated_method = "C60683C81D18824C561CD9B09C7681DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(String key) {
        dsTaint.addTaint(key);
        boolean var1A922EEE95FE1D978384090336DB26E0_611943626 = (mValues.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mValues.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.468 -0400", hash_original_method = "F0AF95EE9AB5B022FDA3C4DAA44F68C1", hash_generated_method = "A6F1A1F053D52568823093FBDEF32F81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(String key) {
        dsTaint.addTaint(key);
        Object varD3458E5C1B6FC3CC2B7CDCBD51B76618_670002021 = (mValues.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.469 -0400", hash_original_method = "FD6B0B33BC77B5F3D2D2C6DE92834A83", hash_generated_method = "EF00C446611F6DBF5997B77B63867887")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAsString(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        {
            Object varBBD94B29008FCC1DD1EB3B362BCBF9D8_1527982593 = (value.toString());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object value = mValues.get(key);
        //return value != null ? value.toString() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.469 -0400", hash_original_method = "50D64D5E49DC2F013CFC471F23AA3A1E", hash_generated_method = "7BFF28CF01EDAFC3DF2A4BDEC7313D3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Long getAsLong(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var0C458C54E2216422FF1489EE52D25DBE_278938675 = (((Number) value).longValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Long var592CB393B68685A4088473AAD15AFD78_1716284783 = (Long.valueOf(value.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.470 -0400", hash_original_method = "C11C55EBF0D230069C8558AD456DF6B2", hash_generated_method = "9763D451F34918E058A7D532BD051BA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Integer getAsInteger(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var5F266B0C4CDA00E5B9756027C07CC69C_1803797877 = (((Number) value).intValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Integer varFFE9F80B3F0FB84ABB77635B667F6531_1586931336 = (Integer.valueOf(value.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.470 -0400", hash_original_method = "20021B08C31B81AF996FD4C57E428DFB", hash_generated_method = "E10EF7205F0FAC9C3F4139D995CC2318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Short getAsShort(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var9EC3AE8E7D5E10A89390B67BBF63F8BE_6762437 = (((Number) value).shortValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Short var6AD6CF6EB763D0BEF0D5CFA3F7AA2B15_1465599618 = (Short.valueOf(value.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.471 -0400", hash_original_method = "10A45AB5E2B4A25109E88A986B8ABD1E", hash_generated_method = "A049D024B816C2D0B564117B726F29ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Byte getAsByte(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object varBB340FB2D1EB1A27D3A6D56D19CB3B81_1856867810 = (((Number) value).byteValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Byte varB4A89381A271B3B7DAA9B9E3B34BFA96_1985349219 = (Byte.valueOf(value.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.472 -0400", hash_original_method = "43D54EF438725B45BE89593CD2466062", hash_generated_method = "870DAE2881A7F2B4B3E7E7A768D4DAA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Double getAsDouble(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var4C341ED01BB178F82EB0BFB9BB37D4FA_1707980118 = (((Number) value).doubleValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Double varEAD3D25140529155B0B459649F76AFDE_1038061051 = (Double.valueOf(value.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.472 -0400", hash_original_method = "72E58B472E78C1EB7239E330F6CA9313", hash_generated_method = "B3D2B834544AD0009C3693AC9C19DB93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Float getAsFloat(String key) {
        dsTaint.addTaint(key);
        Object value;
        value = mValues.get(key);
        try 
        {
            {
                Object var51568D4E851772BB791ED165B907C0E4_1674715276 = (((Number) value).floatValue());
            } //End flattened ternary
        } //End block
        catch (ClassCastException e)
        {
            {
                try 
                {
                    Float varB6720A0CEC9D7471E41B54009EA31258_1105543118 = (Float.valueOf(value.toString()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.473 -0400", hash_original_method = "26BA447DF201321FA24067450431D916", hash_generated_method = "59242D528649A4BA369E156BAA6B744B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.473 -0400", hash_original_method = "A780551E0EA49FF2BF74805BA852B981", hash_generated_method = "9EAFABA1EF5D8970CB063C05A6D69845")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.474 -0400", hash_original_method = "CB190561C8A3BAECAF3D6E789BEEE6E0", hash_generated_method = "50AEB86D4B59F124439D8923317C9F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<String, Object>> valueSet() {
        Set<Map.Entry<String, Object>> var98CDE00EE0834F44E2F3323BBCE893C0_1217728773 = (mValues.entrySet());
        return (Set<Map.Entry<String, Object>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.474 -0400", hash_original_method = "424C133E0D7FEE4B423B7AD7977A2226", hash_generated_method = "BE62AB1527FC0B99D68AD2B45C829741")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        Set<String> varBFAF58BFC2D6DB1E757FC5C02380E632_920938696 = (mValues.keySet());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.474 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.475 -0400", hash_original_method = "2C0F18C86DFE76C8F92DFC9EBC596E26", hash_generated_method = "D56FFB131037FE728CC06CD11F2D649A")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("deprecation")
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeMap(mValues);
        // ---------- Original Method ----------
        //parcel.writeMap(mValues);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.475 -0400", hash_original_method = "F9E2AE250F36F443A2E1239B6C3C3E6F", hash_generated_method = "210BABFF42FF65B0200D4EEB1D021245")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void putStringArrayList(String key, ArrayList<String> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        mValues.put(key, value);
        // ---------- Original Method ----------
        //mValues.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.476 -0400", hash_original_method = "F231C09776862BE2F464FBA056529E22", hash_generated_method = "5BC718B9622B3FE00CC8FD26BDA91084")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Deprecated
    public ArrayList<String> getStringArrayList(String key) {
        dsTaint.addTaint(key);
        ArrayList<String> var59566692DDF4F7CBC6D6E591B77C0EF8_706137647 = ((ArrayList<String>) mValues.get(key));
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (ArrayList<String>) mValues.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.476 -0400", hash_original_method = "7B4B42E004B10F53CC96D4FD27076B59", hash_generated_method = "CAA01E1E5AB4F48CB45F7E8B46A4418D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        {
            Iterator<String> seatecAstronomy42 = mValues.keySet().iterator();
            seatecAstronomy42.hasNext();
            String name = seatecAstronomy42.next();
            {
                String value;
                value = getAsString(name);
                {
                    boolean var44E9D3A0138A31D1E5A269420690E988_1378099558 = (sb.length() > 0);
                    sb.append(" ");
                } //End collapsed parenthetic
                sb.append(name + "=" + value);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1981077416 = (sb.toString());
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

    
}


