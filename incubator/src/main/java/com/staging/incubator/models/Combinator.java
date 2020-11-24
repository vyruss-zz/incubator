package com.staging.incubator.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Combinator implements Serializable {

	@Column(name = "parent_one_id")
	private int parentOneId;
//	
	@Column(name = "parent_two_id")
	private int parentTwoId;
	
}
