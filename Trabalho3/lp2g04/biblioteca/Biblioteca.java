package lp2g04.biblioteca;
import java.util.*;
import java.util.Enumeration;
import java.io.*;
public class Biblioteca{
	private Hashtable<Integer,Usuario> cadastroUser = new Hashtable<>();
	private Hashtable<String, Livro> cadastroLivro = new Hashtable<>();
	private String arquivoUsuarios, arquivoLivros;
	public Biblioteca(Hashtable<Integer,Usuario> cadastroUser,Hashtable<String, Livro> cadastroLivro){
		this.cadastroUser = cadastroUser;
		this.cadastroLivro = cadastroLivro;
	}
	public Biblioteca(String arq1, String arq2){
			try{
				this.arquivoUsuarios = arq1;
				this.arquivoLivros = arq2;
				FileInputStream fileIn = new FileInputStream(arq1);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				cadastroUser = (Hashtable<Integer,Usuario>)in.readObject();
				in.close();
				fileIn.close();
				FileInputStream fileInput = new FileInputStream(arq2);
				ObjectInputStream input = new ObjectInputStream(fileInput);
				cadastroLivro = (Hashtable<String,Livro>)input.readObject();
				input.close();
				fileInput.close();
			}
			catch(IOException e){
				System.out.println("Erro ao ler o arquivo " + e);
		}
			catch(ClassNotFoundException e){
				System.out.println("Classe nao encontrada " + e);
		} 
	
	}
	public String getArquivoUsuarios(){
		return arquivoUsuarios;
	}
	public String getArquivoLivros(){
		return arquivoLivros;
	}
	public Hashtable<Integer,Usuario> getCadastroUser(){
		return cadastroUser;
	}
	public Hashtable<String,Livro> getCadastroLivro(){
		return cadastroLivro;
	}
	public void cadastraUsuario(Usuario user){
		try{
			cadastroUser.put(user.getCodigoUsuario(), user);
		
		}
		catch(NullPointerException e){
			System.out.println("Chave ou valor nulos " + e);
		
		}
	
	}
	public void cadastraLivro(Livro livro){
		try{
			cadastroLivro.put(livro.getCodigo(), livro);
		
		}
		catch(NullPointerException e){
			System.out.println("Chave ou valor nulos " + e);
		
		}
	
	}
	public void salvaArquivoUser(Hashtable<Integer,Usuario> cadastro, String arq){
		try{
			FileOutputStream fileOut = new FileOutputStream(arq);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cadastro);
			out.close();
			fileOut.close();
		}
		catch(IOException e){
			System.out.println("Erro ao salvar o arquivo " + e);
		}
		 
	}
	public void salvaArquivoLivro(Hashtable<String, Livro>  cadastro, String arq){
		try{
			FileOutputStream fileOut = new FileOutputStream(arq);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cadastro);
			out.close();
			fileOut.close();
		}
		catch(IOException e){
			System.out.println("Erro ao salvar o arquivo " + e);
		}
		 
	}
	public void leArquivoUser(String arq){
		try{
			FileInputStream fileIn = new FileInputStream(arq);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cadastroUser = (Hashtable<Integer,Usuario>)in.readObject();
			in.close();
			fileIn.close();
			
		}
		catch(IOException e){
			System.out.println("Erro ao ler o arquivo " + e);
		}
		catch(ClassNotFoundException e){
			System.out.println("Classe nao encontrada " + e);
		} 
		
	}
	public void leArquivoLivro(String arq){
		try{
			FileInputStream fileIn = new FileInputStream(arq);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cadastroLivro = (Hashtable<String,Livro>)in.readObject();
			in.close();
			fileIn.close();
			
		}
		catch(IOException e){
			System.out.println("Erro ao ler o arquivo " + e);
		}
		catch(ClassNotFoundException e){
			System.out.println("Classe nao encontrada " + e);
		} 
		
	}
	public void emprestaLivro(Usuario user, Livro livro){
		try{
			livro.empresta();
			user.addLivroHist((GregorianCalendar)Calendar.getInstance(), livro.getCodigo());
		}
		catch(CopiaNaoDisponivelEx e){
			System.out.println(e);
			System.exit(1);
		}
	}
	public boolean devolveLivro(Usuario user, Livro livro, int dias){
		try{
			livro.devolve();
			user.setDataDevHistUser(livro, (GregorianCalendar)Calendar.getInstance());
			livro.setDataDevLivro(user);
			ArrayList<Emprest> hist = user.getHist();
			GregorianCalendar dataEntrega,dataMax;
			for(int i = 0; i < hist.size(); i++){
				if(hist.get(i).getCodigoLivroSolicitado() == livro.getCodigo()){
					dataEntrega = hist.get(i).getDataDev();
					dataMax = new GregorianCalendar(hist.get(i).getDataEmp().get(Calendar.YEAR),hist.get(i).getDataEmp().get(Calendar.MONTH), hist.get(i).getDataEmp().get(Calendar.DAY_OF_MONTH));
					dataMax.add(GregorianCalendar.DAY_OF_MONTH, dias);
					int atraso = dataMax.compareTo(dataEntrega);
					if(atraso < 0)
						return true;
					else
						return false;
				}
			}
			return false;
		}
		catch(NenhumaCopiaEmprestadaEx e){
			System.out.println(e);
			System.exit(1);
			return false;
		}
		catch(IllegalArgumentException e){
			System.out.println("Valor no calendario invalido "+ e);
			return false;
		}
		catch(NullPointerException e){
			System.out.println("Calendario nulo" + e);
			return false;
		}
	}
	public Comparator<Livro> titulo = new Comparator<>(){
		public int compare (Livro p1, Livro p2){ 
			String pf1, pf2;
			pf2 = p2.getTitulo();
			pf1 = p1.getTitulo();
			return (pf2.charAt(0) - pf1.charAt(0));
					}
				};
	public Comparator<Usuario> nome = new Comparator<>(){
		public int compare (Usuario p1, Usuario p2){ 
			String pf1, pf2;
			pf2 = p2.getNome();
			pf1 = p1.getNome();
			return (pf2.charAt(0) - pf1.charAt(0));
					}
				};
	public String imprimeLivros(){
		ArrayList<Livro> livros = new ArrayList<>();
		Enumeration<String> e = cadastroLivro.keys();
		while(e.hasMoreElements()){
			String key = e.nextElement();
			livros.add(cadastroLivro.get(key));
		}
		Collections.sort(livros, titulo.reversed());
		return livros.toString();
	}
	public String imprimeUsuarios(){
		ArrayList<Usuario> user = new ArrayList<>();
		Enumeration<Integer> e = cadastroUser.keys();
		while(e.hasMoreElements()){
			int key = e.nextElement();
			user.add(cadastroUser.get(key));
		}
		Collections.sort(user, nome.reversed());
		return user.toString();
	}
	public Livro getLivro(String cod) throws LivroNaoCadastradoEx{
		if(cadastroLivro.get(cod) == null){
			throw new LivroNaoCadastradoEx(cod);
		}
		else{
			return cadastroLivro.get(cod);
		}
	}
	public Usuario getUsuario(int cod) throws UsuarioNaoCadastradoEx{
		if(cadastroUser.get(cod) == null){
			throw new UsuarioNaoCadastradoEx(cod);
		}
		else{
			return cadastroUser.get(cod);
		}
	}
}
