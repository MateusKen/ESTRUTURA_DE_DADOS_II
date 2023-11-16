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

public class MainChaining {
	
	private static void isEmpty(HashTable hashTable) {
		System.out.println("Hash table is" + (hashTable.isEmpty() ? " " : " not ") + "empty.");
		
	}
	
	private static void search(HashTable hashTable, int key) {
		System.out.print("search(" + key + "): ");
		String value = hashTable.search(key);
		System.out.println(value == null ? "Search returned null." : value);
	}
	
	private static void insert(HashTable hashTable, int key, String value) {
		System.out.print("insert(" + key + ", " + value + "): ");
		
		InsertResult result = hashTable.insert(key, value);
		System.out.println(switch (result) {
			case WithCollision -> "InsertResult.WithCollision";
			case WithoutCollision -> "InsertResult.WithoutCollision";
			case Updated -> "InsertResult.Updated";
			case NoSlotAvailable -> "InsertResult.NoSlotAvailable";
		});
	}

	private static void remove(HashTable hashTable, int key) {
		System.out.print("remove(" + key + "): ");
		boolean result = hashTable.remove(key);
		System.out.println(result ? "Removed!" : "Key not found.");
		
	}

	public static void main(String[] args) {
		System.out.println("***** Hash table - Chaining *****");

		HashTable hashTable = new HashTableChaining(7);
		isEmpty(hashTable);
		
		int keys[] = { 50078, 50327, 50720, 50782, 50898, 50013, 50329, 50721, 50897, 50899, 51032 };
		String values[] = {
			"BANCO DE DADOS",
			"ESTRUTURA DE DADOS I",
			"MODELAGEM MATEMATICA I",
			"ORGANIZACAO DE COMPUTADORES",
			"PROJETO E ANALISE DE ALGORITMOS I",
			"ALGORITMOS NUMERICOS",
			"ESTRUTURA DE DADOS II",
			"MODELAGEM MATEMATICA II",
			"PROJETO DE SOFTWARE",
			"PROJETO E ANALISE DE ALGORITMOS II",
			"SISTEMAS OPERACIONAIS"
		};

		System.out.println("----------");
		for (int i = 0; i < keys.length; ++i) {
			insert(hashTable, keys[i], values[i]);
		}

		System.out.println("----------");
		System.out.println(hashTable);

		System.out.println("----------");
		int index = 0;
		int key = keys[index];
		search(hashTable, key);
		remove(hashTable, key);
		search(hashTable, key);
		index = 10;
		key = keys[index];
		search(hashTable, key);
		remove(hashTable, key);
		search(hashTable, key);

		System.out.println("----------");
		for (int i = 1; i < 5; ++i) {
			remove(hashTable, keys[i]);
		}

		System.out.println("----------");
		System.out.println(hashTable);

		System.out.println("----------");
		index = 5;
		key = keys[index];
		insert(hashTable, key, values[index]);
		insert(hashTable, key, values[index].toLowerCase());

		System.out.println("----------");
		index = 10;
		key = keys[index];
		insert(hashTable, key, values[index].toLowerCase());

		System.out.println("----------");
		System.out.println(hashTable);

		System.out.println("----------");
		for (int i = 0; i < keys.length; ++i) {
			search(hashTable, keys[i]);
		}
	}

}
