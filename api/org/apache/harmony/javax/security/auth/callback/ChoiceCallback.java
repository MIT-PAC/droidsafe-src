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



public class ChoiceCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.996 -0400", hash_original_field = "D5AA81EF30F3D1B20BEC310DCCEA9F89", hash_generated_field = "45005D00672054049C72A6B224F83A29")


    private static final long serialVersionUID = -3975664071579892167L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.997 -0400", hash_original_field = "D2AB274F69020A37003CA8E48E45D03C", hash_generated_field = "08A3646B678A949962FDDEB246CB921B")


    private int defaultChoice;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.998 -0400", hash_original_field = "E39008C8C5530C4D0AB35F720027C03F", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")


    private String prompt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.998 -0400", hash_original_field = "41ACF3ADD3DF525299741F431CA8CE6C", hash_generated_field = "7F5C79A334009FA9B56C9C5E97E310EF")


    private boolean multipleSelectionsAllowed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.999 -0400", hash_original_field = "F7541E064B67E6200FE2DDA0D76B470F", hash_generated_field = "532265EEBC91FD86FB045A3ABC7569AF")


    private String[] choices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.999 -0400", hash_original_field = "EE1AA5D41DC680973225DFB10236A201", hash_generated_field = "A214636FDEE520BEFBE5AB9BEBCAB6F6")


    private int[] selections;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.002 -0400", hash_original_method = "F587F829DD01DCF1D28AAA4716F26CD3", hash_generated_method = "5C7432250931DEDAF4E23CA98AB92A1C")
    
public ChoiceCallback(String prompt, String[] choices, int defaultChoice,
            boolean multipleSelectionsAllowed) {
        super();
        setPrompt(prompt);
        setChoices(choices);
        setDefaultChoice(defaultChoice);
        this.multipleSelectionsAllowed = multipleSelectionsAllowed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.000 -0400", hash_original_method = "029EDADAEDA2AFC5DBDBABFA218BA091", hash_generated_method = "26CD81BC0804DD96242D53AC771B1F1E")
    
private void setChoices(String[] choices) {
        if (choices == null || choices.length == 0) {
            throw new IllegalArgumentException("auth.1C"); //$NON-NLS-1$
        }
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] == null || choices[i].length() == 0) {
                throw new IllegalArgumentException("auth.1C"); //$NON-NLS-1$
            }
        }
        //FIXME: System.arraycopy(choices, 0 , new String[choices.length], 0, choices.length);
        this.choices = choices;

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.000 -0400", hash_original_method = "698D470B766BBB13E508EDEAA9F21795", hash_generated_method = "2E1AE1532527C2F20C18C9014EA808B3")
    
private void setPrompt(String prompt) {
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException("auth.14"); //$NON-NLS-1$
        }
        this.prompt = prompt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.001 -0400", hash_original_method = "025CDC269FD5E1E4B569BFF83796DB74", hash_generated_method = "151AC78B034D2D8C8B6141685330F60F")
    
private void setDefaultChoice(int defaultChoice) {
        if (0 > defaultChoice || defaultChoice >= choices.length) {
            throw new IllegalArgumentException("auth.1D"); //$NON-NLS-1$
        }
        this.defaultChoice = defaultChoice;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.002 -0400", hash_original_method = "1D9FEBB25A52606E7C277CCE7245E86E", hash_generated_method = "FFD1EF8697E5CA94421239A86374EC8C")
    
public boolean allowMultipleSelections() {
        return multipleSelectionsAllowed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.003 -0400", hash_original_method = "FF74700781D07E0EF995BFE9E824CB43", hash_generated_method = "56907F71F2E0193931EDC8D69EDD884A")
    
public String[] getChoices() {
        return choices;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.003 -0400", hash_original_method = "44208A1B5521AB17C141051E5A09A654", hash_generated_method = "9515404F9E02449B796A0E5E0346D189")
    
public int getDefaultChoice() {
        return defaultChoice;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.004 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "8CA7BA3046EB7CBE9C3CBEDBD6976E4F")
    
public String getPrompt() {
        return prompt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.004 -0400", hash_original_method = "995CB5E79E79C6A3551F8C82F3149623", hash_generated_method = "E5ED818407341CB56D09D6418F24D6F7")
    
public int[] getSelectedIndexes() {
        return selections;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.005 -0400", hash_original_method = "4F4A4B0DFFB6BC63ED34D5C3E8E8C483", hash_generated_method = "852DA7C0AD3ADC401CB9EDA6D01DE031")
    
public void setSelectedIndex(int selection) {
        this.selections = new int[1];
        this.selections[0] = selection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:09.005 -0400", hash_original_method = "E60907693556E01C33A8718D56537365", hash_generated_method = "E0AE3791536BD44F9E6EB10211DD0D42")
    
public void setSelectedIndexes(int[] selections) {
        if (!multipleSelectionsAllowed) {
            throw new UnsupportedOperationException();
        }
        this.selections = selections;
        //FIXME: 
        // this.selections = new int[selections.length]
        //System.arraycopy(selections, 0, this.selections, 0, this.selections.length);
    }
}
