package com.motechnologies.treebinary.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeRequest {
	private Integer root;
	private List<Integer> nodes;
}
