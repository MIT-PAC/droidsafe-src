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
 * Copyright 2009 Rene Treffer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package de.measite.smack;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Map;

import com.novell.sasl.client.DigestMD5SaslClient;

import org.apache.harmony.javax.security.auth.callback.CallbackHandler;
import org.apache.harmony.javax.security.sasl.SaslClient;
import org.apache.harmony.javax.security.sasl.SaslException;
import org.apache.qpid.management.common.sasl.PlainSaslClient;

public class SaslClientFactory implements
		org.apache.harmony.javax.security.sasl.SaslClientFactory {

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.300 -0400", hash_original_method = "F0F237B43340512E86D027FD7D36DE1E", hash_generated_method = "DB03B42ACFF22174910E6E759839A45F")
	
@Override
	public SaslClient createSaslClient(String[] mechanisms,
			String authorizationId, String protocol, String serverName,
			Map<String, ?> props, CallbackHandler cbh) throws SaslException {
		for (String mech: mechanisms) {
			if ("PLAIN".equals(mech)) {
				return new PlainSaslClient(authorizationId, cbh);
			} else
			if ("DIGEST-MD5".equals(mech)) {
				return DigestMD5SaslClient.getClient(
					authorizationId,
					protocol,
					serverName,
					props,
					cbh
				);
			}
		}
		return null;
	}

	@DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:36.301 -0400", hash_original_method = "DC0C359999BC87C8658EF8F99046F8EB", hash_generated_method = "5DD020E5E00F00E3FC40FD9DF891BD65")
	
@Override
	public String[] getMechanismNames(Map<String, ?> props) {
		return new String[]{
			"PLAIN",
			"DIGEST-MD5"
		};
	}

}
