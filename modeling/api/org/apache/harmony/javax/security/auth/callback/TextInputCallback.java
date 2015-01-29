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

package org.apache.harmony.javax.security.auth.callback;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;

public class TextInputCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.045 -0400", hash_original_field = "F69403F80BC788246D62E22F983F4E65", hash_generated_field = "2A1268C218B8C736BF5FE3F690DA4C23")

    private static final long serialVersionUID = -8064222478852811804L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.045 -0400", hash_original_field = "AD7E58A82EEDD02E2FB67C4EA69C0D37", hash_generated_field = "26A49509539D709149C79333C53183D4")

    private String defaultText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.046 -0400", hash_original_field = "E39008C8C5530C4D0AB35F720027C03F", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.046 -0400", hash_original_field = "533BC7F2F8011642F38D9FE3B8668402", hash_generated_field = "6128EBC3A571BFF36DAF5BC2E6905CE5")

    private String inputText;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.048 -0400", hash_original_method = "ACF93EDAFCA1C5D18B0CE23EC20EC212", hash_generated_method = "5FCF3F8E1E243D8FF28BE0A203485037")
    
public TextInputCallback(String prompt) {
        super();
        setPrompt(prompt);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.049 -0400", hash_original_method = "6E87734B42503DE7041BF01607D6D69C", hash_generated_method = "CB199A10AEA0136CAF4CE0C5A70F640D")
    
public TextInputCallback(String prompt, String defaultText) {
        super();
        setPrompt(prompt);
        setDefaultText(defaultText);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.047 -0400", hash_original_method = "698D470B766BBB13E508EDEAA9F21795", hash_generated_method = "2E1AE1532527C2F20C18C9014EA808B3")
    
private void setPrompt(String prompt) {
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException("auth.14"); //$NON-NLS-1$
        }
        this.prompt = prompt;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.047 -0400", hash_original_method = "1C807D276A6F367F6DCE56150722F4F7", hash_generated_method = "9EDFA105255B7A519C9E045637DB5EFD")
    
private void setDefaultText(String defaultText) {
        if (defaultText == null || defaultText.length() == 0) {
            throw new IllegalArgumentException("auth.15"); //$NON-NLS-1$
        }
        this.defaultText = defaultText;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.049 -0400", hash_original_method = "7A1B4BDB0EE02DDD5D220CCF5A4BA32E", hash_generated_method = "304148D2CB17DDC2284E9A57895E9897")
    
public String getDefaultText() {
        return defaultText;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.050 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "8CA7BA3046EB7CBE9C3CBEDBD6976E4F")
    
public String getPrompt() {
        return prompt;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.050 -0400", hash_original_method = "589C424E16A710DC55032C55CC40F43D", hash_generated_method = "7049D688CAC749700D5EC52A798F28CA")
    
public String getText() {
        return inputText;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.051 -0400", hash_original_method = "09D324BCCBA5E11690C3F8F3C06EC8A8", hash_generated_method = "1B143D02F2B08D24CB052D78ACB4C9F7")
    
public void setText(String text) {
        this.inputText = text;
    }
}
