package Flags;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class isMexican implements Flags{
    private String flagName = "isMexican";
    private Integer flagFortschritt = 0;

    public void execute(Donaldtrump dt, ClientInfo c, int i) {
        int channelIdUSA = dt.getApi().getChannelByNameExact("Phillips West Side Ghetto Keller", true).getId();
        int channelIdMexico = dt.getApi().getChannelByNameExact("Mexico", true).getId();
        int BehoerdeId = dt.getApi().getChannelByNameExact("Einwanderungsbehörde", true).getId();
        if (i == flagFortschritt || (i - 1) == flagFortschritt || i == 0 ){
            switch (i) {
                case 0:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Du bist ein Tacofresser. Der 45. Präsident der USA hat entschieden, dass du nicht auf direktem Weg einreisen darfst. Für die Einreise benötigtst Einreisepapiere. Bitte wende dich an die zuständige Behörde.");
                    dt.getApi().moveClient(c.getId(), channelIdMexico);
                    flagFortschritt = 0;
                    break;

                case 1:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Dem Antrag auf Einreise wurde stattgegeben! Viel Spaß in meinem Land du Alien");
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
