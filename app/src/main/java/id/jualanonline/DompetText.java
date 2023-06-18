package id.jualanonline;

public class DompetText {
    String actionText;
    int Images;
    public DompetText(String actionText, int Images){
        this.actionText = actionText;
        this.Images = Images;
    }

    public int getImages() {
        return Images;
    }

    public String getActionText() {
        return actionText;
    }
}
