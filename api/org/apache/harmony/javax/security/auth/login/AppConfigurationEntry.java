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
import java.util.Collections;
import java.util.Map;



public class AppConfigurationEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.345 -0400", hash_original_field = "24849849B401C8B6EE91CAB2C21A5870", hash_generated_field = "5AF39E9D6C816711FA036D1799D64C4B")

    private  Map<String, ?> options;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.346 -0400", hash_original_field = "4DE8305FADB3296BD8D79FCBB6F0D33D", hash_generated_field = "01A642E7EC9CD48023C14B67A9F2932E")

    private  AppConfigurationEntry.LoginModuleControlFlag controlFlag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.346 -0400", hash_original_field = "CC9E61D65714F716C360C6220369DCEE", hash_generated_field = "4E7C72968CD87BEBE1A005AB05150E03")

    private  String loginModuleName;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.347 -0400", hash_original_method = "B061C1169D512202FE2A4A6C2B9A0BDA", hash_generated_method = "454E2BDAC8534798B363DA5E8F5E8B32")
    
public AppConfigurationEntry(String loginModuleName,
            AppConfigurationEntry.LoginModuleControlFlag controlFlag, Map<String, ?> options) {

        if (loginModuleName == null || loginModuleName.length() == 0) {
            throw new IllegalArgumentException("auth.26"); //$NON-NLS-1$
        }

        if (controlFlag == null) {
            throw new IllegalArgumentException("auth.27"); //$NON-NLS-1$
        }

        if (options == null) {
            throw new IllegalArgumentException("auth.1A"); //$NON-NLS-1$
        }

        this.loginModuleName = loginModuleName;
        this.controlFlag = controlFlag;
        this.options = Collections.unmodifiableMap(options);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.348 -0400", hash_original_method = "F6F114924EB5A23396CC11BAEC568103", hash_generated_method = "F109AD4CE42BD488416FF1C09B497D56")
    
public String getLoginModuleName() {
        return loginModuleName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.348 -0400", hash_original_method = "3F703EA909EEF6F1132A6D962CE5FE25", hash_generated_method = "2A236CEC8A958DB1EE8EDC4E22EAFC7E")
    
public LoginModuleControlFlag getControlFlag() {
        return controlFlag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.349 -0400", hash_original_method = "17CD54894C02C35166936FB5BD0056E2", hash_generated_method = "8FF26E11ABFC9A9DEB313543F50FA651")
    
public Map<java.lang.String, ?> getOptions() {
        return options;
    }

    public static class LoginModuleControlFlag {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.350 -0400", hash_original_field = "67350378BDE079511404FFBF69D82752", hash_generated_field = "CBEFCC707DD58A47071A2003D241EDCF")


        public static final LoginModuleControlFlag REQUIRED = new LoginModuleControlFlag(
                "LoginModuleControlFlag: required");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.350 -0400", hash_original_field = "7B9F532DFA12E36CFCA88104F7D74CC5", hash_generated_field = "EB5ABFB3DC64ADD0B68E80B0CDD498D5")


        public static final LoginModuleControlFlag REQUISITE = new LoginModuleControlFlag(
                "LoginModuleControlFlag: requisite");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.351 -0400", hash_original_field = "6FC6E60BFF7240637557E985B4FB9061", hash_generated_field = "0BF2A25B2B60AB90093BC041BFD8A5A7")


        public static final LoginModuleControlFlag OPTIONAL = new LoginModuleControlFlag(
                "LoginModuleControlFlag: optional");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.351 -0400", hash_original_field = "D99C7790749850CFF60FCB887502D1CB", hash_generated_field = "7FB6578CD90B1CB78C393132C1712669")


        public static final LoginModuleControlFlag SUFFICIENT = new LoginModuleControlFlag(
                "LoginModuleControlFlag: sufficient");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.349 -0400", hash_original_field = "94D05443C2D4A14B2E46701545655D4C", hash_generated_field = "7E5FDFD9BF7ECBA20F0405CD4F35E22E")

        private  String flag; //$NON-NLS-1$

        // Creates the LoginModuleControlFlag object with specified a flag
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.352 -0400", hash_original_method = "863281485EB64CEC07509F0F7D4466BF", hash_generated_method = "7DBCEA7AFFC968AF1BE5EA9765B2EDA3")
        
private LoginModuleControlFlag(String flag) {
            this.flag = flag;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.352 -0400", hash_original_method = "EA80489DF602A6637C55E1A6A72F527F", hash_generated_method = "53ADA7CA315EA5FD4C8C666FD89B1793")
        
@Override
        public String toString() {
            return flag;
        }
    }
}
