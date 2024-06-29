package mgs;

public class FuncionarioSaudavel extends Funcionario{
		private static final long serialVersionUID = 1L;
	    private String alergias;
	    private String problemasMedicos;
	    private String telefoneContato;
	    private String emailContato;

	    public FuncionarioSaudavel(int id, String nome, String alergias, String problemasMedicos, String telefoneContato, String emailContato) {
	    	super(id, nome);
	        this.alergias = alergias;
	        this.problemasMedicos = problemasMedicos;
	        this.telefoneContato = telefoneContato;
	        this.emailContato = emailContato;
	    }

	    public String getAlergias() {
	        return alergias;
	    }

	    public String getProblemasMedicos() {
	        return problemasMedicos;
	    }

	    public String getTelefoneContato() {
	        return telefoneContato;
	    }

	    public String getEmailContato() {
	        return emailContato;
	    }

	    @Override
	    public String toString() {
	    	String retornoAncestral = super.toString();
	        return retornoAncestral +
	                "Alergias = " 			+ alergias 			+ '\n' +
	                "Problemas Médicos = " 	+ problemasMedicos 	+ '\n' +
	                "Telefone Contato = " 	+ telefoneContato 	+ '\n' +
	                "Email Contato = " 		+ emailContato;
	    }
	}

