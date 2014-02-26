/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001-2005 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache Commons" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
 
package org.apache.commons.net.nntp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This is a class that contains the basic state needed for message retrieval and threading.
 * With thanks to Jamie  Zawinski <jwz@jwz.org>
 * @author rwinston <rwinston@checkfree.com>
 *
 */
public class Article implements Threadable {
		
	/**
	 * Recursive method that traverses a pre-threaded graph (or tree) 
	 * of connected Article objects and prints them out.  
	 * @param article the root of the article 'tree'
	 * @param depth the current tree depth
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.488 -0500", hash_original_method = "688801513F9CC3FC2D9B956CC71C2D9D", hash_generated_method = "00CC59E2456E37417BD3FAD6CA1EE650")
	
public static void printThread(Article article, int depth) {
			for (int i = 0; i < depth; ++i)
				System.out.print("==>");
			System.out.println(article.getSubject() + "\t" + article.getFrom());
			if (article.kid != null)
				printThread(article.kid, depth + 1);
			if (article.next != null)
				printThread(article.next, depth);
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.425 -0500", hash_original_field = "AD73D511D8C0DDDC6A5FC70A12252EE6", hash_generated_field = "3A3FCFC03BF63196D41D2C1F90A4CCD2")

	private int articleNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.429 -0500", hash_original_field = "05CF6DC5327609584327D4E74FDB9847", hash_generated_field = "77BC7ADBB1809074C43A3B672A24414B")

	private String subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.437 -0500", hash_original_field = "EE33E4A007EF5C5D569CA54EEDF39A38", hash_generated_field = "3D6104A8AD729A5E4BBF8BAD7888D7CC")

	private String date;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.440 -0500", hash_original_field = "5BEF1F2E0B8C500D11739D073D3AF413", hash_generated_field = "D2D9435B6ECA5241B9285B1776397631")

	private String articleId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.443 -0500", hash_original_field = "95A71D5B6F85B847440272BE71605ADE", hash_generated_field = "357BAA20A1C353A27705519C60B7E0DF")

	private String simplifiedSubject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.446 -0500", hash_original_field = "E5E29A4FD249F99876855FEBBD8507F1", hash_generated_field = "C1B976DE3297C1947D36F376ED057E08")

	private String from;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.450 -0500", hash_original_field = "51692AAE7EAA9078BB8E432A10ED87AD", hash_generated_field = "2798528AB23057407FEAD0560EC5BF5E")

	private StringBuffer header;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.453 -0500", hash_original_field = "BAC436825CF3126CD646B63B53499DAD", hash_generated_field = "B63BF0E12C6D3FC607FA8052546B649D")

	private StringBuffer references;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.456 -0500", hash_original_field = "4DAA62EEFC42DDA4C5825B00A817E6BC", hash_generated_field = "7CAFCFEADFA1D234382A8F110A73CB64")

	private boolean isReply = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.459 -0500", hash_original_field = "1B8AA6306F1F24D7A6A598E8509430D8", hash_generated_field = "44DC1AF7F81A01D8275E8D6EF9791EF3")

	
	public Article kid, next;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.463 -0500", hash_original_method = "92666D6EA1E33E9CD3A5521B843BEBBC", hash_generated_method = "B9A2095532502B82BB1EAF7D4183773F")
	
public Article() {
		header = new StringBuffer();
	}

	/**
	 * Adds an arbitrary header key and value to this message's header.
	 * @param name the header name
	 * @param val the header value
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.467 -0500", hash_original_method = "11B1E697782FA8E30A6D0D1E236AB9C8", hash_generated_method = "660D7457B8BE490BE462C73899E90B4C")
	
public void addHeaderField(String name, String val) {
		header.append(name);
		header.append(": ");
		header.append(val);
		header.append('\n');
	}
	
	/**
	 * Adds a message-id to the list of messages that this message references (i.e. replies to)
	 * @param msgId
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.471 -0500", hash_original_method = "41572E8B48AA4FFDEDC5648FC4357E34", hash_generated_method = "A38AC4790B73304A5AFBA25675780FA5")
	
public void addReference(String msgId) {
		if (references == null) {
			references = new StringBuffer();
			references.append("References: ");
		}
		references.append(msgId);
		references.append("\t");
	}

	/**
	 * Returns the MessageId references as an array of Strings
	 * @return an array of message-ids
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.475 -0500", hash_original_method = "1C729909A93E22E1CFAD6C97F0E8C15B", hash_generated_method = "1FBAAB0B96A99C7018568EFCC539D3B2")
	
public String[] getReferences() {
		if (references == null)
			return new String[0];
		ArrayList list = new ArrayList();
		int terminator = references.toString().indexOf(':');
		StringTokenizer st =
			new StringTokenizer(references.substring(terminator), "\t");
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return (String[]) list.toArray();
	}
	
	/**
	 * Attempts to parse the subject line for some typical reply signatures, and strip them out
	 *
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.480 -0500", hash_original_method = "1580E47F5CA043D92A51FFCE46D3AD3B", hash_generated_method = "A973F409C0398A46C86939076D4BEBA6")
	
private void simplifySubject() {
			int start = 0;
			String subject = getSubject();
			int len = subject.length();

			boolean done = false;

			while (!done) {
				done = true;

				// skip whitespace
				// "Re: " breaks this
				while (start < len && subject.charAt(start) == ' ') {
					start++;
				}

				if (start < (len - 2)
					&& (subject.charAt(start) == 'r' || subject.charAt(start) == 'R')
					&& (subject.charAt(start + 1) == 'e' || subject.charAt(start + 1) == 'E')) {

					if (subject.charAt(start + 2) == ':') {
						start += 3; // Skip "Re:"
						isReply = true;
						done = false;
					} else if (
						start < (len - 2) 
						&& 
						(subject.charAt(start + 2) == '[' || subject.charAt(start + 2) == '(')) {
                    	
						int i = start + 3;

						while (i < len && subject.charAt(i) >= '0' && subject.charAt(i) <= '9')
							i++;

						if (i < (len - 1)
							&& (subject.charAt(i) == ']' || subject.charAt(i) == ')')
							&& subject.charAt(i + 1) == ':') {
							start = i + 2;
							isReply = true;
							done = false;
						}
					}
				}

				if (simplifiedSubject == "(no subject)")
					simplifiedSubject = "";

				int end = len;

				while (end > start && subject.charAt(end - 1) < ' ')
					end--;

				if (start == 0 && end == len)
					simplifiedSubject = subject;
				else
					simplifiedSubject = subject.substring(start, end);
			}
		}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.492 -0500", hash_original_method = "57DD1CE918CFBFB61C6E39BD290A295E", hash_generated_method = "859BF159021C9E20A0189C84A66B9CF8")
	
public String getArticleId() {
		return articleId;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.495 -0500", hash_original_method = "29A1B89D82FEDF32A304DEB37C4633E3", hash_generated_method = "0E3851DDD8DEDB908480396BFA863EDD")
	
public int getArticleNumber() {
		return articleNumber;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.499 -0500", hash_original_method = "D93E0C2E728A494A9898BBDE97B14BE7", hash_generated_method = "341A34829B9C3A3276732B3F20DFA3F2")
	
public String getDate() {
		return date;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.502 -0500", hash_original_method = "9ECD383D716C5B075DDF6AD4346104F5", hash_generated_method = "1F0356561CB391F879808AE55FE55254")
	
public String getFrom() {
		return from;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.505 -0500", hash_original_method = "8EBD535E211A75BE78AF45361DF5913D", hash_generated_method = "8FE22A6343735A7D9BA6760DEE36A03C")
	
public String getSubject() {
		return subject;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.509 -0500", hash_original_method = "8A168D08C2DBA953F2A91DEEBB7FA9EE", hash_generated_method = "45ABFE27B052CA7054732E54CEDFA300")
	
public void setArticleId(String string) {
		articleId = string;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.512 -0500", hash_original_method = "7E9086900C6946D28811DAB12728F136", hash_generated_method = "DCC8E53F2E3752341EDA2B9F4C7613B6")
	
public void setArticleNumber(int i) {
		articleNumber = i;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.515 -0500", hash_original_method = "CD249ED37CCD101D61A70538576B04CB", hash_generated_method = "19DB768198B82E967ED639C1E6753F47")
	
public void setDate(String string) {
		date = string;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.518 -0500", hash_original_method = "D84EB19BC65C6DDD45E8FD5C3A5B29EE", hash_generated_method = "B23C9AA25FD0AAA4CD5F7D14DD2DECC5")
	
public void setFrom(String string) {
		from = string;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.521 -0500", hash_original_method = "FEE41DDA7DC8A6944C06A8F34A277A1B", hash_generated_method = "8F736F25EEED5DA45DDC9B622A0B7361")
	
public void setSubject(String string) {
		subject = string;
	}

	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.526 -0500", hash_original_method = "E278C1B3D6919FD1D8D546530F6036CE", hash_generated_method = "686AA24403A4F6137115446107F218F5")
	
public boolean isDummy() {
		return (getSubject() == null);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.529 -0500", hash_original_method = "43BB25FE3FB6ADB30F83A24462C6C7DB", hash_generated_method = "3D7455EB0D6BF68EED2A3F3EBA445023")
	
public String messageThreadId() {
		return articleId;
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.531 -0500", hash_original_method = "E251C9E6FAFC23CD6EAD17C1BD6E2230", hash_generated_method = "32A84E40CA7A7A49891F5AA850AC7280")
	
public String[] messageThreadReferences() {
		return getReferences();
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.535 -0500", hash_original_method = "CA41C7D22EB5A3C615A9597B90A61050", hash_generated_method = "F73DCBA2B043436B31D3FCC96D7045DE")
	
public String simplifiedSubject() {
		if(simplifiedSubject == null)
			simplifySubject();
		return simplifiedSubject;
	}

	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.546 -0500", hash_original_method = "49974B224A7041AE9594CB571D129955", hash_generated_method = "39AFBF142CAEFC5BCF2398F7CFB6875A")
	
public boolean subjectIsReply() {
		if(simplifiedSubject == null)
			simplifySubject();
		return isReply;
	}

	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.549 -0500", hash_original_method = "445CD0A0B26668E523A235D160BE7BAC", hash_generated_method = "4A524F0DB2E647E7FB188C7CDB1353A3")
	
public void setChild(Threadable child) {
		this.kid = (Article) child;
		flushSubjectCache();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.553 -0500", hash_original_method = "D60545D36F01DAED44E166B1A1ED407D", hash_generated_method = "B6F3C08949714570C71D24BE876A5ECC")
	
private void flushSubjectCache() {
		simplifiedSubject = null;
	}

	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.556 -0500", hash_original_method = "1194F5D02EA97ACE953FAAFF017727F5", hash_generated_method = "A7333C9EC45BF9A1D0324049B96B14F7")
	
public void setNext(Threadable next) {
		this.next = (Article)next;
		flushSubjectCache();
	}

	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:08.559 -0500", hash_original_method = "F7EE12DBF5AF00AF31C1981E4BF53C13", hash_generated_method = "F644B5C816D672148F81C651E9862E4C")
	
public Threadable makeDummy() {
		return (Threadable)new Article();
	}
}
