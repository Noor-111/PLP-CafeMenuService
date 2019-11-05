package com.cg.CafeDetails.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Data
//@EqualsAndHashCode(exclude = "menus")

@Entity
@Table(name = "cafedetails")
//@SequenceGenerator(name = "cafeseq", sequenceName = "cafedetails_seq", initialValue = 100, allocationSize = 1)
public class CafeDetails {

	@Id
	//@GeneratedValue(generator = "cafeseq")
	private int cafeId;
	private String cafeLocation;
	private double cafeRating;
	
	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
	@JoinTable(
			name = "detailandmenu", 
			joinColumns = @JoinColumn(referencedColumnName = "cafeId"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "itemId"))
	Set<CafeMenu> menus = new HashSet<CafeMenu>();

	public CafeDetails() {
	}
	
	public CafeDetails(int cafeId, String cafeLocation, double cafeRating, Set<CafeMenu> menus) {
		super();
		this.cafeId = cafeId;
		this.cafeLocation = cafeLocation;
		this.cafeRating = cafeRating;
		this.menus= menus;
//		this.menus = Stream.of(menus).collect(Collectors.toSet());
//		this.menus.forEach(x -> x.getDetails().add(this));
//		
//		for (CafeMenu menu: menus) 
//			System.out.println(menu.getItemName());
	}

	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeLocation() {
		return cafeLocation;
	}

	public void setCafeLocation(String cafeLocation) {
		this.cafeLocation = cafeLocation;
	}

	public double getCafeRating() {
		return cafeRating;
	}

	public void setCafeRating(double cafeRating) {
		this.cafeRating = cafeRating;
	}

	public Set<CafeMenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<CafeMenu> menus) {
		this.menus = menus;
	}
	
	
}
