package javax.crypto.interfaces;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.crypto.spec.DHParameterSpec;

public interface DHKey {

    
    public DHParameterSpec getParams();
}
