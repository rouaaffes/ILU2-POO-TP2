package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder reponse = new StringBuilder();
					reponse.append("Bienvenue villageois" + nomVisiteur + " ");
					reponse.append("Quelle est votre force ? ");
					int force = Clavier.entrerEntier(reponse.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);

					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					emmenager(nomVisiteur);
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder salut = new StringBuilder();
		salut.append("Bienvenue Druide " + nomVisiteur + "Quelle est votre force?");
		int forceDruide = Clavier.entrerEntier(salut.toString());
		StringBuilder potionmin = new StringBuilder();
		potionmin.append("Quelle est la force de potion la plus faible que vous prduisez ?");
		int effetPotionMin = Clavier.entrerEntier(potionmin.toString());
		StringBuilder potionmax = new StringBuilder();
		potionmax.append("Quelle est la force de potion la plus forte que vous prduisez ?");
		int effetPotionMax = Clavier.entrerEntier(potionmax.toString());
		while (effetPotionMin > effetPotionMax) {
			System.out.println("attention Druide , vous vous êtes trompés entre le minimum et le maximum");
			// StringBuilder potionmin = new StringBuilder();
			// potionmin.append("Quelle est la force de potion la plus faible que vous
			// prduisez ?");
			effetPotionMin = Clavier.entrerEntier(potionmin.toString());
			// StringBuilder potionmax = new StringBuilder();
			// potionmax.append("Quelle est la force de potion la plus faible que vous
			// prduisez ?");
			effetPotionMax = Clavier.entrerEntier(potionmax.toString());

		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
