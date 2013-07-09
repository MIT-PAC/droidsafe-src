package droidsafe.analyses.value.models.droidsafe.helpers;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.models.android.content.Intent;
import droidsafe.analyses.value.models.android.net.Uri;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DSUtils extends ValueAnalysisModeledObject {
/*
    public static void translateIntent(Intent request, Intent result){
        result.setAction(request.getAction());
        result.setType(request.getType());
        result.setPackage(request.getPackage());

        if (request.getData() == null){
            Uri resultData = result.getData();
            Set<String> type = request.getType();
            if(resultData == null) {
                Uri uri = new Uri(type);
                
                resultAllocNode 
                
                //create field access expression
                
                Set<AllocNode> nodes = GeoPTA.v().getPTSetContextIns(field);
                
                //add to results map node->uri
                
                result.setData(new Uri(type));
            } else {
                resultData.uriString.addAll(type);
            }
        } else {
            result.setData(request.getData());
        }
    }
*/
}
