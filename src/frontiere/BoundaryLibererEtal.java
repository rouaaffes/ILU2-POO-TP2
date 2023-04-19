package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		} else {
			String[] donnees = controlLibererEtal.libererEtal(nomVendeur);
			// if ("True".equals(donnees[0])) {
			System.out.println("Vus avez vendu " + donnees[4] + " sur " + donnees[3] + "" + donnees[2]);
			System.out.println("En revoir " + nomVendeur + " passez une bonne journée ");
			// }
		}
	}

}
