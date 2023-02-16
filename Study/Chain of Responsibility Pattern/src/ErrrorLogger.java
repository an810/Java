public class ErrrorLogger extends AbstractLogger{

    public ErrrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message){
        System.out.println("Error Console::Logger: " + message);
    }
}
