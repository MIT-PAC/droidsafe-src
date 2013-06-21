package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;

public interface XmlResourceParser extends XmlPullParser, AttributeSet {
    
    public void close();
}
