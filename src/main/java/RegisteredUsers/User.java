package RegisteredUsers;

import Events.BaseEvent;
import Flags.Flags;

import java.util.ArrayList;

public class User {

    String LastKnownName;
    String UniqueIdentifier;
    ArrayList<Flags> flags = new ArrayList<Flags>();
    ArrayList<BaseEvent> events = new ArrayList<BaseEvent>();

    public String getLastKnownName() {
        return LastKnownName;
    }

    public void setLastKnownName(String lastKnownName) {
        LastKnownName = lastKnownName;
    }

    public String getUniqueIdentifier() {
        return UniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        UniqueIdentifier = uniqueIdentifier;
    }

    public ArrayList<Flags> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<Flags> flags) {
        this.flags = flags;
    }

    public ArrayList<BaseEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<BaseEvent> events) {
        this.events = events;
    }


}
