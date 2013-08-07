package android.content.pm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public interface XmlSerializerAndParser<T> {
    void writeAsXml(T item, XmlSerializer out) throws IOException;
    T createFromXml(XmlPullParser parser) throws IOException, XmlPullParserException;
}
