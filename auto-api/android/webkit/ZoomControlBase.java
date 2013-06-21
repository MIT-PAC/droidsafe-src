package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

interface ZoomControlBase {

    
    public void show();

    
    public void hide();

    
    public void update();

    
    public boolean isVisible();
}
