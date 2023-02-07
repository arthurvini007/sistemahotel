package Pousada;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Pousada[] pousada = new Pousada[10];
        Scanner sc = new Scanner(System.in);

        String saida = "";
        String menu, nomeHospede, emailHospede;
        int qtdCheck, quartoCheckIn, quartoCheckOut;

        for (int i = 0; i <= 9; i++) {
            pousada[i] = new Pousada();
        }

        do {

            System.out.println("Ola");
            System.out.println("Bem vindo a pousada do Gilson \n");

            System.out.println("Escolha a opcao desejada: ");
            System.out.println("1-  Check In \n2-  Check Out \n3-  Listar quartos \nsair-  fechar aplicativo");
            System.out.print("-> ");
            menu = sc.next().toLowerCase();

            switch (menu) {
                case "1":
                    System.out.println("\n Por gentileza insira quantos Check-in deseja realizar: ");
                    System.out.println("quartos: 1 a 10");
                    System.out.print("-> ");
                    qtdCheck = sc.nextInt();
                    if (qtdCheck < 1 || qtdCheck > 10) {
                        System.out.println("Quantidade de check-in invalidas");
                    } else {
                        for (int i = 1; i <= qtdCheck; i++) {

                            System.out.printf("\n Insira o quarto do hospede %d: ", i);
                            quartoCheckIn = sc.nextInt();

                            if (quartoCheckIn < 1 || quartoCheckIn > 10) {
                                System.out.println("por gentileza escolher um quarto valido");
                                i -= 1;
                            } else if (!pousada[quartoCheckIn - 1].isOcupado()) {
                                System.out.println("\n--------------------------------------\n");
                                System.out.println("Insira o nome do hospede: ");
                                System.out.print("-> ");
                                nomeHospede = sc.next();

                                System.out.println("Insira o email do hospede: ");
                                System.out.print("-> ");
                                emailHospede = sc.next();

                                pousada[quartoCheckIn - 1].CheckIn(nomeHospede, emailHospede);

                            } else {
                                System.out.println("Você inseriu um quarto ocupado, por gentileza escolher outro");
                                i -= 1;
                            }
                        }
                    }
                    break;

                case "2":
                    System.out.println("Por gentileza insira quantos Check-Out deseja realizar: ");
                    System.out.println("quartos: 1 a 10");
                    qtdCheck = sc.nextInt();
                    if (qtdCheck < 1 || qtdCheck > 10) {
                        System.out.println("Quantidade de checkout invalidas");
                    } else {
                        for (int i = 1; i <= qtdCheck; i++) {

                            System.out.println("Insira o quarto que deseja realizar o check out: ");
                            System.out.print("-> ");
                            quartoCheckOut = sc.nextInt();

                            if (quartoCheckOut < 1 || quartoCheckOut > 10) {
                                System.out.println("por gentileza escolher um quarto valido");
                                i -= 1;
                            } else if (pousada[quartoCheckOut].isOcupado()) {
                                pousada[quartoCheckOut].CheckOut();

                                System.out.println("Checkout realizado com sucesso!");
                            } else {
                                System.out.println(
                                        "Você escolheu um quarto que não tem hospede, por gentileza escolher um quarto valido");
                                i -= 1;
                            }
                        }
                    }
                    break;

                case "3":
                    for (int i = 0; i < 10; i++) {

                        if (!pousada[i].isOcupado()) {
                            System.out.println("--------------------------------------");
                            System.out.printf("%d: quarto desocupado \n", i + 1);
                        } else {
                            System.out.println("--------------------------------------");
                            System.out.printf("%d: \n", i + 1);
                            System.out.println("Nome: " + pousada[i].getNome());
                            System.out.println("Email: " + pousada[i].getEmail());
                        }
                    }
                    break;

                case "sair":
                    saida = "sair";
                    break;

                default:
                    System.out.println("Por gentileza escolher uma opçao valida");
                    break;

            }

        } while (!saida.equals("sair"));
    }
}