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

package droidsafe.eclipse.plugin.core.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import droidsafe.eclipse.plugin.core.view.indicator.Utils;

/**
 * Represents a boolean predicate that is used to filter the viewable contents of an indicator.
 * Currently only predicates of forms
 * 
 *   AND <boolean clauses>, and
 *   OR <boolean clauses>
 *   
 *     where each boolean clause is of form
 *     
 *       <field> <comparison op> <value>
 *   
 * are supported.
 * 
 * @author gilham
 *
 */
public class FilterPred {

    /**
     * The boolean operator to apply to the boolean clauses, default value is 'AND'.
     */
    private BoolOp boolOp = BoolOp.AND;
    
    /**
     * The boolean clauses, each clause is of form
     *   <field> <CompareOp> <value>
     */
    private List<FilterPredClause> clauses = new ArrayList<FilterPredClause>();
    
    /**
     * Constructs a FilterPred with the given boolean operator and the given list
     * of boolean clauses.
     * 
     * @param boolOp - the boolean op
     * @param clauses - the list of boolean clauses
     */
    public FilterPred(BoolOp boolOp, List<FilterPredClause> clauses) {
        this.boolOp = boolOp;
        this.clauses = clauses;
    }

    /**
     * Constructs a FilterPred by copying the boolean operator and the clauses from the 
     * given FilterPred.
     * 
     * @param boolOp - the boolean op
     * @param clauses - the list of boolean clauses
     */
    public FilterPred(FilterPred pred) {
        this.boolOp = pred.getBoolOp();
        for (FilterPredClause clause: pred.getClauses()) {
            this.clauses.add(new FilterPredClause(clause));
        }
    }

    /**
     * Constructs a FilterPred with a single boolean clause.
     * 
     * @param clause - the single boolean clause
     */
    public FilterPred(FilterPredClause clause) {
        clauses.add(clause);
    }

    /**
     * Returns the boolean operator for this FilterPred.
     * 
     * @return the boolean operator
     */
    public BoolOp getBoolOp() {
        return boolOp;
    }

    /**
     * Return the boolean clauses for this FilterPred.
     * 
     * @return the boolean clauses
     */
    public List<FilterPredClause> getClauses() {
        return clauses;
    }

    /**
     * Apply this FilterPred to the given JsonElement and return the
     * resulting boolean value.
     * 
     * @param jsonElt - the JsonElement to apply the FilterPred
     * @return the resulting boolean value
     */
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
    
    /**
     * Returns the string representation of this FilterPred.
     */
    @Override
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

    /**
     * Given a JsonElement that represents a filter predicate and a set of filter field names, parses this JsonElement
     * into a FilterPred and returns the result.
     * 
     * @param filterElt - a JsonElement that represents a filter predicate
     * @param filterFields - a set of filter fields used to check the validity of the fields in the filterElt
     * @return the resulting FilterPred
     * @throws FilterParseException
     */
    public static FilterPred parse(JsonElement filterElt, Set<String> filterFields) throws FilterParseException {
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
        throw new FilterParseException("Missing predicate property \"pred\", \"conjuncts\", or \"disjuncts\" in\n" + filterElt);
    }

    /**
     * Given a JsonArray that represents the boolean filter clauses and a set of filter field names, parses 
     * the JsonArray into a list of FilterPredClauses and returns the result.
     * 
     * @param clauseArr - a JsonArray that represents the filter predicate clauses
     * @param filterFields - a set of filter fields used to check the validity of the fields contained in the clause array
     * @return the resulting list of FilterPredClauses
     * @throws FilterParseException
     */
    private static List<FilterPredClause> parsePredClauses(JsonArray clauseArr, Set<String> filterFields) throws FilterParseException {
        List<FilterPredClause> result = new ArrayList<FilterPredClause>();
        for (int i = 0; i < clauseArr.size(); i++) {
            FilterPredClause clause = FilterPredClause.parse(clauseArr.get(i), filterFields);
            result.add(clause);
        }
        return result;
    }
}
