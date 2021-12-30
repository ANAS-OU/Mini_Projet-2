package java.mini_projet;

import java.util.*;

public class mini_projet {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nom , sec;
        int num, choix;
        float moy = 0;
        Ecole EC = new Ecole();

        do {
            System.out.println("_____________________________________________");
            System.out.println("       1:  Ajouter                           ");
            System.out.println("       2:  Afficher                          ");
            System.out.println("       3:  Modifier                          ");
            System.out.println("       4:  Supprimer                         ");
            System.out.println("       5:  List des admis                    ");
            System.out.println("       6:  List d'une section                ");
            System.out.println("       7:  Classement des eleves par moyenne ");
            System.out.println("       0:  Quitter                           ");
            System.out.println("_____________________________________________");
            System.out.print("  |---> Tapez votre choix : ");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("num :  ");
                    num = scan.nextInt();
                    System.out.print("nom :  ");
                    nom = scan.nextLine();
                    System.out.print("section : ");
                    sec = scan.nextLine();
                    System.out.print("moyenne : ");
                    moy = scan.nextFloat(); // on peux ajouter une condition pour (0 =< moy >= 20)

                    EC.Ajouter(num, nom, sec, moy);
                    break;

                case 2:
                    if (EC.ls.isEmpty()) System.out.println(" La liste est vide");
                    else EC.afficher();
                    break;

                case 3:
                    if (EC.ls.isEmpty()) System.out.println(" La liste est vide");
                    else {
                        System.out.println("Donner le num :");
                        int n = scan.nextInt();
                        if (EC.index(n) != -1) {
                            System.out.print("Donner le nouveau moyenne :");
                            moy = scan.nextFloat();
                            // on peux ajouter une condition pour (0 =< moy >= 20)
                            EC.ModifierMoy(EC.index(n), moy);
                        } else System.out.println("--> Ce numéro n'existe pas");
                    }
                        break;

                        case 4:
                            if (EC.ls.isEmpty()) System.out.println("--> La liste est vide");
                            else {
                                System.out.println("Donner le num :");
                                int code = scan.nextInt();
                                if (EC.index(code) != -1) EC.Supprimer(EC.index(code));
                                else System.out.println("--> Ce numéro n'existe pas");
                            }
                                break;

                                case 5:
                                    if (EC.ls.isEmpty()) System.out.println("--> La liste est vide");
                                    else {
                                        EC.listAdmis();
                                    }
                                    break;

                                case 6:
                                    if (EC.ls.isEmpty()) System.out.println("--> La liste est vide");
                                    else {
                                        System.out.print("    le nom du section   :   ");
                                        sec = scan.nextLine().replaceAll("\\s", "");
                                        System.out.println("              [[[[ la liste des élèves du cette  section ]]]]         ");
                                        EC.listSection(sec);
                                    }
                                    break;
                                case 7:
                                    if (EC.ls.isEmpty()) System.out.println("--> La liste est vide");
                                    else {
                                        EC.classement();
                                    }
                                    break;

                                case 0:
                                    System.out.println("Merci a vous");
                                    break;
                                default:
                                    System.out.println("--> Le choix est incorrect");
                            }
                    }
                    while (choix != 0) ;
            }
}
