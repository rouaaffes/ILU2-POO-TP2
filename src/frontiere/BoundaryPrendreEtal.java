package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVnedeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVnedeurConnu) {
			System.out.println("je suis désolée " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal\n");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déja occupé");
			} else {
				installerVendeur(nomVendeur);
			}
		}

	}

	private void installerVendeur(String nomVendeur) {
		Scanner console = new Scanner(System.in);
		System.out.println(
				"c'est parfait , il me reste un étal pour vous !" + "\n" + " il me faudrait quelques renseignements\n");
		System.out.println("quel produit souhaitez-vous vendre ?\n");

		String produit = console.next();
		int nbproduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n".toString());
		int indice_etal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);
		if (indice_etal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n " + indice_etal + 1);
		}
	}
}
