class Wentylator {
    public int moc;

    public Wentylator(int moc)
    {
        this.moc = moc;
    }

    public void wlacz()
    {
        System.out.println("Wentylator wlaczony z moca " + moc + "%");
    }

    public void wylacz()
    {
        System.out.println("Wentylator wylaczony");
    }
}