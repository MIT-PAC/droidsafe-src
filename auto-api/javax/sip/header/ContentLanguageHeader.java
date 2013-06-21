package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public interface ContentLanguageHeader extends Header {
    String NAME = "Content-Language";

    Locale getContentLanguage();
    void setContentLanguage(Locale language);

    String getLanguageTag();
    void setLanguageTag(String languageTag);
}
