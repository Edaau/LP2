package lp2g04.biblioteca;
import java.util.*;
import java.io.Serializable;
public class EmprestPara implements Serializable{
	private GregorianCalendar dataEmprest, dataDev;
	private int codigoUser;
	public EmprestPara(GregorianCalendar dataEmprest, GregorianCalendar dataDev, int codigoUser){
		this.dataEmprest = dataEmprest;
		this.dataDev = dataDev;
		this.codigoUser = codigoUser;
	}
	public GregorianCalendar getDataEmprestimo(){
		return dataEmprest;
	}
	public GregorianCalendar getDataDevolucao(){
		return dataDev;
	}
	public int getCodigoUser(){
		return codigoUser;
	}
	public void setDataEmprestimo(GregorianCalendar data){
		dataEmprest = data;
	}
	public void setDataDevolucao(GregorianCalendar data){
		dataDev = data;
	}
	public void getCodigoUser(int codigo){
		codigoUser = codigo;
	}
	public String toString(){
		return "Data de emprestimo: " + dataEmprest.get(Calendar.DAY_OF_MONTH)+"/"+ (dataEmprest.get(Calendar.MONTH)+1)+"/"+dataEmprest.get(Calendar.YEAR) + "\n" + "Data de devolucao: " + dataDev.get(Calendar.DAY_OF_MONTH)+"/"+ (dataDev.get(Calendar.MONTH)+1)+"/"+dataDev.get(Calendar.YEAR) + "\n" + "Codigo do Usuario que solicitou: " + codigoUser + "\n";}

}
