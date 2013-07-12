package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Reader;
import java.io.InputStream;

public interface AutoDetector {

	

	public Reader autoDetectingReader(InputStream i);

	}
