package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Annotation {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.676 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

    private Object value;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.676 -0400", hash_original_method = "B1453DDFF141446D32AF844E0A6591E8", hash_generated_method = "39B2C3DA0D326D411001D911DA4DDF90")
    public  Annotation(Object attribute) {
        value = attribute;
        // ---------- Original Method ----------
        //value = attribute;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.676 -0400", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "79697A7EDADCDDB5AB0EAE442C83735F")
    public Object getValue() {
Object varAF280DA2BC37D8BE783D8499160168DE_1599590957 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1599590957.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1599590957;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.676 -0400", hash_original_method = "439CE19804D9002003DD6A4835AE4496", hash_generated_method = "2D28C613AC45E38764DBB36A8D28D5EF")
    @Override
    public String toString() {
String var63C569056C3C83D0B971C160C125DCA8_75491727 =         getClass().getName() + "[value=" + value + ']';
        var63C569056C3C83D0B971C160C125DCA8_75491727.addTaint(taint);
        return var63C569056C3C83D0B971C160C125DCA8_75491727;
        // ---------- Original Method ----------
        //return getClass().getName() + "[value=" + value + ']';
    }

    
}

