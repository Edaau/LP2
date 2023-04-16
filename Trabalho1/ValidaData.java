// foi necessario uma alteracao no cpf visto que o tamanho de um cpf ultrapassa o tamanho maximo de um int
// dessa forma foi necessario colocar-lo como long
public class ValidaData {
	public static boolean isDia(int dia){
		if(dia >= 1 && dia <= 30)
			return true;
		else
			return false;
	
	}
	public static boolean isDia(String dia){
		for(int i = 0; i<dia.length();i++){
			if( !(Character.isDigit(dia.charAt(i))))
				return false;
		}
		
		int day = Integer.parseInt(dia);
		if(day >= 1 && day <= 30)
			return true;
		else
			return false ;
	
	}

	public static boolean isMes(int mes){
		if(mes >= 1 && mes <= 12)
			return true;
		else
			return false;
	
	}
	public static boolean isMes(String mes){
		for(int i = 0; i<mes.length();i++){
			if( !(Character.isDigit(mes.charAt(i))))
				return false;
		}
		int month = Integer.parseInt(mes);
		if(month >= 1 && month <= 12)
			return true;
		else
			return false;
	}
	public static boolean isAno(int ano){
		if(ano >= 1910 && ano <= 2023)
			return true;
		else
			return false;
	
	}
	public static boolean isAno(String ano){
		for(int i = 0; i<ano.length();i++){
			if( !(Character.isDigit(ano.charAt(i))))
				return false;
		}
		int year = Integer.parseInt(ano);
		if(year >= 1910 && year <= 2023)
			return true;
		else
			return false;
	
	}





}
