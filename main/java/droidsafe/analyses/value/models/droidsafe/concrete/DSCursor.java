package droidsafe.analyses.value.models.droidsafe.concrete;

import com.google.common.collect.Sets;

import droidsafe.analyses.value.models.android.database.Cursor;
import droidsafe.analyses.value.models.android.net.Uri;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;

import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

public class DSCursor extends Cursor {

    public DSCursor(AllocNode allocNode) { 
        super(allocNode);
    }
    
    public void _init_() {

    }

    public void _init_(Uri uri, String[] projection, Set<String> selection, String[] selectionArgs, Set<String> sortOrder) {
    
    }

    public Set<ValueAnalysisBoolean> moveToFirst() {
        return null;
    }

    public Set<ValueAnalysisBoolean> isAfterLast() {
        return null;
    }

    public Set<ValueAnalysisBoolean> moveToNext() {
        return Sets.newHashSet(new ValueAnalysisBoolean(true));
    }
   
    public Set<String> getString(Set<ValueAnalysisInt> columnIndex) {
        return null;
    }

    public Set<ValueAnalysisInt> getCount() {
        return null;
    }
}


