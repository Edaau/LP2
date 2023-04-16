package lp2g04.biblioteca;
import java.util.*;
import java.io.Serializable;
public class Usuario extends Pessoa implements Serializable{
	private String endereco;
	private int codigoUsuario;
	private ArrayList<Emprest> hist;
	public Usuario(String nome, String sobreNome, int dia, int mes, int ano, String endereco,int codigoUsuario){
		super(nome, sobreNome, dia, mes, ano);
		this.endereco = endereco;
		this.codigoUsuario = codigoUsuario;
		this.hist = new ArrayList<Emprest>();
		}
	public void addLivroHist(GregorianCalendar data, String codigo) {
		Emprest locacao = new Emprest(data, codigo);
		hist.add(locacao);
	         }
	public String getEndereco(){
		return this.endereco;
	}
	public int getCodigoUsuario(){
		return this.codigoUsuario;
	}
	public ArrayList<Emprest> getHist(){
		return this.hist;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public void setCodigoUsuario(int codigo){
		this.codigoUsuario = codigo;
	}
	public void setDataDevHistUser(Livro livro, GregorianCalendar dataDev){
		for(int i = 0; i < hist.size(); i++){
			if(hist.get(i).getCodigoLivroSolicitado() == livro.getCodigo()){
				hist.get(i).setDataDev(dataDev);
			}
		}
		
	}
	public String toString(){
		return super.toString() + "Endereco: "+ endereco + "\n" + "Codigo do Usuario: " + codigoUsuario + "\n" + "Historico do Usuario: " + hist + "\n";
	}
}
