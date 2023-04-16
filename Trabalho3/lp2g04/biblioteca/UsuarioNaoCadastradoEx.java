package lp2g04.biblioteca;
public class UsuarioNaoCadastradoEx extends Exception{
	private static final long serialVersionUID = 0l;
	private int codigo;
	public UsuarioNaoCadastradoEx(int codigo){
		this.codigo = codigo;
	
	}
	public int getCodigo(){
		return codigo;
	}
	public String toString(){
		return ("O usuario com o codigo: " + this.codigo + " nao esta cadastrado.");
	
	}


}
