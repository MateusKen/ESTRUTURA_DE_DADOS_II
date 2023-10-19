

public class FilaCircular {
	// Constante e Atributos Privados
	private static final int TAM_DEFAULT = 100;
	private int inicio, fim, qtde;
	private BTNode e[ ];
	// Métodos públicos
	public FilaCircular(int tamanho) {// construtor 1 (com tamanho)
		  this.inicio = this.fim = this.qtde = 0;
		  e = new BTNode[tamanho];
	}
	
	public FilaCircular() {  // construtor 2 (sem parâmetros).
		this(TAM_DEFAULT);
	}

	// verifica se a fila está vazia
	public boolean qIsEmpty() {
		return (qtde == 0);
	}
	
	// Verifica se a fila está cheia
    public boolean qIsFull() {
    	return (qtde == e.length); 	
    }
    
    // insere um elemento no final da fila
	public void enqueue(BTNode e) {
		if (! qIsFull( )){
			    this.e[this.fim++] = e;
			    this.fim = this.fim % this.e.length;
			    this.qtde++;
		}
		else 
			    System.out.println("Oveflow - Estouro de Fila");	
	}
	// remove um elemento do final da fila
    public BTNode dequeue() {
    	  BTNode aux;
    	  if (! qIsEmpty( )){
    	   aux =  this.e[ this.inicio];
    	   this.inicio = ++this.inicio % this.e.length;
    	   this.qtde--;
    	   return aux;
    	  }else{
    	    System.out.println("underflow - Esvaziamento de Fila");
    	    return null;
    	  }
    }
    // retorna quem está no início da fila
    // caso a fila não esteja vazia
	public BTNode front() {
		if (! qIsEmpty())
			return e[inicio];
		else{
			System.out.println("underflow - Esvaziamento de Fila");
			return null;
		}			
	}
	// retorna quem está no final da fila caso ela não esteja vazia
	public BTNode rear() {
		if (! qIsEmpty()){
			  int pfinal;
			  if (this.fim != 0) pfinal = this.fim - 1;
			  else pfinal = this.e.length - 1;
			  return this.e[pfinal];
		}else{
			  System.out.println("underflow - Esvaziamento de Fila");
			  return null;
		}			
	}
	// Retorna o total de elementos da fila
	public	int totalElementos(){
		return qtde;
	}
	
	// Sobrescrita/sobreposição (override) do método toString(), que veio da superclasse Object.
	// O retorno do método toString() é a representação de um objeto em formato string, e toString()
	// geralmente é executado (de forma implícita) quando passamos um objeto ao System.out.print*().
	//
	// Experimente incluir o seguinte código na main() e veja a saída:
	// FilaCircular f = new FilaCircular();
	// System.out.println(f);
	//
	// Depois, remova/comente o método toString() abaixo e rode o código acima novamente.
	@Override
	public String toString() {
		
		int indiceNovo = (inicio + qtde) % e.length;
		
		StringBuilder sb = new StringBuilder();
		sb.append("[Fila] quantidade: ")
			.append(qtde)
			.append(", capacidade: ")
			.append(e.length);
		if (qtde != 0) {
			sb.append(", primeiro: ")
				.append(front())
				.append(", último: ")
				.append(rear());
		} 
		
		sb.append("\nConteudo da Fila': [ ");
		if (qtde != 0) {
			if (indiceNovo <= inicio) {
				for (int i = inicio; i < e.length; ++i)
					sb.append("[" + e[i].getData() + "]");
				for (int i = 0; i < indiceNovo; ++i)
					sb.append("[" + e[i].getData() + "]");
			} else {
				for (int i = inicio; i < indiceNovo; ++i)
					sb.append("[" + e[i].getData() + "]");
			}
		}
		sb.append(" ]");
		return sb.toString();
	}
}
