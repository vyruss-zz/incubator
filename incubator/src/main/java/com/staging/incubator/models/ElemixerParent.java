package com.staging.incubator.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="parent_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElemixerParent {

	@Id
	@Column(name="combination_id")
	private int combinationId;
	
//	@OneToMany(mappedBy="parentOne")
//	@JoinColumn(name="element_id")
//	@JsonManagedReference(value="parentOne")
//	private Element parentOne;
//	
//	@OneToOne(mappedBy="parentTwo")
//	@JoinColumn(name="element_id")
//	@JsonManagedReference(value="parentTwo")
//	private Element parentTwo;
//	
//	@OneToOne(mappedBy="elementId")
//	private Element child;
	
	/*@OneToOne(mappedBy="")
	@JoinColumn(name="")
	private List<Element> family;*/
}
