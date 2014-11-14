package droidsafe.analyses.value;

public class UnresolvedIntent extends IntentModel {

    private static UnresolvedIntent singleton = new UnresolvedIntent();
    
    private UnresolvedIntent() {    
    }
    
    public static UnresolvedIntent v() {
        return singleton;
    }
    

    public boolean isResolved() {
        return false;
    }
}
