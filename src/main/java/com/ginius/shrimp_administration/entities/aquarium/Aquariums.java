//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2019.03.01 � 06:41:14 AM CET 
//

package com.ginius.shrimp_administration.entities.aquarium;

import java.math.BigDecimal;
import java.math.BigInteger;
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
@XmlType(name = "", propOrder = { "aquarium" })
@XmlRootElement(name = "aquariums")
public class Aquariums {

	protected List<Aquariums.Aquarium> aquarium;

	public List<Aquariums.Aquarium> getAquarium() {
		if (aquarium == null) {
			aquarium = new ArrayList<Aquariums.Aquarium>();
		}
		return this.aquarium;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "longueur", "largeur", "hauteur", "litrageBrut", "litrageNet", "substratID",
			"eauID", "filtrationID", "eclairageID", "crevettes" })
	public static class Aquarium {

		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int longueur;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int largeur;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeInteger")
		protected int hauteur;
		@XmlElement(required = true)
		protected double litrageBrut;
		@XmlElement(required = true)
		protected double litrageNet;
		@XmlElement(required = true)
		protected double substratID;
		@XmlElement(required = true)
		protected double eauID;
		@XmlElement(required = true)
		protected double filtrationID;
		@XmlElement(required = true)
		protected double eclairageID;
		@XmlElement(required = true)
		protected Aquariums.Aquarium.Crevettes crevettes;
		@XmlAttribute(name = "AquariumID")
		protected double aquariumID;

		public int getLongueur() {
			return longueur;
		}

		public void setLongueur(int value) {
			this.longueur = value;
		}

		public int getLargeur() {
			return largeur;
		}

		public void setLargeur(int value) {
			this.largeur = value;
		}

		public int getHauteur() {
			return hauteur;
		}

		public void setHauteur(int value) {
			this.hauteur = value;
		}

		public double getLitrageBrut() {
			return litrageBrut;
		}

		public void setLitrageBrut(double value) {
			this.litrageBrut = value;
		}

		public double getLitrageNet() {
			return litrageNet;
		}

		public void setLitrageNet(double value) {
			this.litrageNet = value;
		}

		public double getSubstratID() {
			return substratID;
		}

		public void setSubstratID(double value) {
			this.substratID = value;
		}

		public double getEauID() {
			return eauID;
		}

		public void setEauID(double value) {
			this.eauID = value;
		}

		public double getFiltrationID() {
			return filtrationID;
		}

		public void setFiltrationID(double value) {
			this.filtrationID = value;
		}

		public double getEclairageID() {
			return eclairageID;
		}

		public void setEclairageID(double value) {
			this.eclairageID = value;
		}

		public Aquariums.Aquarium.Crevettes getCrevettes() {
			return crevettes;
		}

		public void setCrevettes(Aquariums.Aquarium.Crevettes value) {
			this.crevettes = value;
		}

		public double getAquariumID() {
			return aquariumID;
		}

		public void setAquariumID(double value) {
			this.aquariumID = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "crevetteID" })
		public static class Crevettes {

			protected List<BigDecimal> crevetteID;

			public List<BigDecimal> getCrevetteID() {
				if (crevetteID == null) {
					crevetteID = new ArrayList<BigDecimal>();
				}
				return this.crevetteID;
			}

		}

	}

}
