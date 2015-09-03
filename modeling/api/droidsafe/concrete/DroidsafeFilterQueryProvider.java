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
 */

package droidsafe.concrete;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSComment;
import droidsafe.annotations.DSSource;
import droidsafe.annotations.DSSourceKind;
import droidsafe.annotations.DSSpec;
import droidsafe.annotations.DSVerified;
import droidsafe.helpers.DSOnlyType;
import android.database.Cursor;
import android.widget.FilterQueryProvider;
import droidsafe.annotations.*;

public class DroidsafeFilterQueryProvider implements FilterQueryProvider {
	
	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public DroidsafeFilterQueryProvider() {
		
	}

	@Override
	@DSVerified
	@DSComment("Abstract Method")
	@DSSafe(DSCat.SAFE_LIST)
	
	public Cursor runQuery(CharSequence constraint) {
		// TODO Auto-generated method stub
		Cursor cursor = new DSCursor(DSOnlyType.DONTCARE);
		return cursor;
	}

}
