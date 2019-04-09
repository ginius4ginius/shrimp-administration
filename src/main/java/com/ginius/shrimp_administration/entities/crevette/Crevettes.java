//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2019.04.06 � 05:08:04 AM CEST 
//

package com.ginius.shrimp_administration.entities.crevette;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Classe Java pour anonymous complex type.
 * 
 * <p>
 * Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette
 * classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;sequence>
 *           &lt;element name="crevette">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="categorie" type="{}simpleTypeCharacter1a20"/>
 *                     &lt;element name="sousCategorie" type="{}simpleTypeCharacter1a20"/>
 *                     &lt;element name="nom" type="{}simpleTypeCharacter1a20"/>
 *                     &lt;element name="ghMin" type="{}simpleTypeNumeric1a2"/>
 *                     &lt;element name="ghMax" type="{}simpleTypeNumeric1a2"/>
 *                     &lt;element name="khMin" type="{}simpleTypeNumeric1a2"/>
 *                     &lt;element name="khMax" type="{}simpleTypeNumeric1a2"/>
 *                     &lt;element name="phMin" type="{}simpleTypeDecimal1a2"/>
 *                     &lt;element name="phMax" type="{}simpleTypeDecimal1a2"/>
 *                     &lt;element name="temperature" type="{}simpleTypeNumeric1a2"/>
 *                     &lt;element name="description" type="{}simpleTypeCharacter1a2000" minOccurs="0"/>
 *                     &lt;element name="image" type="{}simpleTypeCharacter1a2000" minOccurs="0"/>
 *                     &lt;element name="possede" type="{}simpleTypeNumeric1"/>
 *                   &lt;/sequence>
 *                   &lt;attribute name="CrevetteID" type="{}simpleTypeId" />
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "crevette" })
@XmlRootElement(name = "crevettes")
public class Crevettes {

	protected List<Crevettes.Crevette> crevette;

	/**
	 * Gets the value of the crevette property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the crevette property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCrevette().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Crevettes.Crevette }
	 * 
	 * 
	 */
	public List<Crevettes.Crevette> getCrevette() {
		if (crevette == null) {
			crevette = new ArrayList<Crevettes.Crevette>();
		}
		return this.crevette;
	}

	/**
	 * <p>
	 * Classe Java pour anonymous complex type.
	 * 
	 * <p>
	 * Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette
	 * classe.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="categorie" type="{}simpleTypeCharacter1a20"/>
	 *         &lt;element name="sousCategorie" type="{}simpleTypeCharacter1a20"/>
	 *         &lt;element name="nom" type="{}simpleTypeCharacter1a20"/>
	 *         &lt;element name="ghMin" type="{}simpleTypeNumeric1a2"/>
	 *         &lt;element name="ghMax" type="{}simpleTypeNumeric1a2"/>
	 *         &lt;element name="khMin" type="{}simpleTypeNumeric1a2"/>
	 *         &lt;element name="khMax" type="{}simpleTypeNumeric1a2"/>
	 *         &lt;element name="phMin" type="{}simpleTypeDecimal1a2"/>
	 *         &lt;element name="phMax" type="{}simpleTypeDecimal1a2"/>
	 *         &lt;element name="temperature" type="{}simpleTypeNumeric1a2"/>
	 *         &lt;element name="description" type="{}simpleTypeCharacter1a2000" minOccurs="0"/>
	 *         &lt;element name="image" type="{}simpleTypeCharacter1a2000" minOccurs="0"/>
	 *         &lt;element name="possede" type="{}simpleTypeNumeric1"/>
	 *       &lt;/sequence>
	 *       &lt;attribute name="CrevetteID" type="{}simpleTypeId" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "categorie", "sousCategorie", "nom", "ghMin", "ghMax", "khMin", "khMax", "phMin",
			"phMax", "temperature", "description","image", "possede" })
	public static class Crevette {

		@XmlElement(required = true)
		protected String categorie;
		@XmlElement(required = true)
		protected String sousCategorie;
		@XmlElement(required = true)
		protected String nom;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeint")
		protected int ghMin;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeint")
		protected int ghMax;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeint")
		protected int khMin;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeint")
		protected int khMax;
		@XmlElement(required = true)
		protected double phMin;
		@XmlElement(required = true)
		protected double phMax;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeint")
		protected int temperature;
		protected String description;
		@XmlElement(required = true)
		@XmlSchemaType(name = "nonNegativeint")
		protected int possede;
		@XmlAttribute(name = "CrevetteID")
		protected int crevetteID;
		protected String image;

		public Crevette(String categorie, String sousCategorie, String nom, int ghMin, int ghMax, int khMin, int khMax,
				double phMin, double phMax, int temperature, int crevetteID, String description, int possede, String image) {
			super();
			this.categorie = categorie;
			this.sousCategorie = sousCategorie;
			this.nom = nom;
			this.ghMin = ghMin;
			this.ghMax = ghMax;
			this.khMin = khMin;
			this.khMax = khMax;
			this.phMin = phMin;
			this.phMax = phMax;
			this.temperature = temperature;
			this.crevetteID = crevetteID;
			this.description = description;
			this.possede = possede;
			this.image = image;
		}

		public Crevette() {
		}

		/**
		 * Obtient la valeur de la propri�t� categorie.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCategorie() {
			return categorie;
		}

		/**
		 * D�finit la valeur de la propri�t� categorie.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setCategorie(String value) {
			this.categorie = value;
		}

		/**
		 * Obtient la valeur de la propri�t� sousCategorie.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getSousCategorie() {
			return sousCategorie;
		}

		/**
		 * D�finit la valeur de la propri�t� sousCategorie.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setSousCategorie(String value) {
			this.sousCategorie = value;
		}

		/**
		 * Obtient la valeur de la propri�t� nom.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNom() {
			return nom;
		}

		/**
		 * D�finit la valeur de la propri�t� nom.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setNom(String value) {
			this.nom = value;
		}

		/**
		 * Obtient la valeur de la propri�t� ghMin.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public int getGhMin() {
			return ghMin;
		}

		/**
		 * D�finit la valeur de la propri�t� ghMin.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setGhMin(int value) {
			this.ghMin = value;
		}

		/**
		 * Obtient la valeur de la propri�t� ghMax.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public int getGhMax() {
			return ghMax;
		}

		/**
		 * D�finit la valeur de la propri�t� ghMax.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setGhMax(int value) {
			this.ghMax = value;
		}

		/**
		 * Obtient la valeur de la propri�t� khMin.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public int getKhMin() {
			return khMin;
		}

		/**
		 * D�finit la valeur de la propri�t� khMin.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setKhMin(int value) {
			this.khMin = value;
		}

		/**
		 * Obtient la valeur de la propri�t� khMax.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public int getKhMax() {
			return khMax;
		}

		/**
		 * D�finit la valeur de la propri�t� khMax.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setKhMax(int value) {
			this.khMax = value;
		}

		/**
		 * Obtient la valeur de la propri�t� phMin.
		 * 
		 * @return possible object is {@link double }
		 * 
		 */
		public double getPhMin() {
			return phMin;
		}

		/**
		 * D�finit la valeur de la propri�t� phMin.
		 * 
		 * @param value allowed object is {@link double }
		 * 
		 */
		public void setPhMin(double value) {
			this.phMin = value;
		}

		/**
		 * Obtient la valeur de la propri�t� phMax.
		 * 
		 * @return possible object is {@link double }
		 * 
		 */
		public double getPhMax() {
			return phMax;
		}

		/**
		 * D�finit la valeur de la propri�t� phMax.
		 * 
		 * @param value allowed object is {@link double }
		 * 
		 */
		public void setPhMax(double value) {
			this.phMax = value;
		}

		/**
		 * Obtient la valeur de la propri�t� temperature.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public int getTemperature() {
			return temperature;
		}

		/**
		 * D�finit la valeur de la propri�t� temperature.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setTemperature(int value) {
			this.temperature = value;
		}

		/**
		 * Obtient la valeur de la propri�t� description.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * D�finit la valeur de la propri�t� description.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setDescription(String value) {
			this.description = value;
		}

		/**
		 * Obtient la valeur de la propri�t� possede.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public int getPossede() {
			return possede;
		}

		/**
		 * D�finit la valeur de la propri�t� possede.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setPossede(int value) {
			this.possede = value;
		}

		/**
		 * Obtient la valeur de la propri�t� crevetteID.
		 * 
		 * @return possible object is {@link double }
		 * 
		 */
		public int getCrevetteID() {
			return crevetteID;
		}

		/**
		 * D�finit la valeur de la propri�t� crevetteID.
		 * 
		 * @param value allowed object is {@link double }
		 * 
		 */
		public void setCrevetteID(int value) {
			this.crevetteID = value;
		}
		
		/**
		 * Obtient la valeur de la propri�t� image.
		 * 
		 * @return possible object is {@link int }
		 * 
		 */
		public String getImage() {
			return image;
		}

		/**
		 * D�finit la valeur de la propri�t� image.
		 * 
		 * @param value allowed object is {@link int }
		 * 
		 */
		public void setImage(String value) {
			this.image = value;
		}

		@Override
		public String toString() {
			return categorie + " " + sousCategorie + " - " + nom;
		}
		
		
	}

}
