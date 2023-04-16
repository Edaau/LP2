// foi necessario uma alteracao no cpf visto que o tamanho de um cpf ultrapassa o tamanho maximo de um int
// dessa forma foi necessario colocar-lo como long
import java.util.*;
public class Pessoa{
	private String nome, sobreNome;
	private GregorianCalendar dataNasc;
	//Campo para contar quantas pessoas foram criadas.
	private static int contInstancias = 0;
	public Pessoa(String nome, String sobreNome, int dia, int mes, int ano){
		this.nome = nome;
		this.sobreNome = sobreNome;
		//E necessario tirar uma unidade do mes passado visto que a classe Calendar utiliza os meses sendo de 0 a 11 sendo 0 o mes de janeiro.
		this.dataNasc = new GregorianCalendar(ano, mes-1, dia);
		this.contInstancias++;
	}
	
	public Pessoa(){
		this.contInstancias++;
	}
	public static int numPessoas(){
		return contInstancias;
	} 
	public void setNome(String s){
		nome = s;
	}
	public void setSobreNome(String s){
		sobreNome = s;
	}
	public void setDataNasc(int ano, int mes, int dia){
		if(dataNasc instanceof GregorianCalendar){
			dataNasc.set(ano, mes-1, dia);
		}
		else{
			dataNasc = new GregorianCalendar(ano, mes-1, dia);
		
		}
	}
	public String getNome(){
		return nome;
	}
	public String getSobreNome(){
		return sobreNome;
	}
	public GregorianCalendar getDataNasc(){
		return dataNasc;
	}
	
	//verifica se o peso e valido
	public static boolean isPeso(String peso){
		try{
			double weight = Double.parseDouble(peso);
			if(weight > 2.5 && weight < 300.0)
				return true;
			else
				return false;
		}
		catch(NumberFormatException nfe) {
			return false;
		}
	}
	public static boolean isPeso(double peso){
		if(peso > 2.5 && peso < 300.0)
			return true;
		else
			return false;
	}
	//verifica se a altura e valido
	public static boolean isAltura(String altura){
		try{
			double height = Double.parseDouble(altura);
			if(height > 0.45 && height < 2.38)
				return true;
			else
				return false;
		}
		catch(NumberFormatException nfe) {
			return false;
		}
	}
	public static boolean isAltura(double altura){
		if(altura > 0.45 && altura < 2.38)
			return true;
		else
			return false;
	}
	//verifica se o nome e valido.
	public static boolean isNome(String s){
		boolean validade = true;
		for(int i = 0 ; i<s.length(); i++){
			if(!(Character.isAlphabetic(s.charAt(i)))){
				validade = false;
			}
		}
		if(s.equals(""))
			validade = false;
		return validade;
	}
	//verifica se o sobrenome e valido.
	public static boolean isSobreNome(String s){
		boolean validade = true;
		for(int i = 0 ; i<s.length(); i++){
			if(!(Character.isAlphabetic(s.charAt(i)))){
				validade = false;
			}
		}
		if(s.equals(""))
			validade = false;
		return validade;
	}
	//verifica se o tamanho do array e valido.
	public static boolean isArray(String s){
		for(int i = 0; i<s.length();i++){
			if( !(Character.isDigit(s.charAt(i))))
				return false;
		}
		if(s.equals(""))
			return false;
		int tamanho = Integer.parseInt(s);
		if(tamanho >= 0)
			return true;
		else
			return false;
	
	}
	public static boolean isArray(int i){
		if(i >= 0)
			return true;
		else
			return false;
	}
	public static boolean isResposta1(String r1){
		for(int i = 0; i<r1.length();i++){
			if( !(Character.isDigit(r1.charAt(i))))
				return false;
		}
		if(r1.equals(""))
			return false;
		int R1 = Integer.parseInt(r1);
		if(R1 == 1 || R1 == 2)
			return true;
		else
			return false ;
	
	}
	public static boolean isResposta2(String r2){
		for(int i = 0; i<r2.length();i++){
			if( !(Character.isDigit(r2.charAt(i))))
				return false;
		}
		if(r2.equals(""))
			return false;
		int R2 = Integer.parseInt(r2);
		if(R2 >= 1 && R2 <= 12)
			return true;
		else
			return false ;
	
	}
	public String toString(){
		return "Nome: "+ nome +" "+sobreNome+"\n"+"Data de nascimento: "+ dataNasc.get(Calendar.DAY_OF_MONTH)+"/"+ (dataNasc.get(Calendar.MONTH)+1)+"/"+dataNasc.get(Calendar.YEAR)+"\n";
	}
	

}
