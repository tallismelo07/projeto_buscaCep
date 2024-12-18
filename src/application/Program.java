package application;

import classes.ViaCepService;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {
       Scanner sc = new Scanner(System.in);
        System.out.println("------ MENU ------");
        System.out.print("Digite sue CEP: ");
        int digitandoCep = sc.nextInt();

        ViaCepService buscandoApi = new ViaCepService();
        buscandoApi.buscaAPI(digitandoCep);

    }
}