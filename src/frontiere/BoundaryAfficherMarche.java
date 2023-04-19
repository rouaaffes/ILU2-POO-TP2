package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		int length_tab_marche = controlAfficherMarche.donnerInfosMarche().length;
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (length_tab_marche == 0) {
			System.out.println("Le marche est vide , revenez plus tard ");
		} else {
			System.out.println(nomAcheteur + " vous trouverez au marche ");
			int i = 0;
			while (i < length_tab_marche) {
				System.out.println("-" + infosMarche[i]);
				i++;
				System.out.println(" qui vend " + infosMarche[i]);
				i++;
				System.out.println(infosMarche[i] + "\n");
				i++;
			}
		}
	}
}
