package Flags;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class isMexican implements Flags{
    String flagName = "isMexican";
    int flagFortschritt = 0;

    public void execute(Donaldtrump dt, ClientInfo c, int i) {
        int channelIdUSA = dt.getApi().getChannelByNameExact("USA", true).getId();
        int channelIdMexico = dt.getApi().getChannelByNameExact("Mexico", true).getId();
        int BehoerdeId = dt.getApi().getChannelByNameExact("Einwanderungsbehörde", true).getId();
        if (i == flagFortschritt || (i-1)==flagFortschritt) {
            switch (i) {
                case 0:
                    dt.getApi().sendPrivateMessage(c.getId(), "Du bist ein Tacofresser. Der 45. Präsident der USA hat entschieden, dass du nicht auf direktem Weg einreisen darfst. Für die Einreise benötigtst du Passierschein A38. Bitte wende dich an die zuständige Behörde.");
                    dt.getApi().moveClient(c.getId(), channelIdMexico);
                    break;


                case 1:
                    dt.getApi().sendPrivateMessage(c.getId(), "Der Antrag auf Einreise wird geprüft. Bitte kurz warten!");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){e.printStackTrace();}
                    if (c.getChannelId() == BehoerdeId) {
                        dt.getApi().sendPrivateMessage(c.getId(), "Dem Antrag auf Einreise wurde stattgegeben!");
                        User u = dt.getRegisteredUser(c);
                        dt.removeFlag("isMexican", u);
                    }

                    // Dokument abholen
            }
        }
    }







    public String getFlagName() {
        return flagName;
    }

    public int getFlagFortschritt() {
        return 0;
    }

    public void setFlagFortschritt() {

    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }


}
