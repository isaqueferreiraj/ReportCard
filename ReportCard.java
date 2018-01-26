import java.util.Arrays;

public class ReportCard {
	
	private String nomeAluno;
	private String serie;
	private char turma;
	private String ensino;
	private String[] materias;
	/**
	 * As notas s�o armazenadas numa matriz onde o n�mero de colunas � fixo em 4, pois corresponde ao n�mero de unidades
	 *  que uma materia tem e o n�mero de linhas ir� variar de acordo com o n�mero de mat�rias, pois cada linha corresponde
	 *   as notas de uma mat�ria.
	 */
	private double[][] notas; 
	private double[] media;
	
	
	/**
	 * 
	 * @param nomeAluno nome do aluno
	 * @param serie serie que o aluno est� cursando
	 * @param turma identifica��o da turma("A", "B", "C" etc)
	 * @param ensino o tipo de ensino (Fundamenta I, Fundamental II ou M�dio)
	 * @param nMaterias o n�mero de materias que o aluno est� cursando
	 */
	public ReportCard(String nomeAluno, String serie, char turma, String ensino, int nMaterias){
		this.nomeAluno = nomeAluno;
		this.serie = serie;
		this.turma = turma;
		this.ensino = ensino;
		this.materias = new String[nMaterias];
		this.notas = new double[nMaterias][4];
		this.media = new double[nMaterias];
	}

	/**
	 * Retorna o nome do aluno
	 * @return
	 */
	public String getNomeAluno() {
		return nomeAluno;
	}

	/**
	 * Insere o nome do aluno
	 * @param nomeAluno
	 */
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	/**
	 * Retorna a serie o aluno
	 * @return
	 */
	public String getSerie() {
		return serie;
	}

	
	/**
	 * Insere a serie do aluno
	 * @param serie
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}

	/**
	 * Retorna a identifica��o da turma
	 * @return
	 */
	public char getTurma() {
		return turma;
	}
	
	/**
	 * Insere a identifca��o da turma
	 * @param turma
	 */
	public void setTurma(char turma) {
		this.turma = turma;
	}

	/**
	 * Retorna o tipo de ensino do aluno
	 * @return
	 */
	public String getEnsino() {
		return ensino;
	}
	
	/**
	 * Insere o tipo de ensino do aluno
	 * @param ensino
	 */

	public void setEnsino(String ensino) {
		this.ensino = ensino;
	}

	/**
	 * Retorna a mat�ria do �ndice passado como par�metro
	 * @param n
	 * @return
	 */
	public String getMateria(int n) {
		return materias[n];
	}

	/**
	 * Insere uma mat�ria na posi��o passada como par�metro
	 * @param materia
	 * @param n
	 */
	public void setMateria(String materia, int n) {
		this.materias[n] = materia;
	}
	
	/**
	 * Retorna a nota da unidade e mat�ria passadas como par�metro
	 * @param materia
	 * @param unidade
	 * @return
	 */
	public double getNota(String materia, int unidade) {
		
		return notas[procurarMateria(materia)][unidade];
	}

	/**
	 * Insere a nota na unidade da mat�ria, ambas sendo passadas como par�metro
	 * @param materia
	 * @param nota
	 * @param unidade
	 */
	public void setNota(String materia, double nota, int unidade) {
		this.notas[procurarMateria(materia)][unidade] = nota;
	}

	/**
	 * 
	 * @param materia
	 * @return a m�dia da mat�ria passa como par�metro
	 */
	public double getMedia(String materia) {
		gerarMedia(materia);
		return media[procurarMateria(materia)];
	}

	/**
	 * 
	 * @param materia
	 * @return a m�dia da mat�ria recebida como par�metro
	 */
	public void gerarMedia(String materia) {
		double totalNotas = 0;
		
		for(int i = 0; i < 4; i++)
			totalNotas += notas[procurarMateria(materia)][i];
		
		this.media[procurarMateria(materia)] = (totalNotas/4); 
	}
	
	/**
	 * 
	 * @param materia
	 * @return o indice da materia recebida como par�metro
	 */
	private int procurarMateria(String materia){
		int indice = 0;
		
		for(int i = 0; i < this.materias.length; i++){
			if(this.materias[i].equals(materia)){
				indice = i;
				i = this.materias.length;
			}
		}
		
		return indice;
	}

	@Override
	public String toString() {
		StringBuffer string = new StringBuffer("BoletimEscolar\n");
		
		string.append("Nome do aluno: ");
		string.append(this.nomeAluno);
		string.append("\nS�rie: ");
		string.append(this.serie);
		string.append("\nTurma: ");
		string.append(this.turma);
		string.append("\nEnsino: ");
		string.append(this.ensino);
		string.append("\nMat�ria | 1� Unid | 2� Unid | 3� Unid | 4� Unid | M�dia");
		
		for(int i = 0; i < materias.length; i++){
			string.append("\n");
			string.append(materias[i]);
			
			for(int j = 0; j < 4; j++){
				string.append(" | ");
				string.append(notas[procurarMateria(materias[i])][j]);
			}
			
			string.append(" | ");
			string.append(media[i]);
		}
		
		return string.toString();
	}	
}
