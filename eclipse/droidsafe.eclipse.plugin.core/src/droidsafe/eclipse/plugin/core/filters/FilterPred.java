package droidsafe.eclipse.plugin.core.filters;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;

public class FilterPred {

    private BoolOp boolOp = BoolOp.AND;
    private List<FilterPredClause> clauses = new ArrayList<FilterPredClause>();
    
    public FilterPred(BoolOp boolOp, List<FilterPredClause> clauses) {
        this.boolOp = boolOp;
        this.clauses = clauses;
    }

    public FilterPred(FilterPred pred) {
        this.boolOp = pred.getBoolOp();
        for (FilterPredClause clause: pred.getClauses()) {
            this.clauses.add(new FilterPredClause(clause));
        }
    }

    public FilterPred(FilterPredClause clause) {
        clauses.add(clause);
    }

    public BoolOp getBoolOp() {
        return boolOp;
    }

    public List<FilterPredClause> getClauses() {
        return clauses;
    }

    public boolean apply(JsonElement jsonElt) {
        boolean result = (boolOp == BoolOp.AND) ? true : false;
        for (FilterPredClause clause: clauses) {
            boolean satisfied = clause.apply(jsonElt);
            switch (boolOp) {
                case AND: 
                    result = result && satisfied;
                    if (!result) return false;
                    break;
                default:
                    result = result || satisfied;
                    if (result) return true;
            }
        }
        return result;
    }
    
    public String toString() {
        StringBuffer buf = new StringBuffer();
        boolean first = true;
        for (FilterPredClause clause: clauses) {
            if (first)
                first = false;
            else {
                buf.append(' ');
                buf.append(boolOp);
                buf.append(' ');
            }
            buf.append(clause);
        }
        return buf.toString();
    }
}
