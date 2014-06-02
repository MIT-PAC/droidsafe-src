package droidsafe.eclipse.plugin.core.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;

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

    public static FilterPred parse(JsonElement filterElt, Set<String> filterFields) throws FilterException {
        JsonElement predElt = Utils.getFieldValue(filterElt, "pred");
        if (predElt != null) {
            FilterPredClause clause = FilterPredClause.parse(predElt, filterFields);
            if (clause != null)
                return new FilterPred(clause);
        } else {
            JsonArray conjuncts = Utils.getFieldValueAsArray(filterElt, "conjuncts");
            if (conjuncts != null) {
                List<FilterPredClause> clauses = parsePredClauses(conjuncts, filterFields);
                return new FilterPred(BoolOp.AND, clauses);
            } else {
                JsonArray disjuncts = Utils.getFieldValueAsArray(filterElt, "disjuncts");
                if (disjuncts != null) {
                    List<FilterPredClause> clauses = parsePredClauses(disjuncts, filterFields);
                    return new FilterPred(BoolOp.OR, clauses);
                }
            }
        }
        throw new FilterException("Missing predicate property \"pred\", \"conjuncts\", or \"disjuncts\" in\n" + filterElt);
    }

    private static List<FilterPredClause> parsePredClauses(JsonArray clauseArr, Set<String> filterFields) throws FilterException {
        List<FilterPredClause> result = new ArrayList<FilterPredClause>();
        for (int i = 0; i < clauseArr.size(); i++) {
            FilterPredClause clause = FilterPredClause.parse(clauseArr.get(i), filterFields);
            result.add(clause);
        }
        return result;
    }
}
