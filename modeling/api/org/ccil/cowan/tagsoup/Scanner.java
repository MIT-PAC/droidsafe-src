package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Reader;

import org.xml.sax.SAXException;

public interface Scanner {

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void scan(Reader r, ScanHandler h) throws IOException, SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void resetDocumentLocator(String publicid, String systemid);

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void startCDATA();

	}
