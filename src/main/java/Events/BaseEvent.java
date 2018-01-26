package Events;

import Bot.Donaldtrump;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public interface BaseEvent {

    String eventName = null;
    Integer eventFortschritt = null;

    public String getEventName();

    public Integer getEventFortschritt();
    public void setEventFortschritt();

    public void executeEvent(Donaldtrump dt, ClientInfo u);

}
