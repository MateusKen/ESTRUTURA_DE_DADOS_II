
public class AVL extends BST{

  private BTNode raiz;
  private int nElem;   // Número de elementos (nós) na árvore
  private int fb; // fator de balanceamento
  
  public AVL()  { raiz = null;  nElem=0; }

  public AVL(String e){
    raiz = new BTNode(e);
    nElem = 1;
  }

  public BTNode getNoRaiz(){ return raiz; }
  
  public int getFb() {
	  return fb;
}
  public void setFb(int fb) {
	  this.fb = fb;
  }
  
  
  private int calculaAlturaAVL(){
  	int cont = -1;
  	if (!isEmpty()){
  		return 1 + Math.max(raiz.left.getHeight(), raiz.right.getHeight());
  	}
  	return cont;
  }

  private void setNoRaiz(BTNode novoNoRaiz){
  	raiz = novoNoRaiz;
  }

  public int getNElem(){ return nElem; }
  public void setNElem(int nElem){ this.nElem = nElem; }

  public boolean isEmpty(){
    if (raiz == null)
      return true;
    else
      return false;
  }

  public BTNode searchAVL( String e ){
    return searchBTNode(raiz, e);
  }
  
  private BTNode searchBTNode( BTNode noAtual, String e ){
    BTNode aux;
    if (noAtual != null) {
      if (noAtual.getData().compareTo( e ) == 0) // Se elemento encontrado
        return noAtual;
      else{ // Se n�o encontrado, busca primeiro do lado esquerdo
        aux = searchBTNode( noAtual.getLeft(), e );
        if (aux == null)  // Procura do lado direito da �rvore
          aux = searchBTNode( noAtual.getRight(), e );
        return aux;
      }
    } else // Elemento �dado� n�o encontrado na �rvore
      return null;
  }


  //Percurso em ordem
  public void emOrdemSimetrica( BTNode raiz ){
    if (raiz != null){
      emOrdemSimetrica( raiz.getLeft() );
      System.out.println( raiz.getData() );
      emOrdemSimetrica( raiz.getRight() );
    }
  }
  //Percurso pre ordem
  public void preOrdem( BTNode raiz ){
    if (raiz != null){
      System.out.println( raiz.getData() );
      preOrdem( raiz.getLeft() );
      preOrdem( raiz.getRight() );
    }
  }
  //Percurso pos ordem
  public void posOrdem( BTNode raiz ){
    if (raiz != null){
      posOrdem( raiz.getLeft() );
      posOrdem( raiz.getRight() );
      System.out.println( raiz.getData() );
    }
  }
  
  //Percurso em nível
  public void emNivel(){
    BTNode noAux;
    FilaCircular f;
    if (raiz != null){
      f = new FilaCircular();
      f.enqueue( raiz );
      while( !f.qIsEmpty() ){
        noAux = (BTNode) f.dequeue ();
        if (noAux.getLeft() != null)
          f.enqueue( noAux.getLeft() );
        if (noAux.getRight() != null)
          f.enqueue( noAux.getRight() );
        String pai = null;
        if (noAux.getParent()!=null) pai = noAux.getParent().getData();
        System.out.println( noAux.getData()  +" pai:"+pai);
      }
    }
  }
	

  /* rota��o tipo LL */
  private BTNode rotacaoLL(BTNode desbA)
  {
   BTNode aux;

   aux = desbA.getLeft();
   if (desbA.getParent() != null){   /* verifica se desb n�o � a raiz */
      if (desbA.getParent().getLeft() == desbA)
          desbA.getParent().setLeft( aux );
        else
         desbA.getParent().setRight( aux );
   }

    aux.setParent( desbA.getParent() );
    desbA.setLeft( aux.getRight() );

    if (desbA.getLeft() != null)
       desbA.getLeft().setParent( desbA );

    aux.setRight( desbA );
    desbA.setParent( aux );

    return( aux );
  }

/* rota��o tipo RR */
private BTNode rotacaoRR(BTNode desbA)
{
  BTNode aux;

  aux = desbA.getRight();
  if (desbA.getParent() != null)   /* verifica se desb n�o � a raiz */
     if (desbA.getParent().getLeft() == desbA)
        desbA.getParent().setLeft( aux );
     else
        desbA.getParent().setRight( aux );

  aux.setParent( desbA.getParent() );
  desbA.setRight( aux.getLeft() );
  if (desbA.getRight() != null)
     desbA.getRight().setParent( desbA );
  aux.setLeft( desbA );
  desbA.setParent( aux );

  return(aux);
}


/* rota��o tipo LR */
private BTNode rotacaoLR(BTNode desbA)
{
  desbA.setLeft ( rotacaoRR( desbA.getLeft() ) );
  return( rotacaoLL(desbA) );
}


/* rota��o tipo RL */
private BTNode rotacaoRL(BTNode desbA)
{
  desbA.setRight( rotacaoLL( desbA.getRight() ) );
  return( rotacaoRR(desbA) );
}

private boolean flagInsercao;

public void insereAVL(String k)
{
  flagInsercao = false;
  setNoRaiz(insereBTNode(raiz, k));
  setNElem(getNElem() + 1 );
}


private BTNode insereBTNode(BTNode noAtual, String x )
{
  if (noAtual != null)
  { BTNode subDir =  noAtual.getRight();
  BTNode subEsq =  noAtual.getLeft();
  int Fb = subDir.getHeight()- subEsq.getHeight();
  
  BTNode subEsqEsq = noAtual.getLeft().getLeft();
  BTNode subEsqDir = noAtual.getLeft().getRight();
	  int FbEsq = subEsqDir.getHeight() - subEsqEsq.getHeight();
	  
	  BTNode subDirEsq = noAtual.getRight().getLeft();
  BTNode subDirDir = noAtual.getRight().getRight();
	  int FbDir = subDirDir.getHeight() - subDirEsq.getHeight();
    if (noAtual.getData().compareTo( x ) > 0)
    {
      noAtual.setLeft( insereBTNode( noAtual.getLeft(), x ) );
      noAtual.getLeft().setParent( noAtual );
      if (flagInsercao)
      {	
  
        switch( Fb ){
           case -1: Fb = 0;
                   flagInsercao = false;
                   break;
           case 0: Fb = 1;
                   break;
           case 1: 	
        	   		if (FbEsq == 1)
                    {
                      noAtual = rotacaoLL(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      Fb = 0;
          	   		  FbDir = 0;
                    }
                    else
                    {
                      noAtual = rotacaoLR(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      if (Fb==0)
                      { //1�Caso
                    	  FbDir = 0;
                          FbEsq = 0;
                      }
                      else if (Fb == 1)
                      { //2�Caso
                        FbEsq = 0;
                        FbDir = -1;
                      }
                      else
                      { //3�Caso
                        FbEsq = 1;
                        FbDir = 0;
                      }
                      Fb = 0;
                    }
                    flagInsercao = false;
                    break;
        }
      }
    }
    else
    {
      noAtual.setRight( insereBTNode(noAtual.getRight(), x));
      noAtual.getRight().setParent( noAtual );
      if ( flagInsercao )
      {
        switch( Fb ){
           case -1: if (FbDir == -1)
                    {
                      noAtual = rotacaoRR(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      Fb=0;
                      FbEsq = 0;
                    }
                    else
                    {
                      noAtual = rotacaoRL(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      if (Fb==0)
                      { //1�Caso
                        FbDir = 0;
                        FbEsq = 0;
                      }
                      else if (Fb == -1)
                      { //2�Caso
                    	  FbDir = 0;
                    	  FbEsq = -1;
                      }
                      else
                      { //3�Caso
                    	  FbDir = -1;
                    	  FbEsq = 0;
                      }
                      Fb = 0;
                    }
                    flagInsercao = false;
                   break;
           case 0: Fb = -1;
                   break;
           case 1: Fb = 0; 
                   flagInsercao=false;
                   break;
         }
       }
    }
 }
 else
 {
    noAtual = new BTNode( x, 0, null, null, null );

    flagInsercao = true;
 }
 return( noAtual );
}


private boolean flagRemove;
    
    public boolean removeAVL(String k){
        flagRemove=false;
        if (raiz == null) {
            System.out.println("Erro na remo��o, a �rvore est� vazia !");
            return false;
        }
        else if (searchAVL(k)==null){
            System.out.println("Erro na remo��o, elemento n�o existente !");
            return false;
        }
        else {
            raiz = removeBTNode(raiz, k);
            setNElem( getNElem() - 1 );
            return true;
        }
    }

    private BTNode removeBTNode(BTNode noAtual, String x){
        if (noAtual.getData().compareTo( x ) > 0){
            noAtual.setLeft(removeBTNode(noAtual.getLeft(),x));
            if (flagRemove)
                noAtual = balanceamentoEsquerdo(noAtual);
        }
        else if (noAtual.getData().compareTo(x)<0){
            noAtual.setRight(removeBTNode(noAtual.getRight(),x));
            if (flagRemove)
                noAtual = balanceamentoDireito(noAtual);
        }
        else { //Encontrou o n� a ser removido
            if (noAtual.getRight()==null){
                if (noAtual.getLeft()!=null){ //Escolhe o n� � esquerda como substituto
                    noAtual.getLeft().setParent(noAtual.getParent());
                }
                noAtual = noAtual.getLeft();
                flagRemove = true;
            }
            else if (noAtual.getLeft()==null){
                if (noAtual.getRight()!=null){ //Escolhe o n� � direita como substituto
                    noAtual.getRight().setParent(noAtual.getParent());
                }
                noAtual = noAtual.getRight();
                flagRemove = true;
            }
            else{ // Busca o elemento mais � direita do n� esquerdo
                noAtual.setLeft(buscaRemove(noAtual.getLeft(), noAtual));
                //Se necess�rio efetua balanceamento (Esquerdo pois a fun��o 
                //busca_remove foi para o n� esquerdo)
                if (flagRemove){
                    noAtual = balanceamentoEsquerdo(noAtual);
                }
            }
        }
        
        return noAtual;
    }
 
    private BTNode balanceamentoEsquerdo (BTNode no){
    	BTNode subDir =  no.getRight();
    	  BTNode subEsq =  no.getLeft();
    	  int Fb = subDir.getHeight()- subEsq.getHeight();
    	  
    	  BTNode subEsqEsq = no.getLeft().getLeft();
    	  BTNode subEsqDir = no.getLeft().getRight();
    		  int FbEsq = subEsqDir.getHeight() - subEsqEsq.getHeight();
    		  
    		  BTNode subDirEsq = no.getRight().getLeft();
    	  BTNode subDirDir = no.getRight().getRight();
    		  int FbDir = subDirDir.getHeight() - subDirEsq.getHeight();
        switch (Fb){
            case 1:
                Fb = 0;
                break;
            case 0:
                Fb = -1;
                flagRemove=false;
                break;
            case -1:
                if (FbDir<=0){
                    subDir = rotacaoRR(no);
                    if (FbDir == 0){
                        Fb = -1;
                        FbDir = 1;
                        flagRemove = false;
                    }
                    else{
                        Fb = 0;
                        FbDir = 0;
                    }
                    no = subDir;
                }
                else{
                    no = rotacaoRL(no);
                    if (Fb==0){
                    	FbDir = 0; FbEsq=0;}
             		else if (Fb==-1){ Fb=0; 
             		FbDir = 0; FbEsq=1;}
             		else {Fb=0; 
             		FbDir = -1; FbEsq=0;} 
                }
        }
        return (no);
    }
    
    private BTNode balanceamentoDireito (BTNode no){
    	BTNode subDir =  no.getRight();
  	  BTNode subEsq =  no.getLeft();
  	  int Fb = subDir.getHeight()- subEsq.getHeight();
  	  
  	  BTNode subEsqEsq = no.getLeft().getLeft();
  	  BTNode subEsqDir = no.getLeft().getRight();
  		  int FbEsq = subEsqDir.getHeight() - subEsqEsq.getHeight();
  		  
  		  BTNode subDirEsq = no.getRight().getLeft();
  	  BTNode subDirDir = no.getRight().getRight();
  		  int FbDir = subDirDir.getHeight() - subDirEsq.getHeight();
        switch (Fb){
            case -1:
            	 Fb = 0;
                break;
            case 0:
            	 Fb = 1;
                flagRemove=false;
                break;
            case 1:
                
                if (FbEsq>=0){
                    subEsq = rotacaoLL(no);
                    if (FbEsq == 0){
                        Fb = 1;
                        FbEsq=-1;
                        flagRemove = false;
                    }
                    else{
                    	Fb = 0;
                    	FbEsq=0;
                    }
                    no = subEsq;
                }
                else{
                    no = rotacaoLR(no);
                    if (Fb==0){
                  		FbDir=0; FbEsq=0;}
             		else if (Fb==1){ Fb=0; 
             		FbDir=-1; FbEsq=0;}
             		else {Fb = 0; 
             		FbDir=0;FbEsq=1;} 
                }
        }
        return (no);  
    }

    private BTNode buscaRemove(BTNode noAtual, BTNode noChave){
        
        BTNode noRemovido;
        if (noAtual.getRight()!=null){
            noAtual.setRight(buscaRemove(noAtual.getRight(), noChave));
            if (flagRemove){
                noAtual = balanceamentoDireito(noAtual);
            }
        }
        else{
            noChave.setData(noAtual.getData());
            noRemovido = noAtual;
            noAtual = noAtual.getLeft();
            if (noAtual != null){
                noAtual.setParent(noRemovido.getParent());
            }
            flagRemove = true;
            noRemovido = null;
        }
        return (noAtual);
        
    }

}
