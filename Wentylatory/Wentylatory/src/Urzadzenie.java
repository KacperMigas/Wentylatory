class Urzadzenie {
    public Czujnik czujnikZew;
    public Czujnik czujnikUrz;
    public Wentylator wentylator;
    public Urzadzenie(int temperaturaZew, int temperaturaUrz) {
        this.czujnikZew = new Czujnik(temperaturaZew);
        this.czujnikUrz = new Czujnik(temperaturaUrz);
        wlaczUrzadzenie();}
    public void wlaczUrzadzenie() {
        if (czujnikUrz.zmierzTemperature() >= 50) {
            wentylator = new Wentylator(50);
            wentylator.wlacz();}}
    public void symulujPrace(int czas) {
        for (int i = 0; i < czas; i++) {
            czujnikZew.zmierzTemperature();
            czujnikUrz.zmierzTemperature();
            czujnikZew.temperatura += 5;
            czujnikUrz.temperatura += wentylator != null ? wentylator.moc / 2 : 0;
            if(czujnikUrz.temperatura <= 75 && czujnikUrz.temperatura > 50) {
                System.out.println("Wentylatory pracuja z pelna moca.");}
            if (czujnikUrz.temperatura <= 100 && czujnikUrz.temperatura >75) {
                System.out.println("Wentylatory pracuja z pelna moca.");}
            if (czujnikUrz.temperatura > 100) {
                System.out.println("Ostrzeżenie: wysoka temperatura!");}
            if (czujnikUrz.temperatura >= 130) {
                wentylator.wylacz();
                System.out.println("Urzadzenie wylaczone. Wentylatory pracuja z pelna moca.");
                while (czujnikUrz.temperatura > 55) {
                    czujnikUrz.temperatura -= 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                wlaczUrzadzenie();
            }
            if (czujnikUrz.temperatura < 0) {
                System.out.println("Za niska temperatura urzadzenia grozi awaria - system zostal wylaczony");
                break;
            }
            if (wentylator != null) {
                czujnikUrz.temperatura -= 1;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Symulacja zakonczona");
    }
}
