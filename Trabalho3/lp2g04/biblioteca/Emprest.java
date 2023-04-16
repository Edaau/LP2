package lp2g04.biblioteca;
import java.util.*;
import java.io.Serializable;
public class Emprest implements Serializable{
	private GregorianCalendar dataEmp, dataDev;
	private String codigoLivro;
	public Emprest(GregorianCalendar data, String codigo){
		this.dataEmp = data;
		this.codigoLivro = codigo;
	}
	public Emprest(GregorianCalendar dataEmprest, GregorianCalendar dataDev, String codigo){
		this.dataEmp = dataEmprest;
		this.dataDev = dataDev;
		this.codigoLivro = codigo;
	}
	public GregorianCalendar getDataEmp(){
		return this.dataEmp;
	}
	public GregorianCalendar getDataDev(){
		return this.dataDev;
	}
	public String getCodigoLivroSolicitado(){
		return this.codigoLivro;
	}
	public void setDataEmp(GregorianCalendar dataEmp){
		this.dataEmp = dataEmp;
	}
	public void setDataDev(GregorianCalendar dataDev){
		this.dataDev = dataDev;
		}
	public void setCodigoLivroSolicitado(String codigo){
		this.codigoLivro = codigo;
		}
	public String toString(){
		if(dataDev == null){
			return "Data de emprestimo: " + dataEmp.get(Calendar.DAY_OF_MONTH)+"/"+ (dataEmp.get(Calendar.MONTH)+1)+"/"+dataEmp.get(Calendar.YEAR) + "\n" + "Codigo do livro solicitado: " + codigoLivro + "\n";
			}
		else{
		return "Data de emprestimo: " + dataEmp.get(Calendar.DAY_OF_MONTH)+"/"+ (dataEmp.get(Calendar.MONTH)+1)+"/"+dataEmp.get(Calendar.YEAR) + "\n" + "Data de devolucao: " + dataDev.get(Calendar.DAY_OF_MONTH)+"/"+ (dataDev.get(Calendar.MONTH)+1)+"/"+dataDev.get(Calendar.YEAR) + "\n" + "Codigo do livro solicitado: " + codigoLivro + "\n";}}







}
