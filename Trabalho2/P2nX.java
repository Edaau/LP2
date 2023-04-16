import java.util.Scanner;
public class P2nX {	
	public static void main(String[] args){
		MinhaListaOrdenavel mylist = P2nX.criaEPreenche();
		P2nX.tabela(mylist);
	
	}
	public static MinhaListaOrdenavel criaEPreenche(){
		MinhaListaOrdenavel array = new MinhaListaOrdenavel();
		Homem pessoa1 = new Homem("Eduardo", "Alcantara", 30, 4, 1977, 79.4, 1.62);
		array.add(pessoa1);
		Homem pessoa2 = new Homem("Aldair", "Barbosa", 7, 4, 1983, 80.7, 1.80);
		array.add(pessoa2);
		Homem pessoa3 = new Homem("Eduardo", "Pinheiro", 19, 12, 2003, 58.0, 1.70);
		array.add(pessoa3);
		Homem pessoa4 = new Homem("Casimiro", "Miguel", 20, 10, 1993, 120.2, 1.85);
		array.add(pessoa4);
		Homem pessoa5 = new Homem("Jose", "Carvajal", 24, 5, 2010, 38.9, 1.50);
		array.add(pessoa5);
		Mulher pessoa6 = new Mulher("Laura", "Ventura", 9, 9, 2003, 50.0, 1.58);
		array.add(pessoa6);
		Mulher pessoa7 = new Mulher("Gabrielle", "Pinheiro", 15, 2, 1979, 60.3, 1.57);
		array.add(pessoa7);
		Mulher pessoa8 = new Mulher("Jubiscleia", "Silva", 16, 10, 2001, 58.0, 1.70);
		array.add(pessoa8);
		Mulher pessoa9 = new Mulher("Jennifer", "Pereira", 31, 7, 2000, 45.9, 1.73);
		array.add(pessoa9);
		Mulher pessoa10 = new Mulher("Paula", "Carvalho", 20, 1, 1983, 139.4, 1.62);
		array.add(pessoa10);
		return array;
	}
	public static void tabela(MinhaListaOrdenavel array){
		System.out.println("1.Imprimir lista");
		System.out.println("2.Sair");
		System.out.print("Digite sua opcao: ");
		Scanner teclado = new Scanner(System.in);
		String r1 = teclado.nextLine();
		while(!(Pessoa.isResposta1(r1))){
			System.out.println("Por favor entre com 1 ou 2.");
			r1 = teclado.nextLine();
		}
		if(Integer.parseInt(r1) == 2)
			System.exit(0);
		System.out.println("Escolha sua forma de ordenacao: ");
		System.out.println("1.Alfabetica(A-Z)");
		System.out.println("2.Alfabetica(Z-A)");
		System.out.println("3.Menor Peso");
		System.out.println("4.Maior Peso");
		System.out.println("5.Maior Altura");
		System.out.println("6.Menor Altura");
		System.out.println("7.Menor IMC");
		System.out.println("8.Maior IMC");
		System.out.println("9.Mulher/Homem");
		System.out.println("10.Homem/mulher");
		System.out.println("11.Menor Data de Nascimento");
		System.out.println("12.Maior Data de Nascimento");
		System.out.print("Digite sua opcao: ");
		String r2 = teclado.nextLine();
		System.out.print("\n");
		while(!(Pessoa.isResposta2(r2))){
			System.out.println("Por favor entre com um numero entre 1 e 12.");
			r2 = teclado.nextLine();
		}
		array.ordena(Integer.parseInt(r2));
		for(int i = 0; i<10; i++){
			System.out.println(array.get(i));
		
		}
		teclado.close();
	}
}
