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
