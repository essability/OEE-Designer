package org.point85.app.opc.ua;

import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceDescription;

public class OpcUaTreeNode {
	private ExpandedNodeId nodeDataType;
	private boolean browsed = false;

	private ReferenceDescription referenceDescription;

	public OpcUaTreeNode(ReferenceDescription referenceDescription) {
		this.referenceDescription = referenceDescription;
	}

	public ReferenceDescription getReferenceDescription() {
		return referenceDescription;
	}

	public void setReferenceDescription(ReferenceDescription referenceDescription) {
		this.referenceDescription = referenceDescription;
	}

	public NodeClass getNodeClass() {
		return referenceDescription.getNodeClass();
	}

	public NodeId getNodeId(NamespaceTable nst) {
		return referenceDescription.getNodeId().toNodeId(nst).orElse(null);
	}

	public String getBrowseName() {
		return referenceDescription.getBrowseName().getName();
	}

	public String getDisplayName() {
		return referenceDescription.getDisplayName().getText();
	}

	@Override
	public String toString() {
		return getDisplayName();
	}

	public boolean isBrowsed() {
		return browsed;
	}

	public void setBrowsed(boolean browsed) {
		this.browsed = browsed;
	}

	public ExpandedNodeId getNodeDataType() {
		return nodeDataType;
	}

	public void setNodeDataType(ExpandedNodeId nodeDataType) {
		this.nodeDataType = nodeDataType;
	}
}
