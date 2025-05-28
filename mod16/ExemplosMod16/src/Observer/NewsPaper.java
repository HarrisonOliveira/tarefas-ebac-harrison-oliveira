package Observer;

public class NewsPaper implements Observer {
    @Override
    public void update(Subject subject) {
      if (subject instanceof Jornalist){
          Jornalist jornalist = (Jornalist) subject;
          System.out.println("Notificando Mensagem pelo Newspaper" + jornalist.toString());
      }
    }
}
