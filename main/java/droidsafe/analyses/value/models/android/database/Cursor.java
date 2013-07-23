package droidsafe.analyses.value.models.android.database;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

import soot.jimple.spark.pag.AllocNode;

public class Cursor extends ValueAnalysisModeledObject {

    public Cursor(AllocNode allocNode) { 
        super(allocNode);
    }
}

