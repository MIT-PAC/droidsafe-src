/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.harmony.javax.security.auth.login;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.AccessController;
import org.apache.harmony.javax.security.auth.AuthPermission;

public abstract class Configuration {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.693 -0400", hash_original_field = "CF70BB5FA8E03B7E9184F25C9E52D75B", hash_generated_field = "F1131520255BD5B92A8FDCDAA9B91E9B")

    private static Configuration configuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.694 -0400", hash_original_field = "A6B91C41D872BA9CAF7A9423EA74759A", hash_generated_field = "CE5D09EB30F716D2422AEDFBBFF26C88")

    private static final AuthPermission GET_LOGIN_CONFIGURATION = new AuthPermission(
            "getLoginConfiguration");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.695 -0400", hash_original_field = "06F1C2B8DC2070FB32B4297A97AC2443", hash_generated_field = "0F3E92B3CE7F8D5641D6E178990306DD")

    // creates a AuthPermission object with a specify property
    private static final AuthPermission SET_LOGIN_CONFIGURATION = new AuthPermission(
            "setLoginConfiguration");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.695 -0400", hash_original_field = "4DF9D4E30093AE85B87789A04329683F", hash_generated_field = "302CE28EF6AD0C54725BDC42D6C97C67")

    // Key to security properties, defining default configuration provider.
    private static final String LOGIN_CONFIGURATION_PROVIDER = "login.configuration.provider";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.696 -0400", hash_original_method = "E261AC0D2911EEB168643B1AC24CB5B4", hash_generated_method = "1DAAA6E013F4F68312A8AADE957C1F87")
    
public static Configuration getConfiguration() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(GET_LOGIN_CONFIGURATION);
        }
        return getAccessibleConfiguration();
    }

    /**
     * Reads name of default configuration provider from security.properties,
     * loads the class and instantiates the provider.<br> In case of any
     * exception, wraps it with SecurityException and throws further.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.698 -0400", hash_original_method = "F30DEA7A091BEC57EC5E8AFD58F3922D", hash_generated_method = "9FA9EBC2F5C6E0A3EE306B141CB7BF15")
    
private static final Configuration getDefaultProvider() {
        return new Configuration() {
			
			@Override
			public void refresh() {
			}
			
			@DSSafe(DSCat.SAFE_LIST)
        @Override
			public AppConfigurationEntry[] getAppConfigurationEntry(
					String applicationName) {
				return new AppConfigurationEntry[0];
			}
		};
    }

    /**
     * Shortcut accessor for friendly classes, to skip security checks.
     * If active configuration was set to <code>null</code>, tries to load a default 
     * provider, so this method never returns <code>null</code>. <br>
     * This method is synchronized with setConfiguration()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.699 -0400", hash_original_method = "B15F95B21213EA173D82B2E2B1119F4A", hash_generated_method = "A983C53A4FF2CE7ED41BBCCBAAE42A6D")
    
static Configuration getAccessibleConfiguration() {
        Configuration current = configuration;
        if (current == null) {
            synchronized (Configuration.class) {
                if (configuration == null) {
                    configuration = getDefaultProvider();
                }
                return configuration;
            }
        }
        return current;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.699 -0400", hash_original_method = "1B531E68CB5E851BDA7EA301272ECF2B", hash_generated_method = "6E3C0166B4B91F851C33C3343FEC81ED")
    
public static void setConfiguration(Configuration configuration) {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(SET_LOGIN_CONFIGURATION);
        }
        Configuration.configuration = configuration;
    } //$NON-NLS-1$

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.696 -0400", hash_original_method = "01D098F40E622A8EC68FF7CBDF4615CA", hash_generated_method = "22A1448976A075E83FEC38ABF1ACA6F6")
    
protected Configuration() {
        super();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.700 -0400", hash_original_method = "C70FA0206626337048D22E4C69D13CF4", hash_generated_method = "8595C423BCFD08BB9D7EE237D5D699D8")
    
public abstract AppConfigurationEntry[] getAppConfigurationEntry(String applicationName);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.700 -0400", hash_original_method = "500C1FD836B4942DF003D435F0D22C7F", hash_generated_method = "DFA7D4A224BDD6722BAB7E95975D244B")
    
public abstract void refresh();

}
