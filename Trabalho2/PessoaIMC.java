public abstract class PessoaIMC extends Pessoa{
	protected double peso;
	protected double altura;
	public PessoaIMC(String nome, String sobreNome, int dia, int mes, int ano, double peso, double altura){
		super(nome,sobreNome,dia,mes,ano);
		this.peso = peso;
		this.altura = altura;
	}
	public double getPeso(){
		return peso;
	}
	public double getAltura(){
		return altura;
	}
	public double calculaIMC(double altura, double peso){
		return (peso/(altura*altura));
	}
	abstract String resultIMC();
	public String toString(){
		return super.toString() + "Peso: "+ peso+"\n"+"Altura: "+altura+"\n"+String.format("IMC: %.2f",calculaIMC(altura,peso))+" ";
	}



}
