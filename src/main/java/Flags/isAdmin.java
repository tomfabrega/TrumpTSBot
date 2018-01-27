package Flags;

import Bot.Donaldtrump;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

public class isAdmin implements Flags {
    public String getFlagName() {
        return "isAdmin";
    }

    public int getFlagFortschritt() {
        return 0;
    }

    public void setFlagFortschritt(int num) {

    }

    public void execute(Donaldtrump dt, ClientInfo c, int i) {

    }
}
