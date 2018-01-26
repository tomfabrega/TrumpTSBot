package Events;

import Bot.Donaldtrump;
import RegisteredUsers.User;

public class MexicoEvent implements BaseEvent {
    public String getEventName() {
        return "MexicoEvent";
    }

    public Integer getEventFortschritt() {
        return 0;
    }

    public void setEventFortschritt() {

    }

    public void executeEvent(Donaldtrump dt, User u) {
        switch (getEventFortschritt()) {
            case 0:
            case 1: // Dokument abholen
        }
    }
}
