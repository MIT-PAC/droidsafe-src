package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xmlpull.v1.XmlPullParser;
import android.util.AttributeSet;

public interface XmlResourceParser extends XmlPullParser, AttributeSet {
    
    public void close();
}
