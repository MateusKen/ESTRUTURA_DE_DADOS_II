
//
//Tabela Hash (Open Addressing/Chaining) - Exemplo de implementação em Java
//Copyright (C) 2023 André Kishimoto
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <https://www.gnu.org/licenses/>.
//

package ClosedAddressHashing;

public class HashFunction {

	public static int mod(int k, int m) {
		
		// 1) -----
		
		//Tranforma a chave em String
		String kStr = Integer.toString(k);
		StringBuilder digitosStr = new StringBuilder();
 		
		//Coloca o primeiro, terceiro e quinto digito na nova String
		 for (int i = 0; i < kStr.length(); i++) {
	         if (i == 0 || i == 2 || i == 4) {
	             digitosStr.append(kStr.charAt(i));
	         }
	     }
		 
		//Nova Chave
		 k = Integer.parseInt(digitosStr.toString());
		 		 
		 // 2) -----
		 
		 //Eleva a chave a 2
		 k = (k * k);
		 
		 //Converte pra String
		 String quadradoStr = Integer.toString(k);
		 
		 //Pega os digitos do meio
		 int meio = quadradoStr.length() / 2;
		 if (quadradoStr.length() % 2 == 0) {
			 quadradoStr = quadradoStr.substring(meio - 1, meio + 1);
		 } else {
			 quadradoStr = quadradoStr.substring(meio, meio);
		 }
		 
		 //Nova Chave
		 k = Integer.parseInt(quadradoStr);
		 
		 System.out.print(k);
		 
		 // 3) -----
		 
		 //Divisao inteira por 7
		 k = k / 7;
		 
		 
		return k % m;
	}
	
}
