package com.epsi.lib;

public class Utilisateur {
	private int id;
	private String name;
	private String mdp;
	
	/**
	 * 
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param mdp
	 */
	public Utilisateur(int id, String name, String mdp) {
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
