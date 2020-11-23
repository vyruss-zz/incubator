package com.staging.incubator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="elements_table")
public class Element {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="element_id")
	private int elementId;
	
	@Column(name="description", nullable=false)
	private String description;
	@Column(name="color", nullable=false,length=7)
	private String color;
	@Column(name="parent_one")
	private Element parentOne;
	@Column(name = "parent_two")
	private Element parentTwo;
	
	
}
