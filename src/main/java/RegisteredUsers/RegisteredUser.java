package RegisteredUsers;

import Events.BaseEvent;
import Flags.Flags;

import java.util.ArrayList;

public interface RegisteredUser {
    ArrayList<Flags> flags = null;
    ArrayList<BaseEvent> events = null;
    String Username = null;
    String UniqueId = null;



}
