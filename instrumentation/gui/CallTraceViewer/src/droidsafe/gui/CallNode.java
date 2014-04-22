/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Nguyen Nguyen
 */
public class CallNode {
    List<CallNode> children;
    public Object data;     
    
    public CallNode(Object nodeData) {
        data = nodeData;
        children = new LinkedList<CallNode>();       
    }
    
    public void addChild(CallNode child) {
        children.add(child);
    }
    
    public CallNode getChildAt(int ind) {
        if (ind >= 0 && ind < children.size())
            return children.get(ind);
        return null;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();        
        sb.append(String.format("[%s]", data.toString(), children.size()));
        return sb.toString();
    }
    
    @Override 
    public boolean equals(Object other) {
        if (other instanceof CallNode) {
            CallNode otherCallNode = (CallNode)other;
            return data.equals(otherCallNode.data);
        }
        return false;
    }
}
