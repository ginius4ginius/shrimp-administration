//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2019.03.01 � 05:11:32 AM CET 
//

package com.ginius.shrimp_administration.entities.crevette;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "crevette" })
@XmlRootElement(name = "crevettes")
public class Crevettes {

	protected List<Crevettes.Crevette> crevette;

	public List<Crevettes.Crevette> getCrevette() {
		if (crevette == null) {
			crevette = new ArrayList<Crevettes.Crevette>();
		}
		return this.crevette;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "variete", "nom", "ghMin", "ghMax", "khMin", "khMax", "phMin", "phMax",
			"temperature" })
	public static class Crevette {

		@XmlElement(required = true)
		protected String variete;
		@XmlElement(required = true)
		protected String nom;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int ghMin;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int ghMax;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int khMin;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int khMax;
		@XmlElement(required = true)
		protected double phMin;
		@XmlElement(required = true)
		protected double phMax;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int temperature;
		@XmlAttribute(name = "CrevetteID")
		protected int crevetteID;

		public Crevette() {
			super();
		}

		public Crevette(String variete, String nom, int ghMin, int ghMax, int khMin, int khMax, double phMin,
				double phMax, int temperature, int crevetteID) {
			super();
			this.variete = variete;
			this.nom = nom;
			this.ghMin = ghMin;
			this.ghMax = ghMax;
			this.khMin = khMin;
			this.khMax = khMax;
			this.phMin = phMin;
			this.phMax = phMax;
			this.temperature = temperature;
			this.crevetteID = crevetteID;
		}

		public String getVariete() {
			return variete;
		}

		public void setVariete(String value) {
			this.variete = value;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String value) {
			this.nom = value;
		}

		public int getGhMin() {
			return ghMin;
		}

		public void setGhMin(int value) {
			this.ghMin = value;
		}

		public int getGhMax() {
			return ghMax;
		}

		public void setGhMax(int value) {
			this.ghMax = value;
		}

		public int getKhMin() {
			return khMin;
		}

		public void setKhMin(int value) {
			this.khMin = value;
		}

		public int getKhMax() {
			return khMax;
		}

		public void setKhMax(int value) {
			this.khMax = value;
		}

		public double getPhMin() {
			return phMin;
		}

		public void setPhMin(double value) {
			this.phMin = value;
		}

		public double getPhMax() {
			return phMax;
		}

		public void setPhMax(double value) {
			this.phMax = value;
		}

		public int getTemperature() {
			return temperature;
		}

		public void setTemperature(int value) {
			this.temperature = value;
		}

		public int getCrevetteID() {
			return crevetteID;
		}

		public void setCrevetteID(int i) {
			this.crevetteID = i;
		}

	}

}
