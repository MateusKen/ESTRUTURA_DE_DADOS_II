public class Concurso {
    private String nomeConcurso;
    private Candidato[] candidatos;
    private Juri[] membrosJuri;

    public String getNomeConcurso() {
        return nomeConcurso;
    }

    public void setNomeConcurso(String nomeConcurso) {
        this.nomeConcurso = nomeConcurso;
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Candidato[] candidatos) {
        this.candidatos = candidatos;
    }

    public Juri[] getMembrosJuri() {
        return membrosJuri;
    }

    public void setMembrosJuri(Juri[] membrosJuri) {
        this.membrosJuri = membrosJuri;
    }
}
