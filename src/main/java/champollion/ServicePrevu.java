package champollion;

public class ServicePrevu {

    private int volumeCM;
    private int volumeTD;
    private int volumeTP;
    private Enseignant e;
    private UE ue;

    public ServicePrevu(int volumeCM, int volumeTd, int volumeTP, Enseignant e, UE ue) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.e = e;
        this.ue = ue;
    }

    public int getVolumeCM(){
        return volumeCM;
    }

    public int getVolumeTD(){
        return volumeTD;
    }

    public int getVolumeTP(){
        return volumeTP;
    }

    public Enseignant getE(){
        return e;
    }

    public UE getUe(){
        return ue;
    }

    public void setVolumeCM(int volumeCM){
        this.volumeCM = volumeCM;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    public void setE(Enseignant e) {
        this.e = e;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }
}
