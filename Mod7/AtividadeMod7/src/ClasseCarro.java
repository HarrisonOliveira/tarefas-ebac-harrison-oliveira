/**
 * @author Harrison
 *
 * @version 1.0
 */

public class ClasseCarro {
    private String marca;
    private int velocidadeMaxima;

    /**
     * Este método retorna a marca do carro
     * @return
     *
     */
    public String getMarca(){
        return marca;
    }

    /**
     * Este método define a marca do carro
     * @param marca recebe a marca do carro
     */
    public void setMarca( String marca){
        this.marca = marca;
    }

    /**
     * Este metodo retorna a velocidade maxima do carro
     * @return
     */
    public int getVelocidadeMaxima(){
        return velocidadeMaxima;
    }

    /**
     * Este método define a velocidade maxima do carro.
     *
     * @param velocidadeMaxima recebe a velocidade maxima do carro.
     */
    public void setVelocidadeMaxima (int velocidadeMaxima){
        this.velocidadeMaxima = velocidadeMaxima;
    }

}
