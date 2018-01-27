package BotCommands;

import Bot.Donaldtrump;
import Flags.isAdmin;
import RegisteredUsers.User;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ClientInfo;

import java.util.List;

public class RegisterAsAdminCommand implements BotCommands {
    public String getCommand() {
        return "!register";
    }

    public Boolean getIsAdminCommand() {
        return false;
    }

    public void execute(Donaldtrump dt, User u, List<String> args, TextMessageEvent textMessageEvent, ClientInfo invokerClient) {
        if (args.get(0).equals("nurderhsv")){
            dt.SetUserFlag(u, new isAdmin());
            int clientId = dt.getApi().getClientByUId(u.getUniqueIdentifier()).getId();
            dt.getApi().sendPrivateMessage(clientId, "Sie sind nun Admin!");

        }
    }
}
