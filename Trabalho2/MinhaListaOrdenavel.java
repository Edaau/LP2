import java.util.*;
public class MinhaListaOrdenavel {
	ArrayList<PessoaIMC> pessoas = new ArrayList<>(); 
	public static final int ALFABETICA = 1, ALFABETICA_REVERSO = 2, PESO = 3, PESO_REVERSO = 4, ALTURA = 5, ALTURA_REVERSO= 6, IMC = 7, IMC_REVERSO = 8, GENERO= 9 , GENERO_REVERSO= 10, DATA_DE_NASC = 11, DATA_DE_NASC_REVERSO = 12;
	public void add(PessoaIMC p){
		pessoas.add(p);
	}
	public PessoaIMC get(int index){
		return pessoas.get(index);
	}
	public Comparator<PessoaIMC> pesoC = new Comparator<>(){
		public int compare (PessoaIMC p1, PessoaIMC p2){ 
			double pf1, pf2;
			pf2 = p2.getPeso();
			pf1 = p1.getPeso();
			return (int)Math.round (pf2 - pf1);
							}
						};
	public Comparator<PessoaIMC> alturaC = new Comparator<>(){
		public int compare (PessoaIMC p1, PessoaIMC p2){ 
			double pf1, pf2;
			pf2 = p2.getAltura();
			pf1 = p1.getAltura();
			return (int)Math.round ((pf2*100) - (pf1*100));
					}
				};
	public Comparator<PessoaIMC> IMCComparator = new Comparator<>(){
		public int compare (PessoaIMC p1, PessoaIMC p2){ 
			double pf1, pf2;
			pf2 = p2.calculaIMC(p2.getAltura(), p2.getPeso());
			pf1 = p1.calculaIMC(p1.getAltura(), p1.getPeso());
			return (int)Math.round ((pf2*100) - (pf1*100));
}
};
	public Comparator<PessoaIMC> nomeAZC = new Comparator<>(){
		public int compare (PessoaIMC p1, PessoaIMC p2){ 
			String pf1, pf2;
			pf2 = p2.getNome();
			pf1 = p1.getNome();
			return (pf2.charAt(0) - pf1.charAt(0));
					}
				};
	public Comparator<PessoaIMC> generoC = new Comparator<>(){
		public int compare (PessoaIMC p1, PessoaIMC p2){			
			if(p2 instanceof Homem)
				return 1;
			else
				return -1;
					}
				};
	public Comparator<PessoaIMC> dataNascComparator = new Comparator<>(){
		public int compare (PessoaIMC p1, PessoaIMC p2){ 
			GregorianCalendar data1, data2;
			data1 = p1.getDataNasc();
			data2 = p2.getDataNasc();
			return data2.compareTo(data1);
}
};
	public ArrayList ordena(int criterio){
		switch(criterio){
			case ALFABETICA:
				Collections.sort(pessoas, nomeAZC.reversed());
				break;
			case ALFABETICA_REVERSO:
				Collections.sort(pessoas, nomeAZC);
				break;
			case PESO:
				Collections.sort(pessoas, pesoC.reversed());
				break;
			case PESO_REVERSO:
				Collections.sort(pessoas, pesoC);
				break;
			case ALTURA:
				Collections.sort(pessoas, alturaC);
				break;
			case ALTURA_REVERSO:
				Collections.sort(pessoas, alturaC.reversed());
				break;
			case IMC:
				Collections.sort(pessoas, IMCComparator.reversed());
				break;
			case IMC_REVERSO:
				Collections.sort(pessoas, IMCComparator);
				break;
			case GENERO:
				Collections.sort(pessoas, generoC.reversed());
				break;
			case GENERO_REVERSO:
				Collections.sort(pessoas, generoC);
				break;
			case DATA_DE_NASC:
				Collections.sort(pessoas, dataNascComparator.reversed());
				break;
			case DATA_DE_NASC_REVERSO:
				Collections.sort(pessoas, dataNascComparator);
				break;
			default:
				System.out.println("Por favor escolha um numero de 1 a 12!");
		}
		return pessoas;
	
	}



}
