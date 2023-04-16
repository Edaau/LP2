// foi necessario uma alteracao no cpf visto que o tamanho de um cpf ultrapassa o tamanho maximo de um int
// dessa forma foi necessario colocar-lo como long
public class ValidaCPF{
	 public static boolean verificaCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;
        
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } 
        
        public static String imprimeCPF(String CPF) {
       		if(CPF.length() == 11)
		    return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
		    CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
            	else
            		return("0"+CPF.substring(0, 2) + "." + CPF.substring(2, 5) + "." +
            CPF.substring(5, 8) + "-" + CPF.substring(8, 10));
        }
        
        //Verifica se a string passada e convertivel em um CPF.
    	public static boolean isCPF(String s){
    		String cpf = "";
    		for(int i = 0; i<s.length(); i++){
    			if(!(Character.isAlphabetic(s.charAt(i)))){
	    			if(Character.isDigit(s.charAt(i))){
	    				cpf = cpf + s.charAt(i);
	    			
	    			}
    			}
    			else
    				return false;
    		}
    		if(ValidaCPF.verificaCPF(cpf))
    			return true;
    		else
    			return false;
    	}
    	//Verifica se o inteiro passado e convertivel em um CPF.
	public static boolean isCPF(long i){
    		String s = Long.toString(i);
    		String cpf = "";
    		for(int j = 0; j<s.length(); j++){
    			if(Character.isDigit(s.charAt(j))){
    				cpf = cpf + s.charAt(j);
    			
    			}
    		}
    		if(ValidaCPF.verificaCPF(cpf))
    			return true;
    		else
    			return false;
    	
    	}
	public static long toIntCPF(String s){
		ValidaCPF.verificaCPF(s);
		long cpf = Long.parseLong(s);
		return cpf;
	}
	public static long toIntCPF(long i){
		String cpf = Long.toString(i);
		ValidaCPF.verificaCPF(cpf);
		long cpfLong = Long.parseLong(cpf);
		return cpfLong;
	}







}
