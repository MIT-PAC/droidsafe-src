package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.xml.sax.SAXException;

public interface ScanHandler {
	

	public void adup(char[] buff, int offset, int length) throws SAXException;

	

	public void aname(char[] buff, int offset, int length) throws SAXException;

	

	public void aval(char[] buff, int offset, int length) throws SAXException;

	
	public void cdsect(char[] buff, int offset, int length) throws SAXException;

	

	public void decl(char[] buff, int offset, int length) throws SAXException;

	

	public void entity(char[] buff, int offset, int length) throws SAXException;

	

	public void eof(char[] buff, int offset, int length) throws SAXException;

	

	public void etag(char[] buff, int offset, int length) throws SAXException;

	

	public void gi(char[] buff, int offset, int length) throws SAXException;

	

	public void pcdata(char[] buff, int offset, int length) throws SAXException;

	

	public void pi(char[] buff, int offset, int length) throws SAXException;

	

	public void pitarget(char[] buff, int offset, int length) throws SAXException;

	

	public void stagc(char[] buff, int offset, int length) throws SAXException;

	

	public void stage(char[] buff, int offset, int length) throws SAXException;

	

	public void cmnt(char[] buff, int offset, int length) throws SAXException;

	

	public int getEntity();
	}
