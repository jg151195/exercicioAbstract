package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<Pessoa>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #"+i+" data:");
			System.out.print("Individual or company ? (i/c)");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double rendaAnual = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				Double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(name, rendaAnual, gastoSaude));
			}
			else if (ch == 'c') {
				System.out.print("Number of employees: ");
				Integer numFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(name,rendaAnual,numFuncionarios));
			}
		}
		
		System.out.print("TAXES PAID: ");
		Double soma = 0.0;
		for(Pessoa pessoa : list) {
			soma +=pessoa.imposto();
			System.out.println(pessoa);
		}
		
		System.out.printf("TOTAL TAXES: %.2f",soma);
		
		
		
		sc.close();

	}

}
