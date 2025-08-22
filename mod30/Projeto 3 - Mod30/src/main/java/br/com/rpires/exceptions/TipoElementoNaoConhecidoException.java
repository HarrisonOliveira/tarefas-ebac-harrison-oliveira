/**
 * 
 */
package br.com.rpires.exceptions;

import java.io.Serial;

/**
 * @author rodrigo.pires
 *
 */
public class TipoElementoNaoConhecidoException extends Exception {
	

	@Serial
    private static final long serialVersionUID = -2268140970978666251L;

	public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }

}
