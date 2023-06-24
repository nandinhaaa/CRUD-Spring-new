package br.edu.ifsuldeminas.mach.webii.crudmanager.controller;
public class ProjetoNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjetoNotFoundException() {
        super();
    }

    public ProjetoNotFoundException(String message) {
        super(message);
    }

    public ProjetoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
