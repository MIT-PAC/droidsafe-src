package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;





public class Annotation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.270 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.271 -0400", hash_original_method = "B1453DDFF141446D32AF844E0A6591E8", hash_generated_method = "39B2C3DA0D326D411001D911DA4DDF90")
    public  Annotation(Object attribute) {
        value = attribute;
        // ---------- Original Method ----------
        //value = attribute;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.271 -0400", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "1CEE207CC1C9BF4F2C2F219A31FB0F86")
    public Object getValue() {
Object varAF280DA2BC37D8BE783D8499160168DE_1375314323 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1375314323.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1375314323;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.271 -0400", hash_original_method = "439CE19804D9002003DD6A4835AE4496", hash_generated_method = "29622FD5DC7A4ED0DDF6C49813B423B7")
    @Override
    public String toString() {
String var63C569056C3C83D0B971C160C125DCA8_1799429314 =         getClass().getName() + "[value=" + value + ']';
        var63C569056C3C83D0B971C160C125DCA8_1799429314.addTaint(taint);
        return var63C569056C3C83D0B971C160C125DCA8_1799429314;
        // ---------- Original Method ----------
        //return getClass().getName() + "[value=" + value + ']';
    }

    
}

