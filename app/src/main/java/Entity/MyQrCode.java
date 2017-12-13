package Entity;


public class MyQrCode
{
    private LazyImmutableInt id;
    private int x;
    private int y;
    private String message;
    private int password;
    private boolean isOpen;

    public MyQrCode(int id,int x, int y, String message, int password, boolean isOpen)
    {
        this.id = new LazyImmutableInt();
        this.id.setValue(id);
        this.x = x;
        this.y = y;
        this.message = message;
        this.password = password;
        this.isOpen = isOpen;
    }

    public MyQrCode()
    {
        x=0;
        y=0;
        message = new String();
        password=0;
        isOpen=false;
    }

    public int getId()
    {
        return id.getValue();
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public int getPassword()
    {
        return password;
    }

    public void setPassword(int password)
    {
        this.password = password;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean open)
    {
        isOpen = open;
    }
}
