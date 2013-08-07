package android.test;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;



abstract class SimpleCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.888 -0400", hash_original_field = "B7CC7FBA0DFED4BBCE4A900CC4FB9C3E", hash_generated_field = "F44EFF3B1199C5E87D4423C4F1F5A40F")

    private Map<K, V> map = new HashMap<K, V>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.888 -0400", hash_original_method = "B9E87204655C6A026C6C2BCEB338A844", hash_generated_method = "B9E87204655C6A026C6C2BCEB338A844")
    public SimpleCache ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    protected abstract V load(K key);

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.889 -0400", hash_original_method = "74016580A84D30BA8D414209F3F20310", hash_generated_method = "C245CE592C72237A77BD8C506E54301F")
    final V get(K key) {
        addTaint(key.getTaint());
        if(map.containsKey(key))        
        {
V var97156AACD411ADC83FECC30C065B5B0C_507151743 =             map.get(key);
            var97156AACD411ADC83FECC30C065B5B0C_507151743.addTaint(taint);
            return var97156AACD411ADC83FECC30C065B5B0C_507151743;
        } //End block
        V value = load(key);
        map.put(key, value);
V varAF280DA2BC37D8BE783D8499160168DE_1996749646 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1996749646.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1996749646;
        // ---------- Original Method ----------
        //if (map.containsKey(key)) {
            //return map.get(key);
        //}
        //V value = load(key);
        //map.put(key, value);
        //return value;
    }

    
}

