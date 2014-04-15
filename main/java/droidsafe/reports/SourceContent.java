package droidsafe.reports;

import soot.SootClass;
import soot.SootMethod;
import soot.jimple.Stmt;

import com.google.gson.annotations.SerializedName;

import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public abstract class SourceContent {
    
    @SerializedName("src-loc")
    SourceLocationTag src_loc;
    
    protected void setSource(Stmt genStmt) {
        SootMethod method = JimpleRelationships.v().getEnclosingMethod(genStmt);
        src_loc = SootUtils.getSourceLocation(genStmt);
    }
    
    protected void setSource(SootMethod method) {
        src_loc = SootUtils.getMethodLocation(method);
    }
}