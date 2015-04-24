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
 * Copyright (C) 2011 The Android Open Source Project
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
 * limitations under the License
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    /**
     * Creates a cross process cursor wrapper.
     * @param cursor The underlying cursor to wrap.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.987 -0500", hash_original_method = "5197A5F113F85D854415B2B6533E1F8C", hash_generated_method = "AE455A2594CA87F4AA1FE2262F4153C1")
    
public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.990 -0500", hash_original_method = "8AFBAB5134F9C202EA9293756DDD55DE", hash_generated_method = "5BEBB5BB2469261611900B3E1EBDF372")
    
@Override
    public void fillWindow(int position, CursorWindow window) {
        if (mCursor instanceof CrossProcessCursor) {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            crossProcessCursor.fillWindow(position, window);
            return;
        }

        DatabaseUtils.cursorFillWindow(mCursor, position, window);
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.992 -0500", hash_original_method = "D510FEC99A9AF46DE1EA010D6828DD6E", hash_generated_method = "B274170C8BD2FA2D26833AA62279DD73")
    
@Override
    public CursorWindow getWindow() {
        if (mCursor instanceof CrossProcessCursor) {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            return crossProcessCursor.getWindow();
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.995 -0500", hash_original_method = "1B4D2A02F9F1E4FEB130E32B375A1C19", hash_generated_method = "39EC9CB83A8BDF1263B4668B66D96CF6")
    
@Override
    public boolean onMove(int oldPosition, int newPosition) {
        if (mCursor instanceof CrossProcessCursor) {
            final CrossProcessCursor crossProcessCursor = (CrossProcessCursor)mCursor;
            return crossProcessCursor.onMove(oldPosition, newPosition);
        }

        return true;
    }
    
}

