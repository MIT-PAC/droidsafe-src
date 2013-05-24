package droidsafe.eclipse.plugin.core.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import droidsafe.eclipse.plugin.core.view.SecuritySpecOutlineViewPart;

public class SetCodeLocationAsTopParents extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchPart part = HandlerUtil.getActivePart(event);
    if (part instanceof SecuritySpecOutlineViewPart) {
      SecuritySpecOutlineViewPart droidsafeView = (SecuritySpecOutlineViewPart) part;
      droidsafeView.setCodeLocationAsViewTopLevelParents();
    }
    return null;
  }

}
