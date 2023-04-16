import java.util.*;
public class Mulher extends PessoaIMC{
	private static final String GENERO = "Mulher";
	private int idade;
	public Mulher(String nome, String sobreNome, int dia, int mes, int ano, double peso, double altura){
		super(nome, sobreNome, dia, mes, ano, peso, altura);
		//coleta a data atual.
		Calendar dataHoje = Calendar.getInstance();
		GregorianCalendar dataAniversario = getDataNasc();
		//verifica se ja fez aniversario no ano atual.
		if(dataHoje.get(Calendar.MONTH) < dataAniversario.get(Calendar.MONTH))
			idade = (dataHoje.get(Calendar.YEAR) - dataAniversario.get(Calendar.YEAR))-1;
		else if(dataHoje.get(Calendar.MONTH) == dataAniversario.get(Calendar.MONTH)){
			if (dataHoje.get(Calendar.DAY_OF_MONTH) < dataAniversario.get(Calendar.DAY_OF_MONTH))
				idade = (dataHoje.get(Calendar.YEAR) - dataAniversario.get(Calendar.YEAR))-1;
			else
				idade = (dataHoje.get(Calendar.YEAR) - dataAniversario.get(Calendar.YEAR));
		}
		else
			idade = (dataHoje.get(Calendar.YEAR) - dataAniversario.get(Calendar.YEAR));
	}
	public void setIdade(int i){
		idade = i;
		}
	public int getIdade(){
		return idade;
	}
	public static String getGenero(){
		return GENERO;
	}
	public String resultIMC(){
		double imc = super.calculaIMC(altura, peso);
		if(imc < 19.0){
			return "Abaixo do peso ideal";
		}
		else if(imc >= 19.0 && imc <= 25.8){
			return "Peso ideal";
		}
		else 
			return "Acima do peso ideal";
	}
	public String toString(){
		return super.toString() + resultIMC() +"\n"+ "Genero: " + GENERO+"\n";
	
	}

}
