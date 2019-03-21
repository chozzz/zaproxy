package org.zaproxy.zap.extension.script;

import java.awt.event.MouseAdapter;
import java.io.Writer;
import java.util.List;

import javax.swing.TransferHandler;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeCellRenderer;

public interface ScriptUI {

	/**
	 * Called after an engine is added.
	 * <p>
	 * The UI should display the contents of the selected script if it's targeting the added engine.
	 * 
	 * @param scriptEngineWrapper the engine that was removed
	 * @since 2.4.0
	 */
	void engineAdded(ScriptEngineWrapper scriptEngineWrapper);

	/**
	 * Called after an engine is removed.
	 * <p>
	 * The UI should clear the contents of the selected script if it's targeting the removed engine.
	 * 
	 * @param scriptEngineWrapper the engine that was removed
	 * @since 2.4.0
	 */
	void engineRemoved(ScriptEngineWrapper scriptEngineWrapper);

	/**
	 * Gets the currently selected script node.
	 *
	 * @return the selected node, or {@code null} if none.
	 * @see #getSelectedNodes()
	 * @see #addSelectionListener(TreeSelectionListener)
	 */
	ScriptNode getSelectedNode();
	
	/**
	 * Gets the currently selected script nodes.
	 *
	 * @return the selected nodes, or empty list if none.
	 * @see #getSelectedNode()
	 * @see #addSelectionListener(TreeSelectionListener)
	 */
	List<ScriptNode> getSelectedNodes();

	/**
	 * Adds the given tree selection listener.
	 *
	 * @param tsl the tree selection listener to be added.
	 * @since TODO add version
	 * @see #removeSelectionListener(TreeSelectionListener)
	 * @see #getSelectedNode()
	 * @see #getSelectedNodes()
	 */
	default void addSelectionListener(TreeSelectionListener tsl) {
		// Nothing to do.
	}

	/**
	 * Removes the given tree selection listener.
	 *
	 * @param tsl the tree selection listener to remove.
	 * @since TODO add version
	 * @see #addSelectionListener(TreeSelectionListener)
	 */
	default void removeSelectionListener(TreeSelectionListener tsl) {
		// Nothing to do.
	}
	
	void addMouseListener(MouseAdapter adapter); 

	/**
	 * Removes the given mouse listener.
	 *
	 * @param mouseListener the mouse listener that will be removed.
	 * @since 2.4.0
	 */
	void removeMouseListener(MouseAdapter mouseListener); 
	
	void addRenderer(Class<?> c, TreeCellRenderer renderer);

	/**
	 * Removes the renderer added for the given class.
	 *
	 * @param klass the class whose target renderer should be removed
	 * @since 2.4.0
	 */
	void removeRenderer(Class<?> klass);

	/**
	 * Adds a transfer handler for the given class.
	 *
	 * @param klass the class in which the given transfer handler will be used
	 * @param th the transfer handler
	 * @since 2.4.0
	 */
	void addScriptTreeTransferHandler(Class<?> klass, TransferHandler th);

	/**
	 * Removes the transfer handler that was being used for the given class.
	 *
	 * @param klass the class whose targeting transfer handler will be removed
	 * @since 2.4.0
	 */
	void removeScriptTreeTransferHandler(Class<?> klass);
	
	void displayScript (ScriptWrapper script);

	boolean isScriptDisplayed(ScriptWrapper script);

	void selectNode(ScriptNode node, boolean expand);

	void disableScriptDialog(Class<?> klass);

	/**
	 * Removes a disabled script dialogue of the given class.
	 *
	 * @param klass the class that has the script dialogue disabled
	 * @since 2.4.0
	 */
	void removeDisableScriptDialog(Class<?> klass);
	
	String getTreeName();
	
	Writer getOutputWriter();
}
