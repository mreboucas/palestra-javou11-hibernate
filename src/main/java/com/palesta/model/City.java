package com.palesta.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pkcity;

	private String cep;

	private String city;

	private String codibge;

	private String type;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="fkstate")
	private State state;

	//bi-directional many-to-one association to Neighborhood
	@OneToMany(mappedBy="city")
	private List<Neighborhood> neighborhoods;

	public City() {
	}

	public Integer getPkcity() {
		return this.pkcity;
	}

	public void setPkcity(Integer pkcity) {
		this.pkcity = pkcity;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCodibge() {
		return this.codibge;
	}

	public void setCodibge(String codibge) {
		this.codibge = codibge;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Neighborhood> getNeighborhoods() {
		return this.neighborhoods;
	}

	public void setNeighborhoods(List<Neighborhood> neighborhoods) {
		this.neighborhoods = neighborhoods;
	}

	public Neighborhood addNeighborhood(Neighborhood neighborhood) {
		getNeighborhoods().add(neighborhood);
		neighborhood.setCity(this);

		return neighborhood;
	}

	public Neighborhood removeNeighborhood(Neighborhood neighborhood) {
		getNeighborhoods().remove(neighborhood);
		neighborhood.setCity(null);

		return neighborhood;
	}

}