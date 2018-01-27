package Flags;

import Bot.Donaldtrump;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class a38 implements Flags {
    private String flagName = "a38";
    private Integer flagFortschritt = 0;

    public void execute(Donaldtrump dt, ClientInfo c, int i) {
        int channelIdGhetto = dt.getApi().getChannelByNameExact("Phillips West Side Ghetto Keller", true).getId();
        if (i == flagFortschritt || (i - 1) == flagFortschritt || i == 0) {
            switch (i) {
                case 0:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Nein, nein nein. So einfach kommst du hier nicht wieder rein. Ab in den GHETTO KELLER mit dir... Passierschein A28 brauchst du. Schau mal in der Champions League nach!");
                    dt.getApi().moveClient(c.getId(), channelIdGhetto);
                    flagFortschritt = 0;
                    break;
                case 1:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Blaues Formular...ausfüllen...Hänchen...und jetzt zieh Leine...");
                    flagFortschritt = 1;
                    break;
                case 2:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Nein, nein! Das HELLBLAUE Formular. Nicht das Mitternachtsblaue. Farbenblind? Hänchen ist jetzt geschlossen. Geh am besten die Typen aus Raper of Hoes nerven.....");
                    flagFortschritt = 2;
                    break;
                case 3:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Bitte schön, Ihr Formular! Bitte IDLEN Sie einen Augenblick. Es wird sich zeitnah jemand um Sie kümmern. Vielen dank für Ihren Besuch!");
                    flagFortschritt = 3;
                    break;
                case 4:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Danke für Ihre Geduld. Passierschein F26 liegt jetzt für Sie bereit. Bei Rückfragen, stehe selbstverständlich NICHT ICH!!! zur Verfügung. Frag den Azubi in der Lobby!");
                    flagFortschritt = 4;
                    break;
                case 5:
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Passierschein A 38... wo ist er denn.....ah ja. Da haben wir ihn ja. Da haste... Ich hoffe du lernst draus...");
                    dt.getApi().sendPrivateMessage(c.getId(),
                            "Dem Antrag auf Einreise wurde stattgegeben! Viel Spaß in meinem Land du Alien");
                    User u = dt.getRegisteredUser(c);
                    dt.removeFlag("a38", u);
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
}
