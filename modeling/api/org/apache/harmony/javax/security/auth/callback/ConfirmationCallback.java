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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.javax.security.auth.callback;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;



public class ConfirmationCallback implements Callback, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.851 -0400", hash_original_field = "E6281627ECF574949C074CC15B3EA856", hash_generated_field = "6AE22EBC31D7D18B692C77FF9A06D382")


    private static final long serialVersionUID = -9095656433782481624L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.852 -0400", hash_original_field = "96144739E9343F0C4C8EED8C95C4D3F4", hash_generated_field = "D85642FFC0FA65698B9F3B257AE70493")


    public static final int YES = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.853 -0400", hash_original_field = "2216558877FDD1692F8E46CBB987A405", hash_generated_field = "F941D1237392CD0B92804396197B1EB7")


    public static final int NO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.853 -0400", hash_original_field = "DBF9200C4A0337196A058C04CF627491", hash_generated_field = "4D8DA89E031565FBA903227D50DE270C")


    public static final int CANCEL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.854 -0400", hash_original_field = "9F571CB785A536761439361D4E4C40BC", hash_generated_field = "5224DEAF73E6C41AD00B654386222EDE")


    public static final int OK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.854 -0400", hash_original_field = "E75C2EF7F094E04FF220E20B4E39A916", hash_generated_field = "F52DDEF676109D0F21F339424E960324")


    public static final int YES_NO_OPTION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.855 -0400", hash_original_field = "2EB065EDE05547FB6FC368ED4AE2E607", hash_generated_field = "9797044F1833F3DC34EDFD56C42DFBB9")


    public static final int YES_NO_CANCEL_OPTION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.855 -0400", hash_original_field = "F4C536340BB5C418DBB5835F6E0261EF", hash_generated_field = "D68ED6B938B7AFA0A5AE819F07C094DA")


    public static final int OK_CANCEL_OPTION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.856 -0400", hash_original_field = "43923E67A3859C16682057EC210DEEFE", hash_generated_field = "8ADB312AFEACA8728ADAE0D8F3D9141E")


    public static final int UNSPECIFIED_OPTION = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.857 -0400", hash_original_field = "840675B2F8A9BE4EBEF5B5F9F9D9C018", hash_generated_field = "76E60C65F3078DE399A0BD7029E8A318")


    public static final int INFORMATION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.857 -0400", hash_original_field = "90B00A13356ACCF5BD2780C16BA63349", hash_generated_field = "B8C559E7F173AA822B2B792E52FCD9B2")


    public static final int WARNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.858 -0400", hash_original_field = "6B79DA8E084E22F65CCDD07B979B9949", hash_generated_field = "FBFCEE2B35A82DB052F105819D247209")


    public static final int ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.858 -0400", hash_original_field = "E39008C8C5530C4D0AB35F720027C03F", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")


    private String prompt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.859 -0400", hash_original_field = "B3E0C00F8616825E1647BC1E6CD823E2", hash_generated_field = "57552E8D54B3896B51E574B541E7B7DE")


    private int messageType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.859 -0400", hash_original_field = "B3C186AACFD6671351A6E55F5EC0B11C", hash_generated_field = "B008EEF81060CEB66CCC803BADBE5111")


    private int optionType = UNSPECIFIED_OPTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.860 -0400", hash_original_field = "A07EE51CFE23F1E2CE9AE6DCEB937166", hash_generated_field = "9A96427FA8832D01A43B4C7C466B02F8")


    private int defaultOption;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.860 -0400", hash_original_field = "3D0347FE2C2D374E27541B265D0EF0C8", hash_generated_field = "9E73FA49A3D1F7FB5A327BCD51686046")


    private String[] options;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.861 -0400", hash_original_field = "D7726ADF2B2C1044C59548F5B2EACD55", hash_generated_field = "05A7147CF6038F5EF0125FE94129234D")


    private int selection;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.862 -0400", hash_original_method = "B3AE6B59BA6F7EEAD8F642DE24EDEFCD", hash_generated_method = "60BDAF33CF4408AA7C29DD6616740FE6")
    
public ConfirmationCallback(int messageType, int optionType, int defaultOption) {
        super();
        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException("auth.16"); //$NON-NLS-1$
        }

        switch (optionType) {
            case YES_NO_OPTION:
                if (defaultOption != YES && defaultOption != NO) {
                    throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
                }
                break;
            case YES_NO_CANCEL_OPTION:
                if (defaultOption != YES && defaultOption != NO && defaultOption != CANCEL) {
                    throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
                }
                break;
            case OK_CANCEL_OPTION:
                if (defaultOption != OK && defaultOption != CANCEL) {
                    throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
                }
                break;
            default:
                throw new IllegalArgumentException("auth.18"); //$NON-NLS-1$
        }
        this.messageType = messageType;
        this.optionType = optionType;
        this.defaultOption = defaultOption;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.863 -0400", hash_original_method = "8250FEA8CB7033FECA36CD58FDA527E6", hash_generated_method = "39AF72D7C7F1D15C2C0EF482BC70E054")
    
public ConfirmationCallback(int messageType, String[] options, int defaultOption) {
        super();
        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException("auth.16"); //$NON-NLS-1$
        }

        if (options == null || options.length == 0) {
            throw new IllegalArgumentException("auth.1A"); //$NON-NLS-1$
        }
        for (int i = 0; i < options.length; i++) {
            if (options[i] == null || options[i].length() == 0) {
                throw new IllegalArgumentException("auth.1A"); //$NON-NLS-1$
            }
        }
        if (0 > defaultOption || defaultOption >= options.length) {
            throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
        }
        // FIXME:System.arraycopy(options, 0 , new String[this.options.length],
        // 0, this.options.length);
        this.options = options;
        this.defaultOption = defaultOption;
        this.messageType = messageType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.864 -0400", hash_original_method = "667AEDFD5EE12CED5D7F6EDDE3820CAC", hash_generated_method = "6C9451C95980E372FED6787DC820E47B")
    
public ConfirmationCallback(String prompt, int messageType, int optionType,
            int defaultOption) {
        super();
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException("auth.14"); //$NON-NLS-1$
        }

        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException("auth.16"); //$NON-NLS-1$
        }

        switch (optionType) {
            case YES_NO_OPTION:
                if (defaultOption != YES && defaultOption != NO) {
                    throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
                }
                break;
            case YES_NO_CANCEL_OPTION:
                if (defaultOption != YES && defaultOption != NO && defaultOption != CANCEL) {
                    throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
                }
                break;
            case OK_CANCEL_OPTION:
                if (defaultOption != OK && defaultOption != CANCEL) {
                    throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
                }
                break;
            default:
                throw new IllegalArgumentException("auth.18"); //$NON-NLS-1$
        }
        this.prompt = prompt;
        this.messageType = messageType;
        this.optionType = optionType;
        this.defaultOption = defaultOption;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.865 -0400", hash_original_method = "312CF9E06AD7768D942CAD84755622E2", hash_generated_method = "FF6CE364EB2013440CBE9B331DC8A734")
    
public ConfirmationCallback(String prompt, int messageType, String[] options,
            int defaultOption) {
        super();
        if (prompt == null || prompt.length() == 0) {
            throw new IllegalArgumentException("auth.14"); //$NON-NLS-1$
        }

        if (messageType > ERROR || messageType < INFORMATION) {
            throw new IllegalArgumentException("auth.16"); //$NON-NLS-1$
        }

        if (options == null || options.length == 0) {
            throw new IllegalArgumentException("auth.1A"); //$NON-NLS-1$
        }
        for (int i = 0; i < options.length; i++) {
            if (options[i] == null || options[i].length() == 0) {
                throw new IllegalArgumentException("auth.1A"); //$NON-NLS-1$
            }
        }
        if (0 > defaultOption || defaultOption >= options.length) {
            throw new IllegalArgumentException("auth.17"); //$NON-NLS-1$
        }
        // FIXME:System.arraycopy(options, 0 , new String[this.options.length],
        // 0, this.options.length);
        this.options = options;
        this.defaultOption = defaultOption;
        this.messageType = messageType;
        this.prompt = prompt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.866 -0400", hash_original_method = "9CD919A2E5CE4DE3A8693DD7DF368A07", hash_generated_method = "8CA7BA3046EB7CBE9C3CBEDBD6976E4F")
    
public String getPrompt() {
        return prompt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.866 -0400", hash_original_method = "2C4FC08D25B03FD0EFCA578F58E578D2", hash_generated_method = "FAA258CC0C63CB0D776A6C84B6E75963")
    
public int getMessageType() {
        return messageType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.867 -0400", hash_original_method = "EA690033FD3551B5CC8A0B6438ED470B", hash_generated_method = "2E3DCA420313688F7571D63B6D93279C")
    
public int getDefaultOption() {
        return defaultOption;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.867 -0400", hash_original_method = "48688425F3667854241D63D50DF1E7C0", hash_generated_method = "41CCA2CA21859D69CAA86CFBF6DD00F7")
    
public String[] getOptions() {
        return options;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.867 -0400", hash_original_method = "EAEA79927B727C07C14EDC037589A40F", hash_generated_method = "AC8236F7DB0A909E50ABDABB96441A3F")
    
public int getOptionType() {
        return optionType;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.868 -0400", hash_original_method = "007BF61E23F43A3371718E99FCFD1306", hash_generated_method = "E2CDF32FB717D40E075DD79DF81FE432")
    
public int getSelectedIndex() {
        return selection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:08.869 -0400", hash_original_method = "DD948143031C7F3C860B571A0CC6095B", hash_generated_method = "7F25A9F62EC2407CC930F5E47A973EFC")
    
public void setSelectedIndex(int selection) {
        if (options != null) {
            if (0 <= selection && selection <= options.length) {
                this.selection = selection;
            } else {
                throw new ArrayIndexOutOfBoundsException("auth.1B"); //$NON-NLS-1$
            }
        } else {
            switch (optionType) {
                case YES_NO_OPTION:
                    if (selection != YES && selection != NO) {
                        throw new IllegalArgumentException("auth.19"); //$NON-NLS-1$
                    }
                    break;
                case YES_NO_CANCEL_OPTION:
                    if (selection != YES && selection != NO && selection != CANCEL) {
                        throw new IllegalArgumentException("auth.19"); //$NON-NLS-1$
                    }
                    break;
                case OK_CANCEL_OPTION:
                    if (selection != OK && selection != CANCEL) {
                        throw new IllegalArgumentException("auth.19"); //$NON-NLS-1$
                    }
                    break;
            }
            this.selection = selection;
        }
    }
}
