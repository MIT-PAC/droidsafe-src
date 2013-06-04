package droidsafe.analyses.attr.models.android.net;

import droidsafe.analyses.attr.AttrModeledClass;

import droidsafe.analyses.attr.AttrModelingSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public abstract class Uri extends AttrModeledClass {

    public Uri(){}

    public Uri(AllocNode allocNode) {
        super(allocNode);
    }

    @Override
    public String dsDisplay(){
        String str = "<modeled Uri" + this.getId() + "> {";
        if (this.invalidated) {
            str += "invalidated";
        } else {

        }
        return str + "}";
    }

    public abstract static class AbstractHierarchicalUri extends Uri {

        public AbstractHierarchicalUri() {}

        public AbstractHierarchicalUri(AllocNode allocNode){
            super(allocNode);
        }
    }

    public static class HierarchicalUri extends AbstractHierarchicalUri {

        public HierarchicalUri(AllocNode allocNode) {
            super(allocNode);
        }

        @Override
        public String dsDisplay(){
            String str = "<modeled HierarchicalUri" + this.getId() + "> {";
            if (this.invalidated) {
                str += "invalidated";
            } else {
            }
            return str + "}";
        }
    }

    public static class StringUri extends AbstractHierarchicalUri {

        /** URI string representation. */
        private Set<String> uriString;

        public StringUri(AllocNode allocNode) {
            super(allocNode);
        }

        public StringUri(Set<String> uriString) {
            this.uriString.addAll(uriString);
        }

        public void _init_(Set<String> uriString){
            this.uriString.addAll(uriString);
        }

        public Set<String> dsToString() {
            return this.uriString;
        }

        @Override
        public String dsDisplay(){
            String str = "<modeled StringUri" + this.getId() + "> {";
            if (this.invalidated) {
                str += "invalidated";
            } else {
                if(this.uriString != null)
                    str += "uriString: " + this.uriString; 
            }
            return str + "}";
        }
    }
}
