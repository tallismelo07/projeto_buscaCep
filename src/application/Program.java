package application;

import classes.ViaCepService;
import records.AddressAPI;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {
        ViaCepService buscandoApi = new ViaCepService();

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu CEP: ");
        String digitantoCep = sc.nextLine();

        AddressAPI newAddress = buscandoApi.buscaAPI(digitantoCep);
        System.out.println(newAddress);
        buscandoApi.salvarJson(newAddress);
    }
}