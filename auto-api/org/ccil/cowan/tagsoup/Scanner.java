package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import org.xml.sax.SAXException;

public interface Scanner {

	

	public void scan(Reader r, ScanHandler h) throws IOException, SAXException;

	

	public void resetDocumentLocator(String publicid, String systemid);

	

	public void startCDATA();

	}
