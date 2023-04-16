package lp2g04.biblioteca;
public class CopiaNaoDisponivelEx extends Exception{
	private static final long serialVersionUID = 0l;
	private String livro;
	public CopiaNaoDisponivelEx (String livro){
		this.livro = livro;
	
	}
	public String getLivro(){
		return livro;
	}
	public String toString(){
		return ("O livro: " + this.livro + " nao esta disponivel, pois todas as copias ja foram emprestadas.");
	
	}



}
