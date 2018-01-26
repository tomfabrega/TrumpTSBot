package Flags;

import Bot.Donaldtrump;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public interface Flags {
    String flagName = null;
    int flagFortschritt = 0;

    public String getFlagName();
    public int getFlagFortschritt();
    public void setFlagFortschritt();

    public void execute(Donaldtrump dt, ClientInfo c, int i);


}
