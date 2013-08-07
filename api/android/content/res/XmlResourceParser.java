package android.content.res;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.xmlpull.v1.XmlPullParser;

import android.util.AttributeSet;

public interface XmlResourceParser extends XmlPullParser, AttributeSet {
    
    public void close();
}
