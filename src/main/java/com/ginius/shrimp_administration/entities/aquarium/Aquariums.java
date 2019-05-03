
package com.ginius.shrimp_administration.entities.aquarium;

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
 * 
 * @author giniu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "aquarium" })
@XmlRootElement(name = "aquariums")
public class Aquariums {

	protected List<Aquariums.Aquarium> aquarium;

	public List<Aquariums.Aquarium> getAquarium() {
		if (aquarium == null) {
			aquarium = new ArrayList<>();
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
		protected int substratID;
		@XmlElement(required = true)
		protected int eauID;
		@XmlElement(required = true)
		protected int filtrationID;
		@XmlElement(required = true)
		protected int eclairageID;
		@XmlElement(required = true)
		protected Aquariums.Aquarium.Crevettes crevettes;
		@XmlAttribute(name = "AquariumID")
		protected int aquariumID;

		public Aquarium() {
			super();
		}

		/**
		 * Classe d'encapsulation des paramètres du constructeur aquarium
		 * @author giniu
		 *
		 */
		public static class DataAquarium {
			int longueur;
			int largeur;
			int hauteur;
			double litrageBrut;
			double litrageNet;
			int substratID;
			int eauID;
			int filtrationID;
			int eclairageID;
			int aquariumID;
			Crevettes crevettes;
			
			public int getLongueur() {
				return longueur;
			}
			public void setLongueur(int longueur) {
				this.longueur = longueur;
			}
			public int getLargeur() {
				return largeur;
			}
			public void setLargeur(int largeur) {
				this.largeur = largeur;
			}
			public int getHauteur() {
				return hauteur;
			}
			public void setHauteur(int hauteur) {
				this.hauteur = hauteur;
			}
			public double getLitrageBrut() {
				return litrageBrut;
			}
			public void setLitrageBrut(double litrageBrut) {
				this.litrageBrut = litrageBrut;
			}
			public double getLitrageNet() {
				return litrageNet;
			}
			public void setLitrageNet(double litrageNet) {
				this.litrageNet = litrageNet;
			}
			public int getSubstratID() {
				return substratID;
			}
			public void setSubstratID(int substratID) {
				this.substratID = substratID;
			}
			public int getEauID() {
				return eauID;
			}
			public void setEauID(int eauID) {
				this.eauID = eauID;
			}
			public int getFiltrationID() {
				return filtrationID;
			}
			public void setFiltrationID(int filtrationID) {
				this.filtrationID = filtrationID;
			}
			public int getEclairageID() {
				return eclairageID;
			}
			public void setEclairageID(int eclairageID) {
				this.eclairageID = eclairageID;
			}
			public int getAquariumID() {
				return aquariumID;
			}
			public void setAquariumID(int aquariumID) {
				this.aquariumID = aquariumID;
			}
			public Crevettes getCrevettes() {
				return crevettes;
			}
			public void setCrevettes(Crevettes crevettes) {
				this.crevettes = crevettes;
			}

		}

		public Aquarium(final DataAquarium dataAquarium ) {
			super();
			this.longueur = dataAquarium.getLongueur();
			this.largeur = dataAquarium.getLargeur();
			this.hauteur = dataAquarium.getHauteur();
			this.litrageBrut = dataAquarium.getLitrageBrut();
			this.litrageNet = dataAquarium.getLitrageNet();
			this.substratID = dataAquarium.getSubstratID();
			this.eauID = dataAquarium.getEauID();
			this.filtrationID = dataAquarium.getFiltrationID();
			this.eclairageID = dataAquarium.getEclairageID();
			this.crevettes = dataAquarium.getCrevettes();
			this.aquariumID = dataAquarium.getAquariumID();
		}

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

		public int getSubstratID() {
			return substratID;
		}

		public void setSubstratID(int value) {
			this.substratID = value;
		}

		public int getEauID() {
			return eauID;
		}

		public void setEauID(int value) {
			this.eauID = value;
		}

		public int getFiltrationID() {
			return filtrationID;
		}

		public void setFiltrationID(int value) {
			this.filtrationID = value;
		}

		public int getEclairageID() {
			return eclairageID;
		}

		public void setEclairageID(int value) {
			this.eclairageID = value;
		}

		public Aquariums.Aquarium.Crevettes getCrevettes() {
			return crevettes;
		}

		public void setCrevettes(Aquariums.Aquarium.Crevettes value) {
			this.crevettes = value;
		}

		public int getAquariumID() {
			return aquariumID;
		}

		public void setAquariumID(int value) {
			this.aquariumID = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "crevetteID" })
		public static class Crevettes {

			protected List<Double> crevetteID;

			public List<Double> getCrevetteID() {
				if (crevetteID == null) {
					crevetteID = new ArrayList<>();
				}
				return this.crevetteID;
			}

		}

		@Override
		public String toString() {
			return "Aquarium [litrageNet=" + litrageNet + ", crevettes=" + crevettes + ", aquariumID=" + aquariumID
					+ "]";
		}

	}

}
