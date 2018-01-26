package Flags;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class isMexican implements Flags{
    private String flagName = "isMexican";
    private Integer flagFortschritt = 0;

    public void execute(Donaldtrump dt, ClientInfo c, int i) {
        int channelIdUSA = dt.getApi().getChannelByNameExact("USA", true).getId();
        int channelIdMexico = dt.getApi().getChannelByNameExact("Mexico", true).getId();
        int BehoerdeId = dt.getApi().getChannelByNameExact("Einwanderungsbehörde", true).getId();
        if (i == flagFortschritt || (i - 1) == flagFortschritt) {
            switch (i) {
                case 0:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Du bist ein Tacofresser. Der 45. Präsident der USA hat entschieden, dass du nicht auf direktem Weg einreisen darfst. Für die Einreise benötigtst du Passierschein A38. Bitte wende dich an die zuständige Behörde.");
                    dt.getApi().moveClient(c.getId(), channelIdMexico);
                    flagFortschritt = 0;
                    break;
                case 1:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Sie benötigen das blaue Formular aus dem Channel Hänchen");
                    flagFortschritt = 1;
                    break;
                case 2:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Nein, nein! Das HELLBLAUE Formular. Nicht das Mitternachtsblaue. Leider hat Hänchen mittlerweile geschlossen. Bitte fragen Sie bei den Raper of Hoes nach dem korrekten Formular.");
                    flagFortschritt = 2;
                    break;
                case 3:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Bitte schön, Ihr Formular! Bitte IDLEN Sie einen Augenblick. Es wird sich zeitnah jemand um Sie kümmern.");
                    flagFortschritt = 3;
                    break;
                case 4:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Danke für Ihre Geduld. Passierschein F26 liegt jetzt für Sie bereit. Bei Rückfragen, wenden Sie sich bitte an das Service Personal in der Lobby. Vielen Dank!");
                    flagFortschritt = 4;
                    break;
                case 5:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Passierschein A 38... wo ist er denn.....ah ja. Da haben wir ihn ja. Bitte schön.");
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Dem Antrag auf Einreise wurde stattgegeben!");
                    User u = dt.getRegisteredUser(c);
                    dt.removeFlag("isMexican", u);
                    break;

            }
        }

    }







    public String getFlagName() {
        return flagName;
    }

    public int getFlagFortschritt() {
        return 0;
    }

    public void setFlagFortschritt(int num) {

    }


    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }


}
