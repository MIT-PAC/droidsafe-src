package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RadioState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.eclipse.plugin.core.specmodel.MethodModel;
import droidsafe.eclipse.plugin.core.specmodel.TreeElement;
import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;
import droidsafe.utils.SourceLocationTag;

public class SortOutlineView extends AbstractHandler {
  private static final Logger logger = LoggerFactory.getLogger(SortOutlineView.class);

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (!HandlerUtil.matchesRadioState(event)) {
      IWorkbenchPart part = HandlerUtil.getActivePart(event);
      if (part instanceof SecuritySpecOutlineViewPart) {
        SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;

        String currentState = event.getParameter(RadioState.PARAMETER_ID);
        // perform task for current state
        if (currentState.equals("method")) {
          // sort entries by method name.
          droidsafeView.sortViewByMethodName();
        } else if (currentState.equals("class")) {
          // sort entries by class name
          droidsafeView.sortViewByClassName();
        }
        // and finally update the current state
        HandlerUtil.updateRadioState(event.getCommand(), currentState);
      }
    }
    return null;
  }

}
