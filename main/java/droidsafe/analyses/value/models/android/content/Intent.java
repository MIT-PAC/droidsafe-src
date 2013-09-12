import droidsafe.analyses.value.RefVAModel;
import droidsafe.analyses.value.models.java.lang.String;
import droidsafe.analyses.value.models.android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public class Intent extends RefVAModel {
    
    public Set<String> mAction = new HashSet<String>();
}
