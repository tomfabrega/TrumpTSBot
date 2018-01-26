package Events;

import Bot.Donaldtrump;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class MexicoEvent implements BaseEvent {
    public String getEventName() {
        return "MexicoEvent";
    }

    public Integer getEventFortschritt() {
        return 0;
    }

    public void setEventFortschritt() {

    }

    public void executeEvent(Donaldtrump dt, ClientInfo c) {
        int channelIdUSA = dt.getApi().getChannelByNameExact("USA", true).getId();
        int channelIdMexico = dt.getApi().getChannelByNameExact("Mexico", true).getId();

        switch (getEventFortschritt()) {
            case 0: dt.getApi().sendPrivateMessage(c.getId(), "Du bist ein Tacofresser. Der 45. Präsident der USA hat entschieden, dass du nicht auf direktem Weg einreisen darfst. Für die Einreise benötigtst du Passierschein A38. Bitte wende dich an die zuständige Behörde.");
                    dt.getApi().moveClient(c.getId(), channelIdMexico);
            case 1: // Dokument abholen
        }
    }
}
