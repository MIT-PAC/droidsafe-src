package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.Map;

abstract class SimpleCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.198 -0400", hash_original_field = "B7CC7FBA0DFED4BBCE4A900CC4FB9C3E", hash_generated_field = "F44EFF3B1199C5E87D4423C4F1F5A40F")

    private Map<K, V> map = new HashMap<K, V>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.199 -0400", hash_original_method = "B9E87204655C6A026C6C2BCEB338A844", hash_generated_method = "B9E87204655C6A026C6C2BCEB338A844")
    public SimpleCache ()
    {
        //Synthesized constructor
    }


    protected abstract V load(K key);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.201 -0400", hash_original_method = "74016580A84D30BA8D414209F3F20310", hash_generated_method = "452F89ED96EA3CA66D3ABCC17EE0A64E")
    final V get(K key) {
        addTaint(key.getTaint());
    if(map.containsKey(key))        
        {
V var97156AACD411ADC83FECC30C065B5B0C_724671804 =             map.get(key);
            var97156AACD411ADC83FECC30C065B5B0C_724671804.addTaint(taint);
            return var97156AACD411ADC83FECC30C065B5B0C_724671804;
        } //End block
        V value = load(key);
        map.put(key, value);
V varAF280DA2BC37D8BE783D8499160168DE_1631102763 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1631102763.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1631102763;
        // ---------- Original Method ----------
        //if (map.containsKey(key)) {
            //return map.get(key);
        //}
        //V value = load(key);
        //map.put(key, value);
        //return value;
    }

    
}

