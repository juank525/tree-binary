package com.motechnologies.treebinary.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.motechnologies.treebinary.exceptions.TreeException;
import com.motechnologies.treebinary.model.Node;
import com.motechnologies.treebinary.model.TreeRequest;
import com.motechnologies.treebinary.service.impl.TreeBinaryServiceImpl;

public class TreeBinaryServiceImplTest {

	@InjectMocks
	TreeBinaryServiceImpl treeBinaryServiceImpl;

	Integer nodesArray[] = new Integer[] { 39, 28, 44, 29, 76, 74, 85, 83, 87 };
	Integer root = 67;
	TreeRequest treeRequest = null;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);

		treeRequest = TreeRequest.builder().root(root).nodes(Arrays.asList(nodesArray)).build();
	}

	@Test
	void createTreeTest() {
		Node tree = treeBinaryServiceImpl.createTree(treeRequest);
		assertNotNull(tree);
	}

	@Test
	void getLowestCommonAncestorTest() {
		treeBinaryServiceImpl.createTree(treeRequest);
		assertEquals(Node.builder().value(39).build(), treeBinaryServiceImpl.getLowestCommonAncestor(29, 44));
		assertEquals(Node.builder().value(67).build(), treeBinaryServiceImpl.getLowestCommonAncestor(44, 85));
		assertEquals(Node.builder().value(85).build(), treeBinaryServiceImpl.getLowestCommonAncestor(83, 87));

	}

	@Test
	void commonAncestorExceptionNotExistNodeTest() {
		treeBinaryServiceImpl.createTree(treeRequest);
		assertThrows(TreeException.class, () -> {
			treeBinaryServiceImpl.getLowestCommonAncestor(100, 44);
		});

	}

	@Test
	void commonAncestorExceptionRootTest() {
		treeBinaryServiceImpl.createTree(treeRequest);
		assertThrows(TreeException.class, () -> {
			treeBinaryServiceImpl.getLowestCommonAncestor(root, 44);
		});

	}

}
