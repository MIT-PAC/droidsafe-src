/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package org.apache.http.entity;

// Droidsafe Imports
import java.io.Serializable;
import java.nio.charset.Charset;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public final class ContentType implements Serializable {
	
	private static final long serialVersionUID = -7768694718232371896L;
	public static final ContentType APPLICATION_ATOM_XML = create(
            "application/atom+xml", (Charset)null);
	public static final ContentType APPLICATION_FORM_URLENCODED = create(
            "application/x-www-form-urlencoded", (Charset)null);
	public static final ContentType APPLICATION_JSON = create(
            "application/json", (Charset)null);
	public static final ContentType APPLICATION_OCTET_STREAM = create(
            "application/octet-stream", (Charset) null);
	public static final ContentType APPLICATION_SVG_XML = create(
            "application/svg+xml", (Charset)null);
	public static final ContentType APPLICATION_XHTML_XML = create(
            "application/xhtml+xml", (Charset)null);
	public static final ContentType APPLICATION_XML = create(
            "application/xml", (Charset)null);
	public static final ContentType MULTIPART_FORM_DATA = create(
            "multipart/form-data", (Charset)null);
	public static final ContentType TEXT_HTML = create(
            "text/html", (Charset)null);
	public static final ContentType TEXT_PLAIN = create(
            "text/plain", (Charset)null);
	public static final ContentType TEXT_XML = create(
            "text/xml", (Charset)null);
	public static final ContentType WILDCARD = create(
            "*/*", (Charset) null);
	public static final ContentType DEFAULT_TEXT = TEXT_PLAIN;
	public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
	private final String mimeType;
	private final Charset charset;
	
	@DSModeled(DSC.SAFE)
	ContentType(final String mimeType, final Charset charset){
		this.mimeType = mimeType;
		this.charset = charset;
	}
	
	public String getMimeType(){
		
		// Original method
		/*
		{
        return this.mimeType;
    }
		*/
		return "";
	}
	
	public Charset getCharset(){
		
		// Original method
		/*
		{
        return this.charset;
    }
		*/
		return null;
	}
	
	@DSModeled(DSC.SAFE)
	@Override public String toString(){
		
		// Original method
		/*
		{
        StringBuilder buf = new StringBuilder();
        buf.append(this.mimeType);
        if (this.charset != null) {
            buf.append("; charset=");
            buf.append(this.charset.name());
        }
        return buf.toString();
    }
		*/
		return this.mimeType;
	}
	
	private static boolean valid(final String s){
		
		// Original method
		/*
		{
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '"' || ch == ',' || ch == ';') {
                return false;
            }
        }
        return true;
    }
		*/
		return false;
	}
	
	@DSModeled(DSC.SAFE)
	public static ContentType create(final String mimeType, final Charset charset){
		
		// Original method
		/*
		{
        if (mimeType == null) {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        String type = mimeType.trim().toLowerCase(Locale.US);
        if (type.length() == 0) {
            throw new IllegalArgumentException("MIME type may not be empty");
        }
        if (!valid(type)) {
            throw new IllegalArgumentException("MIME type may not contain reserved characters");
        }
        return new ContentType(type, charset);
    }
		*/
        return new ContentType(mimeType, charset);
	}
	
	@DSModeled(DSC.SAFE)
	public static ContentType create(final String mimeType){
		
		// Original method
		/*
		{
        return new ContentType(mimeType, (Charset) null);
    }
		*/
        return new ContentType(mimeType, null);
	}
	
	@DSModeled(DSC.SAFE)
	public static ContentType create(
            final String mimeType, final String charset){
		
		// Original method
		/*
		{
        return create(mimeType, 
                (charset != null && charset.length() > 0) ? Charset.forName(charset) : null);
    }
		*/
        return new ContentType(mimeType, null);
	}
	
	private static ContentType create(final HeaderElement helem){
		
		// Original method
		/*
		{
        String mimeType = helem.getName();
        String charset = null;
        NameValuePair param = helem.getParameterByName("charset");
        if (param != null) {
            charset = param.getValue();
        }
        return create(mimeType, charset);
    }
		*/
		return null;
	}
	
	public static ContentType parse(
            final String s){
		
		// Original method
		/*
		{
        if (s == null) {
            throw new IllegalArgumentException("Content type may not be null");
        }
        HeaderElement[] elements = BasicHeaderValueParser.parseElements(s, null);
        if (elements.length > 0) {
            return create(elements[0]);
        } else {
            throw new ParseException("Invalid content type: " + s);
        }
    }
		*/
		return null;
	}
	
	public static ContentType get(
            final HttpEntity entity){
		
		// Original method
		/*
		{
        if (entity == null) {
            return null;
        }
        Header header = entity.getContentType();
        if (header != null) {
            HeaderElement[] elements = header.getElements();
            if (elements.length > 0) {
                return create(elements[0]);
            }
        }
        return null;
    }
		*/
		return null;
	}
	
	public static ContentType getOrDefault(
            final HttpEntity entity){
		
		// Original method
		/*
		{
        ContentType contentType = get(entity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }
		*/
		return null;
	}
	
}

