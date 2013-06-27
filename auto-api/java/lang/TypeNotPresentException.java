package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TypeNotPresentException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.710 -0400", hash_original_field = "84AA805A9D919179AB8F8B24376E2ED7", hash_generated_field = "DAFE675943633FA9AA0F7DE9E967D92B")

    private String typeName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.710 -0400", hash_original_method = "8F99105588FC99ADE0A826CA1D876689", hash_generated_method = "C0BD1431B87B3D2E5E974CB5285CEA67")
    public  TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        this.typeName = typeName;
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //this.typeName = typeName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.716 -0400", hash_original_method = "4654D488024911B4CA912D2186B5898B", hash_generated_method = "C6BA6F2E724A21E97FC85A5B0DE3C800")
    public String typeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_40674967 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_40674967 = typeName;
        varB4EAC82CA7396A68D541C85D26508E83_40674967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_40674967;
        // ---------- Original Method ----------
        //return typeName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.716 -0400", hash_original_field = "05D74C83C628BE3A800AC84C4407C44C", hash_generated_field = "982C24623923A3B55E7C39E3AD784E41")

    private static long serialVersionUID = -5101214195716534496L;
}

