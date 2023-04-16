package lp2g04.biblioteca;
public class LivroNaoCadastradoEx extends Exception{
	private static final long serialVersionUID = 0l;
	private String codigo;
	public LivroNaoCadastradoEx(String codigo){
		this.codigo = codigo;
	
	}
	public String getCodigo(){
		return codigo;
	}
	public String toString(){
		return ("O livro com o codigo: " + this.codigo + " nao esta cadastrado.");
	
	}


}
