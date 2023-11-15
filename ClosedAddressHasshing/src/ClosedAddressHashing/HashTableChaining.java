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

//import java.util.Iterator;
import java.util.LinkedList;

public class HashTableChaining implements HashTable {

	private final static int HASH_TABLE_DEFAULT_SIZE = 127; 
	private LinkedList<HashTableData> table[];
	private int count;
	
	public HashTableChaining() {
		this(HASH_TABLE_DEFAULT_SIZE);
	}
	
	public HashTableChaining(int size) {
		table = new LinkedList[size];
		for (int i = 0; i < size; ++i) {
			table[i] = new LinkedList<HashTableData>();
		}
		count = 0;
	}
	
	@Override
	public String search(int key) {
		int hashKey = HashFunction.mod(key, table.length);
		
		for (var entry : table[hashKey]) {
			if (entry.getKey() == key) {
				return entry.getValue();
			}
		}

		return null;
	}

	@Override
	public InsertResult insert(int key, String value) {
		int hashKey = HashFunction.mod(key, table.length);

		InsertResult result = table[hashKey].isEmpty() ? InsertResult.WithoutCollision : InsertResult.WithCollision;
		System.out.println("insert - hashKey: " + hashKey);

		for (var entry : table[hashKey]) {
			if (entry.getKey() == key) {
				entry.setValue(value);
				return InsertResult.Updated;
			}
		}
		
		table[hashKey].add(new HashTableData(key, value));
		++count;

		return result;
	}

	@Override
	public boolean remove(int key) {
		int hashKey = HashFunction.mod(key, table.length);


//		final Iterator<HashTableData> it = table[hashKey].iterator();
//		while (it.hasNext()) {
//			if (it.next().getKey() == key) {
//				it.remove();
//				--count;
//				return true;
//			}
//		}

		// Código a seguir para Java 8+ é equivalente ao loop acima.
		boolean removed = table[hashKey].removeIf(entry -> entry.getKey() == key);
		if (removed) {
			--count;
		}

		return removed;
	}

	@Override
	public boolean isEmpty() {
		// Se não tiver um contador na classe, podemos verificar se a tabela hash está vazia
		// com o seguinte código:
//		boolean isEmpty = true;
//		for (var list : table) {
//			isEmpty = isEmpty && list.isEmpty();
//		}
//		return isEmpty;
		
		return count == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("count: " + count + "\n");
		
		int i = 0;
		for (var list : table) {
			sb.append("[" + i + "] " + (list.isEmpty() ? "<empty>" : list.toString()) + "\n");
			++i;
		}
		
		return sb.toString();
	}

}
