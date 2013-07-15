package javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public interface ContentLanguageHeader extends Header {
    String NAME = "Content-Language";

    Locale getContentLanguage();
    void setContentLanguage(Locale language);

    String getLanguageTag();
    void setLanguageTag(String languageTag);
}
