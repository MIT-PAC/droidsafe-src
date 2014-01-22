package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.Reader;

public interface AutoDetector {

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Reader autoDetectingReader(InputStream i);

	}
