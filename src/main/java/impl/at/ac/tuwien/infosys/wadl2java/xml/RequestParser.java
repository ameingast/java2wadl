package at.ac.tuwien.infosys.wadl2java.xml;

import org.w3c.dom.Node;

import at.ac.tuwien.infosys.java2wadl.WadlException;
import at.ac.tuwien.infosys.java2wadl.util.XmlUtil;
import at.ac.tuwien.infosys.java2wadl.wadl.IRequest;
import at.ac.tuwien.infosys.java2wadl.wadl.Request;

public class RequestParser {
	public IRequest parse(Node node) throws WadlException {
		final IRequest request = new Request();

		parseRepresentations(node, request);
		parseParams(node, request);
		return request;
	}

	private void parseParams(Node node, final IRequest request) throws WadlException {
		for (Node paramNode : XmlUtil.getChildNodes(node, "param")) {
			request.addParam(new ParamParser().parse(paramNode));
		}
	}

	private void parseRepresentations(Node node, final IRequest request) throws WadlException {
		for (Node representationNode : XmlUtil.getChildNodes(node, "representation")) {
			request.addRepresentation(new RepresentationParser().parse(representationNode));
		}
	}
}
