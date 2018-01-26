package Flags;

import Bot.Donaldtrump;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public interface Flags {
    String flagName = null;
    Integer flagFortschritt = 0;

    public String getFlagName();
    public int getFlagFortschritt();
    public void setFlagFortschritt(int num);

    public void execute(Donaldtrump dt, ClientInfo c, int i);


}
