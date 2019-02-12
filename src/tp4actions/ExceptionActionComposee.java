package tp4actions;

@SuppressWarnings("serial")
public class ExceptionActionComposee extends Exception {

    public ExceptionActionComposee(int codeErr) {
        switch (codeErr) {
            case 1:
                System.err.println("Erreur : Vous dépassez la capacité de l'action composée");
                ;
                break;
            case 2:
                System.err.println("Erreur : le pourcentage doit être compris entre 0 et 1 (exclus)");
                break;
            case 3:
                System.err.println("Erreur : l'action n'est pas entierement compos�e");
                break;
        }
    }
}
