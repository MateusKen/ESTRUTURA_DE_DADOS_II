class Main {
  public static void main(String[] args) {
    Pessoa pessoa1 = new Pessoa("Joao", "rua A", "1234");
    Fornecedor pessoa2 = new Fornecedor("Roberto", "rua B", "2468", 8, 3);
    Empregado pessoa3 = new Empregado("Jose", "rua C", "1357", 1, 1000, (float) 0.3);
    Administrador pessoa4 = new Administrador("Pedro", "rua D", "4321", 2, (float) 1000, (float) 0.3, (float) 100);
    Operario pessoa5 = new Operario("Ramirez", "rua E", "8765", 3, (float) 1000, (float) 0.3, 100, (float) 0.2);
    Vendedor pessoa6 = new Vendedor("Tomaz", "rua F", "0987", 4, (float) 1000, (float) 0.3, 100, (float) 0.3);
    System.out.print(pessoa1.toString());
    System.out.print("\n");
    System.out.print(pessoa2.toString());
    System.out.print("\n");
    System.out.print("O saldo de "+pessoa2.getNome()+" atual é " +pessoa2.obterSaldo());
    System.out.print(pessoa3.toString());
    System.out.print("\n");
    System.out.print("O salário de "+pessoa3.getNome()+" é de "+pessoa3.calcularSalario());
    System.out.print("\n");
    System.out.print(pessoa4.toString());
    System.out.print("\n");
    System.out.print("O salário de "+pessoa4.getNome()+" é de "+pessoa4.calcularSalario());
    System.out.print("\n");
    System.out.print(pessoa5.toString());
    System.out.print("\n");
    System.out.print("O salário de "+pessoa5.getNome()+ " é de "+pessoa5.calcularSalario());
    System.out.print("\n");
    System.out.print(pessoa6.toString());
    System.out.print("\n");
    System.out.print("O salário de "+pessoa6.getNome()+" é de "+pessoa6.calcularSalario());
    
  }
}
