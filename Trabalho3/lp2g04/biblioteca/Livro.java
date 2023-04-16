package lp2g04.biblioteca;
import java.util.*;
import java.io.Serializable;
public class Livro implements Serializable{
	private String codigo, titulo, categoria;
	private int quantidade, emprestados;
	private ArrayList<EmprestPara> hist = new ArrayList<>();
	public Livro(String codigo, String titulo, String categoria, int quantidade, int emprestados){
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.emprestados = emprestados;
	}
	public String getCodigo(){
		return codigo;
	}
	public String getTitulo(){
		return titulo;
	}
	public String getCategoria(){
		return categoria;
	}
	public int getQuantidade(){
		return quantidade;
	}
	public int getEmprestados(){
		return emprestados;
	}
	public ArrayList<EmprestPara> getHist(){
		return hist;
	}
	public void setCodigo(String codigo){
		this.codigo = codigo;
		}
	public void setTitulo(String titulo){
		this.titulo = titulo;
		}
	public void setCategoria(String categoria){
		this.categoria = categoria;
		}
	public void setQuantidade(int quantidade){
		this.quantidade = quantidade;
		}
	public void setEmprestados(int emprestados){
		this.emprestados = emprestados;
		}
	public void setHist(ArrayList<EmprestPara> hist){
		this.hist = hist;
		}
	public void empresta() throws CopiaNaoDisponivelEx{
		if(quantidade == 0)
			throw new CopiaNaoDisponivelEx(titulo);
			
		else{
			quantidade--;
			emprestados++;
			}
	}
	public void devolve() throws NenhumaCopiaEmprestadaEx{
		if(emprestados == 0) 
			throw new NenhumaCopiaEmprestadaEx(titulo);	
		else{
			emprestados--;
			quantidade++;
		
		}
	}
	public void addUsuarioHist(GregorianCalendar dataLocacao, GregorianCalendar dataDev, int codigoUser){
		EmprestPara user = new EmprestPara(dataLocacao, dataDev, codigoUser);
		hist.add(user);
	}
	public void setDataDevLivro(Usuario user){
		ArrayList<Emprest> hist = user.getHist();
		for(int i = 0; i < hist.size(); i++){
			if(hist.get(i).getCodigoLivroSolicitado() == codigo){
				addUsuarioHist(hist.get(i).getDataEmp(), hist.get(i).getDataDev(), user.getCodigoUsuario());
			}
		}
		
	}
	public String toString(){
		return "Titulo: "+ titulo + "\n" + "Codigo do Livro: " + codigo + "\n" + "Categoria: "+ categoria +"\n" + "Quantidade: "+ quantidade + "\n" + "emprestados: " + emprestados + "\n" + "Historico do Livro: " + hist.toString() + "\n";
	}
}
