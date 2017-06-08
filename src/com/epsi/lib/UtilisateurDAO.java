package com.epsi.lib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
public class UtilisateurDAO implements Serializable {

	private static final long serialVersionUID = 7710122618006840191L;
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="mdp")
	private String mdp;
	
	/**
	 * 
	 */
	public UtilisateurDAO() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param mdp
	 */
	public UtilisateurDAO(int id, String name, String mdp) {
		super();
		this.id = id;
		this.name = name;
		this.mdp = mdp;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
