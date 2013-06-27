package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Reader;
import java.io.InputStream;

public interface AutoDetector {

	

	public Reader autoDetectingReader(InputStream i);

	}
