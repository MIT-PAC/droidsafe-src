package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xml.sax.SAXException;

public interface ScanHandler {

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void adup(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void aname(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void aval(char[] buff, int offset, int length) throws SAXException;
	
	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void cdsect(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void decl(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void entity(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void eof(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void etag(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void gi(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void pcdata(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void pi(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void pitarget(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void stagc(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void stage(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void cmnt(char[] buff, int offset, int length) throws SAXException;

	@DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public int getEntity();
	}
