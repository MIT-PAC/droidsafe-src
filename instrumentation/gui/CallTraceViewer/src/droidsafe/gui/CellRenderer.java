/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Nguyen Nguyen
 */
public class CellRenderer extends DefaultTreeCellRenderer  {

    Color color1 = Color.ORANGE;
    Color specColor = Color.ORANGE;
    
    static Font defaultFont = new Font("Courier New", Font.PLAIN, 14);
    static Font specFont = new Font("Courier New", Font.BOLD, 15);
    
    public CellRenderer() {
        super();        
        
        setFont(defaultFont);  
        this.setForeground(specColor);
        
    }

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        
        
        super.getTreeCellRendererComponent(
                tree, value, sel,
                expanded, leaf, row,
                hasFocus);               
        
        
        // No when selection is active
        if (sel)
            return this;
        
        setFont(defaultFont);
        setForeground(Color.BLACK);
        
        if (value instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
            Object obj = node.getUserObject();            
            if (obj instanceof CallNode) {
                CallNode callNode = (CallNode)obj;                
                if ((callNode.data instanceof TraceLine) && callNode.isLeaf()) {                
                    TraceLine traceLine = (TraceLine)callNode.data;
                    if (ApiClassifier.v().isSpec(traceLine.methodSignature) ||
                        ApiClassifier.v().isBan(traceLine.methodSignature) ||
                        ApiClassifier.v().isSink(traceLine.methodSignature)){
                        setForeground(Color.decode("#F02060"));
                        setFont(specFont);
                    }
                }
            }                    
        }
        this.setBackground(specColor);
        return this;
    }

}
