package controleur;

import java.util.Objects;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public int donnerStockVendeur(String vendeur, String produit, int quantite) {
		Gaulois[] vendeurs;
		vendeurs = village.rechercherVendeursProduit(produit);
		int stock = 0;
		boolean trouve = false;
		for (int i = 0; i < vendeurs.length; i++) {
			if (Objects.equals(vendeurs[i].getNom(), vendeur)) {
				Gaulois vendeurGaulois = vendeurs[i];
				Etal etalvendeur = village.rechercherEtal(vendeurGaulois);
				stock = etalvendeur.getQuantite();

			}
		}

		return stock;
	}

	public void diminuerStock(String vendeur, String produit, int quantite) {
		Gaulois[] vendeurs;
		vendeurs = village.rechercherVendeursProduit(produit);
		int stock = 0;
		boolean trouve = false;
		for (int i = 0; i < vendeurs.length; i++) {
			if (Objects.equals(vendeurs[i].getNom(), vendeur)) {
				Gaulois vendeurGaulois = vendeurs[i];
				Etal etalvendeur = village.rechercherEtal(vendeurGaulois);
				etalvendeur.acheterProduit(quantite);
			}
		}

	}

	public String[] ListerVendeurPourProduit(String produit) {
		String[] marche = village.donnerEtatMarche();
		String[] vendeurs = new String[10];
		int i = 2;
		int j = 0;
		int nb_vendeurs = 0;
		while (i < marche.length) {
			if (Objects.equals(produit, marche[i])) {
				vendeurs[j] = marche[i - 2];
				nb_vendeurs++;
			}
			i = i + 2;
		}
		if (nb_vendeurs == 0) {
			return null;
		}
		return vendeurs;
	}

}
