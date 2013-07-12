package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class TypeNotPresentException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.746 -0400", hash_original_field = "84AA805A9D919179AB8F8B24376E2ED7", hash_generated_field = "DAFE675943633FA9AA0F7DE9E967D92B")

    private String typeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.749 -0400", hash_original_method = "8F99105588FC99ADE0A826CA1D876689", hash_generated_method = "CAB211ED29B063F4857097B8EB26FB6A")
    public  TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        addTaint(cause.getTaint());
        this.typeName = typeName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.750 -0400", hash_original_method = "4654D488024911B4CA912D2186B5898B", hash_generated_method = "5DCF4D553430859009A8EC1F99BAD598")
    public String typeName() {
String var4C6AC62FA49FB0840C158A6211BE4A27_309561567 =         typeName;
        var4C6AC62FA49FB0840C158A6211BE4A27_309561567.addTaint(taint);
        return var4C6AC62FA49FB0840C158A6211BE4A27_309561567;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.751 -0400", hash_original_field = "05D74C83C628BE3A800AC84C4407C44C", hash_generated_field = "52B7B4456FF9EC4629580090450082F9")

    private static final long serialVersionUID = -5101214195716534496L;
}

