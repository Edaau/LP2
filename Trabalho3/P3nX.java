import lp2g04.biblioteca.*;
import java.util.*;
import java.io.*;
public class P3nX{
	public static Biblioteca Manutencao(Scanner teclado){
		System.out.println("Bem vindo bibliotecario, deseja comecar uma biblioteca do 0[pressione 1], carregar a biblioteca padrao[pressione 2] ou carregar uma biblioteca externa[pressione 3]");
		String resposta1 = teclado.nextLine();
		while(!(Pessoa.isResposta1(resposta1))){
			System.out.println("Por favor insira uma resposta valida.");
			resposta1 = teclado.nextLine();
		}
		int answer1 = Integer.parseInt(resposta1);
		Biblioteca myLib = null;
		if(answer1 == 1){
			File arquivo1 = new File("CadastrosUsuarios.txt");
			File arquivo2 = new File("CadastrosLivros.txt");
			try{
				arquivo1.createNewFile();
				FileOutputStream fileOut = new FileOutputStream(arquivo1.getName());
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				Hashtable<Integer,Usuario> hash1 = new Hashtable<>();
				out.writeObject(hash1);
				out.close();
				fileOut.close();
				arquivo2.createNewFile();
				FileOutputStream fileOutput = new FileOutputStream(arquivo2.getName());
				ObjectOutputStream output = new ObjectOutputStream(fileOutput);
				Hashtable<String,Livro> hash2 = new Hashtable<>();
				output.writeObject(hash2);
				output.close();
				fileOutput.close();
				myLib = new Biblioteca(arquivo1.getName(), arquivo2.getName());
				
			}
			catch(IOException e){
				System.out.println("Erro na criacao do arquivo" + e);
			}
		}
		
		else if(answer1 == 2){
			myLib = new Biblioteca("CadastrosUsuarios.txt","CadastrosLivros.txt");
		
		}
		else{
			System.out.println("Insira o nome do arquivo da hashtable com os usuarios:");
			String arquivo1 = teclado.nextLine();
			System.out.println("Insira o nome do arquivo da hashtable com os livros:");
			String arquivo2 = teclado.nextLine();
			myLib = new Biblioteca(arquivo1, arquivo2);
				}
		return myLib;
}


	public static void Cadastro(Biblioteca myLib, Scanner teclado){
		System.out.println("Para cadastrar usuarios[pressione 1]");
		System.out.println("Para cadastrar livros [pressione 2]");
		System.out.println("Para salvar em arquivo [pressione 3]");
		System.out.println("Para voltar [pressione 4]");
		String resposta1 = teclado.nextLine();
		while(!(Pessoa.isResposta3(resposta1))){
			System.out.println("Por favor insira uma resposta valida.");
			resposta1 = teclado.nextLine();
		}
		int answer1 = Integer.parseInt(resposta1);
		if(answer1 == 1){
			String continuar = "S";
			while(continuar.equalsIgnoreCase("S")){
				System.out.print("Insira o nome: ");
				String nome = teclado.nextLine();
				while(!(Pessoa.isNome(nome))){
					System.out.print("Por favor entre com um nome valido: ");
					nome = teclado.nextLine();
					}
				System.out.print("Insira o Sobrenome: ");
				String sobreNome = teclado.nextLine();
				while(!(Pessoa.isSobreNome(sobreNome))){
					System.out.print("Por favor entre com um Sobrenome valido: ");
					sobreNome = teclado.nextLine();
					}
				System.out.print("Insira o dia do nascimento: ");
				String day = teclado.nextLine();
				while(!(ValidaData.isDia(day))){
					System.out.print("Por favor entre com um dia valido: ");
					day = teclado.nextLine();
					}
				int dia = Integer.parseInt(day);
				System.out.print("Insira o mes do nascimento: ");
				String month = teclado.nextLine();
				while(!(ValidaData.isMes(month))){
					System.out.print("Por favor entre com um mes valido: ");
					month = teclado.nextLine();
					}
				int mes = Integer.parseInt(month);
				System.out.print("Insira o ano do nascimento: ");
				String year = teclado.nextLine();
				while(!(ValidaData.isAno(year))){
					System.out.print("Por favor entre com um ano valido: ");
					year = teclado.nextLine();
					}
				int ano = Integer.parseInt(year);
				System.out.print("Insira o endereco: ");
				String endereco = teclado.nextLine();
				System.out.print("Insira o codigo do usuario: ");
				String code = teclado.nextLine();
				while(!(Pessoa.isCodigoUser(code))){
					System.out.print("Por favor entre com um codigo valido: ");
					code = teclado.nextLine();
					}
				int codigo = Integer.parseInt(code);
				Usuario user = new Usuario(nome, sobreNome, dia, mes, ano, endereco, codigo);
				myLib.cadastraUsuario(user);
				myLib.salvaArquivoUser(myLib.getCadastroUser(), myLib.getArquivoUsuarios());
				System.out.println("Deseja adicionar outro usuario?[S/N]");
				continuar = teclado.nextLine();
				}
		}
		else if(answer1 == 2){
			String continuar = "S";
			while(continuar.equalsIgnoreCase("S")){
				System.out.print("Insira o codigo do livro: ");
				String codigo = teclado.nextLine();
				System.out.print("Insira o titulo do livro: ");
				String titulo = teclado.nextLine();
				System.out.print("Insira a categoria do livro: ");
				String categoria = teclado.nextLine();
				System.out.print("Insira a quantidade do livro: ");
				String quant = teclado.nextLine();
				while(!(Pessoa.isCodigoUser(quant))){
					System.out.print("Por favor entre com um codigo valido: ");
					quant = teclado.nextLine();
					}
				int quantidade = Integer.parseInt(quant);
				Livro livro = new Livro(codigo, titulo, categoria, quantidade, 0);
				myLib.cadastraLivro(livro);
				myLib.salvaArquivoLivro(myLib.getCadastroLivro(), myLib.getArquivoLivros());
				System.out.println("Deseja adicionar outro livro?[S/N]");
				continuar = teclado.nextLine();
				}
		}
		else if(answer1 == 3){
			System.out.println("Deseja salvar o cadastro de usuarios[Pressione 1] ou o cadastro de livros[Pressione 2]");
			String resposta2 = teclado.nextLine();
			while(!(Pessoa.isResposta4(resposta2))){
				System.out.println("Por favor insira uma resposta valida.");
				resposta2 = teclado.nextLine();
		}
			int answer2 = Integer.parseInt(resposta2);
			if(answer2 == 1){
				System.out.println("Por favor insira o nome do arquivo");
				String nomearq = teclado.nextLine();
				try{
					File arquivo = new File(nomearq);
					arquivo.createNewFile();
					FileOutputStream fileOut = new FileOutputStream(arquivo.getName());
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					Hashtable<Integer,Usuario> hash = myLib.getCadastroUser();
					out.writeObject(hash);
					out.close();
					fileOut.close();
				}
				catch(IOException e ){
					System.out.println("Erro de IO" + e);
				}
			}
			if(answer2 == 2){
				try{
					System.out.println("Por favor insira o nome do arquivo");
					String nomearq = teclado.nextLine();
					File arquivo = new File(nomearq);
					arquivo.createNewFile();
					FileOutputStream fileOut = new FileOutputStream(arquivo.getName());
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					Hashtable<String,Livro> hash = myLib.getCadastroLivro();
					out.writeObject(hash);
					out.close();
					fileOut.close();
				}
				catch(IOException e ){
					System.out.println("Erro de IO" + e);
				}
			}
		}
		else{
			return;
		}
		
	}
	public static void Emprestimo(Biblioteca myLib, Scanner teclado, int dias, int numMax, int multa){
		System.out.println("Exibir cadastros de livros[Pressione 1], fazer um emprestimo[pressione 2] ou fazer uma devolucao[pressione 3]");
		String resposta1 = teclado.nextLine();
		while(!(Pessoa.isResposta1(resposta1))){
				System.out.println("Por favor insira uma resposta valida.");
				resposta1 = teclado.nextLine();
		}
		int answer1 = Integer.parseInt(resposta1);
		if(answer1 == 1){
			System.out.println(myLib.imprimeLivros());
		}
		else if(answer1 == 2){
			String continuar = "S";
			int cont = 0;
			while(continuar.equalsIgnoreCase("S")){
				System.out.println("Insira o codigo do livro:");
				String codigoLivro = teclado.nextLine();
				System.out.print("Insira o codigo do usario: ");
				String code = teclado.nextLine();
				while(!(Pessoa.isCodigoUser(code))){
					System.out.print("Por favor entre com um codigo valido: ");
					code = teclado.nextLine();
					}
				int codigoUser = Integer.parseInt(code);
				try{
					Livro livro = myLib.getLivro(codigoLivro);
					Usuario user = myLib.getUsuario(codigoUser);
					myLib.emprestaLivro(user, livro);
					System.out.println("Usuario que pegou o livro emprestado:" + user.getNome() +" "+ user.getSobreNome());
					System.out.println("Livro emprestado com sucesso: " + livro.getTitulo()); 
					myLib.salvaArquivoLivro(myLib.getCadastroLivro(), myLib.getArquivoLivros());
					myLib.salvaArquivoUser(myLib.getCadastroUser(), myLib.getArquivoUsuarios());
					cont++;
					}
				catch(LivroNaoCadastradoEx e){
					System.out.println(e);
				}
				catch(UsuarioNaoCadastradoEx e){
					System.out.println(e);
				}
				if(cont == numMax){
					System.out.println("Numero maximo de emprestimo de uma vez so foram alcancados.");
					break;
				}
				System.out.println("Deseja fazer outro emprestimo?[S/N]");
				continuar = teclado.nextLine();
				}
		}
		else{
			String continuar = "S";
			while(continuar.equalsIgnoreCase("S")){
				System.out.println("Insira o codigo do livro:");
				String codigoLivro = teclado.nextLine();
				System.out.print("Insira o codigo do usario: ");
				String code = teclado.nextLine();
				while(!(Pessoa.isCodigoUser(code))){
					System.out.print("Por favor entre com um codigo valido: ");
					code = teclado.nextLine();
					}
				int codigoUser = Integer.parseInt(code);
				try{
					Livro livro = myLib.getLivro(codigoLivro);
					Usuario user = myLib.getUsuario(codigoUser);
					boolean atraso = myLib.devolveLivro(user, livro, dias);
					System.out.println("Usuario que devolveu o livro emprestado:" + user.getNome() +" "+ user.getSobreNome());
					System.out.println("Livro devolvido com sucesso: " + livro.getTitulo()); 
					myLib.salvaArquivoLivro(myLib.getCadastroLivro(), myLib.getArquivoLivros());
					myLib.salvaArquivoUser(myLib.getCadastroUser(), myLib.getArquivoUsuarios());
					if(atraso){
						System.out.println("Livro entregue com atraso, multa a ser paga: R$: " + multa);
					}
					}
				catch(LivroNaoCadastradoEx e){
					System.out.println(e);
				}
				catch(UsuarioNaoCadastradoEx e){
					System.out.println(e);
				}
				System.out.println("Deseja fazer outra devolucao?[S/N]");
				continuar = teclado.nextLine();
				}
		}
		}
	public static void Relatorio(Biblioteca myLib, Scanner teclado){
		System.out.println("Listar acervo de livros[Pressione 1], listar cadastro de usuarios[Pressione 2], detalhes de um usuario[Pressione 3] ou detalhes de um livro[Pressione 4]");
		String resposta1 = teclado.nextLine();
		while(!(Pessoa.isResposta3(resposta1))){
				System.out.println("Por favor insira uma resposta valida.");
				resposta1 = teclado.nextLine();
		}
		int answer1 = Integer.parseInt(resposta1);
		if(answer1 == 1){
			System.out.println(myLib.imprimeLivros());
		}
		else if(answer1 == 2){
			System.out.println(myLib.imprimeUsuarios());
		}
		else if(answer1 == 3){
			System.out.println("Insira o codigo do Usuario");
			String codigo = teclado.nextLine();
			while(!(Pessoa.isCodigoUser(codigo))){
					System.out.print("Por favor entre com um codigo valido: ");
					codigo = teclado.nextLine();
					}
			int codigoUser = Integer.parseInt(codigo);
			try{
				System.out.println(myLib.getUsuario(codigoUser));
			}
			catch(UsuarioNaoCadastradoEx e){
					System.out.println(e);
				}
		}
		else{
			System.out.println("Insira o codigo do Livro");
			String codigo = teclado.nextLine();
			try{
				System.out.println(myLib.getLivro(codigo));
			}
			catch(LivroNaoCadastradoEx e){
					System.out.println(e);
				}
	           }
	}
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		Biblioteca myLib = P3nX.Manutencao(teclado);
		int numMax = P3nX.numeroMaximo(teclado);
		int dias = P3nX.diaMax(teclado);
		int multa = P3nX.multa(teclado);
		menu(myLib, teclado, dias, numMax,multa);
	}
	public static int numeroMaximo(Scanner teclado){
		System.out.println("Insira o numero maximo de emprestimos de uma vez");
		String num = teclado.nextLine();
		while(!(Pessoa.isCodigoUser(num))){
			System.out.print("Por favor entre com um codigo valido: ");
			num = teclado.nextLine();
					}
		int numMax = Integer.parseInt(num);
		return numMax;
	}
	public static int diaMax(Scanner teclado){
		System.out.println("Insira o numero maximo de dias que uma pessoa pode ficar com o livro");
		String num = teclado.nextLine();
		while(!(Pessoa.isCodigoUser(num))){
			System.out.print("Por favor entre com um numero valido: ");
			num = teclado.nextLine();
					}
		int numMax = Integer.parseInt(num);
		return numMax;
	}
	public static int multa(Scanner teclado){
		System.out.println("Insira o valor da multa em caso de atraso");
		String num = teclado.nextLine();
		while(!(Pessoa.isCodigoUser(num))){
			System.out.print("Por favor entre com um numero valido: ");
			num = teclado.nextLine();
					}
		int numMax = Integer.parseInt(num);
		return numMax;
	}
	public static void menu(Biblioteca myLib, Scanner teclado, int dias, int numMax, int multa){
		System.out.println("Para cadastrar livros e usuarios[Pressione 1], para fazer emprestimo ou devolucao[Pressione 2], para ver o relatorio[Pressione 3] ou sair[Pressione 4]");
		String resposta1 = teclado.nextLine();
		while(!(Pessoa.isResposta3(resposta1))){
				System.out.println("Por favor insira uma resposta valida.");
				resposta1 = teclado.nextLine();
		}
		int answer1 = Integer.parseInt(resposta1);
		while(answer1 != 4){
			if(answer1 == 1){
				P3nX.Cadastro(myLib, teclado);
				System.out.println("Para cadastrar livros e usuarios[Pressione 1], para fazer emprestimo ou devolucao[Pressione 2], para ver o relatorio[Pressione 3] ou sair[Pressione 4]");
				resposta1 = teclado.nextLine();
				while(!(Pessoa.isResposta3(resposta1))){
						System.out.println("Por favor insira uma resposta valida.");
						resposta1 = teclado.nextLine();
				}
				answer1 = Integer.parseInt(resposta1);
			}
			if(answer1 == 2){
				P3nX.Emprestimo(myLib,teclado,dias,numMax,multa);
				System.out.println("Para cadastrar livros e usuarios[Pressione 1], para fazer emprestimo ou devolucao[Pressione 2], para ver o relatorio[Pressione 3] ou sair[Pressione 4]");
				resposta1 = teclado.nextLine();
				while(!(Pessoa.isResposta3(resposta1))){
						System.out.println("Por favor insira uma resposta valida.");
						resposta1 = teclado.nextLine();
				}
				answer1 = Integer.parseInt(resposta1);
			}
			if(answer1 == 3){
				P3nX.Relatorio(myLib, teclado);
				System.out.println("Para cadastrar livros e usuarios[Pressione 1], para fazer emprestimo ou devolucao[Pressione 2], para ver o relatorio[Pressione 3] ou sair[Pressione 4]");
				resposta1 = teclado.nextLine();
				while(!(Pessoa.isResposta3(resposta1))){
						System.out.println("Por favor insira uma resposta valida.");
						resposta1 = teclado.nextLine();
				}
				answer1 = Integer.parseInt(resposta1);
			}
		}
		System.exit(0);
	}
	}
