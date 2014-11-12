package droidsafe.analyses.interapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import soot.jimple.Stmt;
import droidsafe.android.system.InfoKind;

public class SourceFlow {
    /** source information kind */
    private InfoKind srcKind;
    /** Strings representing the generating source statements */
    private Collection<String> srcStmts;
    /** The reolved intent for the source flow */
    private ResolvedIntent intent;
    /** The generating api call type */
    private InterAppApiCall apiCall;
    
    public SourceFlow(InterAppApiCall apiCall, InfoKind srcKind, Collection<Stmt> srcSootStmts, ResolvedIntent intent) {
        super();
        this.apiCall = apiCall;
        this.srcKind = srcKind;
        
        this.intent = intent;
        this.srcStmts = new ArrayList<String>();
        for (Stmt stmt : srcSootStmts) {
            this.srcStmts.add(stmt.toString());
        }
    }
    
    public InterAppApiCall getApiCall() {
        return apiCall;
    }

    public void setApiCall(InterAppApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public InfoKind getSrcKind() {
        return srcKind;
    }

    public void setSrcKind(InfoKind srcKind) {
        this.srcKind = srcKind;
    }

    public Collection<String> getSrcStmts() {
        return srcStmts;
    }

    public void setSrcStmt(Set<String> srcStmts) {
        this.srcStmts = srcStmts;
    }

    public ResolvedIntent getIntent() {
        return intent;
    }

    public void setIntent(ResolvedIntent intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        return "SourceFlow [srcKind=" + srcKind + ", srcStmts=" + srcStmts + ", intent=" + intent
                + ", apiCall=" + apiCall + "]";
    }
    
    
}
