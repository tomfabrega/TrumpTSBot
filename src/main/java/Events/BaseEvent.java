package Events;

import Bot.Donaldtrump;
import RegisteredUsers.User;

public interface BaseEvent {

    String eventName = null;
    Integer eventFortschritt = null;

    public String getEventName();

    public Integer getEventFortschritt();
    public void setEventFortschritt();

    public void executeEvent(Donaldtrump c, User u);

}
