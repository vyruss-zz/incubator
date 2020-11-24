package com.staging.incubator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "elements_table")
@EqualsAndHashCode(exclude = {"parentOne", "parentTwo"})
@IdClass(Combinator.class)
public class Element {

//	@EmbeddedId
//	@JoinColumns({ @JoinColumn(name = "parent_one_id", referencedColumnName="parent_one_id"),
//			@JoinColumn(name = "parent_two_id", referencedColumnName="parent_two_id") })
//	private Combinator combi;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "element_id")
	private Integer elementId;

	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "color", nullable = false, length = 7)
	private String color;

	@Id
	@OneToOne(mappedBy = "parent_one_id")
	@MapsId("parentOneId")
	@JoinColumn(name = "parent_one_id")
	private int parentOneId;

	@Id
	@OneToOne(mappedBy = "parent_two_id")
	@MapsId("parentTwoId")
	@JoinColumn(name = "parent_two_id")
	private int parentTwoId;

	@OneToOne
	@JoinColumn(name = "parentOneId", nullable = true)
	@JsonBackReference(value = "parentOne")
	private Element parentOne;
	@OneToOne
	@JoinColumn(name = "parentTwoId", nullable = true)
	@JsonBackReference(value = "parentTwo")
	private Element parentTwo;

	@Override
	public String toString() {
		return "Element [elementId=" + elementId + ", description=" + description + ", color=" + color + "]";
	}

}
