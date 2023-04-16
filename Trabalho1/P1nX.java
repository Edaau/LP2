// foi necessario uma alteracao no cpf visto que o tamanho de um cpf ultrapassa o tamanho maximo de um int
// dessa forma foi necessario colocar-lo como long
import java.util.Scanner;
public class P1nX {
	public static void main(String [] args){
		// por favor inserir na seguinte ordem.
		// nome sobrenome dataDeNascimento CPF peso altura genero ou nome sobrenome dataDeNascimento genero. 
		//Exemplo: Eduardo Pinheiro 19 12 2003 50920117007 66.9 1.67 Homem ou Eduardo Pinheiro 19 12 2003 Homem.
		Pessoa [] pessoas;
		Homem homem01;
		//Criticando todas as entradas possiveis passadas por linha de comando.
		if(args.length == 9){
			if(Pessoa.isNome(args[0])){
				if(Pessoa.isSobreNome(args[1])){
					if(ValidaData.isDia(args[2])){
					int dia = Integer.parseInt(args[2]);
						if(ValidaData.isMes(args[3])){
						int mes = Integer.parseInt(args[3]);
							if(ValidaData.isAno(args[4])){
							int ano = Integer.parseInt(args[4]);
								if(ValidaCPF.isCPF(args[5])){
									String cpf = "";
								    	for(int i = 0; i<args[5].length(); i++){
									    	if(Character.isDigit(args[5].charAt(i)))
									    		cpf = cpf + args[5].charAt(i);
															}
									long CPF = ValidaCPF.toIntCPF(cpf);				
									if(Pessoa.isPeso(args[6])){
										float peso = Float.parseFloat(args[6]);
										if(Pessoa.isAltura(args[7])){
											float altura = Float.parseFloat(args[7]);
											if(args[8].equalsIgnoreCase(Homem.getGenero())){
												homem01 = new Homem(args[0],args[1],dia,mes,ano,CPF,peso,altura);
												System.out.println(homem01);
											}
											else if(args[8].equalsIgnoreCase(Mulher.getGenero())){
												Mulher mulher01 = new Mulher(args[0],args[1],dia,mes,ano,CPF,peso,altura);
												System.out.println(mulher01);
											}
											else{
												System.out.println("Por favor entre com um genero valido.");
												System.exit(1);
												}
										}
										else {
											System.out.println("Por favor entre com uma altura valida.");
											System.exit(1);
											}
									}
									else{
										System.out.println("Por favor entre com um peso valido.");
										System.exit(1);
										}
							}
								else{
									System.out.println("Por favor entre com um CPF valido.");
									System.exit(1);
									}
						}
							else{
								System.out.println("Por favor entre com um ano valido");
								System.exit(1);
								}
						}
						else{
							System.out.println("Por favor entre com um mes valido.");
							System.exit(1);
							}
					}
					else{
						System.out.println("Por favor entre com um dia valido.");
						System.exit(1);
						}
					}
				else{
					System.out.println("Por favor entre com um sobrenome valido.");
					System.exit(1);
					}
			}	
			else{
				System.out.println("Por favor entre com um nome valido.");
				System.exit(1);
				}
		}
			
		else if(args.length == 6){
			if(Pessoa.isNome(args[0])){
				if(Pessoa.isSobreNome(args[1])){
					if(ValidaData.isDia(args[2])){
					int dia = Integer.parseInt(args[2]);
						if(ValidaData.isMes(args[3])){
						int mes = Integer.parseInt(args[3]);
							if(ValidaData.isAno(args[4])){
							int ano = Integer.parseInt(args[4]);
								if(args[5].equalsIgnoreCase(Homem.getGenero())){
										homem01 = new Homem(args[0],args[1],dia,mes,ano);
										System.out.println(homem01);
											}
								else if(args[5].equalsIgnoreCase(Mulher.getGenero())){
										Mulher mulher01 = new Mulher(args[0],args[1],dia,mes,ano);
										System.out.println(mulher01);
											}
								else{
										System.out.println("Por favor entre com um genero valido.");	
										System.exit(1);	
										}	
						}
							else{
								System.out.println("Por favor entre com um ano valido");
								System.exit(1);
								}
						}
						else{
							System.out.println("Por favor entre com um mes valido.");
							System.exit(1);
							}
					}
					else{
						System.out.println("Por favor entre com um dia valido.");
						System.exit(1);
						}
					}
				else{
					System.out.println("Por favor entre com um sobrenome valido.");
					System.exit(1);
					}
			}	
			else{
				System.out.println("Por favor entre com um nome valido.");
				System.exit(1);
				}
				}
		else{
			System.out.println("Por favor entre com a quantidade de argumentos necessarios.");
			System.exit(1);
		}
		Scanner teclado = new Scanner(System.in);
		System.out.print("Quantos elementos adicionais deseja criar? ");//insira 0 caso nao queira criar.
		String quantidade = teclado.nextLine();
		while(!(Pessoa.isArray(quantidade))){
			System.out.print("Por favor entre com um valor valido: ");
			quantidade = teclado.nextLine();
		}
		int tamanho = Integer.parseInt(quantidade);
		pessoas = new Pessoa[tamanho];
		for(int i = 0; i<tamanho; i++){
			System.out.print("Insira o nome: ");
			String nome = teclado.nextLine();
			String aux = "";
			if(nome.equals(aux))
				break;
			while(!(Pessoa.isNome(nome))){
				System.out.print("Por favor entre com um nome valido: ");
				nome = teclado.nextLine();
				}
			System.out.print("Insira o Sobrenome: ");
			String sobreNome = teclado.nextLine();
			if(sobreNome.equals(aux))
				break;
			while(!(Pessoa.isSobreNome(sobreNome))){
				System.out.print("Por favor entre com um Sobrenome valido: ");
				sobreNome = teclado.nextLine();
				}
			System.out.print("Insira o dia do nascimento: ");
			String day = teclado.nextLine();
			if(day.equals(aux))
				break;
			while(!(ValidaData.isDia(day))){
				System.out.print("Por favor entre com um dia valido: ");
				day = teclado.nextLine();
				}
			int dia = Integer.parseInt(day);
			System.out.print("Insira o mes do nascimento: ");
			String month = teclado.nextLine();
			if(month.equals(aux))
				break;
			while(!(ValidaData.isMes(month))){
				System.out.print("Por favor entre com um mes valido: ");
				month = teclado.nextLine();
				}
			int mes = Integer.parseInt(month);
			System.out.print("Insira o ano do nascimento: ");
			String year = teclado.nextLine();
			if(year.equals(aux))
				break;
			while(!(ValidaData.isAno(year))){
				System.out.print("Por favor entre com um ano valido: ");
				year = teclado.nextLine();
				}
			int ano = Integer.parseInt(year);
			System.out.print("Insira o genero: ");
			String genero = teclado.nextLine();
			if(genero.equals(aux))
				break;
			while(!(genero.equalsIgnoreCase(Homem.getGenero())|| genero.equalsIgnoreCase(Mulher.getGenero()))){
				System.out.print("Por favor entre com um genero valido: ");
				genero = teclado.nextLine();
				}
			System.out.print("Deseja inserir o CPF,peso e altura?[Sim/Nao]: ");// entre com sim ou nao.
			String resposta = teclado.nextLine();
			if(resposta.equals(aux))
				break;
			while(!(resposta.equalsIgnoreCase("nao") || resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s"))){
				System.out.print("Insira uma resposta valida :");
				resposta = teclado.nextLine();
				}
			if(resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")){
				System.out.print("Insira o CPF: ");
				String testeCPF = teclado.nextLine();
				if(testeCPF.equals(aux))
					break;
				while(!(ValidaCPF.isCPF(testeCPF))){
					System.out.print("Por favor entre com um cpf valido: ");
					testeCPF = teclado.nextLine();
					}
				String cpf = "";
				for(int j = 0; j<testeCPF.length();j++){
					if(Character.isDigit(testeCPF.charAt(j)))
						cpf = cpf + testeCPF.charAt(j);
								}
				long CPF = Long.parseLong(cpf);
				System.out.print("Insira o peso: ");
				String weight = teclado.nextLine();
				if(weight.equals(aux))
					break;
				while(!(Pessoa.isPeso(weight))){
					System.out.print("Por favor entre com um peso valido: ");
					weight = teclado.nextLine();
					}
				float peso = Float.parseFloat(weight);
				System.out.print("Insira a altura: ");
				String height = teclado.nextLine();
				if(height.equals(aux))
					break;
				while(!(Pessoa.isAltura(height))){
					System.out.print("Por favor entre com uma altura valido: ");
					height= teclado.nextLine();
					}
				float altura = Float.parseFloat(height);
				if((genero.equalsIgnoreCase(Homem.getGenero())))
					pessoas[i] = new Homem(nome, sobreNome, dia, mes, ano, CPF, peso, altura);
				else
					pessoas[i] = new Mulher(nome, sobreNome, dia, mes, ano, CPF, peso, altura);
			}
			else{
				if((genero.equalsIgnoreCase(Homem.getGenero())))
					pessoas[i] = new Homem(nome, sobreNome, dia, mes, ano);
				else
					pessoas[i] = new Mulher(nome, sobreNome, dia, mes, ano);
				
			}
			
		}
		int contHomem = 0, contMulher = 0;
		if(homem01 instanceof Homem)
			contHomem++;
		else
			contMulher++;
		//decrementa 1 pois o primeiro homem ou mulher foi contado quando foi criado pela linha de comando e nao faz parte do array.
		for(int i = 0 ; i<(Pessoa.numPessoas()-1);i++){
			System.out.println("\n"+pessoas[i]);
			if(pessoas[i] instanceof Homem){
				contHomem++;
				}
			if(pessoas[i] instanceof Mulher){
				contMulher++;
				}
		}
		System.out.println("Numero de Homens: "+ contHomem);
		System.out.println("Numero de Mulheres: "+ contMulher);
	}
}
