package lp2g04.biblioteca;
public class NenhumaCopiaEmprestadaEx extends Exception{
	private static final long serialVersionUID = 0l;
	private String livro;
	public NenhumaCopiaEmprestadaEx(String livro){
		this.livro = livro;	
	}
	public String getLivro(){
		return livro;
	}
	public String toString(){
		return ("O livro: " + this.livro + " nao possui copias que foram emprestadas.");
	
	}

}
