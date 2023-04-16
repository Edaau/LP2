// foi necessario uma alteracao no cpf visto que o tamanho de um cpf ultrapassa o tamanho maximo de um int
// dessa forma foi necessario colocar-lo como long
import java.util.*;
public class Pessoa{
	private String nome, sobreNome;
	private GregorianCalendar dataNasc;
	private long numCPF;
	//Campo para contar quantas pessoas foram criadas.
	private static int contInstancias = 0;
	public Pessoa(String nome, String sobreNome, int dia, int mes, int ano){
		this.nome = nome;
		this.sobreNome = sobreNome;
		//E necessario tirar uma unidade do mes passado visto que a classe Calendar utiliza os meses sendo de 0 a 11 sendo 0 o mes de janeiro.
		this.dataNasc = new GregorianCalendar(ano, mes-1, dia);
		this.contInstancias++;
	}
	public Pessoa(String nome, String sobreNome, int dia, int mes, int ano, long numCPF,float peso, float altura){
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataNasc = new GregorianCalendar(ano, mes-1, dia);
		this.numCPF = numCPF;
		this.peso = peso;
		this.altura = altura;
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
	public void setNumCPF(long cpf){
		numCPF = cpf;
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
	public long getNumCPF(){
		return numCPF;
	}
	//verifica se o peso e valido
	public static boolean isPeso(String peso){
		try{
			float weight = Float.parseFloat(peso);
			if(weight > 2.5f && weight < 300.0f)
				return true;
			else
				return false;
		}
		catch(NumberFormatException nfe) {
			return false;
		}
	}
	public static boolean isPeso(float peso){
		if(peso > 2.5f && peso < 300.0f)
			return true;
		else
			return false;
	}
	//verifica se a altura e valido
	public static boolean isAltura(String altura){
		try{
			float height = Float.parseFloat(altura);
			if(height > 0.45f && height < 2.38f)
				return true;
			else
				return false;
		}
		catch(NumberFormatException nfe) {
			return false;
		}
	}
	public static boolean isAltura(float altura){
		if(altura > 0.45f && altura < 2.38f)
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
	public String toString(){
		if(numCPF == 0)
			return "Nome: "+ nome +"\n"+"Sobrenome: " + sobreNome+"\n" + "Data de nascimento: "+ dataNasc.get(Calendar.DAY_OF_MONTH)+"/"+ (dataNasc.get(Calendar.MONTH)+1)+"/"+dataNasc.get(Calendar.YEAR)+"\n"+"Numero do CPF: "+"Nao informado\n"+"Peso: "+"Nao informado\n"+"Altura: "+"Nao informado";
		else
			return "Nome: "+ nome +"\n"+"Sobrenome: " + sobreNome+"\n" + "Data de nascimento: "+ dataNasc.get(Calendar.DAY_OF_MONTH)+"/"+ (dataNasc.get(Calendar.MONTH)+1)+"/"+dataNasc.get(Calendar.YEAR)+"\n"+"Numero do CPF: "+ValidaCPF.imprimeCPF(Long.toString(numCPF))+"\n"+"Peso: "+peso+"\n"+"Altura: "+altura;
	}
	

}
