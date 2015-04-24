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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/entity/StringEntity.java $
 * $Revision: 618367 $
 * $Date: 2008-02-04 10:26:06 -0800 (Mon, 04 Feb 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.http.Header;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class StringEntity extends AbstractHttpEntity {
	
	// DSModeled - changed type from char[] to String.
	protected final String content;
	
	@DSModeled(DSC.SPEC)
	public StringEntity(final String string) {
		this.content = string;
    }

	public StringEntity(final String string, final Charset charset) {
        this(string, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset));
    }

	public StringEntity(final String string, final ContentType contentType) {
        this.content = string;
        setContentType(contentType.toString());
    }
	
	@Override
	public InputStream getContent() throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRepeatable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStreaming() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void writeTo(OutputStream arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consumeContent() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Header getContentEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isChunked() {
		// TODO Auto-generated method stub
		return false;
	}

}
