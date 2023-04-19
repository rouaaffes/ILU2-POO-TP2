package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.isHabitant(nomAcheteur)) {
			Scanner console = new Scanner(System.in);
			System.out.println("Quel produit vous voulez achetez");
			String produit = console.next();

			String[] vendeurs = controlAcheterProduit.ListerVendeurPourProduit(produit);
			int i = 0;
			if (vendeurs == null) {
				System.out.println("il n'y a pas de marchand qui vend le produit que vous voulez");
			} else {
				System.out.println("chez quel commercant voulez-vous acheter ces " + produit);
				while (vendeurs[i] != null) {
					System.out.println(i + 1 + "-" + vendeurs[i] + "\n");
					i++;
				}
				int numero = console.nextInt();
				String vendeur = vendeurs[numero - 1];

				System.out.println("Combien de " + produit + " voulez-vous acheter ");
				int nbproduit = console.nextInt();
				int stock = controlAcheterProduit.donnerStockVendeur(vendeur, produit, nbproduit);
				if (nbproduit > stock) {
					System.out.println("le max que tu peux acheter c'est " + stock);
				} else {
					System.out.println(nomAcheteur + "se déplace jusqu'à l'étal du vendeur " + vendeur);
					System.out.println(nomAcheteur + " a acheté" + nbproduit + produit + " a " + vendeur);
					controlAcheterProduit.diminuerStock(vendeur, produit, nbproduit);

				}
			}

		} else {
			System.out.println("vous n'êtes pas un habitant du village ");
		}
	}
}
