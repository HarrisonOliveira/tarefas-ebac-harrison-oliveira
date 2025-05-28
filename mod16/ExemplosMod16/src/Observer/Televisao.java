package Observer;

public class Televisao implements Observer{
    @Override
    public void update(Subject subject) {
        if (subject instanceof Jornalist){
            Jornalist jornalist = (Jornalist) subject;
            System.out.println("Notificando Mensagem pala Televisao" + jornalist.toString());
        }
    }
}
