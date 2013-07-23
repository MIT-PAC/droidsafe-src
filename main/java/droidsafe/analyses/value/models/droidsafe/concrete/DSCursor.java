package droidsafe.analyses.value.models.droidsafe.concrete;

import com.google.common.collect.Sets;

import droidsafe.analyses.value.models.android.database.Cursor;
import droidsafe.analyses.value.models.android.net.Uri;
import droidsafe.analyses.value.models.droidsafe.primitive.Boolean;

import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public class DSCursor extends Cursor {

    public DSCursor(AllocNode allocNode) { 
        super(allocNode);
    }

    public void __init__(Uri uri, String[] projection, Set<String> selection, String[] selectionArgs, Set<String> sortOrder) {
    
    }

    public Set<ValueAnalysisBoolean> moveToFirst() {
        return null;
    }

    public Set<ValueAnalysisBoolean> moveToNext() {
        return Sets.newHashSet(new ValueAnalysisBoolean(true));
    }
   
    public Set<String> getString(ValueAnalysisInt columnIndex) {
        return null;
    }


}


