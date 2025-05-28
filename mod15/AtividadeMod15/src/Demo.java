public class Demo {
    public static void main (String[] args ){
        Custumer cliente = new Custumer("A", false);
        Factory factory = getFactory(cliente);
        factory.create(cliente.getGradeRequest());
    }


    public static Factory getFactory(Custumer cliente){
        if(cliente.hasCompanyContract()){
            return new ContratosFactory();
        }else {
            return new SemContratoFactory();
        }
    }
}
