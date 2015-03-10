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
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.android.internal.R;

public class CharacterPickerDialog extends Dialog implements OnItemClickListener, OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.197 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.200 -0500", hash_original_field = "A0E0D46B2E5271C6AA1B4726B137CECB", hash_generated_field = "4D56A7421E5A9A046126DAEE3F2ADC1F")

    private Editable mText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.203 -0500", hash_original_field = "AE4A646A55260577A41F3158DEDFFA41", hash_generated_field = "C4E4EFD2F278AF0CA31B4D2B65C0BA3F")

    private String mOptions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.206 -0500", hash_original_field = "DAD069851D7B65E53E7465911A6A4A4D", hash_generated_field = "2F18391B0FEF3A9AD8385744A3286F25")

    private boolean mInsert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.209 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.212 -0500", hash_original_field = "3D3F68D11E57184359C62700E6D8585C", hash_generated_field = "ABAA2B18FA7C6BED1CB3E1E533F796CB")

    private Button mCancelButton;

    /**
     * Creates a new CharacterPickerDialog that presents the specified
     * <code>options</code> for insertion or replacement (depending on
     * the sense of <code>insert</code>) into <code>text</code>.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.215 -0500", hash_original_method = "B85B2CE2D9925643AD72FE26FAC534DC", hash_generated_method = "B2136AFE62B7246CAB629FD53700B2CA")
    
public CharacterPickerDialog(Context context, View view,
                                 Editable text, String options,
                                 boolean insert) {
        super(context, com.android.internal.R.style.Theme_Panel);

        mView = view;
        mText = text;
        mOptions = options;
        mInsert = insert;
        mInflater = LayoutInflater.from(context);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.218 -0500", hash_original_method = "E0AAB102B3ED3AF261F94C84219E8ECE", hash_generated_method = "AFAC94750396B597F8BB4B9A0515357A")
    @DSVerified
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.token = mView.getApplicationWindowToken();
        params.type = params.TYPE_APPLICATION_ATTACHED_DIALOG;
        params.flags = params.flags | Window.FEATURE_NO_TITLE;

        setContentView(R.layout.character_picker);

        GridView grid = (GridView) findViewById(R.id.characterPicker);
        grid.setAdapter(new OptionsAdapter(getContext()));
        grid.setOnItemClickListener(this); //this will trigger onItemClick

        mCancelButton = (Button) findViewById(R.id.cancel);
        mCancelButton.setOnClickListener(this);
    }

    /**
     * Handles clicks on the character buttons.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.221 -0500", hash_original_method = "EEFA1E961CDBB58662ABBCDF41F1AD2A", hash_generated_method = "65313E400B2230ADE8F11B1477BB7E1A")
    
public void onItemClick(AdapterView parent, View view, int position, long id) {
        String result = String.valueOf(mOptions.charAt(position));
        replaceCharacterAndClose(result);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.224 -0500", hash_original_method = "889637D7E351CCF8A657470FC2914F00", hash_generated_method = "36883B57129A6A258181D8CA0419954E")
    
private void replaceCharacterAndClose(CharSequence replace) {
        int selEnd = Selection.getSelectionEnd(mText);
        if (mInsert || selEnd == 0) {
            mText.insert(selEnd, replace);
        } else {
            mText.replace(selEnd - 1, selEnd, replace);
        }

        dismiss();
    }

    /**
     * Handles clicks on the Cancel button.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.228 -0500", hash_original_method = "3104127334A31B48E0F0795A4514B3FB", hash_generated_method = "83AB2C617D4369F8739FE19B5CE2C164")
    @DSVerified
public void onClick(View v) {
        if (v == mCancelButton) {
            dismiss();
        } else if (v instanceof Button) {
            CharSequence result = ((Button) v).getText();
            replaceCharacterAndClose(result);
        }
    }
    
    private class OptionsAdapter extends BaseAdapter {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.232 -0500", hash_original_method = "AC698511382015922DCBD4CE64D2CC39", hash_generated_method = "310122105A636972DECFA3875E12F36D")
        
public OptionsAdapter(Context context) {
            super();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.235 -0500", hash_original_method = "2F3D5346969689C1B0E524EA0F83CDB3", hash_generated_method = "3D5D618B2C4A90AC83411EF5C6ACE585")
        @DSVerified("onClick Called inside button")
        @DSSafe(DSCat.SAFE_OTHERS)
public View getView(int position, View convertView, ViewGroup parent) {
            Button b = (Button)
                mInflater.inflate(R.layout.character_picker_button, null);
            b.setText(String.valueOf(mOptions.charAt(position)));
            b.setOnClickListener(CharacterPickerDialog.this);
            return b;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.238 -0500", hash_original_method = "DE59A8E1295F8E334D75F62942CFDC7D", hash_generated_method = "068ECB1C09DB1EEA27AC6685EFD58AE6")
        
public final int getCount() {
            return mOptions.length();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.241 -0500", hash_original_method = "8B0C0E62DBC532F544A3C62A19BF4060", hash_generated_method = "80F71820F60B1DF2BFF86DB8B119223E")
        
public final Object getItem(int position) {
            return String.valueOf(mOptions.charAt(position));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.DATABASE})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.244 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "EACE94B0A96EDF0E9405B246169ACAA0")
        
public final long getItemId(int position) {
            return position;
        }
        
    }
    
}

